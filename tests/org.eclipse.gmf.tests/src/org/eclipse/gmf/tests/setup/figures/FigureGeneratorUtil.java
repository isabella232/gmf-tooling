/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureRef;
import org.eclipse.gmf.gmfgraph.Font;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.RGBColor;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.graphdef.codegen.FigureGenerator;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Processor;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.ProcessorCallback;
import org.eclipse.gmf.internal.graphdef.codegen.GalleryProcessor;
import org.eclipse.gmf.tests.CompileUtil;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.RuntimeWorkspaceSetup;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.osgi.framework.Bundle;

public class FigureGeneratorUtil {

	public static final String DEFAULT_FIGURE_PACKAGE = "org.eclipse.gmf.tests.sample.figures";

	public static final String DEFAULT_PLUGIN_ACTIVATOR = DEFAULT_FIGURE_PACKAGE + ".PluginActivator";

	// FigureGenerator: utility methods to generate/compile/instantiate figures

	public static void generate(StandaloneGenerator.Config config, Processor processor) {
		StandaloneGenerator generator = new StandaloneGenerator(processor, config, null);
		generator.run();
		Assert.assertTrue(generator.getRunStatus().toString(), generator.getRunStatus().getSeverity() < IStatus.ERROR);
	}
	
	public static GeneratedClassData[] generateAndCompile(FigureGallery gallery) {
		return generateAndCompile(gallery, createStandaloneGeneratorConfig());
	}

	public static GeneratedClassData[] generateAndCompile(StandaloneGenerator.Config config, RealFigure... figures) {
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		gallery.setName("bb");
		gallery.getFigures().addAll(Arrays.asList(figures));
		return generateAndCompile(gallery, config);
	}

	public static GeneratedClassData[] generateAndCompile(final FigureGallery gallery, StandaloneGenerator.Config config) {
		Assert.assertTrue(gallery.getName() != null && gallery.getName().trim().length() > 0);
		Assert.assertFalse(gallery.getFigures().isEmpty() && gallery.getDescriptors().isEmpty());

		final Map<FigureDescriptor, String> fqns = new HashMap<FigureDescriptor, String>();
		generate(config, new GalleryProcessor(gallery) {
			@Override
			public void go(ProcessorCallback callback, Config config) throws InterruptedException {
				super.go(callback, config);
				for (RealFigure f : gallery.getFigures()) {
					FigureRef fr = GMFGraphFactory.eINSTANCE.createFigureRef();
					fr.setFigure(f);
					FigureDescriptor fakeDesc = DiaDefSetup.newDescriptor(f.getName(), fr);
					String fqn = callback.visitFigure(fakeDesc);
					handle(fakeDesc, fqn);
				}
			}
			@Override
			protected void handle(FigureDescriptor next, String fqn) {
				fqns.put(next, fqn);
			}
		});
		
		try {
			Bundle bundle = installPlugin(config.getPluginID());
			ArrayList<GeneratedClassData> result = new ArrayList<GeneratedClassData>();
			for (FigureDescriptor next : fqns.keySet()) {
				result.add(new GeneratedClassData(next, bundle.loadClass(fqns.get(next)))); 
			}
			return result.toArray(new GeneratedClassData[result.size()]);
		} catch (Exception e){
			Assert.fail(e.getClass().getSimpleName() + ":" + e.getMessage());
		}
		Assert.fail("Should not be here!");
		return null;
	}
	
	public static Bundle installPlugin(String pluginId) throws CoreException, Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		IStatus compileStatus = new CompileUtil().build(project);
		Assert.assertTrue(compileStatus.getMessage(), compileStatus.getSeverity() < IStatus.ERROR);
		RuntimeWorkspaceSetup.get().getReadyToStartAsBundle(project);
		String url = project.getLocation().toFile().toURL().toExternalForm();
		return Plugin.getBundleContext().installBundle(url);
	}
	
	public static void generateAndParse(RealFigure f) {
		generateAndParse(f, new FigureGenerator(null, DEFAULT_FIGURE_PACKAGE, false));
	}

	public static void generateAndParse(FigureDescriptor f) {
		generateAndParse(f, new FigureGenerator(null, DEFAULT_FIGURE_PACKAGE, false));
	}

	public static void generateAndParse(RealFigure f, FigureGenerator generator) {
		FigureDescriptor fd = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
		// XXX the only goal of FigureRef here is to keep original figure containment intact
		FigureRef fr = GMFGraphFactory.eINSTANCE.createFigureRef();
		fr.setFigure(f);
		fd.setActualFigure(fr);
		fd.setName(f.getName());
		generateAndParse(fd, generator);
	}

	public static void generateAndParse(FigureDescriptor fd, FigureGenerator generator) {
		String res = generator.go(fd);

		Assert.assertNotNull("Generation should produce code", res);
		ASTParser p = ASTParser.newParser(AST.JLS3);
		p.setSource(res.toCharArray());
		ASTNode astNode = p.createAST(null);
		Assert.assertEquals("Generator is expected to produce cu", astNode.getNodeType(), ASTNode.COMPILATION_UNIT);
		CompilationUnit cu = (CompilationUnit) astNode;
		if (generator.getPackageName() != null) {
			Assert.assertNotNull("Generator initialized with packageName should produce package statement", cu.getPackage());
			Assert.assertEquals("Package names are different", generator.getPackageName(), cu.getPackage().getName().getFullyQualifiedName());
		} else {
			Assert.assertNull(cu.getPackage());
		}
		IProblem[] problems = cu.getProblems();
		for (int i = 0; i < problems.length; i++) {
			Assert.assertFalse(problems[i].getMessage() + ", line:" + problems[i].getSourceLineNumber() + ", pos:" + cu.getColumnNumber(problems[i].getSourceStart()), problems[i].isError());
		}
	}

	public static Config createStandaloneGeneratorConfig() {
		return new StandaloneGenerator.ConfigImpl(createTestPluginName(), DEFAULT_FIGURE_PACKAGE);
	}
	
	public static Config createStandaloneGeneratorConfig(String packageName, boolean useMapMode) {
		return new StandaloneGenerator.ConfigImpl(createTestPluginName(), packageName, useMapMode ? MapModeCodeGenStrategy.DYNAMIC : MapModeCodeGenStrategy.STATIC, null);
	}

	private static String createTestPluginName() {
		return "org.eclipse.gmf.tests.sample.figures.t" + System.currentTimeMillis();
	}

	public static class GeneratedClassData {

		private final FigureDescriptor myFigureDef;

		private final Class<?> myLoadedClass;

		public GeneratedClassData(FigureDescriptor figureDef, Class<?> loadedClass) {
			myFigureDef = figureDef;
			myLoadedClass = loadedClass;
		}

		public Class<?> getLoadedClass() {
			return myLoadedClass;
		}

		public FigureDescriptor getFigureDef() {
			return myFigureDef;
		}
	}

	// GMFGRAPH: utility methods reused across all the tests.

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
	
	public static Point createPoint(int x, int y){
		Point point = GMFGraphFactory.eINSTANCE.createPoint();
		point.setX(x);
		point.setY(y);
		return point;
	}

}
