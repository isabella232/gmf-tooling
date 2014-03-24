/**
 */
package org.eclipse.gmf.tooling.examples.labels.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gmf.tooling.examples.labels.AllLabelsType;
import org.eclipse.gmf.tooling.examples.labels.LabelsPackage;
import org.eclipse.gmf.tooling.examples.labels.Side;
import org.eclipse.gmf.tooling.examples.labels.VerticalLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All Labels Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getBigDecimal <em>Big Decimal</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getBigInteger <em>Big Integer</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#isBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getBooleanObject <em>Boolean Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getByte <em>Byte</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getByteObject <em>Byte Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getChar <em>Char</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getCharacterObject <em>Character Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getDouble <em>Double</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getDoubleObject <em>Double Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getFloat <em>Float</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getFloatObject <em>Float Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getInt <em>Int</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getIntegerObject <em>Integer Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getLong <em>Long</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getLongObject <em>Long Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getShort <em>Short</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getShortObject <em>Short Object</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getSide <em>Side</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.examples.labels.impl.AllLabelsTypeImpl#getFeatureVerticalLabelLinks <em>Feature Vertical Label Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllLabelsTypeImpl extends NamedElementImpl implements AllLabelsType {
	/**
	 * The default value of the '{@link #getBigDecimal() <em>Big Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal BIG_DECIMAL_EDEFAULT = new BigDecimal("0");

	/**
	 * The cached value of the '{@link #getBigDecimal() <em>Big Decimal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal bigDecimal = BIG_DECIMAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigInteger() <em>Big Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigInteger()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger BIG_INTEGER_EDEFAULT = new BigInteger("311");

	/**
	 * The cached value of the '{@link #getBigInteger() <em>Big Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBigInteger()
	 * @generated
	 * @ordered
	 */
	protected BigInteger bigInteger = BIG_INTEGER_EDEFAULT;

	/**
	 * The default value of the '{@link #isBoolean() <em>Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBoolean() <em>Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoolean()
	 * @generated
	 * @ordered
	 */
	protected boolean boolean_ = BOOLEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getBooleanObject() <em>Boolean Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanObject()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean BOOLEAN_OBJECT_EDEFAULT = Boolean.TRUE;

	/**
	 * The cached value of the '{@link #getBooleanObject() <em>Boolean Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanObject()
	 * @generated
	 * @ordered
	 */
	protected Boolean booleanObject = BOOLEAN_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getByte() <em>Byte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getByte()
	 * @generated
	 * @ordered
	 */
	protected static final byte BYTE_EDEFAULT = 0x01;

	/**
	 * The cached value of the '{@link #getByte() <em>Byte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getByte()
	 * @generated
	 * @ordered
	 */
	protected byte byte_ = BYTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getByteObject() <em>Byte Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getByteObject()
	 * @generated
	 * @ordered
	 */
	protected static final Byte BYTE_OBJECT_EDEFAULT = new Byte((byte)0x2a);

	/**
	 * The cached value of the '{@link #getByteObject() <em>Byte Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getByteObject()
	 * @generated
	 * @ordered
	 */
	protected Byte byteObject = BYTE_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getChar() <em>Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChar()
	 * @generated
	 * @ordered
	 */
	protected static final char CHAR_EDEFAULT = '{';

	/**
	 * The cached value of the '{@link #getChar() <em>Char</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChar()
	 * @generated
	 * @ordered
	 */
	protected char char_ = CHAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharacterObject() <em>Character Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterObject()
	 * @generated
	 * @ordered
	 */
	protected static final Character CHARACTER_OBJECT_EDEFAULT = new Character('}');

	/**
	 * The cached value of the '{@link #getCharacterObject() <em>Character Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterObject()
	 * @generated
	 * @ordered
	 */
	protected Character characterObject = CHARACTER_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDouble() <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDouble()
	 * @generated
	 * @ordered
	 */
	protected static final double DOUBLE_EDEFAULT = 42.42;

	/**
	 * The cached value of the '{@link #getDouble() <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDouble()
	 * @generated
	 * @ordered
	 */
	protected double double_ = DOUBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDoubleObject() <em>Double Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleObject()
	 * @generated
	 * @ordered
	 */
	protected static final Double DOUBLE_OBJECT_EDEFAULT = new Double(42.42);

	/**
	 * The cached value of the '{@link #getDoubleObject() <em>Double Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleObject()
	 * @generated
	 * @ordered
	 */
	protected Double doubleObject = DOUBLE_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFloat() <em>Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloat()
	 * @generated
	 * @ordered
	 */
	protected static final float FLOAT_EDEFAULT = 24.24F;

	/**
	 * The cached value of the '{@link #getFloat() <em>Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloat()
	 * @generated
	 * @ordered
	 */
	protected float float_ = FLOAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFloatObject() <em>Float Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatObject()
	 * @generated
	 * @ordered
	 */
	protected static final Float FLOAT_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFloatObject() <em>Float Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatObject()
	 * @generated
	 * @ordered
	 */
	protected Float floatObject = FLOAT_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInt() <em>Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInt()
	 * @generated
	 * @ordered
	 */
	protected static final int INT_EDEFAULT = 36535;

	/**
	 * The cached value of the '{@link #getInt() <em>Int</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInt()
	 * @generated
	 * @ordered
	 */
	protected int int_ = INT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntegerObject() <em>Integer Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerObject()
	 * @generated
	 * @ordered
	 */
	protected static final Integer INTEGER_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIntegerObject() <em>Integer Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerObject()
	 * @generated
	 * @ordered
	 */
	protected Integer integerObject = INTEGER_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLong() <em>Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLong()
	 * @generated
	 * @ordered
	 */
	protected static final long LONG_EDEFAULT = 424242L;

	/**
	 * The cached value of the '{@link #getLong() <em>Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLong()
	 * @generated
	 * @ordered
	 */
	protected long long_ = LONG_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongObject() <em>Long Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongObject()
	 * @generated
	 * @ordered
	 */
	protected static final Long LONG_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongObject() <em>Long Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongObject()
	 * @generated
	 * @ordered
	 */
	protected Long longObject = LONG_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getShort() <em>Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShort()
	 * @generated
	 * @ordered
	 */
	protected static final short SHORT_EDEFAULT = 13;

	/**
	 * The cached value of the '{@link #getShort() <em>Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShort()
	 * @generated
	 * @ordered
	 */
	protected short short_ = SHORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getShortObject() <em>Short Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortObject()
	 * @generated
	 * @ordered
	 */
	protected static final Short SHORT_OBJECT_EDEFAULT = new Short((short)42);

	/**
	 * The cached value of the '{@link #getShortObject() <em>Short Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortObject()
	 * @generated
	 * @ordered
	 */
	protected Short shortObject = SHORT_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getString() <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_EDEFAULT = "Hello!";

	/**
	 * The cached value of the '{@link #getString() <em>String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getString()
	 * @generated
	 * @ordered
	 */
	protected String string = STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSide() <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSide()
	 * @generated
	 * @ordered
	 */
	protected static final Side SIDE_EDEFAULT = Side.LEFT;

	/**
	 * The cached value of the '{@link #getSide() <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSide()
	 * @generated
	 * @ordered
	 */
	protected Side side = SIDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureVerticalLabelLinks() <em>Feature Vertical Label Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureVerticalLabelLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<VerticalLabel> featureVerticalLabelLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllLabelsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LabelsPackage.Literals.ALL_LABELS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigDecimal(BigDecimal newBigDecimal) {
		BigDecimal oldBigDecimal = bigDecimal;
		bigDecimal = newBigDecimal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__BIG_DECIMAL, oldBigDecimal, bigDecimal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getBigInteger() {
		return bigInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigInteger(BigInteger newBigInteger) {
		BigInteger oldBigInteger = bigInteger;
		bigInteger = newBigInteger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__BIG_INTEGER, oldBigInteger, bigInteger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBoolean() {
		return boolean_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoolean(boolean newBoolean) {
		boolean oldBoolean = boolean_;
		boolean_ = newBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__BOOLEAN, oldBoolean, boolean_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getBooleanObject() {
		return booleanObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanObject(Boolean newBooleanObject) {
		Boolean oldBooleanObject = booleanObject;
		booleanObject = newBooleanObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__BOOLEAN_OBJECT, oldBooleanObject, booleanObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte getByte() {
		return byte_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setByte(byte newByte) {
		byte oldByte = byte_;
		byte_ = newByte;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__BYTE, oldByte, byte_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Byte getByteObject() {
		return byteObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setByteObject(Byte newByteObject) {
		Byte oldByteObject = byteObject;
		byteObject = newByteObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__BYTE_OBJECT, oldByteObject, byteObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getChar() {
		return char_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChar(char newChar) {
		char oldChar = char_;
		char_ = newChar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__CHAR, oldChar, char_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Character getCharacterObject() {
		return characterObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterObject(Character newCharacterObject) {
		Character oldCharacterObject = characterObject;
		characterObject = newCharacterObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__CHARACTER_OBJECT, oldCharacterObject, characterObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDouble() {
		return double_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDouble(double newDouble) {
		double oldDouble = double_;
		double_ = newDouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__DOUBLE, oldDouble, double_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getDoubleObject() {
		return doubleObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoubleObject(Double newDoubleObject) {
		Double oldDoubleObject = doubleObject;
		doubleObject = newDoubleObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__DOUBLE_OBJECT, oldDoubleObject, doubleObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFloat() {
		return float_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFloat(float newFloat) {
		float oldFloat = float_;
		float_ = newFloat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__FLOAT, oldFloat, float_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getFloatObject() {
		return floatObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFloatObject(Float newFloatObject) {
		Float oldFloatObject = floatObject;
		floatObject = newFloatObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__FLOAT_OBJECT, oldFloatObject, floatObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInt() {
		return int_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInt(int newInt) {
		int oldInt = int_;
		int_ = newInt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__INT, oldInt, int_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getIntegerObject() {
		return integerObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerObject(Integer newIntegerObject) {
		Integer oldIntegerObject = integerObject;
		integerObject = newIntegerObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__INTEGER_OBJECT, oldIntegerObject, integerObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLong() {
		return long_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLong(long newLong) {
		long oldLong = long_;
		long_ = newLong;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__LONG, oldLong, long_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getLongObject() {
		return longObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongObject(Long newLongObject) {
		Long oldLongObject = longObject;
		longObject = newLongObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__LONG_OBJECT, oldLongObject, longObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getShort() {
		return short_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShort(short newShort) {
		short oldShort = short_;
		short_ = newShort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__SHORT, oldShort, short_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short getShortObject() {
		return shortObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortObject(Short newShortObject) {
		Short oldShortObject = shortObject;
		shortObject = newShortObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__SHORT_OBJECT, oldShortObject, shortObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getString() {
		return string;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setString(String newString) {
		String oldString = string;
		string = newString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__STRING, oldString, string));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Side getSide() {
		return side;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSide(Side newSide) {
		Side oldSide = side;
		side = newSide == null ? SIDE_EDEFAULT : newSide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LabelsPackage.ALL_LABELS_TYPE__SIDE, oldSide, side));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VerticalLabel> getFeatureVerticalLabelLinks() {
		if (featureVerticalLabelLinks == null) {
			featureVerticalLabelLinks = new EObjectResolvingEList<VerticalLabel>(VerticalLabel.class, this, LabelsPackage.ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS);
		}
		return featureVerticalLabelLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LabelsPackage.ALL_LABELS_TYPE__BIG_DECIMAL:
				return getBigDecimal();
			case LabelsPackage.ALL_LABELS_TYPE__BIG_INTEGER:
				return getBigInteger();
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN:
				return isBoolean();
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN_OBJECT:
				return getBooleanObject();
			case LabelsPackage.ALL_LABELS_TYPE__BYTE:
				return getByte();
			case LabelsPackage.ALL_LABELS_TYPE__BYTE_OBJECT:
				return getByteObject();
			case LabelsPackage.ALL_LABELS_TYPE__CHAR:
				return getChar();
			case LabelsPackage.ALL_LABELS_TYPE__CHARACTER_OBJECT:
				return getCharacterObject();
			case LabelsPackage.ALL_LABELS_TYPE__DATE:
				return getDate();
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE:
				return getDouble();
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE_OBJECT:
				return getDoubleObject();
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT:
				return getFloat();
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT_OBJECT:
				return getFloatObject();
			case LabelsPackage.ALL_LABELS_TYPE__INT:
				return getInt();
			case LabelsPackage.ALL_LABELS_TYPE__INTEGER_OBJECT:
				return getIntegerObject();
			case LabelsPackage.ALL_LABELS_TYPE__LONG:
				return getLong();
			case LabelsPackage.ALL_LABELS_TYPE__LONG_OBJECT:
				return getLongObject();
			case LabelsPackage.ALL_LABELS_TYPE__SHORT:
				return getShort();
			case LabelsPackage.ALL_LABELS_TYPE__SHORT_OBJECT:
				return getShortObject();
			case LabelsPackage.ALL_LABELS_TYPE__STRING:
				return getString();
			case LabelsPackage.ALL_LABELS_TYPE__SIDE:
				return getSide();
			case LabelsPackage.ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS:
				return getFeatureVerticalLabelLinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LabelsPackage.ALL_LABELS_TYPE__BIG_DECIMAL:
				setBigDecimal((BigDecimal)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BIG_INTEGER:
				setBigInteger((BigInteger)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN:
				setBoolean((Boolean)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN_OBJECT:
				setBooleanObject((Boolean)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BYTE:
				setByte((Byte)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BYTE_OBJECT:
				setByteObject((Byte)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__CHAR:
				setChar((Character)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__CHARACTER_OBJECT:
				setCharacterObject((Character)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__DATE:
				setDate((Date)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE:
				setDouble((Double)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE_OBJECT:
				setDoubleObject((Double)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT:
				setFloat((Float)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT_OBJECT:
				setFloatObject((Float)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__INT:
				setInt((Integer)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__INTEGER_OBJECT:
				setIntegerObject((Integer)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__LONG:
				setLong((Long)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__LONG_OBJECT:
				setLongObject((Long)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__SHORT:
				setShort((Short)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__SHORT_OBJECT:
				setShortObject((Short)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__STRING:
				setString((String)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__SIDE:
				setSide((Side)newValue);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS:
				getFeatureVerticalLabelLinks().clear();
				getFeatureVerticalLabelLinks().addAll((Collection<? extends VerticalLabel>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LabelsPackage.ALL_LABELS_TYPE__BIG_DECIMAL:
				setBigDecimal(BIG_DECIMAL_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BIG_INTEGER:
				setBigInteger(BIG_INTEGER_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN:
				setBoolean(BOOLEAN_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN_OBJECT:
				setBooleanObject(BOOLEAN_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BYTE:
				setByte(BYTE_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__BYTE_OBJECT:
				setByteObject(BYTE_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__CHAR:
				setChar(CHAR_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__CHARACTER_OBJECT:
				setCharacterObject(CHARACTER_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE:
				setDouble(DOUBLE_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE_OBJECT:
				setDoubleObject(DOUBLE_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT:
				setFloat(FLOAT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT_OBJECT:
				setFloatObject(FLOAT_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__INT:
				setInt(INT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__INTEGER_OBJECT:
				setIntegerObject(INTEGER_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__LONG:
				setLong(LONG_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__LONG_OBJECT:
				setLongObject(LONG_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__SHORT:
				setShort(SHORT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__SHORT_OBJECT:
				setShortObject(SHORT_OBJECT_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__STRING:
				setString(STRING_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__SIDE:
				setSide(SIDE_EDEFAULT);
				return;
			case LabelsPackage.ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS:
				getFeatureVerticalLabelLinks().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LabelsPackage.ALL_LABELS_TYPE__BIG_DECIMAL:
				return BIG_DECIMAL_EDEFAULT == null ? bigDecimal != null : !BIG_DECIMAL_EDEFAULT.equals(bigDecimal);
			case LabelsPackage.ALL_LABELS_TYPE__BIG_INTEGER:
				return BIG_INTEGER_EDEFAULT == null ? bigInteger != null : !BIG_INTEGER_EDEFAULT.equals(bigInteger);
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN:
				return boolean_ != BOOLEAN_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__BOOLEAN_OBJECT:
				return BOOLEAN_OBJECT_EDEFAULT == null ? booleanObject != null : !BOOLEAN_OBJECT_EDEFAULT.equals(booleanObject);
			case LabelsPackage.ALL_LABELS_TYPE__BYTE:
				return byte_ != BYTE_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__BYTE_OBJECT:
				return BYTE_OBJECT_EDEFAULT == null ? byteObject != null : !BYTE_OBJECT_EDEFAULT.equals(byteObject);
			case LabelsPackage.ALL_LABELS_TYPE__CHAR:
				return char_ != CHAR_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__CHARACTER_OBJECT:
				return CHARACTER_OBJECT_EDEFAULT == null ? characterObject != null : !CHARACTER_OBJECT_EDEFAULT.equals(characterObject);
			case LabelsPackage.ALL_LABELS_TYPE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE:
				return double_ != DOUBLE_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__DOUBLE_OBJECT:
				return DOUBLE_OBJECT_EDEFAULT == null ? doubleObject != null : !DOUBLE_OBJECT_EDEFAULT.equals(doubleObject);
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT:
				return float_ != FLOAT_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__FLOAT_OBJECT:
				return FLOAT_OBJECT_EDEFAULT == null ? floatObject != null : !FLOAT_OBJECT_EDEFAULT.equals(floatObject);
			case LabelsPackage.ALL_LABELS_TYPE__INT:
				return int_ != INT_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__INTEGER_OBJECT:
				return INTEGER_OBJECT_EDEFAULT == null ? integerObject != null : !INTEGER_OBJECT_EDEFAULT.equals(integerObject);
			case LabelsPackage.ALL_LABELS_TYPE__LONG:
				return long_ != LONG_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__LONG_OBJECT:
				return LONG_OBJECT_EDEFAULT == null ? longObject != null : !LONG_OBJECT_EDEFAULT.equals(longObject);
			case LabelsPackage.ALL_LABELS_TYPE__SHORT:
				return short_ != SHORT_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__SHORT_OBJECT:
				return SHORT_OBJECT_EDEFAULT == null ? shortObject != null : !SHORT_OBJECT_EDEFAULT.equals(shortObject);
			case LabelsPackage.ALL_LABELS_TYPE__STRING:
				return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
			case LabelsPackage.ALL_LABELS_TYPE__SIDE:
				return side != SIDE_EDEFAULT;
			case LabelsPackage.ALL_LABELS_TYPE__FEATURE_VERTICAL_LABEL_LINKS:
				return featureVerticalLabelLinks != null && !featureVerticalLabelLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (bigDecimal: ");
		result.append(bigDecimal);
		result.append(", bigInteger: ");
		result.append(bigInteger);
		result.append(", boolean: ");
		result.append(boolean_);
		result.append(", booleanObject: ");
		result.append(booleanObject);
		result.append(", byte: ");
		result.append(byte_);
		result.append(", byteObject: ");
		result.append(byteObject);
		result.append(", char: ");
		result.append(char_);
		result.append(", characterObject: ");
		result.append(characterObject);
		result.append(", date: ");
		result.append(date);
		result.append(", double: ");
		result.append(double_);
		result.append(", doubleObject: ");
		result.append(doubleObject);
		result.append(", float: ");
		result.append(float_);
		result.append(", floatObject: ");
		result.append(floatObject);
		result.append(", int: ");
		result.append(int_);
		result.append(", integerObject: ");
		result.append(integerObject);
		result.append(", long: ");
		result.append(long_);
		result.append(", longObject: ");
		result.append(longObject);
		result.append(", short: ");
		result.append(short_);
		result.append(", shortObject: ");
		result.append(shortObject);
		result.append(", string: ");
		result.append(string);
		result.append(", side: ");
		result.append(side);
		result.append(')');
		return result.toString();
	}

} //AllLabelsTypeImpl
