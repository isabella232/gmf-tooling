/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.type.baseimpl.types;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.tests.expression.ast.ATypeModel;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;
import org.eclipse.gmf.internal.xpand.expression.Variable;

public class EnumTest extends TestCase {
	private ATypeModel aType;

	protected void setUp() throws Exception {
		aType = new ATypeModel();
	}

	public final void testSimple() {
		ExecutionContext ctx = aType.newContext(null, new Variable("obj", aType.getInstance()));
		ExpressionFacade ec = new ExpressionFacade(ctx);

		final String fieldAccessor = "obj." + ATypeModel.ENUM_ATTR;
		final String literal1Name = ATypeModel.ENUM_TYPE_NAME + "::" + ATypeModel.LITERAL1_NAME;
		final String literal2Name = ATypeModel.ENUM_TYPE_NAME + "::" + ATypeModel.LITERAL2_NAME;
		aType.setEnumAttr(ATypeModel.LITERAL1_NAME);
		assertEquals(Boolean.TRUE, ec.evaluate(fieldAccessor + " == " + literal1Name));
		assertEquals(Boolean.TRUE, ec.evaluate(fieldAccessor + " != " + literal2Name));
		aType.setEnumAttr(ATypeModel.LITERAL2_NAME);
		assertEquals(Boolean.TRUE, ec.evaluate(fieldAccessor + " == " + literal2Name));
		assertEquals(Boolean.TRUE, ec.evaluate(fieldAccessor + " != " + literal1Name));

		EClassifier t = BuiltinMetaModel.getType(ec.evaluate(literal1Name));
		// XXX was: assertEquals(aType.getMetaEnum(), t);
		assertEquals(EcorePackage.eINSTANCE.getEEnumerator(), t);
	}
}
