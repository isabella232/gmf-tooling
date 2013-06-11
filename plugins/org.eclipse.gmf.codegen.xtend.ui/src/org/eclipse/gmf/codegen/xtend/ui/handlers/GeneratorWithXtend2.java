package org.eclipse.gmf.codegen.xtend.ui.handlers;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.util.Generator;

public class GeneratorWithXtend2 extends Generator {

	public GeneratorWithXtend2(GenEditorGenerator genModel) {
		super(genModel, new CodegenEmittersWithXtend2(!genModel.isDynamicTemplates(), genModel.getTemplateDirectory(), genModel.getModelAccess() != null));
	}
	
}
