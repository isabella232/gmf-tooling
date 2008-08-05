package org.eclipse.gmf.tests.lite.rt.svg;

import java.awt.geom.Rectangle2D;

import junit.framework.TestCase;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.lite.svg.SVGFigure;
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

public class SVGFigureTest extends TestCase {

	protected FigureCanvas canvas;

	public SVGFigureTest() {
		super("SVGFigure");
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

	/**
	 * Check that test canvas is available.
	 */
	public void testCanvasSetup() {
		flushCanvas();
		Point size = canvas.getSize();
		assertEquals(size.x, 200);
		assertEquals(size.y, 200);
		assertColor(0, 0, ColorConstants.green.getRGB());
		assertColor(1, 1, ColorConstants.yellow.getRGB());
		assertColor(100, 100, ColorConstants.yellow.getRGB());
		assertColor(198, 198, ColorConstants.yellow.getRGB());
		assertColor(199, 199, ColorConstants.green.getRGB());
	}

	/**
	 * Check that SVGFigure loads documents.
	 */
	public void testDocumentLoading() {
		SVGFigure f = new SVGFigure();
		f.setURI("platform:/plugin/org.eclipse.gmf.tests.lite/images/box.svg");
		assertTrue(f.checkContentAvailable());
	}

	/**
	 * Check that SVGFigure renders documents.
	 */
	public void testRendering() {
		SVGFigure f = new SVGFigure();
		f.setURI("platform:/plugin/org.eclipse.gmf.tests.lite/images/box.svg");
		f.setPreferredSize(50, 50); // TODO : infer from doc; see #243051
		canvas.getContents().add(f);
		flushCanvas();
		assertColor(0, 0, new RGB(0, 0, 0));
		assertColor(1, 1, new RGB(0x66, 0x33, 0));
		assertColor(48, 48, new RGB(0x66, 0x33, 0));
		assertColor(49, 49, new RGB(0, 0, 0));
		assertColor(25, 50, ColorConstants.yellow.getRGB());
		assertColor(50, 25, ColorConstants.yellow.getRGB());
	}

	/**
	 * Check that SVGFigure respects AOI.
	 */
	public void testAreaOfInterest() {
		SVGFigure f = new SVGFigure();
		f.setURI("platform:/plugin/org.eclipse.gmf.tests.lite/images/box.svg");
		f.setAreaOfInterest(new Rectangle2D.Double(15, 15, 25, 25));
		f.setPreferredSize(25, 25);
		canvas.getContents().add(f);
		flushCanvas();
		assertColor(0, 0, new RGB(0x66, 0x33, 0));
		assertColor(5, 5, new RGB(0, 0, 0));
		assertColor(24, 24, new RGB(0x66, 0x33, 0));
		assertColor(25, 25, ColorConstants.yellow.getRGB());
		assertColor(25, 25, ColorConstants.yellow.getRGB());
	}
}
