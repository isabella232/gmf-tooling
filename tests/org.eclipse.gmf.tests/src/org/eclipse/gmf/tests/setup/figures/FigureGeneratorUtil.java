/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.figures;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Dimension;
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
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Processor;
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

public class FigureGeneratorUtil {

	public static final String DRAW2D = "org.eclipse.draw2d";

	public static final String DEFAULT_FIGURE_PACKAGE = "org.eclipse.gmf.tests.sample.figures";

	public static final String DEFAULT_PLUGIN_ACTIVATOR = DEFAULT_FIGURE_PACKAGE + ".PluginActivator";

	// FigureGenerator: utility methods to generate/compile/instantiate figures
	
	public static void performTests(Figure f, FigureCheck check) {
		performTests(f, check, createStandaloneGeneratorConfig());
	}
	
	public static void performTests(Figure f, FigureCheck check, Config config) {
		generateAndParse(f);
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		gallery.setName("bb");
		gallery.getFigures().add(f);
		gallery.setImplementationBundle(Plugin.getPluginID());

		GeneratedClassData[] theOnly = generateAndCompile(gallery, config);
		Assert.assertNotNull(theOnly);
		Assert.assertEquals(1, theOnly.length);
		Class figureClass = theOnly[0].getLoadedClass();
		if (check != null){
			IFigure figure = check.instantiateFigure(figureClass);
			Assert.assertNotNull(figure);
			check.checkFigure(figure);
		}
	}
	
	public static void generate(StandaloneGenerator.Config config, Processor processor) {
		StandaloneGenerator generator = new StandaloneGenerator(processor, config, new RuntimeFQNSwitch());
		generator.run();
		Assert.assertTrue(generator.getRunStatus().toString(), generator.getRunStatus().getSeverity() < IStatus.ERROR);
	}
	
	public static GeneratedClassData[] generateAndCompile(FigureGallery gallery) {
		return generateAndCompile(gallery, createStandaloneGeneratorConfig());
	}

	public static GeneratedClassData[] generateAndCompile(FigureGallery gallery, StandaloneGenerator.Config config) {
		if (gallery.getName() == null){
			gallery.setName("NameDoesNotMakeSense");
		}
		Assert.assertNotNull(gallery.getImplementationBundle());
		Assert.assertFalse(gallery.getFigures().isEmpty());

		generate(config, new GalleryProcessor(gallery));
		
		try {
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
			Assert.fail(e.getMessage());
		} catch (BundleException e) {
			Assert.fail(e.getMessage());
		} catch (ClassNotFoundException e) {
			Assert.fail(e.getMessage());
		} catch (CoreException e){
			Assert.fail(e.getMessage());
		} catch (Exception e){
			Assert.fail(e.getMessage());
		}
		Assert.fail("Should not be here!");
		return null;
	}
	
