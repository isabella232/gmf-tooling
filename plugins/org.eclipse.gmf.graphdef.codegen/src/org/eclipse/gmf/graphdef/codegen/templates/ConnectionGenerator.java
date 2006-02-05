package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;
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
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "() {";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "\t\tsetSourceDecoration(createSourceDecoration());";
  protected final String TEXT_9 = NL + "\t\tsetTargetDecoration(createTargetDecoration());";
  protected final String TEXT_10 = NL + "\t}" + NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_12 = " createSourceDecoration() {";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = "\t\t";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = " = new ";
  protected final String TEXT_17 = "();";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = ".setForegroundColor(";
  protected final String TEXT_21 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = ".setBackgroundColor(";
  protected final String TEXT_29 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ")";
  protected final String TEXT_33 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_37 = "), getMapMode().DPtoLP(";
  protected final String TEXT_38 = "));";
  protected final String TEXT_39 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_40 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = ".setTemplate(pl);";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_47 = NL + "\t\treturn ";
  protected final String TEXT_48 = ";" + NL + "\t}";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_51 = " createTargetDecoration() {";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = "\t\t";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = " = new ";
  protected final String TEXT_56 = "();";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = ".setForegroundColor(";
  protected final String TEXT_60 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ")";
  protected final String TEXT_64 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = ".setBackgroundColor(";
  protected final String TEXT_68 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_76 = "), getMapMode().DPtoLP(";
  protected final String TEXT_77 = "));";
  protected final String TEXT_78 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_79 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\t";
  protected final String TEXT_83 = ".setTemplate(pl);";
  protected final String TEXT_84 = NL + "\t\t";
  protected final String TEXT_85 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_86 = NL + "\t\treturn ";
  protected final String TEXT_87 = ";" + NL + "\t}";
  protected final String TEXT_88 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Object[] args = (Object[]) argument;
PolylineConnection figure = (PolylineConnection) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();
final Dispatcher dispatcher = (Dispatcher) args[2];

    stringBuffer.append(TEXT_2);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dispatcher.dispatch("ShapeAttrs", dispatcher.create(figure, "this", importManager, fqnSwitch)));
    if (figure.getSourceDecoration() != null) {
    stringBuffer.append(TEXT_8);
    }
if (figure.getTargetDecoration() != null) {
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    String decFigVarName = "df";
if (figure.getSourceDecoration() != null) {
DecorationFigure df = figure.getSourceDecoration();
    stringBuffer.append(TEXT_11);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_17);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_18);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
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
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_27);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_28);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_32);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_34);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_35);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_38);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_39);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_40);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_42);
    		} /*for*/ 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_44);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_46);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_48);
    } /*if sourceDecoration != null */ 
    stringBuffer.append(TEXT_49);
    if (figure.getTargetDecoration() != null) {
DecorationFigure df = figure.getTargetDecoration();
    stringBuffer.append(TEXT_50);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_56);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_57);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_58);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_59);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_63);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_65);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_66);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_67);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_71);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_73);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_74);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_77);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_78);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_79);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_81);
    		} /*for*/ 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_83);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_85);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
