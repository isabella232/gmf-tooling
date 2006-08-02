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

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class DiagramElementTest extends GeneratedCanvasTest {
	public DiagramElementTest(String name) {
		super(name);
	}

	private static final Rectangle NODE_1_BOUNDS = new Rectangle(10, 10, 100, 100);
	private static final Rectangle NODE_2_BOUNDS = new Rectangle(200, 200, 150, 150);
	private static final Rectangle NODE_3_BOUNDS = new Rectangle(400, 570, 70, 70);

	public void testAlignNodes() {
		Node createdNode1 = createNode(getSetup().getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNode1);
		moveNode(createdNode1, NODE_1_BOUNDS);
		EditPart ep1 = findEditPart(createdNode1);
		Node createdNode2 = createNode(getSetup().getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNode2);
		moveNode(createdNode2, NODE_2_BOUNDS);
		EditPart ep2 = findEditPart(createdNode2);
		Node createdNode3 = createNode(getSetup().getGenModel().getNodeA(), getCanvasInstance().getCanvas());
		assertNotNull("Node not created", createdNode3);
		moveNode(createdNode3, NODE_3_BOUNDS);
		EditPart ep3 = findEditPart(createdNode3);
		align(Arrays.asList(new EditPart[] {ep2, ep3, ep1}), PositionConstants.LEFT);
		checkBounds(createdNode1, NODE_1_BOUNDS);
		checkBounds(createdNode2, new Rectangle(10, 200, 150, 150));
		checkBounds(createdNode3, new Rectangle(10, 570, 70, 70));
		getCommandStack().undo();
		align(Arrays.asList(new EditPart[] {ep1, ep3, ep2}), PositionConstants.RIGHT);
		checkBounds(createdNode1, new Rectangle(250, 10, 100, 100));
		checkBounds(createdNode2, NODE_2_BOUNDS);
		checkBounds(createdNode3, new Rectangle(280, 570, 70, 70));
		getCommandStack().undo();
		align(Arrays.asList(new EditPart[] {ep1, ep2, ep3}), PositionConstants.BOTTOM);
		checkBounds(createdNode1, new Rectangle(10, 540, 100, 100));
		checkBounds(createdNode2, new Rectangle(200, 490, 150, 150));
		checkBounds(createdNode3, NODE_3_BOUNDS);
		getCommandStack().undo();
	}

	private void layout(IFigure parentFigure) {
		parentFigure.getLayoutManager().layout(parentFigure);
	}

	private void moveNode(Node node, Rectangle bounds) {
		assertTrue("Unexpected layout constraint", node.getLayoutConstraint() instanceof Bounds);
		Bounds nodeBounds = (Bounds) node.getLayoutConstraint();
		Rectangle original = new Rectangle(nodeBounds.getX(), nodeBounds.getY(), nodeBounds.getWidth(), nodeBounds.getHeight());
		GraphicalEditPart editPart = (GraphicalEditPart) findEditPart(node);
		assertNotNull("Missing editpart for the node", editPart);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setMoveDelta(bounds.getTopLeft().translate(original.getTopLeft().negate()));
		req.setSizeDelta(bounds.getSize().getDifference(original.getSize()));
		req.setEditParts(editPart);
		req.setResizeDirection(PositionConstants.NORTH_WEST);
		Command cmd = editPart.getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		checkBounds(node, bounds);
	}

	private void align(List nodes, int alignment) {
		layout(((GraphicalEditPart)nodes.get(0)).getFigure().getParent());	//since the action operates with figure bounds, we must invoke layout explicitly to update them from layout constraints.
		AlignmentAction action = new AlignmentAction(new ViewPart() {
			public Object getAdapter(Class adapter) {
				if (CommandStack.class == adapter) {
					return getCommandStack();
				}
				return super.getAdapter(adapter);
			}
			public void createPartControl(Composite parent) {
			}
			public void setFocus() {
			}
		}, alignment);
		final IStructuredSelection selection = new StructuredSelection(nodes);
		action.setSelectionProvider(new ISelectionProvider() {
			public void setSelection(ISelection selection) {
			}
			public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			}
			public ISelection getSelection() {
				return selection;
			}
			public void addSelectionChangedListener(ISelectionChangedListener listener) {
			}
		});
		action.update();
		action.run();
	}

	private void checkBounds(Node node, Rectangle bounds) {
		assertTrue("Unexpected layout constraint", node.getLayoutConstraint() instanceof Bounds);
		Bounds nodeBounds = (Bounds) node.getLayoutConstraint();
		checkBounds(nodeBounds, bounds);
	}

	private void checkBounds(Bounds nodeBounds, Rectangle bounds) {
		assertEquals(nodeBounds.getX(), bounds.x);
		assertEquals(nodeBounds.getY(), bounds.y);
		assertEquals(nodeBounds.getWidth(), bounds.width);
		assertEquals(nodeBounds.getHeight(), bounds.height);
	}
}
