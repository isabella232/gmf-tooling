package org.eclipse.gmf.tooling.examples.linklf.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfElementTypes;
import org.eclipse.gmf.tooling.examples.linklf.diagram.providers.LinklfModelingAssistantProvider;

/**
	 * @generated
	 */
public class LinklfModelingAssistantProviderOfContainerEditPart extends LinklfModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(LinklfElementTypes.Port_3005);
		return types;
	}

}
