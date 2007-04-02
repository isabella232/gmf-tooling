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
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ThrowsTag;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;


/**
 * Proxy to an ExecutableMemberDoc
 */

public class ExecutableMemberDocProxy extends MemberDocProxy implements ExecutableMemberDoc
{

  public ExecutableMemberDocProxy(ExecutableMemberDoc innerExecutableMemberDoc)
  {
    super(innerExecutableMemberDoc);
  }

  private ExecutableMemberDoc getInnerExecutableMemberDoc()
  {
    return (ExecutableMemberDoc)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#isNative()
   */
  public boolean isNative()
  {
    return getInnerExecutableMemberDoc().isNative();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#isSynchronized()
   */
  public boolean isSynchronized()
  {
    return getInnerExecutableMemberDoc().isSynchronized();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#thrownExceptions()
   */
  public ClassDoc[] thrownExceptions()
  {
    return FACTORY.createClassDocProxies(getInnerExecutableMemberDoc().thrownExceptions());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#paramTags()
   */
  public ParamTag[] paramTags()
  {
    return getInnerExecutableMemberDoc().paramTags();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#parameters()
   */
  public Parameter[] parameters()
  {
    return FACTORY.createParameterProxies(getInnerExecutableMemberDoc().parameters());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#throwsTags()
   */
  public ThrowsTag[] throwsTags()
  {
    return FACTORY.createThrowsTagProxies(getInnerExecutableMemberDoc().throwsTags());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#flatSignature()
   */
  public String flatSignature()
  {
    return getInnerExecutableMemberDoc().flatSignature();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ExecutableMemberDoc#signature()
   */
  public String signature()
  {
    return getInnerExecutableMemberDoc().signature();
  }

  public boolean isVarArgs()
  {
    return false;
  }

  public Type[] thrownExceptionTypes()
  {
    return null;
  }

  public ParamTag[] typeParamTags()
  {
    return null;
  }

  public TypeVariable[] typeParameters()
  {
    return null;
  }

  public AnnotationDesc[] annotations()
  {
    return null;
  }

}
