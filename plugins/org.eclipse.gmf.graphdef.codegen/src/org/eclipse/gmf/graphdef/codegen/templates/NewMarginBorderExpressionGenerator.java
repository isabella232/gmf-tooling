package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.gmf.common.codegen.ImportAssistant;

public class NewMarginBorderExpressionGenerator
{
  protected static String nl;
  public static synchronized NewMarginBorderExpressionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewMarginBorderExpressionGenerator result = new NewMarginBorderExpressionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "new ";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ")";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
final MarginBorder border = (MarginBorder)args[0];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher)args[1];
final ImportAssistant importManager = dispatcher.getImportManager();

//Produces EXPRESSION instead of statement

    
	int top = 0;
	int left = 0;
	int bottom = 0;
	int right = 0;
	if (border.eIsSet(GMFGraphPackage.eINSTANCE.getMarginBorder_Insets())){
		Insets insets = border.getInsets();
		top = insets.getTop();
		left = insets.getLeft();
		bottom = insets.getBottom();
		right = insets.getRight();
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.MarginBorder"));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dispatcher.DPtoLP(top));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dispatcher.DPtoLP(left));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dispatcher.DPtoLP(bottom));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dispatcher.DPtoLP(right));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
