/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanAbstractExpression;
import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanOCLFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Route_4002(Route instance) {
		try {
			Object value0 = TaiPanOCLFactory.getExpression("0.8", TaiPanPackage.eINSTANCE.getRoute()).evaluate(instance);

			value0 = TaiPanAbstractExpression.performCast(value0, EcorePackage.eINSTANCE.getEDouble());
			instance.setReliability(((Double) value0).doubleValue());
		} catch (RuntimeException e) {
			TaiPanDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Route_4003(Route instance) {
		try {
			Object value0 = TaiPanOCLFactory.getExpression("0.2", TaiPanPackage.eINSTANCE.getRoute()).evaluate(instance);

			value0 = TaiPanAbstractExpression.performCast(value0, EcorePackage.eINSTANCE.getEDouble());
			instance.setReliability(((Double) value0).doubleValue());
		} catch (RuntimeException e) {
			TaiPanDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}
}
