/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import org.eclipse.gmf.common.codegen.NullImportAssistant;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;

/**
 * TODO generate project, compile and instaniate figures to make sure values are set (like figure's bg/fg color)
 * @author artem
 */
public class FigureCodegenTest extends FigureCodegenTestBase {
	public FigureCodegenTest(String name) {
		super(name);
	}

	public void testGenPolylineConnection() {
		performTests(ecoreContainmentRef());
	}

	public void testGenCustomFigure() {
		performTests(figure1());
	}

	public void testGenSimpleShape() {
		performTests(figure2());
	}

	public void testGenComplexShape() {
		performTests(figure3());
	}

	public void testGenFigureWithoutPackageStmt() {
		setCustomFigureGenerator(new FigureGenerator(null, new NullImportAssistant(), new RuntimeFQNSwitch()));
		testGenComplexShape();
	}

}
