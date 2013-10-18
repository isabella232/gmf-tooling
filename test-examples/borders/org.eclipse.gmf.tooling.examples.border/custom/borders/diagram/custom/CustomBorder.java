package borders.diagram.custom;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;

public class CustomBorder extends AbstractBorder {

	private static final int DEFAULT_WIDTH = 10;

	private static final Color DEFAULT_COLOR = ColorConstants.cyan;

	private static final Insets DEFAULT_INSETS = new Insets(DEFAULT_WIDTH);

	private int style = Graphics.LINE_SOLID;

	public Color getColor() {
		return DEFAULT_COLOR;
	}

	public Insets getInsets(IFigure figure) {
		return DEFAULT_INSETS;
	}

	public int getWidth() {
		return DEFAULT_WIDTH;
	}

	public boolean isOpaque() {
		return true;
	}

	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));
		if (getWidth() % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}
		tempRect.shrink(getWidth() / 2, getWidth() / 2);
		graphics.setLineWidth(getWidth());
		graphics.setLineStyle(getStyle());
		if (getColor() != null)
			graphics.setForegroundColor(getColor());
		graphics.drawRectangle(tempRect);
	}

	public int getStyle() {
		return style;
	}
}
