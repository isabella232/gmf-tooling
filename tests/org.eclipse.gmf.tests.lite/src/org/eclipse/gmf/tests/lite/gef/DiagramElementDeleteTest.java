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
package org.eclipse.gmf.tests.lite.gef;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;


public class DiagramElementDeleteTest extends GeneratedCanvasTest {
	public DiagramElementDeleteTest(String name) {
		super(name);
	}

	public void testReferencesToDeletedElement() throws Exception {
		GenNode metaBook = getSetup().getGenModel().getNodeB();
		Node book1Node = createNode(metaBook, getDiagram());
		EObject book1 = book1Node.getElement();
		NodeEditPart book1EP = (NodeEditPart) findEditPart(book1Node);
		GenNode metaWriter = getSetup().getGenModel().getNodeA();
		Node writer1Node = createNode(metaWriter, getDiagram());
		EObject writer1 = writer1Node.getElement();
		NodeEditPart writer1EP = (NodeEditPart) findEditPart(writer1Node);
		EStructuralFeature authorFeature = book1.eClass().getEStructuralFeature("author");
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getDiagram().getElement());
		Command setWriterCommand = SetCommand.create(editingDomain, book1, authorFeature, writer1);
		new EMFCommandOperation(editingDomain, setWriterCommand).execute(new NullProgressMonitor(), null);
		List<?> book1OutgoingLinks = book1EP.getSourceConnections();
		assertEquals(1, book1OutgoingLinks.size());
		ConnectionEditPart book1AuthorLinkEP = (ConnectionEditPart) book1OutgoingLinks.get(0);
		Edge book1AuthorEdge = (Edge) book1AuthorLinkEP.getModel();

		GroupRequest deleteRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteRequest.setEditParts(writer1EP);
		org.eclipse.gef.commands.Command command = writer1EP.getCommand(deleteRequest);
		assertNotNull(command);
		if (!command.canExecute()) {
			System.out.println("The returned command is " + command);
		}
		assertTrue(command.canExecute());
		execute(command);

		assertNull(book1.eGet(authorFeature));
		assertNull(book1AuthorEdge.eResource());
	}

	public void testIncomingTypeLinksToDeletedElement() throws Exception {
		GenNode metaBook = getSetup().getGenModel().getNodeB();
		Node book1Node = createNode(metaBook, getDiagram());
		NodeEditPart book1EP = (NodeEditPart) findEditPart(book1Node);
		GenNode metaWriter = getSetup().getGenModel().getNodeA();
		Node writer1Node = createNode(metaWriter, getDiagram());
		NodeEditPart writer1EP = (NodeEditPart) findEditPart(writer1Node);
		GenLink metaOpinion = getSetup().getGenModel().getLinkC();
		Edge opinion1Edge = createLink(metaOpinion, writer1Node, book1Node);
		EObject opinion1 = opinion1Edge.getElement();
		List<?> writer1OutgoingLinks = writer1EP.getSourceConnections();
		assertEquals(1, writer1OutgoingLinks.size());
		ConnectionEditPart opinion1LinkEP = (ConnectionEditPart) writer1OutgoingLinks.get(0);
		assertSame(opinion1Edge, opinion1LinkEP.getModel());

		GroupRequest deleteRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteRequest.setEditParts(book1EP);
		org.eclipse.gef.commands.Command command = book1EP.getCommand(deleteRequest);
		assertNotNull(command);
		assertTrue(command.canExecute());
		execute(command);

		assertNull(opinion1Edge.eResource());
		assertNull(opinion1.eResource());
	}
}
