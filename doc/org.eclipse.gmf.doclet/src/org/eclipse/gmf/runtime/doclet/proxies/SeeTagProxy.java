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
import com.sun.javadoc.MemberDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.SeeTag;


/**
 * Proxy to a SeeTag
 */

public class SeeTagProxy extends TagProxy implements SeeTag
{

  public SeeTagProxy(SeeTag innerSeeTag)
  {
    super(innerSeeTag);
  }

  private SeeTag getInnerSeeTag()
  {
    return (SeeTag)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.SeeTag#referencedClass()
   */
  public ClassDoc referencedClass()
  {
    return FACTORY.createClassDocProxy(getInnerSeeTag().referencedClass());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.SeeTag#referencedMember()
   */
  public MemberDoc referencedMember()
  {
    return FACTORY.createMemberDocProxy(getInnerSeeTag().referencedMember());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.SeeTag#referencedPackage()
   */
  public PackageDoc referencedPackage()
  {
    return FACTORY.createPackageDocProxy(getInnerSeeTag().referencedPackage());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.SeeTag#label()
   */
  public String label()
  {
    return getInnerSeeTag().label();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.SeeTag#referencedClassName()
   */
  public String referencedClassName()
  {
    return getInnerSeeTag().referencedClassName();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.SeeTag#referencedMemberName()
   */
  public String referencedMemberName()
  {
    return getInnerSeeTag().referencedMemberName();
  }

}
