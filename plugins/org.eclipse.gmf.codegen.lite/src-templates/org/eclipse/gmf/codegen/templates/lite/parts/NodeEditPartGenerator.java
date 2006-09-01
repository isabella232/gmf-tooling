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
  protected final String TEXT_32 = " primaryShape;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_33 = "(";
  protected final String TEXT_34 = " model) {" + NL + "\t\tassert model instanceof ";
  protected final String TEXT_35 = ";" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL;
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_38 = " view = (";
  protected final String TEXT_39 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_40 = " view = (";
  protected final String TEXT_41 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "\t\tinstallEditPolicy(";
  protected final String TEXT_44 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_45 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_46 = " createDeleteCommand(";
  protected final String TEXT_47 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_48 = " editingDomain = ";
  protected final String TEXT_49 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_50 = " cc = new ";
  protected final String TEXT_51 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_52 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_53 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_54 = " editingDomain) {";
  protected final String TEXT_55 = NL + "\t\t\t\t";
  protected final String TEXT_56 = " result = new ";
  protected final String TEXT_57 = "();";
  protected final String TEXT_58 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_59 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_60 = ".eINSTANCE.get";
  protected final String TEXT_61 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_62 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_63 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_64 = ".eINSTANCE.get";
  protected final String TEXT_65 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = ".UNSET_VALUE));";
  protected final String TEXT_67 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_68 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_69 = ".eINSTANCE.get";
  protected final String TEXT_70 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_71 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_72 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_73 = ".eINSTANCE.get";
  protected final String TEXT_74 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = ".UNSET_VALUE));";
  protected final String TEXT_76 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_77 = NL + "\t\t\t\treturn ";
  protected final String TEXT_78 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_79 = ".eINSTANCE.get";
  protected final String TEXT_80 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_81 = NL + "\t\t\t\treturn ";
  protected final String TEXT_82 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_83 = ".eINSTANCE.get";
  protected final String TEXT_84 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = ".UNSET_VALUE);";
  protected final String TEXT_86 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_87 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_88 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_89 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_90 = " getCreateCommand(";
  protected final String TEXT_91 = " request) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_92 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_93 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_94 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_95 = " createChangeConstraintCommand(";
  protected final String TEXT_96 = " child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_97 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_98 = " createChildEditPolicy(";
  protected final String TEXT_99 = " child) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_100 = "() {" + NL + "\t\t\t\t\tpublic ";
  protected final String TEXT_101 = " getTargetEditPart(";
  protected final String TEXT_102 = " request) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_103 = ".REQ_SELECTION.equals(request.getType())) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_104 = ".this;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_105 = ".GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_106 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_107 = " getReconnectTargetCommand(";
  protected final String TEXT_108 = " request) {";
  protected final String TEXT_109 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_110 = ".INSTANCE;";
  protected final String TEXT_111 = NL + "\t\t\t\t";
  protected final String TEXT_112 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_113 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_114 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_115 = " edge = (";
  protected final String TEXT_116 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_117 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_118 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_119 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_120 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_121 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_122 = NL + "\t\t\t\tcase ";
  protected final String TEXT_123 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_124 = "TargetCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_125 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_126 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_127 = "(";
  protected final String TEXT_128 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_129 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_130 = " getReconnectSourceCommand(";
  protected final String TEXT_131 = " request) {";
  protected final String TEXT_132 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_133 = ".INSTANCE;";
  protected final String TEXT_134 = NL + "\t\t\t\t";
  protected final String TEXT_135 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_136 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_137 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_138 = " edge = (";
  protected final String TEXT_139 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_140 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_141 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_142 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_143 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_144 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_145 = NL + "\t\t\t\tcase ";
  protected final String TEXT_146 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_147 = "SourceCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_148 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_149 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_152 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_153 = " getConnectionCreateCommand(";
  protected final String TEXT_154 = " request) {";
  protected final String TEXT_155 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_156 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_157 = " requestEx = (";
  protected final String TEXT_158 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_159 = " result = new ";
  protected final String TEXT_160 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_162 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_163 = "StartCommand(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_165 = " wrappedResult = new ";
  protected final String TEXT_166 = "(";
  protected final String TEXT_167 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_168 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_169 = " getConnectionCompleteCommand(";
  protected final String TEXT_170 = " request) {";
  protected final String TEXT_171 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_172 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_173 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_174 = " requestEx = (";
  protected final String TEXT_175 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_176 = " result = new ";
  protected final String TEXT_177 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_179 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_180 = "Command(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_182 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_183 = "(";
  protected final String TEXT_184 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_185 = NL + "\t\t\t\treturn ";
  protected final String TEXT_186 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_187 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_188 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_189 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_190 = " invisibleRectangle = new ";
  protected final String TEXT_191 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_192 = "());" + NL + "\t\t";
  protected final String TEXT_193 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_194 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_195 = " createNodeShape() {";
  protected final String TEXT_196 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_197 = "()";
  protected final String TEXT_198 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_199 = ";";
  protected final String TEXT_200 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_201 = ";";
  protected final String TEXT_202 = NL + "\t\t";
  protected final String TEXT_203 = " figure = new ";
  protected final String TEXT_204 = "();";
  protected final String TEXT_205 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_206 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_207 = NL + "\t\treturn primaryShape;" + NL + "\t}";
  protected final String TEXT_208 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_209 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_210 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_211 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_212 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_213 = " view = (";
  protected final String TEXT_214 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_215 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_216 = " decorationPane = new ";
  protected final String TEXT_217 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_218 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_219 = " imageFigure = new ";
  protected final String TEXT_220 = "(";
  protected final String TEXT_221 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_222 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_223 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_224 = " setupContentPane(";
  protected final String TEXT_225 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_226 = NL + "\t\t\t";
  protected final String TEXT_227 = " layout = new ";
  protected final String TEXT_228 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_229 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_230 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_231 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_232 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_233 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_234 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_235 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_236 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_237 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_238 = " childEditPart) {";
  protected final String TEXT_239 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_240 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_241 = ") childEditPart).";
  protected final String TEXT_242 = "(getPrimaryShape().";
  protected final String TEXT_243 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_244 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_245 = ") {" + NL + "\t\t\t";
  protected final String TEXT_246 = " pane = getPrimaryShape().";
  protected final String TEXT_247 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_248 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_249 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_250 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_251 = ") {" + NL + "\t\t\t";
  protected final String TEXT_252 = " pane = getPrimaryShape().";
  protected final String TEXT_253 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_254 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_255 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_256 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_257 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_258 = NL + "\t\tfor(";
  protected final String TEXT_259 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_260 = " nextChild = (";
  protected final String TEXT_261 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_262 = ".getVisualID(nextChild) == ";
  protected final String TEXT_263 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_264 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_265 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_266 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_267 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_268 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_269 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_270 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_271 = " getLabelEditPart(";
  protected final String TEXT_272 = " req) {" + NL + "\t\t";
  protected final String TEXT_273 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_274 = " view = (";
  protected final String TEXT_275 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_276 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_277 = NL + "\t\t\t\tcase ";
  protected final String TEXT_278 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_279 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_280 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_281 = " childEditPart) {";
  protected final String TEXT_282 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_283 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_284 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_285 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_286 = " root = (";
  protected final String TEXT_287 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_288 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_289 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_290 = " childEditPart, int index) {";
  protected final String TEXT_291 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_292 = " labelFigure = ((";
  protected final String TEXT_293 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_294 = NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_295 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_296 = " childEditPart) {";
  protected final String TEXT_297 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_298 = " labelFigure = ((";
  protected final String TEXT_299 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_300 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_301 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_302 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_303 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_304 = " childEditPart = (";
  protected final String TEXT_305 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_306 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_307 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_308 = " node = getDiagramNode();" + NL + "\t\tif (node.getLayoutConstraint() == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_309 = ";" + NL + "\t\t";
  protected final String TEXT_310 = " bounds = (";
  protected final String TEXT_311 = ") node.getLayoutConstraint();" + NL + "\t\t((";
  protected final String TEXT_312 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_313 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_314 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_315 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_316 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_317 = " getSourceConnectionAnchor(";
  protected final String TEXT_318 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_319 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_320 = " getSourceConnectionAnchor(";
  protected final String TEXT_321 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_322 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_323 = "  getTargetConnectionAnchor(";
  protected final String TEXT_324 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_325 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_326 = "  getTargetConnectionAnchor(";
  protected final String TEXT_327 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_328 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_329 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);";
  protected final String TEXT_330 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_331 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_332 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_333 = NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}";
  protected final String TEXT_334 = NL;
  protected final String TEXT_335 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_336 = " domainModelEditDomain = ";
  protected final String TEXT_337 = ".getEditingDomain(";
  protected final String TEXT_338 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * Service to find a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_339 = " viewService;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_340 = " getViewService() {" + NL + "\t\tif (viewService == null) {" + NL + "\t\t\tviewService = new ";
  protected final String TEXT_341 = "(getViewer());" + NL + "\t\t}" + NL + "\t\treturn viewService;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher(getViewService());" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_342 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher(";
  protected final String TEXT_343 = " viewService) {" + NL + "\t\t\tsuper(viewService);" + NL + "\t\t}";
  protected final String TEXT_344 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_345 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_346 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_347 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_348 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_349 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_350 = ".createEventTypeFilter(";
  protected final String TEXT_351 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_352 = ".createEventTypeFilter(";
  protected final String TEXT_353 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_354 = ".createEventTypeFilter(";
  protected final String TEXT_355 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_356 = ".createEventTypeFilter(";
  protected final String TEXT_357 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_358 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_359 = " createFilter() {";
  protected final String TEXT_360 = NL;
  protected final String TEXT_361 = NL + "\t\t\t";
  protected final String TEXT_362 = " filter = ";
  protected final String TEXT_363 = ".createFeatureFilter(";
  protected final String TEXT_364 = ".eINSTANCE.get";
  protected final String TEXT_365 = "());";
  protected final String TEXT_366 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_367 = ".createFeatureFilter(";
  protected final String TEXT_368 = ".eINSTANCE.get";
  protected final String TEXT_369 = "()));";
  protected final String TEXT_370 = NL;
  protected final String TEXT_371 = NL + "\t\t\t";
  protected final String TEXT_372 = " filter = ";
  protected final String TEXT_373 = ".createFeatureFilter(";
  protected final String TEXT_374 = ".eINSTANCE.get";
  protected final String TEXT_375 = "());";
  protected final String TEXT_376 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_377 = ".createFeatureFilter(";
  protected final String TEXT_378 = ".eINSTANCE.get";
  protected final String TEXT_379 = "()));";
  protected final String TEXT_380 = NL;
  protected final String TEXT_381 = NL + "\t\t\t";
  protected final String TEXT_382 = " filter = ";
  protected final String TEXT_383 = ".createFeatureFilter(";
  protected final String TEXT_384 = ".eINSTANCE.get";
  protected final String TEXT_385 = "());";
  protected final String TEXT_386 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_387 = ".createFeatureFilter(";
  protected final String TEXT_388 = ".eINSTANCE.get";
  protected final String TEXT_389 = "()));";
  protected final String TEXT_390 = NL;
  protected final String TEXT_391 = NL + "\t\t\t";
  protected final String TEXT_392 = " filter = ";
  protected final String TEXT_393 = ".createFeatureFilter(";
  protected final String TEXT_394 = ".eINSTANCE.get";
  protected final String TEXT_395 = "());";
  protected final String TEXT_396 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_397 = ".createFeatureFilter(";
  protected final String TEXT_398 = ".eINSTANCE.get";
  protected final String TEXT_399 = "()));";
  protected final String TEXT_400 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_401 = NL + "\t\t\t";
  protected final String TEXT_402 = " filter = getConstrainedChildLinksFilter();";
  protected final String TEXT_403 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_404 = NL + "\t\t\t";
  protected final String TEXT_405 = " filter = createUncontainedLinksFilter();";
  protected final String TEXT_406 = NL + "\t\t\t";
  protected final String TEXT_407 = " filter = ";
  protected final String TEXT_408 = ".NOT_TOUCH;";
  protected final String TEXT_409 = NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t\tprotected ";
  protected final String TEXT_410 = " getCreateNotationalElementCommand(";
  protected final String TEXT_411 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_412 = " linkDescriptor = (";
  protected final String TEXT_413 = ") descriptor;" + NL + "\t\t\t";
  protected final String TEXT_414 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_415 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_416 = " createdEdge = ";
  protected final String TEXT_417 = ".eINSTANCE.createEdge();" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_418 = NL + "\t\t\tcase ";
  protected final String TEXT_419 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_420 = ") {" + NL + "\t\t\t\t\tcreatedEdge.setElement(linkDescriptor.getElement());" + NL + "\t\t\t\t\t";
  protected final String TEXT_421 = ".decorateView(createdEdge);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_422 = NL + "\t\t\tcase ";
  protected final String TEXT_423 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tcreatedEdge.setElement(null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_424 = ".decorateView(createdEdge);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_425 = NL + "\t\t\t}" + NL + "\t\t\tif (createdEdge.getType() == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_426 = "(getHost().getDiagram(), createdEdge, sourceView, targetView);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_427 = " getSemanticChildLinks() {";
  protected final String TEXT_428 = NL;
  protected final String TEXT_429 = "\t";
  protected final String TEXT_430 = " result = new ";
  protected final String TEXT_431 = "();";
  protected final String TEXT_432 = NL + "\t";
  protected final String TEXT_433 = " modelObject = ";
  protected final String TEXT_434 = ".getElement();" + NL + "\t";
  protected final String TEXT_435 = " nextValue;";
  protected final String TEXT_436 = NL + "\tint linkVID;";
  protected final String TEXT_437 = NL + "\tfor(";
  protected final String TEXT_438 = " it = ";
  protected final String TEXT_439 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_440 = ") it.next();";
  protected final String TEXT_441 = NL + "\tnextValue = (";
  protected final String TEXT_442 = ")";
  protected final String TEXT_443 = ";";
  protected final String TEXT_444 = NL + "\tlinkVID = ";
  protected final String TEXT_445 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_446 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_447 = NL + "\tcase ";
  protected final String TEXT_448 = ".VISUAL_ID: {";
  protected final String TEXT_449 = NL + "\tif (";
  protected final String TEXT_450 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_451 = NL + "\t\t";
  protected final String TEXT_452 = " source = (";
  protected final String TEXT_453 = ")";
  protected final String TEXT_454 = ";";
  protected final String TEXT_455 = NL + "\t\t";
  protected final String TEXT_456 = " source = ";
  protected final String TEXT_457 = ".getElement();";
  protected final String TEXT_458 = NL + "\t\t";
  protected final String TEXT_459 = " target = (";
  protected final String TEXT_460 = ")";
  protected final String TEXT_461 = ";";
  protected final String TEXT_462 = NL + "\t\t";
  protected final String TEXT_463 = " target = ";
  protected final String TEXT_464 = ".getElement();";
  protected final String TEXT_465 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_466 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_467 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_468 = NL + "\t}";
  protected final String TEXT_469 = NL + "\t}";
  protected final String TEXT_470 = NL + "\t}";
  protected final String TEXT_471 = NL + "\tfor(";
  protected final String TEXT_472 = " it = ";
  protected final String TEXT_473 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_474 = ") it.next();";
  protected final String TEXT_475 = NL + "\tnextValue = (";
  protected final String TEXT_476 = ")";
  protected final String TEXT_477 = ";";
  protected final String TEXT_478 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_479 = NL + "\t\tresult.add(new ";
  protected final String TEXT_480 = "(modelObject, nextValue, null, ";
  protected final String TEXT_481 = ".VISUAL_ID));";
  protected final String TEXT_482 = NL + "\t}";
  protected final String TEXT_483 = NL + "\t}";
  protected final String TEXT_484 = NL + "\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_485 = " getNotationalChildLinks() {" + NL + "\t\t\t";
  protected final String TEXT_486 = " result = new ";
  protected final String TEXT_487 = "();" + NL + "\t\t\t";
  protected final String TEXT_488 = " allLinks = ";
  protected final String TEXT_489 = ".getEdges();" + NL + "\t\t\tfor(";
  protected final String TEXT_490 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_491 = " next = (";
  protected final String TEXT_492 = ") it.next();";
  protected final String TEXT_493 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_494 = " source = next.getSource();" + NL + "\t\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_495 = " target = next.getTarget();" + NL + "\t\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}";
  protected final String TEXT_496 = NL + "\t\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_497 = ") {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_498 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_499 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_500 = ".VISUAL_ID:";
  protected final String TEXT_501 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_502 = NL + "\t\t\t\t} else {";
  protected final String TEXT_503 = NL + "\t\t\t\t}";
  protected final String TEXT_504 = NL + "\t\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_505 = NL + "\t\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_506 = ".getElement()) {" + NL + "\t\t\t\t\t\tint linkVID = ";
  protected final String TEXT_507 = ".getVisualID(next);" + NL + "\t\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_508 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_509 = ".VISUAL_ID:";
  protected final String TEXT_510 = NL + "\t\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_511 = NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_512 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_513 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_514 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_515 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_516 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_517 = " linkRefresher = getLinkNotationModelRefresher();" + NL + "\t\tif (!linkRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_518 = " command = linkRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_519 = " domainModelEditDomain = ";
  protected final String TEXT_520 = ".getEditingDomain(";
  protected final String TEXT_521 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_522 = "(domainModelEditDomain, command));" + NL + "\t}";
  protected final String TEXT_523 = NL;
  protected final String TEXT_524 = NL;
  protected final String TEXT_525 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_526 = " domainModelRefresher = new ";
  protected final String TEXT_527 = "(this);" + NL;
  protected final String TEXT_528 = NL;
  protected final String TEXT_529 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_530 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_531 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_532 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_533 = NL;
  protected final String TEXT_534 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_535 = NL + "\t\t";
  protected final String TEXT_536 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_537 = ") ";
  protected final String TEXT_538 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_539 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_540 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_541 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_542 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_543 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_544 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_545 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_546 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_547 = "\t" + NL + "\t}";
  protected final String TEXT_548 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_549 = " createdFont;";
  protected final String TEXT_550 = "\t" + NL;
  protected final String TEXT_551 = NL;
  protected final String TEXT_552 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_553 = " style = (";
  protected final String TEXT_554 = ")  ";
  protected final String TEXT_555 = ".getStyle(";
  protected final String TEXT_556 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_557 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_558 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_559 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_560 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_561 = " style = (";
  protected final String TEXT_562 = ")  ";
  protected final String TEXT_563 = ".getStyle(";
  protected final String TEXT_564 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_565 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_566 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_567 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_568 = " createdBackgroundColor;" + NL;
  protected final String TEXT_569 = NL;
  protected final String TEXT_570 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_571 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_572 = " feature, ";
  protected final String TEXT_573 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_574 = "();";
  protected final String TEXT_575 = NL;
  protected final String TEXT_576 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_577 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_578 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_579 = NL;
  protected final String TEXT_580 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_581 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_582 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_583 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_584 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_585 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_586 = NL;
  protected final String TEXT_587 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_588 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_589 = NL;
  protected final String TEXT_590 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_591 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_592 = NL;
  protected final String TEXT_593 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_594 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_595 = NL;
  protected final String TEXT_596 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_597 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_598 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_599 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_600 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_601 = NL;
  protected final String TEXT_602 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_603 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_604 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_605 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_606 = "SourceCommand extends ";
  protected final String TEXT_607 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_608 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_609 = " newSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_610 = " oldSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_611 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_612 = "SourceCommand(";
  protected final String TEXT_613 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_614 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_615 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_616 = "SourceCommand(";
  protected final String TEXT_617 = " edge, ";
  protected final String TEXT_618 = " newSource) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newSource = newSource;" + NL + "\t\t\tthis.oldSource = edge.getSource();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_619 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_620 = " domainModelEditDomain = ";
  protected final String TEXT_621 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_622 = " command = new ";
  protected final String TEXT_623 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_624 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew ";
  protected final String TEXT_625 = "(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_626 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_627 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_628 = NL + "\t\t\treturn false;";
  protected final String TEXT_629 = NL + "\t\t\t";
  protected final String TEXT_630 = " container = (";
  protected final String TEXT_631 = ")getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_632 = ".eINSTANCE.get";
  protected final String TEXT_633 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_634 = NL;
  protected final String TEXT_635 = NL + "\t\tif (";
  protected final String TEXT_636 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_637 = NL + "\t\t}";
  protected final String TEXT_638 = NL + "\t\tif (";
  protected final String TEXT_639 = ".size() >= ";
  protected final String TEXT_640 = ".eINSTANCE.get";
  protected final String TEXT_641 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_642 = NL + "\t\t}";
  protected final String TEXT_643 = NL;
  protected final String TEXT_644 = NL + "\t\tif (";
  protected final String TEXT_645 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_646 = NL + "\t\t}";
  protected final String TEXT_647 = NL + "\t\tif (";
  protected final String TEXT_648 = ".size() >= ";
  protected final String TEXT_649 = ".eINSTANCE.get";
  protected final String TEXT_650 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_651 = NL + "\t\t}";
  protected final String TEXT_652 = NL;
  protected final String TEXT_653 = NL + "\t\t\tif(!";
  protected final String TEXT_654 = ".canCreateLink(";
  protected final String TEXT_655 = ", ";
  protected final String TEXT_656 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_657 = NL + "\t\t\treturn true;";
  protected final String TEXT_658 = NL;
  protected final String TEXT_659 = NL + "\t\tif (";
  protected final String TEXT_660 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_661 = NL + "\t\t}";
  protected final String TEXT_662 = NL + "\t\tif (";
  protected final String TEXT_663 = ".size() >= ";
  protected final String TEXT_664 = ".eINSTANCE.get";
  protected final String TEXT_665 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_666 = NL + "\t\t}";
  protected final String TEXT_667 = NL;
  protected final String TEXT_668 = NL + "\t\t\tif(!";
  protected final String TEXT_669 = ".canCreateLink(";
  protected final String TEXT_670 = ", ";
  protected final String TEXT_671 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_672 = NL + "\t\t\treturn true;";
  protected final String TEXT_673 = NL + "\t\t\treturn false;";
  protected final String TEXT_674 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_675 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_676 = " editingDomain = ";
  protected final String TEXT_677 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_678 = " result = new ";
  protected final String TEXT_679 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_680 = "(edge, newSource));";
  protected final String TEXT_681 = NL + "\t\t\t";
  protected final String TEXT_682 = " container = getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_683 = ".eINSTANCE.get";
  protected final String TEXT_684 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_685 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_686 = " oldContainer = edge.getElement().eContainer();" + NL + "\t\t\tif (oldContainer == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_687 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tif (oldContainer != container) {";
  protected final String TEXT_688 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_689 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), edge.getElement()));";
  protected final String TEXT_690 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_691 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), ";
  protected final String TEXT_692 = ".UNSET_VALUE));";
  protected final String TEXT_693 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_694 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_695 = ".eINSTANCE.get";
  protected final String TEXT_696 = "(), edge.getElement()));";
  protected final String TEXT_697 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_698 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_699 = ".eINSTANCE.get";
  protected final String TEXT_700 = "()," + NL + "\t\t\t\t\tedge.getElement()));";
  protected final String TEXT_701 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_702 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_703 = ".eINSTANCE.get";
  protected final String TEXT_704 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_705 = ".UNSET_VALUE));";
  protected final String TEXT_706 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_707 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_708 = ".eINSTANCE.get";
  protected final String TEXT_709 = "(), edge.getElement()));";
  protected final String TEXT_710 = NL + "\t\t\t}";
  protected final String TEXT_711 = NL + "\t\t\tresult.append(";
  protected final String TEXT_712 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_713 = ".eINSTANCE.get";
  protected final String TEXT_714 = "()," + NL + "\t\t\t\toldSource.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_715 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_716 = ".eINSTANCE.get";
  protected final String TEXT_717 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_718 = NL + "\t\t\tresult.append(";
  protected final String TEXT_719 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_720 = ".eINSTANCE.get";
  protected final String TEXT_721 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_722 = NL + "\t\t\tresult.append(";
  protected final String TEXT_723 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_724 = ".eINSTANCE.get";
  protected final String TEXT_725 = "(), edge.getTarget().getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_726 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_727 = ".eINSTANCE.get";
  protected final String TEXT_728 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_729 = NL + "\t\t\tresult.append(";
  protected final String TEXT_730 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_731 = ".eINSTANCE.get";
  protected final String TEXT_732 = "(), ";
  protected final String TEXT_733 = ".UNSET_VALUE));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_734 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_735 = ".eINSTANCE.get";
  protected final String TEXT_736 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_737 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL;
  protected final String TEXT_738 = NL;
  protected final String TEXT_739 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_740 = " getRelationshipContainer(";
  protected final String TEXT_741 = " element, ";
  protected final String TEXT_742 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_743 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_744 = NL;
  protected final String TEXT_745 = NL + "\t\t\tprivate ";
  protected final String TEXT_746 = " createDomainModelRemoveCommand(";
  protected final String TEXT_747 = " editingDomain) {";
  protected final String TEXT_748 = NL + "\t\t\t\t";
  protected final String TEXT_749 = " result = new ";
  protected final String TEXT_750 = "();";
  protected final String TEXT_751 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_752 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_753 = ".getElement().eContainer(), ";
  protected final String TEXT_754 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_755 = ".getElement()));";
  protected final String TEXT_756 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_757 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_758 = ".getElement().eContainer(), ";
  protected final String TEXT_759 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_760 = ".UNSET_VALUE));";
  protected final String TEXT_761 = NL + "\t\t\t\treturn ";
  protected final String TEXT_762 = ".INSTANCE;";
  protected final String TEXT_763 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_764 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_765 = ".getElement().eContainer(), ";
  protected final String TEXT_766 = ".eINSTANCE.get";
  protected final String TEXT_767 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_768 = ".getElement()));";
  protected final String TEXT_769 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_770 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_771 = ".getElement().eContainer(), ";
  protected final String TEXT_772 = ".eINSTANCE.get";
  protected final String TEXT_773 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_774 = ".UNSET_VALUE));";
  protected final String TEXT_775 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_776 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_777 = ".getElement(), ";
  protected final String TEXT_778 = ".eINSTANCE.get";
  protected final String TEXT_779 = "(), ";
  protected final String TEXT_780 = ".getSource().getElement()));";
  protected final String TEXT_781 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_782 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_783 = ".getElement(), ";
  protected final String TEXT_784 = ".eINSTANCE.get";
  protected final String TEXT_785 = "(), ";
  protected final String TEXT_786 = ".UNSET_VALUE));";
  protected final String TEXT_787 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_788 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_789 = ".getElement(), ";
  protected final String TEXT_790 = ".eINSTANCE.get";
  protected final String TEXT_791 = "(), ";
  protected final String TEXT_792 = ".getTarget().getElement()));";
  protected final String TEXT_793 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_794 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_795 = ".getElement(), ";
  protected final String TEXT_796 = ".eINSTANCE.get";
  protected final String TEXT_797 = "(), ";
  protected final String TEXT_798 = ".UNSET_VALUE));";
  protected final String TEXT_799 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_800 = NL + "\t\t\t\treturn ";
  protected final String TEXT_801 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_802 = ".getSource().getElement(), ";
  protected final String TEXT_803 = ".eINSTANCE.get";
  protected final String TEXT_804 = "(), ";
  protected final String TEXT_805 = ".getTarget().getElement());";
  protected final String TEXT_806 = NL + "\t\t\t\treturn ";
  protected final String TEXT_807 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_808 = ".getSource().getElement(), ";
  protected final String TEXT_809 = ".eINSTANCE.get";
  protected final String TEXT_810 = "(), ";
  protected final String TEXT_811 = ".UNSET_VALUE);";
  protected final String TEXT_812 = NL + "\t\t\t}";
  protected final String TEXT_813 = NL + "\t}" + NL;
  protected final String TEXT_814 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_815 = "StartCommand extends ";
  protected final String TEXT_816 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_817 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_818 = "StartCommand(";
  protected final String TEXT_819 = " requestEx) {" + NL + "\t\t\t//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart()." + NL + "\t\t\tsource = (";
  protected final String TEXT_820 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\tif (source == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_821 = NL + "\t\t\treturn false;";
  protected final String TEXT_822 = NL + "\t\t\t";
  protected final String TEXT_823 = " container = (";
  protected final String TEXT_824 = ")getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_825 = ".eINSTANCE.get";
  protected final String TEXT_826 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_827 = NL;
  protected final String TEXT_828 = NL + "\t\tif (";
  protected final String TEXT_829 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_830 = NL + "\t\t}";
  protected final String TEXT_831 = NL + "\t\tif (";
  protected final String TEXT_832 = ".size() >= ";
  protected final String TEXT_833 = ".eINSTANCE.get";
  protected final String TEXT_834 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_835 = NL + "\t\t}";
  protected final String TEXT_836 = NL;
  protected final String TEXT_837 = NL + "\t\tif (";
  protected final String TEXT_838 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_839 = NL + "\t\t}";
  protected final String TEXT_840 = NL + "\t\tif (";
  protected final String TEXT_841 = ".size() >= ";
  protected final String TEXT_842 = ".eINSTANCE.get";
  protected final String TEXT_843 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_844 = NL + "\t\t}";
  protected final String TEXT_845 = NL;
  protected final String TEXT_846 = NL + "\t\t\tif(!";
  protected final String TEXT_847 = ".canCreateLink(";
  protected final String TEXT_848 = ", ";
  protected final String TEXT_849 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_850 = NL + "\t\t\treturn true;";
  protected final String TEXT_851 = NL;
  protected final String TEXT_852 = NL + "\t\tif (";
  protected final String TEXT_853 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_854 = NL + "\t\t}";
  protected final String TEXT_855 = NL + "\t\tif (";
  protected final String TEXT_856 = ".size() >= ";
  protected final String TEXT_857 = ".eINSTANCE.get";
  protected final String TEXT_858 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_859 = NL + "\t\t}";
  protected final String TEXT_860 = NL;
  protected final String TEXT_861 = NL + "\t\t\tif(!";
  protected final String TEXT_862 = ".canCreateLink(";
  protected final String TEXT_863 = ", ";
  protected final String TEXT_864 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_865 = NL + "\t\t\treturn true;";
  protected final String TEXT_866 = NL + "\t\t\treturn false;";
  protected final String TEXT_867 = NL + "\t\t}";
  protected final String TEXT_868 = NL;
  protected final String TEXT_869 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_870 = " getRelationshipContainer(";
  protected final String TEXT_871 = " element, ";
  protected final String TEXT_872 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_873 = NL + NL + "\t}";
  protected final String TEXT_874 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_875 = "TargetCommand extends ";
  protected final String TEXT_876 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_877 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_878 = " newTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_879 = " oldTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_880 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_881 = "TargetCommand(";
  protected final String TEXT_882 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_883 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_884 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_885 = "TargetCommand(";
  protected final String TEXT_886 = " edge, ";
  protected final String TEXT_887 = " newTarget) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newTarget = newTarget;" + NL + "\t\t\tthis.oldTarget = edge.getTarget();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_888 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_889 = " domainModelEditDomain = ";
  protected final String TEXT_890 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_891 = " command = new ";
  protected final String TEXT_892 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_893 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew ";
  protected final String TEXT_894 = "(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_895 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_896 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_897 = NL;
  protected final String TEXT_898 = NL + "\t\t\tif(!";
  protected final String TEXT_899 = ".canCreateLink(";
  protected final String TEXT_900 = ", ";
  protected final String TEXT_901 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_902 = NL + "\t\t\treturn true;";
  protected final String TEXT_903 = NL;
  protected final String TEXT_904 = NL + "\t\t\tif(!";
  protected final String TEXT_905 = ".canCreateLink(";
  protected final String TEXT_906 = ", ";
  protected final String TEXT_907 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_908 = NL + "\t\t\treturn true;";
  protected final String TEXT_909 = NL + "\t\t\treturn false;";
  protected final String TEXT_910 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_911 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_912 = " editingDomain = ";
  protected final String TEXT_913 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_914 = " result = new ";
  protected final String TEXT_915 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_916 = "(edge, newTarget));";
  protected final String TEXT_917 = NL + "\t\t\tresult.append(";
  protected final String TEXT_918 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_919 = ".eINSTANCE.get";
  protected final String TEXT_920 = "()," + NL + "\t\t\t\toldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_921 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_922 = ".eINSTANCE.get";
  protected final String TEXT_923 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_924 = NL + "\t\t\tresult.append(";
  protected final String TEXT_925 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_926 = ".eINSTANCE.get";
  protected final String TEXT_927 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_928 = NL + "\t\t\tresult.append(";
  protected final String TEXT_929 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_930 = ".eINSTANCE.get";
  protected final String TEXT_931 = "(), oldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_932 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_933 = ".eINSTANCE.get";
  protected final String TEXT_934 = "(), newTarget.getElement()));";
  protected final String TEXT_935 = NL + "\t\t\tresult.append(";
  protected final String TEXT_936 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_937 = ".eINSTANCE.get";
  protected final String TEXT_938 = "(), newTarget.getElement()));";
  protected final String TEXT_939 = NL + "\t\t\treturn result;" + NL + "\t\t}";
  protected final String TEXT_940 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_941 = NL;
  protected final String TEXT_942 = NL + "\t\t\tprivate ";
  protected final String TEXT_943 = " createDomainModelRemoveCommand(";
  protected final String TEXT_944 = " editingDomain) {";
  protected final String TEXT_945 = NL + "\t\t\t\t";
  protected final String TEXT_946 = " result = new ";
  protected final String TEXT_947 = "();";
  protected final String TEXT_948 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_949 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_950 = ".getElement().eContainer(), ";
  protected final String TEXT_951 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_952 = ".getElement()));";
  protected final String TEXT_953 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_954 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_955 = ".getElement().eContainer(), ";
  protected final String TEXT_956 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_957 = ".UNSET_VALUE));";
  protected final String TEXT_958 = NL + "\t\t\t\treturn ";
  protected final String TEXT_959 = ".INSTANCE;";
  protected final String TEXT_960 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_961 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_962 = ".getElement().eContainer(), ";
  protected final String TEXT_963 = ".eINSTANCE.get";
  protected final String TEXT_964 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_965 = ".getElement()));";
  protected final String TEXT_966 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_967 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_968 = ".getElement().eContainer(), ";
  protected final String TEXT_969 = ".eINSTANCE.get";
  protected final String TEXT_970 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_971 = ".UNSET_VALUE));";
  protected final String TEXT_972 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_973 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_974 = ".getElement(), ";
  protected final String TEXT_975 = ".eINSTANCE.get";
  protected final String TEXT_976 = "(), ";
  protected final String TEXT_977 = ".getSource().getElement()));";
  protected final String TEXT_978 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_979 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_980 = ".getElement(), ";
  protected final String TEXT_981 = ".eINSTANCE.get";
  protected final String TEXT_982 = "(), ";
  protected final String TEXT_983 = ".UNSET_VALUE));";
  protected final String TEXT_984 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_985 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_986 = ".getElement(), ";
  protected final String TEXT_987 = ".eINSTANCE.get";
  protected final String TEXT_988 = "(), ";
  protected final String TEXT_989 = ".getTarget().getElement()));";
  protected final String TEXT_990 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_991 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_992 = ".getElement(), ";
  protected final String TEXT_993 = ".eINSTANCE.get";
  protected final String TEXT_994 = "(), ";
  protected final String TEXT_995 = ".UNSET_VALUE));";
  protected final String TEXT_996 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_997 = NL + "\t\t\t\treturn ";
  protected final String TEXT_998 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_999 = ".getSource().getElement(), ";
  protected final String TEXT_1000 = ".eINSTANCE.get";
  protected final String TEXT_1001 = "(), ";
  protected final String TEXT_1002 = ".getTarget().getElement());";
  protected final String TEXT_1003 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1004 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1005 = ".getSource().getElement(), ";
  protected final String TEXT_1006 = ".eINSTANCE.get";
  protected final String TEXT_1007 = "(), ";
  protected final String TEXT_1008 = ".UNSET_VALUE);";
  protected final String TEXT_1009 = NL + "\t\t\t}";
  protected final String TEXT_1010 = NL + "\t}" + NL;
  protected final String TEXT_1011 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_1012 = "Command extends ";
  protected final String TEXT_1013 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1014 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1015 = " target;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1016 = " createdEdge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_1017 = "Command(";
  protected final String TEXT_1018 = " requestEx) {" + NL + "\t\t\tif (requestEx.getSourceEditPart().getModel() instanceof ";
  protected final String TEXT_1019 = ") {" + NL + "\t\t\t\tsource = (";
  protected final String TEXT_1020 = ")requestEx.getSourceEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tsource = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (requestEx.getTargetEditPart().getModel() instanceof ";
  protected final String TEXT_1021 = ") {" + NL + "\t\t\t\ttarget = (";
  protected final String TEXT_1022 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (source == null || target == null) {" + NL + "\t\t\t\tcreatedEdge = null;" + NL + "\t\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1023 = ".INSTANCE;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedEdge = ";
  protected final String TEXT_1024 = ".eINSTANCE.createEdge();";
  protected final String TEXT_1025 = NL + "\t\t\t";
  protected final String TEXT_1026 = " createdDomainElement = ";
  protected final String TEXT_1027 = ".eINSTANCE.create";
  protected final String TEXT_1028 = "();" + NL + "\t\t\tcreatedEdge.setElement(";
  protected final String TEXT_1029 = "(";
  protected final String TEXT_1030 = ") ";
  protected final String TEXT_1031 = "createdDomainElement);" + NL + "\t\t\t";
  protected final String TEXT_1032 = NL + "\t\t\t";
  protected final String TEXT_1033 = ".";
  protected final String TEXT_1034 = ".initializeElement(";
  protected final String TEXT_1035 = "(";
  protected final String TEXT_1036 = ") ";
  protected final String TEXT_1037 = "createdDomainElement);";
  protected final String TEXT_1038 = NL + "\t\t\tcreatedEdge.setElement(null);";
  protected final String TEXT_1039 = NL + "\t\t\t";
  protected final String TEXT_1040 = ".decorateView(createdEdge);" + NL + "\t\t\t";
  protected final String TEXT_1041 = " domainModelEditDomain = ";
  protected final String TEXT_1042 = ".getEditingDomain(source.getDiagram().getElement());";
  protected final String TEXT_1043 = NL + "\t\t\torg.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();";
  protected final String TEXT_1044 = NL + "\t\t\t";
  protected final String TEXT_1045 = " container = getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_1046 = ".eINSTANCE.get";
  protected final String TEXT_1047 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\tdomainModelAddCommand = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1048 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1049 = ".eINSTANCE.get";
  protected final String TEXT_1050 = "(), createdDomainElement));";
  protected final String TEXT_1051 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1052 = ".create(domainModelEditDomain," + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1053 = ".eINSTANCE.get";
  protected final String TEXT_1054 = "(), createdDomainElement));";
  protected final String TEXT_1055 = NL;
  protected final String TEXT_1056 = NL + "\t\tif (";
  protected final String TEXT_1057 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1058 = NL + "\t\t}";
  protected final String TEXT_1059 = NL + "\t\tif (";
  protected final String TEXT_1060 = ".size() >= ";
  protected final String TEXT_1061 = ".eINSTANCE.get";
  protected final String TEXT_1062 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1063 = NL + "\t\t}";
  protected final String TEXT_1064 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1065 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1066 = ".eINSTANCE.get";
  protected final String TEXT_1067 = "(), source.getElement()));";
  protected final String TEXT_1068 = NL;
  protected final String TEXT_1069 = NL + "\t\tif (";
  protected final String TEXT_1070 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_1071 = NL + "\t\t}";
  protected final String TEXT_1072 = NL + "\t\tif (";
  protected final String TEXT_1073 = ".size() >= ";
  protected final String TEXT_1074 = ".eINSTANCE.get";
  protected final String TEXT_1075 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1076 = NL + "\t\t}";
  protected final String TEXT_1077 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1078 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1079 = ".eINSTANCE.get";
  protected final String TEXT_1080 = "(), target.getElement()));";
  protected final String TEXT_1081 = NL + "\t\tdomainModelAddCommand = addLinkEndsCommand;";
  protected final String TEXT_1082 = NL + "\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1083 = ".create(domainModelEditDomain, source.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1084 = ".eINSTANCE.get";
  protected final String TEXT_1085 = "(), target.getElement());";
  protected final String TEXT_1086 = NL + "\t\t}" + NL;
  protected final String TEXT_1087 = NL;
  protected final String TEXT_1088 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1089 = " getRelationshipContainer(";
  protected final String TEXT_1090 = " element, ";
  protected final String TEXT_1091 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1092 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (source == null || target == null || createdEdge == null || domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1093 = NL;
  protected final String TEXT_1094 = NL + "\t\t\tif(!";
  protected final String TEXT_1095 = ".canCreateLink(";
  protected final String TEXT_1096 = ", ";
  protected final String TEXT_1097 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1098 = NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tsource.getDiagram().insertEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(source);" + NL + "\t\t\tcreatedEdge.setTarget(target);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t\tsource.getDiagram().removeEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(null);" + NL + "\t\t\tcreatedEdge.setTarget(null);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_1099 = NL;
  protected final String TEXT_1100 = NL;
  protected final String TEXT_1101 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_1102 = NL + "}";
  protected final String TEXT_1103 = NL;

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
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_54);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_57);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_61);
    
	} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_66);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_70);
    
	} else {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_75);
    
	}

    stringBuffer.append(TEXT_76);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_80);
    
	} else {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_85);
    
	}
}

    stringBuffer.append(TEXT_86);
    
}	/*restrict local vars used in component edit policy*/

    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_108);
    
