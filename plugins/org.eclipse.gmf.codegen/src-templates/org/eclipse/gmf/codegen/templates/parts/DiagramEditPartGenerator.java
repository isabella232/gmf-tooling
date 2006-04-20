package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramEditPartGenerator
{
  protected static String nl;
  public static synchronized DiagramEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditPartGenerator result = new DiagramEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends DiagramEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String MODEL_ID = \"";
  protected final String TEXT_9 = "\";";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_14 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_15 = "());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_16 = "());" + NL + "\t}" + NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_9);
    {
GenCommonBase genCommonBase = genDiagram;
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCanonicalEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
