/*
 * Copyright (c) 2006 Borland Software Corporation
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

import org.eclipse.draw2d.GraphicsSource;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;

public class NoUpdateViewer extends GraphicalViewerImpl {
	protected LightweightSystem createLightweightSystem() {
		final UpdateManager NO_MANAGER = new UpdateManager() {
			public void addDirtyRegion(IFigure figure, int x, int y, int w, int h) {}
			public void addInvalidFigure(IFigure figure) {}
			public void performUpdate() {}
			public void performUpdate(Rectangle exposed) {}
			public void setGraphicsSource(GraphicsSource gs) {}
			public void setRoot(IFigure figure) {}
		};

		return new LightweightSystem() {
			{
				setUpdateManager(NO_MANAGER);
			}
	
			public UpdateManager getUpdateManager() {
				return NO_MANAGER;
			}
		};
	}
}
