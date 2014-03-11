package org.eclipse.gmf.codegen.gwt.impl

import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.gmf.codegen.gwt.IFileGenerator

class TextFileGenerator implements IFileGenerator {

	override generateFile(CharSequence content, String path, IProgressMonitor monitor) {
		val charset = "UTF-8"
		var ByteArrayInputStream stream = null
		try {
			stream = new ByteArrayInputStream(content.toString.getBytes(charset))
			generateFile(stream, path, monitor)
		} finally {
			stream.close()
		}
	}
	
	override generateFile(InputStream content, String path, IProgressMonitor monitor) {
		val filePath = new Path(path)

    	CodeGenUtil.EclipseUtil::findOrCreateContainer(
    		filePath.removeLastSegments(1), 
    		false, 
    		null as IPath, 
    		monitor
    	)

		val file = ResourcesPlugin::workspace.root.getFile(filePath)
		if (!file.exists)
    		file.create(content, true, monitor)
    	else
    		file.setContents(content, true, true, monitor)
	}

}