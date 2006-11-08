package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class MatchingStrategyGenerator
{
  protected static String nl;
  public static synchronized MatchingStrategyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MatchingStrategyGenerator result = new MatchingStrategyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean matches(";
  protected final String TEXT_8 = " editorRef, ";
  protected final String TEXT_9 = " input) {";
  protected final String TEXT_10 = NL + "        ";
  protected final String TEXT_11 = " editorInput;" + NL + "        try {" + NL + "            editorInput = editorRef.getEditorInput();" + NL + "        } catch (";
  protected final String TEXT_12 = " e) {" + NL + "            return false;" + NL + "        }" + NL + "        " + NL + "        if (editorInput.equals(input)) {" + NL + "        \treturn true;" + NL + "        }" + NL + "        ";
  protected final String TEXT_13 = NL + "        if (editorInput instanceof ";
  protected final String TEXT_14 = " && input instanceof ";
  protected final String TEXT_15 = ") {" + NL + "        \treturn ((";
  protected final String TEXT_16 = ") editorInput).getFile().equals(((";
  protected final String TEXT_17 = ") input).getFile());" + NL + "        }" + NL + "" + NL + "\t\t";
  protected final String TEXT_18 = " editor = editorRef.getEditor(false);" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_19 = " && editor instanceof ";
  protected final String TEXT_20 = ") {" + NL + "\t\t\t";
  protected final String TEXT_21 = " editorDiagram = ((";
  protected final String TEXT_22 = ") editor).getDiagram();" + NL + "\t\t\t";
  protected final String TEXT_23 = " otherDiagram = ((";
  protected final String TEXT_24 = ") input).getDiagram();" + NL + "\t\t\treturn equals(editorDiagram, otherDiagram);" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean equals(";
  protected final String TEXT_25 = " editorDiagram, ";
  protected final String TEXT_26 = " otherDiagram) {" + NL + "\t\t";
  protected final String TEXT_27 = " editorResource = editorDiagram.eResource();" + NL + "\t\t";
  protected final String TEXT_28 = " otherResource = otherDiagram.eResource();" + NL + "\t\tif (editorResource != null && otherResource != null) {" + NL + "\t\t\t";
  protected final String TEXT_29 = " editorURI = editorResource.getURI();" + NL + "\t\t\t";
  protected final String TEXT_30 = " otherURI = otherResource.getURI();" + NL + "\t\t\tString editorURIFragment = editorResource.getURIFragment(editorDiagram);" + NL + "\t\t\tString otherURIFragment = otherResource.getURIFragment(otherDiagram);" + NL + "\t\t\treturn editorURI.equals(otherURI) && editorURIFragment.equals(otherURIFragment);" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
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
    stringBuffer.append(genDiagram.getMatchingStrategyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorMatchingStrategy"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorReference"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_12);
     /* Workaround for IFileEditorInputProxy comparision.. */ 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_30);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
