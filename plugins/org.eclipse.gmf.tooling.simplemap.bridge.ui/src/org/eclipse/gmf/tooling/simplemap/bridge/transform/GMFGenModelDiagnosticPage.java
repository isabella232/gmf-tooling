/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.bridge.transform;

import org.eclipse.emf.common.util.Diagnostic;

class GMFGenModelDiagnosticPage extends ModelDiagnosticPage {

	GMFGenModelDiagnosticPage(String pageName) {
		super(pageName);
		setTitle(Messages.TransformToGenModelWizard_title_gmfgendiagnostic);
		setDescription(Messages.TransformToGenModelWizard_descr_gmfgendiagnostic);
	}

	@Override
	protected boolean getIgnoreOption() {
		return getOperation().getOptions().getIgnoreGMFGenValidation();
	}

	@Override
	protected Diagnostic getValidationResult() {
		return getOperation().getGMFGenValidationResult();
	}

	@Override
	protected void setIgnoreOption(boolean ignore) {
		getOperation().getOptions().setIgnoreGMFGenValidation(ignore);
	}

}
