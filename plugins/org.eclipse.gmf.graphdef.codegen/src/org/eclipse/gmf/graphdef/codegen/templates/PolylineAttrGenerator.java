package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.GraphDefDispatcher;

public class PolylineAttrGenerator
{
  protected static String nl;
  public static synchronized PolylineAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PolylineAttrGenerator result = new PolylineAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = ".addPoint(new ";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
final Polyline figureInstance = (Polyline) args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(dispatcher.dispatch("Shape", args));
    if (!figureInstance.getTemplate().isEmpty()) {
	final String pointClassName = importManager.getImportedName("org.eclipse.draw2d.geometry.Point");
	for (java.util.Iterator pointIt = figureInstance.getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(pointClassName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_6);
    }}
    return stringBuffer.toString();
  }
}
