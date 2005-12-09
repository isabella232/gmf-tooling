package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;

/**
 * GMFGenModel with:
 * - nodes A, B
 * - link C, with class (from A to B)
 * - link D, as reference (either from B to A or from A to B, unspecified) XXX is it fair?
 * - diagram element Z 
 * @author artem
 */
public interface DiaGenSource {

	GenDiagram getGenDiagram();
	GenNode getNodeA();
	GenNode getNodeB();
	GenLink getLinkC();
	GenLink getLinkD();
}
