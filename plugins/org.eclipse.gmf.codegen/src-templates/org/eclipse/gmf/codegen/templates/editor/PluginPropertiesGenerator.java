package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import java.util.*;

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
  protected final String TEXT_3 = NL + "navigatorContentName=*.";
  protected final String TEXT_4 = " diagram contents";
  protected final String TEXT_5 = NL + "###" + NL + "# Property Sheet";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "tab.";
  protected final String TEXT_8 = "=";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenPlugin genPlugin = (GenPlugin) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getProvider());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genPlugin.getEditorGen().getDiagramFileExtension());
    stringBuffer.append(TEXT_4);
    if (genPlugin.getEditorGen().getPropertySheet() != null) {
	final GenPropertySheet propertySheet = genPlugin.getEditorGen().getPropertySheet();
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    for (Iterator it = propertySheet.getTabs().iterator(); it.hasNext(); ) {
	final GenPropertyTab tab = (GenPropertyTab) it.next();
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tab.getID());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tab.getLabel());
    }
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
