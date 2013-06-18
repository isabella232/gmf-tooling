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
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.Common
import xpt.providers.ElementTypes

class childContainerCreateCommand {
	
	@Inject extension Common;
	
	@Inject ElementTypes xptElementTypes;
 
 	def childContainerCreateCommand(Iterable<? extends GenNode> nodes) '''
	«IF !nodes.empty»

	«generatedMemberComment(nodes)»
	protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
	«FOR n : nodes»		
		«childNodeCreateCommand(n)»
	«ENDFOR»
		return super.getCreateCommand(req);
	}
	«ENDIF»
	'''


	def childNodeCreateCommand(GenNode node) '''
	if («xptElementTypes.accessElementType(node)» == req.getElementType()) {
		return getGEFWrapper(new «node.createCommandQualifiedClassName»(req));
	}
	'''

}