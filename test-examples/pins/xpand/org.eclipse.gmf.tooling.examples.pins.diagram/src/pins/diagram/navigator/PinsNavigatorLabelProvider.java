package pins.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
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

import pins.PinsChild;
import pins.diagram.edit.parts.ColorPinEditPart;
import pins.diagram.edit.parts.CustomPinEditPart;
import pins.diagram.edit.parts.DiagramEditPart;
import pins.diagram.edit.parts.PinsChild2EditPart;
import pins.diagram.edit.parts.PinsChild3EditPart;
import pins.diagram.edit.parts.PinsChildEditPart;
import pins.diagram.edit.parts.VisiblePinEditPart;
import pins.diagram.edit.parts.VisiblePinWarningLabelEditPart;
import pins.diagram.part.PinsDiagramEditorPlugin;
import pins.diagram.part.PinsVisualIDRegistry;
import pins.diagram.providers.PinsElementTypes;
import pins.diagram.providers.PinsParserProvider;

/**
 * @generated
 */
public class PinsNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		PinsDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		PinsDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PinsNavigatorItem && !isOwnView(((PinsNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof PinsNavigatorGroup) {
			PinsNavigatorGroup group = (PinsNavigatorGroup) element;
			return PinsDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof PinsNavigatorItem) {
			PinsNavigatorItem navigatorItem = (PinsNavigatorItem) element;
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
		switch (PinsVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://org.eclipse.gmf.tooling.examples.pins?Diagram", PinsElementTypes.Diagram_1000); //$NON-NLS-1$
		case CustomPinEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.pins?CustomPin", PinsElementTypes.CustomPin_2001); //$NON-NLS-1$
		case VisiblePinEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.pins?VisiblePin", PinsElementTypes.VisiblePin_2002); //$NON-NLS-1$
		case ColorPinEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.pins?ColorPin", PinsElementTypes.ColorPin_2003); //$NON-NLS-1$
		case PinsChildEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.pins?PinsChild", PinsElementTypes.PinsChild_3001); //$NON-NLS-1$
		case PinsChild2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.pins?PinsChild", PinsElementTypes.PinsChild_3002); //$NON-NLS-1$
		case PinsChild3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://org.eclipse.gmf.tooling.examples.pins?PinsChild", PinsElementTypes.PinsChild_3003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PinsDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && PinsElementTypes.isKnownElementType(elementType)) {
			image = PinsElementTypes.getImage(elementType);
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
		if (element instanceof PinsNavigatorGroup) {
			PinsNavigatorGroup group = (PinsNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof PinsNavigatorItem) {
			PinsNavigatorItem navigatorItem = (PinsNavigatorItem) element;
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
		switch (PinsVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000Text(view);
		case CustomPinEditPart.VISUAL_ID:
			return getCustomPin_2001Text(view);
		case VisiblePinEditPart.VISUAL_ID:
			return getVisiblePin_2002Text(view);
		case ColorPinEditPart.VISUAL_ID:
			return getColorPin_2003Text(view);
		case PinsChildEditPart.VISUAL_ID:
			return getPinsChild_3001Text(view);
		case PinsChild2EditPart.VISUAL_ID:
			return getPinsChild_3002Text(view);
		case PinsChild3EditPart.VISUAL_ID:
			return getPinsChild_3003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getDiagram_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCustomPin_2001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getVisiblePin_2002Text(View view) {
		IParser parser = PinsParserProvider.getParser(PinsElementTypes.VisiblePin_2002, view.getElement() != null ? view.getElement() : view,
				PinsVisualIDRegistry.getType(VisiblePinWarningLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			PinsDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getColorPin_2003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPinsChild_3001Text(View view) {
		PinsChild domainModelElement = (PinsChild) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getPinsChild();
		} else {
			PinsDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPinsChild_3002Text(View view) {
		PinsChild domainModelElement = (PinsChild) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getPinsChild();
		} else {
			PinsDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPinsChild_3003Text(View view) {
		PinsChild domainModelElement = (PinsChild) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getPinsChild();
		} else {
			PinsDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
		return DiagramEditPart.MODEL_ID.equals(PinsVisualIDRegistry.getModelID(view));
	}

}
