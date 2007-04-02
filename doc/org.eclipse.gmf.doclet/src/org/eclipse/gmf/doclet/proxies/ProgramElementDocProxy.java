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


import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;


/**
 * Proxy to a ProgramElementDoc
 */

public class ProgramElementDocProxy extends DocProxy implements ProgramElementDoc
{

  public ProgramElementDocProxy(ProgramElementDoc innerProgramElementDoc)
  {
    super(innerProgramElementDoc);
  }

  private ProgramElementDoc getInnerProgramElementDoc()
  {
    return (ProgramElementDoc)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#modifierSpecifier()
   */
  public int modifierSpecifier()
  {
    return getInnerProgramElementDoc().modifierSpecifier();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#isFinal()
   */
  public boolean isFinal()
  {
    return getInnerProgramElementDoc().isFinal();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#isPackagePrivate()
   */
  public boolean isPackagePrivate()
  {
    return getInnerProgramElementDoc().isPackagePrivate();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#isPrivate()
   */
  public boolean isPrivate()
  {
    return getInnerProgramElementDoc().isPrivate();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#isProtected()
   */
  public boolean isProtected()
  {
    return getInnerProgramElementDoc().isProtected();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#isPublic()
   */
  public boolean isPublic()
  {
    return getInnerProgramElementDoc().isPublic();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#isStatic()
   */
  public boolean isStatic()
  {
    return getInnerProgramElementDoc().isStatic();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#containingClass()
   */
  public ClassDoc containingClass()
  {
    return FACTORY.createClassDocProxy(getInnerProgramElementDoc().containingClass());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#containingPackage()
   */
  public PackageDoc containingPackage()
  {
    return FACTORY.createPackageDocProxy(getInnerProgramElementDoc().containingPackage());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#modifiers()
   */
  public String modifiers()
  {
    return getInnerProgramElementDoc().modifiers();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.ProgramElementDoc#qualifiedName()
   */
  public String qualifiedName()
  {
    return getInnerProgramElementDoc().qualifiedName();
  }

  public AnnotationDesc[] annotations()
  {
    return null;
  }

}
