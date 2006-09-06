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
  protected final String TEXT_19 = NL + "/*" + NL + " * ";
  protected final String TEXT_20 = NL + " */";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_23 = " extends ";
  protected final String TEXT_24 = " implements ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = " {";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_31 = " contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_32 = " primaryShape;" + NL;
  protected final String TEXT_33 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_34 = " childNodesPane;";
  protected final String TEXT_35 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = " model) {" + NL + "\t\tassert model instanceof ";
  protected final String TEXT_38 = ";" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL;
  protected final String TEXT_39 = NL;
  protected final String TEXT_40 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_41 = " view = (";
  protected final String TEXT_42 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_43 = " view = (";
  protected final String TEXT_44 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = "\t\tinstallEditPolicy(";
  protected final String TEXT_47 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_48 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_49 = " createDeleteCommand(";
  protected final String TEXT_50 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_51 = " editingDomain = ";
  protected final String TEXT_52 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_53 = " cc = new ";
  protected final String TEXT_54 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_55 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_56 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_57 = " editingDomain) {";
  protected final String TEXT_58 = NL + "\t\t\t\t";
  protected final String TEXT_59 = " result = new ";
  protected final String TEXT_60 = "();";
  protected final String TEXT_61 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_62 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_63 = ".eINSTANCE.get";
  protected final String TEXT_64 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_65 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_66 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_67 = ".eINSTANCE.get";
  protected final String TEXT_68 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_69 = ".UNSET_VALUE));";
  protected final String TEXT_70 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_71 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_72 = ".eINSTANCE.get";
  protected final String TEXT_73 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_74 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_75 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_76 = ".eINSTANCE.get";
  protected final String TEXT_77 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_78 = ".UNSET_VALUE));";
  protected final String TEXT_79 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_80 = NL + "\t\t\t\treturn ";
  protected final String TEXT_81 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_82 = ".eINSTANCE.get";
  protected final String TEXT_83 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_84 = NL + "\t\t\t\treturn ";
  protected final String TEXT_85 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_86 = ".eINSTANCE.get";
  protected final String TEXT_87 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_88 = ".UNSET_VALUE);";
  protected final String TEXT_89 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_90 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_91 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_92 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_93 = " getCreateCommand(";
  protected final String TEXT_94 = " request) {";
  protected final String TEXT_95 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_96 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_97 = " requestEx = (";
  protected final String TEXT_98 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_99 = " result = new ";
  protected final String TEXT_100 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_102 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_103 = "Command((View) getModel(), requestEx";
  protected final String TEXT_104 = ", " + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_105 = ")getConstraintFor(request)";
  protected final String TEXT_106 = "));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_108 = "(";
  protected final String TEXT_109 = ".getEditingDomain(((View) getModel()).getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_110 = NL + "\t\t\t\treturn ";
  protected final String TEXT_111 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_112 = NL + "\t\t\tprotected ";
  protected final String TEXT_113 = " createChangeConstraintCommand(final ";
  protected final String TEXT_114 = " request, final ";
  protected final String TEXT_115 = " child, Object constraint) {" + NL + "\t\t\t\tif (!isDirectChild(child)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_116 = ".INSTANCE;" + NL + "\t\t\t\t}";
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = "\t\t\t\tfinal ";
  protected final String TEXT_119 = " node = (";
  protected final String TEXT_120 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_121 = " emfCommand = new ";
  protected final String TEXT_122 = "(\"Change node position/size\") {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_123 = " moveDelta;" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_124 = " resizeDelta;" + NL + "" + NL + "\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\treturn canExecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (node.getLayoutConstraint() instanceof ";
  protected final String TEXT_125 = " == false) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = " bounds = (";
  protected final String TEXT_127 = ") node.getLayoutConstraint();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_128 = " original = new ";
  protected final String TEXT_129 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_130 = " referenceFigure = ((";
  protected final String TEXT_131 = ")child).getFigure();" + NL + "\t\t\t\t\t\treferenceFigure.translateToAbsolute(original);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_132 = " transformed = request.getTransformedRectangle(original);" + NL + "\t\t\t\t\t\treferenceFigure.translateToRelative(transformed);" + NL + "\t\t\t\t\t\treferenceFigure.translateToRelative(original);" + NL + "\t\t\t\t\t\tresizeDelta = transformed.getSize().expand(original.getSize().negate());" + NL + "\t\t\t\t\t\tmoveDelta = transformed.getTopLeft().translate(original.getTopLeft().negate());" + NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\texecute(moveDelta.getNegated(), resizeDelta.getNegated());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\texecute(moveDelta, resizeDelta);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\texecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprivate void execute(";
  protected final String TEXT_133 = " move, ";
  protected final String TEXT_134 = " resize) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_135 = " bounds = (";
  protected final String TEXT_136 = ") node.getLayoutConstraint();" + NL + "\t\t\t\t\t\tbounds.setX(bounds.getX() + move.x);" + NL + "\t\t\t\t\t\tbounds.setY(bounds.getY() + move.y);" + NL + "\t\t\t\t\t\tbounds.setWidth(bounds.getWidth() + resize.width);" + NL + "\t\t\t\t\t\tbounds.setHeight(bounds.getHeight() + resize.height);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_137 = "(";
  protected final String TEXT_138 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_139 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_140 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_141 = NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_142 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_143 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_144 = " createChangeConstraintCommand(";
  protected final String TEXT_145 = " child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_146 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_147 = NL + "\t\t\tprotected ";
  protected final String TEXT_148 = " createChildEditPolicy(";
  protected final String TEXT_149 = " child) {";
  protected final String TEXT_150 = NL + "\t\t\t\tif (isDirectChild(child)) {" + NL + "\t\t\t\t\treturn super.createChildEditPolicy(child);" + NL + "\t\t\t\t}";
  protected final String TEXT_151 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_152 = "() {" + NL + "\t\t\t\t\tpublic ";
  protected final String TEXT_153 = " getTargetEditPart(";
  protected final String TEXT_154 = " request) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_155 = ".REQ_SELECTION.equals(request.getType())) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_156 = ".this;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_157 = ".GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_158 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_159 = " getReconnectTargetCommand(";
  protected final String TEXT_160 = " request) {";
  protected final String TEXT_161 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_162 = ".INSTANCE;";
  protected final String TEXT_163 = NL + "\t\t\t\t";
  protected final String TEXT_164 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_165 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_166 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_167 = " edge = (";
  protected final String TEXT_168 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_169 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_170 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_171 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_172 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_173 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_174 = NL + "\t\t\t\tcase ";
  protected final String TEXT_175 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_176 = "TargetCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_177 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_178 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_179 = "(";
  protected final String TEXT_180 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_181 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_182 = " getReconnectSourceCommand(";
  protected final String TEXT_183 = " request) {";
  protected final String TEXT_184 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_185 = ".INSTANCE;";
  protected final String TEXT_186 = NL + "\t\t\t\t";
  protected final String TEXT_187 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_188 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_189 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_190 = " edge = (";
  protected final String TEXT_191 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_192 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_193 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_194 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_195 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_196 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_197 = NL + "\t\t\t\tcase ";
  protected final String TEXT_198 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_199 = "SourceCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_200 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_201 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_202 = "(";
  protected final String TEXT_203 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_204 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_205 = " getConnectionCreateCommand(";
  protected final String TEXT_206 = " request) {";
  protected final String TEXT_207 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_208 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_209 = " requestEx = (";
  protected final String TEXT_210 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_211 = " result = new ";
  protected final String TEXT_212 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_214 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_215 = "StartCommand(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_217 = " wrappedResult = new ";
  protected final String TEXT_218 = "(";
  protected final String TEXT_219 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_220 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_221 = " getConnectionCompleteCommand(";
  protected final String TEXT_222 = " request) {";
  protected final String TEXT_223 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_224 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_225 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_226 = " requestEx = (";
  protected final String TEXT_227 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_228 = " result = new ";
  protected final String TEXT_229 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_231 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_232 = "Command(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_234 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_235 = "(";
  protected final String TEXT_236 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_237 = NL + "\t\t\t\treturn ";
  protected final String TEXT_238 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_239 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_240 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_241 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_242 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_243 = " invisibleRectangle = new ";
  protected final String TEXT_244 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_245 = "());" + NL + "\t\t";
  protected final String TEXT_246 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);";
  protected final String TEXT_247 = NL + "\t\tchildNodesPane = createChildNodesPane();" + NL + "\t\tshape.add(childNodesPane);";
  protected final String TEXT_248 = NL + NL + "\t\t";
  protected final String TEXT_249 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL;
  protected final String TEXT_250 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_251 = " createChildNodesPane() {" + NL + "\t\t";
  protected final String TEXT_252 = " result = new ";
  protected final String TEXT_253 = "();" + NL + "\t\tsetupContentPane(result);" + NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_254 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_255 = " createNodeShape() {";
  protected final String TEXT_256 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_257 = "()";
  protected final String TEXT_258 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_259 = ";";
  protected final String TEXT_260 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_261 = ";";
  protected final String TEXT_262 = NL + "\t\t";
  protected final String TEXT_263 = " figure = new ";
  protected final String TEXT_264 = "();";
  protected final String TEXT_265 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_266 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_267 = NL + "\t\treturn primaryShape;" + NL + "\t}";
  protected final String TEXT_268 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_269 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_270 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_271 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_272 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_273 = " view = (";
  protected final String TEXT_274 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_275 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_276 = " decorationPane = new ";
  protected final String TEXT_277 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_278 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_279 = " imageFigure = new ";
  protected final String TEXT_280 = "(";
  protected final String TEXT_281 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_282 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_283 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_284 = " setupContentPane(";
  protected final String TEXT_285 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_286 = NL + "\t\t\t";
  protected final String TEXT_287 = " layout = new ";
  protected final String TEXT_288 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_289 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_290 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_291 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_292 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_293 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_294 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_295 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_296 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_297 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_298 = " childEditPart) {";
  protected final String TEXT_299 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_300 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_301 = ") childEditPart).";
  protected final String TEXT_302 = "(getPrimaryShape().";
  protected final String TEXT_303 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_304 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_305 = ") {" + NL + "\t\t\t";
  protected final String TEXT_306 = " pane = getPrimaryShape().";
  protected final String TEXT_307 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_308 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_309 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_310 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_311 = ") {" + NL + "\t\t\t";
  protected final String TEXT_312 = " pane = getPrimaryShape().";
  protected final String TEXT_313 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_314 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_315 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_316 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_317 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_318 = NL + "\t\tfor(";
  protected final String TEXT_319 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_320 = " nextChild = (";
  protected final String TEXT_321 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_322 = ".getVisualID(nextChild) == ";
  protected final String TEXT_323 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_324 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_325 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_326 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_327 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_328 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_329 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_330 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_331 = " getLabelEditPart(";
  protected final String TEXT_332 = " req) {" + NL + "\t\t";
  protected final String TEXT_333 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_334 = " view = (";
  protected final String TEXT_335 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_336 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_337 = NL + "\t\t\t\tcase ";
  protected final String TEXT_338 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_339 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_340 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_341 = " childEditPart) {";
  protected final String TEXT_342 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_343 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_344 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_345 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_346 = " root = (";
  protected final String TEXT_347 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_348 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_349 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isDirectChild(";
  protected final String TEXT_350 = " childEditPart) {";
  protected final String TEXT_351 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_352 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_353 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_354 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_355 = " childEditPart, int index) {";
  protected final String TEXT_356 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_357 = " labelFigure = ((";
  protected final String TEXT_358 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_359 = NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_360 = NL + "\t\tif (isDirectChild(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_361 = " childFigure = ((";
  protected final String TEXT_362 = ") childEditPart).getFigure();" + NL + "\t\t\tchildNodesPane.add(childFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_363 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_364 = " childEditPart) {";
  protected final String TEXT_365 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_366 = " labelFigure = ((";
  protected final String TEXT_367 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_368 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_369 = NL + "\t\tif (isDirectChild(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_370 = " childFigure = ((";
  protected final String TEXT_371 = ") childEditPart).getFigure();" + NL + "\t\t\tchildNodesPane.remove(childFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_372 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_373 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_374 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_375 = " childEditPart = (";
  protected final String TEXT_376 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_377 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_378 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_379 = " node = getDiagramNode();" + NL + "\t\tif (node.getLayoutConstraint() == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_380 = ";" + NL + "\t\t";
  protected final String TEXT_381 = " bounds = (";
  protected final String TEXT_382 = ") node.getLayoutConstraint();" + NL + "\t\t((";
  protected final String TEXT_383 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_384 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_385 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_386 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_387 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_388 = " getSourceConnectionAnchor(";
  protected final String TEXT_389 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_390 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_391 = " getSourceConnectionAnchor(";
  protected final String TEXT_392 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_393 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_394 = "  getTargetConnectionAnchor(";
  protected final String TEXT_395 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_396 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_397 = "  getTargetConnectionAnchor(";
  protected final String TEXT_398 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_399 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_400 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);";
  protected final String TEXT_401 = NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_402 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_403 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_404 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_405 = NL + "\t\tuninstallNotationModelRefresher();";
  protected final String TEXT_406 = NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}";
  protected final String TEXT_407 = NL;
  protected final String TEXT_408 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_409 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_410 = " domainModelEditDomain = ";
  protected final String TEXT_411 = ".getEditingDomain(";
  protected final String TEXT_412 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_413 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_414 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_415 = " {";
  protected final String TEXT_416 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_417 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_418 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_419 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_420 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_421 = " createFilter() {";
  protected final String TEXT_422 = NL + "\t\t\t";
  protected final String TEXT_423 = " filter = ";
  protected final String TEXT_424 = ".createFeatureFilter(";
  protected final String TEXT_425 = ".eINSTANCE.get";
  protected final String TEXT_426 = "());";
  protected final String TEXT_427 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_428 = ".createFeatureFilter(";
  protected final String TEXT_429 = ".eINSTANCE.get";
  protected final String TEXT_430 = "()));";
  protected final String TEXT_431 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_432 = ".createNotifierFilter(";
  protected final String TEXT_433 = ".getElement()));";
  protected final String TEXT_434 = NL + "\t\t\t";
  protected final String TEXT_435 = " filter = ";
  protected final String TEXT_436 = ".createNotifierFilter(";
  protected final String TEXT_437 = ".getElement());";
  protected final String TEXT_438 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_439 = NL + "\t\t\t";
  protected final String TEXT_440 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_441 = NL + "\t\t\t";
  protected final String TEXT_442 = " filter = ";
  protected final String TEXT_443 = ".NOT_TOUCH;";
  protected final String TEXT_444 = NL + "\t\t\treturn filter;";
  protected final String TEXT_445 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_446 = " getCreateNotationalElementCommand(";
  protected final String TEXT_447 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_448 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_449 = NL + "\t\t\tcase ";
  protected final String TEXT_450 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_451 = ") {" + NL + "\t\t\t\t\treturn new Create";
  protected final String TEXT_452 = "NotationCommand(getHost(), domainElement";
  protected final String TEXT_453 = ", new Rectangle(0, 0, 0, 0)";
  protected final String TEXT_454 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_455 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_456 = " getSemanticChildNodes() {";
  protected final String TEXT_457 = NL;
  protected final String TEXT_458 = NL + "\treturn ";
  protected final String TEXT_459 = ".EMPTY_LIST;";
  protected final String TEXT_460 = NL + "\t";
  protected final String TEXT_461 = " result = new ";
  protected final String TEXT_462 = "();";
  protected final String TEXT_463 = NL + "\t";
  protected final String TEXT_464 = " viewObject = ";
  protected final String TEXT_465 = ";" + NL + "\t";
  protected final String TEXT_466 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_467 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_468 = NL + "\tfor(";
  protected final String TEXT_469 = " it = ";
  protected final String TEXT_470 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_471 = ") it.next();";
  protected final String TEXT_472 = NL + "\tnextValue = (";
  protected final String TEXT_473 = ")";
  protected final String TEXT_474 = ";";
  protected final String TEXT_475 = NL + "\tnodeVID = ";
  protected final String TEXT_476 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_477 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_478 = NL + "\tcase ";
  protected final String TEXT_479 = ".VISUAL_ID: {";
  protected final String TEXT_480 = NL + "\tif (";
  protected final String TEXT_481 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_482 = NL + "\t\tresult.add(new ";
  protected final String TEXT_483 = "(nextValue, nodeVID));";
  protected final String TEXT_484 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_485 = NL + "\t\t}";
  protected final String TEXT_486 = NL + "\t}";
  protected final String TEXT_487 = NL + "\t}";
  protected final String TEXT_488 = NL + "\treturn result;";
  protected final String TEXT_489 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_490 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_491 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_492 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_493 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_494 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_495 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_496 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_497 = " domainModelEditDomain = ";
  protected final String TEXT_498 = ".getEditingDomain(";
  protected final String TEXT_499 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_500 = "(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_501 = NL;
  protected final String TEXT_502 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_503 = " domainModelEditDomain = ";
  protected final String TEXT_504 = ".getEditingDomain(";
  protected final String TEXT_505 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * Service to find a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_506 = " viewService;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_507 = " getViewService() {" + NL + "\t\tif (viewService == null) {" + NL + "\t\t\tviewService = new ";
  protected final String TEXT_508 = "(getViewer());" + NL + "\t\t}" + NL + "\t\treturn viewService;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher(getViewService());" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_509 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher(";
  protected final String TEXT_510 = " viewService) {" + NL + "\t\t\tsuper(viewService);" + NL + "\t\t}";
  protected final String TEXT_511 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_512 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_513 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_514 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_515 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_516 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_517 = ".createEventTypeFilter(";
  protected final String TEXT_518 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_519 = ".createEventTypeFilter(";
  protected final String TEXT_520 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_521 = ".createEventTypeFilter(";
  protected final String TEXT_522 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_523 = ".createEventTypeFilter(";
  protected final String TEXT_524 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_525 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_526 = " createFilter() {";
  protected final String TEXT_527 = NL;
  protected final String TEXT_528 = NL + "\t\t\t";
  protected final String TEXT_529 = " filter = ";
  protected final String TEXT_530 = ".createFeatureFilter(";
  protected final String TEXT_531 = ".eINSTANCE.get";
  protected final String TEXT_532 = "());";
  protected final String TEXT_533 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_534 = ".createFeatureFilter(";
  protected final String TEXT_535 = ".eINSTANCE.get";
  protected final String TEXT_536 = "()));";
  protected final String TEXT_537 = NL;
  protected final String TEXT_538 = NL + "\t\t\t";
  protected final String TEXT_539 = " filter = ";
  protected final String TEXT_540 = ".createFeatureFilter(";
  protected final String TEXT_541 = ".eINSTANCE.get";
  protected final String TEXT_542 = "());";
  protected final String TEXT_543 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_544 = ".createFeatureFilter(";
  protected final String TEXT_545 = ".eINSTANCE.get";
  protected final String TEXT_546 = "()));";
  protected final String TEXT_547 = NL;
  protected final String TEXT_548 = NL + "\t\t\t";
  protected final String TEXT_549 = " filter = ";
  protected final String TEXT_550 = ".createFeatureFilter(";
  protected final String TEXT_551 = ".eINSTANCE.get";
  protected final String TEXT_552 = "());";
  protected final String TEXT_553 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_554 = ".createFeatureFilter(";
  protected final String TEXT_555 = ".eINSTANCE.get";
  protected final String TEXT_556 = "()));";
  protected final String TEXT_557 = NL;
  protected final String TEXT_558 = NL + "\t\t\t";
  protected final String TEXT_559 = " filter = ";
  protected final String TEXT_560 = ".createFeatureFilter(";
  protected final String TEXT_561 = ".eINSTANCE.get";
  protected final String TEXT_562 = "());";
  protected final String TEXT_563 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_564 = ".createFeatureFilter(";
  protected final String TEXT_565 = ".eINSTANCE.get";
  protected final String TEXT_566 = "()));";
  protected final String TEXT_567 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_568 = NL + "\t\t\t";
  protected final String TEXT_569 = " filter = getConstrainedChildLinksFilter();";
  protected final String TEXT_570 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_571 = NL + "\t\t\t";
  protected final String TEXT_572 = " filter = createUncontainedLinksFilter();";
  protected final String TEXT_573 = NL + "\t\t\t";
  protected final String TEXT_574 = " filter = ";
  protected final String TEXT_575 = ".NOT_TOUCH;";
  protected final String TEXT_576 = NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t\tprotected ";
  protected final String TEXT_577 = " getCreateNotationalElementCommand(";
  protected final String TEXT_578 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_579 = " linkDescriptor = (";
  protected final String TEXT_580 = ") descriptor;" + NL + "\t\t\t";
  protected final String TEXT_581 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_582 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_583 = " createdEdge = ";
  protected final String TEXT_584 = ".eINSTANCE.createEdge();" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_585 = NL + "\t\t\tcase ";
  protected final String TEXT_586 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_587 = ") {" + NL + "\t\t\t\t\tcreatedEdge.setElement(linkDescriptor.getElement());" + NL + "\t\t\t\t\t";
  protected final String TEXT_588 = ".decorateView(createdEdge);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_589 = NL + "\t\t\tcase ";
  protected final String TEXT_590 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tcreatedEdge.setElement(null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_591 = ".decorateView(createdEdge);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_592 = NL + "\t\t\t}" + NL + "\t\t\tif (createdEdge.getType() == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_593 = "(getHost().getDiagram(), createdEdge, sourceView, targetView);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_594 = " getSemanticChildLinks() {";
  protected final String TEXT_595 = NL;
  protected final String TEXT_596 = "\t";
  protected final String TEXT_597 = " result = new ";
  protected final String TEXT_598 = "();";
  protected final String TEXT_599 = NL + "\t";
  protected final String TEXT_600 = " modelObject = ";
  protected final String TEXT_601 = ".getElement();" + NL + "\t";
  protected final String TEXT_602 = " nextValue;";
  protected final String TEXT_603 = NL + "\tint linkVID;";
  protected final String TEXT_604 = NL + "\tfor(";
  protected final String TEXT_605 = " it = ";
  protected final String TEXT_606 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_607 = ") it.next();";
  protected final String TEXT_608 = NL + "\tnextValue = (";
  protected final String TEXT_609 = ")";
  protected final String TEXT_610 = ";";
  protected final String TEXT_611 = NL + "\tlinkVID = ";
  protected final String TEXT_612 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_613 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_614 = NL + "\tcase ";
  protected final String TEXT_615 = ".VISUAL_ID: {";
  protected final String TEXT_616 = NL + "\tif (";
  protected final String TEXT_617 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_618 = NL + "\t\t";
  protected final String TEXT_619 = " source = (";
  protected final String TEXT_620 = ")";
  protected final String TEXT_621 = ";";
  protected final String TEXT_622 = NL + "\t\t";
  protected final String TEXT_623 = " source = ";
  protected final String TEXT_624 = ".getElement();";
  protected final String TEXT_625 = NL + "\t\t";
  protected final String TEXT_626 = " target = (";
  protected final String TEXT_627 = ")";
  protected final String TEXT_628 = ";";
  protected final String TEXT_629 = NL + "\t\t";
  protected final String TEXT_630 = " target = ";
  protected final String TEXT_631 = ".getElement();";
  protected final String TEXT_632 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_633 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_634 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_635 = NL + "\t}";
  protected final String TEXT_636 = NL + "\t}";
  protected final String TEXT_637 = NL + "\t}";
  protected final String TEXT_638 = NL + "\tfor(";
  protected final String TEXT_639 = " it = ";
  protected final String TEXT_640 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_641 = ") it.next();";
  protected final String TEXT_642 = NL + "\tnextValue = (";
  protected final String TEXT_643 = ")";
  protected final String TEXT_644 = ";";
  protected final String TEXT_645 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_646 = NL + "\t\tresult.add(new ";
  protected final String TEXT_647 = "(modelObject, nextValue, null, ";
  protected final String TEXT_648 = ".VISUAL_ID));";
  protected final String TEXT_649 = NL + "\t}";
  protected final String TEXT_650 = NL + "\t}";
  protected final String TEXT_651 = NL + "\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_652 = " getNotationalChildLinks() {" + NL + "\t\t\t";
  protected final String TEXT_653 = " result = new ";
  protected final String TEXT_654 = "();" + NL + "\t\t\t";
  protected final String TEXT_655 = " allLinks = ";
  protected final String TEXT_656 = ".getEdges();" + NL + "\t\t\tfor(";
  protected final String TEXT_657 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_658 = " next = (";
  protected final String TEXT_659 = ") it.next();";
  protected final String TEXT_660 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_661 = " source = next.getSource();" + NL + "\t\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_662 = " target = next.getTarget();" + NL + "\t\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}";
  protected final String TEXT_663 = NL + "\t\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_664 = ") {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_665 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_666 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_667 = ".VISUAL_ID:";
  protected final String TEXT_668 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_669 = NL + "\t\t\t\t} else {";
  protected final String TEXT_670 = NL + "\t\t\t\t}";
  protected final String TEXT_671 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_672 = NL + "\t\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_673 = ".getElement()) {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_674 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_675 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_676 = ".VISUAL_ID:";
  protected final String TEXT_677 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_678 = NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_679 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_680 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_681 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_682 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_683 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_684 = " linkRefresher = getLinkNotationModelRefresher();" + NL + "\t\tif (!linkRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_685 = " command = linkRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_686 = " domainModelEditDomain = ";
  protected final String TEXT_687 = ".getEditingDomain(";
  protected final String TEXT_688 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_689 = "(domainModelEditDomain, command));" + NL + "\t}";
  protected final String TEXT_690 = NL;
  protected final String TEXT_691 = NL;
  protected final String TEXT_692 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_693 = " domainModelRefresher = new ";
  protected final String TEXT_694 = "(this);" + NL;
  protected final String TEXT_695 = NL;
  protected final String TEXT_696 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_697 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_698 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_699 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_700 = NL;
  protected final String TEXT_701 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_702 = NL + "\t\t";
  protected final String TEXT_703 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_704 = ") ";
  protected final String TEXT_705 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_706 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_707 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_708 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_709 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_710 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_711 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_712 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_713 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_714 = "\t" + NL + "\t}";
  protected final String TEXT_715 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_716 = " createdFont;";
  protected final String TEXT_717 = "\t" + NL;
  protected final String TEXT_718 = NL;
  protected final String TEXT_719 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_720 = " style = (";
  protected final String TEXT_721 = ")  ";
  protected final String TEXT_722 = ".getStyle(";
  protected final String TEXT_723 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_724 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_725 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_726 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_727 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_728 = " style = (";
  protected final String TEXT_729 = ")  ";
  protected final String TEXT_730 = ".getStyle(";
  protected final String TEXT_731 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_732 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_733 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_734 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_735 = " createdBackgroundColor;" + NL;
  protected final String TEXT_736 = NL;
  protected final String TEXT_737 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_738 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_739 = " feature, ";
  protected final String TEXT_740 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_741 = "();";
  protected final String TEXT_742 = NL;
  protected final String TEXT_743 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_744 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_745 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_746 = NL;
  protected final String TEXT_747 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_748 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_749 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_750 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_751 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_752 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_753 = NL;
  protected final String TEXT_754 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_755 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_756 = NL;
  protected final String TEXT_757 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_758 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_759 = NL;
  protected final String TEXT_760 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_761 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_762 = NL;
  protected final String TEXT_763 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_764 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_765 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_766 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_767 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_768 = NL;
  protected final String TEXT_769 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_770 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_771 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_772 = NL;
  protected final String TEXT_773 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_774 = "static ";
  protected final String TEXT_775 = "class Create";
  protected final String TEXT_776 = "NotationCommand extends ";
  protected final String TEXT_777 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Create";
  protected final String TEXT_778 = "NotationCommand(";
  protected final String TEXT_779 = " parent, " + NL + "\t\t\t\t";
  protected final String TEXT_780 = " domainElement";
  protected final String TEXT_781 = ", ";
  protected final String TEXT_782 = " constraint";
  protected final String TEXT_783 = ") {" + NL + "\t\t\tsuper(parent);" + NL + "\t\t\tNode createdNode = ";
  protected final String TEXT_784 = ".eINSTANCE.createNode();" + NL + "\t\t\tsetCreatedView(createdNode);" + NL + "\t\t\tcreatedNode.setElement(domainElement);" + NL + "\t\t\t";
  protected final String TEXT_785 = ".decorateView(createdNode);";
  protected final String TEXT_786 = NL + "\t\t\t";
  protected final String TEXT_787 = " bounds = ";
  protected final String TEXT_788 = ".eINSTANCE.createBounds();" + NL + "\t\t\tcreatedNode.setLayoutConstraint(bounds);" + NL + "\t\t\tbounds.setX(constraint.x);" + NL + "\t\t\tbounds.setY(constraint.y);";
  protected final String TEXT_789 = NL + "\t\t\tbounds.setWidth(Math.max(constraint.width, ";
  protected final String TEXT_790 = "));" + NL + "\t\t\tbounds.setHeight(Math.max(constraint.height, ";
  protected final String TEXT_791 = "));";
  protected final String TEXT_792 = NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_793 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_794 = "static ";
  protected final String TEXT_795 = "class Create";
  protected final String TEXT_796 = "Command extends ";
  protected final String TEXT_797 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final Create";
  protected final String TEXT_798 = "NotationCommand notationAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_799 = "Command(";
  protected final String TEXT_800 = " parent, ";
  protected final String TEXT_801 = " request";
  protected final String TEXT_802 = ", ";
  protected final String TEXT_803 = " constraint";
  protected final String TEXT_804 = ") {" + NL + "\t\t\t";
  protected final String TEXT_805 = " domainModelEditDomain = ";
  protected final String TEXT_806 = ".getEditingDomain(parent.getDiagram().getElement());";
  protected final String TEXT_807 = NL + "\t\t\t";
  protected final String TEXT_808 = " createdDomainElement = ";
  protected final String TEXT_809 = ".eINSTANCE.create(" + NL + "\t\t\t\t";
  protected final String TEXT_810 = ".eINSTANCE.get";
  protected final String TEXT_811 = "());";
  protected final String TEXT_812 = NL + "\t\t\t";
  protected final String TEXT_813 = " createdDomainElement = ";
  protected final String TEXT_814 = ".eINSTANCE.create";
  protected final String TEXT_815 = "();";
  protected final String TEXT_816 = NL + "\t\t\t";
  protected final String TEXT_817 = NL + "\t\t\t";
  protected final String TEXT_818 = ".";
  protected final String TEXT_819 = ".initializeElement(";
  protected final String TEXT_820 = "(";
  protected final String TEXT_821 = ") ";
  protected final String TEXT_822 = "createdDomainElement);";
  protected final String TEXT_823 = NL + "\t\t\t";
  protected final String TEXT_824 = " compoundCommand = new ";
  protected final String TEXT_825 = "();" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_826 = ".create(domainModelEditDomain, ";
  protected final String TEXT_827 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_828 = ".eINSTANCE.get";
  protected final String TEXT_829 = "(), createdDomainElement));" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_830 = ".create(domainModelEditDomain, ";
  protected final String TEXT_831 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_832 = ".eINSTANCE.get";
  protected final String TEXT_833 = "(), createdDomainElement));" + NL + "\t\t\tthis.domainModelAddCommand = compoundCommand;";
  protected final String TEXT_834 = NL + "\t\t\tthis.domainModelAddCommand = ";
  protected final String TEXT_835 = ".create(domainModelEditDomain, ";
  protected final String TEXT_836 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_837 = ".eINSTANCE.get";
  protected final String TEXT_838 = "(), createdDomainElement);";
  protected final String TEXT_839 = NL + "\t\t\tthis.notationAddCommand = new Create";
  protected final String TEXT_840 = "NotationCommand(parent, ";
  protected final String TEXT_841 = "(";
  protected final String TEXT_842 = ") ";
  protected final String TEXT_843 = "createdDomainElement";
  protected final String TEXT_844 = ", constraint";
  protected final String TEXT_845 = ");" + NL + "\t\t\trequest.setCreatedObject(notationAddCommand.getCreatedView());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tnotationAddCommand.execute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tnotationAddCommand.undo();" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_846 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_847 = "SourceCommand extends ";
  protected final String TEXT_848 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_849 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_850 = " newSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_851 = " oldSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_852 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_853 = "SourceCommand(";
  protected final String TEXT_854 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_855 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_856 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_857 = "SourceCommand(";
  protected final String TEXT_858 = " edge, ";
  protected final String TEXT_859 = " newSource) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newSource = newSource;" + NL + "\t\t\tthis.oldSource = edge.getSource();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_860 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_861 = " domainModelEditDomain = ";
  protected final String TEXT_862 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_863 = " command = new ";
  protected final String TEXT_864 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_865 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew ";
  protected final String TEXT_866 = "(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_867 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_868 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_869 = NL + "\t\t\treturn false;";
  protected final String TEXT_870 = NL + "\t\t\t";
  protected final String TEXT_871 = " container = (";
  protected final String TEXT_872 = ")getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_873 = ".eINSTANCE.get";
  protected final String TEXT_874 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_875 = NL;
  protected final String TEXT_876 = NL + "\t\tif (";
  protected final String TEXT_877 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_878 = NL + "\t\t}";
  protected final String TEXT_879 = NL + "\t\tif (";
  protected final String TEXT_880 = ".size() >= ";
  protected final String TEXT_881 = ".eINSTANCE.get";
  protected final String TEXT_882 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_883 = NL + "\t\t}";
  protected final String TEXT_884 = NL;
  protected final String TEXT_885 = NL + "\t\tif (";
  protected final String TEXT_886 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_887 = NL + "\t\t}";
  protected final String TEXT_888 = NL + "\t\tif (";
  protected final String TEXT_889 = ".size() >= ";
  protected final String TEXT_890 = ".eINSTANCE.get";
  protected final String TEXT_891 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_892 = NL + "\t\t}";
  protected final String TEXT_893 = NL;
  protected final String TEXT_894 = NL + "\t\t\tif(!";
  protected final String TEXT_895 = ".canCreateLink(";
  protected final String TEXT_896 = ", ";
  protected final String TEXT_897 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_898 = NL + "\t\t\treturn true;";
  protected final String TEXT_899 = NL;
  protected final String TEXT_900 = NL + "\t\tif (";
  protected final String TEXT_901 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_902 = NL + "\t\t}";
  protected final String TEXT_903 = NL + "\t\tif (";
  protected final String TEXT_904 = ".size() >= ";
  protected final String TEXT_905 = ".eINSTANCE.get";
  protected final String TEXT_906 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_907 = NL + "\t\t}";
  protected final String TEXT_908 = NL;
  protected final String TEXT_909 = NL + "\t\t\tif(!";
  protected final String TEXT_910 = ".canCreateLink(";
  protected final String TEXT_911 = ", ";
  protected final String TEXT_912 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_913 = NL + "\t\t\treturn true;";
  protected final String TEXT_914 = NL + "\t\t\treturn false;";
  protected final String TEXT_915 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_916 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_917 = " editingDomain = ";
  protected final String TEXT_918 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_919 = " result = new ";
  protected final String TEXT_920 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_921 = "(edge, newSource));";
  protected final String TEXT_922 = NL + "\t\t\t";
  protected final String TEXT_923 = " container = getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_924 = ".eINSTANCE.get";
  protected final String TEXT_925 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_926 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_927 = " oldContainer = edge.getElement().eContainer();" + NL + "\t\t\tif (oldContainer == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_928 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tif (oldContainer != container) {";
  protected final String TEXT_929 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_930 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), edge.getElement()));";
  protected final String TEXT_931 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_932 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), ";
  protected final String TEXT_933 = ".UNSET_VALUE));";
  protected final String TEXT_934 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_935 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_936 = ".eINSTANCE.get";
  protected final String TEXT_937 = "(), edge.getElement()));";
  protected final String TEXT_938 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_939 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_940 = ".eINSTANCE.get";
  protected final String TEXT_941 = "()," + NL + "\t\t\t\t\tedge.getElement()));";
  protected final String TEXT_942 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_943 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_944 = ".eINSTANCE.get";
  protected final String TEXT_945 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_946 = ".UNSET_VALUE));";
  protected final String TEXT_947 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_948 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_949 = ".eINSTANCE.get";
  protected final String TEXT_950 = "(), edge.getElement()));";
  protected final String TEXT_951 = NL + "\t\t\t}";
  protected final String TEXT_952 = NL + "\t\t\tresult.append(";
  protected final String TEXT_953 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_954 = ".eINSTANCE.get";
  protected final String TEXT_955 = "()," + NL + "\t\t\t\toldSource.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_956 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_957 = ".eINSTANCE.get";
  protected final String TEXT_958 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_959 = NL + "\t\t\tresult.append(";
  protected final String TEXT_960 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_961 = ".eINSTANCE.get";
  protected final String TEXT_962 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_963 = NL + "\t\t\tresult.append(";
  protected final String TEXT_964 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_965 = ".eINSTANCE.get";
  protected final String TEXT_966 = "(), edge.getTarget().getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_967 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_968 = ".eINSTANCE.get";
  protected final String TEXT_969 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_970 = NL + "\t\t\tresult.append(";
  protected final String TEXT_971 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_972 = ".eINSTANCE.get";
  protected final String TEXT_973 = "(), ";
  protected final String TEXT_974 = ".UNSET_VALUE));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_975 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_976 = ".eINSTANCE.get";
  protected final String TEXT_977 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_978 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL;
  protected final String TEXT_979 = NL;
  protected final String TEXT_980 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_981 = " getRelationshipContainer(";
  protected final String TEXT_982 = " element, ";
  protected final String TEXT_983 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_984 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_985 = NL;
  protected final String TEXT_986 = NL + "\t\t\tprivate ";
  protected final String TEXT_987 = " createDomainModelRemoveCommand(";
  protected final String TEXT_988 = " editingDomain) {";
  protected final String TEXT_989 = NL + "\t\t\t\t";
  protected final String TEXT_990 = " result = new ";
  protected final String TEXT_991 = "();";
  protected final String TEXT_992 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_993 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_994 = ".getElement().eContainer(), ";
  protected final String TEXT_995 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_996 = ".getElement()));";
  protected final String TEXT_997 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_998 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_999 = ".getElement().eContainer(), ";
  protected final String TEXT_1000 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_1001 = ".UNSET_VALUE));";
  protected final String TEXT_1002 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1003 = ".INSTANCE;";
  protected final String TEXT_1004 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1005 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1006 = ".getElement().eContainer(), ";
  protected final String TEXT_1007 = ".eINSTANCE.get";
  protected final String TEXT_1008 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1009 = ".getElement()));";
  protected final String TEXT_1010 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1011 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1012 = ".getElement().eContainer(), ";
  protected final String TEXT_1013 = ".eINSTANCE.get";
  protected final String TEXT_1014 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1015 = ".UNSET_VALUE));";
  protected final String TEXT_1016 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1017 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1018 = ".getElement(), ";
  protected final String TEXT_1019 = ".eINSTANCE.get";
  protected final String TEXT_1020 = "(), ";
  protected final String TEXT_1021 = ".getSource().getElement()));";
  protected final String TEXT_1022 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1023 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1024 = ".getElement(), ";
  protected final String TEXT_1025 = ".eINSTANCE.get";
  protected final String TEXT_1026 = "(), ";
  protected final String TEXT_1027 = ".UNSET_VALUE));";
  protected final String TEXT_1028 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1029 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1030 = ".getElement(), ";
  protected final String TEXT_1031 = ".eINSTANCE.get";
  protected final String TEXT_1032 = "(), ";
  protected final String TEXT_1033 = ".getTarget().getElement()));";
  protected final String TEXT_1034 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1035 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1036 = ".getElement(), ";
  protected final String TEXT_1037 = ".eINSTANCE.get";
  protected final String TEXT_1038 = "(), ";
  protected final String TEXT_1039 = ".UNSET_VALUE));";
  protected final String TEXT_1040 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1041 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1042 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1043 = ".getSource().getElement(), ";
  protected final String TEXT_1044 = ".eINSTANCE.get";
  protected final String TEXT_1045 = "(), ";
  protected final String TEXT_1046 = ".getTarget().getElement());";
  protected final String TEXT_1047 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1048 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1049 = ".getSource().getElement(), ";
  protected final String TEXT_1050 = ".eINSTANCE.get";
  protected final String TEXT_1051 = "(), ";
  protected final String TEXT_1052 = ".UNSET_VALUE);";
  protected final String TEXT_1053 = NL + "\t\t\t}";
  protected final String TEXT_1054 = NL + "\t}" + NL;
  protected final String TEXT_1055 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_1056 = "StartCommand extends ";
  protected final String TEXT_1057 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1058 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_1059 = "StartCommand(";
  protected final String TEXT_1060 = " requestEx) {" + NL + "\t\t\t//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart()." + NL + "\t\t\tsource = (";
  protected final String TEXT_1061 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\tif (source == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1062 = NL + "\t\t\treturn false;";
  protected final String TEXT_1063 = NL + "\t\t\t";
  protected final String TEXT_1064 = " container = (";
  protected final String TEXT_1065 = ")getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_1066 = ".eINSTANCE.get";
  protected final String TEXT_1067 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1068 = NL;
  protected final String TEXT_1069 = NL + "\t\tif (";
  protected final String TEXT_1070 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1071 = NL + "\t\t}";
  protected final String TEXT_1072 = NL + "\t\tif (";
  protected final String TEXT_1073 = ".size() >= ";
  protected final String TEXT_1074 = ".eINSTANCE.get";
  protected final String TEXT_1075 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1076 = NL + "\t\t}";
  protected final String TEXT_1077 = NL;
  protected final String TEXT_1078 = NL + "\t\tif (";
  protected final String TEXT_1079 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1080 = NL + "\t\t}";
  protected final String TEXT_1081 = NL + "\t\tif (";
  protected final String TEXT_1082 = ".size() >= ";
  protected final String TEXT_1083 = ".eINSTANCE.get";
  protected final String TEXT_1084 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1085 = NL + "\t\t}";
  protected final String TEXT_1086 = NL;
  protected final String TEXT_1087 = NL + "\t\t\tif(!";
  protected final String TEXT_1088 = ".canCreateLink(";
  protected final String TEXT_1089 = ", ";
  protected final String TEXT_1090 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1091 = NL + "\t\t\treturn true;";
  protected final String TEXT_1092 = NL;
  protected final String TEXT_1093 = NL + "\t\tif (";
  protected final String TEXT_1094 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1095 = NL + "\t\t}";
  protected final String TEXT_1096 = NL + "\t\tif (";
  protected final String TEXT_1097 = ".size() >= ";
  protected final String TEXT_1098 = ".eINSTANCE.get";
  protected final String TEXT_1099 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1100 = NL + "\t\t}";
  protected final String TEXT_1101 = NL;
  protected final String TEXT_1102 = NL + "\t\t\tif(!";
  protected final String TEXT_1103 = ".canCreateLink(";
  protected final String TEXT_1104 = ", ";
  protected final String TEXT_1105 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1106 = NL + "\t\t\treturn true;";
  protected final String TEXT_1107 = NL + "\t\t\treturn false;";
  protected final String TEXT_1108 = NL + "\t\t}";
  protected final String TEXT_1109 = NL;
  protected final String TEXT_1110 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1111 = " getRelationshipContainer(";
  protected final String TEXT_1112 = " element, ";
  protected final String TEXT_1113 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1114 = NL + NL + "\t}";
  protected final String TEXT_1115 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_1116 = "TargetCommand extends ";
  protected final String TEXT_1117 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1118 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1119 = " newTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1120 = " oldTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1121 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_1122 = "TargetCommand(";
  protected final String TEXT_1123 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_1124 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_1125 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_1126 = "TargetCommand(";
  protected final String TEXT_1127 = " edge, ";
  protected final String TEXT_1128 = " newTarget) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newTarget = newTarget;" + NL + "\t\t\tthis.oldTarget = edge.getTarget();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_1129 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_1130 = " domainModelEditDomain = ";
  protected final String TEXT_1131 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_1132 = " command = new ";
  protected final String TEXT_1133 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_1134 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew ";
  protected final String TEXT_1135 = "(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_1136 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_1137 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_1138 = NL;
  protected final String TEXT_1139 = NL + "\t\t\tif(!";
  protected final String TEXT_1140 = ".canCreateLink(";
  protected final String TEXT_1141 = ", ";
  protected final String TEXT_1142 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1143 = NL + "\t\t\treturn true;";
  protected final String TEXT_1144 = NL;
  protected final String TEXT_1145 = NL + "\t\t\tif(!";
  protected final String TEXT_1146 = ".canCreateLink(";
  protected final String TEXT_1147 = ", ";
  protected final String TEXT_1148 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1149 = NL + "\t\t\treturn true;";
  protected final String TEXT_1150 = NL + "\t\t\treturn false;";
  protected final String TEXT_1151 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_1152 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_1153 = " editingDomain = ";
  protected final String TEXT_1154 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_1155 = " result = new ";
  protected final String TEXT_1156 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_1157 = "(edge, newTarget));";
  protected final String TEXT_1158 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1159 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1160 = ".eINSTANCE.get";
  protected final String TEXT_1161 = "()," + NL + "\t\t\t\toldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1162 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1163 = ".eINSTANCE.get";
  protected final String TEXT_1164 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_1165 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1166 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_1167 = ".eINSTANCE.get";
  protected final String TEXT_1168 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_1169 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1170 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_1171 = ".eINSTANCE.get";
  protected final String TEXT_1172 = "(), oldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_1173 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_1174 = ".eINSTANCE.get";
  protected final String TEXT_1175 = "(), newTarget.getElement()));";
  protected final String TEXT_1176 = NL + "\t\t\tresult.append(";
  protected final String TEXT_1177 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_1178 = ".eINSTANCE.get";
  protected final String TEXT_1179 = "(), newTarget.getElement()));";
  protected final String TEXT_1180 = NL + "\t\t\treturn result;" + NL + "\t\t}";
  protected final String TEXT_1181 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_1182 = NL;
  protected final String TEXT_1183 = NL + "\t\t\tprivate ";
  protected final String TEXT_1184 = " createDomainModelRemoveCommand(";
  protected final String TEXT_1185 = " editingDomain) {";
  protected final String TEXT_1186 = NL + "\t\t\t\t";
  protected final String TEXT_1187 = " result = new ";
  protected final String TEXT_1188 = "();";
  protected final String TEXT_1189 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1190 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1191 = ".getElement().eContainer(), ";
  protected final String TEXT_1192 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_1193 = ".getElement()));";
  protected final String TEXT_1194 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1195 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1196 = ".getElement().eContainer(), ";
  protected final String TEXT_1197 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_1198 = ".UNSET_VALUE));";
  protected final String TEXT_1199 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1200 = ".INSTANCE;";
  protected final String TEXT_1201 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1202 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1203 = ".getElement().eContainer(), ";
  protected final String TEXT_1204 = ".eINSTANCE.get";
  protected final String TEXT_1205 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1206 = ".getElement()));";
  protected final String TEXT_1207 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1208 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1209 = ".getElement().eContainer(), ";
  protected final String TEXT_1210 = ".eINSTANCE.get";
  protected final String TEXT_1211 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1212 = ".UNSET_VALUE));";
  protected final String TEXT_1213 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1214 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1215 = ".getElement(), ";
  protected final String TEXT_1216 = ".eINSTANCE.get";
  protected final String TEXT_1217 = "(), ";
  protected final String TEXT_1218 = ".getSource().getElement()));";
  protected final String TEXT_1219 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1220 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1221 = ".getElement(), ";
  protected final String TEXT_1222 = ".eINSTANCE.get";
  protected final String TEXT_1223 = "(), ";
  protected final String TEXT_1224 = ".UNSET_VALUE));";
  protected final String TEXT_1225 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1226 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1227 = ".getElement(), ";
  protected final String TEXT_1228 = ".eINSTANCE.get";
  protected final String TEXT_1229 = "(), ";
  protected final String TEXT_1230 = ".getTarget().getElement()));";
  protected final String TEXT_1231 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1232 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1233 = ".getElement(), ";
  protected final String TEXT_1234 = ".eINSTANCE.get";
  protected final String TEXT_1235 = "(), ";
  protected final String TEXT_1236 = ".UNSET_VALUE));";
  protected final String TEXT_1237 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1238 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1239 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1240 = ".getSource().getElement(), ";
  protected final String TEXT_1241 = ".eINSTANCE.get";
  protected final String TEXT_1242 = "(), ";
  protected final String TEXT_1243 = ".getTarget().getElement());";
  protected final String TEXT_1244 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1245 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1246 = ".getSource().getElement(), ";
  protected final String TEXT_1247 = ".eINSTANCE.get";
  protected final String TEXT_1248 = "(), ";
  protected final String TEXT_1249 = ".UNSET_VALUE);";
  protected final String TEXT_1250 = NL + "\t\t\t}";
  protected final String TEXT_1251 = NL + "\t}" + NL;
  protected final String TEXT_1252 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_1253 = "Command extends ";
  protected final String TEXT_1254 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1255 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1256 = " target;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1257 = " createdEdge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_1258 = "Command(";
  protected final String TEXT_1259 = " requestEx) {" + NL + "\t\t\tif (requestEx.getSourceEditPart().getModel() instanceof ";
  protected final String TEXT_1260 = ") {" + NL + "\t\t\t\tsource = (";
  protected final String TEXT_1261 = ")requestEx.getSourceEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tsource = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (requestEx.getTargetEditPart().getModel() instanceof ";
  protected final String TEXT_1262 = ") {" + NL + "\t\t\t\ttarget = (";
  protected final String TEXT_1263 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (source == null || target == null) {" + NL + "\t\t\t\tcreatedEdge = null;" + NL + "\t\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1264 = ".INSTANCE;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedEdge = ";
  protected final String TEXT_1265 = ".eINSTANCE.createEdge();";
  protected final String TEXT_1266 = NL + "\t\t\t";
  protected final String TEXT_1267 = " createdDomainElement = ";
  protected final String TEXT_1268 = ".eINSTANCE.create";
  protected final String TEXT_1269 = "();" + NL + "\t\t\tcreatedEdge.setElement(";
  protected final String TEXT_1270 = "(";
  protected final String TEXT_1271 = ") ";
  protected final String TEXT_1272 = "createdDomainElement);" + NL + "\t\t\t";
  protected final String TEXT_1273 = NL + "\t\t\t";
  protected final String TEXT_1274 = ".";
  protected final String TEXT_1275 = ".initializeElement(";
  protected final String TEXT_1276 = "(";
  protected final String TEXT_1277 = ") ";
  protected final String TEXT_1278 = "createdDomainElement);";
  protected final String TEXT_1279 = NL + "\t\t\tcreatedEdge.setElement(null);";
  protected final String TEXT_1280 = NL + "\t\t\t";
  protected final String TEXT_1281 = ".decorateView(createdEdge);" + NL + "\t\t\t";
  protected final String TEXT_1282 = " domainModelEditDomain = ";
  protected final String TEXT_1283 = ".getEditingDomain(source.getDiagram().getElement());";
  protected final String TEXT_1284 = NL + "\t\t\torg.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();";
  protected final String TEXT_1285 = NL + "\t\t\t";
  protected final String TEXT_1286 = " container = getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_1287 = ".eINSTANCE.get";
  protected final String TEXT_1288 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\tdomainModelAddCommand = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1289 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1290 = ".eINSTANCE.get";
  protected final String TEXT_1291 = "(), createdDomainElement));";
  protected final String TEXT_1292 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1293 = ".create(domainModelEditDomain," + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1294 = ".eINSTANCE.get";
  protected final String TEXT_1295 = "(), createdDomainElement));";
  protected final String TEXT_1296 = NL;
  protected final String TEXT_1297 = NL + "\t\tif (";
  protected final String TEXT_1298 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1299 = NL + "\t\t}";
  protected final String TEXT_1300 = NL + "\t\tif (";
  protected final String TEXT_1301 = ".size() >= ";
  protected final String TEXT_1302 = ".eINSTANCE.get";
  protected final String TEXT_1303 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1304 = NL + "\t\t}";
  protected final String TEXT_1305 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1306 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1307 = ".eINSTANCE.get";
  protected final String TEXT_1308 = "(), source.getElement()));";
  protected final String TEXT_1309 = NL;
  protected final String TEXT_1310 = NL + "\t\tif (";
  protected final String TEXT_1311 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1312 = NL + "\t\t}";
  protected final String TEXT_1313 = NL + "\t\tif (";
  protected final String TEXT_1314 = ".size() >= ";
  protected final String TEXT_1315 = ".eINSTANCE.get";
  protected final String TEXT_1316 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1317 = NL + "\t\t}";
  protected final String TEXT_1318 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1319 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1320 = ".eINSTANCE.get";
  protected final String TEXT_1321 = "(), target.getElement()));";
  protected final String TEXT_1322 = NL + "\t\tdomainModelAddCommand = addLinkEndsCommand;";
  protected final String TEXT_1323 = NL + "\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1324 = ".create(domainModelEditDomain, source.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1325 = ".eINSTANCE.get";
  protected final String TEXT_1326 = "(), target.getElement());";
  protected final String TEXT_1327 = NL + "\t\t}" + NL;
  protected final String TEXT_1328 = NL;
  protected final String TEXT_1329 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1330 = " getRelationshipContainer(";
  protected final String TEXT_1331 = " element, ";
  protected final String TEXT_1332 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1333 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (source == null || target == null || createdEdge == null || domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1334 = NL;
  protected final String TEXT_1335 = NL + "\t\t\tif(!";
  protected final String TEXT_1336 = ".canCreateLink(";
  protected final String TEXT_1337 = ", ";
  protected final String TEXT_1338 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1339 = NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tsource.getDiagram().insertEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(source);" + NL + "\t\t\tcreatedEdge.setTarget(target);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t\tsource.getDiagram().removeEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(null);" + NL + "\t\t\tcreatedEdge.setTarget(null);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_1340 = NL;
  protected final String TEXT_1341 = NL;
  protected final String TEXT_1342 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_1343 = NL + "}";
  protected final String TEXT_1344 = NL;

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
			if (myPrimaryLabel == null){
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
			} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
				GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
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

    stringBuffer.append(TEXT_18);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    importManager.emitPackageStatement(stringBuffer);
    
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.NodeEditPart"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_26);
    {
GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_32);
    
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_34);
    
	}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_57);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_60);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_64);
    
	} else {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_69);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_73);
    
	} else {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_78);
    
	}

    stringBuffer.append(TEXT_79);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_83);
    
	} else {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_88);
    
	}
}

    stringBuffer.append(TEXT_89);
    
}	/*restrict local vars used in component edit policy*/

    
String layoutEditPolicyBaseClass;
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {
	layoutEditPolicyBaseClass = "org.eclipse.gef.editpolicies.XYLayoutEditPolicy";
} else {
	layoutEditPolicyBaseClass = "org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy";
}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(layoutEditPolicyBaseClass));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_94);
    
