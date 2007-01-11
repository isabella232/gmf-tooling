package org.eclipse.gmf.codegen.templates.lite.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class CompartmentEditPartGenerator
{
  protected static String nl;
  public static synchronized CompartmentEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CompartmentEditPartGenerator result = new CompartmentEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "((";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = "((";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = ".eGet(";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "())";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = "((";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "()";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_23 = " extends ";
  protected final String TEXT_24 = " implements ";
  protected final String TEXT_25 = " {";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_30 = "(View view) {" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_31 = " getModelChildren() {" + NL + "\t\t";
  protected final String TEXT_32 = " style = (";
  protected final String TEXT_33 = ") getDiagramNode().getStyle(";
  protected final String TEXT_34 = ".eINSTANCE.getDrawerStyle());" + NL + "\t\tif (style != null && style.isCollapsed()) {" + NL + "\t\t\treturn ";
  protected final String TEXT_35 = ".EMPTY_LIST;" + NL + "\t\t}" + NL + "\t\treturn getDiagramNode().getChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_36 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_37 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_38 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_39 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_40 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_41 = " createChangeConstraintCommand(final ";
  protected final String TEXT_42 = " request, final ";
  protected final String TEXT_43 = " child, Object constraint) {";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = "\t\t\t\tfinal ";
  protected final String TEXT_46 = " node = (";
  protected final String TEXT_47 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_48 = " emfCommand = new ";
  protected final String TEXT_49 = "(node, request, ((";
  protected final String TEXT_50 = ")child).getFigure());" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_51 = "(";
  protected final String TEXT_52 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_53 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_54 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = "protected ";
  protected final String TEXT_57 = " createChildEditPolicy(";
  protected final String TEXT_58 = " child) {" + NL + "\tif (child != null) {" + NL + "\t\t";
  protected final String TEXT_59 = " result = child.getEditPolicy(";
  protected final String TEXT_60 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\tif (result != null) {" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn super.createChildEditPolicy(child);" + NL + "}";
  protected final String TEXT_61 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_62 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_63 = "() {" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_64 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_65 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_66 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = "protected ";
  protected final String TEXT_69 = " createChildEditPolicy(";
  protected final String TEXT_70 = " child) {" + NL + "\tif (child != null) {" + NL + "\t\t";
  protected final String TEXT_71 = " result = child.getEditPolicy(";
  protected final String TEXT_72 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\tif (result != null) {" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn super.createChildEditPolicy(child);" + NL + "}";
  protected final String TEXT_73 = NL;
  protected final String TEXT_74 = NL + "protected Command createAddCommand(final ";
  protected final String TEXT_75 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_76 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_77 = " childNode = (";
  protected final String TEXT_78 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_79 = " editingDomain = ";
  protected final String TEXT_80 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_81 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_82 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int visualID = ";
  protected final String TEXT_83 = ".getVisualID(childNode);" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_84 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_85 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_86 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_87 = NL + "\t\t\tcase ";
  protected final String TEXT_88 = ".VISUAL_ID:" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = " result = new ";
  protected final String TEXT_90 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_91 = " element = childNode.getElement();";
  protected final String TEXT_92 = NL + "\t\t\t\t\tswitch (visualID) {";
  protected final String TEXT_93 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_94 = ".VISUAL_ID:";
  protected final String TEXT_95 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_96 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_97 = ".eINSTANCE.get";
  protected final String TEXT_98 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_99 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_100 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_101 = ".eINSTANCE.get";
  protected final String TEXT_102 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_103 = ".UNSET_VALUE));";
  protected final String TEXT_104 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_105 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_106 = ".eINSTANCE.get";
  protected final String TEXT_107 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_108 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_109 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_110 = ".eINSTANCE.get";
  protected final String TEXT_111 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_112 = ".UNSET_VALUE));";
  protected final String TEXT_113 = NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_114 = NL + "\t\t\t\t\t}\t";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "\t\tif (";
  protected final String TEXT_117 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_118 = NL + "\t\t}";
  protected final String TEXT_119 = NL + "\t\tif (";
  protected final String TEXT_120 = ".size() >= ";
  protected final String TEXT_121 = ".eINSTANCE.get";
  protected final String TEXT_122 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_123 = NL + "\t\t}";
  protected final String TEXT_124 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_125 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = ".getElement(), ";
  protected final String TEXT_127 = ".eINSTANCE.get";
  protected final String TEXT_128 = "(), element));";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = NL + "\t\tif (";
  protected final String TEXT_131 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_132 = NL + "\t\t}";
  protected final String TEXT_133 = NL + "\t\tif (";
  protected final String TEXT_134 = ".size() >= ";
  protected final String TEXT_135 = ".eINSTANCE.get";
  protected final String TEXT_136 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t}";
  protected final String TEXT_138 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_139 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_140 = ".getElement(), ";
  protected final String TEXT_141 = ".eINSTANCE.get";
  protected final String TEXT_142 = "(), element));";
  protected final String TEXT_143 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_144 = ".create(editingDomain, childNode.eContainer(), childNode.eContainmentFeature(), childNode));" + NL + "\t\t\t\t\tif (newVisualID == visualID) {" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_145 = ".create(editingDomain, ";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ".eINSTANCE.getView_PersistedChildren(), childNode));" + NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_148 = "(childNode, ";
  protected final String TEXT_149 = "null";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = ") constraint";
  protected final String TEXT_152 = "));" + NL + "\t\t\t\t\t} else {";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_154 = "(";
  protected final String TEXT_155 = ", element, ";
  protected final String TEXT_156 = "null";
  protected final String TEXT_157 = "((";
  protected final String TEXT_158 = ") constraint).getCopy().union(new ";
  protected final String TEXT_159 = "(";
  protected final String TEXT_160 = ", ";
  protected final String TEXT_161 = "))";
  protected final String TEXT_162 = ", ";
  protected final String TEXT_163 = ".INSTANCE));";
  protected final String TEXT_164 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcommand = result;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_165 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_166 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_167 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_168 = NL;
  protected final String TEXT_169 = NL + "protected ";
  protected final String TEXT_170 = " getCloneCommand(";
  protected final String TEXT_171 = " request) {" + NL + "\t";
  protected final String TEXT_172 = " editParts = request.getEditParts();" + NL + "\t";
  protected final String TEXT_173 = " command = new ";
  protected final String TEXT_174 = "();" + NL + "\tcommand.setDebugLabel(\"Clone in ConstrainedLayoutEditPolicy\");//$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_175 = " childPart;" + NL + "\t";
  protected final String TEXT_176 = " r;" + NL + "\tObject constraint;" + NL + "" + NL + "\tfor (int i = 0; i < editParts.size(); i++) {" + NL + "\t\tchildPart = (";
  protected final String TEXT_177 = ")editParts.get(i);" + NL + "\t\tr = childPart.getFigure().getBounds().getCopy();" + NL + "\t\t//convert r to absolute from childpart figure" + NL + "\t\tchildPart.getFigure().translateToAbsolute(r);" + NL + "\t\tr = request.getTransformedRectangle(r);" + NL + "\t\t//convert this figure to relative " + NL + "\t\tgetLayoutContainer().translateToRelative(r);" + NL + "\t\tgetLayoutContainer().translateFromParent(r);" + NL + "\t\tr.translate(getLayoutOrigin().getNegated());" + NL + "\t\tconstraint = getConstraintFor(r);" + NL + "\t\tcommand.add(createCloneCommand(childPart," + NL + "\t\t\ttranslateToModelConstraint(constraint)));" + NL + "\t}" + NL + "\treturn command.unwrap();" + NL + "}" + NL + "protected ";
  protected final String TEXT_178 = " createCloneCommand(final ";
  protected final String TEXT_179 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_180 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_181 = " childNode = (";
  protected final String TEXT_182 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_183 = " editingDomain = ";
  protected final String TEXT_184 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_185 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_186 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_187 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_188 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_189 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_190 = NL + "\t\t\tcase ";
  protected final String TEXT_191 = ".VISUAL_ID:" + NL + "\t\t\t\tcommand = new ";
  protected final String TEXT_192 = "() {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_193 = " afterCopyCommand;" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_194 = " createCommand() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_195 = " element = childNode.getElement();" + NL + "\t\t\t\t\t\t//We are being optimistic here about whether further commands can be executed." + NL + "\t\t\t\t\t\t//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.  " + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_196 = ".create(editingDomain, element);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (!super.prepare()) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_197 = NL;
  protected final String TEXT_198 = NL + "\t\tif (";
  protected final String TEXT_199 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_200 = NL + "\t\t}";
  protected final String TEXT_201 = NL + "\t\tif (";
  protected final String TEXT_202 = ".size() >= ";
  protected final String TEXT_203 = ".eINSTANCE.get";
  protected final String TEXT_204 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_205 = NL + "\t\t}";
  protected final String TEXT_206 = NL;
  protected final String TEXT_207 = NL + "\t\tif (";
  protected final String TEXT_208 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_209 = NL + "\t\t}";
  protected final String TEXT_210 = NL + "\t\tif (";
  protected final String TEXT_211 = ".size() >= ";
  protected final String TEXT_212 = ".eINSTANCE.get";
  protected final String TEXT_213 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_214 = NL + "\t\t}";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tsuper.execute();" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_216 = " results = super.getResult();" + NL + "\t\t\t\t\t\tassert results.size() == 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_217 = " result = (";
  protected final String TEXT_218 = ") results.iterator().next();" + NL + "\t\t\t\t\t\tafterCopyCommand = new ";
  protected final String TEXT_219 = "();";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_221 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_222 = ".getElement(), ";
  protected final String TEXT_223 = ".eINSTANCE.get";
  protected final String TEXT_224 = "(), result));";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_226 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_227 = ".getElement(), ";
  protected final String TEXT_228 = ".eINSTANCE.get";
  protected final String TEXT_229 = "(), result));";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\tafterCopyCommand.append(new ";
  protected final String TEXT_231 = "(";
  protected final String TEXT_232 = ", result, ";
  protected final String TEXT_233 = "null";
  protected final String TEXT_234 = "((";
  protected final String TEXT_235 = ") constraint).getCopy().union(new ";
  protected final String TEXT_236 = "(";
  protected final String TEXT_237 = ", ";
  protected final String TEXT_238 = "))";
  protected final String TEXT_239 = ", ";
  protected final String TEXT_240 = ".INSTANCE));" + NL + "\t\t\t\t\t\tif (afterCopyCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tafterCopyCommand.execute();" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tassert false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tafterCopyCommand.undo();" + NL + "\t\t\t\t\t\tsuper.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\tsuper.redo();" + NL + "\t\t\t\t\t\tafterCopyCommand.redo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_241 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_242 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_243 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_244 = NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {";
  protected final String TEXT_245 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_246 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_247 = " requestEx = (";
  protected final String TEXT_248 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_249 = " result = new ";
  protected final String TEXT_250 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_252 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_253 = "((View) getModel(), requestEx";
  protected final String TEXT_254 = ", " + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_255 = ")getConstraintFor(request)";
  protected final String TEXT_256 = "));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_257 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_258 = "(";
  protected final String TEXT_259 = ".getEditingDomain(((View) getModel()).getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_260 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_261 = NL;
  protected final String TEXT_262 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_263 = "\", new ";
  protected final String TEXT_264 = "()); //$NON-NLS-1$";
  protected final String TEXT_265 = NL;
  protected final String TEXT_266 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_267 = ".OPEN_ROLE";
  protected final String TEXT_268 = " + \"";
  protected final String TEXT_269 = "\" ";
  protected final String TEXT_270 = ", new ";
  protected final String TEXT_271 = "());";
  protected final String TEXT_272 = NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the selection handles that should be contributed to the parent when it becomes selected." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_273 = " createSelectionHandles() {";
  protected final String TEXT_274 = NL + "\t\treturn ";
  protected final String TEXT_275 = ".singletonList(new ";
  protected final String TEXT_276 = "(this, getTitleName()));";
  protected final String TEXT_277 = NL + "\t\treturn ";
  protected final String TEXT_278 = ".singletonList(new ";
  protected final String TEXT_279 = "(this, getTitleName()));";
  protected final String TEXT_280 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_281 = " req) {";
  protected final String TEXT_282 = NL;
  protected final String TEXT_283 = "if (";
  protected final String TEXT_284 = ".REQ_OPEN.equals(req.getType())) {" + NL + "\t";
  protected final String TEXT_285 = " command = getCommand(req);" + NL + "\tif (command != null && command.canExecute()) {" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(command);" + NL + "\t}" + NL + "\treturn;" + NL + "}" + NL + "\t\tsuper.performRequest(req);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getTitleName() {";
  protected final String TEXT_286 = NL + "\t\treturn \"";
  protected final String TEXT_287 = "\";";
  protected final String TEXT_288 = NL + "\t\treturn \"\";\t//$NON-NLS-1$";
  protected final String TEXT_289 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_290 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_291 = " result = new ";
  protected final String TEXT_292 = "();" + NL + "\t\tresult.setLayoutManager(new ";
  protected final String TEXT_293 = "());" + NL + "\t\t";
  protected final String TEXT_294 = " scrollPane = new ";
  protected final String TEXT_295 = "();" + NL + "\t\tresult.add(scrollPane);";
  protected final String TEXT_296 = NL + "\t\t";
  protected final String TEXT_297 = " viewport = new ";
  protected final String TEXT_298 = "();" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_299 = "();" + NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_300 = "());";
  protected final String TEXT_301 = NL + "\t\t";
  protected final String TEXT_302 = " viewport = new ";
  protected final String TEXT_303 = "();" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_304 = "();" + NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_305 = "());";
  protected final String TEXT_306 = NL + "\t\tviewport.setContents(contentPane);" + NL + "\t\tscrollPane.setViewport(viewport);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_307 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (";
  protected final String TEXT_308 = ".class == key) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_309 = "(this);" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(key);" + NL + "\t}";
  protected final String TEXT_310 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tuninstallNotationModelRefresher();" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_311 = NL;
  protected final String TEXT_312 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_313 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_314 = " domainModelEditDomain = ";
  protected final String TEXT_315 = ".getEditingDomain(";
  protected final String TEXT_316 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_317 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_318 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_319 = " {";
  protected final String TEXT_320 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_321 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_322 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_323 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_324 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_325 = " createFilter() {";
  protected final String TEXT_326 = NL + "\t\t\t";
  protected final String TEXT_327 = " filter = ";
  protected final String TEXT_328 = ".createFeatureFilter(";
  protected final String TEXT_329 = ".eINSTANCE.get";
  protected final String TEXT_330 = "());";
  protected final String TEXT_331 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_332 = ".createFeatureFilter(";
  protected final String TEXT_333 = ".eINSTANCE.get";
  protected final String TEXT_334 = "()));";
  protected final String TEXT_335 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_336 = ".createNotifierFilter(";
  protected final String TEXT_337 = ".getElement()));";
  protected final String TEXT_338 = NL + "\t\t\t";
  protected final String TEXT_339 = " filter = ";
  protected final String TEXT_340 = ".createNotifierFilter(";
  protected final String TEXT_341 = ".getElement());";
  protected final String TEXT_342 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_343 = NL + "\t\t\t";
  protected final String TEXT_344 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_345 = NL + "\t\t\t";
  protected final String TEXT_346 = " filter = ";
  protected final String TEXT_347 = ".NOT_TOUCH;";
  protected final String TEXT_348 = NL + "\t\t\treturn filter;";
  protected final String TEXT_349 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_350 = " getCreateNotationalElementCommand(";
  protected final String TEXT_351 = " descriptor) {";
  protected final String TEXT_352 = NL;
  protected final String TEXT_353 = "\t\t\t";
  protected final String TEXT_354 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_355 = NL + "\t\t\tcase ";
  protected final String TEXT_356 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_357 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_358 = "(";
  protected final String TEXT_359 = ", domainElement, ";
  protected final String TEXT_360 = "new ";
  protected final String TEXT_361 = "(0, 0, ";
  protected final String TEXT_362 = ", ";
  protected final String TEXT_363 = ")";
  protected final String TEXT_364 = NL + "null";
  protected final String TEXT_365 = ", ";
  protected final String TEXT_366 = ".INSTANCE);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_367 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_368 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_369 = " getSemanticChildNodes() {";
  protected final String TEXT_370 = NL;
  protected final String TEXT_371 = NL + "\treturn ";
  protected final String TEXT_372 = ".EMPTY_LIST;";
  protected final String TEXT_373 = NL + "\t";
  protected final String TEXT_374 = " result = new ";
  protected final String TEXT_375 = "();";
  protected final String TEXT_376 = NL + "\t";
  protected final String TEXT_377 = " viewObject = ";
  protected final String TEXT_378 = ";" + NL + "\t";
  protected final String TEXT_379 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_380 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_381 = NL + "\tfor(";
  protected final String TEXT_382 = " it = ";
  protected final String TEXT_383 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_384 = ") it.next();";
  protected final String TEXT_385 = NL + "\tnextValue = (";
  protected final String TEXT_386 = ")";
  protected final String TEXT_387 = ";";
  protected final String TEXT_388 = NL + "\tnodeVID = ";
  protected final String TEXT_389 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_390 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_391 = NL + "\tcase ";
  protected final String TEXT_392 = ".VISUAL_ID: {";
  protected final String TEXT_393 = NL + "\tif (";
  protected final String TEXT_394 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_395 = NL + "\t\tresult.add(new ";
  protected final String TEXT_396 = "(nextValue, nodeVID));";
  protected final String TEXT_397 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_398 = NL + "\t\t}";
  protected final String TEXT_399 = NL + "\t}";
  protected final String TEXT_400 = NL + "\t}";
  protected final String TEXT_401 = NL + "\treturn result;";
  protected final String TEXT_402 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_403 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_404 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_405 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_406 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_407 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_408 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_409 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_410 = " domainModelEditDomain = ";
  protected final String TEXT_411 = ".getEditingDomain(";
  protected final String TEXT_412 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_413 = "(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_414 = NL;
  protected final String TEXT_415 = NL;
  protected final String TEXT_416 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_417 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_418 = " feature, ";
  protected final String TEXT_419 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_420 = NL;
  protected final String TEXT_421 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_422 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_423 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_424 = ".eINSTANCE.getView_Styles(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_425 = ".eINSTANCE.getDrawerStyle_Collapsed(), childrenRefresher);" + NL + "\t\t";
  protected final String TEXT_426 = NL;
  protected final String TEXT_427 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_428 = ".eINSTANCE.getView_Visible(), visibilityRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "//XXX:\t\trefreshBackgroundColor();" + NL + "//XXX:\t\trefreshForegroundColor();" + NL + "//XXX:\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = ((View)getModel()).isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_429 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenCompartment genCompartment = (GenCompartment) ((Object[]) argument)[0];
GenNode genHost = genCompartment.getNode();
GenDiagram genDiagram = genCompartment.getDiagram();
List childNodes = genCompartment.getChildNodes();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("NotationModelRefresher");	//from notationModelRefresher.jetinc

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    
class FeatureGetAccessorHelper {
	/**
	 * @param containerName the name of the container
	 * @param feature the feature whose value is in interest
	 * @param containerMetaClass the <code>GenClass</code> of the container, or <code>null</code>, if the container is declared as an <code>EObject</code>.
	 * @param needsCastToResultType whether the cast to the result type is required (this parameter is only used if the <code>EClass</code> this feature belongs to is an external interface). 
	 */
	public void appendFeatureValueGetter(String containerName, GenFeature feature, GenClass containerMetaClass, boolean needsCastToResultType) {
		if (feature.getGenClass().isExternalInterface()) {
			boolean needsCastToEObject = containerMetaClass != null && containerMetaClass.isExternalInterface();
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(feature.isListType() ? "java.util.Collection" : feature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_7);
    
			}
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_9);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_10);
    
			}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_13);
    
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_14);
    
			}
		} else {
			boolean needsCastToFeatureGenType = containerMetaClass == null || containerMetaClass.isExternalInterface();
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_16);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_17);
    
			}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(feature.getGetAccessor());
    stringBuffer.append(TEXT_19);
    
		}
	}
}
final FeatureGetAccessorHelper myFeatureGetAccessorHelper = new FeatureGetAccessorHelper();

    stringBuffer.append(TEXT_20);
    importManager.emitPackageStatement(stringBuffer);
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gef.commands.Command");
importManager.addImport("org.eclipse.gef.commands.CompoundCommand");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.requests.CreateRequest");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_21);
    
