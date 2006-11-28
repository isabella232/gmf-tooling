package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_11 = " getCreateCommand(";
  protected final String TEXT_12 = " req) {";
  protected final String TEXT_13 = NL + "\t\tif (";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " == req.getElementType()) {";
  protected final String TEXT_16 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_17 = " container = (";
  protected final String TEXT_18 = ") (req.getContainer() instanceof ";
  protected final String TEXT_19 = " ? ((";
  protected final String TEXT_20 = ") req.getContainer()).getElement() : req.getContainer());";
  protected final String TEXT_21 = NL + "\t\t\tif (";
  protected final String TEXT_22 = " != null) {";
  protected final String TEXT_23 = NL + "\t\t\tif (";
  protected final String TEXT_24 = ".size() >= ";
  protected final String TEXT_25 = ") {";
  protected final String TEXT_26 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_27 = NL + "\t\t\tif (";
  protected final String TEXT_28 = " != null) {";
  protected final String TEXT_29 = NL + "\t\t\tif (";
  protected final String TEXT_30 = ".size() >= ";
  protected final String TEXT_31 = ") {";
  protected final String TEXT_32 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_33 = NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_34 = ".eINSTANCE.get";
  protected final String TEXT_35 = "());" + NL + "\t\t\t}";
  protected final String TEXT_36 = NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_37 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_38 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_40 = "Command extends ";
  protected final String TEXT_41 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_42 = "Command(";
  protected final String TEXT_43 = " req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_44 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_45 = ".eINSTANCE.get";
  protected final String TEXT_46 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_47 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_48 = " container = ((";
  protected final String TEXT_49 = ") getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_50 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_51 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_52 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_53 = " doDefaultElementCreation() {" + NL + "\t\t\t";
  protected final String TEXT_54 = " newElement = (";
  protected final String TEXT_55 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {";
  protected final String TEXT_56 = NL + "\t\t\t\t ";
  protected final String TEXT_57 = " container = (";
  protected final String TEXT_58 = ") getElementToEdit();" + NL + "\t\t\t\t if (container != null) {";
  protected final String TEXT_59 = NL + "\t\t\t\t\t";
  protected final String TEXT_60 = " featureValues = container.";
  protected final String TEXT_61 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_62 = NL + "\t\t\t\t \t";
  protected final String TEXT_63 = "newElement);";
  protected final String TEXT_64 = NL + "\t\t\t\t }";
  protected final String TEXT_65 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_66 = ".Initializers.";
  protected final String TEXT_67 = ".init(newElement);";
  protected final String TEXT_68 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_69 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (getEClass() != null) {" + NL + "\t\t\t\treturn getEClass().isSuperTypeOf(getEClassToEdit());" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_70 = " getContainmentFeature() {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_71 = " doDefaultElementCreation() {" + NL + "\t\t\t// Uncomment to put \"phantom\" objects into the diagram file.\t\t" + NL + "\t\t\t//";
  protected final String TEXT_72 = " resource = ((";
  protected final String TEXT_73 = ") getRequest()).getContainer().eResource();" + NL + "\t\t\t//if (resource == null) {" + NL + "\t\t\t//\treturn null;" + NL + "\t\t\t//}" + NL + "\t\t\t";
  protected final String TEXT_74 = " resource = getElementToEdit().eResource();" + NL + "\t\t\t";
  protected final String TEXT_75 = " eClass = getElementType().getEClass();" + NL + "\t\t\t";
  protected final String TEXT_76 = " eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);" + NL + "\t\t\tresource.getContents().add(eObject);" + NL + "\t\t\treturn eObject;" + NL + "\t\t}";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new DestroyElementCommand(req) {" + NL + "\t\t" + NL + "\t\t\tprotected EObject getElementToDestroy() {" + NL + "\t\t\t\tView view = (View) getHost().getModel();" + NL + "\t\t\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\t\tif (annotation != null) {" + NL + "\t\t\t\t\treturn view;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.getElementToDestroy();" + NL + "\t\t\t}\t\t" + NL;
  protected final String TEXT_79 = NL + "\t\t\tprotected ";
  protected final String TEXT_80 = " doExecuteWithResult(";
  protected final String TEXT_81 = " progressMonitor, ";
  protected final String TEXT_82 = " info) throws ";
  protected final String TEXT_83 = " {" + NL + "\t\t\t\tEObject eObject = getElementToDestroy();" + NL + "\t\t\t\tboolean removeFromResource = eObject.eContainer() == null;" + NL + "\t\t\t\t";
  protected final String TEXT_84 = " result = super.doExecuteWithResult(progressMonitor, info);" + NL + "\t\t\t\t";
  protected final String TEXT_85 = " resource = eObject.eResource();" + NL + "\t\t\t\tif (removeFromResource && resource != null) {" + NL + "\t\t\t\t\tresource.getContents().remove(eObject);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}";
  protected final String TEXT_86 = NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_87 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_88 = NL + "\t\tif (";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? ";
  protected final String TEXT_91 = " : ";
  protected final String TEXT_92 = ";" + NL + "\t\t}";
  protected final String TEXT_93 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_94 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_95 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_96 = NL + "\t\t";
  protected final String TEXT_97 = " element = (";
  protected final String TEXT_98 = ") getSemanticElement();";
  protected final String TEXT_99 = NL + "\t\t";
  protected final String TEXT_100 = " element = (";
  protected final String TEXT_101 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_102 = ".eINSTANCE.get";
  protected final String TEXT_103 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_104 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_105 = NL + "\t\tif (";
  protected final String TEXT_106 = " != null) {";
  protected final String TEXT_107 = NL + "\t\tif (";
  protected final String TEXT_108 = ".size() >= ";
  protected final String TEXT_109 = ") {";
  protected final String TEXT_110 = NL + "\t\t\treturn ";
  protected final String TEXT_111 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_112 = NL + "\t\tif (";
  protected final String TEXT_113 = " != null) {";
  protected final String TEXT_114 = NL + "\t\tif (";
  protected final String TEXT_115 = ".size() >= ";
  protected final String TEXT_116 = ") {";
  protected final String TEXT_117 = NL + "\t\t\treturn ";
  protected final String TEXT_118 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_119 = NL + "\t\tif(!";
  protected final String TEXT_120 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_121 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_122 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_123 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_124 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_125 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_126 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_127 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_128 = NL + "\t\tfinal ";
  protected final String TEXT_129 = " element = (";
  protected final String TEXT_130 = ") getSemanticElement();";
  protected final String TEXT_131 = NL + "\t\tfinal ";
  protected final String TEXT_132 = " element = (";
  protected final String TEXT_133 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_134 = ".eINSTANCE.get";
  protected final String TEXT_135 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_136 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_137 = NL + "\t\tif (";
  protected final String TEXT_138 = " != null) {";
  protected final String TEXT_139 = NL + "\t\tif (";
  protected final String TEXT_140 = ".size() >= ";
  protected final String TEXT_141 = ") {";
  protected final String TEXT_142 = NL + "\t\t\treturn ";
  protected final String TEXT_143 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_144 = NL + "\t\tif (";
  protected final String TEXT_145 = " != null) {";
  protected final String TEXT_146 = NL + "\t\tif (";
  protected final String TEXT_147 = ".size() >= ";
  protected final String TEXT_148 = ") {";
  protected final String TEXT_149 = NL + "\t\t\treturn ";
  protected final String TEXT_150 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_151 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_152 = ".eINSTANCE.get";
  protected final String TEXT_153 = "());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\tif(!";
  protected final String TEXT_155 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_156 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_157 = "\t\t\t\t" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_158 = "(req, element, (";
  protected final String TEXT_159 = ") req.getTarget(), (";
  protected final String TEXT_160 = ") req.getSource()));" + NL + "\t}";
  protected final String TEXT_161 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_162 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_163 = NL + "\t\tif(!";
  protected final String TEXT_164 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_165 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_166 = "\t";
  protected final String TEXT_167 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_168 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_169 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_170 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_171 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_172 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_173 = NL + "\t\tfinal ";
  protected final String TEXT_174 = " element = (";
  protected final String TEXT_175 = ") req.getSource();";
  protected final String TEXT_176 = NL + "\t\tfinal ";
  protected final String TEXT_177 = " element = (";
  protected final String TEXT_178 = ") getRelationshipContainer(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_179 = ".eINSTANCE.get";
  protected final String TEXT_180 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_181 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_182 = NL + "\t\tif (";
  protected final String TEXT_183 = " != null) {";
  protected final String TEXT_184 = NL + "\t\tif (";
  protected final String TEXT_185 = ".size() >= ";
  protected final String TEXT_186 = ") {";
  protected final String TEXT_187 = NL + "\t\t\treturn ";
  protected final String TEXT_188 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_189 = NL + "\t\tif (";
  protected final String TEXT_190 = " != null) {";
  protected final String TEXT_191 = NL + "\t\tif (";
  protected final String TEXT_192 = ".size() >= ";
  protected final String TEXT_193 = ") {";
  protected final String TEXT_194 = NL + "\t\t\treturn ";
  protected final String TEXT_195 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_196 = NL + "\t\tif(!";
  protected final String TEXT_197 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_198 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_199 = "\t\t";
  protected final String TEXT_200 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_201 = ".eINSTANCE.get";
  protected final String TEXT_202 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_203 = "(req, element, (";
  protected final String TEXT_204 = ") req.getSource(), (";
  protected final String TEXT_205 = ") req.getTarget()));" + NL + "\t}";
  protected final String TEXT_206 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_207 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_208 = NL + "\t\t";
  protected final String TEXT_209 = " element = (";
  protected final String TEXT_210 = ") getSemanticElement();";
  protected final String TEXT_211 = NL + "\t\tif (";
  protected final String TEXT_212 = " != null) {";
  protected final String TEXT_213 = NL + "\t\tif (";
  protected final String TEXT_214 = ".size() >= ";
  protected final String TEXT_215 = ") {";
  protected final String TEXT_216 = NL + "\t\t\treturn ";
  protected final String TEXT_217 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_218 = NL + "\t\tif(!";
  protected final String TEXT_219 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_220 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_221 = NL;
  protected final String TEXT_222 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_223 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_224 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_225 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_226 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_227 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_228 = NL + "\t\t";
  protected final String TEXT_229 = " element = (";
  protected final String TEXT_230 = ") getSemanticElement();";
  protected final String TEXT_231 = NL + "\t\tif (";
  protected final String TEXT_232 = " != null) {";
  protected final String TEXT_233 = NL + "\t\tif (";
  protected final String TEXT_234 = ".size() >= ";
  protected final String TEXT_235 = " || ";
  protected final String TEXT_236 = ".contains(req.getSource())) {";
  protected final String TEXT_237 = NL + "\t\t\treturn ";
  protected final String TEXT_238 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_239 = NL + "\t\t";
  protected final String TEXT_240 = " element = (";
  protected final String TEXT_241 = ") getSemanticElement();" + NL + "\t\tif (";
  protected final String TEXT_242 = ".contains(req.getSource())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_243 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_244 = NL + "\t\tif(!";
  protected final String TEXT_245 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_246 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_247 = "\t\t";
  protected final String TEXT_248 = NL + "\t\t";
  protected final String TEXT_249 = " setReq = new ";
  protected final String TEXT_250 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_251 = ".eINSTANCE.get";
  protected final String TEXT_252 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_253 = "(setReq));" + NL + "\t}";
  protected final String TEXT_254 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_255 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_256 = NL + "\t\tif(!";
  protected final String TEXT_257 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_258 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_259 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_260 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_261 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_262 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_263 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_264 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = " element = (";
  protected final String TEXT_267 = ") req.getSource();";
  protected final String TEXT_268 = NL + "\t\tif (";
  protected final String TEXT_269 = " != null) {";
  protected final String TEXT_270 = NL + "\t\tif (";
  protected final String TEXT_271 = ".size() >= ";
  protected final String TEXT_272 = " || ";
  protected final String TEXT_273 = ".contains(req.getTarget())) {";
  protected final String TEXT_274 = NL + "\t\t\treturn ";
  protected final String TEXT_275 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_276 = NL + "\t\t";
  protected final String TEXT_277 = " element = (";
  protected final String TEXT_278 = ") req.getSource();" + NL + "\t\tif (";
  protected final String TEXT_279 = ".contains(req.getTarget())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_280 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_281 = NL + "\t\tif(!";
  protected final String TEXT_282 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_283 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_284 = NL + "\t\t";
  protected final String TEXT_285 = " setReq = new ";
  protected final String TEXT_286 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_287 = ".eINSTANCE.get";
  protected final String TEXT_288 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_289 = "(setReq));" + NL + "\t}";
  protected final String TEXT_290 = NL + "}";
  protected final String TEXT_291 = NL;

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
    
final GenNode genNode = (GenNode) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genNode.getDiagram();

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
    stringBuffer.append(genNode.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
if (genNode.getChildNodes().size() > 0 && genNode.getModelFacet() != null) {
	Collection childNodes = genNode.getChildNodes();
	GenClass containerGenClass = genNode.getModelFacet().getMetaClass();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_12);
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();
	if (modelFacet == null) {
		continue;
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_15);
    
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	GenFeature childMetaFeature = modelFacet.getChildMetaFeature();
	if (!modelFacet.isPhantomElement()) {
		int upperContainmentBound = containmentMetaFeature.getEcoreFeature().getUpperBound();
		int upperChildBound = childMetaFeature.getEcoreFeature().getUpperBound();
		boolean processChildMetafeature = !childMetaFeature.equals(containmentMetaFeature) && upperChildBound > 0;
		if (upperContainmentBound > 0 || processChildMetafeature) {
			String containerInterfaceName = importManager.getImportedName(containerGenClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_16);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    
			if (upperContainmentBound > 0) {
				if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_22);
    
				} else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_25);
    
				}

    stringBuffer.append(TEXT_26);
    
			}
		
			if (processChildMetafeature) {
				if (upperChildBound == 1) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_28);
    
				} else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_31);
    
				}

    stringBuffer.append(TEXT_32);
    
			}
		}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_35);
    
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_37);
    
}

    stringBuffer.append(TEXT_38);
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();
	if (modelFacet == null) {
		continue;
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(containerGenClass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(containerGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_51);
    
	boolean processChildMetafeature = !modelFacet.isPhantomElement() && !modelFacet.getChildMetaFeature().isDerived() && !modelFacet.getChildMetaFeature().equals(modelFacet.getContainmentMetaFeature());
	if (modelFacet.getModelElementInitializer() != null || processChildMetafeature) { 
		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_55);
    
		if (processChildMetafeature) {
			String containerMetaClass = importManager.getImportedName(modelFacet.getChildMetaFeature().getGenClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_56);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_58);
    
			if (modelFacet.getChildMetaFeature().isListType()) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(modelFacet.getChildMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_61);
    
			} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(getFeatureValueSetterPrefix("container", modelFacet.getChildMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_63);
    
			}

    stringBuffer.append(TEXT_64);
    
		}
		if (modelFacet.getModelElementInitializer() != null) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_67);
    
		}

    stringBuffer.append(TEXT_68);
    
	}
	
	if (modelFacet.isPhantomElement()) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EReference"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_76);
    
	}

    stringBuffer.append(TEXT_77);
    }
    }
    stringBuffer.append(TEXT_78);
    	if (genNode.getModelFacet() != null && genNode.getModelFacet().isPhantomElement()) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.commands.ExecutionException"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_85);
    	}
    stringBuffer.append(TEXT_86);
    
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_87);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	if (!genLink.isOutgoingCreationAllowed() && !genLink.isIncomingCreationAllowed() || genLink.getModelFacet() == null) {
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
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		incomingClass = metaFeature.getTypeGenClass();
		namePartSuffix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (genNode.getModelFacet() == null) {
		continue;
	}
	GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
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

    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(startCommandGetter);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(endCommandGetter);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	GenLinkConstraints linkConstraints = genLink.getCreationConstraints();

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
		boolean checkChildFeatureUpperBound = !childFeature.equals(containmentFeature) && upperChildBound > 0;

/**
 * Model element could be source of the link or target of the link. It can be both source and 
 * target only in case of selfLink.
 **/
		if (genNode.getModelFacet() == null) {
			continue;
		}
		GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
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

    stringBuffer.append(TEXT_94);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_95);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
				if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_98);
    				} else {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_104);
    
				}
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_106);
    					} else {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_109);
    					}
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_111);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_113);
    					} else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_116);
    					}
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_118);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_121);
    			} // end of link constraints 
     // create always executable command 
    stringBuffer.append(TEXT_122);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_123);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_124);
     // check that source is valid 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_127);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_130);
    			} else {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_136);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_138);
    					} else {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_141);
    					}
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_143);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_144);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_145);
    					} else {
    stringBuffer.append(TEXT_146);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_148);
    					}
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_150);
    
				}
			}

     // create semantic command 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_153);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_156);
    			} // end of link constraints 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName(modelFacet.getCreateCommandQualifiedClassName()));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_160);
    
		}
			
			
