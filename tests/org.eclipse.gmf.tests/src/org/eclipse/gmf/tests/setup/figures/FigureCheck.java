/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.figures;

import junit.framework.Assert;

import org.eclipse.draw2d.IFigure;

public abstract class FigureCheck extends Assert {
	
	public static final FigureCheck CHECK_CAN_CREATE_INSTANCE = new FigureCheck(){
		public void checkFigure(IFigure figure) {
			//
		}
	};
	
	public static FigureCheck combineChecks(final FigureCheck[] checks){
		assertNotNull(checks);
		assertTrue(checks.length > 0);
		
		return new FigureCheck(){
			public IFigure instantiateFigure(Class figureClass) {
				//can not instantiate twice
				return checks[0].instantiateFigure(figureClass);
			}
			
			public void checkFigure(IFigure figure) {
				for (int i = 0; i < checks.length; i++){
					checks[i].checkFigure(figure);
				}
			}
		};
	}
	
	public static FigureCheck combineChecks(FigureCheck first, FigureCheck second){
		return combineChecks(new FigureCheck[] {first, second});
	}

	/**
	 * Overridable to allow not default construction
	 */
	public IFigure instantiateFigure(Class figureClass) {
		Object result = null;
		try {
			result = figureClass.newInstance();
		} catch (InstantiationException e) {
			fail(e.getMessage());
		} catch (IllegalAccessException e) {
			fail(e.getMessage());
		}
		assertNotNull(result);
		assertTrue(figureClass.getName(), result instanceof IFigure);
		return (IFigure) result;
	}

	public abstract void checkFigure(IFigure figure);
}