class RelatedNodesFinder {
	private HashMap<GenClass, Collection<GenNode>> myCache = new HashMap<GenClass, Collection<GenNode>>();
	private final GenDiagram myDiagram;

	public RelatedNodesFinder(GenDiagram genDiagram) {
		myDiagram = genDiagram;
	}

	public Collection<GenNode> getRelatedGenNodes(GenClass genClass) {
		Collection<GenNode> result = myCache.get(genClass);
		if (result == null) {
			result = new LinkedList<GenNode>();
			myCache.put(genClass, result);
			for(Iterator it = myDiagram.getAllNodes().iterator(); it.hasNext(); ) {
				GenNode next = (GenNode) it.next();
				if (genClass.equals(next.getDomainMetaClass())) {
					result.add(next);
				}
			}
		}
		return result;
	}
}
RelatedNodesFinder myRelatedNodesFinder = new RelatedNodesFinder(genDiagram);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_25);
    {
GenCommonBase genCommonBase = genCompartment;
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_37);
    if (!genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_72);
    }
    
{
	String _getViewCode = "getDiagramNode()";
	boolean isListLayout = genCompartment.isListLayout();

    stringBuffer.append(TEXT_73);
    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_86);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();

    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_91);
    
		{
			Collection<GenNode> relatedNodes = myRelatedNodesFinder.getRelatedGenNodes(next.getDomainMetaClass());
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_92);
    
			}
			for(GenNode nextRelated : relatedNodes) {
				TypeModelFacet facet = nextRelated.getModelFacet();
				GenFeature childFeature = facet.getChildMetaFeature();
				GenFeature containmentFeature = facet.getContainmentMetaFeature();
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(nextRelated.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_94);
    
				}
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_98);
    
					} else {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_103);
    
					}
				}
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_107);
    
				} else {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_112);
    
				}
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_113);
    
				}
			}	//for(GenNode nextRelated : relatedNodes)
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_114);
    /*switch(visualID)*/
    
			}
			TypeModelFacet facet = next.getModelFacet();
			GenFeature childFeature = facet.getChildMetaFeature();
			GenFeature containmentFeature = facet.getContainmentMetaFeature();
			if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
				GenFeature _feature = childFeature;
				String _ownerInstance = _getViewCode + ".getElement()";
				String _exceedsUpperBound = "return " + importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand") + ".INSTANCE;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_115);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_116);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_118);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_119);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_123);
    
	}
}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_128);
    
			}
			{
				GenFeature _feature = containmentFeature;
				String _ownerInstance = _getViewCode + ".getElement()";
				String _exceedsUpperBound = "return " + importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand") + ".INSTANCE;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_129);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_130);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_132);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_133);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_137);
    
	}
}

    
			}

    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_142);
    
		}	//local declaration for related nodes.

    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand"));
    stringBuffer.append(TEXT_148);
    if (isListLayout) {
    stringBuffer.append(TEXT_149);
    } else {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_155);
    if (isListLayout) {
    stringBuffer.append(TEXT_156);
    } else {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_163);
    
		}

    stringBuffer.append(TEXT_164);
    
	}	//for

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_167);
    
}	//if (!childNodes.isEmpty()) in createAddCommand

    stringBuffer.append(TEXT_168);
    
