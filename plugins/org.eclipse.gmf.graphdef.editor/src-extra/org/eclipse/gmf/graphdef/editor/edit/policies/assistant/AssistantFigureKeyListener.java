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
package org.eclipse.gmf.graphdef.editor.edit.policies.assistant;

import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.KeyListener;
import org.eclipse.swt.SWT;

public abstract class AssistantFigureKeyListener extends KeyListener.Stub {

	private BubbleFigure myFeedbackFigure;

	public AssistantFigureKeyListener(BubbleFigure feedbackFigure) {
		myFeedbackFigure = feedbackFigure;
	}

	public void keyPressed(KeyEvent ke) {
		switch (ke.character) {
		case SWT.ESC:
			hideAssistant();
			return;
		case ' ':
			if (ke.getState() != 0) {
				// ignoring any key events with state masks
				return;
			}
		case SWT.CR:
			for (Object nextFigure : myFeedbackFigure.getChildren()) {
				if (nextFigure instanceof SelectableBubbleItemFigure) {
					SelectableBubbleItemFigure childFigure = (SelectableBubbleItemFigure) nextFigure;
					if (childFigure.isSelected()) {
						((SelectEditPartDragTracker) childFigure.getDragTracker()).handleButtonUp(1);
						return;
					}
				}
			}
			return;
		case 12:
			switch (myFeedbackFigure.getMode()) {
			case ICON:
				myFeedbackFigure.setMode(BubbleFigure.Mode.PREVIEW);
				break;
			case PREVIEW:
				myFeedbackFigure.setMode(BubbleFigure.Mode.ICON);
				break;
			}
			myFeedbackFigure.setSize(myFeedbackFigure.getPreferredSize());
		}
		switch (ke.keycode) {
		case SWT.ARROW_UP:
			for (Object nextFigure : myFeedbackFigure.getChildren()) {
				if (nextFigure instanceof SelectableBubbleItemFigure) {
					myFeedbackFigure.selectChild((SelectableBubbleItemFigure) nextFigure);
					return;
				}
			}
			return;
		case SWT.ARROW_DOWN:
			SelectableBubbleItemFigure lastChildFigure = null;
			for (Object nextFigure : myFeedbackFigure.getChildren()) {
				if (nextFigure instanceof SelectableBubbleItemFigure) {
					lastChildFigure = (SelectableBubbleItemFigure) nextFigure;
				}
			}
			if (lastChildFigure != null) {
				myFeedbackFigure.selectChild(lastChildFigure);
			}
			return;
		case SWT.ARROW_RIGHT:
			SelectableBubbleItemFigure selectedChildFigure = null;
			for (Object nextFigure : myFeedbackFigure.getChildren()) {
				if (nextFigure instanceof SelectableBubbleItemFigure) {
					SelectableBubbleItemFigure nextChildFigure = (SelectableBubbleItemFigure) nextFigure;
					if (selectedChildFigure != null) {
						myFeedbackFigure.selectChild(nextChildFigure);
						return;
					}
					if (nextChildFigure.isSelected()) {
						selectedChildFigure = nextChildFigure;
					}
				}
			}
			return;
		case SWT.ARROW_LEFT:
			SelectableBubbleItemFigure prevChildFigure = null;
			for (Object nextFigure : myFeedbackFigure.getChildren()) {
				if (nextFigure instanceof SelectableBubbleItemFigure) {
					SelectableBubbleItemFigure childFigure = (SelectableBubbleItemFigure) nextFigure;
					if (childFigure.isSelected()) {
						if (prevChildFigure != null) {
							myFeedbackFigure.selectChild(prevChildFigure);
						}
						return;
					}
					prevChildFigure = childFigure;
				}
			}
			return;
		}
	}

	protected abstract void hideAssistant();

}
