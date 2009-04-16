/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.util;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

/**
 * @author artem
 */
public interface ModelVersions {

	/**
	 * Year 2005
	 */
	public static final String GMFGEN_1_0 = "http://www.eclipse.org/gmf/2005/GenModel"; //$NON-NLS-1$

	/**
	 * Version identifier used for few milestones of 2.0, until it turned into .../2006/GenModel
	 */
	public static final String GMFGEN_PRE_2_0 = "http://www.eclipse.org/gmf/2005/GenModel/2.0"; //$NON-NLS-1$

	/**
	 * Year 2006 and 2007
	 */
	public static final String GMFGEN_2_0 = "http://www.eclipse.org/gmf/2006/GenModel"; //$NON-NLS-1$

	/**
	 * Year 2008
	 */
	public static final String GMFGEN_2_1 = "http://www.eclipse.org/gmf/2008/GenModel"; //$NON-NLS-1$

	/**
	 * Year 2009
	 */
	public static final String GMFGEN_2_2 = GMFGenPackage.eNS_URI;
}
