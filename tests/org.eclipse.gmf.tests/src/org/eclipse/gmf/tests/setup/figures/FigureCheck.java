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
import org.eclipse.draw2d.RectangleFigure;

public abstract class FigureCheck extends Assert {
	
	public static final FigureCheck CHECK_CAN_CREATE_INSTANCE = new FigureCheck(){
		protected void checkFigure(IFigure figure) {
			Assert.assertNotNull(figure);
		}
	};

	private FigureCheck next;

	/**
	 * Allows both
	 * 		c1.chain(c2).chain(c3)
	 * and
	 * 		c1.chain(c2.chain(c3)).chain(c4);
	 * @return this, head of the chain
	 */
	public final FigureCheck chain(FigureCheck next) {
		Assert.assertFalse(this == next);
		FigureCheck last = this;
		while (last.next != null) {
			last = last.next;
		}
		last.next = next;
		return this;
	}

	public final void go(Class figureClass) {
		IFigure figure = instantiateFigure(figureClass);
		assertNotNull(figure);
		go(figure);
	}

	public final void go(IFigure figure) {
		checkFigure(figure);
		if (next != null) {
			next.go(figure);
		}
	}

	/**
	 * Overridable to allow not default construction
	 */
	protected IFigure instantiateFigure(Class figureClass) {
		Object result = null;
		try {
			result = figureClass.newInstance();
		} catch (Exception e) {
			fail(e.getClass().getSimpleName() + ":" + e.getMessage());
		}
		assertTrue(figureClass.getName(), result instanceof IFigure);
		return (IFigure) result;
	}

	protected abstract void checkFigure(IFigure figure);
}