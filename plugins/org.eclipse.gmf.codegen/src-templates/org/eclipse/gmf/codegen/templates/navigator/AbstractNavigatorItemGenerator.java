package org.eclipse.gmf.codegen.templates.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class AbstractNavigatorItemGenerator
{
  protected static String nl;
  public static synchronized AbstractNavigatorItemGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractNavigatorItemGenerator result = new AbstractNavigatorItemGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_6 = " implements ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tstatic {" + NL + "\t\tfinal Class[] supportedTypes = new Class[] { ";
  protected final String TEXT_8 = ".class };" + NL + "\t\tfinal ";
  protected final String TEXT_9 = " propertySheetPageContributor = new ";
  protected final String TEXT_10 = "() {" + NL + "\t\t\tpublic String getContributorId() {" + NL + "\t\t\t\treturn \"";
  protected final String TEXT_11 = "\"; //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t";
  protected final String TEXT_12 = ".getAdapterManager().registerAdapters(new ";
  protected final String TEXT_13 = "() {" + NL + "\t\t" + NL + "\t\t\tpublic Object getAdapter(Object adaptableObject, Class adapterType) {" + NL + "\t\t\t\tif (adaptableObject instanceof ";
  protected final String TEXT_14 = " && adapterType == ";
  protected final String TEXT_15 = ".class) {" + NL + "\t\t\t\t\treturn propertySheetPageContributor;\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic Class[] getAdapterList() {" + NL + "\t\t\t\treturn supportedTypes;" + NL + "\t\t\t}" + NL + "\t\t}, ";
  protected final String TEXT_16 = ".class);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate Object myParent;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected ";
  protected final String TEXT_17 = "(Object parent) {" + NL + "\t\tmyParent = parent;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object getParent() {" + NL + "\t\treturn myParent;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object getAdapter(Class adapter) {" + NL + "\t\treturn ";
  protected final String TEXT_18 = ".getAdapterManager().getAdapter(this, adapter);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNavigator.getAbstractNavigatorItemClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genNavigator.getEditorGen().getPlugin().getID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Platform"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdapterFactory"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genNavigator.getAbstractNavigatorItemClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genNavigator.getAbstractNavigatorItemClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genNavigator.getAbstractNavigatorItemClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Platform"));
    stringBuffer.append(TEXT_18);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
