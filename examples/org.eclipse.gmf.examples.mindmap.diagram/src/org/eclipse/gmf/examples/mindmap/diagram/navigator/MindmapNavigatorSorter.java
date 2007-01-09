package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class MindmapNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5004;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 5002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof MindmapNavigatorItem) {
			MindmapNavigatorItem item = (MindmapNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return MindmapVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
