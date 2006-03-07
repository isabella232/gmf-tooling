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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends ";
  protected final String TEXT_9 = " {";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_13 = " getCreateCommand(";
  protected final String TEXT_14 = " req) {";
  protected final String TEXT_15 = NL + "\t\tif (";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " == req.getElementType()) {";
  protected final String TEXT_18 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_19 = " container = (";
  protected final String TEXT_20 = ") (req.getContainer() instanceof ";
  protected final String TEXT_21 = " ? ((";
  protected final String TEXT_22 = ") req.getContainer()).getElement() : req.getContainer());";
  protected final String TEXT_23 = NL + "\t\t\tif (";
  protected final String TEXT_24 = " != null) {";
  protected final String TEXT_25 = NL + "\t\t\tif (";
  protected final String TEXT_26 = ".size() >= ";
  protected final String TEXT_27 = ") {";
  protected final String TEXT_28 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_29 = NL + "\t\t\tif (";
  protected final String TEXT_30 = " != null) {";
  protected final String TEXT_31 = NL + "\t\t\tif (";
  protected final String TEXT_32 = ".size() >= ";
  protected final String TEXT_33 = ") {";
  protected final String TEXT_34 = NL + "\t\t\t\treturn super.getCreateCommand(req);" + NL + "\t\t\t}";
  protected final String TEXT_35 = NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_36 = ".eINSTANCE.get";
  protected final String TEXT_37 = "());" + NL + "\t\t\t}";
  protected final String TEXT_38 = NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_39 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_40 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_41 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_42 = "Command extends ";
  protected final String TEXT_43 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_44 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_45 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_46 = ".eINSTANCE.get";
  protected final String TEXT_47 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_48 = " getElementToEdit() {" + NL + "\t\t\t";
  protected final String TEXT_49 = " container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof ";
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
  protected final String TEXT_72 = " resource = ((CreateElementRequest) getRequest()).getContainer().eResource();" + NL + "\t\t\t//if (resource == null) {" + NL + "\t\t\t//\treturn null;" + NL + "\t\t\t//}" + NL + "\t\t\t";
  protected final String TEXT_73 = " resource = getElementToEdit().eResource();" + NL + "\t\t\t";
  protected final String TEXT_74 = " eClass = getElementType().getEClass();" + NL + "\t\t\t";
  protected final String TEXT_75 = " helper = ";
  protected final String TEXT_76 = ".getHelper(resource);" + NL + "\t\t\t";
  protected final String TEXT_77 = " eObject;" + NL + "\t\t\tif (helper != null) {" + NL + "\t\t\t\teObject = helper.create(eClass);" + NL + "\t\t\t} else {" + NL + "\t\t\t\teObject = eClass.getEPackage().getEFactoryInstance().create(eClass);" + NL + "\t\t\t}" + NL + "\t\t\tresource.getContents().add(eObject);" + NL + "\t\t\treturn eObject;" + NL + "\t\t}";
  protected final String TEXT_78 = NL + "\t}";
  protected final String TEXT_79 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new DestroyElementCommand(req) {" + NL + "\t\t" + NL + "\t\t\tprotected EObject getElementToDestroy() {" + NL + "\t\t\t\tView view = (View) getHost().getModel();" + NL + "\t\t\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\t\tif (annotation != null) {" + NL + "\t\t\t\t\treturn view;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.getElementToDestroy();" + NL + "\t\t\t}\t\t" + NL;
  protected final String TEXT_80 = NL + "\t\t\tprotected ";
  protected final String TEXT_81 = " doExecuteWithResult(";
  protected final String TEXT_82 = " progressMonitor, ";
  protected final String TEXT_83 = " info) throws ";
  protected final String TEXT_84 = " {" + NL + "\t\t\t\tEObject eObject = getElementToDestroy();" + NL + "\t\t\t\tboolean removeFromResource = eObject.eContainer() == null;" + NL + "\t\t\t\t";
  protected final String TEXT_85 = " result = super.doExecuteWithResult(progressMonitor, info);" + NL + "\t\t\t\t";
  protected final String TEXT_86 = " resource = eObject.eResource();" + NL + "\t\t\t\tif (removeFromResource && resource != null) {" + NL + "\t\t\t\t\tresource.getContents().remove(eObject);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}";
  protected final String TEXT_87 = NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_88 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_89 = NL + "\t\tif (";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? ";
  protected final String TEXT_92 = " : ";
  protected final String TEXT_93 = ";" + NL + "\t\t}";
  protected final String TEXT_94 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_95 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_96 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_97 = NL + "\t\t";
  protected final String TEXT_98 = " element = (";
  protected final String TEXT_99 = ") getSemanticElement();";
  protected final String TEXT_100 = NL + "\t\t";
  protected final String TEXT_101 = " element = (";
  protected final String TEXT_102 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_103 = ".eINSTANCE.get";
  protected final String TEXT_104 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_105 = ".INSTANCE;" + NL + "\t\t}";
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
  protected final String TEXT_120 = NL + "\t\tif(!";
  protected final String TEXT_121 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_122 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_123 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_124 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_125 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_126 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_127 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_128 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_129 = NL + "\t\tfinal ";
  protected final String TEXT_130 = " element = (";
  protected final String TEXT_131 = ") getSemanticElement();";
  protected final String TEXT_132 = NL + "\t\tfinal ";
  protected final String TEXT_133 = " element = (";
  protected final String TEXT_134 = ") getRelationshipContainer(getSemanticElement()," + NL + "\t\t\t";
  protected final String TEXT_135 = ".eINSTANCE.get";
  protected final String TEXT_136 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_137 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_138 = NL + "\t\tif (";
  protected final String TEXT_139 = " != null) {";
  protected final String TEXT_140 = NL + "\t\tif (";
  protected final String TEXT_141 = ".size() >= ";
  protected final String TEXT_142 = ") {";
  protected final String TEXT_143 = NL + "\t\t\treturn ";
  protected final String TEXT_144 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_145 = NL + "\t\tif (";
  protected final String TEXT_146 = " != null) {";
  protected final String TEXT_147 = NL + "\t\tif (";
  protected final String TEXT_148 = ".size() >= ";
  protected final String TEXT_149 = ") {";
  protected final String TEXT_150 = NL + "\t\t\treturn ";
  protected final String TEXT_151 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_152 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_153 = ".eINSTANCE.get";
  protected final String TEXT_154 = "());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_155 = NL + "\t\tif(!";
  protected final String TEXT_156 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_157 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_158 = "\t\t\t\t" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_159 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_160 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_161 = "Command extends ";
  protected final String TEXT_162 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_163 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_164 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_165 = ".eINSTANCE.get";
  protected final String TEXT_166 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_167 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_168 = " doDefaultElementCreation() {";
  protected final String TEXT_169 = NL + "\t\t\t";
  protected final String TEXT_170 = " newElement = (";
  protected final String TEXT_171 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_172 = "(";
  protected final String TEXT_173 = ") getSource());";
  protected final String TEXT_174 = NL + "\t\t\t\t";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = ") getTarget());";
  protected final String TEXT_177 = NL + "\t\t\t\t";
  protected final String TEXT_178 = " container = (";
  protected final String TEXT_179 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_180 = NL + "\t\t\t\t\t";
  protected final String TEXT_181 = " featureValues = container.";
  protected final String TEXT_182 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_183 = NL + "\t\t\t\t \t";
  protected final String TEXT_184 = "newElement);";
  protected final String TEXT_185 = NL + "\t\t\t\t}";
  protected final String TEXT_186 = NL + "\t\t\t\t";
  protected final String TEXT_187 = ".Initializers.";
  protected final String TEXT_188 = ".init(newElement);";
  protected final String TEXT_189 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_190 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_191 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_192 = NL + "\t\tif(!";
  protected final String TEXT_193 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_194 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_195 = "\t";
  protected final String TEXT_196 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_197 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_198 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_199 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_200 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_201 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_202 = NL + "\t\tfinal ";
  protected final String TEXT_203 = " element = (";
  protected final String TEXT_204 = ") req.getSource();";
  protected final String TEXT_205 = NL + "\t\tfinal ";
  protected final String TEXT_206 = " element = (";
  protected final String TEXT_207 = ") getRelationshipContainer(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_208 = ".eINSTANCE.get";
  protected final String TEXT_209 = "(), req.getElementType());" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_210 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_211 = NL + "\t\tif (";
  protected final String TEXT_212 = " != null) {";
  protected final String TEXT_213 = NL + "\t\tif (";
  protected final String TEXT_214 = ".size() >= ";
  protected final String TEXT_215 = ") {";
  protected final String TEXT_216 = NL + "\t\t\treturn ";
  protected final String TEXT_217 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_218 = NL + "\t\tif (";
  protected final String TEXT_219 = " != null) {";
  protected final String TEXT_220 = NL + "\t\tif (";
  protected final String TEXT_221 = ".size() >= ";
  protected final String TEXT_222 = ") {";
  protected final String TEXT_223 = NL + "\t\t\treturn ";
  protected final String TEXT_224 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_225 = NL + "\t\tif(!";
  protected final String TEXT_226 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_227 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_228 = "\t\t";
  protected final String TEXT_229 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_230 = ".eINSTANCE.get";
  protected final String TEXT_231 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_232 = "Command(req) {" + NL + "" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected ";
  protected final String TEXT_233 = " getElementToEdit() {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_234 = "Command extends ";
  protected final String TEXT_235 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_236 = "Command(CreateRelationshipRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_237 = " getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_238 = ".eINSTANCE.get";
  protected final String TEXT_239 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void setElementToEdit(";
  protected final String TEXT_240 = " element) {" + NL + "\t\t\tthrow new UnsupportedOperationException();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_241 = " doDefaultElementCreation() {";
  protected final String TEXT_242 = NL + "\t\t\t";
  protected final String TEXT_243 = " newElement = (";
  protected final String TEXT_244 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_245 = "(";
  protected final String TEXT_246 = ") getTarget());";
  protected final String TEXT_247 = NL + "\t\t\t\t";
  protected final String TEXT_248 = "(";
  protected final String TEXT_249 = ") getSource());";
  protected final String TEXT_250 = NL + "\t\t\t\t";
  protected final String TEXT_251 = " container = (";
  protected final String TEXT_252 = ") getElementToEdit();" + NL + "\t\t\t\tif (container != null) {";
  protected final String TEXT_253 = NL + "\t\t\t\t\t";
  protected final String TEXT_254 = " featureValues = container.";
  protected final String TEXT_255 = "();" + NL + "\t\t\t\t\tfeatureValues.add(newElement);";
  protected final String TEXT_256 = NL + "\t\t\t\t \t";
  protected final String TEXT_257 = "newElement);";
  protected final String TEXT_258 = NL + "\t\t\t\t}";
  protected final String TEXT_259 = NL + "\t\t\t\t";
  protected final String TEXT_260 = ".Initializers.";
  protected final String TEXT_261 = ".init(newElement);";
  protected final String TEXT_262 = NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_263 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_264 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_265 = NL + "\t\t";
  protected final String TEXT_266 = " element = (";
  protected final String TEXT_267 = ") getSemanticElement();";
  protected final String TEXT_268 = NL + "\t\tif (";
  protected final String TEXT_269 = " != null) {";
  protected final String TEXT_270 = NL + "\t\tif (";
  protected final String TEXT_271 = ".size() >= ";
  protected final String TEXT_272 = ") {";
  protected final String TEXT_273 = NL + "\t\t\treturn ";
  protected final String TEXT_274 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_275 = NL + "\t\tif(!";
  protected final String TEXT_276 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_277 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_278 = NL;
  protected final String TEXT_279 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_280 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_281 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_282 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_283 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_284 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_285 = NL + "\t\t";
  protected final String TEXT_286 = " element = (";
  protected final String TEXT_287 = ") getSemanticElement();";
  protected final String TEXT_288 = NL + "\t\tif (";
  protected final String TEXT_289 = " != null) {";
  protected final String TEXT_290 = NL + "\t\tif (";
  protected final String TEXT_291 = ".size() >= ";
  protected final String TEXT_292 = NL + "\t\t\t|| ";
  protected final String TEXT_293 = ".contains(req.getSource())";
  protected final String TEXT_294 = NL + "\t\t\t\t) {";
  protected final String TEXT_295 = NL + "\t\t\treturn ";
  protected final String TEXT_296 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_297 = NL + "\t\t";
  protected final String TEXT_298 = " element = (";
  protected final String TEXT_299 = ") getSemanticElement();" + NL + "\t\tif (";
  protected final String TEXT_300 = ".contains(req.getSource())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_301 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_302 = NL + "\t\tif(!";
  protected final String TEXT_303 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_304 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_305 = "\t\t";
  protected final String TEXT_306 = NL + "\t\t";
  protected final String TEXT_307 = " setReq = new ";
  protected final String TEXT_308 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_309 = ".eINSTANCE.get";
  protected final String TEXT_310 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_311 = "(setReq));" + NL + "\t}";
  protected final String TEXT_312 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_313 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_314 = NL + "\t\tif(!";
  protected final String TEXT_315 = ".canCreateLink(req, true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_316 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_317 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_318 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_319 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_320 = NL + "\t\tif (!(req.getSource() instanceof ";
  protected final String TEXT_321 = ")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_322 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_323 = NL + "\t\t";
  protected final String TEXT_324 = " element = (";
  protected final String TEXT_325 = ") req.getSource();";
  protected final String TEXT_326 = NL + "\t\tif (";
  protected final String TEXT_327 = " != null) {";
  protected final String TEXT_328 = NL + "\t\tif (";
  protected final String TEXT_329 = ".size() >= ";
  protected final String TEXT_330 = NL + "\t\t\t|| ";
  protected final String TEXT_331 = ".contains(req.getTarget())";
  protected final String TEXT_332 = NL + "\t\t\t\t) {";
  protected final String TEXT_333 = NL + "\t\t\treturn ";
  protected final String TEXT_334 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_335 = NL + "\t\t";
  protected final String TEXT_336 = " element = (";
  protected final String TEXT_337 = ") req.getSource();" + NL + "\t\tif (";
  protected final String TEXT_338 = ".contains(req.getTarget())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_339 = ".INSTANCE;" + NL + "\t\t}";
  protected final String TEXT_340 = NL + "\t\tif(!";
  protected final String TEXT_341 = ".canCreateLink(req, false)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_342 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_343 = NL + "\t\t";
  protected final String TEXT_344 = " setReq = new ";
  protected final String TEXT_345 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_346 = ".eINSTANCE.get";
  protected final String TEXT_347 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_348 = "(setReq));" + NL + "\t}";
  protected final String TEXT_349 = NL + "}";
  protected final String TEXT_350 = NL;

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
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genNode.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    
if (genNode.getChildNodes().size() > 0) {
	Collection childNodes = genNode.getChildNodes();
	GenClass containerGenClass = genNode.getModelFacet().getMetaClass();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest"));
    stringBuffer.append(TEXT_14);
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_17);
    
	TypeModelFacet modelFacet = genChildNode.getModelFacet();
	GenFeature containmentMetaFeature = modelFacet.getContainmentMetaFeature();
	GenFeature childMetaFeature = modelFacet.getChildMetaFeature();
	if (!modelFacet.isPhantomElement()) {
		int upperContainmentBound = containmentMetaFeature.getEcoreFeature().getUpperBound();
		int upperChildBound = childMetaFeature.getEcoreFeature().getUpperBound();
		boolean processChildMetafeature = !childMetaFeature.equals(containmentMetaFeature) && upperChildBound > 0;
		if (upperContainmentBound > 0 || processChildMetafeature) {
			String containerInterfaceName = importManager.getImportedName(containerGenClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_18);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(containerInterfaceName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_22);
    
			if (upperContainmentBound > 0) {
				if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_24);
    
				} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(getFeatureValueGetter("container", containmentMetaFeature, false, importManager));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_27);
    
				}

    stringBuffer.append(TEXT_28);
    
			}
		
			if (processChildMetafeature) {
				if (upperChildBound == 1) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_30);
    
				} else {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_33);
    
				}

    stringBuffer.append(TEXT_34);
    
			}
		}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_37);
    
	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    
}

    stringBuffer.append(TEXT_40);
    
