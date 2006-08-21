package org.eclipse.gmf.tests.tr;

import org.eclipse.gmf.internal.common.codegen.TextMerger;

/**
 * @author dstadnik
 */
public class XmlTextMergerTest extends TextMergerTest {

	public XmlTextMergerTest(String name) {
		super(name);
	}

	protected TextMerger getTextMerger() {
		TextMerger merger = TextMerger.getForFile("plugin.xml");
		assertNotNull(merger);
		return merger;
	}

	protected String getOldHeader() {
		return "<old>\n";
	}

	protected String getOldPart1() {
		return "<part1/>\n";
	}

	protected String getOldTail() {
		return "</old>\n";
	}

	protected String getNewHeader() {
		return "<new>\n";
	}

	protected String getNewPart1() {
		return "<partx>\n";
	}

	protected String getNewTail() {
		return "</new>\n";
	}

	protected String getRegion1() {
		return "<region1/>\n";
	}

	protected String getRegion2() {
		return "<region21/>\n<region22/>\n";
	}
}
