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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ExecutionContextImplTest extends TestCase {
	ExecutionContext ec;

	@Override
	protected void setUp() throws Exception {
		ec = new ExecutionContextImpl(null);
	}

	// XXX not sure about bigInt/bigDecimal, as well as StringBuffer/char
	public final void testgetType() {
		assertEquals(EcorePackage.eINSTANCE.getEInt(), BuiltinMetaModel.getType(new Integer(3)));
		assertEquals(EcorePackage.eINSTANCE.getEInt(), BuiltinMetaModel.getType(new Short((short) 3)));
		assertEquals(EcorePackage.eINSTANCE.getEInt(), BuiltinMetaModel.getType(new Long(3l)));
		assertEquals(EcorePackage.eINSTANCE.getEInt(), BuiltinMetaModel.getType(new Byte((byte) 3)));
//		assertEquals(EcorePackage.eINSTANCE.getEInt(), BuiltinMetaModel.getType(new BigInteger("3")));

		assertEquals(EcorePackage.eINSTANCE.getEDouble(), BuiltinMetaModel.getType(new Float(3)));
		assertEquals(EcorePackage.eINSTANCE.getEDouble(), BuiltinMetaModel.getType(new Double(3)));
//		assertEquals(EcorePackage.eINSTANCE.getEDouble(), BuiltinMetaModel.getType(new BigDecimal(3)));

		assertEquals(EcorePackage.eINSTANCE.getEString(), BuiltinMetaModel.getType("Test"));
//		assertEquals(EcorePackage.eINSTANCE.getEString(), BuiltinMetaModel.getType(new StringBuffer()));
//		assertEquals(EcorePackage.eINSTANCE.getEString(), BuiltinMetaModel.getType(new Character('c')));

	}

	public final void testGetTypeForName() {
		final EClassifier t = ec.getTypeForName("List[String]");
		assertNotNull(t);
		assertTrue(BuiltinMetaModel.isParameterizedType(t));
		assertEquals(EcorePackage.eINSTANCE.getEString(), BuiltinMetaModel.getInnerType(t));
	}
}
