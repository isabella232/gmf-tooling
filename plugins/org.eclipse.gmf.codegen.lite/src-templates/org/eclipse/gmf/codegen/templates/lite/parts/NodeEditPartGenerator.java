package org.eclipse.gmf.codegen.templates.lite.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.gmfgen.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.ecore.*;

public class NodeEditPartGenerator
{
  protected static String nl;
  public static synchronized NodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeEditPartGenerator result = new NodeEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "((";
  protected final String TEXT_4 = ")";
  protected final String TEXT_5 = "((";
  protected final String TEXT_6 = ")";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = ".eGet(";
  protected final String TEXT_9 = ".eINSTANCE.get";
  protected final String TEXT_10 = "())";
  protected final String TEXT_11 = ")";
  protected final String TEXT_12 = "((";
  protected final String TEXT_13 = ")";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = "()";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "/*" + NL + " * ";
  protected final String TEXT_21 = NL + " */";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_24 = " extends ";
  protected final String TEXT_25 = " implements ";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = " {";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_32 = " contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_33 = " primaryShape;" + NL;
  protected final String TEXT_34 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_35 = " childNodesPane;";
  protected final String TEXT_36 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_37 = "(";
  protected final String TEXT_38 = " model) {" + NL + "\t\tassert model instanceof ";
  protected final String TEXT_39 = ";" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL;
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_42 = " view = (";
  protected final String TEXT_43 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_44 = " view = (";
  protected final String TEXT_45 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = "\t\tinstallEditPolicy(";
  protected final String TEXT_48 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_49 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_50 = " createDeleteCommand(";
  protected final String TEXT_51 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_52 = " editingDomain = ";
  protected final String TEXT_53 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_54 = " cc = new ";
  protected final String TEXT_55 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_56 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_57 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_58 = " editingDomain) {";
  protected final String TEXT_59 = NL + "\t\t\t\t";
  protected final String TEXT_60 = " result = new ";
  protected final String TEXT_61 = "();";
  protected final String TEXT_62 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_63 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_64 = ".eINSTANCE.get";
  protected final String TEXT_65 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_66 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_67 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_68 = ".eINSTANCE.get";
  protected final String TEXT_69 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_70 = ".UNSET_VALUE));";
  protected final String TEXT_71 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_72 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_73 = ".eINSTANCE.get";
  protected final String TEXT_74 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_75 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_76 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_77 = ".eINSTANCE.get";
  protected final String TEXT_78 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = ".UNSET_VALUE));";
  protected final String TEXT_80 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_81 = NL + "\t\t\t\treturn ";
  protected final String TEXT_82 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_83 = ".eINSTANCE.get";
  protected final String TEXT_84 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_85 = NL + "\t\t\t\treturn ";
  protected final String TEXT_86 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_87 = ".eINSTANCE.get";
  protected final String TEXT_88 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = ".UNSET_VALUE);";
  protected final String TEXT_90 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_91 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_92 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_93 = "() {";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "protected Command createAddCommand(final ";
  protected final String TEXT_96 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_97 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_98 = " childNode = (";
  protected final String TEXT_99 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_100 = " editingDomain = ";
  protected final String TEXT_101 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_102 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_103 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int visualID = ";
  protected final String TEXT_104 = ".getVisualID(childNode);" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_105 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_106 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_107 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_108 = NL + "\t\t\tcase ";
  protected final String TEXT_109 = ".VISUAL_ID:" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_110 = " result = new ";
  protected final String TEXT_111 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = " element = childNode.getElement();";
  protected final String TEXT_113 = NL + "\t\t\t\t\tswitch (visualID) {";
  protected final String TEXT_114 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_115 = ".VISUAL_ID:";
  protected final String TEXT_116 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_117 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_118 = ".eINSTANCE.get";
  protected final String TEXT_119 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_120 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_121 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_122 = ".eINSTANCE.get";
  protected final String TEXT_123 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_124 = ".UNSET_VALUE));";
  protected final String TEXT_125 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_126 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_127 = ".eINSTANCE.get";
  protected final String TEXT_128 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_129 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_130 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_131 = ".eINSTANCE.get";
  protected final String TEXT_132 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_133 = ".UNSET_VALUE));";
  protected final String TEXT_134 = NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_135 = NL + "\t\t\t\t\t}\t";
  protected final String TEXT_136 = NL;
  protected final String TEXT_137 = NL + "\t\tif (";
  protected final String TEXT_138 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t}";
  protected final String TEXT_140 = NL + "\t\tif (";
  protected final String TEXT_141 = ".size() >= ";
  protected final String TEXT_142 = ".eINSTANCE.get";
  protected final String TEXT_143 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t}";
  protected final String TEXT_145 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_146 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_147 = ".getElement(), ";
  protected final String TEXT_148 = ".eINSTANCE.get";
  protected final String TEXT_149 = "(), element));";
  protected final String TEXT_150 = NL;
  protected final String TEXT_151 = NL + "\t\tif (";
  protected final String TEXT_152 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_153 = NL + "\t\t}";
  protected final String TEXT_154 = NL + "\t\tif (";
  protected final String TEXT_155 = ".size() >= ";
  protected final String TEXT_156 = ".eINSTANCE.get";
  protected final String TEXT_157 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t}";
  protected final String TEXT_159 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_160 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_161 = ".getElement(), ";
  protected final String TEXT_162 = ".eINSTANCE.get";
  protected final String TEXT_163 = "(), element));";
  protected final String TEXT_164 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_165 = ".create(editingDomain, childNode.eContainer(), childNode.eContainmentFeature(), childNode));" + NL + "\t\t\t\t\tif (newVisualID == visualID) {" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_166 = ".create(editingDomain, ";
  protected final String TEXT_167 = ", ";
  protected final String TEXT_168 = ".eINSTANCE.getView_PersistedChildren(), childNode));" + NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_169 = "(childNode, ";
  protected final String TEXT_170 = "null";
  protected final String TEXT_171 = "(";
  protected final String TEXT_172 = ") constraint";
  protected final String TEXT_173 = "));" + NL + "\t\t\t\t\t} else {";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = ", element, ";
  protected final String TEXT_177 = "null";
  protected final String TEXT_178 = "((";
  protected final String TEXT_179 = ") constraint).getCopy().union(new ";
  protected final String TEXT_180 = "(";
  protected final String TEXT_181 = ", ";
  protected final String TEXT_182 = "))";
  protected final String TEXT_183 = ", ";
  protected final String TEXT_184 = ".INSTANCE));";
  protected final String TEXT_185 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcommand = result;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_186 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_187 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_188 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_189 = NL;
  protected final String TEXT_190 = NL + "protected ";
  protected final String TEXT_191 = " getCloneCommand(";
  protected final String TEXT_192 = " request) {" + NL + "\t";
  protected final String TEXT_193 = " editParts = request.getEditParts();" + NL + "\t";
  protected final String TEXT_194 = " command = new ";
  protected final String TEXT_195 = "();" + NL + "\tcommand.setDebugLabel(\"Clone in ConstrainedLayoutEditPolicy\");//$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_196 = " childPart;" + NL + "\t";
  protected final String TEXT_197 = " r;" + NL + "\tObject constraint;" + NL + "" + NL + "\tfor (int i = 0; i < editParts.size(); i++) {" + NL + "\t\tchildPart = (";
  protected final String TEXT_198 = ")editParts.get(i);" + NL + "\t\tr = childPart.getFigure().getBounds().getCopy();" + NL + "\t\t//convert r to absolute from childpart figure" + NL + "\t\tchildPart.getFigure().translateToAbsolute(r);" + NL + "\t\tr = request.getTransformedRectangle(r);" + NL + "\t\t//convert this figure to relative " + NL + "\t\tgetLayoutContainer().translateToRelative(r);" + NL + "\t\tgetLayoutContainer().translateFromParent(r);" + NL + "\t\tr.translate(getLayoutOrigin().getNegated());" + NL + "\t\tconstraint = getConstraintFor(r);" + NL + "\t\tcommand.add(createCloneCommand(childPart," + NL + "\t\t\ttranslateToModelConstraint(constraint)));" + NL + "\t}" + NL + "\treturn command.unwrap();" + NL + "}" + NL + "protected ";
  protected final String TEXT_199 = " createCloneCommand(final ";
  protected final String TEXT_200 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_201 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_202 = " childNode = (";
  protected final String TEXT_203 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_204 = " editingDomain = ";
  protected final String TEXT_205 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_206 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_207 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_208 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_209 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_210 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_211 = NL + "\t\t\tcase ";
  protected final String TEXT_212 = ".VISUAL_ID:" + NL + "\t\t\t\tcommand = new ";
  protected final String TEXT_213 = "() {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_214 = " afterCopyCommand;" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_215 = " createCommand() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_216 = " element = childNode.getElement();" + NL + "\t\t\t\t\t\t//We are being optimistic here about whether further commands can be executed." + NL + "\t\t\t\t\t\t//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.  " + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_217 = ".create(editingDomain, element);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (!super.prepare()) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_218 = NL;
  protected final String TEXT_219 = NL + "\t\tif (";
  protected final String TEXT_220 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_221 = NL + "\t\t}";
  protected final String TEXT_222 = NL + "\t\tif (";
  protected final String TEXT_223 = ".size() >= ";
  protected final String TEXT_224 = ".eINSTANCE.get";
  protected final String TEXT_225 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_226 = NL + "\t\t}";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = NL + "\t\tif (";
  protected final String TEXT_229 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_230 = NL + "\t\t}";
  protected final String TEXT_231 = NL + "\t\tif (";
  protected final String TEXT_232 = ".size() >= ";
  protected final String TEXT_233 = ".eINSTANCE.get";
  protected final String TEXT_234 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_235 = NL + "\t\t}";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tsuper.execute();" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_237 = " results = super.getResult();" + NL + "\t\t\t\t\t\tassert results.size() == 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_238 = " result = (";
  protected final String TEXT_239 = ") results.iterator().next();" + NL + "\t\t\t\t\t\tafterCopyCommand = new ";
  protected final String TEXT_240 = "();";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_242 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_243 = ".getElement(), ";
  protected final String TEXT_244 = ".eINSTANCE.get";
  protected final String TEXT_245 = "(), result));";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_247 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_248 = ".getElement(), ";
  protected final String TEXT_249 = ".eINSTANCE.get";
  protected final String TEXT_250 = "(), result));";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\tafterCopyCommand.append(new ";
  protected final String TEXT_252 = "(";
  protected final String TEXT_253 = ", result, ";
  protected final String TEXT_254 = "null";
  protected final String TEXT_255 = "((";
  protected final String TEXT_256 = ") constraint).getCopy().union(new ";
  protected final String TEXT_257 = "(";
  protected final String TEXT_258 = ", ";
  protected final String TEXT_259 = "))";
  protected final String TEXT_260 = ", ";
  protected final String TEXT_261 = ".INSTANCE));" + NL + "\t\t\t\t\t\tif (afterCopyCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tafterCopyCommand.execute();" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tassert false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tafterCopyCommand.undo();" + NL + "\t\t\t\t\t\tsuper.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\tsuper.redo();" + NL + "\t\t\t\t\t\tafterCopyCommand.redo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_262 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_263 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_264 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_265 = NL + "\t\t\tprotected ";
  protected final String TEXT_266 = " getCreateCommand(";
  protected final String TEXT_267 = " request) {";
  protected final String TEXT_268 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_269 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_270 = " requestEx = (";
  protected final String TEXT_271 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_272 = " result = new ";
  protected final String TEXT_273 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_274 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_275 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_276 = "Command((View) getModel(), requestEx";
  protected final String TEXT_277 = ", " + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_278 = ")getConstraintFor(request)";
  protected final String TEXT_279 = "));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_281 = "(";
  protected final String TEXT_282 = ".getEditingDomain(((View) getModel()).getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_283 = NL + "\t\t\t\treturn ";
  protected final String TEXT_284 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_285 = NL + "\t\t\tprotected ";
  protected final String TEXT_286 = " createChangeConstraintCommand(final ";
  protected final String TEXT_287 = " request, final ";
  protected final String TEXT_288 = " child, Object constraint) {" + NL + "\t\t\t\tif (!isDirectChild(child)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_289 = ".INSTANCE;" + NL + "\t\t\t\t}";
  protected final String TEXT_290 = NL;
  protected final String TEXT_291 = "\t\t\t\tfinal ";
  protected final String TEXT_292 = " node = (";
  protected final String TEXT_293 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_294 = " emfCommand = new ";
  protected final String TEXT_295 = "(node, request, ((";
  protected final String TEXT_296 = ")child).getFigure());" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_297 = "(";
  protected final String TEXT_298 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_299 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_300 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_301 = NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_302 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_303 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_304 = " createChangeConstraintCommand(";
  protected final String TEXT_305 = " child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_306 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_307 = NL + "\t\t\tprotected ";
  protected final String TEXT_308 = " createChildEditPolicy(";
  protected final String TEXT_309 = " child) {";
  protected final String TEXT_310 = NL + "\t\t\t\tif (isDirectChild(child)) {" + NL + "\t\t\t\t\treturn super.createChildEditPolicy(child);" + NL + "\t\t\t\t}";
  protected final String TEXT_311 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_312 = "() {" + NL + "\t\t\t\t\tpublic ";
  protected final String TEXT_313 = " getTargetEditPart(";
  protected final String TEXT_314 = " request) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_315 = ".REQ_SELECTION.equals(request.getType())) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_316 = ".this;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_317 = ".GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_318 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_319 = " getReconnectTargetCommand(";
  protected final String TEXT_320 = " request) {";
  protected final String TEXT_321 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_322 = ".INSTANCE;";
  protected final String TEXT_323 = NL + "\t\t\t\t";
  protected final String TEXT_324 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_325 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_326 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_327 = " edge = (";
  protected final String TEXT_328 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_329 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_330 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_331 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_332 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_333 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_334 = NL + "\t\t\t\tcase ";
  protected final String TEXT_335 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_336 = "TargetCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_337 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_338 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_339 = "(";
  protected final String TEXT_340 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_341 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_342 = " getReconnectSourceCommand(";
  protected final String TEXT_343 = " request) {";
  protected final String TEXT_344 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_345 = ".INSTANCE;";
  protected final String TEXT_346 = NL + "\t\t\t\t";
  protected final String TEXT_347 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_348 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_349 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_350 = " edge = (";
  protected final String TEXT_351 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_352 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_353 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_354 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_355 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_356 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_357 = NL + "\t\t\t\tcase ";
  protected final String TEXT_358 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_359 = "SourceCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_360 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_361 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_362 = "(";
  protected final String TEXT_363 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_364 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_365 = " getConnectionCreateCommand(";
  protected final String TEXT_366 = " request) {";
  protected final String TEXT_367 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_368 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_369 = " requestEx = (";
  protected final String TEXT_370 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_371 = " result = new ";
  protected final String TEXT_372 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_373 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_374 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.appendIfCanExecute(new Create";
  protected final String TEXT_375 = "StartCommand(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_376 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (!result.canExecute()) {" + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_377 = " wrappedResult = new ";
  protected final String TEXT_378 = "(";
  protected final String TEXT_379 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_380 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_381 = " getConnectionCompleteCommand(";
  protected final String TEXT_382 = " request) {";
  protected final String TEXT_383 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_384 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_385 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_386 = " requestEx = (";
  protected final String TEXT_387 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_388 = " result = new ";
  protected final String TEXT_389 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_390 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_391 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.appendIfCanExecute(new Create";
  protected final String TEXT_392 = "Command(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_393 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_394 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_395 = "(";
  protected final String TEXT_396 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_397 = NL + "\t\t\t\treturn ";
  protected final String TEXT_398 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_399 = NL + "\t\t//This edit part understands the direct edit request and delegates it to the appropriate label, so no command is needed here." + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_400 = ".DIRECT_EDIT_ROLE, new ";
  protected final String TEXT_401 = "() {" + NL + "\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_402 = " request) {" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_403 = " getDirectEditCommand(";
  protected final String TEXT_404 = " request) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_405 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_406 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_407 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_408 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_409 = " invisibleRectangle = new ";
  protected final String TEXT_410 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_411 = "());" + NL + "\t\t";
  protected final String TEXT_412 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);";
  protected final String TEXT_413 = NL + "\t\tchildNodesPane = createChildNodesPane();" + NL + "\t\tshape.add(childNodesPane);";
  protected final String TEXT_414 = NL + NL + "\t\t";
  protected final String TEXT_415 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL;
  protected final String TEXT_416 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_417 = " createChildNodesPane() {" + NL + "\t\t";
  protected final String TEXT_418 = " result = new ";
  protected final String TEXT_419 = "();" + NL + "\t\tsetupContentPane(result);" + NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_420 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_421 = " createNodeShape() {";
  protected final String TEXT_422 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_423 = "()";
  protected final String TEXT_424 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_425 = ";";
  protected final String TEXT_426 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_427 = ";";
  protected final String TEXT_428 = NL + "\t\t";
  protected final String TEXT_429 = " figure = new ";
  protected final String TEXT_430 = "();";
  protected final String TEXT_431 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_432 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_433 = NL + "\t\treturn primaryShape;" + NL + "\t}";
  protected final String TEXT_434 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_435 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_436 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_437 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_438 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_439 = " view = (";
  protected final String TEXT_440 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_441 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_442 = " decorationPane = new ";
  protected final String TEXT_443 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_444 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_445 = " imageFigure = new ";
  protected final String TEXT_446 = "(";
  protected final String TEXT_447 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_448 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_449 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_450 = " setupContentPane(";
  protected final String TEXT_451 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_452 = NL + "\t\t\t";
  protected final String TEXT_453 = " layout = new ";
  protected final String TEXT_454 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_455 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_456 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_457 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_458 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_459 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_460 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_461 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_462 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_463 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_464 = " childEditPart) {";
  protected final String TEXT_465 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_466 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_467 = ") childEditPart).";
  protected final String TEXT_468 = "(getPrimaryShape().";
  protected final String TEXT_469 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_470 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_471 = ") {" + NL + "\t\t\t";
  protected final String TEXT_472 = " pane = getPrimaryShape().";
  protected final String TEXT_473 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_474 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_475 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_476 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_477 = ") {" + NL + "\t\t\t";
  protected final String TEXT_478 = " pane = getPrimaryShape().";
  protected final String TEXT_479 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_480 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_481 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_482 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_483 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_484 = NL + "\t\tfor(";
  protected final String TEXT_485 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_486 = " nextChild = (";
  protected final String TEXT_487 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_488 = ".getVisualID(nextChild) == ";
  protected final String TEXT_489 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_490 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_491 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_492 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_493 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_494 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_495 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_496 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_497 = " getLabelEditPart(";
  protected final String TEXT_498 = " req) {" + NL + "\t\t";
  protected final String TEXT_499 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_500 = " view = (";
  protected final String TEXT_501 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_502 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_503 = NL + "\t\t\t\tcase ";
  protected final String TEXT_504 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_505 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_506 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_507 = " childEditPart) {";
  protected final String TEXT_508 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_509 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_510 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_511 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_512 = " root = (";
  protected final String TEXT_513 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_514 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_515 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isDirectChild(";
  protected final String TEXT_516 = " childEditPart) {";
  protected final String TEXT_517 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_518 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_519 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_520 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_521 = " childEditPart, int index) {";
  protected final String TEXT_522 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_523 = " labelFigure = ((";
  protected final String TEXT_524 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_525 = NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_526 = NL + "\t\tif (isDirectChild(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_527 = " childFigure = ((";
  protected final String TEXT_528 = ") childEditPart).getFigure();" + NL + "\t\t\tchildNodesPane.add(childFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_529 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_530 = " childEditPart) {";
  protected final String TEXT_531 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_532 = " labelFigure = ((";
  protected final String TEXT_533 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_534 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_535 = NL + "\t\tif (isDirectChild(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_536 = " childFigure = ((";
  protected final String TEXT_537 = ") childEditPart).getFigure();" + NL + "\t\t\tchildNodesPane.remove(childFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_538 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_539 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_540 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_541 = " childEditPart = (";
  protected final String TEXT_542 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_543 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_544 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_545 = " node = getDiagramNode();" + NL + "\t\tif (node.getLayoutConstraint() == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_546 = ";" + NL + "\t\t";
  protected final String TEXT_547 = " bounds = (";
  protected final String TEXT_548 = ") node.getLayoutConstraint();" + NL + "\t\tint x = bounds.getX();" + NL + "\t\tint y = bounds.getY();" + NL + "\t\tint width = bounds.getWidth();" + NL + "\t\tint height = bounds.getHeight();" + NL + "\t\tif (width < 0) {" + NL + "\t\t\tx -= width;" + NL + "\t\t\twidth = -width;" + NL + "\t\t}" + NL + "\t\tif (height < 0) {" + NL + "\t\t\ty -= height;" + NL + "\t\t\theight = -height;" + NL + "\t\t}" + NL + "\t\t((";
  protected final String TEXT_549 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_550 = "(x, y, width, height));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_551 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_552 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_553 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_554 = " getSourceConnectionAnchor(";
  protected final String TEXT_555 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_556 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_557 = " getSourceConnectionAnchor(";
  protected final String TEXT_558 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_559 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_560 = "  getTargetConnectionAnchor(";
  protected final String TEXT_561 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_562 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_563 = "  getTargetConnectionAnchor(";
  protected final String TEXT_564 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_565 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (";
  protected final String TEXT_566 = ".class == key) {" + NL + "\t\t\treturn getTreeEditPartAdapter();" + NL + "\t\t}";
  protected final String TEXT_567 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter myTreeEditPartAdapter;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter getTreeEditPartAdapter() {" + NL + "\t\tif (myTreeEditPartAdapter == null) {" + NL + "\t\t\tmyTreeEditPartAdapter = new TreeEditPartAdapter();" + NL + "\t\t}" + NL + "\t\treturn myTreeEditPartAdapter;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);";
  protected final String TEXT_568 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_569 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_570 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_571 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_572 = NL + "\t\tuninstallNotationModelRefresher();";
  protected final String TEXT_573 = NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}";
  protected final String TEXT_574 = NL;
  protected final String TEXT_575 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_576 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_577 = " domainModelEditDomain = ";
  protected final String TEXT_578 = ".getEditingDomain(";
  protected final String TEXT_579 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_580 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_581 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_582 = " {";
  protected final String TEXT_583 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_584 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_585 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_586 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_587 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_588 = " createFilter() {";
  protected final String TEXT_589 = NL + "\t\t\t";
  protected final String TEXT_590 = " filter = ";
  protected final String TEXT_591 = ".createFeatureFilter(";
  protected final String TEXT_592 = ".eINSTANCE.get";
  protected final String TEXT_593 = "());";
  protected final String TEXT_594 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_595 = ".createFeatureFilter(";
  protected final String TEXT_596 = ".eINSTANCE.get";
  protected final String TEXT_597 = "()));";
  protected final String TEXT_598 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_599 = ".createNotifierFilter(";
  protected final String TEXT_600 = ".getElement()));";
  protected final String TEXT_601 = NL + "\t\t\t";
  protected final String TEXT_602 = " filter = ";
  protected final String TEXT_603 = ".createNotifierFilter(";
  protected final String TEXT_604 = ".getElement());";
  protected final String TEXT_605 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_606 = NL + "\t\t\t";
  protected final String TEXT_607 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_608 = NL + "\t\t\t";
  protected final String TEXT_609 = " filter = ";
  protected final String TEXT_610 = ".NOT_TOUCH;";
  protected final String TEXT_611 = NL + "\t\t\treturn filter;";
  protected final String TEXT_612 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_613 = " getCreateNotationalElementCommand(";
  protected final String TEXT_614 = " descriptor) {";
  protected final String TEXT_615 = NL;
  protected final String TEXT_616 = "\t\t\t";
  protected final String TEXT_617 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_618 = NL + "\t\t\tcase ";
  protected final String TEXT_619 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_620 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_621 = "(";
  protected final String TEXT_622 = ", domainElement, ";
  protected final String TEXT_623 = "new ";
  protected final String TEXT_624 = "(0, 0, ";
  protected final String TEXT_625 = ", ";
  protected final String TEXT_626 = ")";
  protected final String TEXT_627 = NL + "null";
  protected final String TEXT_628 = ", ";
  protected final String TEXT_629 = ".INSTANCE);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_630 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_631 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_632 = " getSemanticChildNodes() {";
  protected final String TEXT_633 = NL;
  protected final String TEXT_634 = NL + "\treturn ";
  protected final String TEXT_635 = ".EMPTY_LIST;";
  protected final String TEXT_636 = NL + "\t";
  protected final String TEXT_637 = " result = new ";
  protected final String TEXT_638 = "();";
  protected final String TEXT_639 = NL + "\t";
  protected final String TEXT_640 = " viewObject = ";
  protected final String TEXT_641 = ";" + NL + "\t";
  protected final String TEXT_642 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_643 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_644 = NL + "\tfor(";
  protected final String TEXT_645 = " it = ";
  protected final String TEXT_646 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_647 = ") it.next();";
  protected final String TEXT_648 = NL + "\tnextValue = (";
  protected final String TEXT_649 = ")";
  protected final String TEXT_650 = ";";
  protected final String TEXT_651 = NL + "\tnodeVID = ";
  protected final String TEXT_652 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_653 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_654 = NL + "\tcase ";
  protected final String TEXT_655 = ".VISUAL_ID: {";
  protected final String TEXT_656 = NL + "\tif (";
  protected final String TEXT_657 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_658 = NL + "\t\tresult.add(new ";
  protected final String TEXT_659 = "(nextValue, nodeVID));";
  protected final String TEXT_660 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_661 = NL + "\t\t}";
  protected final String TEXT_662 = NL + "\t}";
  protected final String TEXT_663 = NL + "\t}";
  protected final String TEXT_664 = NL + "\treturn result;";
  protected final String TEXT_665 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_666 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_667 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_668 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_669 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_670 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_671 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_672 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_673 = " domainModelEditDomain = ";
  protected final String TEXT_674 = ".getEditingDomain(";
  protected final String TEXT_675 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_676 = "(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_677 = NL;
  protected final String TEXT_678 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_679 = " domainModelEditDomain = ";
  protected final String TEXT_680 = ".getEditingDomain(";
  protected final String TEXT_681 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * Service to find a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_682 = " viewService;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_683 = " getViewService() {" + NL + "\t\tif (viewService == null) {" + NL + "\t\t\tviewService = new ";
  protected final String TEXT_684 = "(getViewer());" + NL + "\t\t}" + NL + "\t\treturn viewService;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher(getViewService());" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_685 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher(";
  protected final String TEXT_686 = " viewService) {" + NL + "\t\t\tsuper(viewService);" + NL + "\t\t}";
  protected final String TEXT_687 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_688 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_689 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_690 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_691 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_692 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_693 = ".createEventTypeFilter(";
  protected final String TEXT_694 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_695 = ".createEventTypeFilter(";
  protected final String TEXT_696 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_697 = ".createEventTypeFilter(";
  protected final String TEXT_698 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_699 = ".createEventTypeFilter(";
  protected final String TEXT_700 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_701 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_702 = " createFilter() {";
  protected final String TEXT_703 = NL;
  protected final String TEXT_704 = NL + "\t\t\t";
  protected final String TEXT_705 = " filter = ";
  protected final String TEXT_706 = ".createFeatureFilter(";
  protected final String TEXT_707 = ".eINSTANCE.get";
  protected final String TEXT_708 = "());";
  protected final String TEXT_709 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_710 = ".createFeatureFilter(";
  protected final String TEXT_711 = ".eINSTANCE.get";
  protected final String TEXT_712 = "()));";
  protected final String TEXT_713 = NL;
  protected final String TEXT_714 = NL + "\t\t\t";
  protected final String TEXT_715 = " filter = ";
  protected final String TEXT_716 = ".createFeatureFilter(";
  protected final String TEXT_717 = ".eINSTANCE.get";
  protected final String TEXT_718 = "());";
  protected final String TEXT_719 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_720 = ".createFeatureFilter(";
  protected final String TEXT_721 = ".eINSTANCE.get";
  protected final String TEXT_722 = "()));";
  protected final String TEXT_723 = NL;
  protected final String TEXT_724 = NL + "\t\t\t";
  protected final String TEXT_725 = " filter = ";
  protected final String TEXT_726 = ".createFeatureFilter(";
  protected final String TEXT_727 = ".eINSTANCE.get";
  protected final String TEXT_728 = "());";
  protected final String TEXT_729 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_730 = ".createFeatureFilter(";
  protected final String TEXT_731 = ".eINSTANCE.get";
  protected final String TEXT_732 = "()));";
  protected final String TEXT_733 = NL;
  protected final String TEXT_734 = NL + "\t\t\t";
  protected final String TEXT_735 = " filter = ";
  protected final String TEXT_736 = ".createFeatureFilter(";
  protected final String TEXT_737 = ".eINSTANCE.get";
  protected final String TEXT_738 = "());";
  protected final String TEXT_739 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_740 = ".createFeatureFilter(";
  protected final String TEXT_741 = ".eINSTANCE.get";
  protected final String TEXT_742 = "()));";
  protected final String TEXT_743 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_744 = NL + "\t\t\t";
  protected final String TEXT_745 = " filter = getConstrainedChildLinksFilter();";
  protected final String TEXT_746 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_747 = NL + "\t\t\t";
  protected final String TEXT_748 = " filter = createUncontainedLinksFilter();";
  protected final String TEXT_749 = NL + "\t\t\t";
  protected final String TEXT_750 = " filter = ";
  protected final String TEXT_751 = ".NOT_TOUCH;";
  protected final String TEXT_752 = NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t\tprotected ";
  protected final String TEXT_753 = " getCreateNotationalElementCommand(";
  protected final String TEXT_754 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_755 = " linkDescriptor = (";
  protected final String TEXT_756 = ") descriptor;";
  protected final String TEXT_757 = NL;
  protected final String TEXT_758 = "\t\t\t";
  protected final String TEXT_759 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_760 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\t";
  protected final String TEXT_761 = " decorator = null;" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_762 = NL + "\t\t\tcase ";
  protected final String TEXT_763 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_764 = ") {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_765 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_766 = NL + "\t\t\tcase ";
  protected final String TEXT_767 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_768 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_769 = NL + "\t\t\t}" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_770 = "(";
  protected final String TEXT_771 = ", linkDescriptor.getElement(), sourceView, targetView, decorator);";
  protected final String TEXT_772 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_773 = " getSemanticChildLinks() {";
  protected final String TEXT_774 = NL;
  protected final String TEXT_775 = "\t";
  protected final String TEXT_776 = " result = new ";
  protected final String TEXT_777 = "();";
  protected final String TEXT_778 = NL + "\t";
  protected final String TEXT_779 = " modelObject = ";
  protected final String TEXT_780 = ".getElement();" + NL + "\t";
  protected final String TEXT_781 = " nextValue;";
  protected final String TEXT_782 = NL + "\tint linkVID;";
  protected final String TEXT_783 = NL + "\tfor(";
  protected final String TEXT_784 = " it = ";
  protected final String TEXT_785 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_786 = ") it.next();";
  protected final String TEXT_787 = NL + "\tnextValue = (";
  protected final String TEXT_788 = ")";
  protected final String TEXT_789 = ";";
  protected final String TEXT_790 = NL + "\tlinkVID = ";
  protected final String TEXT_791 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_792 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_793 = NL + "\tcase ";
  protected final String TEXT_794 = ".VISUAL_ID: {";
  protected final String TEXT_795 = NL + "\tif (";
  protected final String TEXT_796 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_797 = NL + "\t\t";
  protected final String TEXT_798 = " source = (";
  protected final String TEXT_799 = ")";
  protected final String TEXT_800 = ";";
  protected final String TEXT_801 = NL + "\t\t";
  protected final String TEXT_802 = " source = ";
  protected final String TEXT_803 = ".getElement();";
  protected final String TEXT_804 = NL + "\t\t";
  protected final String TEXT_805 = " target = (";
  protected final String TEXT_806 = ")";
  protected final String TEXT_807 = ";";
  protected final String TEXT_808 = NL + "\t\t";
  protected final String TEXT_809 = " target = ";
  protected final String TEXT_810 = ".getElement();";
  protected final String TEXT_811 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_812 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_813 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_814 = NL + "\t}";
  protected final String TEXT_815 = NL + "\t}";
  protected final String TEXT_816 = NL + "\t}";
  protected final String TEXT_817 = NL + "\tfor(";
  protected final String TEXT_818 = " it = ";
  protected final String TEXT_819 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_820 = ") it.next();";
  protected final String TEXT_821 = NL + "\tnextValue = (";
  protected final String TEXT_822 = ")";
  protected final String TEXT_823 = ";";
  protected final String TEXT_824 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_825 = NL + "\t\tresult.add(new ";
  protected final String TEXT_826 = "(modelObject, nextValue, null, ";
  protected final String TEXT_827 = ".VISUAL_ID));";
  protected final String TEXT_828 = NL + "\t}";
  protected final String TEXT_829 = NL + "\t}";
  protected final String TEXT_830 = NL + "\treturn result;";
  protected final String TEXT_831 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_832 = " getNotationalChildLinks() {" + NL + "\t\t\t";
  protected final String TEXT_833 = " result = new ";
  protected final String TEXT_834 = "();" + NL + "\t\t\t";
  protected final String TEXT_835 = " allLinks = ";
  protected final String TEXT_836 = ".getEdges();" + NL + "\t\t\tfor(";
  protected final String TEXT_837 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_838 = " next = (";
  protected final String TEXT_839 = ") it.next();";
  protected final String TEXT_840 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_841 = " source = next.getSource();" + NL + "\t\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_842 = " target = next.getTarget();" + NL + "\t\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}";
  protected final String TEXT_843 = NL + "\t\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_844 = ") {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_845 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_846 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_847 = ".VISUAL_ID:";
  protected final String TEXT_848 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_849 = NL + "\t\t\t\t} else {";
  protected final String TEXT_850 = NL + "\t\t\t\t}";
  protected final String TEXT_851 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_852 = NL + "\t\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_853 = ".getElement()) {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_854 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_855 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_856 = ".VISUAL_ID:";
  protected final String TEXT_857 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_858 = NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_859 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_860 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_861 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_862 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_863 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_864 = " linkRefresher = getLinkNotationModelRefresher();" + NL + "\t\tif (!linkRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_865 = " command = linkRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_866 = " domainModelEditDomain = ";
  protected final String TEXT_867 = ".getEditingDomain(";
  protected final String TEXT_868 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_869 = "(domainModelEditDomain, command));" + NL + "\t}";
  protected final String TEXT_870 = NL;
  protected final String TEXT_871 = NL;
  protected final String TEXT_872 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_873 = " domainModelRefresher = new ";
  protected final String TEXT_874 = "(this);" + NL;
  protected final String TEXT_875 = NL;
  protected final String TEXT_876 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_877 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_878 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_879 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_880 = NL;
  protected final String TEXT_881 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_882 = NL + "\t\t";
  protected final String TEXT_883 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_884 = ") ";
  protected final String TEXT_885 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_886 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_887 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_888 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_889 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_890 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_891 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_892 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_893 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_894 = "\t" + NL + "\t}";
  protected final String TEXT_895 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_896 = " createdFont;";
  protected final String TEXT_897 = "\t" + NL;
  protected final String TEXT_898 = NL;
  protected final String TEXT_899 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_900 = " style = (";
  protected final String TEXT_901 = ")  ";
  protected final String TEXT_902 = ".getStyle(";
  protected final String TEXT_903 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_904 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_905 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_906 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_907 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_908 = " style = (";
  protected final String TEXT_909 = ")  ";
  protected final String TEXT_910 = ".getStyle(";
  protected final String TEXT_911 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_912 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_913 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_914 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_915 = " createdBackgroundColor;" + NL;
  protected final String TEXT_916 = NL;
  protected final String TEXT_917 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_918 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_919 = " feature, ";
  protected final String TEXT_920 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_921 = "();";
  protected final String TEXT_922 = NL;
  protected final String TEXT_923 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_924 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_925 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_926 = NL;
  protected final String TEXT_927 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_928 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_929 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_930 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_931 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_932 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_933 = NL;
  protected final String TEXT_934 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_935 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_936 = NL;
  protected final String TEXT_937 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_938 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_939 = NL;
  protected final String TEXT_940 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_941 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_942 = NL;
  protected final String TEXT_943 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_944 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_945 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_946 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_947 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_948 = NL;
  protected final String TEXT_949 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_950 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_951 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_952 = NL;
  protected final String TEXT_953 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_954 = "static ";
  protected final String TEXT_955 = "class Create";
  protected final String TEXT_956 = "Command extends ";
  protected final String TEXT_957 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_958 = " notationAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_959 = "Command(";
  protected final String TEXT_960 = " parent, ";
  protected final String TEXT_961 = " request";
  protected final String TEXT_962 = ", ";
  protected final String TEXT_963 = " constraint";
  protected final String TEXT_964 = ") {" + NL + "\t\t\t";
  protected final String TEXT_965 = " domainModelEditDomain = ";
  protected final String TEXT_966 = ".getEditingDomain(parent.getDiagram().getElement());";
  protected final String TEXT_967 = NL + "\t\t\t";
  protected final String TEXT_968 = " createdDomainElement = ";
  protected final String TEXT_969 = ".eINSTANCE.create(" + NL + "\t\t\t\t";
  protected final String TEXT_970 = ".eINSTANCE.get";
  protected final String TEXT_971 = "());";
  protected final String TEXT_972 = NL + "\t\t\t";
  protected final String TEXT_973 = " createdDomainElement = ";
  protected final String TEXT_974 = ".eINSTANCE.create";
  protected final String TEXT_975 = "();";
  protected final String TEXT_976 = NL + "\t\t\t";
  protected final String TEXT_977 = NL + "\t\t\t";
  protected final String TEXT_978 = ".";
  protected final String TEXT_979 = ".initializeElement(";
  protected final String TEXT_980 = "(";
  protected final String TEXT_981 = ") ";
  protected final String TEXT_982 = "createdDomainElement);";
  protected final String TEXT_983 = NL;
  protected final String TEXT_984 = NL + "\t\tif (";
  protected final String TEXT_985 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_986 = NL + "\t\t}";
  protected final String TEXT_987 = NL + "\t\tif (";
  protected final String TEXT_988 = ".size() >= ";
  protected final String TEXT_989 = ".eINSTANCE.get";
  protected final String TEXT_990 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_991 = NL + "\t\t}";
  protected final String TEXT_992 = NL;
  protected final String TEXT_993 = NL + "\t\tif (";
  protected final String TEXT_994 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_995 = NL + "\t\t}";
  protected final String TEXT_996 = NL + "\t\tif (";
  protected final String TEXT_997 = ".size() >= ";
  protected final String TEXT_998 = ".eINSTANCE.get";
  protected final String TEXT_999 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1000 = NL + "\t\t}";
  protected final String TEXT_1001 = NL + "\t\t\t";
  protected final String TEXT_1002 = " compoundCommand = new ";
  protected final String TEXT_1003 = "();" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_1004 = ".create(domainModelEditDomain, parent.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1005 = ".eINSTANCE.get";
  protected final String TEXT_1006 = "(), createdDomainElement));" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_1007 = ".create(domainModelEditDomain, parent.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1008 = ".eINSTANCE.get";
  protected final String TEXT_1009 = "(), createdDomainElement));" + NL + "\t\t\tthis.domainModelAddCommand = compoundCommand;";
  protected final String TEXT_1010 = NL + "\t\t\tthis.domainModelAddCommand = ";
  protected final String TEXT_1011 = ".create(domainModelEditDomain, parent.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1012 = ".eINSTANCE.get";
  protected final String TEXT_1013 = "(), createdDomainElement);";
  protected final String TEXT_1014 = NL + "\t\t\tconstraint = constraint.union(new ";
  protected final String TEXT_1015 = "(";
  protected final String TEXT_1016 = ", ";
  protected final String TEXT_1017 = "));";
  protected final String TEXT_1018 = NL + "\t\t\tthis.notationAddCommand = new ";
  protected final String TEXT_1019 = "(parent, ";
  protected final String TEXT_1020 = "(";
  protected final String TEXT_1021 = ") ";
  protected final String TEXT_1022 = "createdDomainElement, " + NL + "\t\t\t\t";
  protected final String TEXT_1023 = "constraint";
  protected final String TEXT_1024 = "null";
  protected final String TEXT_1025 = ", ";
  protected final String TEXT_1026 = ".INSTANCE);" + NL + "\t\t\trequest.setCreatedObject(notationAddCommand.getCreatedView());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tnotationAddCommand.execute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tnotationAddCommand.undo();" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_1027 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_1028 = "SourceCommand extends ";
  protected final String TEXT_1029 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1030 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1031 = " newSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1032 = " oldSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1033 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_1034 = "SourceCommand(";
  protected final String TEXT_1035 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_1036 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_1037 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_1038 = "SourceCommand(";
  protected final String TEXT_1039 = " edge, ";
  protected final String TEXT_1040 = " newSource) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newSource = newSource;" + NL + "\t\t\tthis.oldSource = edge.getSource();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_1041 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_1042 = " domainModelEditDomain = ";
  protected final String TEXT_1043 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_1044 = " command = new ";
  protected final String TEXT_1045 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_1046 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew ";
  protected final String TEXT_1047 = "(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_1048 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_1049 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_1050 = NL + "\t\t\treturn false;";
  protected final String TEXT_1051 = NL + "\t\t\t";
  protected final String TEXT_1052 = " container = (";
  protected final String TEXT_1053 = ")getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_1054 = ".eINSTANCE.get";
  protected final String TEXT_1055 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1056 = NL;
  protected final String TEXT_1057 = NL + "\t\tif (";
  protected final String TEXT_1058 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1059 = NL + "\t\t}";
  protected final String TEXT_1060 = NL + "\t\tif (";
  protected final String TEXT_1061 = ".size() >= ";
  protected final String TEXT_1062 = ".eINSTANCE.get";
  protected final String TEXT_1063 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1064 = NL + "\t\t}";
  protected final String TEXT_1065 = NL;
  protected final String TEXT_1066 = NL + "\t\tif (";
  protected final String TEXT_1067 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1068 = NL + "\t\t}";
  protected final String TEXT_1069 = NL + "\t\tif (";
  protected final String TEXT_1070 = ".size() >= ";
  protected final String TEXT_1071 = ".eINSTANCE.get";
  protected final String TEXT_1072 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1073 = NL + "\t\t}";
  protected final String TEXT_1074 = NL;
  protected final String TEXT_1075 = NL + "\t\tif (";
  protected final String TEXT_1076 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1077 = NL + "\t\t}";
  protected final String TEXT_1078 = NL + "\t\tif (";
  protected final String TEXT_1079 = ".size() >= ";
  protected final String TEXT_1080 = ".eINSTANCE.get";
  protected final String TEXT_1081 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1082 = NL + "\t\t}";
  protected final String TEXT_1083 = NL;
  protected final String TEXT_1084 = NL + "\t\t\tif(!";
  protected final String TEXT_1085 = ".canCreateLink(";
  protected final String TEXT_1086 = ", ";
  protected final String TEXT_1087 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1088 = NL + "\t\t\treturn true;";
  protected final String TEXT_1089 = NL;
  protected final String TEXT_1090 = NL + "\t\tif (";
  protected final String TEXT_1091 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1092 = NL + "\t\t}";
  protected final String TEXT_1093 = NL + "\t\tif (";
  protected final String TEXT_1094 = ".size() >= ";
  protected final String TEXT_1095 = ".eINSTANCE.get";
  protected final String TEXT_1096 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1097 = NL + "\t\t}";
  protected final String TEXT_1098 = NL;
  protected final String TEXT_1099 = NL + "\t\t\tif(!";
  protected final String TEXT_1100 = ".canCreateLink(";
  protected final String TEXT_1101 = ", ";
  protected final String TEXT_1102 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1103 = NL + "\t\t\treturn true;";
  protected final String TEXT_1104 = NL + "\t\t\treturn false;";
  protected final String TEXT_1105 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1106 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_1107 = " editingDomain = ";
  protected final String TEXT_1108 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_1109 = " result = new ";
  protected final String TEXT_1110 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_1111 = "(edge, newSource));";
  protected final String TEXT_1112 = NL + "\t\t\t";
  protected final String TEXT_1113 = " container = getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_1114 = ".eINSTANCE.get";
  protected final String TEXT_1115 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1116 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_1117 = " oldContainer = edge.getElement().eContainer();" + NL + "\t\t\tif (oldContainer == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1118 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tif (oldContainer != container) {";
  protected final String TEXT_1119 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1120 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_1121 = ".eINSTANCE.get";
  protected final String TEXT_1122 = "(), edge.getElement()));";
  protected final String TEXT_1123 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1124 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_1125 = ".eINSTANCE.get";
  protected final String TEXT_1126 = "(), ";
  protected final String TEXT_1127 = ".UNSET_VALUE));";
  protected final String TEXT_1128 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1129 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_1130 = ".eINSTANCE.get";
  protected final String TEXT_1131 = "(), edge.getElement()));";
  protected final String TEXT_1132 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1133 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_1134 = ".eINSTANCE.get";
  protected final String TEXT_1135 = "()," + NL + "\t\t\t\t\tedge.getElement()));";
  protected final String TEXT_1136 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1137 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_1138 = ".eINSTANCE.get";
  protected final String TEXT_1139 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1140 = ".UNSET_VALUE));";
  protected final String TEXT_1141 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1142 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_1143 = ".eINSTANCE.get";
  protected final String TEXT_1144 = "(), edge.getElement()));";
  protected final String TEXT_1145 = NL + "\t\t\t}";
  protected final String TEXT_1146 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1147 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1148 = ".eINSTANCE.get";
  protected final String TEXT_1149 = "()," + NL + "\t\t\t\toldSource.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1150 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1151 = ".eINSTANCE.get";
  protected final String TEXT_1152 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_1153 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1154 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1155 = ".eINSTANCE.get";
  protected final String TEXT_1156 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_1157 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1158 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_1159 = ".eINSTANCE.get";
  protected final String TEXT_1160 = "(), edge.getTarget().getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1161 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_1162 = ".eINSTANCE.get";
  protected final String TEXT_1163 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_1164 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1165 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_1166 = ".eINSTANCE.get";
  protected final String TEXT_1167 = "(), ";
  protected final String TEXT_1168 = ".UNSET_VALUE));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1169 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_1170 = ".eINSTANCE.get";
  protected final String TEXT_1171 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_1172 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL;
  protected final String TEXT_1173 = NL;
  protected final String TEXT_1174 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1175 = " getRelationshipContainer(";
  protected final String TEXT_1176 = " element, ";
  protected final String TEXT_1177 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1178 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1179 = NL;
  protected final String TEXT_1180 = NL + "\t\t\tprivate ";
  protected final String TEXT_1181 = " createDomainModelRemoveCommand(";
  protected final String TEXT_1182 = " editingDomain) {";
  protected final String TEXT_1183 = NL + "\t\t\t\t";
  protected final String TEXT_1184 = " result = new ";
  protected final String TEXT_1185 = "();";
  protected final String TEXT_1186 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1187 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1188 = ".getElement().eContainer(), ";
  protected final String TEXT_1189 = ".eINSTANCE.get";
  protected final String TEXT_1190 = "(), ";
  protected final String TEXT_1191 = ".getElement()));";
  protected final String TEXT_1192 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1193 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1194 = ".getElement().eContainer(), ";
  protected final String TEXT_1195 = ".eINSTANCE.get";
  protected final String TEXT_1196 = "(), ";
  protected final String TEXT_1197 = ".UNSET_VALUE));";
  protected final String TEXT_1198 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1199 = ".INSTANCE;";
  protected final String TEXT_1200 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1201 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1202 = ".getElement().eContainer(), ";
  protected final String TEXT_1203 = ".eINSTANCE.get";
  protected final String TEXT_1204 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1205 = ".getElement()));";
  protected final String TEXT_1206 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1207 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1208 = ".getElement().eContainer(), ";
  protected final String TEXT_1209 = ".eINSTANCE.get";
  protected final String TEXT_1210 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1211 = ".UNSET_VALUE));";
  protected final String TEXT_1212 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1213 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1214 = ".getElement(), ";
  protected final String TEXT_1215 = ".eINSTANCE.get";
  protected final String TEXT_1216 = "(), ";
  protected final String TEXT_1217 = ".getSource().getElement()));";
  protected final String TEXT_1218 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1219 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1220 = ".getElement(), ";
  protected final String TEXT_1221 = ".eINSTANCE.get";
  protected final String TEXT_1222 = "(), ";
  protected final String TEXT_1223 = ".UNSET_VALUE));";
  protected final String TEXT_1224 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1225 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1226 = ".getElement(), ";
  protected final String TEXT_1227 = ".eINSTANCE.get";
  protected final String TEXT_1228 = "(), ";
  protected final String TEXT_1229 = ".getTarget().getElement()));";
  protected final String TEXT_1230 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1231 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1232 = ".getElement(), ";
  protected final String TEXT_1233 = ".eINSTANCE.get";
  protected final String TEXT_1234 = "(), ";
  protected final String TEXT_1235 = ".UNSET_VALUE));";
  protected final String TEXT_1236 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1237 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1238 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1239 = ".getSource().getElement(), ";
  protected final String TEXT_1240 = ".eINSTANCE.get";
  protected final String TEXT_1241 = "(), ";
  protected final String TEXT_1242 = ".getTarget().getElement());";
  protected final String TEXT_1243 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1244 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1245 = ".getSource().getElement(), ";
  protected final String TEXT_1246 = ".eINSTANCE.get";
  protected final String TEXT_1247 = "(), ";
  protected final String TEXT_1248 = ".UNSET_VALUE);";
  protected final String TEXT_1249 = NL + "\t\t\t}";
  protected final String TEXT_1250 = NL + "\t}" + NL;
  protected final String TEXT_1251 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_1252 = "StartCommand extends ";
  protected final String TEXT_1253 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1254 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_1255 = "StartCommand(";
  protected final String TEXT_1256 = " requestEx) {" + NL + "\t\t\t//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart()." + NL + "\t\t\tsource = (";
  protected final String TEXT_1257 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\tif (source == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1258 = NL + "\t\t\treturn false;";
  protected final String TEXT_1259 = NL + "\t\t\t";
  protected final String TEXT_1260 = " container = (";
  protected final String TEXT_1261 = ")getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_1262 = ".eINSTANCE.get";
  protected final String TEXT_1263 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1264 = NL;
  protected final String TEXT_1265 = NL + "\t\tif (";
  protected final String TEXT_1266 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1267 = NL + "\t\t}";
  protected final String TEXT_1268 = NL + "\t\tif (";
  protected final String TEXT_1269 = ".size() >= ";
  protected final String TEXT_1270 = ".eINSTANCE.get";
  protected final String TEXT_1271 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1272 = NL + "\t\t}";
  protected final String TEXT_1273 = NL;
  protected final String TEXT_1274 = NL + "\t\tif (";
  protected final String TEXT_1275 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1276 = NL + "\t\t}";
  protected final String TEXT_1277 = NL + "\t\tif (";
  protected final String TEXT_1278 = ".size() >= ";
  protected final String TEXT_1279 = ".eINSTANCE.get";
  protected final String TEXT_1280 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1281 = NL + "\t\t}";
  protected final String TEXT_1282 = NL;
  protected final String TEXT_1283 = NL + "\t\tif (";
  protected final String TEXT_1284 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1285 = NL + "\t\t}";
  protected final String TEXT_1286 = NL + "\t\tif (";
  protected final String TEXT_1287 = ".size() >= ";
  protected final String TEXT_1288 = ".eINSTANCE.get";
  protected final String TEXT_1289 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1290 = NL + "\t\t}";
  protected final String TEXT_1291 = NL;
  protected final String TEXT_1292 = NL + "\t\t\tif(!";
  protected final String TEXT_1293 = ".canCreateLink(";
  protected final String TEXT_1294 = ", ";
  protected final String TEXT_1295 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1296 = NL + "\t\t\treturn true;";
  protected final String TEXT_1297 = NL;
  protected final String TEXT_1298 = NL + "\t\tif (";
  protected final String TEXT_1299 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1300 = NL + "\t\t}";
  protected final String TEXT_1301 = NL + "\t\tif (";
  protected final String TEXT_1302 = ".size() >= ";
  protected final String TEXT_1303 = ".eINSTANCE.get";
  protected final String TEXT_1304 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1305 = NL + "\t\t}";
  protected final String TEXT_1306 = NL;
  protected final String TEXT_1307 = NL + "\t\t\tif(!";
  protected final String TEXT_1308 = ".canCreateLink(";
  protected final String TEXT_1309 = ", ";
  protected final String TEXT_1310 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1311 = NL + "\t\t\treturn true;";
  protected final String TEXT_1312 = NL + "\t\t\treturn false;";
  protected final String TEXT_1313 = NL + "\t\t}";
  protected final String TEXT_1314 = NL;
  protected final String TEXT_1315 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1316 = " getRelationshipContainer(";
  protected final String TEXT_1317 = " element, ";
  protected final String TEXT_1318 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1319 = NL + NL + "\t}";
  protected final String TEXT_1320 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_1321 = "TargetCommand extends ";
  protected final String TEXT_1322 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1323 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1324 = " newTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1325 = " oldTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1326 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_1327 = "TargetCommand(";
  protected final String TEXT_1328 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_1329 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_1330 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_1331 = "TargetCommand(";
  protected final String TEXT_1332 = " edge, ";
  protected final String TEXT_1333 = " newTarget) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newTarget = newTarget;" + NL + "\t\t\tthis.oldTarget = edge.getTarget();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_1334 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_1335 = " domainModelEditDomain = ";
  protected final String TEXT_1336 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_1337 = " command = new ";
  protected final String TEXT_1338 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_1339 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew ";
  protected final String TEXT_1340 = "(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_1341 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_1342 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_1343 = NL;
  protected final String TEXT_1344 = NL + "\t\tif (";
  protected final String TEXT_1345 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1346 = NL + "\t\t}";
  protected final String TEXT_1347 = NL + "\t\tif (";
  protected final String TEXT_1348 = ".size() >= ";
  protected final String TEXT_1349 = ".eINSTANCE.get";
  protected final String TEXT_1350 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1351 = NL + "\t\t}";
  protected final String TEXT_1352 = NL;
  protected final String TEXT_1353 = NL + "\t\t\tif(!";
  protected final String TEXT_1354 = ".canCreateLink(";
  protected final String TEXT_1355 = ", ";
  protected final String TEXT_1356 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1357 = NL + "\t\t\treturn true;";
  protected final String TEXT_1358 = NL;
  protected final String TEXT_1359 = NL + "\t\tif (";
  protected final String TEXT_1360 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1361 = NL + "\t\t}";
  protected final String TEXT_1362 = NL + "\t\tif (";
  protected final String TEXT_1363 = ".size() >= ";
  protected final String TEXT_1364 = ".eINSTANCE.get";
  protected final String TEXT_1365 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1366 = NL + "\t\t}";
  protected final String TEXT_1367 = NL;
  protected final String TEXT_1368 = NL + "\t\t\tif(!";
  protected final String TEXT_1369 = ".canCreateLink(";
  protected final String TEXT_1370 = ", ";
  protected final String TEXT_1371 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1372 = NL + "\t\t\treturn true;";
  protected final String TEXT_1373 = NL + "\t\t\treturn false;";
  protected final String TEXT_1374 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1375 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_1376 = " editingDomain = ";
  protected final String TEXT_1377 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_1378 = " result = new ";
  protected final String TEXT_1379 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_1380 = "(edge, newTarget));";
  protected final String TEXT_1381 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1382 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1383 = ".eINSTANCE.get";
  protected final String TEXT_1384 = "()," + NL + "\t\t\t\toldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1385 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1386 = ".eINSTANCE.get";
  protected final String TEXT_1387 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_1388 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1389 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1390 = ".eINSTANCE.get";
  protected final String TEXT_1391 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_1392 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1393 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_1394 = ".eINSTANCE.get";
  protected final String TEXT_1395 = "(), oldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1396 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_1397 = ".eINSTANCE.get";
  protected final String TEXT_1398 = "(), newTarget.getElement()));";
  protected final String TEXT_1399 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1400 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_1401 = ".eINSTANCE.get";
  protected final String TEXT_1402 = "(), newTarget.getElement()));";
  protected final String TEXT_1403 = NL + "\t\t\treturn result;" + NL + "\t\t}";
  protected final String TEXT_1404 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1405 = NL;
  protected final String TEXT_1406 = NL + "\t\t\tprivate ";
  protected final String TEXT_1407 = " createDomainModelRemoveCommand(";
  protected final String TEXT_1408 = " editingDomain) {";
  protected final String TEXT_1409 = NL + "\t\t\t\t";
  protected final String TEXT_1410 = " result = new ";
  protected final String TEXT_1411 = "();";
  protected final String TEXT_1412 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1413 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1414 = ".getElement().eContainer(), ";
  protected final String TEXT_1415 = ".eINSTANCE.get";
  protected final String TEXT_1416 = "(), ";
  protected final String TEXT_1417 = ".getElement()));";
  protected final String TEXT_1418 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1419 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1420 = ".getElement().eContainer(), ";
  protected final String TEXT_1421 = ".eINSTANCE.get";
  protected final String TEXT_1422 = "(), ";
  protected final String TEXT_1423 = ".UNSET_VALUE));";
  protected final String TEXT_1424 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1425 = ".INSTANCE;";
  protected final String TEXT_1426 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1427 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1428 = ".getElement().eContainer(), ";
  protected final String TEXT_1429 = ".eINSTANCE.get";
  protected final String TEXT_1430 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1431 = ".getElement()));";
  protected final String TEXT_1432 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1433 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1434 = ".getElement().eContainer(), ";
  protected final String TEXT_1435 = ".eINSTANCE.get";
  protected final String TEXT_1436 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1437 = ".UNSET_VALUE));";
  protected final String TEXT_1438 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1439 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1440 = ".getElement(), ";
  protected final String TEXT_1441 = ".eINSTANCE.get";
  protected final String TEXT_1442 = "(), ";
  protected final String TEXT_1443 = ".getSource().getElement()));";
  protected final String TEXT_1444 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1445 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1446 = ".getElement(), ";
  protected final String TEXT_1447 = ".eINSTANCE.get";
  protected final String TEXT_1448 = "(), ";
  protected final String TEXT_1449 = ".UNSET_VALUE));";
  protected final String TEXT_1450 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1451 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1452 = ".getElement(), ";
  protected final String TEXT_1453 = ".eINSTANCE.get";
  protected final String TEXT_1454 = "(), ";
  protected final String TEXT_1455 = ".getTarget().getElement()));";
  protected final String TEXT_1456 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1457 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1458 = ".getElement(), ";
  protected final String TEXT_1459 = ".eINSTANCE.get";
  protected final String TEXT_1460 = "(), ";
  protected final String TEXT_1461 = ".UNSET_VALUE));";
  protected final String TEXT_1462 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1463 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1464 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1465 = ".getSource().getElement(), ";
  protected final String TEXT_1466 = ".eINSTANCE.get";
  protected final String TEXT_1467 = "(), ";
  protected final String TEXT_1468 = ".getTarget().getElement());";
  protected final String TEXT_1469 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1470 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1471 = ".getSource().getElement(), ";
  protected final String TEXT_1472 = ".eINSTANCE.get";
  protected final String TEXT_1473 = "(), ";
  protected final String TEXT_1474 = ".UNSET_VALUE);";
  protected final String TEXT_1475 = NL + "\t\t\t}";
  protected final String TEXT_1476 = NL + "\t}" + NL;
  protected final String TEXT_1477 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_1478 = "Command extends ";
  protected final String TEXT_1479 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1480 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1481 = " target;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1482 = " createdEdge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_1483 = "Command(";
  protected final String TEXT_1484 = " requestEx) {" + NL + "\t\t\tif (requestEx.getSourceEditPart().getModel() instanceof ";
  protected final String TEXT_1485 = ") {" + NL + "\t\t\t\tsource = (";
  protected final String TEXT_1486 = ")requestEx.getSourceEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tsource = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (requestEx.getTargetEditPart().getModel() instanceof ";
  protected final String TEXT_1487 = ") {" + NL + "\t\t\t\ttarget = (";
  protected final String TEXT_1488 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (source == null || target == null) {" + NL + "\t\t\t\tcreatedEdge = null;" + NL + "\t\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1489 = ".INSTANCE;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedEdge = ";
  protected final String TEXT_1490 = ".eINSTANCE.createEdge();";
  protected final String TEXT_1491 = NL + "\t\t\t";
  protected final String TEXT_1492 = " createdDomainElement = ";
  protected final String TEXT_1493 = ".eINSTANCE.create";
  protected final String TEXT_1494 = "();" + NL + "\t\t\tcreatedEdge.setElement(";
  protected final String TEXT_1495 = "(";
  protected final String TEXT_1496 = ") ";
  protected final String TEXT_1497 = "createdDomainElement);" + NL + "\t\t\t";
  protected final String TEXT_1498 = NL + "\t\t\t";
  protected final String TEXT_1499 = ".";
  protected final String TEXT_1500 = ".initializeElement(";
  protected final String TEXT_1501 = "(";
  protected final String TEXT_1502 = ") ";
  protected final String TEXT_1503 = "createdDomainElement);";
  protected final String TEXT_1504 = NL + "\t\t\tcreatedEdge.setElement(null);";
  protected final String TEXT_1505 = NL + "\t\t\t";
  protected final String TEXT_1506 = ".INSTANCE.decorateView(createdEdge);" + NL + "\t\t\t";
  protected final String TEXT_1507 = " domainModelEditDomain = ";
  protected final String TEXT_1508 = ".getEditingDomain(source.getDiagram().getElement());";
  protected final String TEXT_1509 = NL + "\t\t\torg.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();";
  protected final String TEXT_1510 = NL + "\t\t\t";
  protected final String TEXT_1511 = " container = getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_1512 = ".eINSTANCE.get";
  protected final String TEXT_1513 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\tdomainModelAddCommand = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1514 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1515 = ".eINSTANCE.get";
  protected final String TEXT_1516 = "(), createdDomainElement));";
  protected final String TEXT_1517 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1518 = ".create(domainModelEditDomain," + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1519 = ".eINSTANCE.get";
  protected final String TEXT_1520 = "(), createdDomainElement));";
  protected final String TEXT_1521 = NL;
  protected final String TEXT_1522 = NL + "\t\tif (";
  protected final String TEXT_1523 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1524 = NL + "\t\t}";
  protected final String TEXT_1525 = NL + "\t\tif (";
  protected final String TEXT_1526 = ".size() >= ";
  protected final String TEXT_1527 = ".eINSTANCE.get";
  protected final String TEXT_1528 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1529 = NL + "\t\t}";
  protected final String TEXT_1530 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1531 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1532 = ".eINSTANCE.get";
  protected final String TEXT_1533 = "(), source.getElement()));";
  protected final String TEXT_1534 = NL;
  protected final String TEXT_1535 = NL + "\t\tif (";
  protected final String TEXT_1536 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1537 = NL + "\t\t}";
  protected final String TEXT_1538 = NL + "\t\tif (";
  protected final String TEXT_1539 = ".size() >= ";
  protected final String TEXT_1540 = ".eINSTANCE.get";
  protected final String TEXT_1541 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1542 = NL + "\t\t}";
  protected final String TEXT_1543 = NL;
  protected final String TEXT_1544 = NL + "\t\tif (";
  protected final String TEXT_1545 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1546 = NL + "\t\t}";
  protected final String TEXT_1547 = NL + "\t\tif (";
  protected final String TEXT_1548 = ".size() >= ";
  protected final String TEXT_1549 = ".eINSTANCE.get";
  protected final String TEXT_1550 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1551 = NL + "\t\t}";
  protected final String TEXT_1552 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1553 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1554 = ".eINSTANCE.get";
  protected final String TEXT_1555 = "(), target.getElement()));";
  protected final String TEXT_1556 = NL + "\t\tdomainModelAddCommand = addLinkEndsCommand;";
  protected final String TEXT_1557 = NL;
  protected final String TEXT_1558 = NL + "\t\tif (";
  protected final String TEXT_1559 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1560 = NL + "\t\t}";
  protected final String TEXT_1561 = NL + "\t\tif (";
  protected final String TEXT_1562 = ".size() >= ";
  protected final String TEXT_1563 = ".eINSTANCE.get";
  protected final String TEXT_1564 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1565 = NL + "\t\t}";
  protected final String TEXT_1566 = NL + "\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1567 = ".create(domainModelEditDomain, source.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1568 = ".eINSTANCE.get";
  protected final String TEXT_1569 = "(), target.getElement());";
  protected final String TEXT_1570 = NL + "\t\t}" + NL;
  protected final String TEXT_1571 = NL;
  protected final String TEXT_1572 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1573 = " getRelationshipContainer(";
  protected final String TEXT_1574 = " element, ";
  protected final String TEXT_1575 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1576 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (source == null || target == null || createdEdge == null || domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1577 = NL;
  protected final String TEXT_1578 = NL + "\t\t\tif(!";
  protected final String TEXT_1579 = ".canCreateLink(";
  protected final String TEXT_1580 = ", ";
  protected final String TEXT_1581 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1582 = NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tsource.getDiagram().insertEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(source);" + NL + "\t\t\tcreatedEdge.setTarget(target);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t\tsource.getDiagram().removeEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(null);" + NL + "\t\t\tcreatedEdge.setTarget(null);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_1583 = NL;
  protected final String TEXT_1584 = NL;
  protected final String TEXT_1585 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_1586 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class TreeEditPartAdapter extends ";
  protected final String TEXT_1587 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic TreeEditPartAdapter() {" + NL + "\t\t\tsuper(getDiagramNode(), ";
  protected final String TEXT_1588 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createEditPolicies() {";
  protected final String TEXT_1589 = NL;
  protected final String TEXT_1590 = "\t\tinstallEditPolicy(";
  protected final String TEXT_1591 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_1592 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_1593 = " createDeleteCommand(";
  protected final String TEXT_1594 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_1595 = " editingDomain = ";
  protected final String TEXT_1596 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_1597 = " cc = new ";
  protected final String TEXT_1598 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_1599 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_1600 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_1601 = " editingDomain) {";
  protected final String TEXT_1602 = NL + "\t\t\t\t";
  protected final String TEXT_1603 = " result = new ";
  protected final String TEXT_1604 = "();";
  protected final String TEXT_1605 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1606 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1607 = ".eINSTANCE.get";
  protected final String TEXT_1608 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_1609 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1610 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1611 = ".eINSTANCE.get";
  protected final String TEXT_1612 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1613 = ".UNSET_VALUE));";
  protected final String TEXT_1614 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1615 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1616 = ".eINSTANCE.get";
  protected final String TEXT_1617 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_1618 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1619 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1620 = ".eINSTANCE.get";
  protected final String TEXT_1621 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1622 = ".UNSET_VALUE));";
  protected final String TEXT_1623 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1624 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1625 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1626 = ".eINSTANCE.get";
  protected final String TEXT_1627 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_1628 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1629 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1630 = ".eINSTANCE.get";
  protected final String TEXT_1631 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1632 = ".UNSET_VALUE);";
  protected final String TEXT_1633 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_1634 = NL;
  protected final String TEXT_1635 = "\t\tinstallEditPolicy(";
  protected final String TEXT_1636 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_1637 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_1638 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tsetWidgetText(value);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_1639 = NL;
  protected final String TEXT_1640 = "\t\t\t\t\tprotected ";
  protected final String TEXT_1641 = " getDirectEditCommand(";
  protected final String TEXT_1642 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1643 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_1644 = "(";
  protected final String TEXT_1645 = ").parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1646 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_1647 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1648 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1649 = " editingDomain = ";
  protected final String TEXT_1650 = ".getEditingDomain(";
  protected final String TEXT_1651 = ".getDiagram().getElement());";
  protected final String TEXT_1652 = NL + "\t\t\t\t\t\tif (parseResult.length != 1) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1653 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1654 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult[0]);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_1655 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1656 = " createDomainModelCommand(";
  protected final String TEXT_1657 = " editingDomain, Object value) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1658 = " element = ";
  protected final String TEXT_1659 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1660 = " feature = (";
  protected final String TEXT_1661 = ") ";
  protected final String TEXT_1662 = ".eINSTANCE.get";
  protected final String TEXT_1663 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_1664 = ".parseValue(feature, value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1665 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_1666 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1667 = " result = new ";
  protected final String TEXT_1668 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1669 = " values = new ";
  protected final String TEXT_1670 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_1671 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1672 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1673 = ".create(editingDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\treturn result;";
  protected final String TEXT_1674 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_1675 = ".create(editingDomain, element, feature, valueToSet);";
  protected final String TEXT_1676 = NL + "\t\t\t\t\t}";
  protected final String TEXT_1677 = NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_1678 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1679 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1680 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_1681 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1682 = " createDomainModelCommand(";
  protected final String TEXT_1683 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1684 = " element = ";
  protected final String TEXT_1685 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1686 = " result = new ";
  protected final String TEXT_1687 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_1688 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1689 = " ";
  protected final String TEXT_1690 = "feature = (";
  protected final String TEXT_1691 = ") ";
  protected final String TEXT_1692 = ".eINSTANCE.get";
  protected final String TEXT_1693 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_1694 = ".parseValue(feature, values[";
  protected final String TEXT_1695 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1696 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_1697 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1698 = " ";
  protected final String TEXT_1699 = "values = new ";
  protected final String TEXT_1700 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_1701 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1702 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1703 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_1704 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1705 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_1706 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_1707 = NL + "\t\t\t\t});";
  protected final String TEXT_1708 = NL + "\t\t}" + NL;
  protected final String TEXT_1709 = NL;
  protected final String TEXT_1710 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_1711 = " manager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_1712 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_1713 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_1714 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_1715 = "(this, ";
  protected final String TEXT_1716 = ".class, new ";
  protected final String TEXT_1717 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_1718 = " celleditor) {" + NL + "\t\t\t\t\tif (checkTreeItem()) {" + NL + "\t\t\t\t\t\tcelleditor.getControl().setFont(((";
  protected final String TEXT_1719 = ") getWidget()).getFont());" + NL + "\t\t\t\t\t\tcelleditor.getControl().setBounds(((";
  protected final String TEXT_1720 = ") getWidget()).getBounds());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL + "" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getEditText() {" + NL + "\t\t\t";
  protected final String TEXT_1721 = " primaryLabelEditPart = getPrimaryLabelEditPart();" + NL + "\t\t\tif (primaryLabelEditPart != null) {" + NL + "\t\t\t\treturn primaryLabelEditPart.getLabelEditText();" + NL + "\t\t\t}" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL;
  protected final String TEXT_1722 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void activate() {" + NL + "\t\t\tsuper.activate();" + NL + "\t\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void deactivate() {" + NL + "\t\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\t\tsuper.deactivate();" + NL + "\t\t}" + NL;
  protected final String TEXT_1723 = NL;
  protected final String TEXT_1724 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_1725 = " domainModelRefresher = new ";
  protected final String TEXT_1726 = "(this);" + NL;
  protected final String TEXT_1727 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getText() {" + NL + "\t\t\t";
  protected final String TEXT_1728 = " primaryLabelEditPart = getPrimaryLabelEditPart();" + NL + "\t\t\tif (primaryLabelEditPart != null) {" + NL + "\t\t\t\treturn primaryLabelEditPart.getLabelText();" + NL + "\t\t\t}" + NL + "\t\t\treturn super.getText();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1729 = " getPrimaryLabelEditPart() {" + NL + "\t\t\tfor(";
  protected final String TEXT_1730 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_1731 = " nextChild = (";
  protected final String TEXT_1732 = ")it.next();" + NL + "\t\t\t\tif (";
  protected final String TEXT_1733 = ".getVisualID(nextChild) == ";
  protected final String TEXT_1734 = ".VISUAL_ID) {" + NL + "\t\t\t\t\treturn (";
  protected final String TEXT_1735 = ") ";
  protected final String TEXT_1736 = ".this.getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1737 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createRefreshers() {" + NL + "\t\t\tsuper.createRefreshers();" + NL + "\t\t\tRefresher labelRefresher = new Refresher() {" + NL + "\t\t\t\tpublic void refresh() {" + NL + "\t\t\t\t\trefreshVisuals();" + NL + "\t\t\t\t}" + NL + "\t\t\t};";
  protected final String TEXT_1738 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_1739 = ".eINSTANCE.get";
  protected final String TEXT_1740 = "(), labelRefresher);";
  protected final String TEXT_1741 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_1742 = ".eINSTANCE.get";
  protected final String TEXT_1743 = "(), labelRefresher);";
  protected final String TEXT_1744 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_1745 = ".eINSTANCE.get";
  protected final String TEXT_1746 = "(), labelRefresher);";
  protected final String TEXT_1747 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Since compartments and labels are not selectable edit parts, they are filtered from the overview as well." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1748 = " getModelChildren() {" + NL + "\t\t\t";
  protected final String TEXT_1749 = " result = new ";
  protected final String TEXT_1750 = "();" + NL + "\t\t\tfor(";
  protected final String TEXT_1751 = " it = getDiagramNode().getVisibleChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_1752 = " next = (";
  protected final String TEXT_1753 = ") it.next();" + NL + "\t\t\t\tswitch (";
  protected final String TEXT_1754 = ".getVisualID(next)) {";
  protected final String TEXT_1755 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1756 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_1757 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1758 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult.addAll(next.getChildren());" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_1759 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tresult.addAll(getDiagramNode().getSourceEdges());" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_1760 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
final GenNode genNode = (GenNode) genElement;
final GenDiagram genDiagram = genNode.getDiagram();
Palette palette = genDiagram.getPalette();
boolean isXYLayout = ViewmapLayoutTypeHelper.getSharedInstance().isStoringChildPositions(genNode);
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("LinkNotationModelRefresher");	//from linkNotationModelRefresher.jetinc
importManager.registerInnerClass("NotationModelRefresher");	//from notationModelRefresher.jetinc
importManager.registerInnerClass("TreeEditPartAdapter");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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

    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName(feature.isListType() ? "java.util.Collection" : feature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_4);
    
			}
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_6);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_7);
    
			}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_10);
    
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_11);
    
			}
		} else {
			boolean needsCastToFeatureGenType = containerMetaClass == null || containerMetaClass.isExternalInterface();
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_13);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_14);
    
			}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(feature.getGetAccessor());
    stringBuffer.append(TEXT_16);
    
		}
	}
}
final FeatureGetAccessorHelper myFeatureGetAccessorHelper = new FeatureGetAccessorHelper();

    stringBuffer.append(TEXT_17);
    
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

    stringBuffer.append(TEXT_18);
    
class NodeEditPartHelper {
	private final List myInnerLabels = new LinkedList();
	private final List myAllInnerLabels = new LinkedList();
	private final List myExternalLabels = new LinkedList();
	private final List myPinnedCompartments = new LinkedList();
	private final List myFloatingCompartments = new LinkedList();
	private final List myContainedFeatureModelFacetLinks = new LinkedList();
	private final List myContainedTypeModelFacetLinks = new LinkedList();
	private GenNodeLabel myPrimaryLabel;
	private boolean myHasChildrenInListCompartments = false;
	private boolean hasIncomingLinks = false;
	private boolean hasOutgoingLinks = false;

	public NodeEditPartHelper(GenNode genNode){
		myPrimaryLabel = null;

		for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel next = (GenNodeLabel) labels.next();
			if (myPrimaryLabel == null && !next.isReadOnly()){
				myPrimaryLabel = next;
			}
			if (next instanceof GenExternalNodeLabel) {
				myExternalLabels.add(next);
			} else {
				myAllInnerLabels.add(next);
				if (next.getViewmap() instanceof ParentAssignedViewmap) {
					myInnerLabels.add(next);
				}
			}
		}
		
		for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();){
			GenCompartment next = (GenCompartment) compartments.next();
			if (next.getViewmap() instanceof ParentAssignedViewmap){
				myPinnedCompartments.add(next);
			} else {
				myFloatingCompartments.add(next);
			}	
			
			myHasChildrenInListCompartments |= next.isListLayout() && !next.getChildNodes().isEmpty();
		}

		for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
			GenLink genLink = (GenLink)it.next();
			if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
				continue;
			}
			GenClass incomingClass;
			GenClass outgoingClass;
			GenClass containerClass;
			if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
				incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
				outgoingClass = modelFacet.getSourceMetaFeature() == null
					? modelFacet.getContainmentMetaFeature().getGenClass()
					: modelFacet.getSourceMetaFeature().getTypeGenClass();
				if (modelFacet.getSourceMetaFeature() == null && modelFacet.getTargetMetaFeature() == null) {
					//if one link feature is null, the element is treated as this end of the link. If both are null, we cannot do anything about such a link.
					containerClass = null;
				} else {
					containerClass = modelFacet.getContainmentMetaFeature().getGenClass();
				}
			} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
				GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
				incomingClass = metaFeature.getTypeGenClass();
				outgoingClass = metaFeature.getGenClass();
				containerClass = metaFeature.getGenClass();
			} else {
				continue;
			}
			hasIncomingLinks |= (incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass()));
			hasOutgoingLinks |= (outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass()));
			if (containerClass != null && containerClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
				if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
					myContainedTypeModelFacetLinks.add(genLink);
				} else {
					myContainedFeatureModelFacetLinks.add(genLink);
				}
			}
		}
	}

	public boolean hasBothChildrenAndCompartments() {
		return !genNode.getCompartments().isEmpty() && !genNode.getChildNodes().isEmpty();
	}

	public boolean containsLinks() {
		return containsFeatureModelFacetLinks() || containsTypeModelFacetLinks();
	}

	public boolean containsFeatureModelFacetLinks() {
		return !myContainedFeatureModelFacetLinks.isEmpty();
	}

	public boolean containsTypeModelFacetLinks() {
		return !myContainedTypeModelFacetLinks.isEmpty();
	}

	public boolean hasIncomingLinks() {
		return hasIncomingLinks;
	}

	public boolean hasOutgoingLinks() {
		return hasOutgoingLinks;
	}

	public boolean hasChildrenInListCompartments(){
		return myHasChildrenInListCompartments;
	}
	
	public boolean hasInnerFixedLabels(){
		return !myInnerLabels.isEmpty();
	}
	
	public boolean hasPinnedCompartments(){
		return !myPinnedCompartments.isEmpty();
	}
	
	public boolean hasFixedChildren(){
		return hasInnerFixedLabels() || hasPinnedCompartments();
	}
	
	public boolean hasExternalLabels(){
		return !myExternalLabels.isEmpty();
	}
	
	public GenNodeLabel getPrimaryLabel(){
		return myPrimaryLabel;
	}
	
	public Iterator getInnerFixedLabels(){
		return myInnerLabels.iterator();
	}
	
	public Iterator getExternalLabels(){
		return myExternalLabels.iterator();
	}
	
	public Iterator getPinnedCompartments(){
		return myPinnedCompartments.iterator();
	}

	public Iterator getAllInnerLabels() {
		return myAllInnerLabels.iterator();
	}

	public Iterator getContainedFeatureModelFacetLinks() {
		return myContainedFeatureModelFacetLinks.iterator();
	}

	public Iterator getContainedTypeModelFacetLinks() {
		return myContainedTypeModelFacetLinks.iterator();
	}
}
final NodeEditPartHelper myHelper = new NodeEditPartHelper(genNode);

    stringBuffer.append(TEXT_19);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    importManager.emitPackageStatement(stringBuffer);
    
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_23);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.NodeEditPart"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_27);
    {
GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_33);
    
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_35);
    
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_58);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_61);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_65);
    
	} else {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_70);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_74);
    
	} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_79);
    
	}

    stringBuffer.append(TEXT_80);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_84);
    
	} else {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_89);
    
	}
}

    stringBuffer.append(TEXT_90);
    
}	/*restrict local vars used in component edit policy*/

    
String layoutEditPolicyBaseClass;
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {
	layoutEditPolicyBaseClass = "org.eclipse.gef.editpolicies.XYLayoutEditPolicy";
} else {
	layoutEditPolicyBaseClass = "org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy";
}

    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(layoutEditPolicyBaseClass));
    stringBuffer.append(TEXT_93);
    
