package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
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
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_8 = " getConnectionCompleteCommand(" + NL + "\t\t\t";
  protected final String TEXT_9 = " request) {" + NL + "\t\t";
  protected final String TEXT_10 = " elementType = getElementType(request);";
  protected final String TEXT_11 = NL + "\t\tif (";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " == elementType) {" + NL + "\t\t\treturn getConnectionWithReorientedViewCompleteCommand(request);" + NL + "\t\t}";
  protected final String TEXT_14 = NL + "\t\treturn super.getConnectionCompleteCommand(request);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IElementType getElementType(CreateConnectionRequest request) {" + NL + "\t\tif (request instanceof CreateConnectionViewAndElementRequest) {" + NL + "\t\t\tCreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request)" + NL + "\t\t\t\t\t.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();" + NL + "\t\t\treturn (IElementType) requestAdapter.getAdapter(IElementType.class);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getConnectionWithReorientedViewCompleteCommand(CreateConnectionRequest request) {" + NL + "\t\tICommandProxy c = (ICommandProxy) super.getConnectionCompleteCommand(request);" + NL + "\t\tCompositeCommand cc = (CompositeCommand) c.getICommand();" + NL + "\t\tTransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();" + NL + "\t\t";
  protected final String TEXT_15 = " rcvCommand =" + NL + "\t\t\tnew ";
  protected final String TEXT_16 = "(editingDomain, null);" + NL + "\t\trcvCommand.setEdgeAdaptor(getViewAdapter());" + NL + "\t\tcc.compose(rcvCommand);" + NL + "\t\treturn c;" + NL + "\t}" + NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenNode genNode = (GenNode) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = genNode.getDiagram();

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
    stringBuffer.append(genNode.getGraphicalNodeEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_10);
    	for (Iterator it = genNode.getReorientedIncomingGenLinks().iterator(); it.hasNext();) {
		GenLink nextLink = (GenLink) it.next();
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_13);
    	}
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReorientConnectionViewCommandQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReorientConnectionViewCommandQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
