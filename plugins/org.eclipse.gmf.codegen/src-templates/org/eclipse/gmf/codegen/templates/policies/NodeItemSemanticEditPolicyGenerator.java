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
  protected final String TEXT_16 = "\t\t" + NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_17 = ".eINSTANCE.get";
  protected final String TEXT_18 = "());" + NL + "\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\treturn getMSLWrapper(new ";
  protected final String TEXT_20 = "(req));" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_22 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new DestroyElementCommand(req) {" + NL + "\t\t" + NL + "\t\t\tprotected EObject getElementToDestroy() {" + NL + "\t\t\t\tView view = (View) getHost().getModel();" + NL + "\t\t\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\t\tif (annotation != null) {" + NL + "\t\t\t\t\treturn view;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.getElementToDestroy();" + NL + "\t\t\t}\t\t" + NL;
  protected final String TEXT_23 = NL + "\t\t\tprotected ";
  protected final String TEXT_24 = " doExecuteWithResult(";
  protected final String TEXT_25 = " progressMonitor, ";
  protected final String TEXT_26 = " info) throws ";
  protected final String TEXT_27 = " {" + NL + "\t\t\t\tEObject eObject = getElementToDestroy();" + NL + "\t\t\t\tboolean removeFromResource = eObject.eContainer() == null;" + NL + "\t\t\t\t";
  protected final String TEXT_28 = " result = super.doExecuteWithResult(progressMonitor, info);" + NL + "\t\t\t\t";
  protected final String TEXT_29 = " resource = eObject.eResource();" + NL + "\t\t\t\tif (removeFromResource && resource != null) {" + NL + "\t\t\t\t\tresource.getContents().remove(eObject);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_31 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {";
  protected final String TEXT_32 = NL + "\t\tif (";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " == req.getElementType()) {" + NL + "\t\t\treturn req.getTarget() == null ? ";
  protected final String TEXT_35 = " : ";
  protected final String TEXT_36 = ";" + NL + "\t\t}";
  protected final String TEXT_37 = NL + "\t\treturn super.getCreateRelationshipCommand(req);" + NL + "\t}";
  protected final String TEXT_38 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_39 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = " sourceEObject = ";
  protected final String TEXT_42 = "req.getTarget()";
  protected final String TEXT_43 = "req.getSource()";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = " targetEObject = ";
  protected final String TEXT_47 = "req.getSource()";
  protected final String TEXT_48 = "req.getTarget()";
  protected final String TEXT_49 = ";" + NL + "if (";
  protected final String TEXT_50 = "(sourceEObject != null && ";
  protected final String TEXT_51 = "false == sourceEObject instanceof ";
  protected final String TEXT_52 = ")";
  protected final String TEXT_53 = " || ";
  protected final String TEXT_54 = "(targetEObject != null && ";
  protected final String TEXT_55 = "false == targetEObject instanceof ";
  protected final String TEXT_56 = ")";
  protected final String TEXT_57 = ") {" + NL + "\treturn ";
  protected final String TEXT_58 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = " source = (";
  protected final String TEXT_61 = ") sourceEObject;";
  protected final String TEXT_62 = NL;
  protected final String TEXT_63 = " target = (";
  protected final String TEXT_64 = ") targetEObject;";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = " container = (";
  protected final String TEXT_68 = ") getRelationshipContainer(source, ";
  protected final String TEXT_69 = ".eINSTANCE.get";
  protected final String TEXT_70 = "(), req.getElementType());" + NL + "if (container == null) {" + NL + "\treturn ";
  protected final String TEXT_71 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_72 = NL + "\t\tif(!";
  protected final String TEXT_73 = "(";
  protected final String TEXT_74 = "container, ";
  protected final String TEXT_75 = "source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_76 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_77 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_79 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = " sourceEObject = ";
  protected final String TEXT_82 = "req.getTarget()";
  protected final String TEXT_83 = "req.getSource()";
  protected final String TEXT_84 = ";";
  protected final String TEXT_85 = NL;
  protected final String TEXT_86 = " targetEObject = ";
  protected final String TEXT_87 = "req.getSource()";
  protected final String TEXT_88 = "req.getTarget()";
  protected final String TEXT_89 = ";" + NL + "if (";
  protected final String TEXT_90 = "(sourceEObject != null && ";
  protected final String TEXT_91 = "false == sourceEObject instanceof ";
  protected final String TEXT_92 = ")";
  protected final String TEXT_93 = " || ";
  protected final String TEXT_94 = "(targetEObject != null && ";
  protected final String TEXT_95 = "false == targetEObject instanceof ";
  protected final String TEXT_96 = ")";
  protected final String TEXT_97 = ") {" + NL + "\treturn ";
  protected final String TEXT_98 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_99 = NL;
  protected final String TEXT_100 = " source = (";
  protected final String TEXT_101 = ") sourceEObject;";
  protected final String TEXT_102 = NL;
  protected final String TEXT_103 = " target = (";
  protected final String TEXT_104 = ") targetEObject;";
  protected final String TEXT_105 = NL;
  protected final String TEXT_106 = NL;
  protected final String TEXT_107 = " container = (";
  protected final String TEXT_108 = ") getRelationshipContainer(source, ";
  protected final String TEXT_109 = ".eINSTANCE.get";
  protected final String TEXT_110 = "(), req.getElementType());" + NL + "if (container == null) {" + NL + "\treturn ";
  protected final String TEXT_111 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_112 = NL + "\t\tif(!";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = "container, ";
  protected final String TEXT_115 = "source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_116 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_117 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_118 = ".eINSTANCE.get";
  protected final String TEXT_119 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_120 = "(req, ";
  protected final String TEXT_121 = "container, ";
  protected final String TEXT_122 = "source, target));" + NL + "\t}";
  protected final String TEXT_123 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_124 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_125 = NL;
  protected final String TEXT_126 = " sourceEObject = ";
  protected final String TEXT_127 = "req.getTarget()";
  protected final String TEXT_128 = "req.getSource()";
  protected final String TEXT_129 = ";";
  protected final String TEXT_130 = NL;
  protected final String TEXT_131 = " targetEObject = ";
  protected final String TEXT_132 = "req.getSource()";
  protected final String TEXT_133 = "req.getTarget()";
  protected final String TEXT_134 = ";" + NL + "if (";
  protected final String TEXT_135 = "(sourceEObject != null && ";
  protected final String TEXT_136 = "false == sourceEObject instanceof ";
  protected final String TEXT_137 = ")";
  protected final String TEXT_138 = " || ";
  protected final String TEXT_139 = "(targetEObject != null && ";
  protected final String TEXT_140 = "false == targetEObject instanceof ";
  protected final String TEXT_141 = ")";
  protected final String TEXT_142 = ") {" + NL + "\treturn ";
  protected final String TEXT_143 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_144 = NL;
  protected final String TEXT_145 = " source = (";
  protected final String TEXT_146 = ") sourceEObject;";
  protected final String TEXT_147 = NL;
  protected final String TEXT_148 = " target = (";
  protected final String TEXT_149 = ") targetEObject;";
  protected final String TEXT_150 = NL;
  protected final String TEXT_151 = NL;
  protected final String TEXT_152 = " container = (";
  protected final String TEXT_153 = ") getRelationshipContainer(source, ";
  protected final String TEXT_154 = ".eINSTANCE.get";
  protected final String TEXT_155 = "(), req.getElementType());" + NL + "if (container == null) {" + NL + "\treturn ";
  protected final String TEXT_156 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_157 = NL + "\t\tif(!";
  protected final String TEXT_158 = "(";
  protected final String TEXT_159 = "container, ";
  protected final String TEXT_160 = "source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_161 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_162 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_163 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_164 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_165 = NL;
  protected final String TEXT_166 = " sourceEObject = ";
  protected final String TEXT_167 = "req.getTarget()";
  protected final String TEXT_168 = "req.getSource()";
  protected final String TEXT_169 = ";";
  protected final String TEXT_170 = NL;
  protected final String TEXT_171 = " targetEObject = ";
  protected final String TEXT_172 = "req.getSource()";
  protected final String TEXT_173 = "req.getTarget()";
  protected final String TEXT_174 = ";" + NL + "if (";
  protected final String TEXT_175 = "(sourceEObject != null && ";
  protected final String TEXT_176 = "false == sourceEObject instanceof ";
  protected final String TEXT_177 = ")";
  protected final String TEXT_178 = " || ";
  protected final String TEXT_179 = "(targetEObject != null && ";
  protected final String TEXT_180 = "false == targetEObject instanceof ";
  protected final String TEXT_181 = ")";
  protected final String TEXT_182 = ") {" + NL + "\treturn ";
  protected final String TEXT_183 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_184 = NL;
  protected final String TEXT_185 = " source = (";
  protected final String TEXT_186 = ") sourceEObject;";
  protected final String TEXT_187 = NL;
  protected final String TEXT_188 = " target = (";
  protected final String TEXT_189 = ") targetEObject;";
  protected final String TEXT_190 = NL;
  protected final String TEXT_191 = NL;
  protected final String TEXT_192 = " container = (";
  protected final String TEXT_193 = ") getRelationshipContainer(source, ";
  protected final String TEXT_194 = ".eINSTANCE.get";
  protected final String TEXT_195 = "(), req.getElementType());" + NL + "if (container == null) {" + NL + "\treturn ";
  protected final String TEXT_196 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_197 = NL + "\t\tif(!";
  protected final String TEXT_198 = "(";
  protected final String TEXT_199 = "container, ";
  protected final String TEXT_200 = "source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_201 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_202 = NL + "\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\treq.setContainmentFeature(";
  protected final String TEXT_203 = ".eINSTANCE.get";
  protected final String TEXT_204 = "());" + NL + "\t\t}" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_205 = "(req, ";
  protected final String TEXT_206 = "container, ";
  protected final String TEXT_207 = " source, target));" + NL + "\t}";
  protected final String TEXT_208 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_209 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_210 = NL;
  protected final String TEXT_211 = " sourceEObject = ";
  protected final String TEXT_212 = "req.getTarget()";
  protected final String TEXT_213 = "req.getSource()";
  protected final String TEXT_214 = ";";
  protected final String TEXT_215 = NL;
  protected final String TEXT_216 = " targetEObject = ";
  protected final String TEXT_217 = "req.getSource()";
  protected final String TEXT_218 = "req.getTarget()";
  protected final String TEXT_219 = ";" + NL + "if (";
  protected final String TEXT_220 = "(sourceEObject != null && ";
  protected final String TEXT_221 = "false == sourceEObject instanceof ";
  protected final String TEXT_222 = ")";
  protected final String TEXT_223 = " || ";
  protected final String TEXT_224 = "(targetEObject != null && ";
  protected final String TEXT_225 = "false == targetEObject instanceof ";
  protected final String TEXT_226 = ")";
  protected final String TEXT_227 = ") {" + NL + "\treturn ";
  protected final String TEXT_228 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_229 = NL;
  protected final String TEXT_230 = " source = (";
  protected final String TEXT_231 = ") sourceEObject;";
  protected final String TEXT_232 = NL;
  protected final String TEXT_233 = " target = (";
  protected final String TEXT_234 = ") targetEObject;" + NL + "\t\tif(!";
  protected final String TEXT_235 = "(source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_236 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_237 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_238 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_239 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_240 = NL;
  protected final String TEXT_241 = " sourceEObject = ";
  protected final String TEXT_242 = "req.getTarget()";
  protected final String TEXT_243 = "req.getSource()";
  protected final String TEXT_244 = ";";
  protected final String TEXT_245 = NL;
  protected final String TEXT_246 = " targetEObject = ";
  protected final String TEXT_247 = "req.getSource()";
  protected final String TEXT_248 = "req.getTarget()";
  protected final String TEXT_249 = ";" + NL + "if (";
  protected final String TEXT_250 = "(sourceEObject != null && ";
  protected final String TEXT_251 = "false == sourceEObject instanceof ";
  protected final String TEXT_252 = ")";
  protected final String TEXT_253 = " || ";
  protected final String TEXT_254 = "(targetEObject != null && ";
  protected final String TEXT_255 = "false == targetEObject instanceof ";
  protected final String TEXT_256 = ")";
  protected final String TEXT_257 = ") {" + NL + "\treturn ";
  protected final String TEXT_258 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_259 = NL;
  protected final String TEXT_260 = " source = (";
  protected final String TEXT_261 = ") sourceEObject;";
  protected final String TEXT_262 = NL;
  protected final String TEXT_263 = " target = (";
  protected final String TEXT_264 = ") targetEObject;" + NL + "\t\tif(!";
  protected final String TEXT_265 = "(source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_266 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_267 = NL + "\t\t";
  protected final String TEXT_268 = " setReq = new ";
  protected final String TEXT_269 = "(req.getTarget()," + NL + "\t\t\t";
  protected final String TEXT_270 = ".eINSTANCE.get";
  protected final String TEXT_271 = "(), req.getSource());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_272 = "(setReq));" + NL + "\t}";
  protected final String TEXT_273 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateStart";
  protected final String TEXT_274 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_275 = NL;
  protected final String TEXT_276 = " sourceEObject = ";
  protected final String TEXT_277 = "req.getTarget()";
  protected final String TEXT_278 = "req.getSource()";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL;
  protected final String TEXT_281 = " targetEObject = ";
  protected final String TEXT_282 = "req.getSource()";
  protected final String TEXT_283 = "req.getTarget()";
  protected final String TEXT_284 = ";" + NL + "if (";
  protected final String TEXT_285 = "(sourceEObject != null && ";
  protected final String TEXT_286 = "false == sourceEObject instanceof ";
  protected final String TEXT_287 = ")";
  protected final String TEXT_288 = " || ";
  protected final String TEXT_289 = "(targetEObject != null && ";
  protected final String TEXT_290 = "false == targetEObject instanceof ";
  protected final String TEXT_291 = ")";
  protected final String TEXT_292 = ") {" + NL + "\treturn ";
  protected final String TEXT_293 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_294 = NL;
  protected final String TEXT_295 = " source = (";
  protected final String TEXT_296 = ") sourceEObject;";
  protected final String TEXT_297 = NL;
  protected final String TEXT_298 = " target = (";
  protected final String TEXT_299 = ") targetEObject;" + NL + "\t\tif(!";
  protected final String TEXT_300 = "(source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_301 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_302 = NL + "\t\treturn new Command() {" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_303 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateComplete";
  protected final String TEXT_304 = "Command(CreateRelationshipRequest req) {";
  protected final String TEXT_305 = NL;
  protected final String TEXT_306 = " sourceEObject = ";
  protected final String TEXT_307 = "req.getTarget()";
  protected final String TEXT_308 = "req.getSource()";
  protected final String TEXT_309 = ";";
  protected final String TEXT_310 = NL;
  protected final String TEXT_311 = " targetEObject = ";
  protected final String TEXT_312 = "req.getSource()";
  protected final String TEXT_313 = "req.getTarget()";
  protected final String TEXT_314 = ";" + NL + "if (";
  protected final String TEXT_315 = "(sourceEObject != null && ";
  protected final String TEXT_316 = "false == sourceEObject instanceof ";
  protected final String TEXT_317 = ")";
  protected final String TEXT_318 = " || ";
  protected final String TEXT_319 = "(targetEObject != null && ";
  protected final String TEXT_320 = "false == targetEObject instanceof ";
  protected final String TEXT_321 = ")";
  protected final String TEXT_322 = ") {" + NL + "\treturn ";
  protected final String TEXT_323 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_324 = NL;
  protected final String TEXT_325 = " source = (";
  protected final String TEXT_326 = ") sourceEObject;";
  protected final String TEXT_327 = NL;
  protected final String TEXT_328 = " target = (";
  protected final String TEXT_329 = ") targetEObject;" + NL + "\t\tif(!";
  protected final String TEXT_330 = "(source, target)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_331 = ".INSTANCE;\t\t\t" + NL + "\t\t}";
  protected final String TEXT_332 = NL + "\t\t";
  protected final String TEXT_333 = " setReq = new ";
  protected final String TEXT_334 = "(req.getSource()," + NL + "\t\t\t";
  protected final String TEXT_335 = ".eINSTANCE.get";
  protected final String TEXT_336 = "(), req.getTarget());" + NL + "\t\treturn getMSLWrapper(new ";
  protected final String TEXT_337 = "(setReq));" + NL + "\t}";
  protected final String TEXT_338 = NL + "}";
  protected final String TEXT_339 = NL;

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
    	if (!modelFacet.isPhantomElement()) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_18);
    	}
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genChildNode.getCreateCommandQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    	if (genNode.getModelFacet() != null && genNode.getModelFacet().isPhantomElement()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.commands.ExecutionException"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CommandResult"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_29);
    	}
    stringBuffer.append(TEXT_30);
    
