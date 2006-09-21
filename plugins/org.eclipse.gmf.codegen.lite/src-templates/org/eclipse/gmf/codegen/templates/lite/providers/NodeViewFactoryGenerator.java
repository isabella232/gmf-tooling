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
  protected final String TEXT_5 = " implements ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_7 = " INSTANCE = new ";
  protected final String TEXT_8 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void decorateView(";
  protected final String TEXT_9 = " view) {";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = "view.setType(";
  protected final String TEXT_12 = ".getType(";
  protected final String TEXT_13 = ".VISUAL_ID));" + NL + "\t\t";
  protected final String TEXT_14 = " style = ";
  protected final String TEXT_15 = ".eINSTANCE.createShapeStyle();" + NL + "\t\tview.getStyles().add(style);" + NL + "\t\t//XXX: init styles from attributes!!!";
  protected final String TEXT_16 = NL + "\t\tcreate";
  protected final String TEXT_17 = "Label(view);";
  protected final String TEXT_18 = NL + "\t\tcreate";
  protected final String TEXT_19 = "Compartment(view);";
  protected final String TEXT_20 = NL + "\t}" + NL;
  protected final String TEXT_21 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_22 = "Label(";
  protected final String TEXT_23 = " view) {" + NL + "\t\t";
  protected final String TEXT_24 = " label = ";
  protected final String TEXT_25 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(label);" + NL + "\t\t";
  protected final String TEXT_26 = ".INSTANCE.decorateView(label);" + NL + "\t}";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_29 = "Compartment(";
  protected final String TEXT_30 = " view) {" + NL + "\t\t";
  protected final String TEXT_31 = " compartment = ";
  protected final String TEXT_32 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(compartment);" + NL + "\t\t";
  protected final String TEXT_33 = ".INSTANCE.decorateView(compartment);" + NL + "\t}";
  protected final String TEXT_34 = NL + "}";
  protected final String TEXT_35 = NL;

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.ShapeStyle"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_15);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenNodeLabel label = (GenNodeLabel) it.next();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_17);
    
}/*iterate over labels*/

    
for (Iterator it = genElement.getCompartments().iterator(); it.hasNext(); ) {
	GenCompartment compartment = (GenCompartment) it.next();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_19);
    
}/*iterate over compartments*/

    stringBuffer.append(TEXT_20);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenNodeLabel label = (GenNodeLabel) it.next();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_27);
    
for (Iterator it = genElement.getCompartments().iterator(); it.hasNext(); ) {
	GenCompartment compartment = (GenCompartment) it.next();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(compartment.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    
}/*iterate over compartments*/

    stringBuffer.append(TEXT_34);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
