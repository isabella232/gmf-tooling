package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;
import java.util.*;

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
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.Figure;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.StackLayout;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapMode;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ShapeNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodeFigure() {";
  protected final String TEXT_7 = " " + NL + "\t\t";
  protected final String TEXT_8 = " node = new ";
  protected final String TEXT_9 = "() {" + NL + "" + NL + "\t\t\tprotected void paintFigure(Graphics graphics) {" + NL + "\t\t\t\tsuper.paintFigure(graphics);" + NL + "\t\t\t\tgraphics.fillRectangle(getClientArea());" + NL + "\t\t\t\tgraphics.drawRectangle(getClientArea());" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".setLineStyle(Graphics.";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = ".setLineWidth(attrs.getLineWidth());";
  protected final String TEXT_16 = NL + "\t\tnode.setDefaultSize(MapMode.DPtoLP(";
  protected final String TEXT_17 = "), MapMode.DPtoLP(";
  protected final String TEXT_18 = "));";
  protected final String TEXT_19 = NL + "\t\tnode.setLayoutManager(new StackLayout());" + NL + "\t\tnode.add(contentPane = createContentPane());" + NL + "\t\treturn node;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createContentPane() {" + NL + "\t\tIFigure plate = new Figure();" + NL + "\t\tConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();" + NL + "\t\tlayout.setSpacing(MapMode.DPtoLP(5));" + NL + "\t\tplate.setLayoutManager(layout);" + NL + "\t\treturn plate;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_20 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_21 = ".Labels.";
  protected final String TEXT_22 = ");" + NL + "\t}";
  protected final String TEXT_23 = NL + "}";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) argument;
GenDiagram genDiagram = genNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    
String figureClassName;
if (genNode.getViewmap() instanceof FigureViewmap) {
	figureClassName = importManager.getImportedName(((FigureViewmap) genNode.getViewmap()).getFigureQualifiedClassName());
} else {
	figureClassName = importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure");
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(figureClassName);
    stringBuffer.append(TEXT_9);
    
for (Iterator it = genNode.getViewmap().getAttributes().iterator(); it.hasNext();) {
	Attributes next = (Attributes) it.next();
	if (next instanceof ShapeAttributes) {
		String figureVarName = "node";
		ShapeAttributes attrs = (ShapeAttributes) next;

    stringBuffer.append(TEXT_10);
    
String lineStyle = attrs.getLineStyle();
if (lineStyle != null && lineStyle.trim().length() > 0) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(lineStyle);
    stringBuffer.append(TEXT_13);
    
}
if (attrs.isSetLineWidth()) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_15);
    }
    	}
	if (next instanceof DefaultSizeAttributes) {
		DefaultSizeAttributes attrs = (DefaultSizeAttributes) next;

    stringBuffer.append(TEXT_16);
    stringBuffer.append(attrs.getWidth());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(attrs.getHeight());
    stringBuffer.append(TEXT_18);
    
	}
}

    stringBuffer.append(TEXT_19);
    
if (!genNode.getLabels().isEmpty()) {
	GenNodeLabel primaryLabel = (GenNodeLabel) genNode.getLabels().get(0);
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);

    stringBuffer.append(TEXT_20);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(AccessUtil.getLabelTextId(primaryLabel));
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
