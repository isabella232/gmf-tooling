/*******************************************************************************
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.examples.mindmap.diagram.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_label2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_label3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_labelEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Resource_name_emailEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Thread_subjectEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Topic_nameEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser threadThreadSubject_4001Parser;

	/**
	 * @generated
	 */
	private IParser getThreadThreadSubject_4001Parser() {
		if (threadThreadSubject_4001Parser == null) {
			threadThreadSubject_4001Parser = createThreadThreadSubject_4001Parser();
		}
		return threadThreadSubject_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadThreadSubject_4001Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getThread().getEStructuralFeature("subject"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser threadItemThreadItem_2002Parser;

	/**
	 * @generated
	 */
	private IParser getThreadItemThreadItem_2002Parser() {
		if (threadItemThreadItem_2002Parser == null) {
			threadItemThreadItem_2002Parser = createThreadItemThreadItem_2002Parser();
		}
		return threadItemThreadItem_2002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadItemThreadItem_2002Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getThreadItem().getEStructuralFeature("body"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser topicTopicName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getTopicTopicName_4002Parser() {
		if (topicTopicName_4002Parser == null) {
			topicTopicName_4002Parser = createTopicTopicName_4002Parser();
		}
		return topicTopicName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTopicTopicName_4002Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceResourceNameEmail_4003Parser;

	/**
	 * @generated
	 */
	private IParser getResourceResourceNameEmail_4003Parser() {
		if (resourceResourceNameEmail_4003Parser == null) {
			resourceResourceNameEmail_4003Parser = createResourceResourceNameEmail_4003Parser();
		}
		return resourceResourceNameEmail_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceResourceNameEmail_4003Parser() {
		List features = new ArrayList(2);
		features.add(MindmapPackage.eINSTANCE.getResource().getEStructuralFeature("name"));
		features.add(MindmapPackage.eINSTANCE.getResource().getEStructuralFeature("email"));
		MindmapStructuralFeaturesParser parser = new MindmapStructuralFeaturesParser(features);
		parser.setViewPattern("{0} [{1}]");
		parser.setEditPattern("{0} : {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipRelationshipLabel_4004Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_4004Parser() {
		if (relationshipRelationshipLabel_4004Parser == null) {
			relationshipRelationshipLabel_4004Parser = createRelationshipRelationshipLabel_4004Parser();
		}
		return relationshipRelationshipLabel_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_4004Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getRelationship().getEStructuralFeature("label"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipRelationshipLabel_4005Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_4005Parser() {
		if (relationshipRelationshipLabel_4005Parser == null) {
			relationshipRelationshipLabel_4005Parser = createRelationshipRelationshipLabel_4005Parser();
		}
		return relationshipRelationshipLabel_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_4005Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getRelationship().getEStructuralFeature("label"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipRelationshipLabel_4006Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_4006Parser() {
		if (relationshipRelationshipLabel_4006Parser == null) {
			relationshipRelationshipLabel_4006Parser = createRelationshipRelationshipLabel_4006Parser();
		}
		return relationshipRelationshipLabel_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_4006Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getRelationship().getEStructuralFeature("label"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case Thread_subjectEditPart.VISUAL_ID:
			return getThreadThreadSubject_4001Parser();
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItemThreadItem_2002Parser();
		case Topic_nameEditPart.VISUAL_ID:
			return getTopicTopicName_4002Parser();
		case Resource_name_emailEditPart.VISUAL_ID:
			return getResourceResourceNameEmail_4003Parser();
		case Relationship_labelEditPart.VISUAL_ID:
			return getRelationshipRelationshipLabel_4004Parser();
		case Relationship_label2EditPart.VISUAL_ID:
			return getRelationshipRelationshipLabel_4005Parser();
		case Relationship_label3EditPart.VISUAL_ID:
			return getRelationshipRelationshipLabel_4006Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(MindmapVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(MindmapVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (MindmapElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}
}
