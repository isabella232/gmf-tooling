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
  protected final String TEXT_31 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_32 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_33 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_34 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_35 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_36 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_37 = " createChangeConstraintCommand(final ";
  protected final String TEXT_38 = " request, final ";
  protected final String TEXT_39 = " child, Object constraint) {";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "\t\t\t\tfinal ";
  protected final String TEXT_42 = " node = (";
  protected final String TEXT_43 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_44 = " emfCommand = new ";
  protected final String TEXT_45 = "(node, request, ((";
  protected final String TEXT_46 = ")child).getFigure());" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_47 = "(";
  protected final String TEXT_48 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_49 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_50 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_51 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_52 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_53 = "() {" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_54 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_55 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_56 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + "protected Command createAddCommand(final ";
  protected final String TEXT_59 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_60 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_61 = " childNode = (";
  protected final String TEXT_62 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_63 = " editingDomain = ";
  protected final String TEXT_64 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_65 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_66 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int visualID = ";
  protected final String TEXT_67 = ".getVisualID(childNode);" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_68 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_69 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_70 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_71 = NL + "\t\t\tcase ";
  protected final String TEXT_72 = ".VISUAL_ID:" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = " result = new ";
  protected final String TEXT_74 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = " element = childNode.getElement();";
  protected final String TEXT_76 = NL + "\t\t\t\t\tswitch (visualID) {";
  protected final String TEXT_77 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_78 = ".VISUAL_ID:";
  protected final String TEXT_79 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_80 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_81 = ".eINSTANCE.get";
  protected final String TEXT_82 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_83 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_84 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_85 = ".eINSTANCE.get";
  protected final String TEXT_86 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = ".UNSET_VALUE));";
  protected final String TEXT_88 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_89 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_90 = ".eINSTANCE.get";
  protected final String TEXT_91 = "()," + NL + "\t\t\t\t\t\telement));";
  protected final String TEXT_92 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_93 = ".create(" + NL + "\t\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\t\telement.eContainer(), ";
  protected final String TEXT_94 = ".eINSTANCE.get";
  protected final String TEXT_95 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_96 = ".UNSET_VALUE));";
  protected final String TEXT_97 = NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_98 = NL + "\t\t\t\t\t}\t";
  protected final String TEXT_99 = NL;
  protected final String TEXT_100 = NL + "\t\tif (";
  protected final String TEXT_101 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t}";
  protected final String TEXT_103 = NL + "\t\tif (";
  protected final String TEXT_104 = ".size() >= ";
  protected final String TEXT_105 = ".eINSTANCE.get";
  protected final String TEXT_106 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_109 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_110 = ".getElement(), ";
  protected final String TEXT_111 = ".eINSTANCE.get";
  protected final String TEXT_112 = "(), element));";
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = NL + "\t\tif (";
  protected final String TEXT_115 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "\t\t}";
  protected final String TEXT_117 = NL + "\t\tif (";
  protected final String TEXT_118 = ".size() >= ";
  protected final String TEXT_119 = ".eINSTANCE.get";
  protected final String TEXT_120 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_121 = NL + "\t\t}";
  protected final String TEXT_122 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_123 = ".create(" + NL + "\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_124 = ".getElement(), ";
  protected final String TEXT_125 = ".eINSTANCE.get";
  protected final String TEXT_126 = "(), element));";
  protected final String TEXT_127 = NL + "\t\t\t\t\tresult.append(";
  protected final String TEXT_128 = ".create(editingDomain, childNode.eContainer(), childNode.eContainmentFeature(), childNode));" + NL + "\t\t\t\t\tif (newVisualID == visualID) {" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_129 = ".create(editingDomain, ";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ".eINSTANCE.getView_PersistedChildren(), childNode));" + NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_132 = "(childNode, ";
  protected final String TEXT_133 = "null";
  protected final String TEXT_134 = "(";
  protected final String TEXT_135 = ") constraint";
  protected final String TEXT_136 = "));" + NL + "\t\t\t\t\t} else {";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\tresult.append(new ";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = ", element, ";
  protected final String TEXT_140 = "null";
  protected final String TEXT_141 = "((";
  protected final String TEXT_142 = ") constraint).getCopy().union(new ";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = ", ";
  protected final String TEXT_145 = "))";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ".INSTANCE));";
  protected final String TEXT_148 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcommand = result;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_149 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_150 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_151 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_152 = NL;
  protected final String TEXT_153 = NL + "protected ";
  protected final String TEXT_154 = " getCloneCommand(";
  protected final String TEXT_155 = " request) {" + NL + "\t";
  protected final String TEXT_156 = " editParts = request.getEditParts();" + NL + "\t";
  protected final String TEXT_157 = " command = new ";
  protected final String TEXT_158 = "();" + NL + "\tcommand.setDebugLabel(\"Clone in ConstrainedLayoutEditPolicy\");//$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_159 = " childPart;" + NL + "\t";
  protected final String TEXT_160 = " r;" + NL + "\tObject constraint;" + NL + "" + NL + "\tfor (int i = 0; i < editParts.size(); i++) {" + NL + "\t\tchildPart = (";
  protected final String TEXT_161 = ")editParts.get(i);" + NL + "\t\tr = childPart.getFigure().getBounds().getCopy();" + NL + "\t\t//convert r to absolute from childpart figure" + NL + "\t\tchildPart.getFigure().translateToAbsolute(r);" + NL + "\t\tr = request.getTransformedRectangle(r);" + NL + "\t\t//convert this figure to relative " + NL + "\t\tgetLayoutContainer().translateToRelative(r);" + NL + "\t\tgetLayoutContainer().translateFromParent(r);" + NL + "\t\tr.translate(getLayoutOrigin().getNegated());" + NL + "\t\tconstraint = getConstraintFor(r);" + NL + "\t\tcommand.add(createCloneCommand(childPart," + NL + "\t\t\ttranslateToModelConstraint(constraint)));" + NL + "\t}" + NL + "\treturn command.unwrap();" + NL + "}" + NL + "protected ";
  protected final String TEXT_162 = " createCloneCommand(final ";
  protected final String TEXT_163 = " child, final Object constraint) {" + NL + "\tif (child.getModel() instanceof ";
  protected final String TEXT_164 = ") {" + NL + "\t\tfinal ";
  protected final String TEXT_165 = " childNode = (";
  protected final String TEXT_166 = ") child.getModel();" + NL + "\t\tfinal ";
  protected final String TEXT_167 = " editingDomain = ";
  protected final String TEXT_168 = ".getEditingDomain(childNode.getDiagram().getElement());" + NL + "\t\tString modelID = ";
  protected final String TEXT_169 = ".getModelID(childNode);" + NL + "\t\tif (";
  protected final String TEXT_170 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\tfinal int newVisualID = ";
  protected final String TEXT_171 = ".INSTANCE.getNodeVisualID(";
  protected final String TEXT_172 = ", childNode.getElement());" + NL + "\t\t\t";
  protected final String TEXT_173 = " command = null;" + NL + "\t\t\tswitch (newVisualID) {";
  protected final String TEXT_174 = NL + "\t\t\tcase ";
  protected final String TEXT_175 = ".VISUAL_ID:" + NL + "\t\t\t\tcommand = new ";
  protected final String TEXT_176 = "() {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_177 = " afterCopyCommand;" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_178 = " createCommand() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_179 = " element = childNode.getElement();" + NL + "\t\t\t\t\t\t//We are being optimistic here about whether further commands can be executed." + NL + "\t\t\t\t\t\t//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.  " + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_180 = ".create(editingDomain, element);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (!super.prepare()) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_181 = NL;
  protected final String TEXT_182 = NL + "\t\tif (";
  protected final String TEXT_183 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_184 = NL + "\t\t}";
  protected final String TEXT_185 = NL + "\t\tif (";
  protected final String TEXT_186 = ".size() >= ";
  protected final String TEXT_187 = ".eINSTANCE.get";
  protected final String TEXT_188 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_189 = NL + "\t\t}";
  protected final String TEXT_190 = NL;
  protected final String TEXT_191 = NL + "\t\tif (";
  protected final String TEXT_192 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_193 = NL + "\t\t}";
  protected final String TEXT_194 = NL + "\t\tif (";
  protected final String TEXT_195 = ".size() >= ";
  protected final String TEXT_196 = ".eINSTANCE.get";
  protected final String TEXT_197 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_198 = NL + "\t\t}";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tsuper.execute();" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_200 = " results = super.getResult();" + NL + "\t\t\t\t\t\tassert results.size() == 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_201 = " result = (";
  protected final String TEXT_202 = ") results.iterator().next();" + NL + "\t\t\t\t\t\tafterCopyCommand = new ";
  protected final String TEXT_203 = "();";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_205 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_206 = ".getElement(), ";
  protected final String TEXT_207 = ".eINSTANCE.get";
  protected final String TEXT_208 = "(), result));";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\tafterCopyCommand.append(";
  protected final String TEXT_210 = ".create(" + NL + "\t\t\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_211 = ".getElement(), ";
  protected final String TEXT_212 = ".eINSTANCE.get";
  protected final String TEXT_213 = "(), result));";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\tafterCopyCommand.append(new ";
  protected final String TEXT_215 = "(";
  protected final String TEXT_216 = ", result, ";
  protected final String TEXT_217 = "null";
  protected final String TEXT_218 = "((";
  protected final String TEXT_219 = ") constraint).getCopy().union(new ";
  protected final String TEXT_220 = "(";
  protected final String TEXT_221 = ", ";
  protected final String TEXT_222 = "))";
  protected final String TEXT_223 = ", ";
  protected final String TEXT_224 = ".INSTANCE));" + NL + "\t\t\t\t\t\tif (afterCopyCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tafterCopyCommand.execute();" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tassert false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tafterCopyCommand.undo();" + NL + "\t\t\t\t\t\tsuper.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\tsuper.redo();" + NL + "\t\t\t\t\t\tafterCopyCommand.redo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_225 = NL + "\t\t\t}" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_226 = "(editingDomain, command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_227 = ".INSTANCE;" + NL + "}";
  protected final String TEXT_228 = NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {";
  protected final String TEXT_229 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_230 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_231 = " requestEx = (";
  protected final String TEXT_232 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_233 = " result = new ";
  protected final String TEXT_234 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_235 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_236 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_237 = "Command((View) getModel(), requestEx";
  protected final String TEXT_238 = ", " + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_239 = ")getConstraintFor(request)";
  protected final String TEXT_240 = "));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_242 = "(";
  protected final String TEXT_243 = ".getEditingDomain(((View) getModel()).getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_244 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getTitleName() {" + NL + "\t\treturn \"";
  protected final String TEXT_245 = "\";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_246 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_247 = " result = new ";
  protected final String TEXT_248 = "();" + NL + "\t\tresult.setLabel(getTitleName());" + NL + "\t\tresult.setOpaque(false);" + NL + "\t\tresult.setLayoutManager(new ";
  protected final String TEXT_249 = "());" + NL + "\t\t";
  protected final String TEXT_250 = " scrollPane = new ";
  protected final String TEXT_251 = "();" + NL + "\t\tresult.add(scrollPane);";
  protected final String TEXT_252 = NL + "\t\t";
  protected final String TEXT_253 = " viewport = new ";
  protected final String TEXT_254 = "();" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_255 = "();" + NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_256 = "());";
  protected final String TEXT_257 = NL + "\t\t";
  protected final String TEXT_258 = " viewport = new ";
  protected final String TEXT_259 = "();" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_260 = "();" + NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_261 = "());";
  protected final String TEXT_262 = NL + "\t\tviewport.setContents(contentPane);" + NL + "\t\tscrollPane.setViewport(viewport);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_263 = " resolveSemanticElement() {" + NL + "\t\tView view = getDiagramNode();" + NL + "\t\treturn (view.getElement() instanceof ";
  protected final String TEXT_264 = ") ? (";
  protected final String TEXT_265 = ") view.getElement() : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tuninstallNotationModelRefresher();" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_266 = NL;
  protected final String TEXT_267 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_268 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_269 = " domainModelEditDomain = ";
  protected final String TEXT_270 = ".getEditingDomain(";
  protected final String TEXT_271 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_272 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_273 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_274 = " {";
  protected final String TEXT_275 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_276 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_277 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_278 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_279 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_280 = " createFilter() {";
  protected final String TEXT_281 = NL + "\t\t\t";
  protected final String TEXT_282 = " filter = ";
  protected final String TEXT_283 = ".createFeatureFilter(";
  protected final String TEXT_284 = ".eINSTANCE.get";
  protected final String TEXT_285 = "());";
  protected final String TEXT_286 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_287 = ".createFeatureFilter(";
  protected final String TEXT_288 = ".eINSTANCE.get";
  protected final String TEXT_289 = "()));";
  protected final String TEXT_290 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_291 = ".createNotifierFilter(";
  protected final String TEXT_292 = ".getElement()));";
  protected final String TEXT_293 = NL + "\t\t\t";
  protected final String TEXT_294 = " filter = ";
  protected final String TEXT_295 = ".createNotifierFilter(";
  protected final String TEXT_296 = ".getElement());";
  protected final String TEXT_297 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_298 = NL + "\t\t\t";
  protected final String TEXT_299 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_300 = NL + "\t\t\t";
  protected final String TEXT_301 = " filter = ";
  protected final String TEXT_302 = ".NOT_TOUCH;";
  protected final String TEXT_303 = NL + "\t\t\treturn filter;";
  protected final String TEXT_304 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_305 = " getCreateNotationalElementCommand(";
  protected final String TEXT_306 = " descriptor) {";
  protected final String TEXT_307 = NL;
  protected final String TEXT_308 = "\t\t\t";
  protected final String TEXT_309 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_310 = NL + "\t\t\tcase ";
  protected final String TEXT_311 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_312 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_313 = "(";
  protected final String TEXT_314 = ", domainElement, ";
  protected final String TEXT_315 = "new ";
  protected final String TEXT_316 = "(0, 0, ";
  protected final String TEXT_317 = ", ";
  protected final String TEXT_318 = ")";
  protected final String TEXT_319 = NL + "null";
  protected final String TEXT_320 = ", ";
  protected final String TEXT_321 = ".INSTANCE);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_322 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_323 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_324 = " getSemanticChildNodes() {";
  protected final String TEXT_325 = NL;
  protected final String TEXT_326 = NL + "\treturn ";
  protected final String TEXT_327 = ".EMPTY_LIST;";
  protected final String TEXT_328 = NL + "\t";
  protected final String TEXT_329 = " result = new ";
  protected final String TEXT_330 = "();";
  protected final String TEXT_331 = NL + "\t";
  protected final String TEXT_332 = " viewObject = ";
  protected final String TEXT_333 = ";" + NL + "\t";
  protected final String TEXT_334 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_335 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_336 = NL + "\tfor(";
  protected final String TEXT_337 = " it = ";
  protected final String TEXT_338 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_339 = ") it.next();";
  protected final String TEXT_340 = NL + "\tnextValue = (";
  protected final String TEXT_341 = ")";
  protected final String TEXT_342 = ";";
  protected final String TEXT_343 = NL + "\tnodeVID = ";
  protected final String TEXT_344 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_345 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_346 = NL + "\tcase ";
  protected final String TEXT_347 = ".VISUAL_ID: {";
  protected final String TEXT_348 = NL + "\tif (";
  protected final String TEXT_349 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_350 = NL + "\t\tresult.add(new ";
  protected final String TEXT_351 = "(nextValue, nodeVID));";
  protected final String TEXT_352 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_353 = NL + "\t\t}";
  protected final String TEXT_354 = NL + "\t}";
  protected final String TEXT_355 = NL + "\t}";
  protected final String TEXT_356 = NL + "\treturn result;";
  protected final String TEXT_357 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_358 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_359 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_360 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_361 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_362 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_363 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_364 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_365 = " domainModelEditDomain = ";
  protected final String TEXT_366 = ".getEditingDomain(";
  protected final String TEXT_367 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_368 = "(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_369 = NL;
  protected final String TEXT_370 = NL;
  protected final String TEXT_371 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_372 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_373 = " feature, ";
  protected final String TEXT_374 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_375 = NL;
  protected final String TEXT_376 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_377 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_378 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_379 = NL;
  protected final String TEXT_380 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_381 = ".eINSTANCE.getView_Visible(), visibilityRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "//XXX:\t\trefreshBackgroundColor();" + NL + "//XXX:\t\trefreshForegroundColor();" + NL + "//XXX:\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = ((View)getModel()).isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL;
  protected final String TEXT_382 = NL;
  protected final String TEXT_383 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_384 = "static ";
  protected final String TEXT_385 = "class Create";
  protected final String TEXT_386 = "Command extends ";
  protected final String TEXT_387 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_388 = " notationAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_389 = "Command(";
  protected final String TEXT_390 = " parent, ";
  protected final String TEXT_391 = " request";
  protected final String TEXT_392 = ", ";
  protected final String TEXT_393 = " constraint";
  protected final String TEXT_394 = ") {" + NL + "\t\t\t";
  protected final String TEXT_395 = " domainModelEditDomain = ";
  protected final String TEXT_396 = ".getEditingDomain(parent.getDiagram().getElement());";
  protected final String TEXT_397 = NL + "\t\t\t";
  protected final String TEXT_398 = " createdDomainElement = ";
  protected final String TEXT_399 = ".eINSTANCE.create(" + NL + "\t\t\t\t";
  protected final String TEXT_400 = ".eINSTANCE.get";
  protected final String TEXT_401 = "());";
  protected final String TEXT_402 = NL + "\t\t\t";
  protected final String TEXT_403 = " createdDomainElement = ";
  protected final String TEXT_404 = ".eINSTANCE.create";
  protected final String TEXT_405 = "();";
  protected final String TEXT_406 = NL + "\t\t\t";
  protected final String TEXT_407 = NL + "\t\t\t";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = ".initializeElement(";
  protected final String TEXT_410 = "(";
  protected final String TEXT_411 = ") ";
  protected final String TEXT_412 = "createdDomainElement);";
  protected final String TEXT_413 = NL;
  protected final String TEXT_414 = NL + "\t\tif (";
  protected final String TEXT_415 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_416 = NL + "\t\t}";
  protected final String TEXT_417 = NL + "\t\tif (";
  protected final String TEXT_418 = ".size() >= ";
  protected final String TEXT_419 = ".eINSTANCE.get";
  protected final String TEXT_420 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_421 = NL + "\t\t}";
  protected final String TEXT_422 = NL;
  protected final String TEXT_423 = NL + "\t\tif (";
  protected final String TEXT_424 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_425 = NL + "\t\t}";
  protected final String TEXT_426 = NL + "\t\tif (";
  protected final String TEXT_427 = ".size() >= ";
  protected final String TEXT_428 = ".eINSTANCE.get";
  protected final String TEXT_429 = "().getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_430 = NL + "\t\t}";
  protected final String TEXT_431 = NL + "\t\t\t";
  protected final String TEXT_432 = " compoundCommand = new ";
  protected final String TEXT_433 = "();" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_434 = ".create(domainModelEditDomain, parent.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_435 = ".eINSTANCE.get";
  protected final String TEXT_436 = "(), createdDomainElement));" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_437 = ".create(domainModelEditDomain, parent.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_438 = ".eINSTANCE.get";
  protected final String TEXT_439 = "(), createdDomainElement));" + NL + "\t\t\tthis.domainModelAddCommand = compoundCommand;";
  protected final String TEXT_440 = NL + "\t\t\tthis.domainModelAddCommand = ";
  protected final String TEXT_441 = ".create(domainModelEditDomain, parent.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_442 = ".eINSTANCE.get";
  protected final String TEXT_443 = "(), createdDomainElement);";
  protected final String TEXT_444 = NL + "\t\t\tconstraint = constraint.union(new ";
  protected final String TEXT_445 = "(";
  protected final String TEXT_446 = ", ";
  protected final String TEXT_447 = "));";
  protected final String TEXT_448 = NL + "\t\t\tthis.notationAddCommand = new ";
  protected final String TEXT_449 = "(parent, ";
  protected final String TEXT_450 = "(";
  protected final String TEXT_451 = ") ";
  protected final String TEXT_452 = "createdDomainElement, " + NL + "\t\t\t\t";
  protected final String TEXT_453 = "constraint";
  protected final String TEXT_454 = "null";
  protected final String TEXT_455 = ", ";
  protected final String TEXT_456 = ".INSTANCE);" + NL + "\t\t\trequest.setCreatedObject(notationAddCommand.getCreatedView());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tnotationAddCommand.execute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tnotationAddCommand.undo();" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_457 = NL + "}" + NL;
  protected final String TEXT_458 = NL;

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_33);
    if (!genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ChangeBoundsCommand"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_50);
    } else {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_56);
    }
    
{
	String _getViewCode = "getDiagramNode()";
	boolean isListLayout = genCompartment.isListLayout();

    stringBuffer.append(TEXT_57);
    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_70);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_75);
    
		{
			Collection<GenNode> relatedNodes = myRelatedNodesFinder.getRelatedGenNodes(next.getDomainMetaClass());
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_76);
    
			}
			for(GenNode nextRelated : relatedNodes) {
				TypeModelFacet facet = nextRelated.getModelFacet();
				GenFeature childFeature = facet.getChildMetaFeature();
				GenFeature containmentFeature = facet.getContainmentMetaFeature();
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(nextRelated.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_78);
    
				}
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_82);
    
					} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_87);
    
					}
				}
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_91);
    
				} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_96);
    
				}
				if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_97);
    
				}
			}	//for(GenNode nextRelated : relatedNodes)
			if (relatedNodes.size() != 1) {

    stringBuffer.append(TEXT_98);
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

    stringBuffer.append(TEXT_99);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_100);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_102);
    
	} else {

    stringBuffer.append(TEXT_103);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_107);
    
	}
}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_112);
    
			}
			{
				GenFeature _feature = containmentFeature;
				String _ownerInstance = _getViewCode + ".getElement()";
				String _exceedsUpperBound = "return " + importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand") + ".INSTANCE;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_113);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_114);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_116);
    
	} else {

    stringBuffer.append(TEXT_117);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_121);
    
	}
}

    
			}

    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_126);
    
		}	//local declaration for related nodes.

    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.SetBoundsCommand"));
    stringBuffer.append(TEXT_132);
    if (isListLayout) {
    stringBuffer.append(TEXT_133);
    } else {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_139);
    if (isListLayout) {
    stringBuffer.append(TEXT_140);
    } else {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_147);
    
		}

    stringBuffer.append(TEXT_148);
    
	}	//for

    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_151);
    
}	//if (!childNodes.isEmpty()) in createAddCommand

    stringBuffer.append(TEXT_152);
    
