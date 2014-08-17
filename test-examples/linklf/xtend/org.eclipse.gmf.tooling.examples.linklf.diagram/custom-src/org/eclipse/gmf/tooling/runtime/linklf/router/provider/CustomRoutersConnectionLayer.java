package org.eclipse.gmf.tooling.runtime.linklf.router.provider;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;

/**
 * [GMFRT] request extraction of protected createXXXRouter() instead
 */
public class CustomRoutersConnectionLayer extends ConnectionLayerEx {

	private RectilinearRouter myCustomRectilinearRouter;

	@Override
	public ConnectionRouter getRectilinearRouter() {
		if (myCustomRectilinearRouter == null) {
			myCustomRectilinearRouter = createRectilinearRouter();
		}
		return myCustomRectilinearRouter;
	}

	protected RectilinearRouter createRectilinearRouter() {
		return new RectilinearRouter();
	}

}
