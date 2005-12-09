/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface DomainModelSource {

	EPackage getModel();
	NodeData getNodeA();
	/**
	 * Could be null
	 * @return
	 */
	NodeData getNodeB();
	LinkData getLinkAsClass();
	EReference getLinkAsRef();
	EClass getDiagramElement();
	
	public class NodeData {
		
		private final EClass myClass;
		private final EAttribute myNameAttr;
		private final EReference myContainment;
	
		public NodeData(EClass eClass, EAttribute nameAttr, EReference containment) {
			assert eClass != null;
			myClass = eClass;
			myNameAttr = nameAttr;
			myContainment = containment;
		}
	
		public EClass getEClass() {
			return myClass;
		}
	
		public EReference getContainment() {
			return myContainment;
		}
	
		public EAttribute getNameAttr() {
			return myNameAttr;
		}
	}

	public class LinkData {
	
		private final EClass myClass;
		private final EStructuralFeature myTargetFeature;
		private final EReference myContainment;
	
		/**
		 * @param eClass may be <code>null</code>
		 * @param targetFeature not <code>null</code>
		 * @param containment may be <code>null</code>
		 */
		public LinkData(EClass eClass, EStructuralFeature targetFeature, EReference containment) {
			assert targetFeature != null;
			myClass = eClass;
			myTargetFeature = targetFeature;
			myContainment = containment;
		}
	
		public EClass getEClass() {
			return myClass;
		}
	
		public EReference getContainment() {
			return myContainment;
		}
	
		public EStructuralFeature getTargetFeature() {
			return myTargetFeature;
		}
	}
}
