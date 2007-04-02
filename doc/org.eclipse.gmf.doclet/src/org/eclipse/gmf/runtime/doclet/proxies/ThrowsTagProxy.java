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
import com.sun.javadoc.ThrowsTag;
import com.sun.javadoc.Type;


/**
 * Proxy to a ThrowsTag
 */

public class ThrowsTagProxy extends TagProxy implements ThrowsTag
{

  public ThrowsTagProxy(ThrowsTag innerThrowsTag)
  {
    super(innerThrowsTag);
  }

  private ThrowsTag getInnerThrowsTag()
  {
    return (ThrowsTag)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ThrowsTag#exception()
   */
  public ClassDoc exception()
  {
    return FACTORY.createClassDocProxy(getInnerThrowsTag().exception());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ThrowsTag#exceptionComment()
   */
  public String exceptionComment()
  {
    return getInnerThrowsTag().exceptionComment();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ThrowsTag#exceptionName()
   */
  public String exceptionName()
  {
    return getInnerThrowsTag().exceptionName();
  }

  public Type exceptionType()
  {
    return null;
  }
}
