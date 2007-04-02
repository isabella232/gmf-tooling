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

package org.eclipse.gmf.doclet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;

import org.eclipse.gmf.doclet.proxies.ProxyFactory;
import org.eclipse.gmf.doclet.utils.AliasRegistry;
import org.eclipse.gmf.doclet.utils.MapsGenerator;
import org.eclipse.gmf.doclet.utils.NamespaceChecker;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.tools.doclets.standard.Standard;


/**
 * Main entry point of the doclet, this doclet offers support for the
 * special namespace-based accessibility rules and generates Eclipse TOC for
 * exported packages
 */
public class Doclet extends Standard
{

  private static final String CMDLINE_OPTION_CLIENT_CONTEXT = "-clientContext"; //$NON-NLS-1$

  private static final String CMDLINE_OPTION_NAMESPACE_ALIAS = "-namespaceAlias"; //$NON-NLS-1$

  private static final String CMDLINE_OPTION_NAMESPACE_ALIASES = "-namespaceAliases"; //$NON-NLS-1$

  private static final String CMDLINE_OPTION_TOC_FILENAME = "-tocFilename"; //$NON-NLS-1$

  private static final String CMDLINE_OPTION_TOC_REF_PREFIX = "-tocRefPrefix"; //$NON-NLS-1$

  private static final String CMDLINE_OPTION_TOC_TITLE = "-tocTitle"; //$NON-NLS-1$

  private static final String CMDLINE_OPTION_TOC_LINK_TO = "-tocLinkTo"; //$NON-NLS-1$

  private static String clientContext = ""; //$NON-NLS-1$

  private static NamespaceChecker namespaceChecker = null;

  private static AliasRegistry aliasRegistry = null;

  private static File tocFile = null;

  private static String tocRefPrefix = "reference/api/"; //$NON-NLS-1$

  private static String tocTitle = "API Reference"; //$NON-NLS-1$

  private static String tocLinkTo = ""; //$NON-NLS-1$

  public static boolean start(RootDoc root)
  {

    readOptions(root.options(), root);
    RootDoc rootDocProxy = getRootDocProxy(root);
    boolean startRet = Standard.start(rootDocProxy);
    outputToc(rootDocProxy);

    return startRet;
  }

  public static int optionLength(String option)
  {

    if (option.equals(CMDLINE_OPTION_CLIENT_CONTEXT))
    {
      return 2;
    }
    if (option.equals(CMDLINE_OPTION_NAMESPACE_ALIAS))
    {
      return 2;
    }
    if (option.equals(CMDLINE_OPTION_NAMESPACE_ALIASES))
    {
      return 2;
    }
    if (option.equals(CMDLINE_OPTION_TOC_FILENAME))
    {
      return 2;
    }
    if (option.equals(CMDLINE_OPTION_TOC_REF_PREFIX))
    {
      return 2;
    }
    if (option.equals(CMDLINE_OPTION_TOC_TITLE))
    {
      return 2;
    }
    if (option.equals(CMDLINE_OPTION_TOC_LINK_TO))
    {
      return 2;
    }
    return Standard.optionLength(option);
  }

