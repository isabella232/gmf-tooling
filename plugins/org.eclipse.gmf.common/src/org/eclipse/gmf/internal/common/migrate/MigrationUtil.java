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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.common.ToolingResourceFactory;

/**
 * Utility class providing model migration related functionality.
 */
public class MigrationUtil {
	
	private MigrationUtil() {
	}
	
	/**
	 * Creates and loads the given resource and forces migration to be performed at load-time.<p>
	 * <code>Note:</code>No runtime exception is thrown, all detected problems are recorded 
	 * as {@link Resource.Diagnostic}.
	 *  
	 * @param modelResourceURI the resource uri containing the model to migrate
	 * 
	 * @return model-load-helper encapsulating the resource and its in-memory migrated contents.
	 */
	public static ModelLoadHelper migrateModel(URI modelResourceURI) {
		if(modelResourceURI == null) {
			throw new IllegalArgumentException("null resource uri"); //$NON-NLS-1$
		}
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.setResourceFactoryRegistry(new ResourceFactoryRegistryImpl() {			
			public Factory getFactory(URI uri) {
				return new ToolingResourceFactory() {
					public Resource createResource(URI uri) {
						return new MigrationResource(uri);
					}
				};
			}
		});

		ModelLoadHelper loadHelper = new ModelLoadHelper(rset, modelResourceURI);
		return loadHelper;
	}	
	
	/**
	 * Creates resource diagnostic wrapping the given message.
	 * @param resource the resource associated with the created diagnostic
	 * @param message non-<code>null</code> message text to be wrapped as diagnostic
	 * 
	 * @return diagnostic object
	 */
	public static MigrationDiagnostic createMessageDiagnostic(Resource resource, final String message) {
		final String location = resource.getURI() == null ? null : resource.getURI().toString();
		return new MigrationDiagnostic() {

			public String getMessage() {
				return message;
			}

			public String getLocation() {
				return location;
			}

			public int getColumn() {
				return 0;
			}

			public int getLine() {
				return 0;
			}
		};
	}
	
	/**
	 * Just a marker interface for diagnostic notification messages
	 */
	public interface MigrationDiagnostic extends Resource.Diagnostic {		
	}
}

