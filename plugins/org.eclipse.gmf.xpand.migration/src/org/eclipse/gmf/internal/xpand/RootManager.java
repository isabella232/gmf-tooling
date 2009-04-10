/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.internal.xpand.build.WorkspaceResourceManager;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.migration.Activator;

/**
 * Tracks template roots for a given project.
 */
public class RootManager {
	public static final IPath PROJECT_RELATIVE_PATH_TO_CONFIG_FILE = new Path(".xpand-root");	//$NON-NLS-1$
	private final IFile myConfig;
	private List<RootDescription> myRoots;
	private List<IRootChangeListener> myListeners = new ArrayList<IRootChangeListener>(2);
	private RootDescription myFallbackRoot;
	private IProject myProject;

	public RootManager(IProject project) {
		myConfig = project.getFile(PROJECT_RELATIVE_PATH_TO_CONFIG_FILE);
		myProject = project;
	}

	public void addRootChangeListener(IRootChangeListener l) {
		if (l != null && !myListeners.contains(l)) {
			myListeners.add(l);
		}
	}

	public void removeRootChangeListener(IRootChangeListener l) {
		myListeners.remove(l);
	}

	public void rootsChanged() {
		myRoots = null;
		for (IRootChangeListener next : myListeners) {
			next.rootsChanged(this);
		}
	}

	protected IProject getProject() {
		return myConfig.getProject();
	}
	
