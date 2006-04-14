package org.eclipse.gmf.graphdef.gmfEditor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;

import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Compartment_nameEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Connection_nameEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.FigureGallery_nameEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Node_nameEditPart;

/**
 * @generated
 */
public class GMFGraphParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser compartmentCompartmentName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getCompartmentCompartmentName_4001Parser() {
		if (compartmentCompartmentName_4001Parser == null) {
			compartmentCompartmentName_4001Parser = createCompartmentCompartmentName_4001Parser();
		}
		return compartmentCompartmentName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompartmentCompartmentName_4001Parser() {
		GMFGraphStructuralFeatureParser parser = new GMFGraphStructuralFeatureParser(GMFGraphPackage.eINSTANCE.getIdentity().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser nodeNodeName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getNodeNodeName_4002Parser() {
		if (nodeNodeName_4002Parser == null) {
			nodeNodeName_4002Parser = createNodeNodeName_4002Parser();
		}
		return nodeNodeName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createNodeNodeName_4002Parser() {
		GMFGraphStructuralFeatureParser parser = new GMFGraphStructuralFeatureParser(GMFGraphPackage.eINSTANCE.getIdentity().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser connectionConnectionName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getConnectionConnectionName_4003Parser() {
		if (connectionConnectionName_4003Parser == null) {
			connectionConnectionName_4003Parser = createConnectionConnectionName_4003Parser();
		}
		return connectionConnectionName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createConnectionConnectionName_4003Parser() {
		GMFGraphStructuralFeatureParser parser = new GMFGraphStructuralFeatureParser(GMFGraphPackage.eINSTANCE.getIdentity().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser figureGalleryFigureGalleryName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getFigureGalleryFigureGalleryName_4004Parser() {
		if (figureGalleryFigureGalleryName_4004Parser == null) {
			figureGalleryFigureGalleryName_4004Parser = createFigureGalleryFigureGalleryName_4004Parser();
		}
		return figureGalleryFigureGalleryName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createFigureGalleryFigureGalleryName_4004Parser() {
		GMFGraphStructuralFeatureParser parser = new GMFGraphStructuralFeatureParser(GMFGraphPackage.eINSTANCE.getIdentity().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (GMFGraphElementTypes.Compartment_1001 == type) {
			if (Compartment_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getCompartmentCompartmentName_4001Parser();
			}
		}
		if (GMFGraphElementTypes.Node_1002 == type) {
			if (Node_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getNodeNodeName_4002Parser();
			}
		}
		if (GMFGraphElementTypes.Connection_1003 == type) {
			if (Connection_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getConnectionConnectionName_4003Parser();
			}
		}
		if (GMFGraphElementTypes.FigureGallery_1004 == type) {
			if (FigureGallery_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getFigureGalleryFigureGalleryName_4004Parser();
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String viewType = (String) hint.getAdapter(String.class);
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type == null) {
			EObject element = (EObject) hint.getAdapter(EObject.class);
			type = ElementTypeRegistry.getInstance().getElementType(element);
		}
		return getParser(type, viewType);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			return getParser(((GetParserOperation) operation).getHint()) != null;
		}
		return false;
	}
}
