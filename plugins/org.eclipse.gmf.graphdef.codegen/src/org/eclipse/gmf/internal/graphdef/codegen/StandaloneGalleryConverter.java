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

package org.eclipse.gmf.internal.graphdef.codegen;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator;

public class StandaloneGalleryConverter {
	private final StandaloneGenerator.GenerationInfo myGenerationInfo;
	private final DiagramElementsCopier myDiagramElementsCopier;
	
	public StandaloneGalleryConverter(StandaloneGenerator.GenerationInfo generationInfo){
		myGenerationInfo = generationInfo;
		myDiagramElementsCopier = new DiagramElementsCopier();
	}
	
	public FigureGallery convertFigureGallery(){
		FigureGallery result = GMFGraphFactory.eINSTANCE.createFigureGallery();
		String generatedBundle = myGenerationInfo.getConfig().getPluginID();
		result.setImplementationBundle(generatedBundle);
		
		for (Enumeration originalFigures = myGenerationInfo.getProcessedFigures(); originalFigures.hasMoreElements();){
			Figure nextOriginal = (Figure) originalFigures.nextElement();
			String nextConvertedFqn = myGenerationInfo.getGeneratedClassFQN(nextOriginal);
			CustomFigure custom = createCustomFigure(nextOriginal);
			custom.setName(nextOriginal.getName());
			custom.setBundleName(generatedBundle);
			custom.setQualifiedClassName(nextConvertedFqn);
			
			result.getFigures().add(custom);
			myDiagramElementsCopier.registerSubstitution(nextOriginal, custom);
		}
		return result;
	}
	
	public Canvas mirrorDiagramElements(Collection resources){
		Canvas result = null;
		for (Iterator it = resources.iterator(); it.hasNext();){
			Resource next = (Resource)it.next();
			if (!next.getContents().isEmpty()){
				EObject root = (EObject) next.getContents().get(0);
				if (root instanceof Canvas){
					Canvas original = (Canvas)root;
					if (result == null){
						result = GMFGraphFactory.eINSTANCE.createCanvas();
						result.setName(original.getName());
					}
					Collection children = myDiagramElementsCopier.copyAll(original.getChildren());
					Collection compartments = myDiagramElementsCopier.copyAll(original.getCompartments());
					Collection labels = myDiagramElementsCopier.copyAll(original.getLabels());
					Collection nodes = myDiagramElementsCopier.copyAll(original.getNodes());

					result.getChildren().addAll(children);
					result.getCompartments().addAll(compartments);
					result.getLabels().addAll(labels);
					result.getNodes().addAll(nodes);
				}
			}
		}
		if (result != null && !result.eContents().isEmpty()){
			myDiagramElementsCopier.copyReferences();	
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
	
	private static class DiagramElementsCopier extends EcoreUtil.Copier {
		private final HashSet myOriginalFigures = new HashSet();
		
		public void registerSubstitution(Figure original, CustomFigure substituted){
			put(original, substituted);
			myOriginalFigures.add(original);
		}
		
		protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
			if (EcoreUtil.isAncestor(myOriginalFigures, eObject)){
				//no such features in the CustomFigure's
				return;
			}
			super.copyReference(eReference, eObject, copyEObject);
		}
		
	}

}
