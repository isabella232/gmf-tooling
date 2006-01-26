package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import java.util.*;

public class DecorationFigureGenerator
{
  protected static String nl;
  public static synchronized DecorationFigureGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DecorationFigureGenerator result = new DecorationFigureGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "\t\t";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = " = new ";
  protected final String TEXT_9 = "();";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".setForegroundColor(";
  protected final String TEXT_13 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = ".setBackgroundColor(";
  protected final String TEXT_21 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_29 = "), getMapMode().DPtoLP(";
  protected final String TEXT_30 = "));";
  protected final String TEXT_31 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_32 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = ".setTemplate(pl);";
  protected final String TEXT_37 = NL + "\t\t";
  protected final String TEXT_38 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_39 = NL + "\t\tsetScale(";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t}" + NL + "}";
  protected final String TEXT_43 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
DecorationFigure figure = (DecorationFigure) argument;
assert false == figure instanceof CustomFigure;
final Point scale;
scale = null; //XXX
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fqnSwitch.doSwitch(figure));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    
DecorationFigure df = figure;
String decFigVarName = "this";
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_9);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_10);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_11);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_12);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_16);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_18);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_19);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_20);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_24);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_26);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_27);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_30);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_31);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_34);
    		} /*for*/ 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_36);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_38);
    } /*if instanceof */ 
    if (scale != null) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(scale.getX());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(scale.getY());
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
