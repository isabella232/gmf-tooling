package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = " getParser() {" + NL + "\t\tif (parser == null) {";
  protected final String TEXT_10 = NL + "\t\t\tparser = new ";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "().getEStructuralFeature(\"";
  protected final String TEXT_14 = "\"));";
  protected final String TEXT_15 = NL + "\t\t\t";
  protected final String TEXT_16 = " features = new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\tfeatures.add(";
  protected final String TEXT_20 = ".eINSTANCE.get";
  protected final String TEXT_21 = "().getEStructuralFeature(\"";
  protected final String TEXT_22 = "\"));";
  protected final String TEXT_23 = NL + "\t\t\tparser = new ";
  protected final String TEXT_24 = "(features);";
  protected final String TEXT_25 = "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t((";
  protected final String TEXT_27 = ") parser).setViewPattern(\"";
  protected final String TEXT_28 = "\");";
  protected final String TEXT_29 = NL + "\t\t\t((";
  protected final String TEXT_30 = ") parser).setEditPattern(\"";
  protected final String TEXT_31 = "\");";
  protected final String TEXT_32 = NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_33 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_34 = NL + "}";
  protected final String TEXT_35 = NL;

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
    stringBuffer.append(genLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_6);
    
String accessorName;
if (genLabel.getLink().getModelFacet() instanceof TypeLinkModelFacet) {
	TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLabel.getLink().getModelFacet();
	accessorName = modelFacet.getMetaClass().getClassifierAccessorName();
} else {
	FeatureModelFacet modelFacet = (FeatureModelFacet) genLabel.getLink().getModelFacet();
	accessorName = modelFacet.getMetaFeature().getGenClass().getClassifierAccessorName();
}

    stringBuffer.append(TEXT_7);
    
{
	GenPackage genPackage = genDiagram.getDomainMetaModel();
	String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
	LabelModelFacet modelFacet = genLabel.getModelFacet();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_9);
    
	String parserClassName;
	if (modelFacet instanceof FeatureModelFacet) {
		parserClassName = importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName());
		String featureName = ((FeatureModelFacet) modelFacet).getMetaFeature().getName();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_14);
    
	} else if (modelFacet instanceof CompositeFeatureModelFacet) {
		parserClassName = importManager.getImportedName(genDiagram.getStructuralFeaturesParserQualifiedClassName());
		java.util.List features = ((CompositeFeatureModelFacet) modelFacet).getMetaFeatures();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(features.size());
    stringBuffer.append(TEXT_18);
    
		for (java.util.Iterator it = features.iterator(); it.hasNext(); ) {
			String featureName = ((GenFeature) it.next()).getName();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_22);
    		}
    stringBuffer.append(TEXT_23);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_24);
    
	} else {
		throw new IllegalArgumentException();
	}

    stringBuffer.append(TEXT_25);
    	if (modelFacet.getViewPattern() != null && modelFacet.getViewPattern().length() != 0) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelFacet.getViewPattern());
    stringBuffer.append(TEXT_28);
    
	}
	if (modelFacet.getEditPattern() != null && modelFacet.getEditPattern().length() != 0) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelFacet.getEditPattern());
    stringBuffer.append(TEXT_31);
    	}
    stringBuffer.append(TEXT_32);
    	if (genLabel.isReadOnly()) {
    stringBuffer.append(TEXT_33);
    
	}
}

    stringBuffer.append(TEXT_34);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
