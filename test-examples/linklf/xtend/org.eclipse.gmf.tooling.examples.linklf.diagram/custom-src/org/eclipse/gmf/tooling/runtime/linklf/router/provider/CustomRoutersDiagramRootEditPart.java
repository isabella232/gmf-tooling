package org.eclipse.gmf.tooling.runtime.linklf.router.provider;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayeredPane;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;

public class CustomRoutersDiagramRootEditPart extends RenderedDiagramRootEditPart {

	private CustomRoutersConnectionLayer myConnectionLayer;

	public CustomRoutersDiagramRootEditPart(MeasurementUnit mUnit) {
		super(mUnit);
	}

	/**
	 * Overridden to allow customization of the routers installed into the connection layers.
	 * @see #createConnectionLayer()
	 */
	@Override
	protected LayeredPane createPrintableLayers() {
		FreeformLayeredPane layeredPane = new FreeformLayeredPane();

		layeredPane.add(new BorderItemsAwareFreeFormLayer(), PRIMARY_LAYER);
		layeredPane.add(createConnectionLayer(), CONNECTION_LAYER);
		layeredPane.add(new FreeformLayer(), DECORATION_PRINTABLE_LAYER);

		return layeredPane;
	}

	protected ConnectionLayerEx createConnectionLayer() {
		myConnectionLayer = new CustomRoutersConnectionLayer();
		return myConnectionLayer;
	}

	@Override
	protected void register() {
		super.register();
		myConnectionLayer.setEditPartViewer(getViewer());

	}

	@Override
	protected void unregister() {
		myConnectionLayer.setEditPartViewer(null);
		super.unregister();
	}

}
