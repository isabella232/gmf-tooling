package org.eclipse.gmf.codegen.xtend.ui.handlers;

import org.eclipse.gmf.codegen.util.GeneratorWithXtend2;
import org.eclipse.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;

public class ExecuteTemplatesOperationWithXtend2 extends ExecuteTemplatesOperation {

	@Override
	protected GeneratorBase createGenerator() {
		return new GeneratorWithXtend2(getGenModel());
	}
}
