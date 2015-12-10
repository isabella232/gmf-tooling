/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend.setup;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.util.CodegenEmittersWithXtend2;
import org.eclipse.gmf.codegen.util.GeneratorWithXtend2;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;

public class RuntimeBasedGeneratorConfigurationXtend extends org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration {

	public GeneratorBase createGenerator(GenDiagram diagram) {
		final GenEditorGenerator editorGen = diagram.getEditorGen();
		// using caching EmitterSource saves few seconds on test execution (115-118 compared to 112)
		// but it seems reasonable to avoid unpredictability of reuse (due to use of soft references)
		// and might be good idea to have separate test to test emitter reuse explicitly
		return new GeneratorWithXtend2(editorGen, new CodegenEmittersWithXtend2(!editorGen.isDynamicTemplates(), editorGen.getTemplateDirectory(), editorGen.getModelAccess() != null));
	}

}
