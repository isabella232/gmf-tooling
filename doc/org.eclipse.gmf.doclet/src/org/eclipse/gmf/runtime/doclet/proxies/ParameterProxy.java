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


import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;


/**
 * Proxy to a Parameter
 */

public class ParameterProxy extends Proxy implements Parameter
{

  public ParameterProxy(Parameter innerParameter)
  {
    super(innerParameter);
  }

  private Parameter getInnerParameter()
  {
    return (Parameter)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Parameter#type()
   */
  public Type type()
  {
    return (Type)FACTORY.createTypeProxy(getInnerParameter().type());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Parameter#name()
   */
  public String name()
  {
    return getInnerParameter().name();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Parameter#typeName()
   */
  public String typeName()
  {
    return getInnerParameter().typeName();
  }

  public AnnotationDesc[] annotations()
  {
    return null;
  }

}
