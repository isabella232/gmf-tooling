package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.graphdef.codegen.Dispatcher;

public class PolygonDecorationAttrGenerator
{
  protected static String nl;
  public static synchronized PolygonDecorationAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PolygonDecorationAttrGenerator result = new PolygonDecorationAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Dispatcher.Args args = (Dispatcher.Args) argument;
final Dispatcher dispatcher = args.getDispatcher();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(dispatcher.dispatch("PolylineDecoration", args));
    return stringBuffer.toString();
  }
}
