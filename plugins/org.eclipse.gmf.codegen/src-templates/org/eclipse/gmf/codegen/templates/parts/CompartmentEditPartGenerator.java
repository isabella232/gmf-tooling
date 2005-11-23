package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class CompartmentEditPartGenerator {
 
  protected static String nl;
  public static synchronized CompartmentEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CompartmentEditPartGenerator result = new CompartmentEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean hasModelChildrenChanged(Notification evt) {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_8 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getTitleName() {" + NL + "\t\treturn \"";
  protected final String TEXT_9 = "\";" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_10 = "());";
  protected final String TEXT_11 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_12 = "CanonicalEditPolicy());";
  protected final String TEXT_13 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new ";
  protected final String TEXT_14 = "());";
  protected final String TEXT_15 = NL + "\t}" + NL + "\t";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ";
  protected final String TEXT_18 = "CanonicalEditPolicy extends ";
  protected final String TEXT_19 = " {" + NL + "\t";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_22 = " getSemanticChildrenList() {\t" + NL + "\t\t\t";
  protected final String TEXT_23 = " modelElement = (";
  protected final String TEXT_24 = ") ((View) getHost().getModel()).getElement();" + NL + "\t\t\tList result = new ";
  protected final String TEXT_25 = "();" + NL + "\t\t\t";
  protected final String TEXT_26 = " nextValue;";
  protected final String TEXT_27 = "\t" + NL + "\t\t\tfor (";
  protected final String TEXT_28 = " it = ";
  protected final String TEXT_29 = ".iterator(); it.hasNext();) {" + NL + "\t\t\t\tnextValue = (";
  protected final String TEXT_30 = ") it.next();";
  protected final String TEXT_31 = NL + "\t\t\tnextValue = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\t\t\tint nodeVID = ";
  protected final String TEXT_34 = ".INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, \"\");" + NL + "\t\t\tif (";
  protected final String TEXT_35 = " == nodeVID) {" + NL + "\t\t\t\tresult.add(nextValue);" + NL + "\t\t\t}";
  protected final String TEXT_36 = NL + "\t\t\t}";
  protected final String TEXT_37 = "\t\t\t" + NL + "\t\t\treturn result;" + NL + "\t\t}";
  protected final String TEXT_38 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getFactoryHint(";
  protected final String TEXT_39 = " elementAdapter) {" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL + "" + NL + "\t}";
  protected final String TEXT_40 = NL + "}";
  protected final String TEXT_41 = NL;

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
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
importManager.markImportLocation(stringBuffer);
importManager.addImport("org.eclipse.emf.common.notify.Notification");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");

boolean isListLayout = genCompartment.getLayoutKind() == CompartmentLayoutKind.TOOLBAR_LITERAL;

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(isListLayout ? importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart") : importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    
if (isListLayout) {

    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(genCompartment.getTitle());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genCompartment.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    
if (genCompartment.getChildNodes().size() > 0) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_12);
    
}
if (isListLayout) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy"));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
if (genCompartment.getChildNodes().size() > 0) {
	GenChildContainer childContainer = genCompartment;
	GenNode containerNode = genCompartment.getNode();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(childContainer.getEditPartClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy"));
    stringBuffer.append(TEXT_19);
    
{
	String modelElementInterfaceName = importManager.getImportedName(containerNode.getModelFacet().getMetaClass().getQualifiedInterfaceName());
	Collection genNodes = childContainer.getChildNodes();

    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_26);
    
for (Iterator it = genNodes.iterator(); it.hasNext();) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(getFeatureValueGetter("modelElement", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_30);
    
	} else {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(getFeatureValueGetter("modelElement", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_35);
    
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_36);
    
	}
}

    stringBuffer.append(TEXT_37);
    
}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_39);
    
}

    stringBuffer.append(TEXT_40);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}