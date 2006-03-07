package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ExternalNodeLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized ExternalNodeLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ExternalNodeLabelEditPartGenerator result = new ExternalNodeLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends ";
  protected final String TEXT_9 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic {" + NL + "\t\tregisterSnapBackPosition(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "Labels.";
  protected final String TEXT_12 = ", new Point(0, 0));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenExternalNodeLabel genLabel = (GenExternalNodeLabel) ((Object[]) argument)[0];
GenDiagram genDiagram = genLabel.getDiagram();

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
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getBaseExternalNodeLabelEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genLabel.getNode().getUniqueIdentifier());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genLabel.getSemanticHintLabelFieldName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
