package org.eclipse.gmf.graphdef.codegen.standalone.templates;

import org.eclipse.gmf.graphdef.codegen.*;

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
  protected final String TEXT_1 = "pluginName = ";
  protected final String TEXT_2 = NL + "providerName = ";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final StandaloneGenerator.Config config = (StandaloneGenerator.Config) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(config.getPluginFriendlyName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(config.getPluginProviderName());
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
