package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEModelingAssistantProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TOEModelingAssistantProviderOfAllHolderEditPart extends TOEModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(TOEElementTypes.Employee_2001);
		types.add(TOEElementTypes.Department_2002);
		types.add(TOEElementTypes.Project_2003);
		types.add(TOEElementTypes.Manager_2004);
		return types;
	}

}
