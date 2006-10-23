package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class MindmapAbstractNavigatorItem implements IAdaptable {

	/**
	 * @generated
	 */
	private Object myParent;

	/**
	 * @generated
	 */
	protected MindmapAbstractNavigatorItem(Object parent) {
		myParent = parent;
	}

	/**
	 * @generated
	 */
	abstract public String getModelID();

	/**
	 * @generated
	 */
	public Object getParent() {
		return myParent;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {
		if (ITabbedPropertySheetPageContributor.class.isAssignableFrom(adapter)) {
			return new ITabbedPropertySheetPageContributor() {
				public String getContributorId() {
					return "org.eclipse.gmf.examples.mindmap.diagram";
				}
			};
		}
		return null;
	}

}
