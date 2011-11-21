/*******************************************************************************
* Copyright (c) 2011 EBM Websourcing (PetalsLink)
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Mickael Istria (EBM - PetalsLink) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.runtime.graphdef;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ScalablePolygonShape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.CustomLayout;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.Layout;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.LayoutRef;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.ScalablePolygon;
import org.eclipse.gmf.gmfgraph.Shape;
import org.eclipse.gmf.gmfgraph.StackLayout;
import org.eclipse.gmf.gmfgraph.XYLayout;
import org.eclipse.gmf.gmfgraph.XYLayoutData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * This class represents the runtime Draw2d {@link IFigure} for a given
 * .gmfgraph {@link org.eclipse.gmf.gmfgraph.Figure} description.
 * 
 * It simply interprets all given attributes to instantiate a Draw2d figure.
 * 
 * @author Mickael Istria - EBM WebSourcing
 */
public class GMFGraphRenderedFigure extends Figure {
	
	private static class ConvertedFigure {
		public IFigure figure;
		public Object layoutData;
	}

	private IFigure mainFigure;
	private List<Color> toDisposeColors = new ArrayList<Color>();
	private List<Font> toDisposeFonts = new ArrayList<Font>();
	
	public GMFGraphRenderedFigure(org.eclipse.gmf.gmfgraph.Figure figureDef) {
		setLayoutManager(new GridLayout(1, false));
		ConvertedFigure res = toDraw2d(figureDef); 
		mainFigure = res.figure;
		GridData gridData = new GridData();
		gridData.widthHint = mainFigure.getPreferredSize().width;
		gridData.heightHint = mainFigure.getPreferredSize().height;
		add(mainFigure, gridData);
	}
	
	@Override
	public void erase() {
		for (Color color : toDisposeColors) {
			color.dispose();
		}
		for (Font font : toDisposeFonts) {
			font.dispose();
		}
		super.erase();
	}

	private ConvertedFigure toDraw2d(org.eclipse.gmf.gmfgraph.Figure figureDef) {
		IFigure figure = null;
		Object layoutData = null;
		// Create Figure
		if (figureDef instanceof FigureRef) {
			ConvertedFigure converted = toDraw2d(((FigureRef)figureDef).getFigure());
			figure = converted.figure;
			layoutData = converted.layoutData;
		} else if (figureDef instanceof org.eclipse.gmf.gmfgraph.Ellipse) {
			figure = new Ellipse();
		} else if (figureDef instanceof org.eclipse.gmf.gmfgraph.Rectangle) {
			figure = new RectangleFigure();
		} else if (figureDef instanceof RoundedRectangle) {
			figure = new org.eclipse.draw2d.RoundedRectangle();
		} else if (figureDef instanceof PolygonDecoration) {
			figure = new org.eclipse.draw2d.PolygonDecoration();
		} else if (figureDef instanceof ScalablePolygon) {
			figure = new ScalablePolygonShape();
		} else if (figureDef instanceof org.eclipse.gmf.gmfgraph.Polygon) {
			figure = new org.eclipse.draw2d.Polygon();
		} else if (figureDef instanceof PolylineDecoration) {
			figure = new PolylineDecoration();
		} else if (figureDef instanceof PolylineConnection) {
			figure = new org.eclipse.draw2d.PolylineConnection();
		} else if (figureDef instanceof org.eclipse.gmf.gmfgraph.Polyline) {
			figure = new Polyline();
		} else {
			// TODO connections, label, decoration, custom...
			// all other concrete types for a Figure
		}
		
		if (figureDef.getLayoutData() != null) {
			layoutData = toDraw2d(figureDef.getLayoutData());
		}
		
		populate(figureDef, figure);
		
		ConvertedFigure res = new ConvertedFigure();
		res.figure = figure;
		res.layoutData = layoutData;
		return res;
	}