if (palette != null && !genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_100);
    
	for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
		GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_103);
    if (isXYLayout) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    
	}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_109);
    
}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_111);
    
if (!genNode.getChildNodes().isEmpty() && isXYLayout) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_140);
    
} else {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_146);
    
}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_149);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_150);
    
}

    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_160);
    
if (!myHelper.hasIncomingLinks()) {

    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_162);
    
} else {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_173);
    
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
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			incomingClass = metaFeature.getTypeGenClass();
			reconnectCommandNameInfix = metaFeature.getFeatureAccessorName();
		} else {
			continue;
		}
		if (!incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
			continue;
		}

    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_176);
    
	}

    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_180);
    
}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_183);
    
if (!myHelper.hasOutgoingLinks()) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_185);
    
} else {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_196);
    
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
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			outgoingClass = metaFeature.getGenClass();
			reconnectCommandNameInfix = metaFeature.getFeatureAccessorName();
		} else {
			continue;
		}
		if (!outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
			continue;
		}

    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_199);
    
	}

    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_203);
    
}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_206);
    if (palette != null && myHelper.hasOutgoingLinks()) {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_212);
    
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
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		createCommandNameInfix = metaFeature.getFeatureAccessorName();
	} else {
		continue;
	}
	if (!outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass())) {
		continue;
	}

    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_215);
    
}

    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_219);
    }/*when there's palette*/
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_222);
    if (palette != null && myHelper.hasIncomingLinks()) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_229);
    
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

    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_232);
    
}

    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_236);
    }/*when there's palette*/
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_238);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_239);
    
}

    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_240);
    
}

    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_246);
    
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_247);
    
	}

    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_249);
    
	if (!genNode.getCompartments().isEmpty() && !genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RectangleFigure"));
    stringBuffer.append(TEXT_253);
    
	}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_255);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_257);
    if (isXYLayout) {
    stringBuffer.append(TEXT_258);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_259);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_261);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_262);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_264);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    }
    stringBuffer.append(TEXT_267);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_270);
    }
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_285);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_286);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_288);
    } else {
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_292);
    }
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_296);
    
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_298);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_299);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_303);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_304);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_307);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_308);
    	
} // for pinned compartments

    stringBuffer.append(TEXT_309);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_310);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_314);
    
} // for pinned compartments

    stringBuffer.append(TEXT_315);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_317);
    
		GenNodeLabel firstEditableLabel = null;
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (!genLabel.isReadOnly()) {
				firstEditableLabel = genLabel;
				break;
			}
		}
		if (firstEditableLabel != null) {

    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName(firstEditableLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_324);
    
		}

    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_336);
    
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_338);
    
		}

    stringBuffer.append(TEXT_339);
    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_341);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_343);
    
	}

    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_348);
    
}
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_350);
    
	for(Iterator directChildren = genNode.getChildNodes().iterator(); directChildren.hasNext(); ) {
		GenChildNode next = (GenChildNode) directChildren.next();

    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_352);
    
	}

    stringBuffer.append(TEXT_353);
    
}
if (myHelper.hasExternalLabels() || myHelper.hasFixedChildren() || myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_355);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_358);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_359);
    
	}
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_362);
    
	}

    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_364);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_367);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_368);
    
	}
	if (myHelper.hasBothChildrenAndCompartments()) {

    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_371);
    
	}

    stringBuffer.append(TEXT_372);
    
}

    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_377);
    
}

    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_399);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_400);
    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_401);
    
}

    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_402);
    
}

    stringBuffer.append(TEXT_403);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_404);
    
}

    
if (!genNode.getChildNodes().isEmpty()) {

    stringBuffer.append(TEXT_405);
    
}

    stringBuffer.append(TEXT_406);
    
