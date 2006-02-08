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

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.gmf.common.UnexpectedBehaviourException;

/**
 * TODO collect errors and provide accessor - e.g. FigureGenerator could check 
 * whether {@link #dispatch(Object, Object)} was a success. 
 * @author artem
 */
public class DispatcherImpl implements Dispatcher {

	private final EmitterFactory myFactory;

	private final KeyMap myKeyMap;

	public DispatcherImpl(EmitterFactory factory, KeyMap keyMap) {
		myFactory = factory;
		myKeyMap = keyMap;
	}

	public String dispatch(Object key, Object argument) {
		final String pluginID = "org.eclipse.gmf.common";
		final ILog traceFacility = Platform.getLog(Platform.getBundle(pluginID));
		try {
			StringBuffer errors = new StringBuffer();
			for (KeyChain it = myKeyMap.map(key); it.hasNext();) {
				Object nextKey = it.next();
				if (myFactory.checkEmitter(nextKey)) {
					try {
						JETEmitter em = myFactory.acquireEmitter(nextKey);
						return em.generate(new NullProgressMonitor(), new Object[] {argument});
					} catch (NoSuchTemplateException ex) {
						traceFacility.log(new Status(Status.ERROR, pluginID, 0, "Template for key '" + nextKey + "' failed", ex));
						errors.append(formatError(ex));
						errors.append("\n");
					} catch (UnexpectedBehaviourException ex) {
						traceFacility.log(new Status(Status.ERROR, pluginID, 0, "Template for key '" + nextKey + "' failed", ex));
						errors.append(formatError(ex));
						errors.append("\n");
					}
				}
			}
			if (errors.length() == 0) {
				// TODO option silent?
				return "// no suitable template found for '" + key + "'";
			} else {
				return errors.toString();
			}
		} catch (JETException ex) {
			traceFacility.log(new Status(Status.ERROR, pluginID, 0, ex.getMessage(), ex));
			return "ERROR: " + formatError(ex);
		}
	}

	private static String formatError(Exception ex) {
		return ex.getClass().getName() + ": " + ex.getMessage();
	}
}
