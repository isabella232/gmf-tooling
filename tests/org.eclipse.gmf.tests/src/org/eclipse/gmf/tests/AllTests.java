/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.gmf.runtime.emf.type.core.internal.EMFTypePlugin;
import org.eclipse.gmf.tests.gef.CompartmentPropertiesTest;
import org.eclipse.gmf.tests.gef.DiagramNodeTest;
import org.eclipse.gmf.tests.gen.AuditHandcodedTest;
import org.eclipse.gmf.tests.gen.CodegenReconcileTest;
import org.eclipse.gmf.tests.gen.CompilationTest;
import org.eclipse.gmf.tests.gen.FigureCodegenTest;
import org.eclipse.gmf.tests.gen.FigureLayoutTest;
import org.eclipse.gmf.tests.gen.GenFeatureSeqInitializerTest;
import org.eclipse.gmf.tests.gen.HandcodedGMFMapItemProvidersTest;
import org.eclipse.gmf.tests.gen.HandcodedGraphDefTest;
import org.eclipse.gmf.tests.gen.HandcodedImplTest;
import org.eclipse.gmf.tests.gen.LabelSupportTest;
import org.eclipse.gmf.tests.gen.MapModeStrategyTest;
import org.eclipse.gmf.tests.gen.ModelLoadHelperTest;
import org.eclipse.gmf.tests.gen.RTFigureTest;
import org.eclipse.gmf.tests.gen.ShapePropertiesTest;
import org.eclipse.gmf.tests.gen.StandaloneMapModeTest;
import org.eclipse.gmf.tests.gen.StandalonePluginConverterTest;
import org.eclipse.gmf.tests.gen.ToolDefHandocodedImplTest;
import org.eclipse.gmf.tests.gen.ViewmapProducersTest;
import org.eclipse.gmf.tests.migration.AllMigrationTests;
import org.eclipse.gmf.tests.rt.AuditRulesTest;
import org.eclipse.gmf.tests.rt.ElementInitializerTest;
import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.rt.MetricRulesTest;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.TestSetupTest;
import org.eclipse.gmf.tests.setup.figures.FigureCodegenSetup;
import org.eclipse.gmf.tests.setup.figures.FigureLayoutSetup;
import org.eclipse.gmf.tests.setup.figures.LabelSupportSetup;
import org.eclipse.gmf.tests.setup.figures.ShapePropertiesSetup;
import org.eclipse.gmf.tests.tr.EcoreGenModelMatcherTest;
import org.eclipse.gmf.tests.tr.GenModelGraphAnalyzerTest;
import org.eclipse.gmf.tests.tr.GenModelTransformerBasicRTTest;
import org.eclipse.gmf.tests.tr.GenModelTransformerSimpleTest;
import org.eclipse.gmf.tests.tr.HistoryTest;
import org.eclipse.gmf.tests.tr.LabelMappingTransformTest;
import org.eclipse.gmf.tests.tr.NamingStrategyTest;
import org.eclipse.gmf.tests.tr.PaletteTransformationTest;
import org.eclipse.gmf.tests.tr.PluginXMLTextMergerTest;
import org.eclipse.gmf.tests.tr.TestDefaultMergeService;
import org.eclipse.gmf.tests.tr.XmlTextMergerTest;
import org.eclipse.gmf.tests.validate.AllValidateTests;

public class AllTests {

