/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.sketch.SketchDiagram;
import org.eclipse.gmf.sketch.SketchDiagramElement;

/**
 * @author dstadnik
 */
public class VisualIDsDispenser {

	private Map<SketchDiagramElement, Integer> bindings = new HashMap<SketchDiagramElement, Integer>();

	private Map<Integer, SketchDiagramElement> reverseBindings = new HashMap<Integer, SketchDiagramElement>();

	private int nextVisualID = 1; // nextVisualID > max(visualID:bindings)

	public VisualIDsDispenser(SketchDiagram diagram) {
		bind(diagram);
		for (Iterator<EObject> it = diagram.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof SketchDiagramElement) {
				bind((SketchDiagramElement) next);
			}
		}
	}

	protected void bind(SketchDiagramElement element) {
		int visualID = element.getVisualID();
		if (visualID <= 0) {
			return; // unspecified
		}
		if (bindings.containsKey(element)) {
			throw new IllegalStateException();
		}
		if (reverseBindings.containsKey(visualID)) {
			Activator.logWarning(String.format(Messages.VisualIDsDispenser_Collision, visualID));
			return; // already bound
		}
		bindings.put(element, visualID);
		reverseBindings.put(visualID, element);
		if (nextVisualID <= visualID) {
			nextVisualID = visualID + 1;
		}
	}

	public int get(SketchDiagramElement element) {
		if (bindings.containsKey(element)) {
			return bindings.get(element);
		}
		int visualID = nextVisualID++;
		if (reverseBindings.containsKey(visualID)) {
			throw new IllegalStateException();
		}
		bindings.put(element, visualID);
		reverseBindings.put(visualID, element);
		return visualID;
	}
}
