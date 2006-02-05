package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;
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
  protected final String TEXT_38 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_39 = " = new ";
  protected final String TEXT_40 = "();";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = " ";
  protected final String TEXT_43 = " = new ";
  protected final String TEXT_44 = "();" + NL + "\t\t";
  protected final String TEXT_45 = ".setText(\"";
  protected final String TEXT_46 = "\");";
  protected final String TEXT_47 = NL;
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = ".setForegroundColor(";
  protected final String TEXT_50 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ")";
  protected final String TEXT_54 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = ".setBackgroundColor(";
  protected final String TEXT_58 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ")";
  protected final String TEXT_62 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_66 = "), getMapMode().DPtoLP(";
  protected final String TEXT_67 = "));";
  protected final String TEXT_68 = NL + "\t\t";
  protected final String TEXT_69 = ".add(";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
CustomFigure figure = (CustomFigure) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();
final Dispatcher dispatcher = (Dispatcher) args[2];

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
    stringBuffer.append(dispatcher.dispatch("ShapeAttrs", dispatcher.create(figureInstance, figureVarName, importManager, fqnSwitch)));
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_40);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_41);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_48);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_49);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_53);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_55);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_56);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_57);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_61);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_63);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_64);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_67);
    }
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_70);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_71);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
