package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.GraphDefDispatcher;
import java.util.*;

public class PolylineDecorationAttrGenerator
{
  protected static String nl;
  public static synchronized PolylineDecorationAttrGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PolylineDecorationAttrGenerator result = new PolylineDecorationAttrGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// dispatchNext?";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = " pl = new ";
  protected final String TEXT_5 = "();";
  protected final String TEXT_6 = NL + "\t\tpl.addPoint(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = ".setTemplate(pl);" + NL + "\t\t";
  protected final String TEXT_11 = ".setScale(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.Args args = (GraphDefDispatcher.Args) argument;
// not PolylineDecoration, as we use same template from PolygonDecoration
final Polyline figureInstance = (Polyline) args.getFigure();
final String figureVarName = args.getVariableName();
final GraphDefDispatcher dispatcher = args.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dispatcher.dispatch("Shape", args));
    if (!figureInstance.getTemplate().isEmpty()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.PointList"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.PointList"));
    stringBuffer.append(TEXT_5);
    		for (Iterator pointIt = figureInstance.getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_6);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_8);
    		} /*for*/ 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dispatcher.DPtoLP(7));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dispatcher.DPtoLP(3));
    stringBuffer.append(TEXT_13);
    	} /*!if getTemplate().isEmpty()*/ 
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
