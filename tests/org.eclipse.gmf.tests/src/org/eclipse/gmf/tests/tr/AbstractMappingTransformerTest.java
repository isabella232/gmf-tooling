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

import junit.framework.TestCase;

import org.eclipse.gmf.diadef.Canvas;
import org.eclipse.gmf.diadef.Connection;
import org.eclipse.gmf.diadef.Node;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

public abstract class AbstractMappingTransformerTest extends TestCase implements DiaDefSetup.Config {
	private MapSetup myMapDef;
	private DiaDefSetup myDiaDef;

	protected AbstractMappingTransformerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myDiaDef = new DiaDefSetup(this);
		myDiaDef.init();
		myMapDef = new MapSetup();
		myMapDef.init(myDiaDef, SessionSetup.getDomainModel());
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
		return myMapDef.getCanvasMapping();
	}

	protected NodeMapping getNodeMapping() {
		return myMapDef.getNodeMapping();
	}

	protected LinkMapping getLinkMapping() {
		return myMapDef.getLinkMapping();
	}

	// no-op
	public void setupCanvasDef(Canvas canvasDef) {
	}

	// no-op
	public void setupLinkDef(Connection linkDef) {
	}

	// no-op
	public void setupNodeDef(Node nodeDef) {
	}
}
