package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class PropertySourceProviderGenerator
{
  protected static String nl;
  public static synchronized PropertySourceProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PropertySourceProviderGenerator result = new PropertySourceProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " adapterFactoryContentProvider;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = " domainAdapterFactory) {" + NL + "\t\tadapterFactoryContentProvider = new ";
  protected final String TEXT_10 = "(domainAdapterFactory);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_11 = " getPropertySource(Object object) {" + NL + "\t\tif (object instanceof ";
  protected final String TEXT_12 = ") {" + NL + "\t\t\treturn (";
  protected final String TEXT_13 = ") object;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_14 = " view = getNotationElement(object);" + NL + "\t\tif (view == null) {" + NL + "\t\t\treturn adapterFactoryContentProvider.getPropertySource(object);" + NL + "\t\t}" + NL + "\t\t//XXX: compose with view properties" + NL + "\t\t";
  protected final String TEXT_15 = " domainElement = view.getElement();" + NL + "\t\treturn adapterFactoryContentProvider.getPropertySource(domainElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_16 = " getNotationElement(Object object) {" + NL + "\t\t";
  protected final String TEXT_17 = " view = null;" + NL + "\t\tif (object instanceof ";
  protected final String TEXT_18 = ") {" + NL + "\t\t\tview = (";
  protected final String TEXT_19 = ") object;" + NL + "\t\t} else if (object instanceof ";
  protected final String TEXT_20 = ") {" + NL + "\t\t\t";
  protected final String TEXT_21 = " editPart = (";
  protected final String TEXT_22 = ") object;" + NL + "\t\t\tif (editPart.getModel() instanceof ";
  protected final String TEXT_23 = ") {" + NL + "\t\t\t\tview = (";
  protected final String TEXT_24 = ") editPart.getModel();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (view != null && \"";
  protected final String TEXT_25 = "\".equals(";
  protected final String TEXT_26 = ".getModelID(view))) {" + NL + "\t\t\treturn view;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getPropertyProviderClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySourceProvider"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getPropertyProviderClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.AdapterFactory"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySource"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySource"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySource"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
