package org.eclipse.gmf.tooling.runtime.linklf.labels;

import org.eclipse.draw2d.ConnectionLocator;

class LinkLabelOffsetConvention {

	public static int getPercentageOffsetAmongTheLineForAlignment(int alignment) {
		switch (alignment) {
		case ConnectionLocator.SOURCE:
			return 100;
		case ConnectionLocator.TARGET:
			return 0;
		case ConnectionLocator.MIDDLE:
		default:
			return 50;
		}
	}

}
