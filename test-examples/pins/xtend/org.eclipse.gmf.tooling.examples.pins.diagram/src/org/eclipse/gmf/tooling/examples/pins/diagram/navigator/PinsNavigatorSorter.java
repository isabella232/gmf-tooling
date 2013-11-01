package org.eclipse.gmf.tooling.examples.pins.diagram.navigator;

import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class PinsNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 3005;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof PinsNavigatorItem) {
			PinsNavigatorItem item = (PinsNavigatorItem) element;
			return PinsVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
