/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 *    Artem Tikhomirov (independent) support to handle not-matched new elements (Cleaner) 
 */

package org.eclipse.gmf.internal.common.reconcile;

import org.eclipse.emf.ecore.EClass;

public interface ReconcilerConfig {
	Matcher getMatcher(EClass eClass); 
	Decision[] getDecisions(EClass eClass);
	Copier getCopier(EClass eClass);
	Cleaner getCleaner(EClass eClass);
}
