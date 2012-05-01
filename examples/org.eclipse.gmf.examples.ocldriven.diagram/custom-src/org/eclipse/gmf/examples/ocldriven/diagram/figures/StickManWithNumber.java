package org.eclipse.gmf.examples.ocldriven.diagram.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class StickManWithNumber extends StickMan {

	private int myCounter;

	public void setCounter(int counter) {
		myCounter = counter;
	}

	@Override
	protected void outlineShape(Graphics graphics, Rectangle bounds) {
		super.outlineShape(graphics, bounds);
		graphics.drawText(String.valueOf(myCounter), bounds.getLocation());
	}

	public void setForegroundColorRGB(Integer red, Integer green, Integer blue) {
		setForegroundColor(new Color(null, red, green, blue));
	}

	public void setBackgroundRGB(Integer red, Integer green, Integer blue) {
		setBackgroundColor(new Color(null, red, green, blue));
	}
}
