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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class DomainModelSetupInstanceClassName extends DomainModelSetup {
	
	private static final String INSTANCE_CLASSES_PACKAGE = "myModel.interfaces";

	public DomainModelSetup init() {
		DomainModelSetup result = super.init();
		
		result.getDiagramElement().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".DiagramInterface");
		suppressAccessorMethods(result.getDiagramElement());
		result.getNodeA().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".AInterface");
		suppressAccessorMethods(result.getNodeA().getEClass());
		result.getChildOfA().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".AChildInterface");
		suppressAccessorMethods(result.getChildOfA().getEClass());
		result.getNodeB().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".BInterface");
		suppressAccessorMethods(result.getNodeB().getEClass());
		result.getChildOfB().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".BChildInterface");
		result.getLinkAsClass().getEClass().setInstanceClassName(INSTANCE_CLASSES_PACKAGE + ".LinkWClassInterface");
		
		return result;
	}

	/**
	 * Change made to ItemProvider.javajet (rev 1.35, 27.03.2007) changes assumption whether external interface 
	 * should or should not have accessors for attributes. We used to follow assumption that it should not,
	 * and eGet is the way to access attributes, however, the change seems to
	 * FIXME [revisit] if assumption about interfaces defining all accessors is valid, we can simplify 
	 * gmf templates (handling external interfaces) a bit.
	 * 
	 * perhaps, fixing {@link GenProjectBaseSetup#generateUserInterface} to generate appropriate accessors 
	 * is better idea.
	 */
	private static void suppressAccessorMethods(EClass c) {
		assert c.eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
		// we assume instance class name points to *empty* interface, hence we need to let EMF
		// generator know that it should not expect accessors for attributed defined in the model
		// after casting to the value of this attribute
		for (EStructuralFeature f : c.getEAllStructuralFeatures()) {
			if (f.getEType().getInstanceClass() == String.class) {
				EcoreUtil.setSuppressedVisibility(f, EcoreUtil.GET, true);
				// .SET as well, if needed
			}
		}
	}
}
