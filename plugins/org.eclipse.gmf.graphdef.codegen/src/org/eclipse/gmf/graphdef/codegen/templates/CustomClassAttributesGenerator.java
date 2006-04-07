package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import java.util.*;

public class CustomClassAttributesGenerator
{
  protected static String nl;
  public static synchronized CustomClassAttributesGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CustomClassAttributesGenerator result = new CustomClassAttributesGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t{";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + "\t\t\t";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";\t\t";
  protected final String TEXT_8 = NL + "\t\t\t";
  protected final String TEXT_9 = ".set";
  protected final String TEXT_10 = "(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = "\t";
  protected final String TEXT_13 = NL + "\t\t}";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final CustomClass instance = (CustomClass) ((Object[]) argument)[0];
//final GraphDefDispatcher dispatcher = (GraphDefDispatcher) ((Object[]) argument)[1];
final String varName = (String) ((Object[]) argument)[2];
final boolean hasAttributes = !instance.getAttributes().isEmpty();

    	if (hasAttributes) {
    stringBuffer.append(TEXT_1);
    	}
    
int attrIndex = 0;
for (Iterator attrs = instance.getAttributes().iterator(); attrs.hasNext(); attrIndex++){
	CustomAttribute next = (CustomAttribute) attrs.next(); 
	String varValue;
	if (next.isMultiStatementValue()){
		varValue = "attr" + attrIndex;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(java.text.MessageFormat.format(next.getValue(), new Object[] {varValue}));
    stringBuffer.append(TEXT_3);
    	} else {
	 	varValue = next.getValue();
}
	if (next.isDirectAccess()) { 

    stringBuffer.append(TEXT_4);
    stringBuffer.append(varName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(varValue);
    stringBuffer.append(TEXT_7);
    			
	} else {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(varName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(CodeGenUtil.capName(next.getName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(varValue);
    stringBuffer.append(TEXT_11);
    	
	}

    stringBuffer.append(TEXT_12);
    
} //for 

    	if (hasAttributes) {
    stringBuffer.append(TEXT_13);
    	}
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