for (Iterator nodes = childNodes.iterator(); nodes.hasNext(); ) {
	GenNode genChildNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genChildNode.getModelFacet();

    stringBuffer.append(TEXT_41);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(containerGenClass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(containerGenClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.resources.IResourceHelper"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.internal.util.Util"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_77);
    
	}

    stringBuffer.append(TEXT_78);
    }
    }
    stringBuffer.append(TEXT_79);
    	if (genNode.getModelFacet().isPhantomElement()) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.commands.ExecutionException"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_86);
    	}
    stringBuffer.append(TEXT_87);
    
GenClass nodeMetaClass = genNode.getModelFacet().getMetaClass();
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_88);
    
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
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		incomingClass = metaFeature.getTypeGenClass();
		namePartSuffix = metaFeature.getFeatureAccessorName();
	} else {
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

    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(startCommandGetter);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(endCommandGetter);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    
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

    stringBuffer.append(TEXT_95);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_96);
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
				if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_99);
    				} else {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_105);
    
				}
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

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_122);
    			} // end of link constraints 
     // create always executable command 
    stringBuffer.append(TEXT_123);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_124);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_125);
     // check that source is valid 
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_128);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_131);
    			} else {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_137);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_139);
    					} else {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_142);
    					}
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_144);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_146);
    					} else {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_149);
    					}
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_151);
    
				}
			}

     // create semantic command 
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_154);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_157);
    			} // end of link constraints 
    stringBuffer.append(TEXT_158);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_168);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_173);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_176);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_179);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_182);
    				} else {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_184);
    				}
    stringBuffer.append(TEXT_185);
    
			}
			if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_188);
    			}
    stringBuffer.append(TEXT_189);
    
		}
			
			
