package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.*;
import java.util.Iterator;;

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
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {";
  protected final String TEXT_6 = "\t" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tcreateContents();" + NL + "\t}" + NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean myUseLocalCoordinates = ";
  protected final String TEXT_13 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean useLocalCoordinates() {" + NL + "\t\treturn myUseLocalCoordinates;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setUseLocalCoordinates(boolean useLocalCoordinates) {" + NL + "\t\tmyUseLocalCoordinates = useLocalCoordinates;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "}" + NL + "\t";
  protected final String TEXT_16 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_17 = " ";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL + "\t";
  protected final String TEXT_21 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_22 = " ";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "}";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
Figure figure = (Figure) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final FigureQualifiedNameSwitch fqnSwitch = (FigureQualifiedNameSwitch) args[2];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher) args[3];
final boolean isInnerClass = ((Boolean) args[4]).booleanValue();

    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fqnSwitch.get(figure, importManager));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_5);
    
GraphDefDispatcher.LayoutArgs dispatcherArgs = dispatcher.createLayoutArgs(figure, "this", "myGenLayoutManager", null);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(dispatcher.dispatch("createLayout", dispatcherArgs));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dispatcher.dispatch(figure, dispatcherArgs));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dispatcher.dispatch("Children", dispatcherArgs));
    stringBuffer.append(TEXT_10);
    if (false == figure instanceof Polyline) {/*no much sense to define useLocalCoordinates for polyline and its descendants*/
    stringBuffer.append(TEXT_11);
    
// simple heuristic to detect need for local coordinates
boolean useLocalDefaultValue = false;
for (java.util.Iterator it = figure.getChildren().iterator(); it.hasNext(); ) {
	if (it.next() instanceof Polyline) {
		useLocalDefaultValue = true;
		break;
	}
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(useLocalDefaultValue);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
//input: boolean isInnerClass
if (isInnerClass){ /*put fields out of inner class body*/ 
    stringBuffer.append(TEXT_15);
    
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
for (Iterator allFields = dispatcher.getStaticFieldsManager().allFields(); allFields.hasNext();) {
	StaticFieldsManager.StaticField next = (StaticFieldsManager.StaticField)allFields.next(); 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(next.getType());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(next.getValue());
    stringBuffer.append(TEXT_19);
    
}

     } else { 
    stringBuffer.append(TEXT_20);
    
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
for (Iterator allFields = dispatcher.getStaticFieldsManager().allFields(); allFields.hasNext();) {
	StaticFieldsManager.StaticField next = (StaticFieldsManager.StaticField)allFields.next(); 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(next.getType());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(next.getValue());
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    }
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
