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
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;


/**
 * Proxy to a PackageDoc
 */

public class PackageDocProxy extends DocProxy implements PackageDoc
{

  public PackageDocProxy(PackageDoc innerPackageDoc)
  {
    super(innerPackageDoc);
  }

  private PackageDoc getInnerPackageDoc()
  {
    return (PackageDoc)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#allClasses()
   */
  public ClassDoc[] allClasses()
  {
    return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().allClasses());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#errors()
   */
  public ClassDoc[] errors()
  {
    return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().errors());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#exceptions()
   */
  public ClassDoc[] exceptions()
  {
    return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().exceptions());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#interfaces()
   */
  public ClassDoc[] interfaces()
  {
    return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().interfaces());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#ordinaryClasses()
   */
  public ClassDoc[] ordinaryClasses()
  {
    return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().ordinaryClasses());
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#allClasses(boolean)
   */
  public ClassDoc[] allClasses(boolean arg0)
  {
    return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().allClasses(arg0));
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.PackageDoc#findClass(java.lang.String)
   */
  public ClassDoc findClass(String arg0)
  {
    return ProxyFactory.getInstance().createClassDocProxy(getInnerPackageDoc().findClass(arg0));
  }

  public AnnotationTypeDoc[] annotationTypes()
  {
    return null;
  }

  public AnnotationDesc[] annotations()
  {
    return null;
  }

  public ClassDoc[] enums()
  {
    return null;
  }

}
