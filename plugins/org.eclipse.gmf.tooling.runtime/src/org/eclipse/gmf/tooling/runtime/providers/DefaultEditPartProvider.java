package org.eclipse.gmf.tooling.runtime.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

public class DefaultEditPartProvider extends AbstractEditPartProvider {

	private EditPartFactory factory;

	private boolean allowCaching;

	private WeakReference<IGraphicalEditPart> cachedPart;

	private WeakReference<View> cachedView;

	private final DiagramStructure diagramStructure;

	private final String expectedModelId;

	public DefaultEditPartProvider(EditPartFactory factory, DiagramStructure diagramStructure, String expectedModelId) {
		this.diagramStructure = diagramStructure;
		this.expectedModelId = expectedModelId;

		setFactory(factory);
		setAllowCaching(true);
	}

	public final EditPartFactory getFactory() {
		return factory;
	}

	protected void setFactory(EditPartFactory factory) {
		this.factory = factory;
	}

	public final boolean isAllowCaching() {
		return allowCaching;
	}

	protected synchronized void setAllowCaching(boolean allowCaching) {
		this.allowCaching = allowCaching;
		if (!allowCaching) {
			cachedPart = null;
			cachedView = null;
		}
	}

	protected IGraphicalEditPart createEditPart(View view) {
		EditPart part = factory.createEditPart(null, view);
		if (part instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart) part;
		}
		return null;
	}

	protected IGraphicalEditPart getCachedPart(View view) {
		if (cachedView != null && cachedView.get() == view) {
			return (IGraphicalEditPart) cachedPart.get();
		}
		return null;
	}

	public synchronized IGraphicalEditPart createGraphicEditPart(View view) {
		if (isAllowCaching()) {
			IGraphicalEditPart part = getCachedPart(view);
			cachedPart = null;
			cachedView = null;
			if (part != null) {
				return part;
			}
		}
		return createEditPart(view);
	}

	public synchronized boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation) operation).getView();
			if (!expectedModelId.equals(diagramStructure.getModelID(view))) {
				return false;
			}
			if (isAllowCaching() && getCachedPart(view) != null) {
				return true;
			}
			IGraphicalEditPart part = createEditPart(view);
			if (part != null) {
				if (isAllowCaching()) {
					cachedPart = new WeakReference<IGraphicalEditPart>(part);
					cachedView = new WeakReference<View>(view);
				}
				return true;
			}
		}
		return false;
	}
}
