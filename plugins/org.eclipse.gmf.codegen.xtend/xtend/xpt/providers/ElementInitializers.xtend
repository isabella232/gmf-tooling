/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - refactored javaInitilizers not to use methods from GMFGen model
 *                               [221347] Got rid of generated interfaces 
 *                               (IObjectInitializer, IFeatureInitializer) and implementation thereof
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import xpt.MetaDef

/**
 * XXX [MG] - revisit: static vs instance methods: static to use meta-calls instance to generate methods for calls  
 */
class ElementInitializers {
	/**
	 * GenLink or GenNode 
	 */
	@MetaDef static def initMethodCall(GenCommonBase xptSelf, TypeModelFacet modelFacet, String newElementVar) '''
		«IF modelFacet.modelElementInitializer != null»
			«elementInitializersInstanceCall(xptSelf)».init_«xptSelf.uniqueIdentifier»(«newElementVar»);
		«ENDIF»
	'''

	@MetaDef private static def elementInitializersInstanceCall(GenCommonBase xptSelf) // 
		'''«xptSelf.diagram.elementInitializersPackageName».«xptSelf.diagram.elementInitializersClassName».getInstance()'''

}
