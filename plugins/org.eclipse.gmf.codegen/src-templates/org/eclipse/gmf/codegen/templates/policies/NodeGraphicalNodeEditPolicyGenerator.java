package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_7 = " getConnectionCreateCommand(" + NL + "\t\t\t";
  protected final String TEXT_8 = " request) {" + NL + "\t\t";
  protected final String TEXT_9 = " elementType = getElementType(request);";
  protected final String TEXT_10 = NL + "\t\tif (";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " == elementType) {" + NL + "\t\t\treturn getConnectionWithReorientedViewCreateCommand(request);" + NL + "\t\t}";
  protected final String TEXT_13 = NL + "\t\treturn super.getConnectionCreateCommand(request);" + NL + "\t}";
  protected final String TEXT_14 = NL + "}";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) argument;
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
	if (!genLink.isViewDirectionAlignedWithModel()) {
		continue;
	}
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		if (nodeMetaClass.equals(modelFacet.getTargetMetaFeature().getTypeGenClass())) {
			ids.add(genLink.getUniqueIdentifier());
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (nodeMetaClass.equals(metaFeature.getTypeGenClass())) {
			ids.add(genLink.getUniqueIdentifier());
		}
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
