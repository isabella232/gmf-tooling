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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.gmf.common.UnexpectedBehaviourException;

/**
 * @author artem
 */
public class CachingEmitterFactory implements EmitterFactory {

	private final EmitterFactory myDelegate;
	private final Map<Object, JETEmitter> myCache;

	public CachingEmitterFactory(EmitterFactory delegate) {
		assert delegate != null;
		myDelegate = delegate;
		myCache = createCache();
	}

	/**
	 * Instantiates {@link HashMap} by default. NOTE, this method is invoked
	 * from constructor, object may not be fully initialized, don't use this
	 * method for anything but cache instantiation.
	 */
	protected Map<Object, JETEmitter> createCache() {
		return new HashMap<Object, JETEmitter>();
	}

	public JETEmitter acquireEmitter(Object key) throws NoSuchTemplateException, UnexpectedBehaviourException {
		JETEmitter em = checkCache(key);
		if (em != null) {
			return em;
		}
		em = myDelegate.acquireEmitter(key);
		cache(key, em);
		return em;
	}

	public boolean checkEmitter(Object key) {
		return checkCache(key) != null || myDelegate.checkEmitter(key);
	}

	private JETEmitter checkCache(Object key) {
		return myCache.get(key);
	}

	private void cache(Object key, JETEmitter emitter) {
		myCache.put(key, emitter);
	}
}
