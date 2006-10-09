/**
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gef;

import java.util.Collection;

import junit.framework.Assert;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;

public class DiagramNodeCloneMoveTest extends GeneratedCanvasTest {
	public DiagramNodeCloneMoveTest(String name) {
		super(name);
	}

	public void testClone() throws Exception {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		assertTrue("Incorrect Setup: passed node has no compartments", nodeB.getCompartments().size() > 0);
		GenCompartment genCompartment = (GenCompartment) nodeB.getCompartments().get(0);
		assertTrue("Incorrect Setup: passed node has no children", genCompartment.getChildNodes().size() > 0);

		GenNode childNode = (GenNode) genCompartment.getChildNodes().get(0);
		
		Node nodeBInstance = getCanvasInstance().getNodeB();
		Diagram diagram = nodeBInstance.getDiagram();
		Node clonedB = checkClone(nodeBInstance, diagram, diagram, nodeB, nodeB);

		//Check child
		Node level1Child = createNodeIndirect(childNode, getCanvasInstance().getNodeBCompartment());
		assertNotNull("Level1 ChildNode was not created", level1Child);
		Node clonedLevel1Child = checkClone(level1Child, getCanvasInstance().getNodeBCompartment(), getCanvasInstance().getNodeBCompartment(), childNode, childNode);

		Node clonedBCompartment = (Node) findChildView(clonedB, genCompartment);
		//Finally, check cloning to another element.
		checkClone(clonedLevel1Child, clonedBCompartment, getCanvasInstance().getNodeBCompartment(), childNode, childNode);
	}

	public void testMove() throws Exception {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		assertTrue("Incorrect Setup: passed node has no compartments", nodeB.getCompartments().size() > 0);
		GenCompartment genCompartment = (GenCompartment) nodeB.getCompartments().get(0);
		assertTrue("Incorrect Setup: passed node has no children", genCompartment.getChildNodes().size() > 0);

		GenNode childNode = (GenNode) genCompartment.getChildNodes().get(0);
		
		Node nodeBInstance = getCanvasInstance().getNodeB();
		Diagram diagram = nodeBInstance.getDiagram();
		Node clonedB = checkClone(nodeBInstance, diagram, diagram, nodeB, nodeB);

		Node level1Child = createNodeIndirect(childNode, getCanvasInstance().getNodeBCompartment());
		assertNotNull("Level1 ChildNode was not created", level1Child);

		Node clonedBCompartment = (Node) findChildView(clonedB, genCompartment);
		checkMove(level1Child, clonedBCompartment, getCanvasInstance().getNodeBCompartment(), childNode, childNode);
	}

	public void testCloneWithVisualIDChange() throws Exception {
		GenNode nodeA = getSetup().getGenModel().getNodeA();
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		GenCompartment genCompartment = (GenCompartment) nodeA.getCompartments().get(0);
		assertNotNull("Node A has no compartments", genCompartment);
		GenNode nodeBAsChildOfA = (GenNode) genCompartment.getChildNodes().get(0);
		assertNotNull("Node A compartment has no children", nodeBAsChildOfA);
		assertEquals("Incorrect child", nodeB.getModelFacet().getMetaClass().getEcoreClass().getName(), nodeBAsChildOfA.getModelFacet().getMetaClass().getEcoreClass().getName());
		Node nodeAInstance = getCanvasInstance().getNodeA();
		Node compartmentA =  (Node) findChildView(nodeAInstance, genCompartment);
		assertNotNull("Compartment not found", compartmentA);
		Node nodeBInstance = getCanvasInstance().getNodeB();
		Diagram diagram = nodeBInstance.getDiagram();
		checkClone(nodeBInstance, compartmentA, diagram, nodeB, nodeBAsChildOfA);
	}

	public void testMoveWithVisualIDChange() throws Exception {
		GenNode nodeA = getSetup().getGenModel().getNodeA();
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		GenCompartment genCompartment = (GenCompartment) nodeA.getCompartments().get(0);
		assertNotNull("Node A has no compartments", genCompartment);
		GenNode nodeBAsChildOfA = (GenNode) genCompartment.getChildNodes().get(0);
		assertNotNull("Node A compartment has no children", nodeBAsChildOfA);
		assertSame("Incorrect child", nodeB.getModelFacet().getMetaClass(), nodeBAsChildOfA.getModelFacet().getMetaClass());
		Node nodeAInstance = getCanvasInstance().getNodeA();
		Node compartmentA =  (Node) findChildView(nodeAInstance, genCompartment);
		assertNotNull("Compartment not found", compartmentA);
		Node nodeBInstance = getCanvasInstance().getNodeB();
		Diagram diagram = nodeBInstance.getDiagram();
		checkMove(nodeBInstance, compartmentA, diagram, nodeB, nodeBAsChildOfA);
	}

	private Node checkClone(Node node, View newContainer, View originalContainer, GenNode originalGenNode, GenNode expectedGenNode) {
		assertEquals(originalGenNode.getVisualID(), Integer.parseInt(node.getType()));
		EditPart nodeEP = findEditPart(node);
		assertNotNull(nodeEP);
		assertTrue(nodeEP.isActive());
		checkContainment(node, originalContainer, originalGenNode.getModelFacet().getContainmentMetaFeature(), originalGenNode.getModelFacet().getChildMetaFeature());
		Node clone = cloneOrMoveNode(node, newContainer, true);
		assertNotNull("Clone command returned null", clone);
		assertEquals(expectedGenNode.getVisualID(), Integer.parseInt(clone.getType()));
		EditPart clonedEP = findEditPart(clone);
		assertNotNull("Failed to find the edit part for the cloned node", clonedEP);
		assertTrue(clonedEP.isActive());
		checkContainment(clone, newContainer, expectedGenNode.getModelFacet().getContainmentMetaFeature(), expectedGenNode.getModelFacet().getChildMetaFeature());
		assertTrue(nodeEP.isActive());
		//make sure clone has not affected the original node.
		checkContainment(node, originalContainer, originalGenNode.getModelFacet().getContainmentMetaFeature(), originalGenNode.getModelFacet().getChildMetaFeature());
		return clone;
	}

	private Node checkMove(Node node, View newContainer, View originalContainer, GenNode originalGenNode, GenNode expectedGenNode) {
		assertEquals(originalGenNode.getVisualID(), Integer.parseInt(node.getType()));
		EditPart nodeEP = findEditPart(node);
		assertNotNull(nodeEP);
		assertTrue(nodeEP.isActive());
		checkContainment(node, originalContainer, originalGenNode.getModelFacet().getContainmentMetaFeature(), originalGenNode.getModelFacet().getChildMetaFeature());
		Node moved = cloneOrMoveNode(node, newContainer, false);
		assertNotNull("Move command returned null", moved);
		assertEquals(expectedGenNode.getVisualID(), Integer.parseInt(moved.getType()));
		EditPart movedEP = findEditPart(moved);
		assertNotNull("Failed to find the edit part for the cloned node", movedEP);
		assertTrue(movedEP.isActive());
		checkContainment(moved, newContainer, expectedGenNode.getModelFacet().getContainmentMetaFeature(), expectedGenNode.getModelFacet().getChildMetaFeature());
		assertFalse(nodeEP.isActive());
		//make sure clone has removed the original node.
		assertFalse(originalContainer.getChildren().contains(node));
		//Do not check that the node is uncontained. Implementation may move the node by actually placing the same instance to another place. 
//		checkContainment(node, null, originalGenNode.getModelFacet().getContainmentMetaFeature(), originalGenNode.getModelFacet().getChildMetaFeature());
		return moved;
	}

	private void checkContainment(View child, View parent, GenFeature containmentMetaFeature, GenFeature childMetaFeature) {
		assertSame("Incorrect notation-model containment", parent, child.eContainer());
		EObject childEObject = child.getElement();
		if (parent == null) {
			assertNull("Incorrect domain-model containment", childEObject.eContainer());
			return;
		}
		EObject parentEObject = parent.getElement();
		assertSame("Incorrect domain-model containment", parentEObject, childEObject.eContainer());
		EStructuralFeature containmentFeature = parentEObject.eClass().getEStructuralFeature(containmentMetaFeature.getEcoreFeature().getName());
		assertNotNull("Failed to find containment feature", containmentFeature);
		assertSame("Incorrect domain-model containment feature", containmentFeature, childEObject.eContainmentFeature());
		if (childMetaFeature != null) {
			EStructuralFeature childFeature = parentEObject.eClass().getEStructuralFeature(childMetaFeature.getEcoreFeature().getName());
			assertNotNull("Failed to find child feature", childFeature);
			assertTrue("Child feature not set", ((Collection)parentEObject.eGet(childFeature)).contains(childEObject));
		}
	}

	@SuppressWarnings("unchecked")
	private Node cloneOrMoveNode(Node node, View container, boolean isCloneNotMove) {
		final Object[] resultHolder = new Object[1];
		EditPart containerEP = findEditPart(container);
		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD) {
					resultHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		EditPart nodeEP = findEditPart(node);
		assertNotNull("No edit part available for the node being cloned", nodeEP);
		Command cmd = null;
		if (!isCloneNotMove) {
			ChangeBoundsRequest orphanRequest = new ChangeBoundsRequest(RequestConstants.REQ_ORPHAN);
			orphanRequest.setLocation(new Point(0, 0));
			orphanRequest.setEditParts(nodeEP);
			cmd = nodeEP.getCommand(orphanRequest);
		}
		ChangeBoundsRequest cloneRequest = new ChangeBoundsRequest(isCloneNotMove ? RequestConstants.REQ_CLONE : RequestConstants.REQ_ADD);
		cloneRequest.setLocation(new Point(0,0));
		cloneRequest.setEditParts(nodeEP);
		cmd = merge(cmd, containerEP.getCommand(cloneRequest));
		Assert.assertNotNull("No command is available for request", cmd); //$NON-NLS-1$		
		container.eAdapters().add(adapter);
		try {
			execute(cmd);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$			
		} finally {
			container.eAdapters().remove(adapter);
		}
		assertTrue("Failed to create notation model Node", resultHolder[0] instanceof Node); //$NON-NLS-1$
		return (Node) resultHolder[0];
	}

	/**
	 * The setup we use does not provide palette, so direct node creation is impossible.
	 * Workaround by creating the node in the domain model.
	 * Works only if the created domain node is in the same EPackage as the container node.
	 */
	protected Node createNodeIndirect(GenNode nodeType, View notationContainer) {
		final Object[] resultHolder = new Object[1];
		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD) {
					resultHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		EObject container = notationContainer.getElement();
		assertNotNull(container);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(container);
		EPackage ePackage = container.eClass().getEPackage();
		EObject createdElement = ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier(nodeType.getDomainMetaClass().getEcoreClass().getName()));
		CompoundCommand compoundCommand = new CompoundCommand();
		EStructuralFeature containmentFeature = container.eClass().getEStructuralFeature(nodeType.getModelFacet().getContainmentMetaFeature().getEcoreFeature().getName());
		assertNotNull(containmentFeature);
		compoundCommand.append(AddCommand.create(editingDomain, container, containmentFeature, createdElement));
		EStructuralFeature childFeature = container.eClass().getEStructuralFeature(nodeType.getModelFacet().getChildMetaFeature().getEcoreFeature().getName());
		if (childFeature != null && !childFeature.isDerived() && childFeature != containmentFeature) {
			compoundCommand.append(AddCommand.create(editingDomain, container, childFeature, createdElement));
		}
		assertTrue(compoundCommand.canExecute());
		notationContainer.eAdapters().add(adapter);
		try {
			new EMFCommandOperation(editingDomain, compoundCommand).execute(new NullProgressMonitor(), null);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			notationContainer.eAdapters().remove(adapter);
		}
		assertTrue("Failed to indirectly create notation model Node", resultHolder[0] instanceof Node); //$NON-NLS-1$
		return (Node) resultHolder[0];
	}

	private Command merge(Command one, Command another) {
		if (one == null) {
			return another;
		}
		if (another == null) {
			return one;
		}
		return one.chain(another);
	}
}
