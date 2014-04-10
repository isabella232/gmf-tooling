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
package gmfgraph.top

import com.google.inject.Inject
import com.google.inject.Singleton
import gmfgraph.Attrs
import gmfgraph.Border
import gmfgraph.Children
import gmfgraph.Decoration
import gmfgraph.Extras
import gmfgraph.Layout
import gmfgraph.Utils_Statefull_qvto
import java.util.ArrayList
import java.util.List
import org.eclipse.gmf.gmfgraph.DecorationFigure
import org.eclipse.gmf.gmfgraph.FigureRef
import org.eclipse.gmf.gmfgraph.PolylineConnection
import org.eclipse.gmf.gmfgraph.RealFigure
import xpt.Common
import xpt.Common_qvtoimport java.lang.reflect.Array
import java.util.Arrays

@Singleton class Figure {
	@Inject extension Common_qvto;
	@Inject extension Common;
	@Inject extension Utils_Statefull_qvto;
	
	@Inject Layout xptLayout;
	@Inject Attrs xptAttrs;
	@Inject Children xptChildren;
	@Inject Border xptBorder;
	@Inject Extras xptExtras;
	@Inject Decoration xptDecoration; 
	
	def dispatch ClassBody(org.eclipse.gmf.gmfgraph.Figure it, String cuName) '''«ERROR('abstract ClassBody(Figure)')»'''

	def dispatch ClassBody(FigureRef it, String cuName) '''«ClassBody(figure, cuName, it)»'''

	def dispatch ClassBody(RealFigure it, String cuName) '''«ClassBody(it, cuName, null)»'''

	def dispatch ClassBody(RealFigure it, String cuName, FigureRef figureRef) '''
		«generatedMemberComment»
		public «cuName»() {
			«clearState()»
			«xptLayout.Init(it.layout, 'this')»
			«xptAttrs.Init(it, 'this')»
		«IF figureRef != null»
			// «figureRef.figure.name» 
			// Process FigureRef details
			«xptLayout.Init(figureRef.layout, 'this')»
			«xptAttrs.Init(figureRef, 'this')»
		«ENDIF»		
		«IF !it.children.filter(typeof(org.eclipse.gmf.gmfgraph.Figure)).empty»
			createContents();
		}
		«xptChildren.CreateChildren(it)»
		«ELSE»
		}
		«ENDIF»
		«xptBorder.InitMethods(it)»
		«extraLineBreak»
		«xptExtras.extraMethods(it)»
		«additions(it)»
	'''
	
	def Iterable<org.eclipse.gmf.gmfgraph.Figure> safeExcluding(List<org.eclipse.gmf.gmfgraph.Figure> children, DecorationFigure... d)  {
		return safeExcluding(children, Arrays.asList(d));
	}	

	def Iterable<org.eclipse.gmf.gmfgraph.Figure> safeExcluding(List<org.eclipse.gmf.gmfgraph.Figure> children, List<DecorationFigure> d)  {
		children.filter[f| !d.contains(f)];
	}

	def dispatch ClassBody(PolylineConnection it, String cuName, FigureRef figureRef) '''
		«val childrenWithoutDecorators = safeExcluding(it.children, sourceDecoration, targetDecoration)»
		«generatedMemberComment»
		public «cuName»() {
			«clearState()»
			«xptAttrs.Init(it, 'this')»
			«extraLineBreak»
			«IF childrenWithoutDecorators.isEmpty()»
					createContents();
			«ENDIF»
			«IF it.sourceDecoration != null»
				setSourceDecoration(createSourceDecoration());
			«ENDIF»
			«IF it.targetDecoration != null»
				setTargetDecoration(createTargetDecoration());
			«ENDIF»
		}
	
		«/*
		  *	Copy of Children::CreateChildren with temp workaround to generate child figures for labels only.
		  * 	Though this is workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=193180, I'm not sure
	      * what's the right approach with e.g. decoration as child of a link.
		  */
		IF childrenWithoutDecorators.isEmpty()»
		«generatedMemberComment»
		private void createContents(){
			«FOR l : childrenWithoutDecorators»
				«xptChildren.instantiate(l, 0, it, 'this')»
			«ENDFOR»
			«extraLineBreak»
		}
		«ENDIF»
		«IF it.sourceDecoration != null»
		«generatedMemberComment»
		private org.eclipse.draw2d.RotatableDecoration createSourceDecoration() {
			«xptDecoration.Instantiate(it.sourceDecoration, 'df')»
			return df;
		}
		«ENDIF»
		«IF it.targetDecoration != null»
		«generatedMemberComment»
		private org.eclipse.draw2d.RotatableDecoration createTargetDecoration() {
			«xptDecoration.Instantiate(it.targetDecoration, 'df')»
			return df;
		}
		«ENDIF»
		«additions(it)»
	'''

	def additions(org.eclipse.gmf.gmfgraph.Figure it) ''''''
	
}