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
  protected final String TEXT_3 = NL + NL + ", ";
  protected final String TEXT_4 = ")";
  protected final String TEXT_5 = NL + "new ";
  protected final String TEXT_6 = "(";
  protected final String TEXT_7 = NL + NL + ")";
  protected final String TEXT_8 = NL + "new ";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = NL + "new ";
  protected final String TEXT_12 = "()";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
	String colorName = (hasColor) ? "BORDER" : null;
	if (hasColor && hasWidth){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_2);
    
//input: [oeg].gmfgraph.Color colorVal
//input: String colorName
//input: [oeg].common.codegen.ImportAssistant importManager 
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher

	if (colorVal instanceof RGBColor) {
		String staticFieldType = importManager.getImportedName("org.eclipse.swt.graphics.Color");
		String staticFieldName = (colorName == null) ? "COLOR" : colorName;
		String staticFieldValue = "new " + staticFieldType + "(null, " + ((RGBColor)colorVal).getRed() + ", " + ((RGBColor)colorVal).getGreen() + ", " + ((RGBColor)colorVal).getBlue() + ")";

    stringBuffer.append(dispatcher.getStaticFieldsManager().addStaticField(staticFieldType, staticFieldName, staticFieldValue));
    	} else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants") + "." + ((ConstantColor) colorVal).getValue().getLiteral());
    	} else {
		throw new IllegalStateException("Unknown color: " + colorVal);
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(dispatcher.DPtoLP(border.getWidth()));
    stringBuffer.append(TEXT_4);
    
	} else if (hasColor && !hasWidth) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_6);
    
//input: [oeg].gmfgraph.Color colorVal
//input: String colorName
//input: [oeg].common.codegen.ImportAssistant importManager 
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher

	if (colorVal instanceof RGBColor) {
		String staticFieldType = importManager.getImportedName("org.eclipse.swt.graphics.Color");
		String staticFieldName = (colorName == null) ? "COLOR" : colorName;
		String staticFieldValue = "new " + staticFieldType + "(null, " + ((RGBColor)colorVal).getRed() + ", " + ((RGBColor)colorVal).getGreen() + ", " + ((RGBColor)colorVal).getBlue() + ")";

    stringBuffer.append(dispatcher.getStaticFieldsManager().addStaticField(staticFieldType, staticFieldName, staticFieldValue));
    	} else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants") + "." + ((ConstantColor) colorVal).getValue().getLiteral());
    	} else {
		throw new IllegalStateException("Unknown color: " + colorVal);
	}

    stringBuffer.append(TEXT_7);
    
	} else if (!hasColor && hasWidth){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dispatcher.DPtoLP(border.getWidth()));
    stringBuffer.append(TEXT_10);
    
	} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(borderClazz);
    stringBuffer.append(TEXT_12);
    
	} 

    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
