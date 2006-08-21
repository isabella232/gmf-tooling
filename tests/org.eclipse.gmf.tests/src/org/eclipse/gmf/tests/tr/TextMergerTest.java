package org.eclipse.gmf.tests.tr;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.common.codegen.TaggedTextMerger;
import org.eclipse.gmf.internal.common.codegen.TextMerger;

/**
 * @author dstadnik
 */
public abstract class TextMergerTest extends TestCase {

	public TextMergerTest(String name) {
		super(name);
	}

	protected abstract TextMerger getTextMerger();

	protected abstract String getOldHeader();

	protected abstract String getOldPart1();

	protected abstract String getOldTail();

	protected abstract String getNewHeader();

	protected abstract String getNewPart1();

	protected abstract String getNewTail();

	protected abstract String getRegion1();

	protected abstract String getRegion2();

	public void testOneRegionMerge() throws Exception {
		TaggedTextMerger merger = (TaggedTextMerger) getTextMerger();
		String oldText = getOldHeader() + merger.getBeginTag() + getRegion1() + merger.getEndTag() + getOldTail();
		String newText = getNewHeader() + merger.getBeginTag() + merger.getEndTag() + getNewTail();
		String mergedText = merger.process(oldText, newText);
		String expectedText = getNewHeader() + merger.getBeginTag() + getRegion1() + merger.getEndTag() + getNewTail();
		assertEquals(mergedText, expectedText);
	}

	public void testTwoRegionsMerge() throws Exception {
		TaggedTextMerger merger = (TaggedTextMerger) getTextMerger();
		String oldText = getOldHeader() + merger.getBeginTag() + getRegion1() + merger.getEndTag() + getOldPart1() + merger.getBeginTag() + getRegion2() + merger.getEndTag() + getOldTail();
		String newText = getNewHeader() + getNewPart1() + merger.getBeginTag() + merger.getEndTag() + getNewTail();
		String mergedText = merger.process(oldText, newText);
		String expectedText = getNewHeader() + getNewPart1() + merger.getBeginTag() + getRegion1() + getRegion2() + merger.getEndTag() + getNewTail();
		assertEquals(mergedText, expectedText);
	}

	public void testIdentityMerge() throws Exception {
		TaggedTextMerger merger = (TaggedTextMerger) getTextMerger();
		String newText = getNewHeader() + getNewPart1() + merger.getBeginTag() + merger.getEndTag() + getNewTail();
		String mergedText = merger.process(newText, newText);
		assertEquals(mergedText, newText);
	}

	public void testAnchorTextPreservation() throws Exception {
		TaggedTextMerger merger = (TaggedTextMerger) getTextMerger();
		String oldText = getOldHeader() + getOldTail();
		String newText = getNewHeader() + merger.getBeginTag() + "\n" + merger.getEndTag() + getNewTail();
		String mergedText = merger.process(oldText, newText);
		assertEquals(mergedText, newText);
	}
}
