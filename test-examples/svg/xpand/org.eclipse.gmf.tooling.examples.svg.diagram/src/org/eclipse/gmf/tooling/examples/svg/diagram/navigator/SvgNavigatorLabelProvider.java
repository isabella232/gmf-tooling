package org.eclipse.gmf.tooling.examples.svg.diagram.navigator;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.GoalEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlayerEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlaygroundEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgDiagramEditorPlugin;
import org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry;
import org.eclipse.gmf.tooling.examples.svg.diagram.providers.SvgElementTypes;
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
public class SvgNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		SvgDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		SvgDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof SvgNavigatorItem && !isOwnView(((SvgNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof SvgNavigatorGroup) {
			SvgNavigatorGroup group = (SvgNavigatorGroup) element;
			return SvgDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof SvgNavigatorItem) {
			SvgNavigatorItem navigatorItem = (SvgNavigatorItem) element;
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
		switch (SvgVisualIDRegistry.getVisualID(view)) {
		case PlaygroundEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://org.eclipse.gmf.tooling.examples.svg?Playground", SvgElementTypes.Playground_1000); //$NON-NLS-1$
		case GoalEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.svg?Goal", SvgElementTypes.Goal_2001); //$NON-NLS-1$
		case PlayerEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://org.eclipse.gmf.tooling.examples.svg?Player", SvgElementTypes.Player_2002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = SvgDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && SvgElementTypes.isKnownElementType(elementType)) {
			image = SvgElementTypes.getImage(elementType);
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
		if (element instanceof SvgNavigatorGroup) {
			SvgNavigatorGroup group = (SvgNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof SvgNavigatorItem) {
			SvgNavigatorItem navigatorItem = (SvgNavigatorItem) element;
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
		switch (SvgVisualIDRegistry.getVisualID(view)) {
		case PlaygroundEditPart.VISUAL_ID:
			return getPlayground_1000Text(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2001Text(view);
		case PlayerEditPart.VISUAL_ID:
			return getPlayer_2002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getPlayground_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getGoal_2001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getPlayer_2002Text(View view) {
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
		return PlaygroundEditPart.MODEL_ID.equals(SvgVisualIDRegistry.getModelID(view));
	}

}
