package org.eclipse.gmf.codegen.gwt.client

import client.webapp.WebApp
import java.io.ByteArrayInputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor

class WebappGenerator {
	
	extension WebApp = new WebApp

	def generate(IProject project, String moduleName, IProgressMonitor monitor) {
		val webappFolder = project.getFolder("webapp")
		if (!webappFolder.exists)
			webappFolder.create(true, true, monitor)

		val cssFile = webappFolder.getFile("app.css")
		if (!cssFile.exists)
			cssFile.create(cssContent, monitor)

		val htmlFile = webappFolder.getFile("index.html")
		if (!htmlFile.exists)
			htmlFile.create(htmlContent(moduleName), monitor)

		val webInfFolder = webappFolder.getFolder("WEB-INF")
		if (!webInfFolder.exists)
			webInfFolder.create(true, true, monitor)

		val webFile = webInfFolder.getFile("web.xml")
		if (!webFile.exists)
			webFile.create(webContent(moduleName), monitor)
	}

	private def create(IFile it, CharSequence content, IProgressMonitor monitor) {
		val stream = new ByteArrayInputStream(content.toString.bytes)
		try {
			it.create(stream, true, monitor)
		} catch (CoreException e) {
			e.printStackTrace
		} finally {
			stream.close
		}
	}

}