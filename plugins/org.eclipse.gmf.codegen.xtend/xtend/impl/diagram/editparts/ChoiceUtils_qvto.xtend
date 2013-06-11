/**
 * Copyright (c) 2011 - 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Svyatoslav Kovalsky (Montages) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.diagram.editparts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.OclChoiceParser
import org.eclipse.gmf.codegen.gmfgen.PredefinedEnumParser
import xpt.Common_qvto

class ChoiceUtils_qvto {
	@Inject extension Common_qvto

	def boolean isOclChoiceLabel(GenCommonBase xptSelf) {
		var LabelModelFacet labelModelFacet = getLabelModelfacet(xptSelf)
		return labelModelFacet != null && labelModelFacet.parser.oclIsKindOf(typeof(OclChoiceParser))
	}

	def boolean isOclChoiceLabelWithShowExpr(GenCommonBase xptSelf) {
		var LabelModelFacet labelModelFacet = getLabelModelfacet(xptSelf)
		if (labelModelFacet == null) {
			return false
		}
		var parser = labelModelFacet.parser;
		return switch (parser) {
			OclChoiceParser: parser.showExpression != null
			default: false
		}
	}

	def boolean isChoiceLabel(LabelModelFacet modelFacet) {
		var parser = modelFacet.parser;
		return parser.oclIsKindOf(typeof(PredefinedEnumParser)) || parser.oclIsKindOf(typeof(OclChoiceParser));
	}

	def String getDirectManagerFQN(LabelModelFacet modelFacet) {
		return if (isChoiceLabel(modelFacet)) {
			"org.eclipse.gmf.tooling.runtime.directedit.ComboDirectEditManager"
		} else {
			"org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2"
		}
	}

	private def LabelModelFacet getLabelModelfacet(GenCommonBase xptSelf) {
		return switch (xptSelf) {
			GenChildLabelNode: xptSelf.labelModelFacet
			GenLabel: xptSelf.modelFacet
			default: null
		}
	}

}
