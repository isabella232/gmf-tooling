package org.eclipse.gmf.example.lesscode.diagram.navigator;

import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.ElementBasedLinkEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.RootContainerEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectReferenceBasedLinkTargetEditPart;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeDiagramEditorPlugin;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
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

/**
 * @generated
 */
public class LesscodeNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		LesscodeDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		LesscodeDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof LesscodeNavigatorItem && !isOwnView(((LesscodeNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof LesscodeNavigatorGroup) {
			LesscodeNavigatorGroup group = (LesscodeNavigatorGroup) element;
			return LesscodeDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof LesscodeNavigatorItem) {
			LesscodeNavigatorItem navigatorItem = (LesscodeNavigatorItem) element;
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
		switch (LesscodeVisualIDRegistry.getVisualID(view)) {
		case RootContainerEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/gmf-tooling/bug403577?RootContainer", LesscodeElementTypes.RootContainer_1000); //$NON-NLS-1$
		case ElementBasedLinkEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/gmf-tooling/bug403577?ElementBasedLink", LesscodeElementTypes.ElementBasedLink_4001); //$NON-NLS-1$
		case SubjectReferenceBasedLinkTargetEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/gmf-tooling/bug403577?Subject?referenceBasedLinkTarget", LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = LesscodeDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && LesscodeElementTypes.isKnownElementType(elementType)) {
			image = LesscodeElementTypes.getImage(elementType);
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
		if (element instanceof LesscodeNavigatorGroup) {
			LesscodeNavigatorGroup group = (LesscodeNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof LesscodeNavigatorItem) {
			LesscodeNavigatorItem navigatorItem = (LesscodeNavigatorItem) element;
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
		switch (LesscodeVisualIDRegistry.getVisualID(view)) {
		case RootContainerEditPart.VISUAL_ID:
			return getRootContainer_1000Text(view);
		case ElementBasedLinkEditPart.VISUAL_ID:
			return getElementBasedLink_4001Text(view);
		case SubjectReferenceBasedLinkTargetEditPart.VISUAL_ID:
			return getSubjectReferenceBasedLinkTarget_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getRootContainer_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getElementBasedLink_4001Text(View view) {
		ElementBasedLink domainModelElement = (ElementBasedLink) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSubjectReferenceBasedLinkTarget_4002Text(View view) {
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
		return RootContainerEditPart.MODEL_ID.equals(LesscodeVisualIDRegistry.getModelID(view));
	}

}
