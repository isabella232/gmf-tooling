/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
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
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.Common
import xpt.diagram.commands.CreateNodeCommand
import xpt.providers.ElementTypes
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase

@Singleton class childContainerCreateCommand {
	
	@Inject extension Common;
	
	@Inject ElementTypes xptElementTypes;
	@Inject CreateNodeCommand xptCreateNodeCommand;
 
 	def CharSequence childContainerCreateCommand(GenContainerBase container, Iterable<? extends GenNode> nodes) '''
	«IF !nodes.empty»

	«generatedMemberComment()»
	protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
	«FOR n : nodes»		
		«childNodeCreateCommand(container, n)»
	«ENDFOR»
		return super.getCreateCommand(req);
	}
	«ENDIF»
	'''


	def childNodeCreateCommand(GenContainerBase container, GenNode childNode) '''
	if («xptElementTypes.accessElementType(childNode)» == req.getElementType()) {
		return getGEFWrapper(new «xptCreateNodeCommand.qualifiedClassName(childNode.findFacetForContainerOrDiagram(container))»(req));
	}
	'''

}