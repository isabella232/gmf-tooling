package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ActionBarContributorGenerator
{
  protected static String nl;
  public static synchronized ActionBarContributorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ActionBarContributorGenerator result = new ActionBarContributorGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends DiagramActionBarContributor {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getEditorClass() {" + NL + "\t\treturn ";
  protected final String TEXT_5 = ".class;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getEditorId() {" + NL + "\t\treturn ";
  protected final String TEXT_6 = ".ID;" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView editorView = (GenEditorView) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = editorView.getEditorGen().getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(editorView.getActionBarContributorClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(editorView.getClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(editorView.getClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
