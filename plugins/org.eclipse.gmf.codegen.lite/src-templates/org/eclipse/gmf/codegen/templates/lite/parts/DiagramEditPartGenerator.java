package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class DiagramEditPartGenerator
{
  protected static String nl;
  public static synchronized DiagramEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditPartGenerator result = new DiagramEditPartGenerator();
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
  protected final String TEXT_20 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_21 = " extends AbstractGraphicalEditPart implements ";
  protected final String TEXT_22 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String MODEL_ID = \"";
  protected final String TEXT_23 = "\";" + NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_28 = "(";
  protected final String TEXT_29 = " model) {" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_30 = " getDiagram() {" + NL + "\t\treturn (";
  protected final String TEXT_31 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_34 = " view = (";
  protected final String TEXT_35 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_36 = " view = (";
  protected final String TEXT_37 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addNotify() {" + NL + "\t\tsuper.addNotify();" + NL + "\t\tgetDiagram().eAdapters().add(getUpdateManager());" + NL + "\t\tgetDiagram().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\tinstallEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {" + NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {";
  protected final String TEXT_38 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_39 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = " requestEx = (";
  protected final String TEXT_41 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = " result = new ";
  protected final String TEXT_43 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_45 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_46 = "(getDiagram(), requestEx, (";
  protected final String TEXT_47 = ")getConstraintFor(request)));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_49 = "(";
  protected final String TEXT_50 = ".getEditingDomain(getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_51 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = NL + "protected Command createAddCommand(final ";
  protected final String TEXT_54 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_55 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_56 = " childNode = (";
  protected final String TEXT_57 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_58 = " editingDomain = ";
  protected final String TEXT_59 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_60 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_61 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int visualID = ";
  protected final String TEXT_62 = ".getVisualID(childNode);" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_63 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_64 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_65 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_66 = NL + "\t\t\tcase ";
  protected final String TEXT_67 = ".VISUAL_ID:" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = " result = new ";
  protected final String TEXT_69 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_70 = " element = childNode.getElement();";
  protected final String TEXT_71 = NL + "\t\t\t\t\tswitch (visualID) {";
  protected final String TEXT_72 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_73 = ".VISUAL_ID:";
  protected final String TEXT_74 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_75 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_76 = ".eINSTANCE.get";
  protected final String TEXT_77 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_78 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_79 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_80 = ".eINSTANCE.get";
  protected final String TEXT_81 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_82 = ".UNSET_VALUE));";
  protected final String TEXT_83 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_84 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_85 = ".eINSTANCE.get";
  protected final String TEXT_86 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_87 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_88 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_89 = ".eINSTANCE.get";
  protected final String TEXT_90 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = ".UNSET_VALUE));";
  protected final String TEXT_92 = NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_93 = NL + "\t\t\t\t\t}\t";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\t\tif (";
  protected final String TEXT_96 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_97 = NL + "\t\t}";
  protected final String TEXT_98 = NL + "\t\tif (";
  protected final String TEXT_99 = ".size() >= ";
  protected final String TEXT_100 = ".eINSTANCE.get";
  protected final String TEXT_101 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t}";
  protected final String TEXT_103 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_104 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_105 = ".getElement(), ";
  protected final String TEXT_106 = ".eINSTANCE.get";
  protected final String TEXT_107 = "(), element));";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = NL + "\t\tif (";
  protected final String TEXT_110 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t}";
  protected final String TEXT_112 = NL + "\t\tif (";
  protected final String TEXT_113 = ".size() >= ";
  protected final String TEXT_114 = ".eINSTANCE.get";
  protected final String TEXT_115 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "\t\t}";
  protected final String TEXT_117 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_118 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = ".getElement(), ";
  protected final String TEXT_120 = ".eINSTANCE.get";
  protected final String TEXT_121 = "(), element));";
  protected final String TEXT_122 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_123 = ".create(editingDomain, childNode.eContainer(), childNode.eContainmentFeature(), childNode));" + NL + "\t\t\t\t\tif (newVisualID == visualID) {" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_124 = ".create(editingDomain, ";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ".eINSTANCE.getView_PersistedChildren(), childNode));" + NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_127 = "(childNode, ";
  protected final String TEXT_128 = "null";
  protected final String TEXT_129 = "(";
  protected final String TEXT_130 = ") constraint";
  protected final String TEXT_131 = "));" + NL + "\t\t\t\t\t} else {";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_133 = "(";
  protected final String TEXT_134 = ", element, ";
  protected final String TEXT_135 = "null";
  protected final String TEXT_136 = "((";
  protected final String TEXT_137 = ") constraint).getCopy().union(new ";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = ", ";
  protected final String TEXT_140 = "))";
  protected final String TEXT_141 = ", ";
  protected final String TEXT_142 = ".INSTANCE));";
  protected final String TEXT_143 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcommand = result;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_144 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_145 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_146 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_147 = NL;
  protected final String TEXT_148 = NL + "protected ";
  protected final String TEXT_149 = " getCloneCommand(";
  protected final String TEXT_150 = " request) {" + NL + "\t";
  protected final String TEXT_151 = " editParts = request.getEditParts();" + NL + "\t";
  protected final String TEXT_152 = " command = new ";
  protected final String TEXT_153 = "();" + NL + "\tcommand.setDebugLabel(\"Clone in ConstrainedLayoutEditPolicy\");//$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_154 = " childPart;" + NL + "\t";
  protected final String TEXT_155 = " r;" + NL + "\tObject constraint;" + NL + "" + NL + "\tfor (int i = 0; i < editParts.size(); i++) {" + NL + "\t\tchildPart = (";
  protected final String TEXT_156 = ")editParts.get(i);" + NL + "\t\tr = childPart.getFigure().getBounds().getCopy();" + NL + "\t\t//convert r to absolute from childpart figure" + NL + "\t\tchildPart.getFigure().translateToAbsolute(r);" + NL + "\t\tr = request.getTransformedRectangle(r);" + NL + "\t\t//convert this figure to relative " + NL + "\t\tgetLayoutContainer().translateToRelative(r);" + NL + "\t\tgetLayoutContainer().translateFromParent(r);" + NL + "\t\tr.translate(getLayoutOrigin().getNegated());" + NL + "\t\tconstraint = getConstraintFor(r);" + NL + "\t\tcommand.add(createCloneCommand(childPart," + NL + "\t\t\ttranslateToModelConstraint(constraint)));" + NL + "\t}" + NL + "\treturn command.unwrap();" + NL + "}" + NL + "protected ";
  protected final String TEXT_157 = " createCloneCommand(final ";
  protected final String TEXT_158 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_159 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_160 = " childNode = (";
  protected final String TEXT_161 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_162 = " editingDomain = ";
  protected final String TEXT_163 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_164 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_165 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_166 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_167 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_168 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_169 = NL + "\t\t\tcase ";
  protected final String TEXT_170 = ".VISUAL_ID:" + NL + "\t\t\t\tcommand = new ";
  protected final String TEXT_171 = "() {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_172 = " afterCopyCommand;" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_173 = " createCommand() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_174 = " element = childNode.getElement();" + NL + "\t\t\t\t\t\t//We are being optimistic here about whether further commands can be executed." + NL + "\t\t\t\t\t\t//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.  " + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_175 = ".create(editingDomain, element);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (!super.prepare()) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_176 = NL;
  protected final String TEXT_177 = NL + "\t\tif (";
  protected final String TEXT_178 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_179 = NL + "\t\t}";
  protected final String TEXT_180 = NL + "\t\tif (";
  protected final String TEXT_181 = ".size() >= ";
  protected final String TEXT_182 = ".eINSTANCE.get";
  protected final String TEXT_183 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_184 = NL + "\t\t}";
  protected final String TEXT_185 = NL;
  protected final String TEXT_186 = NL + "\t\tif (";
  protected final String TEXT_187 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_188 = NL + "\t\t}";
  protected final String TEXT_189 = NL + "\t\tif (";
  protected final String TEXT_190 = ".size() >= ";
  protected final String TEXT_191 = ".eINSTANCE.get";
  protected final String TEXT_192 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t\t}";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tsuper.execute();" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_195 = " results = super.getResult();" + NL + "\t\t\t\t\t\tassert results.size() == 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_196 = " result = (";
  protected final String TEXT_197 = ") results.iterator().next();" + NL + "\t\t\t\t\t\tafterCopyCommand = new ";
  protected final String TEXT_198 = "();";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_200 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_201 = ".getElement(), ";
  protected final String TEXT_202 = ".eINSTANCE.get";
  protected final String TEXT_203 = "(), result));";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_205 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_206 = ".getElement(), ";
  protected final String TEXT_207 = ".eINSTANCE.get";
  protected final String TEXT_208 = "(), result));";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\tafterCopyCommand.append(new ";
  protected final String TEXT_210 = "(";
  protected final String TEXT_211 = ", result, ";
  protected final String TEXT_212 = "null";
  protected final String TEXT_213 = "((";
  protected final String TEXT_214 = ") constraint).getCopy().union(new ";
  protected final String TEXT_215 = "(";
  protected final String TEXT_216 = ", ";
  protected final String TEXT_217 = "))";
  protected final String TEXT_218 = ", ";
  protected final String TEXT_219 = ".INSTANCE));" + NL + "\t\t\t\t\t\tif (afterCopyCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tafterCopyCommand.execute();" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tassert false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tafterCopyCommand.undo();" + NL + "\t\t\t\t\t\tsuper.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\tsuper.redo();" + NL + "\t\t\t\t\t\tafterCopyCommand.redo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_220 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_221 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_222 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_223 = NL + "\t\t\tprotected ";
  protected final String TEXT_224 = " createChangeConstraintCommand(final ";
  protected final String TEXT_225 = " request, final ";
  protected final String TEXT_226 = " child, Object constraint) {";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = "\t\t\t\tfinal ";
  protected final String TEXT_229 = " node = (";
  protected final String TEXT_230 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_231 = " emfCommand = new ";
  protected final String TEXT_232 = "(node, request, ((";
  protected final String TEXT_233 = ")child).getFigure());" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_234 = "(";
  protected final String TEXT_235 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_236 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_237 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_238 = NL;
  protected final String TEXT_239 = "protected ";
  protected final String TEXT_240 = " createChildEditPolicy(";
  protected final String TEXT_241 = " child) {" + NL + "\tif (child != null) {" + NL + "\t\t";
  protected final String TEXT_242 = " result = child.getEditPolicy(";
  protected final String TEXT_243 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\tif (result != null) {" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn super.createChildEditPolicy(child);" + NL + "}" + NL + "\t\t});";
  protected final String TEXT_244 = NL;
  protected final String TEXT_245 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_246 = "\", new ";
  protected final String TEXT_247 = "()); //$NON-NLS-1$";
  protected final String TEXT_248 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_249 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_250 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFigure() {" + NL + "\t\tIFigure f = new FreeformLayer();" + NL + "\t\tf.setBorder(new MarginBorder(5));" + NL + "\t\tf.setLayoutManager(new FreeformLayout());" + NL + "\t\treturn f;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (";
  protected final String TEXT_251 = ".class == key) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_252 = "(this);" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_253 = ".class == key) {" + NL + "\t\t\treturn getTreeEditPartAdapter();" + NL + "\t\t}";
  protected final String TEXT_254 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter myTreeEditPartAdapter;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter getTreeEditPartAdapter() {" + NL + "\t\tif (myTreeEditPartAdapter == null) {" + NL + "\t\t\tmyTreeEditPartAdapter = new TreeEditPartAdapter();" + NL + "\t\t}" + NL + "\t\treturn myTreeEditPartAdapter;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn getDiagram().getVisibleChildren();" + NL + "\t}" + NL;
  protected final String TEXT_255 = NL;
  protected final String TEXT_256 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_257 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_258 = " feature, ";
  protected final String TEXT_259 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_260 = NL;
  protected final String TEXT_261 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_262 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_263 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_264 = ".eINSTANCE.getView_Styles(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_265 = ".eINSTANCE.getDrawerStyle_Collapsed(), childrenRefresher);" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tif (!getDiagram().eAdapters().contains(getUpdateManager())) {" + NL + "\t\t\tgetDiagram().eAdapters().add(getUpdateManager());" + NL + "\t\t}" + NL + "\t\tif (!getDiagram().getElement().eAdapters().contains(domainModelRefresher)) {" + NL + "\t\t\tgetDiagram().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\t}" + NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_266 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_267 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_268 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_269 = NL + "\t\tuninstallNotationModelRefresher();" + NL + "\t\tgetDiagram().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tgetDiagram().eAdapters().remove(getUpdateManager());" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_270 = NL;
  protected final String TEXT_271 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_272 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_273 = " domainModelEditDomain = ";
  protected final String TEXT_274 = ".getEditingDomain(";
  protected final String TEXT_275 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_276 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_277 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_278 = " {";
  protected final String TEXT_279 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_280 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_281 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_282 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_283 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_284 = " createFilter() {";
  protected final String TEXT_285 = NL + "\t\t\t";
  protected final String TEXT_286 = " filter = ";
  protected final String TEXT_287 = ".createFeatureFilter(";
  protected final String TEXT_288 = ".eINSTANCE.get";
  protected final String TEXT_289 = "());";
  protected final String TEXT_290 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_291 = ".createFeatureFilter(";
  protected final String TEXT_292 = ".eINSTANCE.get";
  protected final String TEXT_293 = "()));";
  protected final String TEXT_294 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_295 = ".createNotifierFilter(";
  protected final String TEXT_296 = ".getElement()));";
  protected final String TEXT_297 = NL + "\t\t\t";
  protected final String TEXT_298 = " filter = ";
  protected final String TEXT_299 = ".createNotifierFilter(";
  protected final String TEXT_300 = ".getElement());";
  protected final String TEXT_301 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_302 = NL + "\t\t\t";
  protected final String TEXT_303 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_304 = NL + "\t\t\t";
  protected final String TEXT_305 = " filter = ";
  protected final String TEXT_306 = ".NOT_TOUCH;";
  protected final String TEXT_307 = NL + "\t\t\treturn filter;";
  protected final String TEXT_308 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_309 = " getCreateNotationalElementCommand(";
  protected final String TEXT_310 = " descriptor) {";
  protected final String TEXT_311 = NL;
  protected final String TEXT_312 = "\t\t\t";
  protected final String TEXT_313 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_314 = NL + "\t\t\tcase ";
  protected final String TEXT_315 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_316 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_317 = "(";
  protected final String TEXT_318 = ", domainElement, ";
  protected final String TEXT_319 = "new ";
  protected final String TEXT_320 = "(0, 0, ";
  protected final String TEXT_321 = ", ";
  protected final String TEXT_322 = ")";
  protected final String TEXT_323 = NL + "null";
  protected final String TEXT_324 = ", ";
  protected final String TEXT_325 = ".INSTANCE);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_326 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_327 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_328 = " getSemanticChildNodes() {";
  protected final String TEXT_329 = NL;
  protected final String TEXT_330 = NL + "\treturn ";
  protected final String TEXT_331 = ".EMPTY_LIST;";
  protected final String TEXT_332 = NL + "\t";
  protected final String TEXT_333 = " result = new ";
  protected final String TEXT_334 = "();";
  protected final String TEXT_335 = NL + "\t";
  protected final String TEXT_336 = " viewObject = ";
  protected final String TEXT_337 = ";" + NL + "\t";
  protected final String TEXT_338 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_339 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_340 = NL + "\tfor(";
  protected final String TEXT_341 = " it = ";
  protected final String TEXT_342 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_343 = ") it.next();";
  protected final String TEXT_344 = NL + "\tnextValue = (";
  protected final String TEXT_345 = ")";
  protected final String TEXT_346 = ";";
  protected final String TEXT_347 = NL + "\tnodeVID = ";
  protected final String TEXT_348 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_349 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_350 = NL + "\tcase ";
  protected final String TEXT_351 = ".VISUAL_ID: {";
  protected final String TEXT_352 = NL + "\tif (";
  protected final String TEXT_353 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_354 = NL + "\t\tresult.add(new ";
  protected final String TEXT_355 = "(nextValue, nodeVID));";
  protected final String TEXT_356 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_357 = NL + "\t\t}";
  protected final String TEXT_358 = NL + "\t}";
  protected final String TEXT_359 = NL + "\t}";
  protected final String TEXT_360 = NL + "\treturn result;";
  protected final String TEXT_361 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_362 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_363 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_364 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_365 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_366 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_367 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_368 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_369 = " domainModelEditDomain = ";
  protected final String TEXT_370 = ".getEditingDomain(";
  protected final String TEXT_371 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_372 = "(domainModelEditDomain, command));" + NL + "\t}" + NL + NL;
  protected final String TEXT_373 = NL;
  protected final String TEXT_374 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_375 = " domainModelEditDomain = ";
  protected final String TEXT_376 = ".getEditingDomain(";
  protected final String TEXT_377 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * Service to find a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_378 = " viewService;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_379 = " getViewService() {" + NL + "\t\tif (viewService == null) {" + NL + "\t\t\tviewService = new ";
  protected final String TEXT_380 = "(getViewer());" + NL + "\t\t}" + NL + "\t\treturn viewService;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher(getViewService());" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_381 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher(";
  protected final String TEXT_382 = " viewService) {" + NL + "\t\t\tsuper(viewService);" + NL + "\t\t}";
  protected final String TEXT_383 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_384 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_385 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_386 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_387 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_388 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_389 = ".createEventTypeFilter(";
  protected final String TEXT_390 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_391 = ".createEventTypeFilter(";
  protected final String TEXT_392 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_393 = ".createEventTypeFilter(";
  protected final String TEXT_394 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_395 = ".createEventTypeFilter(";
  protected final String TEXT_396 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_397 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_398 = " createFilter() {";
  protected final String TEXT_399 = NL;
  protected final String TEXT_400 = NL + "\t\t\t";
  protected final String TEXT_401 = " filter = ";
  protected final String TEXT_402 = ".createFeatureFilter(";
  protected final String TEXT_403 = ".eINSTANCE.get";
  protected final String TEXT_404 = "());";
  protected final String TEXT_405 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_406 = ".createFeatureFilter(";
  protected final String TEXT_407 = ".eINSTANCE.get";
  protected final String TEXT_408 = "()));";
  protected final String TEXT_409 = NL;
  protected final String TEXT_410 = NL + "\t\t\t";
  protected final String TEXT_411 = " filter = ";
  protected final String TEXT_412 = ".createFeatureFilter(";
  protected final String TEXT_413 = ".eINSTANCE.get";
  protected final String TEXT_414 = "());";
  protected final String TEXT_415 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_416 = ".createFeatureFilter(";
  protected final String TEXT_417 = ".eINSTANCE.get";
  protected final String TEXT_418 = "()));";
  protected final String TEXT_419 = NL;
  protected final String TEXT_420 = NL + "\t\t\t";
  protected final String TEXT_421 = " filter = ";
  protected final String TEXT_422 = ".createFeatureFilter(";
  protected final String TEXT_423 = ".eINSTANCE.get";
  protected final String TEXT_424 = "());";
  protected final String TEXT_425 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_426 = ".createFeatureFilter(";
  protected final String TEXT_427 = ".eINSTANCE.get";
  protected final String TEXT_428 = "()));";
  protected final String TEXT_429 = NL;
  protected final String TEXT_430 = NL + "\t\t\t";
  protected final String TEXT_431 = " filter = ";
  protected final String TEXT_432 = ".createFeatureFilter(";
  protected final String TEXT_433 = ".eINSTANCE.get";
  protected final String TEXT_434 = "());";
  protected final String TEXT_435 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_436 = ".createFeatureFilter(";
  protected final String TEXT_437 = ".eINSTANCE.get";
  protected final String TEXT_438 = "()));";
  protected final String TEXT_439 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_440 = NL + "\t\t\t";
  protected final String TEXT_441 = " filter = getConstrainedChildLinksFilter();";
  protected final String TEXT_442 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_443 = NL + "\t\t\t";
  protected final String TEXT_444 = " filter = createUncontainedLinksFilter();";
  protected final String TEXT_445 = NL + "\t\t\t";
  protected final String TEXT_446 = " filter = ";
  protected final String TEXT_447 = ".NOT_TOUCH;";
  protected final String TEXT_448 = NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t\tprotected ";
  protected final String TEXT_449 = " getCreateNotationalElementCommand(";
  protected final String TEXT_450 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_451 = " linkDescriptor = (";
  protected final String TEXT_452 = ") descriptor;";
  protected final String TEXT_453 = NL;
  protected final String TEXT_454 = "\t\t\t";
  protected final String TEXT_455 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_456 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\t";
  protected final String TEXT_457 = " decorator = null;" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_458 = NL + "\t\t\tcase ";
  protected final String TEXT_459 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_460 = ") {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_461 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_462 = NL + "\t\t\tcase ";
  protected final String TEXT_463 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_464 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_465 = NL + "\t\t\t}" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_466 = "(";
  protected final String TEXT_467 = ", linkDescriptor.getElement(), sourceView, targetView, decorator);";
  protected final String TEXT_468 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_469 = " getSemanticChildLinks() {";
  protected final String TEXT_470 = NL;
  protected final String TEXT_471 = "\t";
  protected final String TEXT_472 = " result = new ";
  protected final String TEXT_473 = "();";
  protected final String TEXT_474 = NL + "\t";
  protected final String TEXT_475 = " modelObject = ";
  protected final String TEXT_476 = ".getElement();" + NL + "\t";
  protected final String TEXT_477 = " nextValue;";
  protected final String TEXT_478 = NL + "\tint linkVID;";
  protected final String TEXT_479 = NL + "\tfor(";
  protected final String TEXT_480 = " it = ";
  protected final String TEXT_481 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_482 = ") it.next();";
  protected final String TEXT_483 = NL + "\tnextValue = (";
  protected final String TEXT_484 = ")";
  protected final String TEXT_485 = ";";
  protected final String TEXT_486 = NL + "\tlinkVID = ";
  protected final String TEXT_487 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_488 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_489 = NL + "\tcase ";
  protected final String TEXT_490 = ".VISUAL_ID: {";
  protected final String TEXT_491 = NL + "\tif (";
  protected final String TEXT_492 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_493 = NL + "\t\t";
  protected final String TEXT_494 = " source = (";
  protected final String TEXT_495 = ")";
  protected final String TEXT_496 = ";";
  protected final String TEXT_497 = NL + "\t\t";
  protected final String TEXT_498 = " source = ";
  protected final String TEXT_499 = ".getElement();";
  protected final String TEXT_500 = NL + "\t\t";
  protected final String TEXT_501 = " target = (";
  protected final String TEXT_502 = ")";
  protected final String TEXT_503 = ";";
  protected final String TEXT_504 = NL + "\t\t";
  protected final String TEXT_505 = " target = ";
  protected final String TEXT_506 = ".getElement();";
  protected final String TEXT_507 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_508 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_509 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_510 = NL + "\t}";
  protected final String TEXT_511 = NL + "\t}";
  protected final String TEXT_512 = NL + "\t}";
  protected final String TEXT_513 = NL + "\tfor(";
  protected final String TEXT_514 = " it = ";
  protected final String TEXT_515 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_516 = ") it.next();";
  protected final String TEXT_517 = NL + "\tnextValue = (";
  protected final String TEXT_518 = ")";
  protected final String TEXT_519 = ";";
  protected final String TEXT_520 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_521 = NL + "\t\tresult.add(new ";
  protected final String TEXT_522 = "(modelObject, nextValue, null, ";
  protected final String TEXT_523 = ".VISUAL_ID));";
  protected final String TEXT_524 = NL + "\t}";
  protected final String TEXT_525 = NL + "\t}";
  protected final String TEXT_526 = NL + "\treturn result;";
  protected final String TEXT_527 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_528 = " getNotationalChildLinks() {" + NL + "\t\t\t";
  protected final String TEXT_529 = " result = new ";
  protected final String TEXT_530 = "();" + NL + "\t\t\t";
  protected final String TEXT_531 = " allLinks = ";
  protected final String TEXT_532 = ".getEdges();" + NL + "\t\t\tfor(";
  protected final String TEXT_533 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_534 = " next = (";
  protected final String TEXT_535 = ") it.next();";
  protected final String TEXT_536 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_537 = " source = next.getSource();" + NL + "\t\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_538 = " target = next.getTarget();" + NL + "\t\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}";
  protected final String TEXT_539 = NL + "\t\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_540 = ") {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_541 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_542 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_543 = ".VISUAL_ID:";
  protected final String TEXT_544 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_545 = NL + "\t\t\t\t} else {";
  protected final String TEXT_546 = NL + "\t\t\t\t}";
  protected final String TEXT_547 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_548 = NL + "\t\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_549 = ".getElement()) {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_550 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_551 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_552 = ".VISUAL_ID:";
  protected final String TEXT_553 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_554 = NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_555 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_556 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_557 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_558 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_559 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_560 = " linkRefresher = getLinkNotationModelRefresher();" + NL + "\t\tif (!linkRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_561 = " command = linkRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_562 = " domainModelEditDomain = ";
  protected final String TEXT_563 = ".getEditingDomain(";
  protected final String TEXT_564 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_565 = "(domainModelEditDomain, command));" + NL + "\t}";
  protected final String TEXT_566 = NL;
  protected final String TEXT_567 = NL;
  protected final String TEXT_568 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_569 = " domainModelRefresher = new ";
  protected final String TEXT_570 = "(this);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_571 = " updateManager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_572 = " getUpdateManager() {" + NL + "\t\tif (updateManager == null) {" + NL + "\t\t\tupdateManager = new ";
  protected final String TEXT_573 = "(getViewer());" + NL + "\t\t}" + NL + "\t\treturn updateManager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class TreeEditPartAdapter extends ";
  protected final String TEXT_574 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic TreeEditPartAdapter() {" + NL + "\t\t\tsuper(getDiagram(), ";
  protected final String TEXT_575 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createEditPolicies() {" + NL + "\t\t\tinstallEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void activate() {" + NL + "\t\t\tsuper.activate();" + NL + "\t\t\tif (!getDiagram().eAdapters().contains(getTreeUpdateManager())) {" + NL + "\t\t\t\tgetDiagram().eAdapters().add(getTreeUpdateManager());" + NL + "\t\t\t}" + NL + "\t\t\tif (!getDiagram().getElement().eAdapters().contains(domainModelRefresher)) {" + NL + "\t\t\t\tgetDiagram().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void deactivate() {" + NL + "\t\t\tgetDiagram().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\t\tgetDiagram().eAdapters().remove(getTreeUpdateManager());" + NL + "\t\t\tsuper.deactivate();" + NL + "\t\t}" + NL;
  protected final String TEXT_576 = NL;
  protected final String TEXT_577 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_578 = " domainModelRefresher = new ";
  protected final String TEXT_579 = "(this);" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_580 = " treeUpdateManager;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_581 = " getTreeUpdateManager() {" + NL + "\t\t\tif (treeUpdateManager == null) {" + NL + "\t\t\t\ttreeUpdateManager = new ";
  protected final String TEXT_582 = "(getViewer());" + NL + "\t\t\t}" + NL + "\t\t\treturn treeUpdateManager;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_583 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("NotationModelRefresher");	//from notationModelRefresher.jetinc
importManager.registerInnerClass("LinkNotationModelRefresher");	//from linkNotationModelRefresher.jetinc
importManager.registerInnerClass("TreeEditPartAdapter");
List childNodes = genDiagram.getTopLevelNodes();

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
    
class DiagramEditPartHelper {
	private final List myContainedFeatureModelFacetLinks = new LinkedList();
	private final List myContainedTypeModelFacetLinks = new LinkedList();
	public DiagramEditPartHelper(GenDiagram diagram) {
		for(Iterator it = diagram.getLinks().iterator(); it.hasNext(); ) {
			GenLink genLink = (GenLink)it.next();
			if (!genLink.isViewDirectionAlignedWithModel() || genLink.getModelFacet() == null) {
				continue;
			}
			GenClass containerClass;
			if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
				if (modelFacet.getSourceMetaFeature() == null && modelFacet.getTargetMetaFeature() == null) {
					//if one link feature is null, the element is treated as this end of the link. If both are null, we cannot do anything about such a link.
					containerClass = null;
				} else {
					containerClass = modelFacet.getContainmentMetaFeature().getGenClass();
				}
			} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
				GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
				containerClass = metaFeature.getGenClass();
			} else {
				continue;
			}
			if (containerClass.getEcoreClass().isSuperTypeOf(diagram.getDomainDiagramElement().getEcoreClass())) {
				if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
					myContainedTypeModelFacetLinks.add(genLink);
				} else {
					myContainedFeatureModelFacetLinks.add(genLink);
				}
			}
		}
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

	public Iterator getContainedFeatureModelFacetLinks() {
		return myContainedFeatureModelFacetLinks.iterator();
	}

	public Iterator getContainedTypeModelFacetLinks() {
		return myContainedTypeModelFacetLinks.iterator();
	}
}
final DiagramEditPartHelper myHelper = new DiagramEditPartHelper(genDiagram);

    stringBuffer.append(TEXT_19);
    
importManager.emitPackageStatement(stringBuffer);
importManager.addImport("org.eclipse.gef.editparts.AbstractGraphicalEditPart");
importManager.addImport("org.eclipse.draw2d.IFigure");
importManager.addImport("org.eclipse.draw2d.FreeformLayer");
importManager.addImport("org.eclipse.draw2d.FreeformLayout");
importManager.addImport("org.eclipse.draw2d.MarginBorder");
importManager.addImport("org.eclipse.gef.commands.Command");
importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.draw2d.geometry.Dimension");
importManager.addImport("org.eclipse.draw2d.geometry.Point");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.SnapToGrid");
importManager.addImport("org.eclipse.gef.SnapToHelper");
importManager.addImport("org.eclipse.gef.editpolicies.RootComponentEditPolicy");
importManager.addImport("org.eclipse.gef.commands.UnexecutableCommand");
importManager.addImport("org.eclipse.gef.editpolicies.RootComponentEditPolicy");
importManager.addImport("org.eclipse.gef.editpolicies.XYLayoutEditPolicy");
importManager.addImport("org.eclipse.gef.requests.ChangeBoundsRequest");
importManager.addImport("org.eclipse.gef.requests.CreateRequest");
importManager.addImport("org.eclipse.gmf.runtime.notation.Bounds");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.notation.Node");
importManager.addImport("org.eclipse.gmf.runtime.notation.NotationPackage");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("java.util.List");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_23);
    {
GenCommonBase genCommonBase = genDiagram;
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_37);
    if (null != genDiagram.getPalette()) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_43);
    
for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenTopLevelNode next = (GenTopLevelNode)it.next();

    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".Create" + next.getDomainMetaClass().getName() + next.getVisualID() + "Command"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_47);
    
}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_50);
    }/*when there's palette*/
    stringBuffer.append(TEXT_51);
    
{
	String _getViewCode = "getDiagram()";
	boolean isListLayout = false;

    stringBuffer.append(TEXT_52);
    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_65);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_70);
    
		{
			Collection<GenNode> relatedNodes = myRelatedNodesFinder.getRelatedGenNodes(next.getDomainMetaClass());
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_71);
    
			}
			for(GenNode nextRelated : relatedNodes) {
				TypeModelFacet facet = nextRelated.getModelFacet();
				GenFeature childFeature = facet.getChildMetaFeature();
				GenFeature containmentFeature = facet.getContainmentMetaFeature();
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(nextRelated.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    
				}
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_77);
    
					} else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_82);
    
					}
				}
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_86);
    
				} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_91);
    
				}
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_92);
    
				}
			}	//for(GenNode nextRelated : relatedNodes)
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_93);
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

    stringBuffer.append(TEXT_94);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_95);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_97);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_98);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_102);
    
	}
}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_107);
    
			}
			{
				GenFeature _feature = containmentFeature;
				String _ownerInstance = _getViewCode + ".getElement()";
				String _exceedsUpperBound = "return " + importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand") + ".INSTANCE;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_108);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_109);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_111);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_112);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_116);
    
	}
}

    
			}

    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_121);
    
		}	//local declaration for related nodes.

    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand"));
    stringBuffer.append(TEXT_127);
    if (isListLayout) {
    stringBuffer.append(TEXT_128);
    } else {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_134);
    if (isListLayout) {
    stringBuffer.append(TEXT_135);
    } else {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_142);
    
		}

    stringBuffer.append(TEXT_143);
    
	}	//for

    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_146);
    
}	//if (!childNodes.isEmpty()) in createAddCommand

    stringBuffer.append(TEXT_147);
    