{
	String _getViewCode = "getDiagramNode()";
	List childNodes = genNode.getChildNodes();
	boolean isListLayout = !isXYLayout;

    stringBuffer.append(TEXT_94);
    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_107);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();

    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_112);
    
		{
			Collection<GenNode> relatedNodes = myRelatedNodesFinder.getRelatedGenNodes(next.getDomainMetaClass());
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_113);
    
			}
			for(GenNode nextRelated : relatedNodes) {
				TypeModelFacet facet = nextRelated.getModelFacet();
				GenFeature childFeature = facet.getChildMetaFeature();
				GenFeature containmentFeature = facet.getContainmentMetaFeature();
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName(nextRelated.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_115);
    
				}
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_119);
    
					} else {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_124);
    
					}
				}
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_128);
    
				} else {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_133);
    
				}
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_134);
    
				}
			}	//for(GenNode nextRelated : relatedNodes)
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_135);
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

    stringBuffer.append(TEXT_136);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_137);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_139);
    
	} else {

    stringBuffer.append(TEXT_140);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_144);
    
	}
}

    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_149);
    
			}
			{
				GenFeature _feature = containmentFeature;
				String _ownerInstance = _getViewCode + ".getElement()";
				String _exceedsUpperBound = "return " + importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand") + ".INSTANCE;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_150);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_151);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_153);
    
	} else {

    stringBuffer.append(TEXT_154);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_158);
    
	}
}

    
			}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_163);
    
		}	//local declaration for related nodes.

    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand"));
    stringBuffer.append(TEXT_169);
    if (isListLayout) {
    stringBuffer.append(TEXT_170);
    } else {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_176);
    if (isListLayout) {
    stringBuffer.append(TEXT_177);
    } else {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_182);
    }
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_184);
    
		}

    stringBuffer.append(TEXT_185);
    
	}	//for

    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_188);
    
}	//if (!childNodes.isEmpty()) in createAddCommand

    stringBuffer.append(TEXT_189);
    
