/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
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

import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.internal.bridge.DistinctTopLevelNodesFactoryGate;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenNamingMediatorImpl;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.setup.DiaGenSource;

/**
 * @author dstadnik
 */
public class GenASetup extends AbstractASetup implements DiaGenSource {

	protected Mapping mapping;

	protected boolean rcp;

	protected GenEditorGenerator gen;

	protected ViewmapProducer viewmapProducer;

	public GenASetup(Mapping mapping, ViewmapProducer viewmapProducer, boolean rcp) {
		this.mapping = mapping;
		this.rcp = rcp;
		this.viewmapProducer = viewmapProducer;
	}

	protected Iterator<EObject> getAllDomainModelContents() {
		return null;
	}

	// source

	public GenDiagram getGenDiagram() {
		if (gen == null) {
			DiagramGenModelTransformer.Parameters opts = new DiagramGenModelTransformer.Parameters( //
					new BasicDiagramRunTimeModelHelper(), //
					viewmapProducer, //
					new DistinctTopLevelNodesFactoryGate(), //
					new NaiveIdentifierDispenser(), rcp);
			DiagramGenModelTransformer t = new DiagramGenModelTransformer(opts);
			EPackage ePackage = mapping.getDiagram().getDomainModel();
			if (ePackage != null) {
				GenModel gm = Utils.createGenModel(ePackage);
				t.setEMFGenModel(gm);
				saveModel(gm, "genmodel");
			}
			t.transform(mapping);
			gen = t.getResult();
			new GenNamingMediatorImpl().traverse(gen);
			saveModel(gen, "gmfgen"); //$NON-NLS-1$
			validate(gen);
		}
		return gen.getDiagram();
	}

	public GenNode getNodeA() {
		return null;
	}

	public GenNode getNodeB() {
		return null;
	}

	public GenLink getLinkC() {
		return null;
	}

	public GenLink getLinkD() {
		return null;
	}
}
