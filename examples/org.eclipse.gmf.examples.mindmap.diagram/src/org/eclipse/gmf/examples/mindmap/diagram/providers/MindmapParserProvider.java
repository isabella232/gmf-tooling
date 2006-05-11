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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_label2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_label3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Relationship_labelEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Resource_name_emailEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Thread_subjectEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.Topic_nameEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class MindmapParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser threadThreadSubject_4002Parser;

	/**
	 * @generated
	 */
	private IParser getThreadThreadSubject_4002Parser() {
		if (threadThreadSubject_4002Parser == null) {
			threadThreadSubject_4002Parser = createThreadThreadSubject_4002Parser();
		}
		return threadThreadSubject_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadThreadSubject_4002Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getThread().getEStructuralFeature("subject"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser threadItemThreadItemBody_4001Parser;

	/**
	 * @generated
	 */
	private IParser getThreadItemThreadItemBody_4001Parser() {
		if (threadItemThreadItemBody_4001Parser == null) {
			threadItemThreadItemBody_4001Parser = createThreadItemThreadItemBody_4001Parser();
		}
		return threadItemThreadItemBody_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadItemThreadItemBody_4001Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getThreadItem().getEStructuralFeature("body"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser topicTopicName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getTopicTopicName_4003Parser() {
		if (topicTopicName_4003Parser == null) {
			topicTopicName_4003Parser = createTopicTopicName_4003Parser();
		}
		return topicTopicName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTopicTopicName_4003Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getTopic().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceResourceNameEmail_4004Parser;

	/**
	 * @generated
	 */
	private IParser getResourceResourceNameEmail_4004Parser() {
		if (resourceResourceNameEmail_4004Parser == null) {
			resourceResourceNameEmail_4004Parser = createResourceResourceNameEmail_4004Parser();
		}
		return resourceResourceNameEmail_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceResourceNameEmail_4004Parser() {
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
	private IParser relationshipRelationshipLabel_4007Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_4007Parser() {
		if (relationshipRelationshipLabel_4007Parser == null) {
			relationshipRelationshipLabel_4007Parser = createRelationshipRelationshipLabel_4007Parser();
		}
		return relationshipRelationshipLabel_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_4007Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(MindmapPackage.eINSTANCE.getRelationship().getEStructuralFeature("label"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, int visualID) {
		if (MindmapElementTypes.Thread_2001 == type) {
			if (Thread_subjectEditPart.VISUAL_ID == visualID) {
				return getThreadThreadSubject_4002Parser();
			}
		}
		if (MindmapElementTypes.ThreadItem_2002 == type) {
			return getThreadItemThreadItemBody_4001Parser();
		}
		if (MindmapElementTypes.Topic_1001 == type) {
			if (Topic_nameEditPart.VISUAL_ID == visualID) {
				return getTopicTopicName_4003Parser();
			}
		}
		if (MindmapElementTypes.Resource_1002 == type) {
			if (Resource_name_emailEditPart.VISUAL_ID == visualID) {
				return getResourceResourceNameEmail_4004Parser();
			}
		}
		if (MindmapElementTypes.Relationship_3002 == type) {
			if (Relationship_labelEditPart.VISUAL_ID == visualID) {
				return getRelationshipRelationshipLabel_4005Parser();
			}
		}
		if (MindmapElementTypes.Relationship_3003 == type) {
			if (Relationship_label2EditPart.VISUAL_ID == visualID) {
				return getRelationshipRelationshipLabel_4006Parser();
			}
		}
		if (MindmapElementTypes.Relationship_3004 == type) {
			if (Relationship_label3EditPart.VISUAL_ID == visualID) {
				return getRelationshipRelationshipLabel_4007Parser();
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		int visualID = MindmapVisualIDRegistry.getVisualID((String) hint.getAdapter(String.class));
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type == null) {
			EObject element = (EObject) hint.getAdapter(EObject.class);
			type = ElementTypeRegistry.getInstance().getElementType(element);
		}
		return getParser(type, visualID);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			return getParser(((GetParserOperation) operation).getHint()) != null;
		}
		return false;
	}
}
