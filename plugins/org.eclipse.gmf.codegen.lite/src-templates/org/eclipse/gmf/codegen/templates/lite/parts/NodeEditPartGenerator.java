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
  protected final String TEXT_55 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(new ";
  protected final String TEXT_56 = "((";
  protected final String TEXT_57 = ") getDiagramNode().eContainer(), getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_58 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_59 = " editingDomain) {";
  protected final String TEXT_60 = NL + "\t\t\t\t";
  protected final String TEXT_61 = " result = new ";
  protected final String TEXT_62 = "();";
  protected final String TEXT_63 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_64 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_65 = ".eINSTANCE.get";
  protected final String TEXT_66 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_67 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_68 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_69 = ".eINSTANCE.get";
  protected final String TEXT_70 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_71 = ".UNSET_VALUE));";
  protected final String TEXT_72 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_73 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_74 = ".eINSTANCE.get";
  protected final String TEXT_75 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_76 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_77 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_78 = ".eINSTANCE.get";
  protected final String TEXT_79 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = ".UNSET_VALUE));";
  protected final String TEXT_81 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_82 = NL + "\t\t\t\treturn ";
  protected final String TEXT_83 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_84 = ".eINSTANCE.get";
  protected final String TEXT_85 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_86 = NL + "\t\t\t\treturn ";
  protected final String TEXT_87 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_88 = ".eINSTANCE.get";
  protected final String TEXT_89 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_90 = ".UNSET_VALUE);";
  protected final String TEXT_91 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_92 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_93 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_94 = "() {";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "protected Command createAddCommand(final ";
  protected final String TEXT_97 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_98 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_99 = " childNode = (";
  protected final String TEXT_100 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_101 = " editingDomain = ";
  protected final String TEXT_102 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_103 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_104 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int visualID = ";
  protected final String TEXT_105 = ".getVisualID(childNode);" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_106 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_107 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_108 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_109 = NL + "\t\t\tcase ";
  protected final String TEXT_110 = ".VISUAL_ID:" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_111 = " result = new ";
  protected final String TEXT_112 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_113 = " element = childNode.getElement();";
  protected final String TEXT_114 = NL + "\t\t\t\t\tswitch (visualID) {";
  protected final String TEXT_115 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_116 = ".VISUAL_ID:";
  protected final String TEXT_117 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_118 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_119 = ".eINSTANCE.get";
  protected final String TEXT_120 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_121 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_122 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_123 = ".eINSTANCE.get";
  protected final String TEXT_124 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = ".UNSET_VALUE));";
  protected final String TEXT_126 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_127 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_128 = ".eINSTANCE.get";
  protected final String TEXT_129 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_130 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_131 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_132 = ".eINSTANCE.get";
  protected final String TEXT_133 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_134 = ".UNSET_VALUE));";
  protected final String TEXT_135 = NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_136 = NL + "\t\t\t\t\t}\t";
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = NL + "\t\tif (";
  protected final String TEXT_139 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t}";
  protected final String TEXT_141 = NL + "\t\tif (";
  protected final String TEXT_142 = ".size() >= ";
  protected final String TEXT_143 = ".eINSTANCE.get";
  protected final String TEXT_144 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_145 = NL + "\t\t}";
  protected final String TEXT_146 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_147 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_148 = ".getElement(), ";
  protected final String TEXT_149 = ".eINSTANCE.get";
  protected final String TEXT_150 = "(), element));";
  protected final String TEXT_151 = NL;
  protected final String TEXT_152 = NL + "\t\tif (";
  protected final String TEXT_153 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t\t}";
  protected final String TEXT_155 = NL + "\t\tif (";
  protected final String TEXT_156 = ".size() >= ";
  protected final String TEXT_157 = ".eINSTANCE.get";
  protected final String TEXT_158 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_159 = NL + "\t\t}";
  protected final String TEXT_160 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_161 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_162 = ".getElement(), ";
  protected final String TEXT_163 = ".eINSTANCE.get";
  protected final String TEXT_164 = "(), element));";
  protected final String TEXT_165 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_166 = ".create(editingDomain, childNode.eContainer(), childNode.eContainmentFeature(), childNode));" + NL + "\t\t\t\t\tif (newVisualID == visualID) {" + NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_167 = "(";
  protected final String TEXT_168 = "));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_169 = ".create(editingDomain, ";
  protected final String TEXT_170 = ", ";
  protected final String TEXT_171 = ".eINSTANCE.getView_PersistedChildren(), childNode));" + NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_172 = "(childNode, ";
  protected final String TEXT_173 = "null";
  protected final String TEXT_174 = "(";
  protected final String TEXT_175 = ") constraint";
  protected final String TEXT_176 = "));" + NL + "\t\t\t\t\t} else {";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_178 = "(";
  protected final String TEXT_179 = ", element, ";
  protected final String TEXT_180 = "null";
  protected final String TEXT_181 = "((";
  protected final String TEXT_182 = ") constraint).getCopy().union(new ";
  protected final String TEXT_183 = "(";
  protected final String TEXT_184 = ", ";
  protected final String TEXT_185 = "))";
  protected final String TEXT_186 = ", ";
  protected final String TEXT_187 = ".INSTANCE));";
  protected final String TEXT_188 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcommand = result;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_189 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_190 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_191 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_192 = NL;
  protected final String TEXT_193 = NL + "protected ";
  protected final String TEXT_194 = " getCloneCommand(";
  protected final String TEXT_195 = " request) {" + NL + "\t";
  protected final String TEXT_196 = " editParts = request.getEditParts();" + NL + "\t";
  protected final String TEXT_197 = " command = new ";
  protected final String TEXT_198 = "();" + NL + "\tcommand.setDebugLabel(\"Clone in ConstrainedLayoutEditPolicy\");//$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_199 = " childPart;" + NL + "\t";
  protected final String TEXT_200 = " r;" + NL + "\tObject constraint;" + NL + "" + NL + "\tfor (int i = 0; i < editParts.size(); i++) {" + NL + "\t\tchildPart = (";
  protected final String TEXT_201 = ")editParts.get(i);" + NL + "\t\tr = childPart.getFigure().getBounds().getCopy();" + NL + "\t\t//convert r to absolute from childpart figure" + NL + "\t\tchildPart.getFigure().translateToAbsolute(r);" + NL + "\t\tr = request.getTransformedRectangle(r);" + NL + "\t\t//convert this figure to relative " + NL + "\t\tgetLayoutContainer().translateToRelative(r);" + NL + "\t\tgetLayoutContainer().translateFromParent(r);" + NL + "\t\tr.translate(getLayoutOrigin().getNegated());" + NL + "\t\tconstraint = getConstraintFor(r);" + NL + "\t\tcommand.add(createCloneCommand(childPart," + NL + "\t\t\ttranslateToModelConstraint(constraint)));" + NL + "\t}" + NL + "\treturn command.unwrap();" + NL + "}" + NL + "protected ";
  protected final String TEXT_202 = " createCloneCommand(final ";
  protected final String TEXT_203 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_204 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_205 = " childNode = (";
  protected final String TEXT_206 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_207 = " editingDomain = ";
  protected final String TEXT_208 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_209 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_210 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_211 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_212 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_213 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_214 = NL + "\t\t\tcase ";
  protected final String TEXT_215 = ".VISUAL_ID:" + NL + "\t\t\t\tcommand = new ";
  protected final String TEXT_216 = "() {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_217 = " afterCopyCommand;" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_218 = " createCommand() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_219 = " element = childNode.getElement();" + NL + "\t\t\t\t\t\t//We are being optimistic here about whether further commands can be executed." + NL + "\t\t\t\t\t\t//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.  " + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_220 = ".create(editingDomain, element);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (!super.prepare()) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_221 = NL;
  protected final String TEXT_222 = NL + "\t\tif (";
  protected final String TEXT_223 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_224 = NL + "\t\t}";
  protected final String TEXT_225 = NL + "\t\tif (";
  protected final String TEXT_226 = ".size() >= ";
  protected final String TEXT_227 = ".eINSTANCE.get";
  protected final String TEXT_228 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_229 = NL + "\t\t}";
  protected final String TEXT_230 = NL;
  protected final String TEXT_231 = NL + "\t\tif (";
  protected final String TEXT_232 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_233 = NL + "\t\t}";
  protected final String TEXT_234 = NL + "\t\tif (";
  protected final String TEXT_235 = ".size() >= ";
  protected final String TEXT_236 = ".eINSTANCE.get";
  protected final String TEXT_237 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_238 = NL + "\t\t}";
  protected final String TEXT_239 = NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tsuper.execute();" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_240 = " results = super.getResult();" + NL + "\t\t\t\t\t\tassert results.size() == 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_241 = " result = (";
  protected final String TEXT_242 = ") results.iterator().next();" + NL + "\t\t\t\t\t\tafterCopyCommand = new ";
  protected final String TEXT_243 = "();";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_245 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_246 = ".getElement(), ";
  protected final String TEXT_247 = ".eINSTANCE.get";
  protected final String TEXT_248 = "(), result));";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_250 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_251 = ".getElement(), ";
  protected final String TEXT_252 = ".eINSTANCE.get";
  protected final String TEXT_253 = "(), result));";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\tafterCopyCommand.append(new ";
  protected final String TEXT_255 = "(";
  protected final String TEXT_256 = ", result, ";
  protected final String TEXT_257 = "null";
  protected final String TEXT_258 = "((";
  protected final String TEXT_259 = ") constraint).getCopy().union(new ";
  protected final String TEXT_260 = "(";
  protected final String TEXT_261 = ", ";
  protected final String TEXT_262 = "))";
  protected final String TEXT_263 = ", ";
  protected final String TEXT_264 = ".INSTANCE));" + NL + "\t\t\t\t\t\tif (afterCopyCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tafterCopyCommand.execute();" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tassert false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tafterCopyCommand.undo();" + NL + "\t\t\t\t\t\tsuper.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\tsuper.redo();" + NL + "\t\t\t\t\t\tafterCopyCommand.redo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_265 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_266 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_267 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_268 = NL + "\t\t\tprotected ";
  protected final String TEXT_269 = " getCreateCommand(";
  protected final String TEXT_270 = " request) {";
  protected final String TEXT_271 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_272 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_273 = " requestEx = (";
  protected final String TEXT_274 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_275 = " result = new ";
  protected final String TEXT_276 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_277 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_278 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_279 = "((View) getModel(), requestEx";
  protected final String TEXT_280 = ", " + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_281 = ")getConstraintFor(request)";
  protected final String TEXT_282 = "));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_283 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_284 = "(";
  protected final String TEXT_285 = ".getEditingDomain(((View) getModel()).getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_286 = NL + "\t\t\t\treturn ";
  protected final String TEXT_287 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_288 = NL + "\t\t\tprotected ";
  protected final String TEXT_289 = " createChangeConstraintCommand(final ";
  protected final String TEXT_290 = " request, final ";
  protected final String TEXT_291 = " child, Object constraint) {" + NL + "\t\t\t\tif (!isDirectChild(child)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_292 = ".INSTANCE;" + NL + "\t\t\t\t}";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = "\t\t\t\tfinal ";
  protected final String TEXT_295 = " node = (";
  protected final String TEXT_296 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_297 = " emfCommand = new ";
  protected final String TEXT_298 = "(node, request, ((";
  protected final String TEXT_299 = ")child).getFigure());" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_300 = "(";
  protected final String TEXT_301 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_302 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_303 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_304 = NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_305 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_306 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_307 = " createChangeConstraintCommand(";
  protected final String TEXT_308 = " child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_309 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_310 = NL + "\t\t\tprotected ";
  protected final String TEXT_311 = " createChildEditPolicy(";
  protected final String TEXT_312 = " child) {";
  protected final String TEXT_313 = NL + "\t\t\t\tif (isDirectChild(child)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_314 = " result = child.getEditPolicy(";
  protected final String TEXT_315 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\t\t\t\tif (result != null) {" + NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.createChildEditPolicy(child);" + NL + "\t\t\t\t}";
  protected final String TEXT_316 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_317 = "() {" + NL + "\t\t\t\t\tpublic ";
  protected final String TEXT_318 = " getTargetEditPart(";
  protected final String TEXT_319 = " request) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_320 = ".REQ_SELECTION.equals(request.getType())) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_321 = ".this;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_322 = ".GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_323 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_324 = " getReconnectTargetCommand(";
  protected final String TEXT_325 = " request) {";
  protected final String TEXT_326 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_327 = ".INSTANCE;";
  protected final String TEXT_328 = NL + "\t\t\t\t";
  protected final String TEXT_329 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_330 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_331 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_332 = " edge = (";
  protected final String TEXT_333 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_334 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_335 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_336 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_337 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_338 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_339 = NL + "\t\t\t\tcase ";
  protected final String TEXT_340 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_341 = "(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_342 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_343 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_344 = "(";
  protected final String TEXT_345 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_346 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_347 = " getReconnectSourceCommand(";
  protected final String TEXT_348 = " request) {";
  protected final String TEXT_349 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_350 = ".INSTANCE;";
  protected final String TEXT_351 = NL + "\t\t\t\t";
  protected final String TEXT_352 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_353 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_354 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_355 = " edge = (";
  protected final String TEXT_356 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_357 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_358 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_359 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_360 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_361 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_362 = NL + "\t\t\t\tcase ";
  protected final String TEXT_363 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_364 = "(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_365 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_366 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_367 = "(";
  protected final String TEXT_368 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_369 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_370 = " getConnectionCreateCommand(";
  protected final String TEXT_371 = " request) {";
  protected final String TEXT_372 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_373 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_374 = " requestEx = (";
  protected final String TEXT_375 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_376 = " result = new ";
  protected final String TEXT_377 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_378 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_379 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.appendIfCanExecute(new ";
  protected final String TEXT_380 = "(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_381 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (!result.canExecute()) {" + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_382 = " wrappedResult = new ";
  protected final String TEXT_383 = "(";
  protected final String TEXT_384 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_385 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_386 = " getConnectionCompleteCommand(";
  protected final String TEXT_387 = " request) {";
  protected final String TEXT_388 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_389 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_390 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_391 = " requestEx = (";
  protected final String TEXT_392 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_393 = " result = new ";
  protected final String TEXT_394 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_395 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_396 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.appendIfCanExecute(new ";
  protected final String TEXT_397 = "(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_399 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_400 = "(";
  protected final String TEXT_401 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_402 = NL + "\t\t\t\treturn ";
  protected final String TEXT_403 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_404 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_405 = ".DIRECT_EDIT_ROLE, new ";
  protected final String TEXT_406 = "());";
  protected final String TEXT_407 = NL;
  protected final String TEXT_408 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_409 = "\", new ";
  protected final String TEXT_410 = "()); //$NON-NLS-1$";
  protected final String TEXT_411 = NL;
  protected final String TEXT_412 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_413 = ".OPEN_ROLE";
  protected final String TEXT_414 = " + \"";
  protected final String TEXT_415 = "\" ";
  protected final String TEXT_416 = ", new ";
  protected final String TEXT_417 = "());";
  protected final String TEXT_418 = NL + "\t\tinstallEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());";
  protected final String TEXT_419 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_420 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_421 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_422 = " getPrimaryDragEditPolicy() {";
  protected final String TEXT_423 = NL + "\t\treturn new ";
  protected final String TEXT_424 = "();";
  protected final String TEXT_425 = NL + "\t\t";
  protected final String TEXT_426 = " result = new ";
  protected final String TEXT_427 = "();";
  protected final String TEXT_428 = NL + "\t\t";
  protected final String TEXT_429 = " result = new ";
  protected final String TEXT_430 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_431 = " createSelectionHandles() {" + NL + "\t\t\t\t";
  protected final String TEXT_432 = " result = super.createSelectionHandles();" + NL + "\t\t\t\tfor(";
  protected final String TEXT_433 = " it = getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_434 = " next = (";
  protected final String TEXT_435 = ") it.next();" + NL + "\t\t\t\t\t";
  protected final String TEXT_436 = " nextView = (";
  protected final String TEXT_437 = ") next.getModel();" + NL + "\t\t\t\t\tswitch (";
  protected final String TEXT_438 = ".getVisualID(nextView)) {";
  protected final String TEXT_439 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_440 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\tresult.addAll(((";
  protected final String TEXT_441 = ") next).createSelectionHandles());" + NL + "\t\t\t\t\t\tbreak;";
  protected final String TEXT_442 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_443 = NL + "\t\tresult.setResizeDirections(";
  protected final String TEXT_444 = ".NONE);";
  protected final String TEXT_445 = NL + "\t\tresult.setResizeDirections(";
  protected final String TEXT_446 = ".";
  protected final String TEXT_447 = " | ";
  protected final String TEXT_448 = ");";
  protected final String TEXT_449 = NL + "\t\treturn result;";
  protected final String TEXT_450 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_451 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_452 = " invisibleRectangle = new ";
  protected final String TEXT_453 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_454 = "());" + NL + "\t\t";
  protected final String TEXT_455 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);";
  protected final String TEXT_456 = NL + "\t\tchildNodesPane = createChildNodesPane();" + NL + "\t\tshape.add(childNodesPane);";
  protected final String TEXT_457 = NL + NL + "\t\t";
  protected final String TEXT_458 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL;
  protected final String TEXT_459 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_460 = " createChildNodesPane() {" + NL + "\t\t";
  protected final String TEXT_461 = " result = new ";
  protected final String TEXT_462 = "();" + NL + "\t\tsetupContentPane(result);" + NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_463 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_464 = " createNodeShape() {";
  protected final String TEXT_465 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_466 = "()";
  protected final String TEXT_467 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_468 = ";";
  protected final String TEXT_469 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_470 = ";";
  protected final String TEXT_471 = NL + "\t\t";
  protected final String TEXT_472 = " figure = new ";
  protected final String TEXT_473 = "();";
  protected final String TEXT_474 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_475 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_476 = NL + "\t\treturn primaryShape;" + NL + "\t}";
  protected final String TEXT_477 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_478 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_479 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_480 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_481 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_482 = " view = (";
  protected final String TEXT_483 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_484 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_485 = " decorationPane = new ";
  protected final String TEXT_486 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_487 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_488 = " imageFigure = new ";
  protected final String TEXT_489 = "(";
  protected final String TEXT_490 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_491 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_492 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_493 = " setupContentPane(";
  protected final String TEXT_494 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_495 = NL + "\t\t\t";
  protected final String TEXT_496 = " layout = new ";
  protected final String TEXT_497 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_498 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_499 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_500 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_501 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_502 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_503 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_504 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_505 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_506 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_507 = " childEditPart) {";
  protected final String TEXT_508 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_509 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_510 = ") childEditPart).";
  protected final String TEXT_511 = "(getPrimaryShape().";
  protected final String TEXT_512 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_513 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_514 = ") {" + NL + "\t\t\t";
  protected final String TEXT_515 = " pane = getPrimaryShape().";
  protected final String TEXT_516 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_517 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_518 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_519 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_520 = ") {" + NL + "\t\t\t";
  protected final String TEXT_521 = " pane = getPrimaryShape().";
  protected final String TEXT_522 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_523 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_524 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_525 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_526 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_527 = NL + "\t\tfor(";
  protected final String TEXT_528 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_529 = " nextChild = (";
  protected final String TEXT_530 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_531 = ".getVisualID(nextChild) == ";
  protected final String TEXT_532 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_533 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_534 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_535 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_536 = ".REQ_DIRECT_EDIT.equals(req.getType())) {" + NL + "\t\t\t";
  protected final String TEXT_537 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_538 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_539 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_540 = NL;
  protected final String TEXT_541 = "if (";
  protected final String TEXT_542 = ".REQ_OPEN.equals(req.getType())) {" + NL + "\t";
  protected final String TEXT_543 = " command = getCommand(req);" + NL + "\tif (command != null && command.canExecute()) {" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(command);" + NL + "\t}" + NL + "\treturn;" + NL + "}" + NL + "\t\tsuper.performRequest(req);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_544 = " getLabelEditPart(";
  protected final String TEXT_545 = " req) {" + NL + "\t\t";
  protected final String TEXT_546 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_547 = " view = (";
  protected final String TEXT_548 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_549 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_550 = NL + "\t\t\t\tcase ";
  protected final String TEXT_551 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_552 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_553 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_554 = " childEditPart) {";
  protected final String TEXT_555 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_556 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_557 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_558 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_559 = " root = (";
  protected final String TEXT_560 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_561 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_562 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isDirectChild(";
  protected final String TEXT_563 = " childEditPart) {";
  protected final String TEXT_564 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_565 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_566 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_567 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_568 = " childEditPart, int index) {";
  protected final String TEXT_569 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_570 = " labelFigure = ((";
  protected final String TEXT_571 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_572 = NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_573 = NL + "\t\tif (isDirectChild(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_574 = " childFigure = ((";
  protected final String TEXT_575 = ") childEditPart).getFigure();" + NL + "\t\t\tchildNodesPane.add(childFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_576 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_577 = " childEditPart) {";
  protected final String TEXT_578 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_579 = " labelFigure = ((";
  protected final String TEXT_580 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_581 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_582 = NL + "\t\tif (isDirectChild(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_583 = " childFigure = ((";
  protected final String TEXT_584 = ") childEditPart).getFigure();" + NL + "\t\t\tchildNodesPane.remove(childFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_585 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_586 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_587 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_588 = " childEditPart = (";
  protected final String TEXT_589 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_590 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_591 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_592 = " node = getDiagramNode();" + NL + "\t\tif (node.getLayoutConstraint() == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_593 = ";" + NL + "\t\t";
  protected final String TEXT_594 = " bounds = (";
  protected final String TEXT_595 = ") node.getLayoutConstraint();" + NL + "\t\tint x = bounds.getX();" + NL + "\t\tint y = bounds.getY();" + NL + "\t\tint width = bounds.getWidth();" + NL + "\t\tint height = bounds.getHeight();" + NL + "\t\tif (width < 0) {" + NL + "\t\t\tx -= width;" + NL + "\t\t\twidth = -width;" + NL + "\t\t}" + NL + "\t\tif (height < 0) {" + NL + "\t\t\ty -= height;" + NL + "\t\t\theight = -height;" + NL + "\t\t}" + NL + "\t\t((";
  protected final String TEXT_596 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_597 = "(x, y, width, height));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_598 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_599 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_600 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_601 = " getSourceConnectionAnchor(";
  protected final String TEXT_602 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_603 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_604 = " getSourceConnectionAnchor(";
  protected final String TEXT_605 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_606 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_607 = "  getTargetConnectionAnchor(";
  protected final String TEXT_608 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_609 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_610 = "  getTargetConnectionAnchor(";
  protected final String TEXT_611 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_612 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_613 = NL + "\t\tif (";
  protected final String TEXT_614 = ".class == key) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_615 = "(this);" + NL + "\t\t}";
  protected final String TEXT_616 = NL + "\t\tif (";
  protected final String TEXT_617 = ".class == key) {" + NL + "\t\t\treturn getTreeEditPartAdapter();" + NL + "\t\t}";
  protected final String TEXT_618 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter myTreeEditPartAdapter;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter getTreeEditPartAdapter() {" + NL + "\t\tif (myTreeEditPartAdapter == null) {" + NL + "\t\t\tmyTreeEditPartAdapter = new TreeEditPartAdapter();" + NL + "\t\t}" + NL + "\t\treturn myTreeEditPartAdapter;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);";
  protected final String TEXT_619 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_620 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_621 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_622 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_623 = NL + "\t\tuninstallNotationModelRefresher();";
  protected final String TEXT_624 = NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}";
  protected final String TEXT_625 = NL;
  protected final String TEXT_626 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_627 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_628 = " domainModelEditDomain = ";
  protected final String TEXT_629 = ".getEditingDomain(";
  protected final String TEXT_630 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_631 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_632 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_633 = " {";
  protected final String TEXT_634 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_635 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_636 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_637 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_638 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_639 = " createFilter() {";
  protected final String TEXT_640 = NL + "\t\t\t";
  protected final String TEXT_641 = " filter = ";
  protected final String TEXT_642 = ".createFeatureFilter(";
  protected final String TEXT_643 = ".eINSTANCE.get";
  protected final String TEXT_644 = "());";
  protected final String TEXT_645 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_646 = ".createFeatureFilter(";
  protected final String TEXT_647 = ".eINSTANCE.get";
  protected final String TEXT_648 = "()));";
  protected final String TEXT_649 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_650 = ".createNotifierFilter(";
  protected final String TEXT_651 = ".getElement()));";
  protected final String TEXT_652 = NL + "\t\t\t";
  protected final String TEXT_653 = " filter = ";
  protected final String TEXT_654 = ".createNotifierFilter(";
  protected final String TEXT_655 = ".getElement());";
  protected final String TEXT_656 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_657 = NL + "\t\t\t";
  protected final String TEXT_658 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_659 = NL + "\t\t\t";
  protected final String TEXT_660 = " filter = ";
  protected final String TEXT_661 = ".NOT_TOUCH;";
  protected final String TEXT_662 = NL + "\t\t\treturn filter;";
  protected final String TEXT_663 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_664 = " getCreateNotationalElementCommand(";
  protected final String TEXT_665 = " descriptor) {";
  protected final String TEXT_666 = NL;
  protected final String TEXT_667 = "\t\t\t";
  protected final String TEXT_668 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_669 = NL + "\t\t\tcase ";
  protected final String TEXT_670 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_671 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_672 = "(";
  protected final String TEXT_673 = ", domainElement, ";
  protected final String TEXT_674 = "new ";
  protected final String TEXT_675 = "(0, 0, ";
  protected final String TEXT_676 = ", ";
  protected final String TEXT_677 = ")";
  protected final String TEXT_678 = NL + "null";
  protected final String TEXT_679 = ", ";
  protected final String TEXT_680 = ".INSTANCE, false);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_681 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_682 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_683 = " getSemanticChildNodes() {";
  protected final String TEXT_684 = NL;
  protected final String TEXT_685 = NL + "\treturn ";
  protected final String TEXT_686 = ".EMPTY_LIST;";
  protected final String TEXT_687 = NL + "\t";
  protected final String TEXT_688 = " result = new ";
  protected final String TEXT_689 = "();";
  protected final String TEXT_690 = NL + "\t";
  protected final String TEXT_691 = " viewObject = ";
  protected final String TEXT_692 = ";" + NL + "\t";
  protected final String TEXT_693 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_694 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_695 = NL + "\tfor(";
  protected final String TEXT_696 = " it = ";
  protected final String TEXT_697 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_698 = ") it.next();";
  protected final String TEXT_699 = NL + "\tnextValue = (";
  protected final String TEXT_700 = ")";
  protected final String TEXT_701 = ";";
  protected final String TEXT_702 = NL + "\tnodeVID = ";
  protected final String TEXT_703 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_704 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_705 = NL + "\tcase ";
  protected final String TEXT_706 = ".VISUAL_ID: {";
  protected final String TEXT_707 = NL + "\tif (";
  protected final String TEXT_708 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_709 = NL + "\t\tresult.add(new ";
  protected final String TEXT_710 = "(nextValue, nodeVID));";
  protected final String TEXT_711 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_712 = NL + "\t\t}";
  protected final String TEXT_713 = NL + "\t}";
  protected final String TEXT_714 = NL + "\t}";
  protected final String TEXT_715 = NL + "\treturn result;";
  protected final String TEXT_716 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_717 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_718 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_719 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_720 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_721 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_722 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_723 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_724 = " domainModelEditDomain = ";
  protected final String TEXT_725 = ".getEditingDomain(";
  protected final String TEXT_726 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_727 = "(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_728 = NL;
  protected final String TEXT_729 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_730 = " domainModelEditDomain = ";
  protected final String TEXT_731 = ".getEditingDomain(";
  protected final String TEXT_732 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * Service to find a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_733 = " viewService;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_734 = " getViewService() {" + NL + "\t\tif (viewService == null) {" + NL + "\t\t\tviewService = new ";
  protected final String TEXT_735 = "(getViewer());" + NL + "\t\t}" + NL + "\t\treturn viewService;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher(getViewService());" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_736 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher(";
  protected final String TEXT_737 = " viewService) {" + NL + "\t\t\tsuper(viewService);" + NL + "\t\t}";
  protected final String TEXT_738 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_739 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_740 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_741 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_742 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_743 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_744 = ".createEventTypeFilter(";
  protected final String TEXT_745 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_746 = ".createEventTypeFilter(";
  protected final String TEXT_747 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_748 = ".createEventTypeFilter(";
  protected final String TEXT_749 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_750 = ".createEventTypeFilter(";
  protected final String TEXT_751 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_752 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_753 = " createFilter() {";
  protected final String TEXT_754 = NL;
  protected final String TEXT_755 = NL + "\t\t\t";
  protected final String TEXT_756 = " filter = ";
  protected final String TEXT_757 = ".createFeatureFilter(";
  protected final String TEXT_758 = ".eINSTANCE.get";
  protected final String TEXT_759 = "());";
  protected final String TEXT_760 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_761 = ".createFeatureFilter(";
  protected final String TEXT_762 = ".eINSTANCE.get";
  protected final String TEXT_763 = "()));";
  protected final String TEXT_764 = NL;
  protected final String TEXT_765 = NL + "\t\t\t";
  protected final String TEXT_766 = " filter = ";
  protected final String TEXT_767 = ".createFeatureFilter(";
  protected final String TEXT_768 = ".eINSTANCE.get";
  protected final String TEXT_769 = "());";
  protected final String TEXT_770 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_771 = ".createFeatureFilter(";
  protected final String TEXT_772 = ".eINSTANCE.get";
  protected final String TEXT_773 = "()));";
  protected final String TEXT_774 = NL;
  protected final String TEXT_775 = NL + "\t\t\t";
  protected final String TEXT_776 = " filter = ";
  protected final String TEXT_777 = ".createFeatureFilter(";
  protected final String TEXT_778 = ".eINSTANCE.get";
  protected final String TEXT_779 = "());";
  protected final String TEXT_780 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_781 = ".createFeatureFilter(";
  protected final String TEXT_782 = ".eINSTANCE.get";
  protected final String TEXT_783 = "()));";
  protected final String TEXT_784 = NL;
  protected final String TEXT_785 = NL + "\t\t\t";
  protected final String TEXT_786 = " filter = ";
  protected final String TEXT_787 = ".createFeatureFilter(";
  protected final String TEXT_788 = ".eINSTANCE.get";
  protected final String TEXT_789 = "());";
  protected final String TEXT_790 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_791 = ".createFeatureFilter(";
  protected final String TEXT_792 = ".eINSTANCE.get";
  protected final String TEXT_793 = "()));";
  protected final String TEXT_794 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_795 = NL + "\t\t\t";
  protected final String TEXT_796 = " filter = getConstrainedChildLinksFilter();";
  protected final String TEXT_797 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_798 = NL + "\t\t\t";
  protected final String TEXT_799 = " filter = createUncontainedLinksFilter();";
  protected final String TEXT_800 = NL + "\t\t\t";
  protected final String TEXT_801 = " filter = ";
  protected final String TEXT_802 = ".NOT_TOUCH;";
  protected final String TEXT_803 = NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t\tprotected ";
  protected final String TEXT_804 = " getCreateNotationalElementCommand(";
  protected final String TEXT_805 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_806 = " linkDescriptor = (";
  protected final String TEXT_807 = ") descriptor;";
  protected final String TEXT_808 = NL;
  protected final String TEXT_809 = "\t\t\t";
  protected final String TEXT_810 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_811 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\t";
  protected final String TEXT_812 = " decorator = null;" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_813 = NL + "\t\t\tcase ";
  protected final String TEXT_814 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_815 = ") {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_816 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_817 = NL + "\t\t\tcase ";
  protected final String TEXT_818 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_819 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_820 = NL + "\t\t\t}" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_821 = "(";
  protected final String TEXT_822 = ", linkDescriptor.getElement(), sourceView, targetView, decorator);";
  protected final String TEXT_823 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_824 = " getSemanticChildLinks() {";
  protected final String TEXT_825 = NL;
  protected final String TEXT_826 = "\t";
  protected final String TEXT_827 = " result = new ";
  protected final String TEXT_828 = "();";
  protected final String TEXT_829 = NL + "\t";
  protected final String TEXT_830 = " modelObject = ";
  protected final String TEXT_831 = ".getElement();" + NL + "\t";
  protected final String TEXT_832 = " nextValue;";
  protected final String TEXT_833 = NL + "\tint linkVID;";
  protected final String TEXT_834 = NL + "\tfor(";
  protected final String TEXT_835 = " it = ";
  protected final String TEXT_836 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_837 = ") it.next();";
  protected final String TEXT_838 = NL + "\tnextValue = (";
  protected final String TEXT_839 = ")";
  protected final String TEXT_840 = ";";
  protected final String TEXT_841 = NL + "\tlinkVID = ";
  protected final String TEXT_842 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_843 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_844 = NL + "\tcase ";
  protected final String TEXT_845 = ".VISUAL_ID: {";
  protected final String TEXT_846 = NL + "\tif (";
  protected final String TEXT_847 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_848 = NL + "\t\t";
  protected final String TEXT_849 = " source = (";
  protected final String TEXT_850 = ")";
  protected final String TEXT_851 = ";";
  protected final String TEXT_852 = NL + "\t\t";
  protected final String TEXT_853 = " source = ";
  protected final String TEXT_854 = ".getElement();";
  protected final String TEXT_855 = NL + "\t\t";
  protected final String TEXT_856 = " target = (";
  protected final String TEXT_857 = ")";
  protected final String TEXT_858 = ";";
  protected final String TEXT_859 = NL + "\t\t";
  protected final String TEXT_860 = " target = ";
  protected final String TEXT_861 = ".getElement();";
  protected final String TEXT_862 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_863 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_864 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_865 = NL + "\t}";
  protected final String TEXT_866 = NL + "\t}";
  protected final String TEXT_867 = NL + "\t}";
  protected final String TEXT_868 = NL + "\tfor(";
  protected final String TEXT_869 = " it = ";
  protected final String TEXT_870 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_871 = ") it.next();";
  protected final String TEXT_872 = NL + "\tnextValue = (";
  protected final String TEXT_873 = ")";
  protected final String TEXT_874 = ";";
  protected final String TEXT_875 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_876 = NL + "\t\tresult.add(new ";
  protected final String TEXT_877 = "(modelObject, nextValue, null, ";
  protected final String TEXT_878 = ".VISUAL_ID));";
  protected final String TEXT_879 = NL + "\t}";
  protected final String TEXT_880 = NL + "\t}";
  protected final String TEXT_881 = NL + "\treturn result;";
  protected final String TEXT_882 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_883 = " getNotationalChildLinks() {" + NL + "\t\t\t";
  protected final String TEXT_884 = " result = new ";
  protected final String TEXT_885 = "();" + NL + "\t\t\t";
  protected final String TEXT_886 = " allLinks = ";
  protected final String TEXT_887 = ".getEdges();" + NL + "\t\t\tfor(";
  protected final String TEXT_888 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_889 = " next = (";
  protected final String TEXT_890 = ") it.next();";
  protected final String TEXT_891 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_892 = " source = next.getSource();" + NL + "\t\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_893 = " target = next.getTarget();" + NL + "\t\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}";
  protected final String TEXT_894 = NL + "\t\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_895 = ") {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_896 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_897 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_898 = ".VISUAL_ID:";
  protected final String TEXT_899 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_900 = NL + "\t\t\t\t} else {";
  protected final String TEXT_901 = NL + "\t\t\t\t}";
  protected final String TEXT_902 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_903 = NL + "\t\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_904 = ".getElement()) {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_905 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_906 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_907 = ".VISUAL_ID:";
  protected final String TEXT_908 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_909 = NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_910 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_911 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_912 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_913 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_914 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_915 = " linkRefresher = getLinkNotationModelRefresher();" + NL + "\t\tif (!linkRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_916 = " command = linkRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_917 = " domainModelEditDomain = ";
  protected final String TEXT_918 = ".getEditingDomain(";
  protected final String TEXT_919 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_920 = "(domainModelEditDomain, command));" + NL + "\t}";
  protected final String TEXT_921 = NL;
  protected final String TEXT_922 = NL;
  protected final String TEXT_923 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_924 = " domainModelRefresher = new ";
  protected final String TEXT_925 = "(this);" + NL;
  protected final String TEXT_926 = NL;
  protected final String TEXT_927 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_928 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_929 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_930 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_931 = NL;
  protected final String TEXT_932 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_933 = NL + "\t\t";
  protected final String TEXT_934 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_935 = ") ";
  protected final String TEXT_936 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_937 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_938 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_939 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_940 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_941 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_942 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_943 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_944 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_945 = "\t" + NL + "\t}";
  protected final String TEXT_946 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_947 = " createdFont;";
  protected final String TEXT_948 = "\t" + NL;
  protected final String TEXT_949 = NL;
  protected final String TEXT_950 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_951 = " style = (";
  protected final String TEXT_952 = ")  ";
  protected final String TEXT_953 = ".getStyle(";
  protected final String TEXT_954 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_955 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_956 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_957 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_958 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_959 = " style = (";
  protected final String TEXT_960 = ")  ";
  protected final String TEXT_961 = ".getStyle(";
  protected final String TEXT_962 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_963 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_964 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_965 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_966 = " createdBackgroundColor;" + NL;
  protected final String TEXT_967 = NL;
  protected final String TEXT_968 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_969 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_970 = " feature, ";
  protected final String TEXT_971 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_972 = "();";
  protected final String TEXT_973 = NL;
  protected final String TEXT_974 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_975 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_976 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_977 = ".eINSTANCE.getView_Styles(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_978 = ".eINSTANCE.getDrawerStyle_Collapsed(), childrenRefresher);" + NL + "\t\t";
  protected final String TEXT_979 = NL;
  protected final String TEXT_980 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_981 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_982 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_983 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_984 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_985 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_986 = NL;
  protected final String TEXT_987 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_988 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_989 = NL;
  protected final String TEXT_990 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_991 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_992 = NL;
  protected final String TEXT_993 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_994 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_995 = NL;
  protected final String TEXT_996 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_997 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_998 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_999 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_1000 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_1001 = NL;
  protected final String TEXT_1002 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_1003 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_1004 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_1005 = NL;
  protected final String TEXT_1006 = NL;
  protected final String TEXT_1007 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_1008 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class TreeEditPartAdapter extends ";
  protected final String TEXT_1009 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic TreeEditPartAdapter() {" + NL + "\t\t\tsuper(getDiagramNode(), ";
  protected final String TEXT_1010 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createEditPolicies() {";
  protected final String TEXT_1011 = NL;
  protected final String TEXT_1012 = "\t\tinstallEditPolicy(";
  protected final String TEXT_1013 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_1014 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_1015 = " createDeleteCommand(";
  protected final String TEXT_1016 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_1017 = " editingDomain = ";
  protected final String TEXT_1018 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_1019 = " cc = new ";
  protected final String TEXT_1020 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(new ";
  protected final String TEXT_1021 = "((";
  protected final String TEXT_1022 = ") getDiagramNode().eContainer(), getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_1023 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_1024 = " editingDomain) {";
  protected final String TEXT_1025 = NL + "\t\t\t\t";
  protected final String TEXT_1026 = " result = new ";
  protected final String TEXT_1027 = "();";
  protected final String TEXT_1028 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1029 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1030 = ".eINSTANCE.get";
  protected final String TEXT_1031 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_1032 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1033 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1034 = ".eINSTANCE.get";
  protected final String TEXT_1035 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1036 = ".UNSET_VALUE));";
  protected final String TEXT_1037 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1038 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1039 = ".eINSTANCE.get";
  protected final String TEXT_1040 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_1041 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1042 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1043 = ".eINSTANCE.get";
  protected final String TEXT_1044 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1045 = ".UNSET_VALUE));";
  protected final String TEXT_1046 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1047 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1048 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1049 = ".eINSTANCE.get";
  protected final String TEXT_1050 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_1051 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1052 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_1053 = ".eINSTANCE.get";
  protected final String TEXT_1054 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1055 = ".UNSET_VALUE);";
  protected final String TEXT_1056 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_1057 = NL;
  protected final String TEXT_1058 = "\t\tinstallEditPolicy(";
  protected final String TEXT_1059 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_1060 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_1061 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tsetWidgetText(value);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_1062 = NL;
  protected final String TEXT_1063 = "\t\t\t\t\tprotected ";
  protected final String TEXT_1064 = " getDirectEditCommand(";
  protected final String TEXT_1065 = " request) {";
  protected final String TEXT_1066 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_1067 = ".INSTANCE;";
  protected final String TEXT_1068 = NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1069 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;";
  protected final String TEXT_1070 = NL + "\t\t\t\t\t\tif (value.length() == 0) {" + NL + "\t\t\t\t\t\t\tparseResult = new Object[] { null };" + NL + "\t\t\t\t\t\t} else {";
  protected final String TEXT_1071 = NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_1072 = "(";
  protected final String TEXT_1073 = ").parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1074 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_1075 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1076 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_1077 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_1078 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1079 = " editingDomain = ";
  protected final String TEXT_1080 = ".getEditingDomain(";
  protected final String TEXT_1081 = ".getDiagram().getElement());" + NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_1082 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1083 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1084 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_1085 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_1086 = " createDomainModelCommand(";
  protected final String TEXT_1087 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1088 = " element = ";
  protected final String TEXT_1089 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1090 = " result = new ";
  protected final String TEXT_1091 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_1092 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1093 = " ";
  protected final String TEXT_1094 = "feature = (";
  protected final String TEXT_1095 = ") ";
  protected final String TEXT_1096 = ".eINSTANCE.get";
  protected final String TEXT_1097 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_1098 = ".parseValue(feature, values[";
  protected final String TEXT_1099 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_1100 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_1101 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_1102 = " ";
  protected final String TEXT_1103 = "values = new ";
  protected final String TEXT_1104 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_1105 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1106 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tif (valueToSet != null) {" + NL + "\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1107 = ".create(editingDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_1108 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_1109 = ".create(editingDomain, element, feature, valueToSet == null ? ";
  protected final String TEXT_1110 = ".UNSET_VALUE : valueToSet));";
  protected final String TEXT_1111 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_1112 = NL + "\t\t\t\t});";
  protected final String TEXT_1113 = NL + "\t\t}" + NL;
  protected final String TEXT_1114 = NL;
  protected final String TEXT_1115 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_1116 = " manager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_1117 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_1118 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_1119 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_1120 = "(this, ";
  protected final String TEXT_1121 = ".class, new ";
  protected final String TEXT_1122 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_1123 = " celleditor) {" + NL + "\t\t\t\t\tif (checkTreeItem()) {" + NL + "\t\t\t\t\t\tcelleditor.getControl().setFont(((";
  protected final String TEXT_1124 = ") getWidget()).getFont());" + NL + "\t\t\t\t\t\tcelleditor.getControl().setBounds(((";
  protected final String TEXT_1125 = ") getWidget()).getBounds());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL + "" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getEditText() {" + NL + "\t\t\t";
  protected final String TEXT_1126 = " primaryLabelEditPart = getPrimaryLabelEditPart();" + NL + "\t\t\tif (primaryLabelEditPart != null) {" + NL + "\t\t\t\treturn primaryLabelEditPart.getLabelEditText();" + NL + "\t\t\t}" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL;
  protected final String TEXT_1127 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void activate() {" + NL + "\t\t\tsuper.activate();" + NL + "\t\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void deactivate() {" + NL + "\t\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\t\tsuper.deactivate();" + NL + "\t\t}" + NL;
  protected final String TEXT_1128 = NL;
  protected final String TEXT_1129 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_1130 = " domainModelRefresher = new ";
  protected final String TEXT_1131 = "(this);" + NL;
  protected final String TEXT_1132 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getText() {" + NL + "\t\t\t";
  protected final String TEXT_1133 = " primaryLabelEditPart = getPrimaryLabelEditPart();" + NL + "\t\t\tif (primaryLabelEditPart != null) {" + NL + "\t\t\t\treturn primaryLabelEditPart.getLabelText();" + NL + "\t\t\t}" + NL + "\t\t\treturn super.getText();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1134 = " getPrimaryLabelEditPart() {" + NL + "\t\t\tfor(";
  protected final String TEXT_1135 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_1136 = " nextChild = (";
  protected final String TEXT_1137 = ")it.next();" + NL + "\t\t\t\tif (";
  protected final String TEXT_1138 = ".getVisualID(nextChild) == ";
  protected final String TEXT_1139 = ".VISUAL_ID) {" + NL + "\t\t\t\t\treturn (";
  protected final String TEXT_1140 = ") ";
  protected final String TEXT_1141 = ".this.getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1142 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createRefreshers() {" + NL + "\t\t\tsuper.createRefreshers();" + NL + "\t\t\tRefresher labelRefresher = new Refresher() {" + NL + "\t\t\t\tpublic void refresh() {" + NL + "\t\t\t\t\trefreshVisuals();" + NL + "\t\t\t\t}" + NL + "\t\t\t};";
  protected final String TEXT_1143 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_1144 = ".eINSTANCE.get";
  protected final String TEXT_1145 = "(), labelRefresher);";
  protected final String TEXT_1146 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_1147 = ".eINSTANCE.get";
  protected final String TEXT_1148 = "(), labelRefresher);";
  protected final String TEXT_1149 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Since compartments and labels are not selectable edit parts, they are filtered from the overview as well." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1150 = " getModelChildren() {" + NL + "\t\t\t";
  protected final String TEXT_1151 = " result = new ";
  protected final String TEXT_1152 = "();" + NL + "\t\t\tfor(";
  protected final String TEXT_1153 = " it = getDiagramNode().getVisibleChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_1154 = " next = (";
  protected final String TEXT_1155 = ") it.next();" + NL + "\t\t\t\t";
  protected final String TEXT_1156 = " style = (";
  protected final String TEXT_1157 = ") next.getStyle(";
  protected final String TEXT_1158 = ".eINSTANCE.getDrawerStyle());" + NL + "\t\t\t\tif (style != null && style.isCollapsed()) {" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tswitch (";
  protected final String TEXT_1159 = ".getVisualID(next)) {";
  protected final String TEXT_1160 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1161 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_1162 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1163 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult.addAll(next.getChildren());" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_1164 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tresult.addAll(getDiagramNode().getSourceEdges());" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_1165 = NL;

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
	private final List myAllLabels = new LinkedList();
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
			myAllLabels.add(next);
			if (next instanceof GenExternalNodeLabel) {
				myExternalLabels.add(next);
			} else {
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

	public Iterator getAllLabels() {
		return myAllLabels.iterator();
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_59);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_62);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_66);
    
	} else {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_71);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_75);
    
	} else {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_80);
    
	}

    stringBuffer.append(TEXT_81);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_85);
    
	} else {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_90);
    
	}
}

    stringBuffer.append(TEXT_91);
    
}	/*restrict local vars used in component edit policy*/

    
String layoutEditPolicyBaseClass;
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {
	layoutEditPolicyBaseClass = "org.eclipse.gef.editpolicies.XYLayoutEditPolicy";
} else {
	layoutEditPolicyBaseClass = "org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy";
}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(layoutEditPolicyBaseClass));
    stringBuffer.append(TEXT_94);
    
{
	String _getViewCode = "getDiagramNode()";
	List childNodes = genNode.getChildNodes();
	boolean isListLayout = !isXYLayout;

    stringBuffer.append(TEXT_95);
    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_108);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_113);
    
		{
			Collection<GenNode> relatedNodes = myRelatedNodesFinder.getRelatedGenNodes(next.getDomainMetaClass());
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_114);
    
			}
			for(GenNode nextRelated : relatedNodes) {
				TypeModelFacet facet = nextRelated.getModelFacet();
				GenFeature childFeature = facet.getChildMetaFeature();
				GenFeature containmentFeature = facet.getContainmentMetaFeature();
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName(nextRelated.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_116);
    
				}
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_120);
    
					} else {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_125);
    
					}
				}
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_129);
    
				} else {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_134);
    
				}
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_135);
    
				}
			}	//for(GenNode nextRelated : relatedNodes)
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_136);
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

    stringBuffer.append(TEXT_137);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_138);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_140);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_141);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_145);
    
	}
}

    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_150);
    
			}
			{
				GenFeature _feature = containmentFeature;
				String _ownerInstance = _getViewCode + ".getElement()";
				String _exceedsUpperBound = "return " + importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand") + ".INSTANCE;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_151);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_152);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_154);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_155);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_159);
    
	}
}

    
			}

    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_164);
    
		}	//local declaration for related nodes.

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ExpandDrawerCommand"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand"));
    stringBuffer.append(TEXT_172);
    if (isListLayout) {
    stringBuffer.append(TEXT_173);
    } else {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_179);
    if (isListLayout) {
    stringBuffer.append(TEXT_180);
    } else {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_187);
    
		}

    stringBuffer.append(TEXT_188);
    
	}	//for

    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_191);
    
}	//if (!childNodes.isEmpty()) in createAddCommand

    stringBuffer.append(TEXT_192);
    
