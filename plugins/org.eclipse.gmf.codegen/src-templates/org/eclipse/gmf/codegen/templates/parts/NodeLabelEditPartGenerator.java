package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class NodeLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized NodeLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeLabelEditPartGenerator result = new NodeLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends TextCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t\tsetNumIcons(1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Image getLabelIcon(int index) {" + NL + "\t\tImageDescriptor descriptor = ";
  protected final String TEXT_7 = ".getInstance().getItemImageDescriptor(resolveSemanticElement());" + NL + "\t\tif (descriptor == null) {" + NL + "\t\t\tdescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t}" + NL + "\t\treturn descriptor.createImage();" + NL + "\t}";
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
  protected final String TEXT_23 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void handleNotificationEvent(";
  protected final String TEXT_24 = " notification) {" + NL + "\t\tsuper.handleNotificationEvent(notification);" + NL + "\t\tObject feature = notification.getFeature();" + NL + "\t\tif (";
  protected final String TEXT_25 = ".eINSTANCE.getSize_Width().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_26 = ".eINSTANCE.getSize_Height().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_27 = ".eINSTANCE.getLocation_X().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_28 = ".eINSTANCE.getLocation_Y().equals(feature)) {" + NL + "\t\t\trefreshBounds();" + NL + "\t\t} " + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\tint width = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_29 = ".eINSTANCE.getSize_Width())).intValue();" + NL + "\t\tint height = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_30 = ".eINSTANCE.getSize_Height())).intValue();" + NL + "\t\t";
  protected final String TEXT_31 = " size = new ";
  protected final String TEXT_32 = "(width, height);" + NL + "\t\tint x = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_33 = ".eINSTANCE.getLocation_X())).intValue();" + NL + "\t\tint y = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_34 = ".eINSTANCE.getLocation_Y())).intValue();" + NL + "\t\t";
  protected final String TEXT_35 = " loc = new ";
  protected final String TEXT_36 = "(x, y);" + NL + "\t\t((";
  protected final String TEXT_37 = ") getParent()).setLayoutConstraint(this, getFigure(), new ";
  protected final String TEXT_38 = "(loc, size));" + NL + "\t}";
  protected final String TEXT_39 = NL + "}";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNodeLabel genLabel = (GenNodeLabel) argument;
GenDiagram genDiagram = genLabel.getDiagram();
boolean isParentFlowLayout = !genLabel.getNode().isListLayout();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
String accessorName = genLabel.getNode().getDomainMetaClass().getClassifierAccessorName();

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

    if (isParentFlowLayout) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
