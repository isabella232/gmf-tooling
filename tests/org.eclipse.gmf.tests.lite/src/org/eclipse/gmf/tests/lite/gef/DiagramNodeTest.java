/*
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gef;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.codegen.gmfgen.GenColor;
import org.eclipse.gmf.codegen.gmfgen.GenCustomFont;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramPreferences;
import org.eclipse.gmf.codegen.gmfgen.GenFont;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenRGBColor;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.tests.lite.gen.LiteGeneratorConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;


public class DiagramNodeTest extends org.eclipse.gmf.tests.gef.DiagramNodeTest {
	public DiagramNodeTest(String name) {
		super(name, new LiteGeneratorConfiguration());
	}

	public void testPreferences() throws Exception {
		GenDiagramPreferences preferences = getSetup().getGenModel().getGenDiagram().getPreferences();
		assertNotNull("Wrong setup: null preferences", preferences);

		GenNode genNode = getSetup().getGenModel().getNodeA();
		assertTrue("Incorrect Setup: passed node has no labels", genNode.getLabels().size() > 0);

		Node nodeA = createTopNode(genNode);
		assertNotNull("Notation model Node was not created", nodeA);
		checkStyle(nodeA, NotationPackage.eINSTANCE.getFillStyle_FillColor(), preferences.getFillColor());
		checkStyle(nodeA, NotationPackage.eINSTANCE.getLineStyle_LineColor(), preferences.getLineColor());

		Node label = (Node) findChildView(nodeA, genNode.getLabels().get(0));
		assertNotNull("Child label not created", label);
		checkStyle(nodeA, NotationPackage.eINSTANCE.getFontStyle_FontColor(), preferences.getFontColor());
		checkFontStyle(nodeA, preferences.getDefaultFont());

		GraphicalEditPart editPartA = (GraphicalEditPart) findEditPart(nodeA);
		assertNotNull(editPartA);
		checkFigureColor(editPartA.getFigure().getBackgroundColor(), NotationPackage.eINSTANCE.getFillStyle_FillColor(), preferences.getFillColor());
		checkFigureColor(editPartA.getFigure().getForegroundColor(), NotationPackage.eINSTANCE.getLineStyle_LineColor(), preferences.getLineColor());

		GraphicalEditPart editPartLabel = (GraphicalEditPart) findEditPart(label);
		assertNotNull(editPartLabel);
		checkFigureColor(editPartLabel.getFigure().getForegroundColor(), NotationPackage.eINSTANCE.getFontStyle_FontColor(), preferences.getFontColor());
		checkFigureFont(editPartLabel.getFigure().getFont(), preferences.getDefaultFont());
	}

	private void checkStyle(Node node, EAttribute attribute, GenColor genColor) {
		Style style = node.getStyle(attribute.getEContainingClass());
		assertNotNull(style);
		int color = (Integer) style.eGet(attribute);
		int red = color & 0x000000FF;
		int green = (color & 0x0000FF00) >> 8;
		int blue = (color & 0x00FF0000) >> 16;
		assertTrue("Wrong setup: genColor is expected to be GenRGBColor", genColor instanceof GenRGBColor);
		GenRGBColor rgbColor = (GenRGBColor) genColor;
		assertEquals("Wrong " + attribute.getName() + " color", rgbColor.getRed(), red);
		assertEquals("Wrong " + attribute.getName() + " color", rgbColor.getGreen(), green);
		assertEquals("Wrong " + attribute.getName() + " color", rgbColor.getBlue(), blue);
	}

	private void checkFontStyle(Node label, GenFont defaultFont) {
		assertTrue("Wrong setup: font is expected to be GenCustomFont", defaultFont instanceof GenCustomFont);
		GenCustomFont font = (GenCustomFont) defaultFont;
		FontStyle fontStyle = (FontStyle) label.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		assertNotNull(fontStyle);
		assertEquals(font.getName(), fontStyle.getFontName());
		assertEquals(font.getHeight(), fontStyle.getFontHeight());
		switch (font.getStyle()) {
		case BOLD_LITERAL:
			assertTrue(fontStyle.isBold());
			assertFalse(fontStyle.isItalic());
			break;
		case NORMAL_LITERAL:
			assertFalse(fontStyle.isBold());
			assertFalse(fontStyle.isItalic());
			break;
		case ITALIC_LITERAL:
			assertFalse(fontStyle.isBold());
			assertTrue(fontStyle.isItalic());
			break;
		default:
			fail();
			break;
		}
	}

	private void checkFigureColor(Color figureColor, EAttribute attribute, GenColor genColor) {
		assertNotNull(figureColor);
		assertTrue("Wrong setup: genColor is expected to be GenRGBColor", genColor instanceof GenRGBColor);
		GenRGBColor rgbColor = (GenRGBColor) genColor;
		assertEquals("Wrong " + attribute.getName() + " color", rgbColor.getRed(), figureColor.getRed());
		assertEquals("Wrong " + attribute.getName() + " color", rgbColor.getGreen(), figureColor.getGreen());
		assertEquals("Wrong " + attribute.getName() + " color", rgbColor.getBlue(), figureColor.getBlue());
	}

	private void checkFigureFont(Font font, GenFont defaultFont) {
		assertTrue("Wrong setup: font is expected to be GenRGBColor", defaultFont instanceof GenCustomFont);
		GenCustomFont customFont = (GenCustomFont) defaultFont;
		FontData main = font.getFontData()[0];
		assertEquals(customFont.getName(), main.getName());
		assertEquals(customFont.getHeight(), main.getHeight());
		switch (customFont.getStyle()) {
		case BOLD_LITERAL:
			assertEquals(SWT.BOLD, main.getStyle());
			break;
		case NORMAL_LITERAL:
			assertEquals(SWT.NORMAL, main.getStyle());
			break;
		case ITALIC_LITERAL:
			assertEquals(SWT.ITALIC, main.getStyle());
			break;
		default:
			fail();
			break;
		}
	}
}
