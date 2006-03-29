package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.GraphDefDispatcher;

public class CustomFigureAttrGenerator
{
  protected static String nl;
  public static synchronized CustomFigureAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CustomFigureAttrGenerator result = new CustomFigureAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
final CustomFigure figureInstance = (CustomFigure) args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(dispatcher.dispatch("customAttributes", new Object[] {figureInstance, dispatcher, figureVarName}));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dispatcher.dispatch("Figure", args));
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
