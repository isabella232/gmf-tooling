package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;

public class LinkViewFactoryGenerator
{
  protected static String nl;
  public static synchronized LinkViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkViewFactoryGenerator result = new LinkViewFactoryGenerator();
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
  protected final String TEXT_14 = ".VISUAL_ID));" + NL + "\t\t//XXX: init styles from attributes!!!";
  protected final String TEXT_15 = NL + "\t\tcreate";
  protected final String TEXT_16 = "Label(view);";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = " diagramFacet = ";
  protected final String TEXT_20 = ".eINSTANCE.createEAnnotation();" + NL + "\t\tdiagramFacet.setSource(\"";
  protected final String TEXT_21 = "\");" + NL + "\t\tview.getEAnnotations().add(diagramFacet);";
  protected final String TEXT_22 = NL + "\t}" + NL;
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_24 = "Label(";
  protected final String TEXT_25 = " view) {" + NL + "\t\t";
  protected final String TEXT_26 = " label = ";
  protected final String TEXT_27 = ".eINSTANCE.createNode();" + NL + "\t\tview.getPersistedChildren().add(label);" + NL + "\t\t";
  protected final String TEXT_28 = ".INSTANCE.decorateView(label);" + NL + "\t}";
  protected final String TEXT_29 = NL + "}";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenLink genElement = (GenLink) ((Object[]) argument)[0];
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
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenLinkLabel label = (GenLinkLabel) it.next();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_16);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_17);
    
if (genElement.getBehaviour(OpenDiagramBehaviour.class).size() == 1) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(org.eclipse.gmf.codegen.gmfgen.impl.OpenDiagramBehaviourImpl.ANNOTATION_SOURCE);
    stringBuffer.append(TEXT_21);
    
}

    stringBuffer.append(TEXT_22);
    
for (Iterator it = genElement.getLabels().iterator(); it.hasNext(); ) {
	GenLinkLabel label = (GenLinkLabel) it.next();

    stringBuffer.append(TEXT_23);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    
}/*iterate over labels*/

    stringBuffer.append(TEXT_29);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
