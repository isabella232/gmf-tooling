package org.eclipse.gmf.example.lesscode.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeModelingAssistantProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class LesscodeModelingAssistantProviderOfRootContainerEditPart extends LesscodeModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(LesscodeElementTypes.Subject_2001);
		types.add(LesscodeElementTypes.OneContainmentGroup_2002);
		types.add(LesscodeElementTypes.MultiContainmentGroup_2003);
		return types;
	}

}
