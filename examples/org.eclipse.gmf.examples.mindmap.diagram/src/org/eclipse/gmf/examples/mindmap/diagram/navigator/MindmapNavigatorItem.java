package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapNavigatorItem extends MindmapAbstractNavigatorItem {

	/**
	 * @generated
	 */
	private View myView;

	/**
	 * @generated
	 */
	public MindmapNavigatorItem(View view, Object parent) {
		super(parent);
		myView = view;
	}

	/**
	 * @generated
	 */
	public View getView() {
		return myView;
	}

	/**
	 * @generated
	 */
	public String getModelID() {
		return MindmapVisualIDRegistry.getModelID(myView);
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return MindmapVisualIDRegistry.getVisualID(myView);
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class adapter) {
		if (View.class.isAssignableFrom(adapter)
				|| EObject.class.isAssignableFrom(adapter)) {
			return myView;
		}
		return super.getAdapter(adapter);
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj instanceof MindmapNavigatorItem) {
			EObject eObject = getView().getElement();
			EObject anotherEObject = ((MindmapNavigatorItem) obj).getView()
					.getElement();
			if (eObject == null) {
				return anotherEObject == null;
			} else if (anotherEObject == null) {
				return false;
			}
			return eObject.eResource().getURIFragment(eObject).equals(
					anotherEObject.eResource().getURIFragment(anotherEObject));
		}
		return super.equals(obj);
	}

}
