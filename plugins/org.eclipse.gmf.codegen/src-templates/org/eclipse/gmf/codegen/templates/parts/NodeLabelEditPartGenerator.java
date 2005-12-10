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
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends TextCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t\tsetNumIcons(1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Image getLabelIcon(int index) {" + NL + "\t\tImageDescriptor descriptor = ";
  protected final String TEXT_7 = ".getInstance().getItemImageDescriptor(resolveSemanticElement());" + NL + "\t\tif (descriptor == null) {" + NL + "\t\t\tdescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t}" + NL + "\t\treturn descriptor.createImage();" + NL + "\t}";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParser getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tparser = new ";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = ".eINSTANCE.get";
  protected final String TEXT_11 = "().getEStructuralFeature(\"";
  protected final String TEXT_12 = "\"));" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_13 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void handleNotificationEvent(";
  protected final String TEXT_14 = " notification) {" + NL + "\t\tsuper.handleNotificationEvent(notification);" + NL + "\t\tObject feature = notification.getFeature();" + NL + "\t\tif (";
  protected final String TEXT_15 = ".eINSTANCE.getSize_Width().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_16 = ".eINSTANCE.getSize_Height().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_17 = ".eINSTANCE.getLocation_X().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_18 = ".eINSTANCE.getLocation_Y().equals(feature)) {" + NL + "\t\t\trefreshBounds();" + NL + "\t\t} " + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\tint width = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_19 = ".eINSTANCE.getSize_Width())).intValue();" + NL + "\t\tint height = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_20 = ".eINSTANCE.getSize_Height())).intValue();" + NL + "\t\t";
  protected final String TEXT_21 = " size = new ";
  protected final String TEXT_22 = "(width, height);" + NL + "\t\tint x = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_23 = ".eINSTANCE.getLocation_X())).intValue();" + NL + "\t\tint y = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_24 = ".eINSTANCE.getLocation_Y())).intValue();" + NL + "\t\t";
  protected final String TEXT_25 = " loc = new ";
  protected final String TEXT_26 = "(x, y);" + NL + "\t\t((";
  protected final String TEXT_27 = ") getParent()).setLayoutConstraint(this, getFigure(), new ";
  protected final String TEXT_28 = "(loc, size));" + NL + "\t}";
  protected final String TEXT_29 = NL + "}";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNodeLabel label = (GenNodeLabel) argument;
GenDiagram genDiagram = label.getDiagram();
boolean isParentFlowLayout = label.getNode().getChildContainersPlacement() == CompartmentPlacementKind.FLOW_LITERAL;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
String accessorName = label.getNode().getDomainMetaClass().getClassifierAccessorName();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(label.getMetaFeature().getName());
    stringBuffer.append(TEXT_12);
    
if (isParentFlowLayout) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_28);
    
}

    stringBuffer.append(TEXT_29);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
