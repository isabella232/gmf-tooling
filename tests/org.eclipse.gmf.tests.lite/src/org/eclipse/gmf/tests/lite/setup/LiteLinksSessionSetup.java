/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.setup;

import org.eclipse.gmf.tests.lite.gen.LiteGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;


public class LiteLinksSessionSetup extends LinksSessionSetup {

	protected LiteLinksSessionSetup(GeneratorConfiguration genConfig) {
		super(genConfig);
	}

	public static LinksSessionSetup getInstance() {
		if (factoryClosed) {
			return null;
		}
		return new LiteLinksSessionSetup(new LiteGeneratorConfiguration());
	}

	@Override
	protected DiaGenSource createGenModel() {
		DiaGenSource result = super.createGenModel();
		result.getGenDiagram().getContainsShortcutsTo().add("Library");	//$NON-NLS-1$
		result.getGenDiagram().getContainsShortcutsTo().add(result.getGenDiagram().getEditorGen().getModelID());
		return result;
	}
}
