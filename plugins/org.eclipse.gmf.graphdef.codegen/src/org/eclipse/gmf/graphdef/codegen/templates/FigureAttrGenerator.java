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
  protected final String TEXT_20 = ".setPreferredSize(";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t";
  protected final String TEXT_24 = ".setSize(";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = ".setMaximumSize(new ";
  protected final String TEXT_29 = "(";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = "));";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = ".setMinimumSize(new ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = "));";
  protected final String TEXT_37 = NL + "\t\t";
  protected final String TEXT_38 = ".setFont(new ";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = ".getCurrent(), \"";
  protected final String TEXT_41 = "\", ";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = "));";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = ".setBorder(new ";
  protected final String TEXT_47 = "(";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = ".setBorder(";
  protected final String TEXT_54 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
final Figure figureInstance = args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

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
    stringBuffer.append(dispatcher.DPtoLP(d.getDx()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dispatcher.DPtoLP(d.getDy()));
    stringBuffer.append(TEXT_22);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Size())) {
		Point p = figureInstance.getSize();
    stringBuffer.append(TEXT_23);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dispatcher.DPtoLP(p.getX()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dispatcher.DPtoLP(p.getY()));
    stringBuffer.append(TEXT_26);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_MaximumSize())) {
		Dimension d = figureInstance.getMaximumSize();
    stringBuffer.append(TEXT_27);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dispatcher.DPtoLP(d.getDx()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dispatcher.DPtoLP(d.getDy()));
    stringBuffer.append(TEXT_31);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_MinimumSize())) {
		Dimension d = figureInstance.getMinimumSize();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dispatcher.DPtoLP(d.getDx()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dispatcher.DPtoLP(d.getDy()));
    stringBuffer.append(TEXT_36);
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
		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Display"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(fontName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(font.getHeight());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(font.getStyle().getLiteral());
    stringBuffer.append(TEXT_44);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Insets())) {
		Insets insets = figureInstance.getInsets();
    stringBuffer.append(TEXT_45);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.MarginBorder"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dispatcher.DPtoLP(insets.getTop()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dispatcher.DPtoLP(insets.getLeft()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dispatcher.DPtoLP(insets.getBottom()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dispatcher.DPtoLP(insets.getRight()));
    stringBuffer.append(TEXT_51);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_Border())) {
		Border border = figureInstance.getBorder();
    stringBuffer.append(TEXT_52);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(dispatcher.dispatch(border, new Object[] {border, dispatcher}));
    stringBuffer.append(TEXT_54);
    }
    return stringBuffer.toString();
  }
}
