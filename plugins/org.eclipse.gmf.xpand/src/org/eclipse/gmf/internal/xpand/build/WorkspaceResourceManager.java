/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Artem Tikhomirov (Borland)
 *     Boris Blajer (Borland) - support for composite resources
 */
package org.eclipse.gmf.internal.xpand.build;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.internal.xpand.inactive.StreamDecoder;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.util.ParserException;
import org.eclipse.gmf.internal.xpand.util.ResourceManagerImpl;
import org.eclipse.gmf.internal.xpand.util.StreamConverter;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.project.builder.WorkspaceUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.BundleUnitResolver;
import org.osgi.framework.Bundle;

// FIXME package-local?, refactor Activator.getResourceManager uses
public class WorkspaceResourceManager extends ResourceManagerImpl {
	
	private static final IPath[] EMPTY_PATH = new IPath[0];
	
	private final IProject contextProject;
	private final IPath[] myConfiguredRoots;

	/**
	 * Fall-back constructor can be used for stand alone XPand resources
	 */
	public WorkspaceResourceManager(IProject context) {
		this(context, EMPTY_PATH);
	}
	
	public WorkspaceResourceManager(IProject context, IPath[] configuredRoots) {
		this.contextProject = context;
		myConfiguredRoots = configuredRoots;
	}

	public XpandResource loadXpandResource(IFile file) throws CoreException, IOException, ParserException {
		String fullyQualifiedName;
		if (file == null || (fullyQualifiedName = toFullyQualifiedName(file)) == null) {
			return null;
		}
		// try file directly, to get IO/Parse exceptions, if any.
		Reader r = new StreamConverter().toContentsReader(file);
		XpandResource[] loadXpandResources = loadXpandResources(new Reader[] { r }, fullyQualifiedName);
		assert loadXpandResources.length == 1 && loadXpandResources[0] != null;
		return loadXpandResources[0];
	}

	@Override
	protected void handleParserException(ParserException ex) {
		// may get here only when some referenced template/xtend file is
		// broken. Since it's expected to get compiled anyway (either prior
		// to compilation of its use or afterwards), error messages should get
		// into problems view sooner or later.
	}

	@Override
	protected boolean shouldCache() {
		/*
		 * WorkspanceResourceManager was refactored to cache all resources.
		 * 
		 * From now this resource manager should be:
		 * 
		 * 1. created
		 * 
		 * 2. used during the session of compilation/code completion
		 * 
		 * 3. forgotten to free corresponding memory resources.
		 */
		return true;
	}

	public void forget(IFile resource) {
		// implement when caching
	}

	@Override
	protected Reader[] resolveMultiple(String fqn, String ext) throws IOException {
		IPath fp = new Path(fqn.replaceAll(TypeNameUtil.NS_DELIM, "/")).addFileExtension(ext);
		IPath[] resolutions = getResolutions(fp);
		ArrayList<Reader> result = new ArrayList<Reader>(resolutions.length);
		for (IPath p : getResolutions(fp)) {
			Reader nextReader = getReader(p);
			if (nextReader != null) {
				result.add(nextReader);
			}
		}
		if (result.isEmpty()) {
			throw new FileNotFoundException(fp.toString());
		}
		return result.toArray(new Reader[result.size()]);
	}

	private Reader getReader(IPath p) throws IOException {
		if (p.isAbsolute()) {
			assert p.segmentCount() > 1;
			//Try workspace-relative first.
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(p.segment(0));
			if (project.isAccessible()) {
				return getWorkspaceFileReader(project, p.removeFirstSegments(1));
			}
			//Fallback to platform location
			Bundle platformBundle = Platform.getBundle(p.segment(0));
			if (platformBundle != null) {
				URL url = platformBundle.getEntry(p.removeFirstSegments(1).toString());
				if (url != null) {
					InputStream is = url.openStream();
					// FIXME for now, go with legacy encoding as a default
					return new StreamDecoder(is, StreamDecoder.LEGACY_ENCODING).getReader();
				}
			}
		} else {
			return getWorkspaceFileReader(contextProject, p);
		}
		return null;
	}

