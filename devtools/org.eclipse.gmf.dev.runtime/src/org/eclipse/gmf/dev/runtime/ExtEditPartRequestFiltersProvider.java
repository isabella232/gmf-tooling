/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.runtime;

import org.eclipse.gmf.dev.EditPartRequestFiltersProvider;

/**
 * @author dstadnik
 */
public class ExtEditPartRequestFiltersProvider implements EditPartRequestFiltersProvider {

	public Class getConstants() {
		return org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.class;
	}
}
