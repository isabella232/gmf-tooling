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
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = ".setForegroundColor(";
  protected final String TEXT_34 = "new Color(null, ";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ")";
  protected final String TEXT_38 = "ColorConstants.";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = ".setBackgroundColor(";
  protected final String TEXT_42 = "new Color(null, ";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ")";
  protected final String TEXT_46 = "ColorConstants.";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_50 = "), getMapMode().DPtoLP(";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "\t\tsetSourceDecoration(createSourceDecoration());";
  protected final String TEXT_53 = NL + "\t\tsetTargetDecoration(createTargetDecoration());";
  protected final String TEXT_54 = NL + "\t}" + NL;
  protected final String TEXT_55 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_56 = " createSourceDecoration() {";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = "\t\t";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = " = new ";
  protected final String TEXT_61 = "();";
  protected final String TEXT_62 = NL;
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = ".setForegroundColor(";
  protected final String TEXT_65 = "new Color(null, ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ")";
  protected final String TEXT_69 = "ColorConstants.";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = ".setBackgroundColor(";
  protected final String TEXT_73 = "new Color(null, ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ")";
  protected final String TEXT_77 = "ColorConstants.";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t";
  protected final String TEXT_80 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_81 = "), getMapMode().DPtoLP(";
  protected final String TEXT_82 = "));";
  protected final String TEXT_83 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_84 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = ".setTemplate(pl);";
  protected final String TEXT_89 = NL + "\t\t";
  protected final String TEXT_90 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_91 = NL + "\t\treturn ";
  protected final String TEXT_92 = ";" + NL + "\t}";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_95 = " createTargetDecoration() {";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = "\t\t";
  protected final String TEXT_98 = " ";
  protected final String TEXT_99 = " = new ";
  protected final String TEXT_100 = "();";
  protected final String TEXT_101 = NL;
  protected final String TEXT_102 = NL + "\t\t";
  protected final String TEXT_103 = ".setForegroundColor(";
  protected final String TEXT_104 = "new Color(null, ";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = ")";
  protected final String TEXT_108 = "ColorConstants.";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = ".setBackgroundColor(";
  protected final String TEXT_112 = "new Color(null, ";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ", ";
  protected final String TEXT_115 = ")";
  protected final String TEXT_116 = "ColorConstants.";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_120 = "), getMapMode().DPtoLP(";
  protected final String TEXT_121 = "));";
  protected final String TEXT_122 = NL + "\t\torg.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();";
  protected final String TEXT_123 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_124 = ", ";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t";
  protected final String TEXT_127 = ".setTemplate(pl);";
  protected final String TEXT_128 = NL + "\t\t";
  protected final String TEXT_129 = ".setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));";
  protected final String TEXT_130 = NL + "\t\treturn ";
  protected final String TEXT_131 = ";" + NL + "\t}";
  protected final String TEXT_132 = NL + "}";
  protected final String TEXT_133 = NL;

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
     { // scope
Shape figureInstance = figure;
String figureVarName = "this";
    stringBuffer.append(TEXT_5);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_8);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_11);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_14);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_17);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_20);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_23);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_24);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_27);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_28);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_31);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_33);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_37);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_39);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_40);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_41);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_45);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_47);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_48);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_51);
    }
     }// scope 
    if (figure.getSourceDecoration() != null) {
    stringBuffer.append(TEXT_52);
    }
if (figure.getTargetDecoration() != null) {
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    String decFigVarName = "df";
if (figure.getSourceDecoration() != null) {
DecorationFigure df = figure.getSourceDecoration();
    stringBuffer.append(TEXT_55);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_61);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_62);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_63);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_64);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_68);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_70);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_71);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_72);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_76);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_78);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_79);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_82);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_83);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_84);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_86);
    		} /*for*/ 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_88);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_90);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_92);
    } /*if sourceDecoration != null */ 
    stringBuffer.append(TEXT_93);
    if (figure.getTargetDecoration() != null) {
DecorationFigure df = figure.getTargetDecoration();
    stringBuffer.append(TEXT_94);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(fqnSwitch.doSwitch(df));
    stringBuffer.append(TEXT_100);
      { // scope
Figure figureInstance = df;
String figureVarName = decFigVarName;

    stringBuffer.append(TEXT_101);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_102);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_103);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_107);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_109);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_110);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_111);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_115);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_117);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_118);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_121);
    }
    } // scope 
     /*include FigureChildren*/ 
    
if ((df instanceof PolylineDecoration || df instanceof PolygonDecoration)) {
	if (!((Polyline) df).getTemplate().isEmpty()) {

    stringBuffer.append(TEXT_122);
    		for (Iterator pointIt = ((Polyline) df).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_123);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_125);
    		} /*for*/ 
    stringBuffer.append(TEXT_126);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_127);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_129);
    } /*if instanceof */ 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(decFigVarName);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(TEXT_133);
    return stringBuffer.toString();
  }
}
