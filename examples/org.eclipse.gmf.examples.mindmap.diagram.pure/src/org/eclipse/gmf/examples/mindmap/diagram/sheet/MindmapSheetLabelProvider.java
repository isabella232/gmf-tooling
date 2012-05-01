package org.eclipse.gmf.examples.mindmap.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

public class MindmapSheetLabelProvider extends DecoratingLabelProvider {

	public MindmapSheetLabelProvider() {
		super(new AdapterFactoryLabelProvider(MindmapDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()), null);
	}

	@Override
	public String getText(Object element) {
		final Object selected = unwrap(element);
		return super.getText(selected);
	}

	@Override
	public Image getImage(Object element) {
		return super.getImage(unwrap(element));
	}

	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return unwrap(((IStructuredSelection) element).getFirstElement());
		}
		if (element instanceof EditPart) {
			return unwrapEditPart((EditPart) element);
		}
		if (element instanceof IAdaptable) {
			final View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null) {
				return unwrapView(view);
			}
		}
		return element;
	}

	private Object unwrapEditPart(EditPart p) {
		if (p.getModel() instanceof View) {
			return unwrapView((View) p.getModel());
		}
		return p.getModel();
	}

	private Object unwrapView(View view) {
		return view.getElement() == null ? view : view.getElement();
	}

}
