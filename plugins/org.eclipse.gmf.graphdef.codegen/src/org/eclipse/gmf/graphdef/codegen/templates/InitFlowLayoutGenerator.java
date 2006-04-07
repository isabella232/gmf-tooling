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
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = "\t\t" + NL + "\t\t";
  protected final String TEXT_8 = ".setSpacing(";
  protected final String TEXT_9 = ");" + NL + "\t\t";
  protected final String TEXT_10 = ".setVertical(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = ".setMajorAlignment(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ");" + NL + "\t\t";
  protected final String TEXT_16 = ".setMajorSpacing(";
  protected final String TEXT_17 = ");" + NL + "\t\t";
  protected final String TEXT_18 = ".setMinorSpacing(";
  protected final String TEXT_19 = ");" + NL + "\t\t";
  protected final String TEXT_20 = ".setHorizontal(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + NL;
  protected final String TEXT_23 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs argsBundle = (GraphDefDispatcher.LayoutArgs) argument;
final FlowLayout gmfLayout = (FlowLayout) argsBundle.getLayout();
final String layouterVarName = argsBundle.getManagerVariableName();
final GraphDefDispatcher dispatcher = argsBundle.getDispatcher();
final String layouterClassName = dispatcher.getFQNSwitch().get(gmfLayout, dispatcher.getImportManager());

class AlignmentConverter {
	private final String myBegin;
	private final String myCenter;
	private final String myEnd;
	
	public AlignmentConverter(String begin, String center, String end){
		myBegin = begin;
		myCenter = center;
		myEnd = end;
	}
	
	public String convert(Alignment alignment){
		if (alignment == null){
			alignment = Alignment.BEGINNING_LITERAL;
		}
		switch (alignment.getValue()){
			case Alignment.BEGINNING : 
				return myBegin;
			case Alignment.END :
				return myEnd;
			case Alignment.FILL:
			case Alignment.CENTER:
				return myCenter;
			default:
				throw new IllegalArgumentException("Unknown alignment: " + alignment);
		}
	}
}

class AlignmentFacade {
	public String convert(FlowLayout layout, Alignment alignment){
		return getConverter(layout).convert(alignment);
	}
	
	private AlignmentConverter getConverter(FlowLayout layout){
		return layout.isForceSingleLine() ? 
			new AlignmentConverter("ALIGN_TOPLEFT", "ALIGN_CENTER", "ALIGN_BOTTOMRIGHT") : 
			new AlignmentConverter("ALIGN_LEFTTOP", "ALIGN_CENTER", "ALIGN_RIGHTBOTTOM");
	}
}

final AlignmentFacade alignmentFacade = new AlignmentFacade();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(gmfLayout.isMatchMinorSize());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(layouterClassName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(alignmentFacade.convert(gmfLayout, gmfLayout.getMinorAlignment()));
    stringBuffer.append(TEXT_6);
    
if (gmfLayout.isForceSingleLine()){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gmfLayout.getMajorSpacing());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(gmfLayout.isVertical());
    stringBuffer.append(TEXT_11);
    
} else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(layouterClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(alignmentFacade.convert(gmfLayout, gmfLayout.getMajorAlignment()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(gmfLayout.getMajorSpacing());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(gmfLayout.getMinorSpacing());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(layouterVarName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(!gmfLayout.isVertical());
    stringBuffer.append(TEXT_21);
    
} 

    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
