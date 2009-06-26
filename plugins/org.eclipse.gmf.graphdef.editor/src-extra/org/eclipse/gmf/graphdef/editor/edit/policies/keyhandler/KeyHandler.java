/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies.keyhandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.graphdef.editor.edit.policies.KeyHandlerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class KeyHandler extends org.eclipse.gef.KeyHandler {

	public static final KeyStroke ACTIVATE_CHILD_SELECTION = KeyStroke.getPressed((char) 12, (int) 'l', SWT.CTRL);

	private IDiagramGraphicalViewer myViewer;

	private Set<KeyStroke> myHandledKeyStrokes = new HashSet<KeyStroke>();

	public KeyHandler(IDiagramGraphicalViewer viewer) {
		myViewer = viewer;
		setParent(myViewer.getKeyHandler());
		myHandledKeyStrokes.add(ACTIVATE_CHILD_SELECTION);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		return performRequest(KeyStroke.getPressed(event.character, event.keyCode, event.stateMask)) || super.keyPressed(event);
	}

	private boolean performRequest(KeyStroke keyStroke) {
		if (myHandledKeyStrokes.contains(keyStroke)) {
			EditPart target = getSelectedEditPart();
			if (target != null) {
				KeyPressedRequest request = new KeyPressedRequest(keyStroke);
				request.setLocation(getCursorLocation(target));

				EditPolicy editPolicy = target.getEditPolicy(KeyHandlerEditPolicy.KEY_HANDLER_ROLE);
				if (editPolicy instanceof KeyHandlerEditPolicy) {
					((KeyHandlerEditPolicy) editPolicy).processRequest(request);
				}

				target = target.getTargetEditPart(request);
				if (target != null) {
					Command command = target.getCommand(request);
					if (command != null && command.canExecute()) {
						myViewer.getDiagramEditDomain().getDiagramCommandStack().execute(command);
					}
				}
				return request.isPerformed();
			}
		}
		return false;
	}

	private Point getCursorLocation(EditPart target) {
		Display display = myViewer.getControl().getDisplay();
		Control control = display.getCursorControl();
		if (control == myViewer.getControl() && target instanceof GraphicalEditPart) {
			Point location = new Point(control.toControl(display.getCursorLocation()));
			((GraphicalEditPart) target).getFigure().translateToRelative(location);
			return location;
		}
		return null;
	}

	private EditPart getSelectedEditPart() {
		for (EditPart editPart : (List<EditPart>) myViewer.getSelectedEditParts()) {
			if (editPart.getSelected() == EditPart.SELECTED_PRIMARY) {
				return editPart;
			}
		}
		return null;
	}

}
