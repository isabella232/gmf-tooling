package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

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

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends DiagramActionBarContributor {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getEditorClass() {" + NL + "\t\treturn ";
  protected final String TEXT_4 = ".class;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getEditorId() {" + NL + "\t\treturn ";
  protected final String TEXT_5 = ".EDITOR_ID;" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(diagram.getActionBarContributorClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(diagram.getEditorClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(diagram.getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
