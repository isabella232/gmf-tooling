package org.eclipse.gmf.tooling.runtime.linklf;

import java.util.Arrays;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

public class ShapeNodeAnchorDelegate {

	private NodeFigure myNodeFigure;

	public ShapeNodeAnchorDelegate(NodeFigure nodeFigure) {
		myNodeFigure = nodeFigure;
	}

	public NodeFigure getNodeFigure() {
		return myNodeFigure;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		Point fromRequest = safeGetPointFromLinkRequest(request);
		ConnectionAnchor result = getNodeFigure().getSourceConnectionAnchorAt(fromRequest);
		if (request instanceof ReconnectRequest) {
			ReconnectRequest reqImpl = (ReconnectRequest) request;
			AbstractConnectionEditPart linkEP = (AbstractConnectionEditPart) reqImpl.getConnectionEditPart();
			Connection conn = linkEP.getConnectionFigure();
			ConnectionRouter router = conn.getConnectionRouter();
			PointList pointsBefore = conn.getPoints().getCopy();
			conn.setSourceAnchor(result);
			router.route(conn);
			PointList pointsAfter = conn.getPoints().getCopy();
			Point routedLocation = pointsAfter.getFirstPoint();
			conn.translateToAbsolute(routedLocation);
			result = getNodeFigure().getSourceConnectionAnchorAt(routedLocation);
			if (!Arrays.equals(pointsAfter.toIntArray(), pointsBefore.toIntArray())) {
				conn.setPoints(pointsBefore);
			}
		}
		return result;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		Point fromRequestAbs = safeGetPointFromLinkRequest(request);
		ConnectionAnchor result = getNodeFigure().getTargetConnectionAnchorAt(fromRequestAbs);
		if (request instanceof ReconnectRequest) {
			ReconnectRequest reqImpl = (ReconnectRequest) request;
			AbstractConnectionEditPart linkEP = (AbstractConnectionEditPart) reqImpl.getConnectionEditPart();
			Connection conn = linkEP.getConnectionFigure();
			ConnectionRouter router = conn.getConnectionRouter();
			PointList pointsBefore = conn.getPoints().getCopy();
			conn.setTargetAnchor(result);
			router.route(conn);
			PointList pointsAfter = conn.getPoints().getCopy();
			Point routedTarget = pointsAfter.getLastPoint();
			conn.translateToAbsolute(routedTarget);
			result = getNodeFigure().getTargetConnectionAnchorAt(routedTarget);
			if (!Arrays.equals(pointsAfter.toIntArray(), pointsBefore.toIntArray())) {
				conn.setPoints(pointsBefore);
			}
		}
		return result;
	}

	private Point safeGetPointFromLinkRequest(Request request) {
		Point result = null;
		if (request instanceof DropRequest) {
			result = ((DropRequest) request).getLocation();
		}
		//additional copy for ReconnectRequest, dont know why, 
		//but see, e.g, ShapeNodeEditPart#getSourceConnectionAnchor
		if (result != null && request instanceof ReconnectRequest) {
			result = result.getCopy();
		}
		return result;
	}

}
