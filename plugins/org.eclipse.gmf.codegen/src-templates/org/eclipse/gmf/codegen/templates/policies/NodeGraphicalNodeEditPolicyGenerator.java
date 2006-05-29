package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NodeGraphicalNodeEditPolicyGenerator
{
  protected static String nl;
  public static synchronized NodeGraphicalNodeEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeGraphicalNodeEditPolicyGenerator result = new NodeGraphicalNodeEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_9 = " getConnectionCompleteCommand(" + NL + "\t\t\t";
  protected final String TEXT_10 = " request) {" + NL + "\t\t";
  protected final String TEXT_11 = " elementType = getElementType(request);";
  protected final String TEXT_12 = NL + "\t\tif (";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " == elementType) {" + NL + "\t\t\treturn getConnectionWithReorientedViewCompleteCommand(request);" + NL + "\t\t}";
  protected final String TEXT_15 = NL + "\t\treturn super.getConnectionCompleteCommand(request);" + NL + "\t}";
  protected final String TEXT_16 = NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenNode genNode = (GenNode) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genNode.getDiagram();

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
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseGraphicalNodeEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
Set ids = new HashSet();
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
		continue;
	}
	GenClass incomingClass;
	GenClass outgoingClass;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		outgoingClass = modelFacet.getSourceMetaFeature() == null
			? modelFacet.getContainmentMetaFeature().getGenClass()
			: modelFacet.getSourceMetaFeature().getTypeGenClass();
		incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		incomingClass = metaFeature.getTypeGenClass();
	} else {
		continue;
	}
	if (genNode.getModelFacet() == null) {
		continue;
	}
	GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
	boolean canBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
	boolean canBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
/*
 * This logic is currently alligned with the logic in NodeItemSemanticEditPolicy.javajet i.e.:
 *
 * - we do not perform link rotation if this link could be drawn from instance of this EP 
 *   to the instance of this EP.
 *
 * - if link could be created in "opposite" direction (genLink.isIncomingCreationAllowed() == true)
 *   and this EP could be only a source of the link then we should reverse link at the end of link 
 *   creation
 *
 */
	if (canBeSource && canBeTarget) {
		continue;
	}
	if (genLink.isIncomingCreationAllowed() && canBeSource) {
		ids.add(genLink.getUniqueIdentifier());
	}
}
if (!ids.isEmpty()) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_11);
    	for (Iterator it = ids.iterator(); it.hasNext();) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append((String) it.next());
    stringBuffer.append(TEXT_14);
    	}
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