/* delegation from getCloneCommand to createCloneCommand is 100% analogous to delegation from getAddCommand() to createAddCommand() in ConstrainedLayoutEditPolicy. */

    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_189);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();
		TypeModelFacet facet = next.getModelFacet();
		GenFeature childFeature = facet.getChildMetaFeature();
		GenFeature containmentFeature = facet.getContainmentMetaFeature();

    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CommandWrapper"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.CopyCommand"));
    stringBuffer.append(TEXT_196);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
			GenFeature _feature = childFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_197);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_198);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_200);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_201);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_205);
    
	}
}

    
		}
		{
			GenFeature _feature = containmentFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_206);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_207);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_209);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_210);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_214);
    
	}
}

    
		}

    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_219);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_224);
    
		}

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_229);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_232);
    if (isListLayout) {
    stringBuffer.append(TEXT_233);
    } else {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_240);
    
		}
	}	//for

    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_243);
    
}	//if (!childNodes.isEmpty())

    
}

    stringBuffer.append(TEXT_244);
    if (null != genDiagram.getPalette()) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_250);
    
for(Iterator it = genCompartment.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Create" + next.getDomainMetaClass().getName() + next.getVisualID() + "Command"));
    stringBuffer.append(TEXT_253);
    if (!genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_255);
    }
    stringBuffer.append(TEXT_256);
    
}

    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_259);
    }/*when there's palette*/
    stringBuffer.append(TEXT_260);
    {
GenCommonBase genCommonBase = genCompartment;
    stringBuffer.append(TEXT_261);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_262);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    
{
	List<OpenDiagramBehaviour> behaviours = genCommonBase.getBehaviour(OpenDiagramBehaviour.class);
	for(int i = 0, iMax = behaviours.size(); i < iMax; i++) {
	/*doesn't make sense to install more than one policy for the same role*/ 
		OpenDiagramBehaviour next = behaviours.get(i);

    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.EditPolicyRoles"));
    stringBuffer.append(TEXT_267);
    if (i > 0) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(importManager.getImportedName(genCommonBase.getBehaviour(OpenDiagramBehaviour.class).get(0).getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_271);
    
	}
}

    }
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_273);
    
