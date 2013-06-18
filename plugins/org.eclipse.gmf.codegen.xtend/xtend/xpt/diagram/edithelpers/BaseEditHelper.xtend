/**
 * Copyright (c) 2006, 2009, 2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #368169 - extract common code to GMFT-specific runtime
 * 								 - #386838 - migrate to Xtend2
 */
package xpt.diagram.edithelpers;

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

public class BaseEditHelper {
	@Inject extension Common;

	def extendsClause(GenDiagram it) '''extends «superClass(it)»'''

	def superClass(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase'''

	def BaseEditHelper(GenDiagram it) '''
		«copyright(editorGen)»
		package «editHelpersPackageName»;
		
		«generatedClassComment(it)»
		public class «baseEditHelperClassName» «extendsClause(it)» {
		
			«attributes(it)»
			
			«getEditHelperAdvice(it)»
			
			«getInsteadCommand(it)»
		
			«getCreateCommand(it)»
		
			«getCreateRelationshipCommand(it)»
		
			«getDestroyElementCommand(it)»
		
			«getDestroyReferenceCommand(it)»
		
			«additions(it)»
		}
	'''

	def editPolicyCommandConstant(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase.EDIT_POLICY_COMMAND'''

	def contextElementTypeConstant(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE'''

	def attributes(GenDiagram it) ''''''

	/* 
	We don't have anything to generate here since common code had extracted to GMFT-runtime as part of #368169
	*/
	def getEditHelperAdvice(GenDiagram it) ''''''

	def getInsteadCommand(GenDiagram it) ''''''

	def getCreateCommand(GenDiagram it) ''''''

	def getCreateRelationshipCommand(GenDiagram it) ''''''

	def getDestroyElementCommand(GenDiagram it) ''''''

	def getDestroyReferenceCommand(GenDiagram it) ''''''

	def additions(GenDiagram it) ''''''

}
