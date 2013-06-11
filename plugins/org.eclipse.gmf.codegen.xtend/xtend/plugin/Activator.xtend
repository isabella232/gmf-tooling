/**
 * Copyright (c) 2010 Artem Tikhomirov and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (independent) - Initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package plugin

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import xpt.MetaDef

class Activator {
	
//	/**
//	 * FIXME[artem]: For 2.3, delegates to legacy xpt::plugin::Activator template.
//	 * Refactoring (moving templates out from xpt) pending.
//	 */
//	def Main(GenPlugin it) '''«xpt::plugin::Activator::Activator(it)»'''

	// access to the sole Activator instance
	@MetaDef def instanceAccess(GenEditorGenerator it)'''«it.plugin.activatorQualifiedClassName».getInstance()'''
	
}