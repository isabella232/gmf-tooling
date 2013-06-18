/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - [407332] common API for XXXElementTypes extracted to GMFT-runtime
 *                               - [386838] migration to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

class IconProvider {
	@Inject extension Common;

	@Inject ElementTypes xptElementTypes;

	def IconProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «providersPackageName»;
		
		«generatedClassComment»
		public class «iconProviderClassName» extends «extendsList(it)» implements «implementsList(it)» {
		
			«constructor(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.providers.DefaultElementTypeIconProvider'''

	def implementsList(GenDiagram it) '''org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider'''

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «iconProviderClassName»() {
			super(«xptElementTypes.typedInstanceCall(it)»);
		}
	'''

	def additions(GenDiagram it) ''''''

}
