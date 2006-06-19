/**
 * Copyright (c) 2006 Eclipse.org
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

import java.util.Iterator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.RuntimeDiagramTestBase;

public class NotationRefreshTest extends RuntimeDiagramTestBase {
	public NotationRefreshTest(String name) {
		super(name);
	}

	public void testNotationRefreshOnDeleteNode() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		View nodeA = getCanvasInstance().getNodeA();
		EObject elementA = nodeA.getElement();
		EditPart editPartA = findEditPart(nodeA);
		Command command = RemoveCommand.create(editingDomain, elementA.eContainer(), elementA.eContainingFeature(), elementA);
		assertTrue("Failed to obtain command to remove an instance of the domain model element", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertNull("RemoveCommand not executed properly", elementA.eContainer());
		assertNull("Notational refresh failed on domain element removal", findView(diagram, elementA));
		assertNull("EditPart not removed automatically", findEditPart(nodeA));
		assertFalse(editPartA.isActive());
	}

	public void testNotationRefreshOnCreateNode() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		EStructuralFeature feature = getCanvasInstance().getNodeA().getElement().eContainmentFeature();
		EClass newChildClass = getCanvasInstance().getNodeA().getElement().eClass();
		EObject newChild = newChildClass.getEPackage().getEFactoryInstance().create(newChildClass);
		
		Command command = AddCommand.create(editingDomain, diagramElement, feature, newChild);
		assertTrue("Failed to obtain command to create a new instance of the domain model element", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertSame("AddCommand not executed properly", diagramElement, newChild.eContainer());
		View newChildView = findView(diagram, newChild);
		assertNotNull("Notational refresh failed on domain element creation", newChildView);
		int visualId = getType(newChildView);
		assertEquals(getGenModel().getNodeA().getVisualID(), visualId);
		EditPart newChildEP = findEditPart(newChildView);
		assertNotNull("EditPart not created automatically", newChildEP);
	}

	public void testNotationRefreshOnAttributeChangeThatAffectsSelector() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();
		Bounds bounds = (Bounds) nodeB.getLayoutConstraint();
		Rectangle rectangle = new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		assertEquals("Unexpected visual ID of the element", getGenModel().getNodeB().getVisualID(), getType(nodeB));
		EObject elementB = nodeB.getElement();
		EditPart editPartB = findEditPart(nodeB);
		EClass elementBClass = elementB.eClass();
		EStructuralFeature feature = elementBClass.getEStructuralFeature("pages");	//$NON-NLS-1$
		assertNotNull("Failed to find the feature that affects selector", feature);
		Integer newValue = new Integer(200);
		Command command = SetCommand.create(editingDomain, elementB, feature, newValue);
		assertTrue("Failed to obtain command to make a change that affects selector", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertEquals("SetCommand not executed properly", newValue, elementB.eGet(feature));
		Node newNodeB = (Node) findView(diagram, elementB);
		assertNotNull("Notational refresh failed to recreate a new node upon a change that affects selector", newNodeB);
		assertNotSame("Notational refresh failed to replace a new node upon a change that affects selector", nodeB, newNodeB);
		assertTrue("Notational refresh failed to change visual ID of the element upon a change that affects selector", getGenModel().getNodeB().getVisualID() != getType(newNodeB));
		EditPart newEditPartB = findEditPart(newNodeB);
		assertNotNull("EditPart not recreated automatically", newEditPartB);
		assertNotSame("EditPart not replaced automatically", editPartB, newEditPartB);
		assertFalse(editPartB.isActive());
		assertTrue(newEditPartB.isActive());
		Bounds newBounds = (Bounds) newNodeB.getLayoutConstraint();
		Rectangle newRectangle = new Rectangle(newBounds.getX(), newBounds.getY(), newBounds.getWidth(), newBounds.getHeight());
		assertEquals("Notational refresh failed to position the new node where the old one was", rectangle, newRectangle);
	}

	private int getType(View view) {
		return Integer.parseInt(view.getType());
	}

	private View findView(View container, EObject child) {
		for(Iterator it = container.getChildren().iterator(); it.hasNext(); ) {
			View next = (View) it.next();
			if (child.equals(next.getElement())) {
				return next;
			}
		}
		return null;
	}
}
