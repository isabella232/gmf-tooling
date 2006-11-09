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
  protected final String TEXT_9 = " view) {" + NL + "\t\tif (view.eIsSet(";
  protected final String TEXT_10 = ".eINSTANCE.getView_Type())) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = "view.setType(";
  protected final String TEXT_13 = ".getType(";
  protected final String TEXT_14 = ".VISUAL_ID));" + NL + "\t\t";
  protected final String TEXT_15 = " style = ";
  protected final String TEXT_16 = ".eINSTANCE.createShapeStyle();" + NL + "\t\tview.getStyles().add(style);" + NL + "\t\t//XXX: init styles from attributes!!!";
  protected final String TEXT_17 = NL + "\t\tcreate";
  protected final String TEXT_18 = "Label(view);";
  protected final String TEXT_19 = NL + "\t\tcreate";
  protected final String TEXT_20 = "Compartment(view);";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = " diagramFacet = ";
  protected final String TEXT_24 = ".eINSTANCE.createEAnnotation();" + NL + "\t\tdiagramFacet.setSource(\"";
  protected final String TEXT_25 = "\");" + NL + "\t\tview.getEAnnotations().add(diagramFacet);";
  protected final String TEXT_26 = NL + "\t}" + NL;
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_28 = "Label(";
  protected final String TEXT_29 = " view) {" + NL + "\t\t";
  protected final String TEXT_30 = " label = ";
  protected final String TEXT_31 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(label);" + NL + "\t\t";
  protected final String TEXT_32 = ".INSTANCE.decorateView(label);" + NL + "\t}";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_35 = "Compartment(";
  protected final String TEXT_36 = " view) {" + NL + "\t\t";
  protected final String TEXT_37 = " compartment = ";
  protected final String TEXT_38 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(compartment);" + NL + "\t\t";
  protected final String TEXT_39 = ".INSTANCE.decorateView(compartment);" + NL + "\t}";
  protected final String TEXT_40 = NL + "}";
  protected final String TEXT_41 = NL;

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genElement.getDiagram().getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genElement.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.ShapeStyle"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_16);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenNodeLabel label = (GenNodeLabel) it.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_18);
    
}/*iterate over labels*/

    
for (Iterator it = genElement.getCompartments().iterator(); it.hasNext(); ) {
	GenCompartment compartment = (GenCompartment) it.next();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_20);
    
}/*iterate over compartments*/

    stringBuffer.append(TEXT_21);
    
if (genElement.getBehaviour(OpenDiagramBehaviour.class).size() == 1) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(org.eclipse.gmf.codegen.gmfgen.impl.OpenDiagramBehaviourImpl.ANNOTATION_SOURCE);
    stringBuffer.append(TEXT_25);
    
}

    stringBuffer.append(TEXT_26);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenNodeLabel label = (GenNodeLabel) it.next();

    stringBuffer.append(TEXT_27);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_33);
    
for (Iterator it = genElement.getCompartments().iterator(); it.hasNext(); ) {
	GenCompartment compartment = (GenCompartment) it.next();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(compartment.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    
}/*iterate over compartments*/

    stringBuffer.append(TEXT_40);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
