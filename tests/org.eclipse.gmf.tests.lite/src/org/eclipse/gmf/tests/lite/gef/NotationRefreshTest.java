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

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicEList;
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
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;

public class NotationRefreshTest extends GeneratedCanvasTest {
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
		assertEquals(getSetup().getGenModel().getNodeA().getVisualID(), visualId);
		EditPart newChildEP = findEditPart(newChildView);
		assertNotNull("EditPart not created automatically", newChildEP);
	}

	public void testNotationRefreshOnCreateDirectChildNode() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();
		EObject elementB = nodeB.getElement();
		EStructuralFeature directNodeFeature = elementB.eClass().getEStructuralFeature("chapters");
		assertNotNull("Child feature not found", directNodeFeature);
		EClass chapterClass = (EClass) directNodeFeature.getEType();
		EObject chapter = chapterClass.getEPackage().getEFactoryInstance().create(chapterClass);
		Command command = AddCommand.create(editingDomain, elementB, directNodeFeature, chapter);
		assertTrue("Failed to obtain command to create a new instance of the domain model element", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertSame("AddCommand not executed properly", elementB, chapter.eContainer());
		View newChildView = findView(nodeB, chapter);
		assertNotNull("Notational refresh failed on domain element creation", newChildView);
		EditPart newChildEP = findEditPart(newChildView);
		assertNotNull("EditPart not created automatically", newChildEP);
	}

	public void testNotationRefreshOnAttributeChangeThatAffectsSelector() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();
		EObject elementB = nodeB.getElement();
		Bounds bounds = (Bounds) nodeB.getLayoutConstraint();