final String OUTGOING_TOKEN = "Outgoing";
final String INCOMING_TOKEN = "Incoming";

    stringBuffer.append(TEXT_31);
    
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

    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(startCommandGetter);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(endCommandGetter);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();

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

    stringBuffer.append(TEXT_38);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_39);
    			boolean reversedRequest = false;
			boolean nullTargetAllowed = true;
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_41);
     if (reversedRequest) {
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_46);
     if (reversedRequest) {
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    if (modelFacet.getSourceMetaFeature() != null) {
	String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_73);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_76);
     // create always executable command 
    stringBuffer.append(TEXT_77);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_78);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_79);
    			boolean reversedRequest = true;
			boolean nullTargetAllowed = false;
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_81);
     if (reversedRequest) {
    stringBuffer.append(TEXT_82);
    } else {
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_86);
     if (reversedRequest) {
    stringBuffer.append(TEXT_87);
    } else {
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    if (modelFacet.getSourceMetaFeature() != null) {
	String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_113);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_116);
     // create semantic command 
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(modelFacet.getCreateCommandQualifiedClassName()));
    stringBuffer.append(TEXT_120);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    
		}
			
			
// 3. StartIncomingCommand
			
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_123);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_124);
    			boolean reversedRequest = true;
			boolean nullTargetAllowed = true;
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_126);
     if (reversedRequest) {
    stringBuffer.append(TEXT_127);
    } else {
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_131);
     if (reversedRequest) {
    stringBuffer.append(TEXT_132);
    } else {
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    if (modelFacet.getSourceMetaFeature() != null) {
	String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_158);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_161);
     // create always executable command 
    stringBuffer.append(TEXT_162);
    
		}
		
		
