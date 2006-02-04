package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "\t\t";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = " = new ";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = ".setForegroundColor(";
  protected final String TEXT_14 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = ".setBackgroundColor(";
  protected final String TEXT_22 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_30 = "), getMapMode().DPtoLP(";
  protected final String TEXT_31 = "));";
  protected final String TEXT_32 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_33 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\t";
  protected final String TEXT_37 = ".setTemplate(pl);";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_40 = NL + "\t\tsetScale(";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
DecorationFigure figure = (DecorationFigure) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
assert false == figure instanceof CustomFigure;
final Point scale;
scale = null; //XXX
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName((String) fqnSwitch.doSwitch(figure)));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_5);
    
DecorationFigure df = figure;
String decFigVarName = "this";
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_10);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_11);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_13);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_17);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_19);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_20);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_21);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_25);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_27);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_28);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_31);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_32);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_33);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_35);
    		} /*for*/ 
    stringBuffer.append(TEXT_36);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_37);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_39);
    } /*if instanceof */ 
    if (scale != null) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(scale.getX());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(scale.getY());
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