/* delegation from getCloneCommand to createCloneCommand is 100% analogous to delegation from getAddCommand() to createAddCommand() in ConstrainedLayoutEditPolicy. */

    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_213);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();
		TypeModelFacet facet = next.getModelFacet();
		GenFeature childFeature = facet.getChildMetaFeature();
		GenFeature containmentFeature = facet.getContainmentMetaFeature();

    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CommandWrapper"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.CopyCommand"));
    stringBuffer.append(TEXT_220);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
			GenFeature _feature = childFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_221);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_222);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_224);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_225);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_229);
    
	}
}

    
		}
		{
			GenFeature _feature = containmentFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_230);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_231);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_233);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_234);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_238);
    
	}
}

    
		}

    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_243);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_248);
    
		}

    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_253);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_256);
    if (isListLayout) {
    stringBuffer.append(TEXT_257);
    } else {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_262);
    }
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_264);
    
		}
	}	//for

    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_267);
    
}	//if (!childNodes.isEmpty())

    
}

    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_270);
    
if (palette != null && !genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_276);
    
	for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
		GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Create" + next.getDomainMetaClass().getName() + next.getVisualID() + "Command"));
    stringBuffer.append(TEXT_279);
    if (isXYLayout) {
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    
	}

    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_285);
    
}

    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_287);
    
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {

    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_303);
    
} else {

    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_309);
    
}

    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_312);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_315);
    
}

    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_325);
    
