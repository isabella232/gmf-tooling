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

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.gmf.tooling.runtime.providers.router.CustomRoutersConnectionLayer;

/**
 * Replaces rectilinear router with custom {@link LinkLFRectilinearRouter}
 * implementation.
 * 
 * @since 3.3
 */
public class LinkLFConnectionLayer extends CustomRoutersConnectionLayer {

	@Override
	protected ConnectionRouter createRectilinearRouter() {
		return new LinkLFRectilinearRouter();
	}

}
