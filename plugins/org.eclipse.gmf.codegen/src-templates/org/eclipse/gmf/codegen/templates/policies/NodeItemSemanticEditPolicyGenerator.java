package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class NodeItemSemanticEditPolicyGenerator
{
  protected static String nl;
  public static synchronized NodeItemSemanticEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeItemSemanticEditPolicyGenerator result = new NodeItemSemanticEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLDestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req));" + NL + "\t}";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_8 = NL + "\t\tif (";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? getCreateStart";
  protected final String TEXT_11 = "Command(req) : getCreateComplete";
  protected final String TEXT_12 = "Command(req);" + NL + "\t\t}";
  protected final String TEXT_13 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_14 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_15 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_16 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_17 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_18 = ".INSTANCE;" + NL + "\t\t}" + NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_19 = ".eINSTANCE.get";
  protected final String TEXT_20 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_21 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_22 = "Command extends ";
  protected final String TEXT_23 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_24 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_25 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_26 = ".eINSTANCE.get";
  protected final String TEXT_27 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_28 = " getElementToEdit() {" + NL + "\t\t\treturn getTarget();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_29 = " doDefaultElementCreation() {";
  protected final String TEXT_30 = NL + "\t\t\t";
  protected final String TEXT_31 = " newElement = (";
  protected final String TEXT_32 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tnewElement.set";
  protected final String TEXT_33 = "((";
  protected final String TEXT_34 = ") getSource());";
  protected final String TEXT_35 = NL + "\t\t\t\t";
  protected final String TEXT_36 = ".Initializers.";
  protected final String TEXT_37 = ".init(newElement);";
  protected final String TEXT_38 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_40 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_41 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_42 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_43 = ".INSTANCE;" + NL + "\t\t}" + NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_44 = ".eINSTANCE.get";
  protected final String TEXT_45 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_46 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_47 = "Command extends ";
  protected final String TEXT_48 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_49 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_50 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_51 = ".eINSTANCE.get";
  protected final String TEXT_52 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_53 = " getElementToEdit() {" + NL + "\t\t\treturn getSource();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_54 = " doDefaultElementCreation() {";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = " newElement = (";
  protected final String TEXT_57 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tnewElement.set";
  protected final String TEXT_58 = "((";
  protected final String TEXT_59 = ") getTarget());";
  protected final String TEXT_60 = NL + "\t\t\t\t";
  protected final String TEXT_61 = ".Initializers.";
  protected final String TEXT_62 = ".init(newElement);";
  protected final String TEXT_63 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_64 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_65 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_66 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_67 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_68 = ".INSTANCE;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_69 = " setReq = new ";
  protected final String TEXT_70 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_71 = ".eINSTANCE.get";
  protected final String TEXT_72 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_73 = "(setReq));" + NL + "\t}";
  protected final String TEXT_74 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_75 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_76 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_77 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_78 = ".INSTANCE;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_79 = " setReq = new ";
  protected final String TEXT_80 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_81 = ".eINSTANCE.get";
  protected final String TEXT_82 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_83 = "(setReq));" + NL + "\t}";
  protected final String TEXT_84 = NL + "}";
  protected final String TEXT_85 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) argument;
GenDiagram genDiagram = genNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genNode.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_7);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	String namePart = null;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		if (nodeMetaClass.equals(modelFacet.getContainmentMetaFeature().getGenClass())) {
			namePart = OUTGOING_TOKEN + modelFacet.getMetaClass().getName();
		} else if (nodeMetaClass.equals(modelFacet.getTargetMetaFeature().getTypeGenClass())) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName();
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (nodeMetaClass.equals(metaFeature.getGenClass())) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName();
		} else if (nodeMetaClass.equals(metaFeature.getTypeGenClass())) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName();
		}
	}
	if (namePart != null) {
		namePart += genLink.getVisualID();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_12);
    
	}
}

    stringBuffer.append(TEXT_13);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	String namePart = null;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenClass outgoingClass = modelFacet.getContainmentMetaFeature().getGenClass();
		GenClass incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_29);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelFacet.getTargetMetaFeature().getAccessorName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_34);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();

    stringBuffer.append(TEXT_39);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_54);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(modelFacet.getTargetMetaFeature().getAccessorName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_59);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		GenClass outgoingClass = metaFeature.getGenClass();
		GenClass incomingClass = metaFeature.getTypeGenClass();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();

    stringBuffer.append(TEXT_64);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_73);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();

    stringBuffer.append(TEXT_74);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_83);
    
		}
	}
}

    stringBuffer.append(TEXT_84);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_85);
    return stringBuffer.toString();
  }
}
