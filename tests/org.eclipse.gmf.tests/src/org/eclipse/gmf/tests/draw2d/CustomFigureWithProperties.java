/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.tests.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class CustomFigureWithProperties extends RectangleFigure {
	private int myInnerWidth = 20;
	
	/**
	 * Intentionally public to test CustomAttribute#isDirectAccess
	 */
	public int innerHeight = 20;  
	
	public void setInnerWidth(int innerWidth){
		myInnerWidth = innerWidth;
	}
	
	public int getInnerWidth() {
		return myInnerWidth;
	}
	
	public Color getInnerColor(){
		return isRed(getBackgroundColor()) ? ColorConstants.green : ColorConstants.red;
	}
	
	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);
		Rectangle r = getBounds();
		if (myInnerWidth > 0 && innerHeight > 0 && myInnerWidth < r.width && innerHeight < r.height){
			int innerX = r.x + (myInnerWidth - r.width) / 2;
			int innerY = r.y + (innerHeight - r.height) / 2;
			graphics.drawRectangle(innerX, innerY, myInnerWidth, innerHeight);
		}
	}
	
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		Rectangle r = getBounds();
		if (myInnerWidth > 0 && innerHeight > 0 && myInnerWidth < r.width - 2 && innerHeight < r.height - 2){
			graphics.pushState();
			graphics.setBackgroundColor(getInnerColor());
			int innerX = r.x + (myInnerWidth - r.width) / 2 + 1;
			int innerY = r.y + (innerHeight - r.height) / 2 + 1;
			graphics.fillRectangle(innerX + 1, innerY + 1, myInnerWidth - 1, innerHeight + 1);
			graphics.popState();
		}
	}
	
	private static boolean isRed(Color color){
		//do not use RGB to avoid object creation
		return color != null && color.getRed() == 255 && color.getBlue() == 0 && color.getGreen() == 0; 
	}
}
