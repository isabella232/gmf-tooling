/**
 * Copyright (c) 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.actions

import com.google.inject.Inject
import xpt.Common
import xpt.Common_qvto

class LoadResourceAction {

	@Inject extension Common;
	@Inject extension Common_qvto;

	def Main(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) '''
		«copyright(it.owner.editorGen)»
		package «withoutLastSegment(it.qualifiedClassName)»;
		
		«generatedClassComment(it)»
		public class «lastSegment(it.qualifiedClassName)» «extendsList(it)» «implementsList(it)» {
			«executeMethod(it)»
			«additions(it)»
		}
	'''

	def extendsList(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) //
	''' extends org.eclipse.gmf.tooling.runtime.actions.DefaultLoadResourceAction'''

	def implementsList(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) //
	''''''

	def executeMethod(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) '''
		«generatedMemberComment(it)»
		public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
			return super.execute(event);
		}
	'''

	def additions(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) ''''''

}
