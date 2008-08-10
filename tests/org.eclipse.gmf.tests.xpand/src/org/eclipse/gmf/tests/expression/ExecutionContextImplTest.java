/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.tests.expression;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.ocl.TypeHelper;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ExecutionContextImplTest extends TestCase {
	ExecutionContext ec;

	@Override
	protected void setUp() throws Exception {
		ec = new ExecutionContextImpl(new Scope() {});
	}

	// XXX not sure about bigInt/bigDecimal, as well as StringBuffer/char
	public final void testgetType() {
		OCLStandardLibrary<EClassifier> stdlib = ec.getOCLEnvironment().getOCLStandardLibrary();
		assertEquals(stdlib.getInteger(), BuiltinMetaModel.getType(ec, new Integer(3)));
		assertEquals(stdlib.getInteger(), BuiltinMetaModel.getType(ec, new Short((short) 3)));
		assertEquals(stdlib.getInteger(), BuiltinMetaModel.getType(ec, new Long(3l)));
//		assertEquals(stdlib.getInteger(), BuiltinMetaModel.getType(new BigInteger("3")));

		assertEquals(stdlib.getReal(), BuiltinMetaModel.getType(ec, new Float(3)));
		assertEquals(stdlib.getReal(), BuiltinMetaModel.getType(ec, new Double(3)));
//		assertEquals(stdlib.getReal(), BuiltinMetaModel.getType(new BigDecimal(3)));

		assertEquals(stdlib.getString(), BuiltinMetaModel.getType(ec, "Test"));
//		assertEquals(stdlib.getString(), BuiltinMetaModel.getType(new StringBuffer()));
//		assertEquals(stdlib.getString(), BuiltinMetaModel.getType(new Character('c')));
	}

	// @see ecore.UMLReflectionImpl#getOCLTypeFor
	public void off_testOCLDoesntSupportByte() {
		OCLStandardLibrary<EClassifier> stdlib = ec.getOCLEnvironment().getOCLStandardLibrary();
		assertEquals(stdlib.getInteger(), BuiltinMetaModel.getType(ec, new Byte((byte) 3)));
	}
	/*
	 * FIXME split out tests for xpand.ocl.* classes
	 */
	public final void testGetTypeForName() {
		CollectionTypeCS type = CSTFactory.eINSTANCE.createCollectionTypeCS();
		type.setCollectionTypeIdentifier(CollectionTypeIdentifierEnum.SEQUENCE_LITERAL);
		PrimitiveTypeCS inner = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
		inner.setType(SimpleTypeEnum.STRING_LITERAL);
		inner.setValue("String");
		type.setTypeCS(inner);
		OCLStandardLibrary<EClassifier> stdlib = ec.getOCLEnvironment().getOCLStandardLibrary();
		TypeHelper th = new TypeHelper(type);
		final EClassifier t = th.getTypeForName(ec);
		assertNotNull(t);
		/*
		 * FIXME: find out why:
		 * stdlib.getCollection() is a Collection of AnyType, but with *it's own* instance of any type
		 * (the one available as stdlib.getT(), and thus 
		 * TypeUtil.getRelationship(stdlib.getCollection(), Sequence{String}) says unrelated,
		 * as inner type of the stdlib collection is not the same AnyType getRelationship() uses 
		 *
		* 		int rel = TypeUtil.getRelationship(ec.getOCLEnvironment(), stdlib.getCollection(), t);
		* 		assertTrue(0 != (rel & UMLReflection.RELATED_TYPE));
		 */
		assertTrue(t instanceof org.eclipse.ocl.types.CollectionType); // this is the way C.Damus writes OCL tests 
        CollectionType tt = (CollectionType) t;
        assertEquals(CollectionKind.SEQUENCE_LITERAL, tt.getKind());
		assertEquals(stdlib.getString(), tt.getElementType());
	}
}
