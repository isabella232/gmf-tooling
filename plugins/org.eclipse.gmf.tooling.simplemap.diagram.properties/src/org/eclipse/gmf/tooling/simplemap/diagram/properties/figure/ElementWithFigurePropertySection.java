/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.diagram.properties.figure;

import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.tooling.simplemap.diagram.properties.AbstractSimplemapPropertySection;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLabelNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;

public abstract class ElementWithFigurePropertySection extends AbstractSimplemapPropertySection {

	protected Figure getFigure(Object selected) {
		Object transformSelection = super.transformSelection(selected);

		Figure figure = null;

		if (transformSelection instanceof SimpleNode) {
			figure = ((SimpleNode) transformSelection).getDiagramNode().getFigure().getActualFigure();
		}

		if (transformSelection instanceof SimpleCompartment) {
			figure = ((SimpleCompartment) transformSelection).getCompartment().getAccessor().getFigure();
		}

		if (transformSelection instanceof SimpleLinkMapping) {
			FigureDescriptor figDesc = ((SimpleLinkMapping) transformSelection).getDiagramLink().getFigure();
			figure = figDesc != null ? figDesc.getActualFigure() : null;

		}

		return figure;
	}

	protected Figure getLabelFigure(Object selected) {
		Object transformSelection = super.transformSelection(selected);

		Figure figure = null;

		if (transformSelection instanceof SimpleNode) {
			DiagramLabel diagramLabel = ((SimpleNode) transformSelection).getDiagramLabel();
			if (diagramLabel != null && diagramLabel.getAccessor() != null)
				figure = diagramLabel.getAccessor().getFigure();
		}

		if (transformSelection instanceof SimpleLabelNode) {
			figure = ((SimpleNode) transformSelection).getDiagramLabel().getFigure().getActualFigure();
		}

		if (transformSelection instanceof SimpleCompartment) {
			figure = ((SimpleCompartment) transformSelection).getCompartment().getFigure().getActualFigure();
		}

		if (transformSelection instanceof SimpleLinkMapping) {
			figure = ((SimpleLinkMapping) transformSelection).getDiagramLabel().getFigure().getActualFigure();

		}

		return figure;
	}

}