{
	final String _getViewCode = "getDiagramNode()";
	final String _getDiagramCode = "getDiagramNode().getDiagram()";
	final boolean _includeUncontainedLinks = false;
	if (!genNode.getChildNodes().isEmpty()) {
		final boolean isListLayout = !isXYLayout;
		final List childNodes = genNode.getChildNodes();

    stringBuffer.append(TEXT_407);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_415);
    
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

    stringBuffer.append(TEXT_416);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_419);
    
}

    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_421);
    
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

    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_426);
    
		} else {

    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_430);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_431);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_433);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_437);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_438);
    
		} else {

    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_440);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_441);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_443);
    
	}

    stringBuffer.append(TEXT_444);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_445);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_448);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(nextNode.getDomainMetaClass().getName());
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_452);
    if (!isListLayout) {
    stringBuffer.append(TEXT_453);
    }
    stringBuffer.append(TEXT_454);
    
}

    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(TEXT_457);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_458);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_459);
    
} else {

    stringBuffer.append(TEXT_460);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_461);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_462);
    
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

    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_467);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_468);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_469);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_471);
    
		} else {

    stringBuffer.append(TEXT_472);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_473);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_474);
    
	}

    stringBuffer.append(TEXT_475);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_476);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_477);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_478);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_479);
    
		} else {

    stringBuffer.append(TEXT_480);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_481);
    
		}

    stringBuffer.append(TEXT_482);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_483);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_484);
    
		} else {

    stringBuffer.append(TEXT_485);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_486);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_487);
    
	}
}

    stringBuffer.append(TEXT_488);
    
}

    stringBuffer.append(TEXT_489);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_498);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_500);
    
	}

    stringBuffer.append(TEXT_501);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_502);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_503);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService"));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher"));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_510);
    
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

    stringBuffer.append(TEXT_511);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_512);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_514);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_515);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_524);
    
	}

    stringBuffer.append(TEXT_525);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_526);
    
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

    stringBuffer.append(TEXT_527);
    
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

    stringBuffer.append(TEXT_528);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_532);
    
	} else {

    stringBuffer.append(TEXT_533);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_534);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_536);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_537);
    
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

    stringBuffer.append(TEXT_538);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_542);
    
	} else {

    stringBuffer.append(TEXT_543);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_546);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_547);
    
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

    stringBuffer.append(TEXT_548);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_552);
    
	} else {

    stringBuffer.append(TEXT_553);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_556);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_557);
    
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

    stringBuffer.append(TEXT_558);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_562);
    
	} else {

    stringBuffer.append(TEXT_563);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_566);
    
	}

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_567);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_568);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_569);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_570);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_571);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_572);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_573);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_575);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_576);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_579);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_584);
    
	for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_585);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_588);
    
	}
	for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_589);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_590);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_591);
    
	}

    stringBuffer.append(TEXT_592);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_598);
    
