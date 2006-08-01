/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;


public class DomainModelSetupInstanceClassName extends DomainModelSetup {
	
	private static final String INSTANCE_CLASSES_PACKAGE = "myModel.interfaces";

	public DomainModelSetup init() {
		DomainModelSetup result = super.init();
		
		result.getDiagramElement().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".DiagramInterface");
		result.getNodeA().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".AInterface");
		result.getChildOfA().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".AChildInterface");
		result.getNodeB().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".BInterface");
		result.getChildOfB().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".BChildInterface");
		result.getLinkAsClass().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".LinkWClassInterface");
		
		return result;
	}
	
}
