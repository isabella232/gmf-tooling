package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

public interface DiaGenSource {

	GenDiagram getGenDiagram();
	GenNode getGenNode();
	GenLink getGenLink();
}
