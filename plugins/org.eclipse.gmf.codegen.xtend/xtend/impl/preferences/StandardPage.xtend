/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.preferences

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage
import org.eclipse.gmf.codegen.gmfgen.StandardPreferencePages
import xpt.Common
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef

class StandardPage {
	@Inject extension Common;

	def Main(GenStandardPreferencePage it) '''
		«copyright(it.diagram.editorGen)»
		package «getDiagram().preferencesPackageName»;
		
		«generatedClassComment»
		public class «getClassName()» «extendsList(it)» «implementsList(it)» {
		
			«generatedMemberComment»
			public «getClassName()»() {
				setPreferenceStore(«getDiagram().editorGen.plugin.activatorQualifiedClassName».getInstance().getPreferenceStore());
			}
		}
	'''

	def extendsList(GenStandardPreferencePage it) '''
		«IF kind == StandardPreferencePages::GENERAL_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramsPreferencePage«»
		«ELSEIF kind == StandardPreferencePages::APPEARANCE_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.AppearancePreferencePage«»
		«ELSEIF kind == StandardPreferencePages::CONNECTIONS_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage«»
		«ELSEIF kind == StandardPreferencePages::PRINTING_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage«»
		«ELSEIF kind == StandardPreferencePages::RULERS_AND_GRID_LITERAL»
			extends org.eclipse.gmf.runtime.diagram.ui.preferences.RulerGridPreferencePage«»
		«ENDIF»
	'''

	def implementsList(GenStandardPreferencePage it) '''«/* no-op */»'''

	@MetaDef def call_initDefaults(GenStandardPreferencePage it, String storeVarName) //
	'''«IF kind != StandardPreferencePages::PATHMAPS_LITERAL»«getQualifiedClassName()».initDefaults(«storeVarName»);«ENDIF»'''

}
