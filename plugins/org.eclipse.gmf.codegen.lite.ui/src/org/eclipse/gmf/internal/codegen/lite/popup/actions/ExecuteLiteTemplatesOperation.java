/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.lite.popup.actions;

import org.eclipse.gmf.internal.codegen.lite.Generator;
import org.eclipse.gmf.internal.codegen.popup.actions.ExecuteTemplatesOperation;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;

/**
 * @author dstadnik
 */
public class ExecuteLiteTemplatesOperation extends ExecuteTemplatesOperation {

	@Override
	protected GeneratorBase createGenerator() {
		return new Generator(getGenModel());
	}
}
