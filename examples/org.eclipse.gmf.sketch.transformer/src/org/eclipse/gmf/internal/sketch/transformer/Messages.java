/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import org.eclipse.osgi.util.NLS;

/**
 * @author dstadnik
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.gmf.internal.sketch.transformer.messages"; //$NON-NLS-1$

	public static String SketchTransformer_NoCanvas;

	public static String SketchTransformer_NoGenFeatureForAttr;

	public static String SketchTransformer_NoLinkSource;

	public static String SketchTransformer_NoLinkTarget;

	public static String SketchTransformer_RefNodeNotChild;

	public static String SketchTransformer_RefNodeNotResolved;

	public static String SketchTransformer_TopNodeAttrsIgnored;

	public static String SketchTransformer_TopNodeOnBorder;

	public static String TransformSketchAction_ErrorSavingResult;

	public static String TransformSketchAction_ErrorTransforming;

	public static String VisualIDsDispenser_Collision;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
