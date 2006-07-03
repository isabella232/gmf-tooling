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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " implements ";
  protected final String TEXT_8 = ", IUpdatableEditPart {";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_13 = " contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_14 = " primaryShape;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = " model) {" + NL + "\t\tassert model instanceof ";
  protected final String TEXT_17 = ";" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = "\t\tinstallEditPolicy(";
  protected final String TEXT_20 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_21 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_22 = " createDeleteCommand(";
  protected final String TEXT_23 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_24 = " editingDomain = ";
  protected final String TEXT_25 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_26 = " cc = new ";
  protected final String TEXT_27 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_28 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new WrappingCommand(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_29 = " editingDomain) {";
  protected final String TEXT_30 = NL + "\t\t\t\t";
  protected final String TEXT_31 = " result = new ";
  protected final String TEXT_32 = "();";
  protected final String TEXT_33 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_34 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_35 = ".eINSTANCE.get";
  protected final String TEXT_36 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_37 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_38 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_39 = ".eINSTANCE.get";
  protected final String TEXT_40 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = ".UNSET_VALUE));";
  protected final String TEXT_42 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_43 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_44 = ".eINSTANCE.get";
  protected final String TEXT_45 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_46 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_47 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_48 = ".eINSTANCE.get";
  protected final String TEXT_49 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = ".UNSET_VALUE));";
  protected final String TEXT_51 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_52 = NL + "\t\t\t\treturn ";
  protected final String TEXT_53 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_54 = ".eINSTANCE.get";
  protected final String TEXT_55 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_56 = NL + "\t\t\t\treturn ";
  protected final String TEXT_57 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_58 = ".eINSTANCE.get";
  protected final String TEXT_59 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = ".UNSET_VALUE);";
  protected final String TEXT_61 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_62 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_63 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_64 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_65 = " getCreateCommand(";
  protected final String TEXT_66 = " request) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_67 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_68 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_69 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_70 = " createChangeConstraintCommand(";
  protected final String TEXT_71 = " child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_72 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_73 = " createChildEditPolicy(";
  protected final String TEXT_74 = " child) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_75 = "() {" + NL + "\t\t\t\t\tpublic ";
  protected final String TEXT_76 = " getTargetEditPart(";
  protected final String TEXT_77 = " request) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_78 = ".REQ_SELECTION.equals(request.getType())) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_79 = ".this;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_80 = ".GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_81 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_82 = " getReconnectTargetCommand(";
  protected final String TEXT_83 = " request) {";
  protected final String TEXT_84 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_85 = ".INSTANCE;";
  protected final String TEXT_86 = NL + "\t\t\t\t";
  protected final String TEXT_87 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_88 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_89 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_90 = " edge = (";
  protected final String TEXT_91 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_92 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_93 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_94 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_95 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_96 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_97 = NL + "\t\t\t\tcase ";
  protected final String TEXT_98 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_99 = "TargetCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_100 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_101 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_102 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_103 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_104 = " getReconnectSourceCommand(";
  protected final String TEXT_105 = " request) {";
  protected final String TEXT_106 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_107 = ".INSTANCE;";
  protected final String TEXT_108 = NL + "\t\t\t\t";
  protected final String TEXT_109 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_110 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_111 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_112 = " edge = (";
  protected final String TEXT_113 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_114 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_115 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_116 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_117 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_118 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_119 = NL + "\t\t\t\tcase ";
  protected final String TEXT_120 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_121 = "SourceCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_122 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_123 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_124 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_125 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_126 = " getConnectionCreateCommand(";
  protected final String TEXT_127 = " request) {";
  protected final String TEXT_128 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_129 = ".CreateConnectionRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_130 = ".CreateConnectionRequestEx requestEx = (";
  protected final String TEXT_131 = ".CreateConnectionRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_132 = " result = new ";
  protected final String TEXT_133 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_134 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_135 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_136 = "StartCommand(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = " wrappedResult = new WrappingCommand(";
  protected final String TEXT_139 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_140 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_141 = " getConnectionCompleteCommand(";
  protected final String TEXT_142 = " request) {";
  protected final String TEXT_143 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_144 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_145 = ".CreateConnectionRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_146 = ".CreateConnectionRequestEx requestEx = (";
  protected final String TEXT_147 = ".CreateConnectionRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = " result = new ";
  protected final String TEXT_149 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_151 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_152 = "Command(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_154 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_155 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_156 = NL + "\t\t\t\treturn ";
  protected final String TEXT_157 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_158 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_159 = " invisibleRectangle = new ";
  protected final String TEXT_160 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_161 = "());" + NL + "\t\t";
  protected final String TEXT_162 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_163 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_164 = " createNodeShape() {";
  protected final String TEXT_165 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_166 = "()";
  protected final String TEXT_167 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_168 = ";";
  protected final String TEXT_169 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_170 = ";";
  protected final String TEXT_171 = NL + "\t\t";
  protected final String TEXT_172 = " figure = new ";
  protected final String TEXT_173 = "();";
  protected final String TEXT_174 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_175 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_176 = NL + "\t\treturn primaryShape;" + NL + "\t}";
  protected final String TEXT_177 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_178 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_179 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_180 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_181 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_182 = " view = (";
  protected final String TEXT_183 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_184 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_185 = " decorationPane = new ";
  protected final String TEXT_186 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_187 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_188 = " imageFigure = new ";
  protected final String TEXT_189 = "(";
  protected final String TEXT_190 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_191 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_192 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_193 = " setupContentPane(";
  protected final String TEXT_194 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_195 = NL + "\t\t\t";
  protected final String TEXT_196 = " layout = new ";
  protected final String TEXT_197 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_198 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_199 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_200 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_201 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_202 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_203 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_204 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_205 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_206 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_207 = " childEditPart) {";
  protected final String TEXT_208 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_209 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_210 = ") childEditPart).";
  protected final String TEXT_211 = "(getPrimaryShape().";
  protected final String TEXT_212 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_213 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_214 = ") {" + NL + "\t\t\t";
  protected final String TEXT_215 = " pane = getPrimaryShape().";
  protected final String TEXT_216 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_217 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_218 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_219 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_220 = ") {" + NL + "\t\t\t";
  protected final String TEXT_221 = " pane = getPrimaryShape().";
  protected final String TEXT_222 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_223 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_224 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_225 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_226 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_227 = NL + "\t\tfor(";
  protected final String TEXT_228 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_229 = " nextChild = (";
  protected final String TEXT_230 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_231 = ".getVisualID(nextChild) == ";
  protected final String TEXT_232 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_233 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_234 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_235 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_236 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_237 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_238 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_239 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_240 = " getLabelEditPart(";
  protected final String TEXT_241 = " req) {" + NL + "\t\t";
  protected final String TEXT_242 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_243 = " view = (";
  protected final String TEXT_244 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_245 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_246 = NL + "\t\t\t\tcase ";
  protected final String TEXT_247 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_248 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_249 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_250 = " childEditPart) {";
  protected final String TEXT_251 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_252 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_253 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_254 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_255 = " root = (";
  protected final String TEXT_256 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_257 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_258 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_259 = " childEditPart, int index) {";
  protected final String TEXT_260 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_261 = " labelFigure = ((";
  protected final String TEXT_262 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_263 = NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_264 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_265 = " childEditPart) {";
  protected final String TEXT_266 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_267 = " labelFigure = ((";
  protected final String TEXT_268 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_269 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_270 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_271 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_272 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_273 = " childEditPart = (";
  protected final String TEXT_274 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_275 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_276 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_277 = " node = getDiagramNode();" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_278 = ";" + NL + "\t\t";
  protected final String TEXT_279 = " bounds = (";
  protected final String TEXT_280 = ") node.getLayoutConstraint();" + NL + "\t\t((";
  protected final String TEXT_281 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_282 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_283 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_284 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_285 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_286 = " getSourceConnectionAnchor(";
  protected final String TEXT_287 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_288 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_289 = " getSourceConnectionAnchor(";
  protected final String TEXT_290 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_291 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_292 = "  getTargetConnectionAnchor(";
  protected final String TEXT_293 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_294 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_295 = "  getTargetConnectionAnchor(";
  protected final String TEXT_296 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_297 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_298 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_299 = NL;
  protected final String TEXT_300 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_301 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_302 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_303 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_304 = NL;
  protected final String TEXT_305 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_306 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_307 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_308 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_309 = NL;
  protected final String TEXT_310 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_311 = NL + "\t\t";
  protected final String TEXT_312 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_313 = ") ";
  protected final String TEXT_314 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_315 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_316 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_317 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_318 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_319 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_320 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_321 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_322 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_323 = "\t" + NL + "\t}";
  protected final String TEXT_324 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_325 = " createdFont;";
  protected final String TEXT_326 = "\t" + NL;
  protected final String TEXT_327 = NL;
  protected final String TEXT_328 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_329 = " style = (";
  protected final String TEXT_330 = ")  ";
  protected final String TEXT_331 = ".getStyle(";
  protected final String TEXT_332 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_333 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_334 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_335 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_336 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_337 = " style = (";
  protected final String TEXT_338 = ")  ";
  protected final String TEXT_339 = ".getStyle(";
  protected final String TEXT_340 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_341 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_342 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_343 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_344 = " createdBackgroundColor;" + NL;
  protected final String TEXT_345 = NL;
  protected final String TEXT_346 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_347 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_348 = " feature, ";
  protected final String TEXT_349 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_350 = "();";
  protected final String TEXT_351 = NL;
  protected final String TEXT_352 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_353 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_354 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_355 = NL;
  protected final String TEXT_356 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_357 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_358 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_359 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_360 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_361 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_362 = NL;
  protected final String TEXT_363 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_364 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_365 = NL;
  protected final String TEXT_366 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_367 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_368 = NL;
  protected final String TEXT_369 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_370 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_371 = NL;
  protected final String TEXT_372 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_373 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_374 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_375 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_376 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_377 = NL;
  protected final String TEXT_378 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_379 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_380 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_381 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_382 = "SourceCommand extends ";
  protected final String TEXT_383 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_384 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_385 = " newSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_386 = " oldSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_387 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_388 = "SourceCommand(";
  protected final String TEXT_389 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_390 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_391 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_392 = "SourceCommand(";
  protected final String TEXT_393 = " edge, ";
  protected final String TEXT_394 = " newSource) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newSource = newSource;" + NL + "\t\t\tthis.oldSource = edge.getSource();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_395 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_396 = " domainModelEditDomain = ";
  protected final String TEXT_397 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_398 = " command = new ";
  protected final String TEXT_399 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_400 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew WrappingCommand(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_401 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_402 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_403 = NL + "\t\t\treturn false;";
  protected final String TEXT_404 = NL + "\t\t\t";
  protected final String TEXT_405 = " container = (";
  protected final String TEXT_406 = ")getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_407 = ".eINSTANCE.get";
  protected final String TEXT_408 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_409 = NL;
  protected final String TEXT_410 = NL + "\t\tif (";
  protected final String TEXT_411 = ".";
  protected final String TEXT_412 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_413 = NL + "\t\t}";
  protected final String TEXT_414 = NL + "\t\tif (";
  protected final String TEXT_415 = ".";
  protected final String TEXT_416 = "().size() >= ";
  protected final String TEXT_417 = ".eINSTANCE.get";
  protected final String TEXT_418 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_419 = NL + "\t\t}";
  protected final String TEXT_420 = NL;
  protected final String TEXT_421 = NL + "\t\tif (";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_424 = NL + "\t\t}";
  protected final String TEXT_425 = NL + "\t\tif (";
  protected final String TEXT_426 = ".";
  protected final String TEXT_427 = "().size() >= ";
  protected final String TEXT_428 = ".eINSTANCE.get";
  protected final String TEXT_429 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_430 = NL + "\t\t}";
  protected final String TEXT_431 = NL;
  protected final String TEXT_432 = NL + "\t\t\tif(!";
  protected final String TEXT_433 = ".canCreateLink(";
  protected final String TEXT_434 = ", ";
  protected final String TEXT_435 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_436 = NL + "\t\t\treturn true;";
  protected final String TEXT_437 = NL;
  protected final String TEXT_438 = NL + "\t\tif (";
  protected final String TEXT_439 = ".";
  protected final String TEXT_440 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_441 = NL + "\t\t}";
  protected final String TEXT_442 = NL + "\t\tif (";
  protected final String TEXT_443 = ".";
  protected final String TEXT_444 = "().size() >= ";
  protected final String TEXT_445 = ".eINSTANCE.get";
  protected final String TEXT_446 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_447 = NL + "\t\t}";
  protected final String TEXT_448 = NL;
  protected final String TEXT_449 = NL + "\t\t\tif(!";
  protected final String TEXT_450 = ".canCreateLink(";
  protected final String TEXT_451 = ", ";
  protected final String TEXT_452 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_453 = NL + "\t\t\treturn true;";
  protected final String TEXT_454 = NL + "\t\t\treturn false;";
  protected final String TEXT_455 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_456 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_457 = " editingDomain = ";
  protected final String TEXT_458 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_459 = " result = new ";
  protected final String TEXT_460 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_461 = "(edge, newSource));";
  protected final String TEXT_462 = NL + "\t\t\t";
  protected final String TEXT_463 = " container = getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_464 = ".eINSTANCE.get";
  protected final String TEXT_465 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_466 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_467 = " oldContainer = edge.getElement().eContainer();" + NL + "\t\t\tif (oldContainer == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_468 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tif (oldContainer != container) {";
  protected final String TEXT_469 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_470 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), edge.getElement()));";
  protected final String TEXT_471 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_472 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), ";
  protected final String TEXT_473 = ".UNSET_VALUE));";
  protected final String TEXT_474 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_475 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_476 = ".eINSTANCE.get";
  protected final String TEXT_477 = "(), edge.getElement()));";
  protected final String TEXT_478 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_479 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_480 = ".eINSTANCE.get";
  protected final String TEXT_481 = "()," + NL + "\t\t\t\t\tedge.getElement()));";
  protected final String TEXT_482 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_483 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_484 = ".eINSTANCE.get";
  protected final String TEXT_485 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_486 = ".UNSET_VALUE));";
  protected final String TEXT_487 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_488 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_489 = ".eINSTANCE.get";
  protected final String TEXT_490 = "(), edge.getElement()));";
  protected final String TEXT_491 = NL + "\t\t\t}";
  protected final String TEXT_492 = NL + "\t\t\tresult.append(";
  protected final String TEXT_493 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_494 = ".eINSTANCE.get";
  protected final String TEXT_495 = "()," + NL + "\t\t\t\toldSource.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_496 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_497 = ".eINSTANCE.get";
  protected final String TEXT_498 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_499 = NL + "\t\t\tresult.append(";
  protected final String TEXT_500 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_501 = ".eINSTANCE.get";
  protected final String TEXT_502 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_503 = NL + "\t\t\tresult.append(";
  protected final String TEXT_504 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_505 = ".eINSTANCE.get";
  protected final String TEXT_506 = "(), edge.getTarget().getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_507 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_508 = ".eINSTANCE.get";
  protected final String TEXT_509 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_510 = NL + "\t\t\tresult.append(";
  protected final String TEXT_511 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_512 = ".eINSTANCE.get";
  protected final String TEXT_513 = "(), ";
  protected final String TEXT_514 = ".UNSET_VALUE));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_515 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_516 = ".eINSTANCE.get";
  protected final String TEXT_517 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_518 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL;
  protected final String TEXT_519 = NL;
  protected final String TEXT_520 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_521 = " getRelationshipContainer(";
  protected final String TEXT_522 = " element, ";
  protected final String TEXT_523 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_524 = NL;
  protected final String TEXT_525 = NL + "\t\t\tprivate ";
  protected final String TEXT_526 = " createDomainModelRemoveCommand(";
  protected final String TEXT_527 = " editingDomain) {";
  protected final String TEXT_528 = NL + "\t\t\t\t";
  protected final String TEXT_529 = " result = new ";
  protected final String TEXT_530 = "();";
  protected final String TEXT_531 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_532 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_533 = ".getElement().eContainer(), ";
  protected final String TEXT_534 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_535 = ".getElement()));";
  protected final String TEXT_536 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_537 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_538 = ".getElement().eContainer(), ";
  protected final String TEXT_539 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_540 = ".UNSET_VALUE));";
  protected final String TEXT_541 = NL + "\t\t\t\treturn ";
  protected final String TEXT_542 = ".INSTANCE;";
  protected final String TEXT_543 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_544 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_545 = ".getElement().eContainer(), ";
  protected final String TEXT_546 = ".eINSTANCE.get";
  protected final String TEXT_547 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_548 = ".getElement()));";
  protected final String TEXT_549 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_550 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_551 = ".getElement().eContainer(), ";
  protected final String TEXT_552 = ".eINSTANCE.get";
  protected final String TEXT_553 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_554 = ".UNSET_VALUE));";
  protected final String TEXT_555 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_556 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_557 = ".getElement(), ";
  protected final String TEXT_558 = ".eINSTANCE.get";
  protected final String TEXT_559 = "(), ";
  protected final String TEXT_560 = ".getSource().getElement()));";
  protected final String TEXT_561 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_562 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_563 = ".getElement(), ";
  protected final String TEXT_564 = ".eINSTANCE.get";
  protected final String TEXT_565 = "(), ";
  protected final String TEXT_566 = ".UNSET_VALUE));";
  protected final String TEXT_567 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_568 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_569 = ".getElement(), ";
  protected final String TEXT_570 = ".eINSTANCE.get";
  protected final String TEXT_571 = "(), ";
  protected final String TEXT_572 = ".getTarget().getElement()));";
  protected final String TEXT_573 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_574 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_575 = ".getElement(), ";
  protected final String TEXT_576 = ".eINSTANCE.get";
  protected final String TEXT_577 = "(), ";
  protected final String TEXT_578 = ".UNSET_VALUE));";
  protected final String TEXT_579 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_580 = NL + "\t\t\t\treturn ";
  protected final String TEXT_581 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_582 = ".getSource().getElement(), ";
  protected final String TEXT_583 = ".eINSTANCE.get";
  protected final String TEXT_584 = "(), ";
  protected final String TEXT_585 = ".getTarget().getElement());";
  protected final String TEXT_586 = NL + "\t\t\t\treturn ";
  protected final String TEXT_587 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_588 = ".getSource().getElement(), ";
  protected final String TEXT_589 = ".eINSTANCE.get";
  protected final String TEXT_590 = "(), ";
  protected final String TEXT_591 = ".UNSET_VALUE);";
  protected final String TEXT_592 = NL + "\t\t\t}";
  protected final String TEXT_593 = NL + "\t}" + NL;
  protected final String TEXT_594 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_595 = "StartCommand extends ";
  protected final String TEXT_596 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_597 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_598 = "StartCommand(";
  protected final String TEXT_599 = ".CreateConnectionRequestEx requestEx) {" + NL + "\t\t\t//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart()." + NL + "\t\t\tsource = (";
  protected final String TEXT_600 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\tif (source == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_601 = NL + "\t\t\treturn false;";
  protected final String TEXT_602 = NL + "\t\t\t";
  protected final String TEXT_603 = " container = (";
  protected final String TEXT_604 = ")getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_605 = ".eINSTANCE.get";
  protected final String TEXT_606 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_607 = NL;
  protected final String TEXT_608 = NL + "\t\tif (";
  protected final String TEXT_609 = ".";
  protected final String TEXT_610 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_611 = NL + "\t\t}";
  protected final String TEXT_612 = NL + "\t\tif (";
  protected final String TEXT_613 = ".";
  protected final String TEXT_614 = "().size() >= ";
  protected final String TEXT_615 = ".eINSTANCE.get";
  protected final String TEXT_616 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_617 = NL + "\t\t}";
  protected final String TEXT_618 = NL;
  protected final String TEXT_619 = NL + "\t\tif (";
  protected final String TEXT_620 = ".";
  protected final String TEXT_621 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_622 = NL + "\t\t}";
  protected final String TEXT_623 = NL + "\t\tif (";
  protected final String TEXT_624 = ".";
  protected final String TEXT_625 = "().size() >= ";
  protected final String TEXT_626 = ".eINSTANCE.get";
  protected final String TEXT_627 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_628 = NL + "\t\t}";
  protected final String TEXT_629 = NL;
  protected final String TEXT_630 = NL + "\t\t\tif(!";
  protected final String TEXT_631 = ".canCreateLink(";
  protected final String TEXT_632 = ", ";
  protected final String TEXT_633 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_634 = NL + "\t\t\treturn true;";
  protected final String TEXT_635 = NL;
  protected final String TEXT_636 = NL + "\t\tif (";
  protected final String TEXT_637 = ".";
  protected final String TEXT_638 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_639 = NL + "\t\t}";
  protected final String TEXT_640 = NL + "\t\tif (";
  protected final String TEXT_641 = ".";
  protected final String TEXT_642 = "().size() >= ";
  protected final String TEXT_643 = ".eINSTANCE.get";
  protected final String TEXT_644 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_645 = NL + "\t\t}";
  protected final String TEXT_646 = NL;
  protected final String TEXT_647 = NL + "\t\t\tif(!";
  protected final String TEXT_648 = ".canCreateLink(";
  protected final String TEXT_649 = ", ";
  protected final String TEXT_650 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_651 = NL + "\t\t\treturn true;";
  protected final String TEXT_652 = NL + "\t\t\treturn false;";
  protected final String TEXT_653 = NL + "\t\t}";
  protected final String TEXT_654 = NL;
  protected final String TEXT_655 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_656 = " getRelationshipContainer(";
  protected final String TEXT_657 = " element, ";
  protected final String TEXT_658 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_659 = NL + NL + "\t}";
  protected final String TEXT_660 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_661 = "TargetCommand extends ";
  protected final String TEXT_662 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_663 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_664 = " newTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_665 = " oldTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_666 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_667 = "TargetCommand(";
  protected final String TEXT_668 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_669 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_670 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_671 = "TargetCommand(";
  protected final String TEXT_672 = " edge, ";
  protected final String TEXT_673 = " newTarget) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newTarget = newTarget;" + NL + "\t\t\tthis.oldTarget = edge.getTarget();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_674 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_675 = " domainModelEditDomain = ";
  protected final String TEXT_676 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_677 = " command = new ";
  protected final String TEXT_678 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_679 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew WrappingCommand(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_680 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_681 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_682 = NL;
  protected final String TEXT_683 = NL + "\t\t\tif(!";
  protected final String TEXT_684 = ".canCreateLink(";
  protected final String TEXT_685 = ", ";
  protected final String TEXT_686 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_687 = NL + "\t\t\treturn true;";
  protected final String TEXT_688 = NL;
  protected final String TEXT_689 = NL + "\t\t\tif(!";
  protected final String TEXT_690 = ".canCreateLink(";
  protected final String TEXT_691 = ", ";
  protected final String TEXT_692 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_693 = NL + "\t\t\treturn true;";
  protected final String TEXT_694 = NL + "\t\t\treturn false;";
  protected final String TEXT_695 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_696 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_697 = " editingDomain = ";
  protected final String TEXT_698 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_699 = " result = new ";
  protected final String TEXT_700 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_701 = "(edge, newTarget));";
  protected final String TEXT_702 = NL + "\t\t\tresult.append(";
  protected final String TEXT_703 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_704 = ".eINSTANCE.get";
  protected final String TEXT_705 = "()," + NL + "\t\t\t\toldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_706 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_707 = ".eINSTANCE.get";
  protected final String TEXT_708 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_709 = NL + "\t\t\tresult.append(";
  protected final String TEXT_710 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_711 = ".eINSTANCE.get";
  protected final String TEXT_712 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_713 = NL + "\t\t\tresult.append(";
  protected final String TEXT_714 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_715 = ".eINSTANCE.get";
  protected final String TEXT_716 = "(), oldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_717 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_718 = ".eINSTANCE.get";
  protected final String TEXT_719 = "(), newTarget.getElement()));";
  protected final String TEXT_720 = NL + "\t\t\tresult.append(";
  protected final String TEXT_721 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_722 = ".eINSTANCE.get";
  protected final String TEXT_723 = "(), newTarget.getElement()));";
  protected final String TEXT_724 = NL + "\t\t\tresult.append(";
  protected final String TEXT_725 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge, ";
  protected final String TEXT_726 = ".eINSTANCE.getView_Element(), newTarget.getElement()));";
  protected final String TEXT_727 = NL + "\t\t\treturn result;" + NL + "\t\t}";
  protected final String TEXT_728 = NL;
  protected final String TEXT_729 = NL + "\t\t\tprivate ";
  protected final String TEXT_730 = " createDomainModelRemoveCommand(";
  protected final String TEXT_731 = " editingDomain) {";
  protected final String TEXT_732 = NL + "\t\t\t\t";
  protected final String TEXT_733 = " result = new ";
  protected final String TEXT_734 = "();";
  protected final String TEXT_735 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_736 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_737 = ".getElement().eContainer(), ";
  protected final String TEXT_738 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_739 = ".getElement()));";
  protected final String TEXT_740 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_741 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_742 = ".getElement().eContainer(), ";
  protected final String TEXT_743 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_744 = ".UNSET_VALUE));";
  protected final String TEXT_745 = NL + "\t\t\t\treturn ";
  protected final String TEXT_746 = ".INSTANCE;";
  protected final String TEXT_747 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_748 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_749 = ".getElement().eContainer(), ";
  protected final String TEXT_750 = ".eINSTANCE.get";
  protected final String TEXT_751 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_752 = ".getElement()));";
  protected final String TEXT_753 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_754 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_755 = ".getElement().eContainer(), ";
  protected final String TEXT_756 = ".eINSTANCE.get";
  protected final String TEXT_757 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_758 = ".UNSET_VALUE));";
  protected final String TEXT_759 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_760 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_761 = ".getElement(), ";
  protected final String TEXT_762 = ".eINSTANCE.get";
  protected final String TEXT_763 = "(), ";
  protected final String TEXT_764 = ".getSource().getElement()));";
  protected final String TEXT_765 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_766 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_767 = ".getElement(), ";
  protected final String TEXT_768 = ".eINSTANCE.get";
  protected final String TEXT_769 = "(), ";
  protected final String TEXT_770 = ".UNSET_VALUE));";
  protected final String TEXT_771 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_772 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_773 = ".getElement(), ";
  protected final String TEXT_774 = ".eINSTANCE.get";
  protected final String TEXT_775 = "(), ";
  protected final String TEXT_776 = ".getTarget().getElement()));";
  protected final String TEXT_777 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_778 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_779 = ".getElement(), ";
  protected final String TEXT_780 = ".eINSTANCE.get";
  protected final String TEXT_781 = "(), ";
  protected final String TEXT_782 = ".UNSET_VALUE));";
  protected final String TEXT_783 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_784 = NL + "\t\t\t\treturn ";
  protected final String TEXT_785 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_786 = ".getSource().getElement(), ";
  protected final String TEXT_787 = ".eINSTANCE.get";
  protected final String TEXT_788 = "(), ";
  protected final String TEXT_789 = ".getTarget().getElement());";
  protected final String TEXT_790 = NL + "\t\t\t\treturn ";
  protected final String TEXT_791 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_792 = ".getSource().getElement(), ";
  protected final String TEXT_793 = ".eINSTANCE.get";
  protected final String TEXT_794 = "(), ";
  protected final String TEXT_795 = ".UNSET_VALUE);";
  protected final String TEXT_796 = NL + "\t\t\t}";
  protected final String TEXT_797 = NL + "\t}" + NL;
  protected final String TEXT_798 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_799 = "Command extends ";
  protected final String TEXT_800 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_801 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_802 = " target;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_803 = " createdEdge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_804 = "Command(";
  protected final String TEXT_805 = ".CreateConnectionRequestEx requestEx) {" + NL + "\t\t\tif (requestEx.getSourceEditPart().getModel() instanceof ";
  protected final String TEXT_806 = ") {" + NL + "\t\t\t\tsource = (";
  protected final String TEXT_807 = ")requestEx.getSourceEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tsource = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (requestEx.getTargetEditPart().getModel() instanceof ";
  protected final String TEXT_808 = ") {" + NL + "\t\t\t\ttarget = (";
  protected final String TEXT_809 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (source == null || target == null) {" + NL + "\t\t\t\tcreatedEdge = null;" + NL + "\t\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_810 = ".INSTANCE;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedEdge = ";
  protected final String TEXT_811 = ".eINSTANCE.createEdge();";
  protected final String TEXT_812 = NL + "\t\t\t";
  protected final String TEXT_813 = " createdDomainElement = ";
  protected final String TEXT_814 = ".eINSTANCE.create";
  protected final String TEXT_815 = "();" + NL + "\t\t\tcreatedEdge.setElement(createdDomainElement);" + NL + "\t\t\t";
  protected final String TEXT_816 = NL + "\t\t\t";
  protected final String TEXT_817 = ".";
  protected final String TEXT_818 = ".initializeElement(createdDomainElement);";
  protected final String TEXT_819 = NL + "\t\t\tcreatedEdge.setElement(target.getElement());\t\t//XXX: is this correct?";
  protected final String TEXT_820 = NL + "\t\t\t";
  protected final String TEXT_821 = ".decorateView(createdEdge);" + NL + "\t\t\t";
  protected final String TEXT_822 = " domainModelEditDomain = ";
  protected final String TEXT_823 = ".getEditingDomain(source.getDiagram().getElement());";
  protected final String TEXT_824 = NL + "\t\t\torg.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();";
  protected final String TEXT_825 = NL + "\t\t\t";
  protected final String TEXT_826 = " container = getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_827 = ".eINSTANCE.get";
  protected final String TEXT_828 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\tdomainModelAddCommand = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_829 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_830 = ".eINSTANCE.get";
  protected final String TEXT_831 = "(), createdDomainElement));";
  protected final String TEXT_832 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_833 = ".create(domainModelEditDomain," + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_834 = ".eINSTANCE.get";
  protected final String TEXT_835 = "(), createdDomainElement));";
  protected final String TEXT_836 = NL;
  protected final String TEXT_837 = NL + "\t\tif (";
  protected final String TEXT_838 = ".";
  protected final String TEXT_839 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_840 = NL + "\t\t}";
  protected final String TEXT_841 = NL + "\t\tif (";
  protected final String TEXT_842 = ".";
  protected final String TEXT_843 = "().size() >= ";
  protected final String TEXT_844 = ".eINSTANCE.get";
  protected final String TEXT_845 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_846 = NL + "\t\t}";
  protected final String TEXT_847 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_848 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_849 = ".eINSTANCE.get";
  protected final String TEXT_850 = "(), source.getElement()));";
  protected final String TEXT_851 = NL;
  protected final String TEXT_852 = NL + "\t\tif (";
  protected final String TEXT_853 = ".";
  protected final String TEXT_854 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_855 = NL + "\t\t}";
  protected final String TEXT_856 = NL + "\t\tif (";
  protected final String TEXT_857 = ".";
  protected final String TEXT_858 = "().size() >= ";
  protected final String TEXT_859 = ".eINSTANCE.get";
  protected final String TEXT_860 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_861 = NL + "\t\t}";
  protected final String TEXT_862 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_863 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_864 = ".eINSTANCE.get";
  protected final String TEXT_865 = "(), target.getElement()));";
  protected final String TEXT_866 = NL + "\t\tdomainModelAddCommand = addLinkEndsCommand;";
  protected final String TEXT_867 = NL + "\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_868 = ".create(domainModelEditDomain, source.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_869 = ".eINSTANCE.get";
  protected final String TEXT_870 = "(), target.getElement());";
  protected final String TEXT_871 = NL + "\t\t}" + NL;
  protected final String TEXT_872 = NL;
  protected final String TEXT_873 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_874 = " getRelationshipContainer(";
  protected final String TEXT_875 = " element, ";
  protected final String TEXT_876 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_877 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (source == null || target == null || createdEdge == null || domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_878 = NL;
  protected final String TEXT_879 = NL + "\t\t\tif(!";
  protected final String TEXT_880 = ".canCreateLink(";
  protected final String TEXT_881 = ", ";
  protected final String TEXT_882 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_883 = NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tsource.getDiagram().insertEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(source);" + NL + "\t\t\tcreatedEdge.setTarget(target);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t\tsource.getDiagram().removeEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(null);" + NL + "\t\t\tcreatedEdge.setTarget(null);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_884 = NL;
  protected final String TEXT_885 = NL;
  protected final String TEXT_886 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_887 = NL + "}";
  protected final String TEXT_888 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
final GenNode genNode = (GenNode) genElement;
final GenDiagram genDiagram = genNode.getDiagram();
Palette palette = genDiagram.getPalette();
boolean isXYLayout = ViewmapLayoutTypeHelper.getSharedInstance().isStoringChildPositions(genNode);
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

class NodeEditPartHelper {
	private final List myInnerLabels = new LinkedList();
	private final List myAllInnerLabels = new LinkedList();
	private final List myExternalLabels = new LinkedList();
	private final List myPinnedCompartments = new LinkedList();
	private final List myFloatingCompartments = new LinkedList();
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
			if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
				incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
				outgoingClass = modelFacet.getSourceMetaFeature() == null
					? modelFacet.getContainmentMetaFeature().getGenClass()
					: modelFacet.getSourceMetaFeature().getTypeGenClass();
			} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
				GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
				incomingClass = metaFeature.getTypeGenClass();
				outgoingClass = metaFeature.getGenClass();
			} else {
				continue;
			}
			hasIncomingLinks |= (incomingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass()));
			hasOutgoingLinks |= (outgoingClass.getEcoreClass().isSuperTypeOf(genNode.getModelFacet().getMetaClass().getEcoreClass()));
		}
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
}
final NodeEditPartHelper myHelper = new NodeEditPartHelper(genNode);

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    importManager.emitPackageStatement(stringBuffer);
    
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.NodeEditPart"));
    stringBuffer.append(TEXT_8);
    {
GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_29);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_32);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_36);
    
	} else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_41);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_45);
    
	} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_50);
    
	}

    stringBuffer.append(TEXT_51);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_55);
    
	} else {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_60);
    
	}
}

    stringBuffer.append(TEXT_61);
    
}	/*restrict local vars used in component edit policy*/

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_83);
    