	public boolean isTemplateRoot(IContainer container) {
		for (Iterator<RootDescription> it = getRoots().iterator(); it.hasNext();) {
			RootDescription nextDescription = it.next();
			if (nextDescription.contains(container) && nextDescription.getRelativePath(container).isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public List<IFolder> getXpandRootFolders() {
		List<IFolder> rootFolders = new ArrayList<IFolder>();
		for (RootDescription rootDescription : getRoots()) {
			IPath mainIPath = rootDescription.getMainIPath();
			if (mainIPath == null) {
				continue;
			}
			IFolder rootFolder = null;
			if (mainIPath.isAbsolute()) {
				assert mainIPath.segmentCount() > 1;
				//Try workspace-relative first.
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(mainIPath.segment(0));
				if (project.isAccessible() && project.equals(myProject)) {
					rootFolder = myProject.getFolder(mainIPath.removeFirstSegments(1));
				}
			} else {
				rootFolder = myProject.getFolder(mainIPath);
			}
			if (rootFolder != null && rootFolder.exists()) {
				rootFolders.add(rootFolder);
			}
		}
		return rootFolders;
	}
	
	public String getTemplateFullName(IFile file) {
		IPath relativePath = null;
		for (Iterator<RootDescription> it = getRoots().iterator(); it.hasNext() && relativePath == null;) {
			RootDescription nextDescription = it.next();
			if (nextDescription.contains(file)) {
				relativePath = nextDescription.getRelativePath(file);
			}
		}
		if (relativePath == null) {
			relativePath = getFallbackRoot().getRelativePath(file);
		}
		if (relativePath == null) {
			return null;
		}
		relativePath = relativePath.removeFileExtension();
		String templateFullName = relativePath.toString();
		if (templateFullName.startsWith("/")) {
			templateFullName = templateFullName.substring(1);
		}
		if (templateFullName.endsWith("/")) {
			templateFullName = templateFullName.substring(0, templateFullName.length() - 1);
		}
		return templateFullName.replace("/", SyntaxConstants.NS_DELIM);
	}

	public WorkspaceResourceManager getResourceManager(IFile file) {
		for (RootDescription nextDescription : getRoots()) {
			if (nextDescription.contains(file)) {
				return nextDescription.getManager();
			}
		}
		return getFallbackRoot().getManager();
	}

	private RootDescription getFallbackRoot() {
		if (myFallbackRoot == null) {
			myFallbackRoot = new RootDescription(Collections.<IPath>singletonList(new Path("")));
		}
		return myFallbackRoot;
	}

	private List<RootDescription> getRoots() {
		if (myRoots == null) {
			reloadRoots();
		}
		return myRoots;
	}

	private void reloadRoots() {
		if (!myConfig.exists()) {
			myRoots = Collections.singletonList(new RootDescription(DEFAULT_ROOTS));
			return;
		}
		final ArrayList<RootDescription> read = new ArrayList<RootDescription>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(myConfig.getContents(), myConfig.getCharset()));
			String line;
			while((line = in.readLine()) != null) {
				line = line.trim();
				if (line.length() > 0 && line.charAt(0) != '#') {
					String[] split = line.split(",");
					ArrayList<IPath> nextPaths = new ArrayList<IPath>(split.length);
					for (String nextPath : split) {
						nextPath = nextPath.trim();
						if (nextPath.length() > 0) {
							IPath toAdd = new Path(nextPath);
							//Absolute paths specify resources relative to workbench and/or 
							if (toAdd.isAbsolute() && toAdd.segmentCount() < 2) {
								continue;
							}
							nextPaths.add(toAdd);
						}
					}
					if (nextPaths.size() > 0) {
						read.add(new RootDescription(nextPaths));
					}
				}
			}
		} catch (CoreException ex) {
			// IGNORE
		} catch (IOException ex) {
			// IGNORE
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					/* IGNORE */
				}
			}
		}
		myRoots = read;
	}

	public Set<IProject> getReferencedProjects() {
		Set<IProject> result = new LinkedHashSet<IProject>();
		for (RootDescription nextDescription : getRoots()) {
			for (IPath next : nextDescription.getRoots()) {
				if (next.isAbsolute() && next.segmentCount() > 1) {
					IProject candidate = ResourcesPlugin.getWorkspace().getRoot().getProject(next.segment(0));
					if (candidate.isAccessible()) {
						result.add(candidate);
					}
				}
			}
		}
		return result;
	}

	public boolean containsProject(IPath projectPath) {
		if (myRoots == null) {
			return false;
		}
		for (RootDescription nextRoots : myRoots) {
			for (IPath next : nextRoots.getRoots()) {
				if (next.isAbsolute() && projectPath.isPrefixOf(next)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public List<IPath> getMigratedXpandRootEntry(IContainer rootFolder, IFolder templatesOutputFolder) {
		assert rootFolder instanceof IFolder || rootFolder instanceof IProject;
		if (rootFolder instanceof IFolder) {
			RootDescription rootDescription = getRootDescription((IFolder) rootFolder);
			assert rootDescription != null;
			List<IPath> newRoots = new ArrayList<IPath>(rootDescription.getOriginalRoots());
			for (int i = 0; i < newRoots.size(); i++) {
				if (i == 0) {
					newRoots.set(0, templatesOutputFolder.getProjectRelativePath());
				} else {
					newRoots.set(i, Activator.getDefault().getLegacyTemplateRootRegistry().getMigratedRoot(newRoots.get(i)));
				}
			}
			return newRoots;
		} else {
			return Collections.singletonList(templatesOutputFolder.getProjectRelativePath());
		}
	}
	
	private RootDescription getRootDescription(IFolder rootFolder) {
		for (RootDescription rootDescription : getRoots()) {
			IPath mainIPath = rootDescription.getMainIPath();
			if (mainIPath == null) {
				continue;
			}
			IFolder descriptionRootFolder = null;
			if (mainIPath.isAbsolute()) {
				assert mainIPath.segmentCount() > 1;
				// Try workspace-relative first.
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(mainIPath.segment(0));
				if (project.isAccessible() && project.equals(myProject)) {
					descriptionRootFolder = myProject.getFolder(mainIPath.removeFirstSegments(1));
				}
			} else {
				descriptionRootFolder = myProject.getFolder(mainIPath);
			}
			if (descriptionRootFolder != null && descriptionRootFolder.exists() && descriptionRootFolder.equals(rootFolder)) {
				return rootDescription;
			}
		}
		return null;
	}

	private static final List<IPath> DEFAULT_ROOTS = Collections.<IPath>singletonList(new Path("templates"));	//$NON-NLS-1$

	public interface IRootChangeListener {
		public void rootsChanged(RootManager rootManager);
	}

	public class RootDescription {
		private final List<IPath> myOriginalRoots;
		private final List<IPath> myRoots;
		private WorkspaceResourceManager myManager;
		public RootDescription(List<IPath> roots) {
			assert roots.size() > 0;
			myOriginalRoots = roots;
			myRoots = new ArrayList<IPath>(roots.size());
			for (IPath iPath : roots) {
				myRoots.add(Activator.getDefault().getLegacyTemplateRootRegistry().getActualRoot(iPath));
			}
		}
		public List<IPath> getOriginalRoots() {
			return myOriginalRoots;
		}
		public List<IPath> getRoots() {
			return myRoots;
		}
		public WorkspaceResourceManager getManager() {
			if (myManager == null) {
				myManager = new WorkspaceResourceManager(getProject(), myRoots.toArray(new IPath[myRoots.size()]));
			}
			return myManager;
		}
		public boolean contains(IResource resource) {
			if (resource == null) {
				return false;
			}
			for (IPath nextRoot : myRoots) {
				if (nextRoot.isAbsolute()) {
					if (nextRoot.isPrefixOf(resource.getFullPath())) {
						return true;
					}
				} else {
					if (resource.getProject().equals(getProject()) && nextRoot.isPrefixOf(resource.getProjectRelativePath())) {
						return true;
					}
				}
			}
			return false;
		}
		public IPath getRelativePath(IResource resource) {
			for (IPath nextRoot : myRoots) {
				if (nextRoot.isAbsolute()) {
					IPath fullPath = resource.getFullPath();
					if (nextRoot.isPrefixOf(fullPath)) {
						return fullPath.removeFirstSegments(nextRoot.segmentCount());
					}
				} else {
					IPath projectRelativePath = resource.getProjectRelativePath();
					if (resource.getProject().equals(getProject()) && nextRoot.isPrefixOf(projectRelativePath)) {
						return projectRelativePath.removeFirstSegments(nextRoot.segmentCount());
					}
				}
			}
			return null;
		}
		public IPath getMainIPath() {
			return myRoots.get(0);
		}
	}

}
