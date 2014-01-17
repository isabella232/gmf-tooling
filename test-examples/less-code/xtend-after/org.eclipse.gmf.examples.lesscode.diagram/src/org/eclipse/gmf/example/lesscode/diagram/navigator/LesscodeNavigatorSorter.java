package org.eclipse.gmf.example.lesscode.diagram.navigator;

import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class LesscodeNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7007;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof LesscodeNavigatorItem) {
			LesscodeNavigatorItem item = (LesscodeNavigatorItem) element;
			return LesscodeVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
