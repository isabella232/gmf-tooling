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
  protected final String TEXT_17 = ";" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL;
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_20 = " view = (";
  protected final String TEXT_21 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_22 = " view = (";
  protected final String TEXT_23 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = "\t\tinstallEditPolicy(";
  protected final String TEXT_26 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_27 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_28 = " createDeleteCommand(";
  protected final String TEXT_29 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_30 = " editingDomain = ";
  protected final String TEXT_31 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_32 = " cc = new ";
  protected final String TEXT_33 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_34 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new WrappingCommand(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_35 = " editingDomain) {";
  protected final String TEXT_36 = NL + "\t\t\t\t";
  protected final String TEXT_37 = " result = new ";
  protected final String TEXT_38 = "();";
  protected final String TEXT_39 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_40 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_41 = ".eINSTANCE.get";
  protected final String TEXT_42 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_43 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_44 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_45 = ".eINSTANCE.get";
  protected final String TEXT_46 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = ".UNSET_VALUE));";
  protected final String TEXT_48 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_49 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_50 = ".eINSTANCE.get";
  protected final String TEXT_51 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_52 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_53 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_54 = ".eINSTANCE.get";
  protected final String TEXT_55 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = ".UNSET_VALUE));";
  protected final String TEXT_57 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_58 = NL + "\t\t\t\treturn ";
  protected final String TEXT_59 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_60 = ".eINSTANCE.get";
  protected final String TEXT_61 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_62 = NL + "\t\t\t\treturn ";
  protected final String TEXT_63 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_64 = ".eINSTANCE.get";
  protected final String TEXT_65 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = ".UNSET_VALUE);";
  protected final String TEXT_67 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_68 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_69 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_70 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_71 = " getCreateCommand(";
  protected final String TEXT_72 = " request) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_73 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_74 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_75 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_76 = " createChangeConstraintCommand(";
  protected final String TEXT_77 = " child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_78 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_79 = " createChildEditPolicy(";
  protected final String TEXT_80 = " child) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_81 = "() {" + NL + "\t\t\t\t\tpublic ";
  protected final String TEXT_82 = " getTargetEditPart(";
  protected final String TEXT_83 = " request) {" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_84 = ".REQ_SELECTION.equals(request.getType())) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_85 = ".this;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_86 = ".GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_87 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_88 = " getReconnectTargetCommand(";
  protected final String TEXT_89 = " request) {";
  protected final String TEXT_90 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_91 = ".INSTANCE;";
  protected final String TEXT_92 = NL + "\t\t\t\t";
  protected final String TEXT_93 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_94 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_95 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_96 = " edge = (";
  protected final String TEXT_97 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_98 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_99 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_100 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_101 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_102 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_103 = NL + "\t\t\t\tcase ";
  protected final String TEXT_104 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_105 = "TargetCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_106 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_107 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_108 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_109 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_110 = " getReconnectSourceCommand(";
  protected final String TEXT_111 = " request) {";
  protected final String TEXT_112 = " " + NL + "\t\t\t\treturn ";
  protected final String TEXT_113 = ".INSTANCE;";
  protected final String TEXT_114 = NL + "\t\t\t\t";
  protected final String TEXT_115 = " connection = request.getConnectionEditPart();" + NL + "\t\t\t\tif (connection.getModel() instanceof ";
  protected final String TEXT_116 = " == false) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_117 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_118 = " edge = (";
  protected final String TEXT_119 = ")connection.getModel();" + NL + "\t\t\t\tString modelID = ";
  protected final String TEXT_120 = ".getModelID(edge);" + NL + "\t\t\t\tif (!";
  protected final String TEXT_121 = ".MODEL_ID.equals(modelID)) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_122 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_123 = " result = null;" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_124 = ".getVisualID(edge);" + NL + "\t\t\t\tswitch (visualID) {";
  protected final String TEXT_125 = NL + "\t\t\t\tcase ";
  protected final String TEXT_126 = ".VISUAL_ID:" + NL + "\t\t\t\t\tresult = new Reconnect";
  protected final String TEXT_127 = "SourceCommand(request);" + NL + "\t\t\t\t\tbreak;";
  protected final String TEXT_128 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_129 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_130 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);";
  protected final String TEXT_131 = NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_132 = " getConnectionCreateCommand(";
  protected final String TEXT_133 = " request) {";
  protected final String TEXT_134 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_135 = ".CreateConnectionRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_136 = ".CreateConnectionRequestEx requestEx = (";
  protected final String TEXT_137 = ".CreateConnectionRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = " result = new ";
  protected final String TEXT_139 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_141 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_142 = "StartCommand(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = " wrappedResult = new WrappingCommand(";
  protected final String TEXT_145 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_146 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_147 = " getConnectionCompleteCommand(";
  protected final String TEXT_148 = " request) {";
  protected final String TEXT_149 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_150 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_151 = ".CreateConnectionRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_152 = ".CreateConnectionRequestEx requestEx = (";
  protected final String TEXT_153 = ".CreateConnectionRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_154 = " result = new ";
  protected final String TEXT_155 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_157 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_158 = "Command(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_159 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_160 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_161 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_162 = NL + "\t\t\t\treturn ";
  protected final String TEXT_163 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_164 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_165 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_166 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_167 = " invisibleRectangle = new ";
  protected final String TEXT_168 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_169 = "());" + NL + "\t\t";
  protected final String TEXT_170 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_171 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_172 = " createNodeShape() {";
  protected final String TEXT_173 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_174 = "()";
  protected final String TEXT_175 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_176 = ";";
  protected final String TEXT_177 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_178 = ";";
  protected final String TEXT_179 = NL + "\t\t";
  protected final String TEXT_180 = " figure = new ";
  protected final String TEXT_181 = "();";
  protected final String TEXT_182 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_183 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_184 = NL + "\t\treturn primaryShape;" + NL + "\t}";
  protected final String TEXT_185 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_186 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_187 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_188 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_189 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_190 = " view = (";
  protected final String TEXT_191 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_192 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_193 = " decorationPane = new ";
  protected final String TEXT_194 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_195 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_196 = " imageFigure = new ";
  protected final String TEXT_197 = "(";
  protected final String TEXT_198 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_199 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_200 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_201 = " setupContentPane(";
  protected final String TEXT_202 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_203 = NL + "\t\t\t";
  protected final String TEXT_204 = " layout = new ";
  protected final String TEXT_205 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_206 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_207 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_208 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_209 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_210 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_211 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_212 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_213 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_214 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_215 = " childEditPart) {";
  protected final String TEXT_216 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_217 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_218 = ") childEditPart).";
  protected final String TEXT_219 = "(getPrimaryShape().";
  protected final String TEXT_220 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_221 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_222 = ") {" + NL + "\t\t\t";
  protected final String TEXT_223 = " pane = getPrimaryShape().";
  protected final String TEXT_224 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_225 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_226 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_227 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_228 = ") {" + NL + "\t\t\t";
  protected final String TEXT_229 = " pane = getPrimaryShape().";
  protected final String TEXT_230 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_231 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_232 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_233 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_234 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_235 = NL + "\t\tfor(";
  protected final String TEXT_236 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_237 = " nextChild = (";
  protected final String TEXT_238 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_239 = ".getVisualID(nextChild) == ";
  protected final String TEXT_240 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_241 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_242 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_243 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_244 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_245 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_246 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_247 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_248 = " getLabelEditPart(";
  protected final String TEXT_249 = " req) {" + NL + "\t\t";
  protected final String TEXT_250 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_251 = " view = (";
  protected final String TEXT_252 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_253 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_254 = NL + "\t\t\t\tcase ";
  protected final String TEXT_255 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_256 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_257 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_258 = " childEditPart) {";
  protected final String TEXT_259 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_260 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_261 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_262 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_263 = " root = (";
  protected final String TEXT_264 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_265 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_266 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_267 = " childEditPart, int index) {";
  protected final String TEXT_268 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_269 = " labelFigure = ((";
  protected final String TEXT_270 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_271 = NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_272 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_273 = " childEditPart) {";
  protected final String TEXT_274 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_275 = " labelFigure = ((";
  protected final String TEXT_276 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_277 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_278 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_279 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_280 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_281 = " childEditPart = (";
  protected final String TEXT_282 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_283 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_284 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_285 = " node = getDiagramNode();" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_286 = ";" + NL + "\t\t";
  protected final String TEXT_287 = " bounds = (";
  protected final String TEXT_288 = ") node.getLayoutConstraint();" + NL + "\t\t((";
  protected final String TEXT_289 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_290 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_291 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_292 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_293 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_294 = " getSourceConnectionAnchor(";
  protected final String TEXT_295 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_296 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_297 = " getSourceConnectionAnchor(";
  protected final String TEXT_298 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_299 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_300 = "  getTargetConnectionAnchor(";
  protected final String TEXT_301 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_302 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_303 = "  getTargetConnectionAnchor(";
  protected final String TEXT_304 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_305 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_306 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);";
  protected final String TEXT_307 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_308 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_309 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_310 = NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}";
  protected final String TEXT_311 = NL;
  protected final String TEXT_312 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_313 = " domainModelEditDomain = ";
  protected final String TEXT_314 = ".getEditingDomain(";
  protected final String TEXT_315 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_316 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_317 = " filter;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_318 = " editingDomain;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher() {" + NL + "\t\t\tcreateFilter();" + NL + "\t\t}";
  protected final String TEXT_319 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_320 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_321 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_322 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_323 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_324 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_325 = ".createEventTypeFilter(";
  protected final String TEXT_326 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_327 = ".createEventTypeFilter(";
  protected final String TEXT_328 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_329 = ".createEventTypeFilter(";
  protected final String TEXT_330 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_331 = ".createEventTypeFilter(";
  protected final String TEXT_332 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_333 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void createFilter() {";
  protected final String TEXT_334 = NL;
  protected final String TEXT_335 = NL + "\t\t\tfilter = ";
  protected final String TEXT_336 = ".createFeatureFilter(";
  protected final String TEXT_337 = ".eINSTANCE.get";
  protected final String TEXT_338 = "());";
  protected final String TEXT_339 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_340 = ".createFeatureFilter(";
  protected final String TEXT_341 = ".eINSTANCE.get";
  protected final String TEXT_342 = "()));";
  protected final String TEXT_343 = NL;
  protected final String TEXT_344 = NL + "\t\t\tfilter = ";
  protected final String TEXT_345 = ".createFeatureFilter(";
  protected final String TEXT_346 = ".eINSTANCE.get";
  protected final String TEXT_347 = "());";
  protected final String TEXT_348 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_349 = ".createFeatureFilter(";
  protected final String TEXT_350 = ".eINSTANCE.get";
  protected final String TEXT_351 = "()));";
  protected final String TEXT_352 = NL;
  protected final String TEXT_353 = NL + "\t\t\tfilter = ";
  protected final String TEXT_354 = ".createFeatureFilter(";
  protected final String TEXT_355 = ".eINSTANCE.get";
  protected final String TEXT_356 = "());";
  protected final String TEXT_357 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_358 = ".createFeatureFilter(";
  protected final String TEXT_359 = ".eINSTANCE.get";
  protected final String TEXT_360 = "()));";
  protected final String TEXT_361 = NL;
  protected final String TEXT_362 = NL + "\t\t\tfilter = ";
  protected final String TEXT_363 = ".createFeatureFilter(";
  protected final String TEXT_364 = ".eINSTANCE.get";
  protected final String TEXT_365 = "());";
  protected final String TEXT_366 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_367 = ".createFeatureFilter(";
  protected final String TEXT_368 = ".eINSTANCE.get";
  protected final String TEXT_369 = "()));";
  protected final String TEXT_370 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_371 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter();";
  protected final String TEXT_372 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_373 = NL + "\t\t\tfilter = createUncontainedLinksFilter();";
  protected final String TEXT_374 = NL + "\t\t\tfilter = ";
  protected final String TEXT_375 = ".ANY.negated();";
  protected final String TEXT_376 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void install(";
  protected final String TEXT_377 = " editingDomain) {" + NL + "\t\t\tif (this.editingDomain != null && !this.editingDomain.equals(editingDomain)) {" + NL + "\t\t\t\tthrow new IllegalStateException(\"Already listening to another editing domain\");" + NL + "\t\t\t}" + NL + "\t\t\tthis.editingDomain = editingDomain;" + NL + "\t\t\tthis.editingDomain.addResourceSetListener(this);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isInstalled() {" + NL + "\t\t\treturn editingDomain != null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void uninstall() {" + NL + "\t\t\tif (isInstalled()) {" + NL + "\t\t\t\teditingDomain.removeResourceSetListener(this);" + NL + "\t\t\t\teditingDomain = null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isPrecommitOnly() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_378 = " transactionAboutToCommit(";
  protected final String TEXT_379 = " event) {" + NL + "\t\t\treturn getRefreshLinkNotationModelCommand();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_380 = " getFilter() {" + NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_381 = " command = getRefreshLinkNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_382 = " domainModelEditDomain = ";
  protected final String TEXT_383 = ".getEditingDomain(";
  protected final String TEXT_384 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new WrappingCommand(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_385 = NL;
  protected final String TEXT_386 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static class LinkDescriptor {" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_387 = " mySource;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_388 = " myDestination;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_389 = " myLinkElement;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate int myVisualID;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_390 = " source, ";
  protected final String TEXT_391 = " destination, ";
  protected final String TEXT_392 = " linkElement, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = linkElement;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(";
  protected final String TEXT_393 = " source, ";
  protected final String TEXT_394 = " destination, int linkVID) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyVisualID = linkVID;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_395 = " getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_396 = " getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_397 = " getLinkElement() {" + NL + "\t\treturn myLinkElement;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected int getVisualID() {" + NL + "\t\treturn myVisualID;" + NL + "\t}" + NL + "}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_398 = " getRefreshLinkNotationModelCommand() {" + NL + "\t\t";
  protected final String TEXT_399 = "/*<LinkDescriptor>*/ semanticChildLinks = getSemanticChildLinks();" + NL + "\t\t";
  protected final String TEXT_400 = "/*<Edge>*/ notationalChildLinks = getNotationalChildLinks();" + NL + "\t\tfinal ";
  protected final String TEXT_401 = " semanticToNotationalTypeBasedLinks = new ";
  protected final String TEXT_402 = "();" + NL + "\t\tfinal ";
  protected final String TEXT_403 = "/*<EObject, List<Edge>>*/ semanticToNotationalFeatureBasedLinks = new ";
  protected final String TEXT_404 = "();" + NL + "\t\tfor(";
  protected final String TEXT_405 = " it = notationalChildLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_406 = " next = (";
  protected final String TEXT_407 = ") it.next();" + NL + "\t\t\t";
  protected final String TEXT_408 = " nextSemantic = next.getElement();" + NL + "\t\t\tif (nextSemantic != null) {" + NL + "\t\t\t\tsemanticToNotationalTypeBasedLinks.put(nextSemantic, next);" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_409 = " featureBasedLinksForSource = (";
  protected final String TEXT_410 = ") semanticToNotationalFeatureBasedLinks.get(next.getSource().getElement());" + NL + "\t\t\t\tif (featureBasedLinksForSource == null) {" + NL + "\t\t\t\t\tfeatureBasedLinksForSource = new ";
  protected final String TEXT_411 = "();" + NL + "\t\t\t\t\tsemanticToNotationalFeatureBasedLinks.put(next.getSource().getElement(), featureBasedLinksForSource);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfeatureBasedLinksForSource.add(next);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_412 = " parentView = ";
  protected final String TEXT_413 = ";" + NL + "\t\t";
  protected final String TEXT_414 = " command = new ";
  protected final String TEXT_415 = "();" + NL + "\t\tfor(";
  protected final String TEXT_416 = " it = semanticChildLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\tLinkDescriptor next = (LinkDescriptor) it.next();" + NL + "\t\t\t";
  protected final String TEXT_417 = " nextLinkElement = next.getLinkElement();" + NL + "\t\t\t";
  protected final String TEXT_418 = " currentEdge;" + NL + "\t\t\tif (nextLinkElement != null) {" + NL + "\t\t\t\tcurrentEdge = (";
  protected final String TEXT_419 = ") semanticToNotationalTypeBasedLinks.remove(nextLinkElement);" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_420 = " featureBasedLinksForSource = (";
  protected final String TEXT_421 = ") semanticToNotationalFeatureBasedLinks.get(next.getSource());" + NL + "\t\t\t\tif (featureBasedLinksForSource == null || featureBasedLinksForSource.isEmpty()) {" + NL + "\t\t\t\t\tcurrentEdge = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tcurrentEdge = (";
  protected final String TEXT_422 = ") featureBasedLinksForSource.remove(0);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tint linkVisualID = next.getVisualID();" + NL + "\t\t\tif (currentEdge == null) {" + NL + "\t\t\t\tif (nextLinkElement == null || shouldCreateEdge(nextLinkElement)) {" + NL + "\t\t\t\t\tcommand.appendIfCanExecute(getCreateNotationalEdgeCommand(parentView, next));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tboolean changedSource = currentEdge.getSource().getElement() != next.getSource();" + NL + "\t\t\t\tboolean changedTarget = currentEdge.getTarget().getElement() != next.getDestination();" + NL + "\t\t\t\tboolean changedVID = linkVisualID != ";
  protected final String TEXT_423 = ".getVisualID(currentEdge);" + NL + "\t\t\t\tif (!changedSource && !changedTarget) {" + NL + "\t\t\t\t\tif (changedVID) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_424 = " notationalCommand = getCreateNotationalEdgeCommand(parentView, next);" + NL + "\t\t\t\t\t\tif (notationalCommand != null) {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_425 = "(parentView, notationalCommand, currentEdge));" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_426 = "(parentView, currentEdge));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif (changedVID) {" + NL + "\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_427 = "(parentView, currentEdge));" + NL + "\t\t\t\t\t\tcommand.appendIfCanExecute(getCreateNotationalEdgeCommand(parentView, next));" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_428 = " newSourceView = findView(next.getSource());" + NL + "\t\t\t\t\t\tif (changedSource && newSourceView != null) {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_429 = "(currentEdge, newSourceView));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_430 = " newTargetView = findView(next.getDestination());" + NL + "\t\t\t\t\t\tif (changedTarget && newTargetView != null) {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_431 = "(currentEdge, newTargetView));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tfor(";
  protected final String TEXT_432 = " it = semanticToNotationalTypeBasedLinks.values().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_433 = " obsoleteView = (";
  protected final String TEXT_434 = ") it.next();" + NL + "\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_435 = "(parentView, obsoleteView));" + NL + "\t\t}" + NL + "\t\tfor(";
  protected final String TEXT_436 = " it = semanticToNotationalFeatureBasedLinks.values().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_437 = " obsoleteViews = (";
  protected final String TEXT_438 = ") it.next();" + NL + "\t\t\tfor(";
  protected final String TEXT_439 = " obsoleteViewsIt = obsoleteViews.iterator(); obsoleteViewsIt.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_440 = " obsoleteView = (";
  protected final String TEXT_441 = ") obsoleteViewsIt.next();" + NL + "\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_442 = "(parentView, obsoleteView));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn command.getCommandList().isEmpty() ? null : command;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Finds a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_443 = " findView(";
  protected final String TEXT_444 = " modelElement) {" + NL + "\t\tif (modelElement == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_445 = " editPart = (";
  protected final String TEXT_446 = ") getViewer().getEditPartRegistry().get(modelElement);" + NL + "\t\tif (editPart != null && editPart.getModel() instanceof ";
  protected final String TEXT_447 = ") {" + NL + "\t\t\treturn (";
  protected final String TEXT_448 = ") editPart.getModel();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_449 = " parentView = findView(modelElement.eContainer());" + NL + "\t\tif (parentView != null) {" + NL + "\t\t\t";
  protected final String TEXT_450 = " result = findNode(parentView, modelElement);" + NL + "\t\t\tif (result != null) {" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn findEdge(modelElement);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Finds a notational node that corresponds to the given underlying domain element in a subtree starting from the given parent element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_451 = " findNode(";
  protected final String TEXT_452 = " parentView, ";
  protected final String TEXT_453 = " modelElement) {" + NL + "\t\tfor(";
  protected final String TEXT_454 = " it = parentView.getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_455 = " next = (";
  protected final String TEXT_456 = ") it.next();" + NL + "\t\t\tif (!next.isSetElement() || next.getElement() == parentView) {" + NL + "\t\t\t\t";
  protected final String TEXT_457 = " result = findNode(next, modelElement);" + NL + "\t\t\t\tif (result != null) {" + NL + "\t\t\t\t\treturn result;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (next.isSetElement() && next.getElement() == modelElement) {" + NL + "\t\t\t\treturn next;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Finds a notational edge that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_458 = " findEdge(";
  protected final String TEXT_459 = " modelElement) {" + NL + "\t\tfor(";
  protected final String TEXT_460 = " it = ";
  protected final String TEXT_461 = ".getEdges().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_462 = " next = (";
  protected final String TEXT_463 = ") it.next();" + NL + "\t\t\tif (next.isSetElement() && next.getElement() == modelElement) {" + NL + "\t\t\t\treturn next;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_464 = " getCreateNotationalEdgeCommand(";
  protected final String TEXT_465 = " parentView, LinkDescriptor linkDescriptor) {" + NL + "\t\t";
  protected final String TEXT_466 = " sourceView = findView(linkDescriptor.getSource());" + NL + "\t\t";
  protected final String TEXT_467 = " targetView = findView(linkDescriptor.getDestination());" + NL + "\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_468 = " createdEdge = ";
  protected final String TEXT_469 = ".eINSTANCE.createEdge();" + NL + "\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_470 = NL + "\t\tcase ";
  protected final String TEXT_471 = ".VISUAL_ID:" + NL + "\t\t\tif (linkDescriptor.getLinkElement() instanceof ";
  protected final String TEXT_472 = ") {" + NL + "\t\t\t\tcreatedEdge.setElement(linkDescriptor.getLinkElement());" + NL + "\t\t\t\t";
  protected final String TEXT_473 = ".decorateView(createdEdge);" + NL + "\t\t\t}" + NL + "\t\t\tbreak;";
  protected final String TEXT_474 = NL + "\t\tcase ";
  protected final String TEXT_475 = ".VISUAL_ID:" + NL + "\t\t\tif (linkDescriptor.getLinkElement() == null) {" + NL + "\t\t\t\tcreatedEdge.setElement(null);" + NL + "\t\t\t\t";
  protected final String TEXT_476 = ".decorateView(createdEdge);" + NL + "\t\t\t}" + NL + "\t\t\tbreak;";
  protected final String TEXT_477 = NL + "\t\t}" + NL + "\t\tif (createdEdge.getType() == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn new ";
  protected final String TEXT_478 = "(parentView, createdEdge, sourceView, targetView);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_479 = " getSemanticChildLinks() {";
  protected final String TEXT_480 = NL;
  protected final String TEXT_481 = "\t";
  protected final String TEXT_482 = " result = new ";
  protected final String TEXT_483 = "();";
  protected final String TEXT_484 = NL + "\t";
  protected final String TEXT_485 = " modelObject = ";
  protected final String TEXT_486 = ";" + NL + "\t";
  protected final String TEXT_487 = " nextValue;";
  protected final String TEXT_488 = NL + "\tint linkVID;";
  protected final String TEXT_489 = NL + "\tfor(";
  protected final String TEXT_490 = " it = ((";
  protected final String TEXT_491 = ")modelObject).";
  protected final String TEXT_492 = "().iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_493 = ") it.next();";
  protected final String TEXT_494 = NL + "\tnextValue = ((";
  protected final String TEXT_495 = ")modelObject).";
  protected final String TEXT_496 = "();";
  protected final String TEXT_497 = NL + "\tlinkVID = ";
  protected final String TEXT_498 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_499 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_500 = NL + "\tcase ";
  protected final String TEXT_501 = ".VISUAL_ID: {";
  protected final String TEXT_502 = NL + "\tif (";
  protected final String TEXT_503 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_504 = NL + "\t\t";
  protected final String TEXT_505 = " source = ((";
  protected final String TEXT_506 = ")nextValue).";
  protected final String TEXT_507 = "();";
  protected final String TEXT_508 = NL + "\t\t";
  protected final String TEXT_509 = " source = ";
  protected final String TEXT_510 = ";";
  protected final String TEXT_511 = NL + "\t\t";
  protected final String TEXT_512 = " target = ((";
  protected final String TEXT_513 = ")nextValue).";
  protected final String TEXT_514 = "();";
  protected final String TEXT_515 = NL + "\t\t";
  protected final String TEXT_516 = " target = ";
  protected final String TEXT_517 = ";";
  protected final String TEXT_518 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new LinkDescriptor(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_519 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_520 = NL + "\t}";
  protected final String TEXT_521 = NL + "\t}";
  protected final String TEXT_522 = NL + "\t}";
  protected final String TEXT_523 = NL + "\tfor(";
  protected final String TEXT_524 = " it = ((";
  protected final String TEXT_525 = ")modelObject).";
  protected final String TEXT_526 = "().iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_527 = ") it.next();";
  protected final String TEXT_528 = NL + "\tnextValue = ((";
  protected final String TEXT_529 = ")modelObject).";
  protected final String TEXT_530 = "();";
  protected final String TEXT_531 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_532 = NL + "\t\tresult.add(new LinkDescriptor(modelObject, nextValue, null, ";
  protected final String TEXT_533 = ".VISUAL_ID));";
  protected final String TEXT_534 = NL + "\t}";
  protected final String TEXT_535 = NL + "\t}";
  protected final String TEXT_536 = NL + "\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_537 = " getNotationalChildLinks() {" + NL + "\t\t";
  protected final String TEXT_538 = " result = new ";
  protected final String TEXT_539 = "();" + NL + "\t\t";
  protected final String TEXT_540 = " allLinks = ";
  protected final String TEXT_541 = ".getEdges();" + NL + "\t\tfor(";
  protected final String TEXT_542 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_543 = " next = (";
  protected final String TEXT_544 = ") it.next();";
  protected final String TEXT_545 = NL + "\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\tresult.add(next);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_546 = " source = next.getSource();" + NL + "\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\tresult.add(next);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_547 = " target = next.getTarget();" + NL + "\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\tresult.add(next);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}";
  protected final String TEXT_548 = NL + "\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_549 = ") {" + NL + "\t\t\t\t\tint linkVID = ";
  protected final String TEXT_550 = ".getVisualID(next);" + NL + "\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_551 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_552 = ".VISUAL_ID:";
  protected final String TEXT_553 = NL + "\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_554 = NL + "\t\t\t} else {";
  protected final String TEXT_555 = NL + "\t\t\t}";
  protected final String TEXT_556 = NL + "\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_557 = NL + "\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_558 = ") {" + NL + "\t\t\t\t\tint linkVID = ";
  protected final String TEXT_559 = ".getVisualID(next);" + NL + "\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_560 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_561 = ".VISUAL_ID:";
  protected final String TEXT_562 = NL + "\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_563 = NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t * The generated code always returns ";
  protected final String TEXT_564 = ". " + NL + "\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean shouldCreateEdge(EObject domainElement) {" + NL + "\t\treturn ";
  protected final String TEXT_565 = ";" + NL + "\t}";
  protected final String TEXT_566 = NL;
  protected final String TEXT_567 = NL;
  protected final String TEXT_568 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_569 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_570 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_571 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_572 = NL;
  protected final String TEXT_573 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_574 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_575 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_576 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_577 = NL;
  protected final String TEXT_578 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_579 = NL + "\t\t";
  protected final String TEXT_580 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_581 = ") ";
  protected final String TEXT_582 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_583 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_584 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_585 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_586 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_587 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_588 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_589 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_590 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_591 = "\t" + NL + "\t}";
  protected final String TEXT_592 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_593 = " createdFont;";
  protected final String TEXT_594 = "\t" + NL;
  protected final String TEXT_595 = NL;
  protected final String TEXT_596 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_597 = " style = (";
  protected final String TEXT_598 = ")  ";
  protected final String TEXT_599 = ".getStyle(";
  protected final String TEXT_600 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_601 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_602 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_603 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_604 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_605 = " style = (";
  protected final String TEXT_606 = ")  ";
  protected final String TEXT_607 = ".getStyle(";
  protected final String TEXT_608 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_609 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_610 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_611 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_612 = " createdBackgroundColor;" + NL;
  protected final String TEXT_613 = NL;
  protected final String TEXT_614 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_615 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_616 = " feature, ";
  protected final String TEXT_617 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_618 = "();";
  protected final String TEXT_619 = NL;
  protected final String TEXT_620 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_621 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_622 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_623 = NL;
  protected final String TEXT_624 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_625 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_626 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_627 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_628 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_629 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_630 = NL;
  protected final String TEXT_631 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_632 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_633 = NL;
  protected final String TEXT_634 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_635 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_636 = NL;
  protected final String TEXT_637 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_638 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_639 = NL;
  protected final String TEXT_640 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_641 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_642 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_643 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_644 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_645 = NL;
  protected final String TEXT_646 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_647 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_648 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_649 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_650 = "SourceCommand extends ";
  protected final String TEXT_651 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_652 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_653 = " newSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_654 = " oldSource;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_655 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_656 = "SourceCommand(";
  protected final String TEXT_657 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_658 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_659 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_660 = "SourceCommand(";
  protected final String TEXT_661 = " edge, ";
  protected final String TEXT_662 = " newSource) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newSource = newSource;" + NL + "\t\t\tthis.oldSource = edge.getSource();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_663 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_664 = " domainModelEditDomain = ";
  protected final String TEXT_665 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_666 = " command = new ";
  protected final String TEXT_667 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_668 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew WrappingCommand(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_669 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_670 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_671 = NL + "\t\t\treturn false;";
  protected final String TEXT_672 = NL + "\t\t\t";
  protected final String TEXT_673 = " container = (";
  protected final String TEXT_674 = ")getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_675 = ".eINSTANCE.get";
  protected final String TEXT_676 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_677 = NL;
  protected final String TEXT_678 = NL + "\t\tif (";
  protected final String TEXT_679 = ".";
  protected final String TEXT_680 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_681 = NL + "\t\t}";
  protected final String TEXT_682 = NL + "\t\tif (";
  protected final String TEXT_683 = ".";
  protected final String TEXT_684 = "().size() >= ";
  protected final String TEXT_685 = ".eINSTANCE.get";
  protected final String TEXT_686 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_687 = NL + "\t\t}";
  protected final String TEXT_688 = NL;
  protected final String TEXT_689 = NL + "\t\tif (";
  protected final String TEXT_690 = ".";
  protected final String TEXT_691 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_692 = NL + "\t\t}";
  protected final String TEXT_693 = NL + "\t\tif (";
  protected final String TEXT_694 = ".";
  protected final String TEXT_695 = "().size() >= ";
  protected final String TEXT_696 = ".eINSTANCE.get";
  protected final String TEXT_697 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_698 = NL + "\t\t}";
  protected final String TEXT_699 = NL;
  protected final String TEXT_700 = NL + "\t\t\tif(!";
  protected final String TEXT_701 = ".canCreateLink(";
  protected final String TEXT_702 = ", ";
  protected final String TEXT_703 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_704 = NL + "\t\t\treturn true;";
  protected final String TEXT_705 = NL;
  protected final String TEXT_706 = NL + "\t\tif (";
  protected final String TEXT_707 = ".";
  protected final String TEXT_708 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_709 = NL + "\t\t}";
  protected final String TEXT_710 = NL + "\t\tif (";
  protected final String TEXT_711 = ".";
  protected final String TEXT_712 = "().size() >= ";
  protected final String TEXT_713 = ".eINSTANCE.get";
  protected final String TEXT_714 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_715 = NL + "\t\t}";
  protected final String TEXT_716 = NL;
  protected final String TEXT_717 = NL + "\t\t\tif(!";
  protected final String TEXT_718 = ".canCreateLink(";
  protected final String TEXT_719 = ", ";
  protected final String TEXT_720 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_721 = NL + "\t\t\treturn true;";
  protected final String TEXT_722 = NL + "\t\t\treturn false;";
  protected final String TEXT_723 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_724 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_725 = " editingDomain = ";
  protected final String TEXT_726 = ".getEditingDomain(oldSource.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_727 = " result = new ";
  protected final String TEXT_728 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_729 = "(edge, newSource));";
  protected final String TEXT_730 = NL + "\t\t\t";
  protected final String TEXT_731 = " container = getRelationshipContainer(newSource.getElement(), ";
  protected final String TEXT_732 = ".eINSTANCE.get";
  protected final String TEXT_733 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_734 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_735 = " oldContainer = edge.getElement().eContainer();" + NL + "\t\t\tif (oldContainer == null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_736 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tif (oldContainer != container) {";
  protected final String TEXT_737 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_738 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), edge.getElement()));";
  protected final String TEXT_739 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_740 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), edge.getElement().eContainmentFeature(), ";
  protected final String TEXT_741 = ".UNSET_VALUE));";
  protected final String TEXT_742 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_743 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_744 = ".eINSTANCE.get";
  protected final String TEXT_745 = "(), edge.getElement()));";
  protected final String TEXT_746 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_747 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_748 = ".eINSTANCE.get";
  protected final String TEXT_749 = "()," + NL + "\t\t\t\t\tedge.getElement()));";
  protected final String TEXT_750 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_751 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tedge.getElement().eContainer(), ";
  protected final String TEXT_752 = ".eINSTANCE.get";
  protected final String TEXT_753 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_754 = ".UNSET_VALUE));";
  protected final String TEXT_755 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_756 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\tcontainer, ";
  protected final String TEXT_757 = ".eINSTANCE.get";
  protected final String TEXT_758 = "(), edge.getElement()));";
  protected final String TEXT_759 = NL + "\t\t\t}";
  protected final String TEXT_760 = NL + "\t\t\tresult.append(";
  protected final String TEXT_761 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_762 = ".eINSTANCE.get";
  protected final String TEXT_763 = "()," + NL + "\t\t\t\toldSource.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_764 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_765 = ".eINSTANCE.get";
  protected final String TEXT_766 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_767 = NL + "\t\t\tresult.append(";
  protected final String TEXT_768 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_769 = ".eINSTANCE.get";
  protected final String TEXT_770 = "()," + NL + "\t\t\t\tnewSource.getElement()));";
  protected final String TEXT_771 = NL + "\t\t\tresult.append(";
  protected final String TEXT_772 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_773 = ".eINSTANCE.get";
  protected final String TEXT_774 = "(), edge.getTarget().getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_775 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_776 = ".eINSTANCE.get";
  protected final String TEXT_777 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_778 = NL + "\t\t\tresult.append(";
  protected final String TEXT_779 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\toldSource.getElement(), ";
  protected final String TEXT_780 = ".eINSTANCE.get";
  protected final String TEXT_781 = "(), ";
  protected final String TEXT_782 = ".UNSET_VALUE));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_783 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tnewSource.getElement(), ";
  protected final String TEXT_784 = ".eINSTANCE.get";
  protected final String TEXT_785 = "(), edge.getTarget().getElement()));";
  protected final String TEXT_786 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL;
  protected final String TEXT_787 = NL;
  protected final String TEXT_788 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_789 = " getRelationshipContainer(";
  protected final String TEXT_790 = " element, ";
  protected final String TEXT_791 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_792 = NL;
  protected final String TEXT_793 = NL + "\t\t\tprivate ";
  protected final String TEXT_794 = " createDomainModelRemoveCommand(";
  protected final String TEXT_795 = " editingDomain) {";
  protected final String TEXT_796 = NL + "\t\t\t\t";
  protected final String TEXT_797 = " result = new ";
  protected final String TEXT_798 = "();";
  protected final String TEXT_799 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_800 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_801 = ".getElement().eContainer(), ";
  protected final String TEXT_802 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_803 = ".getElement()));";
  protected final String TEXT_804 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_805 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_806 = ".getElement().eContainer(), ";
  protected final String TEXT_807 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_808 = ".UNSET_VALUE));";
  protected final String TEXT_809 = NL + "\t\t\t\treturn ";
  protected final String TEXT_810 = ".INSTANCE;";
  protected final String TEXT_811 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_812 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_813 = ".getElement().eContainer(), ";
  protected final String TEXT_814 = ".eINSTANCE.get";
  protected final String TEXT_815 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_816 = ".getElement()));";
  protected final String TEXT_817 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_818 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_819 = ".getElement().eContainer(), ";
  protected final String TEXT_820 = ".eINSTANCE.get";
  protected final String TEXT_821 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_822 = ".UNSET_VALUE));";
  protected final String TEXT_823 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_824 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_825 = ".getElement(), ";
  protected final String TEXT_826 = ".eINSTANCE.get";
  protected final String TEXT_827 = "(), ";
  protected final String TEXT_828 = ".getSource().getElement()));";
  protected final String TEXT_829 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_830 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_831 = ".getElement(), ";
  protected final String TEXT_832 = ".eINSTANCE.get";
  protected final String TEXT_833 = "(), ";
  protected final String TEXT_834 = ".UNSET_VALUE));";
  protected final String TEXT_835 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_836 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_837 = ".getElement(), ";
  protected final String TEXT_838 = ".eINSTANCE.get";
  protected final String TEXT_839 = "(), ";
  protected final String TEXT_840 = ".getTarget().getElement()));";
  protected final String TEXT_841 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_842 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_843 = ".getElement(), ";
  protected final String TEXT_844 = ".eINSTANCE.get";
  protected final String TEXT_845 = "(), ";
  protected final String TEXT_846 = ".UNSET_VALUE));";
  protected final String TEXT_847 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_848 = NL + "\t\t\t\treturn ";
  protected final String TEXT_849 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_850 = ".getSource().getElement(), ";
  protected final String TEXT_851 = ".eINSTANCE.get";
  protected final String TEXT_852 = "(), ";
  protected final String TEXT_853 = ".getTarget().getElement());";
  protected final String TEXT_854 = NL + "\t\t\t\treturn ";
  protected final String TEXT_855 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_856 = ".getSource().getElement(), ";
  protected final String TEXT_857 = ".eINSTANCE.get";
  protected final String TEXT_858 = "(), ";
  protected final String TEXT_859 = ".UNSET_VALUE);";
  protected final String TEXT_860 = NL + "\t\t\t}";
  protected final String TEXT_861 = NL + "\t}" + NL;
  protected final String TEXT_862 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_863 = "StartCommand extends ";
  protected final String TEXT_864 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_865 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_866 = "StartCommand(";
  protected final String TEXT_867 = ".CreateConnectionRequestEx requestEx) {" + NL + "\t\t\t//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart()." + NL + "\t\t\tsource = (";
  protected final String TEXT_868 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\tif (source == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_869 = NL + "\t\t\treturn false;";
  protected final String TEXT_870 = NL + "\t\t\t";
  protected final String TEXT_871 = " container = (";
  protected final String TEXT_872 = ")getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_873 = ".eINSTANCE.get";
  protected final String TEXT_874 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_875 = NL;
  protected final String TEXT_876 = NL + "\t\tif (";
  protected final String TEXT_877 = ".";
  protected final String TEXT_878 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_879 = NL + "\t\t}";
  protected final String TEXT_880 = NL + "\t\tif (";
  protected final String TEXT_881 = ".";
  protected final String TEXT_882 = "().size() >= ";
  protected final String TEXT_883 = ".eINSTANCE.get";
  protected final String TEXT_884 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_885 = NL + "\t\t}";
  protected final String TEXT_886 = NL;
  protected final String TEXT_887 = NL + "\t\tif (";
  protected final String TEXT_888 = ".";
  protected final String TEXT_889 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_890 = NL + "\t\t}";
  protected final String TEXT_891 = NL + "\t\tif (";
  protected final String TEXT_892 = ".";
  protected final String TEXT_893 = "().size() >= ";
  protected final String TEXT_894 = ".eINSTANCE.get";
  protected final String TEXT_895 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_896 = NL + "\t\t}";
  protected final String TEXT_897 = NL;
  protected final String TEXT_898 = NL + "\t\t\tif(!";
  protected final String TEXT_899 = ".canCreateLink(";
  protected final String TEXT_900 = ", ";
  protected final String TEXT_901 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_902 = NL + "\t\t\treturn true;";
  protected final String TEXT_903 = NL;
  protected final String TEXT_904 = NL + "\t\tif (";
  protected final String TEXT_905 = ".";
  protected final String TEXT_906 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_907 = NL + "\t\t}";
  protected final String TEXT_908 = NL + "\t\tif (";
  protected final String TEXT_909 = ".";
  protected final String TEXT_910 = "().size() >= ";
  protected final String TEXT_911 = ".eINSTANCE.get";
  protected final String TEXT_912 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_913 = NL + "\t\t}";
  protected final String TEXT_914 = NL;
  protected final String TEXT_915 = NL + "\t\t\tif(!";
  protected final String TEXT_916 = ".canCreateLink(";
  protected final String TEXT_917 = ", ";
  protected final String TEXT_918 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_919 = NL + "\t\t\treturn true;";
  protected final String TEXT_920 = NL + "\t\t\treturn false;";
  protected final String TEXT_921 = NL + "\t\t}";
  protected final String TEXT_922 = NL;
  protected final String TEXT_923 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_924 = " getRelationshipContainer(";
  protected final String TEXT_925 = " element, ";
  protected final String TEXT_926 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_927 = NL + NL + "\t}";
  protected final String TEXT_928 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Reconnect";
  protected final String TEXT_929 = "TargetCommand extends ";
  protected final String TEXT_930 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_931 = " edge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_932 = " newTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_933 = " oldTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_934 = " reconnectCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_935 = "TargetCommand(";
  protected final String TEXT_936 = " request) {" + NL + "\t\t\tthis((";
  protected final String TEXT_937 = ")request.getConnectionEditPart().getModel(), (";
  protected final String TEXT_938 = ")request.getTarget().getModel());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Reconnect";
  protected final String TEXT_939 = "TargetCommand(";
  protected final String TEXT_940 = " edge, ";
  protected final String TEXT_941 = " newTarget) {" + NL + "\t\t\tthis.edge = edge;" + NL + "\t\t\tthis.newTarget = newTarget;" + NL + "\t\t\tthis.oldTarget = edge.getTarget();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\treconnectCommand.execute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn reconnectCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\treconnectCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {";
  protected final String TEXT_942 = NL + "\t\t\tfinal boolean[] resultHolder = new boolean[1];" + NL + "\t\t\t//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion." + NL + "\t\t\tfinal ";
  protected final String TEXT_943 = " domainModelEditDomain = ";
  protected final String TEXT_944 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_945 = " command = new ";
  protected final String TEXT_946 = "() {" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_947 = " deleteCommand = createDomainModelRemoveCommand(domainModelEditDomain);" + NL + "\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\treturn deleteCommand.canExecute();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\treturn true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\tdeleteCommand.execute();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tresultHolder[0] = canReconnect();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tdeleteCommand.undo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tif (!command.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tnew WrappingCommand(domainModelEditDomain, command).execute();" + NL + "\t\t\tif (resultHolder[0]) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t}" + NL + "\t\t\treturn resultHolder[0] && reconnectCommand.canExecute();";
  protected final String TEXT_948 = NL + "\t\t\tif (canReconnect()) {" + NL + "\t\t\t\treconnectCommand = createReconnectCommand();" + NL + "\t\t\t\treturn reconnectCommand.canExecute();" + NL + "\t\t\t}" + NL + "\t\t\treturn false;";
  protected final String TEXT_949 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean canReconnect() {";
  protected final String TEXT_950 = NL;
  protected final String TEXT_951 = NL + "\t\t\tif(!";
  protected final String TEXT_952 = ".canCreateLink(";
  protected final String TEXT_953 = ", ";
  protected final String TEXT_954 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_955 = NL + "\t\t\treturn true;";
  protected final String TEXT_956 = NL;
  protected final String TEXT_957 = NL + "\t\t\tif(!";
  protected final String TEXT_958 = ".canCreateLink(";
  protected final String TEXT_959 = ", ";
  protected final String TEXT_960 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_961 = NL + "\t\t\treturn true;";
  protected final String TEXT_962 = NL + "\t\t\treturn false;";
  protected final String TEXT_963 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_964 = " createReconnectCommand() {" + NL + "\t\t\t";
  protected final String TEXT_965 = " editingDomain = ";
  protected final String TEXT_966 = ".getEditingDomain(oldTarget.getDiagram().getElement());" + NL + "\t\t\t";
  protected final String TEXT_967 = " result = new ";
  protected final String TEXT_968 = "();" + NL + "\t\t\tresult.append(new ";
  protected final String TEXT_969 = "(edge, newTarget));";
  protected final String TEXT_970 = NL + "\t\t\tresult.append(";
  protected final String TEXT_971 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_972 = ".eINSTANCE.get";
  protected final String TEXT_973 = "()," + NL + "\t\t\t\toldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_974 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_975 = ".eINSTANCE.get";
  protected final String TEXT_976 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_977 = NL + "\t\t\tresult.append(";
  protected final String TEXT_978 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getElement(), ";
  protected final String TEXT_979 = ".eINSTANCE.get";
  protected final String TEXT_980 = "()," + NL + "\t\t\t\tnewTarget.getElement()));";
  protected final String TEXT_981 = NL + "\t\t\tresult.append(";
  protected final String TEXT_982 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_983 = ".eINSTANCE.get";
  protected final String TEXT_984 = "(), oldTarget.getElement()));" + NL + "\t\t\tresult.append(";
  protected final String TEXT_985 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_986 = ".eINSTANCE.get";
  protected final String TEXT_987 = "(), newTarget.getElement()));";
  protected final String TEXT_988 = NL + "\t\t\tresult.append(";
  protected final String TEXT_989 = ".create(" + NL + "\t\t\t\teditingDomain," + NL + "\t\t\t\tedge.getSource().getElement(), ";
  protected final String TEXT_990 = ".eINSTANCE.get";
  protected final String TEXT_991 = "(), newTarget.getElement()));";
  protected final String TEXT_992 = NL + "\t\t\treturn result;" + NL + "\t\t}";
  protected final String TEXT_993 = NL;
  protected final String TEXT_994 = NL + "\t\t\tprivate ";
  protected final String TEXT_995 = " createDomainModelRemoveCommand(";
  protected final String TEXT_996 = " editingDomain) {";
  protected final String TEXT_997 = NL + "\t\t\t\t";
  protected final String TEXT_998 = " result = new ";
  protected final String TEXT_999 = "();";
  protected final String TEXT_1000 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1001 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1002 = ".getElement().eContainer(), ";
  protected final String TEXT_1003 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_1004 = ".getElement()));";
  protected final String TEXT_1005 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1006 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1007 = ".getElement().eContainer(), ";
  protected final String TEXT_1008 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_1009 = ".UNSET_VALUE));";
  protected final String TEXT_1010 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1011 = ".INSTANCE;";
  protected final String TEXT_1012 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1013 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1014 = ".getElement().eContainer(), ";
  protected final String TEXT_1015 = ".eINSTANCE.get";
  protected final String TEXT_1016 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1017 = ".getElement()));";
  protected final String TEXT_1018 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1019 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1020 = ".getElement().eContainer(), ";
  protected final String TEXT_1021 = ".eINSTANCE.get";
  protected final String TEXT_1022 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_1023 = ".UNSET_VALUE));";
  protected final String TEXT_1024 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1025 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1026 = ".getElement(), ";
  protected final String TEXT_1027 = ".eINSTANCE.get";
  protected final String TEXT_1028 = "(), ";
  protected final String TEXT_1029 = ".getSource().getElement()));";
  protected final String TEXT_1030 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1031 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1032 = ".getElement(), ";
  protected final String TEXT_1033 = ".eINSTANCE.get";
  protected final String TEXT_1034 = "(), ";
  protected final String TEXT_1035 = ".UNSET_VALUE));";
  protected final String TEXT_1036 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1037 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1038 = ".getElement(), ";
  protected final String TEXT_1039 = ".eINSTANCE.get";
  protected final String TEXT_1040 = "(), ";
  protected final String TEXT_1041 = ".getTarget().getElement()));";
  protected final String TEXT_1042 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_1043 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1044 = ".getElement(), ";
  protected final String TEXT_1045 = ".eINSTANCE.get";
  protected final String TEXT_1046 = "(), ";
  protected final String TEXT_1047 = ".UNSET_VALUE));";
  protected final String TEXT_1048 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_1049 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1050 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1051 = ".getSource().getElement(), ";
  protected final String TEXT_1052 = ".eINSTANCE.get";
  protected final String TEXT_1053 = "(), ";
  protected final String TEXT_1054 = ".getTarget().getElement());";
  protected final String TEXT_1055 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1056 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_1057 = ".getSource().getElement(), ";
  protected final String TEXT_1058 = ".eINSTANCE.get";
  protected final String TEXT_1059 = "(), ";
  protected final String TEXT_1060 = ".UNSET_VALUE);";
  protected final String TEXT_1061 = NL + "\t\t\t}";
  protected final String TEXT_1062 = NL + "\t}" + NL;
  protected final String TEXT_1063 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_1064 = "Command extends ";
  protected final String TEXT_1065 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1066 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1067 = " target;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_1068 = " createdEdge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_1069 = "Command(";
  protected final String TEXT_1070 = ".CreateConnectionRequestEx requestEx) {" + NL + "\t\t\tif (requestEx.getSourceEditPart().getModel() instanceof ";
  protected final String TEXT_1071 = ") {" + NL + "\t\t\t\tsource = (";
  protected final String TEXT_1072 = ")requestEx.getSourceEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tsource = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (requestEx.getTargetEditPart().getModel() instanceof ";
  protected final String TEXT_1073 = ") {" + NL + "\t\t\t\ttarget = (";
  protected final String TEXT_1074 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (source == null || target == null) {" + NL + "\t\t\t\tcreatedEdge = null;" + NL + "\t\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1075 = ".INSTANCE;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedEdge = ";
  protected final String TEXT_1076 = ".eINSTANCE.createEdge();";
  protected final String TEXT_1077 = NL + "\t\t\t";
  protected final String TEXT_1078 = " createdDomainElement = ";
  protected final String TEXT_1079 = ".eINSTANCE.create";
  protected final String TEXT_1080 = "();" + NL + "\t\t\tcreatedEdge.setElement(createdDomainElement);" + NL + "\t\t\t";
  protected final String TEXT_1081 = NL + "\t\t\t";
  protected final String TEXT_1082 = ".";
  protected final String TEXT_1083 = ".initializeElement(createdDomainElement);";
  protected final String TEXT_1084 = NL + "\t\t\tcreatedEdge.setElement(null);";
  protected final String TEXT_1085 = NL + "\t\t\t";
  protected final String TEXT_1086 = ".decorateView(createdEdge);" + NL + "\t\t\t";
  protected final String TEXT_1087 = " domainModelEditDomain = ";
  protected final String TEXT_1088 = ".getEditingDomain(source.getDiagram().getElement());";
  protected final String TEXT_1089 = NL + "\t\t\torg.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();";
  protected final String TEXT_1090 = NL + "\t\t\t";
  protected final String TEXT_1091 = " container = getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_1092 = ".eINSTANCE.get";
  protected final String TEXT_1093 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\tdomainModelAddCommand = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1094 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1095 = ".eINSTANCE.get";
  protected final String TEXT_1096 = "(), createdDomainElement));";
  protected final String TEXT_1097 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1098 = ".create(domainModelEditDomain," + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_1099 = ".eINSTANCE.get";
  protected final String TEXT_1100 = "(), createdDomainElement));";
  protected final String TEXT_1101 = NL;
  protected final String TEXT_1102 = NL + "\t\tif (";
  protected final String TEXT_1103 = ".";
  protected final String TEXT_1104 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_1105 = NL + "\t\t}";
  protected final String TEXT_1106 = NL + "\t\tif (";
  protected final String TEXT_1107 = ".";
  protected final String TEXT_1108 = "().size() >= ";
  protected final String TEXT_1109 = ".eINSTANCE.get";
  protected final String TEXT_1110 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1111 = NL + "\t\t}";
  protected final String TEXT_1112 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1113 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1114 = ".eINSTANCE.get";
  protected final String TEXT_1115 = "(), source.getElement()));";
  protected final String TEXT_1116 = NL;
  protected final String TEXT_1117 = NL + "\t\tif (";
  protected final String TEXT_1118 = ".";
  protected final String TEXT_1119 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_1120 = NL + "\t\t}";
  protected final String TEXT_1121 = NL + "\t\tif (";
  protected final String TEXT_1122 = ".";
  protected final String TEXT_1123 = "().size() >= ";
  protected final String TEXT_1124 = ".eINSTANCE.get";
  protected final String TEXT_1125 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_1126 = NL + "\t\t}";
  protected final String TEXT_1127 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_1128 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_1129 = ".eINSTANCE.get";
  protected final String TEXT_1130 = "(), target.getElement()));";
  protected final String TEXT_1131 = NL + "\t\tdomainModelAddCommand = addLinkEndsCommand;";
  protected final String TEXT_1132 = NL + "\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_1133 = ".create(domainModelEditDomain, source.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_1134 = ".eINSTANCE.get";
  protected final String TEXT_1135 = "(), target.getElement());";
  protected final String TEXT_1136 = NL + "\t\t}" + NL;
  protected final String TEXT_1137 = NL;
  protected final String TEXT_1138 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_1139 = " getRelationshipContainer(";
  protected final String TEXT_1140 = " element, ";
  protected final String TEXT_1141 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_1142 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (source == null || target == null || createdEdge == null || domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1143 = NL;
  protected final String TEXT_1144 = NL + "\t\t\tif(!";
  protected final String TEXT_1145 = ".canCreateLink(";
  protected final String TEXT_1146 = ", ";
  protected final String TEXT_1147 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_1148 = NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tsource.getDiagram().insertEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(source);" + NL + "\t\t\tcreatedEdge.setTarget(target);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t\tsource.getDiagram().removeEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(null);" + NL + "\t\t\tcreatedEdge.setTarget(null);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_1149 = NL;
  protected final String TEXT_1150 = NL;
  protected final String TEXT_1151 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_1152 = NL + "}";
  protected final String TEXT_1153 = NL;

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
importManager.registerInnerClass("LinkDescriptor");	//from linkNotationModelRefresher.jetinc

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_35);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_38);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_42);
    
	} else {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_47);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_51);
    
	} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_56);
    
	}

    stringBuffer.append(TEXT_57);
    
} else {
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
}

    stringBuffer.append(TEXT_67);
    
}	/*restrict local vars used in component edit policy*/

    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_89);
    
if (!myHelper.hasIncomingLinks()) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_91);
    
} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_102);
    
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

    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_105);
    
	}

    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_108);
    
}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_111);
    
if (!myHelper.hasOutgoingLinks()) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_113);
    
} else {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_124);
    
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

    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_127);
    
	}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_130);
    
}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_133);
    if (palette != null && myHelper.hasOutgoingLinks()) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_139);
    
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

    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_142);
    
}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_145);
    }/*when there's palette*/
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_148);
    if (palette != null && myHelper.hasIncomingLinks()) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_155);
    
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

    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_158);
    
}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_161);
    }/*when there's palette*/
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_163);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_164);
    
}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_172);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_174);
    if (isXYLayout) {
    stringBuffer.append(TEXT_175);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_176);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_177);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_178);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_179);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_181);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_182);
    }
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_187);
    }
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_202);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_203);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_205);
    } else {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_213);
    
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_215);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_216);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_220);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_221);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_225);
    	
} // for pinned compartments

    stringBuffer.append(TEXT_226);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_227);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_231);
    
} // for pinned compartments

    stringBuffer.append(TEXT_232);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_234);
    
		GenNodeLabel firstEditableLabel = null;
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (!genLabel.isReadOnly()) {
				firstEditableLabel = genLabel;
				break;
			}
		}
		if (firstEditableLabel != null) {

    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName(firstEditableLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_241);
    
		}

    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_253);
    
		for (Iterator it = myHelper.getAllInnerLabels(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_255);
    
		}

    stringBuffer.append(TEXT_256);
    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_258);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_260);
    
	}

    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_265);
    
}
if (myHelper.hasExternalLabels() || myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_267);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_270);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_271);
    
	}

    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_273);
    
	if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_276);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_277);
    
	}

    stringBuffer.append(TEXT_278);
    
}

    
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_283);
    
}

    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_305);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_306);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_307);
    
}

    stringBuffer.append(TEXT_308);
    
