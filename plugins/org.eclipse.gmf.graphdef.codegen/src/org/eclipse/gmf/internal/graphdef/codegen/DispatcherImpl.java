/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.graphdef.codegen;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;

/**
 * @author artem
 */
public class DispatcherImpl extends Dispatcher {

	private final YAEmitterFactory myFactory;

	public DispatcherImpl(YAEmitterFactory factory) {
		myFactory = factory;
	}

	public String dispatch(Object arg, Object[] orginalArgs) {
		return "asdasdasd";
	}

	public String dispatch(Object key, Args args) {
		try {
			JETEmitter em = myFactory.acquireEmitter(key);
			return em.generate(new NullProgressMonitor(), new Object[] {args});
		} catch (Exception ex) {
			return "// " + ex.getClass().getSimpleName() + ": " + ex.getMessage();
		}
	}
}
