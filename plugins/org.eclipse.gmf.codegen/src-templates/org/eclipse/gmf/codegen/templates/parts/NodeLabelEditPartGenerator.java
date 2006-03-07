package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends TextCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t\tsetNumIcons(1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Image getLabelIcon(int index) {" + NL + "\t\tImageDescriptor descriptor = ";
  protected final String TEXT_10 = ".getInstance().getItemImageDescriptor(resolveSemanticElement());" + NL + "\t\tif (descriptor == null) {" + NL + "\t\t\tdescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t}" + NL + "\t\treturn descriptor.createImage();" + NL + "\t}";
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
  protected final String TEXT_29 = ".getInstance().getParser(hintAdapter);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_30 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void handleNotificationEvent(";
  protected final String TEXT_31 = " notification) {" + NL + "\t\tsuper.handleNotificationEvent(notification);" + NL + "\t\tObject feature = notification.getFeature();" + NL + "\t\tif (";
  protected final String TEXT_32 = ".eINSTANCE.getSize_Width().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_33 = ".eINSTANCE.getSize_Height().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_34 = ".eINSTANCE.getLocation_X().equals(feature)" + NL + "\t\t\t|| ";
  protected final String TEXT_35 = ".eINSTANCE.getLocation_Y().equals(feature)) {" + NL + "\t\t\trefreshBounds();" + NL + "\t\t} " + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\tint width = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_36 = ".eINSTANCE.getSize_Width())).intValue();" + NL + "\t\tint height = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_37 = ".eINSTANCE.getSize_Height())).intValue();" + NL + "\t\t";
  protected final String TEXT_38 = " size = new ";
  protected final String TEXT_39 = "(width, height);" + NL + "\t\tint x = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_40 = ".eINSTANCE.getLocation_X())).intValue();" + NL + "\t\tint y = ((Integer) getStructuralFeatureValue(";
  protected final String TEXT_41 = ".eINSTANCE.getLocation_Y())).intValue();" + NL + "\t\t";
  protected final String TEXT_42 = " loc = new ";
  protected final String TEXT_43 = "(x, y);" + NL + "\t\t((";
  protected final String TEXT_44 = ") getParent()).setLayoutConstraint(this, getFigure(), new ";
  protected final String TEXT_45 = "(loc, size));" + NL + "\t}";
  protected final String TEXT_46 = NL + "}";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNodeLabel genLabel = (GenNodeLabel) ((Object[]) argument)[0];
GenDiagram genDiagram = genLabel.getDiagram();
boolean isParentFlowLayout = !genLabel.getNode().isListLayout();

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
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_10);
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
    if (isParentFlowLayout) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