if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_309);
    
}

    stringBuffer.append(TEXT_310);
    
{
	final String _getViewCode = "getDiagramNode()";
	final String _getDiagramCode = "getDiagramNode().getDiagram()";
	final String _getSemanticElementCode = "getDiagramNode().getElement()";
	final boolean _includeUncontainedLinks = false;

    stringBuffer.append(TEXT_311);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetListenerImpl"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_318);
    
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

    stringBuffer.append(TEXT_319);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_322);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_332);
    
	}

    stringBuffer.append(TEXT_333);
    
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

    stringBuffer.append(TEXT_334);
    
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

    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_338);
    
	} else {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_342);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_343);
    
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

    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_347);
    
	} else {

    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_351);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_352);
    
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

    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_356);
    
	} else {

    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_360);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_361);
    
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

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_370);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_371);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_372);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_373);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_375);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetChangeEvent"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(TEXT_385);
    /*inner class*/
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_402);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_414);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_419);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReplaceNotationalElementCommand"));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_426);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_441);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_456);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_468);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_469);
    
	for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_470);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_472);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_473);
    
	}
	for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_474);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_476);
    
	}

    stringBuffer.append(TEXT_477);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_479);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_482);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_483);
    
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

    stringBuffer.append(TEXT_484);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_485);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_487);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_488);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_489);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_490);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_491);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_493);
    
	} else {

    stringBuffer.append(TEXT_494);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_495);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_496);
    
	}

    stringBuffer.append(TEXT_497);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_498);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_499);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_500);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_501);
    
		} else {

    stringBuffer.append(TEXT_502);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_503);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_504);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_505);
    stringBuffer.append(importManager.getImportedName(modelFacet.getSourceMetaFeature().getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_506);
    stringBuffer.append(modelFacet.getSourceMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_507);
    
		} else {

    stringBuffer.append(TEXT_508);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_509);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_510);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_511);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(importManager.getImportedName(modelFacet.getTargetMetaFeature().getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_513);
    stringBuffer.append(modelFacet.getTargetMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_514);
    
		} else {

    stringBuffer.append(TEXT_515);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_517);
    
		}

    stringBuffer.append(TEXT_518);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_519);
    
		} else {

    stringBuffer.append(TEXT_520);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_521);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_522);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_523);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_527);
    
	} else {

    stringBuffer.append(TEXT_528);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_530);
    
	}

    stringBuffer.append(TEXT_531);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_532);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_533);
    
	}

    stringBuffer.append(TEXT_534);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_535);
    
	}
}

    stringBuffer.append(TEXT_536);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_537);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_543);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_544);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_545);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_546);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_547);
    
	}

    
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_548);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_550);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_551);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_552);
    
		}

    stringBuffer.append(TEXT_553);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_554);
    
		} else {

    stringBuffer.append(TEXT_555);
    
		}
	}
	

    
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_556);
    
		}

    stringBuffer.append(TEXT_557);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_559);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_560);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_561);
    
		}

    stringBuffer.append(TEXT_562);
    
	}

    stringBuffer.append(TEXT_563);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_564);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_565);
    
}

    
}	//end of local declarations

    stringBuffer.append(TEXT_566);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_569);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_576);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_577);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_578);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_579);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_580);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_584);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_588);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_589);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_590);
    
}

    stringBuffer.append(TEXT_591);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_592);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_593);
    
}

    stringBuffer.append(TEXT_594);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_602);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_603);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_604);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_608);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_609);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_610);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_611);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_612);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_615);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_616);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_618);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_621);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_622);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_625);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_626);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_627);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_628);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_629);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_632);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_642);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_643);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_647);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_648);
    
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

    stringBuffer.append(TEXT_649);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_650);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_651);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_654);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_655);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_656);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_657);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_658);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_659);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_660);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_662);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_663);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_664);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_665);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_666);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_667);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_668);
    
	} else {

    stringBuffer.append(TEXT_669);
    
	}

    stringBuffer.append(TEXT_670);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
			if (containmentFeature == null) {

    stringBuffer.append(TEXT_671);
    
			} else {

    stringBuffer.append(TEXT_672);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_673);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_674);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_675);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_676);
    
				{
					GenFeature _feature = containmentFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_677);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_678);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_680);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_681);
    
	} else {

    stringBuffer.append(TEXT_682);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_684);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_685);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_686);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_687);
    
	}
}

    
				}
				GenFeature childFeature = modelFacet.getChildMetaFeature();
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					{
						GenFeature _feature = childFeature;
						String _ownerInstance = "container";
						String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_688);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_689);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_691);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_692);
    
	} else {

    stringBuffer.append(TEXT_693);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_695);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_697);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_698);
    
	}
}

    
					}
				}
			}
			//No need to check the size of the source or target features: their size does not change
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_699);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_700);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_701);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_703);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_704);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			{
				GenFeature _feature = metaFeature;
				String _ownerInstance = "((" + importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()) + ") newSource.getElement())";
				String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_705);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_706);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_708);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_709);
    
	} else {

    stringBuffer.append(TEXT_710);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_712);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_713);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_714);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_715);
    
	}
}

    
			}
{
	String _source = "newSource.getElement()";
	String _target = "edge.getTarget().getElement()";

    stringBuffer.append(TEXT_716);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_717);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_718);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_720);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_721);
    
		} else {

    stringBuffer.append(TEXT_722);
    
		}

    stringBuffer.append(TEXT_723);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_725);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_726);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_727);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_729);
    
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

    stringBuffer.append(TEXT_730);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_731);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_732);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_733);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_735);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_736);
    
			}
			if (containmentFeature != null) {
				if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_737);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_738);
    
				} else {

    stringBuffer.append(TEXT_739);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_740);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_741);
    
				}

    stringBuffer.append(TEXT_742);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_744);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_745);
    
			}
			if (setChild) {
				if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_746);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_748);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_749);
    
				} else {

    stringBuffer.append(TEXT_750);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_751);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_752);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_753);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_754);
    
				}

    stringBuffer.append(TEXT_755);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_757);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_758);
    
			}

    stringBuffer.append(TEXT_759);
    
			if (setSource) {
				if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_760);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_762);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_763);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_764);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_765);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_766);
    
				} else {

    stringBuffer.append(TEXT_767);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_769);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_770);
    
				}
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_771);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_772);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_773);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_774);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_777);
    
			} else {

    stringBuffer.append(TEXT_778);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_781);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_783);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_784);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_785);
    
			}
		}

    stringBuffer.append(TEXT_786);
    stringBuffer.append(TEXT_787);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_788);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_789);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_790);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_791);
    
		}

    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_792);
    
	//input: _edge : String

    stringBuffer.append(TEXT_793);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_795);
    
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

    stringBuffer.append(TEXT_796);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_798);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_799);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_803);
    
			} else {

    stringBuffer.append(TEXT_804);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_805);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_806);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_808);
    
			}
		} else {

    stringBuffer.append(TEXT_809);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_810);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_811);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_815);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_816);
    
			} else {

    stringBuffer.append(TEXT_817);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_818);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_819);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_821);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_822);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_823);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_824);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_826);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_827);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_828);
    
			} else {

    stringBuffer.append(TEXT_829);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_831);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_833);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_834);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_835);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_836);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_839);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_840);
    
			} else {

    stringBuffer.append(TEXT_841);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_844);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_845);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_846);
    
			}
		}

    stringBuffer.append(TEXT_847);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_848);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_849);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_850);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_851);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_852);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_853);
    
		} else {

    stringBuffer.append(TEXT_854);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_856);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_859);
    
		}

    
	}

    stringBuffer.append(TEXT_860);
    
	}

    stringBuffer.append(TEXT_861);
    
	if (palette != null) {

    stringBuffer.append(TEXT_862);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_863);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_864);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_865);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_866);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_867);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
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

    stringBuffer.append(TEXT_875);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_876);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_878);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_879);
    
	} else {

    stringBuffer.append(TEXT_880);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_882);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_884);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_885);
    
	}
}

    
				}
				GenFeature childFeature = modelFacet.getChildMetaFeature();
				if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
					{
						GenFeature _feature = childFeature;
						String _ownerInstance = "container";
						String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_886);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_887);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_888);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_889);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_890);
    
	} else {

    stringBuffer.append(TEXT_891);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_892);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_893);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_895);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_896);
    
	}
}

    
					}
				}
{
	String _source = "source.getElement()";
	String _target = "null";

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
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		{
			GenFeature _feature = metaFeature;
			String _ownerInstance = "((" + importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()) + ") source.getElement())";
			String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_903);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_904);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_905);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_906);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_907);
    
	} else {

    stringBuffer.append(TEXT_908);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_911);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_912);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_913);
    
	}
}

    
		}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_914);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_915);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_916);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_918);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_919);
    
		} else {

    stringBuffer.append(TEXT_920);
    
		}

    stringBuffer.append(TEXT_921);
    stringBuffer.append(TEXT_922);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_923);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_925);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_926);
    
		}

    stringBuffer.append(TEXT_927);
    
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

    stringBuffer.append(TEXT_928);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_929);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_930);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_931);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_932);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_935);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(reconnectCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_939);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_941);
    
	if (linkConstraints != null) {

    stringBuffer.append(TEXT_942);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_944);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_946);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_947);
    
	} else {

    stringBuffer.append(TEXT_948);
    
	}

    stringBuffer.append(TEXT_949);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_950);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_951);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_952);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_954);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_955);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
{
	String _source = "edge.getSource().getElement()";
	String _target = "newTarget.getElement()";

    stringBuffer.append(TEXT_956);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_957);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_958);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_959);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_960);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_961);
    
		} else {

    stringBuffer.append(TEXT_962);
    
		}

    stringBuffer.append(TEXT_963);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_964);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_965);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_966);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_969);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenFeature targetFeature = modelFacet.getTargetMetaFeature();
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_970);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_973);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_976);
    
			} else {

    stringBuffer.append(TEXT_977);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_978);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_979);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_980);
    
			}
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
			if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_981);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_982);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_983);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_984);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_985);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_987);
    
			} else {

    stringBuffer.append(TEXT_988);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_991);
    
			}
		}

    stringBuffer.append(TEXT_992);
    
	if (linkConstraints != null) {
		String _edge = "edge";

    stringBuffer.append(TEXT_993);
    
	//input: _edge : String

    stringBuffer.append(TEXT_994);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_995);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_996);
    
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

    stringBuffer.append(TEXT_997);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_998);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_999);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1000);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1004);
    
			} else {

    stringBuffer.append(TEXT_1005);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1009);
    
			}
		} else {

    stringBuffer.append(TEXT_1010);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1011);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1012);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1017);
    
			} else {

    stringBuffer.append(TEXT_1018);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1023);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1024);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1029);
    
			} else {

    stringBuffer.append(TEXT_1030);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1035);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1036);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1041);
    
			} else {

    stringBuffer.append(TEXT_1042);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1047);
    
			}
		}

    stringBuffer.append(TEXT_1048);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_1049);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1054);
    
		} else {

    stringBuffer.append(TEXT_1055);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1060);
    
		}

    
	}

    stringBuffer.append(TEXT_1061);
    
	}

    stringBuffer.append(TEXT_1062);
    
	if (palette != null) {

    stringBuffer.append(TEXT_1063);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_1076);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			GenClass linkClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_1077);
    stringBuffer.append(importManager.getImportedName(importManager.getImportedName(linkClass.getQualifiedInterfaceName())));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(importManager.getImportedName(linkClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(linkClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_1080);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_1083);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_1084);
    
		}

    stringBuffer.append(TEXT_1085);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_1088);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1089);
    
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

    stringBuffer.append(TEXT_1090);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1096);
    
			}
			if (addChild) {

    stringBuffer.append(TEXT_1097);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1100);
    
			}
			if (addSource) {
				{
					GenFeature _feature = sourceFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";

    stringBuffer.append(TEXT_1101);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1102);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1105);
    
	} else {

    stringBuffer.append(TEXT_1106);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1111);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1112);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1115);
    
			}
			if (addTarget) {
				{
					GenFeature _feature = targetFeature;
					String _ownerInstance = "createdDomainElement";
					String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";

    stringBuffer.append(TEXT_1116);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_1117);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1120);
    
	} else {

    stringBuffer.append(TEXT_1121);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_1126);
    
	}
}

    
				}

    stringBuffer.append(TEXT_1127);
    stringBuffer.append(importManager.getImportedName(targetFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1130);
    
			}

    stringBuffer.append(TEXT_1131);
    
		} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_1132);
    stringBuffer.append(importManager.getImportedName(metaFeature.getEcoreFeature().isMany()? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_1135);
    
		}

    stringBuffer.append(TEXT_1136);
    stringBuffer.append(TEXT_1137);
    
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_1138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_1141);
    
		}

    stringBuffer.append(TEXT_1142);
    
{
	String _source = "source.getElement()";
	String _target = "target.getElement()";

    stringBuffer.append(TEXT_1143);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_1144);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_1147);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_1148);
    
	}

    }/*when there's palette*/
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_1149);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_1150);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_1151);
    
}

    
}

    stringBuffer.append(TEXT_1152);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_1153);
    return stringBuffer.toString();
  }
}