	private void populate(org.eclipse.gmf.gmfgraph.Figure figureDef, IFigure figure) {
		// populate children and attrs
		if (figureDef.getBackgroundColor() != null) {
			figure.setBackgroundColor(toDraw2d(figureDef.getBackgroundColor()));
		}
		if (figureDef.getBorder() != null) {
			figure.setBorder(toDraw2d(figureDef.getBorder()));
		}
		if (figureDef.getFont() != null) {
			figure.setFont(toDraw2d(figureDef.getFont()));
		}
		if (figureDef.getForegroundColor() != null) {
			figure.setForegroundColor(toDraw2d(figureDef.getForegroundColor()));
		}
		if (figureDef.getInsets() != null) {
			// TODO
		}
		if (figureDef.getLayout() != null) {
			figure.setLayoutManager(toDraw2d(figureDef.getLayout()));
		}
		if (figureDef.getLocation() != null) {
			figure.setLocation(toDraw2d(figureDef.getLocation()));
		}
		if (figureDef.getMaximumSize() != null) {
			figure.setMaximumSize(toDraw2d(figureDef.getMaximumSize()));
		}
		if (figureDef.getMinimumSize() != null) {
			figure.setMinimumSize(toDraw2d(figureDef.getMinimumSize()));
		}
		if (figureDef.getPreferredSize() != null) {
			figure.setPreferredSize(toDraw2d(figureDef.getPreferredSize()));
		}
		if (figureDef.getSize() != null) {
			figure.setSize(toDraw2dDimension(figureDef.getSize()));
		}
		
		if (figureDef instanceof Shape) {
			Shape shapeDef = (Shape)figureDef;
			org.eclipse.draw2d.Shape shape = (org.eclipse.draw2d.Shape) figure;
			shape.setFill(shapeDef.isFill());
			shape.setOutline(shapeDef.isOutline());
			shape.setXOR(shapeDef.isXorFill());
			shape.setLineStyle(toDraw2d(shapeDef.getLineKind()));
			shape.setLineWidth(shapeDef.getLineWidth());
		}
		
		if (figureDef instanceof RealFigure) {
			for (EObject child : ((RealFigure)figureDef).getChildren()) {
				if (child instanceof org.eclipse.gmf.gmfgraph.Figure) {
					ConvertedFigure converted = toDraw2d((org.eclipse.gmf.gmfgraph.Figure)child);
					figure.add(converted.figure, converted.layoutData);
				}
			}
		}
		
		if (figureDef instanceof RoundedRectangle) {
			RoundedRectangle rectangleDef = (RoundedRectangle)figureDef;
			((org.eclipse.draw2d.RoundedRectangle)figure).setCornerDimensions(new Dimension(rectangleDef.getCornerWidth(), rectangleDef.getCornerHeight()));
		}
		
		if (figureDef instanceof org.eclipse.gmf.gmfgraph.Polyline) {
			org.eclipse.gmf.gmfgraph.Polyline polylineDef = (org.eclipse.gmf.gmfgraph.Polyline)figureDef;
			for (Point point : polylineDef.getTemplate()) {
				((Polyline)figure).addPoint(toDraw2d(point));
			}
		}
	}
	
	

	////////////////
	// Converters //
	////////////////
	
	private int toDraw2d(LineKind lineKind) {
		switch (lineKind) {
			case LINE_CUSTOM_LITERAL: return SWT.LINE_CUSTOM;
			case LINE_DASH_LITERAL: return SWT.LINE_DASH;
			case LINE_DASHDOT_LITERAL: return SWT.LINE_DASHDOT;
			case LINE_DASHDOTDOT_LITERAL: return SWT.LINE_DASHDOTDOT;
			case LINE_DOT_LITERAL: return SWT.LINE_DOT;
			case LINE_SOLID_LITERAL: return SWT.LINE_SOLID;
		};
		return SWT.DEFAULT;
	}

	private LayoutManager toDraw2d(Layout layout) {
		if (layout instanceof LayoutRef) {
			return toDraw2d(((LayoutRef) layout).getActual());
		} else if (layout instanceof org.eclipse.gmf.gmfgraph.BorderLayout) {
			org.eclipse.gmf.gmfgraph.BorderLayout layoutDef = (org.eclipse.gmf.gmfgraph.BorderLayout)layout;
			BorderLayout res = new BorderLayout();
			res.setHorizontalSpacing(layoutDef.getSpacing().getDx());
			res.setVerticalSpacing(layoutDef.getSpacing().getDy());
			return res;
		} else if (layout instanceof CustomLayout) {
			((CustomLayout) layout).getQualifiedClassName();
			return null;
		} else if (layout instanceof FlowLayout) {
			FlowLayout layoutDef = (FlowLayout)layout;
			org.eclipse.draw2d.FlowLayout res = new org.eclipse.draw2d.FlowLayout();
			res.setHorizontal(!layoutDef.isVertical());
			res.setMajorAlignment(toDraw2d(layoutDef.getMajorAlignment()));
			res.setMinorAlignment(toDraw2d(layoutDef.getMinorAlignment()));
			res.setMajorSpacing(layoutDef.getMajorSpacing());
			res.setMinorAlignment(layoutDef.getMinorSpacing());
			return res;
		} else if (layout instanceof org.eclipse.gmf.gmfgraph.GridLayout) {
			org.eclipse.gmf.gmfgraph.GridLayout layoutDef = (org.eclipse.gmf.gmfgraph.GridLayout) layout;
			GridLayout res = new GridLayout();
			if (layoutDef.getSpacing() != null) {
				res.horizontalSpacing = layoutDef.getSpacing().getDx();
				res.verticalSpacing = layoutDef.getSpacing().getDy();
			}
			if (layoutDef.getMargins() != null) {
				res.marginHeight = layoutDef.getMargins().getDy();
				res.marginWidth = layoutDef.getMargins().getDx();
			}
			res.makeColumnsEqualWidth = layoutDef.isEqualWidth();
			res.numColumns = layoutDef.getNumColumns();
			return res;
		} else if (layout instanceof StackLayout) {
			return new org.eclipse.draw2d.StackLayout();
		} else if (layout instanceof XYLayout) {
			return new org.eclipse.draw2d.XYLayout();
		}
		return null;
	}

