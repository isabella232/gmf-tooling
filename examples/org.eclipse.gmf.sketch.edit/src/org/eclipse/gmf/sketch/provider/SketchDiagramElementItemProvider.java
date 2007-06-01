/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.sketch.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.gmf.sketch.SketchDiagram;
import org.eclipse.gmf.sketch.SketchDiagramElement;
import org.eclipse.gmf.sketch.SketchPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.gmf.sketch.SketchDiagramElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SketchDiagramElementItemProvider extends SketchElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SketchDiagramElementItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addShapePropertyDescriptor(object);
			addVisualIDPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchDiagramElement_name_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchDiagramElement_name_feature", "_UI_SketchDiagramElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_DIAGRAM_ELEMENT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Shape feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShapePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchDiagramElement_shape_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchDiagramElement_shape_feature", "_UI_SketchDiagramElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_DIAGRAM_ELEMENT__SHAPE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Visual ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisualIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_SketchDiagramElement_visualID_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SketchDiagramElement_visualID_feature", "_UI_SketchDiagramElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				SketchPackage.Literals.SKETCH_DIAGRAM_ELEMENT__VISUAL_ID, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextGen(Object object) {
		String label = ((SketchDiagramElement) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_SketchDiagramElement_type") : //$NON-NLS-1$
				getString("_UI_SketchDiagramElement_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public String getText(Object object) {
		String text = getTextGen(object) + " ["; //$NON-NLS-1$
		EClass type = ((SketchDiagram) object).getType();
		if (type != null) {
			text += type.getName();
		}
		return text + "] " + ((SketchDiagram) object).getVisualID(); //$NON-NLS-1$
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

		switch (notification.getFeatureID(SketchDiagramElement.class)) {
		case SketchPackage.SKETCH_DIAGRAM_ELEMENT__NAME:
		case SketchPackage.SKETCH_DIAGRAM_ELEMENT__SHAPE:
		case SketchPackage.SKETCH_DIAGRAM_ELEMENT__VISUAL_ID:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SketchEditPlugin.INSTANCE;
	}

}
