/*
 * Copyright (c) 2006 Borland Software Corporation
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

import junit.framework.TestCase;

import org.eclipse.draw2d.LayeredPane;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureAccessor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FigureHandle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.internal.graphdef.codegen.CanvasProcessor;
import org.eclipse.gmf.internal.graphdef.codegen.GalleryMirrorProcessor;
import org.eclipse.gmf.internal.graphdef.codegen.GalleryMirrorProcessor.GenerationInfo;
import org.eclipse.gmf.tests.setup.figures.FigureCheck;
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
		gallery.setImplementationBundle("org.eclipse.draw2d");
		
		CustomFigure usesLayeredPane = GMFGraphFactory.eINSTANCE.createCustomFigure();
		usesLayeredPane.setName("RequiersImportForDraw2dLayeredPane");
		usesLayeredPane.setQualifiedClassName(LayeredPane.class.getName());
		
		Rectangle layeredPaneItself = GMFGraphFactory.eINSTANCE.createRectangle();
		layeredPaneItself.setName(CodeGenUtil.getSimpleClassName(LayeredPane.class.getName()));
		
		Figure[] originals = new Figure[] {
				usesLayeredPane, 
				layeredPaneItself,  
		};
		
		gallery.getFigures().addAll(Arrays.asList(originals));
		
		final StandaloneGenerator.Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(CUSTOM_FIGURES_PACKAGE, false);
		GeneratedClassData[] genResults = FigureGeneratorUtil.generateAndCompile(gallery, config);
		
		assertEquals(gallery.getFigures().size(), genResults.length);
		
		for (int i = 0; i < genResults.length; i++){
			GeneratedClassData next = genResults[i];
			assertNotNull(FigureCheck.CHECK_CAN_CREATE_INSTANCE.instantiateFigure(next.getLoadedClass()));
		}
	}

	public void testStandaloneGalleryConverter() throws Exception {
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		Figure[] originals = new Figure[] {
				FigureGeneratorUtil.createFigure1(), 
				FigureGeneratorUtil.createFigure2(), 
				FigureGeneratorUtil.createFigure3(), 
		};
		
		gallery.getFigures().addAll(Arrays.asList(originals));
		
		final StandaloneGenerator.Config config = FigureGeneratorUtil.createStandaloneGeneratorConfig(CUSTOM_FIGURES_PACKAGE, false);
		final GalleryMirrorProcessor processor = new GalleryMirrorProcessor(new FigureGallery[] {gallery});
		FigureGeneratorUtil.generate(config, processor);
		GenerationInfo info = processor.getGenerationInfo();
		
		for (int i = 0; i < originals.length; i++){
			assertNotNull(info.getGeneratedClassFQN(originals[i]));
		}
		
		FigureGallery mirroredGallery = processor.convertFigureGallery();
		assertEquals(config.getPluginID(), mirroredGallery.getImplementationBundle());
		
		assertEquals(3, mirroredGallery.getFigures().size());
		
		for (Iterator mirroredFigures = mirroredGallery.getFigures().iterator(); mirroredFigures.hasNext();){
			Figure next = (Figure) mirroredFigures.next();
			assertTrue(next instanceof CustomFigure);
			CustomFigure nextCustom = (CustomFigure)next;
			assertNotNull(nextCustom.getName());
			// TODO assertEquals(original[x], nextCustom.getName());
			assertEquals(config.getPluginID(), nextCustom.getBundleName());
			assertTrue(nextCustom.getQualifiedClassName().startsWith(CUSTOM_FIGURES_PACKAGE + "."));
		}
		
		FigureGeneratorUtil.installPlugin(config.getPluginID());

		GeneratedClassData[] mirroredClasses = FigureGeneratorUtil.generateAndCompile(mirroredGallery);
		for (int i = 0; i < originals.length; i++){
			Figure nextOriginal = originals[i];
			Class nextClass = searchForFigureName(mirroredClasses, nextOriginal.getName());
			assertNotNull("Missed class for : " + nextOriginal.getName(), nextClass);
			
			FigureCheck nextCheck = new GenericFigureCheck(nextOriginal);
			nextCheck.checkFigure(nextCheck.instantiateFigure(nextClass));
		}
	}

	public void testMirroredDiagramElements(){
		Canvas canvas = GMFGraphFactory.eINSTANCE.createCanvas();
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		canvas.getFigures().add(gallery);
		Label label = GMFGraphFactory.eINSTANCE.createLabel();
		label.setName("GraphLabel");
		ConnectionFigure connection = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		connection.setName("GraphConnection");
		Rectangle rectangle = GMFGraphFactory.eINSTANCE.createRectangle();
		rectangle.setName("GraphRectangle");
		LabeledContainer labeledContainer = GMFGraphFactory.eINSTANCE.createLabeledContainer();
		labeledContainer.setName("GraphLabeledContainer");
		
		gallery.getFigures().addAll(Arrays.asList(new Figure[] {
				label, 
				connection, 
				rectangle, 
				labeledContainer, 
		}));
		
		Node node = GMFGraphFactory.eINSTANCE.createNode();
		node.setName("DiagramNode");
		node.setFigure(rectangle);
		
		DiagramLabel diagramLabel = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		diagramLabel.setName("DiagramLabel");
		diagramLabel.setFigure(label);
		
		Connection diagramConnection = GMFGraphFactory.eINSTANCE.createConnection();
		diagramConnection.setName("DiagramConnection");
		diagramConnection.setFigure(connection);
		
		Compartment compartment = GMFGraphFactory.eINSTANCE.createCompartment();
		compartment.setName("DiagramCompartment");
		compartment.setNeedsTitle(!compartment.isNeedsTitle());
		compartment.setCollapsible(!compartment.isCollapsible());
		compartment.setFigure(labeledContainer);
		
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
		final Figure topFigure = GMFGraphFactory.eINSTANCE.createRectangle();
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
		fg.getFigures().add(topFigure);

		final Node node = GMFGraphFactory.eINSTANCE.createNode();
		node.setName("Node");
		node.setFigure(topFigure);

		final DiagramLabel l1 = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		l1.setName("l1");
		l1.setFigure(customLabel);

		final DiagramLabel l2 = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		l2.setName("l2");
		l2.setFigure(ordinaryLabel);

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

	private static Class searchForFigureName(GeneratedClassData[] classes, String expectedName){
		Class result = null;
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
		
		public void check(List originalsByType, List mirroredByType){
			assertEquals(originalsByType.size(), mirroredByType.size());
			Iterator allOriginals = originalsByType.iterator();
			Iterator allMirrored = mirroredByType.iterator();
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
			assertTrue("we know only how to handle figures", original.getFigure() instanceof Figure);
			String expectedFQN = composeFQN((Figure) original.getFigure());
			FigureHandle actualFigure = mirrored.getFigure();
			assertNotNull(actualFigure);
			assertTrue(actualFigure.getClass().getName(), actualFigure instanceof CustomFigure || actualFigure instanceof FigureAccessor);
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

		private static String composeFQN(Figure figure) {
			return CUSTOM_FIGURES_PACKAGE + '.' + CodeGenUtil.validJavaIdentifier(figure.getName());
		}
	}
}
