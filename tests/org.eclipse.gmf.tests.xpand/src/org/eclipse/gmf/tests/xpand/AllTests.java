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
package org.eclipse.gmf.tests.xpand;

import org.eclipse.gmf.internal.xpand.codeassist.FastAnalyzerTest;
import org.eclipse.gmf.internal.xpand.codeassist.StatementProposalComputerTest;
import org.eclipse.gmf.internal.xpand.expression.codeassist.ExpressionProposalComputerTest;
import org.eclipse.gmf.internal.xpand.expression.codeassist.ReverseScannerTest;
import org.eclipse.gmf.internal.xpand.expression.codeassist.TypeProposalComputerTest;
import org.eclipse.gmf.tests.expression.ExecutionContextImplTest;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.gmf.tests.xpand");
		//$JUnit-BEGIN$
		suite.addTestSuite(StatementEvaluatorTest.class);
		suite.addTestSuite(NameUtilTest.class);
		suite.addTestSuite(ReverseScannerTest.class);
		suite.addTestSuite(FastAnalyzerTest.class);
		suite.addTestSuite(CompositeResourcesTest.class);
		suite.addTestSuite(TypeProposalComputerTest.class);
		suite.addTestSuite(OutputImplTest.class);
		suite.addTestSuite(StatementParserTest.class);
		suite.addTestSuite(PolymorphismTest.class);
		suite.addTestSuite(QvtExtensions.class);
		suite.addTestSuite(TypesComparatorTest.class);
		suite.addTestSuite(ExpressionProposalComputerTest.class);
		suite.addTestSuite(ExecutionContextImplTest.class);
		suite.addTestSuite(StatementProposalComputerTest.class);
		suite.addTestSuite(AopFeatureTest.class);
		suite.addTestSuite(StatementAnalyzationTest.class);
		//$JUnit-END$
		return suite;
	}

}
