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
  protected final String TEXT_6 = " {";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_10 = " getCreateCommand(";
  protected final String TEXT_11 = " req) {";
  protected final String TEXT_12 = NL + "\t\tif (";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " == req.getElementType()) {" + NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_15 = ".eINSTANCE.get";
  protected final String TEXT_16 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_17 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_19 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_20 = "Command extends ";
  protected final String TEXT_21 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_22 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_23 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_24 = ".eINSTANCE.get";
  protected final String TEXT_25 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_26 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_27 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_28 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_29 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_30 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_31 = " doDefaultElementCreation() {";
  protected final String TEXT_32 = NL + "\t\t\t";
  protected final String TEXT_33 = " newElement = (";
  protected final String TEXT_34 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_35 = ".Initializers.";
  protected final String TEXT_36 = ".init(newElement);" + NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_37 = NL + "\t}";
  protected final String TEXT_38 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req));" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_40 = NL + "\t\tif (";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? getCreateStart";
  protected final String TEXT_43 = "Command(req) : getCreateComplete";
  protected final String TEXT_44 = "Command(req);" + NL + "\t\t}";
  protected final String TEXT_45 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_46 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_47 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = " element = (";
  protected final String TEXT_50 = ") getSemanticElement();";
  protected final String TEXT_51 = NL + "\t\tif (element.get";
  protected final String TEXT_52 = "() != null) {";
  protected final String TEXT_53 = NL + "\t\tif (element.get";
  protected final String TEXT_54 = "().size() >= ";
  protected final String TEXT_55 = ") {";
  protected final String TEXT_56 = NL + "\t\t\treturn ";
  protected final String TEXT_57 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_58 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_59 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_60 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_61 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_62 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = " element = (";
  protected final String TEXT_65 = ") getSemanticElement();";
  protected final String TEXT_66 = NL + "\t\tif (element.get";
  protected final String TEXT_67 = "() != null) {";
  protected final String TEXT_68 = NL + "\t\tif (element.get";
  protected final String TEXT_69 = "().size() >= ";
  protected final String TEXT_70 = ") {";
  protected final String TEXT_71 = NL + "\t\t\treturn ";
  protected final String TEXT_72 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_73 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_74 = ".eINSTANCE.get";
  protected final String TEXT_75 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_76 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_77 = "Command extends ";
  protected final String TEXT_78 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_79 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_80 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_81 = ".eINSTANCE.get";
  protected final String TEXT_82 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_83 = " getElementToEdit() {" + NL + "\t\t\treturn getTarget();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_84 = " doDefaultElementCreation() {";
  protected final String TEXT_85 = NL + "\t\t\t";
  protected final String TEXT_86 = " newElement = (";
  protected final String TEXT_87 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tnewElement.set";
  protected final String TEXT_88 = "((";
  protected final String TEXT_89 = ") getSource());";
  protected final String TEXT_90 = NL + "\t\t\t\t";
  protected final String TEXT_91 = ".Initializers.";
  protected final String TEXT_92 = ".init(newElement);";
  protected final String TEXT_93 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_94 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_95 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_96 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_97 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_98 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_99 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_100 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_101 = NL + "\t\t";
  protected final String TEXT_102 = " element = (";
  protected final String TEXT_103 = ") req.getSource();";
  protected final String TEXT_104 = NL + "\t\tif (element.get";
  protected final String TEXT_105 = "() != null) {";
  protected final String TEXT_106 = NL + "\t\tif (element.get";
  protected final String TEXT_107 = "().size() >= ";
  protected final String TEXT_108 = ") {";
  protected final String TEXT_109 = NL + "\t\t\treturn ";
  protected final String TEXT_110 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_111 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_112 = ".eINSTANCE.get";
  protected final String TEXT_113 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_114 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_115 = "Command extends ";
  protected final String TEXT_116 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_117 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_118 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_119 = ".eINSTANCE.get";
  protected final String TEXT_120 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_121 = " getElementToEdit() {" + NL + "\t\t\treturn getSource();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_122 = " doDefaultElementCreation() {";
  protected final String TEXT_123 = NL + "\t\t\t";
  protected final String TEXT_124 = " newElement = (";
  protected final String TEXT_125 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tnewElement.set";
  protected final String TEXT_126 = "((";
  protected final String TEXT_127 = ") getTarget());";
  protected final String TEXT_128 = NL + "\t\t\t\t";
  protected final String TEXT_129 = ".Initializers.";
  protected final String TEXT_130 = ".init(newElement);";
  protected final String TEXT_131 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_132 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_133 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_134 = NL + "\t\t";
  protected final String TEXT_135 = " element = (";
  protected final String TEXT_136 = ") getSemanticElement();";
  protected final String TEXT_137 = NL + "\t\tif (element.get";
  protected final String TEXT_138 = "() != null) {";
  protected final String TEXT_139 = NL + "\t\tif (element.get";
  protected final String TEXT_140 = "().size() >= ";
  protected final String TEXT_141 = ") {";
  protected final String TEXT_142 = NL + "\t\t\treturn ";
  protected final String TEXT_143 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_144 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_145 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_146 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_147 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_148 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_149 = NL + "\t\t";
  protected final String TEXT_150 = " element = (";
  protected final String TEXT_151 = ") getSemanticElement();";
  protected final String TEXT_152 = NL + "\t\tif (element.get";
  protected final String TEXT_153 = "() != null) {";
  protected final String TEXT_154 = NL + "\t\tif (element.get";
  protected final String TEXT_155 = "().size() >= ";
  protected final String TEXT_156 = NL + "\t\t\t|| element.get";
  protected final String TEXT_157 = "().contains(req.getSource())";
  protected final String TEXT_158 = NL + "\t\t\t\t) {";
  protected final String TEXT_159 = NL + "\t\t\treturn ";
  protected final String TEXT_160 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_161 = NL + "\t\t";
  protected final String TEXT_162 = " setReq = new ";
  protected final String TEXT_163 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_164 = ".eINSTANCE.get";
  protected final String TEXT_165 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_166 = "(setReq));" + NL + "\t}";
  protected final String TEXT_167 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_168 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_169 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_170 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_171 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_172 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_173 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_174 = NL + "\t\t";
  protected final String TEXT_175 = " element = (";
  protected final String TEXT_176 = ") req.getSource();";
  protected final String TEXT_177 = NL + "\t\tif (element.get";
  protected final String TEXT_178 = "() != null) {";
  protected final String TEXT_179 = NL + "\t\tif (element.get";
  protected final String TEXT_180 = "().size() >= ";
  protected final String TEXT_181 = NL + "\t\t\t|| element.get";
  protected final String TEXT_182 = "().contains(req.getTarget())";
  protected final String TEXT_183 = NL + "\t\t\t\t) {";
  protected final String TEXT_184 = NL + "\t\t\treturn ";
  protected final String TEXT_185 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_186 = NL + "\t\t";
  protected final String TEXT_187 = " setReq = new ";
  protected final String TEXT_188 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_189 = ".eINSTANCE.get";
  protected final String TEXT_190 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_191 = "(setReq));" + NL + "\t}";
  protected final String TEXT_192 = NL + "}";
  protected final String TEXT_193 = NL;

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
    
if (genNode.getChildNodes().size() > 0) {
	GenChildContainer childContainer = genNode;
	GenNode containerNode = genNode;

    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_11);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(containerNode.getModelFacet().getMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_29);
    	if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_31);
    		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    	}
    stringBuffer.append(TEXT_37);
    }
    }
    stringBuffer.append(TEXT_38);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_39);
    
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

    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_44);
    
	}
}

    stringBuffer.append(TEXT_45);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	String namePart = null;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenClass outgoingClass = modelFacet.getContainmentMetaFeature().getGenClass();
		GenClass incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		int upperBound = containmentFeature.getEcoreFeature().getUpperBound();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();

    stringBuffer.append(TEXT_46);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_47);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_48);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_50);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(containmentFeature.getAccessorName());
    stringBuffer.append(TEXT_52);
    				} else {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(containmentFeature.getAccessorName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_55);
    				}
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_57);
    			}
     // create always executable command 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_59);
     // check that source is valid 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_62);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_63);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_65);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(containmentFeature.getAccessorName());
    stringBuffer.append(TEXT_67);
    				} else {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(containmentFeature.getAccessorName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_70);
    				}
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_72);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_84);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(modelFacet.getTargetMetaFeature().getAccessorName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_89);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();

    stringBuffer.append(TEXT_94);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_95);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_97);
     // check that source is valid 
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_100);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_101);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_103);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(containmentFeature.getAccessorName());
    stringBuffer.append(TEXT_105);
    				} else {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(containmentFeature.getAccessorName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_108);
    				}
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_110);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_122);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(modelFacet.getTargetMetaFeature().getAccessorName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_127);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		int upperBound = metaFeature.getEcoreFeature().getUpperBound();
		GenClass outgoingClass = metaFeature.getGenClass();
		GenClass incomingClass = metaFeature.getTypeGenClass();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();

    stringBuffer.append(TEXT_132);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_133);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_134);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_136);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_138);
    				} else {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_141);
    				}
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_143);
    			}
     // create always executable command 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_145);
     // check that source is valid 
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_148);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_149);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_151);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_153);
    				} else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_157);
    					}
    stringBuffer.append(TEXT_158);
    				}
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_160);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_166);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();

    stringBuffer.append(TEXT_167);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_168);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_170);
     // check that source is valid 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_173);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_174);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_176);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_177);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_178);
    				} else {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(metaFeature.getAccessorName());
    stringBuffer.append(TEXT_182);
    					}
    stringBuffer.append(TEXT_183);
    				}
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_185);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_191);
    
		}
	}
}

    stringBuffer.append(TEXT_192);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_193);
    return stringBuffer.toString();
  }
}
