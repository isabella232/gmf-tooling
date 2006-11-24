package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NodeEditPartGenerator {
 
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
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure primaryShape;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {";
  protected final String TEXT_13 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new ";
  protected final String TEXT_14 = "()";
  protected final String TEXT_15 = NL + "\t\t{" + NL + "" + NL + "\t\t\tpublic ";
  protected final String TEXT_16 = " getCommand(";
  protected final String TEXT_17 = " request) {" + NL + "\t\t\t\tif (understandsRequest(request)) {" + NL + "\t\t\t\t\tif (request instanceof ";
  protected final String TEXT_18 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_19 = " adapter =" + NL + "\t\t\t\t\t\t\t((";
  protected final String TEXT_20 = ") request).getViewAndElementDescriptor().getCreateElementRequestAdapter();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = " type =" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_22 = ") adapter.getAdapter(";
  protected final String TEXT_23 = ".class);";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tif (type == ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ") {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_27 = " compartmentEditPart =" + NL + "\t\t\t\t\t\t\t\tgetChildBySemanticHint(";
  protected final String TEXT_28 = ".getType(";
  protected final String TEXT_29 = ".VISUAL_ID));" + NL + "\t\t\t\t\t\t\treturn compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.getCommand(request);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_31 = NL + "\t\t);";
  protected final String TEXT_32 = NL + "\t\tsuper.createDefaultEditPolicies();";
  protected final String TEXT_33 = NL + "\t\tinstallEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());";
  protected final String TEXT_34 = "\t\t" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_35 = "());";
  protected final String TEXT_36 = NL + "\t\tinstallEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_37 = "());";
  protected final String TEXT_38 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ";
  protected final String TEXT_39 = "());";
  protected final String TEXT_40 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.OPEN_ROLE, new ";
  protected final String TEXT_41 = "());";
  protected final String TEXT_42 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_43 = "());";
  protected final String TEXT_44 = NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_47 = "\", new ";
  protected final String TEXT_48 = "()); //$NON-NLS-1$";
  protected final String TEXT_49 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_50 = " createLayoutEditPolicy() {";
  protected final String TEXT_51 = NL + "\t\t";
  protected final String TEXT_52 = " lep = new ";
  protected final String TEXT_53 = "() {";
  protected final String TEXT_54 = NL + NL + "\t\t\tprotected void decorateChild(EditPart child) {" + NL + "\t\t\t\tif (isExternalLabel(child)) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsuper.decorateChild(child);" + NL + "\t\t\t}";
  protected final String TEXT_55 = NL + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_56 = " child) {" + NL + "\t\t\t\tEditPolicy result = super.createChildEditPolicy(child);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_57 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = " xlep = new ";
  protected final String TEXT_60 = "() {" + NL + "" + NL + "\t\t\tprotected boolean isExternalLabel(EditPart editPart) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_61 = ".this.isExternalLabel(editPart);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\txlep.setRealLayoutEditPolicy(lep);" + NL + "\t\treturn xlep;";
  protected final String TEXT_62 = NL + "\t\treturn lep;";
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = " lep = new ";
  protected final String TEXT_65 = "() {";
  protected final String TEXT_66 = NL + NL + "\t\t\tprotected void decorateChild(EditPart child) {" + NL + "\t\t\t\tif (isExternalLabel(child)) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsuper.decorateChild(child);" + NL + "\t\t\t}";
  protected final String TEXT_67 = NL + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_68 = " child) {" + NL + "\t\t\t\tif (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {" + NL + "\t\t\t\t\tif (child instanceof ";
  protected final String TEXT_69 = ") {" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_70 = "();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.createChildEditPolicy(child);" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = " xlep = new ";
  protected final String TEXT_73 = "() {" + NL + "" + NL + "\t\t\tprotected boolean isExternalLabel(EditPart editPart) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_74 = ".this.isExternalLabel(editPart);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\txlep.setRealLayoutEditPolicy(lep);" + NL + "\t\treturn xlep;";
  protected final String TEXT_75 = NL + "\t\treturn lep;";
  protected final String TEXT_76 = NL + "\t\t";
  protected final String TEXT_77 = " lep = new ";
  protected final String TEXT_78 = "() {";
  protected final String TEXT_79 = NL + NL + "\t\t\tprotected void decorateChild(EditPart child) {" + NL + "\t\t\t\tif (isExternalLabel(child)) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsuper.decorateChild(child);" + NL + "\t\t\t}";
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_82 = " child) {" + NL + "\t\t\t\tif (child instanceof ";
  protected final String TEXT_83 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_84 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.createChildEditPolicy(child);" + NL + "\t\t\t}";
  protected final String TEXT_85 = NL + NL + "\t\t\tprotected ";
  protected final String TEXT_86 = " createAddCommand(";
  protected final String TEXT_87 = " child, ";
  protected final String TEXT_88 = " after) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprotected ";
  protected final String TEXT_89 = " createMoveChildCommand(";
  protected final String TEXT_90 = " child, ";
  protected final String TEXT_91 = " after) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprotected ";
  protected final String TEXT_92 = " getCreateCommand(";
  protected final String TEXT_93 = " request) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_94 = NL + "\t\t";
  protected final String TEXT_95 = " xlep = new ";
  protected final String TEXT_96 = "() {" + NL + "" + NL + "\t\t\tprotected boolean isExternalLabel(EditPart editPart) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_97 = ".this.isExternalLabel(editPart);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\txlep.setRealLayoutEditPolicy(lep);" + NL + "\t\treturn xlep;";
  protected final String TEXT_98 = NL + "\t\treturn lep;";
  protected final String TEXT_99 = NL + "\t\t";
  protected final String TEXT_100 = " lep = new ";
  protected final String TEXT_101 = "() {";
  protected final String TEXT_102 = NL + NL + "\t\t\tprotected void decorateChild(EditPart child) {" + NL + "\t\t\t\tif (isExternalLabel(child)) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsuper.decorateChild(child);" + NL + "\t\t\t}";
  protected final String TEXT_103 = NL + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_104 = " child) {" + NL + "\t\t\t\tEditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);" + NL + "\t\t\t\tif( result == null ){" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_105 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprotected ";
  protected final String TEXT_106 = " getMoveChildrenCommand(";
  protected final String TEXT_107 = " request) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprotected ";
  protected final String TEXT_108 = " getCreateCommand(";
  protected final String TEXT_109 = " request) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = " xlep = new ";
  protected final String TEXT_112 = "() {" + NL + "" + NL + "\t\t\tprotected boolean isExternalLabel(EditPart editPart) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_113 = ".this.isExternalLabel(editPart);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\txlep.setRealLayoutEditPolicy(lep);" + NL + "\t\treturn xlep;";
  protected final String TEXT_114 = NL + "\t\treturn lep;";
  protected final String TEXT_115 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createNodeShape() {";
  protected final String TEXT_116 = NL + "\t\treturn primaryShape = new ";
  protected final String TEXT_117 = "()";
  protected final String TEXT_118 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_119 = ";";
  protected final String TEXT_120 = NL + "\t\treturn ";
  protected final String TEXT_121 = ";";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = " figure = new ";
  protected final String TEXT_124 = "();";
  protected final String TEXT_125 = NL + " \t\tfigure.setUseLocalCoordinates(true);";
  protected final String TEXT_126 = NL + " \t\treturn primaryShape = figure;";
  protected final String TEXT_127 = NL + "\t}";
  protected final String TEXT_128 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_129 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_130 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_131 = NL;
  protected final String TEXT_132 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(EditPart childEditPart) {";
  protected final String TEXT_133 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_134 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_135 = ") childEditPart).";
  protected final String TEXT_136 = "(getPrimaryShape().";
  protected final String TEXT_137 = "());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_138 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_139 = ") {" + NL + "\t\t\t";
  protected final String TEXT_140 = " pane = getPrimaryShape().";
  protected final String TEXT_141 = "();" + NL + "\t\t\tsetupContentPane(pane); // FIXME each comparment should handle his content pane in his own way " + NL + "\t\t\tpane.add(((";
  protected final String TEXT_142 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_143 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_144 = ") {" + NL + "\t\t\t";
  protected final String TEXT_145 = " locator = new ";
  protected final String TEXT_146 = "(getMainFigure(), ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ");" + NL + "\t\t\tgetBorderedFigure().getBorderItemContainer().add(((";
  protected final String TEXT_149 = ")childEditPart).getFigure(), locator);" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_150 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean removeFixedChild(EditPart childEditPart) {";
  protected final String TEXT_151 = "\t\t" + NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_152 = ") {" + NL + "\t\t\t";
  protected final String TEXT_153 = " pane = getPrimaryShape().";
  protected final String TEXT_154 = "();" + NL + "\t\t\tpane.remove(((";
  protected final String TEXT_155 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}\t";
  protected final String TEXT_156 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_157 = ") {" + NL + "\t\t\tgetBorderedFigure().getBorderItemContainer().remove(((";
  protected final String TEXT_158 = ")childEditPart).getFigure());" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_159 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_160 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_161 = " createNodePlate() {";
  protected final String TEXT_162 = NL + "\t\t";
  protected final String TEXT_163 = " result = new ";
  protected final String TEXT_164 = "(getMapMode().DPtoLP(";
  protected final String TEXT_165 = "), getMapMode().DPtoLP(";
  protected final String TEXT_166 = "));";
  protected final String TEXT_167 = NL + "\t\t//FIXME: workaround for #154536" + NL + "\t\tresult.getBounds().setSize(result.getPreferredSize());";
  protected final String TEXT_168 = "\t\t" + NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_169 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPolicy getPrimaryDragEditPolicy() {" + NL + "\t\t";
  protected final String TEXT_170 = " ep = (";
  protected final String TEXT_171 = ") super.getPrimaryDragEditPolicy();" + NL + "\t\t";
  protected final String TEXT_172 = NL + "\t\tep.setResizeDirections(";
  protected final String TEXT_173 = ".NONE);" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\tep.setResizeDirections(";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = " | ";
  protected final String TEXT_177 = ");" + NL + "\t\t";
  protected final String TEXT_178 = NL + "\t\treturn ep;" + NL + "\t}";
  protected final String TEXT_179 = NL;
  protected final String TEXT_180 = "\t " + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_181 = " createMainFigure() {";
  protected final String TEXT_182 = NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_183 = " createNodeFigure() {";
  protected final String TEXT_184 = NL + "\t\t";
  protected final String TEXT_185 = " figure = createNodePlate();" + NL + "\t\tfigure.setLayoutManager(new StackLayout());" + NL + "\t\tIFigure shape = createNodeShape();" + NL + "\t\tfigure.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);" + NL + "\t\treturn figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure setupContentPane(IFigure nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_186 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_187 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(IFigure figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_188 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_189 = NL + "\t\t\t";
  protected final String TEXT_190 = " layout = new ";
  protected final String TEXT_191 = "();" + NL + "\t\t\tlayout.setSpacing(getMapMode().DPtoLP(5));" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_192 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_193 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_194 = " getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_195 = ".getType(";
  protected final String TEXT_196 = ".VISUAL_ID));" + NL + "\t}";
  protected final String TEXT_197 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_198 = " childEditPart) {";
  protected final String TEXT_199 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_200 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_201 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_202 = " root = (";
  protected final String TEXT_203 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_204 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_205 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_206 = " childEditPart, int index) {";
  protected final String TEXT_207 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_208 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t} ";
  protected final String TEXT_209 = "\t\t" + NL + "\t\tif (addFixedChild(childEditPart)) {" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_210 = NL + "\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_211 = " childEditPart) {";
  protected final String TEXT_212 = NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_213 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\treturn;" + NL + "\t\t} ";
  protected final String TEXT_214 = NL + "\t\tif (removeFixedChild(childEditPart)){" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_215 = NL + "\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t}";
  protected final String TEXT_216 = "\t\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeNotify() {" + NL + "\t\tfor (";
  protected final String TEXT_217 = " it = getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_218 = " childEditPart = (";
  protected final String TEXT_219 = ") it.next();" + NL + "\t\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_220 = ") childEditPart).getFigure();" + NL + "\t\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.removeNotify();" + NL + "\t}";
  protected final String TEXT_221 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void handleNotificationEvent(";
  protected final String TEXT_222 = " event) {" + NL + "\t\tif (event.getNotifier() == getModel() && ";
  protected final String TEXT_223 = ".eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {" + NL + "\t\t\thandleMajorSemanticChange();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.handleNotificationEvent(event);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_224 = NL;
  protected final String TEXT_225 = NL;
  protected final String TEXT_226 = NL + "}";
  protected final String TEXT_227 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				if (feature.getTypeGenClass() != null) {
					result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
				} else {
					// EDataType
					result.append(importManager.getImportedName(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClassName()));
				}

			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenNode genNode = (GenNode) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genNode.getDiagram();
boolean isXYLayout = ViewmapLayoutType.XY_LAYOUT_LITERAL.equals(genNode.getLayoutType());

class NodeEditPartHelper {
	private final List<GenNodeLabel> myInnerLabels = new LinkedList<GenNodeLabel>();
	private final List<GenNodeLabel> myExternalLabels = new LinkedList<GenNodeLabel>();
	private final List<GenCompartment> myPinnedCompartments = new LinkedList<GenCompartment>();
	private final List<GenCompartment> myFloatingCompartments = new LinkedList<GenCompartment>();
	private final List<GenChildNode> mySideAffixedChildren = new LinkedList<GenChildNode>();
	private GenNodeLabel myPrimaryLabel;
	private boolean myHasChildrenInListCompartments = false;
	private final boolean myIsSideAffixed;
	private final boolean myHasSideAffixedChildren;
	
	public NodeEditPartHelper(GenNode genNode){
		myPrimaryLabel = null;

		for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel next = (GenNodeLabel) labels.next();
			if (myPrimaryLabel == null){
				myPrimaryLabel = next;
			}
			if (next instanceof GenExternalNodeLabel) {
				myExternalLabels.add(next);
			} else if (next.getViewmap() instanceof ParentAssignedViewmap) {
				myInnerLabels.add(next);
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
		
		for (Iterator childNodes = genNode.getChildNodes().iterator(); childNodes.hasNext();){
			GenChildNode next = (GenChildNode)childNodes.next();
			if (next instanceof GenChildSideAffixedNode){
				mySideAffixedChildren.add(next);
			}
		}
		
		myIsSideAffixed = genNode instanceof GenChildSideAffixedNode;
		myHasSideAffixedChildren = !mySideAffixedChildren.isEmpty();
	}
	
	public boolean isSideAffixed(){
		return myIsSideAffixed;
	}
	
	public boolean hasSideAffixedChildren(){
		return myHasSideAffixedChildren;
	}
	
	public String getEditPartSuperClassFQN(){
		if (isSideAffixed()){
			return hasSideAffixedChildren() ? 
				"org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart" :
				"org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart";
		} else {
			return hasSideAffixedChildren() ? 
				"org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart" : 
				"org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart";
		}
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
	
	public Iterator getSideAffixedChildren(){
		return mySideAffixedChildren.iterator();
	}
}
final NodeEditPartHelper myHelper = new NodeEditPartHelper(genNode);

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
if (genNode.getViewmap() instanceof InnerClassViewmap) {
importManager.registerInnerClass(((InnerClassViewmap) genNode.getViewmap()).getClassName());
}
importManager.addImport("org.eclipse.draw2d.IFigure");
importManager.addImport("org.eclipse.draw2d.StackLayout");
importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles");
importManager.addImport("org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure");
importManager.addImport("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(myHelper.getEditPartSuperClassFQN()));
    stringBuffer.append(TEXT_7);
    {	GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_12);
    
if (!genNode.getChildNodes().isEmpty() || myHelper.hasChildrenInListCompartments()) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy"));
    stringBuffer.append(TEXT_14);
    	if (myHelper.hasChildrenInListCompartments()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_23);
    
		for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment compartment = (GenCompartment) compartments.next();
			if (compartment.isListLayout() && !compartment.getChildNodes().isEmpty()) {
				for (Iterator children = compartment.getChildNodes().iterator(); children.hasNext(); ) {
					GenNode child = (GenNode) children.next();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(child.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(compartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    
				}
			}
		}

    stringBuffer.append(TEXT_30);
    	}
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if (myHelper.isSideAffixed()){
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genNode.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    if (genNode.needsGraphicalNodeEditPolicy()) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(genNode.getGraphicalNodeEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_37);
    }
if (!genNode.getChildNodes().isEmpty()) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy"));
    stringBuffer.append(TEXT_39);
    }
if (genNode.getBehaviour(OpenDiagramBehaviour.class).size() == 1) /*doesn't make sense to install more than one policy for the same role*/ {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genNode.getBehaviour(OpenDiagramBehaviour.class).get(0).getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    }
if (genNode.needsCanonicalEditPolicy()) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(genNode.getCanonicalEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    {	GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_45);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    }
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.LayoutEditPolicy"));
    stringBuffer.append(TEXT_50);
    
final String fqnEditPart = importManager.getImportedName("org.eclipse.gef.EditPart");
switch(genNode.getLayoutType().getValue()){
	case ViewmapLayoutType.XY_LAYOUT:

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_53);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_54);
    		}
    stringBuffer.append(TEXT_55);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy"));
    stringBuffer.append(TEXT_57);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_61);
    		} else {
    stringBuffer.append(TEXT_62);
    
		}
		break;
	case ViewmapLayoutType.TOOLBAR_LAYOUT:

    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy"));
    stringBuffer.append(TEXT_65);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_66);
    		}
    stringBuffer.append(TEXT_67);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_74);
    		} else {
    stringBuffer.append(TEXT_75);
    
		}
		break;
	case ViewmapLayoutType.FLOW_LAYOUT:

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.FlowLayoutEditPolicy"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.FlowLayoutEditPolicy"));
    stringBuffer.append(TEXT_78);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_79);
    		}
    stringBuffer.append(TEXT_80);
    if (myHelper.hasSideAffixedChildren()) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy"));
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_93);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_97);
    		} else {
    stringBuffer.append(TEXT_98);
    
		}
		break;
	default:

    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.LayoutEditPolicy"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.LayoutEditPolicy"));
    stringBuffer.append(TEXT_101);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_102);
    		}
    stringBuffer.append(TEXT_103);
    stringBuffer.append(fqnEditPart);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.NonResizableEditPolicy"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_109);
    		if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName(genDiagram.getExternalNodeLabelHostLayoutEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_113);
    		} else {
    stringBuffer.append(TEXT_114);
    
		}
} //switch

    stringBuffer.append(TEXT_115);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}
	figureQualifiedClassName = importManager.getImportedName(figureQualifiedClassName);

    stringBuffer.append(TEXT_116);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_117);
    if (isXYLayout) {
    stringBuffer.append(TEXT_118);
    } // if isXYLayout
    stringBuffer.append(TEXT_119);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_121);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_122);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_124);
    if (!genNode.getChildNodes().isEmpty() && isXYLayout) { /*otherwise, leave to figure's default value*/
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    
if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_132);
    
