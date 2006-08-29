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
import org.eclipse.gmf.internal.common.ToolingResourceFactory;


/**
 * Backward compatible tooling resource factory, creates resource supporting loading of serialized 
 * contents of incompatible historical versions of tooling models.
 * <p>
 * The resources from this factory handle backward compatibility as follows:<p>
 * If old model version is recognized and resource is loaded with errors, 
 * the loaded resource records a diagnostic indicating old version as possible impact for 
 * loading and proposes to run migration.<br>
 * No load-time migration is performed automatically and migration + overwriting the original 
 * model resource is an explicit step to be done by the user.<br>
 * <b>Note</b>: Backward incompatibilities may cause throwing runtime exceptions during load operation which 
 * is the feature of EMF.
 * <p>
 * For performing in-memory migration at load-time use {@link CompatibleToolResourceFactory.MigrateOnLoad } factory.
 */
public class CompatibleToolResourceFactory extends ToolingResourceFactory {
	
	/**
	 * This variant of factory produce resources which ensures that old version contents 
	 * is loaded correctly. In case, an obsolete contents is loaded, in-memory migration 
	 * at load-time is performed and loaded resource reports diagnostic 'migration required'.
	 */
	public static class MigrateOnLoad extends ToolingResourceFactory {

		public MigrateOnLoad() {
			super();
		}
		
		public Resource createResource(URI uri) {		
			return MigrationResource.createCheckAndMigrateOnLoadResource(uri);
		}
	}
	
	public CompatibleToolResourceFactory() {
		super();
	}

	public Resource createResource(URI uri) {
		return MigrationResource.createCheckedResource(uri);
	}
}
