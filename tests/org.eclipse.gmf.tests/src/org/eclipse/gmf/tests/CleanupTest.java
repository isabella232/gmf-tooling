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
package org.eclipse.gmf.tests;

import org.eclipse.swt.widgets.Display;

import junit.framework.TestCase;

/**
 * @author artem
 */
public abstract class CleanupTest extends TestCase {

	public CleanupTest(String name) {
		super(name);
	}

	protected abstract void performCleanup() throws Exception;

	protected final void runTest() throws Throwable {
		try {
			final JobTracker jt = new JobTracker();
			jt.start();
			performCleanup();
			jt.freeze();
			if (!Utils.dispatchDisplayMessages(jt.getNonEmptyCondition(), 10)) {
				System.err.println("Timeout while waiting for jobs to complete");
			}
			jt.stop();

			final boolean[] waitForLegacyActionPersistence = new boolean[] {true};
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					waitForLegacyActionPersistence[0] = false;
				}
			});
			Utils.dispatchDisplayMessages(waitForLegacyActionPersistence, 10);
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			fail("cleanup failed:" + ex.getClass().getSimpleName() + ":" + ex.getMessage());
		}
	}
}
