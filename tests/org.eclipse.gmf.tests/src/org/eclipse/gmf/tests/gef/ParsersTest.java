/*
 * Copyright (c) 2008, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (independent) - [138179] expressions-based labels
 */
package org.eclipse.gmf.tests.gef;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.internal.bridge.genmodel.RuntimeGenModelAccess;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.NeedsSetup;
import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.setup.GenProjectSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.osgi.framework.Bundle;

/**
 * TODO:
 * - test GenParsers reconciler
 * XXX Perhaps, makes sense to change getParser method to access IParsers not through IParserProvider class 
 * but through EditPart#getParser method - as we anyway do that for ExternalParser cases
 * @author dstadnik
 */
public class ParsersTest extends TestCase {

	protected ParsersSetup setup;

	public ParsersTest(String name) {
		super(name);
	}

	@NeedsSetup
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

	public void testCustomParserPlainLabelModelFacet() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		assertTrue("sanity", setup.genModel.a_cp_pmf.getModelFacet().eClass() == GMFGenPackage.eINSTANCE.getLabelModelFacet());
		IParser p = getParser(setup.genModel.a_cp_pmf);
		assertNotNull(p);
		assertEquals("MyCustomParser", p.getClass().getSimpleName());
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertNotNull(s);
		assertEquals(p.getClass().getName(), s);
	}

	// the only difference between this and previous test is use of another label with another model facet
	public void testCustomParserFeatureLabelModelFacet() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		setAttribute(nodkin, "a1", "aaa"); // not necessary, though
		r.getContents().add(nodkin);
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		assertTrue("sanity", setup.genModel.a_cp_flmf.getModelFacet().eClass() == GMFGenPackage.eINSTANCE.getFeatureLabelModelFacet());
		IParser p = getParser(setup.genModel.a_cp_flmf);
		assertNotNull(p);
		assertEquals("MyCustomParser", p.getClass().getSimpleName());
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertNotNull(s);
		assertEquals(p.getClass().getName(), s);
	}

	/**
	 * ExternalParser is invoked via ParserService, not through our generated
	 * parser provider class, hence can't use {@link #getParser(GenNodeLabel)}
	 */
	@SuppressWarnings("unchecked")
	public void testExternalParserWithHint() throws Exception  {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		r.getContents().add(nodkin);
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		Class<?> epc = setup.project.getBundle().loadClass(setup.genModel.a_extp.getEditPartQualifiedClassName());
		final Node notationElement = NotationFactory.eINSTANCE.createNode();
		notationElement.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		notationElement.setElement(notationElement); // since LabelModelFacer is not DesignLabelModelFacet,
		// getParserElement() would try to resolveSemanticElement, but DiagramParserProvider needs an View with 
		// DescStyle  
		Object epInstance = epc.getConstructor(View.class).newInstance(notationElement);
		IParser p = (IParser) epc.getMethod("getParser").invoke(epInstance);
		assertNotNull(p);
		assertEquals("org.eclipse.gmf.runtime.diagram.ui.providers.parsers.DescriptionParser", p.getClass().getName());
	}
	
	public void testExpressionLabelParser() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("uri://org.eclipse.gmf/tests/parkins"));
		EObject nodkin = createNodkin();
		setAttribute(nodkin, "a1", "aaa");
		setAttribute(nodkin, "a2", ""); // if not set, 'if' statement should be rewritten to respect Invalid case (null a2 in a2.size()) 
		r.getContents().add(nodkin);
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);

		assertTrue("sanity", setup.genModel.a_expr.getModelFacet().eClass() == GMFGenPackage.eINSTANCE.getExpressionLabelModelFacet());
		IParser p = getParser(setup.genModel.a_expr);
		assertNotNull(p);
		assertEquals("MyExpressionParser", p.getClass().getSimpleName());
		String s = p.getPrintString(new EObjectAdapter(nodkin), 0);
		assertNotNull(s);
		assertEquals("aaa ==> <none>", s);
	}


	protected IParser getParser(final GenNodeLabel label) throws Exception {
		final GenEditorGenerator editorGen = setup.genModel.diagramkin.getEditorGen();
		String ppfqn = editorGen.getLabelParsers().getQualifiedClassName();
		Class<?> ppc = setup.project.getBundle().loadClass(ppfqn);
		Node notationElement = NotationFactory.eINSTANCE.createNode(); // just not to pass null to ParserHintAdapter
		if (editorGen.getLabelParsers().isExtensibleViaService()) {
			IParserProvider pp = (IParserProvider) ppc.newInstance();
			ParserHintAdapter param = new ParserHintAdapter(notationElement, String.valueOf(label.getVisualID()));
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
		private final RuntimeBasedGeneratorConfiguration myGeneratorConfiguration;

		public ParsersSetup(boolean parsersAsProvider, RuntimeBasedGeneratorConfiguration genConfig) {
			domainModel = new ParsersDomainModel();
			genModel = new ParsersGenModel(domainModel);
			final GenEditorGenerator editorGen = genModel.diagramkin.getEditorGen();
			editorGen.getLabelParsers().setExtensibleViaService(parsersAsProvider);
			String pid = editorGen.getPlugin().getID();
			editorGen.getPlugin().setID(pid + (parsersAsProvider ? ".provider" : ".direct"));
			myGeneratorConfiguration = genConfig;
		}

		
		public ParsersSetup(boolean parsersAsProvider) {
			this(parsersAsProvider, new RuntimeBasedGeneratorConfiguration());
		}

		public void init() throws Exception {
			uses++;
			if (project == null) {
				project = new GenProjectSetup(myGeneratorConfiguration) {
					@Override
					protected void hookExtraCodeGeneration(GenEditorGenerator genEditor, IProject project) throws Exception {
						// need an extra class for custom parser
						// intentionally using a package different from the rest of the parsers 
						String pkgName = genEditor.getDiagram().getEditPartsPackageName();
						String className = "MyCustomParser";
						IFolder f = (IFolder) project.findMember(new Path("src").append(pkgName.replace('.', '/')));
						assertNotNull(f);
						String x = "package " + pkgName + ";\n" +
						"import org.eclipse.core.runtime.IAdaptable;\n" +
						"import org.eclipse.gmf.runtime.common.core.command.ICommand;\n" +
						"import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;\n" +
						"import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;\n" +
						"import org.eclipse.jface.text.contentassist.IContentAssistProcessor;\n" +
						"\n" +
						"public class " + className + " implements IParser {\n" +
						"public IContentAssistProcessor getCompletionProcessor(IAdaptable element) { return null; }\n" +
						"public String getEditString(IAdaptable element, int flags) { return null; }\n" +
						"public ICommand getParseCommand(IAdaptable element, String newString, int flags) { return null; }\n" +
						"public String getPrintString(IAdaptable element, int flags) { return MyCustomParser.class.getName(); }\n" +
						"public boolean isAffectingEvent(Object event, int flags) { return false; }\n" +
						"public IParserEditStatus isValidEditString(IAdaptable element, String editString) { return null; }}";

						f.getFile(className + ".java").create(new ByteArrayInputStream(x.getBytes()), true, new NullProgressMonitor());
					}
				}.init(genModel.diagramkin.getEditorGen());
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
		public GenNodeLabel a_cp_pmf, a_cp_flmf, a_extp; // Custom and External Parsers
		public GenNodeLabel a_expr; // ExpressionLabelParser

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
			genBurden.setExpressionProviders(GMFGenFactory.eINSTANCE.createGenExpressionProviderContainer());
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
			
			final CustomParser customParser = GMFGenFactory.eINSTANCE.createCustomParser();
			customParser.setQualifiedName(diagramkin.getEditPartsPackageName() + ".MyCustomParser");
			customParser.setGenerateBoilerplate(false); // because we will generate this class externally, see ParsersSetup#GenProjectSetup#hookExtraCodeGeneration
			
			final ExternalParser externalParser = GMFGenFactory.eINSTANCE.createExternalParser();
			externalParser.setHint("\"Description\""); // value of CommonParserHint.DESCIPTION constant, 
			// not the constant itself to manually (visually) assure (in the generated class) the hint is being used.
			final ExpressionLabelParser expressionParser = GMFGenFactory.eINSTANCE.createExpressionLabelParser();
			expressionParser.setExpressionContext(nodkin.getDomainMetaClass());
			GenJavaExpressionProvider javaProvider = GMFGenFactory.eINSTANCE.createGenJavaExpressionProvider();
			GenExpressionInterpreter oclProvider = GMFGenFactory.eINSTANCE.createGenExpressionInterpreter();
			oclProvider.setLanguage(GenLanguage.OCL_LITERAL);
			GenLiteralExpressionProvider asisProvider = GMFGenFactory.eINSTANCE.createGenLiteralExpressionProvider();
			genBurden.getExpressionProviders().getProviders().add(javaProvider);
			genBurden.getExpressionProviders().getProviders().add(oclProvider);
			genBurden.getExpressionProviders().getProviders().add(asisProvider);
			ValueExpression v1 = GMFGenFactory.eINSTANCE.createValueExpression();
			v1.setBody("self.a1.concat(' ==> ').concat(if self.a2.size() > 0 then self.a2 else '<none>' endif)");
			oclProvider.getExpressions().add(v1);
			expressionParser.setViewExpression(v1);
			ValueExpression v2 = GMFGenFactory.eINSTANCE.createValueExpression();
			v2.setBody("\"[enter new value here]\"");
			asisProvider.getExpressions().add(v2);
			expressionParser.setEditExpression(v2);
			GenConstraint v3 = GMFGenFactory.eINSTANCE.createGenConstraint();
			v3.setBody("return Boolean.valueOf(self.length() > 2);");
			javaProvider.getExpressions().add(v3);
			javaProvider.setInjectExpressionBody(true);
			expressionParser.setValidateExpression(v3);
			expressionParser.setClassName("MyExpressionParser");
			//
			genBurden.getLabelParsers().getImplementations().add(messageFormatParser);
			genBurden.getLabelParsers().getImplementations().add(nativeParser);
			genBurden.getLabelParsers().getImplementations().add(printfRegexParser);
			genBurden.getLabelParsers().getImplementations().add(customParser);
			genBurden.getLabelParsers().getImplementations().add(externalParser);
			genBurden.getLabelParsers().getImplementations().add(expressionParser);
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
			an2.getModelFacet().setParser(nativeParser);
			//
			apr23 = addAttr(gmm, domainModel.a2, domainModel.a3);
			apr23.getModelFacet().setParser(printfRegexParser);
			//
			a_cp_pmf = addAttr(gmm);
			a_cp_pmf.setModelFacet(GMFGenFactory.eINSTANCE.createLabelModelFacet());
			a_cp_pmf.getModelFacet().setParser(customParser);
			//
			a_cp_flmf = addAttr(gmm, domainModel.a1);
			{
				// need to get different name than default
				// which conflicts with a1's name
				a_cp_flmf.setEditPartClassName("AttrWithCustomParserEditPart");
				a_cp_flmf.getModelFacet().setParser(customParser);
			}
			a_extp = addAttr(gmm);
			a_extp.setEditPartClassName("LabelWithExternalParserEditPart");
			a_extp.setModelFacet(GMFGenFactory.eINSTANCE.createLabelModelFacet());
			a_extp.getModelFacet().setParser(externalParser);
			//
			a_expr = addAttr(gmm);
			a_expr.setEditPartClassName("LabelWithExpressionParserEditPart");
			a_expr.setModelFacet(GMFGenFactory.eINSTANCE.createExpressionLabelModelFacet());
			a_expr.getModelFacet().setParser(expressionParser);
			
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
