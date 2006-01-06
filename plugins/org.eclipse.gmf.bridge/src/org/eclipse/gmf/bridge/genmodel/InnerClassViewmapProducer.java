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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.util.FigureQualifiedNameSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;

/**
 * @author artem
 */
public class InnerClassViewmapProducer extends DefaultViewmapProducer {

	private final FigureGenerator figureGenerator;
	private final FigureQualifiedNameSwitch fqnSwitch = new FigureQualifiedNameSwitch();

	public InnerClassViewmapProducer() {
		figureGenerator = new FigureGenerator(null);
	}

	public Viewmap create(Node node) {
		if (node.getFigure() == null) {
			return super.create(node);
		}
		try {
			return createViewmap(node.getFigure());
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
			return createViewmap(link.getFigure());
		} catch (JETException ex) {
			ex.printStackTrace();
			return super.create(link);
		}
	}

	private Viewmap createViewmap(Figure figure) throws JETException {
		if (isBareInstance(figure)) {
			FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
			v.setFigureQualifiedClassName(String.valueOf(fqnSwitch.doSwitch(figure)));
			return v;
			// XXX perhaps, create SnippetViewmap when there are no children but some props
		} else {
			InnerClassViewmap v = GMFGenFactory.eINSTANCE.createInnerClassViewmap();
			v.setClassBody(figureGenerator.go(figure));
			v.setClassName(figure.getName()); // XXX parse instead?
			return v;
		}
	}

	private static boolean isBareInstance(Figure figure){
		if (!figure.getChildren().isEmpty()) {
			return false;
		}
		Collection featuresToCheck = new LinkedList(figure.eClass().getEAllStructuralFeatures());
		featuresToCheck.remove(GMFGraphPackage.eINSTANCE.getIdentity_Name());
		if (figure instanceof CustomFigure) {
			featuresToCheck.remove(GMFGraphPackage.eINSTANCE.getCustomClass_BundleName());
			featuresToCheck.remove(GMFGraphPackage.eINSTANCE.getCustomClass_QualifiedClassName());
		}
		for(Iterator it = figure.eClass().getEAllStructuralFeatures().iterator(); it.hasNext();) {
			if (figure.eIsSet((EStructuralFeature) it.next())) {
				return false;
			}
		}
		return true;
	}
}
