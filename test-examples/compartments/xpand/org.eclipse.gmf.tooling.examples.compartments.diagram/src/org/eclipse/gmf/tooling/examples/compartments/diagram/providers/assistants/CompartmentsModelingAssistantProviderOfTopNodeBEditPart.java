package org.eclipse.gmf.tooling.examples.compartments.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsModelingAssistantProvider;

/**
 * @generated
 */
public class CompartmentsModelingAssistantProviderOfTopNodeBEditPart extends CompartmentsModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(CompartmentsElementTypes.ChildOfB_G_3004);
		types.add(CompartmentsElementTypes.ChildOfB_E_3003);
		types.add(CompartmentsElementTypes.ChildOfB_F_3006);
		return types;
	}

}
