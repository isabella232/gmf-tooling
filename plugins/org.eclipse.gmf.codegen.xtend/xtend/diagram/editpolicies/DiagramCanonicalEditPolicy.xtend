/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
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
package diagram.editpolicies

import com.google.inject.Inject
import impl.diagram.update.CanonicalUpdate
import impl.diagram.update.domain2notation
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common
import xpt.Common_qvto

class DiagramCanonicalEditPolicy {
	@Inject extension Common;
	@Inject extension Common_qvto;

	@Inject CanonicalUpdate xptCanonicalUpdate;
	@Inject domain2notation xptDomain2notation;

	def className(GenDiagram it) '''«canonicalEditPolicyClassName»'''

	def packageName(GenDiagram it) '''«editPoliciesPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy'''

	def Main(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
			«/**
			 * Perhaps, we need to supply implementation of refreshOnActivate() identical to that in CanonicalConnectionEditPolicy,
			 * if we observe troubles like in the bug 114992. Although I suspect the fact we do no check for EP being active when creating
			 * a connection implies we don't need this method.
			 */»
			«xptCanonicalUpdate.body(it)»
		
			«refreshSemanticMethod(it)»
			«refreshLinks(it)»
			«xptDomain2notation.DomainToNotationClass(it)»
			«additions(it)»
		}
	'''

	def refreshSemanticMethod(GenDiagram it) '''
		«generatedMemberComment»
		protected void refreshSemantic() {
			if (resolveSemanticElement() == null) {
				return;
			}
			java.util.LinkedList<org.eclipse.core.runtime.IAdaptable> createdViews = new java.util.LinkedList<org.eclipse.core.runtime.IAdaptable>();
			«xptCanonicalUpdate.refreshSemanticChildren(it, 'createdViews', editorGen.diagramUpdater)»
		
			«IF it.links.notEmpty»
				java.util.Collection<org.eclipse.core.runtime.IAdaptable> createdConnectionViews = refreshConnections();
			«ENDIF»
		
			«xptCanonicalUpdate.executeLayoutCommand(it, 'createdViews')»
		
			«IF it.links.notEmpty»
				createdViews.addAll(createdConnectionViews);
			«ENDIF»
		
			makeViewsImmutable(createdViews);
		}
	'''

	def refreshLinks(GenDiagram it) '''
		«IF links.notEmpty()»
			«refreshConnectionsMethod(it)»
			
			«xptCanonicalUpdate.refreshConnectionsAuxMethods(it)»
		«ENDIF»
	'''

	def refreshConnectionsMethod(GenDiagram it) '''
		«generatedMemberComment»
		private java.util.Collection<org.eclipse.core.runtime.IAdaptable> refreshConnections() {
			«xptCanonicalUpdate.refreshConnectionsBody(it)»
		}
	'''

	def additions(GenDiagram it) ''''''
}
