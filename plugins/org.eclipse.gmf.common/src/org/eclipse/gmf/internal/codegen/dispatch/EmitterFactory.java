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
package org.eclipse.gmf.internal.codegen.dispatch;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.gmf.common.UnexpectedBehaviourException;

/**
 * @author artem
 */
public interface EmitterFactory {

	/**
	 * @param key
	 * @return <code>true</code> if template for the key passed is known to this factory
	 */
	boolean checkEmitter(Object key);

	/**
	 * This is primary way to get emitters from this factory. Produces new emitter.
	 */
	JETEmitter acquireEmitter(Object key) throws NoSuchTemplateException, UnexpectedBehaviourException;
}