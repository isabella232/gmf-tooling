/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
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
import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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
public class MindmapNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MindmapDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		MindmapDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MindmapNavigatorItem
				&& !isOwnView(((MindmapNavigatorItem) element).getView())) {
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
			return MindmapDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
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
		case MapEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.example.org/mindmap?Map", MindmapElementTypes.Map_1000); //$NON-NLS-1$
		case TopicEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.example.org/mindmap?Topic", MindmapElementTypes.Topic_2001); //$NON-NLS-1$
		case ResourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.example.org/mindmap?Resource", MindmapElementTypes.Resource_2002); //$NON-NLS-1$
		case ThreadEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/mindmap?Thread", MindmapElementTypes.Thread_3001); //$NON-NLS-1$
		case ThreadItemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.example.org/mindmap?ThreadItem", MindmapElementTypes.ThreadItem_3002); //$NON-NLS-1$
		case TopicSubtopicsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/mindmap?Topic?subtopics", MindmapElementTypes.TopicSubtopics_4001); //$NON-NLS-1$
		case RelationshipEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/mindmap?Relationship", MindmapElementTypes.Relationship_4002); //$NON-NLS-1$
		case Relationship2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/mindmap?Relationship", MindmapElementTypes.Relationship_4003); //$NON-NLS-1$
		case Relationship3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.example.org/mindmap?Relationship", MindmapElementTypes.Relationship_4004); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
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
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
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
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (MindmapVisualIDRegistry.getVisualID(view)) {
		case MapEditPart.VISUAL_ID:
			return getMap_1000Text(view);
		case TopicEditPart.VISUAL_ID:
			return getTopic_2001Text(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2002Text(view);
		case ThreadEditPart.VISUAL_ID:
			return getThread_3001Text(view);
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItem_3002Text(view);
		case TopicSubtopicsEditPart.VISUAL_ID:
			return getTopicSubtopics_4001Text(view);
		case RelationshipEditPart.VISUAL_ID:
			return getRelationship_4002Text(view);
		case Relationship2EditPart.VISUAL_ID:
			return getRelationship_4003Text(view);
		case Relationship3EditPart.VISUAL_ID:
			return getRelationship_4004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMap_1000Text(View view) {
		Map domainModelElement = (Map) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getTitle());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTopic_2001Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.Topic_2001,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry.getType(TopicNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getResource_2002Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.Resource_2002,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry
						.getType(ResourceNameEmailEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getThread_3001Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.Thread_3001,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry
						.getType(ThreadSubjectEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getThreadItem_3002Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.ThreadItem_3002,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry.getType(ThreadItemEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 3002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTopicSubtopics_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRelationship_4002Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.Relationship_4002,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry
						.getType(RelationshipLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getRelationship_4003Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.Relationship_4003,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry
						.getType(RelationshipLabel2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getRelationship_4004Text(View view) {
		IAdaptable hintAdapter = new MindmapParserProvider.HintAdapter(
				MindmapElementTypes.Relationship_4004,
				(view.getElement() != null ? view.getElement() : view),
				MindmapVisualIDRegistry
						.getType(RelationshipLabel3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MindmapDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
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
		return MapEditPart.MODEL_ID.equals(MindmapVisualIDRegistry
				.getModelID(view));
	}

}
