package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.edit.providers.EcoreSemanticHints;

/**
 * @generated
 */
public class EReference_name2EditPart extends LabelEditPart {

	static {
		registerSnapBackPosition(EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4019_LABEL, new Point(0, 0));
	}

	/**
	 * @generated
	 */
	public EReference_name2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public int getKeyPoint() {
		return ConnectionLocator.MIDDLE;
	}
}
