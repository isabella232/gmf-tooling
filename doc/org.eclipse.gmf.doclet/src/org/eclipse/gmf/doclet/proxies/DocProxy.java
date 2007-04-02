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


import org.eclipse.gmf.doclet.Doclet;

import com.sun.javadoc.Doc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;

/**
 * Proxy to a Doc
 */
public class DocProxy extends ComparableProxy implements Doc
{

  public DocProxy(Doc innerDoc)
  {
    super(innerDoc);
  }

  private Doc getInnerDoc()
  {
    return (Doc)getInnerObject();
  }

  /* (non-Javadoc)
   * @see Doc#isClass()
   */
  public boolean isClass()
  {
    return getInnerDoc().isClass();
  }

  /* (non-Javadoc)
   * @see Doc#isConstructor()
   */
  public boolean isConstructor()
  {
    return getInnerDoc().isConstructor();
  }

  /* (non-Javadoc)
   * @see Doc#isError()
   */
  public boolean isError()
  {
    return getInnerDoc().isError();
  }

  /* (non-Javadoc)
   * @see Doc#isException()
   */
  public boolean isException()
  {
    return getInnerDoc().isException();
  }

  /* (non-Javadoc)
   * @see Doc#isField()
   */
  public boolean isField()
  {
    return getInnerDoc().isField();
  }

  /* (non-Javadoc)
   * @see Doc#isIncluded()
   */
  public boolean isIncluded()
  {

    boolean isIncluded = getInnerDoc().isIncluded();

    /* If included, extra filtering may be caused by @canBeSeenBy tags */
    if (isIncluded)
    {
      if (getInnerDoc() instanceof PackageDoc)
      {
        PackageDoc packageDoc = (PackageDoc)getInnerDoc();
        String qualifiedName = packageDoc.name();
        if (Doclet.getNamespaceChecker().isClientPreventedToSee(qualifiedName))
        {
          isIncluded = false;
        }
      }
      else if (getInnerDoc() instanceof ProgramElementDoc)
      {
        ProgramElementDoc programElementDoc = (ProgramElementDoc)getInnerDoc();
        String qualifiedName = programElementDoc.qualifiedName();
        if (Doclet.getNamespaceChecker().isClientPreventedToSee(qualifiedName))
        {
          isIncluded = false;
        }
      }
      else if (getInnerDoc() instanceof RootDoc)
      {
        isIncluded = true;
      }
    }

    return isIncluded;
  }

  /* (non-Javadoc)
   * @see Doc#isInterface()
   */
  public boolean isInterface()
  {
    return getInnerDoc().isInterface();
  }

  /* (non-Javadoc)
   * @see Doc#isMethod()
   */
  public boolean isMethod()
  {
    return getInnerDoc().isMethod();
  }

  /* (non-Javadoc)
   * @see Doc#isOrdinaryClass()
   */
  public boolean isOrdinaryClass()
  {
    return getInnerDoc().isOrdinaryClass();
  }

  /* (non-Javadoc)
   * @see Doc#seeTags()
   */
  public SeeTag[] seeTags()
  {
    return getInnerDoc().seeTags();
  }

  /* (non-Javadoc)
   * @see Doc#position()
   */
  public SourcePosition position()
  {
    return getInnerDoc().position();
  }

  /* (non-Javadoc)
   * @see Doc#firstSentenceTags()
   */
  public Tag[] firstSentenceTags()
  {
    return getInnerDoc().firstSentenceTags();
  }

  /* (non-Javadoc)
   * @see Doc#inlineTags()
   */
  public Tag[] inlineTags()
  {
    return getInnerDoc().inlineTags();
  }

  /* (non-Javadoc)
   * @see Doc#tags()
   */
  public Tag[] tags()
  {
    return getInnerDoc().tags();
  }

  /* (non-Javadoc)
   * @see Doc#commentText()
   */
  public String commentText()
  {
    return getInnerDoc().commentText();
  }

  /* (non-Javadoc)
   * @see Doc#getRawCommentText()
   */
  public String getRawCommentText()
  {
    return getInnerDoc().getRawCommentText();
  }

  /* (non-Javadoc)
   * @see Doc#name()
   */
  public String name()
  {
    return getInnerDoc().name();
  }

  /* (non-Javadoc)
   * @see Doc#setRawCommentText(java.lang.String)
   */
  public void setRawCommentText(String arg0)
  {
    getInnerDoc().setRawCommentText(arg0);
  }

  /* (non-Javadoc)
   * @see Doc#tags(java.lang.String)
   */
  public Tag[] tags(String arg0)
  {
    return getInnerDoc().tags(arg0);
  }

  public boolean isAnnotationType()
  {
    return false;
  }

  public boolean isAnnotationTypeElement()
  {
    return false;
  }

  public boolean isEnum()
  {
    return false;
  }

  public boolean isEnumConstant()
  {
    return false;
  }

}