/* delegation from getCloneCommand to createCloneCommand is 100% analogous to delegation from getAddCommand() to createAddCommand() in ConstrainedLayoutEditPolicy. */

    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_210);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();
		TypeModelFacet facet = next.getModelFacet();
		GenFeature childFeature = facet.getChildMetaFeature();
		GenFeature containmentFeature = facet.getContainmentMetaFeature();

    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CommandWrapper"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.CopyCommand"));
    stringBuffer.append(TEXT_217);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
			GenFeature _feature = childFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_218);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_219);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_221);
    
	} else {

    stringBuffer.append(TEXT_222);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_226);
    
	}
}

    
		}
		{
			GenFeature _feature = containmentFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_227);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_228);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_230);
    
	} else {

    stringBuffer.append(TEXT_231);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_235);
    
	}
}

    
		}

    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_240);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_245);
    
		}

    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_250);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_253);
    if (isListLayout) {
    stringBuffer.append(TEXT_254);
    } else {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_259);
    }
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_261);
    
		}
	}	//for

    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_264);
    
}	//if (!childNodes.isEmpty())

    
}

    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_267);
    
if (palette != null && !genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_273);
    
	for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
		GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_276);
    if (isXYLayout) {
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    
	}

    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_282);
    
}

    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_284);
    
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {

    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_300);
    
} else {

    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_306);
    
}

    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_309);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_310);
    
}

    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_320);
    
