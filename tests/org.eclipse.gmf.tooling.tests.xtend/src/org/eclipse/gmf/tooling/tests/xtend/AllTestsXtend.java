/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Mickael Istria (EBM Websourcing) - Support for target platform creation
 */
package org.eclipse.gmf.tooling.tests.xtend;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.gmf.tests.CleanupTest;
import org.eclipse.gmf.tests.Configurator;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.gef.CompartmentPropertiesTest;
import org.eclipse.gmf.tests.gef.DiagramEditorTest;
import org.eclipse.gmf.tests.gef.DiagramNodeTest;
import org.eclipse.gmf.tests.gef.ParsersTest;
import org.eclipse.gmf.tests.gen.AuditHandcodedTest;
import org.eclipse.gmf.tests.gen.CodegenReconcileTest;
import org.eclipse.gmf.tests.gen.FigureCodegenTest;
import org.eclipse.gmf.tests.gen.FigureLayoutTest;
import org.eclipse.gmf.tests.gen.GenFeatureSeqInitializerTest;
import org.eclipse.gmf.tests.gen.HandcodedContributionItemTest;
import org.eclipse.gmf.tests.gen.HandcodedGMFMapItemProvidersTest;
import org.eclipse.gmf.tests.gen.HandcodedGraphDefTest;
import org.eclipse.gmf.tests.gen.HandcodedImplTest;
import org.eclipse.gmf.tests.gen.HandcodedPaletteTest;
import org.eclipse.gmf.tests.gen.LabelSupportTest;
import org.eclipse.gmf.tests.gen.MapModeStrategyTest;
import org.eclipse.gmf.tests.gen.ModelLoadHelperTest;
import org.eclipse.gmf.tests.gen.OrganizeImportsPostprocessorTest;
import org.eclipse.gmf.tests.gen.RTFigureTest;
import org.eclipse.gmf.tests.gen.ShapePropertiesTest;
import org.eclipse.gmf.tests.gen.StandaloneMapModeTest;
import org.eclipse.gmf.tests.gen.StandalonePluginConverterTest;
import org.eclipse.gmf.tests.gen.ToolDefHandocodedImplTest;
import org.eclipse.gmf.tests.gen.ViewmapProducersTest;
import org.eclipse.gmf.tests.rt.AuditRulesTest;
import org.eclipse.gmf.tests.rt.ElementInitializerTest;
import org.eclipse.gmf.tests.rt.LinkChildMetaFeatureNotFromContainerTest;
import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.rt.LinkCreationTest;
import org.eclipse.gmf.tests.rt.LinkEcoreConstraintsTest;
import org.eclipse.gmf.tests.rt.MetricRulesTest;
import org.eclipse.gmf.tests.rt.PaletteTest;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.TestAllDerivedFeatures;
import org.eclipse.gmf.tests.setup.TestSetupTest;
import org.eclipse.gmf.tests.setup.figures.FigureCodegenSetup;
import org.eclipse.gmf.tests.setup.figures.FigureLayoutSetup;
import org.eclipse.gmf.tests.setup.figures.LabelSupportSetup;
import org.eclipse.gmf.tests.setup.figures.ShapePropertiesSetup;
import org.eclipse.gmf.tests.tr.AuditRootTest;
import org.eclipse.gmf.tests.tr.CompareTransformationEngineTest;
import org.eclipse.gmf.tests.tr.EcoreGenModelMatcherTest;
import org.eclipse.gmf.tests.tr.GenModelGraphAnalyzerTest;
import org.eclipse.gmf.tests.tr.GenModelTransformerBasicRTTest;
import org.eclipse.gmf.tests.tr.GenModelTransformerSimpleTest;
import org.eclipse.gmf.tests.tr.HistoryTest;
import org.eclipse.gmf.tests.tr.LabelMappingTransformTest;
import org.eclipse.gmf.tests.tr.ManifestMergeTest;
import org.eclipse.gmf.tests.tr.NamingStrategyTest;
import org.eclipse.gmf.tests.tr.PaletteTransformationTest;
import org.eclipse.gmf.tests.tr.PluginXMLTextMergerTest;
import org.eclipse.gmf.tests.tr.TestDefaultMergeService;
import org.eclipse.gmf.tests.tr.TransformToGenModelOperationTest;
import org.eclipse.gmf.tests.tr.XmlTextMergerTest;
import org.eclipse.gmf.tests.validate.AllValidateTests;
import org.eclipse.gmf.tooling.tests.xtend.gen.RuntimeCompilationTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.rt.BundleActivationTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.rt.EditHelpersTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.rt.LinkChildMetaFeatureNotFromContainerTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.rt.LinkEcoreConstraintsTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.setup.LinksSessionSetupXtend;
import org.eclipse.gmf.tooling.tests.xtend.setup.ParsersSetupXtend;
import org.eclipse.gmf.tooling.tests.xtend.setup.SessionSetupXtend;
import org.eclipse.jdt.core.JavaCore;

