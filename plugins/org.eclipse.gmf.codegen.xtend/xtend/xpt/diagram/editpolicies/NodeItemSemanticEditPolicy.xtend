/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257632] do not rely on EditPart presence for element deletion
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.editpolicies

import com.google.inject.Inject
import impl.diagram.commands.DeleteLinkCommand
import java.util.List
import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.Common
import xpt.editor.VisualIDRegistry

/**
 *	This template should be called only for non-design nodes (modelFacet != null) 
 *	because *ItemSemanticEditPolicy responsible for dealing with semantic model 
 *	elements and meaningless (should not be generated) for pure design nodes.   
 */
@com.google.inject.Singleton class NodeItemSemanticEditPolicy {
	
	@Inject extension Common;
	@Inject extension Utils_qvto;
	
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;
	@Inject childContainerCreateCommand xptChildContainerCreateCommand;
	@Inject linkCommands xptLinkCommands;
	@Inject DeleteLinkCommand xptDeleteLinkCommand;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	
	def className(GenNode it) '''«it.itemSemanticEditPolicyClassName»'''

	def packageName(GenNode it) '''«it.getDiagram().editPoliciesPackageName»'''

	def qualifiedClassName(GenNode it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenNode it) '''«qualifiedClassName(it)»'''
	
	def NodeItemSemanticEditPolicy(GenNode it) '''
	«copyright(getDiagram().editorGen)»
	package «packageName(it)»;
	
	«generatedClassComment()»
	public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(getDiagram())» {
	
		«xptBaseItemSemanticEditPolicy.defaultConstructor(it)»
	
		«xptChildContainerCreateCommand.childContainerCreateCommand(it.childNodes)»
	
		«getDestroyElementCommand(it)»
		«IF hasChildrenOrCompartments(it)»
			«addDestroyChildNodesCommand(it)»
		«ENDIF»
		«xptLinkCommands.linkCommands(it)»
	
		«additions(it)»
	}
	'''

	def getDestroyElementCommand(GenNode it) '''
	«generatedMemberComment()»
	protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
		org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
		org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand cmd = new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		«destroyEdges(it, 'view')»
		org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); «nonNLS()»
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: «it.childNodes.union(compartments.map(c | c.childNodes).flatten).exists[GenChildNodeBase gcn | !isDirectlyOwned(gcn, it)]»
	«IF hasChildrenOrCompartments(it)»
			addDestroyChildNodesCommand(cmd);
	«ENDIF»
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
		} else { «/*Here, we may play smart and don't generate else for non-toplevel nodes(which can't be shortcuts). Is it worth doing?*/»
			cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}
	'''

	def addDestroyChildNodesCommand(GenNode it) '''
	«generatedMemberComment()»
	private void addDestroyChildNodesCommand(org.eclipse.gmf.runtime.common.core.command.ICompositeCommand cmd) {
		org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
		for (java.util.Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			org.eclipse.gmf.runtime.notation.Node node = (org.eclipse.gmf.runtime.notation.Node) nit.next();
			switch («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(node)) {
			«FOR cn : it.childNodes»
				«destroyChildNodes(cn, 'node', it)» 
			«ENDFOR»
			«FOR compartment : it.compartments»
			«xptVisualIDRegistry.caseVisualID(compartment)»
				for (java.util.Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					org.eclipse.gmf.runtime.notation.Node cnode = (org.eclipse.gmf.runtime.notation.Node) cit.next();
					switch («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(cnode)) {
					«FOR cn : compartment.childNodes»	
						«destroyChildNodes(cn, 'cnode', it)»
					«ENDFOR»
					}
				}
				break;
			«ENDFOR»
			}
		}
	}
	'''

	def destroyChildNodes(GenChildNodeBase it, String nodeVar, GenNode genNode) '''
	«xptVisualIDRegistry.caseVisualID(it)»
		«destroyEdges(it, nodeVar)»
		cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest(getEditingDomain(), «nodeVar».getElement(), false))); // directlyOwned: «it.isDirectlyOwned(genNode)»
		// don't need explicit deletion of «nodeVar» as parent's view deletion would clean child views as well 
		// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), «nodeVar»));
		break;
	'''

	/**
	* @param view - Notation element for the passed node
	* assumes 'cmd' to point to composite command
	*/
	def destroyEdges(GenNode it, String view) '''
	«/*
	 * 	XXX: Though semantic editpolicy is supposed to create commands that operate with semantic elements only,
	 * 	old code used to delegate child/link deletion to respective editparts, which in turn led to semantic commands
	 * 	being combined with notational commands (BaseItemSemanticEditPolicy#addDeleteViewCommand()).
	 * 	---
	 * 	Use DiagramUpdater.get[Incoming|Outgoing]View instead, to clean links that are not present on a diagram
	 * 	(but don't forget to clean corresponding Edge, if any)
	 */
	 IF !genIncomingLinks.empty»
		for (java.util.Iterator<?> it = «view».getTargetEdges().iterator(); it.hasNext();) {
			org.eclipse.gmf.runtime.notation.Edge incomingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();
		«FOR il : it.genIncomingLinks»
			if («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(incomingLink) == «VisualIDRegistry::visualID(il)») {
				«xptDeleteLinkCommand.newRequest(il, 'r', 'incomingLink')»
				cmd.add(«xptDeleteLinkCommand.newInstance(il, 'r')»);
				cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		«ENDFOR»
		}
	«ENDIF»
	«IF !genOutgoingLinks.empty»
		for (java.util.Iterator<?> it = «view».getSourceEdges().iterator(); it.hasNext();) {
			org.eclipse.gmf.runtime.notation.Edge outgoingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();
		«FOR ol : it.genOutgoingLinks»
			if («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(outgoingLink) == «VisualIDRegistry::visualID(ol)») {
				«xptDeleteLinkCommand.newRequest(ol, 'r', 'outgoingLink')»
				cmd.add(«xptDeleteLinkCommand.newInstance(ol, 'r')»);
				cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		«ENDFOR»
		}
	«ENDIF»
	'''

	def additions(GenNode it) ''''''
	
	private def static <T> Iterable<T> union(Iterable<? extends T> listA, Iterable<? extends T> listB) {
		var List<T> result = newLinkedList();
		result.addAll(listA);
		result.addAll(listB);
		return result;
	}
	
}
