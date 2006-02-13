package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitBorderLayoutGenerator
{
  protected static String nl;
  public static synchronized InitBorderLayoutGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitBorderLayoutGenerator result = new InitBorderLayoutGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = ".setHorizontalSpacing(";
  protected final String TEXT_4 = ");" + NL + "\t\t";
  protected final String TEXT_5 = ".setVerticalSpacing(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final BorderLayout gmfLayout = (BorderLayout) argsBundle.getLayout();
final String layouterVarName = argsBundle.getLayoutVariableName();

    stringBuffer.append(TEXT_1);
    
Dimension spacing = gmfLayout.getSpacing();
if (spacing != null){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(spacing.getDx());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(spacing.getDy());
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
