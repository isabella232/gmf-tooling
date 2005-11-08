package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.commands.CompoundCommand;" + NL + "import org.eclipse.gef.requests.GroupRequest;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ConnectionEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldDeleteSemantic() {" + NL + "\t\treturn false;" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command createDeleteViewCommand(GroupRequest deleteRequest) {" + NL + "\t\tCompoundCommand cmd = new CompoundCommand();" + NL + "\t\tcmd.add(super.createDeleteViewCommand(deleteRequest));" + NL + "\t\tcmd.add(createDeleteSemanticCommand(deleteRequest));" + NL + "\t\treturn cmd;" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(diagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName(diagram.getReferenceConnectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_5);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