Map genFeature2genLinkMap = new LinkedHashMap();
for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
	GenFeature metaFeature = modelFacet.getChildMetaFeature();
	if (!genFeature2genLinkMap.containsKey(metaFeature)) {
		genFeature2genLinkMap.put(metaFeature, new ArrayList());
	}
	((Collection) genFeature2genLinkMap.get(metaFeature)).add(genLink);
}
Map genFeature2featureGenLinkMap = new LinkedHashMap();
for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
	if (!genFeature2featureGenLinkMap.containsKey(metaFeature)) {
		genFeature2featureGenLinkMap.put(metaFeature, new ArrayList());
	}
	((Collection) genFeature2featureGenLinkMap.get(metaFeature)).add(genLink);
}
if (!genFeature2genLinkMap.isEmpty() || !genFeature2featureGenLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_599);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_602);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_603);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_604);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_605);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_607);
    
	} else {

    stringBuffer.append(TEXT_608);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_609);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_610);
    
	}

    stringBuffer.append(TEXT_611);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_612);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_613);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_614);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_615);
    
		} else {

    stringBuffer.append(TEXT_616);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_617);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_618);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_619);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_620);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_621);
    
		} else {

    stringBuffer.append(TEXT_622);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_624);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_625);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_627);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_628);
    
		} else {

    stringBuffer.append(TEXT_629);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_631);
    
		}

    stringBuffer.append(TEXT_632);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_633);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_634);
    
		} else {

    stringBuffer.append(TEXT_635);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_636);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_637);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_638);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_639);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_641);
    
	} else {

    stringBuffer.append(TEXT_642);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_643);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_644);
    
	}

    stringBuffer.append(TEXT_645);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_646);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_648);
    
	}

    stringBuffer.append(TEXT_649);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_650);
    
	}
}

    stringBuffer.append(TEXT_651);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_659);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_660);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_662);
    
	}
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_663);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_665);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_666);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_667);
    
		}

    stringBuffer.append(TEXT_668);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_669);
    
		} else {

    stringBuffer.append(TEXT_670);
    
		}
	}
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_671);
    
		}

    stringBuffer.append(TEXT_672);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_674);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_675);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_676);
    
		}

    stringBuffer.append(TEXT_677);
    
	}

    stringBuffer.append(TEXT_678);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_679);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_680);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_681);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_684);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_689);
    
}

    
}	//end of local declarations

    stringBuffer.append(TEXT_690);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_693);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_699);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_700);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_701);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_709);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_713);
    
}

    stringBuffer.append(TEXT_714);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_715);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_716);
    
}

    stringBuffer.append(TEXT_717);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_738);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_739);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_745);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_755);
    stringBuffer.append(TEXT_756);
    stringBuffer.append(TEXT_757);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(TEXT_763);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(TEXT_769);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_771);
    
