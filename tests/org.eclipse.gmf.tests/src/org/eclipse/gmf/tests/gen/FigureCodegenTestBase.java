/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Ellipse;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.Font;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.Polygon;
import org.eclipse.gmf.gmfgraph.PolygonDecoration;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.internal.common.codegen.ImportUtil;
import org.eclipse.gmf.internal.graphdef.codegen.GalleryProcessor;
import org.eclipse.gmf.tests.CompileUtil;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * @author artem
 * @author michael.golubev
 */
public class FigureCodegenTestBase extends TestCase {
	protected static final String DRAW2D = "org.eclipse.draw2d";
	private FigureGenerator figureGenerator;
	protected String myFigurePackageName = "org.eclipse.gmf.tests.sample.figures";
	
	public FigureCodegenTestBase(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		SessionSetup.getRuntimeWorkspaceSetup();
	}
	
	protected final void setCustomFigureGenerator(FigureGenerator generator){
		figureGenerator = generator;
	}
	
	protected void performTests(Figure f) {
		performTests(f, new GenericFigureCheck(f));
	}

	protected final void performTests(Figure f, FigureCheck check) {
		generateAndParse(f);
		Class figureClass = generateAndCompile(getGMFGraphGeneratorConfig(), f);
		if (check != null){
			IFigure figure = check.instantiateFigure(figureClass);
			assertNotNull(figure);
			check.checkFigure(figure);
		}
	}
	
	protected final void generateAndParse(Figure f){
		String res = getGenerator().go(f, createImportManager(f));
		
		assertNotNull("Generation should produce code", res);
		ASTParser p = ASTParser.newParser(AST.JLS3);
		p.setSource(res.toCharArray());
		ASTNode astNode = p.createAST(null);
		assertEquals("Generator is expected to produce cu", astNode.getNodeType(), ASTNode.COMPILATION_UNIT);
		CompilationUnit cu = (CompilationUnit) astNode;
		if (getFigurePackageName() != null) {
			assertNotNull("Generator initialized with packageName should produce package statement", cu.getPackage());
			assertEquals("Package names are different", getFigurePackageName(), cu.getPackage().getName().getFullyQualifiedName());
		} else {
			assertNull(cu.getPackage());
		}
		IProblem[] problems = cu.getProblems();
		for (int i = 0; i < problems.length; i++) {
			assertFalse(problems[i].getMessage() + ", line:" + problems[i].getSourceLineNumber() + ", pos:" + cu.getColumnNumber(problems[i].getSourceStart()), problems[i].isError());
		}
	}
	
	protected StandaloneGenerator.Config getGMFGraphGeneratorConfig(){
		return new StandaloneGenerator.ConfigImpl(getTestPluginName(), getFigurePackageName()); 
	}
	
	protected final Class generateAndCompile(StandaloneGenerator.Config config, Figure figure) {
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		gallery.setName("bb");
		gallery.getFigures().add(figure);
		gallery.setImplementationBundle(Plugin.getPluginID());
		
		GeneratedClassData[] theOnly = generateAndCompile(config, gallery);
		assertNotNull(theOnly);
		assertEquals(1, theOnly.length);
		return theOnly[0].getLoadedClass();
	}
	
	protected final GeneratedClassData[] generateAndCompile(StandaloneGenerator.Config config, FigureGallery gallery) {
		if (gallery.getName() == null){
			gallery.setName("NameDoesNotMakeSense");
		}
		assertNotNull(gallery.getImplementationBundle());
		assertFalse(gallery.getFigures().isEmpty());
		
		try {
			StandaloneGenerator generator = new StandaloneGenerator(new GalleryProcessor(gallery), config, new RuntimeFQNSwitch());
			generator.run();
			assertTrue(generator.getRunStatus().toString(), generator.getRunStatus().getSeverity() < IStatus.ERROR);
			
			Bundle bundle = installPlugin(config.getPluginID());
			
			ArrayList result = new ArrayList();
			for (Iterator figures = gallery.getFigures().iterator(); figures.hasNext();){
				Figure next = (Figure) figures.next();
				String fqnName;
				if (config.getMainPackageName() == null || config.getMainPackageName().trim().length() == 0) {
					fqnName = next.getName();
				} else {
					fqnName = config.getMainPackageName() + '.' + next.getName();
				}
				result.add(new GeneratedClassData(next, bundle.loadClass(fqnName))); 
			}
			return (GeneratedClassData[]) result.toArray(new GeneratedClassData[result.size()]);
		} catch (MalformedURLException e) {
			fail(e.getMessage());
		} catch (BundleException e) {
			fail(e.getMessage());
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		} catch (CoreException e){
			fail(e.getMessage());
		} catch (Exception e){
			fail(e.getMessage());
		}
		throw new InternalError("Impossible");
	}
	
	protected final Bundle installPlugin(String pluginId) throws CoreException, Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		SessionSetup.getRuntimeWorkspaceSetup().updateClassPath(project);
		IStatus compileStatus = new CompileUtil().build(project);
		assertTrue(compileStatus.getMessage(), compileStatus.getSeverity() < IStatus.ERROR);
		
