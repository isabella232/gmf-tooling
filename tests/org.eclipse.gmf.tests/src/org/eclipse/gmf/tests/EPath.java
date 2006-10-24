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
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.gmfgraph.Identity;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;

/**
 * Utility class providing easy access and navigation to 
 * ecore metamodel elements by using paths.<p>
 */
public class EPath {
	public static final String SEGMENT_DELIMITER = "::"; //$NON-NLS-1$

	interface NamedElementAdapter {
		String getName(EObject adaptee);
	}
	
	public static final EPath ECORE = createEcorePath(EPackage.Registry.INSTANCE);
	
	public static final EPath createEcorePath(final EPackage.Registry registry) {
		return new EPath(new NamedElementAdapter() {
			public String getName(EObject adaptee) {
				if(adaptee instanceof ENamedElement) {
					ENamedElement adapted = (ENamedElement)adaptee;
					return adapted.getName();
				}			
				return null;
			}
		}) {
			protected EObject resolveRootInitCtx(String elementName) {
				for (Iterator it = registry.entrySet().iterator(); it.hasNext();) {
					Object nextEntry = ((Map.Entry)it.next()).getValue();
					if (nextEntry instanceof EPackage) {
						EPackage ePackage = (EPackage) nextEntry;
						if(elementName.equals(ePackage.getName())) {
							return ePackage;
						}
					}
				}
				Assert.fail("EPackage '" + elementName + "' not found in the package registry"); //$NON-NLS-1$ //$NON-NLS-2$;
				return null;
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	public static final EPath createEcorePathFromModel(URI uri) {
		ModelLoadHelper helper = new ModelLoadHelper(new ResourceSetImpl(), uri);
		Assert.assertTrue(helper.getStatus().getMessage(), helper.getStatus().isOK());
		EPackage.Registry reg = new EPackageRegistryImpl();
		reg.putAll(EPackage.Registry.INSTANCE);
		
		for (Iterator it = helper.getLoadedResource().getContents().iterator(); it.hasNext();) {
			Object element = it.next();
			if(element instanceof EPackage) {
				EPackage ePackage = (EPackage)element;
				reg.put(ePackage.getNsURI(), ePackage);				
			}
		}
		return EPath.createEcorePath(reg);
	}
	
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
	
	protected EObject resolveRootInitCtx(@SuppressWarnings("unused")String elementName) {
		throw new UnsupportedOperationException("Don't know how to resolve init context"); //$NON-NLS-1$
	}
		
	public <T> T lookup(String elementPath, Class<T> type) {
		String[] segments = elementPath.split(SEGMENT_DELIMITER);
		if(segments.length > 0) {
			EObject eRoot = resolveRootInitCtx(segments[0]);
			if(segments.length == 1) {
				Assert.assertTrue(type.isInstance(eRoot));
				return type.cast(eRoot);
			}
			String[] remainingPath = new String[segments.length - 1];
			System.arraycopy(segments, 1, remainingPath, 0, segments.length - 1);
			Object target = ECORE.lookup(eRoot, remainingPath);
			Assert.assertTrue(type.isInstance(target));			
			return type.cast(target);
		}
		Assert.fail("Element " + elementPath + " not found"); //$NON-NLS-1$ //$NON-NLS-2$;		
		return null;
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
	 * Gets value of specified structural feature. 
	 * @param instance the object holding the feature value
	 * @param featureName the name of the structural feature to set.
	 * @return the current value 
	 * @throws IllegalArgumentException if the given name does not refer existing feature
	 */	
	public static Object getStructuralFeatureVal(EObject instance, String featureName) {		
		EObject resultObj = findLocalFeature(instance.eClass(), featureName);
		if(!(resultObj instanceof EStructuralFeature)) {
			throw new IllegalArgumentException("Not existing feature: " + featureName); //$NON-NLS-1$
		}
		EStructuralFeature feature = (EStructuralFeature)resultObj;
		return instance.eGet(feature);
	}
	
	/**
	 * Looks for the given feature only the specified EClass. Note: No
	 * super-types are included in this lookup.
	 * 
	 * @param eClass
	 *            meta-class which contains the feature
	 * @param name
	 *            the featuren name
	 * @return the feature object or <code>null</code> if not such feature is
	 *         found
	 */
	public static EStructuralFeature findLocalFeature(EClass eClass, String name) {
		for (Iterator it = eClass.getEStructuralFeatures().iterator(); it.hasNext();) {
			EStructuralFeature nextFeature = (EStructuralFeature) it.next();
			if(name.equals(nextFeature.getName())) {
				return nextFeature;
			}
		}
		return null;
	}
	
	/**
	 * Looks for the given feature in the specified EClass and its inherited types.
	 * 
	 * @param eClass
	 *            meta-class which contains the feature
	 * @param name
	 *            the featuren name
	 * @return the feature object or <code>null</code> if not such feature is
	 *         found
	 */	
	public static EStructuralFeature findFeature(EClass eClass, String name) {
		EStructuralFeature foundFeature = findLocalFeature(eClass, name);
		if(foundFeature == null) {
			for (Iterator it = eClass.getESuperTypes().iterator(); it.hasNext();) {
				EClass nextSuperClass = (EClass) it.next();
				foundFeature = findFeature(nextSuperClass, name);
				if(foundFeature != null) break;
			}
		}
		return foundFeature;
	}	
	
	public static EStructuralFeature findFeature(EObject initialContext, String qualifiedName) {
		int pos = qualifiedName.lastIndexOf(SEGMENT_DELIMITER);
		if(pos <= 0 || pos == qualifiedName.length() - 1) {
			return null;
		}
		String eClassPath = qualifiedName.substring(0, pos);
		EObject eClassObj = ECORE.lookup(initialContext, eClassPath);
		if(eClassObj instanceof EClass) {
			return findFeature((EClass)eClassObj, qualifiedName.substring(pos + SEGMENT_DELIMITER.length()));
		}
		return null;
	}
}
