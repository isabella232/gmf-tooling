/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.xpand.migration;

import org.eclipse.gmf.tests.expression.ExecutionContextImplTest;
import org.eclipse.gmf.tests.expression.PolymorphismTest;
import org.eclipse.gmf.tests.expression.TypeNameUtilTest;
import org.eclipse.gmf.tests.expression.ast.AnalyzationTest;
import org.eclipse.gmf.tests.expression.ast.EvaluationTest;
import org.eclipse.gmf.tests.expression.ast.ParserTest;
import org.eclipse.gmf.tests.expression.ast.ScannerTest;
import org.eclipse.gmf.tests.type.baseimpl.CollectionFeaturesTest;
import org.eclipse.gmf.tests.type.baseimpl.ObjectFeaturesTest;
import org.eclipse.gmf.tests.type.baseimpl.TypesComparatorTest;
import org.eclipse.gmf.tests.type.baseimpl.types.BooleanTypeTest;
import org.eclipse.gmf.tests.type.baseimpl.types.CollectionTypeTest;
import org.eclipse.gmf.tests.type.baseimpl.types.EnumTest;
import org.eclipse.gmf.tests.type.baseimpl.types.IntegerTypeTest;
import org.eclipse.gmf.tests.type.baseimpl.types.ObjectTypeTest;
import org.eclipse.gmf.tests.type.baseimpl.types.StringTypeTest;
import org.eclipse.gmf.tests.xpand.AopFeatureTest;
import org.eclipse.gmf.tests.xpand.CompositeResourcesTest;
import org.eclipse.gmf.tests.xpand.StatementAnalyzationTest;
import org.eclipse.gmf.tests.xpand.StatementEvaluatorTest;
import org.eclipse.gmf.tests.xpand.StatementParserTest;
import org.eclipse.gmf.tests.xpand.impl.NameUtilTest;
import org.eclipse.gmf.tests.xpand.output.OutputImplTest;
import org.eclipse.gmf.tests.xtend.ExtensionAnalyzationTest;
import org.eclipse.gmf.tests.xtend.ExtensionEvaluationTest;
import org.eclipse.gmf.tests.xtend.ExtensionParserTest;
import org.eclipse.gmf.tests.xtend.XtendFacadeTest;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.gmf.tests.xpand.migration");
		//$JUnit-BEGIN$
		suite.addTestSuite(ExecutionContextImplTest.class);
		suite.addTestSuite(PolymorphismTest.class);
		suite.addTestSuite(TypeNameUtilTest.class);
		suite.addTestSuite(AnalyzationTest.class);
		suite.addTestSuite(EvaluationTest.class);
		suite.addTestSuite(ParserTest.class);
		suite.addTestSuite(ScannerTest.class);
		suite.addTestSuite(CollectionFeaturesTest.class);
		suite.addTestSuite(ObjectFeaturesTest.class);
		suite.addTestSuite(TypesComparatorTest.class);
		suite.addTestSuite(BooleanTypeTest.class);
		suite.addTestSuite(CollectionTypeTest.class);
		suite.addTestSuite(EnumTest.class);
		suite.addTestSuite(IntegerTypeTest.class);
		suite.addTestSuite(ObjectTypeTest.class);
		suite.addTestSuite(StringTypeTest.class);
		suite.addTestSuite(AopFeatureTest.class);
		suite.addTestSuite(CompositeResourcesTest.class);
		suite.addTestSuite(StatementAnalyzationTest.class);
		suite.addTestSuite(StatementEvaluatorTest.class);
		suite.addTestSuite(StatementParserTest.class);
		suite.addTestSuite(NameUtilTest.class);
		suite.addTestSuite(OutputImplTest.class);
		suite.addTestSuite(ExtensionAnalyzationTest.class);
		suite.addTestSuite(ExtensionEvaluationTest.class);
		suite.addTestSuite(ExtensionParserTest.class);
		suite.addTestSuite(XtendFacadeTest.class);
		suite.addTestSuite(XpandMigrationTest.class);
		suite.addTestSuite(XtendMigrationTest.class);
		//$JUnit-END$
		return suite;
	}

}
