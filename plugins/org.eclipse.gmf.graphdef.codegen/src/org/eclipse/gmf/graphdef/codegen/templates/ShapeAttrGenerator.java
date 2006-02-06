package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;

public class ShapeAttrGenerator
{
  protected static String nl;
  public static synchronized ShapeAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ShapeAttrGenerator result = new ShapeAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = ".setFill(";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = ".setOutline(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = ".setLineWidth(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = ".setLineStyle(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = ".setFillXOR(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = ".setOutlineXOR(";
  protected final String TEXT_19 = ");";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Dispatcher.Args args = (Dispatcher.Args) argument;
final Shape figureInstance = (Shape) args.getFigure();
final String figureVarName = args.getVariableName();
final ImportAssistant importManager = args.getImportManager();
final Dispatcher dispatcher = args.getDispatcher();

    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_3);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_6);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_9);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Graphics"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_13);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_16);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(dispatcher.dispatch("Figure", args));
    return stringBuffer.toString();
  }
}
