package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class InitFlowLayoutGenerator
{
  protected static String nl;
  public static synchronized InitFlowLayoutGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitFlowLayoutGenerator result = new InitFlowLayoutGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = ".setStretchMinorAxis(";
  protected final String TEXT_3 = ");" + NL + "\t\t";
  protected final String TEXT_4 = ".setMinorAlignment(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = "\t\t" + NL + "\t\t";
  protected final String TEXT_7 = ".setSpacing(";
  protected final String TEXT_8 = ");" + NL + "\t\t";
  protected final String TEXT_9 = ".setVertical(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = ".setMajorAlignment(";
  protected final String TEXT_13 = ");" + NL + "\t\t";
  protected final String TEXT_14 = ".setMajorSpacing(";
  protected final String TEXT_15 = ");" + NL + "\t\t";
  protected final String TEXT_16 = ".setMinorSpacing(";
  protected final String TEXT_17 = ");" + NL + "\t\t";
  protected final String TEXT_18 = ".setHorizontal(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + NL;
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final FlowLayout gmfLayout = (FlowLayout) argsBundle.getLayout();
final String layouterVarName = argsBundle.getManagerVariableName();

class AlignmentConverter {
	public String convert(Alignment alignment){
		if (alignment == null){
			alignment = Alignment.BEGINNING_LITERAL;
		}
		switch (alignment.getValue()){
			case Alignment.BEGINNING : 
				return "ALIGN_LEFTTOP";
			case Alignment.END :
				return "ALIGN_RIGHTBOTTOM";
			case Alignment.FILL:
			case Alignment.CENTER:
				return "ALIGN_CENTER";
			default:
				throw new IllegalArgumentException("Unknown alignment: " + alignment);
		}
	}
}

final AlignmentConverter alignmentConverter = new AlignmentConverter();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(gmfLayout.isMatchMinorSize());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(alignmentConverter.convert(gmfLayout.getMinorAlignment()));
    stringBuffer.append(TEXT_5);
    
if (gmfLayout.isForceSingleLine()){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(gmfLayout.getMajorSpacing());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gmfLayout.isVertical());
    stringBuffer.append(TEXT_10);
    
} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(alignmentConverter.convert(gmfLayout.getMajorAlignment()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(gmfLayout.getMajorSpacing());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(gmfLayout.getMinorSpacing());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(!gmfLayout.isVertical());
    stringBuffer.append(TEXT_19);
    
} 

    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
