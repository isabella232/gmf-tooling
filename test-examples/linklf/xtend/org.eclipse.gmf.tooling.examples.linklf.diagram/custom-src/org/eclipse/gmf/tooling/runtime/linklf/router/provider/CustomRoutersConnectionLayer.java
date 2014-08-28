package org.eclipse.gmf.tooling.runtime.linklf.router.provider;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.RectilinearRouter;
import org.eclipse.gmf.tooling.runtime.linklf.router.SnapToGridRectilinearRouter;

/**
 * [GMFRT] request extraction of protected createXXXRouter() instead
 */
public class CustomRoutersConnectionLayer extends ConnectionLayerEx {

	private RectilinearRouter myCustomRectilinearRouter;

	private EditPartViewer myViewer;

	protected EditPartViewer getViewer() {
		return myViewer;
	}

	public void setEditPartViewer(EditPartViewer viewer) {
		myViewer = viewer;
		if (myCustomRectilinearRouter instanceof SnapToGridRectilinearRouter) {
			((SnapToGridRectilinearRouter) myCustomRectilinearRouter).setEditPartViewer(viewer);
		}
	}

	@Override
	public ConnectionRouter getRectilinearRouter() {
		if (myCustomRectilinearRouter == null) {
			myCustomRectilinearRouter = createRectilinearRouter();
		}
		return myCustomRectilinearRouter;
	}

	protected RectilinearRouter createRectilinearRouter() {
		//return new RectilinearRouter();
		SnapToGridRectilinearRouter result = new SnapToGridRectilinearRouter();
		result.setEditPartViewer(getViewer());
		return result;
	}

}
