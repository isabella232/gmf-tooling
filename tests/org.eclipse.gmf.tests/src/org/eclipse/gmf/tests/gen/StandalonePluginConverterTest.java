/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.draw2d.LayeredPane;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureAccessor;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.internal.graphdef.codegen.CanvasProcessor;
import org.eclipse.gmf.internal.graphdef.codegen.GalleryMirrorProcessor;
import org.eclipse.gmf.tests.setup.DiaDefSetup;
import org.eclipse.gmf.tests.setup.figures.FigureCheck;
import org.eclipse.gmf.tests.setup.figures.FigureCodegenSetup;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;
import org.eclipse.gmf.tests.setup.figures.FigureGeneratorUtil.GeneratedClassData;

public class StandalonePluginConverterTest extends TestCase {

	private static final String CUSTOM_FIGURES_PACKAGE = "custom.figures.pakkage";

	public StandalonePluginConverterTest(String name) {
		super(name);
	}

	public void testEachGeneratedClassUsesItsOwnImportAssistant(){
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		gallery.setName("zz");
		gallery.setImplementationBundle("org.eclipse.draw2d");
		
		CustomFigure usesLayeredPane = GMFGraphFactory.eINSTANCE.createCustomFigure();
		usesLayeredPane.setName("RequiersImportForDraw2dLayeredPane");
		usesLayeredPane.setQualifiedClassName(LayeredPane.class.getName());
		
		Rectangle layeredPaneItself = GMFGraphFactory.eINSTANCE.createRectangle();
		layeredPaneItself.setName(LayeredPane.class.getSimpleName());
		
		gallery.getFigures().addAll(Arrays.asList(usesLayeredPane, layeredPaneItself));
		
		final StandaloneGenerator.Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(CUSTOM_FIGURES_PACKAGE, false);
		GeneratedClassData[] genResults = FigureGeneratorUtil.generateAndCompile(gallery, config);
		
		assertEquals(gallery.getFigures().size(), genResults.length);
		
		for (int i = 0; i < genResults.length; i++){
			GeneratedClassData next = genResults[i];
			FigureCheck.CHECK_CAN_CREATE_INSTANCE.go(next.getLoadedClass());
		}
	}

	public void testStandaloneGalleryConverter() throws Exception {
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		FigureCodegenSetup sss = new FigureCodegenSetup(); // XXX sss#getFigureGallery() instead?
		FigureDescriptor[] originals = new FigureDescriptor[] {
				DiaDefSetup.newDescriptor(sss.getCustomFigure()), 
				DiaDefSetup.newDescriptor(sss.getSimpleShape()), 
				DiaDefSetup.newDescriptor(sss.getComplexShape()), 
		};
		
		gallery.getDescriptors().addAll(Arrays.asList(originals));
		
		final StandaloneGenerator.Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(CUSTOM_FIGURES_PACKAGE, false);
		final GalleryMirrorProcessor processor = new GalleryMirrorProcessor(new FigureGallery[] {gallery});
		FigureGeneratorUtil.generate(config, processor);
		final Map<FigureDescriptor, String> info = processor.getGenerationInfo();
		
		for (int i = 0; i < originals.length; i++){
			assertNotNull(info.get(originals[i]));
		}
		
		FigureGallery mirroredGallery = processor.convertFigureGallery();
		assertEquals(config.getPluginID(), mirroredGallery.getImplementationBundle());
		
		assertEquals(3, mirroredGallery.getFigures().size());
		
		for (Figure mirroredFigure : mirroredGallery.getFigures()) {
			assertTrue(mirroredFigure instanceof CustomFigure);
			CustomFigure nextCustom = (CustomFigure) mirroredFigure;
			assertNotNull(nextCustom.getName());
			// TODO assertEquals(original[x], nextCustom.getName());
			// XXX assertEquals(config.getPluginID(), nextCustom.getBundleName());
			assertTrue(nextCustom.getQualifiedClassName().startsWith(CUSTOM_FIGURES_PACKAGE + "."));
		}
		
		FigureGeneratorUtil.installPlugin(config.getPluginID());

		GeneratedClassData[] mirroredClasses = FigureGeneratorUtil.generateAndCompile(mirroredGallery);
		for (int i = 0; i < originals.length; i++){
			FigureDescriptor nextOriginal = originals[i];
			Class<?> nextClass = searchForFigureName(mirroredClasses, nextOriginal.getName());
			assertNotNull("Missed class for : " + nextOriginal.getName(), nextClass);
			
			new GenericFigureCheck(nextOriginal.getActualFigure()).go(nextClass);
		}
	}

