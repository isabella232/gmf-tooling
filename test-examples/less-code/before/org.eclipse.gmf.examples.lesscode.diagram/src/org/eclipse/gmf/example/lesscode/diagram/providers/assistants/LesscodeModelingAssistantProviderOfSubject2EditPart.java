package org.eclipse.gmf.example.lesscode.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeModelingAssistantProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class LesscodeModelingAssistantProviderOfSubject2EditPart extends LesscodeModelingAssistantProvider {

	/**
	     * @generated
	     */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((Subject2EditPart) sourceEditPart);
	}

	/**
	     * @generated
	     */
	public List<IElementType> doGetRelTypesOnSource(Subject2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(LesscodeElementTypes.ElementBasedLink_4001);
		types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		return types;
	}

	/**
	     * @generated
	     */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((Subject2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	     * @generated
	     */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(Subject2EditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof SubjectEditPart) {
			types.add(LesscodeElementTypes.ElementBasedLink_4001);
		}
		if (targetEditPart instanceof Subject2EditPart) {
			types.add(LesscodeElementTypes.ElementBasedLink_4001);
		}
		if (targetEditPart instanceof Subject3EditPart) {
			types.add(LesscodeElementTypes.ElementBasedLink_4001);
		}
		if (targetEditPart instanceof Subject4EditPart) {
			types.add(LesscodeElementTypes.ElementBasedLink_4001);
		}
		if (targetEditPart instanceof Subject5EditPart) {
			types.add(LesscodeElementTypes.ElementBasedLink_4001);
		}
		if (targetEditPart instanceof SubjectEditPart) {
			types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		}
		if (targetEditPart instanceof Subject2EditPart) {
			types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		}
		if (targetEditPart instanceof Subject3EditPart) {
			types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		}
		if (targetEditPart instanceof Subject4EditPart) {
			types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		}
		if (targetEditPart instanceof Subject5EditPart) {
			types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		}
		return types;
	}

	/**
	     * @generated
	     */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((Subject2EditPart) sourceEditPart, relationshipType);
	}

	/**
	     * @generated
	     */
	public List<IElementType> doGetTypesForTarget(Subject2EditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == LesscodeElementTypes.ElementBasedLink_4001) {
			types.add(LesscodeElementTypes.Subject_2001);
			types.add(LesscodeElementTypes.Subject_3001);
			types.add(LesscodeElementTypes.Subject_3002);
			types.add(LesscodeElementTypes.Subject_3003);
			types.add(LesscodeElementTypes.Subject_3004);
		} else if (relationshipType == LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002) {
			types.add(LesscodeElementTypes.Subject_2001);
			types.add(LesscodeElementTypes.Subject_3001);
			types.add(LesscodeElementTypes.Subject_3002);
			types.add(LesscodeElementTypes.Subject_3003);
			types.add(LesscodeElementTypes.Subject_3004);
		}
		return types;
	}

	/**
	   * @generated
	   */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((Subject2EditPart) targetEditPart);
	}

	/**
	   * @generated
	   */
	public List<IElementType> doGetRelTypesOnTarget(Subject2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(LesscodeElementTypes.ElementBasedLink_4001);
		types.add(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
		return types;
	}

	/**
	   * @generated
	   */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((Subject2EditPart) targetEditPart, relationshipType);
	}

	/**
	   * @generated
	   */
	public List<IElementType> doGetTypesForSource(Subject2EditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == LesscodeElementTypes.ElementBasedLink_4001) {
			types.add(LesscodeElementTypes.Subject_2001);
			types.add(LesscodeElementTypes.Subject_3001);
			types.add(LesscodeElementTypes.Subject_3002);
			types.add(LesscodeElementTypes.Subject_3003);
			types.add(LesscodeElementTypes.Subject_3004);
		} else if (relationshipType == LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002) {
			types.add(LesscodeElementTypes.Subject_2001);
			types.add(LesscodeElementTypes.Subject_3001);
			types.add(LesscodeElementTypes.Subject_3002);
			types.add(LesscodeElementTypes.Subject_3003);
			types.add(LesscodeElementTypes.Subject_3004);
		}
		return types;
	}

}
