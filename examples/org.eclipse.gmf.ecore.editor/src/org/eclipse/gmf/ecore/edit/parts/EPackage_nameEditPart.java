package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.edit.providers.EcoreStructuralFeatureParser;

import org.eclipse.gmf.ecore.editor.EcoreDiagramEditorPlugin;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;

/**
 * @generated
 */
public class EPackage_nameEditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public EPackage_nameEditPart(View view) {
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

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		}
		return parser;
	}
}
