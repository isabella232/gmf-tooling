/**
 * Copyright (c) 2006, 2013 Borland Software Corporation and others
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

import com.google.inject.Inject
import gmfgraph.MapMode
import org.eclipse.gmf.gmfgraph.Point
import org.eclipse.gmf.gmfgraph.PolygonDecoration
import org.eclipse.gmf.gmfgraph.Polyline
import org.eclipse.gmf.gmfgraph.PolylineDecoration

class Decoration {
	@Inject Figure xptFigure;
	@Inject MapMode xptMapMode;
	@Inject Shape xptShape;

	def dispatch polylineAttrs(PolylineDecoration it, String figureVarName) '''
		«xptShape.shapeAttrs(it, figureVarName)»
		«xptFigure.figureAttrs(it, figureVarName)»
		«templatePoints(it, figureVarName)»
		«scale(it, figureVarName)»
	'''

	def dispatch polylineAttrs(PolygonDecoration it, String figureVarName) '''
		«xptShape.shapeAttrs(it, figureVarName)»
		«xptFigure.figureAttrs(it, figureVarName)»
		«templatePoints(it, figureVarName)»
		«scale(it, figureVarName)»
	'''

	def templatePoints(Polyline it, String figureVarName) '''
		«IF !template.empty»
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			«FOR p : it.template»
				«templatePoint(p, 'pl')»
			«ENDFOR»
			«figureVarName».setTemplate(pl);
		«ENDIF»
	'''

	def templatePoint(Point it, String pointListVarName) '''
		«pointListVarName».addPoint(«xptMapMode.mapMode(it)»);
	'''

	def dispatch scale(PolylineDecoration it, String figureVarName) '''
		«IF !template.empty»
			«figureVarName».setScale(«xptMapMode.mapMode(7)», «xptMapMode.mapMode(3)»);
		«ENDIF»
	'''

	def dispatch scale(PolygonDecoration it, String figureVarName) '''
		«IF !template.empty»
			«figureVarName».setScale(«xptMapMode.mapMode(7)», «xptMapMode.mapMode(3)»);
		«ENDIF»
	'''

}
