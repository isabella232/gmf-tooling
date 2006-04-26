package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;

public class NodeViewFactoryGenerator
{
  protected static String nl;
  public static synchronized NodeViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeViewFactoryGenerator result = new NodeViewFactoryGenerator();
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
  protected final String TEXT_8 = "view.setType(";
  protected final String TEXT_9 = ".getType(";
  protected final String TEXT_10 = ".VISUAL_ID));" + NL + "\t\t";
  protected final String TEXT_11 = " style = ";
  protected final String TEXT_12 = ".eINSTANCE.createShapeStyle();" + NL + "\t\tview.getStyles().add(style);" + NL + "\t\t//XXX: init styles from attributes!!!";
  protected final String TEXT_13 = NL + "\t\tcreate";
  protected final String TEXT_14 = "Label(view);";
  protected final String TEXT_15 = NL + "\t\tcreate";
  protected final String TEXT_16 = "Compartment(view);";
  protected final String TEXT_17 = NL + "\t}" + NL;
  protected final String TEXT_18 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void create";
  protected final String TEXT_19 = "Label(";
  protected final String TEXT_20 = " view) {" + NL + "\t\t";
  protected final String TEXT_21 = " label = ";
  protected final String TEXT_22 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(label);" + NL + "\t\tlabel.setElement(null);" + NL + "\t\t";
  protected final String TEXT_23 = ".decorateView(label);" + NL + "\t}";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void create";
  protected final String TEXT_26 = "Compartment(";
  protected final String TEXT_27 = " view) {" + NL + "\t\t";
  protected final String TEXT_28 = " compartment = ";
  protected final String TEXT_29 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(compartment);" + NL + "\t\tcompartment.setElement(null);" + NL + "\t\t";
  protected final String TEXT_30 = ".decorateView(compartment);" + NL + "\t}";
  protected final String TEXT_31 = NL + "}";
  protected final String TEXT_32 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNode genElement = (GenNode) ((Object[]) argument)[0];
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genElement.getDiagram().getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genElement.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.ShapeStyle"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_12);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenNodeLabel label = (GenNodeLabel) it.next();

    stringBuffer.append(TEXT_13);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_14);
    
}/*iterate over labels*/

    
for (Iterator it = genElement.getCompartments().iterator(); it.hasNext(); ) {
	GenCompartment compartment = (GenCompartment) it.next();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_16);
    
}/*iterate over compartments*/

    stringBuffer.append(TEXT_17);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenNodeLabel label = (GenNodeLabel) it.next();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_24);
    
for (Iterator it = genElement.getCompartments().iterator(); it.hasNext(); ) {
	GenCompartment compartment = (GenCompartment) it.next();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(compartment.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    
}/*iterate over compartments*/

    stringBuffer.append(TEXT_31);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
