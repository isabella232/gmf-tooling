package org.eclipse.gmf.tooling.runtime.parsers;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
			if (Boolean.TYPE.equals(iClass)) {
				if (value instanceof Boolean) {
					// ok
				} else if (value instanceof String) {
					value = Boolean.valueOf((String) value);
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Character.TYPE.equals(iClass)) {
				if (value instanceof Character) {
					// ok
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						value = new Character(s.charAt(0));
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Byte.TYPE.equals(iClass)) {
				if (value instanceof Byte) {
					// ok
				} else if (value instanceof Number) {
					value = new Byte(((Number) value).byteValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Byte.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Short.TYPE.equals(iClass)) {
				if (value instanceof Short) {
					// ok
				} else if (value instanceof Number) {
					value = new Short(((Number) value).shortValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Short.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Integer.TYPE.equals(iClass)) {
				if (value instanceof Integer) {
					// ok
				} else if (value instanceof Number) {
					value = new Integer(((Number) value).intValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Integer.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Long.TYPE.equals(iClass)) {
				if (value instanceof Long) {
					// ok
				} else if (value instanceof Number) {
					value = new Long(((Number) value).longValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Long.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Float.TYPE.equals(iClass)) {
				if (value instanceof Float) {
					// ok
				} else if (value instanceof Number) {
					value = new Float(((Number) value).floatValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Float.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (Double.TYPE.equals(iClass)) {
				if (value instanceof Double) {
					// ok
				} else if (value instanceof Number) {
					value = new Double(((Number) value).doubleValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Double.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, iClass.getName()));
				}
			} else if (type instanceof EEnum) {
				if (value instanceof String) {
					EEnumLiteral literal = ((EEnum) type).getEEnumLiteralByLiteral((String) value);
					if (literal == null) {
						value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnknownLiteral, value));
					} else {
						value = literal.getInstance();
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractAttributeParser_UnexpectedValueType, String.class.getName()));
				}
			}
		}
		return value;
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
