package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class CompartmentItemSemanticEditPolicyGenerator {
 
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
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends ";
  protected final String TEXT_5 = " {";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_9 = " getCreateCommand(";
  protected final String TEXT_10 = " req) {";
  protected final String TEXT_11 = NL + "\t\tif (";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " == req.getElementType()) {";
  protected final String TEXT_14 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_15 = " container = (";
  protected final String TEXT_16 = ") req.getContainer();";
  protected final String TEXT_17 = NL + "\t\t\tif (";
  protected final String TEXT_18 = " != null) {";
  protected final String TEXT_19 = NL + "\t\t\tif (";
  protected final String TEXT_20 = ".size() >= ";
  protected final String TEXT_21 = ") {";
  protected final String TEXT_22 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_23 = NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_24 = ".eINSTANCE.get";
  protected final String TEXT_25 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_26 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_28 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_29 = "Command extends ";
  protected final String TEXT_30 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_31 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_32 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_33 = ".eINSTANCE.get";
  protected final String TEXT_34 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_35 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_36 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_37 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_38 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_39 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_40 = " doDefaultElementCreation() {";
  protected final String TEXT_41 = NL + "\t\t\t";
  protected final String TEXT_42 = " newElement = (";
  protected final String TEXT_43 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_44 = ".Initializers.";
  protected final String TEXT_45 = ".init(newElement);" + NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "\t}";
  protected final String TEXT_47 = NL + NL + "}";
  protected final String TEXT_48 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".set");
			result.append(feature.getAccessorName());
			result.append("(");
		}
		return result.toString();
	}
 
	public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenCompartment genCompartment = (GenCompartment) argument;
GenDiagram genDiagram = genCompartment.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genCompartment.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_5);
    
GenChildContainer childContainer = genCompartment;
GenNode containerNode = genCompartment.getNode();

    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_10);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	int upperBound = containmentMetaFeature.getEcoreFeature().getUpperBound();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_13);
    
	if (upperBound > 0) {
		String containerInterfaceName = importManager.getImportedName(containerNode.getModelFacet().getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_14);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_16);
    
		if (upperBound == 1) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_18);
    
		} else {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_21);
    
		}

    stringBuffer.append(TEXT_22);
    
	}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(containerNode.getModelFacet().getMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_38);
    	if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_40);
    		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_45);
    	}
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}