/* delegation from getCloneCommand to createCloneCommand is 100% analogous to delegation from getAddCommand() to createAddCommand() in ConstrainedLayoutEditPolicy. */

    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_168);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();
		TypeModelFacet facet = next.getModelFacet();
		GenFeature childFeature = facet.getChildMetaFeature();
		GenFeature containmentFeature = facet.getContainmentMetaFeature();

    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CommandWrapper"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.CopyCommand"));
    stringBuffer.append(TEXT_175);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
			GenFeature _feature = childFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_176);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_177);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_179);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_180);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_184);
    
	}
}

    
		}
		{
			GenFeature _feature = containmentFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_185);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound == 1) {

    stringBuffer.append(TEXT_186);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_188);
    
} else {
	if (upperBound > 0) {

    stringBuffer.append(TEXT_189);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_193);
    
	}
}

    
		}

    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_198);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_203);
    
		}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_208);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_211);
    if (isListLayout) {
    stringBuffer.append(TEXT_212);
    } else {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_219);
    
		}
	}	//for

    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_222);
    
}	//if (!childNodes.isEmpty())

    
}

    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_243);
    {
GenCommonBase genCommonBase = genDiagram;
    stringBuffer.append(TEXT_244);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_247);
    }
    }
    stringBuffer.append(TEXT_248);
    
