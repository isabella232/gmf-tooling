package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ChildNodeEditPartGenerator
{
  protected static String nl;
  public static synchronized ChildNodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ChildNodeEditPartGenerator result = new ChildNodeEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ListItemEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_7 = "());" + NL + "\t}" + NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\treturn \"";
  protected final String TEXT_11 = "\";" + NL + "\t}";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\tString text = super.getLabelText();" + NL + "\t\tif (text == null || text.length() == 0) {" + NL + "\t\t\treturn \"";
  protected final String TEXT_13 = "\";" + NL + "\t\t}" + NL + "\t\treturn text;" + NL + "\t}";
  protected final String TEXT_14 = NL + "}";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genChildNode = (GenNode) argument;
GenDiagram genDiagram = genChildNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genChildNode.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
GenNodeLabel genLabel = (GenNodeLabel) genChildNode.getLabels().get(0);

    stringBuffer.append(TEXT_8);
    if (genLabel.isReadOnly() || genLabel.getModelFacet() instanceof TextLabelModelFacet) {
    stringBuffer.append(TEXT_9);
    
}
if (genLabel.getModelFacet() instanceof TextLabelModelFacet) {
	TextLabelModelFacet modelFacet = (TextLabelModelFacet) genLabel.getModelFacet();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelFacet.getText());
    stringBuffer.append(TEXT_11);
    
} else if (genLabel.getModelFacet() instanceof FeatureLabelModelFacet) {
	String defaultText = ((FeatureLabelModelFacet) genLabel.getModelFacet()).getDefaultText();
	if (defaultText != null) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(defaultText);
    stringBuffer.append(TEXT_13);
    
	}
}

    stringBuffer.append(TEXT_14);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