public class AllTestsXtend {

	public static Test suite() throws Exception {

		if (System.getProperty("buildingWithTycho") != null) {
			System.err.println("Generating a target platform");
			Utils.setTargetPlatform();
		}

		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf, tooling side");
		final SessionSetup sessionSetup = SessionSetupXtend.newInstance();
		final LinksSessionSetup sessionSetup2 = LinksSessionSetupXtend.newInstance();
		final SessionSetup setupLinkEcoreConstraintsTest = new LinkEcoreConstraintsTestXtend.CustomSetup();
		final SessionSetup setupLinkChildMetaFeatureNotFromContainerTest = new LinkChildMetaFeatureNotFromContainerTestXtend.CustomSetupXtend();
		final SessionSetup setupEditHelpersTest = new EditHelpersTestXtend.EditHelpersSessionSetup();
		final SessionSetup setupBundleActivationTest = new BundleActivationTestXtend.CustomSetup();

		SessionSetup.disallowSingleTestCaseUse();

		JavaCore.initializeAfterLoad(null);
		// since we force initialization, need to make sure our tests would use same initialized setup instances. 
		Plugin.getConfig().registerInstance(SessionSetup.class, sessionSetup);
		Plugin.getConfig().registerInstance(LinksSessionSetup.class, sessionSetup2);
		Plugin.getConfig().registerInstance(setupLinkEcoreConstraintsTest.getClass(), setupLinkEcoreConstraintsTest);
		Plugin.getConfig().registerInstance(setupLinkChildMetaFeatureNotFromContainerTest.getClass(), setupLinkChildMetaFeatureNotFromContainerTest);
		Plugin.getConfig().registerInstance(setupEditHelpersTest.getClass(), setupEditHelpersTest);
		Plugin.getConfig().registerInstance(setupBundleActivationTest.getClass(), setupBundleActivationTest);
		try {
			sessionSetup.getGeneratedPlugin();
			sessionSetup2.getGeneratedPlugin();
			setupLinkChildMetaFeatureNotFromContainerTest.getGeneratedPlugin();
			setupLinkEcoreConstraintsTest.getGeneratedPlugin();
			setupEditHelpersTest.getGeneratedPlugin();
			setupBundleActivationTest.getGeneratedPlugin();
		} catch (final Exception e) {
			suite.addTest(new ConfigurationFailedCase("Session setup initialization problem", e));
			return suite;
		}
		/* END */

		Plugin.getConfig().register(DiagramEditorTest.class, sessionSetup);
		Plugin.getConfig().register(CodegenReconcileTest.class, sessionSetup);
		Plugin.getConfig().register(HandcodedImplTest.class, sessionSetup);
		Plugin.getConfig().register(CompartmentPropertiesTest.class, sessionSetup);
		Plugin.getConfig().register(PaletteTest.class, sessionSetup);
		Plugin.getConfig().register(TransformToGenModelOperationTest.class, sessionSetup);
		Plugin.getConfig().register(GenModelTransformerSimpleTest.class, sessionSetup);
		Plugin.getConfig().register(LabelMappingTransformTest.class, sessionSetup);
		Plugin.getConfig().register(PaletteTransformationTest.class, sessionSetup);
		Plugin.getConfig().register(AuditHandcodedTest.class, sessionSetup);
		Plugin.getConfig().register(CodegenReconcileTest.class, sessionSetup);

		Plugin.getConfig().register(CompareTransformationEngineTest.class, sessionSetup);

		// Default configuration, TestAllDerivedFeatures also runs for LinksSessionSetup 
		Plugin.getConfig().register(TestAllDerivedFeatures.class, sessionSetup);
		Plugin.getConfig().register(DiagramNodeTest.class, sessionSetup);
		Plugin.getConfig().register(NamingStrategyTest.class, sessionSetup);
		Plugin.getConfig().register(GenModelTransformerBasicRTTest.class, sessionSetup);
		Plugin.getConfig().register(LinkCreationTest.class, sessionSetup);
		// LinksSessionSetup
		Plugin.getConfig().register(AuditRulesTest.class, sessionSetup2);
		Plugin.getConfig().register(ElementInitializerTest.class, sessionSetup2);
		Plugin.getConfig().register(LinkCreationConstraintsTest.class, sessionSetup2);
		Plugin.getConfig().register(MetricRulesTest.class, sessionSetup2);
		// 
		Plugin.getConfig().register(FigureCodegenTest.class, new FigureCodegenSetup());
		Plugin.getConfig().register(LabelSupportTest.class, new LabelSupportSetup());
		Plugin.getConfig().register(ShapePropertiesTest.class, new ShapePropertiesSetup());
		Plugin.getConfig().register(FigureLayoutTest.class, new FigureLayoutSetup());
		//
		// Default configuration, ParsersTest also runs for ParsersSetup(false)
		Plugin.getConfig().register(ParsersTest.class, new ParsersSetupXtend(true));
		//
		Plugin.getConfig().register(LinkEcoreConstraintsTestXtend.class, new LinkEcoreConstraintsTestXtend.CustomSetup());
		Plugin.getConfig().register(LinkChildMetaFeatureNotFromContainerTestXtend.class, new LinkChildMetaFeatureNotFromContainerTestXtend.CustomSetupXtend());
		Plugin.getConfig().register(EditHelpersTestXtend.class, new EditHelpersTestXtend.EditHelpersSessionSetup());
		Plugin.getConfig().register(BundleActivationTestXtend.class, new BundleActivationTestXtend.CustomSetup());

		//$JUnit-BEGIN$
		suite.addTestSuite(TestSetupTest.class); // first, check sources/setups we use for the rest of the tests
		suite.addTestSuite(HandcodedImplTest.class); // then, check handcoded implementations are in place
		suite.addTestSuite(HandcodedGraphDefTest.class);
		suite.addTestSuite(HandcodedPaletteTest.class);
		suite.addTestSuite(HandcodedContributionItemTest.class);
		suite.addTestSuite(HandcodedGMFMapItemProvidersTest.class);

		suite.addTestSuite(GenModelTransformerSimpleTest.class);
		suite.addTestSuite(TransformToGenModelOperationTest.class);
		suite.addTestSuite(LabelMappingTransformTest.class);
		suite.addTestSuite(PaletteTransformationTest.class);
		suite.addTestSuite(AuditRootTest.class);
		suite.addTestSuite(HistoryTest.class);
		suite.addTestSuite(XmlTextMergerTest.class);
		suite.addTestSuite(TestDefaultMergeService.class);
		suite.addTestSuite(PluginXMLTextMergerTest.class);
		suite.addTestSuite(ManifestMergeTest.class);
		suite.addTestSuite(OrganizeImportsPostprocessorTest.class);

		suite.addTestSuite(CompareTransformationEngineTest.class);

		suite.addTestSuite(EcoreGenModelMatcherTest.class);
		suite.addTestSuite(ModelLoadHelperTest.class);
		suite.addTest(AllValidateTests.suite());

		suite.addTestSuite(FigureCodegenTest.class);
		suite.addTestSuite(LabelSupportTest.class);
		suite.addTestSuite(ShapePropertiesTest.class);
		suite.addTestSuite(FigureLayoutTest.class);
		suite.addTestSuite(StandaloneMapModeTest.class);
		suite.addTestSuite(StandalonePluginConverterTest.class);
		suite.addTestSuite(RTFigureTest.class);
		suite.addTestSuite(MapModeStrategyTest.class);
		suite.addTestSuite(ViewmapProducersTest.class);
		suite.addTestSuite(ToolDefHandocodedImplTest.class);
		suite.addTestSuite(AuditHandcodedTest.class);
		suite.addTestSuite(AuditRulesTest.class);
		suite.addTestSuite(ElementInitializerTest.class);
		suite.addTestSuite(CodegenReconcileTest.class);
		// though it might be an overkill to check two setups, it should be fast and won't hurt.
		suite.addTest(feed(TestAllDerivedFeatures.class, sessionSetup, "-SessionSetup"));
		suite.addTest(feed(TestAllDerivedFeatures.class, sessionSetup2, "-LinksSessionSetup"));

		suite.addTestSuite(DiagramNodeTest.class);
		suite.addTestSuite(CompartmentPropertiesTest.class);
		suite.addTestSuite(NamingStrategyTest.class);
		suite.addTestSuite(GenModelTransformerBasicRTTest.class);
		suite.addTestSuite(DiagramEditorTest.class);
		suite.addTest(feed(LinkChildMetaFeatureNotFromContainerTest.class, setupLinkChildMetaFeatureNotFromContainerTest, "-LinkChildMetaFeatureNotFromContainerSessionSetup"));
		suite.addTest(feed(LinkEcoreConstraintsTest.class, setupLinkEcoreConstraintsTest, "-LinkEcoreSessionSetup"));
		suite.addTestSuite(PaletteTest.class);

		suite.addTestSuite(BundleActivationTestXtend.class);

		suite.addTestSuite(LinkCreationTest.class);
		suite.addTestSuite(LinkCreationConstraintsTest.class);
		suite.addTestSuite(MetricRulesTest.class);
		suite.addTestSuite(GenFeatureSeqInitializerTest.class);
		suite.addTestSuite(GenModelGraphAnalyzerTest.class);
		suite.addTest(feed(EditHelpersTestXtend.class, setupEditHelpersTest, "-editHelpersSetup"));
		suite.addTest(feed(ParsersTest.class, new ParsersSetupXtend(false), "-direct"));
		suite.addTest(feed(ParsersTest.class, new ParsersSetupXtend(true), "-provider"));

		// slowest test goes last
		suite.addTestSuite(RuntimeCompilationTestXtend.class);
		//
		suite.addTest(TestSamplesSuiteXtend.suite());

		//$JUnit-END$
		suite.addTest(new CleanupTest("testCleanup") {

			protected void performCleanup() throws Exception {
				sessionSetup.cleanup();
				sessionSetup2.cleanup();
				setupLinkChildMetaFeatureNotFromContainerTest.cleanup();
				setupLinkEcoreConstraintsTest.cleanup();
				setupEditHelpersTest.cleanup();
				setupBundleActivationTest.cleanup();
			}
		});

		return suite;
	}

	public static Test feed(Class<? extends TestCase> theClass, TestConfiguration config, String suffix) {
		return Configurator.feed(theClass, config, theClass.getSimpleName() + suffix);
	}

}