	private Reader getWorkspaceFileReader(IProject project, IPath path) throws IOException {
		IResource r = project.findMember(path);
		if (r instanceof IFile) {
			try {
				return new StreamConverter().toContentsReader((IFile) r);
			} catch (CoreException ex) {
				IOException wrap = new IOException(ex.getStatus().getMessage());
				wrap.initCause(ex);
				throw wrap;
			}
		}
		return null;
	}

	private IPath[] getResolutions(IPath p) {
		IPath[] rv = new IPath[myConfiguredRoots.length];
		for (int i = 0; i < myConfiguredRoots.length; i++) {
			rv[i] = myConfiguredRoots[i].append(p);
		}
		return rv;
	}
	private String toFullyQualifiedName(IFile file) {
		for (IPath nextRoot : myConfiguredRoots) {
			if (!nextRoot.isAbsolute()) {
				if (file.getProject().equals(contextProject) && nextRoot.isPrefixOf(file.getProjectRelativePath())) {
					return toFullyQualifiedName(file.getProjectRelativePath().removeFirstSegments(nextRoot.segmentCount()));
				}
			} else {
				if (nextRoot.isPrefixOf(file.getFullPath())) {
					return toFullyQualifiedName(file.getFullPath().removeFirstSegments(nextRoot.segmentCount()));
				}
			}
		}
		return null;
	}

	private static String toFullyQualifiedName(IPath filePath) {
		return filePath.removeFileExtension().toString().replace("/", TypeNameUtil.NS_DELIM);
	}

	@Override
	protected String resolveCFileFullPath(String fullyQualifiedName, String fileExtension) {
		IPath fp = new Path(fullyQualifiedName.replaceAll(TypeNameUtil.NS_DELIM, "/")).addFileExtension(fileExtension);
		IPath[] resolutions = getResolutions(fp);
		for (IPath resolvedPath : resolutions) {
			IFile file = resolvedPath.isAbsolute() ? ResourcesPlugin.getWorkspace().getRoot().getFile(resolvedPath) : contextProject.getFile(resolvedPath);
			if (file.exists()) {
				return file.getLocation().toOSString();
			}
		}
		// TODO: use file located in main Path in this case?
		return fullyQualifiedName + "." + fileExtension;
	}
	
	@Override
	protected UnitResolver getQVTUnitResolver() {
		List<URL> bundleRootURLs = new ArrayList<URL>();
		for (IPath rootPath : myConfiguredRoots) {
			if (rootPath.isAbsolute()) {
				if (!rootPath.hasTrailingSeparator()) {
					rootPath = rootPath.addTrailingSeparator();
				}
				Bundle platformBundle = Platform.getBundle(rootPath.segment(0));
				if (platformBundle != null) {
					URL url = platformBundle.getEntry(rootPath.removeFirstSegments(1).toString());
					if (url != null) {
						bundleRootURLs.add(url);
					}
				}
			}
		}
		
		final UnitResolver bundleDelegate = BundleUnitResolver.createResolver(bundleRootURLs, true);
		WorkspaceUnitResolver resolver = new WorkspaceUnitResolver(Collections.<IContainer>emptyList()) {
			@Override
			protected UnitResolver getParent() {
				return bundleDelegate;
			}
		};
		for (IPath rootPath : myConfiguredRoots) {
			if(!rootPath.isAbsolute()) {
				rootPath = contextProject.getFullPath().append(rootPath);
			}
			
			IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(rootPath);
			if (member != null && (member instanceof IContainer)) {
				IContainer container = (IContainer) member;
				if (container.exists()) {
					resolver.addSourceContainer(container);
				}
			}
		}
		return resolver;
	}
}