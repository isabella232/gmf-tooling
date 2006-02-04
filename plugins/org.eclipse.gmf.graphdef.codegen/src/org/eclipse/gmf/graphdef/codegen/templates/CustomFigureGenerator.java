package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {" + NL + "\t\t// TODO - process custom properties here";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "\t\t";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = " = new ";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t\t";
  protected final String TEXT_14 = ".setForegroundColor(";
  protected final String TEXT_15 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ")";
  protected final String TEXT_19 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = ".setBackgroundColor(";
  protected final String TEXT_23 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ")";
  protected final String TEXT_27 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_31 = "), getMapMode().DPtoLP(";
  protected final String TEXT_32 = "));";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = " = new ";
  protected final String TEXT_36 = "();";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = ".setFill(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = ".setOutline(";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\t\t";
  protected final String TEXT_45 = ".setLineWidth(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t";
  protected final String TEXT_48 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = ".setFillXOR(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = ".setOutlineXOR(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = "));";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_62 = "), getMapMode().DPtoLP(";
  protected final String TEXT_63 = ")));";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = ".setForegroundColor(";
  protected final String TEXT_66 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ")";
  protected final String TEXT_70 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = ".setBackgroundColor(";
  protected final String TEXT_74 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ")";
  protected final String TEXT_78 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\t\t";
  protected final String TEXT_81 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_82 = "), getMapMode().DPtoLP(";
  protected final String TEXT_83 = "));";
  protected final String TEXT_84 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_85 = " = new ";
  protected final String TEXT_86 = "();";
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = " ";
  protected final String TEXT_89 = " = new ";
  protected final String TEXT_90 = "();" + NL + "\t\t";
  protected final String TEXT_91 = ".setText(\"";
  protected final String TEXT_92 = "\");";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL + "\t\t";
  protected final String TEXT_95 = ".setForegroundColor(";
  protected final String TEXT_96 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = ")";
  protected final String TEXT_100 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t";
  protected final String TEXT_103 = ".setBackgroundColor(";
  protected final String TEXT_104 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = ")";
  protected final String TEXT_108 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_112 = "), getMapMode().DPtoLP(";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "\t\t";
  protected final String TEXT_115 = ".add(";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
CustomFigure figure = (CustomFigure) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName(figure.getQualifiedClassName()));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_5);
    String parentFigureVarName = "this";
    stringBuffer.append(TEXT_6);
    
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
    stringBuffer.append(TEXT_7);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_8);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_14);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_18);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_20);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_21);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_22);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_26);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_28);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_29);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_32);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_33);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_40);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_43);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_46);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_49);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_52);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_55);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_56);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_59);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_60);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_63);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_64);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_65);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_69);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_71);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_72);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_73);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_77);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_79);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_80);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_83);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_86);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_87);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_94);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_95);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_99);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_101);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
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
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_110);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_113);
    }
    }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_116);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_117);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
