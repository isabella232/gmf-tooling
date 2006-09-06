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
  protected final String TEXT_21 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_22 = " extends ";
  protected final String TEXT_23 = " implements ";
  protected final String TEXT_24 = " {";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_29 = "(View view) {" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_30 = " getModelChildren() {" + NL + "\t\treturn getDiagramNode().getChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_31 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_32 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_33 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_34 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_35 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_36 = " createChangeConstraintCommand(final ";
  protected final String TEXT_37 = " request, final ";
  protected final String TEXT_38 = " child, Object constraint) {";
  protected final String TEXT_39 = NL;
  protected final String TEXT_40 = "\t\t\t\tfinal ";
  protected final String TEXT_41 = " node = (";
  protected final String TEXT_42 = ") child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_43 = " emfCommand = new ";
  protected final String TEXT_44 = "(\"Change node position/size\") {" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_45 = " moveDelta;" + NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_46 = " resizeDelta;" + NL + "" + NL + "\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\treturn canExecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (node.getLayoutConstraint() instanceof ";
  protected final String TEXT_47 = " == false) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = " bounds = (";
  protected final String TEXT_49 = ") node.getLayoutConstraint();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = " original = new ";
  protected final String TEXT_51 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = " referenceFigure = ((";
  protected final String TEXT_53 = ")child).getFigure();" + NL + "\t\t\t\t\t\treferenceFigure.translateToAbsolute(original);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = " transformed = request.getTransformedRectangle(original);" + NL + "\t\t\t\t\t\treferenceFigure.translateToRelative(transformed);" + NL + "\t\t\t\t\t\treferenceFigure.translateToRelative(original);" + NL + "\t\t\t\t\t\tresizeDelta = transformed.getSize().expand(original.getSize().negate());" + NL + "\t\t\t\t\t\tmoveDelta = transformed.getTopLeft().translate(original.getTopLeft().negate());" + NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\texecute(moveDelta.getNegated(), resizeDelta.getNegated());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\texecute(moveDelta, resizeDelta);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\texecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprivate void execute(";
  protected final String TEXT_55 = " move, ";
  protected final String TEXT_56 = " resize) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_57 = " bounds = (";
  protected final String TEXT_58 = ") node.getLayoutConstraint();" + NL + "\t\t\t\t\t\tbounds.setX(bounds.getX() + move.x);" + NL + "\t\t\t\t\t\tbounds.setY(bounds.getY() + move.y);" + NL + "\t\t\t\t\t\tbounds.setWidth(bounds.getWidth() + resize.width);" + NL + "\t\t\t\t\t\tbounds.setHeight(bounds.getHeight() + resize.height);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ".getEditingDomain(node.getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(";
  protected final String TEXT_61 = " child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn ";
  protected final String TEXT_62 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_63 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_64 = ".LAYOUT_ROLE, new ";
  protected final String TEXT_65 = "() {" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_66 = " rect) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Object getConstraintFor(";
  protected final String TEXT_67 = " point) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_68 = ".INSTANCE;" + NL + "\t\t\t}";
  protected final String TEXT_69 = NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {";
  protected final String TEXT_70 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_71 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = " requestEx = (";
  protected final String TEXT_73 = ") request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = " result = new ";
  protected final String TEXT_75 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_77 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_78 = "Command((View) getModel(), requestEx";
  protected final String TEXT_79 = ", " + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_80 = ")getConstraintFor(request)";
  protected final String TEXT_81 = "));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = ".getEditingDomain(((View) getModel()).getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_85 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getTitleName() {" + NL + "\t\treturn \"";
  protected final String TEXT_86 = "\";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_87 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_88 = " result = new ";
  protected final String TEXT_89 = "();" + NL + "\t\tresult.setLabel(getTitleName());" + NL + "\t\tresult.setOpaque(false);" + NL + "\t\tresult.setLayoutManager(new ";
  protected final String TEXT_90 = "());" + NL + "\t\t";
  protected final String TEXT_91 = " scrollPane = new ";
  protected final String TEXT_92 = "();" + NL + "\t\tresult.add(scrollPane);";
  protected final String TEXT_93 = NL + "\t\t";
  protected final String TEXT_94 = " viewport = new ";
  protected final String TEXT_95 = "();" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_96 = "();" + NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_97 = "());";
  protected final String TEXT_98 = NL + "\t\t";
  protected final String TEXT_99 = " viewport = new ";
  protected final String TEXT_100 = "();" + NL + "\t\tcontentPane = new ";
  protected final String TEXT_101 = "();" + NL + "\t\tcontentPane.setLayoutManager(new ";
  protected final String TEXT_102 = "());";
  protected final String TEXT_103 = NL + "\t\tviewport.setContents(contentPane);" + NL + "\t\tscrollPane.setViewport(viewport);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\treturn contentPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_104 = " resolveSemanticElement() {" + NL + "\t\tView view = getDiagramNode();" + NL + "\t\treturn (view.getElement() instanceof ";
  protected final String TEXT_105 = ") ? (";
  protected final String TEXT_106 = ") view.getElement() : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tuninstallNotationModelRefresher();" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\t";
  protected final String TEXT_109 = " refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_110 = " domainModelEditDomain = ";
  protected final String TEXT_111 = ".getEditingDomain(";
  protected final String TEXT_112 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_113 = " notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_114 = " getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_115 = " {";
  protected final String TEXT_116 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_117 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_118 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_119 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_120 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_121 = " createFilter() {";
  protected final String TEXT_122 = NL + "\t\t\t";
  protected final String TEXT_123 = " filter = ";
  protected final String TEXT_124 = ".createFeatureFilter(";
  protected final String TEXT_125 = ".eINSTANCE.get";
  protected final String TEXT_126 = "());";
  protected final String TEXT_127 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_128 = ".createFeatureFilter(";
  protected final String TEXT_129 = ".eINSTANCE.get";
  protected final String TEXT_130 = "()));";
  protected final String TEXT_131 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_132 = ".createNotifierFilter(";
  protected final String TEXT_133 = ".getElement()));";
  protected final String TEXT_134 = NL + "\t\t\t";
  protected final String TEXT_135 = " filter = ";
  protected final String TEXT_136 = ".createNotifierFilter(";
  protected final String TEXT_137 = ".getElement());";
  protected final String TEXT_138 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_139 = NL + "\t\t\t";
  protected final String TEXT_140 = " filter = getConstrainedChildrenFilter();";
  protected final String TEXT_141 = NL + "\t\t\t";
  protected final String TEXT_142 = " filter = ";
  protected final String TEXT_143 = ".NOT_TOUCH;";
  protected final String TEXT_144 = NL + "\t\t\treturn filter;";
  protected final String TEXT_145 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_146 = " getCreateNotationalElementCommand(";
  protected final String TEXT_147 = " descriptor) {" + NL + "\t\t\t";
  protected final String TEXT_148 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_149 = NL + "\t\t\tcase ";
  protected final String TEXT_150 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_151 = ") {" + NL + "\t\t\t\t\treturn new Create";
  protected final String TEXT_152 = "NotationCommand(getHost(), domainElement";
  protected final String TEXT_153 = ", new Rectangle(0, 0, 0, 0)";
  protected final String TEXT_154 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_155 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_156 = " getSemanticChildNodes() {";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL + "\treturn ";
  protected final String TEXT_159 = ".EMPTY_LIST;";
  protected final String TEXT_160 = NL + "\t";
  protected final String TEXT_161 = " result = new ";
  protected final String TEXT_162 = "();";
  protected final String TEXT_163 = NL + "\t";
  protected final String TEXT_164 = " viewObject = ";
  protected final String TEXT_165 = ";" + NL + "\t";
  protected final String TEXT_166 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_167 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_168 = NL + "\tfor(";
  protected final String TEXT_169 = " it = ";
  protected final String TEXT_170 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_171 = ") it.next();";
  protected final String TEXT_172 = NL + "\tnextValue = (";
  protected final String TEXT_173 = ")";
  protected final String TEXT_174 = ";";
  protected final String TEXT_175 = NL + "\tnodeVID = ";
  protected final String TEXT_176 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_177 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_178 = NL + "\tcase ";
  protected final String TEXT_179 = ".VISUAL_ID: {";
  protected final String TEXT_180 = NL + "\tif (";
  protected final String TEXT_181 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_182 = NL + "\t\tresult.add(new ";
  protected final String TEXT_183 = "(nextValue, nodeVID));";
  protected final String TEXT_184 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_185 = NL + "\t\t}";
  protected final String TEXT_186 = NL + "\t}";
  protected final String TEXT_187 = NL + "\t}";
  protected final String TEXT_188 = NL + "\treturn result;";
  protected final String TEXT_189 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t\t * The generated code always returns ";
  protected final String TEXT_190 = ". " + NL + "\t\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldCreateView(";
  protected final String TEXT_191 = " descriptor) {" + NL + "\t\t\treturn ";
  protected final String TEXT_192 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_193 = " getHost() {" + NL + "\t\t\treturn ";
  protected final String TEXT_194 = ";" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_195 = " childRefresher = getNotationModelRefresher();" + NL + "\t\tif (!childRefresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_196 = " command = childRefresher.buildRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_197 = " domainModelEditDomain = ";
  protected final String TEXT_198 = ".getEditingDomain(";
  protected final String TEXT_199 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_200 = "(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_201 = NL;
  protected final String TEXT_202 = NL;
  protected final String TEXT_203 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_204 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_205 = " feature, ";
  protected final String TEXT_206 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_207 = NL;
  protected final String TEXT_208 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_209 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_210 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_211 = NL;
  protected final String TEXT_212 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_213 = ".eINSTANCE.getView_Visible(), visibilityRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "//XXX:\t\trefreshBackgroundColor();" + NL + "//XXX:\t\trefreshForegroundColor();" + NL + "//XXX:\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = ((View)getModel()).isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL;
  protected final String TEXT_214 = NL;
  protected final String TEXT_215 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_216 = "static ";
  protected final String TEXT_217 = "class Create";
  protected final String TEXT_218 = "NotationCommand extends ";
  protected final String TEXT_219 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Create";
  protected final String TEXT_220 = "NotationCommand(";
  protected final String TEXT_221 = " parent, " + NL + "\t\t\t\t";
  protected final String TEXT_222 = " domainElement";
  protected final String TEXT_223 = ", ";
  protected final String TEXT_224 = " constraint";
  protected final String TEXT_225 = ") {" + NL + "\t\t\tsuper(parent);" + NL + "\t\t\tNode createdNode = ";
  protected final String TEXT_226 = ".eINSTANCE.createNode();" + NL + "\t\t\tsetCreatedView(createdNode);" + NL + "\t\t\tcreatedNode.setElement(domainElement);" + NL + "\t\t\t";
  protected final String TEXT_227 = ".decorateView(createdNode);";
  protected final String TEXT_228 = NL + "\t\t\t";
  protected final String TEXT_229 = " bounds = ";
  protected final String TEXT_230 = ".eINSTANCE.createBounds();" + NL + "\t\t\tcreatedNode.setLayoutConstraint(bounds);" + NL + "\t\t\tbounds.setX(constraint.x);" + NL + "\t\t\tbounds.setY(constraint.y);";
  protected final String TEXT_231 = NL + "\t\t\tbounds.setWidth(Math.max(constraint.width, ";
  protected final String TEXT_232 = "));" + NL + "\t\t\tbounds.setHeight(Math.max(constraint.height, ";
  protected final String TEXT_233 = "));";
  protected final String TEXT_234 = NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_235 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_236 = "static ";
  protected final String TEXT_237 = "class Create";
  protected final String TEXT_238 = "Command extends ";
  protected final String TEXT_239 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final Create";
  protected final String TEXT_240 = "NotationCommand notationAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_241 = "Command(";
  protected final String TEXT_242 = " parent, ";
  protected final String TEXT_243 = " request";
  protected final String TEXT_244 = ", ";
  protected final String TEXT_245 = " constraint";
  protected final String TEXT_246 = ") {" + NL + "\t\t\t";
  protected final String TEXT_247 = " domainModelEditDomain = ";
  protected final String TEXT_248 = ".getEditingDomain(parent.getDiagram().getElement());";
  protected final String TEXT_249 = NL + "\t\t\t";
  protected final String TEXT_250 = " createdDomainElement = ";
  protected final String TEXT_251 = ".eINSTANCE.create(" + NL + "\t\t\t\t";
  protected final String TEXT_252 = ".eINSTANCE.get";
  protected final String TEXT_253 = "());";
  protected final String TEXT_254 = NL + "\t\t\t";
  protected final String TEXT_255 = " createdDomainElement = ";
  protected final String TEXT_256 = ".eINSTANCE.create";
  protected final String TEXT_257 = "();";
  protected final String TEXT_258 = NL + "\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = ".initializeElement(";
  protected final String TEXT_262 = "(";
  protected final String TEXT_263 = ") ";
  protected final String TEXT_264 = "createdDomainElement);";
  protected final String TEXT_265 = NL + "\t\t\t";
  protected final String TEXT_266 = " compoundCommand = new ";
  protected final String TEXT_267 = "();" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_268 = ".create(domainModelEditDomain, ";
  protected final String TEXT_269 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_270 = ".eINSTANCE.get";
  protected final String TEXT_271 = "(), createdDomainElement));" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_272 = ".create(domainModelEditDomain, ";
  protected final String TEXT_273 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_274 = ".eINSTANCE.get";
  protected final String TEXT_275 = "(), createdDomainElement));" + NL + "\t\t\tthis.domainModelAddCommand = compoundCommand;";
  protected final String TEXT_276 = NL + "\t\t\tthis.domainModelAddCommand = ";
  protected final String TEXT_277 = ".create(domainModelEditDomain, ";
  protected final String TEXT_278 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_279 = ".eINSTANCE.get";
  protected final String TEXT_280 = "(), createdDomainElement);";
  protected final String TEXT_281 = NL + "\t\t\tthis.notationAddCommand = new Create";
  protected final String TEXT_282 = "NotationCommand(parent, ";
  protected final String TEXT_283 = "(";
  protected final String TEXT_284 = ") ";
  protected final String TEXT_285 = "createdDomainElement";
  protected final String TEXT_286 = ", constraint";
  protected final String TEXT_287 = ");" + NL + "\t\t\trequest.setCreatedObject(notationAddCommand.getCreatedView());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tnotationAddCommand.execute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tnotationAddCommand.undo();" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_288 = NL + "}" + NL;
  protected final String TEXT_289 = NL;

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
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_24);
    {
GenCommonBase genCommonBase = genCompartment;
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_32);
    if (!genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.ChangeBoundsRequest"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_62);
    } else {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    if (null != genDiagram.getPalette()) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_75);
    
for(Iterator it = genCompartment.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_78);
    if (!genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    
}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_84);
    }/*when there's palette*/
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genCompartment.getTitle());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LabeledContainer"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LabeledContainer"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.StackLayout"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ScrollPane"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ScrollPane"));
    stringBuffer.append(TEXT_92);
    if (genCompartment.isListLayout()) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ToolbarLayout"));
    stringBuffer.append(TEXT_97);
    } else {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Viewport"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformViewport"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_106);
    
{
String _getViewCode = "getDiagramNode()";
String _getDiagramCode = _getViewCode + ".getDiagram()";
boolean isListLayout = genCompartment.isListLayout();

    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ChildNotationModelRefresher"));
    stringBuffer.append(TEXT_115);
    
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

    stringBuffer.append(TEXT_116);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_119);
    
}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_121);
    
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

    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_126);
    
		} else {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_130);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_133);
    
	} else {
		hasDeclaredFilter = true;

    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_137);
    
	}

    
	if (hasConstraintsInChildren) {
		if (hasDeclaredFilter) {
			hasDeclaredFilter = true;

    stringBuffer.append(TEXT_138);
    
		} else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_140);
    
		}
	}
	if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_143);
    
	}

    stringBuffer.append(TEXT_144);
    
}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_148);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(nextNode.getDomainMetaClass().getName());
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_152);
    if (!isListLayout) {
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    
}

    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_159);
    
} else {

    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_162);
    
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

    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_167);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_169);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_171);
    
		} else {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_173);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_174);
    
	}

    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_176);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_177);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_179);
    
		} else {

    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_181);
    
		}

    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_183);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_184);
    
		} else {

    stringBuffer.append(TEXT_185);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_186);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_187);
    
	}
}

    stringBuffer.append(TEXT_188);
    
}

    stringBuffer.append(TEXT_189);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.AbstractNotationModelRefresher"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_200);
    
}

    stringBuffer.append(TEXT_201);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_213);
    
