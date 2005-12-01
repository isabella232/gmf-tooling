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
  protected final String TEXT_68 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? ";
  protected final String TEXT_69 = " : ";
  protected final String TEXT_70 = ";" + NL + "\t\t}";
  protected final String TEXT_71 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_72 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_73 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = " element = (";
  protected final String TEXT_76 = ") getSemanticElement();";
  protected final String TEXT_77 = NL + "\t\t";
  protected final String TEXT_78 = " element = (";
  protected final String TEXT_79 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_80 = ".eINSTANCE.get";
  protected final String TEXT_81 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_82 = ".INSTANCE;" + NL + "\t\t}";
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
  protected final String TEXT_97 = NL + "\t\tif(!";
  protected final String TEXT_98 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_99 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_100 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_101 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_102 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_103 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_104 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_105 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_106 = NL + "\t\tfinal ";
  protected final String TEXT_107 = " element = (";
  protected final String TEXT_108 = ") getSemanticElement();";
  protected final String TEXT_109 = NL + "\t\tfinal ";
  protected final String TEXT_110 = " element = (";
  protected final String TEXT_111 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_112 = ".eINSTANCE.get";
  protected final String TEXT_113 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_114 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_115 = NL + "\t\tif (";
  protected final String TEXT_116 = " != null) {";
  protected final String TEXT_117 = NL + "\t\tif (";
  protected final String TEXT_118 = ".size() >= ";
  protected final String TEXT_119 = ") {";
  protected final String TEXT_120 = NL + "\t\t\treturn ";
  protected final String TEXT_121 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_122 = NL + "\t\tif (";
  protected final String TEXT_123 = " != null) {";
  protected final String TEXT_124 = NL + "\t\tif (";
  protected final String TEXT_125 = ".size() >= ";
  protected final String TEXT_126 = ") {";
  protected final String TEXT_127 = NL + "\t\t\treturn ";
  protected final String TEXT_128 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_129 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_130 = ".eINSTANCE.get";
  protected final String TEXT_131 = "());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\tif(!";
  protected final String TEXT_133 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_134 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_135 = "\t\t\t\t" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_136 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_137 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_138 = "Command extends ";
  protected final String TEXT_139 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_140 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_141 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_142 = ".eINSTANCE.get";
  protected final String TEXT_143 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_144 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_145 = " doDefaultElementCreation() {";
  protected final String TEXT_146 = NL + "\t\t\t";
  protected final String TEXT_147 = " newElement = (";
  protected final String TEXT_148 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_149 = "(";
  protected final String TEXT_150 = ") getSource());";
  protected final String TEXT_151 = NL + "\t\t\t\t";
  protected final String TEXT_152 = "(";
  protected final String TEXT_153 = ") getTarget());";
  protected final String TEXT_154 = NL + "\t\t\t\t";
  protected final String TEXT_155 = " container = (";
  protected final String TEXT_156 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_157 = NL + "\t\t\t\t\t";
  protected final String TEXT_158 = " featureValues = container.";
  protected final String TEXT_159 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_160 = NL + "\t\t\t\t \t";
  protected final String TEXT_161 = "newElement);";
  protected final String TEXT_162 = NL + "\t\t\t\t}";
  protected final String TEXT_163 = NL + "\t\t\t\t";
  protected final String TEXT_164 = ".Initializers.";
  protected final String TEXT_165 = ".init(newElement);";
  protected final String TEXT_166 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_167 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_168 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_169 = NL + "\t\tif(!";
  protected final String TEXT_170 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_171 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_172 = "\t";
  protected final String TEXT_173 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_174 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_175 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_176 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_177 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_178 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_179 = NL + "\t\tfinal ";
  protected final String TEXT_180 = " element = (";
  protected final String TEXT_181 = ") req.getSource();";
  protected final String TEXT_182 = NL + "\t\tfinal ";
  protected final String TEXT_183 = " element = (";
  protected final String TEXT_184 = ") getRelationshipContainer(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_185 = ".eINSTANCE.get";
  protected final String TEXT_186 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_187 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_188 = NL + "\t\tif (";
  protected final String TEXT_189 = " != null) {";
  protected final String TEXT_190 = NL + "\t\tif (";
  protected final String TEXT_191 = ".size() >= ";
  protected final String TEXT_192 = ") {";
  protected final String TEXT_193 = NL + "\t\t\treturn ";
  protected final String TEXT_194 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_195 = NL + "\t\tif (";
  protected final String TEXT_196 = " != null) {";
  protected final String TEXT_197 = NL + "\t\tif (";
  protected final String TEXT_198 = ".size() >= ";
  protected final String TEXT_199 = ") {";
  protected final String TEXT_200 = NL + "\t\t\treturn ";
  protected final String TEXT_201 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_202 = NL + "\t\tif(!";
  protected final String TEXT_203 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_204 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_205 = "\t\t";
  protected final String TEXT_206 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_207 = ".eINSTANCE.get";
  protected final String TEXT_208 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_209 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_210 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_211 = "Command extends ";
  protected final String TEXT_212 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_213 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_214 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_215 = ".eINSTANCE.get";
  protected final String TEXT_216 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_217 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_218 = " doDefaultElementCreation() {";
  protected final String TEXT_219 = NL + "\t\t\t";
  protected final String TEXT_220 = " newElement = (";
  protected final String TEXT_221 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_222 = "(";
  protected final String TEXT_223 = ") getTarget());";
  protected final String TEXT_224 = NL + "\t\t\t\t";
  protected final String TEXT_225 = "(";
  protected final String TEXT_226 = ") getSource());";
  protected final String TEXT_227 = NL + "\t\t\t\t";
  protected final String TEXT_228 = " container = (";
  protected final String TEXT_229 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_230 = NL + "\t\t\t\t\t";
  protected final String TEXT_231 = " featureValues = container.";
  protected final String TEXT_232 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_233 = NL + "\t\t\t\t \t";
  protected final String TEXT_234 = "newElement);";
  protected final String TEXT_235 = NL + "\t\t\t\t}";
  protected final String TEXT_236 = NL + "\t\t\t\t";
  protected final String TEXT_237 = ".Initializers.";
  protected final String TEXT_238 = ".init(newElement);";
  protected final String TEXT_239 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_240 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_241 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_242 = NL + "\t\t";
  protected final String TEXT_243 = " element = (";
  protected final String TEXT_244 = ") getSemanticElement();";
  protected final String TEXT_245 = NL + "\t\tif (";
  protected final String TEXT_246 = " != null) {";
  protected final String TEXT_247 = NL + "\t\tif (";
  protected final String TEXT_248 = ".size() >= ";
  protected final String TEXT_249 = ") {";
  protected final String TEXT_250 = NL + "\t\t\treturn ";
  protected final String TEXT_251 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_252 = NL + "\t\tif(!";
  protected final String TEXT_253 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_254 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_255 = NL;
  protected final String TEXT_256 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_257 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_258 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_259 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_260 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_261 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_262 = NL + "\t\t";
  protected final String TEXT_263 = " element = (";
  protected final String TEXT_264 = ") getSemanticElement();";
  protected final String TEXT_265 = NL + "\t\tif (";
  protected final String TEXT_266 = " != null) {";
  protected final String TEXT_267 = NL + "\t\tif (";
  protected final String TEXT_268 = ".size() >= ";
  protected final String TEXT_269 = NL + "\t\t\t|| ";
  protected final String TEXT_270 = ".contains(req.getSource())";
  protected final String TEXT_271 = NL + "\t\t\t\t) {";
  protected final String TEXT_272 = NL + "\t\t\treturn ";
  protected final String TEXT_273 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_274 = NL + "\t\t";
  protected final String TEXT_275 = " element = (";
  protected final String TEXT_276 = ") getSemanticElement();" + NL + "\t\tif (";
  protected final String TEXT_277 = ".contains(req.getSource())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_278 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_279 = NL + "\t\tif(!";
  protected final String TEXT_280 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_281 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_282 = "\t\t";
  protected final String TEXT_283 = NL + "\t\t";
  protected final String TEXT_284 = " setReq = new ";
  protected final String TEXT_285 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_286 = ".eINSTANCE.get";
  protected final String TEXT_287 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_288 = "(setReq));" + NL + "\t}";
  protected final String TEXT_289 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_290 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_291 = NL + "\t\tif(!";
  protected final String TEXT_292 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_293 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_294 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_295 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_296 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_297 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_298 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_299 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_300 = NL + "\t\t";
  protected final String TEXT_301 = " element = (";
  protected final String TEXT_302 = ") req.getSource();";
  protected final String TEXT_303 = NL + "\t\tif (";
  protected final String TEXT_304 = " != null) {";
  protected final String TEXT_305 = NL + "\t\tif (";
  protected final String TEXT_306 = ".size() >= ";
  protected final String TEXT_307 = NL + "\t\t\t|| ";
  protected final String TEXT_308 = ".contains(req.getTarget())";
  protected final String TEXT_309 = NL + "\t\t\t\t) {";
  protected final String TEXT_310 = NL + "\t\t\treturn ";
  protected final String TEXT_311 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_312 = NL + "\t\t";
  protected final String TEXT_313 = " element = (";
  protected final String TEXT_314 = ") req.getSource();" + NL + "\t\tif (";
  protected final String TEXT_315 = ".contains(req.getTarget())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_316 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_317 = NL + "\t\tif(!";
  protected final String TEXT_318 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_319 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_320 = NL + "\t\t";
  protected final String TEXT_321 = " setReq = new ";
  protected final String TEXT_322 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_323 = ".eINSTANCE.get";
  protected final String TEXT_324 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_325 = "(setReq));" + NL + "\t}";
  protected final String TEXT_326 = NL + "}";
  protected final String TEXT_327 = NL;

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
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_33);
    
}

    stringBuffer.append(TEXT_34);
    
