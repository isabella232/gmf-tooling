package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class NodeItemSemanticEditPolicyGenerator {
 
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
  protected final String TEXT_14 = " == req.getElementType()) {";
  protected final String TEXT_15 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_16 = " container = (";
  protected final String TEXT_17 = ") req.getContainer();";
  protected final String TEXT_18 = NL + "\t\t\tif (";
  protected final String TEXT_19 = " != null) {";
  protected final String TEXT_20 = NL + "\t\t\tif (";
  protected final String TEXT_21 = ".size() >= ";
  protected final String TEXT_22 = ") {";
  protected final String TEXT_23 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_25 = ".eINSTANCE.get";
  protected final String TEXT_26 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_27 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_28 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_30 = "Command extends ";
  protected final String TEXT_31 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_32 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_33 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_34 = ".eINSTANCE.get";
  protected final String TEXT_35 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_36 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_37 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_38 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_39 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_40 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_41 = " doDefaultElementCreation() {";
  protected final String TEXT_42 = NL + "\t\t\t";
  protected final String TEXT_43 = " newElement = (";
  protected final String TEXT_44 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_45 = ".Initializers.";
  protected final String TEXT_46 = ".init(newElement);" + NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_47 = NL + "\t}";
  protected final String TEXT_48 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req));" + NL + "\t}";
  protected final String TEXT_49 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_50 = NL + "\t\tif (";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? getCreateStart";
  protected final String TEXT_53 = "Command(req) : getCreateComplete";
  protected final String TEXT_54 = "Command(req);" + NL + "\t\t}";
  protected final String TEXT_55 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_56 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_57 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = " element = (";
  protected final String TEXT_60 = ") getSemanticElement();";
  protected final String TEXT_61 = NL + "\t\tif (";
  protected final String TEXT_62 = " != null) {";
  protected final String TEXT_63 = NL + "\t\tif (";
  protected final String TEXT_64 = ".size() >= ";
  protected final String TEXT_65 = ") {";
  protected final String TEXT_66 = NL + "\t\t\treturn ";
  protected final String TEXT_67 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_68 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_69 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_70 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_71 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_72 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_73 = NL + "\t\t";
  protected final String TEXT_74 = " element = (";
  protected final String TEXT_75 = ") getSemanticElement();";
  protected final String TEXT_76 = NL + "\t\tif (";
  protected final String TEXT_77 = " != null) {";
  protected final String TEXT_78 = NL + "\t\tif (";
  protected final String TEXT_79 = ".size() >= ";
  protected final String TEXT_80 = ") {";
  protected final String TEXT_81 = NL + "\t\t\treturn ";
  protected final String TEXT_82 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_83 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_84 = ".eINSTANCE.get";
  protected final String TEXT_85 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_86 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_87 = "Command extends ";
  protected final String TEXT_88 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_89 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_90 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_91 = ".eINSTANCE.get";
  protected final String TEXT_92 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_93 = " getElementToEdit() {" + NL + "\t\t\treturn getTarget();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_94 = " doDefaultElementCreation() {";
  protected final String TEXT_95 = NL + "\t\t\t";
  protected final String TEXT_96 = " newElement = (";
  protected final String TEXT_97 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_98 = "(";
  protected final String TEXT_99 = ") getSource());";
  protected final String TEXT_100 = NL + "\t\t\t\t";
  protected final String TEXT_101 = ".Initializers.";
  protected final String TEXT_102 = ".init(newElement);";
  protected final String TEXT_103 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_104 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_105 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_106 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_107 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_108 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_109 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_110 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_111 = NL + "\t\t";
  protected final String TEXT_112 = " element = (";
  protected final String TEXT_113 = ") req.getSource();";
  protected final String TEXT_114 = NL + "\t\tif (";
  protected final String TEXT_115 = " != null) {";
  protected final String TEXT_116 = NL + "\t\tif (";
  protected final String TEXT_117 = ".size() >= ";
  protected final String TEXT_118 = ") {";
  protected final String TEXT_119 = NL + "\t\t\treturn ";
  protected final String TEXT_120 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_121 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_122 = ".eINSTANCE.get";
  protected final String TEXT_123 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_124 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_125 = "Command extends ";
  protected final String TEXT_126 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_127 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_128 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_129 = ".eINSTANCE.get";
  protected final String TEXT_130 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_131 = " getElementToEdit() {" + NL + "\t\t\treturn getSource();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_132 = " doDefaultElementCreation() {";
  protected final String TEXT_133 = NL + "\t\t\t";
  protected final String TEXT_134 = " newElement = (";
  protected final String TEXT_135 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_136 = "(";
  protected final String TEXT_137 = ") getTarget());";
  protected final String TEXT_138 = NL + "\t\t\t\t";
  protected final String TEXT_139 = ".Initializers.";
  protected final String TEXT_140 = ".init(newElement);";
  protected final String TEXT_141 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_142 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_143 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_144 = NL + "\t\t";
  protected final String TEXT_145 = " element = (";
  protected final String TEXT_146 = ") getSemanticElement();";
  protected final String TEXT_147 = NL + "\t\tif (";
  protected final String TEXT_148 = " != null) {";
  protected final String TEXT_149 = NL + "\t\tif (";
  protected final String TEXT_150 = ".size() >= ";
  protected final String TEXT_151 = ") {";
  protected final String TEXT_152 = NL + "\t\t\treturn ";
  protected final String TEXT_153 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_154 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_155 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_156 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_157 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_158 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_159 = NL + "\t\t";
  protected final String TEXT_160 = " element = (";
  protected final String TEXT_161 = ") getSemanticElement();";
  protected final String TEXT_162 = NL + "\t\tif (";
  protected final String TEXT_163 = " != null) {";
  protected final String TEXT_164 = NL + "\t\tif (";
  protected final String TEXT_165 = ".size() >= ";
  protected final String TEXT_166 = NL + "\t\t\t|| ";
  protected final String TEXT_167 = ".contains(req.getSource())";
  protected final String TEXT_168 = NL + "\t\t\t\t) {";
  protected final String TEXT_169 = NL + "\t\t\treturn ";
  protected final String TEXT_170 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_171 = NL + "\t\t";
  protected final String TEXT_172 = " setReq = new ";
  protected final String TEXT_173 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_174 = ".eINSTANCE.get";
  protected final String TEXT_175 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_176 = "(setReq));" + NL + "\t}";
  protected final String TEXT_177 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_178 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_179 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_180 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_181 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_182 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_183 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_184 = NL + "\t\t";
  protected final String TEXT_185 = " element = (";
  protected final String TEXT_186 = ") req.getSource();";
  protected final String TEXT_187 = NL + "\t\tif (";
  protected final String TEXT_188 = " != null) {";
  protected final String TEXT_189 = NL + "\t\tif (";
  protected final String TEXT_190 = ".size() >= ";
  protected final String TEXT_191 = NL + "\t\t\t|| ";
  protected final String TEXT_192 = ".contains(req.getTarget())";
  protected final String TEXT_193 = NL + "\t\t\t\t) {";
  protected final String TEXT_194 = NL + "\t\t\treturn ";
  protected final String TEXT_195 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_196 = NL + "\t\t";
  protected final String TEXT_197 = " setReq = new ";
  protected final String TEXT_198 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_199 = ".eINSTANCE.get";
  protected final String TEXT_200 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_201 = "(setReq));" + NL + "\t}";
  protected final String TEXT_202 = NL + "}";
  protected final String TEXT_203 = NL;

	private String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
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
	
	private String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
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
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	int upperBound = containmentMetaFeature.getEcoreFeature().getUpperBound();

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    
	if (upperBound > 0) {
		String containerInterfaceName = importManager.getImportedName(containerNode.getModelFacet().getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_17);
    
		if (upperBound == 1) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_19);
    
		} else {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_22);
    
		}

    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_27);
    
}

    stringBuffer.append(TEXT_28);
    
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(containerNode.getModelFacet().getMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_39);
    	if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_41);
    		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_46);
    	}
    stringBuffer.append(TEXT_47);
    }
    }
    stringBuffer.append(TEXT_48);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_49);
    
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

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_54);
    
	}
}

    stringBuffer.append(TEXT_55);
    
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

    stringBuffer.append(TEXT_56);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_57);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_58);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_60);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_62);
    				} else {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_65);
    				}
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_67);
    			}
     // create always executable command 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_69);
     // check that source is valid 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_72);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_73);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_75);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_77);
    				} else {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_80);
    				}
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_82);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_94);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_99);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();

    stringBuffer.append(TEXT_104);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_105);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_107);
     // check that source is valid 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_110);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_111);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_113);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_115);
    				} else {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_118);
    				}
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_120);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_132);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_137);
    			if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		int upperBound = metaFeature.getEcoreFeature().getUpperBound();
		GenClass outgoingClass = metaFeature.getGenClass();
		GenClass incomingClass = metaFeature.getTypeGenClass();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();

    stringBuffer.append(TEXT_142);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_143);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_144);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_146);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_148);
    				} else {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_151);
    				}
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_153);
    			}
     // create always executable command 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_155);
     // check that source is valid 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_158);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_159);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_161);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_163);
    				} else {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_167);
    					}
    stringBuffer.append(TEXT_168);
    				}
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_170);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_176);
    
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();

    stringBuffer.append(TEXT_177);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_178);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_179);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_180);
     // check that source is valid 
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_183);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_184);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_186);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_187);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_188);
    				} else {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_192);
    					}
    stringBuffer.append(TEXT_193);
    				}
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_195);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_201);
    
		}
	}
}

    stringBuffer.append(TEXT_202);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_203);
    return stringBuffer.toString();
  }
}