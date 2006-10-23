package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.Map;

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabel3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabelEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceNameEmailEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadSubjectEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicNameEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicSubtopicsEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import org.eclipse.jface.viewers.LabelProvider;

import org.eclipse.swt.graphics.Image;

import org.eclipse.ui.IMemento;

import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class MindmapNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider {

	/**
	 * @generated
	 */
	static {
		MindmapDiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?InvalidElement",
				ImageDescriptor.getMissingImageDescriptor());
		MindmapDiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?UnknownElement",
				ImageDescriptor.getMissingImageDescriptor());
		MindmapDiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?ImageNotFound",
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (false == element instanceof MindmapAbstractNavigatorItem) {
			return super.getImage(element);
		}

		MindmapAbstractNavigatorItem abstractNavigatorItem = (MindmapAbstractNavigatorItem) element;
		if (!MapEditPart.MODEL_ID.equals(abstractNavigatorItem.getModelID())) {
			return super.getImage(element);
		}

		if (abstractNavigatorItem instanceof MindmapNavigatorItem) {
			MindmapNavigatorItem navigatorItem = (MindmapNavigatorItem) abstractNavigatorItem;
			switch (navigatorItem.getVisualID()) {
			case TopicEditPart.VISUAL_ID:
				return getImage(
						"Navigator?TopLevelNode?http://www.example.org/mindmap?Topic",
						MindmapElementTypes.Topic_2001);
			case ResourceEditPart.VISUAL_ID:
				return getImage(
						"Navigator?TopLevelNode?http://www.example.org/mindmap?Resource",
						MindmapElementTypes.Resource_2002);
			case ThreadEditPart.VISUAL_ID:
				return getImage(
						"Navigator?Node?http://www.example.org/mindmap?Thread",
						MindmapElementTypes.Thread_3001);
			case ThreadItemEditPart.VISUAL_ID:
				return getImage(
						"Navigator?Node?http://www.example.org/mindmap?ThreadItem",
						MindmapElementTypes.ThreadItem_3002);
			case MapEditPart.VISUAL_ID:
				return getImage(
						"Navigator?Diagram?http://www.example.org/mindmap?Map",
						MindmapElementTypes.Map_1000);
			case TopicSubtopicsEditPart.VISUAL_ID:
				return getImage(
						"Navigator?Link?http://www.example.org/mindmap?Topic?subtopics",
						MindmapElementTypes.TopicSubtopics_4001);
			case RelationshipEditPart.VISUAL_ID:
				return getImage(
						"Navigator?Link?http://www.example.org/mindmap?Relationship",
						MindmapElementTypes.Relationship_4002);
			case Relationship2EditPart.VISUAL_ID:
				return getImage(
						"Navigator?Link?http://www.example.org/mindmap?Relationship",
						MindmapElementTypes.Relationship_4003);
			case Relationship3EditPart.VISUAL_ID:
				return getImage(
						"Navigator?Link?http://www.example.org/mindmap?Relationship",
						MindmapElementTypes.Relationship_4004);
			default:
				return getImage("Navigator?UnknownElement", null);
			}
		} else if (abstractNavigatorItem instanceof MindmapNavigatorGroup) {
			MindmapNavigatorGroup group = (MindmapNavigatorGroup) element;
			return MindmapDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MindmapDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& MindmapElementTypes.isKnownElementType(elementType)) {
			image = MindmapElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound");
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (false == element instanceof MindmapAbstractNavigatorItem) {
			return super.getText(element);
		}

		MindmapAbstractNavigatorItem abstractNavigatorItem = (MindmapAbstractNavigatorItem) element;
		if (!MapEditPart.MODEL_ID.equals(abstractNavigatorItem.getModelID())) {
			return super.getText(element);
		}

		if (abstractNavigatorItem instanceof MindmapNavigatorItem) {
			MindmapNavigatorItem navigatorItem = (MindmapNavigatorItem) abstractNavigatorItem;
			switch (navigatorItem.getVisualID()) {
			case TopicEditPart.VISUAL_ID:
				return getTopic_2001Text(navigatorItem.getView());
			case ResourceEditPart.VISUAL_ID:
				return getResource_2002Text(navigatorItem.getView());
			case ThreadEditPart.VISUAL_ID:
				return getThread_3001Text(navigatorItem.getView());
			case ThreadItemEditPart.VISUAL_ID:
				return getThreadItem_3002Text(navigatorItem.getView());
			case MapEditPart.VISUAL_ID:
				return getMap_1000Text(navigatorItem.getView());
			case TopicSubtopicsEditPart.VISUAL_ID:
				return getTopicSubtopics_4001Text(navigatorItem.getView());
			case RelationshipEditPart.VISUAL_ID:
				return getRelationship_4002Text(navigatorItem.getView());
			case Relationship2EditPart.VISUAL_ID:
				return getRelationship_4003Text(navigatorItem.getView());
			case Relationship3EditPart.VISUAL_ID:
				return getRelationship_4004Text(navigatorItem.getView());
			default:
				return getUnknownElementText(navigatorItem.getView());
			}
		} else if (abstractNavigatorItem instanceof MindmapNavigatorGroup) {
			MindmapNavigatorGroup group = (MindmapNavigatorGroup) element;
			return group.getGroupName();
		}
		return super.getText(element);
	}

	/**
	 * @generated
	 */
	private String getTopic_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(TopicNameEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.Topic_2001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getResource_2002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(ResourceNameEmailEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.Resource_2002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getThread_3001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(ThreadSubjectEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.Thread_3001;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getThreadItem_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(ThreadItemEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.ThreadItem_3002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getMap_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((Map) domainModelElement).getTitle());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getTopicSubtopics_4001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getRelationship_4002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(RelationshipLabelEditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.Relationship_4002;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRelationship_4003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(RelationshipLabel2EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.Relationship_4003;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRelationship_4004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(
				new IAdaptable() {
					public Object getAdapter(Class adapter) {
						if (String.class.equals(adapter)) {
							return MindmapVisualIDRegistry
									.getType(RelationshipLabel3EditPart.VISUAL_ID);
						}
						if (IElementType.class.equals(adapter)) {
							return MindmapElementTypes.Relationship_4004;
						}
						return null;
					}
				});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
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

}