if (!myHelper.hasIncomingLinks()) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_85);
    
} else {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_96);
    
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

    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_99);
    
	}

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_102);
    
}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_105);
    
if (!myHelper.hasOutgoingLinks()) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_107);
    
} else {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_118);
    
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

    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_121);
    
	}

    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_124);
    
}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_127);
    if (palette != null && myHelper.hasOutgoingLinks()) {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_133);
    
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

    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_136);
    
}

    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_139);
    }/*when there's palette*/
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_142);
    if (palette != null && myHelper.hasIncomingLinks()) {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_149);
    
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

    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_152);
    
}

    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_155);
    }/*when there's palette*/
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_164);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_166);
    if (isXYLayout) {
    stringBuffer.append(TEXT_167);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_168);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_170);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_171);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_173);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_177);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_194);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_195);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_197);
    } else {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_205);
    
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_207);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_208);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_212);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_213);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_217);
    	
} // for pinned compartments

    stringBuffer.append(TEXT_218);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_219);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_223);
    
} // for pinned compartments

    stringBuffer.append(TEXT_224);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_226);
    
		GenNodeLabel firstEditableLabel = null;
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (!genLabel.isReadOnly()) {
				firstEditableLabel = genLabel;
				break;
			}
		}
		if (firstEditableLabel != null) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName(firstEditableLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_233);
    
		}

    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_245);
    
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_247);
    
		}

    stringBuffer.append(TEXT_248);
    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_250);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_252);
    
	}

    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_257);
    
}
if (myHelper.hasExternalLabels() || myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_259);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_262);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_263);
    
	}

    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_265);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_268);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_269);
    
	}

    stringBuffer.append(TEXT_270);
    
}

    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_275);
    
}

    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_297);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_298);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_308);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_309);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_310);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_322);
    
}

    stringBuffer.append(TEXT_323);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_325);
    
}

    stringBuffer.append(TEXT_326);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_380);
    
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

    stringBuffer.append(TEXT_381);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_394);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_400);
    
	} else {

    stringBuffer.append(TEXT_401);
    
	}

    stringBuffer.append(TEXT_402);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_403);
    
			} else {

    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_408);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_409);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_410);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_412);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_413);
    
	} else {

    stringBuffer.append(TEXT_414);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_419);
    
	}
}

    
				}
				GenFeature childFeature = modelFacet.getChildMetaFeature();
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					{
						GenFeature _feature = childFeature;
						String _ownerInstance = "container";
						String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_420);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_421);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_423);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_424);
    
	} else {

    stringBuffer.append(TEXT_425);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_429);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_430);
    
	}
}

    
					}
				}
			}
			//No need to check the size of the source or target features: their size does not change
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_431);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_433);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_435);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_436);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			{
				GenFeature _feature = metaFeature;
				String _ownerInstance = "((" + importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()) + ") newSource.getElement())";
				String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_437);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_438);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_440);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_441);
    
	} else {

    stringBuffer.append(TEXT_442);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_446);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_447);
    
	}
}

    
			}
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_448);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_450);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_452);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_453);
    
		} else {

    stringBuffer.append(TEXT_454);
    
		}

    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_461);
    
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

    stringBuffer.append(TEXT_462);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_468);
    
			}
			if (containmentFeature != null) {
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_469);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_470);
    
				} else {

    stringBuffer.append(TEXT_471);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_473);
    
				}

    stringBuffer.append(TEXT_474);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_477);
    
			}
			if (setChild) {
				if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_478);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_481);
    
				} else {

    stringBuffer.append(TEXT_482);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_483);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_486);
    
				}

    stringBuffer.append(TEXT_487);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_488);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_489);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_490);
    
			}

    stringBuffer.append(TEXT_491);
    
			if (setSource) {
				if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_492);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_493);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_494);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_495);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_496);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_497);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_498);
    
				} else {

    stringBuffer.append(TEXT_499);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_500);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_501);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_502);
    
				}
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_503);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_506);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_509);
    
			} else {

    stringBuffer.append(TEXT_510);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_511);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_515);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_517);
    
			}
		}

    stringBuffer.append(TEXT_518);
    stringBuffer.append(TEXT_519);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_520);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_523);
    
		}

    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_524);
    
	//input: _edge : String

    stringBuffer.append(TEXT_525);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_527);
    
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

    stringBuffer.append(TEXT_528);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_530);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_531);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_535);
    
			} else {

    stringBuffer.append(TEXT_536);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_540);
    
			}
		} else {

    stringBuffer.append(TEXT_541);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_542);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_543);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_547);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_548);
    
			} else {

    stringBuffer.append(TEXT_549);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_550);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_552);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_553);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_554);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_555);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_559);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_560);
    
			} else {

    stringBuffer.append(TEXT_561);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_564);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_565);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_566);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_567);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_568);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_572);
    
			} else {

    stringBuffer.append(TEXT_573);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_576);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_577);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_578);
    
			}
		}

    stringBuffer.append(TEXT_579);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_580);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_585);
    
		} else {

    stringBuffer.append(TEXT_586);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_590);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_591);
    
		}

    
	}

    stringBuffer.append(TEXT_592);
    
	}

    stringBuffer.append(TEXT_593);
    
	if (palette != null) {

    stringBuffer.append(TEXT_594);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_595);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_596);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_598);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_600);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_601);
    
			} else {

    stringBuffer.append(TEXT_602);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_606);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_607);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_608);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_611);
    
	} else {

    stringBuffer.append(TEXT_612);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_614);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_617);
    
	}
}

    
				}
				GenFeature childFeature = modelFacet.getChildMetaFeature();
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					{
						GenFeature _feature = childFeature;
						String _ownerInstance = "container";
						String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_618);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_619);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_621);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_622);
    
	} else {

    stringBuffer.append(TEXT_623);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_625);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_628);
    
	}
}

    
					}
				}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_629);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_630);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_631);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_633);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_634);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		{
			GenFeature _feature = metaFeature;
			String _ownerInstance = "((" + importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()) + ") source.getElement())";
			String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_635);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_636);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_638);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_639);
    
	} else {

    stringBuffer.append(TEXT_640);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_642);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_644);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_645);
    
	}
}

    
		}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_646);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_647);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_648);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_650);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_651);
    
		} else {

    stringBuffer.append(TEXT_652);
    
		}

    stringBuffer.append(TEXT_653);
    stringBuffer.append(TEXT_654);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_655);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_656);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_658);
    
		}

    stringBuffer.append(TEXT_659);
    
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

    stringBuffer.append(TEXT_660);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_661);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_662);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_663);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_667);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_670);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_671);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_672);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_673);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_674);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_676);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_679);
    
	} else {

    stringBuffer.append(TEXT_680);
    
	}

    stringBuffer.append(TEXT_681);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_682);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_683);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_684);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_686);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_687);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_688);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_689);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_690);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_692);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_693);
    
		} else {

    stringBuffer.append(TEXT_694);
    
		}

    stringBuffer.append(TEXT_695);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_699);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_700);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_701);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_705);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_708);
    
			} else {

    stringBuffer.append(TEXT_709);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_710);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_711);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_712);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_713);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_714);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_715);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_716);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_718);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_719);
    
			} else {

    stringBuffer.append(TEXT_720);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_722);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_723);
    
			}

    stringBuffer.append(TEXT_724);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_726);
    
		}

    stringBuffer.append(TEXT_727);
    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_728);
    
	//input: _edge : String

    stringBuffer.append(TEXT_729);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_731);
    
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

    stringBuffer.append(TEXT_732);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_734);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_735);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_736);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_739);
    
			} else {

    stringBuffer.append(TEXT_740);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_741);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_744);
    
			}
		} else {

    stringBuffer.append(TEXT_745);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_746);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_747);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_750);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_751);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_752);
    
			} else {

    stringBuffer.append(TEXT_753);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_755);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_757);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_758);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_759);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_760);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_763);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_764);
    
			} else {

    stringBuffer.append(TEXT_765);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_766);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_767);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_769);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_770);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_771);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_773);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_774);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_775);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_776);
    
			} else {

    stringBuffer.append(TEXT_777);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_778);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_779);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_781);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_782);
    
			}
		}

    stringBuffer.append(TEXT_783);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_784);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_785);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_786);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_787);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_788);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_789);
    
		} else {

    stringBuffer.append(TEXT_790);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_791);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_792);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_794);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_795);
    
		}

    
	}

    stringBuffer.append(TEXT_796);
    
	}

    stringBuffer.append(TEXT_797);
    
	if (palette != null) {

    stringBuffer.append(TEXT_798);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_801);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_802);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_803);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_804);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_811);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenClass linkClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_812);
    stringBuffer.append(importManager.getImportedName(importManager.getImportedName(linkClass.getQualifiedInterfaceName())));
    stringBuffer.append(TEXT_813);
    stringBuffer.append(importManager.getImportedName(linkClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(linkClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_815);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_816);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_818);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_819);
    
		}

    stringBuffer.append(TEXT_820);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_821);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_822);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_823);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_824);
    
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

    stringBuffer.append(TEXT_825);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_827);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_828);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_831);
    
			}
			if (addChild) {

    stringBuffer.append(TEXT_832);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_834);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_835);
    
			}
			if (addSource) {
				{
					GenFeature _feature = sourceFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";

    stringBuffer.append(TEXT_836);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_837);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_839);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_840);
    
	} else {

    stringBuffer.append(TEXT_841);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_843);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_845);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_846);
    
	}
}

    
				}

    stringBuffer.append(TEXT_847);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_848);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_850);
    
			}
			if (addTarget) {
				{
					GenFeature _feature = targetFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";

    stringBuffer.append(TEXT_851);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_852);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_853);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_854);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_855);
    
	} else {

    stringBuffer.append(TEXT_856);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_859);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_860);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_861);
    
	}
}

    
				}

    stringBuffer.append(TEXT_862);
    stringBuffer.append(importManager.getImportedName(targetFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_865);
    
			}

    stringBuffer.append(TEXT_866);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_867);
    stringBuffer.append(importManager.getImportedName(metaFeature.getEcoreFeature().isMany()? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_870);
    
		}

    stringBuffer.append(TEXT_871);
    stringBuffer.append(TEXT_872);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_873);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_874);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_876);
    
		}

    stringBuffer.append(TEXT_877);
    
{
	String _source = "source.getElement()";
	String _target = "target.getElement()";

    stringBuffer.append(TEXT_878);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_879);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_880);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_882);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_883);
    
	}

    }/*when there's palette*/
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_884);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_885);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_886);
    
}

    
}

    stringBuffer.append(TEXT_887);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_888);
    return stringBuffer.toString();
  }
}
