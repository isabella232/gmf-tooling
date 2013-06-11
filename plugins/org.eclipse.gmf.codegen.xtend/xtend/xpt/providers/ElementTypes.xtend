/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
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

class ElementTypes {

	@MetaDef static def accessElementType(GenCommonBase it) //
	'''«it.diagram.elementTypesQualifiedClassName».«it.uniqueIdentifier»'''

}
