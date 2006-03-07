package org.eclipse.gmf.codegen.templates.commands;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ReorientConnectionViewCommandGenerator
{
  protected static String nl;
  public static synchronized ReorientConnectionViewCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ReorientConnectionViewCommandGenerator result = new ReorientConnectionViewCommandGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends AbstractTransactionalCommand {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IAdaptable edgeAdaptor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(TransactionalEditingDomain editingDomain, String label) {" + NL + "\t\tsuper(editingDomain, label, null);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getAffectedFiles() {" + NL + "\t\tView view = (View) edgeAdaptor.getAdapter(View.class);" + NL + "\t\tif (view != null) {" + NL + "\t\t\treturn getWorkspaceFiles(view);" + NL + "\t\t}" + NL + "\t\treturn super.getAffectedFiles();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IAdaptable getEdgeAdaptor() {" + NL + "\t\treturn edgeAdaptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setEdgeAdaptor(IAdaptable edgeAdaptor) {" + NL + "\t\tthis.edgeAdaptor = edgeAdaptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) {" + NL + "\t\tassert null != edgeAdaptor : \"Null child in ";
  protected final String TEXT_10 = "\"; //$NON-NLS-1$" + NL + "\t\tEdge edge = (Edge) getEdgeAdaptor().getAdapter(Edge.class);" + NL + "\t\tassert null != edge : \"Null edge in ";
  protected final String TEXT_11 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t\tView tempView = edge.getSource();" + NL + "\t\tedge.setSource(edge.getTarget());" + NL + "\t\tedge.setTarget(tempView);" + NL + "" + NL + "\t\treturn CommandResult.newOKCommandResult();" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

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
    stringBuffer.append(genDiagram.getEditCommandsPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditCommandsPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
