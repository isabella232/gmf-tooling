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
import org.eclipse.gmf.codegen.gmfgen.ResizeConstraints;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Child;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Direction;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.Layout;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.XYLayout;
import org.eclipse.gmf.gmfgraph.util.GMFGraphSwitch;

/**
 * @author artem
 */
public class DefaultViewmapProducer extends ViewmapProducer {
	private final LayoutTypeSwitch myLayoutTypeSwitch = new LayoutTypeSwitch();
	
	public DefaultViewmapProducer() {
	}

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

	public Viewmap create(DiagramLabel label) {
		return createLabelViewmap();
	}

	protected final void setupResizeConstraints(Viewmap viewmap, Node diagramNode){
		Direction direction = diagramNode.getResizeConstraint();
		if (direction == null || direction.getValue() == Direction.NSEW){
			return;
		}
		ResizeConstraints constraints = GMFGenFactory.eINSTANCE.createResizeConstraints();
		constraints.setResizeHandles(direction.getValue());
		viewmap.getAttributes().add(constraints);
	}
	
	protected final void setupLayoutType(Viewmap viewmap, Node diagramNode){
		Figure figure = diagramNode.getFigure();
		if (figure == null){
			return;
		}
		ViewmapLayoutType type = myLayoutTypeSwitch.getLayoutType(figure.getLayout());
		viewmap.setLayoutType(type);
	}

	// FIXME remove
	private static Viewmap createLabelViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.Label");
		return v;
	}
	
	
	private static class LayoutTypeSwitch extends GMFGraphSwitch {
		
		public ViewmapLayoutType getLayoutType(Layout layout){
			return layout == null ? ViewmapLayoutType.UNKNOWN_LITERAL : (ViewmapLayoutType)doSwitch(layout);
		}
		
		public Object caseLayout(Layout object) {
			return ViewmapLayoutType.UNKNOWN_LITERAL;
		}
		
		public Object caseFlowLayout(FlowLayout layout) {
			return layout.isForceSingleLine() ? ViewmapLayoutType.TOOLBAR_LAYOUT_LITERAL : ViewmapLayoutType.FLOW_LAYOUT_LITERAL;
		}
		
		public Object caseXYLayout(XYLayout object) {
			return ViewmapLayoutType.XY_LAYOUT_LITERAL;
		}
	}
}