// 4. CompleteIncomingCommand
		
		if (generateCompleteIncomingCommand) {	
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_163);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_164);
    			boolean reversedRequest = false;
			boolean nullTargetAllowed = false;
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_166);
     if (reversedRequest) {
    stringBuffer.append(TEXT_167);
    } else {
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_171);
     if (reversedRequest) {
    stringBuffer.append(TEXT_172);
    } else {
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(TEXT_190);
    if (modelFacet.getSourceMetaFeature() != null) {
	String containerClassName = importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_198);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_201);
     // create semantic command 
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(modelFacet.getContainmentMetaFeature().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName(modelFacet.getCreateCommandQualifiedClassName()));
    stringBuffer.append(TEXT_205);
    if (modelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    
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

    stringBuffer.append(TEXT_208);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_209);
    			boolean reversedRequest = false;
			boolean nullTargetAllowed = true;
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_211);
     if (reversedRequest) {
    stringBuffer.append(TEXT_212);
    } else {
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_216);
     if (reversedRequest) {
    stringBuffer.append(TEXT_217);
    } else {
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_236);
     // create always executable command 
    stringBuffer.append(TEXT_237);
    
		}
		
		
// 2. CompleteOutgoingCommand

		if (generateCompleteOutgoingCommand) {
			String namePart = OUTGOING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_238);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_239);
    			boolean reversedRequest = true;
			boolean nullTargetAllowed = false;
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_241);
     if (reversedRequest) {
    stringBuffer.append(TEXT_242);
    } else {
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_246);
     if (reversedRequest) {
    stringBuffer.append(TEXT_247);
    } else {
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_252);
    }
    stringBuffer.append(TEXT_253);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_254);
    }
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_266);
     // create semantic command 
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_272);
    
		}
		
		