for (Iterator it = myHelper.getInnerFixedLabels(); it.hasNext(); ) {
	GenNodeLabel genLabel = (GenNodeLabel) it.next();
	final String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	final String childSetterName = childViewmap.getSetterName() == null ? "setLabel" : childViewmap.getSetterName();

    stringBuffer.append(TEXT_133);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(childSetterName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_137);
    
}

for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_138);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_142);
    	
} // for pinned compartments

for (Iterator it = myHelper.getSideAffixedChildren(); it.hasNext(); ) {
	GenChildSideAffixedNode next = (GenChildSideAffixedNode) it.next();
	String sideAffixedEidtPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_143);
    stringBuffer.append(sideAffixedEidtPartFQN);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(next.getPreferredSideName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(sideAffixedEidtPartFQN);
    stringBuffer.append(TEXT_149);
    	
} // for side affixed

    stringBuffer.append(TEXT_150);
    
//XXX: ignore labels assuming that they never may be removed
for (Iterator it = myHelper.getPinnedCompartments(); it.hasNext(); ) {
	GenCompartment next = (GenCompartment) it.next();
	final ParentAssignedViewmap childViewmap = (ParentAssignedViewmap) next.getViewmap();
	String compartmentEditPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_151);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(childViewmap.getGetterName());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(compartmentEditPartFQN);
    stringBuffer.append(TEXT_155);
    
} // for pinned compartments

