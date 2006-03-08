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

package org.eclipse.gmf.internal.graphdef.codegen.ui;

import java.util.Enumeration;

import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;

public class StandaloneGalleryConverter {
	public FigureGallery convertFigureGallery(StandaloneGenerator.GenerationInfo generationInfo){
		FigureGallery result = GMFGraphFactory.eINSTANCE.createFigureGallery();
		String generatedBundle = generationInfo.getConfig().getPluginID();
		result.setImplementationBundle(generatedBundle);
		
		for (Enumeration originalFigures = generationInfo.getProcessedFigures(); originalFigures.hasMoreElements();){
			Figure nextOriginal = (Figure) originalFigures.nextElement();
			String nextConvertedFqn = generationInfo.getGeneratedClassFQN(nextOriginal);
			CustomFigure custom = createCustomFigure(nextOriginal);
			custom.setBundleName(generatedBundle);
			custom.setQualifiedClassName(nextConvertedFqn);
			
			result.getFigures().add(custom);
		}
		return result;
	}
	
	private CustomFigure createCustomFigure(Figure original){
		GMFGraphFactory factory = GMFGraphFactory.eINSTANCE;
		if (original instanceof DecorationFigure){
			return factory.createCustomDecoration();
		} 
		if (original instanceof ConnectionFigure){
			return factory.createCustomConnection();
		}
		return factory.createCustomFigure();
	}

}
