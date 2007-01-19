package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.commands;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.DomainElementInitializer;

import org.eclipse.gmf.runtime.lite.commands.VetoCommand;

import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CreateTopic_Subtopics4001StartCommand extends VetoCommand {
	/**
	 * @generated
	 */
	private View source;

	/**
	 * @generated
	 */
	public CreateTopic_Subtopics4001StartCommand(
			CreateConnectionRequestEx requestEx) {
		//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart().
		source = (View) requestEx.getTargetEditPart().getModel();
	}

	/**
	 * @generated
	 */
	protected boolean shouldExecute() {
		if (source == null) {
			return false;
		}

		if (!DomainElementInitializer.LinkConstraints.TopicSubtopics_4001
				.canCreateLink(source.getElement(), null, false)) {
			return false;
		}
		return true;
	}

}
