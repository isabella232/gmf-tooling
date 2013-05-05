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

import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelAction;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelWizard;

public class SimpleTransformToGenModelAction extends TransformToGenModelAction {

	@Override
	protected TransformToGenModelWizard createTransformToGenModelWizard() {
		return new SimpleTransformToGenModelWizard();
	}

}
