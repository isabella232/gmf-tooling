package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

/**
 * @generated
 */
public class Resource_nameEditPart extends TextCompartmentEditPart {

	/**
	 * @generated
	 */
	public Resource_nameEditPart(View view) {
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
	private String defaultText;

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		if (figure instanceof Label) {
			defaultText = ((Label) figure).getText();
		} else if (figure instanceof WrapLabel) {
			defaultText = ((WrapLabel) figure).getText();
		}
		return figure;
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		String text = super.getLabelText();
		if (text == null || text.length() == 0) {
			return defaultText;
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
