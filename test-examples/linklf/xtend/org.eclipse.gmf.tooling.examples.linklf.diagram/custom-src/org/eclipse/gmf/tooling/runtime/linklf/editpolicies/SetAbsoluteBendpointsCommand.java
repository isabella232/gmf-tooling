package org.eclipse.gmf.tooling.runtime.linklf.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.gmf.tooling.runtime.linklf.AbsoluteBendpointsConvention;

@SuppressWarnings("restriction")
public class SetAbsoluteBendpointsCommand extends SetConnectionBendpointsCommand {

	public SetAbsoluteBendpointsCommand(TransactionalEditingDomain editingDomain) {
		super(editingDomain);
	}

	public void setEdge(ConnectionEditPart editPart) {
		View edge = editPart.getNotationView();
		setEdgeAdapter(new EObjectAdapter(edge));
	}

	public void setNewPointList(PointList newPointList) {
		//our implementation does not use the refPoints, but super class still needs them != null
		super.setNewPointList(newPointList, new Point(), new Point());
	}

	@Override
	public void setEdgeAdapter(IAdaptable edgeAdapter) {
		super.setEdgeAdapter(edgeAdapter);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		Assert.isNotNull(getNewPointList());
		Assert.isNotNull(getSourceRefPoint());
		Assert.isNotNull(getTargetRefPoint());

		Edge edge = (Edge) getEdgeAdaptor().getAdapter(Edge.class);
		Assert.isNotNull(edge);

		setAbsoluteBendpoints(edge, getNewPointList());

		return CommandResult.newOKCommandResult();
	}

	public static void setAbsoluteBendpoints(Edge edge, PointList newPointList) {
		List<RelativeBendpoint> newBendpoints = new ArrayList<RelativeBendpoint>();
		int numOfPoints = newPointList.size();
		for (short i = 0; i < numOfPoints; i++) {
			//Dimension s = getNewPointList().getPoint(i).getDifference(getSourceRefPoint());
			//Dimension t = getNewPointList().getPoint(i).getDifference(getTargetRefPoint());
			//newBendpoints.add(new RelativeBendpoint(s.width, s.height, t.width, t.height));
			newBendpoints.add(AbsoluteBendpointsConvention.createAbsoluteBendpointStoredAsRelative(newPointList.getPoint(i)));
		}

		StringBuffer toString = new StringBuffer();
		boolean atLeastOne = false;
		for (RelativeBendpoint next : newBendpoints) {
			if (atLeastOne) {
				toString.append(" - ");
			}
			toString.append(next.convertToString());
			atLeastOne = true;
		}
		System.err.println("SetAbsBendpoints: " + toString);

		RelativeBendpoints points = (RelativeBendpoints) edge.getBendpoints();
		points.setPoints(newBendpoints);
	}

	@Override
	public String toString() {
		return "SAbsBC[$" + System.identityHashCode(this) + "]";
	}

}
