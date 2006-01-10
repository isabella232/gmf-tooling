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
  protected final String TEXT_3 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLDestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
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
  protected final String TEXT_17 = ") (req.getContainer() instanceof ";
  protected final String TEXT_18 = " ? ((";
  protected final String TEXT_19 = ") req.getContainer()).getElement() : req.getContainer());";
  protected final String TEXT_20 = NL + "\t\t\tif (";
  protected final String TEXT_21 = " != null) {";
  protected final String TEXT_22 = NL + "\t\t\tif (";
  protected final String TEXT_23 = ".size() >= ";
  protected final String TEXT_24 = ") {";
  protected final String TEXT_25 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\tif (";
  protected final String TEXT_27 = " != null) {";
  protected final String TEXT_28 = NL + "\t\t\tif (";
  protected final String TEXT_29 = ".size() >= ";
  protected final String TEXT_30 = ") {";
  protected final String TEXT_31 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_32 = NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_33 = ".eINSTANCE.get";
  protected final String TEXT_34 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_35 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_36 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_38 = "Command extends ";
  protected final String TEXT_39 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_40 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_41 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_42 = ".eINSTANCE.get";
  protected final String TEXT_43 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_44 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_45 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_46 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_47 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_48 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_49 = " doDefaultElementCreation() {" + NL + "\t\t\t";
  protected final String TEXT_50 = " newElement = (";
  protected final String TEXT_51 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {";
  protected final String TEXT_52 = NL + "\t\t\t\t ";
  protected final String TEXT_53 = " container = (";
  protected final String TEXT_54 = ") getElementToEdit();" + NL + "\t\t\t\t if (container != null) {";
  protected final String TEXT_55 = NL + "\t\t\t\t\t";
  protected final String TEXT_56 = " featureValues = container.";
  protected final String TEXT_57 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_58 = NL + "\t\t\t\t \t";
  protected final String TEXT_59 = "newElement);";
  protected final String TEXT_60 = NL + "\t\t\t\t }";
  protected final String TEXT_61 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_62 = ".Initializers.";
  protected final String TEXT_63 = ".init(newElement);";
  protected final String TEXT_64 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_65 = NL + "\t}";
  protected final String TEXT_66 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req) {" + NL + "\t\t\tprotected EObject getElementToDestroy() {" + NL + "\t\t\t\tView view = (View) getHost().getModel();" + NL + "\t\t\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcutted\"); //$NON-NLS-1$" + NL + "\t\t\t\tif (annotation != null) {" + NL + "\t\t\t\t\treturn view;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.getElementToDestroy();" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_67 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_68 = NL + "\t\tif (";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? ";
  protected final String TEXT_71 = " : ";
  protected final String TEXT_72 = ";" + NL + "\t\t}";
  protected final String TEXT_73 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_74 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_75 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_76 = NL + "\t\t";
  protected final String TEXT_77 = " element = (";
  protected final String TEXT_78 = ") getSemanticElement();";
  protected final String TEXT_79 = NL + "\t\t";
  protected final String TEXT_80 = " element = (";
  protected final String TEXT_81 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_82 = ".eINSTANCE.get";
  protected final String TEXT_83 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_84 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_85 = NL + "\t\tif (";
  protected final String TEXT_86 = " != null) {";
  protected final String TEXT_87 = NL + "\t\tif (";
  protected final String TEXT_88 = ".size() >= ";
  protected final String TEXT_89 = ") {";
  protected final String TEXT_90 = NL + "\t\t\treturn ";
  protected final String TEXT_91 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_92 = NL + "\t\tif (";
  protected final String TEXT_93 = " != null) {";
  protected final String TEXT_94 = NL + "\t\tif (";
  protected final String TEXT_95 = ".size() >= ";
  protected final String TEXT_96 = ") {";
  protected final String TEXT_97 = NL + "\t\t\treturn ";
  protected final String TEXT_98 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_99 = NL + "\t\tif(!";
  protected final String TEXT_100 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_101 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_102 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_103 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_104 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_105 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_106 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_107 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t\tfinal ";
  protected final String TEXT_109 = " element = (";
  protected final String TEXT_110 = ") getSemanticElement();";
  protected final String TEXT_111 = NL + "\t\tfinal ";
  protected final String TEXT_112 = " element = (";
  protected final String TEXT_113 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_114 = ".eINSTANCE.get";
  protected final String TEXT_115 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_116 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_117 = NL + "\t\tif (";
  protected final String TEXT_118 = " != null) {";
  protected final String TEXT_119 = NL + "\t\tif (";
  protected final String TEXT_120 = ".size() >= ";
  protected final String TEXT_121 = ") {";
  protected final String TEXT_122 = NL + "\t\t\treturn ";
  protected final String TEXT_123 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_124 = NL + "\t\tif (";
  protected final String TEXT_125 = " != null) {";
  protected final String TEXT_126 = NL + "\t\tif (";
  protected final String TEXT_127 = ".size() >= ";
  protected final String TEXT_128 = ") {";
  protected final String TEXT_129 = NL + "\t\t\treturn ";
  protected final String TEXT_130 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_131 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_132 = ".eINSTANCE.get";
  protected final String TEXT_133 = "());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t\tif(!";
  protected final String TEXT_135 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_136 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_137 = "\t\t\t\t" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_138 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_139 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_140 = "Command extends ";
  protected final String TEXT_141 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_142 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_143 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_144 = ".eINSTANCE.get";
  protected final String TEXT_145 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_146 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_147 = " doDefaultElementCreation() {";
  protected final String TEXT_148 = NL + "\t\t\t";
  protected final String TEXT_149 = " newElement = (";
  protected final String TEXT_150 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_151 = "(";
  protected final String TEXT_152 = ") getSource());";
  protected final String TEXT_153 = NL + "\t\t\t\t";
  protected final String TEXT_154 = "(";
  protected final String TEXT_155 = ") getTarget());";
  protected final String TEXT_156 = NL + "\t\t\t\t";
  protected final String TEXT_157 = " container = (";
  protected final String TEXT_158 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_159 = NL + "\t\t\t\t\t";
  protected final String TEXT_160 = " featureValues = container.";
  protected final String TEXT_161 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_162 = NL + "\t\t\t\t \t";
  protected final String TEXT_163 = "newElement);";
  protected final String TEXT_164 = NL + "\t\t\t\t}";
  protected final String TEXT_165 = NL + "\t\t\t\t";
  protected final String TEXT_166 = ".Initializers.";
  protected final String TEXT_167 = ".init(newElement);";
  protected final String TEXT_168 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_169 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_170 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_171 = NL + "\t\tif(!";
  protected final String TEXT_172 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_173 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_174 = "\t";
  protected final String TEXT_175 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_176 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_177 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_178 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_179 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_180 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_181 = NL + "\t\tfinal ";
  protected final String TEXT_182 = " element = (";
  protected final String TEXT_183 = ") req.getSource();";
  protected final String TEXT_184 = NL + "\t\tfinal ";
  protected final String TEXT_185 = " element = (";
  protected final String TEXT_186 = ") getRelationshipContainer(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_187 = ".eINSTANCE.get";
  protected final String TEXT_188 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_189 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_190 = NL + "\t\tif (";
  protected final String TEXT_191 = " != null) {";
  protected final String TEXT_192 = NL + "\t\tif (";
  protected final String TEXT_193 = ".size() >= ";
  protected final String TEXT_194 = ") {";
  protected final String TEXT_195 = NL + "\t\t\treturn ";
  protected final String TEXT_196 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_197 = NL + "\t\tif (";
  protected final String TEXT_198 = " != null) {";
  protected final String TEXT_199 = NL + "\t\tif (";
  protected final String TEXT_200 = ".size() >= ";
  protected final String TEXT_201 = ") {";
  protected final String TEXT_202 = NL + "\t\t\treturn ";
  protected final String TEXT_203 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_204 = NL + "\t\tif(!";
  protected final String TEXT_205 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_206 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_207 = "\t\t";
  protected final String TEXT_208 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_209 = ".eINSTANCE.get";
  protected final String TEXT_210 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_211 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_212 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_213 = "Command extends ";
  protected final String TEXT_214 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_215 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_216 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_217 = ".eINSTANCE.get";
  protected final String TEXT_218 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_219 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_220 = " doDefaultElementCreation() {";
  protected final String TEXT_221 = NL + "\t\t\t";
  protected final String TEXT_222 = " newElement = (";
  protected final String TEXT_223 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_224 = "(";
  protected final String TEXT_225 = ") getTarget());";
  protected final String TEXT_226 = NL + "\t\t\t\t";
  protected final String TEXT_227 = "(";
  protected final String TEXT_228 = ") getSource());";
  protected final String TEXT_229 = NL + "\t\t\t\t";
  protected final String TEXT_230 = " container = (";
  protected final String TEXT_231 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_232 = NL + "\t\t\t\t\t";
  protected final String TEXT_233 = " featureValues = container.";
  protected final String TEXT_234 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_235 = NL + "\t\t\t\t \t";
  protected final String TEXT_236 = "newElement);";
  protected final String TEXT_237 = NL + "\t\t\t\t}";
  protected final String TEXT_238 = NL + "\t\t\t\t";
  protected final String TEXT_239 = ".Initializers.";
  protected final String TEXT_240 = ".init(newElement);";
  protected final String TEXT_241 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_242 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_243 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_244 = NL + "\t\t";
  protected final String TEXT_245 = " element = (";
  protected final String TEXT_246 = ") getSemanticElement();";
  protected final String TEXT_247 = NL + "\t\tif (";
  protected final String TEXT_248 = " != null) {";
  protected final String TEXT_249 = NL + "\t\tif (";
  protected final String TEXT_250 = ".size() >= ";
  protected final String TEXT_251 = ") {";
  protected final String TEXT_252 = NL + "\t\t\treturn ";
  protected final String TEXT_253 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_254 = NL + "\t\tif(!";
  protected final String TEXT_255 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_256 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_257 = NL;
  protected final String TEXT_258 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_259 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_260 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_261 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_262 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_263 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_264 = NL + "\t\t";
  protected final String TEXT_265 = " element = (";
  protected final String TEXT_266 = ") getSemanticElement();";
  protected final String TEXT_267 = NL + "\t\tif (";
  protected final String TEXT_268 = " != null) {";
  protected final String TEXT_269 = NL + "\t\tif (";
  protected final String TEXT_270 = ".size() >= ";
  protected final String TEXT_271 = NL + "\t\t\t|| ";
  protected final String TEXT_272 = ".contains(req.getSource())";
  protected final String TEXT_273 = NL + "\t\t\t\t) {";
  protected final String TEXT_274 = NL + "\t\t\treturn ";
  protected final String TEXT_275 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_276 = NL + "\t\t";
  protected final String TEXT_277 = " element = (";
  protected final String TEXT_278 = ") getSemanticElement();" + NL + "\t\tif (";
  protected final String TEXT_279 = ".contains(req.getSource())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_280 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_281 = NL + "\t\tif(!";
  protected final String TEXT_282 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_283 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_284 = "\t\t";
  protected final String TEXT_285 = NL + "\t\t";
  protected final String TEXT_286 = " setReq = new ";
  protected final String TEXT_287 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_288 = ".eINSTANCE.get";
  protected final String TEXT_289 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_290 = "(setReq));" + NL + "\t}";
  protected final String TEXT_291 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_292 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_293 = NL + "\t\tif(!";
  protected final String TEXT_294 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_295 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_296 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_297 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_298 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_299 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_300 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_301 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_302 = NL + "\t\t";
  protected final String TEXT_303 = " element = (";
  protected final String TEXT_304 = ") req.getSource();";
  protected final String TEXT_305 = NL + "\t\tif (";
  protected final String TEXT_306 = " != null) {";
  protected final String TEXT_307 = NL + "\t\tif (";
  protected final String TEXT_308 = ".size() >= ";
  protected final String TEXT_309 = NL + "\t\t\t|| ";
  protected final String TEXT_310 = ".contains(req.getTarget())";
  protected final String TEXT_311 = NL + "\t\t\t\t) {";
  protected final String TEXT_312 = NL + "\t\t\treturn ";
  protected final String TEXT_313 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_314 = NL + "\t\t";
  protected final String TEXT_315 = " element = (";
  protected final String TEXT_316 = ") req.getSource();" + NL + "\t\tif (";
  protected final String TEXT_317 = ".contains(req.getTarget())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_318 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_319 = NL + "\t\tif(!";
  protected final String TEXT_320 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_321 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_322 = NL + "\t\t";
  protected final String TEXT_323 = " setReq = new ";
  protected final String TEXT_324 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_325 = ".eINSTANCE.get";
  protected final String TEXT_326 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_327 = "(setReq));" + NL + "\t}";
  protected final String TEXT_328 = NL + "}";
  protected final String TEXT_329 = NL;

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
	Collection childNodes = genNode.getChildNodes();
	GenClass containerGenClass = genNode.getModelFacet().getMetaClass();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_11);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
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
		String containerInterfaceName = importManager.getImportedName(containerGenClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_19);
    
		if (upperContainmentBound > 0) {
			if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_21);
    
			} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_24);
    
			}

    stringBuffer.append(TEXT_25);
    
		}
		
		if (processChildMetafeature) {
			if (upperChildBound == 1) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_27);
    
			} else {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_30);
    
			}

    stringBuffer.append(TEXT_31);
    
		}
	}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    
}

    stringBuffer.append(TEXT_36);
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_37);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(containerGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_47);
    
	boolean processChildMetafeature = !modelFacet.getChildMetaFeature().isDerived() && !modelFacet.getChildMetaFeature().equals(modelFacet.getContainmentMetaFeature());
	if (modelFacet.getModelElementInitializer() != null || processChildMetafeature) { 
		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_51);
    
		if (processChildMetafeature) {
			String containerMetaClass = importManager.getImportedName(modelFacet.getChildMetaFeature().getGenClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_52);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_54);
    
			if (modelFacet.getChildMetaFeature().isListType()) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(modelFacet.getChildMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_57);
    
			} else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(getFeatureValueSetterPrefix("container", modelFacet.getChildMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_59);
    
			}

    stringBuffer.append(TEXT_60);
    
		}
		if (modelFacet.getModelElementInitializer() != null) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    
		}

    stringBuffer.append(TEXT_64);
    
	}

    stringBuffer.append(TEXT_65);
    }
    }
    stringBuffer.append(TEXT_66);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_67);
    
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
	boolean selfLink = canBeSource & canBeTarget;
	
	namePartSuffix += genLink.getVisualID();
	String startCommandGetter = "null";
	if (canBeSource && genLink.isOutgoingCreationAllowed()) {
		startCommandGetter = "getCreateStart" + OUTGOING_TOKEN + namePartSuffix + "Command(req)";
	} else if (canBeTarget && genLink.isIncomingCreationAllowed() && !selfLink) {
		startCommandGetter = "getCreateStart" + INCOMING_TOKEN + namePartSuffix + "Command(req)";
	}

	String endCommandGetter = "null";
	if (canBeSource && genLink.isIncomingCreationAllowed() && !selfLink) {
		endCommandGetter = "getCreateComplete" + OUTGOING_TOKEN + namePartSuffix + "Command(req)";
	} else if (canBeTarget && genLink.isOutgoingCreationAllowed()) {
		endCommandGetter = "getCreateComplete" + INCOMING_TOKEN + namePartSuffix + "Command(req)";
	}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(startCommandGetter);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(endCommandGetter);
    stringBuffer.append(TEXT_72);
    
}

    stringBuffer.append(TEXT_73);
    

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
		boolean canBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
		boolean canBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());		
		boolean selfLink = canBeSource && canBeTarget;
		
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
		boolean generateStartOutgoingCommand = canBeSource && genLink.isOutgoingCreationAllowed();
		boolean generateCompleteOutgoingCommand = canBeSource && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateStartIncomingCommand = canBeTarget && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateCompleteIncomingCommand = canBeTarget && genLink.isOutgoingCreationAllowed();
		
		String namePartSuffix = modelFacet.getMetaClass().getName() + genLink.getVisualID();
		
		
