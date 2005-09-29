package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class NodeEditPartGenerator
{
  protected static String nl;
  public static synchronized NodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeEditPartGenerator result = new NodeEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.draw2d.Figure;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.StackLayout;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapMode;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends ShapeNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodeFigure() {" + NL + "\t\tNodeFigure node = new DefaultSizeNodeFigure(MapMode.DPtoLP(50), MapMode.DPtoLP(50)) {" + NL + "" + NL + "\t\t\tprotected void paintFigure(Graphics graphics) {" + NL + "\t\t\t\tsuper.paintFigure(graphics);" + NL + "\t\t\t\tgraphics.drawRectangle(getClientArea());" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tnode.setLayoutManager(new StackLayout());" + NL + "\t\tnode.add(contentPane = createContentPane());" + NL + "\t\treturn node;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createContentPane() {" + NL + "\t\tIFigure plate = new Figure();" + NL + "\t\tConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();" + NL + "\t\tlayout.setSpacing(MapMode.DPtoLP(5));" + NL + "\t\tplate.setLayoutManager(layout);" + NL + "\t\treturn plate;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ");" + NL + "\t}";
  protected final String TEXT_12 = NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) argument;
GenDiagram genDiagram = genNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    if (genNode.hasNameToEdit()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genNode));
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_8);
    if (genNode.hasNameToEdit()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genNode));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genNode));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