if (!myHelper.hasIncomingLinks()) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_110);
    
} else {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_121);
    
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

    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_124);
    
	}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_128);
    
}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_131);
    
if (!myHelper.hasOutgoingLinks()) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_133);
    
} else {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_144);
    
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

    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_147);
    
	}

    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_151);
    
}

    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_154);
    if (palette != null && myHelper.hasOutgoingLinks()) {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_160);
    
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

    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_163);
    
}

    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_167);
    }/*when there's palette*/
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_170);
    if (palette != null && myHelper.hasIncomingLinks()) {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_177);
    
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

    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_180);
    
}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_184);
    }/*when there's palette*/
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_186);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_187);
    
}

    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_195);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_197);
    if (isXYLayout) {
    stringBuffer.append(TEXT_198);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_199);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_201);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_202);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_204);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_225);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_226);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_228);
    } else {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_232);
    }
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_236);
    
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_238);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_239);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_243);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_244);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_248);
    	
} // for pinned compartments

    stringBuffer.append(TEXT_249);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_250);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_254);
    
} // for pinned compartments

    stringBuffer.append(TEXT_255);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_257);
    
		GenNodeLabel firstEditableLabel = null;
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (!genLabel.isReadOnly()) {
				firstEditableLabel = genLabel;
				break;
			}
		}
		if (firstEditableLabel != null) {

    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName(firstEditableLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_264);
    
		}

    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_276);
    
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_278);
    
		}

    stringBuffer.append(TEXT_279);
    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_281);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_283);
    
	}

    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_288);
    
}
if (myHelper.hasExternalLabels() || myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_290);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_293);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_294);
    
	}

    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_296);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_299);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_300);
    
	}

    stringBuffer.append(TEXT_301);
    
}

    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_306);
    
}

    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_328);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_329);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_330);
    
}

    stringBuffer.append(TEXT_331);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_332);
    
}

    stringBuffer.append(TEXT_333);
    
