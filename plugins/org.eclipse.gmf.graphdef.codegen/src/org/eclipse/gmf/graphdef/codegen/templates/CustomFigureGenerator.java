package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import java.util.*;

public class CustomFigureGenerator
{
  protected static String nl;
  public static synchronized CustomFigureGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CustomFigureGenerator result = new CustomFigureGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {" + NL + "\t\t// TODO - process custom properties here";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_8 = " = new ";
  protected final String TEXT_9 = "();";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = " = new ";
  protected final String TEXT_14 = "();";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = ".setFill(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = ".setOutline(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = ".setLineWidth(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t";
  protected final String TEXT_26 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".setFillXOR(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = ".setOutlineXOR(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t";
  protected final String TEXT_35 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = "));";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = "));";
  protected final String TEXT_42 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_43 = " = new ";
  protected final String TEXT_44 = "();";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "\t\torg.eclipse.draw2d.Label ";
  protected final String TEXT_47 = " = new org.eclipse.draw2d.Label();" + NL + "\t\t";
  protected final String TEXT_48 = ".setText(\"";
  protected final String TEXT_49 = "\");";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "\t\t";
  protected final String TEXT_52 = ".add(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
CustomFigure figure = (CustomFigure) argument;
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figure.getQualifiedClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    String parentFigureVarName = "this";
    stringBuffer.append(TEXT_5);
    
LinkedList l = new LinkedList();
l.addAll(figure.getChildren());
final Object marker = new Object();
Stack figureVarNamesStack = new Stack();
int figureCount = 0;
while (!l.isEmpty()) {
	Object _nxt = l.removeFirst();
	if (_nxt == marker) {
		parentFigureVarName = (String) figureVarNamesStack.pop();
		continue;
	}
	FigureMarker figureMarker = (FigureMarker) _nxt;
	String figureVarName = "fig" + (figureCount++);
    stringBuffer.append(TEXT_6);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(((CustomFigure) figureMarker).getQualifiedClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    } else if (figureMarker instanceof Shape) {
Shape shapeFigure = (Shape) figureMarker;
String shapeVarName = figureVarName;
    stringBuffer.append(TEXT_11);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    
// PERHAPS, do this with reflection?

    if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(shapeFigure.isFill());
    stringBuffer.append(TEXT_18);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(shapeFigure.isOutline());
    stringBuffer.append(TEXT_21);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(shapeFigure.getLineWidth());
    stringBuffer.append(TEXT_24);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(shapeFigure.getLineKind().getName());
    stringBuffer.append(TEXT_27);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(shapeFigure.isXorFill());
    stringBuffer.append(TEXT_30);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(shapeFigure.isXorOutline());
    stringBuffer.append(TEXT_33);
    } if (shapeFigure instanceof Polyline && !((Polyline) shapeFigure).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) shapeFigure).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_34);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_37);
    }
    } else if (shapeFigure instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) shapeFigure;
    stringBuffer.append(TEXT_38);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_41);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    } else if (figureMarker instanceof Label) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_53);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