		String url = project.getLocation().toFile().toURL().toExternalForm();
		return Plugin.getBundleContext().installBundle(url);
	}

	// custom top-level, hierarchical children, no custom properties
	protected final Figure figure1() {
		CustomFigure cf = GMFGraphFactory.eINSTANCE.createCustomFigure();
		cf.setName("MyRRectangleAsCustom");
		cf.setBundleName(DRAW2D);
		cf.setQualifiedClassName(org.eclipse.draw2d.RoundedRectangle.class.getName());
		Point p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(1023);
		p.setY(33);
		cf.setSize(p);
		cf.getChildren().add(figure2());
		Ellipse e = GMFGraphFactory.eINSTANCE.createEllipse();
		e.setName("Elli");
		e.setFill(true);
		cf.getChildren().add(e);
		return cf;
	}

	// basic toplevel with plain list of children 
	protected final Figure figure2() {
		Rectangle r = GMFGraphFactory.eINSTANCE.createRectangle();
		r.setName("MyRect");
		r.setFill(true);
		r.setLineWidth(3);
		r.setLineKind(LineKind.LINE_DASHDOT_LITERAL);
		Label l1 = GMFGraphFactory.eINSTANCE.createLabel();
		l1.setText("aaaaa");
		l1.setName("L1");
		l1.setFont(createBasicFont("Arial", 9, FontStyle.ITALIC_LITERAL));
		l1.setForegroundColor(createConstantColor(ColorConstants.CYAN_LITERAL));
		Label l2 = GMFGraphFactory.eINSTANCE.createLabel();
		l2.setText("bbbbb");
		l2.setName("L2");
		l2.setFont(createBasicFont("Helvetica", 12, FontStyle.BOLD_LITERAL));
		r.getChildren().add(l1);
		r.getChildren().add(l2);
		return r;
	}
	
	// basic toplebel with hierarhical list of children (one of them is custom, another is polygon) 
	protected final Figure figure3() {
		RoundedRectangle r = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		r.setName("Rounded1");
		Polygon pg = GMFGraphFactory.eINSTANCE.createPolygon();
		pg.setName("Polygon1");
		Point p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(1);
		p.setY(2);
		pg.getTemplate().add(p);
		p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(0);
		p.setY(3);
		pg.getTemplate().add(p);
		p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(-2);
		p.setY(-1);
		pg.getTemplate().add(p);
		r.getChildren().add(pg);
		r.getChildren().add(figure1());
		return r;
	}
	
	protected final ConnectionFigure ecoreContainmentRef() {
		PolylineConnection cf = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		cf.setName("ContainmentRef");
		PolygonDecoration df = createRhomb();
		df.setFill(true);
		cf.setSourceDecoration(df);
		return cf;
	}

	protected final PolygonDecoration createRhomb() {
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

	protected final String getFigurePackageName(){
		return myFigurePackageName ;
	}
	
	protected final String getTestPluginName(){
		return "org.eclipse.gmf.tests.sample.figures." + getName() + ".t" + System.currentTimeMillis();
	}
	
	protected final String getPluginActivatorClassFQN(){
		return getFigurePackageName() == null ? "PluginActivator" : getFigurePackageName() + '.' + "PluginActivator"; 
	}

	protected ImportAssistant createImportManager(Figure f) {
		return new ImportUtil(getFigurePackageName(), CodeGenUtil.validJavaIdentifier(f.getName()));
	}

	private FigureGenerator getGenerator() {
		if (figureGenerator == null) {
			figureGenerator = new FigureGenerator(new RuntimeFQNSwitch(), false);
		}
		return figureGenerator;
	}
	
	public static abstract class FigureCheck extends Assert  {
		/**
		 * Overridable to allow not default construction
		 */
		protected IFigure instantiateFigure(Class figureClass){
			Object result = null;
			try {
				result = figureClass.newInstance();
			} catch (InstantiationException e) {
				fail(e.getMessage());
			} catch (IllegalAccessException e) {
				fail(e.getMessage());
			}
			assertNotNull(result);
			assertTrue(figureClass.getName(), result instanceof IFigure);
			return (IFigure)result;
		}
		
		public abstract void checkFigure(IFigure figure);
	}
	
	public static FigureCheck combineChecks(final FigureCheck[] checks){
		assertNotNull(checks);
		assertTrue(checks.length > 0);
		
		return new FigureCheck(){
			protected IFigure instantiateFigure(Class figureClass) {
				//can not instantiate twice
				return checks[0].instantiateFigure(figureClass);
			}
			
			public void checkFigure(IFigure figure) {
				for (int i = 0; i < checks.length; i++){
					checks[i].checkFigure(figure);
				}
			}
		};
	}
	
	public static FigureCheck combineChecks(FigureCheck first, FigureCheck second){
		return combineChecks(new FigureCheck[] {first, second});
	}
	
	protected static final ConstantColor createConstantColor(ColorConstants constant) {
		ConstantColor result = GMFGraphFactory.eINSTANCE.createConstantColor();
		result.setValue(constant);
		return result;
	}
	
	protected static final RGBColor createRGBColor(int red, int green, int blue) {
		RGBColor result = GMFGraphFactory.eINSTANCE.createRGBColor();
		result.setRed(red);
		result.setGreen(green);
		result.setBlue(blue);
		return result;
	}

	protected static final Font createBasicFont(String name, int height, FontStyle style){
		BasicFont result = GMFGraphFactory.eINSTANCE.createBasicFont();
		result.setFaceName(name);
		result.setHeight(height);
		result.setStyle(style);
		return result;
	}
	
	protected static class GeneratedClassData {
		private final Figure myFigureDef;
		private final Class myLoadedClass;

		public GeneratedClassData(Figure figureDef, Class loadedClass){
			myFigureDef = figureDef;
			myLoadedClass = loadedClass;
		}
		
		public Class getLoadedClass() {
			return myLoadedClass;
		}
		
		public Figure getFigureDef() {
			return myFigureDef;
		}
	}
	
	protected static final FigureCheck CHECK_CAN_CREATE_INSTANCE = new FigureCheck(){
		public void checkFigure(IFigure figure) {
			//
		}
	};

}
