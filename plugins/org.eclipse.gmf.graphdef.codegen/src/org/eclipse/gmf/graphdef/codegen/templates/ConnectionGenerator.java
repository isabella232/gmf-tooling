package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
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
  protected final String TEXT_8 = NL + "\t\t";
  protected final String TEXT_9 = ".setFill(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".setOutline(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = ".setLineWidth(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = ".setFillXOR(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t";
  protected final String TEXT_24 = ".setOutlineXOR(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t";
  protected final String TEXT_27 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = "));";
  protected final String TEXT_30 = NL + "\t\t";
  protected final String TEXT_31 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_32 = "), getMapMode().DPtoLP(";
  protected final String TEXT_33 = ")));";
  protected final String TEXT_34 = NL + "\t\t";
  protected final String TEXT_35 = ".setForegroundColor(";
  protected final String TEXT_36 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ")";
  protected final String TEXT_40 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\t";
  protected final String TEXT_43 = ".setBackgroundColor(";
  protected final String TEXT_44 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ")";
  protected final String TEXT_48 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_52 = "), getMapMode().DPtoLP(";
  protected final String TEXT_53 = "));";
  protected final String TEXT_54 = NL + "\t\tsetSourceDecoration(createSourceDecoration());";
  protected final String TEXT_55 = NL + "\t\tsetTargetDecoration(createTargetDecoration());";
  protected final String TEXT_56 = NL + "\t}" + NL;
  protected final String TEXT_57 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_58 = " createSourceDecoration() {";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = "\t\t";
  protected final String TEXT_61 = " ";
  protected final String TEXT_62 = " = new ";
  protected final String TEXT_63 = "();";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL + "\t\t";
  protected final String TEXT_66 = ".setForegroundColor(";
  protected final String TEXT_67 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ")";
  protected final String TEXT_71 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\t\t";
  protected final String TEXT_74 = ".setBackgroundColor(";
  protected final String TEXT_75 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ")";
  protected final String TEXT_79 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t";
  protected final String TEXT_82 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_83 = "), getMapMode().DPtoLP(";
  protected final String TEXT_84 = "));";
  protected final String TEXT_85 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_86 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\t\t";
  protected final String TEXT_90 = ".setTemplate(pl);";
  protected final String TEXT_91 = NL + "\t\t";
  protected final String TEXT_92 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_93 = NL + "\t\treturn ";
  protected final String TEXT_94 = ";" + NL + "\t}";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_97 = " createTargetDecoration() {";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = "\t\t";
  protected final String TEXT_100 = " ";
  protected final String TEXT_101 = " = new ";
  protected final String TEXT_102 = "();";
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = NL + "\t\t";
  protected final String TEXT_105 = ".setForegroundColor(";
  protected final String TEXT_106 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_107 = ", ";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ")";
  protected final String TEXT_110 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = ".setBackgroundColor(";
  protected final String TEXT_114 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = ")";
  protected final String TEXT_118 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "\t\t";
  protected final String TEXT_121 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_122 = "), getMapMode().DPtoLP(";
  protected final String TEXT_123 = "));";
  protected final String TEXT_124 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_125 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL + "\t\t";
  protected final String TEXT_129 = ".setTemplate(pl);";
  protected final String TEXT_130 = NL + "\t\t";
  protected final String TEXT_131 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_132 = NL + "\t\treturn ";
  protected final String TEXT_133 = ";" + NL + "\t}";
  protected final String TEXT_134 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Object[] args = (Object[]) argument;
PolylineConnection figure = (PolylineConnection) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_2);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_6);
     { // scope
Shape figureInstance = figure;
String figureVarName = "this";
    stringBuffer.append(TEXT_7);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_10);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_13);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_16);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_19);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_22);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_25);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_26);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_29);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_30);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_33);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_34);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_35);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_39);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_41);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_42);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_43);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_47);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_49);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_50);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_53);
    }
     }// scope 
    if (figure.getSourceDecoration() != null) {
    stringBuffer.append(TEXT_54);
    }
if (figure.getTargetDecoration() != null) {
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    String decFigVarName = "df";
if (figure.getSourceDecoration() != null) {
DecorationFigure df = figure.getSourceDecoration();
    stringBuffer.append(TEXT_57);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_63);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_64);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_65);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_66);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_70);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_72);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_73);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_74);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_78);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_80);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_81);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_84);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_85);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_86);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_88);
    		} /*for*/ 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_90);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_92);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_93);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_94);
    } /*if sourceDecoration != null */ 
    stringBuffer.append(TEXT_95);
    if (figure.getTargetDecoration() != null) {
DecorationFigure df = figure.getTargetDecoration();
    stringBuffer.append(TEXT_96);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_102);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_103);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_104);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_105);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_109);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_111);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_112);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_113);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_117);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_119);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_120);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_123);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_124);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_125);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_127);
    		} /*for*/ 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_129);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_131);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_132);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
