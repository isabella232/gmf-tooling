/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.swt.graphics.Color;

public abstract class InnerFigureDragDropEditPolicy extends DragDropEditPolicy {

	private static final Color GRAY = new Color(null, 200, 200, 200);

	private Integer alpha;

	@Override
	public EditPart getTargetEditPart(Request request) {
		if (getHost().getParent() != null) {
			EditPolicy layoutEditPolicy = getHost().getParent().getEditPolicy(EditPolicy.LAYOUT_ROLE);
			if (layoutEditPolicy instanceof BorderLayoutEditPolicy || layoutEditPolicy instanceof GridLayoutEditPolicy) {
		if (RequestConstants.REQ_DROP.equals(request.getType()) && !isDeepInFigure((ChangeBoundsRequest) request)) {
					// Skipping requests if the mouse is close to the figure
					// border
			return null;
		}
		}
		}
		return super.getTargetEditPart(request);
	}

	private boolean isDeepInFigure(ChangeBoundsRequest request) {
		Point location = request.getLocation().getCopy();
		getActualFigure().translateToRelative(location);

		Point figureCenter = getActualFigure().getBounds().getCenter();
		int dx = location.x - figureCenter.x;
		dx = (int) (Math.signum(dx) * Math.min(0.3 * Math.abs(dx), 10));
		int dy = location.y - figureCenter.y;
		dy = (int) (Math.signum(dy) * Math.min(0.3 * Math.abs(dy), 10));
		// Shifting request location by dr in a direction from center of figure
		location.translate(dx, dy);
		return getActualFigure().containsPoint(location);
	}

	@Override
	public void showTargetFeedback(Request request) {
		Command c = getCommand(request);
		if (c != null && c.canExecute()) {
			if (revertColor == null) {
				revertColor = getActualFigure().getBackgroundColor();
				opacity = getActualFigure().isOpaque();
				alpha = getActualFigure().getAlpha();
				getActualFigure().setBackgroundColor(FigureUtilities.mixColors(GRAY, revertColor));
				getActualFigure().setOpaque(true);
				getActualFigure().setAlpha(alpha == null ? 128 : alpha / 2);
			}
		}
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if (revertColor != null) {
			getActualFigure().setBackgroundColor(revertColor);
			getActualFigure().setOpaque(opacity);
			getActualFigure().setAlpha(alpha);
			revertColor = null;
		}
	}

	protected abstract Shape getActualFigure();

}
