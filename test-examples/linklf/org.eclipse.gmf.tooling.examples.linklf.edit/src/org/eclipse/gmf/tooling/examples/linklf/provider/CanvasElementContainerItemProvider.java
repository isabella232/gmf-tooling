/**
 */
package org.eclipse.gmf.tooling.examples.linklf.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer;
import org.eclipse.gmf.tooling.examples.linklf.LinklfFactory;
import org.eclipse.gmf.tooling.examples.linklf.LinklfPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.gmf.tooling.examples.linklf.CanvasElementContainer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CanvasElementContainerItemProvider extends CanvasElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CanvasElementContainerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CanvasElementContainer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CanvasElementContainer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_CanvasElementContainer_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CanvasElementContainer.class)) {
			case LinklfPackage.CANVAS_ELEMENT_CONTAINER__ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createCanvasElement()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createCanvasElementContainer()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createCanvas()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createContainer()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createRectangle()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createCircle()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createRhombus()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createLink()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createLabeledLink()));

		newChildDescriptors.add
			(createChildParameter
				(LinklfPackage.Literals.CANVAS_ELEMENT_CONTAINER__ELEMENTS,
				 LinklfFactory.eINSTANCE.createPort()));
	}

}
