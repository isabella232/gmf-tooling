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

import java.lang.reflect.Method;

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
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.LabelTextAccessMethod;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.PredefinedParser;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.internal.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.NeedsSetup;
import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.setup.GenProjectSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.osgi.framework.Bundle;

/**
 * TODO:
 * - test GenParsers reconciler
 * - test custom parser for plain LabelModelFacet
 * - test custom parser for featuremodelfacet
 * - test external parser with custom hint
 * - test non-service parsers
 * @author dstadnik
 */
public class ParsersTest extends TestCase implements NeedsSetup {

	protected ParsersSetup setup;

	public ParsersTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		if (setup == null) {
			configure(new ParsersSetup(true));
		}
	}
	
	public final void configure(ParsersSetup ps) throws Exception {
		setup = ps;
		setup.init();
	}

	@Override
	protected void tearDown() throws Exception {
		setup.dispose();
		setup = null;
	}

	/**
	 * Test for the primary usecase: single attribute of string type is exposed as a label on diagram.
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

	/**
	 * Test label that is based on more than one attribute.
	 */
	public void testMultipleAttributes() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		setAttribute(nodkin, "a1", "aaa");
		setAttribute(nodkin, "a2", "xxx");
		setAttribute(nodkin, "a3", new Integer(555));
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		IParser p = getParser(setup.genModel.a123);
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa xxx 555", s);
		s = p.getEditString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa xxx 555", s);
		ICommand c = p.getParseCommand(new EObjectAdapter(nodkin), "bbb yyy 888", 0);
		assertTrue(c.canExecute());
		c.execute(new NullProgressMonitor(), new EObjectAdapter(nodkin));
		s = (String) getAttribute(nodkin, "a1");
		assertEquals("bbb", s);
		s = (String) getAttribute(nodkin, "a2");
		assertEquals("yyy", s);
		Integer i = (Integer) getAttribute(nodkin, "a3");
		assertEquals(888, i.intValue());
	}

	/**
	 * Test custom message format pattern.
	 */
	public void testCustomMessageFormatPatterns() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		setAttribute(nodkin, "a1", "gold");
		setAttribute(nodkin, "a2", "silver");
		setAttribute(nodkin, "a3", new Integer(100));
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		//		mf.setViewPattern("{2} x {1} ({0})");
		//		mf.setEditPattern("[{1}] - {0}, {2}");
		//		mf.setEditorPattern("{2}/{1}/{0}");

		IParser p = getParser(setup.genModel.ac132);
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertEquals("silver x 100 (gold)", s);
		s = p.getEditString(new EObjectAdapter(nodkin), 0);
		assertEquals("silver/100/gold", s);
		ICommand c = p.getParseCommand(new EObjectAdapter(nodkin), "[50] - ping, pong", 0);
		assertTrue(c.canExecute());
		c.execute(new NullProgressMonitor(), new EObjectAdapter(nodkin));
		s = (String) getAttribute(nodkin, "a1");
		assertEquals("ping", s);
		s = (String) getAttribute(nodkin, "a2");
		assertEquals("pong", s);
		Integer i = (Integer) getAttribute(nodkin, "a3");
		assertEquals(50, i.intValue());
	}

	/**
	 * Test different set of editable attributes.
	 */
	public void testDifferentEditableAttributes() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		setAttribute(nodkin, "a1", "gold");
		setAttribute(nodkin, "a2", "silver");
		setAttribute(nodkin, "a3", new Integer(100));
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		//		mf.setViewPattern("{0}*{1}");
		//		mf.setEditPattern("{0}:{1}");
		//		mf.setEditorPattern("<{1}>{0}");

		IParser p = getParser(setup.genModel.a12e31);
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertEquals("gold*silver", s);
		s = p.getEditString(new EObjectAdapter(nodkin), 0);
		assertEquals("<gold>100", s);
		ICommand c = p.getParseCommand(new EObjectAdapter(nodkin), "23:ping", 0);
		assertTrue(c.canExecute());
		c.execute(new NullProgressMonitor(), new EObjectAdapter(nodkin));
		s = (String) getAttribute(nodkin, "a1");
		assertEquals("ping", s);
		s = (String) getAttribute(nodkin, "a2");
		assertEquals("silver", s);
		Integer i = (Integer) getAttribute(nodkin, "a3");
		assertEquals(23, i.intValue());
	}

	/**
	 * Native parsing method test.
	 */
	public void testNativeParsing() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		setAttribute(nodkin, "a2", "aaa");
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		IParser p = getParser(setup.genModel.an2);
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa", s);
		s = p.getEditString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa", s);
		ICommand c = p.getParseCommand(new EObjectAdapter(nodkin), "bbb", 0);
		assertTrue(c.canExecute());
		c.execute(new NullProgressMonitor(), new EObjectAdapter(nodkin));
		s = (String) getAttribute(nodkin, "a2");
		assertEquals("bbb", s);
	}

	/**
	 * Test printf and regexp parsing methods.
	 */
	public void testPrintfAndRegexpParsing() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		setAttribute(nodkin, "a2", "aaa");
		setAttribute(nodkin, "a3", new Integer(6));
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		IParser p = getParser(setup.genModel.apr23);
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa 6", s);
		s = p.getEditString(new EObjectAdapter(nodkin), 0);
		assertEquals("aaa 6", s);
		ICommand c = p.getParseCommand(new EObjectAdapter(nodkin), "bbb 7", 0);
		assertTrue(c.canExecute());
		c.execute(new NullProgressMonitor(), new EObjectAdapter(nodkin));
		s = (String) getAttribute(nodkin, "a2");
		assertEquals("bbb", s);
		Integer i = (Integer) getAttribute(nodkin, "a3");
		assertEquals(7, i.intValue());
	}

	protected IParser getParser(final GenNodeLabel label) throws Exception {
		final GenEditorGenerator editorGen = setup.genModel.diagramkin.getEditorGen();
		String ppfqn = editorGen.getLabelParsers().getQualifiedClassName();
		Class<?> ppc = setup.project.getBundle().loadClass(ppfqn);
		if (editorGen.getLabelParsers().isExtensibleViaService()) {
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
		} else {
			Object ppInstance = ppc.newInstance();
			assertFalse(ppInstance instanceof IParserProvider);
			// ParserUtils.parserAccessorName: "get" + element.getUniqueIdentifier().toFirstUpper() + "Parser"
			Method parserAccess = ppc.getMethod("get" + label.getUniqueIdentifier() + "Parser");
			assertNotNull(parserAccess);
			return (IParser) parserAccess.invoke(ppInstance);
		}
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

	public static class ParsersSetup implements TestConfiguration {

		public ParsersDomainModel domainModel;
		public ParsersGenModel genModel;
		public GenProjectSetup project;
		private int uses = 0;

		public ParsersSetup(boolean parsersAsProvider) {
			domainModel = new ParsersDomainModel();
			genModel = new ParsersGenModel(domainModel);
			final GenEditorGenerator editorGen = genModel.diagramkin.getEditorGen();
			System.out.println("ParsersSetup.ParsersSetup():" + editorGen.getDomainGenModel().getModelDirectory());
			editorGen.getLabelParsers().setExtensibleViaService(parsersAsProvider);
			String pid = editorGen.getPlugin().getID();
			editorGen.getPlugin().setID(pid + (parsersAsProvider ? ".provider" : ".direct"));
		}

		public void init() throws Exception {
			uses++;
			if (project == null) {
				project = new GenProjectSetup(new RuntimeBasedGeneratorConfiguration()).init(genModel.diagramkin.getEditorGen());
			}
		}

		public void dispose() throws Exception {
			assert uses > 0;
			uses--;
			if (uses == 0 && project != null) {
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
		public GenTopLevelNode nodkin;
		public GenNodeLabel a1, a123, ac132, a12e31, an2, apr23;

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
			genBurden.setLabelParsers(GMFGenFactory.eINSTANCE.createGenParsers());
			genBurden.getLabelParsers().setExtensibleViaService(false);
			new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/parking")).getContents().add(genBurden);

			nodkin = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
			nodkin.setDiagramRunTimeClass(Utils.findGenClass(runtimeModel, NotationPackage.eINSTANCE.getNode()));
			{
				TypeModelFacet mf = GMFGenFactory.eINSTANCE.createTypeModelFacet();
				mf.setMetaClass(gmm.findGenClass(domainModel.nodkin));
				mf.setContainmentMetaFeature(gmm.findGenFeature(domainModel.refkin));
				mf.setChildMetaFeature(mf.getContainmentMetaFeature());
				nodkin.setModelFacet(mf);
			}
			nodkin.setElementType(GMFGenFactory.eINSTANCE.createMetamodelType());
			nodkin.setViewmap(createNodeViewmap());
			nodkin.setVisualID(nextVID());
			diagramkin.getTopLevelNodes().add(nodkin);

			final PredefinedParser messageFormatParser = GMFGenFactory.eINSTANCE.createPredefinedParser();
			final PredefinedParser nativeParser = GMFGenFactory.eINSTANCE.createPredefinedParser();
			nativeParser.setViewMethod(LabelTextAccessMethod.NATIVE);
			nativeParser.setEditMethod(LabelTextAccessMethod.NATIVE);
			final PredefinedParser printfRegexParser = GMFGenFactory.eINSTANCE.createPredefinedParser();
			printfRegexParser.setViewMethod(LabelTextAccessMethod.PRINTF);
			printfRegexParser.setEditMethod(LabelTextAccessMethod.REGEXP);
			genBurden.getLabelParsers().getImplementations().add(messageFormatParser);
			genBurden.getLabelParsers().getImplementations().add(nativeParser);
			genBurden.getLabelParsers().getImplementations().add(printfRegexParser);
			a1 = addAttr(gmm, domainModel.a1);
			{
				FeatureLabelModelFacet mf = (FeatureLabelModelFacet) a1.getModelFacet();
				mf.setParser(messageFormatParser);
			}
			a123 = addAttr(gmm, domainModel.a1, domainModel.a2, domainModel.a3);
			{
				FeatureLabelModelFacet mf = (FeatureLabelModelFacet) a123.getModelFacet();
				mf.setParser(messageFormatParser);
			}
			ac132 = addAttr(gmm, domainModel.a1, domainModel.a3, domainModel.a2);
			{
				FeatureLabelModelFacet mf = (FeatureLabelModelFacet) ac132.getModelFacet();
				mf.setViewPattern("{2} x {1} ({0})");
				mf.setEditPattern("[{1}] - {0}, {2}");
				mf.setEditorPattern("{2}/{1}/{0}");
				mf.setParser(messageFormatParser);
			}
			a12e31 = addAttr(gmm, domainModel.a1, domainModel.a2);
			{
				FeatureLabelModelFacet mf = (FeatureLabelModelFacet) a12e31.getModelFacet();
				mf.setViewPattern("{0}*{1}");
				mf.getEditableMetaFeatures().add(gmm.findGenFeature(domainModel.a3));
				mf.getEditableMetaFeatures().add(gmm.findGenFeature(domainModel.a1));
				mf.setEditPattern("{0}:{1}");
				mf.setEditorPattern("<{1}>{0}");
				mf.setParser(messageFormatParser);
			}
			an2 = addAttr(gmm, domainModel.a2);
			{
				FeatureLabelModelFacet mf = (FeatureLabelModelFacet) an2.getModelFacet();
				mf.setParser(nativeParser);
			}
			apr23 = addAttr(gmm, domainModel.a2, domainModel.a3);
			{
				FeatureLabelModelFacet mf = (FeatureLabelModelFacet) apr23.getModelFacet();
				mf.setParser(printfRegexParser);
			}
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
			label.setDiagramRunTimeClass(nodkin.getDiagramRunTimeClass());
			nodkin.getLabels().add(label);
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
