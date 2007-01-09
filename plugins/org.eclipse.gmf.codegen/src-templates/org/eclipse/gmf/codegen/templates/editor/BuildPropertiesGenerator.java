package org.eclipse.gmf.codegen.templates.editor;

public class BuildPropertiesGenerator
{
  protected static String nl;
  public static synchronized BuildPropertiesGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    BuildPropertiesGenerator result = new BuildPropertiesGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "bin.includes = .,\\" + NL + "               META-INF/,\\" + NL + "               plugin.xml,\\" + NL + "               plugin.properties,\\" + NL + "               messages.properties" + NL + "jars.compile.order = ." + NL + "source.. = src/" + NL + "output.. = bin/";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
