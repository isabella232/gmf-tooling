/*****************************************************************************
 * Copyright (c) 2014-15 CEA LIST, Montages AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Michael Golubev (Montages) - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.gmf.tooling.runtime.linklf.router;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.tooling.runtime.providers.router.CustomRoutersDiagramRootEditPart;
import org.eclipse.gmf.tooling.runtime.providers.router.CustomRoutersDiagramRootEditPartProvider;

/**
 * LinkLF specific implementation of the
 * {@link CustomRoutersDiagramRootEditPart}.
 * <p/>
 * This provider will install LinkLF-specific {@link LinkLFConnectionLayer}
 * which in turn will use the customized {@link LinkLFRectilinearRouter} for
 * applicable diagram.
 * 
 * @since 3.3
 */
public class LinkLFDiagramRootEditPartProvider extends
		CustomRoutersDiagramRootEditPartProvider {

	@Override
	public CustomRoutersDiagramRootEditPart createRootEditPart(Diagram diagram) {
		return new LinkLFDiagramRootEditPart(diagram.getMeasurementUnit());
	}

}
