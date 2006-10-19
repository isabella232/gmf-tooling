package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LabelViewFactoryGenerator
{
  protected static String nl;
  public static synchronized LabelViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LabelViewFactoryGenerator result = new LabelViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_7 = " INSTANCE = new ";
  protected final String TEXT_8 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void decorateView(";
  protected final String TEXT_9 = " view) {";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = "view.setType(";
  protected final String TEXT_12 = ".getType(";
  protected final String TEXT_13 = ".VISUAL_ID));";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = " location = ";
  protected final String TEXT_16 = ".eINSTANCE.createLocation();" + NL + "\t\t((";
  protected final String TEXT_17 = ")view).setLayoutConstraint(location);";
  protected final String TEXT_18 = NL + "\t}" + NL + "}";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
GenDiagram genDiagram = genElement.getDiagram();
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

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
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IViewDecorator"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genElement.getDiagram().getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genElement.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    
if (genElement instanceof GenLinkLabel || genElement instanceof GenExternalNodeLabel) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Location"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