//link notation model refresher should always be installed for the diagram edit part, because it tracks the uncontained links
//if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_249);
    
//}

    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToHelper"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToGrid"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.TreeEditPart"));
    stringBuffer.append(TEXT_253);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_254);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_265);
    
//link notation model refresher should always be installed for the diagram edit part, because it tracks the uncontained links
//if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_266);
    
//}

    stringBuffer.append(TEXT_267);
    
//link notation model refresher should always be installed/uninstalled for the diagram edit part, because it tracks the uncontained links
//if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_268);
    
//}

    stringBuffer.append(TEXT_269);
    
{
String _getDiagramCode = "getDiagram()";
String _getViewCode = "getDiagram()";
boolean isListLayout = false;
final boolean _includeUncontainedLinks = true;

    stringBuffer.append(TEXT_270);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_278);
    
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

    stringBuffer.append(TEXT_279);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_282);
    
}

    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_284);
    
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

    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_289);
    
		} else {

    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_293);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_296);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_300);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_301);
    
		} else {

    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_303);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_306);
    
	}

    stringBuffer.append(TEXT_307);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_310);
    
{
	String _parentNode = "getHost()";

    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_313);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_318);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_322);
    
	} else {

    stringBuffer.append(TEXT_323);
    
	}

    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_325);
    
}

    stringBuffer.append(TEXT_326);
    
}

    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(TEXT_329);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_331);
    
} else {

    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_334);
    
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

    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_339);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_341);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_343);
    
		} else {

    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_345);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_346);
    
	}

    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_348);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_349);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_351);
    
		} else {

    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_353);
    
		}

    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_355);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_356);
    
		} else {

    stringBuffer.append(TEXT_357);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_358);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_359);
    
	}
}

    stringBuffer.append(TEXT_360);
    
}

    stringBuffer.append(TEXT_361);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(TEXT_373);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService"));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_382);
    
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

    stringBuffer.append(TEXT_383);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_386);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_396);
    
	}

    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_398);
    
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

    stringBuffer.append(TEXT_399);
    
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

    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_402);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_404);
    
	} else {

    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_408);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_409);
    
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

    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_414);
    
	} else {

    stringBuffer.append(TEXT_415);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_418);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_419);
    
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

    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_424);
    
	} else {

    stringBuffer.append(TEXT_425);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_428);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureLinkModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_429);
    
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

    stringBuffer.append(TEXT_430);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_434);
    
	} else {

    stringBuffer.append(TEXT_435);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_438);
    
	}

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_439);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_441);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_442);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_443);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_444);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_445);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_447);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_448);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_452);
    
