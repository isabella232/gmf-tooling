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

	def className(GenDiagram it) '''«it.iconProviderClassName»'''

	def packageName(GenDiagram it) '''«it.providersPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def IconProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» extends «extendsList(it)» {
			
			«constructor(it)»
			
			«additions(it)»
		}
	'''

	def extendsList(GenDiagram it) '''org.eclipse.gmf.tooling.runtime.providers.DefaultElementTypeIconProvider'''

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «className(it)»() {
			super(«xptElementTypes.typedInstanceCall(it)»);
		}
	'''

	def additions(GenDiagram it) ''''''
}
