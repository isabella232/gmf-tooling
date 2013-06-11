/**
 * Copyright (c) 2011, 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Montages) - initial API and implementation, migration to Xtend2
 */
package impl.diagram.editparts.viewmaps

import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap
import com.google.inject.Inject
import xpt.Common_qvto
import org.eclipse.emf.ecore.EObject
import org.eclipse.gmf.gmfgraph.DiagramLabel
import org.eclipse.gmf.gmfgraph.Node
import org.eclipse.gmf.gmfgraph.Connection
import org.eclipse.gmf.gmfgraph.DiagramElement

class modeledViewmapProducer {
	@Inject extension Common_qvto
	@Inject extension BareFigure_qvto
	
	@Inject gmfgraph.Runtime xptRuntime;
	@Inject gmfgraph.top.Descriptor xptDescriptor;
	
	def viewmapFigureFQN(ModeledViewmap it) ''' 
		«figureFQN(it.figureModel)»
	'''

	def dispatch figureFQN(EObject it) '''
		«ERROR('Unknown figureModel: ' + it)»
	'''

	def dispatch figureFQN(DiagramLabel it)'''
		«IF figure == null || figure.actualFigure == null»org.eclipse.draw2d.Label«
		ELSEIF it.accessor == null»«/** FIXME: bare instances */»«xptRuntime.fqn(it.figure.actualFigure)»«
		ELSE»«xptRuntime.fqn(it.accessor.figure)»«ENDIF»
	'''

	def dispatch figureFQN(Node it) '''«nodeOrLinkFQN(it)»'''

	def dispatch figureFQN(Connection it) '''«nodeOrLinkFQN(it)»'''

	def nodeOrLinkFQN (DiagramElement it) '''
		«IF figure == null || figure.actualFigure == null»org.eclipse.draw2d.RoundedRectangle«
		ELSEIF isBareFigureDescriptor(it.figure)»«xptRuntime.fqn(it.figure.actualFigure)»«
		ELSE»«/** actual InnerClassViewmap case */»«it.figure.name.toFirstUpper»«ENDIF»
	'''

	def viewmapClassBody(ModeledViewmap it) '''«classBody(figureModel)»'''

	def dispatch classBody(EObject it) '''«ERROR('Unknown figureModel: ' + it)»''' 

	def dispatch classBody(DiagramElement it) '''
	«IF figure == null || figure.actualFigure == null || isBareFigureDescriptor(figure)»«/* nothing to do */»«
	ELSE»«/*actual InnerClassViewmap case*/»«xptDescriptor.Inner(it.figure)»«ENDIF»
	'''
}