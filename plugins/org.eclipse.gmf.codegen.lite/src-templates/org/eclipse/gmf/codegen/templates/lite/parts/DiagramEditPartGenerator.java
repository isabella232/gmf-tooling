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
  protected final String TEXT_12 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_15 = " view = (";
  protected final String TEXT_16 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_17 = " view = (";
  protected final String TEXT_18 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addNotify() {" + NL + "\t\tgetDiagram().eAdapters().add(updateManager);" + NL + "\t\tgetDiagram().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\tsuper.addNotify();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\tinstallEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {" + NL + "\t\t\tprotected Command getCreateCommand(CreateRequest request) {";
  protected final String TEXT_19 = NL + "\t\t\t\tif (request instanceof ";
  protected final String TEXT_20 = ".CreateRequestEx) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = ".CreateRequestEx requestEx = (";
  protected final String TEXT_22 = ".CreateRequestEx) request;" + NL + "\t\t\t\t\tint[] visualIds = requestEx.getVisualIds();" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = " result = new ";
  protected final String TEXT_24 = "();" + NL + "\t\t\t\t\tfor(int i = 0; i < visualIds.length; i++) {" + NL + "\t\t\t\t\t\tint nextVisualId = visualIds[i];" + NL + "\t\t\t\t\t\tswitch (nextVisualId) {";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\tcase ";
  protected final String TEXT_26 = ".VISUAL_ID:" + NL + "\t\t\t\t\t\t\tresult.append(new Create";
  protected final String TEXT_27 = "Command(getDiagram(), requestEx, (";
  protected final String TEXT_28 = ")getConstraintFor(request)));" + NL + "\t\t\t\t\t\t\tbreak;";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_30 = ".getEditingDomain(getDiagram().getElement()), result);" + NL + "\t\t\t\t}";
  protected final String TEXT_31 = NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(final ChangeBoundsRequest request, EditPart child, Object constraint) {" + NL + "\t\t\t\tfinal Node node = (Node) child.getModel();" + NL + "\t\t\t\t";
  protected final String TEXT_32 = " emfCommand = new ";
  protected final String TEXT_33 = "(\"Change node position/size\") {" + NL + "\t\t\t\t\tprivate Point moveDelta;" + NL + "\t\t\t\t\tprivate Dimension resizeDelta;" + NL + "" + NL + "\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\treturn canExecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\t\t\tif (node.getLayoutConstraint() instanceof Bounds == false) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tBounds bounds = (Bounds) node.getLayoutConstraint();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = " original = new ";
  protected final String TEXT_35 = "(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = " transformed = request.getTransformedRectangle(original);" + NL + "\t\t\t\t\t\tresizeDelta = transformed.getSize().expand(original.getSize().negate());" + NL + "\t\t\t\t\t\tmoveDelta = transformed.getTopLeft().translate(original.getTopLeft().negate());" + NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\texecute(moveDelta.getNegated(), resizeDelta.getNegated());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\texecute(moveDelta, resizeDelta);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\texecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprivate void execute(Point move, Dimension resize) {" + NL + "\t\t\t\t\t\tBounds bounds = (Bounds) node.getLayoutConstraint();" + NL + "\t\t\t\t\t\tbounds.setX(bounds.getX() + move.x);" + NL + "\t\t\t\t\t\tbounds.setY(bounds.getY() + move.y);" + NL + "\t\t\t\t\t\tbounds.setWidth(bounds.getWidth() + resize.width);" + NL + "\t\t\t\t\t\tbounds.setHeight(bounds.getHeight() + resize.height);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\treturn new WrappingCommand(";
  protected final String TEXT_37 = ".getEditingDomain(getDiagram().getElement()), emfCommand);" + NL + "\t\t\t}" + NL + "\t\t\tprotected Command createChangeConstraintCommand(EditPart child, Object constraint) {" + NL + "\t\t\t\tassert false;" + NL + "\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_38 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_39 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFigure() {" + NL + "\t\tIFigure f = new FreeformLayer();" + NL + "\t\tf.setBorder(new MarginBorder(5));" + NL + "\t\tf.setLayoutManager(new FreeformLayout());" + NL + "\t\treturn f;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (";
  protected final String TEXT_40 = ".class == key) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_41 = "(this);" + NL + "\t\t}";
  protected final String TEXT_42 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn getDiagram().getVisibleChildren();" + NL + "\t}" + NL;
  protected final String TEXT_43 = NL;
  protected final String TEXT_44 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_45 = "static ";
  protected final String TEXT_46 = "class Create";
  protected final String TEXT_47 = "NotationCommand extends ";
  protected final String TEXT_48 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Create";
  protected final String TEXT_49 = "NotationCommand(";
  protected final String TEXT_50 = " parent, " + NL + "\t\t\t\t";
  protected final String TEXT_51 = " domainElement";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = " constraint";
  protected final String TEXT_54 = ") {" + NL + "\t\t\tsuper(parent);" + NL + "\t\t\tNode createdNode = ";
  protected final String TEXT_55 = ".eINSTANCE.createNode();" + NL + "\t\t\tsetCreatedView(createdNode);" + NL + "\t\t\tcreatedNode.setElement(domainElement);" + NL + "\t\t\t";
  protected final String TEXT_56 = ".decorateView(createdNode);";
  protected final String TEXT_57 = NL + "\t\t\t";
  protected final String TEXT_58 = " bounds = ";
  protected final String TEXT_59 = ".eINSTANCE.createBounds();" + NL + "\t\t\tcreatedNode.setLayoutConstraint(bounds);" + NL + "\t\t\tbounds.setX(constraint.x);" + NL + "\t\t\tbounds.setY(constraint.y);";
  protected final String TEXT_60 = NL + "\t\t\tbounds.setWidth(Math.max(constraint.width, ";
  protected final String TEXT_61 = "));" + NL + "\t\t\tbounds.setHeight(Math.max(constraint.height, ";
  protected final String TEXT_62 = "));";
  protected final String TEXT_63 = NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_64 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_65 = "static ";
  protected final String TEXT_66 = "class Create";
  protected final String TEXT_67 = "Command extends ";
  protected final String TEXT_68 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final Create";
  protected final String TEXT_69 = "NotationCommand notationAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_70 = "Command(";
  protected final String TEXT_71 = " parent, ";
  protected final String TEXT_72 = ".CreateRequestEx request";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = " constraint";
  protected final String TEXT_75 = ") {" + NL + "\t\t\t";
  protected final String TEXT_76 = " domainModelEditDomain = ";
  protected final String TEXT_77 = ".getEditingDomain(parent.getDiagram().getElement());";
  protected final String TEXT_78 = NL + "\t\t\t";
  protected final String TEXT_79 = " createdDomainElement = ";
  protected final String TEXT_80 = ".eINSTANCE.create(" + NL + "\t\t\t\t";
  protected final String TEXT_81 = ".eINSTANCE.get";
  protected final String TEXT_82 = "());";
  protected final String TEXT_83 = NL + "\t\t\t";
  protected final String TEXT_84 = " createdDomainElement = ";
  protected final String TEXT_85 = ".eINSTANCE.create";
  protected final String TEXT_86 = "();";
  protected final String TEXT_87 = NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ".initializeElement(createdDomainElement);";
  protected final String TEXT_91 = NL + "\t\t\t";
  protected final String TEXT_92 = " compoundCommand = new ";
  protected final String TEXT_93 = "();" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_94 = ".create(domainModelEditDomain, ";
  protected final String TEXT_95 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_96 = ".eINSTANCE.get";
  protected final String TEXT_97 = "(), createdDomainElement));" + NL + "\t\t\tcompoundCommand.append(";
  protected final String TEXT_98 = ".create(domainModelEditDomain, ";
  protected final String TEXT_99 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_100 = ".eINSTANCE.get";
  protected final String TEXT_101 = "(), createdDomainElement));" + NL + "\t\t\tthis.domainModelAddCommand = compoundCommand;";
  protected final String TEXT_102 = NL + "\t\t\tthis.domainModelAddCommand = ";
  protected final String TEXT_103 = ".create(domainModelEditDomain, ";
  protected final String TEXT_104 = ", " + NL + "\t\t\t\t";
  protected final String TEXT_105 = ".eINSTANCE.get";
  protected final String TEXT_106 = "(), createdDomainElement);";
  protected final String TEXT_107 = NL + "\t\t\tthis.notationAddCommand = new Create";
  protected final String TEXT_108 = "NotationCommand(parent, createdDomainElement";
  protected final String TEXT_109 = ", constraint";
  protected final String TEXT_110 = ");" + NL + "\t\t\trequest.setCreatedObject(notationAddCommand.getCreatedView());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final org.eclipse.emf.common.command.Command domainModelAddCommand;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn domainModelAddCommand != null" + NL + "\t\t\t\t\t&& domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\tdomainModelAddCommand.execute();" + NL + "\t\t\tnotationAddCommand.execute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\tnotationAddCommand.undo();" + NL + "\t\t\tdomainModelAddCommand.undo();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_114 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_115 = " feature, ";
  protected final String TEXT_116 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_119 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_120 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class UpdateManager extends ";
  protected final String TEXT_121 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_122 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_123 = " affectedEditParts = findAffectedParts(msg);" + NL + "\t\t\tfor(";
  protected final String TEXT_124 = " it = affectedEditParts.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\tIUpdatableEditPart next = (IUpdatableEditPart) it.next();" + NL + "\t\t\t\tIUpdatableEditPart.Refresher refresher = next.getRefresher((";
  protected final String TEXT_125 = ")msg.getFeature(), msg);" + NL + "\t\t\t\tif (refresher != null) {" + NL + "\t\t\t\t\trefresher.refresh();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_126 = "/*<IUpdatableEditPart>*/ findAffectedParts(";
  protected final String TEXT_127 = " msg) {" + NL + "\t\t\tObject notifier = msg.getNotifier();" + NL + "\t\t\tif (notifier instanceof ";
  protected final String TEXT_128 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_129 = " view = getView((EObject) notifier);" + NL + "\t\t\t\tif (view != null) {" + NL + "\t\t\t\t\tEditPart affectedEditPart = (EditPart) getViewer().getEditPartRegistry().get(view);" + NL + "\t\t\t\t\tif (affectedEditPart != null) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_130 = ".singleton(affectedEditPart);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn ";
  protected final String TEXT_131 = ".EMPTY_LIST;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_132 = " getView(EObject offspring) {" + NL + "\t\t\twhile (offspring != null && offspring instanceof View == false) {" + NL + "\t\t\t\toffspring = offspring.eContainer();" + NL + "\t\t\t}" + NL + "\t\t\treturn (";
  protected final String TEXT_133 = ") offspring;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tif (!getDiagram().eAdapters().contains(updateManager)) {" + NL + "\t\t\tgetDiagram().eAdapters().add(updateManager);" + NL + "\t\t}" + NL + "\t\tif (!getDiagram().getElement().eAdapters().contains(domainModelRefresher)) {" + NL + "\t\t\tgetDiagram().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\t}" + NL + "\t\tinstallNotationModelRefresher();";
  protected final String TEXT_134 = NL + "\t\tinstallLinkNotationModelRefresher();";
  protected final String TEXT_135 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {";
  protected final String TEXT_136 = NL + "\t\tuninstallLinkNotationModelRefresher();";
  protected final String TEXT_137 = NL + "\t\tuninstallNotationModelRefresher();" + NL + "\t\tgetDiagram().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tgetDiagram().eAdapters().remove(updateManager);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_138 = NL;
  protected final String TEXT_139 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installNotationModelRefresher() {" + NL + "\t\tNotationModelRefresher refresher = getNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_140 = " domainModelEditDomain = ";
  protected final String TEXT_141 = ".getEditingDomain(";
  protected final String TEXT_142 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallNotationModelRefresher() {" + NL + "\t\tgetNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate NotationModelRefresher notationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate NotationModelRefresher getNotationModelRefresher() {" + NL + "\t\tif (notationModelRefresher == null) {" + NL + "\t\t\tnotationModelRefresher = new NotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn notationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class NotationModelRefresher extends ";
  protected final String TEXT_143 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_144 = " filter;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_145 = " editingDomain;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic NotationModelRefresher() {" + NL + "\t\t\tcreateFilter();" + NL + "\t\t}";
  protected final String TEXT_146 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Children of this element are selected based on constraint declared in ";
  protected final String TEXT_147 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_148 = " getConstrainedChildrenFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_149 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_150 = NL + NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void createFilter() {";
  protected final String TEXT_151 = NL + "\t\t\tfilter = ";
  protected final String TEXT_152 = ".createFeatureFilter(";
  protected final String TEXT_153 = ".eINSTANCE.get";
  protected final String TEXT_154 = "());";
  protected final String TEXT_155 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_156 = ".createFeatureFilter(";
  protected final String TEXT_157 = ".eINSTANCE.get";
  protected final String TEXT_158 = "()));";
  protected final String TEXT_159 = NL + "\t\t\tfilter = filter.and(";
  protected final String TEXT_160 = ".createNotifierFilter(";
  protected final String TEXT_161 = "));";
  protected final String TEXT_162 = NL + "\t\t\tfilter = ";
  protected final String TEXT_163 = ".createNotifierFilter(";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\t\t\tfilter = getConstrainedChildrenFilter().or(filter);";
  protected final String TEXT_166 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void install(";
  protected final String TEXT_167 = " editingDomain) {" + NL + "\t\t\tif (this.editingDomain != null && !this.editingDomain.equals(editingDomain)) {" + NL + "\t\t\t\tthrow new IllegalStateException(\"Already listening to another editing domain\");" + NL + "\t\t\t}" + NL + "\t\t\tthis.editingDomain = editingDomain;" + NL + "\t\t\tthis.editingDomain.addResourceSetListener(this);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isInstalled() {" + NL + "\t\t\treturn editingDomain != null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void uninstall() {" + NL + "\t\t\tif (isInstalled()) {" + NL + "\t\t\t\teditingDomain.removeResourceSetListener(this);" + NL + "\t\t\t\teditingDomain = null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isPrecommitOnly() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_168 = " transactionAboutToCommit(";
  protected final String TEXT_169 = " event) {" + NL + "\t\t\treturn getRefreshNotationModelCommand();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_170 = " getFilter() {" + NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshNotationModel() {" + NL + "\t\t";
  protected final String TEXT_171 = " command = getRefreshNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_172 = " domainModelEditDomain = ";
  protected final String TEXT_173 = ".getEditingDomain(";
  protected final String TEXT_174 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new WrappingCommand(domainModelEditDomain, command));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_175 = " getRefreshNotationModelCommand() {" + NL + "\t\t";
  protected final String TEXT_176 = " semanticChildren = getSemanticChildren();" + NL + "\t\t";
  protected final String TEXT_177 = " notationalChildren = ";
  protected final String TEXT_178 = ".getChildren();" + NL + "\t\tfinal ";
  protected final String TEXT_179 = " semanticToNotational = new ";
  protected final String TEXT_180 = "();" + NL + "\t\tfor(";
  protected final String TEXT_181 = " it = notationalChildren.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_182 = " next = (";
  protected final String TEXT_183 = ") it.next();" + NL + "\t\t\t";
  protected final String TEXT_184 = " nextSemantic = next.getElement();" + NL + "\t\t\tif (nextSemantic != null) {" + NL + "\t\t\t\tsemanticToNotational.put(nextSemantic, next);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_185 = " parentView = ";
  protected final String TEXT_186 = ";" + NL + "\t\t";
  protected final String TEXT_187 = " command = new ";
  protected final String TEXT_188 = "();" + NL + "\t\tfor(";
  protected final String TEXT_189 = " it = semanticChildren.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_190 = " next = (";
  protected final String TEXT_191 = ") it.next();" + NL + "\t\t\t";
  protected final String TEXT_192 = " currentView = (";
  protected final String TEXT_193 = ") semanticToNotational.remove(next);" + NL + "\t\t\tint nodeVisualID = ";
  protected final String TEXT_194 = ".INSTANCE.getNodeVisualID(parentView, next);" + NL + "\t\t\tif (currentView == null) {" + NL + "\t\t\t\tif (shouldCreateView(next)) {" + NL + "\t\t\t\t\tcommand.appendIfCanExecute(getCreateNotationalElementCommand(parentView, next, nodeVisualID));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (nodeVisualID != ";
  protected final String TEXT_195 = ".getVisualID(currentView)) {" + NL + "\t\t\t\t";
  protected final String TEXT_196 = " notationalCommand = getCreateNotationalElementCommand(parentView, next, nodeVisualID);" + NL + "\t\t\t\tif (notationalCommand != null) {" + NL + "\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_197 = "(parentView, notationalCommand, currentView));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tfor(";
  protected final String TEXT_198 = " it = semanticToNotational.values().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_199 = " obsoleteView = (";
  protected final String TEXT_200 = ") it.next();" + NL + "\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_201 = "(parentView, obsoleteView));" + NL + "\t\t}" + NL + "\t\treturn command.getCommandList().isEmpty() ? null : command;" + NL + "\t}" + NL + "" + NL + "\tprivate ";
  protected final String TEXT_202 = " getCreateNotationalElementCommand(";
  protected final String TEXT_203 = " parentView, ";
  protected final String TEXT_204 = " domainElement, int nodeVisualID) {" + NL + "\t\tswitch (nodeVisualID) {";
  protected final String TEXT_205 = NL + "\t\tcase ";
  protected final String TEXT_206 = ".VISUAL_ID:" + NL + "\t\t\tif (domainElement instanceof ";
  protected final String TEXT_207 = ") {" + NL + "\t\t\t\treturn new Create";
  protected final String TEXT_208 = "NotationCommand(parentView, domainElement";
  protected final String TEXT_209 = ", new Rectangle(0, 0, 0, 0)";
  protected final String TEXT_210 = ");" + NL + "\t\t\t}" + NL + "\t\t\treturn null;";
  protected final String TEXT_211 = NL + "\t\tdefault:" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_212 = " getSemanticChildren() {";
  protected final String TEXT_213 = NL;
  protected final String TEXT_214 = NL + "\treturn ";
  protected final String TEXT_215 = ".EMPTY_LIST;";
  protected final String TEXT_216 = NL + "\t";
  protected final String TEXT_217 = " result = new ";
  protected final String TEXT_218 = "();";
  protected final String TEXT_219 = NL + "\t";
  protected final String TEXT_220 = " viewObject = ";
  protected final String TEXT_221 = ";" + NL + "\t";
  protected final String TEXT_222 = " modelObject = ";
  protected final String TEXT_223 = ";" + NL + "\t";
  protected final String TEXT_224 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_225 = NL + "\tfor(";
  protected final String TEXT_226 = " it = ((";
  protected final String TEXT_227 = ")modelObject).";
  protected final String TEXT_228 = "().iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_229 = ") it.next();";
  protected final String TEXT_230 = NL + "\tnextValue = ((";
  protected final String TEXT_231 = ")modelObject).";
  protected final String TEXT_232 = "();";
  protected final String TEXT_233 = NL + "\tnodeVID = ";
  protected final String TEXT_234 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_235 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_236 = NL + "\tcase ";
  protected final String TEXT_237 = ".VISUAL_ID: {";
  protected final String TEXT_238 = NL + "\tif (";
  protected final String TEXT_239 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_240 = NL + "\t\tresult.add(nextValue);";
  protected final String TEXT_241 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_242 = NL + "\t\t}";
  protected final String TEXT_243 = NL + "\t}";
  protected final String TEXT_244 = NL + "\t}";
  protected final String TEXT_245 = NL + "\treturn result;";
  protected final String TEXT_246 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns whether a notational element should be created for the given domain element. " + NL + "\t * The generated code always returns ";
  protected final String TEXT_247 = ". " + NL + "\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean shouldCreateView(EObject domainElement) {" + NL + "\t\treturn ";
  protected final String TEXT_248 = ";" + NL + "\t}" + NL;
  protected final String TEXT_249 = NL;
  protected final String TEXT_250 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void installLinkNotationModelRefresher() {" + NL + "\t\tLinkNotationModelRefresher refresher = getLinkNotationModelRefresher();" + NL + "\t\tif (refresher.isInstalled()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_251 = " domainModelEditDomain = ";
  protected final String TEXT_252 = ".getEditingDomain(";
  protected final String TEXT_253 = ".getElement());" + NL + "\t\trefresher.install(domainModelEditDomain);" + NL + "\t\trefreshLinkNotationModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void uninstallLinkNotationModelRefresher() {" + NL + "\t\tgetLinkNotationModelRefresher().uninstall();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher linkNotationModelRefresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LinkNotationModelRefresher getLinkNotationModelRefresher() {" + NL + "\t\tif (linkNotationModelRefresher == null) {" + NL + "\t\t\tlinkNotationModelRefresher = new LinkNotationModelRefresher();" + NL + "\t\t}" + NL + "\t\treturn linkNotationModelRefresher;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class LinkNotationModelRefresher extends ";
  protected final String TEXT_254 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_255 = " filter;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_256 = " editingDomain;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LinkNotationModelRefresher() {" + NL + "\t\t\tcreateFilter();" + NL + "\t\t}";
  protected final String TEXT_257 = NL + NL + "\t\t/**" + NL + "\t\t * NB: Child links of this element are selected based on constraint declared in ";
  protected final String TEXT_258 = ". " + NL + "\t\t * Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in " + NL + "\t\t * notational model having to be updated." + NL + "\t\t * <p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications" + NL + "\t\t * result in such an update." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_259 = " getConstrainedChildLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_260 = ".NOT_TOUCH;" + NL + "\t\t}";
  protected final String TEXT_261 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly result in uncontained links. " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_262 = " createUncontainedLinksFilter() {" + NL + "\t\t\treturn ";
  protected final String TEXT_263 = ".createEventTypeFilter(";
  protected final String TEXT_264 = ".SET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_265 = ".createEventTypeFilter(";
  protected final String TEXT_266 = ".UNSET).or(" + NL + "\t\t\t\t";
  protected final String TEXT_267 = ".createEventTypeFilter(";
  protected final String TEXT_268 = ".REMOVE).or(" + NL + "\t\t\t\t";
  protected final String TEXT_269 = ".createEventTypeFilter(";
  protected final String TEXT_270 = ".REMOVE_MANY)" + NL + "\t\t\t)));" + NL + "\t\t}";
  protected final String TEXT_271 = NL + "\t\t/**" + NL + "\t\t * Creates a notification filter which filters notifications that may possibly affect the notational model" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void createFilter() {";
  protected final String TEXT_272 = NL;
  protected final String TEXT_273 = NL + "\t\t\tfilter = ";
  protected final String TEXT_274 = ".createFeatureFilter(";
  protected final String TEXT_275 = ".eINSTANCE.get";
  protected final String TEXT_276 = "());";
  protected final String TEXT_277 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_278 = ".createFeatureFilter(";
  protected final String TEXT_279 = ".eINSTANCE.get";
  protected final String TEXT_280 = "()));";
  protected final String TEXT_281 = NL;
  protected final String TEXT_282 = NL + "\t\t\tfilter = ";
  protected final String TEXT_283 = ".createFeatureFilter(";
  protected final String TEXT_284 = ".eINSTANCE.get";
  protected final String TEXT_285 = "());";
  protected final String TEXT_286 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_287 = ".createFeatureFilter(";
  protected final String TEXT_288 = ".eINSTANCE.get";
  protected final String TEXT_289 = "()));";
  protected final String TEXT_290 = NL;
  protected final String TEXT_291 = NL + "\t\t\tfilter = ";
  protected final String TEXT_292 = ".createFeatureFilter(";
  protected final String TEXT_293 = ".eINSTANCE.get";
  protected final String TEXT_294 = "());";
  protected final String TEXT_295 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_296 = ".createFeatureFilter(";
  protected final String TEXT_297 = ".eINSTANCE.get";
  protected final String TEXT_298 = "()));";
  protected final String TEXT_299 = NL;
  protected final String TEXT_300 = NL + "\t\t\tfilter = ";
  protected final String TEXT_301 = ".createFeatureFilter(";
  protected final String TEXT_302 = ".eINSTANCE.get";
  protected final String TEXT_303 = "());";
  protected final String TEXT_304 = NL + "\t\t\tfilter = filter.or(";
  protected final String TEXT_305 = ".createFeatureFilter(";
  protected final String TEXT_306 = ".eINSTANCE.get";
  protected final String TEXT_307 = "()));";
  protected final String TEXT_308 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter().or(filter);";
  protected final String TEXT_309 = NL + "\t\t\tfilter = getConstrainedChildLinksFilter();";
  protected final String TEXT_310 = NL + "\t\t\tfilter = filter.or(createUncontainedLinksFilter());";
  protected final String TEXT_311 = NL + "\t\t\tfilter = createUncontainedLinksFilter();";
  protected final String TEXT_312 = NL + "\t\t\tfilter = ";
  protected final String TEXT_313 = ".ANY.negated();";
  protected final String TEXT_314 = NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void install(";
  protected final String TEXT_315 = " editingDomain) {" + NL + "\t\t\tif (this.editingDomain != null && !this.editingDomain.equals(editingDomain)) {" + NL + "\t\t\t\tthrow new IllegalStateException(\"Already listening to another editing domain\");" + NL + "\t\t\t}" + NL + "\t\t\tthis.editingDomain = editingDomain;" + NL + "\t\t\tthis.editingDomain.addResourceSetListener(this);" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isInstalled() {" + NL + "\t\t\treturn editingDomain != null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void uninstall() {" + NL + "\t\t\tif (isInstalled()) {" + NL + "\t\t\t\teditingDomain.removeResourceSetListener(this);" + NL + "\t\t\t\teditingDomain = null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isPrecommitOnly() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_316 = " transactionAboutToCommit(";
  protected final String TEXT_317 = " event) {" + NL + "\t\t\treturn getRefreshLinkNotationModelCommand();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_318 = " getFilter() {" + NL + "\t\t\treturn filter;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLinkNotationModel() {" + NL + "\t\t";
  protected final String TEXT_319 = " command = getRefreshLinkNotationModelCommand();" + NL + "\t\tif (command == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_320 = " domainModelEditDomain = ";
  protected final String TEXT_321 = ".getEditingDomain(";
  protected final String TEXT_322 = ".getElement());" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(new WrappingCommand(domainModelEditDomain, command));" + NL + "\t}" + NL;
  protected final String TEXT_323 = NL;
  protected final String TEXT_324 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static class LinkDescriptor {" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_325 = " mySource;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_326 = " myDestination;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_327 = " myLinkElement;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate int myVisualID;" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_328 = " source, ";
  protected final String TEXT_329 = " destination, ";
  protected final String TEXT_330 = " linkElement, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = linkElement;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(";
  protected final String TEXT_331 = " source, ";
  protected final String TEXT_332 = " destination, int linkVID) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyVisualID = linkVID;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_333 = " getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_334 = " getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_335 = " getLinkElement() {" + NL + "\t\treturn myLinkElement;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected int getVisualID() {" + NL + "\t\treturn myVisualID;" + NL + "\t}" + NL + "}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_336 = " getRefreshLinkNotationModelCommand() {" + NL + "\t\t";
  protected final String TEXT_337 = "/*<LinkDescriptor>*/ semanticChildLinks = getSemanticChildLinks();" + NL + "\t\t";
  protected final String TEXT_338 = "/*<Edge>*/ notationalChildLinks = getNotationalChildLinks();" + NL + "\t\tfinal ";
  protected final String TEXT_339 = " semanticToNotationalTypeBasedLinks = new ";
  protected final String TEXT_340 = "();" + NL + "\t\tfinal ";
  protected final String TEXT_341 = "/*<EObject, List<Edge>>*/ semanticToNotationalFeatureBasedLinks = new ";
  protected final String TEXT_342 = "();" + NL + "\t\tfor(";
  protected final String TEXT_343 = " it = notationalChildLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_344 = " next = (";
  protected final String TEXT_345 = ") it.next();" + NL + "\t\t\t";
  protected final String TEXT_346 = " nextSemantic = next.getElement();" + NL + "\t\t\tif (nextSemantic != null) {" + NL + "\t\t\t\tsemanticToNotationalTypeBasedLinks.put(nextSemantic, next);" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_347 = " featureBasedLinksForSource = (";
  protected final String TEXT_348 = ") semanticToNotationalFeatureBasedLinks.get(next.getSource().getElement());" + NL + "\t\t\t\tif (featureBasedLinksForSource == null) {" + NL + "\t\t\t\t\tfeatureBasedLinksForSource = new ";
  protected final String TEXT_349 = "();" + NL + "\t\t\t\t\tsemanticToNotationalFeatureBasedLinks.put(next.getSource().getElement(), featureBasedLinksForSource);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfeatureBasedLinksForSource.add(next);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_350 = " parentView = ";
  protected final String TEXT_351 = ";" + NL + "\t\t";
  protected final String TEXT_352 = " command = new ";
  protected final String TEXT_353 = "();" + NL + "\t\tfor(";
  protected final String TEXT_354 = " it = semanticChildLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\tLinkDescriptor next = (LinkDescriptor) it.next();" + NL + "\t\t\t";
  protected final String TEXT_355 = " nextLinkElement = next.getLinkElement();" + NL + "\t\t\t";
  protected final String TEXT_356 = " currentEdge;" + NL + "\t\t\tif (nextLinkElement != null) {" + NL + "\t\t\t\tcurrentEdge = (";
  protected final String TEXT_357 = ") semanticToNotationalTypeBasedLinks.remove(nextLinkElement);" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_358 = " featureBasedLinksForSource = (";
  protected final String TEXT_359 = ") semanticToNotationalFeatureBasedLinks.get(next.getSource());" + NL + "\t\t\t\tif (featureBasedLinksForSource == null || featureBasedLinksForSource.isEmpty()) {" + NL + "\t\t\t\t\tcurrentEdge = null;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tcurrentEdge = (";
  protected final String TEXT_360 = ") featureBasedLinksForSource.remove(0);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tint linkVisualID = next.getVisualID();" + NL + "\t\t\tif (currentEdge == null) {" + NL + "\t\t\t\tif (nextLinkElement == null || shouldCreateEdge(nextLinkElement)) {" + NL + "\t\t\t\t\tcommand.appendIfCanExecute(getCreateNotationalEdgeCommand(parentView, next));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tboolean changedSource = currentEdge.getSource().getElement() != next.getSource();" + NL + "\t\t\t\tboolean changedTarget = currentEdge.getTarget().getElement() != next.getDestination();" + NL + "\t\t\t\tboolean changedVID = linkVisualID != ";
  protected final String TEXT_361 = ".getVisualID(currentEdge);" + NL + "\t\t\t\tif (!changedSource && !changedTarget) {" + NL + "\t\t\t\t\tif (changedVID) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_362 = " notationalCommand = getCreateNotationalEdgeCommand(parentView, next);" + NL + "\t\t\t\t\t\tif (notationalCommand != null) {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_363 = "(parentView, notationalCommand, currentEdge));" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_364 = "(parentView, currentEdge));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif (changedVID) {" + NL + "\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_365 = "(parentView, currentEdge));" + NL + "\t\t\t\t\t\tcommand.appendIfCanExecute(getCreateNotationalEdgeCommand(parentView, next));" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_366 = " newSourceView = findView(next.getSource());" + NL + "\t\t\t\t\t\tif (changedSource && newSourceView != null) {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_367 = "(currentEdge, newSourceView));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_368 = " newTargetView = findView(next.getDestination());" + NL + "\t\t\t\t\t\tif (changedTarget && newTargetView != null) {" + NL + "\t\t\t\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_369 = "(currentEdge, newTargetView));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tfor(";
  protected final String TEXT_370 = " it = semanticToNotationalTypeBasedLinks.values().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_371 = " obsoleteView = (";
  protected final String TEXT_372 = ") it.next();" + NL + "\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_373 = "(parentView, obsoleteView));" + NL + "\t\t}" + NL + "\t\tfor(";
  protected final String TEXT_374 = " it = semanticToNotationalFeatureBasedLinks.values().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_375 = " obsoleteViews = (";
  protected final String TEXT_376 = ") it.next();" + NL + "\t\t\tfor(";
  protected final String TEXT_377 = " obsoleteViewsIt = obsoleteViews.iterator(); obsoleteViewsIt.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_378 = " obsoleteView = (";
  protected final String TEXT_379 = ") obsoleteViewsIt.next();" + NL + "\t\t\t\tcommand.appendIfCanExecute(new ";
  protected final String TEXT_380 = "(parentView, obsoleteView));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn command.getCommandList().isEmpty() ? null : command;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Finds a notational element that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_381 = " findView(";
  protected final String TEXT_382 = " modelElement) {" + NL + "\t\tif (modelElement == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_383 = " editPart = (";
  protected final String TEXT_384 = ") getViewer().getEditPartRegistry().get(modelElement);" + NL + "\t\tif (editPart != null && editPart.getModel() instanceof ";
  protected final String TEXT_385 = ") {" + NL + "\t\t\treturn (";
  protected final String TEXT_386 = ") editPart.getModel();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_387 = " parentView = findView(modelElement.eContainer());" + NL + "\t\tif (parentView != null) {" + NL + "\t\t\t";
  protected final String TEXT_388 = " result = findNode(parentView, modelElement);" + NL + "\t\t\tif (result != null) {" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn findEdge(modelElement);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Finds a notational node that corresponds to the given underlying domain element in a subtree starting from the given parent element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_389 = " findNode(";
  protected final String TEXT_390 = " parentView, ";
  protected final String TEXT_391 = " modelElement) {" + NL + "\t\tfor(";
  protected final String TEXT_392 = " it = parentView.getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_393 = " next = (";
  protected final String TEXT_394 = ") it.next();" + NL + "\t\t\tif (!next.isSetElement() || next.getElement() == parentView) {" + NL + "\t\t\t\t";
  protected final String TEXT_395 = " result = findNode(next, modelElement);" + NL + "\t\t\t\tif (result != null) {" + NL + "\t\t\t\t\treturn result;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (next.isSetElement() && next.getElement() == modelElement) {" + NL + "\t\t\t\treturn next;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Finds a notational edge that corresponds to the given underlying domain element. " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_396 = " findEdge(";
  protected final String TEXT_397 = " modelElement) {" + NL + "\t\tfor(";
  protected final String TEXT_398 = " it = ";
  protected final String TEXT_399 = ".getEdges().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_400 = " next = (";
  protected final String TEXT_401 = ") it.next();" + NL + "\t\t\tif (next.isSetElement() && next.getElement() == modelElement) {" + NL + "\t\t\t\treturn next;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_402 = " getCreateNotationalEdgeCommand(";
  protected final String TEXT_403 = " parentView, LinkDescriptor linkDescriptor) {" + NL + "\t\t";
  protected final String TEXT_404 = " sourceView = findView(linkDescriptor.getSource());" + NL + "\t\t";
  protected final String TEXT_405 = " targetView = findView(linkDescriptor.getDestination());" + NL + "\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_406 = " createdEdge = ";
  protected final String TEXT_407 = ".eINSTANCE.createEdge();" + NL + "\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_408 = NL + "\t\tcase ";
  protected final String TEXT_409 = ".VISUAL_ID:" + NL + "\t\t\tif (linkDescriptor.getLinkElement() instanceof ";
  protected final String TEXT_410 = ") {" + NL + "\t\t\t\tcreatedEdge.setElement(linkDescriptor.getLinkElement());" + NL + "\t\t\t\t";
  protected final String TEXT_411 = ".decorateView(createdEdge);" + NL + "\t\t\t}" + NL + "\t\t\tbreak;";
  protected final String TEXT_412 = NL + "\t\tcase ";
  protected final String TEXT_413 = ".VISUAL_ID:" + NL + "\t\t\tif (linkDescriptor.getLinkElement() == null) {" + NL + "\t\t\t\tcreatedEdge.setElement(null);" + NL + "\t\t\t\t";
  protected final String TEXT_414 = ".decorateView(createdEdge);" + NL + "\t\t\t}" + NL + "\t\t\tbreak;";
  protected final String TEXT_415 = NL + "\t\t}" + NL + "\t\tif (createdEdge.getType() == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn new ";
  protected final String TEXT_416 = "(parentView, createdEdge, sourceView, targetView);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_417 = " getSemanticChildLinks() {";
  protected final String TEXT_418 = NL;
  protected final String TEXT_419 = "\t";
  protected final String TEXT_420 = " result = new ";
  protected final String TEXT_421 = "();";
  protected final String TEXT_422 = NL + "\t";
  protected final String TEXT_423 = " modelObject = ";
  protected final String TEXT_424 = ";" + NL + "\t";
  protected final String TEXT_425 = " nextValue;";
  protected final String TEXT_426 = NL + "\tint linkVID;";
  protected final String TEXT_427 = NL + "\tfor(";
  protected final String TEXT_428 = " it = ((";
  protected final String TEXT_429 = ")modelObject).";
  protected final String TEXT_430 = "().iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_431 = ") it.next();";
  protected final String TEXT_432 = NL + "\tnextValue = ((";
  protected final String TEXT_433 = ")modelObject).";
  protected final String TEXT_434 = "();";
  protected final String TEXT_435 = NL + "\tlinkVID = ";
  protected final String TEXT_436 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_437 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_438 = NL + "\tcase ";
  protected final String TEXT_439 = ".VISUAL_ID: {";
  protected final String TEXT_440 = NL + "\tif (";
  protected final String TEXT_441 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_442 = NL + "\t\t";
  protected final String TEXT_443 = " source = ((";
  protected final String TEXT_444 = ")nextValue).";
  protected final String TEXT_445 = "();";
  protected final String TEXT_446 = NL + "\t\t";
  protected final String TEXT_447 = " source = ";
  protected final String TEXT_448 = ";";
  protected final String TEXT_449 = NL + "\t\t";
  protected final String TEXT_450 = " target = ((";
  protected final String TEXT_451 = ")nextValue).";
  protected final String TEXT_452 = "();";
  protected final String TEXT_453 = NL + "\t\t";
  protected final String TEXT_454 = " target = ";
  protected final String TEXT_455 = ";";
  protected final String TEXT_456 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new LinkDescriptor(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_457 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_458 = NL + "\t}";
  protected final String TEXT_459 = NL + "\t}";
  protected final String TEXT_460 = NL + "\t}";
  protected final String TEXT_461 = NL + "\tfor(";
  protected final String TEXT_462 = " it = ((";
  protected final String TEXT_463 = ")modelObject).";
  protected final String TEXT_464 = "().iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_465 = ") it.next();";
  protected final String TEXT_466 = NL + "\tnextValue = ((";
  protected final String TEXT_467 = ")modelObject).";
  protected final String TEXT_468 = "();";
  protected final String TEXT_469 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_470 = NL + "\t\tresult.add(new LinkDescriptor(modelObject, nextValue, null, ";
  protected final String TEXT_471 = ".VISUAL_ID));";
  protected final String TEXT_472 = NL + "\t}";
  protected final String TEXT_473 = NL + "\t}";
  protected final String TEXT_474 = NL + "\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_475 = " getNotationalChildLinks() {" + NL + "\t\t";
  protected final String TEXT_476 = " result = new ";
  protected final String TEXT_477 = "();" + NL + "\t\t";
  protected final String TEXT_478 = " allLinks = ";
  protected final String TEXT_479 = ".getEdges();" + NL + "\t\tfor(";
  protected final String TEXT_480 = " it = allLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_481 = " next = (";
  protected final String TEXT_482 = ") it.next();";
  protected final String TEXT_483 = NL + "\t\t\tif (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {" + NL + "\t\t\t\tresult.add(next);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_484 = " source = next.getSource();" + NL + "\t\t\tif (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {" + NL + "\t\t\t\tresult.add(next);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_485 = " target = next.getTarget();" + NL + "\t\t\tif (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {" + NL + "\t\t\t\tresult.add(next);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}";
  protected final String TEXT_486 = NL + "\t\t\tif (!next.isSetElement() || next.getElement() == null) {" + NL + "\t\t\t\tif (next.getSource() == ";
  protected final String TEXT_487 = ") {" + NL + "\t\t\t\t\tint linkVID = ";
  protected final String TEXT_488 = ".getVisualID(next);" + NL + "\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_489 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_490 = ".VISUAL_ID:";
  protected final String TEXT_491 = NL + "\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_492 = NL + "\t\t\t} else {";
  protected final String TEXT_493 = NL + "\t\t\t}";
  protected final String TEXT_494 = NL + "\t\t\tif (next.isSetElement() && next.getElement() != null) {";
  protected final String TEXT_495 = NL + "\t\t\t\tif (next.getElement().eContainer() == ";
  protected final String TEXT_496 = ") {" + NL + "\t\t\t\t\tint linkVID = ";
  protected final String TEXT_497 = ".getVisualID(next);" + NL + "\t\t\t\t\tswitch (linkVID) {";
  protected final String TEXT_498 = NL + "\t\t\t\t\tcase ";
  protected final String TEXT_499 = ".VISUAL_ID:";
  protected final String TEXT_500 = NL + "\t\t\t\t\t\tresult.add(next);" + NL + "\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_501 = NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns whether a notational edge should be created for the given domain element. " + NL + "\t * The generated code always returns ";
  protected final String TEXT_502 = ". " + NL + "\t * User can change implementation of this method to handle a more sophisticated logic." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean shouldCreateEdge(EObject domainElement) {" + NL + "\t\treturn ";
  protected final String TEXT_503 = ";" + NL + "\t}";
  protected final String TEXT_504 = NL;
  protected final String TEXT_505 = NL;
  protected final String TEXT_506 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_507 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_508 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_509 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate UpdateManager updateManager = new UpdateManager();" + NL + "}";
  protected final String TEXT_510 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("NotationModelRefresher");	//from notationModelRefresher.jetinc
importManager.registerInnerClass("LinkNotationModelRefresher");	//from linkNotationModelRefresher.jetinc
importManager.registerInnerClass("LinkDescriptor");	//from linkNotationModelRefresher.jetinc
List childNodes = genDiagram.getTopLevelNodes();

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
			} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
				GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
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
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_18);
    if (null != genDiagram.getPalette()) {
final Palette palette = genDiagram.getPalette();
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_24);
    
for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenTopLevelNode next = (GenTopLevelNode)it.next();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_28);
    
}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_30);
    }/*when there's palette*/
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_37);
    
//link notation model refresher should always be installed for the diagram edit part, because it tracks the uncontained links
//if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_38);
    
//}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToHelper"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.SnapToGrid"));
    stringBuffer.append(TEXT_41);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_42);
    
for(Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenTopLevelNode next = (GenTopLevelNode)it.next();
	boolean isStatic = true;
	boolean isListLayout = false;
	String resolvedSemanticElement = "parent.getElement()";

    stringBuffer.append(TEXT_43);
    stringBuffer.append(TEXT_44);
    if (isStatic) {
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_51);
    if (!isListLayout) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(next.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    
	if (!isListLayout) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Bounds"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_59);
    
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) next.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_62);
    
	}

    stringBuffer.append(TEXT_63);
    
if (genDiagram.getPalette() != null) {

    stringBuffer.append(TEXT_64);
    if (isStatic) {
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    if (!isListLayout) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_77);
    
	if (next.getDomainMetaClass().isMapEntry()) {
	/*Workaround for Ecore example: map entries cannot be created using factory, only using reflective EFactory.create() method*/

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_82);
    
	} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(next.getDomainMetaClass().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(next.getDomainMetaClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_86);
    
	}

    stringBuffer.append(TEXT_87);
    /*XXX: Class name DomainElementInitializer should be user-customizable*/
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoriesPackageName() + ".DomainElementInitializer"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(next.getUniqueIdentifier());
    stringBuffer.append(TEXT_90);
    
	TypeModelFacet facet = next.getModelFacet();
	GenFeature childFeature = facet.getChildMetaFeature();
	GenFeature containmentFeature = facet.getContainmentMetaFeature();
	if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(childFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_101);
    
	} else {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getEcoreFeature().isMany() ? "org.eclipse.emf.edit.command.AddCommand" : "org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_106);
    
	}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(next.getDomainMetaClass().getName());
    stringBuffer.append(next.getVisualID());
    stringBuffer.append(TEXT_108);
    if(!isListLayout) {
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    
}

    
}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EContentAdapter"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_133);
    
//link notation model refresher should always be installed for the diagram edit part, because it tracks the uncontained links
//if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_134);
    
//}

    stringBuffer.append(TEXT_135);
    
//link notation model refresher should always be installed/uninstalled for the diagram edit part, because it tracks the uncontained links
//if (myHelper.containsLinks()) {

    stringBuffer.append(TEXT_136);
    
//}

    stringBuffer.append(TEXT_137);
    
{
String _getDiagramCode = "getDiagram()";
String _getViewCode = "getDiagram()";
String _getSemanticElementCode = "getDiagram().getElement()";
boolean isListLayout = false;
final boolean _includeUncontainedLinks = true;

    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetListenerImpl"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_145);
    
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

    stringBuffer.append(TEXT_146);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_149);
    
}

    stringBuffer.append(TEXT_150);
    
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

    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_154);
    
		} else {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_158);
    
		}
	}	//for

    
	if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_161);
    
	} else {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_164);
    
	}
}	//local declaration of hasDeclaredFilter

    
if (hasConstraintsInChildren) {

    stringBuffer.append(TEXT_165);
    
}

    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetChangeEvent"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReplaceNotationalElementCommand"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalElementCommand"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_204);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(nextNode.getDomainMetaClass().getName());
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_208);
    if (!isListLayout) {
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    
}

    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(TEXT_213);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_215);
    
} else {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_218);
    
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

    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_224);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(childMetaFeature.getGetAccessor());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_229);
    
		} else {

    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(childMetaFeature.getGetAccessor());
    stringBuffer.append(TEXT_232);
    
	}

    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_234);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_235);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_237);
    
		} else {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_239);
    
		}

    stringBuffer.append(TEXT_240);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_241);
    
		} else {

    stringBuffer.append(TEXT_242);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_243);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_244);
    
	}
}

    stringBuffer.append(TEXT_245);
    
}

    stringBuffer.append(TEXT_246);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    
if (myHelper.containsLinks() || _includeUncontainedLinks) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetListenerImpl"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_256);
    
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

    stringBuffer.append(TEXT_257);
    stringBuffer.append(genDiagram.getVisualIDRegistryQualifiedClassName());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_260);
    
	}
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_270);
    
	}

    stringBuffer.append(TEXT_271);
    
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

    stringBuffer.append(TEXT_272);
    
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

    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_276);
    
	} else {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_280);
    
	}

    
			_feature = modelFacet.getSourceMetaFeature();

    stringBuffer.append(TEXT_281);
    
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

    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_285);
    
	} else {

    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_289);
    
	}

    
			_feature = modelFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_290);
    
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

    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_294);
    
	} else {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_298);
    
	}

    
		}
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();
			GenFeature _feature = ((FeatureModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_299);
    
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

    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_303);
    
	} else {

    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName(_feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(_feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_307);
    
	}

    
		}
		if (hasConstraintsInContainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_308);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_309);
    
			}
		}
		if (_includeUncontainedLinks) {
			if (hasDeclaredFilter) {

    stringBuffer.append(TEXT_310);
    
			} else {
				hasDeclaredFilter = true;

    stringBuffer.append(TEXT_311);
    
			}
		}
		if (!hasDeclaredFilter) {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_313);
    
		}
	}	//local declaration of hasDeclaredFilter

    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.ResourceSetChangeEvent"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(TEXT_323);
    /*inner class*/
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_361);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReplaceNotationalElementCommand"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeSourceCommand"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".ReconnectNotationalEdgeTargetCommand"));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_402);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_403);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_407);
    
	for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_408);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_411);
    
	}
	for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_412);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_414);
    
	}

    stringBuffer.append(TEXT_415);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditCommandsPackageName() + ".CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_417);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_420);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_421);
    
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

    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_423);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_425);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_426);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_428);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_431);
    
	} else {

    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_434);
    
	}

    stringBuffer.append(TEXT_435);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_436);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_437);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_438);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_439);
    
		} else {

    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_441);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_442);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(importManager.getImportedName(modelFacet.getSourceMetaFeature().getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(modelFacet.getSourceMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_445);
    
		} else {

    stringBuffer.append(TEXT_446);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_448);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_449);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(importManager.getImportedName(modelFacet.getTargetMetaFeature().getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(modelFacet.getTargetMetaFeature().getGetAccessor());
    stringBuffer.append(TEXT_452);
    
		} else {

    stringBuffer.append(TEXT_453);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_454);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_455);
    
		}

    stringBuffer.append(TEXT_456);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_457);
    
		} else {

    stringBuffer.append(TEXT_458);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_459);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_460);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_461);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_462);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_463);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_464);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_465);
    
	} else {

    stringBuffer.append(TEXT_466);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_467);
    stringBuffer.append(metaFeature.getGetAccessor());
    stringBuffer.append(TEXT_468);
    
	}

    stringBuffer.append(TEXT_469);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_470);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_471);
    
	}

    stringBuffer.append(TEXT_472);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_473);
    
	}
}

    stringBuffer.append(TEXT_474);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_476);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_477);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_478);
    stringBuffer.append(_getDiagramCode);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_480);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_481);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_482);
    
	if (_includeUncontainedLinks) {

    stringBuffer.append(TEXT_483);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_484);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_485);
    
	}

    
	if (myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_486);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_488);
    
		for(Iterator it = myHelper.getContainedFeatureModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_489);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_490);
    
		}

    stringBuffer.append(TEXT_491);
    
		if (myHelper.containsTypeModelFacetLinks()) {

    stringBuffer.append(TEXT_492);
    
		} else {

    stringBuffer.append(TEXT_493);
    
		}
	}
	

    
	if (myHelper.containsTypeModelFacetLinks()) {
		if (!myHelper.containsFeatureModelFacetLinks()) {

    stringBuffer.append(TEXT_494);
    
		}

    stringBuffer.append(TEXT_495);
    stringBuffer.append(_getSemanticElementCode);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_497);
    
		for(Iterator it = myHelper.getContainedTypeModelFacetLinks(); it.hasNext(); ) {
			GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_498);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_499);
    
		}

    stringBuffer.append(TEXT_500);
    
	}

    stringBuffer.append(TEXT_501);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(genDiagram.isSynchronized());
    stringBuffer.append(TEXT_503);
    
}

    
}

    stringBuffer.append(TEXT_504);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_508);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_509);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_510);
    return stringBuffer.toString();
  }
}
