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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.gmf.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap;
import org.eclipse.gmf.codegen.gmfgen.ResizeConstraints;
import org.eclipse.gmf.codegen.gmfgen.Viewmap;
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.CustomConnection;
import org.eclipse.gmf.gmfgraph.CustomFigure;
import org.eclipse.gmf.gmfgraph.Direction;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Layout;
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
		Node n = createNode("n1", GMFGraphFactory.eINSTANCE.createEllipse());
		Viewmap v = getProducer().create(n);
		assertNotNull(v);
		assertTrue(v instanceof FigureViewmap);
		assertEquals(new RuntimeFQNSwitch().doSwitch(n.getFigure()), ((FigureViewmap) v).getFigureQualifiedClassName());
	}
	
	public void testFindAncestorGallery(){
		Figure external = GMFGraphFactory.eINSTANCE.createRectangle();
		assertNull(InnerClassViewmapProducer.findAncestorFigureGallery(external));
		
		FigureGallery figureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		figureGallery.setName("Any");
		
		Figure normal = GMFGraphFactory.eINSTANCE.createRectangle();
		normal.setName("Normal");
		figureGallery.getFigures().add(normal);
		
		Figure deep = GMFGraphFactory.eINSTANCE.createRectangle();
		deep.setName("Deep");
		normal.getChildren().add(deep);
		
		assertSame(figureGallery, InnerClassViewmapProducer.findAncestorFigureGallery(normal));
		assertSame(figureGallery, InnerClassViewmapProducer.findAncestorFigureGallery(deep));
	}

	public void testViewmapRequiredPluginIDs() {
		final String BUNDLE = "com.mycompany.figures";
		
		FigureGallery figureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
		figureGallery.setName("Any");
		figureGallery.setImplementationBundle(BUNDLE);

		CustomFigure customFigure = GMFGraphFactory.eINSTANCE.createCustomFigure();
		customFigure.setName("ExternalFigure");
		customFigure.setQualifiedClassName("com.mycompany.figures.TheFigure");
		customFigure.setBundleName(BUNDLE);
		
		figureGallery.getFigures().add(customFigure);

		Node node = GMFGraphFactory.eINSTANCE.createNode();
		node.setName("Node");
		node.setFigure(customFigure);

		Compartment compartment = GMFGraphFactory.eINSTANCE.createCompartment();
		compartment.setName("Compartment");
		compartment.setFigure(customFigure);

		Connection connection = GMFGraphFactory.eINSTANCE.createConnection();
		connection.setName("Link");
		CustomConnection customLinkFigure = GMFGraphFactory.eINSTANCE.createCustomConnection();
		customLinkFigure.setName("ExternalLink");
		customLinkFigure.setQualifiedClassName("com.mycompany.figures.TheLink");
		customLinkFigure.setBundleName(BUNDLE);
		connection.setFigure(customLinkFigure);
		
		figureGallery.getFigures().add(customLinkFigure);

		class Checker extends Assert {
			public void checkViewmap(Viewmap viewmap) {
				assertNotNull(viewmap);
				assertTrue(viewmap.getRequiredPluginIDs().contains(BUNDLE));
			}
		}

		Checker checker = new Checker();

		checker.checkViewmap(getProducer().create(node));
		checker.checkViewmap(getProducer().create(compartment));
		checker.checkViewmap(getProducer().create(connection));
	}

	public void testInnerViewmapProducerForNode() {
		Node node = createNode("n1", GMFGraphFactory.eINSTANCE.createRoundedRectangle());
		ConstantColor c = GMFGraphFactory.eINSTANCE.createConstantColor();
		c.setValue(ColorConstants.CYAN_LITERAL);
		Figure figure = node.getFigure();
		figure.setBackgroundColor(c);
		figure.setName("RouRec1");
		node.setFigure(figure);
		Viewmap v = getProducer().create(node);
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
	
	public void testResizeConstaintsSingleDiagonals(){
		Figure f = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		f.setName("Figure");
		
		new ResizeConstraintsChecker(new Direction[] {
				Direction.NORTH_LITERAL, 
				Direction.WEST_LITERAL, 
		}).checkNode(createNode("NW", f, Direction.NORTH_WEST_LITERAL));

		new ResizeConstraintsChecker(new Direction[] {
				Direction.NORTH_LITERAL, 
				Direction.EAST_LITERAL, 
		}).checkNode(createNode("NE", f, Direction.NORTH_EAST_LITERAL));

		new ResizeConstraintsChecker(new Direction[] {
				Direction.SOUTH_LITERAL, 
				Direction.WEST_LITERAL, 
		}).checkNode(createNode("SW", f, Direction.SOUTH_WEST_LITERAL));

		new ResizeConstraintsChecker(new Direction[] {
				Direction.SOUTH_LITERAL, 
				Direction.EAST_LITERAL, 
		}).checkNode(createNode("SE", f, Direction.SOUTH_EAST_LITERAL));
	}
	
	public void testResizeConstraintsMulty(){
		Figure f = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		f.setName("Figure");
		
		Node explicitAny = createNode("ExplicitAll", f, Direction.NSEW_LITERAL);
		Node implicitAny = createNode("ImplicitAll", f, null);
		Node horizontal = createNode("Horizontal", f, Direction.EAST_WEST_LITERAL);
		Node vertical = createNode("Vertical", f, Direction.NORTH_SOUTH_LITERAL);
		
		NoUselessResizeConstraintsChecker allDirectionsChecker = new NoUselessResizeConstraintsChecker();

		allDirectionsChecker.checkNode(implicitAny);
		allDirectionsChecker.checkNode(explicitAny);
		new ResizeConstraintsChecker(new Direction[] {Direction.EAST_LITERAL, Direction.WEST_LITERAL}).checkNode(horizontal);
		new ResizeConstraintsChecker(new Direction[] {Direction.SOUTH_LITERAL, Direction.NORTH_LITERAL}).checkNode(vertical);
	}
	
	public void testResizeConstaintsSingleCartesians(){
		Figure f = GMFGraphFactory.eINSTANCE.createRoundedRectangle();
		f.setName("Figure");

		Direction[] CARTESIANS = new Direction[] {
				Direction.NORTH_LITERAL, 
				Direction.SOUTH_LITERAL,  
				Direction.EAST_LITERAL, 
				Direction.WEST_LITERAL, 
			};

		for (int i = 0; i < CARTESIANS.length; i++){
			Direction next = CARTESIANS[i];
			Node node = createNode("Single" + next.getName(), f, next);
			new ResizeConstraintsChecker(next).checkNode(node);
		}
	}
	
	public void testViewmapLayoutType(){
		ViewmapLayoutTypeChecker checker = new ViewmapLayoutTypeChecker();
		GMFGraphFactory gmf = GMFGraphFactory.eINSTANCE;
		checker.check(null, ViewmapLayoutType.UNKNOWN_LITERAL);
		checker.check(gmf.createCustomLayout(), ViewmapLayoutType.UNKNOWN_LITERAL);
		checker.check(gmf.createGridLayout(), ViewmapLayoutType.UNKNOWN_LITERAL);
		checker.check(gmf.createBorderLayout(), ViewmapLayoutType.UNKNOWN_LITERAL);
		
		checker.check(gmf.createXYLayout(), ViewmapLayoutType.XY_LAYOUT_LITERAL);
		
		FlowLayout flow = gmf.createFlowLayout();
		flow.setForceSingleLine(false);
		checker.check(flow, ViewmapLayoutType.FLOW_LAYOUT_LITERAL);
		
		FlowLayout toolbar = gmf.createFlowLayout();
		toolbar.setForceSingleLine(true);
		checker.check(toolbar, ViewmapLayoutType.TOOLBAR_LAYOUT_LITERAL);
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
	
	private Node createNode(String name, Figure figure){
		return createNode(name, figure, null);
	}
	
	private Node createNode(String name, Figure figure, Direction optionalConstaint){
		assertNotNull(name);
		assertNotNull(figure);
		Node result = GMFGraphFactory.eINSTANCE.createNode();
		result.setName(name);
		result.setFigure(figure);
		if (optionalConstaint != null){
			result.setResizeConstraint(optionalConstaint);
		}
		return result;
	}

	protected ViewmapProducer getProducer() {
		return myProducer;
	}

	private class ResizeConstraintsChecker {
		private final List myExpectedNames;

		public ResizeConstraintsChecker(Direction[] expectedDirectionNames){
			myExpectedNames = new ArrayList(expectedDirectionNames.length);
			for (int i = 0; i < expectedDirectionNames.length; i++){
				myExpectedNames.add(expectedDirectionNames[i].getName());
			}
		}
		
		public ResizeConstraintsChecker(Direction theOnly){
			this(new Direction[] {theOnly});
		}

		protected ResizeConstraintsChecker() {
			myExpectedNames = Collections.EMPTY_LIST;
		}

		public void checkNode(Node node){
			Viewmap viewmap = getProducer().create(node);
			checkViewmap(node.getName(), viewmap);
		}
		
		public void checkViewmap(String nodeName, Viewmap v){
			assertNotNull(v);
			ResizeConstraints genConstraint = (ResizeConstraints)v.find(ResizeConstraints.class); 
			assertNotNull("Problem node:" + nodeName, genConstraint);
			assertEquals("Problem node:" + nodeName, myExpectedNames.size(), genConstraint.getResizeHandleNames().size());
			assertTrue("Problem node:" + nodeName, genConstraint.getResizeHandleNames().containsAll(myExpectedNames));
		}
	}
	
	private class NoUselessResizeConstraintsChecker extends ResizeConstraintsChecker {
		public NoUselessResizeConstraintsChecker() {
		}

		public void checkViewmap(String nodeName, Viewmap v){
			assertNotNull(v);
			ResizeConstraints genConstraint = (ResizeConstraints)v.find(ResizeConstraints.class);
			assertNull("Problem node:" + nodeName, genConstraint);
		}
	}
	
	private class ViewmapLayoutTypeChecker {
		private final Figure myFigure;
		private final Node myNode;
		
		public ViewmapLayoutTypeChecker(){
			this(GMFGraphFactory.eINSTANCE.createRectangle(), GMFGraphFactory.eINSTANCE.createNode());
		}

		public ViewmapLayoutTypeChecker(Figure figure, Node node){
			myFigure = figure;
			myFigure.setName("Figure");
			myNode = node;
			myNode.setName("Node");
			myNode.setFigure(myFigure);
		}
		
		public void check(Layout graphLayout, ViewmapLayoutType expected){
			myFigure.setLayout(graphLayout);
			ViewmapLayoutType actual = getProducer().create(myNode).getLayoutType();
			assertNotNull(actual);
			assertEquals(expected, actual);
		}
	}
}
