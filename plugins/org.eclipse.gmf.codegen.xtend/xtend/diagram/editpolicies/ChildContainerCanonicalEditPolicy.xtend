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
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer
import xpt.Common

class ChildContainerCanonicalEditPolicy {
	@Inject extension Common;

	@Inject CanonicalUpdate xptCanonicalUpdate;

	def extendsList(GenChildContainer it) '''extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy'''

	def Main(GenChildContainer it) '''
		«copyright(it.diagram.editorGen)»
		package «it.diagram.editPoliciesPackageName»;
		
		«generatedClassComment»
		public class «canonicalEditPolicyClassName» «extendsList(it)» {
			«xptCanonicalUpdate.body(it)»
			
			«refreshSemanticMethod(it)»
			
			«additions(it)»
		}
	'''

	def refreshSemanticMethod(GenChildContainer it) '''
		«generatedMemberComment»
		protected void refreshSemantic() {
			if (resolveSemanticElement() == null) {
				return;
			}
			java.util.LinkedList<org.eclipse.core.runtime.IAdaptable> createdViews = new java.util.LinkedList<org.eclipse.core.runtime.IAdaptable>();
			«xptCanonicalUpdate.refreshSemanticChildren(it, 'createdViews', it.diagram.editorGen.diagramUpdater)»
			«xptCanonicalUpdate.executeLayoutCommand(it, 'createdViews')»
			
			makeViewsImmutable(createdViews);
		}
	'''

	def additions(GenChildContainer it) ''''''
}