//		if (bounds == null) {
//			bounds = NotationFactory.eINSTANCE.createBounds();
//		}
		Rectangle rectangle = new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
		assertEquals("Unexpected visual ID of the element", getSetup().getGenModel().getNodeB().getVisualID(), getType(nodeB));
		EditPart editPartB = findEditPart(nodeB);
		Edge edge1 = getCanvasInstance().getLinkByClass();
		EObject edge1DomainElement = edge1.getElement();
		Edge edge2 = getCanvasInstance().getLinkByRef();
		checkLinkEnd(edge1, nodeB);
		checkLinkEnd(edge2, nodeB);
		EditPart edge1EP = findEditPart(edge1);
		EditPart edge2EP = findEditPart(edge2);
		assertTrue(edge1EP.isActive());
		assertTrue(edge2EP.isActive());
		EClass elementBClass = elementB.eClass();
		EStructuralFeature feature = elementBClass.getEStructuralFeature("pages");	//$NON-NLS-1$
		assertNotNull("Failed to find the feature that affects selector", feature);
		Integer newValue = new Integer(400);
		Command command = SetCommand.create(editingDomain, elementB, feature, newValue);
		assertTrue("Failed to obtain command to make a change that affects selector", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertEquals("SetCommand not executed properly", newValue, elementB.eGet(feature));
		Node newNodeB = (Node) findView(diagram, elementB);
		assertNotNull("Notational refresh failed to recreate a new node upon a change that affects selector", newNodeB);
		assertNotSame("Notational refresh failed to replace a new node upon a change that affects selector", nodeB, newNodeB);
		assertTrue("Notational refresh failed to change visual ID of the element upon a change that affects selector", getSetup().getGenModel().getNodeB().getVisualID() != getType(newNodeB));
		EditPart newEditPartB = findEditPart(newNodeB);
		assertNotNull("EditPart not recreated automatically", newEditPartB);
		assertNotSame("EditPart not replaced automatically", editPartB, newEditPartB);
		assertFalse(editPartB.isActive());
		assertTrue(newEditPartB.isActive());
		Bounds newBounds = (Bounds) newNodeB.getLayoutConstraint();
//		if (newBounds == null) {
//			newBounds = NotationFactory.eINSTANCE.createBounds();
//		}
		Rectangle newRectangle = new Rectangle(newBounds.getX(), newBounds.getY(), newBounds.getWidth(), newBounds.getHeight());
		assertEquals("Notational refresh failed to position the new node where the old one was", rectangle, newRectangle);
		assertFalse(edge2EP.isActive());
		Node nodeA = getCanvasInstance().getNodeA();
		Edge newEdge2 = findEdgeWithoutElement(diagram, newNodeB, nodeA, 0);
		assertNotNull("Failed to find the new representation of edge-without-class", newEdge2);
		EditPart newEdge2EP = findEditPart(newEdge2);
		assertNotNull("Link EditPart not recreated automatically", newEdge2EP);
		assertNotSame("Link EditPart not replaced automatically", newEdge2EP, edge2EP);
		assertTrue(newEdge2EP.isActive());
		checkLinkEnd(newEdge2, newNodeB);
		assertFalse(edge1EP.isActive());	//Should have been replaced
		//checkLinkEnd(edge1, newNodeB);
		Edge newEdge1 = findEdgeWithElement(diagram, edge1DomainElement);
		assertNotNull("Failed to find the new representation of edge-with-class", newEdge1);
		EditPart newEdge1EP = findEditPart(newEdge1);
		assertNotNull("Link EditPart not recreated automatically", newEdge1EP);
		assertNotSame("Link EditPart not replaced automatically", newEdge1EP, edge1EP);
		assertTrue(newEdge1EP.isActive());
		checkLinkEnd(newEdge1, newNodeB);
	}

	public void testNotationRefreshOnSemanticRerouteWithClass() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();	//book
		Node nodeA = getCanvasInstance().getNodeA();	//writer
		EditPart bookEP = findEditPart(nodeB);
		EditPart writerEP = findEditPart(nodeA);
		assertNotNull(bookEP);
		assertNotNull(writerEP);
		Edge opinionsEdge = getCanvasInstance().getLinkByClass();
		EObject opinion = opinionsEdge.getElement();
		EditPart opinionEP = findEditPart(opinionsEdge);
		checkLinkEnd(opinionsEdge, nodeA);
		checkLinkEnd(opinionsEdge, nodeB);
		//0. Create one element of each type
		EClass writerClass = nodeA.getElement().eClass();
		EObject newWriter = writerClass.getEPackage().getEFactoryInstance().create(writerClass);
		Command writerCommand = AddCommand.create(editingDomain, diagramElement, nodeA.getElement().eContainmentFeature(), newWriter);
		EClass bookClass = nodeB.getElement().eClass();
		EObject newBook = bookClass.getEPackage().getEFactoryInstance().create(bookClass);
		Command bookCommand = AddCommand.create(editingDomain, diagramElement, nodeB.getElement().eContainmentFeature(), newBook);
		new EMFCommandOperation(editingDomain, writerCommand).execute(new NullProgressMonitor(), null);
		new EMFCommandOperation(editingDomain, bookCommand).execute(new NullProgressMonitor(), null);
		Node nodeA1 = (Node) findView(diagram, newWriter);
		Node nodeB1 = (Node) findView(diagram, newBook);
		//1. Check reroute target of a link-by-class.
		EStructuralFeature targetByClassFeature = opinion.eClass().getEStructuralFeature("book");
		Command command = SetCommand.create(editingDomain, opinion, targetByClassFeature, newBook);
		assertTrue("Failed to create semantic reroute command", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertSame("Command not executed", newBook, opinion.eGet(targetByClassFeature));
		assertTrue(opinionEP.isActive());
		checkLinkEnd(opinionsEdge, nodeA);
		checkLinkEnd(opinionsEdge, nodeB1);
		//2. Check reroute source of a link-by-class.
		EStructuralFeature sourceByClassFeature = opinion.eClass().getEStructuralFeature("writer");
		command = SetCommand.create(editingDomain, opinion, sourceByClassFeature, newWriter);
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertSame("Command not executed", newWriter, opinion.eGet(sourceByClassFeature));
		assertTrue(opinionEP.isActive());
		checkLinkEnd(opinionsEdge, nodeA1);
		checkLinkEnd(opinionsEdge, nodeB1);
	}

	public void testNotationRefreshOnSemanticRerouteWithFeature() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();	//book
		Node nodeA = getCanvasInstance().getNodeA();	//writer
		EditPart bookEP = findEditPart(nodeB);
		EditPart writerEP = findEditPart(nodeA);
		assertNotNull(bookEP);
		assertNotNull(writerEP);
		Edge author = getCanvasInstance().getLinkByRef();
		checkLinkEnd(author, nodeA);
		checkLinkEnd(author, nodeB);
		EditPart authorEP = findEditPart(author);
		//0. Create one element of each type
		EClass writerClass = nodeA.getElement().eClass();
		final EObject newWriter = writerClass.getEPackage().getEFactoryInstance().create(writerClass);
		Command writerCommand = AddCommand.create(editingDomain, diagramElement, nodeA.getElement().eContainmentFeature(), newWriter);
		EClass bookClass = nodeB.getElement().eClass();
		final EObject newBook = bookClass.getEPackage().getEFactoryInstance().create(bookClass);
		Command bookCommand = AddCommand.create(editingDomain, diagramElement, nodeB.getElement().eContainmentFeature(), newBook);
		new EMFCommandOperation(editingDomain, writerCommand).execute(new NullProgressMonitor(), null);
		new EMFCommandOperation(editingDomain, bookCommand).execute(new NullProgressMonitor(), null);
		Node nodeA1 = (Node) findView(diagram, newWriter);
		Node nodeB1 = (Node) findView(diagram, newBook);
		//1. Check reroute target of a link-by-class.
		EStructuralFeature targetFeature = nodeB.getElement().eClass().getEStructuralFeature("author");
		Command command = SetCommand.create(editingDomain, nodeB.getElement(), targetFeature, newWriter);
		assertTrue("Failed to create semantic reroute command", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertSame("Command not executed", newWriter, nodeB.getElement().eGet(targetFeature));
		assertTrue(authorEP.isActive());
		checkLinkEnd(author, nodeA1);
		checkLinkEnd(author, nodeB);
		//2. Check reroute source of a link-by-class.
		EStructuralFeature sourceFeature = nodeA.getElement().eClass().getEStructuralFeature("books");
		final Command rerouteSourceCommand = SetCommand.create(editingDomain, newWriter, sourceFeature, new BasicEList(Collections.singleton(newBook)));
		//workaround: command.canExecute() fails with an exception, because it actually attempts to modify elements without a write transaction.
		new EMFCommandOperation(editingDomain, new AbstractCommand() {
			public boolean canExecute() {
				return true;
			}
			public void redo() {
			}
			public void execute() {
				assertTrue(rerouteSourceCommand != null && rerouteSourceCommand.canExecute());
			}
		}).execute(new NullProgressMonitor(), null);
		new EMFCommandOperation(editingDomain, rerouteSourceCommand).execute(new NullProgressMonitor(), null);
		assertNull("Command not executed", nodeB.getElement().eGet(targetFeature));
		assertSame("Command not executed", newWriter, nodeB1.getElement().eGet(targetFeature));
		assertFalse(authorEP.isActive());
		Edge newAuthor = findEdgeWithoutElement(diagram, nodeB1, nodeA1, 0);
		assertNotNull(newAuthor);
		EditPart newAuthorEP = findEditPart(newAuthor);
		assertNotNull(newAuthorEP);
		assertTrue(newAuthorEP.isActive());
	}

	public void testNotationRefreshOnDeleteLink() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();	//book
		Node nodeA = getCanvasInstance().getNodeA();	//writer
		EditPart bookEP = findEditPart(nodeB);
		EditPart writerEP = findEditPart(nodeA);
		assertNotNull(bookEP);
		assertNotNull(writerEP);
		Edge author = getCanvasInstance().getLinkByRef();
		checkLinkEnd(author, nodeA);
		checkLinkEnd(author, nodeB);
		EditPart authorEP = findEditPart(author);
		assertNotNull(authorEP);
		assertTrue(authorEP.isActive());
		EStructuralFeature targetFeature = nodeB.getElement().eClass().getEStructuralFeature("author");
		assertSame(nodeA.getElement(), nodeB.getElement().eGet(targetFeature));
		final Command command = SetCommand.create(editingDomain, nodeB.getElement(), targetFeature, SetCommand.UNSET_VALUE);
		//workaround: command.canExecute() fails with an exception, because it actually attempts to modify elements without a write transaction.
		new EMFCommandOperation(editingDomain, new AbstractCommand() {
			public boolean canExecute() {
				return true;
			}
			public void redo() {
			}
			public void execute() {
				assertTrue("Failed to create remove semantic link command", command != null && command.canExecute());
			}
		}).execute(new NullProgressMonitor(), null);
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertNull("Command not executed", nodeB.getElement().eGet(targetFeature));
		assertNull(author.eContainer());
		assertFalse(authorEP.isActive());
	}

	public void testNotationRefreshOnSemanticRerouteLinkToNowhere() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();	//book
		Node nodeA = getCanvasInstance().getNodeA();	//writer
		EditPart bookEP = findEditPart(nodeB);
		EditPart writerEP = findEditPart(nodeA);
		assertNotNull(bookEP);
		assertNotNull(writerEP);
		Edge opinionsEdge = getCanvasInstance().getLinkByClass();
		EObject opinion = opinionsEdge.getElement();
		EditPart opinionEP = findEditPart(opinionsEdge);
		checkLinkEnd(opinionsEdge, nodeA);
		checkLinkEnd(opinionsEdge, nodeB);
		EStructuralFeature targetByClassFeature = opinion.eClass().getEStructuralFeature("book");
		Command command = SetCommand.create(editingDomain, opinion, targetByClassFeature, SetCommand.UNSET_VALUE);
		assertTrue("Failed to create semantic reroute command", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertNull("Command not executed", opinion.eGet(targetByClassFeature));
		assertFalse(opinionEP.isActive());
		assertNull(opinionsEdge.eContainer());
	}

	public void testNotationRefreshOnCreateLink() throws Exception {
		EditPart diagramEP = getDiagramEditPart();
		Diagram diagram = (Diagram) diagramEP.getModel();
		EObject diagramElement = diagram.getElement();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagramElement);
		Node nodeB = getCanvasInstance().getNodeB();	//book
		Node nodeA = getCanvasInstance().getNodeA();	//writer
		EditPart bookEP = findEditPart(nodeB);
		EditPart writerEP = findEditPart(nodeA);
		assertNotNull(bookEP);
		assertNotNull(writerEP);
		EClass bookClass = nodeB.getElement().eClass();
		final EObject newBook = bookClass.getEPackage().getEFactoryInstance().create(bookClass);
		Command bookCommand = AddCommand.create(editingDomain, diagramElement, nodeB.getElement().eContainmentFeature(), newBook);
		new EMFCommandOperation(editingDomain, bookCommand).execute(new NullProgressMonitor(), null);
		Node nodeB1 = (Node) findView(diagram, newBook);
		EStructuralFeature targetFeature = nodeB.getElement().eClass().getEStructuralFeature("author");
		Command command = SetCommand.create(editingDomain, newBook, targetFeature, nodeA.getElement());
		assertTrue("Failed to create create semantic link command", command != null && command.canExecute());
		new EMFCommandOperation(editingDomain, command).execute(new NullProgressMonitor(), null);
		assertSame("Command not executed", nodeA.getElement(), newBook.eGet(targetFeature));
		Edge newAuthor = findEdgeWithoutElement(diagram, nodeB1, nodeA, 0);
		assertNotNull("Failed to create edge in response to semantic link creation", newAuthor);
		checkLinkEnd(newAuthor, nodeA);
		checkLinkEnd(newAuthor, nodeB1);
		EditPart newAuthorEP = findEditPart(newAuthor);
		assertNotNull(newAuthorEP);
		assertTrue(newAuthorEP.isActive());
	}

	private void checkLinkEnd(Edge edge, Node node) {
		assertTrue(node.equals(edge.getSource()) || node.equals(edge.getTarget()));
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

	private Edge findEdgeWithElement(Diagram diagram, EObject element) {
		for(Iterator it = diagram.getEdges().iterator(); it.hasNext(); ) {
			Edge next = (Edge) it.next();
			if (next.isSetElement() && next.getElement() == element) {
				return next;
			}
		}
		return null;
	}

	private Edge findEdgeWithoutElement(Diagram diagram, View source, View target, int index) {
		int count = 0;
		for(Iterator it = diagram.getEdges().iterator(); it.hasNext(); ) {
			Edge next = (Edge) it.next();
			if (next.isSetElement() && next.getElement() == null) {
				if (next.getSource() == source && next.getTarget() == target) {
					if (count == index) {
						return next;
					}
					count++;
				}
			}
		}
		return null;
	}
}