{
	Iterator _containedTypeModelFacetLinks = myHelper.getContainedTypeModelFacetLinks();
	Iterator _containedFeatureModelFacetLinks = myHelper.getContainedFeatureModelFacetLinks();
	String _diagramCode = "getHost().getDiagram()";

    stringBuffer.append(TEXT_453);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IViewDecorator"));
    stringBuffer.append(TEXT_457);
    
	for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_458);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_461);
    
	}
	for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_462);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_464);
    
	}

    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(_diagramCode);
    stringBuffer.append(TEXT_467);
    
}

    stringBuffer.append(TEXT_468);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_469);
    
{
	Iterator _containedTypeModelFacetLinks = myHelper.getContainedTypeModelFacetLinks();
	Iterator _containedFeatureModelFacetLinks = myHelper.getContainedFeatureModelFacetLinks();

    stringBuffer.append(TEXT_470);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_473);
    
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

    stringBuffer.append(TEXT_474);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_477);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_478);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_479);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_480);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_482);
    
	} else {

    stringBuffer.append(TEXT_483);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_484);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_485);
    
	}

    stringBuffer.append(TEXT_486);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_487);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_488);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_489);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_490);
    
		} else {

    stringBuffer.append(TEXT_491);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_492);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_493);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_495);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_496);
    
		} else {

    stringBuffer.append(TEXT_497);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_499);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_500);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_502);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_503);
    
		} else {

    stringBuffer.append(TEXT_504);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_506);
    
		}

    stringBuffer.append(TEXT_507);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_508);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_509);
    
		} else {

    stringBuffer.append(TEXT_510);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_511);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_512);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_513);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_514);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_516);
    
	} else {

    stringBuffer.append(TEXT_517);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_518);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_519);
    
	}

    stringBuffer.append(TEXT_520);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_521);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_523);
    
	}

    stringBuffer.append(TEXT_524);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_525);
    
	}
}

    stringBuffer.append(TEXT_526);
    
}

    stringBuffer.append(TEXT_527);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_535);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_536);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_538);
    
	}
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_539);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_541);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_542);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_543);
    
		}

    stringBuffer.append(TEXT_544);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_545);
    
		} else {

    stringBuffer.append(TEXT_546);
    
		}
	}
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_547);
    
		}

    stringBuffer.append(TEXT_548);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_550);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_551);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_552);
    
		}

    stringBuffer.append(TEXT_553);
    
	}

    stringBuffer.append(TEXT_554);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_555);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_563);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_565);
    
}

    
}

    stringBuffer.append(TEXT_566);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager"));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager"));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager"));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager"));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager"));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.UpdateManager"));
    stringBuffer.append(TEXT_582);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_583);
    return stringBuffer.toString();
  }
}
