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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.ResizeConstraints;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Child;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Direction;
import org.eclipse.gmf.gmfgraph.Node;

/**
 * @author artem
 */
public class DefaultViewmapProducer extends ViewmapProducer {
	private DirectionMapper myDirectionMapper; 
	
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

	protected void setupResizeConstraints(Viewmap viewmap, Node diagramNode){
		Direction direction = diagramNode.getResizeConstraint();
		if (direction == null){
			return;
		}
		ResizeConstraints constraints = GMFGenFactory.eINSTANCE.createResizeConstraints();
		constraints.setResizeHandles(getDirectionMapper().direction2resizeConstraint(direction));
		viewmap.getAttributes().add(constraints);
	}

	// FIXME remove
	private static Viewmap createLabelViewmap() {
		FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
		v.setFigureQualifiedClassName("org.eclipse.draw2d.Label");
		return v;
	}
	
	protected DirectionMapper getDirectionMapper(){
		if (myDirectionMapper == null) {
			myDirectionMapper = new DirectionMapper();
		}
		return myDirectionMapper;
	}
	
	protected static class DirectionMapper {
		public int direction2resizeConstraint(Direction literal){
			int result = PositionConstants.NONE;
			
			int direction = literal.getValue();
			result |= returnIfBitMaskSet(direction, Direction.NORTH, PositionConstants.NORTH);
			result |= returnIfBitMaskSet(direction, Direction.SOUTH, PositionConstants.SOUTH);
			result |= returnIfBitMaskSet(direction, Direction.EAST, PositionConstants.EAST);
			result |= returnIfBitMaskSet(direction, Direction.WEST, PositionConstants.WEST);
			
			result |= returnIfBitMaskSet(direction, Direction.NORTH_EAST, PositionConstants.NORTH_EAST);
			result |= returnIfBitMaskSet(direction, Direction.NORTH_WEST, PositionConstants.NORTH_WEST);
			result |= returnIfBitMaskSet(direction, Direction.SOUTH_EAST, PositionConstants.SOUTH_EAST);
			result |= returnIfBitMaskSet(direction, Direction.SOUTH_WEST, PositionConstants.SOUTH_WEST);

			return result;
		}
		
		private static int returnIfBitMaskSet(int value, int mask, int result) {
			return ((value & mask) == mask) ? result : 0;
		}
	}
}
