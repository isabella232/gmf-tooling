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


import com.sun.javadoc.MemberDoc;


/**
 * Proxy to a MemberDoc
 */

public class MemberDocProxy extends ProgramElementDocProxy implements MemberDoc
{

  public MemberDocProxy(MemberDoc innerMemberDoc)
  {
    super(innerMemberDoc);
  }

  private MemberDoc getInnerMemberDoc()
  {
    return (MemberDoc)getInnerObject();
  }

  /* (non-Javadoc)
   * @see com.sun.javadoc.MemberDoc#isSynthetic()
   */
  public boolean isSynthetic()
  {
    return getInnerMemberDoc().isSynthetic();
  }

}
