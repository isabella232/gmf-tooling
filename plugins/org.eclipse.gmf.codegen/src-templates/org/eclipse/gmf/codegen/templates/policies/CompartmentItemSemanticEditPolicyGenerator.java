package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class CompartmentItemSemanticEditPolicyGenerator
{
  protected static String nl;
  public static synchronized CompartmentItemSemanticEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CompartmentItemSemanticEditPolicyGenerator result = new CompartmentItemSemanticEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateCommand(CreateElementRequest req) {";
  protected final String TEXT_8 = NL + "\t\tif (";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " == req.getElementType()) {" + NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_13 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_14 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_15 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_16 = "Command extends ";
  protected final String TEXT_17 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_18 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_19 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_20 = ".eINSTANCE.get";
  protected final String TEXT_21 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_22 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_23 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_24 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_25 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_26 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_27 = " doDefaultElementCreation() {";
  protected final String TEXT_28 = NL + "\t\t\t";
  protected final String TEXT_29 = " newElement = (";
  protected final String TEXT_30 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_31 = ".Initializers.";
  protected final String TEXT_32 = ".init(newElement);" + NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_33 = NL + "\t}";
  protected final String TEXT_34 = NL + "}";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenCompartment genCompartment = (GenCompartment) argument;
GenDiagram genDiagram = genCompartment.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genCompartment.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();

    stringBuffer.append(TEXT_7);
    
for (Iterator nodes = genCompartment.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genNode.getModelFacet();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
for (Iterator nodes = genCompartment.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genNode.getModelFacet();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genCompartment.getNode().getModelFacet().getMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_25);
    	if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_27);
    		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_32);
    	}
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
