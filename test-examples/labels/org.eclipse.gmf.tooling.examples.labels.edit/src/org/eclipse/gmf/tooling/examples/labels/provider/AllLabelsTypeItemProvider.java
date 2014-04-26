/**
 */
package org.eclipse.gmf.tooling.examples.labels.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.gmf.tooling.examples.labels.AllLabelsType;
import org.eclipse.gmf.tooling.examples.labels.LabelsPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.gmf.tooling.examples.labels.AllLabelsType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AllLabelsTypeItemProvider
	extends NamedElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllLabelsTypeItemProvider(AdapterFactory adapterFactory) {
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

			addBigDecimalPropertyDescriptor(object);
			addBigIntegerPropertyDescriptor(object);
			addBooleanPropertyDescriptor(object);
			addBooleanObjectPropertyDescriptor(object);
			addBytePropertyDescriptor(object);
			addByteObjectPropertyDescriptor(object);
			addCharPropertyDescriptor(object);
			addCharacterObjectPropertyDescriptor(object);
			addDatePropertyDescriptor(object);
			addDoublePropertyDescriptor(object);
			addDoubleObjectPropertyDescriptor(object);
			addFloatPropertyDescriptor(object);
			addFloatObjectPropertyDescriptor(object);
			addIntPropertyDescriptor(object);
			addIntegerObjectPropertyDescriptor(object);
			addLongPropertyDescriptor(object);
			addLongObjectPropertyDescriptor(object);
			addShortPropertyDescriptor(object);
			addShortObjectPropertyDescriptor(object);
			addStringPropertyDescriptor(object);
			addSidePropertyDescriptor(object);
			addDataTypedPropertyDescriptor(object);
			addFeatureVerticalLabelLinksPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Big Decimal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBigDecimalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_bigDecimal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_bigDecimal_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__BIG_DECIMAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Big Integer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBigIntegerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_bigInteger_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_bigInteger_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__BIG_INTEGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Boolean feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBooleanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_boolean_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_boolean_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__BOOLEAN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Boolean Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBooleanObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_booleanObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_booleanObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__BOOLEAN_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Byte feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBytePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_byte_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_byte_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__BYTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Byte Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addByteObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_byteObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_byteObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__BYTE_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Char feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCharPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_char_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_char_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__CHAR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Character Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCharacterObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_characterObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_characterObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__CHARACTER_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_date_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_date_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Double feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDoublePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_double_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_double_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__DOUBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Double Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDoubleObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_doubleObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_doubleObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__DOUBLE_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Float feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFloatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_float_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_float_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__FLOAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Float Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFloatObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_floatObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_floatObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__FLOAT_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Int feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_int_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_int_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__INT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Integer Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIntegerObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_integerObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_integerObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__INTEGER_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Long feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLongPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_long_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_long_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__LONG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Long Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLongObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_longObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_longObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__LONG_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Short feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_short_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_short_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__SHORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Short Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShortObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_shortObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_shortObject_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__SHORT_OBJECT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_string_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_string_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__STRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Side feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSidePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_side_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_side_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__SIDE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Data Typed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataTypedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_dataTyped_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_dataTyped_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__DATA_TYPED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Feature Vertical Label Links feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeatureVerticalLabelLinksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AllLabelsType_featureVerticalLabelLinks_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AllLabelsType_featureVerticalLabelLinks_feature", "_UI_AllLabelsType_type"),
				 LabelsPackage.Literals.ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns AllLabelsType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AllLabelsType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AllLabelsType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AllLabelsType_type") :
			getString("_UI_AllLabelsType_type") + " " + label;
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

		switch (notification.getFeatureID(AllLabelsType.class)) {
			case LabelsPackage.ALL_LABELS_TYPE__BIG_DECIMAL:
			case LabelsPackage.ALL_LABELS_TYPE__BIG_INTEGER:
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN:
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__BYTE:
			case LabelsPackage.ALL_LABELS_TYPE__BYTE_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__CHAR:
			case LabelsPackage.ALL_LABELS_TYPE__CHARACTER_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__DATE:
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE:
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT:
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__INT:
			case LabelsPackage.ALL_LABELS_TYPE__INTEGER_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__LONG:
			case LabelsPackage.ALL_LABELS_TYPE__LONG_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__SHORT:
			case LabelsPackage.ALL_LABELS_TYPE__SHORT_OBJECT:
			case LabelsPackage.ALL_LABELS_TYPE__STRING:
			case LabelsPackage.ALL_LABELS_TYPE__SIDE:
			case LabelsPackage.ALL_LABELS_TYPE__DATA_TYPED:
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

}
