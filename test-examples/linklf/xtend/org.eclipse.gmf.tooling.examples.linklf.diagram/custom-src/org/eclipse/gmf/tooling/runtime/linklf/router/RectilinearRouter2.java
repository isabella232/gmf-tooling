package org.eclipse.gmf.tooling.runtime.linklf.router;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;

/**
 * Right now extending {@link RectilinearRouter} does not make sense, because all 
 * of the methods of interest are private there.
 * <p/>
 * We, however, have extracted this class to at least formally note the copy paste 
 * and distinguish it from copy-paste-with-modifications which are intended to be 
 * placed into subclasses.
 * <p/>
 * All of the methods in this class are just the copy-pasted versions of their 
 * private counterparts in {@link RectilinearRouter}, without any changes.
 */
public class RectilinearRouter2 extends RectilinearRouter {

	/**
	 * [GMFRT] make protected in {@link RectilinearRouter} 
	 * <p/>
	 * Iterates through points of a polyline and does the following:
	 * if 3 points lie on the same line the middle point is removed
	 * 
	 * @param line polyline's points
	 */
	@Deprecated
	public static boolean removeRedundantPoints2(PointList line) {
		int initialNumberOfPoints = line.size();
		if (line.size() > 2) {
			PointList newLine = new PointList(line.size());
			newLine.addPoint(line.removePoint(0));
			while (line.size() >= 2) {
				Point p0 = newLine.getLastPoint();
				Point p1 = line.getPoint(0);
				Point p2 = line.getPoint(1);
				if (p0.x == p1.x && p0.x == p2.x) {
					// Have two vertical segments in a row
					// get rid of the point between
					line.removePoint(0);
				} else if (p0.y == p1.y && p0.y == p2.y) {
					// Have two horizontal segments in a row
					// get rid of the point between
					line.removePoint(0);
				} else {
					newLine.addPoint(line.removePoint(0));
				}
			}
			while (line.size() > 0) {
				newLine.addPoint(line.removePoint(0));
			}
			line.removeAllPoints();
			line.addAll(newLine);
		}
		return line.size() != initialNumberOfPoints;
	}

	/**
	 * [GMFRT] make protected in {@link RectilinearRouter}
	 * <p/> 
	 * Calculates geographic position of a point located outside the given rectangle relative
	 * to the rectangle 
	 * 
	 * @param p point outside of rectangle
	 * @param r the rectangle
	 * @return geographic position of the point relative to the recatangle
	 */
	@Deprecated
	protected static int getOutisePointOffRectanglePosition2(Point p, Rectangle r) {
		int position = PositionConstants.NONE;
		if (r.x > p.x) {
			position |= PositionConstants.WEST;
		} else if (r.x + r.width < p.x) {
			position |= PositionConstants.EAST;
		}
		if (r.y > p.y) {
			position |= PositionConstants.NORTH;
		} else if (r.y + r.height < p.y) {
			position |= PositionConstants.SOUTH;
		}
		return position;
	}

	/**
	 * [GMFRT] make protected in {@link RectilinearRouter}
	 * <p/>
	 * Determines whether the rectilinear line segment coming out of the shape should be
	 * horizontal or vertical based on the anchor geographic position relative to the shape 
	 * 
	 * @param anchorRelativeLocation
	 * @return
	 */
	@Deprecated
	protected static int getOffShapeDirection2(int anchorRelativeLocation) {
		if (anchorRelativeLocation == PositionConstants.EAST || anchorRelativeLocation == PositionConstants.WEST) {
			return PositionConstants.HORIZONTAL;
		} else if (anchorRelativeLocation == PositionConstants.NORTH || anchorRelativeLocation == PositionConstants.SOUTH) {
			return PositionConstants.VERTICAL;
		}
		return PositionConstants.NONE;
	}

	/**
	 * [GMFRT] make protected in {@link RectilinearRouter}
	 * <p/>
	 * Returns a translation dimension for the anchor point. Translation dimension
	 * translates the anchor point off the shape. The off shape direction
	 * is specified by the relative to the shape geographic position of the anchor  
	 * 
	 * @param position relative to the shape geographic position of the anchor
	 * @param xFactorValue translation value along x-axis
	 * @param yFactorValue translation value along y-axis
	 * @return
	 */
	@Deprecated
	protected static Dimension getTranslationValue2(int position, int xFactorValue, int yFactorValue) {
		Dimension translationDimension = new Dimension();
		if (position == PositionConstants.EAST) {
			translationDimension.width = xFactorValue;
		} else if (position == PositionConstants.SOUTH) {
			translationDimension.height = yFactorValue;
		} else if (position == PositionConstants.WEST) {
			translationDimension.width = -xFactorValue;
		} else if (position == PositionConstants.NORTH) {
			translationDimension.height = -yFactorValue;
		}
		return translationDimension;
	}

	@Override
	public void routeLine(Connection conn, int nestedRoutingDepth, PointList newLine) {
		super.routeLine(conn, nestedRoutingDepth, newLine);
	}

}