for (Iterator it = myHelper.getSideAffixedChildren(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode) it.next();
	String sideAffixedEidtPartFQN = importManager.getImportedName(next.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_156);
    stringBuffer.append(sideAffixedEidtPartFQN);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(sideAffixedEidtPartFQN);
    stringBuffer.append(TEXT_158);
    	
} // for side affixed

    stringBuffer.append(TEXT_159);
    
} // if myHelper.hasFixedChildren()

    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure"));
    stringBuffer.append(TEXT_161);
    
int width = 40;
int height = 40;
DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) genNode.getViewmap().find(DefaultSizeAttributes.class);
if (defSizeAttrs != null) {
	width = defSizeAttrs.getWidth();
	height = defSizeAttrs.getHeight();
}

    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(height);
    stringBuffer.append(TEXT_166);
    
if (myHelper.isSideAffixed()){		

    stringBuffer.append(TEXT_167);
    
}

    stringBuffer.append(TEXT_168);
    if (genNode.getViewmap().find(ResizeConstraints.class) != null) {
	final ResizeConstraints rc = (ResizeConstraints) genNode.getViewmap().find(ResizeConstraints.class);
	final String draw2dPC = importManager.getImportedName("org.eclipse.draw2d.PositionConstants");
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ResizableEditPolicy"));
    stringBuffer.append(TEXT_171);
    if (rc.getResizeHandleNames().isEmpty()) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(draw2dPC);
    stringBuffer.append(TEXT_173);
     } else {
    stringBuffer.append(TEXT_174);
    for (Iterator rcNamesIter = rc.getResizeHandleNames().iterator(); rcNamesIter.hasNext();) {
			String nextConstantName = (String) rcNamesIter.next();
    stringBuffer.append(draw2dPC);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(nextConstantName);
    if (rcNamesIter.hasNext()) {
    stringBuffer.append(TEXT_176);
    }}
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    if (myHelper.hasSideAffixedChildren()) {
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure"));
    stringBuffer.append(TEXT_181);
    } else {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure"));
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure"));
    stringBuffer.append(TEXT_185);
    
if (isXYLayout) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_188);
    } else {
	String layoutClassName = importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout");

    stringBuffer.append(TEXT_189);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_191);
    }
    stringBuffer.append(TEXT_192);
    
