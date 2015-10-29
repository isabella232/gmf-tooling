package org.eclipse.gmf.tooling.codegen.launcher.utils;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.tooling.codegen.launcher.Activator;

public class WorkspaceHelper {

	public void initWorkspace(String gmfgenProject, List<String> relatedProjects) throws CoreException {
		clearWorkspace();

		for (String path : relatedProjects) {
			importProject(path);
		}

		importProject(gmfgenProject);
	}

	public void clearWorkspace() throws CoreException {
		boolean deleteContent = false;
		boolean forceDelete = true;
		NullProgressMonitor monitor = new NullProgressMonitor();

		getRoot().refreshLocal(0, monitor);

		for (IProject project: getRoot().getProjects()) {
			project.delete(deleteContent, forceDelete, monitor);
		}
	}

	public IProject createProject(String name, IPath location) throws CoreException {
		NullProgressMonitor monitor = new NullProgressMonitor();

		IProject project = getRoot().getProject(name);
		IProjectDescription descr = getWorkspace().newProjectDescription(name);

		if (location != null) {
			descr.setLocation(location);
		}

		if (!project.exists()) {
			project.create(descr, monitor);
		}
		if (!project.isOpen()) {
			project.open(monitor);
		}
		return project;
	}

	
	public IProject importProject(String path) throws CoreException {
		Path location = new Path(path);
		String name = location.lastSegment();
		return importProject(name, location);
	}

	public IProject importProject(String name, IPath location) throws CoreException {
		File projectPath = location.toFile();
		if (!projectPath.exists() || !projectPath.isDirectory()) {
			throw createCoreException("Cannot import project. Location don't exist or it is not directory.");
		}
		boolean projectFileExist = false;
		for(String file: projectPath.list()) {
			if (".project".equals(file)) {
				projectFileExist = true;
				break;
			}
		}
		if (!projectFileExist) {
			throw createCoreException("Directory is not an eclipse project");
		}

		IProject project = getRoot().getProject(name);
		if (project.exists()) {
			if (!project.getLocation().equals(location)) {
				throw createCoreException("Workspace contain project with same name but different location");
			}
			if (!project.isOpen()) {
				project.open(new NullProgressMonitor());
			}
			return project;
		}

		return createProject(name, location);
	}

	private IWorkspaceRoot getRoot() {
		return getWorkspace().getRoot();
	}

	private IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	private static CoreException createCoreException(String message) {
		return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}
}
