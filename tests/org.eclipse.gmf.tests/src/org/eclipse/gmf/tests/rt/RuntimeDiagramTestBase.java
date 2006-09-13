/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

/**
 * Unit testcase base class with support for runtime-diagram editing. Expects LinksSessionSetup.
 */
public abstract class RuntimeDiagramTestBase extends GeneratedCanvasTest {

	protected RuntimeDiagramTestBase(String name) {
		super(name);
	}

	protected DiaGenSource getGenModel() {
		return getSetup().getGenModel();
	}

	protected SessionSetup createDefaultSetup() {
		return LinksSessionSetup.newInstance();
	}

	protected boolean canStartLinkFrom(GenLink linkType, View source) {
		Command cmd = getViewerConfiguration().getStartLinkCommand(source, linkType);
		return cmd != null && cmd.canExecute();
	}

	/**
	 * Sets structural feature value of the business element associated with the
	 * given notation element.
	 * 
	 * @param view
	 *            the notation element encapsulating the bussiness object
	 *            containing the feature to be modified
	 * @param featureName
	 *            the name of the structural feature to set.
	 * @param value
	 *            the value to set
	 * @throws IllegalArgumentException
	 *             if the given name does not refer existing feature
	 */
	protected void setBusinessElementStructuralFeature(View view, String featureName, Object value) {
		Command command = getViewerConfiguration().getSetBusinessElementStructuralFeatureCommand(view, featureName, value);
		assertNotNull("Command is null", command);
		command.execute();
	}
}
