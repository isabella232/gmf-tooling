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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.Collection;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractModelCommand;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractModelCommand {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IAdaptable edgeAdaptor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(String label) {" + NL + "\t\tsuper(label, null);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Collection getAffectedObjects() {" + NL + "\t\tView view = (View) edgeAdaptor.getAdapter(View.class);" + NL + "\t\tif (view != null) {" + NL + "\t\t\treturn getWorkspaceFilesFor(view);" + NL + "\t\t}" + NL + "\t\treturn super.getAffectedObjects();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IAdaptable getEdgeAdaptor() {" + NL + "\t\treturn edgeAdaptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setEdgeAdaptor(IAdaptable edgeAdaptor) {" + NL + "\t\tthis.edgeAdaptor = edgeAdaptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "\t\tassert null != edgeAdaptor : \"Null child in ";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "\t\tEdge edge = (Edge) getEdgeAdaptor().getAdapter(Edge.class);" + NL + "\t\tassert null != edge : \"Null edge in ";
  protected final String TEXT_8 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t\tView tempView = edge.getSource();" + NL + "\t\tedge.setSource(edge.getTarget());" + NL + "\t\tedge.setTarget(tempView);" + NL + "" + NL + "\t\treturn newOKCommandResult();" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditCommandsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditCommandsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getReorientConnectionViewCommandClassName());
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