	public void testMirroredDiagramElements(){
		Canvas canvas = GMFGraphFactory.eINSTANCE.createCanvas();
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		canvas.getFigures().add(gallery);
		Label label = GMFGraphFactory.eINSTANCE.createLabel();
		label.setName("GraphLabel");
		PolylineConnection connection = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		connection.setName("GraphConnection");
		Rectangle rectangle = GMFGraphFactory.eINSTANCE.createRectangle();
		rectangle.setName("GraphRectangle");
		LabeledContainer labeledContainer = GMFGraphFactory.eINSTANCE.createLabeledContainer();
		labeledContainer.setName("GraphLabeledContainer");
		
		Node node = GMFGraphFactory.eINSTANCE.createNode();
		node.setName("DiagramNode");
		node.setFigure(DiaDefSetup.newDescriptor(rectangle));
		
		DiagramLabel diagramLabel = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		diagramLabel.setName("DiagramLabel");
		diagramLabel.setFigure(DiaDefSetup.newDescriptor(label));
		
		Connection diagramConnection = GMFGraphFactory.eINSTANCE.createConnection();
		diagramConnection.setName("DiagramConnection");
		diagramConnection.setFigure(DiaDefSetup.newDescriptor(connection));
		
		Compartment compartment = GMFGraphFactory.eINSTANCE.createCompartment();
		compartment.setName("DiagramCompartment");
		compartment.setNeedsTitle(!compartment.isNeedsTitle());
		compartment.setCollapsible(!compartment.isCollapsible());
		compartment.setFigure(DiaDefSetup.newDescriptor(labeledContainer));

		gallery.getDescriptors().addAll(Arrays.asList(diagramLabel.getFigure(), diagramConnection.getFigure(), node.getFigure(), compartment.getFigure()));

		canvas.getNodes().add(node);
		canvas.getLabels().add(diagramLabel);
		canvas.getConnections().add(diagramConnection);
		canvas.getCompartments().add(compartment);
		
		Canvas mirroredCanvas = mirror(canvas);
		
		Checker checker = new Checker();
		checker.check(canvas.getNodes(), mirroredCanvas.getNodes());
		checker.check(canvas.getCompartments(), mirroredCanvas.getCompartments());
		checker.check(canvas.getConnections(), mirroredCanvas.getConnections());
		checker.check(canvas.getLabels(), mirroredCanvas.getLabels());
	}

