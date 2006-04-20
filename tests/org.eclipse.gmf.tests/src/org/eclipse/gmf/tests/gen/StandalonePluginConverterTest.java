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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Child;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.LabeledContainer;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.GenerationInfo;
import org.eclipse.gmf.internal.graphdef.codegen.StandaloneGalleryConverter;

public class StandalonePluginConverterTest extends FigureCodegenTestBase {

	private static final String CUSTOM_FIGURES_PACKAGE = "custom.figures.pakkage";

	public StandalonePluginConverterTest(String name) {
		super(name);
	}
	
	public void testStandaloneGalleryConverter() throws Exception {
		FigureGallery gallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		Figure[] originals = new Figure[] {
				figure1(), 
				figure2(), 
				figure3(), 
		};
		
		gallery.getFigures().addAll(Arrays.asList(originals));
		
		final String standalonePlugin = "org.eclipse.gmf.tests.generated.custom.figures.t" + System.currentTimeMillis();
		StandaloneGenerator.ConfigImpl config = new StandaloneGenerator.ConfigImpl(standalonePlugin, CUSTOM_FIGURES_PACKAGE, false);
		StandaloneGenerator generator = generateStandalone(gallery, config);
		
		StandaloneGenerator.GenerationInfo info = generator.getGenerationInfo();
		for (int i = 0; i < originals.length; i++){
			assertNotNull(info.getGeneratedClassFQN(originals[i]));
		}
		
		StandaloneGalleryConverter galleryConverter = new StandaloneGalleryConverter(info);
		FigureGallery mirroredGallery = galleryConverter.convertFigureGallery();
		assertEquals(standalonePlugin, mirroredGallery.getImplementationBundle());
		
		assertEquals(3, mirroredGallery.getFigures().size());
		
		for (Iterator mirroredFigures = mirroredGallery.getFigures().iterator(); mirroredFigures.hasNext();){
			Figure next = (Figure) mirroredFigures.next();
			assertTrue(next instanceof CustomFigure);
			CustomFigure nextCustom = (CustomFigure)next;
			assertNotNull(nextCustom.getName());
			assertEquals(standalonePlugin, nextCustom.getBundleName());
			assertTrue(nextCustom.getQualifiedClassName().startsWith(CUSTOM_FIGURES_PACKAGE + "."));
		}
		
		installPlugin(standalonePlugin);

		//XXX: workaround for #134506 -- "GMFGraph generator should produce correct code if the name of CustomFigure is the same as its class's simple name"
		Map workaroundNameMapping = new HashMap();
		for (Iterator mirroredFigures = mirroredGallery.getFigures().iterator(); mirroredFigures.hasNext();){
			Figure next = (Figure) mirroredFigures.next();
			String workaroundName = "My" + next.getName();
			workaroundNameMapping.put(next.getName(), workaroundName);
			next.setName(workaroundName);
		}

		GeneratedClassData[] mirroredClasses = generateAndCompile(getGMFGraphGeneratorConfig(), mirroredGallery);
		for (int i = 0; i < originals.length; i++){
			Figure nextOriginal = originals[i];
			String workaroundName = (String) workaroundNameMapping.get(nextOriginal.getName());
			assertNotNull("Missed name for: " + nextOriginal.getName(), workaroundName);
			Class nextClass = searchForFigureName(mirroredClasses, workaroundName);
			assertNotNull("Missed class for : " + workaroundName, nextClass);
			
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
		
		Child child = GMFGraphFactory.eINSTANCE.createChild();
		child.setName("DiagramChild");
		child.setFigure(rectangle);
		
		Connection diagramConnection = GMFGraphFactory.eINSTANCE.createConnection();
		diagramConnection.setName("DiagramConnection");
		diagramConnection.setFigure(connection);
		
		Compartment compartment = GMFGraphFactory.eINSTANCE.createCompartment();
		compartment.setName("DiagramCompartment");
		compartment.setNeedsTitle(!compartment.isNeedsTitle());
		compartment.setCollapsible(!compartment.isCollapsible());
		compartment.setFigure(labeledContainer);
		
		canvas.getNodes().add(node);
		canvas.getChildren().add(child);
		canvas.getLabels().add(diagramLabel);
		canvas.getConnections().add(diagramConnection);
		canvas.getCompartments().add(compartment);
		
		Resource resource = confineInResource(canvas);

		final String standalonePlugin = "org.eclipse.gmf.tests.generated.mirrored.diagram.elements.t" + System.currentTimeMillis();
		StandaloneGenerator.ConfigImpl config = new StandaloneGenerator.ConfigImpl(standalonePlugin, CUSTOM_FIGURES_PACKAGE, false);		
		StandaloneGenerator generator = generateStandalone(gallery, config);
		StandaloneGalleryConverter galleryConverter = new StandaloneGalleryConverter(generator.getGenerationInfo());
		galleryConverter.convertFigureGallery();
		Canvas mirroredCanvas = galleryConverter.mirrorDiagramElements(Collections.singletonList(resource));
		
		class Checker {
			private final GenerationInfo myGenerationInfo;

			public Checker(GenerationInfo generationInfo){
				myGenerationInfo = generationInfo;
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
				String expectedFQN = myGenerationInfo.getGeneratedClassFQN(original.getFigure());
				Figure actualFigure = mirrored.getFigure();
				assertNotNull(actualFigure);
				assertTrue(actualFigure instanceof CustomFigure);
				CustomFigure actual = (CustomFigure)actualFigure;
				assertEquals(expectedFQN, actual.getQualifiedClassName());
				assertEquals(myGenerationInfo.getConfig().getPluginID(), actual.getBundleName());

				if (original instanceof Compartment){
					Compartment originalCompartment = (Compartment)original;
					Compartment mirroredCompartment = (Compartment)mirrored;
					assertEquals(originalCompartment.isCollapsible(), mirroredCompartment.isCollapsible());
					assertEquals(originalCompartment.isNeedsTitle(), mirroredCompartment.isNeedsTitle());
				}
				///XXX do we need to check Facets???
			}
		}
		
		Checker checker = new Checker(generator.getGenerationInfo());
		checker.check(canvas.getChildren(), mirroredCanvas.getChildren());
		checker.check(canvas.getNodes(), mirroredCanvas.getNodes());
		checker.check(canvas.getCompartments(), mirroredCanvas.getCompartments());
		checker.check(canvas.getConnections(), mirroredCanvas.getConnections());
		checker.check(canvas.getLabels(), mirroredCanvas.getLabels());
	}
	
	private StandaloneGenerator generateStandalone(FigureGallery gallery, StandaloneGenerator.Config config) {
		StandaloneGenerator generator = new StandaloneGenerator(gallery, config, new RuntimeFQNSwitch());
		generator.run();
		assertTrue(generator.getRunStatus().getSeverity() < IStatus.ERROR);
		return generator;
	}
	
	private Resource confineInResource(Canvas canvas) {
		Resource result = new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/StandalonePluginConverterTest"));
		result.getContents().add(canvas);
		return result;
	}
	
	private static Class searchForFigureName(GeneratedClassData[] classes, String expectedName){
		Class result = null;
		for (int i = 0; result == null && i < classes.length; i++){
			Class next = classes[i].getLoadedClass();
			if (expectedName.equals(classes[i].getFigureDef().getName())){
				result = next;
			}
		}
		return result;
	}
}
