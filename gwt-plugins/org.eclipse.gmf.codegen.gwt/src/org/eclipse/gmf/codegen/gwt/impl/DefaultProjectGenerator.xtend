package org.eclipse.gmf.codegen.gwt.impl

import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.gmf.codegen.gwt.IProjectGenerator
import org.eclipse.jdt.core.JavaCore

class DefaultProjectGenerator implements IProjectGenerator {

	override createProject(String projectName, String projectLocation, IProgressMonitor monitor) {
		val project = ResourcesPlugin::workspace.root.getProject(projectName)
		if (!project.exists) {
			project.create(monitor)
		}
		if (!project.open) {
			project.open(monitor)
		}

		val description = project.description
		if (!projectLocation.nullOrEmpty) {
			description.setLocation(new Path(projectLocation))
			project.setDescription(description, monitor)
		}

		project
	}

	override configureClasspath(IProject project, IProgressMonitor monitor) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override configureNature(IProject project, IProgressMonitor monitor) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getFragmentRoot(IProject project, IProgressMonitor monitor) {
		val srcFolder = project.getFolder("src")
		if (!srcFolder.exists)
			srcFolder.create(true, true, monitor)

		val javaProject = JavaCore::create(project)
		javaProject.getPackageFragmentRoot(srcFolder)
	}

}