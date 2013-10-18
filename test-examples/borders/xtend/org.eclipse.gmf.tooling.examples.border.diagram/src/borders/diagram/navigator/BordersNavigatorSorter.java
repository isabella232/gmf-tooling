package borders.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import borders.diagram.part.BordersVisualIDRegistry;

/**
 * @generated
 */
public class BordersNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2006;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof BordersNavigatorItem) {
			BordersNavigatorItem item = (BordersNavigatorItem) element;
			return BordersVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
