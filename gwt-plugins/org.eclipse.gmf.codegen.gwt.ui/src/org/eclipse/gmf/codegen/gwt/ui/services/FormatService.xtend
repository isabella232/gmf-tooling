package org.eclipse.gmf.codegen.gwt.ui.services

import java.util.Collections
import org.eclipse.gmf.codegen.gwt.IFormatService
import org.eclipse.jdt.core.ToolFactory
import org.eclipse.jdt.core.formatter.CodeFormatter
import org.eclipse.jface.text.Document

class FormatService implements IFormatService {
	
	override formatCode(String text) {
		val formatter = ToolFactory::createCodeFormatter(Collections.<Object, Object> emptyMap())
		val doc = new Document(text)
		val edit = formatter.format(CodeFormatter::K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null)

		try {
			// check if text formatted successfully
			if (edit != null) {
				edit.apply(doc)
				return doc.get()
			}
		} catch (Exception ex) {
			ex.printStackTrace()
		}

		return text
	}

}