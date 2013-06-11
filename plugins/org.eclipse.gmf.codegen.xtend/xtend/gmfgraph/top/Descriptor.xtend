/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
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
import gmfgraph.Runtime
import gmfgraph.Utils_Statefull_qvto
import gmfgraph.Utils_qvto
import org.eclipse.gmf.gmfgraph.ChildAccess
import org.eclipse.gmf.gmfgraph.FigureAccessor
import org.eclipse.gmf.gmfgraph.FigureDescriptor
import xpt.Common

class Descriptor {
	@Inject extension Common;
	@Inject extension Utils_qvto;
	@Inject extension Utils_Statefull_qvto;

	@Inject Runtime xptRuntime;
	@Inject Figure xptFigure;

	def Top(FigureDescriptor it, String packageStmt) '''
		«IF !packageStmt.nullOrEmpty»package «packageStmt»;«ENDIF»
		«generatedClassComment()»
		public class «compilationUnitName(it)» extends «xptRuntime.fqn(actualFigure)» {
		«body(it)»
		«additionalStaticFields()»
		}
	'''

	def Inner(FigureDescriptor it) '''
		«generatedClassComment»
		public class «compilationUnitName(it)» extends «xptRuntime.fqn(actualFigure)» {
			«body(it)»
		}
		«additionalStaticFields()»
	'''

	def body(FigureDescriptor it) '''
		«FOR acc : accessors.filter[a|!allCustomAccessors(it).map[typedFigure].exists[f|f == a.figure]]»
			«accessorField(acc)»
		«ENDFOR»
		
		«xptFigure.ClassBody(it.actualFigure, compilationUnitName(it))»
		
		«FOR acc : accessors.filter[a|!allCustomAccessors(it).map[typedFigure].exists[f|f == a.figure]]»
			«accessorToField(acc)»
		«ENDFOR»
		«FOR acc : accessors.filter[a|/*no ! here*/allCustomAccessors(it).map[typedFigure].exists[f|f == a.figure]]»
			«accessorToCustom(acc, allCustomAccessors(it).filter[fa|fa.typedFigure == acc.figure])»
		«ENDFOR»
	'''

	def accessorField(ChildAccess it) '''
		«generatedMemberComment»
		private «xptRuntime.fqn(it.figure)» «it.figureFieldName()»; 
	'''

	/**
	 * ChildAccess points to figure we've generated, here's a field for it
	 */
	def accessorToField(ChildAccess it) '''
		«generatedMemberComment»
		public «xptRuntime.fqn(figure)» «accessor»() {
			return «it.figureFieldName()»;
		}
	'''

	/**
	 * ChildAccess points to some child of a CustomFigure, need to delegate to it's accessor.
	 * Perhaps, should add support for ChildAccess not being generated (in case they are have same name as 
	 * FigureAccessor.accessor
	*/
	def accessorToCustom(ChildAccess it, Iterable<FigureAccessor> fa) '''
		«generatedMemberComment»
		public «xptRuntime.fqn(it.figure)» «it.accessor»() {
			return «fa.filter[accessor != null].head.accessor»;
		}
	'''

	def additionalStaticFields() '''
		«IF !staticStream.empty»
			«FOR str : staticStream»
				«str»
			«ENDFOR»
		«ENDIF»
	'''

}
