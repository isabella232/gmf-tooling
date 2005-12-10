package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class DiagramCanonicalEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized DiagramCanonicalEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramCanonicalEditPolicyGenerator result = new DiagramCanonicalEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.emf.ecore.EObject;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends CanonicalConnectionEditPolicy {";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_8 = " getSemanticChildrenList() {" + NL + "\t\t\t";
  protected final String TEXT_9 = " modelElement = (";
  protected final String TEXT_10 = ") ((View) getHost().getModel()).getElement();" + NL + "\t\t\tList result = new ";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "\t\t\t";
  protected final String TEXT_13 = " nextValue;" + NL + "\t\t\tint nodeVID;";
  protected final String TEXT_14 = "\t" + NL + "\t\t\tfor (";
  protected final String TEXT_15 = " it = ";
  protected final String TEXT_16 = ".iterator(); it.hasNext();) {" + NL + "\t\t\t\tnextValue = (";
  protected final String TEXT_17 = ") it.next();";
  protected final String TEXT_18 = NL + "\t\t\tnextValue = ";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL + "\t\t\tnodeVID = ";
  protected final String TEXT_21 = ".INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, \"\");" + NL + "\t\t\tif (";
  protected final String TEXT_22 = " == nodeVID) {" + NL + "\t\t\t\tresult.add(nextValue);" + NL + "\t\t\t}";
  protected final String TEXT_23 = NL + "\t\t\t}";
  protected final String TEXT_24 = "\t\t\t" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldDeleteView(View view) {" + NL + "\t\t\treturn view.getElement() != ((View) getHost().getModel()).getElement();" + NL + "\t\t}";
  protected final String TEXT_25 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getSemanticConnectionsList() {" + NL + "\t\tDiagram diagram = (Diagram) getHost().getModel();" + NL + "\t\t";
  protected final String TEXT_26 = " modelElement = (";
  protected final String TEXT_27 = ") diagram.getElement();" + NL + "\t\tList result = new LinkedList();" + NL + "\t\tfor (Iterator diagramElements = modelElement.eContents().iterator(); diagramElements.hasNext();) {" + NL + "\t\t\tEObject nextDiagramElement = (EObject) diagramElements.next();" + NL + "\t\t\tfor (Iterator childElements = nextDiagramElement.eContents().iterator(); childElements.hasNext();) {" + NL + "\t\t\t\tEObject nextChild = (EObject) childElements.next();" + NL + "\t\t\t\tif (";
  protected final String TEXT_28 = ".INSTANCE.getLinkWithClassVisualID(nextChild) != -1) {" + NL + "\t\t\t\t\tresult.add(nextChild);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSourceElement(EObject relationship) {" + NL + "\t\treturn relationship.eContainer();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getTargetElement(EObject relationship) {" + NL + "\t\tint vID = ";
  protected final String TEXT_29 = ".INSTANCE.getLinkWithClassVisualID(relationship);" + NL + "\t\tswitch (vID) {";
  protected final String TEXT_30 = NL + "\t\tcase ";
  protected final String TEXT_31 = ":" + NL + "\t\t\treturn ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * For now we are skipping links which was generated based on \"GenLinkReferenceOnly\" classes" + NL + "\t * since they do not handle any domain model objects inside, so we can not process them using" + NL + "\t * CanonicalConnectionEditPolicy class" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldIncludeConnection(Edge connector, List children) {" + NL + "\t\treturn super.shouldIncludeConnection(connector, children) && connector.getElement() != null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_34 = NL;

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
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportUtil importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getCanonicalEditPolicyClassName());
    stringBuffer.append(TEXT_5);
    
String modelElementInterfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());
{
	Collection genNodes = genDiagram.getNodes();

    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_11);
    
if (genNodes.size() > 0) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_13);
    
}

    
for (Iterator it = genNodes.iterator(); it.hasNext();) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(getFeatureValueGetter("modelElement", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_17);
    
	} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(getFeatureValueGetter("modelElement", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_19);
    
	}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_22);
    
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_23);
    
	}
}

    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
	GenLink nextGenLink = (GenLink) it.next();
	if (nextGenLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkFacet = (TypeLinkModelFacet) nextGenLink.getModelFacet(); 
		GenFeature nextLinkTargetFeature = typeLinkFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_30);
    stringBuffer.append(nextGenLink.getVisualID());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(getFeatureValueGetter("relationship", nextLinkTargetFeature, true, importManager));
    stringBuffer.append(nextLinkTargetFeature.isListType() ? ".get(0)" : "");
    stringBuffer.append(TEXT_32);
    
	}
}

    stringBuffer.append(TEXT_33);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}