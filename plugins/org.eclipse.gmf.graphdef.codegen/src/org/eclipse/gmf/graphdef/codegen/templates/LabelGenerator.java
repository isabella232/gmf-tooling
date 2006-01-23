package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;

public class LabelGenerator
{
  protected static String nl;
  public static synchronized LabelGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LabelGenerator result = new LabelGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends org.eclipse.draw2d.Label {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {" + NL + "\t\tsuper();" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
Label figure = (Label) argument;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
