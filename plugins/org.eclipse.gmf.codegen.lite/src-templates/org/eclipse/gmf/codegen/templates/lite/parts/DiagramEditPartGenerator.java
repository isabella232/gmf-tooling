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
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends AbstractGraphicalEditPart implements IUpdatableEditPart {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String MODEL_ID = \"";
  protected final String TEXT_4 = "\";" + NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = " model) {" + NL + "\t\tsetModel(model);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_11 = " getDiagram() {" + NL + "\t\treturn (";
  protected final String TEXT_12 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\tinstallEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {" + NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {";
  protected final String TEXT_13 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_14 = ".CreateRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = ".CreateRequestEx requestEx = (";
  protected final String TEXT_16 = ".CreateRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = " result = new ";
  protected final String TEXT_18 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_20 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_21 = "Command(getDiagram(), requestEx, (";
  protected final String TEXT_22 = ")getConstraintFor(request)));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_24 = ".getEditingDomain(getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_25 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(final ChangeBoundsRequest request, EditPart child, Object constraint) {" + NL + "\t\t\t\tfinal Node node = (Node) child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_26 = " emfCommand = new ";
  protected final String TEXT_27 = "(\"Change node position/size\") {" + NL + "\t\t\t\t\tprivate Point moveDelta;" + NL + "\t\t\t\t\tprivate Dimension resizeDelta;" + NL + "" + NL + "\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\treturn canExecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (node.getLayoutConstraint() instanceof Bounds == false) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tBounds bounds = (Bounds) node.getLayoutConstraint();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_28 = " original = new ";
  protected final String TEXT_29 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = " transformed = request.getTransformedRectangle(original);" + NL + "\t\t\t\t\t\tresizeDelta = transformed.getSize().expand(original.getSize().negate());" + NL + "\t\t\t\t\t\tmoveDelta = transformed.getTopLeft().translate(original.getTopLeft().negate());" + NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\texecute(moveDelta.getNegated(), resizeDelta.getNegated());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\texecute(moveDelta, resizeDelta);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\texecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprivate void execute(Point move, Dimension resize) {" + NL + "\t\t\t\t\t\tBounds bounds = (Bounds) node.getLayoutConstraint();" + NL + "\t\t\t\t\t\tbounds.setX(bounds.getX() + move.x);" + NL + "\t\t\t\t\t\tbounds.setY(bounds.getY() + move.y);" + NL + "\t\t\t\t\t\tbounds.setWidth(bounds.getWidth() + resize.width);" + NL + "\t\t\t\t\t\tbounds.setHeight(bounds.getHeight() + resize.height);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_31 = ".getEditingDomain(getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFigure() {" + NL + "\t\tIFigure f = new FreeformLayer();" + NL + "\t\tf.setBorder(new MarginBorder(5));" + NL + "\t\tf.setLayoutManager(new FreeformLayout());" + NL + "\t\treturn f;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (";
  protected final String TEXT_32 = ".class == key) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_33 = "(this);" + NL + "\t\t}";
  protected final String TEXT_34 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn getDiagram().getVisibleChildren();" + NL + "\t}" + NL;
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_37 = "static ";
  protected final String TEXT_38 = "class Create";
  protected final String TEXT_39 = "NotationCommand extends ";
  protected final String TEXT_40 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Create";
  protected final String TEXT_41 = "NotationCommand(";
  protected final String TEXT_42 = " parent, " + NL + "\t\t\t\t";
  protected final String TEXT_43 = " domainElement";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = " constraint";
  protected final String TEXT_46 = ") {" + NL + "\t\t\tsuper(parent);" + NL + "\t\t\tNode createdNode = ";
  protected final String TEXT_47 = ".eINSTANCE.createNode();" + NL + "\t\t\tsetCreatedView(createdNode);" + NL + "\t\t\tcreatedNode.setElement(domainElement);" + NL + "\t\t\t";
  protected final String TEXT_48 = ".decorateView(createdNode);";
  protected final String TEXT_49 = NL + "\t\t\t";
  protected final String TEXT_50 = " bounds = ";
  protected final String TEXT_51 = ".eINSTANCE.createBounds();" + NL + "\t\t\tcreatedNode.setLayoutConstraint(bounds);" + NL + "\t\t\tbounds.setX(constraint.x);" + NL + "\t\t\tbounds.setY(constraint.y);";
  protected final String TEXT_52 = NL + "\t\t\tbounds.setWidth(Math.max(constraint.width, ";
  protected final String TEXT_53 = "));" + NL + "\t\t\tbounds.setHeight(Math.max(constraint.height, ";
  protected final String TEXT_54 = "));";
  protected final String TEXT_55 = NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_57 = "static ";
  protected final String TEXT_58 = "class Create";
  protected final String TEXT_59 = "Command extends ";
  protected final String TEXT_60 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final Create";
  protected final String TEXT_61 = "NotationCommand notationAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_62 = "Command(";
  protected final String TEXT_63 = " parent, ";
  protected final String TEXT_64 = ".CreateRequestEx request";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = " constraint";
  protected final String TEXT_67 = ") {" + NL + "\t\t\t";
  protected final String TEXT_68 = " domainModelEditDomain = ";
  protected final String TEXT_69 = ".getEditingDomain(parent.getDiagram().getElement());";
  protected final String TEXT_70 = NL + "\t\t\t";
  protected final String TEXT_71 = " createdDomainElement = ";
  protected final String TEXT_72 = ".eINSTANCE.create(" + NL + "\t\t\t\t";
  protected final String TEXT_73 = ".eINSTANCE.get";
  protected final String TEXT_74 = "());";
  protected final String TEXT_75 = NL + "\t\t\t";
  protected final String TEXT_76 = " createdDomainElement = ";
  protected final String TEXT_77 = ".eINSTANCE.create";
  protected final String TEXT_78 = "();";
  protected final String TEXT_79 = NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ".initializeElement(createdDomainElement);";
  protected final String TEXT_83 = NL + "\t\t\t";
  protected final String TEXT_84 = " compoundCommand = new ";
  protected final String TEXT_85 = "();" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_86 = ".create(domainModelEditDomain, ";
  protected final String TEXT_87 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_88 = ".eINSTANCE.get";
  protected final String TEXT_89 = "(), createdDomainElement));" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_90 = ".create(domainModelEditDomain, ";
  protected final String TEXT_91 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_92 = ".eINSTANCE.get";
  protected final String TEXT_93 = "(), createdDomainElement));" + NL + "\t\t\tthis.domainModelAddCommand = compoundCommand;";
  protected final String TEXT_94 = NL + "\t\t\tthis.domainModelAddCommand = ";
  protected final String TEXT_95 = ".create(domainModelEditDomain, ";
  protected final String TEXT_96 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_97 = ".eINSTANCE.get";
  protected final String TEXT_98 = "(), createdDomainElement);";
  protected final String TEXT_99 = NL + "\t\t\tthis.notationAddCommand = new Create";
  protected final String TEXT_100 = "NotationCommand(parent, createdDomainElement";
  protected final String TEXT_101 = ", constraint";
  protected final String TEXT_102 = ");" + NL + "\t\t\trequest.setCreatedObject(notationAddCommand.getCreatedView());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tnotationAddCommand.execute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tnotationAddCommand.undo();" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = NL;
  protected final String TEXT_105 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_106 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_107 = " feature, ";
  protected final String TEXT_108 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_109 = NL;
  protected final String TEXT_110 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_111 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_112 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class UpdateManager extends ";
  protected final String TEXT_113 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_114 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_115 = " affectedEditParts = findAffectedParts(msg);" + NL + "\t\t\tfor(";
  protected final String TEXT_116 = " it = affectedEditParts.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\tIUpdatableEditPart next = (IUpdatableEditPart) it.next();" + NL + "\t\t\t\tIUpdatableEditPart.Refresher refresher = next.getRefresher((";
  protected final String TEXT_117 = ")msg.getFeature(), msg);" + NL + "\t\t\t\tif (refresher != null) {" + NL + "\t\t\t\t\trefresher.refresh();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_118 = "/*<IUpdatableEditPart>*/ findAffectedParts(";
  protected final String TEXT_119 = " msg) {" + NL + "\t\t\tObject notifier = msg.getNotifier();" + NL + "\t\t\tif (notifier instanceof ";
  protected final String TEXT_120 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_121 = " view = getView((EObject) notifier);" + NL + "\t\t\t\tif (view != null) {" + NL + "\t\t\t\t\tEditPart affectedEditPart = (EditPart) getViewer().getEditPartRegistry().get(view);" + NL + "\t\t\t\t\tif (affectedEditPart != null) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_122 = ".singleton(affectedEditPart);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn ";
  protected final String TEXT_123 = ".EMPTY_LIST;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_124 = " getView(EObject offspring) {" + NL + "\t\t\twhile (offspring != null && offspring instanceof View == false) {" + NL + "\t\t\t\toffspring = offspring.eContainer();" + NL + "\t\t\t}" + NL + "\t\t\treturn (";
  protected final String TEXT_125 = ") offspring;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagram().eAdapters().add(updateManager);" + NL + "\t\tgetDiagram().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\tinstallNotationModelRefresher();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tuninstallNotationModelRefresher();" + NL + "\t\tgetDiagram().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tgetDiagram().eAdapters().remove(updateManager);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_126 = NL;
  protected final String TEXT_127 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\tNotationModelRefresher refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_128 = " domainModelEditDomain = ";
  protected final String TEXT_129 = ".getEditingDomain(";
  protected final String TEXT_130 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate NotationModelRefresher notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate NotationModelRefresher getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_131 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_132 = " filter;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_133 = " editingDomain;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic NotationModelRefresher() {" + NL + "\t\t\tcreateFilter();" + NL + "\t\t}";
  protected final String TEXT_134 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_135 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_136 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_137 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_138 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void createFilter() {";
  protected final String TEXT_139 = NL + "\t\t\tfilter = ";
  protected final String TEXT_140 = ".createFeatureFilter(";
  protected final String TEXT_141 = ".eINSTANCE.get";
  protected final String TEXT_142 = "());";
  protected final String TEXT_143 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_144 = ".createFeatureFilter(";
  protected final String TEXT_145 = ".eINSTANCE.get";
  protected final String TEXT_146 = "()));";
  protected final String TEXT_147 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_148 = ".createNotifierFilter(";
  protected final String TEXT_149 = "));";
  protected final String TEXT_150 = NL + "\t\t\tfilter = ";
  protected final String TEXT_151 = ".createNotifierFilter(";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_154 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void install(";
  protected final String TEXT_155 = " editingDomain) {" + NL + "\t\t\tif (this.editingDomain != null && !this.editingDomain.equals(editingDomain)) {" + NL + "\t\t\t\tthrow new IllegalStateException(\"Already listening to another editing domain\");" + NL + "\t\t\t}" + NL + "\t\t\tthis.editingDomain = editingDomain;" + NL + "\t\t\tthis.editingDomain.addResourceSetListener(this);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isInstalled() {" + NL + "\t\t\treturn editingDomain != null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void uninstall() {" + NL + "\t\t\tif (isInstalled()) {" + NL + "\t\t\t\teditingDomain.removeResourceSetListener(this);" + NL + "\t\t\t\teditingDomain = null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isPrecommitOnly() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_156 = " transactionAboutToCommit(";
  protected final String TEXT_157 = " event) {" + NL + "\t\t\treturn getRefreshNotationModelCommand();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_158 = " getFilter() {" + NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_159 = " command = getRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_160 = " domainModelEditDomain = ";
  protected final String TEXT_161 = ".getEditingDomain(";
  protected final String TEXT_162 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new WrappingCommand(domainModelEditDomain, command));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_163 = " getRefreshNotationModelCommand() {" + NL + "\t\t";
  protected final String TEXT_164 = " semanticChildren = getSemanticChildren();" + NL + "\t\t";
  protected final String TEXT_165 = " notationalChildren = ";
  protected final String TEXT_166 = ".getChildren();" + NL + "\t\tfinal ";
  protected final String TEXT_167 = " semanticToNotational = new ";
  protected final String TEXT_168 = "();" + NL + "\t\tfor(";
  protected final String TEXT_169 = " it = notationalChildren.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_170 = " next = (";
  protected final String TEXT_171 = ") it.next();" + NL + "\t\t\t";
  protected final String TEXT_172 = " nextSemantic = next.getElement();" + NL + "\t\t\tif (nextSemantic != null) {" + NL + "\t\t\t\tsemanticToNotational.put(nextSemantic, next);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_173 = " parentView = ";
  protected final String TEXT_174 = ";" + NL + "\t\t";
  protected final String TEXT_175 = " command = new ";
  protected final String TEXT_176 = "();" + NL + "\t\tfor(";
  protected final String TEXT_177 = " it = semanticChildren.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_178 = " next = (";
  protected final String TEXT_179 = ") it.next();" + NL + "\t\t\t";
  protected final String TEXT_180 = " currentView = (";
  protected final String TEXT_181 = ") semanticToNotational.remove(next);" + NL + "\t\t\tint nodeVisualID = ";
  protected final String TEXT_182 = ".INSTANCE.getNodeVisualID(parentView, next);" + NL + "\t\t\tif (currentView == null) {" + NL + "\t\t\t\tif (shouldCreateView(next)) {" + NL + "\t\t\t\t\tcommand.appendIfCanExecute(getCreateNotationalElementCommand(parentView, next, nodeVisualID));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (nodeVisualID != ";
  protected final String TEXT_183 = ".getVisualID(currentView)) {" + NL + "\t\t\t\t";
  protected final String TEXT_184 = " notationalCommand = getCreateNotationalElementCommand(parentView, next, nodeVisualID);" + NL + "\t\t\t\tif (notationalCommand != null) {" + NL + "\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_185 = "(parentView, notationalCommand, currentView));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tfor(";
  protected final String TEXT_186 = " it = semanticToNotational.values().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_187 = " obsoleteView = (";
  protected final String TEXT_188 = ") it.next();" + NL + "\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_189 = "(parentView, obsoleteView));" + NL + "\t\t}" + NL + "\t\treturn command.getCommandList().isEmpty() ? null : command;" + NL + "\t}" + NL + "" + NL + "\tprivate ";
  protected final String TEXT_190 = " getCreateNotationalElementCommand(";
  protected final String TEXT_191 = " parentView, ";
  protected final String TEXT_192 = " domainElement, int nodeVisualID) {" + NL + "\t\tswitch (nodeVisualID) {";
  protected final String TEXT_193 = NL + "\t\tcase ";
  protected final String TEXT_194 = ".VISUAL_ID:" + NL + "\t\t\tif (domainElement instanceof ";
  protected final String TEXT_195 = ") {" + NL + "\t\t\t\treturn new Create";
  protected final String TEXT_196 = "NotationCommand(parentView, domainElement";
  protected final String TEXT_197 = ", new Rectangle(0, 0, 0, 0)";
  protected final String TEXT_198 = ");" + NL + "\t\t\t}" + NL + "\t\t\treturn null;";
  protected final String TEXT_199 = NL + "\t\tdefault:" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_200 = " getSemanticChildren() {";
  protected final String TEXT_201 = NL;
  protected final String TEXT_202 = NL + "\treturn ";
  protected final String TEXT_203 = ".EMPTY_LIST;";
  protected final String TEXT_204 = NL + "\t";
  protected final String TEXT_205 = " result = new ";
  protected final String TEXT_206 = "();";
  protected final String TEXT_207 = NL + "\t";
  protected final String TEXT_208 = " viewObject = ";
  protected final String TEXT_209 = ";" + NL + "\t";
  protected final String TEXT_210 = " modelObject = ";
  protected final String TEXT_211 = ";" + NL + "\t";
  protected final String TEXT_212 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_213 = NL + "\tfor(";
  protected final String TEXT_214 = " it = ((";
  protected final String TEXT_215 = ")modelObject).";
  protected final String TEXT_216 = "().iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_217 = ") it.next();";
  protected final String TEXT_218 = NL + "\tnextValue = ((";
  protected final String TEXT_219 = ")modelObject).";
  protected final String TEXT_220 = "();";
  protected final String TEXT_221 = NL + "\tnodeVID = ";
  protected final String TEXT_222 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_223 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_224 = NL + "\tcase ";
  protected final String TEXT_225 = ".VISUAL_ID: {";
  protected final String TEXT_226 = NL + "\tif (";
  protected final String TEXT_227 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_228 = NL + "\t\tresult.add(nextValue);";
  protected final String TEXT_229 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_230 = NL + "\t\t}";
  protected final String TEXT_231 = NL + "\t}";
  protected final String TEXT_232 = NL + "\t}";
  protected final String TEXT_233 = NL + "\treturn result;";
  protected final String TEXT_234 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t * The generated code always returns ";
  protected final String TEXT_235 = ". " + NL + "\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean shouldCreateView(EObject domainElement) {" + NL + "\t\treturn ";
  protected final String TEXT_236 = ";" + NL + "\t}";
  protected final String TEXT_237 = NL;
  protected final String TEXT_238 = NL;
  protected final String TEXT_239 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_240 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_241 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_242 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate UpdateManager updateManager = new UpdateManager();" + NL + "}";
  protected final String TEXT_243 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("NotationModelRefresher");	//from notationModelRefresher.jetinc
List childNodes = genDiagram.getTopLevelNodes();

    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_4);
    {
GenCommonBase genCommonBase = genDiagram;
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_12);
    if (null != genDiagram.getPalette()) {
final Palette palette = genDiagram.getPalette();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_18);
    
for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenTopLevelNode next = (GenTopLevelNode)it.next();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_22);
    
}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_24);
    }/*when there's palette*/
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToHelper"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToGrid"));
    stringBuffer.append(TEXT_33);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_34);
    
for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenTopLevelNode next = (GenTopLevelNode)it.next();
	boolean isStatic = true;
	boolean isListLayout = false;
	String resolvedSemanticElement = "parent.getElement()";

    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    if (isStatic) {
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_43);
    if (!isListLayout) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    
	if (!isListLayout) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_51);
    
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_54);
    
	}

    stringBuffer.append(TEXT_55);
    
