package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.Dispatcher;

public class LabelAttrGenerator
{
  protected static String nl;
  public static synchronized LabelAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LabelAttrGenerator result = new LabelAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = ".setText(\"";
  protected final String TEXT_3 = "\");";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Dispatcher.Args args = (Dispatcher.Args) argument;
final Label figureInstance = (Label) args.getFigure();
final String figureVarName = args.getVariableName();
final Dispatcher dispatcher = args.getDispatcher();

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getLabel_Text())) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figureInstance.getText());
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(dispatcher.dispatch("Figure", args));
    return stringBuffer.toString();
  }
}
