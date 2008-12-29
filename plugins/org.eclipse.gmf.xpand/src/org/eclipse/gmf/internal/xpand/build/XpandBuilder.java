/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.build;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.RootManager;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.util.ContextFactory;
import org.eclipse.gmf.internal.xpand.util.XpandMarkerManager;
import org.eclipse.gmf.internal.xpand.util.ParserException;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;

public class XpandBuilder extends IncrementalProjectBuilder implements RootManager.IRootChangeListener {
	private RootManager myRootManager;

	private WorkspaceModelRegistry modelRegistry;

	private boolean myRootsChanged = true;

	// XXX again, using map as mere pairs
	private final Map<XpandResource, IFile> xpandResourcesToAnalyze = new HashMap<XpandResource, IFile>();

	public static final String getBUILDER_ID() {
		return Activator.getId() + ".xpandBuilder";
	}

	@Override
	protected void startupOnInitialize() {
		super.startupOnInitialize();
		myRootManager = Activator.getRootManager(getProject());
		myRootManager.addRootChangeListener(this);
		modelRegistry = new WorkspaceModelRegistry();
		Activator.registerModelSource(modelRegistry);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(final int kind, final Map args, final IProgressMonitor monitor) throws CoreException {
		try {
			doBuild(kind, args, monitor);
		} catch (final Throwable e) {
			e.printStackTrace();
		}
		// TODO to separate thread
		for (XpandResource r : xpandResourcesToAnalyze.keySet()) {
	        final ExecutionContext ctx = ContextFactory.createXpandContext(getResourceManager(xpandResourcesToAnalyze.get(r)));
	        final Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
	        try {
	        	r.analyze(ctx, issues);
	        	updateMarkers(xpandResourcesToAnalyze.get(r), issues);
	        } catch (RuntimeException ex) {
	        	Activator.logError(ex);
	        	XpandMarkerManager.addMarkers(xpandResourcesToAnalyze.get(r), new ParserException.ErrorLocationInfo(ex.toString()));
	        }
		}
		xpandResourcesToAnalyze.clear();

		myRootsChanged = false;
		Set<IProject> referencedProjects = myRootManager.getReferencedProjects();
		referencedProjects.remove(getProject());
		return referencedProjects.toArray(new IProject[referencedProjects.size()]);
	}

	private void doBuild(int kind, Map<?, ?> args, IProgressMonitor monitor) throws CoreException {
		if ((kind == FULL_BUILD) || haveRootsChangedSinceLastBuild()) {
			fullBuild(monitor);
		} else {
			Set<IProject> referencedProjects = myRootManager.getReferencedProjects();
			referencedProjects.remove(getProject());
			Collection<IResourceDelta> deltas = new ArrayList<IResourceDelta>(referencedProjects.size());
			IResourceDelta projectDelta = getDelta(getProject());
			if (projectDelta == null) {
				fullBuild(monitor);
				return;
			}
			for (IProject next : referencedProjects) {
				final IResourceDelta delta = getDelta(next);
				if (delta == null) {
					fullBuild(monitor);
					return;
				}
				deltas.add(delta);
			}
			incrementalBuild(projectDelta, deltas, monitor);
		}
	}

	public void rootsChanged(RootManager rootManager) {
		myRootsChanged = true;
	}

	private boolean haveRootsChangedSinceLastBuild() {
		return myRootsChanged;
	}

	void reloadResource(final IFile resource) {
		getResourceManager(resource).forget(resource);
		if (!resource.exists()) {
			return;
		}
		try {
			if (isXpand(resource)) {
				XpandResource r = getResourceManager(resource).loadXpandResource(resource);
				if (r != null) {
					xpandResourcesToAnalyze.put(r, resource);
				}
			}
		} catch (ParserException ex) {
			updateMarkers(resource, ex.getParsingErrors());
		} catch (Exception ex) {
			Activator.logError(ex);
			// perhaps, depending on exception type (Core|IO) we can decide to keep old markers? 
			XpandMarkerManager.deleteMarkers(resource);
			XpandMarkerManager.addErrorMarker(resource, ex.getMessage(), -1, -1);
		}
	}

	public void handleRemovement(final IFile resource) {
		XpandMarkerManager.deleteMarkers(resource);
		getResourceManager(resource).forget(resource);
	}

	private WorkspaceResourceManager getResourceManager(IFile file) {
		WorkspaceResourceManager result = myRootManager.getResourceManager(file);
//		assert result != null;
		return result;
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		Set<IProject> referencedProjects = myRootManager.getReferencedProjects();
		referencedProjects.add(getProject());
		XpandMarkerManager.deleteMarkers(getProject());	//to delete markers from obsolete roots.
		monitor.beginTask(null, 1 + referencedProjects.size());
		try {
			for (IProject next : referencedProjects) {
				checkCanceled(monitor);
				next.accept(new XpandResourceVisitor(new SubProgressMonitor(monitor, 1)));
			}
			checkCanceled(monitor);
			modelRegistry.build(getProject(), new SubProgressMonitor(monitor, 1));
		} finally {
			monitor.done();
		}
	}

	protected void incrementalBuild(final IResourceDelta projectDelta, final Collection<IResourceDelta> referencedProjectDeltas, final IProgressMonitor monitor) throws CoreException {
		monitor.beginTask(null, 2 + referencedProjectDeltas.size());
		try {
			for (IResourceDelta delta : referencedProjectDeltas) {
				checkCanceled(monitor);
				delta.accept(new XpandResourceVisitor(new SubProgressMonitor(monitor, 1)));
			}
			checkCanceled(monitor);
			projectDelta.accept(new XpandResourceVisitor(new SubProgressMonitor(monitor, 1)));
			checkCanceled(monitor);
			modelRegistry.build(getProject(), projectDelta, new SubProgressMonitor(monitor, 1));
		} finally {
			monitor.done();
		}
	}

	private void checkCanceled(final IProgressMonitor monitor) {
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	private static void updateMarkers(IFile resource, Set<AnalysationIssue> issues) {
        XpandMarkerManager.deleteMarkers(resource);
        XpandMarkerManager.addMarkers(resource, issues.toArray(new AnalysationIssue[issues.size()]));
	}

	private static void updateMarkers(IFile resource, ErrorLocationInfo[] parsingErrors) {
        XpandMarkerManager.deleteMarkers(resource);
        XpandMarkerManager.addMarkers(resource, parsingErrors);
	}

	private static boolean isXpand(final IFile resource) {
		return XpandResource.TEMPLATE_EXTENSION.equals(resource.getFileExtension());
	}

	private boolean isFileOfInterest(IFile file) {
		if (!isXpand(file)) {
			return false;
		}
		if (getResourceManager(file) == null) {
			return false;
		}
		return true;
	}

	private class XpandResourceVisitor implements IResourceVisitor, IResourceDeltaVisitor {
		private final IProgressMonitor monitor;

		public XpandResourceVisitor(final IProgressMonitor monitor) {
			this.monitor = monitor;
		}

		public boolean visit(final IResource resource) {
			if (!resource.isDerived() && (resource instanceof IFile) && isFileOfInterest((IFile) resource)) {
				reloadResource((IFile) resource);
			}
			monitor.worked(1);
			return true;
		}

		public boolean visit(final IResourceDelta delta) throws CoreException {
			final IResource resource = delta.getResource();
			if (resource.isDerived()) {
				return false;
			}
			if ((resource instanceof IFile)) {
				IFile file = (IFile) resource;
				if (!isFileOfInterest(file)) {
					return false;
				}
				switch (delta.getKind()) {
				case IResourceDelta.ADDED:
					reloadResource(file);
					break;
				case IResourceDelta.REMOVED:
					handleRemovement(file);
					break;
				case IResourceDelta.CHANGED:
					reloadResource(file);
					break;
				}
			} else if (resource instanceof IProject) {
				// forget about project in resource manager
				if (delta.getKind() == IResourceDelta.REMOVED) {
					System.err.println("Project removed:" + resource.getName());
				}
				if (delta.getKind() == IResourceDelta.OPEN) {
					System.err.println("Project open:" + ((IProject) resource).isOpen());
				}
			}
			monitor.worked(1);
			return true;
		}
	}

}
