package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.GraphDefDispatcher;

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
  protected final String TEXT_3 = NL + ");";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = ".setBackgroundColor(";
  protected final String TEXT_6 = NL + ");";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = ".setPreferredSize(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".setSize(";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ".setMaximumSize(new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = "));";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = ".setMinimumSize(new ";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = "));";
  protected final String TEXT_25 = NL + "\t\t";
  protected final String TEXT_26 = ".setFont(" + NL + "\t\t\t";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".setBorder(new ";
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = "));";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = ".setBorder(";
  protected final String TEXT_37 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
final Figure figureInstance = args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

    
Color colorVal;
String colorName;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
		colorName = figureInstance.getName().toUpperCase() + "_FORE";
    stringBuffer.append(TEXT_1);
    stringBuffer.append(figureVarName);
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
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
		colorName = figureInstance.getName().toUpperCase() + "_BACK";
    stringBuffer.append(TEXT_4);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_5);
    
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

    stringBuffer.append(TEXT_6);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dispatcher.DPtoLP(d.getDx()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dispatcher.DPtoLP(d.getDy()));
    stringBuffer.append(TEXT_10);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Size())) {
		Point p = figureInstance.getSize();
    stringBuffer.append(TEXT_11);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dispatcher.DPtoLP(p.getX()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dispatcher.DPtoLP(p.getY()));
    stringBuffer.append(TEXT_14);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_MaximumSize())) {
		Dimension d = figureInstance.getMaximumSize();
    stringBuffer.append(TEXT_15);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dispatcher.DPtoLP(d.getDx()));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dispatcher.DPtoLP(d.getDy()));
    stringBuffer.append(TEXT_19);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_MinimumSize())) {
		Dimension d = figureInstance.getMinimumSize();
    stringBuffer.append(TEXT_20);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dispatcher.DPtoLP(d.getDx()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dispatcher.DPtoLP(d.getDy()));
    stringBuffer.append(TEXT_24);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Font())) {
		// XXX possible CCE when fonts other than Basic added to model 
		BasicFont font = (BasicFont) figureInstance.getFont();
		String fontName = font.getFaceName();
		if (fontName == null || fontName.trim().length() == 0){
			org.eclipse.swt.graphics.Font system = org.eclipse.swt.widgets.Display.getDefault().getSystemFont();
			if (system != null && system.getFontData().length > 0){
				fontName = system.getFontData()[0].getName();
			}
		}
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dispatcher.getStaticFieldsManager().addStaticField(
				importManager.getImportedName("org.eclipse.swt.graphics.Font"), 
				figureInstance.getName().toUpperCase() + "_FONT", 
				"new " + importManager.getImportedName("org.eclipse.swt.graphics.Font") + "(" + importManager.getImportedName("org.eclipse.swt.widgets.Display") + ".getCurrent(), \"" + fontName + "\", " + font.getHeight() + ", " + importManager.getImportedName("org.eclipse.swt.SWT") + "." + font.getStyle().getLiteral() + ")"
			));
    stringBuffer.append(TEXT_27);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Insets())) {
		Insets insets = figureInstance.getInsets();
    stringBuffer.append(TEXT_28);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.MarginBorder"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dispatcher.DPtoLP(insets.getTop()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dispatcher.DPtoLP(insets.getLeft()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dispatcher.DPtoLP(insets.getBottom()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dispatcher.DPtoLP(insets.getRight()));
    stringBuffer.append(TEXT_34);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Border())) {
		Border border = figureInstance.getBorder();
    stringBuffer.append(TEXT_35);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dispatcher.dispatch(border, new Object[] {border, dispatcher}));
    stringBuffer.append(TEXT_37);
    }
    return stringBuffer.toString();
  }
}