// 1. StartOutgoingCommand

		if (generateStartOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_74);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_75);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
				if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_78);
    				} else {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_84);
    
				}
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_86);
    					} else {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_89);
    					}
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_91);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_93);
    					} else {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_96);
    					}
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_98);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_99);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_101);
    			} // end of link constraints 
     // create always executable command 
    stringBuffer.append(TEXT_102);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_103);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_104);
     // check that source is valid 
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_107);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_110);
    			} else {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_116);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_118);
    					} else {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_121);
    					}
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_123);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_125);
    					} else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_128);
    					}
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_130);
    
				}
			}

     // create semantic command 
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_133);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_134);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_136);
    			} // end of link constraints 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_147);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_152);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_155);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_158);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_161);
    				} else {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_163);
    				}
    stringBuffer.append(TEXT_164);
    
			}
			if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_167);
    			}
    stringBuffer.append(TEXT_168);
    
		}
			
			
// 3. StartIncomingCommand
			
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_169);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_170);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_173);
    			} // end of link constraints 
    stringBuffer.append(TEXT_174);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_175);
    
		}
		
		
// 4. CompleteIncomingCommand
		
		if (generateCompleteIncomingCommand) {	
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_176);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_177);
     // check that source is valid 
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_180);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_183);
    				} else {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_189);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_191);
    					} else {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_194);
    					}
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_196);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_198);
    					} else {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_201);
    					}
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_203);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_206);
    			} // end of constraints 
    stringBuffer.append(TEXT_207);
     // create semantic command 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateRelationshipCommand"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_220);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_225);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_228);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_229);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_231);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_234);
    				} else {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_236);
    				}
    stringBuffer.append(TEXT_237);
    
			}
				if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_240);
    			}
    stringBuffer.append(TEXT_241);
    
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
		boolean canBeSource = outgoingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());
		boolean canBeTarget = incomingClass.getEcoreClass().isSuperTypeOf(nodeMetaClass.getEcoreClass());		
		boolean selfLink = canBeSource && canBeTarget;
		
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
		boolean generateStartOutgoingCommand = canBeSource && genLink.isOutgoingCreationAllowed();
		boolean generateCompleteOutgoingCommand = canBeSource && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateStartIncomingCommand = canBeTarget && genLink.isIncomingCreationAllowed() && !selfLink;
		boolean generateCompleteIncomingCommand = canBeTarget && genLink.isOutgoingCreationAllowed();
		
		String namePartSuffix = metaFeature.getFeatureAccessorName() + genLink.getVisualID();
		
		
