/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.graphdef.codegen.NamingStrategy;
import org.eclipse.gmf.tests.setup.figures.FigureCheck;
import org.eclipse.gmf.tests.setup.figures.GenericFigureCheck;
import org.eclipse.gmf.tests.setup.figures.LabelSupportSetup;

public class LabelSupportTest extends FigureCodegenTestBase {
	
	public LabelSupportTest(String name) {
		super(name);
	}
	
	private LabelSupportSetup getSessionSetup() {
		Assert.assertTrue("Incorrect session setup was used, use FigureCodegenSetup instead of: " + mySessionSetup, mySessionSetup instanceof LabelSupportSetup);
		return (LabelSupportSetup) mySessionSetup;
	}
	
	public void testCustomFigureWithLabel(){
		doPerformTests(getSessionSetup().getCustom());
	}
	
	public void testRectangleWithLabel(){
		doPerformTests(getSessionSetup().getSimple());
	}
	
	public void testLabeledContainer(){
		doPerformTests(getSessionSetup().getLabeledContainer());
	}
	
	public void testDeepLabelGraphdefOnly(){
		doPerformTests(getSessionSetup().getRoot());
	}
	
	protected void doPerformTests(FigureDescriptor fd) {
		performTests(fd, new GenericFigureCheck(fd.getActualFigure()).chain(new LabelAccessorCheck(fd.getAccessors().get(0))));
	}

	private static class LabelAccessorCheck extends FigureCheck {
		private final ChildAccess myLabelAccess;

		public LabelAccessorCheck(ChildAccess labelAccess){
			myLabelAccess = labelAccess;
		}
		
		protected void checkFigure(IFigure figure) {
			assertNotNull(figure);
			assertTrue("NodeEditPart requires this method in the inner figure class", 
					hasMethod(figure, NamingStrategy.getChildFigureGetterName(myLabelAccess), null));
		}	
		
		private static boolean hasMethod(Object instance, String methodName, Class<?>[] params) {
			try {
				Method method = instance.getClass().getMethod(methodName, params);
				return method != null;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
