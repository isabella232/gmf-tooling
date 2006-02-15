package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.*;
import java.util.*;

public class TopShapeGenerator
{
  protected static String nl;
  public static synchronized TopShapeGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TopShapeGenerator result = new TopShapeGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {";
  protected final String TEXT_6 = "\t" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\t" + NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_9 = " = createFigure";
  protected final String TEXT_10 = "();" + NL + "\t\tsetFigure";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ");" + NL + "\t\tadd(";
  protected final String TEXT_13 = ");" + NL + "\t\t";
  protected final String TEXT_14 = "\t\t";
  protected final String TEXT_15 = NL + "\t}" + NL;
  protected final String TEXT_16 = NL + NL + "\tprivate IFigure f";
  protected final String TEXT_17 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getFigure";
  protected final String TEXT_18 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_19 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_20 = "(IFigure figure) {" + NL + "\t\tf";
  protected final String TEXT_21 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createFigure";
  protected final String TEXT_22 = "() {";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t\treturn rv;" + NL + "\t}" + NL;
  protected final String TEXT_26 = NL + "}";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
Shape figure = (Shape) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = (GMFGraphSwitch) args[2];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher) args[3];

    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName((String) fqnSwitch.doSwitch(figure)));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_5);
    
GraphDefDispatcher.LayoutArgs dispatcherArgs = dispatcher.createLayoutArgs(figure, "this", "myGenLayoutManager", null);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(dispatcher.dispatch("createLayout", dispatcherArgs));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dispatcher.dispatch(figure, dispatcherArgs));
    
for (Iterator it = figure.getResolvedChildren().iterator(); it.hasNext();) {
		Figure next = (Figure) it.next();
		final String childVarName = "child" + next.getName();
    stringBuffer.append(TEXT_8);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dispatcher.dispatch("createLayoutData", dispatcher.createLayoutArgs(next, childVarName, dispatcherArgs.getManagerVariableName(), "layoutData" + next.getName())));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
int fc = 0;
for (Iterator it = figure.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_16);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dispatcher.dispatch("instantiate", dispatcher.create(next, "rv")));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dispatcher.dispatch("Children", new Object[] {next.getChildren(), dispatcher, "rv"}));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