for (Iterator nodes = childContainer.getChildNodes().iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_35);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
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
	//GenLinkConstraints linkConstraints = genLink.getCreationConstraints();
	//String constraintsInstance = linkConstraints != null ? importManager.getImportedName(genDiagram.getLinkCreationConstraintsQualifiedClassName())+"."+linkConstraints.getConstraintsInstanceFieldName() : null;
	
	if (!genLink.isOutgoingCreationAllowed() && !genLink.isIncomingCreationAllowed()) {
		continue;
	}
	
	String namePartSuffix = null;
	GenClass outgoingClass;
	GenClass incomingClass;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		outgoingClass = modelFacet.getSourceMetaFeature() == null
			? modelFacet.getContainmentMetaFeature().getGenClass()
			: modelFacet.getSourceMetaFeature().getTypeGenClass();
		incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		namePartSuffix = modelFacet.getMetaClass().getName();
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		incomingClass = metaFeature.getTypeGenClass();
		namePartSuffix = metaFeature.getFeatureAccessorName();
	} else {
// Should not be here!
		continue;
	}
	boolean canBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
	boolean canBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
	
	if (!canBeSource && !canBeTarget) {
		continue;
	}

	namePartSuffix += genLink.getVisualID();
	
/**
 * In case this node can be both Source and Target of this link, this link is a link to self,
 * so for start request we should call "Outgoing" method, for complete = "Incomming" since
 * we should not invert link in this case.
 **/
	String startCommandGetter = genLink.isOutgoingCreationAllowed() ? "getCreateStart" + (canBeSource ? OUTGOING_TOKEN : INCOMING_TOKEN) + namePartSuffix + "Command(req)" : "null";
	String endCommandGetter = genLink.isIncomingCreationAllowed() ? "getCreateComplete" + (canBeTarget ? INCOMING_TOKEN : OUTGOING_TOKEN) + namePartSuffix + "Command(req)" : "null";

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(startCommandGetter);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(endCommandGetter);
    stringBuffer.append(TEXT_70);
    
}

    stringBuffer.append(TEXT_71);
    

