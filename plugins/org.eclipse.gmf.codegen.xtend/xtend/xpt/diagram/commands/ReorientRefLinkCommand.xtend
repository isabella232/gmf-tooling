/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.commands

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenLink
import xpt.Common

class ReorientRefLinkCommand {
	@Inject extension Common;
	@Inject ReorientLinkUtils xptReorientLinkUtils;

	def className(GenLink it) '''«it.reorientCommandClassName»'''

	def packageName(GenLink it) '''«it.diagram.editCommandsPackageName»'''

	def qualifiedClassName(GenLink it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenLink it) '''«qualifiedClassName(it)»'''

	def ReorientRefLinkCommand(GenLink it) ''' 
«copyright(it.diagram.editorGen)»
package «packageName(it)»;

«generatedClassComment(it)»
public class «className(it)» extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {

	«generatedMemberComment(it)»
	private final int reorientDirection;

	«generatedMemberComment(it)»
	private final org.eclipse.emf.ecore.EObject referenceOwner;

	«generatedMemberComment(it)»
	private final org.eclipse.emf.ecore.EObject oldEnd;

	«generatedMemberComment(it)»
	private final org.eclipse.emf.ecore.EObject newEnd;

	«generatedMemberComment(it)»
	public «className(it)»(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}
	
	«xptReorientLinkUtils.canReorient(it.modelFacet, it)»
	«xptReorientLinkUtils.reorient(it.modelFacet)»
	«xptReorientLinkUtils.accessors(it)»
	
	«additions(it)»
}
'''
	
	def additions(GenLink it) ''''''
	
}