	private int toDraw2d(Alignment majorAlignment) {
		switch (majorAlignment) {
		case BEGINNING_LITERAL: return SWT.BEGINNING;
		case END_LITERAL: return SWT.END;
		case CENTER_LITERAL: return SWT.CENTER;
		case FILL_LITERAL: return SWT.FILL;
		}
		return SWT.DEFAULT;
	}

	private Font toDraw2d(org.eclipse.gmf.gmfgraph.Font font) {
		Font res = new Font(Display.getDefault(), new FontData(font.toString()));
		toDisposeFonts.add(res);
		return res;
	}
	
	private Border toDraw2d(org.eclipse.gmf.gmfgraph.Border border) {
		// TODO
		return null;
	}

	private Color toDraw2d(org.eclipse.gmf.gmfgraph.Color colorDef) {
		if (colorDef instanceof ConstantColor) {
			switch (((ConstantColor) colorDef).getValue()) {
			case BLACK_LITERAL: return ColorConstants.black;
			case BLUE_LITERAL: return ColorConstants.blue;
			case CYAN_LITERAL: return ColorConstants.cyan;
			case DARK_BLUE_LITERAL: return ColorConstants.darkBlue;
			case DARK_GRAY_LITERAL: return ColorConstants.darkGray;
			case DARK_GREEN_LITERAL: return ColorConstants.darkGreen;
			case GRAY_LITERAL: return ColorConstants.gray;
			case GREEN_LITERAL: return ColorConstants.green;
			case LIGHT_BLUE_LITERAL: return ColorConstants.lightBlue;
			case LIGHT_GRAY_LITERAL: return ColorConstants.lightGray;
			case LIGHT_GREEN_LITERAL: return ColorConstants.lightGreen;
			case ORANGE_LITERAL: return ColorConstants.orange;
			case RED_LITERAL: return ColorConstants.red;
			case WHITE_LITERAL: return ColorConstants.white;
			case YELLOW_LITERAL: return ColorConstants.yellow;
			default:
				return null;
			}
		} else if (colorDef instanceof RGBColor) {
			RGBColor rgbColorDef = (RGBColor)colorDef;
			RGB rgb = new RGB(rgbColorDef.getBlue(), rgbColorDef.getGreen(), rgbColorDef.getRed());
			Color res = new Color(Display.getDefault(), rgb);
			toDisposeColors.add(res);
			return res;
		}
		return null;
	}

	private Object toDraw2d(LayoutData layoutData) {
		if (layoutData instanceof XYLayoutData) {
			XYLayoutData xyLayoutData = (XYLayoutData)layoutData;
			Rectangle res = new Rectangle();
			res.setSize(toDraw2d(xyLayoutData.getSize()));
			res.setLocation(toDraw2d(xyLayoutData.getTopLeft()));
			return res;
		} else if (layoutData instanceof GridLayoutData) {
			GridLayoutData gridLayoutData = (GridLayoutData) layoutData;
			GridData res = new GridData();
			res.grabExcessHorizontalSpace = gridLayoutData.isGrabExcessHorizontalSpace();
			res.grabExcessVerticalSpace = gridLayoutData.isGrabExcessVerticalSpace();
			res.heightHint = gridLayoutData.getSizeHint().getDx();
			res.widthHint = gridLayoutData.getSizeHint().getDy();
			res.horizontalAlignment = toDraw2d(gridLayoutData.getHorizontalAlignment());
			res.verticalAlignment = toDraw2d(((GridLayoutData) layoutData).getVerticalAlignment());
			res.horizontalIndent = gridLayoutData.getHorizontalIndent();
			res.horizontalSpan = gridLayoutData.getHorizontalSpan();
			res.verticalSpan = gridLayoutData.getVerticalSpan();
			return res;
		} else {
			// TODO: Border and Custom NOT SUPPORTED
			return null;
		}
	}

	private org.eclipse.draw2d.geometry.Point toDraw2d(Point point) {
		return new org.eclipse.draw2d.geometry.Point(point.getX(), point.getY());
	}

	private Dimension toDraw2dDimension(Point point) {
		return new Dimension(point.getX(), point.getY());
	}
	
	private Dimension toDraw2d(org.eclipse.gmf.gmfgraph.Dimension size) {
		return new Dimension(size.getDx(), size.getDy());
	}
}
