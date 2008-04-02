/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.ecore.expressions.EcoreAbstractExpression;
import org.eclipse.gmf.ecore.expressions.EcoreOCLFactory;
import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_EReference_4002(EReference instance) {
		try {
			EcoreOCLFactory.getExpression("false", EcorePackage.eINSTANCE.getEReference()).assignTo(EcorePackage.eINSTANCE.getEReference_Containment(), instance);

		} catch (RuntimeException e) {
			EcoreDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_EReference_4003(EReference instance) {
		try {
			EcoreOCLFactory.getExpression("true", EcorePackage.eINSTANCE.getEReference()).assignTo(EcorePackage.eINSTANCE.getEReference_Containment(), instance);

		} catch (RuntimeException e) {
			EcoreDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}
}
