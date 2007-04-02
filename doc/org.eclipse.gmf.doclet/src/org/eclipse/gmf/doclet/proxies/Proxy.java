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

package org.eclipse.gmf.doclet.proxies;


/**
 * Base proxy class. Used to wrap an Standard Doclet object. Derived classes
 * forward calls to the wrapped instance and wrap generally the returned object.
 */

public class Proxy
{

  protected Object innerObject;

  protected static ProxyFactory FACTORY = ProxyFactory.getInstance();

  public Proxy(Object innerObject)
  {
    this.innerObject = innerObject;
  }

  /*package*/Object getInnerObject()
  {
    return this.innerObject;
  }

}
