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
package org.eclipse.gmf.internal.common.migrate;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * This class holds information used for upgrading existing model instance created with 
 * older versions of its meta-model.<p>
 * Use {@linkplain MigrationConfig.Registry#INSTANCE} for individual migration config registration.<p>  
 * <li>
 * It is assumed that there is only the current (latest) version of the metamodel available in
 * its binary form.</li>
 * <li>
 * Changes described by the config are to be applied to previous versions at loading time,
 * resulting in model instance based on the latest meta-model version.</li> 
 */
public class MigrationConfig {

	/**
	 * Global registry of GMF meta-models migration configs
	 */
	public interface Registry {
		/**
		 * Retrieves migration config for the given model file
		 * 
		 * @param extension model filename extension
		 * @return migration config or <code>null</code> if no config is registered for 
		 * 		this extension
		 */
		MigrationConfig getConfig(String extension);
		/**
		 * Registers the given descriptor with this registry. If a descriptor for the
		 * same file extension already exists, the latter one overrides it.
		 *  
		 * @param descriptor migration config descriptor
		 */
		void register(Descriptor descriptor);
		
		/**
		 * Global registry instance
		 */
		Registry INSTANCE = new RegistryImpl();		
	}
	
	/**
	 * A wrapper of MigrationConfig for use with {@link MigrationConfig.Registry}.</p>
	 * The main purpose of this interface is to enable on demand migration config creation.
	 */
	public interface Descriptor {
		/**
		 * Get file extension of models for which this descriptor is applicable
		 * @return extension string
		 */
		String getExtension();
		/**
		 * Gets config associated with this descriptor.
		 * @return non-null config object
		 */
		MigrationConfig getConfig();
	}
			
	// instance fields
	private String metamodelURI;
	private Set<String> backwardSupportedURIs = Collections.emptySet();
	private LinkedHashMap<EReference, EClass> addedERefTypes = new LinkedHashMap<EReference, EClass>();
		
	/**
	 * Constructs migration config for the given metamodel.
	 * 
	 * @param metamodelNsURI namespace URI of the metamodel, migration of which is 
	 * 	to be described by this config.
	 * 
	 * @param backwardSupportedURIs set of namespace URIs of previous migratable versions
	 */
	public MigrationConfig(String metamodelNsURI, String[] backwardSupportedURIs) {
		if(metamodelNsURI == null) {
			throw new IllegalArgumentException("null metamodel"); //$NON-NLS-1$
		}
		this.metamodelURI = metamodelNsURI;
		for (int i = 0; i < backwardSupportedURIs.length; i++) {
			addBackwardSupportedNsURIs(backwardSupportedURIs[i]);
		}
	}
	
	/**
	 * Gets the metamodel namespace URI representing its current version
	 * @return the uri string
	 */
	public String getMetamodelNsURI() {
		return metamodelURI;
	}
	
	/**
	 * Gets namespace URIs of previous metamodel versions which are migratable to its latest state.
	 * @return set of URI strings
	 */
	public Set<String> backwardSupportedNsURIs() {
		return Collections.unmodifiableSet(backwardSupportedURIs);
	}	
	
	/**
	 * Adds reference type narrowing migration patch.<p>
	 * Ensures correct type narrowing of previosly saved referenced objects in case of missing
	 * xsi/xmi:type info in existing serialized contents.
	 * <p>
	 * @param reference the current version of migrated EReference in the metamodel. 
	 * 		The newly introduced type must be conformant with the old reference type.
	 * @param oldReferenceType EClass representing the reference type used in the previous version. 
	 * 		It must be a concrete class which is instantiated for old version referenced objects. 
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=154712
	 */
	public void addNarrowReferenceType(EReference reference, EClass oldReferenceType) {
		if(reference == null || oldReferenceType == null) {
			throw new IllegalArgumentException("Null reference or old reference type"); //$NON-NLS-1$
		}
		if(!reference.getEReferenceType().isSuperTypeOf(oldReferenceType) ||
			oldReferenceType.isAbstract() || oldReferenceType.isInterface()) {
			throw new IllegalArgumentException("Non-compliant reference types"); //$NON-NLS-1$
		}
		if(reference.getEReferenceType() == oldReferenceType) {
			throw new IllegalArgumentException("Identical reference types"); //$NON-NLS-1$
		}
		if(addedERefTypes.containsKey(reference)) {
			throw new IllegalArgumentException("Reference already has a migration entry"); //$NON-NLS-1$
		}
		addedERefTypes.put(reference, oldReferenceType);
	}
		
	public String toString() { 
		return getClass().getSimpleName() + " : " + getMetamodelNsURI();//$NON-NLS-1$
	}
	
	EClass getAddedTypeInfo(EReference reference) {
		return addedERefTypes.get(reference);
	}
	
	private void addBackwardSupportedNsURIs(String nsURI) {
		if(nsURI == null || nsURI.equals(metamodelURI)) {
			throw new IllegalArgumentException();
		}
		
		if(backwardSupportedURIs.isEmpty()) {
			backwardSupportedURIs = new HashSet<String>();
		}
		backwardSupportedURIs.add(nsURI);		
	}	
		
	/**
	 * Migration config registry implementaion.
	 */
	private static class RegistryImpl extends HashMap<String, Descriptor> implements Registry {
	
		RegistryImpl() {			
		}
		
		public MigrationConfig getConfig(String ext) {
			Descriptor descriptor = get(ext);
			return (descriptor != null) ? descriptor.getConfig() : null;
		}
		
		public void register(Descriptor descriptor) {
			if(descriptor == null || descriptor.getExtension() == null) {
				throw new IllegalArgumentException("null extension or descriptor"); //$NON-NLS-1$
			}
			put(descriptor.getExtension(), descriptor);
		}		
	}	
}
