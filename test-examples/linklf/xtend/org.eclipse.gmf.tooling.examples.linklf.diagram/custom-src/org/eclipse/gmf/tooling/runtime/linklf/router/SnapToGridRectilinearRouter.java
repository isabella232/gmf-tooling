package org.eclipse.gmf.tooling.runtime.linklf.router;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;
import org.eclipse.gmf.tooling.runtime.linklf.DiagramGridSpec;

public class SnapToGridRectilinearRouter extends RectilinearRouter2 {

	private DiagramGridSpec myGridSpec;

	public void setEditPartViewer(EditPartViewer viewer) {
		if (myGridSpec != null && myGridSpec.getViewer() == viewer) {
			return;
		}
		if (myGridSpec != null) {
			myGridSpec.dispose();
		}
		myGridSpec = viewer == null ? null : new DiagramGridSpec(viewer);
	}

	@Override
	public void routeLine(Connection conn, int nestedRoutingDepth, PointList newLine) {
		super.routeLine(conn, nestedRoutingDepth, newLine);
	}

	private PrecisionRectangle getGridSpec() {
		return myGridSpec == null ? null : myGridSpec.getAbsoluteGridSpec();
	}

	/**
	 * We need to find two points offset from the source and target anchors outside the shapes
	 * such that when the polyline is converted to rectilinear from oblique we won't have
	 * rectilinear line segments alligned with source or target shapes edges.
	 * <p/>
	 * Copy-pasted from {@link RectilinearRouter} lines 416.  
	 */
	@Deprecated
	public static void insertPointsProducingNotAlignedRectilinearSegments(PointList line, int sourceAnchorRelativeLocation, int targetAnchorRelativeLocation) {
		Point offStart = line.getFirstPoint();
		Point offEnd = line.getLastPoint();
		Dimension offsetDim = offStart.getDifference(offEnd).scale(0.5);
		offStart.translate(getTranslationValue2(sourceAnchorRelativeLocation, Math.abs(offsetDim.width), Math.abs(offsetDim.height)));
		offEnd.translate(getTranslationValue2(targetAnchorRelativeLocation, Math.abs(offsetDim.width), Math.abs(offsetDim.height)));
		line.insertPoint(offStart, 1);
		line.insertPoint(offEnd, 2);
	}

	public static void insertPointsProducingNotAlignedRectilinearSegments(PointList line, int sourceAnchorRelativeLocation, int targetAnchorRelativeLocation, SnapToGrid snapper) {
		insertPointsProducingNotAlignedRectilinearSegments(line, sourceAnchorRelativeLocation, targetAnchorRelativeLocation);
		if (snapper != null) {
			PrecisionPoint addedForSource = new PrecisionPoint(line.getPoint(1));
			PrecisionPoint snappedForSource = addedForSource.getPreciseCopy();
			PrecisionPoint addedForTarget = new PrecisionPoint(line.getPoint(2));
			PrecisionPoint snappedForTarget = addedForTarget.getPreciseCopy();

			snapper.snapPoint(null, asVerticalOrHorizontal(sourceAnchorRelativeLocation), addedForSource, snappedForSource);
			snapper.snapPoint(null, asVerticalOrHorizontal(targetAnchorRelativeLocation), addedForTarget, snappedForTarget);

			if (snappedForSource.getDistance(addedForSource) <= snappedForTarget.getDistance(addedForTarget)) {
				Dimension delta = snappedForSource.getDifference(addedForSource);
				line.setPoint(snappedForSource, 1);
				line.setPoint(addedForTarget.getTranslated(delta), 2);
			} else {
				Dimension delta = snappedForTarget.getDifference(addedForTarget);
				line.setPoint(addedForSource.getTranslated(delta), 1);
				line.setPoint(snappedForTarget, 2);
			}
		}
	}

	public static int asVerticalOrHorizontal(int direction) {
		return getOffShapeDirection2(direction);
	}

	public static void removeRedundantPoints(PointList line) {
		removeRedundantPoints2(line);
	}

}
