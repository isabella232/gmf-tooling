/*
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gef;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.internal.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GenProjectSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.osgi.framework.Bundle;

/**
 * @author dstadnik
 */
public class ParsersTest extends TestCase {

	protected ParsersSetup setup;

	public ParsersTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		setup = new ParsersSetup();
		setup.init();
	}

	@Override
	protected void tearDown() throws Exception {
		setup.dispose();
		setup = null;
	}

	/**
	 * Test for the primary usecase: single attr of string type exposed as a label on diagram.
	 */
	public void testDefaultLabel() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		setAttribute(nodkin, "a1", "aaa");
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		IParser p = getParser(setup.genModel.a1);
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa", s);
		s = p.getEditString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa", s);
		ICommand c = p.getParseCommand(new EObjectAdapter(nodkin), "bbb", 0);
		assertTrue(c.canExecute());
		c.execute(new NullProgressMonitor(), new EObjectAdapter(nodkin));
		s = (String) getAttribute(nodkin, "a1");
		assertEquals("bbb", s);
	}

	protected IParser getParser(final GenNodeLabel label) throws Exception {
		String ppfqn = setup.genModel.diagramkin.getParserProviderQualifiedClassName();
		Class<?> ppc = setup.project.getBundle().loadClass(ppfqn);
		IParserProvider pp = (IParserProvider) ppc.newInstance();
		IAdaptable param = new IAdaptable() {

			@SuppressWarnings("unchecked")
			public Object getAdapter(Class adapter) {
				if (String.class == adapter) {
					return String.valueOf(label.getVisualID());
				}
				return null;
			}
		};
		return pp.getParser(param);
	}

	protected EObject createNodkin() throws Exception {
		GenEditorGenerator g = setup.genModel.diagramkin.getEditorGen();
		String id = g.getDomainGenModel().getModelPluginID();
		Bundle b = Platform.getBundle(id);
		String mfqn = g.getDomainGenModel().getGenPackages().get(0).getQualifiedFactoryClassName();
		Class<?> modelFactoryClass = b.loadClass(mfqn);
		EFactory f = (EFactory) modelFactoryClass.newInstance();
		return f.create(setup.domainModel.nodkin);
	}

	protected Object getAttribute(EObject obj, String name) {
		for (EAttribute a : obj.eClass().getEAllAttributes()) {
			if (a.getName().equals(name)) {
				return obj.eGet(a);
			}
		}
		throw new IllegalArgumentException(name);
	}

	protected void setAttribute(EObject obj, String name, Object value) {
		for (EAttribute a : obj.eClass().getEAllAttributes()) {
			if (a.getName().equals(name)) {
				obj.eSet(a, value);
				return;
			}
		}
		throw new IllegalArgumentException(name);
	}

	public static class EObjectAdapter implements IAdaptable {

		private EObject obj;

		public EObjectAdapter(EObject obj) {
			this.obj = obj;
		}

		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			if (EObject.class == adapter) {
				return obj;
			}
			return null;
		}
	}

	public static class ParsersSetup {

		public ParsersDomainModel domainModel;
		public ParsersGenModel genModel;
		public GenProjectSetup project;

		public ParsersSetup() {
			domainModel = new ParsersDomainModel();
			genModel = new ParsersGenModel(domainModel);
		}

		public void init() throws Exception {
			project = new GenProjectSetup(new RuntimeBasedGeneratorConfiguration()).init(new DiaGenSource() {

				public GenDiagram getGenDiagram() {
					return genModel.diagramkin;
				}

				public GenLink getLinkC() {
					return null;
				}

				public GenLink getLinkD() {
					return null;
				}

				public GenNode getNodeA() {
					return null;
				}

				public GenNode getNodeB() {
					return null;
				}
			});
		}

		public void dispose() throws Exception {
			if (project != null) {
				project.uninstall();
			}
		}
	}

	public static class ParsersDomainModel {

		public EPackage p;
		public EClass kanvaskin, nodkin;
		public EReference refkin;
		public EAttribute a1, a2, a3;

		public ParsersDomainModel() {
			p = EcoreFactory.eINSTANCE.createEPackage();
			p.setName("parkin");
			p.setNsPrefix("parkin");
			p.setNsURI("uri://eclipse/gmf/tests/parkin/" + System.currentTimeMillis() + '/');
			new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/parkind")).getContents().add(p);

			kanvaskin = EcoreFactory.eINSTANCE.createEClass();
			kanvaskin.setName("Kanvaskin");
			p.getEClassifiers().add(kanvaskin);
			nodkin = EcoreFactory.eINSTANCE.createEClass();
			nodkin.setName("Nodkin");
			p.getEClassifiers().add(nodkin);
			refkin = EcoreFactory.eINSTANCE.createEReference();
			refkin.setContainment(true);
			refkin.setName("refkin");
			refkin.setEType(nodkin);
			kanvaskin.getEStructuralFeatures().add(refkin);

			a1 = EcoreFactory.eINSTANCE.createEAttribute();
			a1.setName("a1");
			a1.setEType(EcorePackage.eINSTANCE.getEString());
			nodkin.getEStructuralFeatures().add(a1);
			a2 = EcoreFactory.eINSTANCE.createEAttribute();
			a2.setName("a2");
			a2.setEType(EcorePackage.eINSTANCE.getEString());
			nodkin.getEStructuralFeatures().add(a2);
			a3 = EcoreFactory.eINSTANCE.createEAttribute();
			a3.setName("a3");
			a3.setEType(EcorePackage.eINSTANCE.getEInt());
			nodkin.getEStructuralFeatures().add(a3);
		}
	}

	public static class ParsersGenModel {

		private int vid = 100;
		public GenDiagram diagramkin;
		public GenTopLevelNode genNodkin;
		public GenNodeLabel a1;

		public ParsersGenModel(ParsersDomainModel domainModel) {
			GenModel runtimeModel = getRuntimeGenModel();
			assert runtimeModel != null;
			GenModelMatcher gmm = new GenModelMatcher(Utils.createGenModel(domainModel.p));
			diagramkin = GMFGenFactory.eINSTANCE.createGenDiagram();
			GenEditorGenerator genBurden = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
			diagramkin.setDomainDiagramElement(gmm.findGenClass(domainModel.kanvaskin));
			genBurden.setDomainGenModel(diagramkin.getDomainDiagramElement().getGenModel());
			genBurden.setEditor(GMFGenFactory.eINSTANCE.createGenEditorView());
			diagramkin.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getDiagram()));
			diagramkin.setViewmap(createDiagramViewmap());
			diagramkin.setVisualID(nextVID());
			MetamodelType dgmmType = GMFGenFactory.eINSTANCE.createMetamodelType();
			diagramkin.setElementType(dgmmType);
			genBurden.setDiagram(diagramkin);
			genBurden.setPlugin(GMFGenFactory.eINSTANCE.createGenPlugin());
			genBurden.setDiagramUpdater(GMFGenFactory.eINSTANCE.createGenDiagramUpdater());
			new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/parking")).getContents().add(genBurden);

			genNodkin = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
			genNodkin.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getNode()));
			TypeModelFacet mf = GMFGenFactory.eINSTANCE.createTypeModelFacet();
			mf.setMetaClass(gmm.findGenClass(domainModel.nodkin));
			mf.setContainmentMetaFeature(gmm.findGenFeature(domainModel.refkin));
			mf.setChildMetaFeature(mf.getContainmentMetaFeature());
			genNodkin.setModelFacet(mf);
			genNodkin.setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
			genNodkin.setViewmap(createNodeViewmap());
			genNodkin.setVisualID(nextVID());
			diagramkin.getTopLevelNodes().add(genNodkin);

			a1 = addAttr(gmm, domainModel.a1);
		}

		private int nextVID() {
			return vid++;
		}

		protected GenNodeLabel addAttr(GenModelMatcher gmm, EAttribute... aa) {
			FeatureLabelModelFacet modelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
			for (EAttribute a : aa) {
				modelFacet.getMetaFeatures().add(gmm.findGenFeature(a));
			}
			GenNodeLabel label = GMFGenFactory.eINSTANCE.createGenNodeLabel();
			label.setModelFacet(modelFacet);
			label.setVisualID(nextVID());
			label.setViewmap(createLabelViewmap());
			label.setDiagramRunTimeClass(genNodkin.getDiagramRunTimeClass());
			genNodkin.getLabels().add(label);
			return label;
		}

		private GenModel getRuntimeGenModel() {
			RuntimeGenModelAccess runtimeAccess = new RuntimeGenModelAccess();
			runtimeAccess.ensure();
			return runtimeAccess.model();
		}

		private static Viewmap createDiagramViewmap() {
			FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
			v.setFigureQualifiedClassName("org.eclipse.draw2d.FreeformLayer");
			return v;
		}

		private static Viewmap createNodeViewmap() {
			FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
			v.setFigureQualifiedClassName("org.eclipse.draw2d.RoundedRectangle");
			return v;
		}

		private static Viewmap createLabelViewmap() {
			FigureViewmap v = GMFGenFactory.eINSTANCE.createFigureViewmap();
			v.setFigureQualifiedClassName("org.eclipse.draw2d.Label");
			return v;
		}
	}
}
