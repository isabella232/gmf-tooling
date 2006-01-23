package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import java.util.*;

public class ShapeGenerator
{
  protected static String nl;
  public static synchronized ShapeGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ShapeGenerator result = new ShapeGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
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
  protected final String TEXT_32 = NL + "\t\tsetFigure";
  protected final String TEXT_33 = "(createFigure";
  protected final String TEXT_34 = "());" + NL + "\t\tadd(getFigure";
  protected final String TEXT_35 = "());";
  protected final String TEXT_36 = NL + "\t}" + NL;
  protected final String TEXT_37 = NL + NL + "\tprivate IFigure f";
  protected final String TEXT_38 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getFigure";
  protected final String TEXT_39 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_40 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_41 = "(IFigure figure) {" + NL + "\t\tf";
  protected final String TEXT_42 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createFigure";
  protected final String TEXT_43 = "() {";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_46 = " = new ";
  protected final String TEXT_47 = "();";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = " = new ";
  protected final String TEXT_52 = "();";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = ".setFill(";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\t";
  protected final String TEXT_58 = ".setOutline(";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".setLineWidth(";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = ".setFillXOR(";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\t";
  protected final String TEXT_70 = ".setOutlineXOR(";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = "));";
  protected final String TEXT_76 = NL + "\t\t";
  protected final String TEXT_77 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_78 = "), getMapMode().DPtoLP(";
  protected final String TEXT_79 = ")));";
  protected final String TEXT_80 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_81 = " = new ";
  protected final String TEXT_82 = "();";
  protected final String TEXT_83 = NL;
  protected final String TEXT_84 = NL + "\t\torg.eclipse.draw2d.Label ";
  protected final String TEXT_85 = " = new org.eclipse.draw2d.Label();" + NL + "\t\t";
  protected final String TEXT_86 = ".setText(\"";
  protected final String TEXT_87 = "\");";
  protected final String TEXT_88 = NL;
  protected final String TEXT_89 = NL;
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_92 = " = new ";
  protected final String TEXT_93 = "();";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\t\t";
  protected final String TEXT_96 = " ";
  protected final String TEXT_97 = " = new ";
  protected final String TEXT_98 = "();";
  protected final String TEXT_99 = NL;
  protected final String TEXT_100 = NL + "\t\t";
  protected final String TEXT_101 = ".setFill(";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t";
  protected final String TEXT_104 = ".setOutline(";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "\t\t";
  protected final String TEXT_107 = ".setLineWidth(";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "\t\t";
  protected final String TEXT_110 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = ".setFillXOR(";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "\t\t";
  protected final String TEXT_116 = ".setOutlineXOR(";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_120 = ", ";
  protected final String TEXT_121 = "));";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_124 = "), getMapMode().DPtoLP(";
  protected final String TEXT_125 = ")));";
  protected final String TEXT_126 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_127 = " = new ";
  protected final String TEXT_128 = "();";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = NL + "\t\torg.eclipse.draw2d.Label ";
  protected final String TEXT_131 = " = new org.eclipse.draw2d.Label();" + NL + "\t\t";
  protected final String TEXT_132 = ".setText(\"";
  protected final String TEXT_133 = "\");";
  protected final String TEXT_134 = NL;
  protected final String TEXT_135 = NL + "\t\t";
  protected final String TEXT_136 = ".add(";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\treturn ";
  protected final String TEXT_139 = ";" + NL + "\t}" + NL;
  protected final String TEXT_140 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Shape shapeFig = (Shape) argument;
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fqnSwitch.doSwitch(shapeFig));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_4);
    
{
Shape shapeFigure = shapeFig;
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
    
}for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext();) {
		Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    
int fc = 0;
for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure figure = (Figure) it.next();
    stringBuffer.append(TEXT_37);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_43);
    
String parentFigureVarName = "rv" + fc;
{ // scope
FigureMarker figureMarker = figure;
String figureVarName = parentFigureVarName;
    stringBuffer.append(TEXT_44);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(((CustomFigure) figureMarker).getQualifiedClassName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    } else if (figureMarker instanceof Shape) {
Shape shapeFigure = (Shape) figureMarker;
String shapeVarName = figureVarName;
    stringBuffer.append(TEXT_49);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    
// PERHAPS, do this with reflection?

    if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(shapeFigure.isFill());
    stringBuffer.append(TEXT_56);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(shapeFigure.isOutline());
    stringBuffer.append(TEXT_59);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(shapeFigure.getLineWidth());
    stringBuffer.append(TEXT_62);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(shapeFigure.getLineKind().getName());
    stringBuffer.append(TEXT_65);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(shapeFigure.isXorFill());
    stringBuffer.append(TEXT_68);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(shapeFigure.isXorOutline());
    stringBuffer.append(TEXT_71);
    } if (shapeFigure instanceof Polyline && !((Polyline) shapeFigure).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) shapeFigure).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_72);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_75);
    }
    } else if (shapeFigure instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) shapeFigure;
    stringBuffer.append(TEXT_76);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_79);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    } else if (figureMarker instanceof Label) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    }
    }
    stringBuffer.append(TEXT_89);
    
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
    stringBuffer.append(TEXT_90);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(((CustomFigure) figureMarker).getQualifiedClassName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    } else if (figureMarker instanceof Shape) {
Shape shapeFigure = (Shape) figureMarker;
String shapeVarName = figureVarName;
    stringBuffer.append(TEXT_95);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    
// PERHAPS, do this with reflection?

    if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(shapeFigure.isFill());
    stringBuffer.append(TEXT_102);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(shapeFigure.isOutline());
    stringBuffer.append(TEXT_105);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(shapeFigure.getLineWidth());
    stringBuffer.append(TEXT_108);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(shapeFigure.getLineKind().getName());
    stringBuffer.append(TEXT_111);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(shapeFigure.isXorFill());
    stringBuffer.append(TEXT_114);
    } if (shapeFigure.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(shapeFigure.isXorOutline());
    stringBuffer.append(TEXT_117);
    } if (shapeFigure instanceof Polyline && !((Polyline) shapeFigure).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) shapeFigure).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_118);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_121);
    }
    } else if (shapeFigure instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) shapeFigure;
    stringBuffer.append(TEXT_122);
    stringBuffer.append(shapeVarName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_125);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(TEXT_129);
    } else if (figureMarker instanceof Label) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_137);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_138);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    return stringBuffer.toString();
  }
}
