package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = NL + "import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;" + NL + "import org.eclipse.jface.preference.IPreferenceStore;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends DiagramPreferenceInitializer {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IPreferenceStore getPreferenceStore() {" + NL + "\t\treturn ";
  protected final String TEXT_3 = ".getInstance().getPreferenceStore();" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenEditorGenerator editorGen = (GenEditorGenerator) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(editorGen.getDiagram().getPreferenceInitializerClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(editorGen.getPlugin().getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
