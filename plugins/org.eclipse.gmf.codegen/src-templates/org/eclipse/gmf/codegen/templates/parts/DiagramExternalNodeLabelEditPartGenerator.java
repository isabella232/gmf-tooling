package org.eclipse.gmf.codegen.templates.parts;

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
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.geometry.Dimension;" + NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.gef.GraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.figures.LabelLocator;" + NL + "import org.eclipse.gmf.runtime.notation.NotationPackage;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends LabelEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int BOTTOM_GAP = 5;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void refreshBounds() {" + NL + "\t\tIFigure refFigure = ((GraphicalEditPart) getParent()).getFigure();" + NL + "\t\tint dx = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();" + NL + "\t\tint dy = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();" + NL + "\t\tPoint offset = new Point(dx, dy);" + NL + "\t\tgetFigure().getParent().setConstraint(getFigure(), new LabelLocator(refFigure, offset, getKeyPoint()) {" + NL + "" + NL + "\t\t\tpublic void relocate(IFigure target) {" + NL + "\t\t\t\tPoint location = getReferencePoint().getTranslated(getOffset());" + NL + "\t\t\t\tlocation.translate(-target.getBounds().width / 2, 0);" + NL + "\t\t\t\ttarget.setLocation(location);" + NL + "\t\t\t\ttarget.setSize(new Dimension(target.getPreferredSize().width, target.getPreferredSize().height));" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprotected Point getReferencePoint() {" + NL + "\t\t\t\treturn getLabelLocation(parent);" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Point getReferencePoint() {" + NL + "\t\treturn getLabelLocation(((GraphicalEditPart) getParent()).getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Point getLabelLocation(IFigure parent) {" + NL + "\t\treturn parent.getBounds().getBottom().getTranslated(0, BOTTOM_GAP);" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

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
    stringBuffer.append(genDiagram.getBaseExternalNodeLabelEditPartClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getBaseExternalNodeLabelEditPartClassName());
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
