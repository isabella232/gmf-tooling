package org.eclipse.gmf.tooling.examples.shortcut.diagram.navigator;

import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ShortcutNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 4002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof ShortcutNavigatorItem) {
			ShortcutNavigatorItem item = (ShortcutNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return ShortcutVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
