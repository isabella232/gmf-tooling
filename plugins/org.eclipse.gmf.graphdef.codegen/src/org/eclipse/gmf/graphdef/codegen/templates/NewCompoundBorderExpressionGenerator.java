package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.gmf.common.codegen.ImportAssistant;

public class NewCompoundBorderExpressionGenerator
{
  protected static String nl;
  public static synchronized NewCompoundBorderExpressionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewCompoundBorderExpressionGenerator result = new NewCompoundBorderExpressionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "new ";
  protected final String TEXT_3 = "(" + NL + "\t";
  protected final String TEXT_4 = ", " + NL + "\t";
  protected final String TEXT_5 = NL + ")";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
final CompoundBorder border = (CompoundBorder)args[0];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher)args[1];
final ImportAssistant importManager = dispatcher.getImportManager();

//We want NEITHER insert any names into the scope NOR produce statement. We need expression instead.

    stringBuffer.append(TEXT_1);
     	Border outer = border.getOuter();
		Border inner = border.getInner();
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.CompoundBorder"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append( (outer == null) ? "null" : dispatcher.dispatch(outer, new Object[]{outer, dispatcher}));
    stringBuffer.append(TEXT_4);
    stringBuffer.append( (inner == null) ? "null" : dispatcher.dispatch(inner, new Object[]{inner, dispatcher}));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
