package org.eclipse.gmf.tooling.examples.compartments.diagram.navigator;

import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
* @generated
*/
public class CompartmentsNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7007;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof CompartmentsNavigatorItem) {
			CompartmentsNavigatorItem item = (CompartmentsNavigatorItem) element;
			return CompartmentsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
