package org.eclipse.gmf.examples.mindmap.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;


public class SubtopicEditPart extends ConnectionNodeEditPart {

	public SubtopicEditPart(View view) {
		super(view);
	}

	@Override
	protected Connection createConnectionFigure() {
		if (getModel() == null) {
			return null;
		}
		
		Connection connection = new PolylineConnectionEx();
		return connection;
	}
}
