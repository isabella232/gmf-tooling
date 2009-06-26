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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.Handle;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.ui.parts.AbstractEditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class HeadlessDiagramGraphicalViewer extends AbstractEditPartViewer implements IDiagramGraphicalViewer {

	private GraphicalEditPart myDiagramEditPart;

	private List<View> myTopLevelNodes = new ArrayList<View>();

	public HeadlessDiagramGraphicalViewer(EditPartFactory editpartFactory, final Font defaultFont, final TransactionalEditingDomain editingDomain) {
		setEditPartFactory(editpartFactory);
		RootEditPart rootEditPart = new DiagramRootEditPart(MeasurementUnit.PIXEL_LITERAL) {

			protected ScalableFreeformLayeredPane createScalableFreeformLayeredPane() {
				ScalableFreeformLayeredPane result = super.createScalableFreeformLayeredPane();
				result.setFont(defaultFont);
				return result;
			}

		};
		rootEditPart.setViewer(this);
		myDiagramEditPart = new GraphicalEditPart(null) {

			@Override
			protected IFigure createFigure() {
				Figure figure = new Figure();
				figure.setLayoutManager(new FlowLayout());
				return figure;
			}

			@Override
			protected List getModelChildren() {
				return myTopLevelNodes;
			}

			@Override
			public TransactionalEditingDomain getEditingDomain() {
				return editingDomain;
			}

			@Override
			protected void registerModel() {
			}

		};
		rootEditPart.setContents(myDiagramEditPart);
	}

	public IFigure addChild(View view) {
		myTopLevelNodes.add(view);
		myDiagramEditPart.refresh();
		return ((IGraphicalEditPart) getEditPartRegistry().get(view)).getFigure();
	}

	@Override
	public Control createControl(Composite parent) {
		return null;
	}

	public List findEditPartsForElement(String elementIdStr, Class editPartClass) {
		return Collections.EMPTY_LIST;
	}

	public IDiagramEditDomain getDiagramEditDomain() {
		return null;
	}

	public void registerEditPartForElement(String elementIdStr, EditPart ep) {
	}

	public void unregisterEditPartForElement(String elementIdStr, EditPart ep) {
	}

	public Handle findHandleAt(Point p) {
		return null;
	}

	public EditPart findObjectAtExcluding(Point location, Collection exclusionSet, Conditional conditional) {
		return null;
	}

}
