/**
 * Copyright (c) 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	  Michael Golubev (Montages) - [368169] extract not-generated shared code to GMF-T runtime
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.parsers

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenParsers
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import xpt.Common_qvto

/**
 * Since GMFT 3.1 we don't generate class AbstractParser into every diagram, by extending the 
 * org.eclipse.gmf.tooling.runtime.parsers.AbstractAttributeParser.
 * If you want to extend other custom implementation you may change the className and quialifiedClassName DEFINE's 
 * which are still used in the extend's clauses for generated PredefinedParser's
 * <p> 
 * However, for 3.1 release we still will generate empty file (without any java content), 
 * to ensure that the old code, including calls to non existing i18n fields in Messages is cleaned up.
 */
class AbstractParser {
	@Inject extension Common_qvto;

	@MetaDef def className(GenParsers it) '''«lastSegment(qualifiedClassName(it))»'''

	@MetaDef def String qualifiedClassName(GenParsers it) '''org.eclipse.gmf.tooling.runtime.parsers.AbstractAttributeParser'''

	def Main(GenParsers it) '''
		//Since GMFT 3.1 we don't generate class AbstractParser into every diagram, instead extend org.eclipse.gmf.tooling.runtime.parsers.AbstractAttributeParser.
	'''
}
