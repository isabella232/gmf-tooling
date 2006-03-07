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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends ListItemEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_10 = "());" + NL + "\t}" + NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_13 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_14 = " figure = super.createFigure();" + NL + "\t\tif (figure instanceof ";
  protected final String TEXT_15 = ") {" + NL + "\t\t\tdefaultText = ((";
  protected final String TEXT_16 = ") figure).getText();" + NL + "\t\t} else if (figure instanceof ";
  protected final String TEXT_17 = ") {" + NL + "\t\t\tdefaultText = ((";
  protected final String TEXT_18 = ") figure).getText();" + NL + "\t\t}" + NL + "\t\treturn figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\tString text = super.getLabelText();" + NL + "\t\tif (text == null || text.length() == 0) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn text;" + NL + "\t}" + NL;
  protected final String TEXT_19 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_20 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_21 = " getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tString parserHint = ((View)getModel()).getType();";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = " element = resolveSemanticElement();" + NL + "\t\t\tif (element != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_24 = " hintAdapter = new ";
  protected final String TEXT_25 = "(element, parserHint) {" + NL + "\t\t\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_26 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getAdapter(adapter);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tparser = ";
  protected final String TEXT_29 = ".getInstance().getParser(hintAdapter);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}" + NL + "}";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genChildNode = (GenNode) ((Object[]) argument)[0];
GenDiagram genDiagram = genChildNode.getDiagram();

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
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genChildNode.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    
GenNodeLabel genLabel = (GenNodeLabel) genChildNode.getLabels().get(0);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_18);
    if (genLabel.isReadOnly()) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_21);
    
GenCommonBase genHost;
if (genLabel instanceof GenNodeLabel) {
	genHost = ((GenNodeLabel) genLabel).getNode();
} else if (genLabel instanceof GenLinkLabel) {
	genHost = ((GenLinkLabel) genLabel).getLink();
} else {
	throw new IllegalArgumentException("Unknown label type: " + genLabel);
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genHost.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserService"));
    stringBuffer.append(TEXT_29);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
