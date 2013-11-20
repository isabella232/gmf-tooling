/**
 * Copyright (c) 2006, 2007, 2013 Borland Software Corporation and others
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
package gmfgraph

import com.google.inject.Inject
import gmfgraph.attr.CustomAttributeOwner
import org.eclipse.gmf.gmfgraph.BorderLayoutData
import org.eclipse.gmf.gmfgraph.CustomLayoutData
import org.eclipse.gmf.gmfgraph.GridLayoutData
import org.eclipse.gmf.gmfgraph.XYLayoutData
import xpt.Common_qvto
import xpt.Common

@com.google.inject.Singleton class LayoutData {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject Runtime xptRuntime;
	@Inject CustomAttributeOwner xptCustomAttributeOwner;
	@Inject MapMode xptMapMode;

	def dispatch Init(LayoutData it, String parentFigureVariable, String owningFigureVariable) '''
		«ERROR('Abstract definition, there should be specific template for ' + it)»
	'''

	def dispatch Init(BorderLayoutData it, String parentFigureVariable, String owningFigureVariable) '''
		«extraLineBreak»
		«parentFigureVariable».add(«owningFigureVariable», org.eclipse.draw2d.BorderLayout.«borderLayoutConstant(it)»);
	'''

	def dispatch Init(XYLayoutData it, String parentFigureVariable, String owningFigureVariable) '''
		«extraLineBreak»
		«parentFigureVariable».add(«owningFigureVariable», «newRectangle(it)»);
	'''

	def dispatch Init(CustomLayoutData it, String parentFigureVariable, String owningFigureVariable) '''
		«extraLineBreak»
		«var constraintVarName = 'constraint' + owningFigureVariable.toFirstUpper»
		«qualifiedClassName» «constraintVarName» = new «qualifiedClassName»();
		«xptCustomAttributeOwner.Init(it, constraintVarName)»
		«parentFigureVariable».add(«owningFigureVariable», «constraintVarName»);
	'''

	def dispatch Init(GridLayoutData it, String parentFigureVariable, String owningFigureVariable) '''
		«extraLineBreak»
		«var constraintVarName = 'constraint' + owningFigureVariable.toFirstUpper»
		«xptRuntime.newInstance(it, constraintVarName)»
		«constraintVarName».verticalAlignment = «xptRuntime.fqn(it)».«verticalAlignment.literal»;
		«constraintVarName».horizontalAlignment = «xptRuntime.fqn(it)».«horizontalAlignment.literal»;
		«constraintVarName».horizontalIndent = «horizontalIndent»;
		«constraintVarName».horizontalSpan = «horizontalSpan»;
		«constraintVarName».verticalSpan = «verticalSpan»;
		«constraintVarName».grabExcessHorizontalSpace = «grabExcessHorizontalSpace»;
		«constraintVarName».grabExcessVerticalSpace = «grabExcessVerticalSpace»;
		«IF null != sizeHint»
			«constraintVarName».widthHint = «sizeHint.dx»;
			«constraintVarName».heightHint = «sizeHint.dy»;
		«ENDIF»
		«parentFigureVariable».add(«owningFigureVariable», «constraintVarName»);
	'''

	def newRectangle(XYLayoutData it) '''
		new org.eclipse.draw2d.geometry.Rectangle(«IF 
			null != topLeft»«xptMapMode.mapMode(topLeft)», «ELSE»0, 0, «ENDIF»«IF  
			null != size»«xptMapMode.mapMode(size)»«ELSE»0, 0«ENDIF»)
	'''

}