if (!myHelper.hasIncomingLinks()) {

    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_322);
    
} else {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_333);
    
	for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
		GenLink genLink = (GenLink)it.next();
		if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
			continue;
		}
		GenClass incomingClass;
		String reconnectCommandNameInfix;
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
			reconnectCommandNameInfix = modelFacet.getMetaClass().getName();
		} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
			GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
			incomingClass = metaFeature.getTypeGenClass();
			reconnectCommandNameInfix = metaFeature.getFeatureAccessorName();
		} else {
			continue;
		}
		if (!incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
			continue;
		}

    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_336);
    
	}

    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_340);
    
}

    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_343);
    
if (!myHelper.hasOutgoingLinks()) {

    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_345);
    
} else {

    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_356);
    
	for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
		GenLink genLink = (GenLink)it.next();
		if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
			continue;
		}
		GenClass outgoingClass;
		String reconnectCommandNameInfix;
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			outgoingClass = modelFacet.getSourceMetaFeature() == null
				? modelFacet.getContainmentMetaFeature().getGenClass()
				: modelFacet.getSourceMetaFeature().getTypeGenClass();
			reconnectCommandNameInfix = modelFacet.getMetaClass().getName();
		} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
			GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
			outgoingClass = metaFeature.getGenClass();
			reconnectCommandNameInfix = metaFeature.getFeatureAccessorName();
		} else {
			continue;
		}
		if (!outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
			continue;
		}

    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_359);
    
	}

    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_363);
    
}

    stringBuffer.append(TEXT_364);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_366);
    if (palette != null && myHelper.hasOutgoingLinks()) {
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_372);
    