	public static Bundle installPlugin(String pluginId) throws CoreException, Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		SessionSetup.getRuntimeWorkspaceSetup().updateClassPath(project);
		IStatus compileStatus = new CompileUtil().build(project);
		Assert.assertTrue(compileStatus.getMessage(), compileStatus.getSeverity() < IStatus.ERROR);
		String url = project.getLocation().toFile().toURL().toExternalForm();
		return Plugin.getBundleContext().installBundle(url);
	}
	
	public static void generateAndParse(Figure f) {
		generateAndParse(f, new FigureGenerator(new RuntimeFQNSwitch(), false));
	}

	public static void generateAndParse(Figure f, FigureGenerator generator) {
		generateAndParse(f, generator, DEFAULT_FIGURE_PACKAGE);
	}

	public static void generateAndParse(Figure f, FigureGenerator generator, String packageName) {
		ImportAssistant importManager = createImportManager(packageName, f);
		String res = generator.go(f, importManager);

		Assert.assertNotNull("Generation should produce code", res);
		ASTParser p = ASTParser.newParser(AST.JLS3);
		p.setSource(res.toCharArray());
		ASTNode astNode = p.createAST(null);
		Assert.assertEquals("Generator is expected to produce cu", astNode.getNodeType(), ASTNode.COMPILATION_UNIT);
		CompilationUnit cu = (CompilationUnit) astNode;
		if (packageName != null) {
			Assert.assertNotNull("Generator initialized with packageName should produce package statement", cu.getPackage());
			Assert.assertEquals("Package names are different", packageName, cu.getPackage().getName().getFullyQualifiedName());
		} else {
			Assert.assertNull(cu.getPackage());
		}
		IProblem[] problems = cu.getProblems();
		for (int i = 0; i < problems.length; i++) {
			Assert.assertFalse(problems[i].getMessage() + ", line:" + problems[i].getSourceLineNumber() + ", pos:" + cu.getColumnNumber(problems[i].getSourceStart()), problems[i].isError());
		}
	}

	public static ImportAssistant createImportManager(Figure figure) {
		return createImportManager(DEFAULT_FIGURE_PACKAGE, figure);
	}

	private static ImportAssistant createImportManager(String packageName, Figure figure) {
		return new ImportUtil(packageName, CodeGenUtil.validJavaIdentifier(figure.getName()));
	}
	
	public static Config createStandaloneGeneratorConfig() {
		return new StandaloneGenerator.ConfigImpl(createTestPluginName(), DEFAULT_FIGURE_PACKAGE);
	}
	
	public static Config createStandaloneGeneratorConfig(String packageName, boolean useMapMode) {
		return new StandaloneGenerator.ConfigImpl(createTestPluginName(), packageName, useMapMode);
	}

	private static String createTestPluginName() {
		return "org.eclipse.gmf.tests.sample.figures.t" + System.currentTimeMillis();
	}

	public static class GeneratedClassData {

		private final Figure myFigureDef;

		private final Class myLoadedClass;

		public GeneratedClassData(Figure figureDef, Class loadedClass) {
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

	// GMFGRAPH: Common figures + utility methods reused across all the tests.

	public static Figure createFigure1() {
		CustomFigure cf = GMFGraphFactory.eINSTANCE.createCustomFigure();
		cf.setName("MyRRectangleAsCustom");
		cf.setBundleName(DRAW2D);
		cf.setQualifiedClassName(org.eclipse.draw2d.RoundedRectangle.class.getName());
		Point p = GMFGraphFactory.eINSTANCE.createPoint();
		p.setX(1023);
		p.setY(33);
		cf.setSize(p);
		cf.getChildren().add(createFigure2());
		Ellipse e = GMFGraphFactory.eINSTANCE.createEllipse();
		e.setName("Elli");
		e.setFill(true);
		cf.getChildren().add(e);
		return cf;
	}

	public static Figure createFigure2() {
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

	public static Figure createFigure3() {
		Figure myFigure3 = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		myFigure3.setName("Rounded1");
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
		myFigure3.getChildren().add(pg);
		myFigure3.getChildren().add(createFigure1());
		return myFigure3;
	}

	public static ConstantColor createConstantColor(ColorConstants constant) {
		ConstantColor result = GMFGraphFactory.eINSTANCE.createConstantColor();
		result.setValue(constant);
		return result;
	}

	public static RGBColor createRGBColor(int red, int green, int blue) {
		RGBColor result = GMFGraphFactory.eINSTANCE.createRGBColor();
		result.setRed(red);
		result.setGreen(green);
		result.setBlue(blue);
		return result;
	}

	public static Font createBasicFont(String name, int height, FontStyle style) {
		BasicFont result = GMFGraphFactory.eINSTANCE.createBasicFont();
		result.setFaceName(name);
		result.setHeight(height);
		result.setStyle(style);
		return result;
	}

	public static Dimension createDimension(int dx, int dy) {
		Dimension result = GMFGraphFactory.eINSTANCE.createDimension();
		result.setDx(dx);
		result.setDy(dy);
		return result;
	}

}
