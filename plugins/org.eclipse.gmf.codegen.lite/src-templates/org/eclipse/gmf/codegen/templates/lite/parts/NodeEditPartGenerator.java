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
  protected final String TEXT_83 = " request) {" + NL + "\t\t\t\t//XXX: reconnect command" + NL + "\t\t\t\treturn ";
  protected final String TEXT_84 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_85 = " getReconnectSourceCommand(";
  protected final String TEXT_86 = " request) {" + NL + "\t\t\t\t//XXX: reconnect command" + NL + "\t\t\t\treturn ";
  protected final String TEXT_87 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_88 = " getConnectionCreateCommand(";
  protected final String TEXT_89 = " request) {";
  protected final String TEXT_90 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_91 = ".CreateConnectionRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_92 = ".CreateConnectionRequestEx requestEx = (";
  protected final String TEXT_93 = ".CreateConnectionRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = " result = new ";
  protected final String TEXT_95 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_97 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_98 = "StartCommand(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1 || !result.canExecute()) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\t//returning an unexecutable command does not change cursor to \"No\"." + NL + "\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = " wrappedResult = new WrappingCommand(";
  protected final String TEXT_101 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t\trequest.setStartCommand(wrappedResult);" + NL + "\t\t\t\t\treturn wrappedResult;" + NL + "\t\t\t\t}";
  protected final String TEXT_102 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected ";
  protected final String TEXT_103 = " getConnectionCompleteCommand(";
  protected final String TEXT_104 = " request) {";
  protected final String TEXT_105 = NL + "\t\t\t\tif (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_106 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_107 = ".CreateConnectionRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_108 = ".CreateConnectionRequestEx requestEx = (";
  protected final String TEXT_109 = ".CreateConnectionRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_110 = " result = new ";
  protected final String TEXT_111 = "();" + NL + "\t\t\t\t\tfor (int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_113 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_114 = "Command(requestEx));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (result.getCommandList().size() != 1) {" + NL + "\t\t\t\t\t\t//Cannot create several connections at once." + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_116 = ".INSTANCE;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_117 = ".getEditingDomain(getDiagramNode().getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_118 = NL + "\t\t\t\treturn ";
  protected final String TEXT_119 = ".INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_120 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_121 = " invisibleRectangle = new ";
  protected final String TEXT_122 = "();" + NL + "\t\tinvisibleRectangle.setLayoutManager(new ";
  protected final String TEXT_123 = "());" + NL + "\t\t";
  protected final String TEXT_124 = " shape = createNodeShape();" + NL + "\t\tinvisibleRectangle.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_125 = " decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tinvisibleRectangle.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn invisibleRectangle;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_126 = " createNodeShape() {";
  protected final String TEXT_127 = NL + "\t\tprimaryShape = new ";
  protected final String TEXT_128 = "()";
  protected final String TEXT_129 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_130 = ";";
  protected final String TEXT_131 = NL + "\t\tprimaryShape = ";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = NL + "\t\t";
  protected final String TEXT_134 = " figure = new ";
  protected final String TEXT_135 = "();";
  protected final String TEXT_136 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_137 = NL + " \t\tprimaryShape = figure;";
  protected final String TEXT_138 = NL + "\t\treturn primaryShape;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_139 = " createDecorationPane() {" + NL + "\t\t";
  protected final String TEXT_140 = " view = (";
  protected final String TEXT_141 = ") getModel();" + NL + "\t\t";
  protected final String TEXT_142 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_143 = " decorationPane = new ";
  protected final String TEXT_144 = "();" + NL + "\t\tdecorationPane.setLayoutManager(new ";
  protected final String TEXT_145 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_146 = " imageFigure = new ";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), ";
  protected final String TEXT_149 = ".EAST);" + NL + "\t\tdecorationPane.add(imageFigure, ";
  protected final String TEXT_150 = ".BOTTOM);" + NL + " \t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_151 = " setupContentPane(";
  protected final String TEXT_152 = " nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_153 = NL + "\t\t\t";
  protected final String TEXT_154 = " layout = new ";
  protected final String TEXT_155 = "();" + NL + "\t\t\tlayout.setSpacing(5);" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_156 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_157 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(";
  protected final String TEXT_158 = " figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_159 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_160 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_161 = " getContentPane() {" + NL + "\t\tif (contentPane == null) {" + NL + "\t\t\treturn super.getContentPane();" + NL + "\t\t}" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_162 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_163 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_164 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(";
  protected final String TEXT_165 = " childEditPart) {";
  protected final String TEXT_166 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_167 = ") {";
  protected final String TEXT_168 = NL + "\t\t\t((";
  protected final String TEXT_169 = ") childEditPart).setLabel(((";
  protected final String TEXT_170 = ") primaryShape).getFigure";
  protected final String TEXT_171 = "());";
  protected final String TEXT_172 = NL + "\t\t\t((";
  protected final String TEXT_173 = ") childEditPart).setLabel(new ";
  protected final String TEXT_174 = "());";
  protected final String TEXT_175 = NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_176 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_177 = " getPrimaryLabelEditPart() {";
  protected final String TEXT_178 = NL + "\t\tfor(";
  protected final String TEXT_179 = " it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_180 = " nextChild = (";
  protected final String TEXT_181 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_182 = ".getVisualID(nextChild) == ";
  protected final String TEXT_183 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_184 = ") getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_185 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_186 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_187 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_188 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_189 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_190 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_191 = " getLabelEditPart(";
  protected final String TEXT_192 = " req) {" + NL + "\t\t";
  protected final String TEXT_193 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_194 = " view = (";
  protected final String TEXT_195 = ") result.getModel();" + NL + "\t\t\tif (getDiagramNode().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_196 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_197 = NL + "\t\t\t\tcase ";
  protected final String TEXT_198 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_199 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_200 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_201 = " childEditPart, int index) {" + NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_202 = " labelFigure = ((";
  protected final String TEXT_203 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t} else {";
  protected final String TEXT_204 = NL + "\t\t\tif (!addFixedChild(childEditPart)) {" + NL + "\t\t\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t\t\t}";
  protected final String TEXT_205 = NL + "\t\t\tsuper.addChildVisual(childEditPart, -1);";
  protected final String TEXT_206 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_207 = " childEditPart) {" + NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t";
  protected final String TEXT_208 = " labelFigure = ((";
  protected final String TEXT_209 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_210 = " childEditPart) {";
  protected final String TEXT_211 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_212 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_213 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_214 = " getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_215 = " root = (";
  protected final String TEXT_216 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_217 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_218 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_219 = " childEditPart, int index) {" + NL + "\t\tif (!addFixedChild(childEditPart)) {" + NL + "\t\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_220 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshBounds();" + NL + "\t\trefreshBackgroundColor();" + NL + "\t\trefreshForegroundColor();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\t";
  protected final String TEXT_221 = " node = getDiagramNode();" + NL + "\t\tassert node.getLayoutConstraint() instanceof ";
  protected final String TEXT_222 = ";" + NL + "\t\t";
  protected final String TEXT_223 = " bounds = (";
  protected final String TEXT_224 = ") node.getLayoutConstraint();" + NL + "\t\t((";
  protected final String TEXT_225 = ") getParent()).setLayoutConstraint(this, getFigure(), " + NL + "\t\t\tnew ";
  protected final String TEXT_226 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_227 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_228 = " getModelSourceConnections() {" + NL + "\t\treturn getDiagramNode().getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_229 = " getModelTargetConnections() {" + NL + "\t\treturn getDiagramNode().getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_230 = " getSourceConnectionAnchor(";
  protected final String TEXT_231 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_232 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_233 = " getSourceConnectionAnchor(";
  protected final String TEXT_234 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_235 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_236 = "  getTargetConnectionAnchor(";
  protected final String TEXT_237 = " connection) {" + NL + "\t\treturn new ";
  protected final String TEXT_238 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_239 = "  getTargetConnectionAnchor(";
  protected final String TEXT_240 = " request) {" + NL + "\t\treturn new ";
  protected final String TEXT_241 = "(getFigure());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_242 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_243 = NL;
  protected final String TEXT_244 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_245 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_246 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_247 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_248 = NL;
  protected final String TEXT_249 = "\tpublic void addRefresher(";
  protected final String TEXT_250 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_251 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_252 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_253 = NL;
  protected final String TEXT_254 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {" + NL + "\t\t";
  protected final String TEXT_255 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_256 = ") ";
  protected final String TEXT_257 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_258 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_259 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_260 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_261 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_262 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_263 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_264 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_265 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_266 = " createdFont;" + NL;
  protected final String TEXT_267 = NL;
  protected final String TEXT_268 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshForegroundColor() {" + NL + "\t\t";
  protected final String TEXT_269 = " style = (";
  protected final String TEXT_270 = ")  ";
  protected final String TEXT_271 = ".getStyle(";
  protected final String TEXT_272 = ".eINSTANCE.getLineStyle());" + NL + "\t\t";
  protected final String TEXT_273 = " toDispose = createdForegroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint foregroundColor = style.getLineColor();" + NL + "\t\t\tint red = foregroundColor & 0x000000FF;" + NL + "\t\t\tint green = (foregroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (foregroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_274 = " currentColor = getFigure().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedForegroundColor = new ";
  protected final String TEXT_275 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdForegroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedForegroundColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshForegroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_276 = " createdForegroundColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBackgroundColor() {" + NL + "\t\t";
  protected final String TEXT_277 = " style = (";
  protected final String TEXT_278 = ")  ";
  protected final String TEXT_279 = ".getStyle(";
  protected final String TEXT_280 = ".eINSTANCE.getFillStyle());" + NL + "\t\t";
  protected final String TEXT_281 = " toDispose = createdBackgroundColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint backgroundColor = style.getFillColor();" + NL + "\t\t\tint red = backgroundColor & 0x000000FF;" + NL + "\t\t\tint green = (backgroundColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (backgroundColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_282 = " currentColor = getFigure().getBackgroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedBackgroundColor = new ";
  protected final String TEXT_283 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setBackgroundColor(createdBackgroundColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setBackgroundColor(getViewer().getControl().getBackground());" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshBackgroundColor()}) currently assigned to the figure." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_284 = " createdBackgroundColor;" + NL;
  protected final String TEXT_285 = NL;
  protected final String TEXT_286 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_287 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_288 = " feature, ";
  protected final String TEXT_289 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new ";
  protected final String TEXT_290 = "();";
  protected final String TEXT_291 = NL;
  protected final String TEXT_292 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_293 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_294 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_295 = NL;
  protected final String TEXT_296 = "\t\tRefresher boundsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBounds();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_297 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_298 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_299 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_300 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_301 = ".eINSTANCE.getLocation_Y(), boundsRefresher);";
  protected final String TEXT_302 = NL;
  protected final String TEXT_303 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_304 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_305 = NL;
  protected final String TEXT_306 = "\t\tRefresher sourceEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshSourceConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_307 = ".eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);";
  protected final String TEXT_308 = NL;
  protected final String TEXT_309 = "\t\tRefresher targetEdgesRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshTargetConnections();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_310 = ".eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);";
  protected final String TEXT_311 = NL;
  protected final String TEXT_312 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_313 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_314 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_315 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_316 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_317 = NL;
  protected final String TEXT_318 = "\t\tRefresher backgroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBackgroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_319 = ".eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);" + NL + "\t\tRefresher foregroundColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshForegroundColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_320 = ".eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_321 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_322 = "StartCommand extends ";
  protected final String TEXT_323 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_324 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_325 = "StartCommand(";
  protected final String TEXT_326 = ".CreateConnectionRequestEx requestEx) {" + NL + "\t\t\t//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart()." + NL + "\t\t\tsource = (";
  protected final String TEXT_327 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\t//This command never gets executed" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\tif (source == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_328 = NL + "\t\t\treturn false;";
  protected final String TEXT_329 = NL + "\t\t\t";
  protected final String TEXT_330 = " container = (";
  protected final String TEXT_331 = ")getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_332 = ".eINSTANCE.get";
  protected final String TEXT_333 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_334 = NL;
  protected final String TEXT_335 = NL + "\t\tif (";
  protected final String TEXT_336 = ".";
  protected final String TEXT_337 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_338 = NL + "\t\t}";
  protected final String TEXT_339 = NL + "\t\tif (";
  protected final String TEXT_340 = ".";
  protected final String TEXT_341 = "().size() >= ";
  protected final String TEXT_342 = ".eINSTANCE.get";
  protected final String TEXT_343 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_344 = NL + "\t\t}";
  protected final String TEXT_345 = NL;
  protected final String TEXT_346 = NL + "\t\tif (";
  protected final String TEXT_347 = ".";
  protected final String TEXT_348 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_349 = NL + "\t\t}";
  protected final String TEXT_350 = NL + "\t\tif (";
  protected final String TEXT_351 = ".";
  protected final String TEXT_352 = "().size() >= ";
  protected final String TEXT_353 = ".eINSTANCE.get";
  protected final String TEXT_354 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_355 = NL + "\t\t}";
  protected final String TEXT_356 = NL;
  protected final String TEXT_357 = NL + "\t\t\tif(!";
  protected final String TEXT_358 = ".canCreateLink(";
  protected final String TEXT_359 = ", ";
  protected final String TEXT_360 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_361 = NL + "\t\t\treturn true;";
  protected final String TEXT_362 = NL + "\t\t\t";
  protected final String TEXT_363 = " domainElement = (";
  protected final String TEXT_364 = ")source.getElement();";
  protected final String TEXT_365 = NL;
  protected final String TEXT_366 = NL + "\t\tif (";
  protected final String TEXT_367 = ".";
  protected final String TEXT_368 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_369 = NL + "\t\t}";
  protected final String TEXT_370 = NL + "\t\tif (";
  protected final String TEXT_371 = ".";
  protected final String TEXT_372 = "().size() >= ";
  protected final String TEXT_373 = ".eINSTANCE.get";
  protected final String TEXT_374 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_375 = NL + "\t\t}";
  protected final String TEXT_376 = NL;
  protected final String TEXT_377 = NL + "\t\t\tif(!";
  protected final String TEXT_378 = ".canCreateLink(";
  protected final String TEXT_379 = ", ";
  protected final String TEXT_380 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_381 = NL + "\t\t\treturn true;";
  protected final String TEXT_382 = NL + "\t\t\treturn false;";
  protected final String TEXT_383 = NL + "\t\t}";
  protected final String TEXT_384 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the new relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_385 = " getRelationshipContainer(";
  protected final String TEXT_386 = " element, ";
  protected final String TEXT_387 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_388 = NL + NL + "\t}";
  protected final String TEXT_389 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_390 = "Command extends ";
  protected final String TEXT_391 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_392 = " source;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_393 = " target;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_394 = " createdEdge;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_395 = "Command(";
  protected final String TEXT_396 = ".CreateConnectionRequestEx requestEx) {" + NL + "\t\t\tif (requestEx.getSourceEditPart().getModel() instanceof ";
  protected final String TEXT_397 = ") {" + NL + "\t\t\t\tsource = (";
  protected final String TEXT_398 = ")requestEx.getSourceEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tsource = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (requestEx.getTargetEditPart().getModel() instanceof ";
  protected final String TEXT_399 = ") {" + NL + "\t\t\t\ttarget = (";
  protected final String TEXT_400 = ")requestEx.getTargetEditPart().getModel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget = null;" + NL + "\t\t\t}" + NL + "\t\t\tif (source == null || target == null) {" + NL + "\t\t\t\tcreatedEdge = null;" + NL + "\t\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_401 = ".INSTANCE;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedEdge = ";
  protected final String TEXT_402 = ".eINSTANCE.createEdge();";
  protected final String TEXT_403 = NL + "\t\t\t";
  protected final String TEXT_404 = " createdDomainElement = ";
  protected final String TEXT_405 = ".eINSTANCE.create";
  protected final String TEXT_406 = "();" + NL + "\t\t\tcreatedEdge.setElement(createdDomainElement);" + NL + "\t\t\t";
  protected final String TEXT_407 = NL + "\t\t\t";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = ".initializeElement(createdDomainElement);";
  protected final String TEXT_410 = NL + "\t\t\tcreatedEdge.setElement(target.getElement());\t\t//XXX: is this correct?";
  protected final String TEXT_411 = NL + "\t\t\t";
  protected final String TEXT_412 = ".decorateView(createdEdge);" + NL + "\t\t\t";
  protected final String TEXT_413 = " domainModelEditDomain = ";
  protected final String TEXT_414 = ".getEditingDomain(source.getDiagram().getElement());";
  protected final String TEXT_415 = NL + "\t\t\torg.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();";
  protected final String TEXT_416 = NL + "\t\t\t";
  protected final String TEXT_417 = " container = getRelationshipContainer(source.getElement(), ";
  protected final String TEXT_418 = ".eINSTANCE.get";
  protected final String TEXT_419 = "());" + NL + "\t\t\tif (container == null) {" + NL + "\t\t\t\tdomainModelAddCommand = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_420 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_421 = ".eINSTANCE.get";
  protected final String TEXT_422 = "(), createdDomainElement));";
  protected final String TEXT_423 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_424 = ".create(domainModelEditDomain," + NL + "\t\t\t\tcontainer, ";
  protected final String TEXT_425 = ".eINSTANCE.get";
  protected final String TEXT_426 = "(), createdDomainElement));";
  protected final String TEXT_427 = NL;
  protected final String TEXT_428 = NL + "\t\tif (";
  protected final String TEXT_429 = ".";
  protected final String TEXT_430 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_431 = NL + "\t\t}";
  protected final String TEXT_432 = NL + "\t\tif (";
  protected final String TEXT_433 = ".";
  protected final String TEXT_434 = "().size() >= ";
  protected final String TEXT_435 = ".eINSTANCE.get";
  protected final String TEXT_436 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_437 = NL + "\t\t}";
  protected final String TEXT_438 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_439 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_440 = ".eINSTANCE.get";
  protected final String TEXT_441 = "(), source.getElement()));";
  protected final String TEXT_442 = NL;
  protected final String TEXT_443 = NL + "\t\tif (";
  protected final String TEXT_444 = ".";
  protected final String TEXT_445 = "() != null) {" + NL + "\t\t\t";
  protected final String TEXT_446 = NL + "\t\t}";
  protected final String TEXT_447 = NL + "\t\tif (";
  protected final String TEXT_448 = ".";
  protected final String TEXT_449 = "().size() >= ";
  protected final String TEXT_450 = ".eINSTANCE.get";
  protected final String TEXT_451 = ".getUpperBound()) {" + NL + "\t\t\t";
  protected final String TEXT_452 = NL + "\t\t}";
  protected final String TEXT_453 = NL + "\t\t\taddLinkEndsCommand.append(";
  protected final String TEXT_454 = ".create(domainModelEditDomain, " + NL + "\t\t\t\tcreatedDomainElement, ";
  protected final String TEXT_455 = ".eINSTANCE.get";
  protected final String TEXT_456 = "(), target.getElement()));";
  protected final String TEXT_457 = NL + "\t\tdomainModelAddCommand = addLinkEndsCommand;";
  protected final String TEXT_458 = NL + "\t\t\tdomainModelAddCommand = ";
  protected final String TEXT_459 = ".create(domainModelEditDomain, source.getElement(), " + NL + "\t\t\t\t";
  protected final String TEXT_460 = ".eINSTANCE.get";
  protected final String TEXT_461 = "(), target.getElement());";
  protected final String TEXT_462 = NL + "\t\t}" + NL;
  protected final String TEXT_463 = NL + "\t\t/**" + NL + "\t\t * Finds container element for the new relationship of the specified type." + NL + "\t\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t\t * the specified element and returns the first element that is instance of" + NL + "\t\t * the specified container class." + NL + "\t\t * " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_464 = " getRelationshipContainer(";
  protected final String TEXT_465 = " element, ";
  protected final String TEXT_466 = " containerClass) {" + NL + "\t\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\t\treturn element;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_467 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\tif (source == null || target == null || createdEdge == null || domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_468 = NL;
  protected final String TEXT_469 = NL + "\t\t\tif(!";
  protected final String TEXT_470 = ".canCreateLink(";
  protected final String TEXT_471 = ", ";
  protected final String TEXT_472 = ", false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_473 = NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tsource.getDiagram().insertEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(source);" + NL + "\t\t\tcreatedEdge.setTarget(target);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t\tsource.getDiagram().removeEdge(createdEdge);" + NL + "\t\t\tcreatedEdge.setSource(null);" + NL + "\t\t\tcreatedEdge.setTarget(null);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_474 = NL;
  protected final String TEXT_475 = NL;
  protected final String TEXT_476 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_477 = NL + "}";
  protected final String TEXT_478 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) ((Object[]) argument)[0];
GenDiagram genDiagram = genNode.getDiagram();
Palette palette = genDiagram.getPalette();
boolean isXYLayout = ViewmapLayoutTypeHelper.getSharedInstance().isStoringChildPositions(genNode);
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ReconnectRequest"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_89);
    if (palette != null) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_95);
    
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

    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_98);
    
}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_101);
    }/*when there's palette*/
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_104);
    if (palette != null) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_111);
    
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

    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_114);
    
}

    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_117);
    }/*when there's palette*/
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_126);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_128);
    if (isXYLayout) {
    stringBuffer.append(TEXT_129);
    } /* use flow layout*/ 
    stringBuffer.append(TEXT_130);
    } else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_132);
    } else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_133);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_135);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ImageFigure"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BorderLayout"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_152);
    
