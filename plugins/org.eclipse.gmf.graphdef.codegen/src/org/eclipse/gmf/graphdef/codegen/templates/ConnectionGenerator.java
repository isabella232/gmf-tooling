package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import java.util.*;

public class ConnectionGenerator
{
  protected static String nl;
  public static synchronized ConnectionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ConnectionGenerator result = new ConnectionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".setFill(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = ".setOutline(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = ".setLineWidth(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = ".setFillXOR(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = ".setOutlineXOR(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t";
  protected final String TEXT_25 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = "));";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_30 = "), getMapMode().DPtoLP(";
  protected final String TEXT_31 = ")));";
  protected final String TEXT_32 = NL + "\t\tsetSourceDecoration(createSourceDecoration());";
  protected final String TEXT_33 = NL + "\t\tsetTargetDecoration(createTargetDecoration());";
  protected final String TEXT_34 = NL + "\t}" + NL;
  protected final String TEXT_35 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_36 = " createSourceDecoration() {";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = "\t\t";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = " = new ";
  protected final String TEXT_41 = "();";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_44 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t";
  protected final String TEXT_48 = ".setTemplate(pl);";
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_51 = NL + "\t\treturn ";
  protected final String TEXT_52 = ";" + NL + "\t}";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_55 = " createTargetDecoration() {";
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = "\t\t";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = " = new ";
  protected final String TEXT_60 = "();";
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_63 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = ".setTemplate(pl);";
  protected final String TEXT_68 = NL + "\t\t";
  protected final String TEXT_69 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_70 = NL + "\t\treturn ";
  protected final String TEXT_71 = ";" + NL + "\t}";
  protected final String TEXT_72 = NL + "}";
  protected final String TEXT_73 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
PolylineConnection figure = (PolylineConnection) argument;
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    Shape shapeFigure = figure;
String shapeVarName = "this";
    stringBuffer.append(TEXT_5);
    
// PERHAPS, do this with reflection?

    if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(shapeFigure.isFill());
    stringBuffer.append(TEXT_8);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(shapeFigure.isOutline());
    stringBuffer.append(TEXT_11);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(shapeFigure.getLineWidth());
    stringBuffer.append(TEXT_14);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(shapeFigure.getLineKind().getName());
    stringBuffer.append(TEXT_17);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(shapeFigure.isXorFill());
    stringBuffer.append(TEXT_20);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(shapeFigure.isXorOutline());
    stringBuffer.append(TEXT_23);
    } if (shapeFigure instanceof Polyline && !((Polyline) shapeFigure).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) shapeFigure).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_24);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_27);
    }
    } else if (shapeFigure instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) shapeFigure;
    stringBuffer.append(TEXT_28);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_31);
    }
    if (figure.getSourceDecoration() != null) {
    stringBuffer.append(TEXT_32);
    }
if (figure.getTargetDecoration() != null) {
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    String decFigVarName = "df";
if (figure.getSourceDecoration() != null) {
DecorationFigure df = figure.getSourceDecoration();
    stringBuffer.append(TEXT_35);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_43);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_44);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_46);
    		} /*for*/ 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_48);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_50);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_52);
    } /*if sourceDecoration != null */ 
    stringBuffer.append(TEXT_53);
    if (figure.getTargetDecoration() != null) {
DecorationFigure df = figure.getTargetDecoration();
    stringBuffer.append(TEXT_54);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_62);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_63);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_65);
    		} /*for*/ 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_67);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_69);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    return stringBuffer.toString();
  }
}