{
	final String _getViewCode = "getDiagramNode()";
	final String _getDiagramCode = "getDiagramNode().getDiagram()";
	final boolean _includeUncontainedLinks = false;

    stringBuffer.append(TEXT_334);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService"));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.OwnedLinksNotationModelRefresher"));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_343);
    
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

    stringBuffer.append(TEXT_344);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_347);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_357);
    
	}

    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_359);
    
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

    stringBuffer.append(TEXT_360);
    
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

    stringBuffer.append(TEXT_361);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_365);
    
	} else {

    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_369);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_370);
    
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

    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_375);
    
	} else {

    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_379);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_380);
    
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

    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_385);
    
	} else {

    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_389);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_390);
    
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

    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_395);
    
	} else {

    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_399);
    
	}

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_400);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_401);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_402);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_403);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_405);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_406);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_408);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_417);
    
	for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_418);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_421);
    
	}
	for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_424);
    
	}

    stringBuffer.append(TEXT_425);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_431);
    
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

    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_435);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_436);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_437);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_438);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_440);
    
	} else {

    stringBuffer.append(TEXT_441);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_442);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_443);
    
	}

    stringBuffer.append(TEXT_444);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_445);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_446);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_447);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_448);
    
		} else {

    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_450);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_451);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_453);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_454);
    
		} else {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_457);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_458);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_460);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_461);
    
		} else {

    stringBuffer.append(TEXT_462);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_464);
    
		}

    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_466);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_467);
    
		} else {

    stringBuffer.append(TEXT_468);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_469);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_470);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_471);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_472);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_474);
    
	} else {

    stringBuffer.append(TEXT_475);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_476);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_477);
    
	}

    stringBuffer.append(TEXT_478);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_479);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_481);
    
	}

    stringBuffer.append(TEXT_482);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_483);
    
	}
}

    stringBuffer.append(TEXT_484);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_486);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_487);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_492);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_493);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_495);
    
	}
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_496);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_498);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_499);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_500);
    
		}

    stringBuffer.append(TEXT_501);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_502);
    
		} else {

    stringBuffer.append(TEXT_503);
    
		}
	}
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_504);
    
		}

    stringBuffer.append(TEXT_505);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_507);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_508);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_509);
    
		}

    stringBuffer.append(TEXT_510);
    
	}

    stringBuffer.append(TEXT_511);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_512);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_514);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_517);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_522);
    
}

    
}	//end of local declarations

    stringBuffer.append(TEXT_523);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_532);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_533);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_534);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_535);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_536);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_541);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_545);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_546);
    
}

    stringBuffer.append(TEXT_547);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_548);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_549);
    
}

    stringBuffer.append(TEXT_550);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_553);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_561);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_565);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_566);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_567);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_578);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_591);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_604);
    
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

    stringBuffer.append(TEXT_605);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_606);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_612);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_613);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_614);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_618);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_619);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_623);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_624);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_625);
    
	} else {

    stringBuffer.append(TEXT_626);
    
	}

    stringBuffer.append(TEXT_627);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_628);
    
			} else {

    stringBuffer.append(TEXT_629);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_630);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_631);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_633);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_634);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_635);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_637);
    
	} else {

    stringBuffer.append(TEXT_638);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_640);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_641);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_642);
    
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

    stringBuffer.append(TEXT_643);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_644);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_646);
    
	} else {

    stringBuffer.append(TEXT_647);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_649);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_650);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_651);
    
	}
}

    
					}
				}
			}
			//No need to check the size of the source or target features: their size does not change
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_652);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_653);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_654);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_656);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_657);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			{
				GenFeature _feature = metaFeature;
				String _ownerInstance = "newSource.getElement()";
				String _exceedsUpperBound = "return false;";
				GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_658);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_659);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_661);
    
	} else {

    stringBuffer.append(TEXT_662);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_665);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_666);
    
	}
}

    
			}
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_667);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_668);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_669);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_671);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_672);
    
		} else {

    stringBuffer.append(TEXT_673);
    
		}

    stringBuffer.append(TEXT_674);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_680);
    
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

    stringBuffer.append(TEXT_681);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_683);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_684);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_686);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_687);
    
			}
			if (containmentFeature != null) {
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_688);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_689);
    
				} else {

    stringBuffer.append(TEXT_690);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_692);
    
				}

    stringBuffer.append(TEXT_693);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_694);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_695);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_696);
    
			}
			if (setChild) {
				if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_697);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_700);
    
				} else {

    stringBuffer.append(TEXT_701);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_702);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_704);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_705);
    
				}

    stringBuffer.append(TEXT_706);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_708);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_709);
    
			}

    stringBuffer.append(TEXT_710);
    
			if (setSource) {
				if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_711);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_712);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_714);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_716);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_717);
    
				} else {

    stringBuffer.append(TEXT_718);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_721);
    
				}
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_722);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_723);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_725);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_728);
    
			} else {

    stringBuffer.append(TEXT_729);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_732);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_736);
    
			}
		}

    stringBuffer.append(TEXT_737);
    stringBuffer.append(TEXT_738);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_739);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_742);
    
		}

    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_743);
    stringBuffer.append(TEXT_744);
    
	//input: _edge : String

    stringBuffer.append(TEXT_745);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_746);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_747);
    
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

    stringBuffer.append(TEXT_748);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_750);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_751);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_755);
    
			} else {

    stringBuffer.append(TEXT_756);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_760);
    
			}
		} else {

    stringBuffer.append(TEXT_761);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_762);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_763);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_765);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_767);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_768);
    
			} else {

    stringBuffer.append(TEXT_769);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_771);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_773);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_774);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_775);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_777);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_779);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_780);
    
			} else {

    stringBuffer.append(TEXT_781);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_785);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_786);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_787);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_791);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_792);
    
			} else {

    stringBuffer.append(TEXT_793);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_795);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_797);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_798);
    
			}
		}

    stringBuffer.append(TEXT_799);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_800);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_804);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_805);
    
		} else {

    stringBuffer.append(TEXT_806);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_810);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_811);
    
		}

    
	}

    stringBuffer.append(TEXT_812);
    
	}

    stringBuffer.append(TEXT_813);
    
	if (palette != null) {

    stringBuffer.append(TEXT_814);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_815);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_818);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_819);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_820);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_821);
    
			} else {

    stringBuffer.append(TEXT_822);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_823);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_825);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_826);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";
					GenClass _ownerGenClass = containmentFeature.getGenClass();

    stringBuffer.append(TEXT_827);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_828);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_830);
    
	} else {

    stringBuffer.append(TEXT_831);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_834);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_835);
    
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

    stringBuffer.append(TEXT_836);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_837);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_839);
    
	} else {

    stringBuffer.append(TEXT_840);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_841);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_843);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_844);
    
	}
}

    
					}
				}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_845);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_846);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_847);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_849);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_850);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		{
			GenFeature _feature = metaFeature;
			String _ownerInstance = "source.getElement()";
			String _exceedsUpperBound = "return false;";
			GenClass _ownerGenClass = null;

    stringBuffer.append(TEXT_851);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_852);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_854);
    
	} else {

    stringBuffer.append(TEXT_855);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_856);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_859);
    
	}
}

    
		}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_860);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_861);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_862);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_864);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_865);
    
		} else {

    stringBuffer.append(TEXT_866);
    
		}

    stringBuffer.append(TEXT_867);
    stringBuffer.append(TEXT_868);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_869);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_870);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_871);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_872);
    
		}

    stringBuffer.append(TEXT_873);
    
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

    stringBuffer.append(TEXT_874);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_875);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_876);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_877);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_878);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_879);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_881);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_884);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_885);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_886);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_887);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_888);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_889);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_890);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_891);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_892);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_894);
    
	} else {

    stringBuffer.append(TEXT_895);
    
	}

    stringBuffer.append(TEXT_896);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_897);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_898);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_899);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_901);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_902);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_903);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_904);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_905);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_907);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_908);
    
		} else {

    stringBuffer.append(TEXT_909);
    
		}

    stringBuffer.append(TEXT_910);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_912);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_913);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_914);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_915);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_916);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_917);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_919);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_920);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_923);
    
			} else {

    stringBuffer.append(TEXT_924);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_926);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_927);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_928);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_929);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_931);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_934);
    
			} else {

    stringBuffer.append(TEXT_935);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_938);
    
			}
		}

    stringBuffer.append(TEXT_939);
    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_940);
    stringBuffer.append(TEXT_941);
    
	//input: _edge : String

    stringBuffer.append(TEXT_942);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_944);
    
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

    stringBuffer.append(TEXT_945);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_947);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_948);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_949);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_950);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_951);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_952);
    
			} else {

    stringBuffer.append(TEXT_953);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_955);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_957);
    
			}
		} else {

    stringBuffer.append(TEXT_958);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_959);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_960);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_961);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_962);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_963);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_964);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_965);
    
			} else {

    stringBuffer.append(TEXT_966);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_970);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_971);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_972);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_976);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_977);
    
			} else {

    stringBuffer.append(TEXT_978);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_982);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_983);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_984);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_988);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_989);
    
			} else {

    stringBuffer.append(TEXT_990);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_992);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_993);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_994);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_995);
    
			}
		}

    stringBuffer.append(TEXT_996);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_997);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_999);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1002);
    
		} else {

    stringBuffer.append(TEXT_1003);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1008);
    
		}

    
	}

    stringBuffer.append(TEXT_1009);
    
	}

    stringBuffer.append(TEXT_1010);
    
	if (palette != null) {

    stringBuffer.append(TEXT_1011);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_1024);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenClass linkClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1025);
    stringBuffer.append(importManager.getImportedName(importManager.getImportedName(linkClass.getQualifiedInterfaceName())));
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(importManager.getImportedName(linkClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(linkClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_1028);
    if (linkClass.isExternalInterface()) {
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1030);
    }
    stringBuffer.append(TEXT_1031);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_1034);
    if (linkClass.isExternalInterface()) {
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1036);
    }
    stringBuffer.append(TEXT_1037);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_1038);
    
		}

    stringBuffer.append(TEXT_1039);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1042);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1043);
    
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

    stringBuffer.append(TEXT_1044);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1050);
    
			}
			if (addChild) {

    stringBuffer.append(TEXT_1051);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1054);
    
			}
			if (addSource) {
				{
					GenFeature _feature = sourceFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1055);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1056);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, false);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1058);
    
	} else {

    stringBuffer.append(TEXT_1059);
    myFeatureGetAccessorHelper.appendFeatureValueGetter(_ownerInstance, _feature, _ownerGenClass, true);
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1063);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1064);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1067);
    
			}
			if (addTarget) {
				{
					GenFeature _feature = targetFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";
					GenClass _ownerGenClass = modelFacet.getMetaClass();

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

    stringBuffer.append(TEXT_1077);
    stringBuffer.append(importManager.getImportedName(targetFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1080);
    
			}

    stringBuffer.append(TEXT_1081);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_1082);
    stringBuffer.append(importManager.getImportedName(metaFeature.getEcoreFeature().isMany()? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1085);
    
		}

    stringBuffer.append(TEXT_1086);
    stringBuffer.append(TEXT_1087);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1088);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1091);
    
		}

    stringBuffer.append(TEXT_1092);
    
{
	String _source = "source.getElement()";
	String _target = "target.getElement()";

    stringBuffer.append(TEXT_1093);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1094);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1097);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1098);
    
	}

    }/*when there's palette*/
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_1099);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_1100);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_1101);
    
}

    
}

    stringBuffer.append(TEXT_1102);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_1103);
    return stringBuffer.toString();
  }
}
