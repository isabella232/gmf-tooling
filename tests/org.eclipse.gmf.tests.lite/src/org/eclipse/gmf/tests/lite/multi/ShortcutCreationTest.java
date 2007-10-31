/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.multi;

import java.util.Iterator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.requests.RequestConstants;
import org.eclipse.gmf.runtime.lite.shortcuts.IShortcutProvider;
import org.eclipse.gmf.runtime.lite.shortcuts.ShortcutProvidersRegistry;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.AbstractMultiSetupTest;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;


public class ShortcutCreationTest extends AbstractMultiSetupTest {
	public ShortcutCreationTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		SessionSetup[] setups = getMultiSetup().getAllSetups();
		assertEquals(2, setups.length);
	}

	public void testShortcutCreationAndDeletion() throws Exception {
		Diagram diagram = getDiagram();
		SessionSetup shortcutSetup = getMultiSetup().getAllSetups()[1];
		GenDiagram shortcutSource = shortcutSetup.getGenModel().getGenDiagram();
		String modelID = shortcutSource.getEditorGen().getModelID();
		RTSetup secondDiagramSetup = new RTSetup().init(shortcutSetup.getGenProject().getBundle(), shortcutSetup.getGenModel(), TransactionUtil.getEditingDomain(diagram));
		EObject shortcutObject = secondDiagramSetup.getNodeA().getElement();
		Node createdShortcut = createShortcutNode(modelID, diagram, shortcutObject);
		EditPart shortcutEP = findEditPart(createdShortcut);
		assertNotNull(shortcutEP);
		assertTrue(shortcutEP.isActive());
		GroupRequest request = new GroupRequest(RequestConstants.REQ_DELETE_VIEW);
		Command deleteViewCommand = shortcutEP.getCommand(request);
		assertNotNull(deleteViewCommand);
		assertTrue("Cannot delete shortcut", deleteViewCommand.canExecute());
		execute(deleteViewCommand);
		assertFalse(shortcutEP.isActive());
		assertNull(createdShortcut.eContainer());
		assertNotNull(shortcutObject.eContainer());
	}

	public void testCanonicalChildrenOfShortcuts() throws Exception {
		SessionSetup shortcutSetup = getMultiSetup().getAllSetups()[1];
		EList<GenCompartment> compartments = shortcutSetup.getGenModel().getNodeA().getCompartments();
		assertFalse(compartments.isEmpty());
		GenCompartment shortcutCompartment = compartments.get(0);
		assertNotNull(shortcutCompartment);
		EList<GenNode> containedNodes = shortcutCompartment.getContainedNodes();
		assertFalse(containedNodes.isEmpty());
		GenNode containedNode = containedNodes.get(0);
		GenFeature containmentMetaFeature = containedNode.getModelFacet().getContainmentMetaFeature();

		Diagram diagram = getDiagram();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(diagram);
		GenDiagram shortcutSource = shortcutSetup.getGenModel().getGenDiagram();
		String modelID = shortcutSource.getEditorGen().getModelID();
		RTSetup secondDiagramSetup = new RTSetup().init(shortcutSetup.getGenProject().getBundle(), shortcutSetup.getGenModel(), TransactionUtil.getEditingDomain(diagram));
		EObject shortcutObject = secondDiagramSetup.getNodeA().getElement();
		Node createdShortcut = createShortcutNode(modelID, diagram, shortcutObject);
		EditPart shortcutEP = findEditPart(createdShortcut);
		assertNotNull(shortcutEP);
		assertTrue(shortcutEP.isActive());
		View compartmentView = findChildView(createdShortcut, shortcutCompartment);
		assertNotNull(compartmentView);
		String featureName = containmentMetaFeature.getEcoreFeature().getName();
		EStructuralFeature feature = shortcutObject.eClass().getEStructuralFeature(featureName);
		assertNotNull("Feature not found", feature);
		assertTrue(feature.getEType() instanceof EClass);
		assertTrue(feature.isMany());
		EClass newChildClass = (EClass) feature.getEType();
		EObject newChild = newChildClass.getEPackage().getEFactoryInstance().create(newChildClass);
		org.eclipse.emf.common.command.Command addCommand = AddCommand.create(domain, shortcutObject, feature, newChild);
		assertNotNull(addCommand);
		assertTrue(addCommand.canExecute());
		new EMFCommandOperation(domain, addCommand).execute(new NullProgressMonitor(), null);
		assertNotNull("Add command not created", newChild.eContainer());
		View newChildView = findView(compartmentView, newChild);
		assertNotNull("Notation model of shortcut not refreshed", newChildView);
	}

	public void testShortcutLinkNotationRefresh() throws Exception {
		SessionSetup shortcutSetup = getMultiSetup().getAllSetups()[1];
		GenNode nodeA = shortcutSetup.getGenModel().getNodeA();
		GenNode nodeB = shortcutSetup.getGenModel().getNodeB();
		GenLink typeLink = shortcutSetup.getGenModel().getLinkC();
		GenLink refLink = shortcutSetup.getGenModel().getLinkD();
		boolean shouldSwapRef = false;
		boolean shouldSwapType = false;
		if (nodeA.getDomainMetaClass().equals(typeLink.getModelFacet().getSourceType())) {
			assertEquals(nodeB.getDomainMetaClass(), typeLink.getModelFacet().getTargetType());
		} else {
			assertEquals(nodeB.getDomainMetaClass(), typeLink.getModelFacet().getSourceType());
			assertEquals(nodeA.getDomainMetaClass(), typeLink.getModelFacet().getTargetType());
			shouldSwapType = true;
		}
		if (nodeA.getDomainMetaClass().equals(refLink.getModelFacet().getSourceType())) {
			assertEquals(nodeB.getDomainMetaClass(), refLink.getModelFacet().getTargetType());
		} else {
			assertEquals(nodeB.getDomainMetaClass(), refLink.getModelFacet().getSourceType());
			assertEquals(nodeA.getDomainMetaClass(), refLink.getModelFacet().getTargetType());
			shouldSwapRef = true;
			shouldSwapType = !shouldSwapType;
		}
		//nodeA is the source, nodeB is the target for the ref link.
		String refLinkMetaFeatureName = ((FeatureLinkModelFacet) refLink.getModelFacet()).getMetaFeature().getEcoreFeature().getName();

		Diagram diagram = getDiagram();
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(diagram);
		GenDiagram shortcutSource = shortcutSetup.getGenModel().getGenDiagram();
		String modelID = shortcutSource.getEditorGen().getModelID();
		RTSetup secondDiagramSetup = new RTSetup().init(shortcutSetup.getGenProject().getBundle(), shortcutSetup.getGenModel(), TransactionUtil.getEditingDomain(diagram));
		EObject shortcutA = secondDiagramSetup.getNodeA().getElement();
		EObject shortcutB = secondDiagramSetup.getNodeB().getElement();
		if (shouldSwapRef) {
			EObject swap = shortcutB;
			shortcutB = shortcutA;
			shortcutA = swap;
		}
		//Delete the ref-based link.
		EStructuralFeature refFeature = shortcutA.eClass().getEStructuralFeature(refLinkMetaFeatureName);
		org.eclipse.emf.common.command.Command deleteLinkCommand = SetCommand.create(domain, shortcutA, refFeature, null);
		assertTrue(deleteLinkCommand != null && deleteLinkCommand.canExecute());
		new EMFCommandOperation(domain, deleteLinkCommand).execute(new NullProgressMonitor(), null);
		assertNull("Delete command not executed", shortcutA.eGet(refFeature));
//The notation model is not necessarily updated, because it is not displayed on any diagram 
//(whereas notation model updaters are registered for edit parts). Therefore, the following four lines are commented.
//		assertEquals("Delete link command not executed", getIntForBoolean(shouldSwapType), secondDiagramSetup.getNodeA().getTargetEdges().size());
//		assertEquals("Delete link command not executed", getIntForBoolean(shouldSwapType), secondDiagramSetup.getNodeB().getSourceEdges().size());
//		assertEquals("Delete link command not executed", getIntForBoolean(!shouldSwapType), secondDiagramSetup.getNodeA().getSourceEdges().size());
//		assertEquals("Delete link command not executed", getIntForBoolean(!shouldSwapType), secondDiagramSetup.getNodeB().getTargetEdges().size());
		Node createdShortcutA = createShortcutNode(modelID, diagram, shortcutA);
		EditPart shortcutAEP = findEditPart(createdShortcutA);
		assertNotNull(shortcutAEP);
		assertTrue(shortcutAEP.isActive());
		Node createdShortcutB = createShortcutNode(modelID, diagram, shortcutB);
		EditPart shortcutBEP = findEditPart(createdShortcutB);
		assertNotNull(shortcutBEP);
		assertTrue(shortcutBEP.isActive());

		//A type-based link between these elements was created in RTSetup, a ref-based link was not created (explicitly deleted)
		assertEquals(getIntForBoolean(shouldSwapType), createdShortcutA.getTargetEdges().size());
		assertEquals(getIntForBoolean(shouldSwapType), createdShortcutB.getSourceEdges().size());
		assertEquals(getIntForBoolean(!shouldSwapType), createdShortcutA.getSourceEdges().size());
		assertEquals(getIntForBoolean(!shouldSwapType), createdShortcutB.getTargetEdges().size());

		org.eclipse.emf.common.command.Command setCommand = SetCommand.create(domain, shortcutA, refFeature, shortcutB);
		assertTrue(setCommand != null && setCommand.canExecute());
		new EMFCommandOperation(domain, setCommand).execute(new NullProgressMonitor(), null);
		assertEquals("Create link command not executed", getIntForBoolean(shouldSwapType) + getIntForBoolean(!shouldSwapRef), secondDiagramSetup.getNodeA().getTargetEdges().size());
		assertEquals("Create link command not executed", getIntForBoolean(shouldSwapType) + getIntForBoolean(!shouldSwapRef), secondDiagramSetup.getNodeB().getSourceEdges().size());
		assertEquals("Create link command not executed", getIntForBoolean(!shouldSwapType) + getIntForBoolean(shouldSwapRef), secondDiagramSetup.getNodeA().getSourceEdges().size());
		assertEquals("Create link command not executed", getIntForBoolean(!shouldSwapType) + getIntForBoolean(shouldSwapRef), secondDiagramSetup.getNodeB().getTargetEdges().size());

		assertEquals("Command that created link did not affect shortcuts", getIntForBoolean(shouldSwapType) + getIntForBoolean(!shouldSwapRef), createdShortcutA.getTargetEdges().size());
		assertEquals("Command that created link did not affect shortcuts", getIntForBoolean(shouldSwapType) + getIntForBoolean(!shouldSwapRef), createdShortcutB.getSourceEdges().size());
		assertEquals("Command that created link did not affect shortcuts", getIntForBoolean(!shouldSwapType) + getIntForBoolean(shouldSwapRef), createdShortcutA.getSourceEdges().size());
		assertEquals("Command that created link did not affect shortcuts", getIntForBoolean(!shouldSwapType) + getIntForBoolean(shouldSwapRef), createdShortcutB.getTargetEdges().size());
	}

	private static int getIntForBoolean(boolean b) {
		return b ? 1 : 0;
	}

	protected Node createShortcutNode(String modelID, View containerView, EObject underlyingModelObject) throws Exception {
		IShortcutProvider provider = ShortcutProvidersRegistry.INSTANCE.getShortcutProvider(modelID);
		assertNotNull("Cannot find shortcut provider", provider);
		CreateNotationalElementCommand createShortcutCommand = provider.getCreateShortcutCommand(containerView, underlyingModelObject);
		assertTrue("Cannot create shortcut to element " + underlyingModelObject + " on diagram " + containerView, createShortcutCommand != null && createShortcutCommand.canExecute());
		CreateListener listener = new CreateListener(NotationPackage.eINSTANCE.getNode());
		containerView.eAdapters().add(listener);
		try {
			new EMFCommandOperation(TransactionUtil.getEditingDomain(containerView), createShortcutCommand).execute(new NullProgressMonitor(), null);
		} finally {
			containerView.eAdapters().remove(listener);
		}
		assertSame(createShortcutCommand.getCreatedView(), listener.getCreatedChild());
		Node createdShortcut = (Node) listener.getCreatedChild();
		assertEquals(EcoreUtil.getURI(underlyingModelObject), EcoreUtil.getURI(createdShortcut.getElement()));
		assertSame(TransactionUtil.getEditingDomain(containerView.getElement()), TransactionUtil.getEditingDomain(createdShortcut.getElement()));
		assertNotNull(createdShortcut.getEAnnotation("Shortcut"));
		return createdShortcut;
	}

	private View findView(View container, EObject child) {
		for(Iterator<?> it = container.getChildren().iterator(); it.hasNext(); ) {
			View next = (View) it.next();
			if (child.equals(next.getElement())) {
				return next;
			}
		}
		return null;
	}
}
