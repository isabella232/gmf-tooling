package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitGridLayoutGenerator
{
  protected static String nl;
  public static synchronized InitGridLayoutGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitGridLayoutGenerator result = new InitGridLayoutGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = ".numColumns = ";
  protected final String TEXT_3 = ";" + NL + "\t\t";
  protected final String TEXT_4 = ".makeColumnsEqualWidth = ";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".marginWidth = ";
  protected final String TEXT_8 = ";" + NL + "\t\t";
  protected final String TEXT_9 = ".marginHeight = ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".horizontalSpacing = ";
  protected final String TEXT_13 = ";" + NL + "\t\t";
  protected final String TEXT_14 = ".verticalSpacing = ";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final GridLayout gmfLayout = (GridLayout) argsBundle.getLayout();
final String layouterVarName = argsBundle.getLayoutVariableName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(gmfLayout.getNumColumns());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(gmfLayout.isEqualWidth());
    stringBuffer.append(TEXT_5);
    
Dimension margins = gmfLayout.getMargins();
if (margins != null){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(margins.getDx());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(margins.getDy());
    stringBuffer.append(TEXT_10);
    
}
Dimension spacing = gmfLayout.getSpacing();
if (spacing != null){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(spacing.getDx());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(spacing.getDy());
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
