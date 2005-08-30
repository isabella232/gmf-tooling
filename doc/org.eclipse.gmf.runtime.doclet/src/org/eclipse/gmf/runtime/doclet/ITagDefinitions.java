/*
 *+------------------------------------------------------------------------+
 *| Licensed Materials - Property of IBM                                   |
 *| (C) Copyright IBM Corp. 2005.  All Rights Reserved.                    |
 *|                                                                        |
 *| US Government Users Restricted Rights - Use, duplication or disclosure |
 *| restricted by GSA ADP Schedule Contract with IBM Corp.                 |
 *+------------------------------------------------------------------------+
 */
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
