/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ant;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.DataType;

public class MetamodelRegistry extends DataType {

	private Collection<Metamodel> myMetamodels = new ArrayList<Metamodel>();

	public void addMetamodel(Metamodel metamodel) {
		if (isReference()) {
			throw noChildrenAllowed();
		}
		myMetamodels.add(metamodel);
	}

	public Collection<Metamodel> getMetamodels() {
		if (isReference()) {
			Object referencedObject = getRefid().getReferencedObject();
			if (referencedObject instanceof MetamodelRegistry) {
				return ((MetamodelRegistry) referencedObject).getMetamodels();
			}
            throw new BuildException(getRefid() + " doesn\'t denote a " + getDataTypeName());
		}
		return myMetamodels;
	}

}
