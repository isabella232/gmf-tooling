package org.eclipse.gmf.tooling.simplemap.diagram.navigator;

import org.eclipse.gmf.tooling.simplemap.diagram.part.SimplemapVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class SimplemapNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2006;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof SimplemapNavigatorItem) {
			SimplemapNavigatorItem item = (SimplemapNavigatorItem) element;
			return SimplemapVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
