/*
 *
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Richard Gronback (Borland) - initial API and implementation
 
 */
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
public class MindmapNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MindmapDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?InvalidElement", ImageDescriptor.getMissingImageDescriptor());
		MindmapDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor());
		MindmapDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MindmapNavigatorItem && !isOwnView(((MindmapNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof MindmapNavigatorGroup) {
			MindmapNavigatorGroup group = (MindmapNavigatorGroup) element;
			return MindmapDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof MindmapNavigatorItem) {
			MindmapNavigatorItem navigatorItem = (MindmapNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case TopicEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/mindmap?Topic", MindmapElementTypes.Topic_1001);
		case ResourceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.example.org/mindmap?Resource", MindmapElementTypes.Resource_1002);
		case ThreadEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/mindmap?Thread", MindmapElementTypes.Thread_2001);
		case ThreadItemEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.example.org/mindmap?ThreadItem", MindmapElementTypes.ThreadItem_2002);
		case MapEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.example.org/mindmap?Map", MindmapElementTypes.Map_79);
		case TopicSubtopicsEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/mindmap?Topic?subtopics", MindmapElementTypes.TopicSubtopics_3001);
		case RelationshipEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/mindmap?Relationship", MindmapElementTypes.Relationship_3002);
		case Relationship2EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/mindmap?Relationship", MindmapElementTypes.Relationship_3003);
		case Relationship3EditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.example.org/mindmap?Relationship", MindmapElementTypes.Relationship_3004);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MindmapDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && MindmapElementTypes.isKnownElementType(elementType)) {
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
		if (element instanceof MindmapNavigatorGroup) {
			MindmapNavigatorGroup group = (MindmapNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof MindmapNavigatorItem) {
			MindmapNavigatorItem navigatorItem = (MindmapNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}
		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case TopicEditPart.VISUAL_ID:
			return getTopic_1001Text(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_1002Text(view);
		case ThreadEditPart.VISUAL_ID:
			return getThread_2001Text(view);
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItem_2002Text(view);
		case MapEditPart.VISUAL_ID:
			return getMap_79Text(view);
		case TopicSubtopicsEditPart.VISUAL_ID:
			return getTopicSubtopics_3001Text(view);
		case RelationshipEditPart.VISUAL_ID:
			return getRelationship_3002Text(view);
		case Relationship2EditPart.VISUAL_ID:
			return getRelationship_3003Text(view);
		case Relationship3EditPart.VISUAL_ID:
			return getRelationship_3004Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getTopic_1001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(TopicNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.Topic_1001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getResource_1002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(ResourceNameEmailEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.Resource_1002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getThread_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(ThreadSubjectEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.Thread_2001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getThreadItem_2002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(ThreadItemEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.ThreadItem_2002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 2002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getMap_79Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((Map) domainModelElement).getTitle());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 79);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getTopicSubtopics_3001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getRelationship_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(RelationshipLabelEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.Relationship_3002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRelationship_3003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(RelationshipLabel2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.Relationship_3003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRelationship_3004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return MindmapVisualIDRegistry.getType(RelationshipLabel3EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return MindmapElementTypes.Relationship_3004;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 4006);
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

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return MapEditPart.MODEL_ID.equals(MindmapVisualIDRegistry.getModelID(view));
	}

}
