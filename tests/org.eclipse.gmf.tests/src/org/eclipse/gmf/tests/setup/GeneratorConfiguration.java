/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;

public interface GeneratorConfiguration {
	public GeneratorBase createGenerator(GenDiagram diagram);
}
