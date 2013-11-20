
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
import org.eclipse.gmf.gmfgraph.DecorationFigure
import org.eclipse.gmf.gmfgraph.PolygonDecoration
import org.eclipse.gmf.gmfgraph.PolylineDecoration

/**
 * Instantiate and define attributes for DecorationFigures
 */
@com.google.inject.Singleton class Decoration {

	@Inject Runtime xptRuntime;
	@Inject Attrs xptAttrs;
	@Inject gmfgraph.attr.Decoration xptDecorationAttrs;

	def dispatch Instantiate(DecorationFigure it, String figureVarName) '''
		«xptRuntime.newInstance(it, figureVarName)»
		«xptAttrs.Init(it, figureVarName)»
	'''

	def dispatch Instantiate(PolylineDecoration it, String figureVarName) '''
		«xptRuntime.newInstance(it, figureVarName)»
		«xptDecorationAttrs.polylineAttrs(it, figureVarName)»
	'''

	/**
	 * Copy of above template for PolylineDecoration, 
	 * just because PolygonDecoration doesn't extend PolylineDecoration in draw2d and gmfgraph
	 */
	def dispatch Instantiate(PolygonDecoration it, String figureVarName) '''
		«xptRuntime.newInstance(it, figureVarName)»
		«xptDecorationAttrs.polylineAttrs(it, figureVarName)»
	'''

}
