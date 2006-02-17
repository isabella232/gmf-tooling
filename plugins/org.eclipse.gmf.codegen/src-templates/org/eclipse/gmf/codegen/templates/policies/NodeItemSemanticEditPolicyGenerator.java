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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
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
  protected final String TEXT_34 = "());" + NL + "\t\t\t}";
  protected final String TEXT_35 = NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_36 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_37 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_38 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_39 = "Command extends ";
  protected final String TEXT_40 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_41 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_42 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_43 = ".eINSTANCE.get";
  protected final String TEXT_44 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_45 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_46 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
  protected final String TEXT_47 = ") {" + NL + "\t\t\t\tcontainer = ((";
  protected final String TEXT_48 = ") container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_49 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_50 = " doDefaultElementCreation() {" + NL + "\t\t\t";
  protected final String TEXT_51 = " newElement = (";
  protected final String TEXT_52 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {";
  protected final String TEXT_53 = NL + "\t\t\t\t ";
  protected final String TEXT_54 = " container = (";
  protected final String TEXT_55 = ") getElementToEdit();" + NL + "\t\t\t\t if (container != null) {";
  protected final String TEXT_56 = NL + "\t\t\t\t\t";
  protected final String TEXT_57 = " featureValues = container.";
  protected final String TEXT_58 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_59 = NL + "\t\t\t\t \t";
  protected final String TEXT_60 = "newElement);";
  protected final String TEXT_61 = NL + "\t\t\t\t }";
  protected final String TEXT_62 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_63 = ".Initializers.";
  protected final String TEXT_64 = ".init(newElement);";
  protected final String TEXT_65 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_66 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isExecutable() {" + NL + "\t\t\tif (getEClass() != null) {" + NL + "\t\t\t\treturn getEClass().isSuperTypeOf(getEClassToEdit());" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_67 = " getContainmentFeature() {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_68 = " doDefaultElementCreation() {" + NL + "\t\t\t// Uncomment to put \"phantom\" objects into the diagram file.\t\t" + NL + "\t\t\t//";
  protected final String TEXT_69 = " resource = ((CreateElementRequest) getRequest()).getContainer().eResource();" + NL + "\t\t\t//if (resource == null) {" + NL + "\t\t\t//\treturn null;" + NL + "\t\t\t//}" + NL + "\t\t\t";
  protected final String TEXT_70 = " resource = getElementToEdit().eResource();" + NL + "\t\t\t";
  protected final String TEXT_71 = " eClass = getElementType().getEClass();" + NL + "\t\t\t";
  protected final String TEXT_72 = " domain = (";
  protected final String TEXT_73 = ") ";
  protected final String TEXT_74 = ".getEditingDomain(resource);" + NL + "\t\t\tif (domain == null) {" + NL + "\t\t\t\tdomain = (";
  protected final String TEXT_75 = ") ";
  protected final String TEXT_76 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_77 = " eObject = ";
  protected final String TEXT_78 = ".create(domain, eClass, true);" + NL + "\t\t\tresource.getContents().add(eObject);" + NL + "\t\t\treturn eObject;" + NL + "\t\t}";
  protected final String TEXT_79 = NL + "\t}";
  protected final String TEXT_80 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new DestroyElementCommand(req) {" + NL + "\t\t" + NL + "\t\t\tprotected EObject getElementToDestroy() {" + NL + "\t\t\t\tView view = (View) getHost().getModel();" + NL + "\t\t\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcutted\"); //$NON-NLS-1$" + NL + "\t\t\t\tif (annotation != null) {" + NL + "\t\t\t\t\treturn view;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.getElementToDestroy();" + NL + "\t\t\t}\t\t" + NL;
  protected final String TEXT_81 = NL + "\t\t\tprotected ";
  protected final String TEXT_82 = " doExecuteWithResult(";
  protected final String TEXT_83 = " progressMonitor, ";
  protected final String TEXT_84 = " info) throws ";
  protected final String TEXT_85 = " {" + NL + "\t\t\t\tEObject eObject = getElementToDestroy();" + NL + "\t\t\t\tif (eObject.eContainer() != null) {" + NL + "\t\t\t\t\treturn super.doExecuteWithResult(progressMonitor, info);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_86 = " elementState = ";
  protected final String TEXT_87 = ".getState(eObject);" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_88 = ".DETACHED != elementState) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = " resource = eObject.eResource();" + NL + "\t\t\t\t\t\tif (resource == null) {" + NL + "\t\t\t\t\t\t\treturn CommandResult.newErrorCommandResult(\"No resource for the object: \" + eObject);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = " domain = (";
  protected final String TEXT_91 = ") ";
  protected final String TEXT_92 = ".getEditingDomain(resource);" + NL + "\t\t\t\t\t\tif (domain == null) {" + NL + "\t\t\t\t\t\t\tdomain = (";
  protected final String TEXT_93 = ") ";
  protected final String TEXT_94 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_95 = " metaModel = ";
  protected final String TEXT_96 = ".getMetaModel(eObject);" + NL + "\t\t\t\t\t\tif ((metaModel != null) && (!metaModel.canDestroy(eObject))) {" + NL + "\t\t\t\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\teObject.eNotify(new ";
  protected final String TEXT_97 = "((";
  protected final String TEXT_98 = ") eObject, ";
  protected final String TEXT_99 = ".PRE_DESTROY, (";
  protected final String TEXT_100 = ") null, eObject, eObject));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_101 = ".teardownContainment(domain, eObject, 0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_102 = ".sendDestroyEvent(domain, eObject);" + NL + "\t\t\t\t\t\tresource.getContents().remove(eObject);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}";
  protected final String TEXT_103 = NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_104 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_105 = NL + "\t\tif (";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? ";
  protected final String TEXT_108 = " : ";
  protected final String TEXT_109 = ";" + NL + "\t\t}";
  protected final String TEXT_110 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_111 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_112 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = " element = (";
  protected final String TEXT_115 = ") getSemanticElement();";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = " element = (";
  protected final String TEXT_118 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_119 = ".eINSTANCE.get";
  protected final String TEXT_120 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_121 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_122 = NL + "\t\tif (";
  protected final String TEXT_123 = " != null) {";
  protected final String TEXT_124 = NL + "\t\tif (";
  protected final String TEXT_125 = ".size() >= ";
  protected final String TEXT_126 = ") {";
  protected final String TEXT_127 = NL + "\t\t\treturn ";
  protected final String TEXT_128 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_129 = NL + "\t\tif (";
  protected final String TEXT_130 = " != null) {";
  protected final String TEXT_131 = NL + "\t\tif (";
  protected final String TEXT_132 = ".size() >= ";
  protected final String TEXT_133 = ") {";
  protected final String TEXT_134 = NL + "\t\t\treturn ";
  protected final String TEXT_135 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_136 = NL + "\t\tif(!";
  protected final String TEXT_137 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_138 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_139 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_140 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_141 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_142 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_143 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_144 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_145 = NL + "\t\tfinal ";
  protected final String TEXT_146 = " element = (";
  protected final String TEXT_147 = ") getSemanticElement();";
  protected final String TEXT_148 = NL + "\t\tfinal ";
  protected final String TEXT_149 = " element = (";
  protected final String TEXT_150 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_151 = ".eINSTANCE.get";
  protected final String TEXT_152 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_153 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_154 = NL + "\t\tif (";
  protected final String TEXT_155 = " != null) {";
  protected final String TEXT_156 = NL + "\t\tif (";
  protected final String TEXT_157 = ".size() >= ";
  protected final String TEXT_158 = ") {";
  protected final String TEXT_159 = NL + "\t\t\treturn ";
  protected final String TEXT_160 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_161 = NL + "\t\tif (";
  protected final String TEXT_162 = " != null) {";
  protected final String TEXT_163 = NL + "\t\tif (";
  protected final String TEXT_164 = ".size() >= ";
  protected final String TEXT_165 = ") {";
  protected final String TEXT_166 = NL + "\t\t\treturn ";
  protected final String TEXT_167 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_168 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_169 = ".eINSTANCE.get";
  protected final String TEXT_170 = "());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_171 = NL + "\t\tif(!";
  protected final String TEXT_172 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_173 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_174 = "\t\t\t\t" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_175 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_176 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_177 = "Command extends ";
  protected final String TEXT_178 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_179 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_180 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_181 = ".eINSTANCE.get";
  protected final String TEXT_182 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_183 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_184 = " doDefaultElementCreation() {";
  protected final String TEXT_185 = NL + "\t\t\t";
  protected final String TEXT_186 = " newElement = (";
  protected final String TEXT_187 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_188 = "(";
  protected final String TEXT_189 = ") getSource());";
  protected final String TEXT_190 = NL + "\t\t\t\t";
  protected final String TEXT_191 = "(";
  protected final String TEXT_192 = ") getTarget());";
  protected final String TEXT_193 = NL + "\t\t\t\t";
  protected final String TEXT_194 = " container = (";
  protected final String TEXT_195 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_196 = NL + "\t\t\t\t\t";
  protected final String TEXT_197 = " featureValues = container.";
  protected final String TEXT_198 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_199 = NL + "\t\t\t\t \t";
  protected final String TEXT_200 = "newElement);";
  protected final String TEXT_201 = NL + "\t\t\t\t}";
  protected final String TEXT_202 = NL + "\t\t\t\t";
  protected final String TEXT_203 = ".Initializers.";
  protected final String TEXT_204 = ".init(newElement);";
  protected final String TEXT_205 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_206 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_207 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_208 = NL + "\t\tif(!";
  protected final String TEXT_209 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_210 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_211 = "\t";
  protected final String TEXT_212 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_213 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_214 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_215 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_216 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_217 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_218 = NL + "\t\tfinal ";
  protected final String TEXT_219 = " element = (";
  protected final String TEXT_220 = ") req.getSource();";
  protected final String TEXT_221 = NL + "\t\tfinal ";
  protected final String TEXT_222 = " element = (";
  protected final String TEXT_223 = ") getRelationshipContainer(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_224 = ".eINSTANCE.get";
  protected final String TEXT_225 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_226 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_227 = NL + "\t\tif (";
  protected final String TEXT_228 = " != null) {";
  protected final String TEXT_229 = NL + "\t\tif (";
  protected final String TEXT_230 = ".size() >= ";
  protected final String TEXT_231 = ") {";
  protected final String TEXT_232 = NL + "\t\t\treturn ";
  protected final String TEXT_233 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_234 = NL + "\t\tif (";
  protected final String TEXT_235 = " != null) {";
  protected final String TEXT_236 = NL + "\t\tif (";
  protected final String TEXT_237 = ".size() >= ";
  protected final String TEXT_238 = ") {";
  protected final String TEXT_239 = NL + "\t\t\treturn ";
  protected final String TEXT_240 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_241 = NL + "\t\tif(!";
  protected final String TEXT_242 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_243 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_244 = "\t\t";
  protected final String TEXT_245 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_246 = ".eINSTANCE.get";
  protected final String TEXT_247 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_248 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_249 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_250 = "Command extends ";
  protected final String TEXT_251 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_252 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_253 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_254 = ".eINSTANCE.get";
  protected final String TEXT_255 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_256 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_257 = " doDefaultElementCreation() {";
  protected final String TEXT_258 = NL + "\t\t\t";
  protected final String TEXT_259 = " newElement = (";
  protected final String TEXT_260 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_261 = "(";
  protected final String TEXT_262 = ") getTarget());";
  protected final String TEXT_263 = NL + "\t\t\t\t";
  protected final String TEXT_264 = "(";
  protected final String TEXT_265 = ") getSource());";
  protected final String TEXT_266 = NL + "\t\t\t\t";
  protected final String TEXT_267 = " container = (";
  protected final String TEXT_268 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_269 = NL + "\t\t\t\t\t";
  protected final String TEXT_270 = " featureValues = container.";
  protected final String TEXT_271 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_272 = NL + "\t\t\t\t \t";
  protected final String TEXT_273 = "newElement);";
  protected final String TEXT_274 = NL + "\t\t\t\t}";
  protected final String TEXT_275 = NL + "\t\t\t\t";
  protected final String TEXT_276 = ".Initializers.";
  protected final String TEXT_277 = ".init(newElement);";
  protected final String TEXT_278 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_279 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_280 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_281 = NL + "\t\t";
  protected final String TEXT_282 = " element = (";
  protected final String TEXT_283 = ") getSemanticElement();";
  protected final String TEXT_284 = NL + "\t\tif (";
  protected final String TEXT_285 = " != null) {";
  protected final String TEXT_286 = NL + "\t\tif (";
  protected final String TEXT_287 = ".size() >= ";
  protected final String TEXT_288 = ") {";
  protected final String TEXT_289 = NL + "\t\t\treturn ";
  protected final String TEXT_290 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_291 = NL + "\t\tif(!";
  protected final String TEXT_292 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_293 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_294 = NL;
  protected final String TEXT_295 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_296 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_297 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_298 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_299 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_300 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_301 = NL + "\t\t";
  protected final String TEXT_302 = " element = (";
  protected final String TEXT_303 = ") getSemanticElement();";
  protected final String TEXT_304 = NL + "\t\tif (";
  protected final String TEXT_305 = " != null) {";
  protected final String TEXT_306 = NL + "\t\tif (";
  protected final String TEXT_307 = ".size() >= ";
  protected final String TEXT_308 = NL + "\t\t\t|| ";
  protected final String TEXT_309 = ".contains(req.getSource())";
  protected final String TEXT_310 = NL + "\t\t\t\t) {";
  protected final String TEXT_311 = NL + "\t\t\treturn ";
  protected final String TEXT_312 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_313 = NL + "\t\t";
  protected final String TEXT_314 = " element = (";
  protected final String TEXT_315 = ") getSemanticElement();" + NL + "\t\tif (";
  protected final String TEXT_316 = ".contains(req.getSource())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_317 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_318 = NL + "\t\tif(!";
  protected final String TEXT_319 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_320 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_321 = "\t\t";
  protected final String TEXT_322 = NL + "\t\t";
  protected final String TEXT_323 = " setReq = new ";
  protected final String TEXT_324 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_325 = ".eINSTANCE.get";
  protected final String TEXT_326 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_327 = "(setReq));" + NL + "\t}";
  protected final String TEXT_328 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_329 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_330 = NL + "\t\tif(!";
  protected final String TEXT_331 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_332 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_333 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_334 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_335 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_336 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_337 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_338 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_339 = NL + "\t\t";
  protected final String TEXT_340 = " element = (";
  protected final String TEXT_341 = ") req.getSource();";
  protected final String TEXT_342 = NL + "\t\tif (";
  protected final String TEXT_343 = " != null) {";
  protected final String TEXT_344 = NL + "\t\tif (";
  protected final String TEXT_345 = ".size() >= ";
  protected final String TEXT_346 = NL + "\t\t\t|| ";
  protected final String TEXT_347 = ".contains(req.getTarget())";
  protected final String TEXT_348 = NL + "\t\t\t\t) {";
  protected final String TEXT_349 = NL + "\t\t\treturn ";
  protected final String TEXT_350 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_351 = NL + "\t\t";
  protected final String TEXT_352 = " element = (";
  protected final String TEXT_353 = ") req.getSource();" + NL + "\t\tif (";
  protected final String TEXT_354 = ".contains(req.getTarget())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_355 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_356 = NL + "\t\tif(!";
  protected final String TEXT_357 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_358 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_359 = NL + "\t\t";
  protected final String TEXT_360 = " setReq = new ";
  protected final String TEXT_361 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_362 = ".eINSTANCE.get";
  protected final String TEXT_363 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_364 = "(setReq));" + NL + "\t}";
  protected final String TEXT_365 = NL + "}";
  protected final String TEXT_366 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
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
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) ((Object[]) argument)[0];
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
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    
	TypeModelFacet modelFacet = genChildNode.getModelFacet();
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	GenFeature childMetaFeature = modelFacet.getChildMetaFeature();
	if (!modelFacet.isPhantomElement()) {
		int upperContainmentBound = containmentMetaFeature.getEcoreFeature().getUpperBound();
		int upperChildBound = childMetaFeature.getEcoreFeature().getUpperBound();
		boolean processChildMetafeature = !childMetaFeature.equals(containmentMetaFeature) && upperChildBound > 0;
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
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_34);
    
	}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    
}

    stringBuffer.append(TEXT_37);
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_38);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(containerGenClass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(containerGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_48);
    
	boolean processChildMetafeature = !modelFacet.isPhantomElement() && !modelFacet.getChildMetaFeature().isDerived() && !modelFacet.getChildMetaFeature().equals(modelFacet.getContainmentMetaFeature());
	if (modelFacet.getModelElementInitializer() != null || processChildMetafeature) { 
		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_52);
    
		if (processChildMetafeature) {
			String containerMetaClass = importManager.getImportedName(modelFacet.getChildMetaFeature().getGenClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_53);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(containerMetaClass);
    stringBuffer.append(TEXT_55);
    
			if (modelFacet.getChildMetaFeature().isListType()) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(modelFacet.getChildMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_58);
    
			} else {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(getFeatureValueSetterPrefix("container", modelFacet.getChildMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_60);
    
			}

    stringBuffer.append(TEXT_61);
    
		}
		if (modelFacet.getModelElementInitializer() != null) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_64);
    
		}

    stringBuffer.append(TEXT_65);
    
	}
	
	if (modelFacet.isPhantomElement()) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EReference"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.util.MSLUtil"));
    stringBuffer.append(TEXT_78);
    
	}

    stringBuffer.append(TEXT_79);
    }
    }
    stringBuffer.append(TEXT_80);
    	if (genNode.getModelFacet().isPhantomElement()) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.commands.ExecutionException"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.edit.MObjectState"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectUtil"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.edit.MObjectState"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.domain.MSLEditingDomain"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.services.metamodel.IMetamodelSupport"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.util.MSLUtil"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.EventTypes"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.util.MSLUtil"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.util.MSLUtil"));
    stringBuffer.append(TEXT_102);
    	}
    stringBuffer.append(TEXT_103);
    
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_104);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	
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

    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(startCommandGetter);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(endCommandGetter);
    stringBuffer.append(TEXT_109);
    
}

    stringBuffer.append(TEXT_110);
    

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

    stringBuffer.append(TEXT_111);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_112);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
				if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_115);
    				} else {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_121);
    
				}
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_123);
    					} else {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_126);
    					}
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_128);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_130);
    					} else {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_133);
    					}
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_135);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_138);
    			} // end of link constraints 
     // create always executable command 
    stringBuffer.append(TEXT_139);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_140);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_141);
     // check that source is valid 
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_144);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_147);
    			} else {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_153);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_155);
    					} else {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_158);
    					}
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_160);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_162);
    					} else {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_165);
    					}
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_167);
    
				}
			}

     // create semantic command 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_170);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_173);
    			} // end of link constraints 
    stringBuffer.append(TEXT_174);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_184);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_189);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_192);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_195);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_198);
    				} else {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_200);
    				}
    stringBuffer.append(TEXT_201);
    
			}
			if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_204);
    			}
    stringBuffer.append(TEXT_205);
    
		}
			
			
