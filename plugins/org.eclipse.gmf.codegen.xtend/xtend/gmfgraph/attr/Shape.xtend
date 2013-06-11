/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
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
package gmfgraph.attr

import org.eclipse.gmf.gmfgraph.LineKind
import org.eclipse.gmf.gmfgraph.Polygon

/**
 *	org.eclipse.draw2d.Shape
 *	private boolean fill = true, outline = true, xorFill, xorOutline;
 *	lineAttributes.width = 1.0
 *	lineAttributes.style = LINE_SOLID
 */
class Shape {

	def shapeAttrs(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«fill(it, figureVarName)»
	«IF it.xorFill»«xorFill(it, figureVarName)»«ENDIF»
	«IF !it.outline»«outline(it, figureVarName)»«ENDIF»
	«IF it.xorOutline»«xorOutline(it, figureVarName)»«ENDIF»
	«IF it.lineWidth != 1»«lineWidth(it, figureVarName)»«ENDIF»
	«IF it.lineKind != LineKind::LINE_SOLID_LITERAL»«lineKind(it, figureVarName)»«ENDIF»
	'''

	def dispatch fill(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«IF !fill»«figureVarName».setFill(«fill»);
	«ENDIF»
	'''

	def dispatch fill(Polygon it, String figureVarName) '''
	«IF it.fill»«figureVarName».setFill(«it.fill»);
	«ENDIF»
	'''

	def xorFill(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setFillXOR(«xorFill»);
	'''

	def outline(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setOutline(«outline»);
	'''

	def xorOutline(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setOutlineXOR(«xorOutline»);
	'''

	def lineWidth(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setLineWidth(«lineWidth»);
	'''

	def lineKind(org.eclipse.gmf.gmfgraph.Shape it, String figureVarName) '''
	«figureVarName».setLineStyle(org.eclipse.draw2d.Graphics.«lineKind»);
	'''

}
