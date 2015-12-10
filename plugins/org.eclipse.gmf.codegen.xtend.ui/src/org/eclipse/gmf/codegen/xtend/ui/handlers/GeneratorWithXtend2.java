package org.eclipse.gmf.codegen.xtend.ui.handlers;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.internal.common.codegen.CodeFormatterFactory;

/**
 * Use {@link org.eclipse.gmf.codegen.util.GeneratorWithXtend2}
 */
@Deprecated
public class GeneratorWithXtend2 extends org.eclipse.gmf.codegen.util.GeneratorWithXtend2 {

	public GeneratorWithXtend2(GenEditorGenerator genModel) {
		super(genModel, new CodegenEmittersWithXtend2(genModel));
	}

	public GeneratorWithXtend2(GenEditorGenerator genModel, CodegenEmittersWithXtend2 codegenEmitters) {
		super(genModel, codegenEmitters, CodeFormatterFactory.DEFAULT);
	}

	public GeneratorWithXtend2(GenEditorGenerator genModel, CodegenEmittersWithXtend2 codegenEmitters, CodeFormatterFactory codeFormatterFactory) {
		super(genModel, codegenEmitters, codeFormatterFactory);
	}

}