	public void testInnerFigureConversion() {
		final RealFigure topFigure = GMFGraphFactory.eINSTANCE.createRectangle();
		topFigure.setName("TopRect");

		final CustomFigure customLabel = GMFGraphFactory.eINSTANCE.createCustomFigure();
		customLabel.setQualifiedClassName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel");
		customLabel.setName("CustomLabel");

		final Label ordinaryLabel = GMFGraphFactory.eINSTANCE.createLabel();
		ordinaryLabel.setText("ordinaryLabel value");
		ordinaryLabel.setName("OrdinaryLabel");

		topFigure.getChildren().add(customLabel);
		topFigure.getChildren().add(ordinaryLabel);
		
		FigureGallery fg = GMFGraphFactory.eINSTANCE.createFigureGallery();
		fg.setName("a1");
		FigureDescriptor fd;
		fg.getDescriptors().add(fd = DiaDefSetup.newDescriptor(topFigure));
		ChildAccess a1, a2;
		fd.getAccessors().add(a1 = GMFGraphFactory.eINSTANCE.createChildAccess());
		a1.setFigure(customLabel);
		fd.getAccessors().add(a2 = GMFGraphFactory.eINSTANCE.createChildAccess());
		a2.setFigure(ordinaryLabel);

		final Node node = GMFGraphFactory.eINSTANCE.createNode();
		node.setName("Node");
		node.setFigure(fd);

		final DiagramLabel l1 = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		l1.setName("l1");
		l1.setFigure(fd);
		l1.setAccessor(a1);

		final DiagramLabel l2 = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		l2.setName("l2");
		l2.setFigure(fd);
		l2.setAccessor(a2);

		final Canvas canvas = GMFGraphFactory.eINSTANCE.createCanvas();
		canvas.setName("canvas");
		canvas.getFigures().add(fg);
		canvas.getNodes().add(node);
		canvas.getLabels().add(l1);
		canvas.getLabels().add(l2);

		Canvas mirroredCanvas = mirror(canvas);
		Checker checker = new Checker();
		checker.check(canvas.getNodes(), mirroredCanvas.getNodes());
		checker.check(canvas.getLabels(), mirroredCanvas.getLabels());
	}

	private Canvas mirror(Canvas canvas) {
		final StandaloneGenerator.Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(CUSTOM_FIGURES_PACKAGE, false);		
		final CanvasProcessor processor = new CanvasProcessor(canvas);
		FigureGeneratorUtil.generate(config, processor);
		return processor.getOutcome();
	}

	private static Class<?> searchForFigureName(GeneratedClassData[] classes, String expectedName){
		Class<?> result = null;
		for (int i = 0; result == null && i < classes.length; i++){
			if (expectedName.equals(classes[i].getFigureDef().getName())){
				result = classes[i].getLoadedClass();
			}
		}
		return result;
	}

	private static class Checker {
		public Checker(){
		}
		
		public void check(List<?> originalsByType, List<?> mirroredByType){
			assertEquals(originalsByType.size(), mirroredByType.size());
			Iterator<?> allOriginals = originalsByType.iterator();
			Iterator<?> allMirrored = mirroredByType.iterator();
			while (allOriginals.hasNext() || allMirrored.hasNext()){
				DiagramElement nextOriginal = (DiagramElement)allOriginals.next();
				DiagramElement nextMirrored = (DiagramElement)allMirrored.next();
				check(nextOriginal, nextMirrored);
			}
			assertFalse(allOriginals.hasNext());
			assertFalse(allMirrored.hasNext());
		}
		
		public void check(DiagramElement original, DiagramElement mirrored){
			assertEquals(original.eClass().getClassifierID(), mirrored.eClass().getClassifierID());
			assertEquals(original.getName(), mirrored.getName());
			String expectedFQN = composeFQN(original.getFigure());
			Figure actualFigure = mirrored.getFigure().getActualFigure();
			assertNotNull(actualFigure);
			assertTrue(actualFigure.getClass().getName(), actualFigure instanceof CustomFigure /* XXX could not happen any longer, need to revisit: || actualFigure instanceof FigureAccessor*/);
			if (actualFigure instanceof CustomFigure) {
				CustomFigure actual = (CustomFigure) actualFigure;
				assertEquals(expectedFQN, actual.getQualifiedClassName());
	
				if (original instanceof Compartment){
					Compartment originalCompartment = (Compartment)original;
					Compartment mirroredCompartment = (Compartment)mirrored;
					assertEquals(originalCompartment.isCollapsible(), mirroredCompartment.isCollapsible());
					assertEquals(originalCompartment.isNeedsTitle(), mirroredCompartment.isNeedsTitle());
				}
				///XXX do we need to check Facets???
			} else {
				FigureAccessor accessor = (FigureAccessor) actualFigure;
				assertNotNull(accessor.getAccessor());
				// FIXME check thoroughly
			}
		}

		private static String composeFQN(FigureDescriptor figure) {
			return CUSTOM_FIGURES_PACKAGE + '.' + CodeGenUtil.validJavaIdentifier(figure.getName());
		}
	}
}