// 3. StartIncomingCommand
			
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_206);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_207);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_210);
    			} // end of link constraints 
    stringBuffer.append(TEXT_211);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_212);
    
		}
		
		
// 4. CompleteIncomingCommand
		
		if (generateCompleteIncomingCommand) {	
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_213);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_214);
     // check that source is valid 
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_217);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_220);
    				} else {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_226);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_228);
    					} else {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_231);
    					}
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_233);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_234);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_235);
    					} else {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_238);
    					}
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_240);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_243);
    			} // end of constraints 
    stringBuffer.append(TEXT_244);
     // create semantic command 
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_257);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_262);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_263);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_265);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_268);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_271);
    				} else {
    stringBuffer.append(TEXT_272);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_273);
    				}
    stringBuffer.append(TEXT_274);
    
			}
				if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_277);
    			}
    stringBuffer.append(TEXT_278);
    
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

    stringBuffer.append(TEXT_279);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_280);
     // check that feature is not set / has capacity for the new value 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_281);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_283);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_284);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_285);
    				} else {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_288);
    				}
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_290);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_293);
    			} // end of link constraints 
    stringBuffer.append(TEXT_294);
     // create always executable command 
    stringBuffer.append(TEXT_295);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_296);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_297);
     // check that source is valid 
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_300);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_301);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_303);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_304);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_305);
    				} else {
    stringBuffer.append(TEXT_306);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_308);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_309);
    				}
    stringBuffer.append(TEXT_310);
    			}
    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_312);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_313);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_317);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_320);
    			} // end of constraints 
    stringBuffer.append(TEXT_321);
     // create semantic command 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_327);
    
		}
		
		
// 3. StartIncomingCommand
		
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_328);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_329);
    			if(genLink.getCreationConstraints() != null) { 
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_332);
    			} // end of link constraints 
     // no feasible restrictions here 
    stringBuffer.append(TEXT_333);
    
		}
		
		
// 4. CompleteIncomingCommand

		if (generateCompleteIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_334);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_335);
     // check that source is valid 
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_338);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_339);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_341);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_342);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_343);
    				} else {
    stringBuffer.append(TEXT_344);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_346);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_347);
    					}
    stringBuffer.append(TEXT_348);
    				}
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_350);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_351);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_355);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_358);
    			} // end of constraints 
     // create semantic command 
    stringBuffer.append(TEXT_359);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_364);
    
		}
	}
}

    stringBuffer.append(TEXT_365);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_366);
    return stringBuffer.toString();
  }
}