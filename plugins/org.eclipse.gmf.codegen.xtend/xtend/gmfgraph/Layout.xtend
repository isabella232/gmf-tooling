/**
 * Copyright (c) 2006, 2008, 2013 Borland Software Corporation and others
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
import org.eclipse.gmf.gmfgraph.Alignment
import org.eclipse.gmf.gmfgraph.BorderLayout
import org.eclipse.gmf.gmfgraph.CustomLayout
import org.eclipse.gmf.gmfgraph.FlowLayout
import org.eclipse.gmf.gmfgraph.GridLayout
import org.eclipse.gmf.gmfgraph.LayoutRef
import xpt.Common

class Layout {
	@Inject extension Common;
	
	@Inject Runtime xptRuntime;
	@Inject CustomAttributeOwner xptCustomAttributeOwner;

	def Init(org.eclipse.gmf.gmfgraph.Layout layout, String owningFigureVariable) '''
		«IF layout != null»
			«dispatch_Init(layout, owningFigureVariable)»
		«ENDIF»
	'''

	def dispatch CharSequence dispatch_Init(org.eclipse.gmf.gmfgraph.Layout it, String owningFigureVariable) '''
		«owningFigureVariable».setLayoutManager(«xptRuntime.newInstance(it)»);
	'''

	def dispatch CharSequence dispatch_Init(LayoutRef it, String owningFigureVariable) '''
		«IF it.actual != null»
			«dispatch_Init(it.actual, owningFigureVariable)»
		«ENDIF»
	'''

	def dispatch CharSequence dispatch_Init(BorderLayout it, String owningFigureVariable) '''
		«var layoutVarName = layoutVarName(owningFigureVariable)»
		«xptRuntime.newInstance(it, layoutVarName)»
		«IF null != it.spacing»
			«layoutVarName».setHorizontalSpacing(«spacing.dx»);// TODO mapMode?
			«layoutVarName».setVerticalSpacing(«spacing.dy»);
		«ENDIF»
		«owningFigureVariable».setLayoutManager(«layoutVarName»);
	'''

	def dispatch CharSequence dispatch_Init(GridLayout it, String owningFigureVariable) '''
		«var layoutVarName = layoutVarName(owningFigureVariable)»
		«xptRuntime.newInstance(it, layoutVarName)»
		«layoutVarName».numColumns = «it.numColumns»;
		«layoutVarName».makeColumnsEqualWidth = «it.equalWidth»;
		«IF null != spacing»
			«layoutVarName».horizontalSpacing = «it.spacing.dx»;
			«layoutVarName».verticalSpacing = «it.spacing.dy»;
		«ENDIF»
		«IF null != it.margins»
			«layoutVarName».marginWidth = «margins.dx»;
			«layoutVarName».marginHeight = «margins.dy»;
		«ENDIF»
		«owningFigureVariable».setLayoutManager(«layoutVarName»);
	'''

	def dispatch CharSequence dispatch_Init(FlowLayout it, String owningFigureVariable) '''
		«var layoutVarName = layoutVarName(owningFigureVariable)»
		«extraLineBreak»
		«xptRuntime.newInstance(it, layoutVarName)»
		«layoutVarName».setStretchMinorAxis(«matchMinorSize»);
		«layoutVarName».setMinorAlignment(«xptRuntime.fqn(it)».«alignment(minorAlignment, forceSingleLine)»);
		«IF forceSingleLine»
			«extraLineBreak»
			«layoutVarName».setSpacing(«majorSpacing»);
			«layoutVarName».setVertical(«vertical»);
		«ELSE»
			«extraLineBreak»
			«layoutVarName».setMajorAlignment(«xptRuntime.fqn(it)».«alignment(majorAlignment, forceSingleLine)»);
			«layoutVarName».setMajorSpacing(«majorSpacing»);
			«layoutVarName».setMinorSpacing(«minorSpacing»);
			«layoutVarName».setHorizontal(«!vertical»);
		«ENDIF»
		«extraLineBreak»
		«owningFigureVariable».setLayoutManager(«layoutVarName»);
	'''

	def dispatch CharSequence dispatch_Init(CustomLayout it, String owningFigureVariable) '''
		«var String layoutVarName = layoutVarName(owningFigureVariable)»
		«xptRuntime.newInstance(it, layoutVarName)»
		«xptCustomAttributeOwner.Init(it, layoutVarName)»
		«owningFigureVariable».setLayoutManager(«layoutVarName»);
	'''

	def String layoutVarName(String owningFigureVariable) {
		return 'layout' + owningFigureVariable.toFirstUpper;
	}

	def String alignment(Alignment alignment, boolean forceSingleLine) {
		switch (alignment) {
			case Alignment::BEGINNING_LITERAL: return if(forceSingleLine) 'ALIGN_TOPLEFT' else 'ALIGN_LEFTTOP'
			case Alignment::END_LITERAL: return if(forceSingleLine) 'ALIGN_BOTTOMRIGHT' else 'ALIGN_RIGHTBOTTOM'
			default: 'ALIGN_CENTER'
		}
	}

}
