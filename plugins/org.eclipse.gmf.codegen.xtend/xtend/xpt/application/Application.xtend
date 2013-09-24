/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.application

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenApplication
import xpt.Common
import xpt.QualifiedClassNameProvider

class Application {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;

	def className(GenApplication it) '''«it.actionBarAdvisorClassName»'''

	def packageName(GenApplication it) '''«it.packageName»'''

	def qualifiedClassName(GenApplication it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenApplication it) '''«qualifiedClassName(it)»'''

	def Application(GenApplication it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» implements org.eclipse.equinox.app.IApplication {
			
			«run(it)»
			
			«generatedMemberComment»
			public void stop() {
			}
			
			«additions(it)»
		}
	'''

	def run(GenApplication it) '''
		
		«generatedMemberComment»
		public Object start(org.eclipse.equinox.app.IApplicationContext context) throws Exception {
			org.eclipse.swt.widgets.Display display = org.eclipse.ui.PlatformUI.createDisplay();
			try {
				int returnCode = org.eclipse.ui.PlatformUI.createAndRunWorkbench(display,
					new «getWorkbenchAdvisorQualifiedClassName(it)»());
				if (returnCode == org.eclipse.ui.PlatformUI.RETURN_RESTART) {
					return org.eclipse.equinox.app.IApplication.EXIT_RESTART;
				}
				return org.eclipse.equinox.app.IApplication.EXIT_OK;
			} finally {
				display.dispose();
			}
		}
	'''

	def additions(GenApplication it) ''''''

}