for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	GenLinkConstraints linkConstraints = genLink.getCreationConstraints();
	String constraintsInstance = linkConstraints != null ? importManager.getImportedName(genDiagram.getLinkCreationConstraintsQualifiedClassName())+"."+linkConstraints.getConstraintsInstanceFieldName() : null;

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
		GenClass outgoingClass = modelFacet.getSourceMetaFeature() == null
			? modelFacet.getContainmentMetaFeature().getGenClass()
			: modelFacet.getSourceMetaFeature().getTypeGenClass();
		GenClass incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		GenFeature childFeature = modelFacet.getChildMetaFeature();
		int upperContainmentBound = containmentFeature.getEcoreFeature().getUpperBound();
		int upperChildBound = childFeature.getEcoreFeature().getUpperBound();
		boolean processChildFeature = !childFeature.isDerived() && !childFeature.equals(containmentFeature);
		boolean checkChildFeatureUpperBound = !childFeature.equals(containmentFeature) && upperChildBound > 0;

/**
 * Model element could be source of the link or target of the link. It can be both source and 
 * target only in case of selfLink.
 **/
		boolean couldBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
		boolean couldBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());		
		boolean selfLink = couldBeSource && couldBeTarget;
		
/**
 * Start  		start of link creation. 
 *				User click to this editpart and start dragging with link tool.
 * Complete 	end of the command
 *				User points to this editpart as a link target and release mouse button.
 *
 * Outgoing 	the node is link source
 *				This element could be a source for this type of link.
 * Incoming		the node is link destination
 *				This element could be a target for this type of link.
 *
 **/
		boolean generateStartOutgoingCommand = couldBeSource && genLink.isOutgoingCreationAllowed();
		boolean generateCompleteOutgoingCommand = couldBeSource && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateStartIncomingCommand = couldBeTarget && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateCompleteIncomingCommand = couldBeTarget && genLink.isOutgoingCreationAllowed();
		
		String namePartSuffix = modelFacet.getMetaClass().getName() + genLink.getVisualID();
		
		
