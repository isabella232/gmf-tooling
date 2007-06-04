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

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = " req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL;
  protected final String TEXT_9 = NL + "\t\tfalse" + NL + "\t\t/* " + NL + "\t\tFIXME no containment feature found in the genmodel, toolsmith need to specify correct one here manually" + NL + "\t\tIf you rely on superclass behaviour, simply delete this comment" + NL + "\t\t*/" + NL + "}";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_12 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "();" + NL + "\t\t}";
  protected final String TEXT_15 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_16 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_17 = " container = ((";
  protected final String TEXT_18 = ") getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_19 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_20 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}" + NL;
  protected final String TEXT_21 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_22 = " doDefaultElementCreation() {" + NL + "\t\t\t";
  protected final String TEXT_23 = " newElement = (";
  protected final String TEXT_24 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {";
  protected final String TEXT_25 = NL + "\t\t\t\t ";
  protected final String TEXT_26 = " container = (";
  protected final String TEXT_27 = ") getElementToEdit();" + NL + "\t\t\t\t if (container != null) {";
  protected final String TEXT_28 = NL + "\t\t\t\t\t";
  protected final String TEXT_29 = " featureValues = container.";
  protected final String TEXT_30 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_31 = NL + "\t\t\t\t \t";
  protected final String TEXT_32 = "newElement);";
  protected final String TEXT_33 = NL + "\t\t\t\t }";
  protected final String TEXT_34 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_35 = ".Initializers.";
  protected final String TEXT_36 = ".init(newElement);";
  protected final String TEXT_37 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_38 = NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\t";
  protected final String TEXT_39 = " container = (";
  protected final String TEXT_40 = ") getElementToEdit();";
  protected final String TEXT_41 = NL + "\t\t\tif (";
  protected final String TEXT_42 = " != null) {";
  protected final String TEXT_43 = NL + "\t\t\tif (";
  protected final String TEXT_44 = ".size() >= ";
  protected final String TEXT_45 = ") {";
  protected final String TEXT_46 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_47 = NL + "\t\t\tif (";
  protected final String TEXT_48 = " != null) {";
  protected final String TEXT_49 = NL + "\t\t\tif (";
  protected final String TEXT_50 = ".size() >= ";
  protected final String TEXT_51 = ") {";
  protected final String TEXT_52 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_53 = NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_54 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (getEClass() != null) {" + NL + "\t\t\t\treturn getEClass().isSuperTypeOf(getEClassToEdit());" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_55 = " getContainmentFeature() {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_56 = " doDefaultElementCreation() {" + NL + "\t\t\t// Uncomment to put \"phantom\" objects into the diagram file.\t\t" + NL + "\t\t\t//";
  protected final String TEXT_57 = " resource = ((";
  protected final String TEXT_58 = ") getRequest()).getContainer().eResource();" + NL + "\t\t\t//if (resource == null) {" + NL + "\t\t\t//\treturn null;" + NL + "\t\t\t//}" + NL + "\t\t\t";
  protected final String TEXT_59 = " resource = getElementToEdit().eResource();" + NL + "\t\t\t";
  protected final String TEXT_60 = " eClass = getElementType().getEClass();" + NL + "\t\t\t";
  protected final String TEXT_61 = " eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);" + NL + "\t\t\tresource.getContents().add(eObject);" + NL + "\t\t\treturn eObject;" + NL + "\t\t}";
  protected final String TEXT_62 = NL + NL + "}";
  protected final String TEXT_63 = NL;

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

TypeModelFacet modelFacet = node.getModelFacet();
if (modelFacet == null) {
	throw new IllegalArgumentException("TypeModelFacet required");
}


    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_8);
    if (!modelFacet.isPhantomElement() && modelFacet.getContainmentMetaFeature() == null && modelFacet.getChildMetaFeature() == null) {
    stringBuffer.append(TEXT_9);
    
	importManager.emitSortedImports();
	return stringBuffer.toString(); // 	ATTENTION !!! CHANGE OF CONTROL FLOW - the template below is NOT processed when both features are null
	// I don't want to wrap rest of the template into huge else block, hence this hack, which I believe will fade away with xpand. 
} 
    stringBuffer.append(TEXT_10);
    if (!modelFacet.isPhantomElement()) {
	GenClass containerGenClass = modelFacet.getContainmentMetaFeature().getGenClass();
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(containerGenClass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(containerGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    if (!modelFacet.isPhantomElement()) {
	GenClass containerGenClass = modelFacet.getContainmentMetaFeature().getGenClass();
	boolean initChildMetafeature = !modelFacet.getChildMetaFeature().isDerived() && !modelFacet.getChildMetaFeature().equals(modelFacet.getContainmentMetaFeature());
	if (modelFacet.getModelElementInitializer() != null || initChildMetafeature) { 
		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_24);
    		if (initChildMetafeature) {
			String containerMetaClass = importManager.getImportedName(modelFacet.getChildMetaFeature().getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_27);
    			if (modelFacet.getChildMetaFeature().isListType()) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelFacet.getChildMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_30);
    			} else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(getFeatureValueSetterPrefix("container", modelFacet.getChildMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_32);
    			}
    stringBuffer.append(TEXT_33);
    		}
		if (modelFacet.getModelElementInitializer() != null) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(node.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    		}
    stringBuffer.append(TEXT_37);
    	}
	
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	GenFeature childMetaFeature = modelFacet.getChildMetaFeature();
	int upperContainmentBound = containmentMetaFeature.getEcoreFeature().getUpperBound();
	int upperChildBound = childMetaFeature.getEcoreFeature().getUpperBound();
	boolean checkChildMetafeature = !childMetaFeature.equals(containmentMetaFeature) && upperChildBound > 0;
	if (upperContainmentBound > 0 || checkChildMetafeature) {
		String containerInterfaceName = importManager.getImportedName(containerGenClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_40);
    		if (upperContainmentBound > 0) {
			if (upperContainmentBound == 1) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_42);
    			} else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_45);
    			}
    stringBuffer.append(TEXT_46);
    		}
		
		if (checkChildMetafeature) {
			if (upperChildBound == 1) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_48);
    			} else {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_51);
    			}
    stringBuffer.append(TEXT_52);
    		} 
    stringBuffer.append(TEXT_53);
    	}
} else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EReference"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}