for(Iterator it = genNode.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();
	boolean isStatic = true;
	boolean isListLayout = !isXYLayout;
	String resolvedSemanticElement = "parent.getElement()";

    stringBuffer.append(TEXT_772);
    stringBuffer.append(TEXT_773);
    if (isStatic) {
    stringBuffer.append(TEXT_774);
    }
    stringBuffer.append(TEXT_775);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_776);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_778);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_780);
    if (!isListLayout) {
    stringBuffer.append(TEXT_781);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_782);
    }
    stringBuffer.append(TEXT_783);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_785);
    
	if (!isListLayout) {

    stringBuffer.append(TEXT_786);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_788);
    
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_789);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_791);
    
	}

    stringBuffer.append(TEXT_792);
    
if (genDiagram.getPalette() != null) {

    stringBuffer.append(TEXT_793);
    if (isStatic) {
    stringBuffer.append(TEXT_794);
    }
    stringBuffer.append(TEXT_795);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_796);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_798);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_801);
    if (!isListLayout) {
    stringBuffer.append(TEXT_802);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_803);
    }
    stringBuffer.append(TEXT_804);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_806);
    
	if (next.getDomainMetaClass().isMapEntry()) {
	/*Workaround for Ecore example: map entries cannot be created using factory, only using reflective EFactory.create() method*/

    stringBuffer.append(TEXT_807);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_811);
    
	} else {

    stringBuffer.append(TEXT_812);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_815);
    
	}

    stringBuffer.append(TEXT_816);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_817);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(next.getUniqueIdentifier());
    stringBuffer.append(TEXT_819);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_820);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_821);
    }
    stringBuffer.append(TEXT_822);
    
	TypeModelFacet facet = next.getModelFacet();
	GenFeature childFeature = facet.getChildMetaFeature();
	GenFeature containmentFeature = facet.getContainmentMetaFeature();
	if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_823);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_828);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_829);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_833);
    
	} else {

    stringBuffer.append(TEXT_834);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_838);
    
	}

    stringBuffer.append(TEXT_839);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_840);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_841);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_842);
    }
    stringBuffer.append(TEXT_843);
    if(!isListLayout) {
    stringBuffer.append(TEXT_844);
    }
    stringBuffer.append(TEXT_845);
    
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

    stringBuffer.append(TEXT_846);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_847);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_850);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_852);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_853);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_854);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_856);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_857);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_858);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_859);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_860);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_861);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_862);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_866);
    
	} else {

    stringBuffer.append(TEXT_867);
    
	}

    stringBuffer.append(TEXT_868);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_869);
    
			} else {

    stringBuffer.append(TEXT_870);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_872);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_873);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_874);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_875);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_876);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_878);
    
	} else {

    stringBuffer.append(TEXT_879);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_880);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_881);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_882);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_883);
    
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

    stringBuffer.append(TEXT_884);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_885);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_886);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_887);
    
	} else {

    stringBuffer.append(TEXT_888);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_889);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_891);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_892);
    
	}
}

    
					}
				}
			}
			//No need to check the size of the source or target features: their size does not change
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_893);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_894);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_895);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_896);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_897);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_898);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			{
				GenFeature _feature = metaFeature;
				String _ownerInstance = "newSource.getElement()";
				String _exceedsUpperBound = "return false;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_899);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_900);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_902);
    
	} else {

    stringBuffer.append(TEXT_903);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_905);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_906);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_907);
    
	}
}

    
			}
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_908);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_909);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_911);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_912);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_913);
    
		} else {

    stringBuffer.append(TEXT_914);
    
		}

    stringBuffer.append(TEXT_915);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_916);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_920);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_921);
    
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

    stringBuffer.append(TEXT_922);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_925);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_927);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_928);
    
			}
			if (containmentFeature != null) {
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_929);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_930);
    
				} else {

    stringBuffer.append(TEXT_931);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_933);
    
				}

    stringBuffer.append(TEXT_934);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_937);
    
			}
			if (setChild) {
				if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_938);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_941);
    
				} else {

    stringBuffer.append(TEXT_942);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_945);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_946);
    
				}

    stringBuffer.append(TEXT_947);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_948);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_950);
    
			}

    stringBuffer.append(TEXT_951);
    
			if (setSource) {
				if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_952);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_955);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_958);
    
				} else {

    stringBuffer.append(TEXT_959);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_960);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_962);
    
				}
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_963);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_966);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_969);
    
			} else {

    stringBuffer.append(TEXT_970);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_973);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_976);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_977);
    
			}
		}

    stringBuffer.append(TEXT_978);
    stringBuffer.append(TEXT_979);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_980);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_983);
    
		}

    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_984);
    stringBuffer.append(TEXT_985);
    
	//input: _edge : String

    stringBuffer.append(TEXT_986);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_988);
    
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

    stringBuffer.append(TEXT_989);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_991);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_992);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_994);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_995);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_996);
    
			} else {

    stringBuffer.append(TEXT_997);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1001);
    
			}
		} else {

    stringBuffer.append(TEXT_1002);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1003);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1004);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1009);
    
			} else {

    stringBuffer.append(TEXT_1010);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1015);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1016);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1021);
    
			} else {

    stringBuffer.append(TEXT_1022);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1027);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1028);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1033);
    
			} else {

    stringBuffer.append(TEXT_1034);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1039);
    
			}
		}

    stringBuffer.append(TEXT_1040);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1041);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1046);
    
		} else {

    stringBuffer.append(TEXT_1047);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1052);
    
		}

    
	}

    stringBuffer.append(TEXT_1053);
    
	}

    stringBuffer.append(TEXT_1054);
    
	if (palette != null) {

    stringBuffer.append(TEXT_1055);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1061);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_1062);
    
			} else {

    stringBuffer.append(TEXT_1063);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1067);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_1068);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1069);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1071);
    
	} else {

    stringBuffer.append(TEXT_1072);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1076);
    
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

    stringBuffer.append(TEXT_1077);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1078);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1080);
    
	} else {

    stringBuffer.append(TEXT_1081);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1085);
    
	}
}

    
					}
				}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_1086);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1087);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1090);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1091);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		{
			GenFeature _feature = metaFeature;
			String _ownerInstance = "source.getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_1092);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1093);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1095);
    
	} else {

    stringBuffer.append(TEXT_1096);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1100);
    
	}
}

    
		}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_1101);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1102);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1105);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1106);
    
		} else {

    stringBuffer.append(TEXT_1107);
    
		}

    stringBuffer.append(TEXT_1108);
    stringBuffer.append(TEXT_1109);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1113);
    
		}

    stringBuffer.append(TEXT_1114);
    
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

    stringBuffer.append(TEXT_1115);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1128);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_1129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_1135);
    
	} else {

    stringBuffer.append(TEXT_1136);
    
	}

    stringBuffer.append(TEXT_1137);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_1138);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1139);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1142);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1143);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_1144);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1145);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1148);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1149);
    
		} else {

    stringBuffer.append(TEXT_1150);
    
		}

    stringBuffer.append(TEXT_1151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_1157);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1164);
    
			} else {

    stringBuffer.append(TEXT_1165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1168);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1175);
    
			} else {

    stringBuffer.append(TEXT_1176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1179);
    
			}
		}

    stringBuffer.append(TEXT_1180);
    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_1181);
    stringBuffer.append(TEXT_1182);
    
	//input: _edge : String

    stringBuffer.append(TEXT_1183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1185);
    
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

    stringBuffer.append(TEXT_1186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_1188);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1193);
    
			} else {

    stringBuffer.append(TEXT_1194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1198);
    
			}
		} else {

    stringBuffer.append(TEXT_1199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1200);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1206);
    
			} else {

    stringBuffer.append(TEXT_1207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1212);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1218);
    
			} else {

    stringBuffer.append(TEXT_1219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1224);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1230);
    
			} else {

    stringBuffer.append(TEXT_1231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1236);
    
			}
		}

    stringBuffer.append(TEXT_1237);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1243);
    
		} else {

    stringBuffer.append(TEXT_1244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1249);
    
		}

    
	}

    stringBuffer.append(TEXT_1250);
    
	}

    stringBuffer.append(TEXT_1251);
    
	if (palette != null) {

    stringBuffer.append(TEXT_1252);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_1265);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenClass linkClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1266);
    stringBuffer.append(importManager.getImportedName(importManager.getImportedName(linkClass.getQualifiedInterfaceName())));
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(importManager.getImportedName(linkClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(linkClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_1269);
    if (linkClass.isExternalInterface()) {
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1271);
    }
    stringBuffer.append(TEXT_1272);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_1275);
    if (linkClass.isExternalInterface()) {
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1277);
    }
    stringBuffer.append(TEXT_1278);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_1279);
    
		}

    stringBuffer.append(TEXT_1280);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1283);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1284);
    
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

    stringBuffer.append(TEXT_1285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1291);
    
			}
			if (addChild) {

    stringBuffer.append(TEXT_1292);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1295);
    
			}
			if (addSource) {
				{
					GenFeature _feature = sourceFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1296);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1297);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1299);
    
	} else {

    stringBuffer.append(TEXT_1300);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1304);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1305);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1308);
    
			}
			if (addTarget) {
				{
					GenFeature _feature = targetFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1309);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1310);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1312);
    
	} else {

    stringBuffer.append(TEXT_1313);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1317);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1318);
    stringBuffer.append(importManager.getImportedName(targetFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1321);
    
			}

    stringBuffer.append(TEXT_1322);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_1323);
    stringBuffer.append(importManager.getImportedName(metaFeature.getEcoreFeature().isMany()? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1326);
    
		}

    stringBuffer.append(TEXT_1327);
    stringBuffer.append(TEXT_1328);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1332);
    
		}

    stringBuffer.append(TEXT_1333);
    
{
	String _source = "source.getElement()";
	String _target = "target.getElement()";

    stringBuffer.append(TEXT_1334);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1335);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1338);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1339);
    
	}

    }/*when there's palette*/
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_1340);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_1341);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_1342);
    
}

    
}

    stringBuffer.append(TEXT_1343);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_1344);
    return stringBuffer.toString();
  }
}
