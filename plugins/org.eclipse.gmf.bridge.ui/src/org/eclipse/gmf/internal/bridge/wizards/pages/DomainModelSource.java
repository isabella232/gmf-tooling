/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author dstadnik
 */
public interface DomainModelSource {

	/**
	 * Update domain model source. After update contents may change.
	 * 
	 * @return true if domain model source was changed in some way.
	 */
	public boolean update();

	public EPackage getContents();

	public IStatus getErrorStatus();
}
