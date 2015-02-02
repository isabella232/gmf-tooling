package org.eclipse.gmf.tests.samples;

import java.math.BigDecimal;
import java.sql.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.gmf.tooling.examples.labels.LabelsFactory;
import org.eclipse.gmf.tooling.examples.labels.LabelsPackage;
import org.eclipse.gmf.tooling.examples.labels.Side;
import org.eclipse.gmf.tooling.runtime.parsers.AbstractAttributeParser;

public class LabelsSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.labels/model/labels.gmfgen";

	public static final String UNEDIT_STRING_VALUE = "unedit";

	public static final Object INVALID_VALUE_OBJECT = new Object();

	public LabelsSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}

	public LabelsSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}

	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}

	public void testBooleanAttibuteParser() {
		LabelsPackage.eINSTANCE.getLabelsFactory();
		EAttribute attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_BooleanObject();
		MockAttributeParser parser = createParser(attr);

		checkParserStatus(parser, Boolean.FALSE.toString(), IParserEditStatus.EDITABLE);
		checkCommonObjectTypeParserStatus(parser);

		attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_Boolean();
		parser = createParser(attr);

		checkParserStatus(parser, Boolean.TRUE.toString(), IParserEditStatus.EDITABLE);

		checkCommonSimpleTypeParserStatus(parser);
	}

	public void testBigDecimalAttibuteParser() {
		LabelsPackage.eINSTANCE.getLabelsFactory();
		EAttribute attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_BigDecimal();
		MockAttributeParser parser = createParser(attr);

		checkParserStatus(parser, "42", IParserEditStatus.EDITABLE);
		checkParserStatus(parser, new BigDecimal(8), IParserEditStatus.EDITABLE);
		checkParserStatus(parser, 735, IParserEditStatus.EDITABLE);

		checkCommonObjectTypeParserStatus(parser);
	}

	public void testDoubleObjectAttibuteParser() {
		LabelsPackage.eINSTANCE.getLabelsFactory();
		EAttribute attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_DoubleObject();
		MockAttributeParser parser = createParser(attr);

		checkParserStatus(parser, "42.42", IParserEditStatus.EDITABLE);
		checkParserStatus(parser, new Double(45), IParserEditStatus.EDITABLE);
		checkParserStatus(parser, 88884444.222444d, IParserEditStatus.EDITABLE);

		checkCommonObjectTypeParserStatus(parser);
	}

	public void testIntAttibuteParser() {
		LabelsPackage.eINSTANCE.getLabelsFactory();
		EAttribute attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_Int();
		MockAttributeParser parser = createParser(attr);

		checkParserStatus(parser, "10546", IParserEditStatus.EDITABLE);
		checkParserStatus(parser, new Integer(300), IParserEditStatus.EDITABLE);
		checkParserStatus(parser, Integer.MAX_VALUE, IParserEditStatus.EDITABLE);
		checkParserStatus(parser, Long.MIN_VALUE, IParserEditStatus.EDITABLE);

		checkCommonSimpleTypeParserStatus(parser);
	}

	public void testDateAttibuteParser() {
		LabelsPackage.eINSTANCE.getLabelsFactory();
		EAttribute attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_Date();
		MockAttributeParser parser = createParser(attr);

		checkParserStatus(parser, "2012-12-12", IParserEditStatus.EDITABLE);
		checkParserStatus(parser, new Date(Long.MAX_VALUE), IParserEditStatus.EDITABLE);
		checkParserStatus(parser, 1L, IParserEditStatus.UNEDITABLE);

		checkCommonObjectTypeParserStatus(parser);
	}

	public void testEnumAttibuteParser() {
		LabelsPackage.eINSTANCE.getLabelsFactory();
		EAttribute attr = LabelsFactory.eINSTANCE.getLabelsPackage().getAllLabelsType_Side();
		MockAttributeParser parser = createParser(attr);

		checkParserStatus(parser, Side.LEFT.toString(), IParserEditStatus.EDITABLE);
		checkParserStatus(parser, Side.RIGHT, IParserEditStatus.EDITABLE);
		checkParserStatus(parser, Side.LEFT_VALUE, IParserEditStatus.EDITABLE);
		checkParserStatus(parser, 3, IParserEditStatus.UNEDITABLE);

		checkCommonSimpleTypeParserStatus(parser);
	}

	private MockAttributeParser createParser(EAttribute attr) {
		return new MockAttributeParser(new EAttribute[] { attr });
	}

	private void checkParserStatus(MockAttributeParser parser, Object value, int parserStatus) {
		Object[] values = new Object[] { value };
		assertEquals(parser.wrappedValidateNewValues(values).getCode(), parserStatus);
	}

	private void checkCommonSimpleTypeParserStatus(MockAttributeParser parser) {
		checkParserStatus(parser, null, IParserEditStatus.UNEDITABLE);
		ckeckCommonUneditableParserStatus(parser);
	}

	private void checkCommonObjectTypeParserStatus(MockAttributeParser parser) {
		checkParserStatus(parser, null, IParserEditStatus.EDITABLE);
		ckeckCommonUneditableParserStatus(parser);
	}

	private void ckeckCommonUneditableParserStatus(MockAttributeParser parser) {
		checkParserStatus(parser, UNEDIT_STRING_VALUE, IParserEditStatus.UNEDITABLE);
		checkParserStatus(parser, INVALID_VALUE_OBJECT, IParserEditStatus.UNEDITABLE);
	}

	private class MockAttributeParser extends AbstractAttributeParser {

		private MockAttributeParser(EAttribute[] features) {
			super(features);
		}

		public IParserEditStatus wrappedValidateNewValues(Object[] values) {
			return validateNewValues(values);
		}

		@Override
		public String getEditString(IAdaptable element, int flags) {
			fail("Unused method");
			return null;
		}

		@Override
		public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
			fail("Unused method");
			return null;
		}

		@Override
		public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
			fail("Unused method");
			return null;
		}

		@Override
		public String getPrintString(IAdaptable element, int flags) {
			fail("Unused method");
			return null;
		}
	}
}
