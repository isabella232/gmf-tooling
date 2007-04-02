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


import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Type;


/**
 * Proxy to a MethodDoc
 */

public class MethodDocProxy extends ExecutableMemberDocProxy implements MethodDoc
{

  public MethodDocProxy(MethodDoc innerMethodDoc)
  {
    super(innerMethodDoc);
  }

  private MethodDoc getInnerMethodDoc()
  {
    return (MethodDoc)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.MethodDoc#isAbstract()
   */
  public boolean isAbstract()
  {
    return getInnerMethodDoc().isAbstract();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.MethodDoc#overriddenClass()
   */
  public ClassDoc overriddenClass()
  {
    return FACTORY.createClassDocProxy(getInnerMethodDoc().overriddenClass());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.MethodDoc#overriddenMethod()
   */
  public MethodDoc overriddenMethod()
  {
    return FACTORY.createMethodDocProxy(getInnerMethodDoc().overriddenMethod());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.MethodDoc#returnType()
   */
  public Type returnType()
  {
    return (Type)FACTORY.createTypeProxy(getInnerMethodDoc().returnType());
  }

  public Type overriddenType()
  {
    return null;
  }

  public boolean overrides(MethodDoc arg0)
  {
    return false;
  }

}
