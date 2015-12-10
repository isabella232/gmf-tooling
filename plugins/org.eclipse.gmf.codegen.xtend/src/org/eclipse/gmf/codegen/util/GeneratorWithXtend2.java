package org.eclipse.gmf.codegen.util;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.util.Generator;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.CodeFormatterFactory;

public class GeneratorWithXtend2 extends Generator {

	private CodegenEmittersWithXtend2 myEmitters;

	public GeneratorWithXtend2(GenEditorGenerator genModel) {
		this(genModel, new CodegenEmittersWithXtend2(genModel));
	}

	public GeneratorWithXtend2(GenEditorGenerator genModel, CodegenEmittersWithXtend2 codegenEmitters) {
		this(genModel, codegenEmitters, CodeFormatterFactory.DEFAULT);
	}

	public GeneratorWithXtend2(GenEditorGenerator genModel, CodegenEmittersWithXtend2 codegenEmitters, CodeFormatterFactory codeFormatterFactory) {
		super(genModel, codegenEmitters, codeFormatterFactory);
		myEmitters = codegenEmitters;
	}

	protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
		try {
			super.customRun();
		} finally {
			hookGenerationCompleted();
		}
	}

	protected CodegenEmittersWithXtend2 getEmitters() {
		return myEmitters;
	}

	protected void hookGenerationCompleted() {
		myEmitters.disposeEmitters();
	}

}
