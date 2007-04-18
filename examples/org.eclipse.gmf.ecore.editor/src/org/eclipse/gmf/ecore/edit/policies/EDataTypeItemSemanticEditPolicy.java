/*
 *  Copyright (c) 2006, 2007 Borland Software Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.ecore.edit.commands.EAnnotationReferencesCreateCommand;
import org.eclipse.gmf.ecore.edit.commands.EAnnotationReferencesReorientCommand;
import org.eclipse.gmf.ecore.edit.commands.EReference2CreateCommand;
import org.eclipse.gmf.ecore.edit.commands.EReference2ReorientCommand;
import org.eclipse.gmf.ecore.edit.commands.EReferenceCreateCommand;
import org.eclipse.gmf.ecore.edit.commands.EReferenceReorientCommand;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeDataTypeAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EDataTypeItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (EcoreVisualIDRegistry.getVisualID(node)) {
			case EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EAnnotation2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (EcoreElementTypes.EAnnotationReferences_4001 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEAnnotationReferences_4001Command(req);
		}
		if (EcoreElementTypes.EReference_4002 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEReference_4002Command(req);
		}
		if (EcoreElementTypes.EReference_4003 == req.getElementType()) {
			return req.getTarget() == null ? null : getCreateCompleteIncomingEReference_4003Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEAnnotationReferences_4001Command(CreateRelationshipRequest req) {
		return getGEFWrapper(new EAnnotationReferencesCreateCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEReference_4002Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof EClass || false == targetEObject instanceof EClassifier) {
			return UnexecutableCommand.INSTANCE;
		}
		EClass source = (EClass) sourceEObject;
		EClassifier target = (EClassifier) targetEObject;
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.canCreateEReference_4002(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		}
		return getGEFWrapper(new EReferenceCreateCommand(req, source, target));
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEReference_4003Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof EClass || false == targetEObject instanceof EClassifier) {
			return UnexecutableCommand.INSTANCE;
		}
		EClass source = (EClass) sourceEObject;
		EClassifier target = (EClassifier) targetEObject;
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.canCreateEReference_4003(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req.setContainmentFeature(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures());
		}
		return getGEFWrapper(new EReference2CreateCommand(req, source, target));
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case EReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(new EReferenceReorientCommand(req));
		case EReference2EditPart.VISUAL_ID:
			return getGEFWrapper(new EReference2ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return getGEFWrapper(new EAnnotationReferencesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
