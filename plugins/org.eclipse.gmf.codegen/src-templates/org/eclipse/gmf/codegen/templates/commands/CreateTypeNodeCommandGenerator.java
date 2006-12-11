package org.eclipse.gmf.codegen.templates.commands;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class CreateTypeNodeCommandGenerator {
 
  protected static String nl;
  public static synchronized CreateTypeNodeCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateTypeNodeCommandGenerator result = new CreateTypeNodeCommandGenerator();
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
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = " req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_10 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_13 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_14 = " container = ((";
  protected final String TEXT_15 = ") getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_16 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_17 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}" + NL;
  protected final String TEXT_18 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_19 = " doDefaultElementCreation() {" + NL + "\t\t\t";
  protected final String TEXT_20 = " newElement = (";
  protected final String TEXT_21 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {";
  protected final String TEXT_22 = NL + "\t\t\t\t ";
  protected final String TEXT_23 = " container = (";
  protected final String TEXT_24 = ") getElementToEdit();" + NL + "\t\t\t\t if (container != null) {";
  protected final String TEXT_25 = NL + "\t\t\t\t\t";
  protected final String TEXT_26 = " featureValues = container.";
  protected final String TEXT_27 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_28 = NL + "\t\t\t\t \t";
  protected final String TEXT_29 = "newElement);";
  protected final String TEXT_30 = NL + "\t\t\t\t }";
  protected final String TEXT_31 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_32 = ".Initializers.";
  protected final String TEXT_33 = ".init(newElement);";
  protected final String TEXT_34 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_35 = NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\t";
  protected final String TEXT_36 = " container = (";
  protected final String TEXT_37 = ") getElementToEdit();";
  protected final String TEXT_38 = NL + "\t\t\tif (";
  protected final String TEXT_39 = " != null) {";
  protected final String TEXT_40 = NL + "\t\t\tif (";
  protected final String TEXT_41 = ".size() >= ";
  protected final String TEXT_42 = ") {";
  protected final String TEXT_43 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_44 = NL + "\t\t\tif (";
  protected final String TEXT_45 = " != null) {";
  protected final String TEXT_46 = NL + "\t\t\tif (";
  protected final String TEXT_47 = ".size() >= ";
  protected final String TEXT_48 = ") {";
  protected final String TEXT_49 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_50 = NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_51 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (getEClass() != null) {" + NL + "\t\t\t\treturn getEClass().isSuperTypeOf(getEClassToEdit());" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_52 = " getContainmentFeature() {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_53 = " doDefaultElementCreation() {" + NL + "\t\t\t// Uncomment to put \"phantom\" objects into the diagram file.\t\t" + NL + "\t\t\t//";
  protected final String TEXT_54 = " resource = ((";
  protected final String TEXT_55 = ") getRequest()).getContainer().eResource();" + NL + "\t\t\t//if (resource == null) {" + NL + "\t\t\t//\treturn null;" + NL + "\t\t\t//}" + NL + "\t\t\t";
  protected final String TEXT_56 = " resource = getElementToEdit().eResource();" + NL + "\t\t\t";
  protected final String TEXT_57 = " eClass = getElementType().getEClass();" + NL + "\t\t\t";
  protected final String TEXT_58 = " eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);" + NL + "\t\t\tresource.getContents().add(eObject);" + NL + "\t\t\treturn eObject;" + NL + "\t\t}";
  protected final String TEXT_59 = NL + NL + "}";
  protected final String TEXT_60 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				if (feature.getTypeGenClass() != null) {
					result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
				} else {
					// EDataType
					result.append(importManager.getImportedName(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClassName()));
				}

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
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
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
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenNode node = (GenNode) ((Object[]) argument)[0];
GenDiagram genDiagram = node.getDiagram(); 

final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

TypeModelFacet modelFacet = (TypeModelFacet) node.getModelFacet();
if (modelFacet == null) {
	throw new IllegalArgumentException("TypeModelFacet required");
}

GenClass containerGenClass = modelFacet.getContainmentMetaFeature().getGenClass();
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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(containerGenClass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(containerGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    if (!modelFacet.isPhantomElement()) {
	boolean initChildMetafeature = !modelFacet.getChildMetaFeature().isDerived() && !modelFacet.getChildMetaFeature().equals(modelFacet.getContainmentMetaFeature());
	if (modelFacet.getModelElementInitializer() != null || initChildMetafeature) { 
		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_21);
    		if (initChildMetafeature) {
			String containerMetaClass = importManager.getImportedName(modelFacet.getChildMetaFeature().getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_24);
    			if (modelFacet.getChildMetaFeature().isListType()) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelFacet.getChildMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_27);
    			} else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getFeatureValueSetterPrefix("container", modelFacet.getChildMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_29);
    			}
    stringBuffer.append(TEXT_30);
    		}
		if (modelFacet.getModelElementInitializer() != null) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(node.getUniqueIdentifier());
    stringBuffer.append(TEXT_33);
    		}
    stringBuffer.append(TEXT_34);
    	}
	
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	GenFeature childMetaFeature = modelFacet.getChildMetaFeature();
	int upperContainmentBound = containmentMetaFeature.getEcoreFeature().getUpperBound();
	int upperChildBound = childMetaFeature.getEcoreFeature().getUpperBound();
	boolean checkChildMetafeature = !childMetaFeature.equals(containmentMetaFeature) && upperChildBound > 0;
	if (upperContainmentBound > 0 || checkChildMetafeature) {
		String containerInterfaceName = importManager.getImportedName(containerGenClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_37);
    		if (upperContainmentBound > 0) {
			if (upperContainmentBound == 1) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_39);
    			} else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_42);
    			}
    stringBuffer.append(TEXT_43);
    		}
		
		if (checkChildMetafeature) {
			if (upperChildBound == 1) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_45);
    			} else {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_48);
    			}
    stringBuffer.append(TEXT_49);
    		} 
    stringBuffer.append(TEXT_50);
    	}
} else {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EReference"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_60);
    return stringBuffer.toString();
  }
}