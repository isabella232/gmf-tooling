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
import xpt.QualifiedClassNameProvider

public class EditHelper {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;

	def className(MetamodelType it) '''«it.editHelperClassName»'''

	def packageName(MetamodelType it) '''«it.diagramElement.getDiagram().editHelpersPackageName»'''

	def qualifiedClassName(MetamodelType it) '''«packageName(it)».«className(it)»'''

	def fullPath(MetamodelType it) '''«qualifiedClassName(it)»'''

	def EditHelper(MetamodelType it) '''
		«copyright(diagramElement.diagram.editorGen)»
		package «packageName(it)»;
		
		public class «className(it)» extends «getBaseEditHelperQualifiedClassName(diagramElement.diagram)» {
			
			«additions(it)»
		}
	'''

	def additions(MetamodelType it) ''''''
}
