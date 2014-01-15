package org.eclipse.gmf.example.lesscode.diagram.navigator;

import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.ElementBasedLinkEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.RootContainerEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectReferenceBasedLinkTargetEditPart;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeDiagramEditorPlugin;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeParserProvider;
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
		case SubjectEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/gmf-tooling/bug403577?Subject", LesscodeElementTypes.Subject_2001); //$NON-NLS-1$
		case OneContainmentGroupEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/gmf-tooling/bug403577?OneContainmentGroup", LesscodeElementTypes.OneContainmentGroup_2002); //$NON-NLS-1$
		case MultiContainmentGroupEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/gmf-tooling/bug403577?MultiContainmentGroup", LesscodeElementTypes.MultiContainmentGroup_2003); //$NON-NLS-1$
		case Subject2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/gmf-tooling/bug403577?Subject", LesscodeElementTypes.Subject_3001); //$NON-NLS-1$
		case Subject3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/gmf-tooling/bug403577?Subject", LesscodeElementTypes.Subject_3002); //$NON-NLS-1$
		case Subject4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/gmf-tooling/bug403577?Subject", LesscodeElementTypes.Subject_3003); //$NON-NLS-1$
		case Subject5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/gmf-tooling/bug403577?Subject", LesscodeElementTypes.Subject_3004); //$NON-NLS-1$
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
		case SubjectEditPart.VISUAL_ID:
			return getSubject_2001Text(view);
		case OneContainmentGroupEditPart.VISUAL_ID:
			return getOneContainmentGroup_2002Text(view);
		case MultiContainmentGroupEditPart.VISUAL_ID:
			return getMultiContainmentGroup_2003Text(view);
		case Subject2EditPart.VISUAL_ID:
			return getSubject_3001Text(view);
		case Subject3EditPart.VISUAL_ID:
			return getSubject_3002Text(view);
		case Subject4EditPart.VISUAL_ID:
			return getSubject_3003Text(view);
		case Subject5EditPart.VISUAL_ID:
			return getSubject_3004Text(view);
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
	private String getSubject_2001Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.Subject_2001, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(SubjectNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getOneContainmentGroup_2002Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.OneContainmentGroup_2002, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(OneContainmentGroupNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMultiContainmentGroup_2003Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.MultiContainmentGroup_2003, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(MultiContainmentGroupNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubject_3001Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.Subject_3001, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(SubjectName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubject_3002Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.Subject_3002, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(SubjectName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubject_3003Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.Subject_3003, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(SubjectName4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSubject_3004Text(View view) {
		IParser parser = LesscodeParserProvider.getParser(LesscodeElementTypes.Subject_3004, view.getElement() != null ? view.getElement() : view,
				LesscodeVisualIDRegistry.getType(SubjectName5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			LesscodeDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
