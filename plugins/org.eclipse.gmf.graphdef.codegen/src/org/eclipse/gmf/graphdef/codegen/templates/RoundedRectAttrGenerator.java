package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.GraphDefDispatcher;

public class RoundedRectAttrGenerator
{
  protected static String nl;
  public static synchronized RoundedRectAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    RoundedRectAttrGenerator result = new RoundedRectAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = ".setCornerDimensions(new ";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "));";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
final RoundedRectangle figureInstance = (RoundedRectangle) args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(dispatcher.dispatch("Shape", args));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dispatcher.DPtoLP(figureInstance.getCornerWidth()));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dispatcher.DPtoLP(figureInstance.getCornerHeight()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
