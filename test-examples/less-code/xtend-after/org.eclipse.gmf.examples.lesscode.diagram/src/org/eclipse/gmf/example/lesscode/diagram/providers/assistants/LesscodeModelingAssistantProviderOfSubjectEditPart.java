package org.eclipse.gmf.example.lesscode.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeModelingAssistantProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class LesscodeModelingAssistantProviderOfSubjectEditPart extends LesscodeModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((SubjectEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(SubjectEditPart source) {
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
		return doGetRelTypesOnSourceAndTarget((SubjectEditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(SubjectEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof SubjectEditPart) {
			types.add(LesscodeElementTypes.ElementBasedLink_4001);
		}
		if (targetEditPart instanceof SubjectEditPart) {
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
		return doGetTypesForTarget((SubjectEditPart) sourceEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(SubjectEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == LesscodeElementTypes.ElementBasedLink_4001) {
			types.add(LesscodeElementTypes.Subject_2001);
		} else if (relationshipType == LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002) {
			types.add(LesscodeElementTypes.Subject_2001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((SubjectEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(SubjectEditPart target) {
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
		return doGetTypesForSource((SubjectEditPart) targetEditPart, relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(SubjectEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == LesscodeElementTypes.ElementBasedLink_4001) {
			types.add(LesscodeElementTypes.Subject_2001);
		} else if (relationshipType == LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002) {
			types.add(LesscodeElementTypes.Subject_2001);
		}
		return types;
	}

}
