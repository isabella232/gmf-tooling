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
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {" + NL + "\t\t// TODO - process custom properties here";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t\t";
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
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = " = new ";
  protected final String TEXT_35 = "();";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL + "\t\t";
  protected final String TEXT_38 = ".setFill(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = ".setOutline(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = ".setLineWidth(";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = ".setFillXOR(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = ".setOutlineXOR(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t";
  protected final String TEXT_56 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = "));";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_61 = "), getMapMode().DPtoLP(";
  protected final String TEXT_62 = ")));";
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = ".setForegroundColor(";
  protected final String TEXT_65 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ")";
  protected final String TEXT_69 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = ".setBackgroundColor(";
  protected final String TEXT_73 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ")";
  protected final String TEXT_77 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t";
  protected final String TEXT_80 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_81 = "), getMapMode().DPtoLP(";
  protected final String TEXT_82 = "));";
  protected final String TEXT_83 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_84 = " = new ";
  protected final String TEXT_85 = "();";
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = " ";
  protected final String TEXT_88 = " = new ";
  protected final String TEXT_89 = "();" + NL + "\t\t";
  protected final String TEXT_90 = ".setText(\"";
  protected final String TEXT_91 = "\");";
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = NL + "\t\t";
  protected final String TEXT_94 = ".setForegroundColor(";
  protected final String TEXT_95 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_96 = ", ";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = ")";
  protected final String TEXT_99 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\t";
  protected final String TEXT_102 = ".setBackgroundColor(";
  protected final String TEXT_103 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ")";
  protected final String TEXT_107 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "\t\t";
  protected final String TEXT_110 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_111 = "), getMapMode().DPtoLP(";
  protected final String TEXT_112 = "));";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = ".add(";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\t}" + NL + "}";

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
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_7);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_10);
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
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_32);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_39);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_42);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_45);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_48);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_51);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_54);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_55);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_58);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_59);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_62);
    }
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
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_85);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_86);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(TEXT_92);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_93);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_94);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_98);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_100);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_101);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_102);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_106);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_108);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_109);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_112);
    }
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_115);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_116);
    return stringBuffer.toString();
  }
}
