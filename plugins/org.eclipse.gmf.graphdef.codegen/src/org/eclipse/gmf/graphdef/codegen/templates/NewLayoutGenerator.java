package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class NewLayoutGenerator
{
  protected static String nl;
  public static synchronized NewLayoutGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewLayoutGenerator result = new NewLayoutGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "();" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t";
  protected final String TEXT_7 = ".setLayoutManager(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final FigureMarker figureMarker = argsBundle.getFigure();
final String figureVarName = argsBundle.getVariableName();
final String layouterVarName = argsBundle.getManagerVariableName();
final GraphDefDispatcher dispatcher = argsBundle.getDispatcher();

    stringBuffer.append(TEXT_1);
    
Layout gmfLayout= figureMarker.getLayout();
if (gmfLayout != null){
	final String layouterImplClass = dispatcher.getFQNSwitch().get(gmfLayout, dispatcher.getImportManager());	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(layouterImplClass);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(layouterImplClass);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(argsBundle.getDispatcher().dispatch(gmfLayout, argsBundle));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_8);
    	
}

    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
