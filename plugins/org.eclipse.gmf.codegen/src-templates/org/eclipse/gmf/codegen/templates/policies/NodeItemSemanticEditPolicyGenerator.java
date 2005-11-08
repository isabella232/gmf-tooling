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
  protected final String TEXT_3 = NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.commands.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLDestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import ";
  protected final String TEXT_4 = ".ElementTypes;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req));" + NL + "\t}";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_9 = NL + "\t\tif (ElementTypes.";
  protected final String TEXT_10 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? getCreateStart";
  protected final String TEXT_11 = "Command(req) : getCreateComplete";
  protected final String TEXT_12 = "Command(req);" + NL + "\t\t}";
  protected final String TEXT_13 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_14 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_15 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_16 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_17 = ")) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_18 = ".eINSTANCE.get";
  protected final String TEXT_19 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_20 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_21 = "Command extends MSLCreateRelationshipCommand {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_22 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EClass getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_23 = ".eINSTANCE.get";
  protected final String TEXT_24 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject getElementToEdit() {" + NL + "\t\t\treturn getTarget();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject doDefaultElementCreation() {";
  protected final String TEXT_25 = NL + "\t\t\t";
  protected final String TEXT_26 = " newElement = (";
  protected final String TEXT_27 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tnewElement.set";
  protected final String TEXT_28 = "((";
  protected final String TEXT_29 = ") getSource());";
  protected final String TEXT_30 = NL + "\t\t\t\tElementTypes.Initializers.";
  protected final String TEXT_31 = ".init(newElement);";
  protected final String TEXT_32 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_33 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_34 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_35 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_36 = ")) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_37 = ".eINSTANCE.get";
  protected final String TEXT_38 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_39 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_40 = "Command extends MSLCreateRelationshipCommand {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_41 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EClass getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_42 = ".eINSTANCE.get";
  protected final String TEXT_43 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject getElementToEdit() {" + NL + "\t\t\treturn getSource();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject doDefaultElementCreation() {";
  protected final String TEXT_44 = NL + "\t\t\t";
  protected final String TEXT_45 = " newElement = (";
  protected final String TEXT_46 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tnewElement.set";
  protected final String TEXT_47 = "((";
  protected final String TEXT_48 = ") getTarget());";
  protected final String TEXT_49 = NL + "\t\t\t\tElementTypes.Initializers.";
  protected final String TEXT_50 = ".init(newElement);";
  protected final String TEXT_51 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_52 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_53 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_54 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_55 = ")) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tSetRequest setReq = new SetRequest(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_56 = ".eINSTANCE.get";
  protected final String TEXT_57 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new SetValueCommand(setReq));" + NL + "\t}";
  protected final String TEXT_58 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_59 = "Command(CreateRelationshipRequest req) {" + NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_60 = "Command(CreateRelationshipRequest req) {" + NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_61 = ")) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tSetRequest setReq = new SetRequest(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_62 = ".eINSTANCE.get";
  protected final String TEXT_63 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new SetValueCommand(setReq));" + NL + "\t}";
  protected final String TEXT_64 = NL + "}";
  protected final String TEXT_65 = NL;

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
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_8);
    
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
			namePart = OUTGOING_TOKEN + modelFacet.getMetaClass().getName();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_24);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(incomingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_29);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_43);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(incomingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_48);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		GenClass outgoingClass = metaFeature.getGenClass();
		GenClass incomingClass = metaFeature.getTypeGenClass();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName();

    stringBuffer.append(TEXT_52);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_57);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName();

    stringBuffer.append(TEXT_58);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_63);
    
		}
	}
}

    stringBuffer.append(TEXT_64);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
