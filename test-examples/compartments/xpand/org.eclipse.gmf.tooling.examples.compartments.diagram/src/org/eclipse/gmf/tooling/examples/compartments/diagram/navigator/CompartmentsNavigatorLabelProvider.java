package org.eclipse.gmf.tooling.examples.compartments.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfAffixedEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ECNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_EEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ENameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FDNodeRelationEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GNumberEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeAEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsDiagramEditorPlugin;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsParserProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class CompartmentsNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		CompartmentsDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		CompartmentsDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof CompartmentsNavigatorItem && !isOwnView(((CompartmentsNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof CompartmentsNavigatorGroup) {
			CompartmentsNavigatorGroup group = (CompartmentsNavigatorGroup) element;
			return CompartmentsDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof CompartmentsNavigatorItem) {
			CompartmentsNavigatorItem navigatorItem = (CompartmentsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://org.eclipse.gmf.tooling.examples.compartments?Canvas", CompartmentsElementTypes.Canvas_1000); //$NON-NLS-1$
		case TopNodeAEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.compartments?TopNodeA", CompartmentsElementTypes.TopNodeA_2001); //$NON-NLS-1$
		case TopNodeBEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.compartments?TopNodeB", CompartmentsElementTypes.TopNodeB_2002); //$NON-NLS-1$
		case ChildOfA_CEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfA_C", CompartmentsElementTypes.ChildOfA_C_3001); //$NON-NLS-1$
		case ChildOfA_DEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfA_D", CompartmentsElementTypes.ChildOfA_D_3002); //$NON-NLS-1$
		case ChildOfB_EEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfB_E", CompartmentsElementTypes.ChildOfB_E_3003); //$NON-NLS-1$
		case ChildOfB_GEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfB_G", CompartmentsElementTypes.ChildOfB_G_3004); //$NON-NLS-1$
		case ChildOfAffixedEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfAffixed", CompartmentsElementTypes.ChildOfAffixed_3005); //$NON-NLS-1$
		case ChildOfB_FEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfB_F", CompartmentsElementTypes.ChildOfB_F_3006); //$NON-NLS-1$
		case ChildOfB_ECNodeRelationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfB_E?cNodeRelation", CompartmentsElementTypes.ChildOfB_ECNodeRelation_4001); //$NON-NLS-1$
		case ChildOfB_FDNodeRelationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://org.eclipse.gmf.tooling.examples.compartments?ChildOfB_F?dNodeRelation", CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = CompartmentsDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && CompartmentsElementTypes.isKnownElementType(elementType)) {
			image = CompartmentsElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof CompartmentsNavigatorGroup) {
			CompartmentsNavigatorGroup group = (CompartmentsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof CompartmentsNavigatorItem) {
			CompartmentsNavigatorItem navigatorItem = (CompartmentsNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (CompartmentsVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000Text(view);
		case TopNodeAEditPart.VISUAL_ID:
			return getTopNodeA_2001Text(view);
		case TopNodeBEditPart.VISUAL_ID:
			return getTopNodeB_2002Text(view);
		case ChildOfA_CEditPart.VISUAL_ID:
			return getChildOfA_C_3001Text(view);
		case ChildOfA_DEditPart.VISUAL_ID:
			return getChildOfA_D_3002Text(view);
		case ChildOfB_EEditPart.VISUAL_ID:
			return getChildOfB_E_3003Text(view);
		case ChildOfB_GEditPart.VISUAL_ID:
			return getChildOfB_G_3004Text(view);
		case ChildOfAffixedEditPart.VISUAL_ID:
			return getChildOfAffixed_3005Text(view);
		case ChildOfB_FEditPart.VISUAL_ID:
			return getChildOfB_F_3006Text(view);
		case ChildOfB_ECNodeRelationEditPart.VISUAL_ID:
			return getChildOfB_ECNodeRelation_4001Text(view);
		case ChildOfB_FDNodeRelationEditPart.VISUAL_ID:
			return getChildOfB_FDNodeRelation_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getCanvas_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getTopNodeA_2001Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.TopNodeA_2001, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(TopNodeANameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTopNodeB_2002Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.TopNodeB_2002, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(TopNodeBNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfA_C_3001Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.ChildOfA_C_3001, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(ChildOfA_CNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfA_D_3002Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.ChildOfA_D_3002, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(ChildOfA_DNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfB_E_3003Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.ChildOfB_E_3003, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(ChildOfB_ENameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfB_G_3004Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.ChildOfB_G_3004, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(ChildOfB_GNumberEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfAffixed_3005Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.ChildOfAffixed_3005, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(ChildOfAffixedEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfB_F_3006Text(View view) {
		IParser parser = CompartmentsParserProvider.getParser(CompartmentsElementTypes.ChildOfB_F_3006, view.getElement() != null ? view.getElement() : view,
				CompartmentsVisualIDRegistry.getType(ChildOfB_FNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			CompartmentsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getChildOfB_ECNodeRelation_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getChildOfB_FDNodeRelation_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return CanvasEditPart.MODEL_ID.equals(CompartmentsVisualIDRegistry.getModelID(view));
	}

}