  public static boolean validOptions(String options[][], DocErrorReporter reporter)
  {

    boolean foundClientContextOption = false;

    for (int i = 0; i < options.length; i++)
    {
      String[] opt = options[i];

      if (opt[0].equals(CMDLINE_OPTION_CLIENT_CONTEXT))
      {
        if (foundClientContextOption)
        {
          reporter.printError("Only one " + CMDLINE_OPTION_CLIENT_CONTEXT + " option allowed."); //$NON-NLS-1$ //$NON-NLS-2$
          return false;
        }
        else
        {
          foundClientContextOption = true;
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_NAMESPACE_ALIAS))
      {
        String arg = opt[1];
        int equalPos = arg.indexOf('=');
        if (equalPos <= 0 || equalPos >= arg.length() - 2)
        {
          reporter.printError("Invalid " + CMDLINE_OPTION_NAMESPACE_ALIAS + ": " + arg); //$NON-NLS-1$ //$NON-NLS-2$
          return false;
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_NAMESPACE_ALIASES))
      {
        String arg = opt[1];
        File file = new File(arg);
        if (!file.exists())
        {
          reporter.printError("No such file in " + CMDLINE_OPTION_NAMESPACE_ALIASES + ": " + arg); //$NON-NLS-1$ //$NON-NLS-2$
          return false;
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_FILENAME))
      {
        String arg = opt[1];
        if (arg == null || arg.length() == 0)
        {
          reporter.printError("Unable to create TOC file: \"" + arg + "\""); //$NON-NLS-1$ //$NON-NLS-2$
          return false;
        }
        else
        {
          File file = new File(arg);
          if (file.isDirectory())
          {
            reporter.printError("Unable to create TOC file: \"" + arg + "\" is a directory"); //$NON-NLS-1$ //$NON-NLS-2$
            return false;
          }
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_REF_PREFIX))
      {
        String arg = opt[1];
        if (arg == null || arg.length() == 0)
        {
          reporter.printError("Invalid " + CMDLINE_OPTION_TOC_REF_PREFIX + ": " + arg); //$NON-NLS-1$ //$NON-NLS-2$
          return false;
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_TITLE))
      {
        String arg = opt[1];
        if (arg == null || arg.length() == 0)
        {
          reporter.printError("Invalid " + CMDLINE_OPTION_TOC_TITLE + ": " + arg); //$NON-NLS-1$ //$NON-NLS-2$
          return false;
        }
      }
    }

    return Standard.validOptions(options, reporter);
  }