if (!genCompartment.isCanCollapse()) {

    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.handles.CompartmentNameHandle"));
    stringBuffer.append(TEXT_276);
    
} else {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.handles.CompartmentCollapseHandle"));
    stringBuffer.append(TEXT_279);
    
}

    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_285);
    
if (genCompartment.isNeedsTitle()) {

    stringBuffer.append(TEXT_286);
    stringBuffer.append(genCompartment.getTitle());
    stringBuffer.append(TEXT_287);
    
} else {

    stringBuffer.append(TEXT_288);
    
}

    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.figures.CompartmentFigure"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ScrollPane"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ScrollPane"));
    stringBuffer.append(TEXT_295);
    if (genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout"));
    stringBuffer.append(TEXT_300);
    } else {
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformViewport"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    
if (!genCompartment.isListLayout()) {

    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToHelper"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToGrid"));
    stringBuffer.append(TEXT_309);
    
}

    stringBuffer.append(TEXT_310);
    
{
String _getViewCode = "getDiagramNode()";
String _getDiagramCode = _getViewCode + ".getDiagram()";
boolean isListLayout = genCompartment.isListLayout();

    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_319);
    
boolean hasConstraintsInChildren = false;
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet != null && typeModelFacet.getMetaClass() != null && typeModelFacet.getModelElementSelector() != null) {
		hasConstraintsInChildren = true;
		break;
	}
}

    
if (hasConstraintsInChildren) {

    stringBuffer.append(TEXT_320);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_323);
    
}

    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_325);
    
