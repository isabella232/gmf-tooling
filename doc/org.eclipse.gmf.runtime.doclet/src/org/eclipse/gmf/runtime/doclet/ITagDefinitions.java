/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.doclet;


/**
 * New tags supported by the Doclet
 */
public interface ITagDefinitions {
	public static final String TAG_CAN_BE_SEEN_BY = "canBeSeenBy";  //$NON-NLS-1$
	public static final String TAG_CAN_BE_IMPLEMENTED_BY = "canBeImplementedBy ";  //$NON-NLS-1$
	public static final String TAG_CAN_BE_SUBCLASSED_BY = "canBeSubclassedBy";  //$NON-NLS-1$
	public static final String TAG_CAN_BE_INSTANTIATED_BY = "canBeInstantiatedBy";  //$NON-NLS-1$
	public static final String TAG_CAN_BE_EXECUTED_BY = "canBeExecutedBy";  //$NON-NLS-1$
}
