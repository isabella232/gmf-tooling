package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;

public class ConstrainedToolbarLayoutEditPolicyGenerator
{
  protected static String nl;
  public static synchronized ConstrainedToolbarLayoutEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ConstrainedToolbarLayoutEditPolicyGenerator result = new ConstrainedToolbarLayoutEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPolicy;" + NL + "import ";
  protected final String TEXT_6 = ".ITextAwareEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.TextSelectionEditPolicy;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ConstrainedToolbarLayoutEditPolicy\textends org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditPolicy createChildEditPolicy(EditPart child) {" + NL + "\t\tif( child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null )" + NL + "\t\t{" + NL + "\t\t\tif (child instanceof ITextAwareEditPart)" + NL + "\t\t\t\treturn new TextSelectionEditPolicy();" + NL + "\t\t}" + NL + "\t\treturn super.createChildEditPolicy(child);" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
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
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
