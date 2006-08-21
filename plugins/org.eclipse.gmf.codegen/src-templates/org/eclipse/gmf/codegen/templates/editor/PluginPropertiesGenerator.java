package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

public class PluginPropertiesGenerator
{
  protected static String nl;
  public static synchronized PluginPropertiesGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginPropertiesGenerator result = new PluginPropertiesGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "pluginName=";
  protected final String TEXT_2 = NL + "providerName=";
  protected final String TEXT_3 = NL + "# gmf generator persistent region begin" + NL + "# gmf generator persistent region end";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenPlugin genPlugin = (GenPlugin) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getProvider());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
