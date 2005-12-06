/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.gmfgraph.Identity;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeModelCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * Utility class providing easy access and navigation to 
 * ecore metamodel elements by using paths.<p>
 */
public class EPath {
	public static final String SEGMENT_DELIMITER = "::"; //$NON-NLS-1$

	interface NamedElementAdapter {
		String getName(EObject adaptee);
	}
		
	public static final EPath ECORE = new EPath(new NamedElementAdapter() {
		public String getName(EObject adaptee) {
			if(adaptee instanceof ENamedElement) {
				ENamedElement adapted = (ENamedElement)adaptee;
				return adapted.getName();
			}			
			return null;
		}
	});
	
	public static final EPath GMFGRAPH = new EPath(new NamedElementAdapter() {
		public String getName(EObject adaptee) {
			if(adaptee instanceof Identity) {
				Identity adapted = (Identity)adaptee;
				return adapted.getName();
			}			
			return null;
		}
	});	
		
	private NamedElementAdapter nameAdapter;
	
	public EPath(NamedElementAdapter adapter) {
		if(adapter == null) {
			throw new IllegalArgumentException("Null named element adapter"); //$NON-NLS-1$
		}
		nameAdapter = adapter;
	}	
	
	/**
	 * Performs lookup of the element specified by the given path.
	 *   
	 * @param initialContext root containter object for the lookup 
	 * @param elementPath the element path string, with '::' as delimiter
	 * 	Example: links::MyClass::name denotes the 'name' attribute in 
	 * 	'MyClass' class in the 'links' package. 
	 * @return the referenced object
	 */
	public EObject lookup(EObject initialContext, String elementPath) {
		String[] segments = elementPath.split(SEGMENT_DELIMITER);		
		return lookup(initialContext, segments);
	}
	
	/**
	 * Performs lookup of the element specified by the given path.
	 * 
	 * @param initialContext root containter object for the lookup 
	 * @param elementPath the segments of the element path
	 * @return the referenced object 
	 */	
	public EObject lookup(EObject initialContext, String[] elementPath) {	
		EObject nextContext = initialContext;
		for (int i = 0; i < elementPath.length; i++) {
			nextContext = lookupImmediate(nextContext, elementPath[i]);
		}
		return nextContext;
	}
	
	private EObject lookupImmediate(EObject initialContext, String elementName) {
		if(elementName == null) {
			throw new IllegalArgumentException("Non-null name required"); //$NON-NLS-1$ 			
		} 
		else if(elementName.indexOf(SEGMENT_DELIMITER) >= 0) {
			throw new IllegalArgumentException("Simple name required"); //$NON-NLS-1$
		}
		
		for (Iterator it = initialContext.eContents().iterator(); it.hasNext();) {
			EObject nextObj = (EObject) it.next();
			String name = nameAdapter.getName(nextObj);
			if(elementName.equals(name)) {
				return nextObj;
			}
		}
		Assert.fail("Element " + elementName + " not found in " + initialContext); //$NON-NLS-1$ //$NON-NLS-2$
		return null;
	}
	
	/**
	 * Sets value of specified structural feature. 
	 * @param instance the object holding the feature value
	 * @param featureName the name of the structural feature to set.
	 * @param value the value to set
	 * @throws IllegalArgumentException if the given name does not refer existing feature
	 */
	public static void setStructuralFeature(EObject instance, String featureName, Object value) {
		EObject resultObj = findFeature(instance.eClass(), featureName);
		if(!(resultObj instanceof EStructuralFeature)) {
			throw new IllegalArgumentException("Not existing feature: " + featureName); //$NON-NLS-1$
		}
		EStructuralFeature feature = (EStructuralFeature)resultObj;

		SetRequest setReq = new SetRequest(instance, feature, value);		
		CompositeModelCommand modelCmd = new CompositeModelCommand(setReq.getLabel());
		modelCmd.compose(new SetValueCommand(setReq));
		new EtoolsProxyCommand(modelCmd).execute();
	}
	
	/**
	 * Gets value of specified structural feature. 
	 * @param instance the object holding the feature value
	 * @param featureName the name of the structural feature to set.
	 * @return the current value 
	 * @throws IllegalArgumentException if the given name does not refer existing feature
	 */	
	public static Object getStructuralFeatureVal(EObject instance, String featureName) {		
		EObject resultObj = findFeature(instance.eClass(), featureName);
		if(!(resultObj instanceof EStructuralFeature)) {
			throw new IllegalArgumentException("Not existing feature: " + featureName); //$NON-NLS-1$
		}
		EStructuralFeature feature = (EStructuralFeature)resultObj;
		return instance.eGet(feature);
	}
	
	private static EStructuralFeature findFeature(EClass eClass, String name) {
		for (Iterator it = eClass.getEAllStructuralFeatures().iterator(); it.hasNext();) {
			EStructuralFeature nextFeature = (EStructuralFeature) it.next();
			if(name.equals(nextFeature.getName())) {
				return nextFeature;
			}
		}
		return null;
	}
}
