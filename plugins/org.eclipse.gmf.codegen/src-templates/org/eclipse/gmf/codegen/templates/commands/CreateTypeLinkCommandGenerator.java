package org.eclipse.gmf.codegen.templates.commands;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class CreateTypeLinkCommandGenerator {
 
  protected static String nl;
  public static synchronized CreateTypeLinkCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateTypeLinkCommandGenerator result = new CreateTypeLinkCommandGenerator();
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
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_9 = " myContainer;";
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_11 = " mySource;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_12 = " myTarget;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = " req, ";
  protected final String TEXT_15 = " container, ";
  protected final String TEXT_16 = " source, ";
  protected final String TEXT_17 = " target) {" + NL + "\t\tsuper(req);";
  protected final String TEXT_18 = NL + "\t\tsuper.setElementToEdit(";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = ") ";
  protected final String TEXT_21 = "container);" + NL + "\t\tmyContainer = container;";
  protected final String TEXT_22 = NL + "\t\tsuper.setElementToEdit(";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ") ";
  protected final String TEXT_25 = "source);";
  protected final String TEXT_26 = NL + "\t\tmySource = source;" + NL + "\t\tmyTarget = target;" + NL + "\t}";
  protected final String TEXT_27 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_28 = " getContainer() {" + NL + "\t\treturn myContainer;" + NL + "\t}";
  protected final String TEXT_29 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_30 = " getSource() {" + NL + "\t\treturn ";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ") ";
  protected final String TEXT_33 = "mySource;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_34 = " getTarget() {" + NL + "\t\treturn ";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = ") ";
  protected final String TEXT_37 = "myTarget;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_38 = " getEClassToEdit() {" + NL + "\t\treturn ";
  protected final String TEXT_39 = ".eINSTANCE.get";
  protected final String TEXT_40 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setElementToEdit(";
  protected final String TEXT_41 = " element) {" + NL + "\t\tthrow new UnsupportedOperationException();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_42 = " doDefaultElementCreation() {" + NL + "\t\t";
  protected final String TEXT_43 = " newElement = (";
  protected final String TEXT_44 = ") super.doDefaultElementCreation();" + NL + "\t\tif (newElement != null) {" + NL + "\t\t\t";
  protected final String TEXT_45 = "myTarget);";
  protected final String TEXT_46 = NL + "\t\t\t";
  protected final String TEXT_47 = "mySource);";
  protected final String TEXT_48 = NL + "\t\t\t\t";
  protected final String TEXT_49 = " featureValues = ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = "();" + NL + "\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_52 = NL + "\t\t\t \t";
  protected final String TEXT_53 = "newElement);";
  protected final String TEXT_54 = NL + "\t\t\t";
  protected final String TEXT_55 = ".Initializers.";
  protected final String TEXT_56 = ".init(";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = ") ";
  protected final String TEXT_59 = "newElement);";
  protected final String TEXT_60 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_61 = "(";
  protected final String TEXT_62 = ") ";
  protected final String TEXT_63 = "newElement;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_64 = NL;

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
    GenLink link = (GenLink) ((Object[]) argument)[0];
GenDiagram genDiagram = link.getDiagram(); 

final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
if (false == link.getModelFacet() instanceof TypeLinkModelFacet) {
	throw new IllegalArgumentException("TypeLinkModelFacet required");
} 
TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) link.getModelFacet();

GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
GenFeature childFeature = modelFacet.getChildMetaFeature();
GenFeature targetFeature = modelFacet.getTargetMetaFeature();
GenFeature sourceFeature = modelFacet.getSourceMetaFeature();

GenClass outgoingClass = sourceFeature == null ? containmentFeature.getGenClass() : sourceFeature.getTypeGenClass();
GenClass incomingClass = targetFeature.getTypeGenClass();
GenClass containerClass = containmentFeature.getGenClass();

boolean processChildFeature = !childFeature.isDerived() && !childFeature.equals(containmentFeature);
boolean separateContainer = modelFacet.getSourceMetaFeature() != null;
String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand"));
    stringBuffer.append(TEXT_7);
    if (separateContainer) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(containerClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest"));
    stringBuffer.append(TEXT_14);
    if (separateContainer) {
    stringBuffer.append(importManager.getImportedName(containerClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_17);
    if (separateContainer) {
    stringBuffer.append(TEXT_18);
    if (containerClass.isExternalInterface()) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_22);
    if (outgoingClass.isExternalInterface()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    if (separateContainer) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(containerClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_30);
    if (outgoingClass.isExternalInterface()) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_34);
    if (incomingClass.isExternalInterface()) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(containerClass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(containerClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", targetFeature, false, importManager));
    stringBuffer.append(TEXT_45);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", sourceFeature, false, importManager));
    stringBuffer.append(TEXT_47);
    }

if (processChildFeature) {
	String containerVarName = separateContainer ? "myContainer" : "mySource";
	if (childFeature.isListType()) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(containerVarName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_51);
    	} else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(getFeatureValueSetterPrefix(containerVarName, childFeature, false, importManager));
    stringBuffer.append(TEXT_53);
    	}
}

if (modelFacet.getModelElementInitializer() != null) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_56);
    if (modelFacet.getMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    if (modelFacet.getMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}