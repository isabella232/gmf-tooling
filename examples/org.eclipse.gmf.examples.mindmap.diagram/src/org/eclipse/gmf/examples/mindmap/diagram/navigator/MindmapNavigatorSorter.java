package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class MindmapNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof MindmapNavigatorItem) {
			MindmapNavigatorItem item = (MindmapNavigatorItem) element;
			if (MapEditPart.MODEL_ID.equals(item.getModelID())) {
				return item.getVisualID();
			}
		}
		return GROUP_CATEGORY;
	}

}
