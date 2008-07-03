/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.DomainModelFileSetup;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.ToolDefSource;
import org.eclipse.gmf.tests.setup.annotated.GenASetup;
import org.eclipse.gmf.tests.setup.annotated.GraphDefASetup;
import org.eclipse.gmf.tests.setup.annotated.MapDefASetup;
import org.eclipse.gmf.tests.setup.annotated.ToolDefASetup;

/**
 * @author artem
 */
public class LinkEcoreConstraintsTest extends GeneratedCanvasTest {

	public LinkEcoreConstraintsTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		URI selected = Plugin.createURI("/models/library/library.ecore"); //$NON-NLS-1$
		final DomainModelSource dmSource =  new DomainModelFileSetup().init(selected);
		final ToolDefSource tdmSource = new ToolDefASetup(dmSource.getModel());
		final DiaDefSource gdmSource = new GraphDefASetup(dmSource.getModel());
		final MapDefSource mmSource = new MapDefASetup(dmSource.getModel(), tdmSource.getRegistry(), gdmSource.getCanvasDef()); 
		final GenASetup genModel = new GenASetup(mmSource.getMapping(), new InnerClassViewmapProducer(), false) {
			@Override
			public GenNode getNodeA() {
				return getGenDiagram().getTopLevelNodes().get(0);
			}
			@Override
			public GenNode getNodeB() {
				return getGenDiagram().getTopLevelNodes().get(1);
			}
			@Override
			public GenLink getLinkD() {
				return getGenDiagram().getLinks().get(0);
			}
		};
		configure(new SessionSetup() {
			@Override
			public DomainModelSource getDomainModel() {
				return dmSource;
			}
			@Override
			public DiaGenSource getGenModel() {
				return genModel;
			}
		});
		super.setUp();
	}

	@Override
	protected RTSource createCanvasInstance() throws Exception {
		return new RTSetup() {
			@Override
			protected void initDiagramFileContents(DomainInstanceProducer instanceProducer, DiaGenSource genSource) {
				myCanvas = NotationFactory.eINSTANCE.createDiagram();
				myDiagramElement = instanceProducer.createInstance(genSource.getGenDiagram().getDomainDiagramElement());
				myCanvas.setElement(myDiagramElement);
				myCanvas.setType(genSource.getGenDiagram().getEditorGen().getModelID());
			}
		}.init(getSetup().getGeneratedPlugin(), getSetup().getGenModel());
	}

	public void testOppositeBounds() {
		final GenLink wroteRef = getSetup().getGenModel().getLinkD();
		final GenNode writerNode = getSetup().getGenModel().getNodeA();
		final GenNode bookNode = getSetup().getGenModel().getNodeB();
		//
		Node nodeW1 = createNode(writerNode, getDiagram());
		Node nodeB1 = createNode(bookNode, getDiagram());
		assertNotNull(nodeW1); 
		assertNotNull(nodeB1);
		Edge link1 = createLink(wroteRef, nodeW1, nodeB1);
		assertNotNull(link1);
		Node nodeW2 = createNode(writerNode, getDiagram());
		Edge link2 = createLink(wroteRef, nodeW2, nodeB1);
		assertNull(link2);
		Command targetCmd = getViewerConfiguration().getCreateLinkCommand(nodeW2, nodeB1, wroteRef);
		assertNotNull(targetCmd);
		assertFalse(targetCmd.canExecute());
	}
}
