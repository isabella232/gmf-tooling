package org.eclipse.gmf.codegen.xtend.ui.handlers;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;

/**
 * Use {@link org.eclipse.gmf.codegen.util.CodegenEmittersWithXtend2}
 */
@Deprecated
public class CodegenEmittersWithXtend2 extends org.eclipse.gmf.codegen.util.CodegenEmittersWithXtend2 {

	public CodegenEmittersWithXtend2(GenEditorGenerator genModel) {
		this(!genModel.isDynamicTemplates(), genModel.getTemplateDirectory(), genModel.getModelAccess() != null);
	}

	public CodegenEmittersWithXtend2(boolean useBaseTemplatesOnly, String templateDirectory, boolean includeDynamicModelTemplates) {
		super(useBaseTemplatesOnly, templateDirectory, includeDynamicModelTemplates);
	}
}
