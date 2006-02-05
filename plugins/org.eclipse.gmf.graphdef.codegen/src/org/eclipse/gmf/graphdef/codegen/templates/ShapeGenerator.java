package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;
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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t\tsetFigure";
  protected final String TEXT_8 = "(createFigure";
  protected final String TEXT_9 = "());" + NL + "\t\tadd(getFigure";
  protected final String TEXT_10 = "());";
  protected final String TEXT_11 = NL + "\t}" + NL;
  protected final String TEXT_12 = NL + NL + "\tprivate IFigure f";
  protected final String TEXT_13 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getFigure";
  protected final String TEXT_14 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_15 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_16 = "(IFigure figure) {" + NL + "\t\tf";
  protected final String TEXT_17 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createFigure";
  protected final String TEXT_18 = "() {";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = " = new ";
  protected final String TEXT_23 = "();";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t\t";
  protected final String TEXT_26 = ".setForegroundColor(";
  protected final String TEXT_27 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ")";
  protected final String TEXT_31 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = ".setBackgroundColor(";
  protected final String TEXT_35 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ")";
  protected final String TEXT_39 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_43 = "), getMapMode().DPtoLP(";
  protected final String TEXT_44 = "));";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = " ";
  protected final String TEXT_47 = " = new ";
  protected final String TEXT_48 = "();";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_51 = " = new ";
  protected final String TEXT_52 = "();";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = " = new ";
  protected final String TEXT_56 = "();" + NL + "\t\t";
  protected final String TEXT_57 = ".setText(\"";
  protected final String TEXT_58 = "\");";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".setForegroundColor(";
  protected final String TEXT_62 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ")";
  protected final String TEXT_66 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t\t";
  protected final String TEXT_69 = ".setBackgroundColor(";
  protected final String TEXT_70 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ")";
  protected final String TEXT_74 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\t\t";
  protected final String TEXT_77 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_78 = "), getMapMode().DPtoLP(";
  protected final String TEXT_79 = "));";
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = NL;
  protected final String TEXT_82 = NL + "\t\t";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = " = new ";
  protected final String TEXT_85 = "();";
  protected final String TEXT_86 = NL;
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = ".setForegroundColor(";
  protected final String TEXT_89 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ", ";
  protected final String TEXT_92 = ")";
  protected final String TEXT_93 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t";
  protected final String TEXT_96 = ".setBackgroundColor(";
  protected final String TEXT_97 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = ")";
  protected final String TEXT_101 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t";
  protected final String TEXT_104 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_105 = "), getMapMode().DPtoLP(";
  protected final String TEXT_106 = "));";
  protected final String TEXT_107 = NL + "\t\t";
  protected final String TEXT_108 = " ";
  protected final String TEXT_109 = " = new ";
  protected final String TEXT_110 = "();";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_113 = " = new ";
  protected final String TEXT_114 = "();";
  protected final String TEXT_115 = NL + "\t\t";
  protected final String TEXT_116 = " ";
  protected final String TEXT_117 = " = new ";
  protected final String TEXT_118 = "();" + NL + "\t\t";
  protected final String TEXT_119 = ".setText(\"";
  protected final String TEXT_120 = "\");";
  protected final String TEXT_121 = NL;
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = ".setForegroundColor(";
  protected final String TEXT_124 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = ")";
  protected final String TEXT_128 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t";
  protected final String TEXT_131 = ".setBackgroundColor(";
  protected final String TEXT_132 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ", ";
  protected final String TEXT_135 = ")";
  protected final String TEXT_136 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\t";
  protected final String TEXT_139 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_140 = "), getMapMode().DPtoLP(";
  protected final String TEXT_141 = "));";
  protected final String TEXT_142 = NL + "\t\t";
  protected final String TEXT_143 = ".add(";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\t\treturn ";
  protected final String TEXT_146 = ";" + NL + "\t}" + NL;
  protected final String TEXT_147 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
Shape shapeFig = (Shape) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();
final Dispatcher dispatcher = (Dispatcher) args[2];

    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName((String) fqnSwitch.doSwitch(shapeFig)));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dispatcher.dispatch("ShapeAttrs", dispatcher.create(shapeFig, "this", importManager, fqnSwitch)));
    
for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext();) {
		Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_7);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
int fc = 0;
for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure figure = (Figure) it.next();
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_18);
    
String parentFigureVarName = "rv" + fc;
{ // scope
FigureMarker figureMarker = figure;
String figureVarName = parentFigureVarName;
    stringBuffer.append(TEXT_19);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_20);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_25);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_26);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_30);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_32);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_33);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_34);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_38);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_40);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_41);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_44);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_45);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dispatcher.dispatch("ShapeAttrs", dispatcher.create(figureInstance, figureVarName, importManager, fqnSwitch)));
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_52);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_53);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_60);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_61);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_65);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_67);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_68);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_69);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_73);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_75);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_76);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_79);
    }
    }
    }
    stringBuffer.append(TEXT_80);
    
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
    stringBuffer.append(TEXT_81);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_82);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_87);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_88);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_92);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_94);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_95);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_96);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_100);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_102);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_103);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_106);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_107);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dispatcher.dispatch("ShapeAttrs", dispatcher.create(figureInstance, figureVarName, importManager, fqnSwitch)));
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_114);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_115);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(TEXT_121);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_122);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_123);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_127);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_129);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_130);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_131);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_135);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_137);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_138);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_141);
    }
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_144);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_145);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_146);
    }
    stringBuffer.append(TEXT_147);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
