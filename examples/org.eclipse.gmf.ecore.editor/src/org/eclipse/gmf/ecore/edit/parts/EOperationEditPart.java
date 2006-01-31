package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.edit.policies.EOperationItemSemanticEditPolicy;

import org.eclipse.gmf.ecore.edit.providers.EcoreStructuralFeatureParser;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;

/**
 * @generated
 */
public class EOperationEditPart extends ListItemEditPart {

	/**
	 * @generated
	 */
	public EOperationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EOperationItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEOperation().getEStructuralFeature("name"));
		}
		return parser;
	}
}
