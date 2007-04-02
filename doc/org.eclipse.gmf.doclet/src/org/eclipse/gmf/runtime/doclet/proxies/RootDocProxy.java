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


import java.util.ArrayList;

import org.eclipse.gmf.runtime.doclet.Doclet;
import org.eclipse.gmf.runtime.doclet.ITagDefinitions;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SourcePosition;


/**
 * Proxy to a RootDoc. Manages the filtering of classes and packages.
 */

public class RootDocProxy extends DocProxy implements RootDoc
{

  private ClassDoc[] filteredClasses = null;

  private ClassDoc[] filteredSpecifiedClasses = null;

  private PackageDoc[] filteredSpecifiedPackages = null;

  private String options[][] = null;

  public RootDocProxy(RootDoc innerRootDoc)
  {
    super(innerRootDoc);
    setFilteredClasses(filterClasses(getInnerRootDoc().classes()));
    setFilteredSpecifiedClasses(filterClasses(getInnerRootDoc().specifiedClasses()));
    setFilteredPackages(filterPackages(getInnerRootDoc().specifiedPackages()));
  }

  private RootDoc getInnerRootDoc()
  {
    return (RootDoc)getInnerObject();
  }

  private ClassDoc[] getFilteredClasses()
  {
    return this.filteredClasses;
  }

  private void setFilteredClasses(ClassDoc[] filteredClasses)
  {
    this.filteredClasses = filteredClasses;
  }

  private ClassDoc[] getFilteredSpecifiedClasses()
  {
    return this.filteredSpecifiedClasses;
  }

  private void setFilteredSpecifiedClasses(ClassDoc[] filteredSpecifiedClasses)
  {
    this.filteredSpecifiedClasses = filteredSpecifiedClasses;
  }

  private PackageDoc[] getFilteredSpecifiedPackages()
  {
    return this.filteredSpecifiedPackages;
  }

  private void setFilteredPackages(PackageDoc[] filteredSpecifiedPackages)
  {
    this.filteredSpecifiedPackages = filteredSpecifiedPackages;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.RootDoc#classes()
   */
  public ClassDoc[] classes()
  {
    return getFilteredClasses();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.RootDoc#specifiedClasses()
   */

  public ClassDoc[] specifiedClasses()
  {
    return getFilteredSpecifiedClasses();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.RootDoc#specifiedPackages()
   */
  public PackageDoc[] specifiedPackages()
  {
    return getFilteredSpecifiedPackages();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.RootDoc#options()
   */
  public String[][] options()
  {

    if (this.options == null)
    {
      this.options = getOptions();
    }

    return this.options;
  }

  private String[][] getOptions()
  {

    String innerOptions[][] = getInnerRootDoc().options();

    /* Regenerate a new array of options that includes our default options */
    ArrayList augmentedOptions = new ArrayList();

    for (int i = 0; i < innerOptions.length; i++)
    {
      String[] opt = innerOptions[i];
      augmentedOptions.add(opt);
    }

    /* Ensure no warnings on our custom tags */
    augmentedOptions.add(new String []{ "-tag", ITagDefinitions.TAG_CAN_BE_SEEN_BY + ":X" }); //$NON-NLS-1$//$NON-NLS-2$

    return (String[][])augmentedOptions.toArray(new String [0] [0]);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.RootDoc#classNamed(java.lang.String)
   */
  public ClassDoc classNamed(String arg0)
  {
    return ProxyFactory.getInstance().createClassDocProxy(getInnerRootDoc().classNamed(arg0));
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.RootDoc#packageNamed(java.lang.String)
   */
  public PackageDoc packageNamed(String arg0)
  {
    return ProxyFactory.getInstance().createPackageDocProxy(getInnerRootDoc().packageNamed(arg0));
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.DocErrorReporter#printError(java.lang.String)
   */
  public void printError(String arg0)
  {
    getInnerRootDoc().printError(arg0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.DocErrorReporter#printNotice(java.lang.String)
   */
  public void printNotice(String arg0)
  {
    getInnerRootDoc().printNotice(arg0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.DocErrorReporter#printWarning(java.lang.String)
   */
  public void printWarning(String arg0)
  {
    getInnerRootDoc().printWarning(arg0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.DocErrorReporter#printError(com.sun.javadoc.SourcePosition,
   *      java.lang.String)
   */
  public void printError(SourcePosition arg0, String arg1)
  {
    getInnerRootDoc().printError(arg0, arg1);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.DocErrorReporter#printNotice(com.sun.javadoc.SourcePosition,
   *      java.lang.String)
   */
  public void printNotice(SourcePosition arg0, String arg1)
  {
    getInnerRootDoc().printNotice(arg0, arg1);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sun.javadoc.DocErrorReporter#printWarning(com.sun.javadoc.SourcePosition,
   *      java.lang.String)
   */
  public void printWarning(SourcePosition arg0, String arg1)
  {
    getInnerRootDoc().printWarning(arg0, arg1);
  }

  private ClassDoc[] filterClasses(ClassDoc[] classes)
  {
    ArrayList retClasses = new ArrayList();
    for (int i = 0; i < classes.length; i++)
    {
      ClassDoc classDoc = classes[i];
      if (false == isFiltered(classDoc))
      {
        retClasses.add(ProxyFactory.getInstance().createClassDocProxy(classDoc));
      }

    }
    return (ClassDoc[])retClasses.toArray(new ClassDoc [0]);
  }

  private boolean isFiltered(ClassDoc classDoc)
  {
    return (Doclet.getNamespaceChecker().isClientPreventedToSee(classDoc.qualifiedName()));
  }

  private PackageDoc[] filterPackages(PackageDoc[] packages)
  {
    ArrayList retPackages = new ArrayList();
    for (int i = 0; i < packages.length; i++)
    {
      PackageDoc packageDoc = packages[i];
      if (false == isFiltered(packageDoc))
      {
        retPackages.add(ProxyFactory.getInstance().createPackageDocProxy(packageDoc));
      }

    }
    return (PackageDoc[])retPackages.toArray(new PackageDoc [0]);
  }

  private boolean isFiltered(PackageDoc packageDoc)
  {
    return (Doclet.getNamespaceChecker().isClientPreventedToSee(packageDoc.name()));
  }

}