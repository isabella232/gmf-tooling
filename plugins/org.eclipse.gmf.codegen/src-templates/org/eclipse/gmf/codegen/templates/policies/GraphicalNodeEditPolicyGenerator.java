package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class GraphicalNodeEditPolicyGenerator
{
  protected static String nl;
  public static synchronized GraphicalNodeEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    GraphicalNodeEditPolicyGenerator result = new GraphicalNodeEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.requests.CreateConnectionRequest;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends GraphicalNodeEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IElementType getElementType(CreateConnectionRequest request) {" + NL + "\t\tif (request instanceof CreateConnectionViewAndElementRequest) {" + NL + "\t\t\tCreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request)" + NL + "\t\t\t\t\t.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();" + NL + "\t\t\treturn (IElementType) requestAdapter.getAdapter(IElementType.class);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getConnectionWithReorientedViewCompleteCommand(CreateConnectionRequest request) {" + NL + "\t\tEtoolsProxyCommand c = (EtoolsProxyCommand) super.getConnectionCompleteCommand(request);" + NL + "\t\tCompositeCommand cc = (CompositeCommand) c.getICommand();" + NL + "\t\tTransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();" + NL + "\t\t";
  protected final String TEXT_7 = " rcvCommand =" + NL + "\t\t\tnew ";
  protected final String TEXT_8 = "(editingDomain, null);" + NL + "\t\trcvCommand.setEdgeAdaptor(getViewAdapter());" + NL + "\t\tcc.compose(rcvCommand);" + NL + "\t\treturn c;" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
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
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getBaseGraphicalNodeEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReorientConnectionViewCommandQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReorientConnectionViewCommandQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