if (!myHelper.hasIncomingLinks()) {

    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_327);
    
} else {

    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_338);
    
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

    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Reconnect" + reconnectCommandNameInfix + genLink.getVisualID() + "TargetCommand"));
    stringBuffer.append(TEXT_341);
    
	}

    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_345);
    
}

    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_348);
    
if (!myHelper.hasOutgoingLinks()) {

    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_350);
    
} else {

    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_361);
    
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

    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Reconnect" + reconnectCommandNameInfix + genLink.getVisualID() + "SourceCommand"));
    stringBuffer.append(TEXT_364);
    
	}

    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_368);
    
}

    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_371);
    if (palette != null && myHelper.hasOutgoingLinks()) {
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_377);
    
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

    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Create" + createCommandNameInfix + genLink.getVisualID() + "StartCommand"));
    stringBuffer.append(TEXT_380);
    
}

    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_384);
    }/*when there's palette*/
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_387);
    if (palette != null && myHelper.hasIncomingLinks()) {
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_394);
    
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
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		incomingClass = metaFeature.getTypeGenClass();
		createCommandNameInfix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (!incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
		continue;
	}

    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Create" + createCommandNameInfix + genLink.getVisualID() + "Command"));
    stringBuffer.append(TEXT_397);
    
}

    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_401);
    }/*when there's palette*/
    stringBuffer.append(TEXT_402);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_403);
    
