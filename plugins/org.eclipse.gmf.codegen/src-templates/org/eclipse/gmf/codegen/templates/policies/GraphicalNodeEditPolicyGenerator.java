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
  protected final String TEXT_13 = " == elementType) {";
  protected final String TEXT_14 = NL + "\t\t\tif (request.getSourceEditPart() != getHost()) {";
  protected final String TEXT_15 = NL + "\t\t\treturn getConnectionWithReorientedViewCompleteCommand(request);";
  protected final String TEXT_16 = NL + "\t\t\t}";
  protected final String TEXT_17 = NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\treturn super.getConnectionCompleteCommand(request);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_19 = " getElementType(";
  protected final String TEXT_20 = " request) {" + NL + "\t\tif (request instanceof ";
  protected final String TEXT_21 = ") {" + NL + "\t\t\t";
  protected final String TEXT_22 = " requestAdapter = ((";
  protected final String TEXT_23 = ") request)" + NL + "\t\t\t\t\t.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();" + NL + "\t\t\treturn (";
  protected final String TEXT_24 = ") requestAdapter.getAdapter(";
  protected final String TEXT_25 = ".class);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_26 = " getConnectionWithReorientedViewCompleteCommand(";
  protected final String TEXT_27 = " request) {" + NL + "\t\t";
  protected final String TEXT_28 = " c = (";
  protected final String TEXT_29 = ") super.getConnectionCompleteCommand(request);" + NL + "\t\t";
  protected final String TEXT_30 = " cc = (";
  protected final String TEXT_31 = ") c.getICommand();" + NL + "\t\t";
  protected final String TEXT_32 = " editingDomain = ((";
  protected final String TEXT_33 = ") getHost()).getEditingDomain();" + NL + "\t\t";
  protected final String TEXT_34 = " rcvCommand =" + NL + "\t\t\tnew ";
  protected final String TEXT_35 = "(editingDomain, null);" + NL + "\t\trcvCommand.setEdgeAdaptor(getViewAdapter());" + NL + "\t\tcc.compose(rcvCommand);" + NL + "\t\treturn c;" + NL + "\t}" + NL + "}";
  protected final String TEXT_36 = NL;

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
    		if (nextLink.isOutgoingCreationAllowed()) {
    stringBuffer.append(TEXT_14);
    		}
    stringBuffer.append(TEXT_15);
    		if (nextLink.isOutgoingCreationAllowed()) {
    stringBuffer.append(TEXT_16);
    		}
    stringBuffer.append(TEXT_17);
    	}
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReorientConnectionViewCommandQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReorientConnectionViewCommandQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
