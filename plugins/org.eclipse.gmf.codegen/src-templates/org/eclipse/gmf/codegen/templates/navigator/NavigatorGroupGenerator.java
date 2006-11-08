package org.eclipse.gmf.codegen.templates.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NavigatorGroupGenerator
{
  protected static String nl;
  public static synchronized NavigatorGroupGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NavigatorGroupGenerator result = new NavigatorGroupGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate String myGroupName;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate String myIcon;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate ";
  protected final String TEXT_8 = " myChildren = new ";
  protected final String TEXT_9 = "();" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\t";
  protected final String TEXT_10 = "(String groupName, String icon, Object parent) {" + NL + "\t\tsuper(parent);" + NL + "\t\tmyGroupName = groupName;" + NL + "\t\tmyIcon = icon;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic String getGroupName() {" + NL + "\t\treturn myGroupName;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic String getIcon() {" + NL + "\t\treturn myIcon;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object[] getChildren() {" + NL + "\t\treturn myChildren.toArray();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic void addChildren(";
  protected final String TEXT_11 = " children) {" + NL + "\t\tmyChildren.addAll(children);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic void addChild(Object child) {" + NL + "\t\tmyChildren.add(child);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic boolean isEmpty() {" + NL + "\t\treturn myChildren.size() == 0;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (obj instanceof ";
  protected final String TEXT_12 = ") {" + NL + "\t\t\t";
  protected final String TEXT_13 = " anotherGroup = (";
  protected final String TEXT_14 = ") obj;" + NL + "\t\t\tif (getGroupName().equals(anotherGroup.getGroupName())) {" + NL + "\t\t\t\treturn getParent().equals(anotherGroup.getParent());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn super.equals(obj);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_15 = NL;

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
    stringBuffer.append(genNavigator.getNavigatorGroupClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genNavigator.getNavigatorGroupClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genNavigator.getNavigatorGroupClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genNavigator.getNavigatorGroupClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genNavigator.getNavigatorGroupClassName());
    stringBuffer.append(TEXT_14);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
