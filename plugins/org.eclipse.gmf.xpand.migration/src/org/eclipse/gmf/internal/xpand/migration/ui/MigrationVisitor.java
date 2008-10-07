/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.gmf.internal.xpand.RootManager;
import org.eclipse.gmf.internal.xpand.build.WorkspaceResourceManager;
import org.eclipse.gmf.internal.xpand.migration.Activator;
import org.eclipse.gmf.internal.xpand.migration.MigrationException;
import org.eclipse.gmf.internal.xpand.migration.XpandMigrationFacade;
import org.eclipse.gmf.internal.xpand.migration.XtendMigrationFacade;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class MigrationVisitor extends AbstractMigrationVisitor {

	static final String CHARSET = "ISO-8859-1";

	private int rootPathSegmentCount;

	private IFolder dstFolder;

	private IFolder dstNativeExtFolder;

	private IProgressMonitor monitor;

	private RootManager rootManager;

	private IJavaProject javaProject;

	private List<CharSequence> nativeLibraryDeclarations = new ArrayList<CharSequence>();

	private static CoreException createCoreException(Throwable th) {
		return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Exception during migration", th));
	}
	
	public MigrationVisitor(IContainer rootContainer, IFolder templatesOutputFolder, RootManager rootManager, IProgressMonitor progressMonitor) {
		this(rootContainer, templatesOutputFolder, null, null, rootManager, progressMonitor);
	}

	public MigrationVisitor(IContainer rootContainer, IFolder templatesOutputFolder, IFolder nativeExtensionsRoot, IJavaProject javaProject, RootManager rootManager, IProgressMonitor progressMonitor) {
		rootPathSegmentCount = rootContainer.getProjectRelativePath().segmentCount();
		dstFolder = templatesOutputFolder;
		dstNativeExtFolder = nativeExtensionsRoot;
		monitor = progressMonitor;
		this.rootManager = rootManager;
		this.javaProject = javaProject;
	}
	
	public List<CharSequence> getNativeLibraryDeclarations() {
		return nativeLibraryDeclarations;
	}

	@Override
	protected void visitFolder(IFolder resource) throws CoreException {
		try {
			IPath relativePath = getRelativePath(resource);
			IFolder folder = dstFolder.getFolder(relativePath);
			folder.create(true, true, createSubProgressMonitor("Migrating " + resource.getProjectRelativePath().toString()));
			if (relativePath.isEmpty()) {
				folder.setDefaultCharset(CHARSET, null);
			}
		} catch (InterruptedException e) {
			throw createCoreException(e);
		}
	}

	@Override
	protected void visitXpandResource(IFile resource) throws CoreException {
		try {
			IProgressMonitor subMonitor = createSubProgressMonitor("Migrating " + resource.getProjectRelativePath().toString());
			dstFolder.getFile(getRelativePath(resource)).create(migrateXpandResource(resource), true, subMonitor);
		} catch (InterruptedException e) {
			throw createCoreException(e);
		}
	}

	private InputStream migrateXpandResource(IFile srcFile) throws CoreException {
		String templateFullName = rootManager.getTemplateFullName(srcFile);
		WorkspaceResourceManager resourceManager = rootManager.getResourceManager(srcFile);
		XpandMigrationFacade migrationFacade = new XpandMigrationFacade(resourceManager, templateFullName, false);
		try {
			String updatedResourceContent = migrationFacade.migrateXpandResource();
			return new ByteArrayInputStream(updatedResourceContent.getBytes(CHARSET));
		} catch (MigrationException ex) {
			throw createCoreException(new XpandResourceMigrationException(ex, srcFile));
		} catch (UnsupportedEncodingException ex) {
			throw createCoreException(ex);
		}
	}

	@Override
	protected void visitXtendResource(IFile resource) throws CoreException {
		try {
			String templateFullName = rootManager.getTemplateFullName(resource);
			WorkspaceResourceManager resourceManager = rootManager.getResourceManager(resource);
			XtendMigrationFacade migrationFacade = new XtendMigrationFacade(resourceManager, templateFullName);

			IProgressMonitor subMonitor = createSubProgressMonitor("Migrating xtend extensions from " + resource.getProjectRelativePath().toString());
			dstFolder.getFile(getRelativePath(resource).removeFileExtension().addFileExtension(MigrateXtendResource.QVTO_EXTENSION)).create(
					new ByteArrayInputStream(migrationFacade.migrateXtendResource().toString().getBytes(CHARSET)), true, subMonitor);

			subMonitor = createSubProgressMonitor("Migrating native extensions from " + resource.getProjectRelativePath().toString());
			StringBuilder nativeLibraryClassBody = migrationFacade.getNativeLibraryClassBody();
			if (nativeLibraryClassBody != null) {
				nativeLibraryDeclarations.add(migrationFacade.getNativeLibraryXmlDeclaration());
				createNativeLibraryClass(migrationFacade.getNativeLibraryPackageName(), migrationFacade.getNativeLibraryClassName(), nativeLibraryClassBody, subMonitor);
			} else {
				subMonitor.done();
			}
		} catch (InterruptedException e) {
			throw createCoreException(e);
		} catch (UnsupportedEncodingException e) {
			throw createCoreException(e);
		} catch (MigrationException e) {
			throw createCoreException(new XpandResourceMigrationException(e, resource));
		}
	}

	private void createNativeLibraryClass(String nativeLibraryPackageName, String nativeLibraryClassName, StringBuilder nativeLibraryClassBody, IProgressMonitor subMonitor) throws CoreException,
			UnsupportedEncodingException, InterruptedException {
		IFolder pkg = getNativeExtSourcesFolder().getFolder(new Path(nativeLibraryPackageName.replaceAll("\\.", "/")));
		createFolder(pkg);
		IFile javaClassFile = pkg.getFile(nativeLibraryClassName + ".java");
		javaClassFile.create(new ByteArrayInputStream(nativeLibraryClassBody.toString().getBytes(pkg.getDefaultCharset())), true, subMonitor);
	}

	private void createFolder(IFolder folder) throws CoreException {
		if (!folder.exists()) {
			IContainer parent = folder.getParent();
			if (parent instanceof IFolder) {
				createFolder((IFolder) parent);
			}
			folder.create(true, true, null);
		}
	}

	private IPath getRelativePath(IResource resource) {
		return resource.getProjectRelativePath().removeFirstSegments(rootPathSegmentCount);
	}

	private IProgressMonitor createSubProgressMonitor(String taskName) throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException("Process was canceled");
		}
		SubProgressMonitor spm = new SubProgressMonitor(monitor, 1);
		spm.setTaskName(taskName);
		return spm;
	}

	private IFolder getNativeExtSourcesFolder() throws CoreException, InterruptedException {
		if (!dstNativeExtFolder.exists()) {
			dstNativeExtFolder.create(true, true, createSubProgressMonitor("Creating folder: " + dstNativeExtFolder.getName()));
			IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
			IClasspathEntry[] newRawClasspath = new IClasspathEntry[rawClasspath.length + 1];
			System.arraycopy(rawClasspath, 0, newRawClasspath, 0, rawClasspath.length);
			newRawClasspath[rawClasspath.length] = JavaCore.newSourceEntry(dstNativeExtFolder.getFullPath());
			javaProject.setRawClasspath(newRawClasspath, createSubProgressMonitor("Setting classpath"));
		}
		return dstNativeExtFolder;
	}

}
