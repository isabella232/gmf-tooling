package org.eclipse.gmf.examples.mindmap.rcp.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabel3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.RelationshipLabelEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ResourceNameEmailEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadSubjectEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.TopicNameEditPart;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapVisualIDRegistry;

/**
 * @generated
 */
public class MindmapParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser threadThreadSubject_5001Parser;

	/**
	 * @generated
	 */
	private IParser getThreadThreadSubject_5001Parser() {
		if (threadThreadSubject_5001Parser == null) {
			threadThreadSubject_5001Parser = createThreadThreadSubject_5001Parser();
		}
		return threadThreadSubject_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadThreadSubject_5001Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(
				MindmapPackage.eINSTANCE.getThread_Subject());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser threadItemThreadItem_3002Parser;

	/**
	 * @generated
	 */
	private IParser getThreadItemThreadItem_3002Parser() {
		if (threadItemThreadItem_3002Parser == null) {
			threadItemThreadItem_3002Parser = createThreadItemThreadItem_3002Parser();
		}
		return threadItemThreadItem_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadItemThreadItem_3002Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(
				MindmapPackage.eINSTANCE.getThreadItem_Body());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser topicTopicName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTopicTopicName_5002Parser() {
		if (topicTopicName_5002Parser == null) {
			topicTopicName_5002Parser = createTopicTopicName_5002Parser();
		}
		return topicTopicName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTopicTopicName_5002Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(
				MindmapPackage.eINSTANCE.getTopic_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceResourceNameEmail_5003Parser;

	/**
	 * @generated
	 */
	private IParser getResourceResourceNameEmail_5003Parser() {
		if (resourceResourceNameEmail_5003Parser == null) {
			resourceResourceNameEmail_5003Parser = createResourceResourceNameEmail_5003Parser();
		}
		return resourceResourceNameEmail_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceResourceNameEmail_5003Parser() {
		List features = new ArrayList(2);
		features.add(MindmapPackage.eINSTANCE.getResource_Name());
		features.add(MindmapPackage.eINSTANCE.getResource_Email());
		MindmapStructuralFeaturesParser parser = new MindmapStructuralFeaturesParser(
				features);
		parser.setViewPattern("{0} [{1}]");
		parser.setEditPattern("{0} : {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipRelationshipLabel_6001Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_6001Parser() {
		if (relationshipRelationshipLabel_6001Parser == null) {
			relationshipRelationshipLabel_6001Parser = createRelationshipRelationshipLabel_6001Parser();
		}
		return relationshipRelationshipLabel_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_6001Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(
				MindmapPackage.eINSTANCE.getRelationship_Label());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipRelationshipLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_6002Parser() {
		if (relationshipRelationshipLabel_6002Parser == null) {
			relationshipRelationshipLabel_6002Parser = createRelationshipRelationshipLabel_6002Parser();
		}
		return relationshipRelationshipLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_6002Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(
				MindmapPackage.eINSTANCE.getRelationship_Label());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipRelationshipLabel_6003Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipRelationshipLabel_6003Parser() {
		if (relationshipRelationshipLabel_6003Parser == null) {
			relationshipRelationshipLabel_6003Parser = createRelationshipRelationshipLabel_6003Parser();
		}
		return relationshipRelationshipLabel_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipRelationshipLabel_6003Parser() {
		MindmapStructuralFeatureParser parser = new MindmapStructuralFeatureParser(
				MindmapPackage.eINSTANCE.getRelationship_Label());
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ThreadSubjectEditPart.VISUAL_ID:
			return getThreadThreadSubject_5001Parser();
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItemThreadItem_3002Parser();
		case TopicNameEditPart.VISUAL_ID:
			return getTopicTopicName_5002Parser();
		case ResourceNameEmailEditPart.VISUAL_ID:
			return getResourceResourceNameEmail_5003Parser();
		case RelationshipLabelEditPart.VISUAL_ID:
			return getRelationshipRelationshipLabel_6001Parser();
		case RelationshipLabel2EditPart.VISUAL_ID:
			return getRelationshipRelationshipLabel_6002Parser();
		case RelationshipLabel3EditPart.VISUAL_ID:
			return getRelationshipRelationshipLabel_6003Parser();
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
