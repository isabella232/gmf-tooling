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
import org.eclipse.core.runtime.IStatus;
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
	
	protected final TraceFacility traceFacility;
	private final boolean shouldTraceMissedTemplates;

	public DispatcherImpl(EmitterFactory factory, KeyMap keyMap) {
		myFactory = factory;
		myKeyMap = keyMap;
		final String pluginID = "org.eclipse.gmf.common";
		traceFacility = new TraceFacility(pluginID);
		final String option = pluginID + "/templates/missed/log";
		shouldTraceMissedTemplates = Boolean.valueOf(Platform.getDebugOption(option)).booleanValue();
	}

	public String dispatch(Object key, Object argument) {
		try {
			StringBuffer errors = new StringBuffer();
			for (KeyChain it = myKeyMap.map(key); it.hasNext();) {
				Object nextKey = it.next();
				if (myFactory.checkEmitter(nextKey)) {
					try {
						JETEmitter em = myFactory.acquireEmitter(nextKey);
						return em.generate(new NullProgressMonitor(), new Object[] {argument});
					} catch (NoSuchTemplateException ex) {
						traceFacility.error("Template for key '" + nextKey + "' failed", ex);
						errors.append(formatError(ex));
						errors.append("\n");
					} catch (UnexpectedBehaviourException ex) {
						traceFacility.error("Template for key '" + nextKey + "' failed", ex);
						errors.append(formatError(ex));
						errors.append("\n");
					}
				}
			}
			if (errors.length() == 0) {
				if (shouldTraceMissedTemplates) {
					final String msg = "No suitable template found for '" + key + "'";
					traceFacility.warn(msg, null);
					return "// " + msg;
				} else {
					return "";
				}
			} else {
				return errors.toString();
			}
		} catch (JETException ex) {
			traceFacility.error(ex.getMessage(), ex);
			return "ERROR: " + formatError(ex);
		}
	}

	private static String formatError(Exception ex) {
		return ex.getClass().getName() + ": " + ex.getMessage();
	}

	private static class TraceFacility {
		private final ILog traceFacility;
		public TraceFacility(String pluginID) {
			traceFacility = Platform.getLog(Platform.getBundle(pluginID));
		}

		public void error(String message, Exception ex) {
			log(IStatus.ERROR, message, ex);
		}

		public void warn(String message, Exception ex) {
			log(IStatus.WARNING, message, ex);
		}

		public String getPluginID() {
			return traceFacility.getBundle().getSymbolicName();
		}

		private void log(int severity, String message, Exception ex) {
			traceFacility.log(new Status(severity, getPluginID(), 0, message, ex));
		}
	}
}
