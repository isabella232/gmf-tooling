package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class NewCustomBorderExpressionGenerator
{
  protected static String nl;
  public static synchronized NewCustomBorderExpressionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewCustomBorderExpressionGenerator result = new NewCustomBorderExpressionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "()";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
final CustomBorder border = (CustomBorder)args[0];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher)args[1];
//final ImportAssistant importManager = dispatcher.getImportManager();

//We want NEITHER insert any names into the scope NOR produce statement. We need expression instead.
//@see customBorderFactoryMethod.jetinc

    stringBuffer.append(dispatcher.getAuxiliaryDataStorage().getRegisteredData(border));
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
