/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author dstadnik
 */
public class WizardUtil {

	private WizardUtil() {
	}

	public static String getDefaultFileName(IFile file, String extension) {
		String fileNameBase = file.getName();
		if (file.getFileExtension() != null) {
			fileNameBase = fileNameBase.substring(0, fileNameBase.length() - (file.getFileExtension().length() + 1));
		}
		String modelFilename = fileNameBase + "." + extension;
		for (int i = 1; file.getParent().findMember(modelFilename) != null; ++i) {
			modelFilename = fileNameBase + i + "." + extension;
		}
		return modelFilename;
	}

	public static String getCapName(EStructuralFeature feature) {
		EClass type = feature.getEContainingClass();
		String name = type.getName();
		if (feature.getName().length() > 0) {
			name += Character.toUpperCase(feature.getName().charAt(0));
		}
		if (feature.getName().length() > 1) {
			name += feature.getName().substring(1);
		}
		return name;
	}
}