if (genDiagram.getPalette() != null) {

    stringBuffer.append(TEXT_56);
    if (isStatic) {
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_64);
    if (!isListLayout) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_69);
    
	if (next.getDomainMetaClass().isMapEntry()) {
	/*Workaround for Ecore example: map entries cannot be created using factory, only using reflective EFactory.create() method*/

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_74);
    
	} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_78);
    
	}

    stringBuffer.append(TEXT_79);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(next.getUniqueIdentifier());
    stringBuffer.append(TEXT_82);
    
	TypeModelFacet facet = next.getModelFacet();
	GenFeature childFeature = facet.getChildMetaFeature();
	GenFeature containmentFeature = facet.getContainmentMetaFeature();
	if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_93);
    
	} else {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_98);
    
	}

    stringBuffer.append(TEXT_99);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_100);
    if(!isListLayout) {
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    
}

    
}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EContentAdapter"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_125);
    
{
String _getDiagramCode = "getDiagram()";
String _getViewCode = "getDiagram()";
String _getSemanticElementCode = "getDiagram().getElement()";
boolean isListLayout = false;

    stringBuffer.append(TEXT_126);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetListenerImpl"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_133);
    
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

    stringBuffer.append(TEXT_134);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_137);
    
}

    stringBuffer.append(TEXT_138);
    
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

    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_142);
    
	} else {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_146);
    
	}
}	//for

    
if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_149);
    
} else {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_152);
    
}

    
if (hasConstraintsInChildren) {

    stringBuffer.append(TEXT_153);
    
}

    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetChangeEvent"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReplaceNotationalElementCommand"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalElementCommand"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_192);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(nextNode.getDomainMetaClass().getName());
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_196);
    if (!isListLayout) {
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    
}

    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_203);
    
} else {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_206);
    
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

    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_212);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(childMetaFeature.getGetAccessor());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_217);
    
		} else {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(childMetaFeature.getGetAccessor());
    stringBuffer.append(TEXT_220);
    
	}

    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_222);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_223);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_225);
    
		} else {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_227);
    
		}

    stringBuffer.append(TEXT_228);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_229);
    
		} else {

    stringBuffer.append(TEXT_230);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_231);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_232);
    
	}
}

    stringBuffer.append(TEXT_233);
    
}

    stringBuffer.append(TEXT_234);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_236);
    
}

    stringBuffer.append(TEXT_237);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_242);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_243);
    return stringBuffer.toString();
  }
}
