package org.eclipse.gmf.tooling.runtime.linklf.editpolicies;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.gmf.runtime.notation.Edge;

public class LinksLFConnectionBendpointEditPolicy extends ConnectionBendpointEditPolicy {

	public LinksLFConnectionBendpointEditPolicy(LineMode lineMode) {
		super(lineMode);
	}

	public LinksLFConnectionBendpointEditPolicy() {
		this(LineMode.OBLIQUE);
	}

	/**
	 * Method getBendpointsChangedCommand
	 * Different signature method that allows a command to constructed for changing the bendpoints
	 * without requiring the original Request.
	 * 
	 * @param connection Connection to generate the bendpoints changed command from
	 * @param edge notation element that the command will operate on.
	 * @return Command SetBendpointsCommand that contains the point changes for the connection.
	 */
	protected Command getBendpointsChangedCommand(Connection connection, Edge edge) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();

		Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef1);
		SetConnectionAnchorsCommand srcAnchorUpdate = null;

		if (getHost().getSource() instanceof INodeEditPart && connection.getPoints().size() > 1) {
			ptRef1 = connection.getPoints().getFirstPoint();
			INodeEditPart sourceEP = (INodeEditPart) getHost().getSource();
			ReconnectRequest reconnectSource = new ReconnectRequest(RequestConstants.REQ_RECONNECT_SOURCE);
			Point ptAbs1 = ptRef1.getCopy();
			getConnection().translateToAbsolute(ptAbs1);
			reconnectSource.setLocation(ptAbs1);
			reconnectSource.setConnectionEditPart(getHost());
			ConnectionAnchor newAnchor = sourceEP.getSourceConnectionAnchor(reconnectSource);
			String newTerminal = sourceEP.mapConnectionAnchorToTerminal(newAnchor);
			srcAnchorUpdate = new SetConnectionAnchorsCommand(editingDomain, "Updating source anchor");
			srcAnchorUpdate.setEdgeAdaptor(new EObjectAdapter(edge));
			srcAnchorUpdate.setNewSourceTerminal(newTerminal);
		}

		Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef2);
		SetConnectionAnchorsCommand trgAnchorUpdate = null;

		if (getHost().getTarget() instanceof INodeEditPart && connection.getPoints().size() > 1) {
			ptRef2 = connection.getPoints().getLastPoint();
			INodeEditPart targetEP = (INodeEditPart) getHost().getTarget();
			ReconnectRequest reconnectTarget = new ReconnectRequest(RequestConstants.REQ_RECONNECT_TARGET);
			Point ptAbs2 = ptRef2.getCopy();
			getConnection().translateToAbsolute(ptAbs2);
			reconnectTarget.setLocation(ptAbs2);
			reconnectTarget.setConnectionEditPart(getHost());
			ConnectionAnchor newTargetAnchor = targetEP.getTargetConnectionAnchor(reconnectTarget);
			String newTerminal = targetEP.mapConnectionAnchorToTerminal(newTargetAnchor);
			trgAnchorUpdate = new SetConnectionAnchorsCommand(editingDomain, "Updating target anchor");
			trgAnchorUpdate.setEdgeAdaptor(new EObjectAdapter(edge));
			trgAnchorUpdate.setNewTargetTerminal(newTerminal);
		}

		SetAbsoluteBendpointsCommand sbbCommand = new SetAbsoluteBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(new EObjectAdapter(edge));
		sbbCommand.setNewPointList(connection.getPoints());

		ICommand result = sbbCommand;
		if (srcAnchorUpdate != null) {
			result = result.compose(srcAnchorUpdate);
		}
		if (trgAnchorUpdate != null) {
			result = result.compose(trgAnchorUpdate);
		}

		return new ICommandProxy(result.reduce());
	}

	/**
	 * Method getSetBendpointCommand.
	 * This method returns a command that executes the REQ_SET_ALL_BENDPOINT request
	 * @param request SetAllBendpointRequest that stores the points to be set by the command.
	 * @return Command to be executed.
	 */
	protected Command getSetBendpointCommand(SetAllBendpointRequest request) {
		Connection connection = getConnection();
		PointList newPoints = request.getPoints();

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		SetAbsoluteBendpointsCommand sbbCommand = new SetAbsoluteBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(new EObjectAdapter((Edge) getHost().getModel()));

		// with SetAbsoluteBendpointsCommand we can use setNewPointList(PointList) here
		// but I left warnings here to revisit what are request.getSource/TargetReference() is 
		// and how it is expected to affect the result here
		if (request.getSourceReference() != null && request.getTargetReference() != null) {
			sbbCommand.setNewPointList(//
					newPoints, request.getSourceReference(), request.getTargetReference());
		} else {
			sbbCommand.setNewPointList(//
					newPoints, connection.getSourceAnchor(), connection.getTargetAnchor());
		}

		return new ICommandProxy(sbbCommand);
	}

	@Override
	public ConnectionEditPart getHost() {
		return (ConnectionEditPart) super.getHost();
	}

	@Override
	protected Connection getConnection() {
		return super.getConnection();
	}

}