if (myHelper.getPrimaryLabel() != null) {
	GenNodeLabel primaryLabel = myHelper.getPrimaryLabel();

    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_196);
    
}
if (myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_198);
    
	for (Iterator externalLabels = myHelper.getExternalLabels(); externalLabels.hasNext();) {
		GenNodeLabel next = (GenNodeLabel) externalLabels.next();

    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_200);
    	}
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.LayerManager"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_204);
    
}
if (myHelper.hasFixedChildren() || myHelper.hasExternalLabels()) {

    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_206);
    	if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_208);
    
	}
	if (myHelper.hasFixedChildren()) {

    stringBuffer.append(TEXT_209);
    	}
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_211);
    	if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_213);
    
	}
	if (myHelper.hasFixedChildren()){

    stringBuffer.append(TEXT_214);
    	}
    stringBuffer.append(TEXT_215);
    	if (myHelper.hasExternalLabels()) {
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_220);
    
	}
} // if hasFixedChildren || hasExternalLabels

/*
 * This code is important fore ferreshing shortcut decoration on 
 * adding corresponding annotation to the View instance.
 */
if (genNode instanceof GenTopLevelNode && genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcorePackage"));
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    if (genNode.getViewmap() instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_225);
    stringBuffer.append(((InnerClassViewmap) genNode.getViewmap()).getClassBody());
    }
    stringBuffer.append(TEXT_226);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_227);
    return stringBuffer.toString();
  }
}