if (!isXYLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout");

    stringBuffer.append(TEXT_153);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_155);
    } else {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_163);
    
	boolean hasFixedChildren = false;
	List innerLabels = new ArrayList(genNode.getLabels().size());
	for (Iterator it = genNode.getLabels().iterator(); it.hasNext(); ) {
		GenNodeLabel genLabel = (GenNodeLabel) it.next();
		if (!(genLabel instanceof GenExternalNodeLabel)) {
			innerLabels.add(genLabel);
		}
	}
	if (!innerLabels.isEmpty()) {
		hasFixedChildren = true;

    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_165);
    
		for (Iterator it = innerLabels.iterator(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
			String labelFigureClassName = null;
			boolean isAccessor;
			if (genLabel.getViewmap() instanceof InnerClassViewmap) {
				labelFigureClassName = ((InnerClassViewmap) genLabel.getViewmap()).getClassName();
				isAccessor = true;
			} else if (genLabel.getViewmap() instanceof FigureViewmap) {
				labelFigureClassName = ((FigureViewmap) genLabel.getViewmap()).getFigureQualifiedClassName();
				isAccessor = false;
			} else {
				// temp hack to make tests pass
				labelFigureClassName = "org.eclipse.draw2d.Label";
				isAccessor = false;
			}

    stringBuffer.append(TEXT_166);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_167);
    			if (isAccessor) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(labelFigureClassName);
    stringBuffer.append(TEXT_171);
    			} else {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(labelFigureClassName);
    stringBuffer.append(TEXT_174);
    			}
    stringBuffer.append(TEXT_175);
    		}
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_177);
    
		GenNodeLabel firstEditableLabel = null;
		for (Iterator it = innerLabels.iterator(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (!genLabel.isReadOnly()) {
				firstEditableLabel = genLabel;
				break;
			}
		}
		if (firstEditableLabel != null) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName(firstEditableLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_184);
    
		}

    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_196);
    
		for (Iterator it = innerLabels.iterator(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_198);
    
		}

    stringBuffer.append(TEXT_199);
    
	}

    
