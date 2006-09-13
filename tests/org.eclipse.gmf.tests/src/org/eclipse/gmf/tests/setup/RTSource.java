/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
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

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * Somehow configured diagram instance
 * @author artem
 */
public interface RTSource {
	Diagram getCanvas();
	Node getNodeA();
	Node getNodeB();
	Edge getLinkByClass();
	Edge getLinkByRef();
}
