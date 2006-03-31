package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.gmf.common.codegen.ImportAssistant;

public class NewLineBorderExpressionGenerator
{
  protected static String nl;
  public static synchronized NewLineBorderExpressionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewLineBorderExpressionGenerator result = new NewLineBorderExpressionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "new ";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = "new ";
  protected final String TEXT_4 = "(null, ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = NL + "new ";
  protected final String TEXT_12 = "(";
  protected final String TEXT_13 = "new ";
  protected final String TEXT_14 = "(null, ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = NL + "new ";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ")";
  protected final String TEXT_23 = NL + "new ";
  protected final String TEXT_24 = "()";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
final LineBorder border = (LineBorder)args[0];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher)args[1];
final ImportAssistant importManager = dispatcher.getImportManager();

//We do not want to insert any names into the scope. 
//We want to provide EXPRESSION instead of statement

    
	String borderClazz = importManager.getImportedName("org.eclipse.draw2d.LineBorder");
	boolean hasColor = border.eIsSet(GMFGraphPackage.eINSTANCE.getLineBorder_Color());
	boolean hasWidth = border.eIsSet(GMFGraphPackage.eINSTANCE.getLineBorder_Width());
	Color colorVal = (hasColor) ? border.getColor() : null;
	if (hasColor && hasWidth){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(borderClazz);
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
    stringBuffer.append(dispatcher.DPtoLP(border.getWidth()));
    stringBuffer.append(TEXT_10);
    
	} else if (hasColor && !hasWidth) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_12);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_17);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_19);
    
	} else if (!hasColor && hasWidth){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dispatcher.DPtoLP(border.getWidth()));
    stringBuffer.append(TEXT_22);
    
	} else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_24);
    
	} 

    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
