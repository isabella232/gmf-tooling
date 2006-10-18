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
package org.eclipse.gmf.tests.expression;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel.Operation;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class PolymorphismTest extends TestCase {
	private static final String TYPE1_STRING_OBJECT = "Type1::String::Object";

	private static final String TYPE1_OBJECT_OBJECT = "Type1::Object::Object";

	private static final String TYPE2_STRING_OBJECT = "Type2::String::Object";

	private static final String TYPE2_STRING_STRING = "Type2::String::String";

	private EClass type1Class;

	private EClass type2Class;

	private EPackage ePackage;

	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		type1Class = EcoreFactory.eINSTANCE.createEClass();
		type1Class.setName("Type1");
		type2Class = EcoreFactory.eINSTANCE.createEClass();
		type2Class.setName("Type2");
		type2Class.getESuperTypes().add(type1Class);
		ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.getEClassifiers().add(type1Class);
		ePackage.getEClassifiers().add(type2Class);

		EOperation type1SO = createMyOp(createStringParam(), createObjectParam());
		EOperation type1OO = createMyOp(createObjectParam(), createObjectParam());
		type1Class.getEOperations().add(type1SO);
		type1Class.getEOperations().add(type1OO);
		EOperation type2SO = createMyOp(createStringParam(), createObjectParam()); // overrides
																					// one
																					// in
																					// type1
		EOperation type2SS = createMyOp(createStringParam(), createStringParam());
		type2Class.getEOperations().add(type2SO);
		type2Class.getEOperations().add(type2SS);

		BuiltinMetaModel.registerOperationImpl(type1SO, PolymorphismTest.class.getMethod("type1SO", String.class, Object.class));
		BuiltinMetaModel.registerOperationImpl(type1OO, PolymorphismTest.class.getMethod("type1OO", Object.class, Object.class));
		BuiltinMetaModel.registerOperationImpl(type2SO, PolymorphismTest.class.getMethod("type2SO", String.class, Object.class));
		BuiltinMetaModel.registerOperationImpl(type2SS, PolymorphismTest.class.getMethod("type2SS", String.class, String.class));
	}

	public static String type1SO(String str, Object obj) {
		return TYPE1_STRING_OBJECT;
	}

	public static String type1OO(Object o1, Object o2) {
		return TYPE1_OBJECT_OBJECT;
	}

	public static String type2SO(String str, Object obj) {
		return TYPE2_STRING_OBJECT;
	}

	public static String type2SS(String s1, String s2) {
		return TYPE2_STRING_STRING;
	}

	@SuppressWarnings("unchecked")
	private static EOperation createMyOp(EParameter p1, EParameter p2) {
		EOperation op = EcoreFactory.eINSTANCE.createEOperation();
		op.setName("myOp");
		op.setEType(EcorePackage.eINSTANCE.getEString());
		op.getEParameters().add(p1);
		op.getEParameters().add(p2);
		return op;
	}

	private static EParameter createStringParam() {
		EParameter p = EcoreFactory.eINSTANCE.createEParameter();
		p.setName("str");
		p.setEType(EcorePackage.eINSTANCE.getEString());
		return p;
	}

	private static EParameter createObjectParam() {
		EParameter p = EcoreFactory.eINSTANCE.createEParameter();
		p.setName("obj");
		p.setEType(EcorePackage.eINSTANCE.getEJavaObject());
		return p;
	}

	public final void testStuff() {
		final EObject type2 = ePackage.getEFactoryInstance().create(type2Class);
		final EObject type1 = ePackage.getEFactoryInstance().create(type1Class);
		final Object obj = new Object();
		final String str = "test";
		final Integer other = new Integer(2);

		assertEquals(TYPE1_OBJECT_OBJECT, executeOperation("myOp", type2, new Object[] { obj, str }));
		assertEquals(TYPE2_STRING_STRING, executeOperation("myOp", type2, new Object[] { str, str }));
		assertEquals(TYPE2_STRING_OBJECT, executeOperation("myOp", type2, new Object[] { str, other }));
		assertEquals(TYPE1_STRING_OBJECT, executeOperation("myOp", type1, new Object[] { str, other }));

	}

	public Object executeOperation(final String name, final Object target, final Object[] params) {
		Operation op = BuiltinMetaModel.executableOperation(name, params, target);
		assertNotNull(op);
		return op.evaluate();
	}
}
