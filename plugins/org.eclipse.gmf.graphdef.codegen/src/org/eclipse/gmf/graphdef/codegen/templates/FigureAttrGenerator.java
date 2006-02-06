package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;

public class FigureAttrGenerator
{
  protected static String nl;
  public static synchronized FigureAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    FigureAttrGenerator result = new FigureAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = ".setForegroundColor(";
  protected final String TEXT_3 = "new ";
  protected final String TEXT_4 = "(null, ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = ".setBackgroundColor(";
  protected final String TEXT_12 = "new ";
  protected final String TEXT_13 = "(null, ";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_21 = "), getMapMode().DPtoLP(";
  protected final String TEXT_22 = "));";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Dispatcher.Args args = (Dispatcher.Args) argument;
final Figure figureInstance = args.getFigure();
final String figureVarName = args.getVariableName();
final ImportAssistant importManager = args.getImportManager();

    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_2);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_7);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_9);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_10);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_11);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_16);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_18);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_19);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_22);
    }
    return stringBuffer.toString();
  }
}
