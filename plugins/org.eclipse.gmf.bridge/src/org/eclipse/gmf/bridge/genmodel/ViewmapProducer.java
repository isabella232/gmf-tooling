/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.bridge.genmodel;

import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Child;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.util.GMFGraphSwitch;

/**
 * @author artem
 * XXX rename 'create' to 'get'? 
 */
public class ViewmapProducer {
	public Viewmap create(Canvas canvasElement) {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.FreeformLayer");
		return v;
	}

	public Viewmap create(Node node) {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.RoundedRectangle");
		return v;
	}

	public Viewmap create(Connection link) {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx");
		return v;
	}

	public Viewmap create(Child child) {
		return createLabelViewmap();
	}

	public Viewmap create(Compartment compartment) {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		// ShapeCompartmentFigure | NestedResizableCompartmentFigure
		v.setFigureQualifiedClassName("XXX");
		return v;
	}

	public Viewmap create(DiagramElement diagramElement) {
		return (Viewmap) new GMFGraphSwitch() {
			public Object caseCanvas(Canvas object) {
				return create(object);
			}
			public Object caseChild(Child object) {
				return create(object);
			}
			public Object caseCompartment(Compartment object) {
				return create(object);
			}
			public Object caseNode(Node object) {
				return create(object);
			}
			public Object caseConnection(Connection object) {
				return create(object);
			}
		}.doSwitch(diagramElement);
	}

	// FIXME remove
	Viewmap createLabelViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.Label");
		return v;
	}
}
