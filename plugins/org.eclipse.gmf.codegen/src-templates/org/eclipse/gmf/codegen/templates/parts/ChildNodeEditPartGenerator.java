package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = " getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tparser = new ";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "().getEStructuralFeature(\"";
  protected final String TEXT_14 = "\"));";
  protected final String TEXT_15 = NL + "\t\t\t((";
  protected final String TEXT_16 = ") parser).setViewPattern(\"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "\t\t\t((";
  protected final String TEXT_19 = ") parser).setEditPattern(\"";
  protected final String TEXT_20 = "\");";
  protected final String TEXT_21 = NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_22 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_23 = NL + "}";
  protected final String TEXT_24 = NL;

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
String accessorName = genChildNode.getDomainMetaClass().getClassifierAccessorName();

    stringBuffer.append(TEXT_8);
    
{
	GenPackage genPackage = genDiagram.getDomainMetaModel();
	String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
	FeatureModelFacet modelFacet = (FeatureModelFacet) genLabel.getModelFacet();
	String featureName = modelFacet.getMetaFeature().getName();
	String parserClassName = importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName());

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_14);
    	if (modelFacet.getViewPattern() != null && modelFacet.getViewPattern().length() != 0) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelFacet.getViewPattern());
    stringBuffer.append(TEXT_17);
    
	}
	if (modelFacet.getEditPattern() != null && modelFacet.getEditPattern().length() != 0) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelFacet.getEditPattern());
    stringBuffer.append(TEXT_20);
    	}
    stringBuffer.append(TEXT_21);
    	if (genLabel.isReadOnly()) {
    stringBuffer.append(TEXT_22);
    
	}
}

    stringBuffer.append(TEXT_23);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
