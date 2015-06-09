package org.eclipse.gmf.tooling.examples.linklf.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Circle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CircleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Container2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerName2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkSourceNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LinkEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rectangle2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RectangleEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.Rhombus2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.RhombusEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfDiagramEditorPlugin;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfParserProvider;
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
public class LinklfNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		LinklfDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		LinklfDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof LinklfNavigatorItem && !isOwnView(((LinklfNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof LinklfNavigatorGroup) {
			LinklfNavigatorGroup group = (LinklfNavigatorGroup) element;
			return LinklfDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof LinklfNavigatorItem) {
			LinklfNavigatorItem navigatorItem = (LinklfNavigatorItem) element;
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
		switch (LinklfVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://linklf.gmf.eclipse.org?Canvas", LinklfElementTypes.Canvas_1000); //$NON-NLS-1$
		case CircleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://linklf.gmf.eclipse.org?Circle", LinklfElementTypes.Circle_2001); //$NON-NLS-1$
		case RectangleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://linklf.gmf.eclipse.org?Rectangle", LinklfElementTypes.Rectangle_2002); //$NON-NLS-1$
		case ContainerEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://linklf.gmf.eclipse.org?Container", LinklfElementTypes.Container_2003); //$NON-NLS-1$
		case RhombusEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://linklf.gmf.eclipse.org?Rhombus", LinklfElementTypes.Rhombus_2004); //$NON-NLS-1$
		case Circle2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://linklf.gmf.eclipse.org?Circle", LinklfElementTypes.Circle_3001); //$NON-NLS-1$
		case Container2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://linklf.gmf.eclipse.org?Container", LinklfElementTypes.Container_3002); //$NON-NLS-1$
		case Rectangle2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://linklf.gmf.eclipse.org?Rectangle", LinklfElementTypes.Rectangle_3003); //$NON-NLS-1$
		case Rhombus2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://linklf.gmf.eclipse.org?Rhombus", LinklfElementTypes.Rhombus_3004); //$NON-NLS-1$
		case PortEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://linklf.gmf.eclipse.org?Port", LinklfElementTypes.Port_3005); //$NON-NLS-1$
		case LinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://linklf.gmf.eclipse.org?Link", LinklfElementTypes.Link_4001); //$NON-NLS-1$
		case LabeledLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://linklf.gmf.eclipse.org?LabeledLink", LinklfElementTypes.LabeledLink_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = LinklfDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && LinklfElementTypes.isKnownElementType(elementType)) {
			image = LinklfElementTypes.getImage(elementType);
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
		if (element instanceof LinklfNavigatorGroup) {
			LinklfNavigatorGroup group = (LinklfNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof LinklfNavigatorItem) {
			LinklfNavigatorItem navigatorItem = (LinklfNavigatorItem) element;
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
		switch (LinklfVisualIDRegistry.getVisualID(view)) {
		case CanvasEditPart.VISUAL_ID:
			return getCanvas_1000Text(view);
		case CircleEditPart.VISUAL_ID:
			return getCircle_2001Text(view);
		case RectangleEditPart.VISUAL_ID:
			return getRectangle_2002Text(view);
		case ContainerEditPart.VISUAL_ID:
			return getContainer_2003Text(view);
		case RhombusEditPart.VISUAL_ID:
			return getRhombus_2004Text(view);
		case Circle2EditPart.VISUAL_ID:
			return getCircle_3001Text(view);
		case Container2EditPart.VISUAL_ID:
			return getContainer_3002Text(view);
		case Rectangle2EditPart.VISUAL_ID:
			return getRectangle_3003Text(view);
		case Rhombus2EditPart.VISUAL_ID:
			return getRhombus_3004Text(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3005Text(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_4001Text(view);
		case LabeledLinkEditPart.VISUAL_ID:
			return getLabeledLink_4002Text(view);
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
	private String getCircle_2001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRectangle_2002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getContainer_2003Text(View view) {
		IParser parser = LinklfParserProvider.getParser(LinklfElementTypes.Container_2003, view.getElement() != null ? view.getElement() : view,
				LinklfVisualIDRegistry.getType(ContainerNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LinklfDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRhombus_2004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCircle_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getContainer_3002Text(View view) {
		IParser parser = LinklfParserProvider.getParser(LinklfElementTypes.Container_3002, view.getElement() != null ? view.getElement() : view,
				LinklfVisualIDRegistry.getType(ContainerName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LinklfDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRectangle_3003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRhombus_3004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPort_3005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLink_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLabeledLink_4002Text(View view) {
		IParser parser = LinklfParserProvider.getParser(LinklfElementTypes.LabeledLink_4002, view.getElement() != null ? view.getElement() : view,
				LinklfVisualIDRegistry.getType(LabeledLinkSourceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LinklfDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
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
		return CanvasEditPart.MODEL_ID.equals(LinklfVisualIDRegistry.getModelID(view));
	}

}
