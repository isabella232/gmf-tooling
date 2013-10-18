/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import xpt.Common

class CompartmentItemSemanticEditPolicy {
	@Inject extension Common;

	@Inject childContainerCreateCommand xptChildContainerCreateCommand;
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;

	def className(GenCompartment it) '''«it.itemSemanticEditPolicyClassName»'''

	def packageName(GenCompartment it) '''«it.getDiagram().editPoliciesPackageName»'''

	def qualifiedClassName(GenCompartment it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenCompartment it) '''«qualifiedClassName(it)»'''

	def CompartmentItemSemanticEditPolicy(GenCompartment it) '''
		«copyright(getDiagram().editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment(it)»
		public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(getDiagram())» {
		
			«_constructor(it)»
		
			«xptChildContainerCreateCommand.childContainerCreateCommand(it.childNodes)»
			
			«additions(it)»
		}
	'''

	def _constructor(GenCompartment it) '''
		«generatedMemberComment(it)»
		public «className(it)»() {
			«xptBaseItemSemanticEditPolicy.defaultConstructorBody(node)»
		}
	'''

	def additions(GenCompartment it) ''''''
}
