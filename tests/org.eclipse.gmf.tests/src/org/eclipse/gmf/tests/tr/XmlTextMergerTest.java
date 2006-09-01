package org.eclipse.gmf.tests.tr;

import org.eclipse.gmf.internal.common.codegen.TaggedTextMerger;

/**
 * @author dstadnik
 */
public class XmlTextMergerTest extends TaggedTextMergerTest {

	private TaggedTextMerger myTaggedTextMerger;

	public XmlTextMergerTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myTaggedTextMerger = new TaggedTextMerger("<!-- aaa -->", "<!-- bbb -->");
	}

	protected TaggedTextMerger getTextMerger() {
		return myTaggedTextMerger;
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
