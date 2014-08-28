package org.eclipse.gmf.tooling.runtime.linklf;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;

public class SlidableSnapToGridAnchor extends SlidableAnchor {

	private EditPartViewer myGridProvider;

	public SlidableSnapToGridAnchor(NodeFigure f, PrecisionPoint p) {
		super(f, p);
	}

	public void setEditPartViewer(EditPartViewer viewer) {
		myGridProvider = viewer;
	}

	@Override
	public Point getOrthogonalLocation(Point orthoReference) {
		//		System.err.println("SlidableSnapToGridAnchor.getOrthogonalLocation(): " + orthoReference);
		//		System.err.println("\t" + this);
		//		Point ownRef = getReferencePoint();
		//		if (ownRef != null && ownRef.y > 430 && ownRef.y < 440) {
		//			System.err.println("here");
		//		}

		Point result = super.getOrthogonalLocation(orthoReference);
		return result;
	}

	private boolean myReentryLock = false;

	@Override
	public Point getLocation(Point reference) {
		//		System.err.println("SlidableSnapToGridAnchor.getLocation(): " + reference);
		//		System.err.println("\t" + this);

		Rectangle gridSpecAbs = getAbsoluteGridSpec();
		if (gridSpecAbs != null && !myReentryLock) {
			myReentryLock = true;
			try {
				double gridX = gridSpecAbs.preciseWidth();
				double gridY = gridSpecAbs.preciseWidth();
				Point gridOrigin = gridSpecAbs.getLocation();

				Point notOnGrid = super.getLocation(reference).getCopy();
				PrecisionRectangle bounds = new PrecisionRectangle(FigureUtilities.getAnchorableFigureBounds(getOwner()));
				getOwner().translateToAbsolute(bounds);

				List<Point> onVerticalGridLocs = new LinkedList<Point>();
				PrecisionPoint fakeRefAbove = new PrecisionPoint(notOnGrid);
				PrecisionPoint fakeRefBelow = new PrecisionPoint(notOnGrid);
				fakeRefAbove.setPreciseY(bounds.preciseY() - bounds.preciseHeight() / 2);
				fakeRefBelow.setPreciseY(bounds.preciseY() + bounds.preciseHeight() / 2 + bounds.preciseHeight());

				double reminderX = Math.IEEEremainder(notOnGrid.preciseX() - gridOrigin.preciseX(), gridX);
				if (reminderX < 0) {
					reminderX += gridX;
				}
				for (double nextX = notOnGrid.preciseX() - reminderX; nextX >= bounds.preciseX(); nextX -= gridX) {
					fakeRefAbove.setPreciseX(nextX);
					fakeRefBelow.setPreciseX(nextX);
					Point onGridForAboveRef = getOrthogonalLocation2(fakeRefAbove);
					Point onGridForBelowRef = getOrthogonalLocation2(fakeRefBelow);
					onVerticalGridLocs.add(onGridForAboveRef);
					if (!onGridForBelowRef.equals(onGridForAboveRef)) {
						onVerticalGridLocs.add(onGridForBelowRef);
					}
				}
				for (double nextX = gridX + notOnGrid.preciseX() - reminderX; nextX <= bounds.preciseX() + bounds.preciseWidth(); nextX += gridX) {
					fakeRefAbove.setPreciseX(nextX);
					fakeRefBelow.setPreciseX(nextX);
					Point onGridForAboveRef = getOrthogonalLocation2(fakeRefAbove);
					Point onGridForBelowRef = getOrthogonalLocation2(fakeRefBelow);
					onVerticalGridLocs.add(onGridForAboveRef);
					if (!onGridForBelowRef.equals(onGridForAboveRef)) {
						onVerticalGridLocs.add(onGridForBelowRef);
					}
				}

				List<Point> onHorizontalGridLocs = new LinkedList<Point>();
				PrecisionPoint fakeRefLeft = new PrecisionPoint(notOnGrid);
				PrecisionPoint fakeRefRight = new PrecisionPoint(notOnGrid);
				fakeRefLeft.setPreciseX(bounds.preciseX() - bounds.preciseWidth() / 2);
				fakeRefRight.setPreciseX(bounds.preciseX() + bounds.preciseWidth() + bounds.preciseWidth() / 2);
				double reminderY = Math.IEEEremainder(notOnGrid.preciseY() - gridOrigin.preciseY(), gridY);
				if (reminderY < 0) {
					reminderY += gridY;
				}
				for (double nextY = notOnGrid.preciseY() - reminderY; nextY >= bounds.preciseY(); nextY -= gridY) {
					fakeRefLeft.setPreciseY(nextY);
					fakeRefRight.setPreciseY(nextY);
					Point onGridForLeftRef = getOrthogonalLocation2(fakeRefLeft);
					Point onGridForRightRef = getOrthogonalLocation2(fakeRefRight);
					onHorizontalGridLocs.add(onGridForLeftRef);
					if (!onGridForLeftRef.equals(onGridForRightRef)) {
						onHorizontalGridLocs.add(onGridForRightRef);
					}
				}
				for (double nextY = gridY + notOnGrid.preciseY() - reminderY; nextY <= bounds.preciseY() + bounds.preciseHeight(); nextY += gridY) {
					fakeRefLeft.setPreciseY(nextY);
					fakeRefRight.setPreciseY(nextY);
					Point onGridForLeftRef = getOrthogonalLocation2(fakeRefLeft);
					Point onGridForRightRef = getOrthogonalLocation2(fakeRefRight);
					onHorizontalGridLocs.add(onGridForLeftRef);
					if (!onGridForLeftRef.equals(onGridForRightRef)) {
						onHorizontalGridLocs.add(onGridForRightRef);
					}
				}

				//System.err.println("Found: on horizontal grid: " + onHorizontalGridLocs);
				//System.err.println("Found: on vertical grid: " + onVerticalGridLocs);

				if (!onHorizontalGridLocs.isEmpty() || !onVerticalGridLocs.isEmpty()) {
					return pickClosestPointToSet(getReferencePoint(), onHorizontalGridLocs, onVerticalGridLocs);
				}
			} finally {
				myReentryLock = false;
			}
		}

		Point result = super.getLocation(reference);
		return result;
	}

