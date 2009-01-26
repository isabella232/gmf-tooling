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
package org.eclipse.gmf.tests.setup;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.tests.ConfiguredTestCase;

/**
 * Generic tests to check all handcoded derived features return
 * EStructuralFeature.Setting to avoid issues like #243151 in the future
 * @author artem
 */
public class TestAllDerivedFeatures extends ConfiguredTestCase {

	public TestAllDerivedFeatures(String name) {
		super(name);
		myDefaultSetup = SessionSetup.newInstance();
	}

	public void testGMFGenModel() {
		checkDerivedFeaturesAreSettings(getSetup().getGenModel().getGenDiagram().getEditorGen());
		
	}

	public void testGMFMapModel() {
		checkDerivedFeaturesAreSettings(getSetup().getMapModel().getMapping());
	}

	private void checkDerivedFeaturesAreSettings(EObject model) {
		Iterator<EObject> it = model.eAllContents();
		do {
			for (EStructuralFeature sf : model.eClass().getEAllStructuralFeatures()) {
				if (sf.isDerived() && sf.isMany()) {
					Object featureValue = model.eGet(sf);
					String featureName = sf.getEContainingClass().getName() + "#" + sf.getName();
					assertTrue("Feature with * multiplicity (" + featureName + ") should return a list", featureValue instanceof List<?>);
					assertTrue("Derived, [*] feature (" + featureName + ") should always implement EStructuralFeature.Setting", featureValue instanceof EStructuralFeature.Setting);
				}
			}
			model = it.hasNext() ? it.next() : null;
		} while (model != null);
	}
}
