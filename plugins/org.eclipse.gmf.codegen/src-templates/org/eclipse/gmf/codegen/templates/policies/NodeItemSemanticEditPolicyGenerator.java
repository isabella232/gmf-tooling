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
  protected final String TEXT_24 = NL + "\t\t\tif (";
  protected final String TEXT_25 = " != null) {";
  protected final String TEXT_26 = NL + "\t\t\tif (";
  protected final String TEXT_27 = ".size() >= ";
  protected final String TEXT_28 = ") {";
  protected final String TEXT_29 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_31 = ".eINSTANCE.get";
  protected final String TEXT_32 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_33 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_34 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_35 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_36 = "Command extends ";
  protected final String TEXT_37 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_38 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_39 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_40 = ".eINSTANCE.get";
  protected final String TEXT_41 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_42 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_43 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_44 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_45 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_46 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_47 = " doDefaultElementCreation() {" + NL + "\t\t\t";
  protected final String TEXT_48 = " newElement = (";
  protected final String TEXT_49 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {";
  protected final String TEXT_50 = NL + "\t\t\t\t ";
  protected final String TEXT_51 = " container = (";
  protected final String TEXT_52 = ") getElementToEdit();" + NL + "\t\t\t\t if (container != null) {";
  protected final String TEXT_53 = NL + "\t\t\t\t\t";
  protected final String TEXT_54 = " featureValues = container.";
  protected final String TEXT_55 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_56 = NL + "\t\t\t\t \t";
  protected final String TEXT_57 = "newElement);";
  protected final String TEXT_58 = NL + "\t\t\t\t }";
  protected final String TEXT_59 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_60 = ".Initializers.";
  protected final String TEXT_61 = ".init(newElement);";
  protected final String TEXT_62 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_63 = NL + "\t}";
  protected final String TEXT_64 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req));" + NL + "\t}";
  protected final String TEXT_65 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_66 = NL + "\t\tif (";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " == req.getElementType()) {";
  protected final String TEXT_69 = NL + "\t\t\treturn req.getTarget() == null ? getCreateStart";
  protected final String TEXT_70 = "Command(req) : getCreateComplete";
  protected final String TEXT_71 = "Command(req);";
  protected final String TEXT_72 = NL + "\t\t\treturn req.getTarget() == null ? getCreateStart";
  protected final String TEXT_73 = "Command(req) : null;";
  protected final String TEXT_74 = NL + "\t\t\treturn req.getTarget() == null ? null : getCreateComplete";
  protected final String TEXT_75 = "Command(req);";
  protected final String TEXT_76 = NL + "\t\t}";
  protected final String TEXT_77 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_79 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_80 = NL + "\t\t";
  protected final String TEXT_81 = " element = (";
  protected final String TEXT_82 = ") getSemanticElement();";
  protected final String TEXT_83 = NL + "\t\tif (";
  protected final String TEXT_84 = " != null) {";
  protected final String TEXT_85 = NL + "\t\tif (";
  protected final String TEXT_86 = ".size() >= ";
  protected final String TEXT_87 = ") {";
  protected final String TEXT_88 = NL + "\t\t\treturn ";
  protected final String TEXT_89 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_90 = NL + "\t\tif (";
  protected final String TEXT_91 = " != null) {";
  protected final String TEXT_92 = NL + "\t\tif (";
  protected final String TEXT_93 = ".size() >= ";
  protected final String TEXT_94 = ") {";
  protected final String TEXT_95 = NL + "\t\t\treturn ";
  protected final String TEXT_96 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_97 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_98 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_99 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_100 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_101 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_102 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_103 = NL + "\t\t";
  protected final String TEXT_104 = " element = (";
  protected final String TEXT_105 = ") getSemanticElement();";
  protected final String TEXT_106 = NL + "\t\tif (";
  protected final String TEXT_107 = " != null) {";
  protected final String TEXT_108 = NL + "\t\tif (";
  protected final String TEXT_109 = ".size() >= ";
  protected final String TEXT_110 = ") {";
  protected final String TEXT_111 = NL + "\t\t\treturn ";
  protected final String TEXT_112 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_113 = NL + "\t\tif (";
  protected final String TEXT_114 = " != null) {";
  protected final String TEXT_115 = NL + "\t\tif (";
  protected final String TEXT_116 = ".size() >= ";
  protected final String TEXT_117 = ") {";
  protected final String TEXT_118 = NL + "\t\t\treturn ";
  protected final String TEXT_119 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_120 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_121 = ".eINSTANCE.get";
  protected final String TEXT_122 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_123 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_124 = "Command extends ";
  protected final String TEXT_125 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_126 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_127 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_128 = ".eINSTANCE.get";
  protected final String TEXT_129 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_130 = " getElementToEdit() {" + NL + "\t\t\treturn getTarget();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_131 = " doDefaultElementCreation() {";
  protected final String TEXT_132 = NL + "\t\t\t";
  protected final String TEXT_133 = " newElement = (";
  protected final String TEXT_134 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_135 = "(";
  protected final String TEXT_136 = ") getSource());";
  protected final String TEXT_137 = NL + "\t\t\t\t";
  protected final String TEXT_138 = " container = (";
  protected final String TEXT_139 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_140 = NL + "\t\t\t\t\t";
  protected final String TEXT_141 = " featureValues = container.";
  protected final String TEXT_142 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_143 = NL + "\t\t\t\t \t";
  protected final String TEXT_144 = "newElement);";
  protected final String TEXT_145 = NL + "\t\t\t\t}";
  protected final String TEXT_146 = NL + "\t\t\t\t";
  protected final String TEXT_147 = ".Initializers.";
  protected final String TEXT_148 = ".init(newElement);";
  protected final String TEXT_149 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_150 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_151 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_152 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_153 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_154 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_155 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_156 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_157 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_158 = NL + "\t\t";
  protected final String TEXT_159 = " element = (";
  protected final String TEXT_160 = ") req.getSource();";
  protected final String TEXT_161 = NL + "\t\tif (";
  protected final String TEXT_162 = " != null) {";
  protected final String TEXT_163 = NL + "\t\tif (";
  protected final String TEXT_164 = ".size() >= ";
  protected final String TEXT_165 = ") {";
  protected final String TEXT_166 = NL + "\t\t\treturn ";
  protected final String TEXT_167 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_168 = NL + "\t\tif (";
  protected final String TEXT_169 = " != null) {";
  protected final String TEXT_170 = NL + "\t\tif (";
  protected final String TEXT_171 = ".size() >= ";
  protected final String TEXT_172 = ") {";
  protected final String TEXT_173 = NL + "\t\t\treturn ";
  protected final String TEXT_174 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_175 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_176 = ".eINSTANCE.get";
  protected final String TEXT_177 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_178 = "Command(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_179 = "Command extends ";
  protected final String TEXT_180 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_181 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_182 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_183 = ".eINSTANCE.get";
  protected final String TEXT_184 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_185 = " getElementToEdit() {" + NL + "\t\t\treturn getSource();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_186 = " doDefaultElementCreation() {";
  protected final String TEXT_187 = NL + "\t\t\t";
  protected final String TEXT_188 = " newElement = (";
  protected final String TEXT_189 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_190 = "(";
  protected final String TEXT_191 = ") getTarget());";
  protected final String TEXT_192 = NL + "\t\t\t\t";
  protected final String TEXT_193 = " container = (";
  protected final String TEXT_194 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_195 = NL + "\t\t\t\t\t";
  protected final String TEXT_196 = " featureValues = container.";
  protected final String TEXT_197 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_198 = NL + "\t\t\t\t \t";
  protected final String TEXT_199 = "newElement);";
  protected final String TEXT_200 = NL + "\t\t\t\t}";
  protected final String TEXT_201 = NL + "\t\t\t\t";
  protected final String TEXT_202 = ".Initializers.";
  protected final String TEXT_203 = ".init(newElement);";
  protected final String TEXT_204 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_205 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_206 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_207 = NL + "\t\t";
  protected final String TEXT_208 = " element = (";
  protected final String TEXT_209 = ") getSemanticElement();";
  protected final String TEXT_210 = NL + "\t\tif (";
  protected final String TEXT_211 = " != null) {";
  protected final String TEXT_212 = NL + "\t\tif (";
  protected final String TEXT_213 = ".size() >= ";
  protected final String TEXT_214 = ") {";
  protected final String TEXT_215 = NL + "\t\t\treturn ";
  protected final String TEXT_216 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_217 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_218 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_219 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_220 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_221 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_222 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_223 = NL + "\t\t";
  protected final String TEXT_224 = " element = (";
  protected final String TEXT_225 = ") getSemanticElement();";
  protected final String TEXT_226 = NL + "\t\tif (";
  protected final String TEXT_227 = " != null) {";
  protected final String TEXT_228 = NL + "\t\tif (";
  protected final String TEXT_229 = ".size() >= ";
  protected final String TEXT_230 = NL + "\t\t\t|| ";
  protected final String TEXT_231 = ".contains(req.getSource())";
  protected final String TEXT_232 = NL + "\t\t\t\t) {";
  protected final String TEXT_233 = NL + "\t\t\treturn ";
  protected final String TEXT_234 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_235 = NL + "\t\t";
  protected final String TEXT_236 = " element = (";
  protected final String TEXT_237 = ") getSemanticElement();" + NL + "\t\tif (";
  protected final String TEXT_238 = ".contains(req.getSource())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_239 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_240 = NL + "\t\t";
  protected final String TEXT_241 = " setReq = new ";
  protected final String TEXT_242 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_243 = ".eINSTANCE.get";
  protected final String TEXT_244 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_245 = "(setReq));" + NL + "\t}";
  protected final String TEXT_246 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_247 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_248 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_249 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_250 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_251 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_252 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_253 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_254 = NL + "\t\t";
  protected final String TEXT_255 = " element = (";
  protected final String TEXT_256 = ") req.getSource();";
  protected final String TEXT_257 = NL + "\t\tif (";
  protected final String TEXT_258 = " != null) {";
  protected final String TEXT_259 = NL + "\t\tif (";
  protected final String TEXT_260 = ".size() >= ";
  protected final String TEXT_261 = NL + "\t\t\t|| ";
  protected final String TEXT_262 = ".contains(req.getTarget())";
  protected final String TEXT_263 = NL + "\t\t\t\t) {";
  protected final String TEXT_264 = NL + "\t\t\treturn ";
  protected final String TEXT_265 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_266 = NL + "\t\t";
  protected final String TEXT_267 = " element = (";
  protected final String TEXT_268 = ") req.getSource();" + NL + "\t\tif (";
  protected final String TEXT_269 = ".contains(req.getTarget())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_270 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_271 = NL + "\t\t";
  protected final String TEXT_272 = " setReq = new ";
  protected final String TEXT_273 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_274 = ".eINSTANCE.get";
  protected final String TEXT_275 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_276 = "(setReq));" + NL + "\t}";
  protected final String TEXT_277 = NL + "}";
  protected final String TEXT_278 = NL;

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
	GenFeature childMetaFeature = modelFacet.getChildMetaFeature();
	int upperContainmentBound = containmentMetaFeature.getEcoreFeature().getUpperBound();
	int upperChildBound = childMetaFeature.getEcoreFeature().getUpperBound();
	boolean processChildMetafeature = !childMetaFeature.equals(containmentMetaFeature) && upperChildBound > 0;

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    
	if (upperContainmentBound > 0 || processChildMetafeature) {
		String containerInterfaceName = importManager.getImportedName(containerNode.getModelFacet().getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_17);
    
		if (upperContainmentBound > 0) {
			if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_19);
    
			} else {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_22);
    
			}

    stringBuffer.append(TEXT_23);
    
		}
		
		if (processChildMetafeature) {
			if (upperChildBound == 1) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_25);
    
			} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_28);
    
			}

    stringBuffer.append(TEXT_29);
    
		}
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_33);
    
}

    stringBuffer.append(TEXT_34);
    
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(containerNode.getModelFacet().getMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_45);
    
	boolean processChildMetafeature = !modelFacet.getChildMetaFeature().isDerived() && !modelFacet.getChildMetaFeature().equals(modelFacet.getContainmentMetaFeature());
	if (modelFacet.getModelElementInitializer() != null || processChildMetafeature) { 
		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_49);
    
		if (processChildMetafeature) {
			String containerMetaClass = importManager.getImportedName(modelFacet.getChildMetaFeature().getGenClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_50);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_52);
    
			if (modelFacet.getChildMetaFeature().isListType()) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(modelFacet.getChildMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_55);
    
			} else {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(getFeatureValueSetterPrefix("container", modelFacet.getChildMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_57);
    
			}

    stringBuffer.append(TEXT_58);
    
		}
		if (modelFacet.getModelElementInitializer() != null) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_61);
    
		}

    stringBuffer.append(TEXT_62);
    
	}

    stringBuffer.append(TEXT_63);
    }
    }
    stringBuffer.append(TEXT_64);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_65);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	if (!genLink.isOutgoingCreationAllowed() && !genLink.isIncomingCreationAllowed()) {
		continue;
	}
	String namePart = null;
	boolean outgoing = true;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		if (nodeMetaClass.equals(modelFacet.getContainmentMetaFeature().getGenClass())) {
			namePart = OUTGOING_TOKEN + modelFacet.getMetaClass().getName();
		} else if (nodeMetaClass.equals(modelFacet.getTargetMetaFeature().getTypeGenClass())) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName();
			outgoing = false;
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (nodeMetaClass.equals(metaFeature.getGenClass())) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName();
		} else if (nodeMetaClass.equals(metaFeature.getTypeGenClass())) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName();
			outgoing = false;
		}
	}
	if (namePart != null) {
		namePart += genLink.getVisualID();

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_68);
    		if (genLink.isOutgoingCreationAllowed() && genLink.isIncomingCreationAllowed()) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_71);
    
		} else {
			if (outgoing ? genLink.isOutgoingCreationAllowed() : genLink.isIncomingCreationAllowed()) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_73);
    			} else {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_75);
    			}
		}

    stringBuffer.append(TEXT_76);
    
	}
}

    stringBuffer.append(TEXT_77);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	String namePart = null;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