// 3. StartIncomingCommand
			
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_190);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_191);
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_194);
    			} // end of link constraints 
    stringBuffer.append(TEXT_195);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_196);
    
		}
		
		
// 4. CompleteIncomingCommand
		
		if (generateCompleteIncomingCommand) {	
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_197);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_198);
     // check that source is valid 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_201);
    
			String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
			if (modelFacet.getSourceMetaFeature() == null) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_204);
    				} else {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_210);
    			}
     // check that containment feature is not set / has capacity for the new element 
    
			if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
				if (upperContainmentBound > 0) {
					if (upperContainmentBound == 1) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_212);
    					} else {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(getFeatureValueGetter("element", containmentFeature, false, importManager));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_215);
    					}
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_217);
    
				}
				if (checkChildFeatureUpperBound) {
					if (upperChildBound == 1) {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_219);
    					} else {
    stringBuffer.append(TEXT_220);
    stringBuffer.append(getFeatureValueGetter("element", childFeature, false, importManager));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_222);
    					}
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_224);
    
				}
			}

    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_227);
    			} // end of constraints 
    stringBuffer.append(TEXT_228);
     // create semantic command 
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_241);
    			String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getTargetMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_246);
    			if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(getFeatureValueSetterPrefix("newElement", modelFacet.getSourceMetaFeature(), false, importManager));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_249);
    
			}
			if (processChildFeature) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_252);
    				if (childFeature.isListType()) {
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(childFeature.getGetAccessor());
    stringBuffer.append(TEXT_255);
    				} else {
    stringBuffer.append(TEXT_256);
    stringBuffer.append(getFeatureValueSetterPrefix("container", childFeature, false, importManager));
    stringBuffer.append(TEXT_257);
    				}
    stringBuffer.append(TEXT_258);
    
			}
				if (modelFacet.getModelElementInitializer() != null) { 

    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_261);
    			}
    stringBuffer.append(TEXT_262);
    
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

    stringBuffer.append(TEXT_263);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_264);
     // check that feature is not set / has capacity for the new value 
    
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
    				}
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_274);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_277);
    			} // end of link constraints 
    stringBuffer.append(TEXT_278);
     // create always executable command 
    stringBuffer.append(TEXT_279);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_280);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_281);
     // check that source is valid 
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_284);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_285);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_287);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_288);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_289);
    				} else {
    stringBuffer.append(TEXT_290);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_292);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_293);
    				}
    stringBuffer.append(TEXT_294);
    			}
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_296);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_297);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_301);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_304);
    			} // end of constraints 
    stringBuffer.append(TEXT_305);
     // create semantic command 
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_311);
    
		}
		
		
