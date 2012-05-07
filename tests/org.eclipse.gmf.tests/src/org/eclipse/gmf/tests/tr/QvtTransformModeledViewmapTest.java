/*******************************************************************************
* Copyright (c) 2011, 2012 Montages A.G.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Guillaume Hillairet (Montages A.G.) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests.tr;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;

public class QvtTransformModeledViewmapTest extends QvtTransformCompareTestSupport {

	public QvtTransformModeledViewmapTest(String name) {
		super(	name, 
				testFolder+"/test.ecore", 
				testFolder+"/test.genmodel",
				testFolder+"/test.gmftool", 
				testFolder+"/test.gmfgraph", 
				testFolder+"/test.gmfmap" );
	}
	
	protected GenEditorGenerator actualGenerator;
	protected GenEditorGenerator expectedGenerator;
	
	public void setUp() throws Exception {
		super.setUp();
		actualGenerator = getQvtTransformation(true).execute();
	}
	
	public void testTopNodeModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenTopLevelNode> nodes = diagram.getTopLevelNodes();
		
		for (GenTopLevelNode node: nodes) {
			Viewmap viewmap = node.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
			
			for (GenNodeLabel label: node.getLabels()) {
				Viewmap labelViewmap = label.getViewmap();
				assertNotNull(labelViewmap);
				assertTrue(labelViewmap instanceof ModeledViewmap);
			}
		}
	}
	
	public void testChildNodeModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenChildNode> nodes = diagram.getChildNodes();
		
		for (GenChildNode node: nodes) {
			Viewmap viewmap = node.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
			
			for (GenNodeLabel label: node.getLabels()) {
				Viewmap labelViewmap = label.getViewmap();
				assertNotNull(labelViewmap);
				assertTrue(labelViewmap instanceof ModeledViewmap);
			}
		}
	}
	
	public void testLinkModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenLink> links = diagram.getLinks();
		
		for (GenLink link: links) {
			Viewmap viewmap = link.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
			
			for (GenLinkLabel label: link.getLabels()) {
				Viewmap labelViewmap = label.getViewmap();
				assertNotNull(labelViewmap);
				assertTrue(labelViewmap instanceof ModeledViewmap);
			}
		}
	}
	
	public void testCompartmentModeledViewmap() {
		assertNotNull(actualGenerator);
		
		GenDiagram diagram = actualGenerator.getDiagram();
		assertNotNull(diagram);
		
		EList<GenCompartment> compartments = diagram.getCompartments();
		for (GenCompartment compartment: compartments) {
			Viewmap viewmap = compartment.getViewmap();
			assertNotNull(viewmap);
			assertTrue(viewmap instanceof ModeledViewmap);
		}
	}
}
