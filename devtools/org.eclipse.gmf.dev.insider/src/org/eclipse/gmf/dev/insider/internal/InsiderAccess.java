/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.insider.internal;

/**
 * @author dstadnik
 */
public class InsiderAccess {

	private InsiderAccess() {}

	public static ViewManager getViewManager() {
		if (ourViewManager == null) {
			ourViewManager = new ViewManager();
		}
		return ourViewManager;
	}

	public static ViewFactory getViewFactory() {
		if (ourViewFactory == null) {
			ourViewFactory = new ViewFactory();
		}
		return ourViewFactory;
	}

	public static ContentBuilderManager getContentBuilderManager() {
		if (ourContentBuilderManager == null) {
			ourContentBuilderManager = new ContentBuilderManager();
		}
		return ourContentBuilderManager;
	}

	public static PresentationFactory getPresentationFactory() {
		if (ourPresentationFactory == null) {
			ourPresentationFactory = new PresentationFactory();
		}
		return ourPresentationFactory;
	}

	private static ViewManager ourViewManager;
	private static ViewFactory ourViewFactory;
	private static ContentBuilderManager ourContentBuilderManager;
	private static PresentationFactory ourPresentationFactory;
}
