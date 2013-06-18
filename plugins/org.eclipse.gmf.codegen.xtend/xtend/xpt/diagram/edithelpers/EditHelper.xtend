/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
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
package xpt.diagram.edithelpers;

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.MetamodelType
import xpt.Common

public class EditHelper {
	@Inject extension Common;

	def EditHelper(MetamodelType it) '''
		«copyright(diagramElement.diagram.editorGen)»
		package «diagramElement.getDiagram().editHelpersPackageName»;
		
		public class «editHelperClassName» extends «diagramElement.diagram.baseEditHelperQualifiedClassName» {
			
			«additions(it)»
		}
	'''

	def additions(MetamodelType it) ''''''
}
