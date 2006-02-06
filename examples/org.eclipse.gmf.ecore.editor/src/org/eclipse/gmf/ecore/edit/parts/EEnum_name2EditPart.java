package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.gmf.ecore.editor.EcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class EEnum_name2EditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public EEnum_name2EditPart(View view) {
		super(view);
		setNumIcons(1);
	}

	/**
	 * @generated
	 */
	protected Image getLabelIcon(int index) {
		ImageDescriptor descriptor = EcoreDiagramEditorPlugin.getInstance().getItemImageDescriptor(resolveSemanticElement());
		if (descriptor == null) {
			descriptor = ImageDescriptor.getMissingImageDescriptor();
		}
		return descriptor.createImage();
	}

}
