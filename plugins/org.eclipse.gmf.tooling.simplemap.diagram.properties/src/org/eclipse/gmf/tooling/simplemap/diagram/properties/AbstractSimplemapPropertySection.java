package org.eclipse.gmf.tooling.simplemap.diagram.properties;

import org.eclipse.gmf.tooling.simplemap.diagram.sheet.SimplemapPropertySection;
import org.eclipse.jface.viewers.IFilter;

public abstract class AbstractSimplemapPropertySection extends SimplemapPropertySection implements IFilter {

	@Override
	public boolean select(Object toTest) {

		return transformSelection(toTest) != null;
	}

}