	public static Test suite() {
		EMFTypePlugin.startDynamicAwareMode();
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf, tooling side");
		//$JUnit-BEGIN$
		
		final SessionSetup sessionSetup = SessionSetup.newInstance();
		final LinksSessionSetup sessionSetup2 = (LinksSessionSetup) LinksSessionSetup.newInstance();
		SessionSetup.disallowSingleTestCaseUse();
		
		/*
		 * [AS++] Temporary workaround: loading all the projects in the
		 * beggining to get rid of the problems with runtime registries
		 * reloading. In particular - ViewService.
		 */
		try {
			sessionSetup.getGenProject();
			sessionSetup2.getGenProject();
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		/* [AS--] */
		
		suite.addTestSuite(TestSetupTest.class); // first, check sources/setups we use for rest of the tests
		suite.addTest(feed(HandcodedImplTest.class, sessionSetup)); // then, check handcoded implementations are in place
		suite.addTestSuite(HandcodedGraphDefTest.class);

		suite.addTest(feed(GenModelTransformerSimpleTest.class, sessionSetup));
		suite.addTest(feed(LabelMappingTransformTest.class, sessionSetup));
		suite.addTest(feed(PaletteTransformationTest.class, sessionSetup));
		suite.addTestSuite(HistoryTest.class);
		suite.addTestSuite(XmlTextMergerTest.class);
		suite.addTestSuite(TestDefaultMergeService.class);
		suite.addTestSuite(PluginXMLTextMergerTest.class);
		
		suite.addTest(feed(FigureCodegenTest.class, new FigureCodegenSetup()));
		suite.addTest(feed(LabelSupportTest.class, new LabelSupportSetup()));
		suite.addTest(feed(ShapePropertiesTest.class, new ShapePropertiesSetup()));
		suite.addTest(feed(FigureLayoutTest.class, new FigureLayoutSetup()));
		suite.addTestSuite(StandaloneMapModeTest.class);
		suite.addTestSuite(StandalonePluginConverterTest.class);
		suite.addTestSuite(RTFigureTest.class);
		suite.addTestSuite(MapModeStrategyTest.class);
		suite.addTestSuite(ViewmapProducersTest.class);
		suite.addTestSuite(ToolDefHandocodedImplTest.class);
		suite.addTest(feed(AuditHandcodedTest.class, sessionSetup));		
		suite.addTest(feed(AuditRulesTest.class, sessionSetup2));		
		suite.addTest(feed(ElementInitializerTest.class, sessionSetup2));
		suite.addTest(feed(CodegenReconcileTest.class, sessionSetup));
		// fires new runtime workbench initialization
		suite.addTestSuite(CompilationTest.class);

		suite.addTest(feed(DiagramNodeTest.class, sessionSetup));
		suite.addTest(feed(CompartmentPropertiesTest.class, sessionSetup));
		suite.addTest(feed(NamingStrategyTest.class, sessionSetup));
		suite.addTest(feed(GenModelTransformerBasicRTTest.class, sessionSetup));
// Test was disabled due to the following problems with openned editor:
// https://bugs.eclipse.org/bugs/show_bug.cgi?id=154748
// https://bugs.eclipse.org/bugs/show_bug.cgi?id=154767
//		suite.addTest(feed(DiagramEditorTest.class, sessionSetup));

//		suite.addTestSuite(RunTimeModelTransformerTest.class); #113966
//		suite.addTestSuite(PropertiesTest.class); #113965 
//		suite.addTestSuite(CanvasTest.class); Nothing there yet
//		suite.addTestSuite(SpecificRTPropertiesTest.class); #113965 
		
		suite.addTest(feed(LinkCreationConstraintsTest.class, sessionSetup2));
		suite.addTest(feed(MetricRulesTest.class, sessionSetup2));		
		suite.addTestSuite(EcoreGenModelMatcherTest.class);
		suite.addTestSuite(ModelLoadHelperTest.class);		
		suite.addTestSuite(GenFeatureSeqInitializerTest.class);
		suite.addTestSuite(HandcodedGMFMapItemProvidersTest.class);
		suite.addTest(AllMigrationTests.suite());
		suite.addTest(AllValidateTests.suite());
		suite.addTestSuite(GenModelGraphAnalyzerTest.class);
		//$JUnit-END$
		suite.addTest(new TestCase("testCleanup") {
			protected void runTest() throws Throwable {
				try {
					sessionSetup.cleanup();
					sessionSetup2.cleanup();
				} catch (RuntimeException ex) {
					throw ex;
				} catch (Exception ex) {
					Plugin.logError("cleanup failed", ex);
					fail(ex.getMessage());
				}
			}
		});
		
		return suite;
	}

	protected static Test feed(Class theClass, TestConfiguration config) {
		TestSuite suite = new TestSuite(theClass);
		if (!NeedsSetup.class.isAssignableFrom(theClass)) {
			return suite;
		}
		try {
			Method m = null;
			Class configClass = config.getClass();
			while (m == null && configClass != null) {
				try {
					m = theClass.getMethod(NeedsSetup.METHOD_NAME, new Class[] { configClass });
				} catch (NoSuchMethodException ex) {
					configClass = configClass.getSuperclass();
				}
			}
			if (m == null) {
				String methodInvocation = NeedsSetup.METHOD_NAME + "(" + config.getClass().getName() + " arg);";
				return new ConfigurationFailedCase(theClass.getName() + " has no method compatible with " + methodInvocation);
			}
			final Object[] args = new Object[] { config };
			for (Enumeration en = suite.tests(); en.hasMoreElements(); ) {
				Object nextTest = en.nextElement();
				m.invoke(nextTest, args);
			}
		} catch (SecurityException ex) {
			return new ConfigurationFailedCase(theClass.getName() + ": " + ex.getMessage());
		} catch (IllegalAccessException ex) {
			return new ConfigurationFailedCase(theClass.getName() + ": " + ex.getMessage());
		} catch (InvocationTargetException ex) {
			return new ConfigurationFailedCase(theClass.getName() + ": " + ex.getMessage());
		}
		return suite;
	}

	private static class ConfigurationFailedCase extends TestCase {
		private final String cause; 
		ConfigurationFailedCase(String aCause) {
			super(ConfigurationFailedCase.class.getName());
			cause = aCause;
		}
		protected void runTest() throws Throwable {
			fail(cause);
		}
	}
}