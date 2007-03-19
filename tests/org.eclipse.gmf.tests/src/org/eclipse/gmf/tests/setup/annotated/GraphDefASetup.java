/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.annotated;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.tests.setup.DiaDefSource;

/**
 * Creates graphical definition model from annotated domain model.
 * 
 * @author dstadnik
 */
public class GraphDefASetup extends AbstractASetup implements DiaDefSource {

	protected EPackage ePackage;

	protected Canvas canvas;

	protected FigureGallery fGallery;

	protected Map<EObject, DiagramElement> owners;

	public GraphDefASetup(EPackage ePackage) {
		this.ePackage = ePackage;
	}

	protected Iterator<EObject> getAllDomainModelContents() {
		return ePackage.eAllContents();
	}

	protected void createCanvas() {
		owners = new HashMap<EObject, DiagramElement>();
		canvas = GMFGraphFactory.eINSTANCE.createCanvas();
		canvas.setName("Default"); //$NON-NLS-1$
		fGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		fGallery.setName("default"); //$NON-NLS-1$
		canvas.getFigures().add(fGallery);
		processDomainModel();
	}

	// canvas

	protected void processCanvas(EModelElement element, String name, List<Parameter> params) {
		canvas.setName(getName(element, name));
	}

	// node

	protected void processNode(EModelElement element, String name, List<Parameter> params) {
		Node node = createNode(element, name, params);
		canvas.getNodes().add(node);
		Figure figure = createNodeFigure(node, element, params);
		fGallery.getFigures().add(figure);
		node.setFigure(figure);
		owners.put(element, node);
	}

	protected Node createNode(EModelElement element, String name, List<Parameter> params) {
		Node node = GMFGraphFactory.eINSTANCE.createNode();
		node.setName(getName(element, name));
		return node;
	}

	protected Figure createNodeFigure(Node node, EModelElement element, List<Parameter> params) {
		Rectangle figure = GMFGraphFactory.eINSTANCE.createRectangle();
		figure.setName(node.getName() + "Figure"); //$NON-NLS-1$
		return figure;
	}

	// compartment

	protected void processCompartment(EModelElement element, String name, List<Parameter> params) {
		Compartment compartment = createCompartment(element, name, params);
		canvas.getCompartments().add(compartment);
		Figure figure = createCompartmentFigure(compartment, element, params);
		fGallery.getFigures().add(figure);
		compartment.setFigure(figure);
	}

	protected Compartment createCompartment(EModelElement element, String name, List<Parameter> params) {
		Compartment compartment = GMFGraphFactory.eINSTANCE.createCompartment();
		compartment.setName(getName(element, name));
		return compartment;
	}

	protected Figure createCompartmentFigure(Compartment compartment, EModelElement element, List<Parameter> params) {
		Rectangle figure = GMFGraphFactory.eINSTANCE.createRectangle();
		figure.setName(compartment.getName() + "Figure"); //$NON-NLS-1$
		return figure;
	}

	// link

	protected void processLink(EModelElement element, String name, List<Parameter> params) {
		Connection connection = createLink(element, name, params);
		canvas.getConnections().add(connection);
		Figure figure = createLinkFigure(connection, element, params);
		fGallery.getFigures().add(figure);
		connection.setFigure(figure);
		owners.put(element, connection);
	}

	protected Connection createLink(EModelElement element, String name, List<Parameter> params) {
		Connection connection = GMFGraphFactory.eINSTANCE.createConnection();
		connection.setName(getName(element, name));
		return connection;
	}

	protected Figure createLinkFigure(Connection connection, EModelElement element, List<Parameter> params) {
		PolylineConnection figure = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		figure.setName(connection.getName() + "Figure"); //$NON-NLS-1$
		return figure;
	}

	// label

	protected void processLabel(EModelElement element, String name, List<Parameter> params) {
		DiagramLabel label = createLabel(element, name, params);
		canvas.getLabels().add(label);
		Figure figure = createLabelFigure(label, element, params);
		// if label element is contained within element mapped to
		// node or connection then label figure should be added to
		// container figure
		DiagramElement host = owners.get(element.eContainer());
		if (host != null) {
			((Figure) host.getFigure()).getChildren().add(figure);
		} else {
			fGallery.getFigures().add(figure);
		}
		label.setFigure(figure);
	}

	protected DiagramLabel createLabel(EModelElement element, String name, List<Parameter> params) {
		DiagramLabel label = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		label.setName(getName(element, name));
		return label;
	}

	protected Figure createLabelFigure(DiagramLabel label, EModelElement element, List<Parameter> params) {
		Label figure = GMFGraphFactory.eINSTANCE.createLabel();
		figure.setName(label.getName() + "Figure"); //$NON-NLS-1$
		return figure;
	}

	// source

	public Canvas getCanvasDef() {
		if (canvas == null) {
			createCanvas();
			saveModel(canvas, "gmfgraph"); //$NON-NLS-1$
			validate(canvas);
		}
		return canvas;
	}

	public DiagramLabel getLabelDef() {
		return null;
	}

	public Connection getLinkDef() {
		return null;
	}

	public Node getNodeDef() {
		return null;
	}
}
