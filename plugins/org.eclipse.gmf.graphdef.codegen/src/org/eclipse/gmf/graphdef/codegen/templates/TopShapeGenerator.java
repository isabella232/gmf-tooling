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
  protected final String TEXT_8 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = " = createFigure";
  protected final String TEXT_11 = "();" + NL + "\t\tsetFigure";
  protected final String TEXT_12 = "(";
  protected final String TEXT_13 = ");" + NL + "\t\tadd(";
  protected final String TEXT_14 = ");" + NL + "\t\t";
  protected final String TEXT_15 = "\t\t";
  protected final String TEXT_16 = NL + "\t}" + NL;
  protected final String TEXT_17 = NL + NL + "\tprivate ";
  protected final String TEXT_18 = " f";
  protected final String TEXT_19 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_20 = " getFigure";
  protected final String TEXT_21 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_22 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = " figure) {" + NL + "\t\tf";
  protected final String TEXT_25 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_26 = " createFigure";
  protected final String TEXT_27 = "() {";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "\t\treturn rv;" + NL + "\t}" + NL;
  protected final String TEXT_31 = NL + "}";
  protected final String TEXT_32 = NL;

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
    
importManager.addImport("org.eclipse.draw2d.IFigure");
final String draw2d_IFigure = importManager.getImportedName("org.eclipse.draw2d.IFigure");

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
    stringBuffer.append(draw2d_IFigure);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dispatcher.dispatch("createLayoutData", dispatcher.createLayoutArgs(next, childVarName, dispatcherArgs.getManagerVariableName(), "layoutData" + next.getName())));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
int fc = 0;
for (Iterator it = figure.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_17);
    stringBuffer.append(draw2d_IFigure);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(draw2d_IFigure);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(draw2d_IFigure);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(draw2d_IFigure);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dispatcher.dispatch("instantiate", dispatcher.create(next, "rv")));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dispatcher.dispatch("Children", new Object[] {next.getChildren(), dispatcher, "rv"}));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
