/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.setup;

import org.eclipse.gmf.codegen.gmfgen.FontStyle;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCustomFont;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramPreferences;
import org.eclipse.gmf.codegen.gmfgen.GenRGBColor;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.lite.gen.LiteGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.DiaGenSetup;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class LiteSessionSetup extends SessionSetup {
	protected LiteSessionSetup(GeneratorConfiguration genConfig) {
		super(genConfig);
	}

	public static SessionSetup getInstance() {
		if (factoryClosed) {
			return null;
		}
		return new LiteSessionSetup(new LiteGeneratorConfiguration());
	}

	protected DiaGenSource createGenModel() {
		final InnerClassViewmapProducer viewmapProducer = new InnerClassViewmapProducer("lite", MapModeCodeGenStrategy.STATIC, null);
		DiaGenSource result = new DiaGenSetup(viewmapProducer).init(getMapModel());
		GenDiagramPreferences preferences = GMFGenFactory.eINSTANCE.createGenDiagramPreferences();
		GenCustomFont font = GMFGenFactory.eINSTANCE.createGenCustomFont();
		font.setHeight(9);
		font.setStyle(FontStyle.ITALIC_LITERAL);
		FontData[] availableFonts = Display.getDefault().getFontList(null, true);
		if (availableFonts == null || availableFonts.length == 0) {
			font.setName(NotationPackage.eINSTANCE.getFontStyle_FontName().getDefaultValueLiteral());
		} else {
			font.setName(availableFonts[(int) (Math.random() * availableFonts.length)].getName());
		}
		preferences.setDefaultFont(font);
		preferences.setFillColor(createRandomColor());
		preferences.setFontColor(createRandomColor());
		preferences.setLineColor(createRandomColor());
		result.getGenDiagram().setPreferences(preferences);
		return result;
	}

	private GenRGBColor createRandomColor() {
		GenRGBColor result = GMFGenFactory.eINSTANCE.createGenRGBColor();
		result.setBlue((int)(Math.random()*255));
		result.setRed((int)(Math.random()*255));
		result.setGreen((int)(Math.random()*255));
		return result;
	}
}