// 3. StartIncomingCommand
		
		if (generateStartIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_273);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_274);
    			boolean reversedRequest = true;
			boolean nullTargetAllowed = true;
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_276);
     if (reversedRequest) {
    stringBuffer.append(TEXT_277);
    } else {
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_281);
     if (reversedRequest) {
    stringBuffer.append(TEXT_282);
    } else {
    stringBuffer.append(TEXT_283);
    }
    stringBuffer.append(TEXT_284);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_301);
     // no feasible restrictions here 
    stringBuffer.append(TEXT_302);
    
		}
		
		
// 4. CompleteIncomingCommand

		if (generateCompleteIncomingCommand) {
			String namePart = INCOMING_TOKEN + namePartSuffix;

    stringBuffer.append(TEXT_303);
    stringBuffer.append(namePart);
    stringBuffer.append(TEXT_304);
    			boolean reversedRequest = false;
			boolean nullTargetAllowed = false;
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_306);
     if (reversedRequest) {
    stringBuffer.append(TEXT_307);
    } else {
    stringBuffer.append(TEXT_308);
    }
    stringBuffer.append(TEXT_309);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_311);
     if (reversedRequest) {
    stringBuffer.append(TEXT_312);
    } else {
    stringBuffer.append(TEXT_313);
    }
    stringBuffer.append(TEXT_314);
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && reversedRequest) {
    stringBuffer.append(TEXT_317);
    }
    stringBuffer.append(TEXT_318);
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    if (nullTargetAllowed && !reversedRequest) {
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName())+"."+genDiagram.getLinkCreationConstraintsClassName()+".canCreate"+genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_331);
     // create semantic command 
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand"));
    stringBuffer.append(TEXT_337);
    
		}
	}
}

    stringBuffer.append(TEXT_338);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_339);
    return stringBuffer.toString();
  }
}