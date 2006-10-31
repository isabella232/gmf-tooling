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

import junit.framework.TestCase;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.tests.NeedsSetup;
import org.eclipse.gmf.tests.setup.figures.AbstractFigureGeneratorSetup;
import org.eclipse.gmf.tests.setup.figures.FigureCheck;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;

/**
 * @author artem
 */
public class FigureCodegenTestBase extends TestCase implements NeedsSetup {

	protected AbstractFigureGeneratorSetup mySessionSetup;

	public FigureCodegenTestBase(String name) {
		super(name);
	}

	public void configure(AbstractFigureGeneratorSetup sessionSetup) {
		mySessionSetup = sessionSetup;
	}

	protected void performTests(Figure f) {
		performTests(f, new GenericFigureCheck(f));
	}

	protected void performTests(Figure f, FigureCheck check) {
		FigureGeneratorUtil.generateAndParse(f);
		Class figureClass = mySessionSetup.getFigureClass(f);
		check.go(figureClass);
	}
}
