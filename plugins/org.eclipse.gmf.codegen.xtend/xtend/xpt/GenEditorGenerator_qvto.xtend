/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

@com.google.inject.Singleton class GenEditorGenerator_qvto {
	@Inject extension GenModelUtils_qvto;

	/** 
	 * FIXME remove java-only GenEditorGenerator#hasAudits or declare it in metamodel
	 */
	def boolean hasAudits(GenEditorGenerator editorGen) {
		return editorGen.audits != null && !editorGen.audits.rules.empty
	}

	/** 
	 * @see GenModelUtils#jdkComplianceLevel
	 */
	def int jdkComplianceLevel(GenEditorGenerator xptSelf) {
		//TODO honest field in the GenEditorGenerator instead of hardcoded value
		return xptSelf.diagram.domainDiagramElement.jdkComplianceLevel();
	}

	def int jdkComplianceLevel(GenCommonBase xptSelf) {
		return xptSelf.diagram.editorGen.jdkComplianceLevel()
	}

}
