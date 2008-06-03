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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
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
			Object value0 = EcoreOCLFactory.getExpression("false", EcorePackage.eINSTANCE.getEReference()).evaluate(instance);
			instance.setContainment(((Boolean) value0).booleanValue());
		} catch (RuntimeException e) {
			EcoreDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_EReference_4003(EReference instance) {
		try {
			Object value0 = EcoreOCLFactory.getExpression("true", EcorePackage.eINSTANCE.getEReference()).evaluate(instance);
			instance.setContainment(((Boolean) value0).booleanValue());
		} catch (RuntimeException e) {
			EcoreDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

}