// 3. StartIncomingCommand
			
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_161);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_162);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_165);
    			} // end of link constraints 
    stringBuffer.append(TEXT_166);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_167);
    
		}
		
		
// 4. CompleteIncomingCommand
		
		if (generateCompleteIncomingCommand) {	
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_168);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_169);
     // check that source is valid 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_172);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_175);
    				} else {
    stringBuffer.append(TEXT_176);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_181);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_182);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_183);
    					} else {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_186);
    					}
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_188);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_189);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_190);
    					} else {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_193);
    					}
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_195);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_198);
    			} // end of constraints 
    stringBuffer.append(TEXT_199);
     // create semantic command 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(modelFacet.getCreateCommandQualifiedClassName()));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_205);
    
		}

	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
//
//
//
////////////////////////
// Feat Link Commands //
////////////////////////
//
//
//
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		int upperBound = metaFeature.getEcoreFeature().getUpperBound();
		GenClass outgoingClass = metaFeature.getGenClass();
		GenClass incomingClass = metaFeature.getTypeGenClass();
		
/**
 * Model element could be source of the link or target of the link. It can be both source and 
 * target only in case of selfLink.
 **/
		if (genNode.getModelFacet() == null) {
			continue;
		}
		GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
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

    stringBuffer.append(TEXT_206);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_207);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_208);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_210);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_212);
    				} else {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_215);
    				}
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_217);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_220);
    			} // end of link constraints 
    stringBuffer.append(TEXT_221);
     // create always executable command 
    stringBuffer.append(TEXT_222);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_223);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_224);
     // check that source is valid 
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_227);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_228);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_230);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_232);
    				} else {
    stringBuffer.append(TEXT_233);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_236);
    				}
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_238);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_239);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_243);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_246);
    			} // end of constraints 
    stringBuffer.append(TEXT_247);
     // create semantic command 
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_253);
    
		}
		
		
// 3. StartIncomingCommand
		
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_254);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_255);
    			if(genLink.getCreationConstraints() != null) { 
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_258);
    			} // end of link constraints 
     // no feasible restrictions here 
    stringBuffer.append(TEXT_259);
    
		}
		
		
// 4. CompleteIncomingCommand

		if (generateCompleteIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_260);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_261);
     // check that source is valid 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_264);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_265);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_267);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_269);
    				} else {
    stringBuffer.append(TEXT_270);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
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
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_283);
    			} // end of constraints 
     // create semantic command 
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_289);
    
		}
	}
}

    stringBuffer.append(TEXT_290);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_291);
    return stringBuffer.toString();
  }
}