// 3. StartIncomingCommand
		
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_312);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_313);
    			if(genLink.getCreationConstraints() != null) { 
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_316);
    			} // end of link constraints 
     // no feasible restrictions here 
    stringBuffer.append(TEXT_317);
    
		}
		
		
// 4. CompleteIncomingCommand

		if (generateCompleteIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_318);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_319);
     // check that source is valid 
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_322);
     // check that feature is not set / has capacity for the new value / is unique 
    
			if (upperBound > 0) { // consider UNBOUNDED_MULTIPLICITY and UNSPECIFIED_MULTIPLICITY
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_323);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_325);
    				if (upperBound == 1) {
    stringBuffer.append(TEXT_326);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_327);
    				} else {
    stringBuffer.append(TEXT_328);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(upperBound);
    					if (metaFeature.getEcoreFeature().isUnique()) {
    stringBuffer.append(TEXT_330);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_331);
    					}
    stringBuffer.append(TEXT_332);
    				}
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_334);
    
			} else if (metaFeature.getEcoreFeature().isUnique()) {
				String outgoingClassName = importManager.getImportedName(outgoingClass.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_335);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(outgoingClassName);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(getFeatureValueGetter("element", metaFeature, false, importManager));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_339);
    			}
    			if(linkConstraints != null) { 
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_342);
    			} // end of constraints 
     // create semantic command 
    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_348);
    
		}
	}
}

    stringBuffer.append(TEXT_349);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_350);
    return stringBuffer.toString();
  }
}