  private static void readOptions(String[][] options, DocErrorReporter reporter)
  {

    aliasRegistry = new AliasRegistry();

    for (int i = 0; i < options.length; i++)
    {
      String[] opt = options[i];
      if (opt[0].equals(CMDLINE_OPTION_CLIENT_CONTEXT))
      {
        clientContext = opt[1];
      }
      else if (opt[0].equals(CMDLINE_OPTION_NAMESPACE_ALIAS))
      {
        String arg = opt[1];
        int equalPos = arg.indexOf('=');
        if (equalPos > 0 && equalPos < arg.length() - 2)
        {
          String alias = arg.substring(0, equalPos);
          String value = arg.substring(equalPos + 1);
          aliasRegistry.registerAlias(alias, value);
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_NAMESPACE_ALIASES))
      {
        readNamespaceAliases(opt[1], reporter);
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_FILENAME))
      {
        String arg = opt[1];
        File file = new File(arg);
        try
        {
          file.delete();
          if (file.createNewFile())
          {
            tocFile = file;
            reporter.printNotice("TOC Pathname: " + file.getAbsolutePath()); //$NON-NLS-1$
          }
        }
        catch (IOException e)
        {
          reporter.printError("Could not create TOC file: \"" + arg + "\""); //$NON-NLS-1$ //$NON-NLS-2$
        }
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_REF_PREFIX))
      {
        tocRefPrefix = opt[1];
        reporter.printNotice("TOC REF Prefix: " + tocRefPrefix); //$NON-NLS-1$
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_TITLE))
      {
        tocTitle = opt[1];
        reporter.printNotice("TOC Title: " + tocTitle); //$NON-NLS-1$
      }
      else if (opt[0].equals(CMDLINE_OPTION_TOC_LINK_TO))
      {
        tocLinkTo = opt[1].trim();
        reporter.printNotice("TOC Link To: " + tocLinkTo); //$NON-NLS-1$
      }
    }

    /* Check for alias for the client context */
    String aliasValue = getAliasRegistry().getAliasValue(clientContext);
    if (aliasValue != null)
    {
      clientContext = aliasValue;
    }

  }

  private static void readNamespaceAliases(String fileName, DocErrorReporter reporter)
  {
    Properties namespaceAliases = new Properties();

    try
    {
      FileInputStream fis = new FileInputStream(fileName);
      namespaceAliases.load(fis);
      fis.close();

      for (Iterator iter = namespaceAliases.entrySet().iterator(); iter.hasNext();)
      {
        Map.Entry next = (Map.Entry)iter.next();

        aliasRegistry.registerAlias((String)next.getKey(), (String)next.getValue());
      }
    }
    catch (IOException e)
    {
      reporter.printError("Could not read namespace aliases from " + fileName //$NON-NLS-1$
        + ": " + e.getLocalizedMessage()); //$NON-NLS-1$
    }
  }

  public static NamespaceChecker getNamespaceChecker()
  {
    return namespaceChecker;
  }

  public static AliasRegistry getAliasRegistry()
  {
    return aliasRegistry;
  }

  private static RootDoc getRootDocProxy(RootDoc root)
  {

    MapsGenerator mapGenerator = new MapsGenerator(root, getAliasRegistry());

    namespaceChecker = new NamespaceChecker(clientContext, mapGenerator.getCanBeSeeByMap());

    RootDoc retRootDoc = ProxyFactory.getInstance().createRootDocProxy(root);
    // printOptions(retRootDoc.options());
    return retRootDoc;
  }

  private static void outputToc(RootDoc rootDoc)
  {
    if (tocFile == null)
      return;

    try
    {
      FileOutputStream fos = new FileOutputStream(tocFile);
      PrintWriter pw = new PrintWriter(fos);
      pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"); //$NON-NLS-1$
      pw.println("<?NLS TYPE=\"org.eclipse.help.toc\"?>"); //$NON-NLS-1$
      pw.println();

      String linkToText = ""; //$NON-NLS-1$
      if (tocLinkTo.length() > 0)
      {
        linkToText = " link_to=\"" + tocLinkTo + "\""; //$NON-NLS-1$ //$NON-NLS-2$
      }

      String tocText = "<toc" + linkToText + " label=\"Reference\">"; //$NON-NLS-1$ //$NON-NLS-2$ 
      pw.println(tocText);

      pw.println("\t<topic label=\"" + tocTitle + "\" href=\"" + tocRefPrefix + "overview-summary.html\">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

      /* Gather list of packages and sort by name */
      TreeSet treeSet = new TreeSet(Collator.getInstance());
      ClassDoc classDocs[] = rootDoc.classes();
      if (classDocs != null)
      {
        for (int i = 0; i < classDocs.length; i++)
        {
          ClassDoc classDoc = classDocs[i];
          PackageDoc packageDoc = classDoc.containingPackage();
          if (packageDoc != null)
          {
            treeSet.add(packageDoc.name());
          }
        }
      }

      /* Iterate over each package name and output a topic entry */
      for (Iterator iter = treeSet.iterator(); iter.hasNext();)
      {
        String packageName = (String)iter.next();
        String packagePath = packageName.replace('.', '/');
        pw.println("\t\t<topic label=\"" + packageName + "\" href=\"" + tocRefPrefix + packagePath + "/package-summary.html\" />"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }

      pw.println("\t</topic>"); //$NON-NLS-1$
      pw.println("</toc>"); //$NON-NLS-1$

      pw.close();

    }
    catch (FileNotFoundException e)
    {
      rootDoc.printError("Cannot find tocFile: " + tocFile.getAbsolutePath()); //$NON-NLS-1$
    }

  }

  // private static void printOptions(String options[][]) {
  // System.out.println();
  // System.out
  // .println("************************* START Options
  // ***************************"); //$NON-NLS-1$
  // System.out.println();
  // for (int i = 0; i < options.length; i++) {
  // String[] opt = options[i];
  // for (int j = 0; j < opt.length; j++) {
  // String string = opt[j];
  // System.out.print(string + " "); //$NON-NLS-1$
  // }
  // System.out.println();
  // }
  // System.out.println();
  // System.out
  // .println("************************* END Options
  // ***************************"); //$NON-NLS-1$
  // System.out.println();
  // }

}