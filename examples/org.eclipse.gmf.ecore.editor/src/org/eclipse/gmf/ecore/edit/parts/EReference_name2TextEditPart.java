package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.edit.providers.EcoreStructuralFeatureParser;

/**
 * @generated
 */
public class EReference_name2TextEditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public EReference_name2TextEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEReference().getEStructuralFeature("name"));
		}
		return parser;
	}
}
