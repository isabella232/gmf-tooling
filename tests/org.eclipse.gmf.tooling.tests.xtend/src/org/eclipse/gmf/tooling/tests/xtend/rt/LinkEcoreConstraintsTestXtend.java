/*
 * Copyright (c) 2008, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend.rt;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.rt.GeneratedCanvasTest;
import org.eclipse.gmf.tests.rt.LinkEcoreConstraintsTest;
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
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfiguration;

/**
 * @author artem
 */
public class LinkEcoreConstraintsTestXtend extends LinkEcoreConstraintsTest {
	
	public final static class CustomSetup extends SessionSetup {
		public CustomSetup() {
			super(new RuntimeBasedGeneratorConfiguration());
		}

		private DiaGenSource myGenModel;

		private DomainModelSource myDmSource;

		@Override
		public DomainModelSource getDomainModel() {
			if (myDmSource == null) {
				URI selected;
				try {
					selected = Plugin.createURI("/models/library/library.ecore");
					myDmSource = new DomainModelFileSetup().init(selected);
				} catch (IOException e) {
					fail("exception: " + e.getMessage());
				}
			}
			return myDmSource;
		}

		@Override
		public DiaGenSource getGenModel() {
			if (myGenModel == null) {
				ToolDefSource tdmSource = new ToolDefASetup(getDomainModel().getModel());
				DiaDefSource gdmSource = new GraphDefASetup(getDomainModel().getModel());
				MapDefSource mmSource = new MapDefASetup(getDomainModel().getModel(), tdmSource.getRegistry(), gdmSource.getCanvasDef());
				myGenModel = new GenASetup(mmSource.getMapping(), new InnerClassViewmapProducer(), false) {

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
			}
			return myGenModel;
		}
	};

	public LinkEcoreConstraintsTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfiguration());
	}
}
