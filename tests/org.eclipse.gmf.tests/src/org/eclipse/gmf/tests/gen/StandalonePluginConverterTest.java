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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;
import org.eclipse.gmf.internal.graphdef.codegen.StandaloneGalleryConverter;

public class StandalonePluginConverterTest extends FigureCodegenTestBase {

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
		final String customFiguresPackage = "custom.figures.pakkage";
		StandaloneGenerator.ConfigImpl config = new StandaloneGenerator.ConfigImpl(standalonePlugin, customFiguresPackage, false);
		StandaloneGenerator generator = new StandaloneGenerator(gallery, config, new RuntimeFQNSwitch());
		generator.run();
		assertTrue(generator.getRunStatus().getSeverity() < IStatus.ERROR);
		
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
			assertTrue(nextCustom.getQualifiedClassName().startsWith(customFiguresPackage + "."));
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
