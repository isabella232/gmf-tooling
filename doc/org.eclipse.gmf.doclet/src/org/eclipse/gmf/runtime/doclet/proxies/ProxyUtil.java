/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.doclet.proxies;


/**
 * Utility to deal with proxies
 */
public class ProxyUtil
{

  public static Object getInnerObject(Object possibleProxy)
  {
    if (possibleProxy instanceof Proxy)
    {
      possibleProxy = ((Proxy)possibleProxy).getInnerObject();
    }
    return possibleProxy;
  }
}
