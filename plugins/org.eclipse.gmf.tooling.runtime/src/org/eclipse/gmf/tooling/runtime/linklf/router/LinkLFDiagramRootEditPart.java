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

import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.tooling.runtime.providers.router.CustomRoutersConnectionLayer;
import org.eclipse.gmf.tooling.runtime.providers.router.CustomRoutersDiagramRootEditPart;

/**
 * Implementation of the {@link CustomRoutersDiagramRootEditPart} which installs
 * customized {@link LinkLFRectilinearRouter} as a rectilinear router for given
 * diagram.
 * 
 * @since 3.3
 */
public class LinkLFDiagramRootEditPart extends CustomRoutersDiagramRootEditPart {

	public LinkLFDiagramRootEditPart(MeasurementUnit mUnit) {
		super(mUnit);
	}

	@Override
	protected CustomRoutersConnectionLayer createConnectionLayer() {
		return new LinkLFConnectionLayer();
	}

}