for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
		continue;
	}
	GenClass outgoingClass;
	String createCommandNameInfix;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		outgoingClass = modelFacet.getSourceMetaFeature() == null
			? modelFacet.getContainmentMetaFeature().getGenClass()
			: modelFacet.getSourceMetaFeature().getTypeGenClass();
		createCommandNameInfix = modelFacet.getMetaClass().getName();
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		createCommandNameInfix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (!outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
		continue;
	}

    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_375);
    
}

    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_379);
    }/*when there's palette*/
    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_382);
    if (palette != null && myHelper.hasIncomingLinks()) {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_389);
    
for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
		continue;
	}
	GenClass incomingClass;
	String createCommandNameInfix;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		createCommandNameInfix = modelFacet.getMetaClass().getName();
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		incomingClass = metaFeature.getTypeGenClass();
		createCommandNameInfix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (!incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
		continue;
	}

    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_392);
    
}

    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_396);
    }/*when there's palette*/
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_398);
    
if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_402);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_404);
    
}

    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_405);
    
}

    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_406);
    
}

    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_412);
    
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_413);
    
	}

    stringBuffer.append(TEXT_414);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_415);
    
	if (!genNode.getCompartments().isEmpty() && !genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RectangleFigure"));
    stringBuffer.append(TEXT_419);
    
	}

    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_421);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_423);
    if (isXYLayout) {
    stringBuffer.append(TEXT_424);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_425);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_426);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_427);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_428);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_430);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_431);
    }
    stringBuffer.append(TEXT_432);
    }
    stringBuffer.append(TEXT_433);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_434);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_436);
    }
    stringBuffer.append(TEXT_437);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_451);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_452);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_454);
    } else {
    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_458);
    }
    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_462);
    
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_464);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_465);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_469);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_470);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_474);
    	
} // for pinned compartments

    stringBuffer.append(TEXT_475);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_476);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_479);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_480);
    
} // for pinned compartments

    stringBuffer.append(TEXT_481);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_482);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_483);
    
		if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_484);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_490);
    
		}

    stringBuffer.append(TEXT_491);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_502);
    
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_503);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_504);
    
		}

    stringBuffer.append(TEXT_505);
    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_506);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_507);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_508);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_509);
    
	}

    stringBuffer.append(TEXT_510);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_514);
    
}
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_515);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_516);
    
	for(Iterator directChildren = genNode.getChildNodes().iterator(); directChildren.hasNext(); ) {
		GenChildNode next = (GenChildNode) directChildren.next();

    stringBuffer.append(TEXT_517);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_518);
    
	}

    stringBuffer.append(TEXT_519);
    
}
if (myHelper.hasExternalLabels() || myHelper.hasFixedChildren() || myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_520);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_521);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_522);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_524);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_525);
    
	}
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_526);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_528);
    
	}

    stringBuffer.append(TEXT_529);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_530);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_531);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_533);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_534);
    
	}
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_535);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_537);
    
	}

    stringBuffer.append(TEXT_538);
    
}

    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_539);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_543);
    
}

    stringBuffer.append(TEXT_544);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.TreeEditPart"));
    stringBuffer.append(TEXT_566);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_567);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_568);
    
}

    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_569);
    
}

    stringBuffer.append(TEXT_570);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_571);
    
}

    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_572);
    
}

    stringBuffer.append(TEXT_573);
    
