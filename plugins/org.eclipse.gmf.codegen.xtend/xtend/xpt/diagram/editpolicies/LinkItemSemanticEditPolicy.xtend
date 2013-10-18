/**
 * Copyright (c) 2007-2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 * 								- #386838 - migrate to Xtend2
 */
package xpt.diagram.editpolicies

import com.google.inject.Inject
import impl.diagram.commands.DeleteLinkCommand
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import xpt.Common
import xpt.Common_qvto

class LinkItemSemanticEditPolicy {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension LinkUtils_qvto;

	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;
	@Inject linkCommands xptLinkCommands;
	@Inject DeleteLinkCommand xptDeleteLinkCommand;

	def className(GenLink it) '''«it.itemSemanticEditPolicyClassName»'''

	def packageName(GenLink it) '''«it.getDiagram().editPoliciesPackageName»'''

	def qualifiedClassName(GenLink it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenLink it) '''«qualifiedClassName(it)»'''

	def LinkItemSemanticEditPolicy(GenLink it) '''
		«copyright(diagram.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment(it)»
		public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(it.diagram)» {
		
			«xptBaseItemSemanticEditPolicy.defaultConstructor(it)»
		
			«classBody(it)»
			
			«additions(it)»
		}
	'''

	def classBody(GenLink it) '''
		«getDestroySemanticCommand(it.modelFacet, it)»
		«IF isTypeLink(it)»«xptLinkCommands.linkCommands(it)»«ENDIF»
	'''

	def dispatch getDestroySemanticCommand(LinkModelFacet it, GenLink genLink) '''
		«ERROR('Unsupported model facet: ' + it + ", for link: " + genLink)»
	'''

	def dispatch getDestroySemanticCommand(FeatureLinkModelFacet it, GenLink genLink) '''
		«generatedMemberComment(it)»
		protected org.eclipse.gef.commands.Command getDestroyReferenceCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest req) {
			return getGEFWrapper(«xptDeleteLinkCommand.newDeleteReferenceLinkCommand(it, genLink, 'req')»);
		}
	'''

	def dispatch getDestroySemanticCommand(TypeLinkModelFacet it, GenLink genLink) '''
		«generatedMemberComment(it)»
		protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
			return getGEFWrapper(«xptDeleteLinkCommand.newDeleteLinkWithClassCommand(it, genLink, 'req')»);
		}
	'''

	def additions(GenLink it) ''''''

}