// 1. StartOutgoingCommand
		
		if (generateStartOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_242);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_243);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_244);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_246);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_248);
    				} else {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_251);
    				}
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_253);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_254);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_256);
    			} // end of link constraints 
    stringBuffer.append(TEXT_257);
     // create always executable command 
    stringBuffer.append(TEXT_258);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_259);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_260);
     // check that source is valid 
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_263);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_264);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_266);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_267);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_268);
    				} else {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_271);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_272);
    				}
    stringBuffer.append(TEXT_273);
    			}
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_275);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_276);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_280);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_281);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_283);
    			} // end of constraints 
    stringBuffer.append(TEXT_284);
     // create semantic command 
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_290);
    
		}
		
		
// 3. StartIncomingCommand
		
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_291);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_292);
    			if(genLink.getCreationConstraints() != null) { 
    stringBuffer.append(TEXT_293);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_295);
    			} // end of link constraints 
     // no feasible restrictions here 
    stringBuffer.append(TEXT_296);
    
		}
		
		
// 4. CompleteIncomingCommand

		if (generateCompleteIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_297);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_298);
     // check that source is valid 
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_301);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_302);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_304);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_305);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_306);
    				} else {
    stringBuffer.append(TEXT_307);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_309);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_310);
    					}
    stringBuffer.append(TEXT_311);
    				}
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_313);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_314);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_318);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_319);
    stringBuffer.append(constraintsInstance);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_321);
    			} // end of constraints 
     // create semantic command 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_327);
    
		}
	}
}

    stringBuffer.append(TEXT_328);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_329);
    return stringBuffer.toString();
  }
}