/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;

/**
 * @generated
 */
public class MindmapDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == MindmapPackage.eINSTANCE.getDocumentRoot()) {
			return true;
		}
		if (eClass == MindmapPackage.eINSTANCE.getMap()) {
			return true;
		}
		if (eClass == MindmapPackage.eINSTANCE.getRelationship()) {
			return true;
		}
		if (eClass == MindmapPackage.eINSTANCE.getResource()) {
			return true;
		}
		if (eClass == MindmapPackage.eINSTANCE.getThread()) {
			return true;
		}
		if (eClass == MindmapPackage.eINSTANCE.getThreadItem()) {
			return true;
		}
		if (eClass == MindmapPackage.eINSTANCE.getTopic()) {
			return true;
		}
		return false;
	}

}
