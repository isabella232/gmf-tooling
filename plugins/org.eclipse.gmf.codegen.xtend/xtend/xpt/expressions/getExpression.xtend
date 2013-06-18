/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.expressions

import com.google.inject.Inject
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase
import org.eclipse.gmf.codegen.gmfgen.ValueExpression
import xpt.Common_qvto
import metamodel.MetaModel
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef

class getExpression {
	@Inject extension Common_qvto;
	
	@Inject MetaModel xptMetaModel;

@MetaDef def getExpressionBody(ValueExpression it) '''«getExpressionBody(provider, it)»'''

@MetaDef def dispatch getExpressionBody(GenExpressionProviderBase it, ValueExpression valueExpr) //
	'''«ERROR('Abstract template call: getExpression')»'''

@MetaDef def dispatch getExpressionBody(GenExpressionInterpreter it, ValueExpression valueExpr) //
	'''«it.qualifiedClassName».getExpressionBody(«it.expressionIndex(valueExpr)»)'''


@MetaDef def dispatch getExpression(GenExpressionProviderBase it, ValueExpression valueExpr, GenClassifier context) //
	'''«ERROR('Abstract template call: getExpression')»'''

@MetaDef def dispatch getExpression(GenExpressionInterpreter it, ValueExpression valueExpr, GenClassifier context) //
	'''«getExpression(it, valueExpr, context, 'null')»'''

// occasionally we need to use some well-known context type, i.e. String
@MetaDef def dispatch getExpression(GenExpressionInterpreter it, ValueExpression valueExpr, String contextMetaClassifier) //
	'''«it.qualifiedClassName».«getExpressionAccessor(valueExpr)»(«it.expressionIndex(valueExpr)», «contextMetaClassifier», 'null')'''

// pass specific environment to obtain expression 
@MetaDef def getExpression(GenExpressionInterpreter it, ValueExpression valueExpr, GenClassifier context, String environmentArg) //
	'''«getQualifiedClassName()».«getExpressionAccessor(valueExpr)»(«it.expressionIndex(valueExpr)», «xptMetaModel.MetaClass(context)», «environmentArg»)'''

	/**
	 * XXX: [MG] in Xpand, there was additional "-1" here: 'it.expressions.indexOf(expr) - 1', hope in Xtend we don't need it
	 */   
	private static def int expressionIndex(GenExpressionInterpreter it, ValueExpression expr) {
		it.expressions.indexOf(expr)
	}
}