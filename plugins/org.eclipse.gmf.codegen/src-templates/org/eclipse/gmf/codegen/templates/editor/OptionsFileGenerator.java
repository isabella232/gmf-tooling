package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

public class OptionsFileGenerator
{
  protected static String nl;
  public static synchronized OptionsFileGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    OptionsFileGenerator result = new OptionsFileGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "# Debugging options for the ";
  protected final String TEXT_2 = " plug-in" + NL + "" + NL + "# Turn on general debugging for the ";
  protected final String TEXT_3 = " plug-in";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "/debug=false" + NL + "" + NL + "# Turn on debugging of visualID processing";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "/debug/visualID=true";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenPlugin genPlugin = (GenPlugin) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
