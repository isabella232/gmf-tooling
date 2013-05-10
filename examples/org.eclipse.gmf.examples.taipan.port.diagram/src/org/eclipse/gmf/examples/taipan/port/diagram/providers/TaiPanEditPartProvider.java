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
package org.eclipse.gmf.examples.taipan.port.diagram.providers;

import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.TaiPanEditPartFactory;
import org.eclipse.gmf.examples.taipan.port.diagram.part.TaiPanVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class TaiPanEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public TaiPanEditPartProvider() {
		super(new TaiPanEditPartFactory(), TaiPanVisualIDRegistry.TYPED_INSTANCE, PortEditPart.MODEL_ID);
	}
}