/* delegation from getCloneCommand to createCloneCommand is 100% analogous to delegation from getAddCommand() to createAddCommand() in ConstrainedLayoutEditPolicy. */

    
if (!childNodes.isEmpty()) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.CompoundCommand"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_173);
    
	for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
		GenNode next = (GenNode) it.next();
		TypeModelFacet facet = next.getModelFacet();
		GenFeature childFeature = facet.getChildMetaFeature();
		GenFeature containmentFeature = facet.getContainmentMetaFeature();

    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CommandWrapper"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.CopyCommand"));
    stringBuffer.append(TEXT_180);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
			GenFeature _feature = childFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_181);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_182);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_184);
    
	} else {

    stringBuffer.append(TEXT_185);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_189);
    
	}
}

    
		}
		{
			GenFeature _feature = containmentFeature;
			String _ownerInstance = _getViewCode + ".getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_190);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_191);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_193);
    
	} else {

    stringBuffer.append(TEXT_194);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_198);
    
	}
}

    
		}

    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_203);
    
		if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_208);
    
		}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_213);
    
		{
			int defaultWidth = 40;
			int defaultHeight = 40;
			DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
			if (defSizeAttrs != null) {
				defaultWidth = defSizeAttrs.getWidth();
				defaultHeight = defSizeAttrs.getHeight();
			}

    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_216);
    if (isListLayout) {
    stringBuffer.append(TEXT_217);
    } else {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_224);
    
		}
	}	//for

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_227);
    
}	//if (!childNodes.isEmpty())

    
}

    stringBuffer.append(TEXT_228);
    if (null != genDiagram.getPalette()) {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_234);
    
