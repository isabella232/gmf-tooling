package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

/**
 * @generated
 */
public class Resource_locationEditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public Resource_locationEditPart(View view) {
		super(view);
		setNumIcons(1);
	}

	/**
	 * @generated
	 */
	protected Image getLabelIcon(int index) {
		ImageDescriptor descriptor = EclipseconDiagramEditorPlugin
				.getInstance().getItemImageDescriptor(resolveSemanticElement());
		if (descriptor == null) {
			descriptor = ImageDescriptor.getMissingImageDescriptor();
		}
		return descriptor.createImage();
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		String text = super.getLabelText();
		if (text == null || text.length() == 0) {
			return "<...>";
		}
		return text;
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			String parserHint = ((View) getModel()).getType();
			EObject element = resolveSemanticElement();
			if (element != null) {
				ParserHintAdapter hintAdapter = new ParserHintAdapter(element,
						parserHint) {
					public Object getAdapter(Class adapter) {
						if (IElementType.class.equals(adapter)) {
							return EclipseconElementTypes.Resource_1004;
						}
						return super.getAdapter(adapter);
					}
				};
				parser = ParserService.getInstance().getParser(hintAdapter);
			}
		}
		return parser;
	}
}
