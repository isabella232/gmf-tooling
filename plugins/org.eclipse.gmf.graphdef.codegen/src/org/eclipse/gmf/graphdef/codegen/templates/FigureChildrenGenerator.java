package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;
import java.util.*;

public class FigureChildrenGenerator
{
  protected static String nl;
  public static synchronized FigureChildrenGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    FigureChildrenGenerator result = new FigureChildrenGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t// FIXME instantiate - FigureRef - dispatch to 'instantiate' template?" + NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = ".add(";
  protected final String TEXT_6 = ");" + NL + "\t\t";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
List/*<Figure>*/ figureChildren = (List) args[0];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher) args[1];
GraphDefDispatcher.LayoutArgs parentArgs = (GraphDefDispatcher.LayoutArgs) args[2];

    stringBuffer.append(TEXT_1);
    
LinkedList l = new LinkedList();
l.addAll(figureChildren);
final Object marker = new Object();
Stack figureVarNamesStack = new Stack();
int figureCount = 0;
while (!l.isEmpty()) {
	Object _nxt = l.removeFirst();
	if (_nxt == marker) {
		parentArgs = (GraphDefDispatcher.LayoutArgs) figureVarNamesStack.pop();
		continue;
	}
	final FigureMarker figureMarker = (FigureMarker) _nxt;
	if (figureMarker instanceof FigureRef) {
		throw new IllegalStateException("FIXME: sorry, don't support FigureRef for a while");
	}
	final String figureVarName = "fig_" + figureCount;
	final String layoutManagerVarName = "layouter" + figureCount;
	final String layoutDataVarName = "layData" + figureCount;
	figureCount++;
    stringBuffer.append(TEXT_2);
    GraphDefDispatcher.LayoutArgs nextLevelArgs = dispatcher.createLayoutArgs((Figure) figureMarker, figureVarName, layoutManagerVarName, layoutDataVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dispatcher.dispatch("instantiate", nextLevelArgs));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(parentArgs.getVariableName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dispatcher.dispatch("createLayoutData", dispatcher.createLayoutArgs(nextLevelArgs, parentArgs.getManagerVariableName(), layoutDataVarName)));
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentArgs);
	parentArgs = nextLevelArgs; // go on processing children of new parentFigure
} // if
} // while

    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
