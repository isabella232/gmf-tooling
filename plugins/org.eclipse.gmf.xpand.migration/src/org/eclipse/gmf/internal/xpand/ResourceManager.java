/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;


/**
 * FIXME no much sense to depend on File here, it's only builder who cares about files
 * TODO describe contract - when returns null
 */
public interface ResourceManager {

    XtendResource loadXtendResource(String fullyQualifiedName);

    XpandResource loadXpandResource(String fullyQualifiedName);
    
	/**
	 * Returns an array of resolutions, in the order from newest to oldest. 
	 * This is to enable one template to partially override only a subset of parent templates.
	 *  
	 * @return never return <code>null</code> or an empty array, throw exception instead
	 * @throws IOException in case resource can't be read. Throw {@link java.io.FileNotFoundException} to indicate resource was not found. 
	 */
    Reader[] resolveMultiple(String fullyQualifiedName, String extension) throws IOException;

}