if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.DelegatingDirectEditPolicy"));
    stringBuffer.append(TEXT_406);
    
}

    {
GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_407);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_408);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_410);
    }
    stringBuffer.append(TEXT_411);
    
{
	List<OpenDiagramBehaviour> behaviours = genCommonBase.getBehaviour(OpenDiagramBehaviour.class);
	for(int i = 0, iMax = behaviours.size(); i < iMax; i++) {
	/*doesn't make sense to install more than one policy for the same role*/ 
		OpenDiagramBehaviour next = behaviours.get(i);

    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.EditPolicyRoles"));
    stringBuffer.append(TEXT_413);
    if (i > 0) {
    stringBuffer.append(TEXT_414);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_415);
    }
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName(genCommonBase.getBehaviour(OpenDiagramBehaviour.class).get(0).getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_417);
    
	}
}

    }
    stringBuffer.append(TEXT_418);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_419);
    
}

    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_420);
    
}

    stringBuffer.append(TEXT_421);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_422);
    
if (genNode.getPrimaryDragEditPolicyQualifiedClassName() != null) {

    stringBuffer.append(TEXT_423);
    stringBuffer.append(importManager.getImportedName(genNode.getPrimaryDragEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_424);
    
} else {
	if (genNode.getCompartments().isEmpty()) {

    stringBuffer.append(TEXT_425);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_427);
    
	} else {

    stringBuffer.append(TEXT_428);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_438);
    
		for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();){
			GenCompartment next = (GenCompartment) compartments.next();

    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_441);
    
		}

    stringBuffer.append(TEXT_442);
    
	}
	ResizeConstraints rc = (ResizeConstraints) genNode.getViewmap().find(ResizeConstraints.class);
	if (rc != null) {
		if (rc.getResizeHandles() == 0) {

    stringBuffer.append(TEXT_443);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_444);
    
		} else {

    stringBuffer.append(TEXT_445);
    
			for (Iterator it = rc.getResizeHandleNames().iterator(); it.hasNext(); ) {
				String next = (String) it.next();

    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(next);
    
				if (it.hasNext()) {
    stringBuffer.append(TEXT_447);
    
				}
			}
		
    stringBuffer.append(TEXT_448);
    
		}
	}

    stringBuffer.append(TEXT_449);
    
}

    stringBuffer.append(TEXT_450);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_455);
    
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_456);
    
	}

    stringBuffer.append(TEXT_457);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_458);
    
	if (!genNode.getCompartments().isEmpty() && !genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RectangleFigure"));
    stringBuffer.append(TEXT_462);
    
	}

    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_464);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_466);
    if (isXYLayout) {
    stringBuffer.append(TEXT_467);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_468);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_469);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_470);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_471);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_473);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_474);
    }
    stringBuffer.append(TEXT_475);
    }
    stringBuffer.append(TEXT_476);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_477);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_479);
    }
    stringBuffer.append(TEXT_480);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_492);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_494);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_495);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_497);
    } else {
    stringBuffer.append(TEXT_498);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_501);
    }
    stringBuffer.append(TEXT_502);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_505);
    
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_506);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_507);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_508);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_512);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_513);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_516);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_517);
    	
} // for pinned compartments

    stringBuffer.append(TEXT_518);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_519);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_523);
    
} // for pinned compartments

    stringBuffer.append(TEXT_524);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_525);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_526);
    
		if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_527);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_533);
    
		}

    stringBuffer.append(TEXT_534);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_549);
    
		for (Iterator it = myHelper.getAllLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_550);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_551);
    
		}

    stringBuffer.append(TEXT_552);
    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_553);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_554);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_555);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_556);
    
	}

    stringBuffer.append(TEXT_557);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_561);
    
}
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_562);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_563);
    
	for(Iterator directChildren = genNode.getChildNodes().iterator(); directChildren.hasNext(); ) {
		GenChildNode next = (GenChildNode) directChildren.next();

    stringBuffer.append(TEXT_564);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_565);
    
	}

    stringBuffer.append(TEXT_566);
    
}
if (myHelper.hasExternalLabels() || myHelper.hasFixedChildren() || myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_567);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_568);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_569);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_571);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_572);
    
	}
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_573);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_575);
    
	}

    stringBuffer.append(TEXT_576);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_577);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_578);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_580);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_581);
    
	}
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_582);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_584);
    
	}

    stringBuffer.append(TEXT_585);
    
}

    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_586);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_590);
    
}

    stringBuffer.append(TEXT_591);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_592);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_612);
    
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {

    stringBuffer.append(TEXT_613);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToHelper"));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToGrid"));
    stringBuffer.append(TEXT_615);
    
}

    stringBuffer.append(TEXT_616);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.TreeEditPart"));
    stringBuffer.append(TEXT_617);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_618);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_619);
    
}

    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_620);
    
}

    stringBuffer.append(TEXT_621);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_622);
    
}

    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_623);
    
}

    stringBuffer.append(TEXT_624);
    
