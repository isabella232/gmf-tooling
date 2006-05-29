/**
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.expressions.EcoreAbstractExpression;
import org.eclipse.gmf.ecore.expressions.EcoreOCLFactory;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class EcoreBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Object editHelperContext = completedRequest.getEditHelperContext();
		if (editHelperContext instanceof View) {
			editHelperContext = ((View) editHelperContext).getElement();
		}
		IElementType elementType = ElementTypeRegistry.getInstance().getElementType(editHelperContext);
		if (elementType == ElementTypeRegistry.getInstance().getType("org.eclipse.gmf.runtime.emf.type.core.default")) {
			EcoreDiagramEditorPlugin.getInstance().logInfo("Failed to get element type for " + editHelperContext);
			elementType = null;
		}
		Command semanticHelperCommand = null;
		if (elementType != null) {
			ICommand semanticCommand = elementType.getEditCommand(completedRequest);
			if (semanticCommand != null) {
				semanticHelperCommand = new EtoolsProxyCommand(semanticCommand);
			}
		}
		Command semanticPolicyCommand = getSemanticCommandSwitch(completedRequest);

		// combine commands from edit policy and edit helper
		if (semanticPolicyCommand == null) {
			if (semanticHelperCommand == null) {
				return null;
			} else {
				semanticPolicyCommand = semanticHelperCommand;
			}
		} else {
			if (semanticHelperCommand != null) {
				semanticPolicyCommand = semanticPolicyCommand.chain(semanticHelperCommand);
			}
		}

		// append command to delete view if necessary
		boolean shouldProceed = true;
		if (completedRequest instanceof DestroyRequest) {
			shouldProceed = shouldProceed((DestroyRequest) completedRequest);
		}
		if (shouldProceed) {
			if (completedRequest instanceof DestroyRequest) {
				Command deleteViewCommand = new EtoolsProxyCommand(new DeleteCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), (View) getHost().getModel()));
				semanticPolicyCommand = semanticPolicyCommand.chain(deleteViewCommand);
			}
			return semanticPolicyCommand;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMSLWrapper(ICommand cmd) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand modelCmd = new CompositeTransactionalCommand(editingDomain, cmd.getLabel());
		modelCmd.compose(cmd);
		return new EtoolsProxyCommand(modelCmd);
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement() {
		return ViewUtil.resolveSemanticElement((View) getHost().getModel());
	}

	/**
	 * Finds container element for the new relationship of the specified type.
	 * Default implementation goes up by containment hierarchy starting from
	 * the specified element and returns the first element that is instance of
	 * the specified container class.
	 * 
	 * @generated
	 */
	protected EObject getRelationshipContainer(EObject element, EClass containerClass, IElementType relationshipType) {
		for (; element != null; element = element.eContainer()) {
			if (containerClass.isSuperTypeOf(element.eClass())) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @generated 
	 */
	protected static class LinkConstraints {

		/**
		 * @generated 
		 */
		public static final LinkConstraints EClassESuperTypes_4004 = createEClassESuperTypes_4004();

		/**
		 * @generated 
		 */
		private static LinkConstraints createEClassESuperTypes_4004() {
			EcoreAbstractExpression sourceExpression = null;
			Map targetEnv = new HashMap(3);
			targetEnv.put("oppositeEnd", org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEClass()); //$NON-NLS-1$
			EcoreAbstractExpression targetExpression = EcoreOCLFactory.getExpression(
					"self <> oppositeEnd and not oppositeEnd.eSuperTypes->includes(self) and not self.eAllSuperTypes->includes(oppositeEnd)", //$NON-NLS-1$
					EcorePackage.eINSTANCE.getEClass(), targetEnv);
			return new LinkConstraints(sourceExpression, targetExpression);
		}

		/**
		 * @generated 
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated 
		 */
		private EcoreAbstractExpression srcEndInv;

		/**
		 * @generated 
		 */
		private EcoreAbstractExpression targetEndInv;

		/**
		 * @generated 
		 */
		public LinkConstraints(EcoreAbstractExpression sourceEnd, EcoreAbstractExpression targetEnd) {
			this.srcEndInv = sourceEnd;
			this.targetEndInv = targetEnd;
		}

		/**
		 * @generated 
		 */
		public boolean canCreateLink(CreateRelationshipRequest req, boolean isBackDirected) {
			Object source = req.getSource();
			Object target = req.getTarget();

			EcoreAbstractExpression sourceConstraint = isBackDirected ? targetEndInv : srcEndInv;
			EcoreAbstractExpression targetConstraint = null;
			if (req.getTarget() != null) {
				targetConstraint = isBackDirected ? srcEndInv : targetEndInv;
			}
			boolean isSourceAccepted = sourceConstraint != null ? evaluate(sourceConstraint, source, target, false) : true;
			if (isSourceAccepted && targetConstraint != null) {
				return evaluate(targetConstraint, target, source, true);
			}
			return isSourceAccepted;
		}

		/**
		 * @generated 
		 */
		private static boolean evaluate(EcoreAbstractExpression constraint, Object sourceEnd, Object oppositeEnd, boolean clearEnv) {
			Map evalEnv = Collections.singletonMap(OPPOSITE_END_VAR, oppositeEnd);
			try {
				Object val = constraint.evaluate(sourceEnd, evalEnv);
				return (val instanceof Boolean) ? ((Boolean) val).booleanValue() : false;
			} catch (Exception e) {
				EcoreDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}
	}
}
