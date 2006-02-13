package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitBorderLayoutDataGenerator
{
  protected static String nl;
  public static synchronized InitBorderLayoutDataGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitBorderLayoutDataGenerator result = new InitBorderLayoutDataGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = ".getParent().getLayoutManager().setConstraint(";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ");" + NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final BorderLayoutData gmfLayoutData = (BorderLayoutData) argsBundle.getData();
final String figureVarName = argsBundle.getVariableName();
final GraphDefDispatcher dispatcher = argsBundle.getDispatcher();

    stringBuffer.append(TEXT_1);
    
Alignment alignment = gmfLayoutData.getAlignment();
if (alignment == null){
	alignment = Alignment.CENTER_LITERAL;
}
final String constantName;
switch(alignment.getValue()){
	case Alignment.CENTER: 
	case Alignment.FILL: 
		constantName = "CENTER";
		break;
	case Alignment.BEGINNING:
		if (gmfLayoutData.isVertical()){
			constantName = "TOP";
		} else {
			constantName = "LEFT";
		}
		break;
	case Alignment.END:
		if (gmfLayoutData.isVertical()){
			constantName = "BOTTOM";
		} else {
			constantName = "RIGHT";
		}
		break;
	default:
		throw new IllegalArgumentException("Unknown Alignment: " + gmfLayoutData.getAlignment());
}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dispatcher.getImportManager().getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(constantName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
