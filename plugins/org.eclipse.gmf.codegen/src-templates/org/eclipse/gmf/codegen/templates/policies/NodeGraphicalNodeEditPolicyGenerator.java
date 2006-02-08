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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends ";
  protected final String TEXT_5 = " {";
  protected final String TEXT_6 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_7 = " getConnectionCompleteCommand(" + NL + "\t\t\t";
  protected final String TEXT_8 = " request) {" + NL + "\t\t";
  protected final String TEXT_9 = " elementType = getElementType(request);";
  protected final String TEXT_10 = NL + "\t\tif (";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " == elementType) {" + NL + "\t\t\treturn getConnectionWithReorientedViewCompleteCommand(request);" + NL + "\t\t}";
  protected final String TEXT_13 = NL + "\t\treturn super.getConnectionCompleteCommand(request);" + NL + "\t}";
  protected final String TEXT_14 = NL + "}";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) ((Object[]) argument)[0];
GenDiagram genDiagram = genNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genNode.getGraphicalNodeEditPolicyClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseGraphicalNodeEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_5);
    
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
Set ids = new HashSet();
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
/**
 * Do not perform any rotation of links in notation model if this property was not specified in 
 * .gmfgen model
 **/	
	if (!genLink.isViewDirectionAlignedWithModel()) {
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
// Should not be here!
		continue;
	}
	boolean canBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
	boolean canBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
/**
 * This logic is currently alligned with the logic in NodeItemSemanticEditPolicy.javajet i.e.:
 * 
 * - we do not perform link rotation if this link could be drawn from instance of this EP 
 *   to the instance of this EP.
 *
 * - if link could be created in "opposite" direction (genLink.isIncomingCreationAllowed() == true)
 *   and this EP could be only a source of the link then we should reverse link at the end of link 
 *   creation
 *
 **/	
	if (canBeSource && canBeTarget) {
		continue;
	}
	
	if (genLink.isIncomingCreationAllowed() && canBeSource) {
		ids.add(genLink.getUniqueIdentifier());
	}
}
if (!ids.isEmpty()) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_9);
    	for (Iterator it = ids.iterator(); it.hasNext();) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append((String) it.next());
    stringBuffer.append(TEXT_12);
    	}
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
