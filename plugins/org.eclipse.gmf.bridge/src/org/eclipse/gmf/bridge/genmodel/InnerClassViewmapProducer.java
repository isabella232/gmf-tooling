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

import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;

/**
 * @author artem
 *
 */
public class InnerClassViewmapProducer extends DefaultViewmapProducer {

	private final FigureGenerator figureGenerator;

	public InnerClassViewmapProducer() {
		figureGenerator = new FigureGenerator(null);
	}

	public Viewmap create(Node node) {
		if (node.getFigure() == null) {
			return super.create(node);
		}
		try {
			return createInnerClassViewmap(node.getFigure());
		} catch (JETException ex) {
			ex.printStackTrace();
			return super.create(node);
		}
	}

	public Viewmap create(Connection link) {
		if (link.getFigure() == null) {
			return super.create(link);
		}
		try {
			return createInnerClassViewmap(link.getFigure());
		} catch (JETException ex) {
			ex.printStackTrace();
			return super.create(link);
		}
	}

	private InnerClassViewmap createInnerClassViewmap(Figure figure) throws JETException {
		InnerClassViewmap v = GMFGenFactory.eINSTANCE.createInnerClassViewmap();
		v.setClassBody(figureGenerator.go(figure));
		v.setClassName(figure.getName()); // XXX parse instead?
		return v;
	}
}
