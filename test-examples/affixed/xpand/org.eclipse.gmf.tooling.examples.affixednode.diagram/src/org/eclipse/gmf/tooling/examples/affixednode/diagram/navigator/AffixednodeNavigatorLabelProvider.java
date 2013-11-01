package org.eclipse.gmf.tooling.examples.affixednode.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.BundleEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.BundleNameEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.CommunicationEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.IncomingCommunicatorEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts.OutcomingCommunicatorEditPart;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.part.AffixednodeDiagramEditorPlugin;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.part.AffixednodeVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeElementTypes;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.providers.AffixednodeParserProvider;
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
public class AffixednodeNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		AffixednodeDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		AffixednodeDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof AffixednodeNavigatorItem && !isOwnView(((AffixednodeNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof AffixednodeNavigatorGroup) {
			AffixednodeNavigatorGroup group = (AffixednodeNavigatorGroup) element;
			return AffixednodeDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof AffixednodeNavigatorItem) {
			AffixednodeNavigatorItem navigatorItem = (AffixednodeNavigatorItem) element;
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
		switch (AffixednodeVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://org.eclipse.gmf.tooling.examples.affixednode?Canvas", AffixednodeElementTypes.Canvas_1000); //$NON-NLS-1$
		case BundleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.affixednode?Bundle", AffixednodeElementTypes.Bundle_2001); //$NON-NLS-1$
		case IncomingCommunicatorEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.affixednode?IncomingCommunicator", AffixednodeElementTypes.IncomingCommunicator_3001); //$NON-NLS-1$
		case OutcomingCommunicatorEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.affixednode?OutcomingCommunicator", AffixednodeElementTypes.OutcomingCommunicator_3002); //$NON-NLS-1$
		case CommunicationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://org.eclipse.gmf.tooling.examples.affixednode?Communication", AffixednodeElementTypes.Communication_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = AffixednodeDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && AffixednodeElementTypes.isKnownElementType(elementType)) {
			image = AffixednodeElementTypes.getImage(elementType);
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
		if (element instanceof AffixednodeNavigatorGroup) {
			AffixednodeNavigatorGroup group = (AffixednodeNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof AffixednodeNavigatorItem) {
			AffixednodeNavigatorItem navigatorItem = (AffixednodeNavigatorItem) element;
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
		switch (AffixednodeVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000Text(view);
		case BundleEditPart.VISUAL_ID:
			return getBundle_2001Text(view);
		case IncomingCommunicatorEditPart.VISUAL_ID:
			return getIncomingCommunicator_3001Text(view);
		case OutcomingCommunicatorEditPart.VISUAL_ID:
			return getOutcomingCommunicator_3002Text(view);
		case CommunicationEditPart.VISUAL_ID:
			return getCommunication_4001Text(view);
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
	private String getBundle_2001Text(View view) {
		IParser parser = AffixednodeParserProvider.getParser(AffixednodeElementTypes.Bundle_2001, view.getElement() != null ? view.getElement() : view,
				AffixednodeVisualIDRegistry.getType(BundleNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			AffixednodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getIncomingCommunicator_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getOutcomingCommunicator_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getCommunication_4001Text(View view) {
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
		return CanvasEditPart.MODEL_ID.equals(AffixednodeVisualIDRegistry.getModelID(view));
	}

}
