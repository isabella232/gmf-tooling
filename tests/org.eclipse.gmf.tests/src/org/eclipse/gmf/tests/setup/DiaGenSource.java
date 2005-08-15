package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLinkWithClass;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

public interface DiaGenSource {

	GenDiagram getGenDiagram();
	GenNode getGenNode();
	GenLinkWithClass getGenLink();
}
