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
package impl.parsers

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.ExpressionLabelParser
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import xpt.Common_qvto

@com.google.inject.Singleton class expression_qvto {
	@Inject extension Common_qvto

	def boolean isViewExpressionDefinedAndOcl(GenCommonBase xptSelf) {
		var LabelModelFacet labelModelFacet = getLabelModelfacet(xptSelf)
		return labelModelFacet != null && labelModelFacet.parser.isParserViewExpressionDefinedAndOcl();
	}

	def dispatch boolean isParserViewExpressionDefinedAndOcl(ExpressionLabelParser xptSelf) {
		return xptSelf.viewExpression != null && xptSelf.viewExpression.provider.oclIsKindOf(typeof(GenExpressionInterpreter));
	}

	def dispatch boolean isParserViewExpressionDefinedAndOcl(GenParserImplementation xptSelf) {
		return false;
	}

	private def LabelModelFacet getLabelModelfacet(GenCommonBase xptSelf) {
		return switch (xptSelf) {
			GenChildLabelNode: xptSelf.labelModelFacet
			GenLabel: xptSelf.modelFacet
			default: null
		}
	}

}
