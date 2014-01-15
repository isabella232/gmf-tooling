package org.eclipse.gmf.example.lesscode.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class LesscodeEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (LesscodeVisualIDRegistry.getVisualID(view)) {

			case RootContainerEditPart.VISUAL_ID:
				return new RootContainerEditPart(view);

			case SubjectEditPart.VISUAL_ID:
				return new SubjectEditPart(view);

			case SubjectNameEditPart.VISUAL_ID:
				return new SubjectNameEditPart(view);

			case OneContainmentGroupEditPart.VISUAL_ID:
				return new OneContainmentGroupEditPart(view);

			case OneContainmentGroupNameEditPart.VISUAL_ID:
				return new OneContainmentGroupNameEditPart(view);

			case MultiContainmentGroupEditPart.VISUAL_ID:
				return new MultiContainmentGroupEditPart(view);

			case MultiContainmentGroupNameEditPart.VISUAL_ID:
				return new MultiContainmentGroupNameEditPart(view);

			case Subject2EditPart.VISUAL_ID:
				return new Subject2EditPart(view);

			case SubjectName2EditPart.VISUAL_ID:
				return new SubjectName2EditPart(view);

			case Subject3EditPart.VISUAL_ID:
				return new Subject3EditPart(view);

			case SubjectName3EditPart.VISUAL_ID:
				return new SubjectName3EditPart(view);

			case Subject4EditPart.VISUAL_ID:
				return new Subject4EditPart(view);

			case SubjectName4EditPart.VISUAL_ID:
				return new SubjectName4EditPart(view);

			case Subject5EditPart.VISUAL_ID:
				return new Subject5EditPart(view);

			case SubjectName5EditPart.VISUAL_ID:
				return new SubjectName5EditPart(view);

			case SubjectInSubjectEditPart.VISUAL_ID:
				return new SubjectInSubjectEditPart(view);

			case SubjectInSubject2EditPart.VISUAL_ID:
				return new SubjectInSubject2EditPart(view);

			case OneContainmentGroupInGroupOneEditPart.VISUAL_ID:
				return new OneContainmentGroupInGroupOneEditPart(view);

			case SubjectInSubject3EditPart.VISUAL_ID:
				return new SubjectInSubject3EditPart(view);

			case MultiContainmentGroupInGroupManyEditPart.VISUAL_ID:
				return new MultiContainmentGroupInGroupManyEditPart(view);

			case SubjectInSubject4EditPart.VISUAL_ID:
				return new SubjectInSubject4EditPart(view);

			case SubjectInSubject5EditPart.VISUAL_ID:
				return new SubjectInSubject5EditPart(view);

			case ElementBasedLinkEditPart.VISUAL_ID:
				return new ElementBasedLinkEditPart(view);

			case SubjectReferenceBasedLinkTargetEditPart.VISUAL_ID:
				return new SubjectReferenceBasedLinkTargetEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
