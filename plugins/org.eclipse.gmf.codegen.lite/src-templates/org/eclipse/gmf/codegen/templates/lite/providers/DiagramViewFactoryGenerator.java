package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramViewFactoryGenerator
{
  protected static String nl;
  public static synchronized DiagramViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramViewFactoryGenerator result = new DiagramViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void decorateView(";
  protected final String TEXT_6 = " view) {";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " annotation = ";
  protected final String TEXT_9 = ".eINSTANCE.createEAnnotation();" + NL + "annotation.setSource(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "view.getEAnnotations().add(annotation);" + NL + "annotation.getDetails().put(\"modelID\", \"";
  protected final String TEXT_10 = "\"); //$NON-NLS-1$" + NL + "annotation.getDetails().put(\"visualID\", \"";
  protected final String TEXT_11 = "\"); //$NON-NLS-1$" + NL + "\t\t";
  protected final String TEXT_12 = " style = ";
  protected final String TEXT_13 = ".eINSTANCE.createDiagramStyle();" + NL + "\t\tview.getStyles().add(style);" + NL + "\t\t//XXX: init styles from attributes!!!" + NL + "\t}" + NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
GenDiagram genElement = genDiagram;		/*make jetinc happy*/
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.DiagramStyle"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
