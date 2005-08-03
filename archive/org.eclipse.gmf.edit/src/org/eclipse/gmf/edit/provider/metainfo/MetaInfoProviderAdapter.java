/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.edit.provider.metainfo;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IDisposable;

/**
 * Basic provider implementation that uses EMF Adapter mechanism to 
 * keep track of provider instances
 * @author artem
 */
public class MetaInfoProviderAdapter extends AdapterImpl implements IDisposable {

	public void dispose() {
		// TODO Auto-generated method stub
	}
}
