package org.eclipse.gmf.examples.eclipsecon.library.diagram.navigator;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07VisualIDRegistry;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class Library07NavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof Library07NavigatorItem) {
			Library07NavigatorItem item = (Library07NavigatorItem) element;
			return Library07VisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
