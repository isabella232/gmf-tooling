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
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class AbstractSVGFigureTest extends TestCase {

	public static final String BOX_URI = "platform:/plugin/org.eclipse.gmf.tests.lite/images/box.svg";

	protected FigureCanvas canvas;

	public AbstractSVGFigureTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		Shell shell = new Shell(PlatformUI.getWorkbench().getDisplay(), SWT.NO_TRIM);
		shell.setSize(200, 200);
		StackLayout layout = new StackLayout();
		shell.setLayout(layout);
		canvas = new FigureCanvas(shell, SWT.DOUBLE_BUFFERED, new LightweightSystem() {

			@Override
			public void paint(GC gc) {
				gc.setAntialias(SWT.OFF);
				super.paint(gc);
			}
		});
		canvas.setContents(new RectangleFigure());
		canvas.getContents().setLayoutManager(new FlowLayout());
		canvas.getContents().setBackgroundColor(ColorConstants.yellow);
		canvas.getContents().setForegroundColor(ColorConstants.green);
		layout.topControl = canvas;
		shell.open();
	}

	@Override
	protected void tearDown() throws Exception {
		canvas.getShell().close();
	}

	/**
	 * Revalidates and repaints the canvas. Should be called after changes to it and before content tests.
	 */
	protected void flushCanvas() {
		canvas.getLightweightSystem().getUpdateManager().performUpdate();
	}

	/**
	 * Saves canvas screenshot in workspace root for postmortem inspection.
	 */
	protected void dumpCanvas(String filePrefix) {
		Point size = canvas.getSize();
		Image image = new Image(canvas.getDisplay(), size.x, size.y);
		try {
			GC gc = new GC(canvas);
			gc.setAntialias(SWT.OFF);
			try {
				gc.copyArea(image, 0, 0);
			} finally {
				gc.dispose();
			}
			String fileName = filePrefix + ".png";
			IPath root = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			if (root != null) {
				fileName = root.append(fileName).toString();
			}
			ImageLoader loader = new ImageLoader();
			loader.data = new ImageData[] { image.getImageData() };
			loader.save(fileName, SWT.IMAGE_PNG);
		} finally {
			image.dispose();
		}
	}

	/**
	 * Check that canvas has the specified color at the (x,y).
	 */
	protected void assertColor(int x, int y, RGB expectedColor) {
		RGB currentColor;
		Image image = new Image(canvas.getDisplay(), 1, 1);
		try {
			GC gc = new GC(canvas);
			gc.setAntialias(SWT.OFF);
			try {
				gc.copyArea(image, x, y);
			} finally {
				gc.dispose();
			}
			ImageData data = image.getImageData();
			int pixel = data.getPixel(0, 0);
			currentColor = data.palette.getRGB(pixel);
		} finally {
			image.dispose();
		}
		assertEquals(expectedColor, currentColor);
	}
}
