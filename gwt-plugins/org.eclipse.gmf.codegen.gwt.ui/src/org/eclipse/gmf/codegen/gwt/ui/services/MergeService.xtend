package org.eclipse.gmf.codegen.gwt.ui.services

import org.eclipse.gmf.codegen.gwt.IMergeService
import org.eclipse.gmf.internal.common.codegen.TextMerger

class MergeService implements IMergeService {

	val TextMerger merger = new TextMerger()

	override mergeJava(String oldText, String newText) {
		merger.mergeJava(oldText, newText)
	}

}