for(Iterator it = genCompartment.getChildNodes().iterator(); it.hasNext(); ) {
	GenChildNode next = (GenChildNode)it.next();
	boolean isStatic = false;
	boolean isListLayout = genCompartment.isListLayout();
	String resolvedSemanticElement = "resolveSemanticElement()";

    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    if (isStatic) {
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_222);
    if (!isListLayout) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_227);
    
	if (!isListLayout) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_230);
    
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_231);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_233);
    
	}

    stringBuffer.append(TEXT_234);
    
if (genDiagram.getPalette() != null) {

    stringBuffer.append(TEXT_235);
    if (isStatic) {
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_243);
    if (!isListLayout) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_245);
    }
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_248);
    
	if (next.getDomainMetaClass().isMapEntry()) {
	/*Workaround for Ecore example: map entries cannot be created using factory, only using reflective EFactory.create() method*/

    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_253);
    
	} else {

    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_257);
    
	}

    stringBuffer.append(TEXT_258);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(next.getUniqueIdentifier());
    stringBuffer.append(TEXT_261);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    
	TypeModelFacet facet = next.getModelFacet();
	GenFeature childFeature = facet.getChildMetaFeature();
	GenFeature containmentFeature = facet.getContainmentMetaFeature();
	if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_275);
    
	} else {

    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_280);
    
	}

    stringBuffer.append(TEXT_281);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_282);
    if (next.getDomainMetaClass().isExternalInterface()) {
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_284);
    }
    stringBuffer.append(TEXT_285);
    if(!isListLayout) {
    stringBuffer.append(TEXT_286);
    }
    stringBuffer.append(TEXT_287);
    
}

    
}

    stringBuffer.append(TEXT_288);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_289);
    return stringBuffer.toString();
  }
}
