package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.GraphDefDispatcher;

public class TopFigureGenerator
{
  protected static String nl;
  public static synchronized TopFigureGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TopFigureGenerator result = new TopFigureGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean myUseLocalCoordinates;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean useLocalCoordinates() {" + NL + "\t\treturn myUseLocalCoordinates;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setUseLocalCoordinates(boolean useLocalCoordinates) {" + NL + "\t\tmyUseLocalCoordinates = useLocalCoordinates;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
Figure figure = (Figure) args[0];
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
    stringBuffer.append(dispatcher.dispatch(figure, dispatcher.create(figure, "this")));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dispatcher.dispatch("Children", new Object[] {figure.getChildren(), dispatcher, "this"}));
    stringBuffer.append(TEXT_7);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
