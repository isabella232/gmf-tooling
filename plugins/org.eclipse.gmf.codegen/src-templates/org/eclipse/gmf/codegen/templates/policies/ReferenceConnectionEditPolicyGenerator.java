package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ReferenceConnectionEditPolicyGenerator
{
  protected static String nl;
  public static synchronized ReferenceConnectionEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ReferenceConnectionEditPolicyGenerator result = new ReferenceConnectionEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.commands.CompoundCommand;" + NL + "import org.eclipse.gef.requests.GroupRequest;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends ConnectionEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldDeleteSemantic() {" + NL + "\t\treturn false;" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command createDeleteViewCommand(GroupRequest deleteRequest) {" + NL + "\t\tCompoundCommand cmd = new CompoundCommand();" + NL + "\t\tcmd.add(super.createDeleteViewCommand(deleteRequest));" + NL + "\t\tcmd.add(createDeleteSemanticCommand(deleteRequest));" + NL + "\t\treturn cmd;" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getReferenceConnectionEditPolicyClassName());
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
