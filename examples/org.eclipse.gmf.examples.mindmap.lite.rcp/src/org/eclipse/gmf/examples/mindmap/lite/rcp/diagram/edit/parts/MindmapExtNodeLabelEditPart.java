package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.AbstractLocator;
import org.eclipse.draw2d.PositionConstants;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;

import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @generated
 */
public abstract class MindmapExtNodeLabelEditPart extends
		AbstractGraphicalEditPart {

	/**
	 * @generated
	 */
	public MindmapExtNodeLabelEditPart(View view) {
		setModel(view);
	}

	/**
	 * @generated
	 */
	public void refreshBounds() {
		Node node = (Node) getModel();
		if (node.getLayoutConstraint() == null) {
			return;
		}
		assert node.getLayoutConstraint() instanceof Location;
		final Location location = (Location) node.getLayoutConstraint();
		getFigure().getParent().setConstraint(getFigure(),
				new AbstractLocator() {
					protected Point getReferencePoint() {
						return getLabelLocation(
								((GraphicalEditPart) getParent()).getFigure())
								.translate(location.getX(), location.getY());
					}

					public int getRelativePosition() {
						return PositionConstants.SOUTH;
					}
				});
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBounds();
	}

	/**
	 * @generated
	 */
	protected IUpdatableEditPart.Refresher boundsRefresher = new IUpdatableEditPart.Refresher() {
		public void refresh() {
			refreshBounds();
		}
	};

	/**
	 * @generated
	 */
	public Point getReferencePoint() {
		return getLabelLocation(((GraphicalEditPart) getParent()).getFigure());
	}

	/**
	 * @generated
	 */
	protected Point getLabelLocation(IFigure parent) {
		Point result = parent.getBounds().getBottom();
		parent.translateToAbsolute(result);
		return result;
	}
}
