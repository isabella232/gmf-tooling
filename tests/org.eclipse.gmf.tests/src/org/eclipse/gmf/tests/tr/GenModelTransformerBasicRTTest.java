/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;

public class GenModelTransformerBasicRTTest extends GenModelTransformerTest {

	public GenModelTransformerBasicRTTest(String name) {
		super(name);
	}

	protected DiagramRunTimeModelHelper getRTHelper() {
		return new BasicDiagramRunTimeModelHelper();
	}
}
