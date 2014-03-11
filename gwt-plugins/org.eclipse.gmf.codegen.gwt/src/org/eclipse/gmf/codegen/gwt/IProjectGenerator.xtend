package org.eclipse.gmf.codegen.gwt

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jdt.core.IPackageFragmentRoot

interface IProjectGenerator {

	def IProject createProject(String projectName, String projectLocation, IProgressMonitor monitor)

	def void configureClasspath(IProject project, IProgressMonitor monitor)
	
	def void configureNature(IProject project, IProgressMonitor monitor)

	def IPackageFragmentRoot getFragmentRoot(IProject project, IProgressMonitor monitor)

}