// 1. StartOutgoingCommand

		if (generateStartOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_72);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_73);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
				if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_76);
    				} else {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_82);
    
				}
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

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_99);
    			} // end of link constraints 
     // create always executable command 
    stringBuffer.append(TEXT_100);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_101);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_102);
     // check that source is valid 
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_105);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_108);
    			} else {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_114);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_116);
    					} else {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_119);
    					}
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_121);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_123);
    					} else {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_126);
    					}
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_128);
    
				}
			}

     // create semantic command 
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_131);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_132);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_134);
    			} // end of link constraints 
    stringBuffer.append(TEXT_135);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_145);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_150);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_153);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_156);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_159);
    				} else {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_161);
    				}
    stringBuffer.append(TEXT_162);
    
			}
			if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_165);
    			}
    stringBuffer.append(TEXT_166);
    
		}
			
			
// 3. StartIncomingCommand
			
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_167);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_168);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_171);
    			} // end of link constraints 
    stringBuffer.append(TEXT_172);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_173);
    
		}
		
		
// 4. CompleteIncomingCommand
		
		if (generateCompleteIncomingCommand) {	
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_174);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_175);
     // check that source is valid 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_178);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_179);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_181);
    				} else {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_187);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_189);
    					} else {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_192);
    					}
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_194);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_196);
    					} else {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_199);
    					}
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_201);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_202);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_204);
    			} // end of constraints 
    stringBuffer.append(TEXT_205);
     // create semantic command 
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_218);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_223);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_224);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_226);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_229);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_232);
    				} else {
    stringBuffer.append(TEXT_233);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_234);
    				}
    stringBuffer.append(TEXT_235);
    
			}
				if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_238);
    			}
    stringBuffer.append(TEXT_239);
    
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
		
/**
 * Model element could be source of the link or target of the link. It can be both source and 
 * target only in case of selfLink.
 **/
		boolean couldBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
		boolean couldBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());		
		boolean selfLink = couldBeSource && couldBeTarget;
		
/**
 * Start  		start of link creation. 
 *				User click to this editpart and start dragging with link tool.
 * Complete 	end of the command
 *				User points to this editpart as a link target and release mouse button.
 *
 * Outgoing 	the node is link source
 *				This element could be a source for this type of link.
 * Incoming		the node is link destination
 *				This element could be a target for this type of link.
 *
 **/
		boolean generateStartOutgoingCommand = couldBeSource && genLink.isOutgoingCreationAllowed();
		boolean generateCompleteOutgoingCommand = couldBeSource && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateStartIncomingCommand = couldBeTarget && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateCompleteIncomingCommand = couldBeTarget && genLink.isOutgoingCreationAllowed();
		
		String namePartSuffix = metaFeature.getFeatureAccessorName() + genLink.getVisualID();
		
		
// 1. StartOutgoingCommand
		
		if (generateStartOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_240);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_241);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_242);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_244);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_246);
    				} else {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_249);
    				}
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_251);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_254);
    			} // end of link constraints 
    stringBuffer.append(TEXT_255);
     // create always executable command 
    stringBuffer.append(TEXT_256);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_257);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_258);
     // check that source is valid 
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_261);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_262);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_264);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_265);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_266);
    				} else {
    stringBuffer.append(TEXT_267);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_270);
    				}
    stringBuffer.append(TEXT_271);
    			}
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_273);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_274);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_278);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_279);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_281);
    			} // end of constraints 
    stringBuffer.append(TEXT_282);
     // create semantic command 
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_288);
    
		}
		
		
// 3. StartIncomingCommand
		
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_289);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_290);
    			if(genLink.getCreationConstraints() != null) { 
    stringBuffer.append(TEXT_291);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_293);
    			} // end of link constraints 
     // no feasible restrictions here 
    stringBuffer.append(TEXT_294);
    
		}
		
		
// 4. CompleteIncomingCommand

		if (generateCompleteIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_295);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_296);
     // check that source is valid 
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_299);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_300);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_302);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_303);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_304);
    				} else {
    stringBuffer.append(TEXT_305);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_307);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_308);
    					}
    stringBuffer.append(TEXT_309);
    				}
    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_311);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_312);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_316);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_317);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_319);
    			} // end of constraints 
     // create semantic command 
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_325);
    
		}
	}
}

    stringBuffer.append(TEXT_326);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_327);
    return stringBuffer.toString();
  }
}