for(Iterator it = genCompartment.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_237);
    if (!genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_239);
    }
    stringBuffer.append(TEXT_240);
    
}

    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_243);
    }/*when there's palette*/
    stringBuffer.append(TEXT_244);
    stringBuffer.append(genCompartment.getTitle());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LabeledContainer"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LabeledContainer"));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ScrollPane"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ScrollPane"));
    stringBuffer.append(TEXT_251);
    if (genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout"));
    stringBuffer.append(TEXT_256);
    } else {
    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformViewport"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_261);
    }
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_265);
    
{
String _getViewCode = "getDiagramNode()";
String _getDiagramCode = _getViewCode + ".getDiagram()";
boolean isListLayout = genCompartment.isListLayout();

    stringBuffer.append(TEXT_266);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_274);
    
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

    stringBuffer.append(TEXT_275);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_278);
    
}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_280);
    
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

    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_285);
    
		} else {

    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_289);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_292);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_296);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_297);
    
		} else {

    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_299);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_302);
    
	}

    stringBuffer.append(TEXT_303);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_306);
    
{
	String _parentNode = "getHost()";

    stringBuffer.append(TEXT_307);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_309);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_314);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_318);
    
	} else {

    stringBuffer.append(TEXT_319);
    
	}

    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_321);
    
}

    stringBuffer.append(TEXT_322);
    
}

    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(TEXT_325);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_327);
    
} else {

    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_330);
    
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

    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_335);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_337);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_339);
    
		} else {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_341);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_342);
    
	}

    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_344);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_345);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_347);
    
		} else {

    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_349);
    
		}

    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_351);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_352);
    
		} else {

    stringBuffer.append(TEXT_353);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_354);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_355);
    
	}
}

    stringBuffer.append(TEXT_356);
    
}

    stringBuffer.append(TEXT_357);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_368);
    
}

    stringBuffer.append(TEXT_369);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_381);
    
