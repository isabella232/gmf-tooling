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
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.diadef.Canvas;
import org.eclipse.gmf.diadef.Connection;
import org.eclipse.gmf.diadef.DiagramDefinitionFactory;
import org.eclipse.gmf.diadef.LineKind;
import org.eclipse.gmf.diadef.Node;

public class DiaDefSetup implements DiaDefSource {
	private Canvas myCanvasDef;
	private Node myNodeDef;
	private Connection myLinkDef;
	private final Config myConfig;

	/**
	 * @param config could be <code>null</code>
	 */
	public DiaDefSetup(Config config) {
		myConfig = config;
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public final DiaDefSetup init() {
		myCanvasDef = DiagramDefinitionFactory.eINSTANCE.createCanvas();
		myNodeDef = DiagramDefinitionFactory.eINSTANCE.createNode();
		myLinkDef = DiagramDefinitionFactory.eINSTANCE.createConnection();
		setupCanvasDef(myCanvasDef);
		setupNodeDef(myNodeDef);
		setupLinkDef(myLinkDef);
		return this;
	}

	protected void setupCanvasDef(Canvas canvasDef) {
		canvasDef.setName("Test-dd-canvas");
		if (myConfig != null) {
			myConfig.setupCanvasDef(canvasDef);
		}
	}

	protected void setupNodeDef(Node nodeDef) {
		nodeDef.setName("Test-dd-node");
		if (myConfig != null) {
			myConfig.setupNodeDef(nodeDef);
		}
	}

	protected void setupLinkDef(Connection linkDef) {
		linkDef.setName("Test-dd-link");
		linkDef.setLineKind(LineKind.DASH_LITERAL);
		if (myConfig != null) {
			myConfig.setupLinkDef(linkDef);
		}
	}
	
	public final Canvas getCanvasDef() {
		return myCanvasDef;
	}

	public final Connection getLinkDef() {
		return myLinkDef;
	}

	public final Node getNodeDef() {
		return myNodeDef;
	}

	public interface Config {
		void setupCanvasDef(Canvas canvasDef);
		void setupNodeDef(Node nodeDef);
		void setupLinkDef(Connection linkDef);
	}
}
