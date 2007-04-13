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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.ecore.edit.commands.EAnnotationReferencesReorientCommand;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageClassesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageDataTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEnumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackageAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackagesEditPart;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackage2ItemSemanticEditPolicy extends EcoreBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand(req.isConfirmationRequired());
		addDestroyChildNodesCommand(cc, req.isConfirmationRequired());
		cc.add(getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}
		}));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd, boolean confirm) {
		View view = (View) getHost().getModel();
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (EcoreVisualIDRegistry.getVisualID(node)) {
			case EPackageClassesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EClass2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode, confirm));
						break;
					}
				}
				break;
			case EPackagePackagesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EPackage3EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode, confirm));
						break;
					}
				}
				break;
			case EPackageDataTypesEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EDataType2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode, confirm));
						break;
					}
				}
				break;
			case EPackageEnumsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EEnum2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode, confirm));
						break;
					}
				}
				break;
			case EPackagePackageAnnotationsEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (EcoreVisualIDRegistry.getVisualID(cnode)) {
					case EAnnotation2EditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode, confirm));
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
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingEAnnotationReferences_4001Command(CreateRelationshipRequest req) {
		EObject sourceEObject = req.getSource();
		EObject targetEObject = req.getTarget();
		if (false == sourceEObject instanceof EAnnotation || false == targetEObject instanceof EObject) {
			return UnexecutableCommand.INSTANCE;
		}
		EAnnotation source = (EAnnotation) sourceEObject;
		EObject target = (EObject) targetEObject;
		if (!EcoreBaseItemSemanticEditPolicy.LinkConstraints.canCreateEAnnotationReferences_4001(source, target)) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(sourceEObject, EcorePackage.eINSTANCE.getEAnnotation_References(), target);
		return getMSLWrapper(new SetValueCommand(setReq));
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
			return getMSLWrapper(new EAnnotationReferencesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
