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
public class LinklfModelingAssistantProviderOfCanvasEditPart extends LinklfModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(LinklfElementTypes.Circle_2001);
		types.add(LinklfElementTypes.Rectangle_2002);
		types.add(LinklfElementTypes.Container_2003);
		types.add(LinklfElementTypes.Rhombus_2004);
		return types;
	}

}