{
	final String _getViewCode = "getDiagramNode()";
	final String _getDiagramCode = "getDiagramNode().getDiagram()";
	final boolean _includeUncontainedLinks = false;
	if (!genNode.getChildNodes().isEmpty()) {
		final boolean isListLayout = !isXYLayout;
		final List childNodes = genNode.getChildNodes();

    stringBuffer.append(TEXT_625);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_633);
    
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

    stringBuffer.append(TEXT_634);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_635);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_637);
    
}

    stringBuffer.append(TEXT_638);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_639);
    
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

    stringBuffer.append(TEXT_640);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_644);
    
		} else {

    stringBuffer.append(TEXT_645);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_646);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_648);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_649);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_651);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_652);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_655);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_656);
    
		} else {

    stringBuffer.append(TEXT_657);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_658);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_659);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_660);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_661);
    
	}

    stringBuffer.append(TEXT_662);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_663);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_665);
    
{
	String _parentNode = "getHost()";

    stringBuffer.append(TEXT_666);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_668);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_669);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_673);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_674);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_677);
    
	} else {

    stringBuffer.append(TEXT_678);
    
	}

    stringBuffer.append(TEXT_679);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_680);
    
}

    stringBuffer.append(TEXT_681);
    
}

    stringBuffer.append(TEXT_682);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(TEXT_684);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_685);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_686);
    
} else {

    stringBuffer.append(TEXT_687);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_688);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_689);
    
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

    stringBuffer.append(TEXT_690);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_694);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_695);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_696);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_698);
    
		} else {

    stringBuffer.append(TEXT_699);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_700);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_701);
    
	}

    stringBuffer.append(TEXT_702);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_703);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_704);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_705);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_706);
    
		} else {

    stringBuffer.append(TEXT_707);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_708);
    
		}

    stringBuffer.append(TEXT_709);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_710);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_711);
    
		} else {

    stringBuffer.append(TEXT_712);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_713);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_714);
    
	}
}

    stringBuffer.append(TEXT_715);
    
}

    stringBuffer.append(TEXT_716);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_717);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_719);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_727);
    
	}

    stringBuffer.append(TEXT_728);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_729);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService"));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher"));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_737);
    
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

    stringBuffer.append(TEXT_738);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_739);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_741);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_742);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_751);
    
	}

    stringBuffer.append(TEXT_752);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_753);
    
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

    stringBuffer.append(TEXT_754);
    
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

    stringBuffer.append(TEXT_755);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_759);
    
	} else {

    stringBuffer.append(TEXT_760);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_763);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_764);
    
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

    stringBuffer.append(TEXT_765);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_769);
    
	} else {

    stringBuffer.append(TEXT_770);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_773);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_774);
    
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

    stringBuffer.append(TEXT_775);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_779);
    
	} else {

    stringBuffer.append(TEXT_780);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_781);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_783);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureLinkModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_784);
    
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

    stringBuffer.append(TEXT_785);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_789);
    
	} else {

    stringBuffer.append(TEXT_790);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_792);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_793);
    
	}

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_794);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_795);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_796);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_797);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_798);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_799);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_800);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_802);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_803);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_804);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_807);
    