{
	final String _getViewCode = "getDiagramNode()";
	final String _getDiagramCode = "getDiagramNode().getDiagram()";
	final boolean _includeUncontainedLinks = false;
	if (!genNode.getChildNodes().isEmpty()) {
		final boolean isListLayout = !isXYLayout;
		final List childNodes = genNode.getChildNodes();

    stringBuffer.append(TEXT_574);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_582);
    
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

    stringBuffer.append(TEXT_583);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_586);
    
}

    stringBuffer.append(TEXT_587);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_588);
    
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

    stringBuffer.append(TEXT_589);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_593);
    
		} else {

    stringBuffer.append(TEXT_594);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_597);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_598);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_600);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_601);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_604);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_605);
    
		} else {

    stringBuffer.append(TEXT_606);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_607);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_608);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_610);
    
	}

    stringBuffer.append(TEXT_611);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_612);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_614);
    
{
	String _parentNode = "getHost()";

    stringBuffer.append(TEXT_615);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_617);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_618);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_622);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_623);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_626);
    
	} else {

    stringBuffer.append(TEXT_627);
    
	}

    stringBuffer.append(TEXT_628);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_629);
    
}

    stringBuffer.append(TEXT_630);
    
}

    stringBuffer.append(TEXT_631);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(TEXT_633);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_634);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_635);
    
} else {

    stringBuffer.append(TEXT_636);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_638);
    
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

    stringBuffer.append(TEXT_639);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_643);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_644);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_645);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_647);
    
		} else {

    stringBuffer.append(TEXT_648);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_649);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_650);
    
	}

    stringBuffer.append(TEXT_651);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_652);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_653);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_654);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_655);
    
		} else {

    stringBuffer.append(TEXT_656);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_657);
    
		}

    stringBuffer.append(TEXT_658);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_659);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_660);
    
		} else {

    stringBuffer.append(TEXT_661);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_662);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_663);
    
	}
}

    stringBuffer.append(TEXT_664);
    
}

    stringBuffer.append(TEXT_665);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_666);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_668);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_671);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_676);
    
	}

    stringBuffer.append(TEXT_677);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_678);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService"));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher"));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_686);
    
	boolean hasConstraintsInContainedLinks = false;
	for (Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeModelFacet typeModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (typeModelFacet != null && typeModelFacet.getMetaClass() != null && typeModelFacet.getModelElementSelector() != null) {
			hasConstraintsInContainedLinks = true;
			break;
		}
	}
	if (hasConstraintsInContainedLinks) {

    stringBuffer.append(TEXT_687);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_688);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_690);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_691);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_692);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_700);
    
	}

    stringBuffer.append(TEXT_701);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_702);
    
	{
		boolean hasDeclaredFilter = false;
		Set genAffectingFeatures = new LinkedHashSet();
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
			if (modelFacet == null) {
				continue;
			}
			GenFeature _feature = modelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_703);
    
	/*
	 * input: 
	 * 		_feature: GenFeature
	 * 		genAffectingFeatures : Set
	 */
	if (_feature == null || genAffectingFeatures.contains(_feature)) {
		continue;
	}
	genAffectingFeatures.add(_feature);
	if (!hasDeclaredFilter) {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_704);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_708);
    
	} else {

    stringBuffer.append(TEXT_709);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_712);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_713);
    
	/*
	 * input: 
	 * 		_feature: GenFeature
	 * 		genAffectingFeatures : Set
	 */
	if (_feature == null || genAffectingFeatures.contains(_feature)) {
		continue;
	}
	genAffectingFeatures.add(_feature);
	if (!hasDeclaredFilter) {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_714);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_718);
    
	} else {

    stringBuffer.append(TEXT_719);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_722);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_723);
    
	/*
	 * input: 
	 * 		_feature: GenFeature
	 * 		genAffectingFeatures : Set
	 */
	if (_feature == null || genAffectingFeatures.contains(_feature)) {
		continue;
	}
	genAffectingFeatures.add(_feature);
	if (!hasDeclaredFilter) {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_724);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_728);
    
	} else {

    stringBuffer.append(TEXT_729);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_732);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureLinkModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_733);
    
	/*
	 * input: 
	 * 		_feature: GenFeature
	 * 		genAffectingFeatures : Set
	 */
	if (_feature == null || genAffectingFeatures.contains(_feature)) {
		continue;
	}
	genAffectingFeatures.add(_feature);
	if (!hasDeclaredFilter) {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_734);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_738);
    
	} else {

    stringBuffer.append(TEXT_739);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_742);
    
	}

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_743);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_744);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_745);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_746);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_747);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_748);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_749);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_751);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_752);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_756);
    
