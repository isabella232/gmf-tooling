package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class LinkLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized LinkLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkLabelEditPartGenerator result = new LinkLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.ConnectionLocator;" + NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends LabelEditPart {" + NL + "" + NL + "\tstatic {" + NL + "\t\tregisterSnapBackPosition(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = "Labels.";
  protected final String TEXT_8 = ", new Point(0, 0));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getKeyPoint() {" + NL + "\t\treturn ConnectionLocator.";
  protected final String TEXT_10 = ";" + NL + "\t}" + NL + "}";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenLinkLabel genLabel = (GenLinkLabel) argument;
GenDiagram genDiagram = genLabel.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genLabel.getLink().getUniqueIdentifier());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genLabel.getSemanticHintLabelFieldName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genLabel.getAlignment());
    stringBuffer.append(TEXT_10);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
