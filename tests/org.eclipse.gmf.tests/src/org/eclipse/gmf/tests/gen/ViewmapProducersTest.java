/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import junit.framework.TestCase;

import org.eclipse.gmf.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * @author artem
 *
 */
public class ViewmapProducersTest extends TestCase {
	private ViewmapProducer myProducer;

	public ViewmapProducersTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myProducer = new InnerClassViewmapProducer();
	}

	public void off_testInnerViewmapProducerBareFigure() {
		Node n = GMFGraphFactory.eINSTANCE.createNode();
		n.setName("n1");
		n.setFigure(GMFGraphFactory.eINSTANCE.createEllipse());
		Viewmap v = getProducer().create(n);
		assertNotNull(v);
		assertTrue(v instanceof FigureViewmap);
		assertEquals(new RuntimeFQNSwitch().doSwitch(n.getFigure()), ((FigureViewmap) v).getFigureQualifiedClassName());
	}

	public void testInnerViewmapProducerForNode() {
		Node n = GMFGraphFactory.eINSTANCE.createNode();
		n.setName("n1");
		Figure f = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		ConstantColor c = GMFGraphFactory.eINSTANCE.createConstantColor();
		c.setValue(ColorConstants.CYAN_LITERAL);
		f.setBackgroundColor(c);
		f.setName("RouRec1");
		n.setFigure(f);
		Viewmap v = getProducer().create(n);
		assertNotNull(v);
		assertTrue(v instanceof InnerClassViewmap);
		InnerClassViewmap icv = (InnerClassViewmap) v;
		assertNotNull(icv.getClassName());
		assertNotNull(icv.getClassBody());
		TypeDeclaration typeDecl = parseFirstType(icv.getClassBody());
		assertNotNull(typeDecl);
		String innerClassGenName = typeDecl.getName().getFullyQualifiedName();
		assertEquals(icv.getClassName(), innerClassGenName);
	}

	private TypeDeclaration parseFirstType(String classContents) {
		ASTParser p = ASTParser.newParser(AST.JLS3);
		p.setSource(classContents.toCharArray());
		p.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode astNode = p.createAST(null);
		assertEquals(ASTNode.COMPILATION_UNIT, astNode.getNodeType());
		CompilationUnit cu = (CompilationUnit) astNode;
		assertNull(cu.getPackage());
		assertTrue(cu.types().size() > 0);
		assertTrue(cu.types().get(0) instanceof TypeDeclaration);
		return (TypeDeclaration) cu.types().get(0);
	}

	protected ViewmapProducer getProducer() {
		return myProducer;
	}
}