{
	Iterator _containedTypeModelFacetLinks = myHelper.getContainedTypeModelFacetLinks();
	Iterator _containedFeatureModelFacetLinks = myHelper.getContainedFeatureModelFacetLinks();
	String _diagramCode = "getHost().getDiagram()";

    stringBuffer.append(TEXT_808);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_811);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IViewDecorator"));
    stringBuffer.append(TEXT_812);
    
	for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_813);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_816);
    
	}
	for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_817);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_819);
    
	}

    stringBuffer.append(TEXT_820);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(_diagramCode);
    stringBuffer.append(TEXT_822);
    
}

    stringBuffer.append(TEXT_823);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_824);
    
{
	Iterator _containedTypeModelFacetLinks = myHelper.getContainedTypeModelFacetLinks();
	Iterator _containedFeatureModelFacetLinks = myHelper.getContainedFeatureModelFacetLinks();

    stringBuffer.append(TEXT_825);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_828);
    
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

    stringBuffer.append(TEXT_829);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_832);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_833);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_834);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_835);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_837);
    
	} else {

    stringBuffer.append(TEXT_838);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_839);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_840);
    
	}

    stringBuffer.append(TEXT_841);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_842);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_843);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_844);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_845);
    
		} else {

    stringBuffer.append(TEXT_846);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_847);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_848);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_850);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_851);
    
		} else {

    stringBuffer.append(TEXT_852);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_853);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_854);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_855);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_857);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_858);
    
		} else {

    stringBuffer.append(TEXT_859);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_860);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_861);
    
		}

    stringBuffer.append(TEXT_862);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_863);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_864);
    
		} else {

    stringBuffer.append(TEXT_865);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_866);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_867);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_868);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_869);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_870);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_871);
    
	} else {

    stringBuffer.append(TEXT_872);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_873);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_874);
    
	}

    stringBuffer.append(TEXT_875);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_876);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_878);
    
	}

    stringBuffer.append(TEXT_879);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_880);
    
	}
}

    stringBuffer.append(TEXT_881);
    
}

    stringBuffer.append(TEXT_882);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_885);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_887);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_890);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_891);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_893);
    
	}
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_894);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_896);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_897);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_898);
    
		}

    stringBuffer.append(TEXT_899);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_900);
    
		} else {

    stringBuffer.append(TEXT_901);
    
		}
	}
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_902);
    
		}

    stringBuffer.append(TEXT_903);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_905);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_906);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_907);
    
		}

    stringBuffer.append(TEXT_908);
    
	}

    stringBuffer.append(TEXT_909);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_912);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_920);
    
}

    
}	//end of local declarations

    stringBuffer.append(TEXT_921);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_930);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_931);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_932);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_933);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_944);
    
}

    stringBuffer.append(TEXT_945);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_946);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_947);
    
}

    stringBuffer.append(TEXT_948);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(TEXT_950);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_951);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_958);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_961);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_962);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(TEXT_967);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(TEXT_979);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_984);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(TEXT_987);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(TEXT_989);
    stringBuffer.append(TEXT_990);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(TEXT_992);
    stringBuffer.append(TEXT_993);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_994);
    stringBuffer.append(TEXT_995);
    stringBuffer.append(TEXT_996);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_997);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_999);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_1004);
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_1005);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_1006);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_1007);
    
}

    
}

    stringBuffer.append(TEXT_1008);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart"));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand"));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1024);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_1025);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1027);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1028);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1031);
    
	} else {

    stringBuffer.append(TEXT_1032);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1036);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1037);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1040);
    
	} else {

    stringBuffer.append(TEXT_1041);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1045);
    
	}

    stringBuffer.append(TEXT_1046);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1047);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1050);
    
	} else {

    stringBuffer.append(TEXT_1051);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1055);
    
	}
}

    stringBuffer.append(TEXT_1056);
    
}	/*restrict local vars used in component edit policy*/

    
if (myHelper.getPrimaryLabel() != null) {
		String editPatternCode = importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()) + ".EDIT_PATTERN";
		String resolvedSemanticElement = "(" + importManager.getImportedName(genNode.getDomainMetaClass().getQualifiedInterfaceName()) + ") getDiagramNode().getElement()";
		LabelModelFacet labelModelFacet = myHelper.getPrimaryLabel().getModelFacet();
		GenClass underlyingMetaClass = genNode.getDomainMetaClass();

    stringBuffer.append(TEXT_1057);
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_1065);
    
