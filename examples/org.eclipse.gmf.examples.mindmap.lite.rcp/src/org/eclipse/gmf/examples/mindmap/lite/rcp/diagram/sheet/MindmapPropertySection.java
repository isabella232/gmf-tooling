package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.runtime.lite.properties.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapPropertySection extends AdvancedPropertySection {

	/**
	 * Modify/unwrap selection.
	 * @generated
	 */

	protected Object transformSelection(Object selected) {
		if (selected instanceof EditPart) {
			Object model = ((EditPart) selected).getModel();
			return model instanceof View ? ((View) model).getElement() : null;
		}
		if (selected instanceof View) {
			return ((View) selected).getElement();
		}
		if (selected instanceof IAdaptable) {
			View view = (View) ((IAdaptable) selected).getAdapter(View.class);
			if (view != null) {
				return view.getElement();
			}
		}
		return selected;
	}

	/**
	 * @generated
	 */
	protected AdapterFactory getItemProvidersAdapterFactory() {
		return MindmapDiagramEditorPlugin.getInstance()
				.getItemProvidersAdapterFactory();
	}
}
