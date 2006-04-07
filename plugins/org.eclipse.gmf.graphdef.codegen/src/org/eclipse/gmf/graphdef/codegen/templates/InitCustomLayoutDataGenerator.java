package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitCustomLayoutDataGenerator
{
  protected static String nl;
  public static synchronized InitCustomLayoutDataGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitCustomLayoutDataGenerator result = new InitCustomLayoutDataGenerator();
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
  protected final String TEXT_7 = ".setConstraint(";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs args = (GraphDefDispatcher.LayoutArgs) argument;
final CustomLayoutData layoutData = (CustomLayoutData) args.getData();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final String layoutImplClassName = dispatcher.getFQNSwitch().get(layoutData, dispatcher.getImportManager());

    stringBuffer.append(TEXT_1);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(args.getConstraintVariableName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dispatcher.dispatch("customAttributes", new Object[] {layoutData, dispatcher, args.getConstraintVariableName()}));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(args.getManagerVariableName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(args.getVariableName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(args.getConstraintVariableName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
