/*
 * Copyright (c) 2010 Artem Tikhomirov
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (independent) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;

/**
 * Front-end for generated GMF diagram editor.
 * @author artem
 */
public interface GeneratedDiagramPlugin {

	/**
	 * This is the generator input for the generated editor
	 */
	GenDiagram getGenDiagram();
	
	/**
	 * Access to generated diagram classes (names should be obtained from {@link #getGenDiagram()}
	 */
	Class<?> loadGeneratedClass(String qualifiedClassName) throws Exception;
}
