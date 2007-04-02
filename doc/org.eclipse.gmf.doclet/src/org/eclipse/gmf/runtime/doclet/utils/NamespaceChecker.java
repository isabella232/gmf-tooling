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

package org.eclipse.gmf.runtime.doclet.utils;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 * Contains the logic to determine if a given qualified name is visible
 * in the context and in the canBeSeenByMap provided to the constructor.
 */

public class NamespaceChecker
{

  private static final String WILDCARD = "*"; //$NON-NLS-1$

  private final String clientContext;

  private final HashMap canBeSeenByMap;

  public NamespaceChecker(String clientContext, HashMap canBeSeenByMap)
  {
    this.clientContext = clientContext;
    this.canBeSeenByMap = canBeSeenByMap;
  }

  private String getClientContext()
  {
    return this.clientContext;
  }

  private HashMap getCanBeSeenByMap()
  {
    return this.canBeSeenByMap;
  }

  public boolean isClientPreventedToSee(String qualifiedName)
  {

    /* By default clients are not prevented to see a given namespace */
    boolean clientPreventedToSee = false;

    /*
     * We iterate through each namespace involved in the fully qualified
     * name passed as parameter until a visibility rule is encountered. The
     * iteration is perform from child namespace to parent namespace.
     * 
     * e.g. com.ibm.xtool.common.core would be iterated as follows:
     * 
     * com.ibm.xtool.common.core com.ibm.xtool.common com.ibm.xtool com.ibm
     * com
     */

    boolean verdictMade = false;
    String partialQualifiedName = qualifiedName;

    while (verdictMade == false && partialQualifiedName.length() > 0)
    {

      /* Get list of allowed client namespaces */
      Set allowedClientNamespaces = (Set)getCanBeSeenByMap().get(partialQualifiedName);

      if (allowedClientNamespaces != null)
      {

        /*
         * Found a visibility rule, remember so we can exit walking
         * through namespaces
         */
        verdictMade = true;

        /*
         * When rules are found, assume client is prevented to see
         * unless a rule states otherwise
         */
        clientPreventedToSee = true;

        /* Iterate through rules to see if one allows visibility */
        for (Iterator iterAllowedClient = allowedClientNamespaces.iterator(); clientPreventedToSee == true && iterAllowedClient.hasNext();)
        {

          /*
           * The following cases are handled: Rule is "*" -> Everybody
           * are allowed to see Rule ends with ".*" -> Everybody
           * sharing namespace before ".*" are allowed to see
           * Otherwise -> Only the namespace identical to the
           * namespace identified in the rule is allowed
           */
          String allowedClient = (String)iterAllowedClient.next();
          if (allowedClient.endsWith(WILDCARD))
          {
            if (allowedClient.length() == 1)
            {
              clientPreventedToSee = false;
            }
            else
            {
              String allowedNamespace = allowedClient.substring(0, allowedClient.length() - 2 - 1);
              if (getClientContext().startsWith(allowedNamespace))
              {
                clientPreventedToSee = false;
              }
            }
          }
          else
          {
            if (false == getClientContext().equals(allowedClient))
            {
              clientPreventedToSee = false;
            }
          }
        }
      }

      /* Get next parent namespace */
      int lastDot = partialQualifiedName.lastIndexOf('.');
      if (lastDot == -1)
      {
        /* No more parent, we are done iterating */
        verdictMade = true;
      }
      else
      {
        partialQualifiedName = partialQualifiedName.substring(0, lastDot);
      }
    }

    //		System.out.println("******** " + qualifiedName + (clientPreventedToSee ? " Prevented" : " Allowed"));

    return clientPreventedToSee;
  }
}