	@Override
	public String toString() {
		return "SSTGA:" + "terminal: " + getTerminal() + ", terminalLoc: " + getReferencePoint() + ", box: " + getBox();
	}

	/**
	 * @deprecated copy-pasted from super class, [GMFRT] make protected
	 */
	@Deprecated
	private Point getOrthogonalLocation2(Point orthoReference) {
		PrecisionPoint ownReference = new PrecisionPoint(getReferencePoint());
		PrecisionRectangle bounds = new PrecisionRectangle(FigureUtilities.getAnchorableFigureBounds(getOwner()));
		getOwner().translateToAbsolute(bounds);
		bounds.expand(0.000001, 0.000001);
		PrecisionPoint preciseOrthoReference = new PrecisionPoint(orthoReference);
		int orientation = PositionConstants.NONE;
		if (bounds.contains(preciseOrthoReference)) {
			int side = getClosestSide2(ownReference, bounds);
			switch (side) {
			case PositionConstants.LEFT:
			case PositionConstants.RIGHT:
				ownReference.preciseY = preciseOrthoReference.preciseY();
				orientation = PositionConstants.HORIZONTAL;
				break;
			case PositionConstants.TOP:
			case PositionConstants.BOTTOM:
				ownReference.preciseX = preciseOrthoReference.preciseX();
				orientation = PositionConstants.VERTICAL;
				break;
			}
		} else if (preciseOrthoReference.preciseX >= bounds.preciseX && preciseOrthoReference.preciseX <= bounds.preciseX + bounds.preciseWidth) {
			ownReference.preciseX = preciseOrthoReference.preciseX;
			orientation = PositionConstants.VERTICAL;
		} else if (preciseOrthoReference.preciseY >= bounds.preciseY && preciseOrthoReference.preciseY <= bounds.preciseY + bounds.preciseHeight) {
			ownReference.preciseY = preciseOrthoReference.preciseY;
			orientation = PositionConstants.HORIZONTAL;
		}
		ownReference.updateInts();

		Point location = getLocation(ownReference, preciseOrthoReference);
		if (location == null) {
			location = getLocation(orthoReference);
			orientation = PositionConstants.NONE;
		}

		if (orientation != PositionConstants.NONE) {
			PrecisionPoint loc = new PrecisionPoint(location);
			if (orientation == PositionConstants.VERTICAL) {
				loc.preciseX = preciseOrthoReference.preciseX;
			} else {
				loc.preciseY = preciseOrthoReference.preciseY;
			}
			loc.updateInts();
			location = loc;
		}

		return location;
	}

	/**
	 * Returns the position of the closest edge of the rectangle closest to the point
	 * @param p the point
	 * @param r the rectangle
	 * @return position of the closest edge
	 * @deprecated copy-pasted from super class, [GMFRT] make protected
	 */
	@Deprecated
	private static int getClosestSide2(Point p, Rectangle r) {
		double diff = Math.abs(r.preciseX() + r.preciseWidth() - p.preciseX());
		int side = PositionConstants.RIGHT;
		double currentDiff = Math.abs(r.preciseX() - p.preciseX());
		if (currentDiff < diff) {
			diff = currentDiff;
			side = PositionConstants.LEFT;
		}
		currentDiff = Math.abs(r.preciseY() + r.preciseHeight() - p.preciseY());
		if (currentDiff < diff) {
			diff = currentDiff;
			side = PositionConstants.BOTTOM;
		}
		currentDiff = Math.abs(r.preciseY() - p.preciseY());
		if (currentDiff < diff) {
			diff = currentDiff;
			side = PositionConstants.TOP;
		}
		return side;
	}

	/**
	 * If grid provider had been set up and has grid enabled then returns active grid specification in absolute coordinates. 
	 * Otherwise returns null.
	 * @return <code>null</code> if no active grid or grid provider had not been set up. 
	 */
	protected Rectangle getAbsoluteGridSpec() {
		return myGridProvider == null ? null : DiagramGridSpec.getAbsoluteGridSpec(myGridProvider);
	}

	private static Point pickClosestPointToSet(Point source, Collection<? extends Point> set1, Collection<? extends Point> set2) {
		double bestDistSquared = Double.MAX_VALUE;
		Point result = null;
		for (Point next : set1) {
			double nextDistSquared = source.getDistance(next);
			if (nextDistSquared < bestDistSquared) {
				result = next;
				bestDistSquared = nextDistSquared;
			}
		}
		for (Point next : set2) {
			double nextDistSquared = source.getDistance(next);
			if (nextDistSquared < bestDistSquared) {
				result = next;
				bestDistSquared = nextDistSquared;
			}
		}
		return result;
	}

}
