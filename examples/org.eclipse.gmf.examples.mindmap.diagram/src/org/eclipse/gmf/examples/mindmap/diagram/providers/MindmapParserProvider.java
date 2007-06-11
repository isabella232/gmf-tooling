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
package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabel2EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabel3EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.RelationshipLabelEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ResourceNameEmailEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadSubjectEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicNameEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.parsers.MessageFormatParser;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

/**
 * @generated
 */
public class MindmapParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser topicName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getTopicName_5002Parser() {
		if (topicName_5002Parser == null) {
			topicName_5002Parser = createTopicName_5002Parser();
		}
		return topicName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTopicName_5002Parser() {
		EAttribute[] features = new EAttribute[] { MindmapPackage.eINSTANCE
				.getTopic_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceNameEmail_5003Parser;

	/**
	 * @generated
	 */
	private IParser getResourceNameEmail_5003Parser() {
		if (resourceNameEmail_5003Parser == null) {
			resourceNameEmail_5003Parser = createResourceNameEmail_5003Parser();
		}
		return resourceNameEmail_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceNameEmail_5003Parser() {
		EAttribute[] features = new EAttribute[] {
				MindmapPackage.eINSTANCE.getResource_Name(),
				MindmapPackage.eINSTANCE.getResource_Email(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0} [{1}]");
		parser.setEditorPattern("{0} [{1}]");
		parser.setEditPattern("{0} : {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser threadSubject_5001Parser;

	/**
	 * @generated
	 */
	private IParser getThreadSubject_5001Parser() {
		if (threadSubject_5001Parser == null) {
			threadSubject_5001Parser = createThreadSubject_5001Parser();
		}
		return threadSubject_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadSubject_5001Parser() {
		EAttribute[] features = new EAttribute[] { MindmapPackage.eINSTANCE
				.getThread_Subject(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser threadItem_3002Parser;

	/**
	 * @generated
	 */
	private IParser getThreadItem_3002Parser() {
		if (threadItem_3002Parser == null) {
			threadItem_3002Parser = createThreadItem_3002Parser();
		}
		return threadItem_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createThreadItem_3002Parser() {
		EAttribute[] features = new EAttribute[] { MindmapPackage.eINSTANCE
				.getThreadItem_Body(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipLabel_6001Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipLabel_6001Parser() {
		if (relationshipLabel_6001Parser == null) {
			relationshipLabel_6001Parser = createRelationshipLabel_6001Parser();
		}
		return relationshipLabel_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipLabel_6001Parser() {
		EAttribute[] features = new EAttribute[] { MindmapPackage.eINSTANCE
				.getRelationship_Label(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipLabel_6002Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipLabel_6002Parser() {
		if (relationshipLabel_6002Parser == null) {
			relationshipLabel_6002Parser = createRelationshipLabel_6002Parser();
		}
		return relationshipLabel_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipLabel_6002Parser() {
		EAttribute[] features = new EAttribute[] { MindmapPackage.eINSTANCE
				.getRelationship_Label(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser relationshipLabel_6003Parser;

	/**
	 * @generated
	 */
	private IParser getRelationshipLabel_6003Parser() {
		if (relationshipLabel_6003Parser == null) {
			relationshipLabel_6003Parser = createRelationshipLabel_6003Parser();
		}
		return relationshipLabel_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRelationshipLabel_6003Parser() {
		EAttribute[] features = new EAttribute[] { MindmapPackage.eINSTANCE
				.getRelationship_Label(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case TopicNameEditPart.VISUAL_ID:
			return getTopicName_5002Parser();
		case ResourceNameEmailEditPart.VISUAL_ID:
			return getResourceNameEmail_5003Parser();
		case ThreadSubjectEditPart.VISUAL_ID:
			return getThreadSubject_5001Parser();
		case ThreadItemEditPart.VISUAL_ID:
			return getThreadItem_3002Parser();
		case RelationshipLabelEditPart.VISUAL_ID:
			return getRelationshipLabel_6001Parser();
		case RelationshipLabel2EditPart.VISUAL_ID:
			return getRelationshipLabel_6002Parser();
		case RelationshipLabel3EditPart.VISUAL_ID:
			return getRelationshipLabel_6003Parser();
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

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}
