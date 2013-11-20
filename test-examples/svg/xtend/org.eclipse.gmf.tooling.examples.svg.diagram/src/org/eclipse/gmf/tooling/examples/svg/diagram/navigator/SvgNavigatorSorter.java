package org.eclipse.gmf.tooling.examples.svg.diagram.navigator;

import org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class SvgNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof SvgNavigatorItem) {
			SvgNavigatorItem item = (SvgNavigatorItem) element;
			return SvgVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
