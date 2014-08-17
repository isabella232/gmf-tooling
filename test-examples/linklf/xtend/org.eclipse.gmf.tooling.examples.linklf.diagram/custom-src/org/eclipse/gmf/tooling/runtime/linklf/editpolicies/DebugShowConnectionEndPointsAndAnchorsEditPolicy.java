package org.eclipse.gmf.tooling.runtime.linklf.editpolicies;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;

public class DebugShowConnectionEndPointsAndAnchorsEditPolicy extends LinksLFConnectionEndPointEditPolicy {

	private IFigure mySourceAnchor;

	private IFigure myTargetAnchor;

	protected void showAnchors() {
		if (mySourceAnchor == null) {
			mySourceAnchor = createSourceAnchorFocus();
		}
		addFeedback(mySourceAnchor);
		if (myTargetAnchor == null) {
			myTargetAnchor = createTargetAnchorFocus();
		}
		addFeedback(myTargetAnchor);
	}

	@Override
	protected void showSelection() {
		super.showSelection();
		showAnchors();
	}

	@Override
	protected void hideSelection() {
		hideAnchors();
		super.hideSelection();
	}

	protected void hideAnchors() {
		if (mySourceAnchor != null) {
			removeFeedback(mySourceAnchor);
			mySourceAnchor = null;
		}
		if (myTargetAnchor != null) {
			removeFeedback(myTargetAnchor);
			myTargetAnchor = null;
		}
	}

	private IFigure createSourceAnchorFocus() {
		return new SourceAnchorFeedback(getConnection());
	}

	private IFigure createTargetAnchorFocus() {
		return new TargetAnchorFeedback(getConnection());
	}

	private static abstract class AnchorFeedback extends Ellipse {

		private AncestorListener myAncestorListener = new AncestorListener.Stub() {

			public void ancestorMoved(IFigure ancestor) {
				revalidate();
			}
		};

		private Connection myConnection;

		public AnchorFeedback(Connection connection, Color color) {
			myConnection = connection;
			setSize(10, 10);
			setLineWidth(2);
			setFill(false);
			setOpaque(true);
			if (color != null) {
				setBackgroundColor(color);
				setForegroundColor(color);
			}
		}

		protected abstract ConnectionAnchor getAnchor(Connection connection);

		@Override
		public void addNotify() {
			super.addNotify();
			myConnection.addAncestorListener(myAncestorListener);
		}

		@Override
		public void removeNotify() {
			myConnection.removeAncestorListener(myAncestorListener);
			super.removeNotify();
		}

		@Override
		public void validate() {
			if (isValid()) {
				return;
			}
			ConnectionAnchor anchor = getAnchor(myConnection);
			Point refPoint = anchor.getReferencePoint().getCopy();
			translateToRelative(refPoint);
			showAt(refPoint);
		}

		public void showAt(Point point) {
			Dimension halfSize = getSize().getScaled(-0.5);
			setLocation(point.getTranslated(halfSize));
		}
	}

	private static class SourceAnchorFeedback extends AnchorFeedback {

		public SourceAnchorFeedback(Connection connection) {
			super(connection, ColorConstants.blue);
		}

		@Override
		protected ConnectionAnchor getAnchor(Connection connection) {
			return connection.getSourceAnchor();
		}

	}

	private static class TargetAnchorFeedback extends AnchorFeedback {

		public TargetAnchorFeedback(Connection connection) {
			super(connection, ColorConstants.red);
		}

		@Override
		protected ConnectionAnchor getAnchor(Connection connection) {
			return connection.getTargetAnchor();
		}

	}

}
