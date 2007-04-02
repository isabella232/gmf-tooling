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


import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;


/**
 * Proxy to a Type
 */

public class TypeProxy extends Proxy implements Type
{

  public TypeProxy(Type innerType)
  {
    super(innerType);
  }

  private Type getInnerType()
  {
    return (Type)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Type#asClassDoc()
   */
  public ClassDoc asClassDoc()
  {
    return FACTORY.createClassDocProxy(getInnerType().asClassDoc());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Type#dimension()
   */
  public String dimension()
  {
    return getInnerType().dimension();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Type#qualifiedTypeName()
   */
  public String qualifiedTypeName()
  {
    return getInnerType().qualifiedTypeName();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.Type#typeName()
   */
  public String typeName()
  {
    return getInnerType().typeName();
  }

  public AnnotationTypeDoc asAnnotationTypeDoc()
  {
    return null;
  }

  public ParameterizedType asParameterizedType()
  {
    return null;
  }

  public TypeVariable asTypeVariable()
  {
    return null;
  }

  public WildcardType asWildcardType()
  {
    return null;
  }

  public boolean isPrimitive()
  {
    return false;
  }

  public String simpleTypeName()
  {
    return null;
  }
}
