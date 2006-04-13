/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.util.Arrays;

import junit.framework.Assert;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

/**
 * Unit testcase base class with support for runtime-diagram editing. Expects LinksSessionSetup.
 */
public abstract class RuntimeDiagramTestBase extends GeneratedCanvasTest {

	protected RuntimeDiagramTestBase(String name) {
		super(name);
	}

	protected Diagram getDiagram() {
		return (Diagram) getDiagramEditPart().getModel();
	}

	protected DiaGenSource getGenModel() {
		return getSetup().getGenModel();
	}

	protected SessionSetup createDefaultSetup() {
		return LinksSessionSetup.newInstance();
	}

	protected Node createNode(final IElementType metamodelType, View notationContainer) {
		final Object[] newObjHolder = new Object[1];

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD) {
					newObjHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		notationContainer.eAdapters().add(adapter);

		try {
			CreateUnspecifiedTypeRequest req = new CreateUnspecifiedTypeRequest(Arrays.asList(new IElementType[] { metamodelType }), PreferencesHint.USE_DEFAULTS);
			Command cmd = findEditPart(notationContainer).getCommand(req);
			Assert.assertNotNull("No command is available for request", cmd); //$NON-NLS-1$		
			execute(cmd);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$			
		} finally {
			notationContainer.eAdapters().remove(adapter);
		}
		return newObjHolder[0] instanceof Node ? (Node) newObjHolder[0] : null;
	}

	protected boolean canStartLinkFrom(IElementType metamodelType, View source) {
		CreateRelationshipRequest req = new CreateRelationshipRequest(source.getElement(), null, metamodelType);
		EditCommandRequestWrapper wrapper = new EditCommandRequestWrapper(req);
		Command cmd = findEditPart(source).getCommand(wrapper);
		return cmd != null && cmd.canExecute();
	}

	protected Edge createLink(IElementType metamodelType, View source, View target) {
		final Object[] newObjHolder = new Object[1];

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD && msg.getNewValue() instanceof Edge) {
					newObjHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		Diagram diagram = getDiagram();
		diagram.eAdapters().add(adapter);
		try {
			CreateRelationshipRequest relationShipReq = new CreateRelationshipRequest(metamodelType);
			relationShipReq.setSource(source.getElement());
			if (target != null) {
				relationShipReq.setTarget(target.getElement());
			}

			ConnectionViewAndElementDescriptor desc = new ConnectionViewAndElementDescriptor(new CreateElementRequestAdapter(relationShipReq), metamodelType instanceof IHintedType ? ((IHintedType) metamodelType).getSemanticHint() : "", PreferencesHint.USE_DEFAULTS);

			CreateConnectionViewAndElementRequest req = new CreateConnectionViewAndElementRequest(desc);
			req.setType(RequestConstants.REQ_CONNECTION_START);

			EditPart sourceEditPart = findEditPart(source);
			req.setSourceEditPart(sourceEditPart);
			// Note: initializes the sourceCommand in the request
			Command sourceCmd = sourceEditPart.getCommand(req);
			if (sourceCmd == null || !sourceCmd.canExecute()) {
				return null;
			}

			EditPart targetEditPart = target != null ? findEditPart(target) : null;
			if (targetEditPart != null) {
				req.setType(RequestConstants.REQ_CONNECTION_END);
				req.setTargetEditPart(targetEditPart);
				req.setLocation(new Point(0, 0));
				sourceEditPart.getCommand(req);
				Command targetCmd = targetEditPart.getCommand(req);
				if (targetCmd == null || !targetCmd.canExecute()) {
					return null;
				}
				execute(targetCmd);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Edge creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			diagram.eAdapters().remove(adapter);
		}
		return newObjHolder[0] instanceof Edge ? (Edge) newObjHolder[0] : null;
	}

	protected IElementType getElementType(GenCommonBase genElement) {
		Class clazz = null;
		try {
			clazz = loadGeneratedClass(getGenModel().getGenDiagram().getElementTypesQualifiedClassName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("ElementTypes class not loaded. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		String identifier = genElement.getUniqueIdentifier();
		try {
			Object type = clazz.getField(identifier).get(null);
			assert type != null : "Metatype field in the ElementTypes class should be initialized"; //$NON-NLS-1$
			assert type instanceof IElementType : IElementType.class.getName() + ": metamodel type class required"; //$NON-NLS-1$ 
			return (IElementType) type;
		} catch (NoSuchFieldException e) {
			fail("Metamodel type " + identifier + " is not registered"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			e.printStackTrace();
			fail("Can't access metamodel type " + identifier); //$NON-NLS-1$			
		}

		return null;
	}

	/**
	 * Sets structural feature value of the business element associated with the
	 * given notation element.
	 * 
	 * @param view
	 *            the notation element encapsulating the bussiness object
	 *            containing the feature to be modified
	 * @param featureName
	 *            the name of the structural feature to set.
	 * @param value
	 *            the value to set
	 * @throws IllegalArgumentException
	 *             if the given name does not refer existing feature
	 */
	protected void setBusinessElementStructuralFeature(View view, String featureName, Object value) {
		EObject instance = view.getElement();
		assertNotNull("No business element bound to notation element", instance); //$NON-NLS-1$
		EObject resultObj = EPath.findLocalFeature(instance.eClass(), featureName);
		if (!(resultObj instanceof EStructuralFeature)) {
			throw new IllegalArgumentException("Not existing feature: " + featureName); //$NON-NLS-1$
		}

		EStructuralFeature feature = (EStructuralFeature) resultObj;
		SetRequest setReq = new SetRequest(instance, feature, value);
		EditPart editPart = findEditPart(view);
		assertTrue("IGraphicalEditPart expected", editPart instanceof IGraphicalEditPart); //$NON-NLS-1$

		TransactionalEditingDomain txEditDomain = ((IGraphicalEditPart) editPart).getEditingDomain();
		CompositeTransactionalCommand modelCmd = new CompositeTransactionalCommand(txEditDomain, "Set feature"); //$NON-NLS-1$
		modelCmd.compose(new SetValueCommand(setReq));
		new EtoolsProxyCommand(modelCmd).execute();
	}
}
