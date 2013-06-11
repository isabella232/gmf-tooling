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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import xpt.MetaDef

class ParserUtils_qvto {

	@MetaDef def String parserFieldName(GenCommonBase element) {
		return element.uniqueIdentifier.toFirstLower + 'Parser'
	}

	@MetaDef def String parserAccessorName(GenCommonBase element) {
		return 'get' + element.uniqueIdentifier.toFirstUpper + 'Parser'
	}

}
