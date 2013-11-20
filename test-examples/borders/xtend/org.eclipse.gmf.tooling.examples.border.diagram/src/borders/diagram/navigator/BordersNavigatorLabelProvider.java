package borders.diagram.navigator;

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

import borders.diagram.edit.parts.CompoundBorderEditPart;
import borders.diagram.edit.parts.CustomBorderEditPart;
import borders.diagram.edit.parts.DiagramEditPart;
import borders.diagram.edit.parts.LineBorderEditPart;
import borders.diagram.edit.parts.MarginBorderEditPart;
import borders.diagram.part.BordersDiagramEditorPlugin;
import borders.diagram.part.BordersVisualIDRegistry;
import borders.diagram.providers.BordersElementTypes;

/**
 * @generated
 */
public class BordersNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		BordersDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		BordersDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof BordersNavigatorItem && !isOwnView(((BordersNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof BordersNavigatorGroup) {
			BordersNavigatorGroup group = (BordersNavigatorGroup) element;
			return BordersDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof BordersNavigatorItem) {
			BordersNavigatorItem navigatorItem = (BordersNavigatorItem) element;
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
		switch (BordersVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://org.eclipse.gmf.tooling.examples.borders?Diagram", BordersElementTypes.Diagram_1000); //$NON-NLS-1$
		case MarginBorderEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.borders?MarginBorder", BordersElementTypes.MarginBorder_2001); //$NON-NLS-1$
		case CustomBorderEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.borders?CustomBorder", BordersElementTypes.CustomBorder_2002); //$NON-NLS-1$
		case CompoundBorderEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.borders?CompoundBorder", BordersElementTypes.CompoundBorder_2003); //$NON-NLS-1$
		case LineBorderEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.borders?LineBorder", BordersElementTypes.LineBorder_2004); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = BordersDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && BordersElementTypes.isKnownElementType(elementType)) {
			image = BordersElementTypes.getImage(elementType);
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
		if (element instanceof BordersNavigatorGroup) {
			BordersNavigatorGroup group = (BordersNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof BordersNavigatorItem) {
			BordersNavigatorItem navigatorItem = (BordersNavigatorItem) element;
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
		switch (BordersVisualIDRegistry.getVisualID(view)) {
		case DiagramEditPart.VISUAL_ID:
			return getDiagram_1000Text(view);
		case MarginBorderEditPart.VISUAL_ID:
			return getMarginBorder_2001Text(view);
		case CustomBorderEditPart.VISUAL_ID:
			return getCustomBorder_2002Text(view);
		case CompoundBorderEditPart.VISUAL_ID:
			return getCompoundBorder_2003Text(view);
		case LineBorderEditPart.VISUAL_ID:
			return getLineBorder_2004Text(view);
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
	private String getMarginBorder_2001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCustomBorder_2002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCompoundBorder_2003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLineBorder_2004Text(View view) {
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
		return DiagramEditPart.MODEL_ID.equals(BordersVisualIDRegistry.getModelID(view));
	}

}
