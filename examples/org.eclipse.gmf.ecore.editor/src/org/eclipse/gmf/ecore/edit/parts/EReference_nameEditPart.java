package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.providers.EcoreSemanticHints;

/**
 * @generated
 */
public class EReference_nameEditPart extends LabelEditPart {

	static {
		registerSnapBackPosition(EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4018_LABEL, new Point(0, 0));
	}

	/**
	 * @generated
	 */
	public EReference_nameEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public int getKeyPoint() {
		return ConnectionLocator.MIDDLE;
	}
}
