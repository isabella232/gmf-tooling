package org.eclipse.gmf.tooling.examples.affixednode.diagram.navigator;

import org.eclipse.gmf.tooling.examples.affixednode.diagram.part.AffixednodeVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
* @generated
*/
public class AffixednodeNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof AffixednodeNavigatorItem) {
			AffixednodeNavigatorItem item = (AffixednodeNavigatorItem) element;
			return AffixednodeVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
