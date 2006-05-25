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
package org.eclipse.gmf.tests.tr;

import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;

public abstract class AbstractMappingTransformerTest extends ConfiguredTestCase {
	private MapDefSource myMapDef;
	private DiaDefSetup myDiaDef;

	protected AbstractMappingTransformerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myDiaDef = createDiaDefSetup();
		myDiaDef.init();
		myMapDef = initMapModel(myDiaDef);
	}
	
	protected DiaDefSetup createDiaDefSetup(){
		return new DiaDefSetup();
	}
	
	protected MapDefSource initMapModel(DiaDefSource graphDef) {
		return new MapSetup().init(graphDef, getSetup().getDomainModel(), new ToolDefSetup());
	}

	protected final Canvas getCanvasDef() {
		return myDiaDef.getCanvasDef();
	}

	protected final Connection getLinkDef() {
		return myDiaDef.getLinkDef();
	}

	protected final Node getNodeDef() {
		return myDiaDef.getNodeDef();
	}

	protected final Mapping getMapping() {
		return myMapDef.getMapping();
	}

	protected final CanvasMapping getCanvasMapping() {
		return getMapping().getDiagram();
	}

	protected NodeMapping getNodeMapping() {
		return myMapDef.getNodeA();
	}

	protected LinkMapping getLinkMapping() {
		return myMapDef.getClassLink();
	}

}
