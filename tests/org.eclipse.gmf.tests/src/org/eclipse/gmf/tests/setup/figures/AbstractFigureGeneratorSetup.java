/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.figures;

import junit.framework.Assert;

import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil.GeneratedClassData;


public abstract class AbstractFigureGeneratorSetup implements TestConfiguration {
	
	private FigureGallery myFigureGallery;

	private GeneratedClassData[] myClassDatas;

	private PolylineConnection myEcoreContainmentRef;

	private Figure myFigure1;

	private Figure myFigure2;

	private Figure myFigure3;

	private Config myConfig;
	
	protected abstract void addFigures(FigureGallery gallery);
	
	public Class getFigureClass(Figure f) {
		GeneratedClassData[] classDatas = getClassData();
		for (int i = 0; i < classDatas.length; i++) {
			if (classDatas[i].getFigureDef() == f) {
				return classDatas[i].getLoadedClass();
			}
		}
		Assert.fail("Class was not found in generated plugin: " + getConfig().getPluginID() + "|" + getConfig().getMainPackageName() + "|" + f.getName());
		return null;
	}
	
	private GeneratedClassData[] getClassData() {
		if (myClassDatas == null) {
			myClassDatas = FigureGeneratorUtil.generateAndCompile(getFigureGallery(), getConfig());
		}
		return myClassDatas;
	}
	
	protected Config getConfig() {
		if (myConfig == null) {
			myConfig = FigureGeneratorUtil.createStandaloneGeneratorConfig();
		}
		return myConfig;
	}

	private FigureGallery getFigureGallery() {
		if (myFigureGallery == null) {
			myFigureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
			myFigureGallery.setName("bb");
			myFigureGallery.setImplementationBundle(Plugin.getPluginID());
			addFigures(myFigureGallery);
			Assert.assertFalse("No figures was added to the gallery by subclasses", myFigureGallery.getFigures().isEmpty());
		}
		return myFigureGallery;
	}

// Creating figures:
	
	public PolylineConnection getEcoreContainmentRef() {
		if (myEcoreContainmentRef == null) {
			myEcoreContainmentRef = GMFGraphFactory.eINSTANCE.createPolylineConnection();
			myEcoreContainmentRef.setName("ContainmentRef");
			PolygonDecoration df = createRhomb();
			df.setFill(true);
			myEcoreContainmentRef.setSourceDecoration(df);
		}
		return myEcoreContainmentRef;
	}
	
	private PolygonDecoration createRhomb() {
		PolygonDecoration df = GMFGraphFactory.eINSTANCE.createPolygonDecoration();
		Point p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(-1);
		p.setY(1);
		df.getTemplate().add(p);
		p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(0);
		p.setY(0);
		df.getTemplate().add(p);
		p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(-1);
		p.setY(-1);
		df.getTemplate().add(p);
		p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(-2);
		p.setY(0);
		df.getTemplate().add(p);
		return df;
	}
	
	public Figure getFigure1() {
		if (myFigure1 == null) {
			myFigure1 = FigureGeneratorUtil.createFigure1();
		}
		return myFigure1;
	}
	

	public Figure getFigure2() {
		if (myFigure2 == null) {
			myFigure2 = FigureGeneratorUtil.createFigure2();
		}
		return myFigure2;
	}
	
	public Figure getFigure3() {
		if (myFigure3 == null) {
			myFigure3 = FigureGeneratorUtil.createFigure3();
		}
		return myFigure3;
	}
	
}