for(Iterator it = genCompartment.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();
	boolean isStatic = false;
	boolean isListLayout = genCompartment.isListLayout();

    stringBuffer.append(TEXT_382);
    
if (genDiagram.getPalette() != null) {

    stringBuffer.append(TEXT_383);
    if (isStatic) {
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_391);
    if (!isListLayout) {
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_393);
    }
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_396);
    
	if (next.getDomainMetaClass().isMapEntry()) {
	/*Workaround for Ecore example: map entries cannot be created using factory, only using reflective EFactory.create() method*/

    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_401);
    
	} else {

    stringBuffer.append(TEXT_402);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_405);
    
	}

    stringBuffer.append(TEXT_406);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(next.getUniqueIdentifier());
    stringBuffer.append(TEXT_409);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_411);
    }
    stringBuffer.append(TEXT_412);
    
	TypeModelFacet facet = next.getModelFacet();
	GenFeature childFeature = facet.getChildMetaFeature();
	GenFeature containmentFeature = facet.getContainmentMetaFeature();
	{
		GenFeature _feature = containmentFeature;
		String _ownerInstance = "parent.getElement()";
		String _exceedsUpperBound = "this.domainModelAddCommand = null;this.notationAddCommand = null;return;";
		GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_413);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_414);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_416);
    
	} else {

    stringBuffer.append(TEXT_417);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_421);
    
	}
}

    
	}
	if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
		GenFeature _feature = childFeature;
		String _ownerInstance = "parent.getElement()";
		String _exceedsUpperBound = "this.domainModelAddCommand = null;this.notationAddCommand = null;return;";
		GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_422);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_423);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_425);
    
	} else {

    stringBuffer.append(TEXT_426);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_429);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_430);
    
	}
}

    stringBuffer.append(TEXT_431);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_439);
    
	} else {

    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_443);
    
	}

    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_444);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_447);
    
	}

    stringBuffer.append(TEXT_448);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_449);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_450);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_451);
    }
    stringBuffer.append(TEXT_452);
    if(!isListLayout) {
    stringBuffer.append(TEXT_453);
    } else {
    stringBuffer.append(TEXT_454);
    }
    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_456);
    
}

    
}

    stringBuffer.append(TEXT_457);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_458);
    return stringBuffer.toString();
  }
}
