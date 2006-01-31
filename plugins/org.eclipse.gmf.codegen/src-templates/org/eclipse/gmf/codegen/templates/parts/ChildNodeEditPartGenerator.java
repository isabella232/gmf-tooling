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
  protected final String TEXT_10 = " getParser() {" + NL + "\t\tif (parser == null) {";
  protected final String TEXT_11 = NL + "\t\t\tparser = new ";
  protected final String TEXT_12 = "(";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "().getEStructuralFeature(\"";
  protected final String TEXT_15 = "\"));";
  protected final String TEXT_16 = NL + "\t\t\t";
  protected final String TEXT_17 = " features = new ";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t\tfeatures.add(";
  protected final String TEXT_21 = ".eINSTANCE.get";
  protected final String TEXT_22 = "().getEStructuralFeature(\"";
  protected final String TEXT_23 = "\"));";
  protected final String TEXT_24 = NL + "\t\t\tparser = new ";
  protected final String TEXT_25 = "(features);";
  protected final String TEXT_26 = "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t((";
  protected final String TEXT_28 = ") parser).setViewPattern(\"";
  protected final String TEXT_29 = "\");";
  protected final String TEXT_30 = NL + "\t\t\t((";
  protected final String TEXT_31 = ") parser).setEditPattern(\"";
  protected final String TEXT_32 = "\");";
  protected final String TEXT_33 = NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_34 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_35 = NL + "}";
  protected final String TEXT_36 = NL;

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
	LabelModelFacet modelFacet = genLabel.getModelFacet();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_10);
    
	String parserClassName;
	if (modelFacet instanceof FeatureModelFacet) {
		parserClassName = importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName());
		String featureName = ((FeatureModelFacet) modelFacet).getMetaFeature().getName();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_15);
    
	} else if (modelFacet instanceof CompositeFeatureModelFacet) {
		parserClassName = importManager.getImportedName(genDiagram.getStructuralFeaturesParserQualifiedClassName());
		java.util.List features = ((CompositeFeatureModelFacet) modelFacet).getMetaFeatures();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(features.size());
    stringBuffer.append(TEXT_19);
    
		for (java.util.Iterator it = features.iterator(); it.hasNext(); ) {
			String featureName = ((GenFeature) it.next()).getName();

    stringBuffer.append(TEXT_20);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_23);
    		}
    stringBuffer.append(TEXT_24);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_25);
    
	} else {
		throw new IllegalArgumentException();
	}

    stringBuffer.append(TEXT_26);
    	if (modelFacet.getViewPattern() != null && modelFacet.getViewPattern().length() != 0) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelFacet.getViewPattern());
    stringBuffer.append(TEXT_29);
    
	}
	if (modelFacet.getEditPattern() != null && modelFacet.getEditPattern().length() != 0) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelFacet.getEditPattern());
    stringBuffer.append(TEXT_32);
    	}
    stringBuffer.append(TEXT_33);
    	if (genLabel.isReadOnly()) {
    stringBuffer.append(TEXT_34);
    
	}
}

    stringBuffer.append(TEXT_35);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
