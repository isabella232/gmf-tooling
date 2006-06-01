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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;" + NL + "import org.eclipse.jface.preference.IPreferenceStore;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends DiagramPreferenceInitializer {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IPreferenceStore getPreferenceStore() {" + NL + "\t\treturn ";
  protected final String TEXT_6 = ".getInstance().getPreferenceStore();" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenEditorGenerator editorGen = (GenEditorGenerator) ((Object[]) argument)[0];
GenDiagram genDiagram = editorGen.getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(editorGen.getDiagram().getPreferenceInitializerClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(editorGen.getPlugin().getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
