package org.eclipse.gmf.examples.ocldriven.toe.diagram.navigator;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
* @generated
*/
public class TOENavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7004;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof TOENavigatorItem) {
			TOENavigatorItem item = (TOENavigatorItem) element;
			return TOEVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
