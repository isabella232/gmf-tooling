/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.tests.expression.ast;

import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.Variable;

/**
 * FIXME replace with plugable operations 
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ATypeModel {
    static final String OPERATION_NAME = "myOperation";
	static final String TEST_ATTR = "test";
	public static final String ENUM_ATTR = "myEnum";
	static final int LITERAL_VALUE = 18;
	public static final String LITERAL1_NAME = "A_LITERAL";
	public static final String LITERAL2_NAME = "B_LITERAL";
	public static final String ENUM_TYPE_NAME = "Type1";
	static final String EVALUATION_TEST_MODEL = "evaluationTestModel";

	private final EClass aTypeClass;
	private final EClass aTypeBClass;
	private final EClass aTypeCClass;
	private final EObject aTypeInstance;

	@SuppressWarnings("unchecked")
	public ATypeModel() {
    	final EPackage evaluationTestModel = EcoreFactory.eINSTANCE.createEPackage();
    	evaluationTestModel.setName(EVALUATION_TEST_MODEL);
    	evaluationTestModel.setNsURI("uri:evaluationTestModel");
    	EEnum type1 = EcoreFactory.eINSTANCE.createEEnum();
    	type1.setName(ENUM_TYPE_NAME);
    	evaluationTestModel.getEClassifiers().add(type1);
    	EEnumLiteral literal1 = EcoreFactory.eINSTANCE.createEEnumLiteral();
    	literal1.setName(LITERAL1_NAME);
    	literal1.setValue(LITERAL_VALUE);
    	literal1.setLiteral("TEST");
    	type1.getELiterals().add(literal1);
    	EEnumLiteral literal2 = EcoreFactory.eINSTANCE.createEEnumLiteral();
    	literal2.setName(LITERAL2_NAME);
    	literal2.setValue(11);
    	literal2.setLiteral("literal2-literal");
    	type1.getELiterals().add(literal2);

    	aTypeCClass = EcoreFactory.eINSTANCE.createEClass();
    	aTypeCClass.setName("TypeC");
    	aTypeCClass.setInterface(true);
    	aTypeBClass = EcoreFactory.eINSTANCE.createEClass();
    	aTypeBClass.setName("TypeB");
    	evaluationTestModel.getEClassifiers().add(aTypeBClass);
    	evaluationTestModel.getEClassifiers().add(aTypeCClass);

    	aTypeClass = EcoreFactory.eINSTANCE.createEClass();
    	aTypeClass.setName("TypeA");
    	aTypeBClass.getESuperTypes().add(aTypeClass);// TypeB extends TypeA ...
    	aTypeBClass.getESuperTypes().add(aTypeCClass);// ... implements TypeC
    	evaluationTestModel.getEClassifiers().add(aTypeClass);

    	EAttribute aTypeTestAttr = EcoreFactory.eINSTANCE.createEAttribute();
    	aTypeTestAttr.setName(TEST_ATTR);
    	aTypeTestAttr.setEType(EcorePackage.eINSTANCE.getEString());
    	aTypeTestAttr.setDefaultValueLiteral("myTestProp");
    	aTypeClass.getEStructuralFeatures().add(aTypeTestAttr);
    	EAttribute aTypeEnumAttr = EcoreFactory.eINSTANCE.createEAttribute();
    	aTypeEnumAttr.setName(ENUM_ATTR);
    	aTypeEnumAttr.setEType(type1);
    	aTypeEnumAttr.setDefaultValue(literal1);
    	aTypeClass.getEStructuralFeatures().add(aTypeEnumAttr);

    	EOperation op1 = EcoreFactory.eINSTANCE.createEOperation();
    	op1.setName(OPERATION_NAME);
    	op1.setEType(EcorePackage.eINSTANCE.getEString());
    	aTypeClass.getEOperations().add(op1);
    	EOperation op2 = EcoreFactory.eINSTANCE.createEOperation();
    	op2.setName(OPERATION_NAME);
    	op2.setEType(EcorePackage.eINSTANCE.getEIntegerObject());
    	EParameter p1 = EcoreFactory.eINSTANCE.createEParameter();
    	p1.setEType(EcorePackage.eINSTANCE.getEString());
    	p1.setName("param");
    	op2.getEParameters().add(p1);
    	aTypeClass.getEOperations().add(op2);
    	aTypeInstance = evaluationTestModel.getEFactoryInstance().create(aTypeClass);

	}

	public ExecutionContext newContext(ResourceMarker res) {
		return newContext(res, null);
	}

	public ExecutionContext newContext(ResourceMarker res, Variable var) {
		return new ExecutionContextImpl(null, res, var == null ? null : Collections.singleton(var), null) {
        	protected EPackage[] getAllVisibleModels() {
        		return new EPackage[] {aTypeClass.getEPackage(), EcorePackage.eINSTANCE};
        	}
        };
	}

	public EClass getMetaType() {
		return aTypeClass;
	}

	public EStructuralFeature getTestMetaAttr() {
		return aTypeClass.getEStructuralFeature(TEST_ATTR);
	}

	public EOperation getMetaOp1() {
		return (EOperation) aTypeClass.getEOperations().get(0);
	}

	public EOperation getMetaOp2() {
		return (EOperation) aTypeClass.getEOperations().get(1);
	}

	public Object getInstance() {
		return aTypeInstance;
	}

	public Object getATypeTestFeatureValue() {
		return aTypeInstance.eGet(aTypeClass.getEStructuralFeature(TEST_ATTR));
	}

	public EEnum getMetaEnum() {
		return (EEnum) aTypeClass.getEPackage().getEClassifier(ENUM_TYPE_NAME);
	}
	public void setEnumAttr(String literalName) {
		assert LITERAL1_NAME.equals(literalName) || LITERAL2_NAME.equals(literalName);
		aTypeInstance.eSet(aTypeClass.getEStructuralFeature(ENUM_ATTR), getMetaEnum().getEEnumLiteral(literalName));
	}

	public EClass getMetaTypeC() {
		return aTypeCClass;
	}

	public EClass getMetaTypeB() {
		return aTypeBClass;
	}

	public void registerOperations() {
		try {
			Method m1 = ATypeModel.class.getMethod("myOperation", new Class[0]);
			Method m2 = ATypeModel.class.getMethod("myOperation", new Class[] {String.class});
			BuiltinMetaModel.registerOperationImpl(getMetaOp1(), m1);
			BuiltinMetaModel.registerOperationImpl(getMetaOp2(), m2);
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
	}

	public static String myOperation() {
		return "hallo test";
	}

	public static Integer myOperation(String string) {
		return new Integer(4);
	}
}
