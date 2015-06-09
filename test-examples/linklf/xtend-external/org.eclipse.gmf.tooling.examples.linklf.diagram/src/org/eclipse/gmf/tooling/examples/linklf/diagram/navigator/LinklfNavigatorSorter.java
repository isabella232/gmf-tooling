package org.eclipse.gmf.tooling.examples.linklf.diagram.navigator;

import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class LinklfNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof LinklfNavigatorItem) {
			LinklfNavigatorItem item = (LinklfNavigatorItem) element;
			return LinklfVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
