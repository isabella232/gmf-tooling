package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

public class PreferencesInitializerGenerator
{
  protected static String nl;
  public static synchronized PreferencesInitializerGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PreferencesInitializerGenerator result = new PreferencesInitializerGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;" + NL + "import org.eclipse.jface.preference.IPreferenceStore;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends DiagramPreferenceInitializer {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IPreferenceStore getPreferenceStore() {" + NL + "\t\treturn ";
  protected final String TEXT_4 = ".getInstance().getPreferenceStore();" + NL + "\t}" + NL + "}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getPreferenceInitializerClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
