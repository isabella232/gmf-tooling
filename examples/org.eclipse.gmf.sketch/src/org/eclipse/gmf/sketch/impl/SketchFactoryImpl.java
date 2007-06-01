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
package org.eclipse.gmf.sketch.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmf.sketch.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SketchFactoryImpl extends EFactoryImpl implements SketchFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SketchFactory init() {
		try {
			SketchFactory theSketchFactory = (SketchFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/gmf/2007/sketch"); //$NON-NLS-1$ 
			if (theSketchFactory != null) {
				return theSketchFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SketchFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SketchPackage.SKETCH_DIAGRAM:
			return createSketchDiagram();
		case SketchPackage.SKETCH_NODE:
			return createSketchNode();
		case SketchPackage.SKETCH_COMPARTMENT:
			return createSketchCompartment();
		case SketchPackage.SKETCH_LINK:
			return createSketchLink();
		case SketchPackage.SKETCH_LABEL:
			return createSketchLabel();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchDiagram createSketchDiagram() {
		SketchDiagramImpl sketchDiagram = new SketchDiagramImpl();
		return sketchDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchNode createSketchNode() {
		SketchNodeImpl sketchNode = new SketchNodeImpl();
		return sketchNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchCompartment createSketchCompartment() {
		SketchCompartmentImpl sketchCompartment = new SketchCompartmentImpl();
		return sketchCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchLink createSketchLink() {
		SketchLinkImpl sketchLink = new SketchLinkImpl();
		return sketchLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchLabel createSketchLabel() {
		SketchLabelImpl sketchLabel = new SketchLabelImpl();
		return sketchLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchPackage getSketchPackage() {
		return (SketchPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SketchPackage getPackage() {
		return SketchPackage.eINSTANCE;
	}

} //SketchFactoryImpl
