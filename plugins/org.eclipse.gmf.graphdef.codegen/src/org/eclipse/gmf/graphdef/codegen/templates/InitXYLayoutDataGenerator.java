package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitXYLayoutDataGenerator
{
  protected static String nl;
  public static synchronized InitXYLayoutDataGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitXYLayoutDataGenerator result = new InitXYLayoutDataGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = " = new ";
  protected final String TEXT_4 = "();";
  protected final String TEXT_5 = NL + "\t\t\t";
  protected final String TEXT_6 = ".x = ";
  protected final String TEXT_7 = ";" + NL + "\t\t\t";
  protected final String TEXT_8 = ".y = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "\t\t\t";
  protected final String TEXT_11 = ".width = ";
  protected final String TEXT_12 = ";" + NL + "\t\t\t";
  protected final String TEXT_13 = ".height = ";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "\t\t\t";
  protected final String TEXT_16 = ".setConstraint(";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final XYLayoutData gmfLayoutData = (XYLayoutData) argsBundle.getData();
final String figureVarName = argsBundle.getVariableName();
final GraphDefDispatcher dispatcher = argsBundle.getDispatcher();
final String layoutConstraintVarName = argsBundle.getConstraintVariableName();
final String layoutManagerVarName = argsBundle.getManagerVariableName();

final String layoutImplClassName = dispatcher.getImportManager().getImportedName((String) dispatcher.getFQNSwitch().doSwitch(gmfLayoutData));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_4);
    
Point topLeft = gmfLayoutData.getTopLeft();
if (topLeft != null){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(topLeft.getX());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(topLeft.getY());
    stringBuffer.append(TEXT_9);
    
}

    
Dimension size = gmfLayoutData.getSize();
if (size != null){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(size.getDx());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(size.getDy());
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(layoutManagerVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
