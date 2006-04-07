package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitCustomLayoutGenerator
{
  protected static String nl;
  public static synchronized InitCustomLayoutGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitCustomLayoutGenerator result = new InitCustomLayoutGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final CustomLayout layout = (CustomLayout) argsBundle.getLayout();
final GraphDefDispatcher dispatcher = argsBundle.getDispatcher();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(dispatcher.dispatch("customAttributes", new Object[] {layout, dispatcher, argsBundle.getManagerVariableName()} ));
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
