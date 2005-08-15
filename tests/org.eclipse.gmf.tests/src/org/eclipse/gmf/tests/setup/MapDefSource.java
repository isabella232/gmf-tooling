package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;

public interface MapDefSource {

	Mapping getMapping();

	CanvasMapping getCanvasMapping();

	NodeMapping getNodeMapping();

	LinkMapping getLinkMapping();
}