boolean hasExternalLabels = false;
for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
	GenNodeLabel label = (GenNodeLabel) labels.next();
	if (label instanceof GenExternalNodeLabel) {
		hasExternalLabels = true;
		break;
	}
}
if (hasExternalLabels) {

    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_203);
    	if (hasFixedChildren) {
    stringBuffer.append(TEXT_204);
    	} else {
    stringBuffer.append(TEXT_205);
    	}
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_210);
    
	for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
		GenNodeLabel label = (GenNodeLabel) labels.next();
		if (label instanceof GenExternalNodeLabel) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_212);
    
		}
	}

    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ScalableFreeformRootEditPart"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ScalableFreeformRootEditPart"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_217);
    
} else {
	if (hasFixedChildren) {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_219);
    
	}
}

    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ConnectionEditPart"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionAnchor"));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ChopboxAnchor"));
    stringBuffer.append(TEXT_241);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_242);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_252);
    
	final String primaryView = "getDiagramNode()";

    stringBuffer.append(TEXT_253);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LineStyle"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FillStyle"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_320);
    /*XXX: probably, this should go to a separate jet-template along with GraphicalNodeEditPolicy*/
    if (palette != null) {
    
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
	GenLinkConstraints linkConstraints = genLink.getCreationConstraints();

    stringBuffer.append(TEXT_321);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_327);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		if (containmentFeature == null) {

    stringBuffer.append(TEXT_328);
    
		} else {

    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_333);
    
			{
				GenFeature _feature = containmentFeature;
				String _ownerInstance = "container";
				String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_334);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_335);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_337);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_338);
    
	} else {

    stringBuffer.append(TEXT_339);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_344);
    
	}
}

    
			}
			GenFeature childFeature = modelFacet.getChildMetaFeature();
			if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {
				{
					GenFeature _feature = childFeature;
					String _ownerInstance = "container";
					String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_345);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_346);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_348);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_349);
    
	} else {

    stringBuffer.append(TEXT_350);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_354);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_355);
    
	}
}

    
				}
			}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_356);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_358);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_360);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_361);
    
		}
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_364);
    
		{
			GenFeature _feature = metaFeature;
			String _ownerInstance = "domainElement";
			String _exceedsUpperBound = "return false;";

    stringBuffer.append(TEXT_365);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_366);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_368);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_369);
    
	} else {

    stringBuffer.append(TEXT_370);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_374);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_375);
    
	}
}

    
		}
{
	String _source = "source.getElement()";
	String _target = "null";

    stringBuffer.append(TEXT_376);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_378);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_380);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_381);
    
	} else {

    stringBuffer.append(TEXT_382);
    
	}

    stringBuffer.append(TEXT_383);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_387);
    
	}

    stringBuffer.append(TEXT_388);
    
}	//outgoing links

    
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
	GenLinkConstraints linkConstraints = genLink.getCreationConstraints();

    stringBuffer.append(TEXT_389);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(createCommandNameInfix);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_402);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		GenClass linkClass = modelFacet.getMetaClass();

    stringBuffer.append(TEXT_403);
    stringBuffer.append(importManager.getImportedName(importManager.getImportedName(linkClass.getQualifiedInterfaceName())));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName(linkClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(linkClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_406);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_409);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_410);
    
	}

    stringBuffer.append(TEXT_411);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_414);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_415);
    
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

    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(containmentFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_421);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_422);
    
		}
		if (addChild) {

    stringBuffer.append(TEXT_423);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_426);
    
		}
		if (addSource) {
			{
				GenFeature _feature = sourceFeature;
				String _ownerInstance = "createdDomainElement";
				String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";

    stringBuffer.append(TEXT_427);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_428);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_431);
    
	} else {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_437);
    
	}
}

    
			}

    stringBuffer.append(TEXT_438);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_441);
    
		}
		if (addTarget) {
			{
				GenFeature _feature = targetFeature;
				String _ownerInstance = "createdDomainElement";
				String _exceedsUpperBound = "domainModelAddCommand = null;\nreturn;";

    stringBuffer.append(TEXT_442);
    
int upperBound = _feature.getEcoreFeature().getUpperBound();
if (upperBound > 0) {
	if (upperBound == 1) {

    stringBuffer.append(TEXT_443);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_445);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_446);
    
	} else {

    stringBuffer.append(TEXT_447);
    stringBuffer.append(_ownerInstance);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(_feature.getGetAccessor());
    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_451);
    stringBuffer.append(_exceedsUpperBound);
    stringBuffer.append(TEXT_452);
    
	}
}

    
			}

    stringBuffer.append(TEXT_453);
    stringBuffer.append(importManager.getImportedName(targetFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_456);
    
		}

    stringBuffer.append(TEXT_457);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_458);
    stringBuffer.append(importManager.getImportedName(metaFeature.getEcoreFeature().isMany()? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_460);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_461);
    
	}

    stringBuffer.append(TEXT_462);
    
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_463);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_464);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_465);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_466);
    
	}

    stringBuffer.append(TEXT_467);
    
{
	String _source = "source.getElement()";
	String _target = "target.getElement()";

    stringBuffer.append(TEXT_468);
    
			if (linkConstraints != null) {

    stringBuffer.append(TEXT_469);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer")+"."+genDiagram.getLinkCreationConstraintsClassName()+"."+linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_470);
    stringBuffer.append(_source);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(_target);
    stringBuffer.append(TEXT_472);
    
			}

    
}	//local declarations for linkConstraints.jetinc

    stringBuffer.append(TEXT_473);
    
}

    }/*when there's palette*/
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genNode.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_474);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_475);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_476);
    
}

    
}

    stringBuffer.append(TEXT_477);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_478);
    return stringBuffer.toString();
  }
}
