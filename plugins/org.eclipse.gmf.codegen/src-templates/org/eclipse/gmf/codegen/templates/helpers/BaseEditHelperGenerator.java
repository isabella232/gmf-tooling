package org.eclipse.gmf.codegen.templates.helpers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class BaseEditHelperGenerator
{
  protected static String nl;
  public static synchronized BaseEditHelperGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    BaseEditHelperGenerator result = new BaseEditHelperGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractEditHelper {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EDIT_POLICY_COMMAND = \"edit policy command\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getInsteadCommand(IEditCommandRequest req) {" + NL + "\t\tICommand epCommand = (ICommand) req.getParameter(EDIT_POLICY_COMMAND);" + NL + "\t\treq.setParameter(EDIT_POLICY_COMMAND, null);" + NL + "\t\tICommand ehCommand = super.getInsteadCommand(req);" + NL + "\t\tif (epCommand == null) {" + NL + "\t\t\treturn ehCommand;" + NL + "\t\t}" + NL + "\t\tif (ehCommand == null) {" + NL + "\t\t\treturn epCommand;" + NL + "\t\t}" + NL + "\t\tCompositeCommand command = new CompositeCommand(null);" + NL + "\t\tcommand.add(epCommand);" + NL + "\t\tcommand.add(ehCommand);" + NL + "\t\treturn command;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getCreateCommand(CreateElementRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getBaseEditHelperClassName());
    stringBuffer.append(TEXT_5);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
