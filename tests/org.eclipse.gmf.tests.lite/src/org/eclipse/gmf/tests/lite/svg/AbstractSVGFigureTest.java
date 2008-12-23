/**
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.svg;

import junit.framework.TestCase;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class AbstractSVGFigureTest extends TestCase {

	private static final int HEIGHT = 200;
	private static final int WIDTH = 200;
	public static final String BOX_URI = "platform:/plugin/org.eclipse.gmf.tests.lite/images/box.svg";
	public static final String GROUP_URI = "platform:/plugin/org.eclipse.gmf.tests.lite/images/group.svg";

	private Image image;
	private SWTGraphics graphics;
	protected RectangleFigure parentFigure;
	private GC gc;
	private LightweightSystem lws;

	public AbstractSVGFigureTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		lws = new LightweightSystem();
		lws.getRootFigure().setSize(WIDTH, HEIGHT);
		image = new Image(Display.getDefault(), WIDTH, HEIGHT);
		gc = new GC(image);
		gc.setAntialias(SWT.OFF);
		graphics = new SWTGraphics(gc);
		parentFigure = new RectangleFigure();
		parentFigure.setLayoutManager(new FlowLayout());
		parentFigure.setBackgroundColor(ColorConstants.yellow);
		parentFigure.setForegroundColor(ColorConstants.green);
		// This line width is necessary due to the latest changes in a
		// RectangleFigure class to get paint border fully till the end of
		// figure
		parentFigure.setLineWidth(2);
		lws.getRootFigure().add(parentFigure);
	}
	
	protected IFigure getParentFigure() {
		return parentFigure;
	}

	@Override
	protected void tearDown() throws Exception {
		graphics.dispose();
		gc.dispose();
		image.dispose();
	}

	/**
	 * Revalidates and repaints the canvas. Should be called after changes to it and before content tests.
	 */
	protected void paintImage() {
		lws.getUpdateManager().performUpdate();
		lws.getRootFigure().paint(graphics);
	}

	protected final void dumpCanvas() {
		dumpCanvas("canvas" + System.currentTimeMillis());
	}

	/**
	 * Saves canvas screenshot in workspace root for postmortem inspection.
	 */
	protected void dumpCanvas(String filePrefix) {
		String fileName = filePrefix + ".png";
		IPath root = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		if (root != null) {
			fileName = root.append(fileName).toString();
		}
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] { image.getImageData() };
		loader.save(fileName, SWT.IMAGE_PNG);
	}

	/**
	 * Check that canvas has the specified color at the (x,y).
	 */
	protected void assertColor(int x, int y, RGB expectedColor) {
		ImageData data = image.getImageData();
		int pixel = data.getPixel(x, y);
		RGB currentColor = data.palette.getRGB(pixel);
		assertEquals(expectedColor, currentColor);
	}
}
