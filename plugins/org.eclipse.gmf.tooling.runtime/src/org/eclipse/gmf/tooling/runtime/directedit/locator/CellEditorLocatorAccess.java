package org.eclipse.gmf.tooling.runtime.directedit.locator;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public class CellEditorLocatorAccess {

	public static final CellEditorLocatorAccess INSTANCE = new CellEditorLocatorAccess();

	public CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

}