//
//
//
////////////////////////
// Type Link Commands //
////////////////////////
//
//
//
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenClass outgoingClass = modelFacet.getContainmentMetaFeature().getGenClass();
		GenClass incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		GenFeature childFeature = modelFacet.getContainmentMetaFeature();
		int upperContainmentBound = containmentFeature.getEcoreFeature().getUpperBound();
		int upperChildBound = childFeature.getEcoreFeature().getUpperBound();
		boolean processChildFeature = !childFeature.isDerived() && !childFeature.equals(containmentFeature);
		boolean checkChildFeatureUpperBound = !childFeature.equals(containmentFeature) && upperChildBound > 0;
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();
			if (genLink.isOutgoingCreationAllowed()) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_79);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_80);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_82);
    
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_84);
    					} else {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_87);
    					}
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_89);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_91);
    					} else {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_94);
    					}
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_96);
    
				}
			}

     // create always executable command 
    stringBuffer.append(TEXT_97);
    
			}
			if (genLink.isIncomingCreationAllowed()) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_99);
     // check that source is valid 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_102);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_103);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_105);
    
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_107);
    					} else {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_110);
    					}
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_112);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_114);
    					} else {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_117);
    					}
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_119);
    
				}
			}

     // create semantic command 
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_131);
    
			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
			String containerMetaClass = importManager.getImportedName(childFeature.getGenClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_132);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_136);
    			if (processChildFeature) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_139);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_142);
    				} else {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_144);
    				}
    stringBuffer.append(TEXT_145);
    
			}
			if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_148);
    			}
    stringBuffer.append(TEXT_149);
    
			}
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + modelFacet.getMetaClass().getName() + genLink.getVisualID();
			if (genLink.isIncomingCreationAllowed()) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_151);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_152);
    
			}
			if (genLink.isOutgoingCreationAllowed()) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_154);
     // check that source is valid 
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_157);
     // check that containment feature is not set / has capacity for the new element 
    
				if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
					String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_158);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_160);
    
					if (upperContainmentBound > 0) {
						if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_162);
    						} else {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_165);
    						}
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_167);
    
					}
					if (checkChildFeatureUpperBound) {
						if (upperChildBound == 1) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_169);
    						} else {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_172);
    						}
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_174);
    
					}
				}

     // create semantic command 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(outgoingClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_186);
    
			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
			String containerMetaClass = importManager.getImportedName(childFeature.getGenClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_187);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_191);
    			if (processChildFeature) {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_194);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_197);
    				} else {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_199);
    				}
    stringBuffer.append(TEXT_200);
    
			}
			if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_203);
    			}
    stringBuffer.append(TEXT_204);
    
			}
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
//
//
//
////////////////////////
// Feat Link Commands //
////////////////////////
//
//
//
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		int upperBound = metaFeature.getEcoreFeature().getUpperBound();
		GenClass outgoingClass = metaFeature.getGenClass();
		GenClass incomingClass = metaFeature.getTypeGenClass();
		if (nodeMetaClass.equals(outgoingClass)) {
			namePart = OUTGOING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();
			if (genLink.isOutgoingCreationAllowed()) {

    stringBuffer.append(TEXT_205);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_206);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_207);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_209);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_211);
    				} else {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_214);
    				}
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_216);
    			}
     // create always executable command 
    stringBuffer.append(TEXT_217);
    
			}
			if (genLink.isIncomingCreationAllowed()) {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_219);
     // check that source is valid 
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_222);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_223);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_225);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_227);
    				} else {
    stringBuffer.append(TEXT_228);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_230);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_231);
    					}
    stringBuffer.append(TEXT_232);
    				}
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_234);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_235);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_239);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_245);
    
			}
		} else if (nodeMetaClass.equals(incomingClass)) {
			namePart = INCOMING_TOKEN + metaFeature.getFeatureAccessorName() + genLink.getVisualID();
			if (genLink.isIncomingCreationAllowed()) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_247);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_248);
    
			}
			if (genLink.isOutgoingCreationAllowed()) {

    stringBuffer.append(TEXT_249);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_250);
     // check that source is valid 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_253);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_254);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_256);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_257);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_258);
    				} else {
    stringBuffer.append(TEXT_259);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_261);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_262);
    					}
    stringBuffer.append(TEXT_263);
    				}
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_265);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_266);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_270);
    			}
     // create semantic command 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_276);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_277);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_278);
    return stringBuffer.toString();
  }
}