/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.rt;


public class ElementInitializerTest extends org.eclipse.gmf.tests.rt.ElementInitializerTest {
	public ElementInitializerTest(String name) {
		super(name);
	}

	protected Class loadJavaContainerClass() {
		String javaContainerName = "JavaInitializers"; //$NON-NLS-1$
		try {
			return loadGeneratedClass(getGenModel().getGenDiagram().getNotationViewFactoriesPackageName() + ".DomainElementInitializer$" + javaContainerName); //$NON-NLS-1$
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}
