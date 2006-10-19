package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramExternalNodeLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized DiagramExternalNodeLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramExternalNodeLabelEditPartGenerator result = new DiagramExternalNodeLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.gef.GraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "(View view) {" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_9 = " node = (";
  protected final String TEXT_10 = ") getModel();" + NL + "\t\tif (node.getLayoutConstraint() == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_11 = ";" + NL + "\t\tfinal ";
  protected final String TEXT_12 = " location = (";
  protected final String TEXT_13 = ") node.getLayoutConstraint();" + NL + "\t\tgetFigure().getParent().setConstraint(getFigure(), new ";
  protected final String TEXT_14 = "() {" + NL + "\t\t\tprotected Point getReferencePoint() {" + NL + "\t\t\t\treturn getLabelLocation(((GraphicalEditPart) getParent()).getFigure()).translate(location.getX(), location.getY());" + NL + "\t\t\t}" + NL + "\t\t\tpublic int getRelativePosition() {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_15 = ".SOUTH;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_16 = ".Refresher boundsRefresher = new ";
  protected final String TEXT_17 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshBounds();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Point getReferencePoint() {" + NL + "\t\treturn getLabelLocation(((GraphicalEditPart) getParent()).getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Point getLabelLocation(IFigure parent) {" + NL + "\t\treturn parent.getBounds().getBottom();" + NL + "\t}" + NL + "}";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getBaseExternalNodeLabelEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getBaseExternalNodeLabelEditPartClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Location"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Location"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Location"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.AbstractLocator"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_17);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
