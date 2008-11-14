package org.eclipse.gmf.examples.mindmap.diagram.edit.parts;

import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

public class TopicEditPart extends ShapeNodeEditPart {

	public TopicEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(40));
		figure.setLayoutManager(new StackLayout());
		figure.add(new TopicFigure());
		return figure;
	}

	public class TopicFigure extends RoundedRectangle {
		public TopicFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(10)));
		}

	}
}
