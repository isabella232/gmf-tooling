/*
 *  Copyright (c) 2007 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.sheet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class CustomPropertySection extends AbstractCustomPropertySection {

	/**
	 * Modify/unwrap selection.
	 * 
	 * @generated
	 */
	protected Object transformSelection(Object selected) {
		if (selected instanceof EditPart) {
			Object model = ((EditPart) selected).getModel();
			return model instanceof View ? ((View) model).getElement() : null;
		}
		if (selected instanceof View) {
			return ((View) selected).getElement();
		}
		if (selected instanceof IAdaptable) {
			View view = (View) ((IAdaptable) selected).getAdapter(View.class);
			if (view != null) {
				return view.getElement();
			}
		}
		return selected;
	}

	/**
	 * @generated
	 */
	private Collection mySavedSelection = new ArrayList();

	/**
	 * @generated
	 */
	public Collection getSavedSelection() {
		// StructuredSelection structured = (StructuredSelection)
		// super.getSelection();
		// return structured.toList();
		return mySavedSelection;
	}

	/**
	 * @generated
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if (selection.isEmpty() || false == selection instanceof StructuredSelection) {
			super.setInput(part, selection);
			return;
		}
		final StructuredSelection structuredSelection = ((StructuredSelection) selection);
		ArrayList transformedSelection = new ArrayList(structuredSelection.size());
		for (Iterator it = structuredSelection.iterator(); it.hasNext();) {
			Object r = transformSelection(it.next());
			if (r != null) {
				transformedSelection.add(r);
			}
		}
		mySavedSelection = transformedSelection;
		super.setInput(part, new StructuredSelection(transformedSelection));
	}

	/**
	 * @generated
	 */
	private static ImageRegistry ourImageRegistry = new ImageRegistry();

	/**
	 * @generated
	 */
	static {
		ourImageRegistry.put(LineKind.LINE_SOLID_LITERAL.getLiteral(), GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_solid.png"));
		ourImageRegistry.put(LineKind.LINE_DASH_LITERAL.getLiteral(), GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dash.png"));
		ourImageRegistry.put(LineKind.LINE_DOT_LITERAL.getLiteral(), GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dot.png"));
		ourImageRegistry.put(LineKind.LINE_DASHDOT_LITERAL.getLiteral(), GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dashdot.png"));
		ourImageRegistry.put(LineKind.LINE_DASHDOTDOT_LITERAL.getLiteral(), GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dashdotdot.png"));
		ourImageRegistry.put(LineKind.LINE_CUSTOM_LITERAL.getLiteral(), GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_custom.png"));
	}

	/**
	 * @generated
	 */
	public ImageRegistry getImageRegistry() {
		return ourImageRegistry;
	}

}