if (labelModelFacet instanceof FeatureLabelModelFacet == false) {

    stringBuffer.append(TEXT_1066);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1067);
    
} else {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = featureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_1068);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1069);
    
	if (metaFeatures.size() == 1 && String.class.equals(((GenFeature) metaFeatures.get(0)).getEcoreFeature().getEType().getInstanceClass())) {

    stringBuffer.append(TEXT_1070);
    
	}

    stringBuffer.append(TEXT_1071);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(editPatternCode);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1076);
    
	if (metaFeatures.size() == 1 && String.class.equals(((GenFeature) metaFeatures.get(0)).getEcoreFeature().getEType().getInstanceClass())) {

    stringBuffer.append(TEXT_1077);
    
	}

    stringBuffer.append(TEXT_1078);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1091);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_1092);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_1093);
    }
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1100);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_1101);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_1102);
    }
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1107);
    
		} else {

    stringBuffer.append(TEXT_1108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1110);
    
		}

    
	}

    stringBuffer.append(TEXT_1111);
    
}

    stringBuffer.append(TEXT_1112);
    
}

    stringBuffer.append(TEXT_1113);
    
if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_1114);
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.TreeItem"));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.TreeItem"));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1126);
    
}

    stringBuffer.append(TEXT_1127);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_1131);
    
