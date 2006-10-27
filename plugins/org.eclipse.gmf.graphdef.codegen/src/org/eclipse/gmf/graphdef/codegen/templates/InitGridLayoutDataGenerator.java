package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitGridLayoutDataGenerator
{
  protected static String nl;
  public static synchronized InitGridLayoutDataGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitGridLayoutDataGenerator result = new InitGridLayoutDataGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = " = new ";
  protected final String TEXT_4 = "();" + NL + "\t\t\t";
  protected final String TEXT_5 = ".verticalAlignment = ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ";" + NL + "\t\t\t";
  protected final String TEXT_8 = ".horizontalAlignment = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = ".widthHint = ";
  protected final String TEXT_13 = ";" + NL + "\t\t\t";
  protected final String TEXT_14 = ".heightHint = ";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "\t\t\t";
  protected final String TEXT_17 = ".horizontalIndent = ";
  protected final String TEXT_18 = ";" + NL + "\t\t\t";
  protected final String TEXT_19 = ".horizontalSpan = ";
  protected final String TEXT_20 = ";" + NL + "\t\t\t";
  protected final String TEXT_21 = ".verticalSpan = ";
  protected final String TEXT_22 = ";" + NL + "\t\t\t";
  protected final String TEXT_23 = ".grabExcessHorizontalSpace = ";
  protected final String TEXT_24 = ";" + NL + "\t\t\t";
  protected final String TEXT_25 = ".grabExcessVerticalSpace = ";
  protected final String TEXT_26 = ";" + NL;
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final GridLayoutData gmfLayoutData = (GridLayoutData) argsBundle.getData();
final GraphDefDispatcher dispatcher = argsBundle.getDispatcher();
final String layoutConstraintVarName = argsBundle.getConstraintVariableName();

final String layoutImplClassName = dispatcher.getFQNSwitch().get(gmfLayoutData, dispatcher.getImportManager());

    stringBuffer.append(TEXT_1);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(gmfLayoutData.getVerticalAlignment().getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(layoutImplClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gmfLayoutData.getHorizontalAlignment().getName());
    stringBuffer.append(TEXT_10);
    
Dimension sizeHint = gmfLayoutData.getSizeHint();
if (sizeHint != null){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sizeHint.getDx());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sizeHint.getDy());
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(gmfLayoutData.getHorizontalIndent());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(gmfLayoutData.getHorizontalSpan());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(gmfLayoutData.getVerticalSpan());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(gmfLayoutData.isGrabExcessHorizontalSpace());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(layoutConstraintVarName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(gmfLayoutData.isGrabExcessVerticalSpace());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