{
	boolean hasDeclaredFilter = false;
	Set genChildFeatures = new LinkedHashSet();
	for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode nextNode = (GenNode) it.next();
		TypeModelFacet typeModelFacet = nextNode.getModelFacet();
		if (typeModelFacet == null) {
			continue;
		}
		GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
		if (genChildFeatures.contains(childMetaFeature)) {
			continue;
		}
		genChildFeatures.add(childMetaFeature);
		if (!hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_330);
    
		} else {

    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_334);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_337);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_341);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_342);
    
		} else {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_344);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_347);
    
	}

    stringBuffer.append(TEXT_348);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_351);
    
{
	String _parentNode = "getHost()";

    stringBuffer.append(TEXT_352);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_354);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_359);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_363);
    
	} else {

    stringBuffer.append(TEXT_364);
    
	}

    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_366);
    
}

    stringBuffer.append(TEXT_367);
    
}

    stringBuffer.append(TEXT_368);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(TEXT_370);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_372);
    
} else {

    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_375);
    
	Map genFeature2genNodeMap = new LinkedHashMap();
	for (int nodeIndex = 0; nodeIndex < childNodes.size(); nodeIndex++) {
		GenNode nextNode = (GenNode) childNodes.get(nodeIndex);
		TypeModelFacet typeModelFacet = nextNode.getModelFacet();
		if (typeModelFacet == null) {
			continue;
		}
		GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
		if (!genFeature2genNodeMap.containsKey(childMetaFeature)) {
			genFeature2genNodeMap.put(childMetaFeature, new ArrayList());
		}
		((Collection) genFeature2genNodeMap.get(childMetaFeature)).add(nextNode);
	}
	Set entrySet = genFeature2genNodeMap.entrySet();
	if (entrySet.size() > 0) {

    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_380);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_382);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_384);
    
		} else {

    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_386);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_387);
    
	}

    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_389);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_390);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_392);
    
		} else {

    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_394);
    
		}

    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_396);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_397);
    
		} else {

    stringBuffer.append(TEXT_398);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_399);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_400);
    
	}
}

    stringBuffer.append(TEXT_401);
    
}

    stringBuffer.append(TEXT_402);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_403);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_413);
    
}

    stringBuffer.append(TEXT_414);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_428);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_429);
    return stringBuffer.toString();
  }
}
