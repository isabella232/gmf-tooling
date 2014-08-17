package org.eclipse.gmf.tooling.runtime.linklf;

import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;

public class AbsoluteBendpointsConvention {

	private static final int MAGIC = -643984;

	public static RelativeBendpoint createAbsoluteBendpointStoredAsRelative(Point point) {
		return new RelativeBendpoint(point.x, point.y, MAGIC, MAGIC);
	}

	public static boolean isAbsoluteStoredAsRelative(RelativeBendpoint modelBP) {
		return modelBP.getTargetX() == MAGIC && modelBP.getTargetY() == MAGIC;
	}

	public static Bendpoint d2dBendpoint(RelativeBendpoint modelBP, Connection connection, float weight) {
		if (isAbsoluteStoredAsRelative(modelBP)) {
			return new AbsoluteBendpoint(modelBP.getSourceX(), modelBP.getSourceY());
		}
		org.eclipse.draw2d.RelativeBendpoint rbp = new org.eclipse.draw2d.RelativeBendpoint(connection);
		rbp.setRelativeDimensions(new Dimension(modelBP.getSourceX(), modelBP.getSourceY()), // 
				new Dimension(modelBP.getTargetX(), modelBP.getTargetY()));
		rbp.setWeight(weight);
		return rbp;
	}

	public static boolean hasAbsoluteStoredAsRelativeBendpoints(Edge edge) {
		List<?> bendpoints = ((RelativeBendpoints) edge.getBendpoints()).getPoints();
		for (Object o : bendpoints) {
			if (o instanceof RelativeBendpoint && isAbsoluteStoredAsRelative((RelativeBendpoint) o)) {
				return true;
			}
		}
		return false;
	}

	public static PointList getAbsoluteRelativeBendpointsList(Edge edge) {
		PointList result = new PointList();
		for (Object o : ((RelativeBendpoints) edge.getBendpoints()).getPoints()) {
			if (o instanceof RelativeBendpoint && isAbsoluteStoredAsRelative((RelativeBendpoint) o)) {
				RelativeBendpoint relativeBendpoint = (RelativeBendpoint) o;
				result.addPoint(new Point(relativeBendpoint.getSourceX(), relativeBendpoint.getSourceY()));
			} else {
				throw new IllegalArgumentException("Expecting absolute bendpoints stored as relative, found: " + o);
			}
		}
		return result;
	}
}
