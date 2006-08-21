package org.eclipse.gmf.tests.tr;

import org.eclipse.gmf.internal.common.codegen.TextMerger;

/**
 * @author dstadnik
 */
public class PrpTextMergerTest extends TextMergerTest {

	public PrpTextMergerTest(String name) {
		super(name);
	}

	protected TextMerger getTextMerger() {
		TextMerger merger = TextMerger.getForFile("plugin.properties");
		assertNotNull(merger);
		return merger;
	}

	protected String getOldHeader() {
		return "prop1=x\n";
	}

	protected String getOldPart1() {
		return "prop2=y\n";
	}

	protected String getOldTail() {
		return "prop3=z\n";
	}

	protected String getNewHeader() {
		return "propx=1\n";
	}

	protected String getNewPart1() {
		return "propy=2\n";
	}

	protected String getNewTail() {
		return "propz=3\n";
	}

	protected String getRegion1() {
		return "region1=aaa\n";
	}

	protected String getRegion2() {
		return "region21=bbb\nregion22=ccc\n";
	}
}
