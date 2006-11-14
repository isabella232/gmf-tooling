package org.eclipse.gmf.codegen.templates.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NavigatorItemGenerator
{
  protected static String nl;
  public static synchronized NavigatorItemGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NavigatorItemGenerator result = new NavigatorItemGenerator();
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
  protected final String TEXT_7 = " {" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tstatic {" + NL + "\t\tfinal Class[] supportedTypes = new Class[] { ";
  protected final String TEXT_8 = ".class, ";
  protected final String TEXT_9 = ".class };" + NL + "\t\t";
  protected final String TEXT_10 = ".getAdapterManager().registerAdapters(new ";
  protected final String TEXT_11 = "() {" + NL + "\t\t" + NL + "\t\t\tpublic Object getAdapter(Object adaptableObject, Class adapterType) {" + NL + "\t\t\t\tif (adaptableObject instanceof ";
  protected final String TEXT_12 = " && (adapterType == ";
  protected final String TEXT_13 = ".class || adapterType == ";
  protected final String TEXT_14 = ".class)) {" + NL + "\t\t\t\t\treturn ((";
  protected final String TEXT_15 = ") adaptableObject).getView();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic Class[] getAdapterList() {" + NL + "\t\t\t\treturn supportedTypes;" + NL + "\t\t\t}" + NL + "\t\t}, ";
  protected final String TEXT_16 = ".class);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate ";
  protected final String TEXT_17 = " myView;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate boolean myLeaf = false;\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic ";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = " view, Object parent, boolean isLeaf) {" + NL + "\t\tsuper(parent);" + NL + "\t\tmyView = view;" + NL + "\t\tmyLeaf = isLeaf;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic ";
  protected final String TEXT_20 = " getView() {" + NL + "\t\treturn myView;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic boolean isLeaf() {" + NL + "\t\treturn myLeaf;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (obj instanceof ";
  protected final String TEXT_21 = ") {" + NL + "\t\t\t";
  protected final String TEXT_22 = " eObject = getView().getElement();" + NL + "\t\t\t";
  protected final String TEXT_23 = " anotherEObject = ((";
  protected final String TEXT_24 = ") obj).getView().getElement();" + NL + "\t\t\tif (eObject == null) {" + NL + "\t\t\t\treturn anotherEObject == null;" + NL + "\t\t\t} else if (anotherEObject == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tif (eObject.eResource() != null) {" + NL + "\t\t\t\treturn eObject.eResource().getURIFragment(eObject).equals(anotherEObject.eResource().getURIFragment(anotherEObject));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn super.equals(obj);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_25 = NL;

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
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Platform"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdapterFactory"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genNavigator.getNavigatorItemClassName());
    stringBuffer.append(TEXT_24);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