{
	Iterator _containedTypeModelFacetLinks = myHelper.getContainedTypeModelFacetLinks();
	Iterator _containedFeatureModelFacetLinks = myHelper.getContainedFeatureModelFacetLinks();
	String _diagramCode = "getHost().getDiagram()";

    stringBuffer.append(TEXT_757);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_759);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IViewDecorator"));
    stringBuffer.append(TEXT_761);
    
	for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_762);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_763);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_765);
    
	}
	for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_766);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_768);
    
	}

    stringBuffer.append(TEXT_769);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(_diagramCode);
    stringBuffer.append(TEXT_771);
    
}

    stringBuffer.append(TEXT_772);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_773);
    
{
	Iterator _containedTypeModelFacetLinks = myHelper.getContainedTypeModelFacetLinks();
	Iterator _containedFeatureModelFacetLinks = myHelper.getContainedFeatureModelFacetLinks();

    stringBuffer.append(TEXT_774);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_777);
    
Map genFeature2genLinkMap = new LinkedHashMap();
for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
	GenFeature metaFeature = modelFacet.getChildMetaFeature();
	if (!genFeature2genLinkMap.containsKey(metaFeature)) {
		genFeature2genLinkMap.put(metaFeature, new ArrayList());
	}
	((Collection) genFeature2genLinkMap.get(metaFeature)).add(genLink);
}
Map genFeature2featureGenLinkMap = new LinkedHashMap();
for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
	if (!genFeature2featureGenLinkMap.containsKey(metaFeature)) {
		genFeature2featureGenLinkMap.put(metaFeature, new ArrayList());
	}
	((Collection) genFeature2featureGenLinkMap.get(metaFeature)).add(genLink);
}
if (!genFeature2genLinkMap.isEmpty() || !genFeature2featureGenLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_778);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_780);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_781);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_782);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_783);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_784);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_786);
    
	} else {

    stringBuffer.append(TEXT_787);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_788);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_789);
    
	}

    stringBuffer.append(TEXT_790);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_791);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_792);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_793);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_794);
    
		} else {

    stringBuffer.append(TEXT_795);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_796);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_797);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_798);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_799);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_800);
    
		} else {

    stringBuffer.append(TEXT_801);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_803);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_804);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_806);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_807);
    
		} else {

    stringBuffer.append(TEXT_808);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_810);
    
		}

    stringBuffer.append(TEXT_811);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_812);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_813);
    
		} else {

    stringBuffer.append(TEXT_814);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_815);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_816);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_817);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_818);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_820);
    
	} else {

    stringBuffer.append(TEXT_821);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_822);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_823);
    
	}

    stringBuffer.append(TEXT_824);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_825);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_827);
    
	}

    stringBuffer.append(TEXT_828);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_829);
    
	}
}

    stringBuffer.append(TEXT_830);
    
}

    stringBuffer.append(TEXT_831);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_839);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_840);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_842);
    
	}
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_843);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_845);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_846);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_847);
    
		}

    stringBuffer.append(TEXT_848);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_849);
    
		} else {

    stringBuffer.append(TEXT_850);
    
		}
	}
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_851);
    
		}

    stringBuffer.append(TEXT_852);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_854);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_855);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_856);
    
		}

    stringBuffer.append(TEXT_857);
    
	}

    stringBuffer.append(TEXT_858);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_859);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_861);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_866);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_869);
    
}

    
}	//end of local declarations

    stringBuffer.append(TEXT_870);
    stringBuffer.append(TEXT_871);
    stringBuffer.append(TEXT_872);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_879);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_880);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_881);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_882);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_885);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_893);
    
}

    stringBuffer.append(TEXT_894);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_895);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_896);
    
}

    stringBuffer.append(TEXT_897);
    stringBuffer.append(TEXT_898);
    stringBuffer.append(TEXT_899);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_900);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_902);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_903);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_904);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_908);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_910);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(TEXT_939);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(TEXT_942);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_947);
    stringBuffer.append(TEXT_948);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_951);
    
for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();
	boolean isStatic = true;
	boolean isListLayout = !isXYLayout;

    stringBuffer.append(TEXT_952);
    