if (myHelper.getPrimaryLabel() != null) {

    stringBuffer.append(TEXT_1132);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(importManager.getImportedName(myHelper.getPrimaryLabel().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_1141);
    
}

    stringBuffer.append(TEXT_1142);
    
if (myHelper.getPrimaryLabel() != null) {
	LabelModelFacet labelModelFacet = myHelper.getPrimaryLabel().getModelFacet();
	if (labelModelFacet instanceof FeatureLabelModelFacet) {
		FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
		for(Iterator it = featureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
			GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_1143);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_1145);
    
		}
	}
} else {
	GenClass metaClass = genNode.getDomainMetaClass();
	if (metaClass != null) {
		List labelNotifyFeatures = metaClass.getLabelNotifyFeatures();
		for(Iterator it = labelNotifyFeatures.iterator(); it.hasNext(); ) {
			GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_1146);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_1148);
    
		}
	}

    
}

    stringBuffer.append(TEXT_1149);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle"));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle"));
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_1159);
    
	for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
		GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_1160);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1161);
    
}

    
		for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();){
			GenCompartment next = (GenCompartment) compartments.next();

    stringBuffer.append(TEXT_1162);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_1163);
    
}

    stringBuffer.append(TEXT_1164);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_1165);
    return stringBuffer.toString();
  }
}
