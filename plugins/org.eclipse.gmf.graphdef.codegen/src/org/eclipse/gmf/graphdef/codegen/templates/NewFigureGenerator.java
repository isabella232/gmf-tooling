package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class NewFigureGenerator
{
  protected static String nl;
  public static synchronized NewFigureGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewFigureGenerator result = new NewFigureGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = " = new ";
  protected final String TEXT_4 = "();";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
final Figure figureInstance = args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final String figureClassName = dispatcher.getFQNSwitch().get(figureInstance, dispatcher.getImportManager());

// PRODUCES instance AND (!) initializes attributes

    stringBuffer.append(TEXT_1);
    stringBuffer.append(figureClassName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figureClassName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(args.getDispatcher().dispatch(figureInstance, args));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(args.getDispatcher().dispatch("createLayout", dispatcher.getLayoutArgsFor(args)));
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
