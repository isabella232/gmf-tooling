package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LinkLabelTextEditPartGenerator
{
  protected static String nl;
  public static synchronized LinkLabelTextEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkLabelTextEditPartGenerator result = new LinkLabelTextEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends TextCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\treturn \"";
  protected final String TEXT_10 = "\";" + NL + "\t}";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\tString text = super.getLabelText();" + NL + "\t\tif (text == null || text.length() == 0) {" + NL + "\t\t\treturn \"";
  protected final String TEXT_12 = "\";" + NL + "\t\t}" + NL + "\t\treturn text;" + NL + "\t}";
  protected final String TEXT_13 = NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenLinkLabel genLabel = (GenLinkLabel) ((Object[]) argument)[0];
GenDiagram genDiagram = genLabel.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    if (genLabel.isReadOnly() || genLabel.getModelFacet() instanceof TextLabelModelFacet) {
    stringBuffer.append(TEXT_8);
    
}
if (genLabel.getModelFacet() instanceof TextLabelModelFacet) {
	TextLabelModelFacet modelFacet = (TextLabelModelFacet) genLabel.getModelFacet();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelFacet.getText());
    stringBuffer.append(TEXT_10);
    
} else if (genLabel.getModelFacet() instanceof FeatureLabelModelFacet) {
	String defaultText = ((FeatureLabelModelFacet) genLabel.getModelFacet()).getDefaultText();
	if (defaultText != null) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(defaultText);
    stringBuffer.append(TEXT_12);
    
	}
}

    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
