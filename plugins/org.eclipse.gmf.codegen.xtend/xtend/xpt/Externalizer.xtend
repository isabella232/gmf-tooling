/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anna Karjakina (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef

class Externalizer {
	@Inject extension Common;
	@Inject extension ExternalizerUtils_qvto;

	@MetaDef def accessorCall(GenEditorGenerator it, String key) //
		'''«it.externalizerPackageName».«getExternalizerClassName()».«escapeIllegalKeySymbols(key)»'''

	@MetaDef def accessorField(String key) '''
		«generatedMemberComment»
		public static String «escapeIllegalKeySymbols(key)»;
	'''
	
	def messageEntry(String key, String message) '''
		«escapeIllegalKeySymbols(key)»=«escapeIllegalMessageSymbols(message)»
	'''
	
}