if (genDiagram.getPalette() != null) {

    stringBuffer.append(TEXT_953);
    if (isStatic) {
    stringBuffer.append(TEXT_954);
    }
    stringBuffer.append(TEXT_955);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_956);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_959);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_961);
    if (!isListLayout) {
    stringBuffer.append(TEXT_962);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_963);
    }
    stringBuffer.append(TEXT_964);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_966);
    
	if (next.getDomainMetaClass().isMapEntry()) {
	/*Workaround for Ecore example: map entries cannot be created using factory, only using reflective EFactory.create() method*/

    stringBuffer.append(TEXT_967);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_971);
    
	} else {

    stringBuffer.append(TEXT_972);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_975);
    
	}

    stringBuffer.append(TEXT_976);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_977);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(next.getUniqueIdentifier());
    stringBuffer.append(TEXT_979);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_980);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_981);
    }
    stringBuffer.append(TEXT_982);
    
	TypeModelFacet facet = next.getModelFacet();
	GenFeature childFeature = facet.getChildMetaFeature();
	GenFeature containmentFeature = facet.getContainmentMetaFeature();
	{
		GenFeature _feature = containmentFeature;
		String _ownerInstance = "parent.getElement()";
		String _exceedsUpperBound = "this.domainModelAddCommand = null;this.notationAddCommand = null;return;";
		GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_983);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_984);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_985);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_986);
    
	} else {

    stringBuffer.append(TEXT_987);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_990);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_991);
    
	}
}

    
	}
	if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
		GenFeature _feature = childFeature;
		String _ownerInstance = "parent.getElement()";
		String _exceedsUpperBound = "this.domainModelAddCommand = null;this.notationAddCommand = null;return;";
		GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_992);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_993);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_994);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_995);
    
	} else {

    stringBuffer.append(TEXT_996);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_997);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_999);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1000);
    
	}
}

    stringBuffer.append(TEXT_1001);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1009);
    
	} else {

    stringBuffer.append(TEXT_1010);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1013);
    
	}

    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_1014);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_1017);
    
	}

    stringBuffer.append(TEXT_1018);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_1019);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1021);
    }
    stringBuffer.append(TEXT_1022);
    if(!isListLayout) {
    stringBuffer.append(TEXT_1023);
    } else {
    stringBuffer.append(TEXT_1024);
    }
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_1026);
    
}

    
}
for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
		continue;
	}
	GenClass outgoingClass;
	String createCommandNameInfix;
	String reconnectCommandNameInfix;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		outgoingClass = modelFacet.getSourceMetaFeature() == null
			? modelFacet.getContainmentMetaFeature().getGenClass()
			: modelFacet.getSourceMetaFeature().getTypeGenClass();
		reconnectCommandNameInfix = createCommandNameInfix = modelFacet.getMetaClass().getName();
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		reconnectCommandNameInfix = createCommandNameInfix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (!outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
		continue;
	}
	GenLinkConstraints linkConstraints = genLink.getCreationConstraints();

    stringBuffer.append(TEXT_1027);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1040);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_1041);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1047);
    
	} else {

    stringBuffer.append(TEXT_1048);
    
	}

    stringBuffer.append(TEXT_1049);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			GenFeature childFeature = modelFacet.getChildMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_1050);
    
			} else {

    stringBuffer.append(TEXT_1051);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1055);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_1056);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1057);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1059);
    
	} else {

    stringBuffer.append(TEXT_1060);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1064);
    
	}
}

    
				}
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					{
						GenFeature _feature = childFeature;
						String _ownerInstance = "container";
						String _exceedsUpperBound = "return false;";
						GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_1065);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1066);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1068);
    
	} else {

    stringBuffer.append(TEXT_1069);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1073);
    
	}
}

    
					}
				}
			}
			//No need to check the size of the source or target features: their size does not change
			//Still need to check the eOpposite() of the source feature
			GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
			GenFeature sourceReverseFeature = sourceFeature == null ? null : sourceFeature.getReverse();
			if (sourceReverseFeature != null && !sourceReverseFeature.isDerived() && sourceReverseFeature != containmentFeature && sourceReverseFeature != childFeature) {
				GenFeature _feature = sourceReverseFeature;
				String _ownerInstance = "newSource.getElement()";
				String _exceedsUpperBound = "return false;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1074);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1075);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1077);
    
	} else {

    stringBuffer.append(TEXT_1078);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1082);
    
	}
}

    
			}
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_1083);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1084);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1087);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1088);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			{
				GenFeature _feature = metaFeature;
				String _ownerInstance = "newSource.getElement()";
				String _exceedsUpperBound = "return false;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1089);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1090);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1092);
    
	} else {

    stringBuffer.append(TEXT_1093);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1097);
    
	}
}

    
			}
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_1098);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1099);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1102);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1103);
    
		} else {

    stringBuffer.append(TEXT_1104);
    
		}

    stringBuffer.append(TEXT_1105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_1111);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			GenFeature childFeature = modelFacet.getChildMetaFeature();
			boolean setSource = sourceFeature != null;
			boolean setChild = childFeature != null && childFeature != containmentFeature && !childFeature.isDerived();
			if (containmentFeature != null) {
				if (sourceFeature != null && sourceFeature.getEcoreFeature() instanceof EReference == true) {
					EReference sourceEcoreFeature = (EReference)sourceFeature.getEcoreFeature();
					if (sourceEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
						setSource = false;
					}
				}
			}
			if (containmentFeature != null || setChild) {

    stringBuffer.append(TEXT_1112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1118);
    
			}
			if (containmentFeature != null) {
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1122);
    
				} else {

    stringBuffer.append(TEXT_1123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1127);
    
				}

    stringBuffer.append(TEXT_1128);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1131);
    
			}
			if (setChild) {
				if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1135);
    
				} else {

    stringBuffer.append(TEXT_1136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1140);
    
				}

    stringBuffer.append(TEXT_1141);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1144);
    
			}

    stringBuffer.append(TEXT_1145);
    
			if (setSource) {
				if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1152);
    
				} else {

    stringBuffer.append(TEXT_1153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1156);
    
				}
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1163);
    
			} else {

    stringBuffer.append(TEXT_1164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1171);
    
			}
		}

    stringBuffer.append(TEXT_1172);
    stringBuffer.append(TEXT_1173);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1177);
    
		}

    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_1178);
    stringBuffer.append(TEXT_1179);
    
	//input: _edge : String

    stringBuffer.append(TEXT_1180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1182);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		GenFeature childFeature = modelFacet.getChildMetaFeature();
		GenFeature targetFeature = modelFacet.getTargetMetaFeature();
		//See creation of links in NodeEditPart

		boolean removeSource = sourceFeature != null;
		boolean removeTarget = targetFeature != null;
		boolean removeChild = childFeature != null && childFeature != containmentFeature && !childFeature.isDerived();
		if (containmentFeature != null) {
			if (sourceFeature != null && sourceFeature.getEcoreFeature() instanceof EReference == true) {
				EReference sourceEcoreFeature = (EReference)sourceFeature.getEcoreFeature();
				if (sourceEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
					removeSource = false;
				}
			}
			if (targetFeature != null && targetFeature.getEcoreFeature() instanceof EReference == true) {
				EReference targetEcoreFeature = (EReference)targetFeature.getEcoreFeature();
				if (targetEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
					removeTarget = false;
				}
			}

    stringBuffer.append(TEXT_1183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1185);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1191);
    
			} else {

    stringBuffer.append(TEXT_1192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1197);
    
			}
		} else {

    stringBuffer.append(TEXT_1198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1199);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1205);
    
			} else {

    stringBuffer.append(TEXT_1206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1211);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1217);
    
			} else {

    stringBuffer.append(TEXT_1218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1223);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1229);
    
			} else {

    stringBuffer.append(TEXT_1230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1235);
    
			}
		}

    stringBuffer.append(TEXT_1236);
    
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1242);
    
		} else {

    stringBuffer.append(TEXT_1243);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1248);
    
		}

    
	}

    stringBuffer.append(TEXT_1249);
    
	}

    stringBuffer.append(TEXT_1250);
    
	if (palette != null) {

    stringBuffer.append(TEXT_1251);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1257);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_1258);
    
			} else {

    stringBuffer.append(TEXT_1259);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1263);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_1264);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1265);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1267);
    
	} else {

    stringBuffer.append(TEXT_1268);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1272);
    
	}
}

    
				}
				GenFeature childFeature = modelFacet.getChildMetaFeature();
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					{
						GenFeature _feature = childFeature;
						String _ownerInstance = "container";
						String _exceedsUpperBound = "return false;";
						GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_1273);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1274);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1276);
    
	} else {

    stringBuffer.append(TEXT_1277);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1281);
    
	}
}

    
					}
				}
				//Need to check the eOpposite() of the source feature
				GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
				GenFeature sourceReverseFeature = sourceFeature == null ? null : sourceFeature.getReverse();
				if (sourceReverseFeature != null && !sourceReverseFeature.isDerived() && sourceReverseFeature != containmentFeature && sourceReverseFeature != childFeature) {
					GenFeature _feature = sourceReverseFeature;
					String _ownerInstance = "source.getElement()";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1282);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1283);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1285);
    
	} else {

    stringBuffer.append(TEXT_1286);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1290);
    
	}
}

    
				}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_1291);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1292);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1295);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1296);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		{
			GenFeature _feature = metaFeature;
			String _ownerInstance = "source.getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1297);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1298);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1300);
    
	} else {

    stringBuffer.append(TEXT_1301);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1305);
    
	}
}

    
		}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_1306);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1307);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1310);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1311);
    
		} else {

    stringBuffer.append(TEXT_1312);
    
		}

    stringBuffer.append(TEXT_1313);
    stringBuffer.append(TEXT_1314);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1318);
    
		}

    stringBuffer.append(TEXT_1319);
    
	}	//if there's palette 
}	//outgoing links

    
for(Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
		continue;
	}
	GenClass incomingClass;
	String createCommandNameInfix;
	String reconnectCommandNameInfix;
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
		reconnectCommandNameInfix = createCommandNameInfix = modelFacet.getMetaClass().getName();
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		incomingClass = metaFeature.getTypeGenClass();
		reconnectCommandNameInfix = createCommandNameInfix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (!incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
		continue;
	}
	GenLinkConstraints linkConstraints = genLink.getCreationConstraints();

    stringBuffer.append(TEXT_1320);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1333);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_1334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1340);
    
	} else {

    stringBuffer.append(TEXT_1341);
    
	}

    stringBuffer.append(TEXT_1342);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			//Need to check the eOpposite() of the target feature
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			GenFeature targetReverseFeature = targetFeature == null ? null : targetFeature.getReverse();
			if (targetReverseFeature != null && !targetReverseFeature.isDerived()) {
				GenFeature _feature = targetReverseFeature;
				String _ownerInstance = "newTarget.getElement()";
				String _exceedsUpperBound = "return false;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1343);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1344);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1346);
    
	} else {

    stringBuffer.append(TEXT_1347);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1351);
    
	}
}

    
			}
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_1352);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1353);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1356);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1357);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			//Need to check eOpposite() of the metaFeature
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			GenFeature reverseMetaFeature = metaFeature == null ? null : metaFeature.getReverse();
			if (reverseMetaFeature != null && !reverseMetaFeature.isDerived()) {
				GenFeature _feature = reverseMetaFeature;
				String _ownerInstance = "newTarget.getElement()";
				String _exceedsUpperBound = "return false;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1358);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1359);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1361);
    
	} else {

    stringBuffer.append(TEXT_1362);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1366);
    
	}
}

    
			}
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_1367);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1368);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1369);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1371);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1372);
    
		} else {

    stringBuffer.append(TEXT_1373);
    
		}

    stringBuffer.append(TEXT_1374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_1380);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1387);
    
			} else {

    stringBuffer.append(TEXT_1388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1391);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1393);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1396);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1398);
    
			} else {

    stringBuffer.append(TEXT_1399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1402);
    
			}
		}

    stringBuffer.append(TEXT_1403);
    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_1404);
    stringBuffer.append(TEXT_1405);
    
	//input: _edge : String

    stringBuffer.append(TEXT_1406);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1408);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		GenFeature childFeature = modelFacet.getChildMetaFeature();
		GenFeature targetFeature = modelFacet.getTargetMetaFeature();
		//See creation of links in NodeEditPart

		boolean removeSource = sourceFeature != null;
		boolean removeTarget = targetFeature != null;
		boolean removeChild = childFeature != null && childFeature != containmentFeature && !childFeature.isDerived();
		if (containmentFeature != null) {
			if (sourceFeature != null && sourceFeature.getEcoreFeature() instanceof EReference == true) {
				EReference sourceEcoreFeature = (EReference)sourceFeature.getEcoreFeature();
				if (sourceEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
					removeSource = false;
				}
			}
			if (targetFeature != null && targetFeature.getEcoreFeature() instanceof EReference == true) {
				EReference targetEcoreFeature = (EReference)targetFeature.getEcoreFeature();
				if (targetEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
					removeTarget = false;
				}
			}

    stringBuffer.append(TEXT_1409);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1411);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1412);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1417);
    
			} else {

    stringBuffer.append(TEXT_1418);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1420);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1422);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1423);
    
			}
		} else {

    stringBuffer.append(TEXT_1424);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1425);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1426);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1431);
    
			} else {

    stringBuffer.append(TEXT_1432);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1433);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1436);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1437);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1438);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1439);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1440);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1441);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1443);
    
			} else {

    stringBuffer.append(TEXT_1444);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1446);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1447);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1449);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1450);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1455);
    
			} else {

    stringBuffer.append(TEXT_1456);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1461);
    
			}
		}

    stringBuffer.append(TEXT_1462);
    
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1463);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1466);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1467);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1468);
    
		} else {

    stringBuffer.append(TEXT_1469);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1470);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1471);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1473);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1474);
    
		}

    
	}

    stringBuffer.append(TEXT_1475);
    
	}

    stringBuffer.append(TEXT_1476);
    
	if (palette != null) {

    stringBuffer.append(TEXT_1477);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1478);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1479);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1480);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_1490);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenClass linkClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1491);
    stringBuffer.append(importManager.getImportedName(importManager.getImportedName(linkClass.getQualifiedInterfaceName())));
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(importManager.getImportedName(linkClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_1493);
    stringBuffer.append(linkClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_1494);
    if (linkClass.isExternalInterface()) {
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1496);
    }
    stringBuffer.append(TEXT_1497);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_1500);
    if (linkClass.isExternalInterface()) {
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1502);
    }
    stringBuffer.append(TEXT_1503);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_1504);
    
		}

    stringBuffer.append(TEXT_1505);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1507);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1508);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1509);
    
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			GenFeature childFeature = modelFacet.getChildMetaFeature();
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			//source/link features seem to be pointing from link to its ends, not vice versa.
			//Anyway, if there is containment feature and it is not opposite to either the source/target, we should add containment, 
			//otherwise we will have problems with saving uncontained EObjects.
			boolean addSource = sourceFeature != null;
			boolean addTarget = targetFeature != null;
			boolean addChild = childFeature != null && childFeature != containmentFeature && !childFeature.isDerived();
			if (containmentFeature != null) {
				if (sourceFeature != null && sourceFeature.getEcoreFeature() instanceof EReference == true) {
					EReference sourceEcoreFeature = (EReference)sourceFeature.getEcoreFeature();
					if (sourceEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
						addSource = false;
					}
				}
				if (targetFeature != null && targetFeature.getEcoreFeature() instanceof EReference == true) {
					EReference targetEcoreFeature = (EReference)targetFeature.getEcoreFeature();
					if (targetEcoreFeature.getEOpposite() == containmentFeature.getEcoreFeature()) {
						addTarget = false;
					}
				}

    stringBuffer.append(TEXT_1510);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1516);
    
			}
			if (addChild) {

    stringBuffer.append(TEXT_1517);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1519);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1520);
    
			}
			if (addSource) {
				{
					GenFeature _feature = sourceFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1521);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1522);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1524);
    
	} else {

    stringBuffer.append(TEXT_1525);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1529);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1530);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1533);
    
			}
			if (addTarget) {
				{
					GenFeature _feature = targetFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1534);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1535);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1536);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1537);
    
	} else {

    stringBuffer.append(TEXT_1538);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1540);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1542);
    
	}
}

    
				}
				//Need to check the eOpposite() of the target feature
				GenFeature targetReverseFeature = targetFeature == null ? null : targetFeature.getReverse();
				if (targetReverseFeature != null && !targetReverseFeature.isDerived()) {
					GenFeature _feature = targetReverseFeature;
					String _ownerInstance = "target.getElement()";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1543);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1544);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1546);
    
	} else {

    stringBuffer.append(TEXT_1547);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1551);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1552);
    stringBuffer.append(importManager.getImportedName(targetFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1555);
    
			}

    stringBuffer.append(TEXT_1556);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			//Need to check eOpposite() of the metaFeature
			GenFeature reverseMetaFeature = metaFeature == null ? null : metaFeature.getReverse();
			if (reverseMetaFeature != null && !reverseMetaFeature.isDerived()) {
				GenFeature _feature = reverseMetaFeature;
				String _ownerInstance = "target.getElement()";
				String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1557);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1558);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1560);
    
	} else {

    stringBuffer.append(TEXT_1561);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1562);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1564);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1565);
    
	}
}

    
			}

    stringBuffer.append(TEXT_1566);
    stringBuffer.append(importManager.getImportedName(metaFeature.getEcoreFeature().isMany()? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1568);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1569);
    
		}

    stringBuffer.append(TEXT_1570);
    stringBuffer.append(TEXT_1571);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1572);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1573);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1574);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1575);
    
		}

    stringBuffer.append(TEXT_1576);
    
{
	String _source = "source.getElement()";
	String _target = "target.getElement()";

    stringBuffer.append(TEXT_1577);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1578);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1581);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1582);
    
	}

    }/*when there's palette*/
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_1583);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_1584);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_1585);
    
}

    
}

    stringBuffer.append(TEXT_1586);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart"));
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_1588);
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(TEXT_1590);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1601);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_1602);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1603);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1604);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1605);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1606);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1608);
    
	} else {

    stringBuffer.append(TEXT_1609);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1613);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1614);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1615);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1617);
    
	} else {

    stringBuffer.append(TEXT_1618);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1622);
    
	}

    stringBuffer.append(TEXT_1623);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1624);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1626);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1627);
    
	} else {

    stringBuffer.append(TEXT_1628);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1629);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1632);
    
	}
}

    stringBuffer.append(TEXT_1633);
    
}	/*restrict local vars used in component edit policy*/

    
if (myHelper.getPrimaryLabel() != null) {
		String editPatternCode = importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()) + ".EDIT_PATTERN";
		String resolvedSemanticElement = "(" + importManager.getImportedName(genNode.getDomainMetaClass().getQualifiedInterfaceName()) + ") getDiagramNode().getElement()";
		LabelModelFacet labelModelFacet = myHelper.getPrimaryLabel().getModelFacet();
		GenClass underlyingMetaClass = genNode.getDomainMetaClass();

    stringBuffer.append(TEXT_1634);
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_1636);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(TEXT_1639);
    stringBuffer.append(TEXT_1640);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_1642);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(editPatternCode);
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_1651);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature featureToSet = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();
	EStructuralFeature ecoreFeature = featureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_1652);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1654);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1657);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1658);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_1660);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_1661);
    stringBuffer.append(importManager.getImportedName(featureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1662);
    stringBuffer.append(featureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_1664);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1665);
    
	if (ecoreFeature.isMany()) {

    stringBuffer.append(TEXT_1666);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1668);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_1669);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_1670);
    stringBuffer.append(featureToSet.getAccessorName());
    stringBuffer.append(TEXT_1671);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1673);
    
	} else {

    stringBuffer.append(TEXT_1674);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1675);
    
	}

    stringBuffer.append(TEXT_1676);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = compositeFeatureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_1677);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1681);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1684);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_1685);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1686);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1687);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_1688);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_1689);
    }
    stringBuffer.append(TEXT_1690);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_1691);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1692);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_1693);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_1694);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1695);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1696);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_1697);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_1698);
    }
    stringBuffer.append(TEXT_1699);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_1700);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_1701);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1702);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1703);
    
		} else {

    stringBuffer.append(TEXT_1704);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1705);
    
		}

    
	}

    stringBuffer.append(TEXT_1706);
    
}

    stringBuffer.append(TEXT_1707);
    
}

    stringBuffer.append(TEXT_1708);
    
if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_1709);
    stringBuffer.append(TEXT_1710);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_1711);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_1712);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_1713);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_1714);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_1715);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_1716);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_1717);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_1718);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.TreeItem"));
    stringBuffer.append(TEXT_1719);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.TreeItem"));
    stringBuffer.append(TEXT_1720);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1721);
    
}

    stringBuffer.append(TEXT_1722);
    stringBuffer.append(TEXT_1723);
    stringBuffer.append(TEXT_1724);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_1725);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_1726);
    
if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_1727);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1728);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1729);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_1730);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1731);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1732);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_1733);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1734);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1735);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_1736);
    
}

    stringBuffer.append(TEXT_1737);
    
if (myHelper.getPrimaryLabel() != null) {
	LabelModelFacet labelModelFacet = myHelper.getPrimaryLabel().getModelFacet();
	if (labelModelFacet instanceof FeatureLabelModelFacet) {
		GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_1738);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1739);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1740);
    
	} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
		CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
		for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
			GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_1741);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1742);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_1743);
    
		}
	}
} else {
	GenClass metaClass = genNode.getDomainMetaClass();
	if (metaClass != null) {
		List labelNotifyFeatures = metaClass.getLabelNotifyFeatures();
		for(Iterator it = labelNotifyFeatures.iterator(); it.hasNext(); ) {
			GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_1744);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1745);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_1746);
    
		}
	}

    
}

    stringBuffer.append(TEXT_1747);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_1748);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_1749);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_1750);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_1751);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1752);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1753);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_1754);
    
	for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
		GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_1755);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1756);
    
}

    
		for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();){
			GenCompartment next = (GenCompartment) compartments.next();

    stringBuffer.append(TEXT_1757);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1758);
    
}

    stringBuffer.append(TEXT_1759);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_1760);
    return stringBuffer.toString();
  }
}
