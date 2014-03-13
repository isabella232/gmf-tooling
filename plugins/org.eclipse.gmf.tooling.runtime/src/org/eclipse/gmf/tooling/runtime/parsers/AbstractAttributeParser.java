package org.eclipse.gmf.tooling.runtime.parsers;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.tooling.runtime.Messages;
import org.eclipse.osgi.util.NLS;

public abstract class AbstractAttributeParser extends AbstractFeatureParser {

	private String viewPattern;

	private String editorPattern;

	private String editPattern;

	protected final EAttribute[] features;

	protected final EAttribute[] editableFeatures;

	public AbstractAttributeParser(EAttribute[] features) {
		super(features);
		this.features = this.editableFeatures = features;
	}

	public AbstractAttributeParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
		this.features = features;
		this.editableFeatures = editableFeatures;
	}

	@Override
	protected Object getValue(EObject element, EStructuralFeature feature) {
		Object value = super.getValue(element, feature);
		Class<?> iClass = ((EAttribute) feature).getEAttributeType().getInstanceClass();
		if (String.class.equals(iClass)) {
			if (value == null) {
				value = ""; //$NON-NLS-1$
			}
		}
		return value;
	}

	@Override
	protected Object getValidNewValue(EStructuralFeature feature, Object value) {
		EClassifier type = feature.getEType();
		if (type instanceof EDataType) {
			Class<?> iClass = type.getInstanceClass();
			if ( value instanceof String && !(type instanceof EEnum) ) {
				try {
					value = EcoreFactory.eINSTANCE.createFromString((EDataType)type, (String)value);
				} catch (Exception e) {
					value = wrapException(iClass, value, e);
				}
			} else if (Boolean.TYPE.equals(iClass) || Boolean.class.equals(iClass)) {
				if ((!(value instanceof Boolean)) && !(Boolean.class.equals(iClass) && value == null)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Character.TYPE.equals(iClass) || Character.class.equals(iClass)) {
				if (!(value instanceof Character) && !(Character.class.equals(iClass) && value == null)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Byte.TYPE.equals(iClass) || Byte.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new Byte(((Number) value).byteValue());
				} else if (value != null || !Byte.class.equals(iClass)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Short.TYPE.equals(iClass) || Short.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new Short(((Number) value).shortValue());
				} else if (value != null || !Short.class.equals(iClass)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Integer.TYPE.equals(iClass) || Integer.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new Integer(((Number) value).intValue());
				} else if (value != null || !Integer.class.equals(iClass)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Long.TYPE.equals(iClass) || Long.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new Long(((Number) value).longValue());
				} else if (value != null || !Long.class.equals(iClass)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Float.TYPE.equals(iClass) || Float.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new Float(((Number) value).floatValue());
				} else if (value != null || !Float.class.equals(iClass)) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Double.TYPE.equals(iClass) || Double.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new Double(((Number) value).doubleValue());
				} else if (value != null || !Double.class.equals(iClass)) { 
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (type instanceof EEnum) {
				EEnumLiteral literal = null;
				if (value instanceof String) {
					literal= ((EEnum) type).getEEnumLiteralByLiteral((String) value);
				} else if (value instanceof Number) {
					literal = ((EEnum) type).getEEnumLiteral(((Number) value).intValue());
				} else if (value instanceof Enumerator){
					literal = ((EEnum) type).getEEnumLiteral(((Enumerator)value).getValue());
				}
				if (literal == null) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnknownLiteral, value));
				} else {
					value = literal.getInstance();
				}
			} else if (Date.class.equals(iClass)) {
				if (!(value instanceof Date) && value != null) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, String.class.getName()));
				}
			} else if (BigDecimal.class.equals(iClass)) {
				if (value instanceof Number) {
					value = new BigDecimal(((Number) value).doubleValue());
				} else if (value != null) {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, String.class.getName()));
				} 
			}
		}
		return value;
	}

	private InvalidValue wrapException(Class<?> className, Object value, Throwable e) {
		return new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType 
				+ ", " + e.getMessage(), className));
	}
	
	public String getViewPattern() {
		return viewPattern;
	}

	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
	}

	public String getEditorPattern() {
		return editorPattern;
	}

	public void setEditorPattern(String editorPattern) {
		this.editorPattern = editorPattern;
	}

	public String getEditPattern() {
		return editPattern;
	}

	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
	}
}
