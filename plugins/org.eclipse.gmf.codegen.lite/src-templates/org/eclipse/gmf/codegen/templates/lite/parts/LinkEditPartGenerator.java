package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;
import java.util.*;

public class LinkEditPartGenerator
{
  protected static String nl;
  public static synchronized LinkEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkEditPartGenerator result = new LinkEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " implements ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = "(";
  protected final String TEXT_13 = " view) {" + NL + "\t\tassert view instanceof ";
  protected final String TEXT_14 = ";" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_15 = " getDiagramEdge() {" + NL + "\t\treturn (";
  protected final String TEXT_16 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_19 = " view = (";
  protected final String TEXT_20 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_21 = " view = (";
  protected final String TEXT_22 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\t//XXX: install correct edit policies!";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = "\t\tinstallEditPolicy(";
  protected final String TEXT_25 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_26 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_27 = " createDeleteCommand(";
  protected final String TEXT_28 = " deleteRequest) {" + NL + "\t\t\t\tfinal Edge edgeToRemove = getDiagramEdge();" + NL + "\t\t\t\tfinal View source = edgeToRemove.getSource();" + NL + "\t\t\t\tfinal View target = edgeToRemove.getTarget();" + NL + "\t\t\t\t";
  protected final String TEXT_29 = " editingDomain = ";
  protected final String TEXT_30 = ".getEditingDomain(getDiagramEdge().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_31 = " cc = new ";
  protected final String TEXT_32 = "();" + NL + "\t\t\t\tcc.append(createDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(new ";
  protected final String TEXT_33 = "() {" + NL + "\t\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\t\treturn source != null && edgeToRemove != null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\treturn source != null && edgeToRemove != null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tsource.getDiagram().insertEdge(edgeToRemove);" + NL + "\t\t\t\t\t\tedgeToRemove.setSource(source);" + NL + "\t\t\t\t\t\tedgeToRemove.setTarget(target);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void redo() {" + NL + "\t\t\t\t\t\texecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tsource.getDiagram().removeEdge(edgeToRemove);" + NL + "\t\t\t\t\t\tedgeToRemove.setSource(null);" + NL + "\t\t\t\t\t\tedgeToRemove.setTarget(null);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_34 = "(editingDomain, cc);" + NL + "\t\t\t}";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL + "\t\t\tprivate ";
  protected final String TEXT_37 = " createDomainModelRemoveCommand(";
  protected final String TEXT_38 = " editingDomain) {";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = " result = new ";
  protected final String TEXT_41 = "();";
  protected final String TEXT_42 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_43 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = ".getElement().eContainer(), ";
  protected final String TEXT_45 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_46 = ".getElement()));";
  protected final String TEXT_47 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_48 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = ".getElement().eContainer(), ";
  protected final String TEXT_50 = ".getElement().eContainmentFeature(), ";
  protected final String TEXT_51 = ".UNSET_VALUE));";
  protected final String TEXT_52 = NL + "\t\t\t\treturn ";
  protected final String TEXT_53 = ".INSTANCE;";
  protected final String TEXT_54 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_55 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = ".getElement().eContainer(), ";
  protected final String TEXT_57 = ".eINSTANCE.get";
  protected final String TEXT_58 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_59 = ".getElement()));";
  protected final String TEXT_60 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_61 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = ".getElement().eContainer(), ";
  protected final String TEXT_63 = ".eINSTANCE.get";
  protected final String TEXT_64 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_65 = ".UNSET_VALUE));";
  protected final String TEXT_66 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_67 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = ".getElement(), ";
  protected final String TEXT_69 = ".eINSTANCE.get";
  protected final String TEXT_70 = "(), ";
  protected final String TEXT_71 = ".getSource().getElement()));";
  protected final String TEXT_72 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_73 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = ".getElement(), ";
  protected final String TEXT_75 = ".eINSTANCE.get";
  protected final String TEXT_76 = "(), ";
  protected final String TEXT_77 = ".UNSET_VALUE));";
  protected final String TEXT_78 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_79 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = ".getElement(), ";
  protected final String TEXT_81 = ".eINSTANCE.get";
  protected final String TEXT_82 = "(), ";
  protected final String TEXT_83 = ".getTarget().getElement()));";
  protected final String TEXT_84 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_85 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_86 = ".getElement(), ";
  protected final String TEXT_87 = ".eINSTANCE.get";
  protected final String TEXT_88 = "(), ";
  protected final String TEXT_89 = ".UNSET_VALUE));";
  protected final String TEXT_90 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_91 = NL + "\t\t\t\treturn ";
  protected final String TEXT_92 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_93 = ".getSource().getElement(), ";
  protected final String TEXT_94 = ".eINSTANCE.get";
  protected final String TEXT_95 = "(), ";
  protected final String TEXT_96 = ".getTarget().getElement());";
  protected final String TEXT_97 = NL + "\t\t\t\treturn ";
  protected final String TEXT_98 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_99 = ".getSource().getElement(), ";
  protected final String TEXT_100 = ".eINSTANCE.get";
  protected final String TEXT_101 = "(), ";
  protected final String TEXT_102 = ".UNSET_VALUE);";
  protected final String TEXT_103 = NL + "\t\t\t}";
  protected final String TEXT_104 = NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_105 = ".CONNECTION_ENDPOINTS_ROLE, new ";
  protected final String TEXT_106 = "());" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_107 = ".CONNECTION_BENDPOINTS_ROLE, new ";
  protected final String TEXT_108 = "());" + NL + "\t}" + NL;
  protected final String TEXT_109 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_110 = " getPrimaryLabelEditPart() {" + NL + "\t\tfor(";
  protected final String TEXT_111 = " it = getDiagramEdge().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_112 = " nextChild = (";
  protected final String TEXT_113 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_114 = ".getVisualID(nextChild) == ";
  protected final String TEXT_115 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (EditPart) getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_116 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_117 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_118 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_119 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_120 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_121 = " getLabelEditPart(";
  protected final String TEXT_122 = " req) {" + NL + "\t\t";
  protected final String TEXT_123 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_124 = " view = (";
  protected final String TEXT_125 = ") result.getModel();" + NL + "\t\t\tif (getDiagramEdge().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_126 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_127 = NL + "\t\t\t\tcase ";
  protected final String TEXT_128 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_129 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_130 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn ((Edge)getModel()).getChildren();" + NL + "\t}" + NL;
  protected final String TEXT_131 = NL;
  protected final String TEXT_132 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_133 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_134 = " feature, ";
  protected final String TEXT_135 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + NL;
  protected final String TEXT_136 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramEdge().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramEdge().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_139 = " domainModelRefresher = new ";
  protected final String TEXT_140 = "(this);" + NL;
  protected final String TEXT_141 = NL;
  protected final String TEXT_142 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_143 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_144 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_145 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_146 = NL;
  protected final String TEXT_147 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_148 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_149 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_150 = NL;
  protected final String TEXT_151 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_152 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_153 = NL;
  protected final String TEXT_154 = "\t\tRefresher bendpointsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBendpoints();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_155 = ".eINSTANCE.getEdge_Bendpoints(), bendpointsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_156 = ".eINSTANCE.getRelativeBendpoints_Points(), bendpointsRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "//XXX:\t\trefreshBackgroundColor();" + NL + "//XXX:\t\trefreshForegroundColor();" + NL + "//XXX:\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t\trefreshBendpoints();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBendpoints() {" + NL + "\t\t";
  protected final String TEXT_157 = " bendpoints = (";
  protected final String TEXT_158 = ") getDiagramEdge().getBendpoints();" + NL + "\t\tif (bendpoints == null) {" + NL + "\t\t\tgetConnectionFigure().setRoutingConstraint(";
  protected final String TEXT_159 = ".EMPTY_LIST);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_160 = " modelConstraint = bendpoints.getPoints();" + NL + "\t\t";
  protected final String TEXT_161 = " figureConstraint = new ";
  protected final String TEXT_162 = "();" + NL + "\t\tfor (int i = 0; i < modelConstraint.size(); i++) {" + NL + "\t\t\t";
  protected final String TEXT_163 = " wbp = (";
  protected final String TEXT_164 = ") modelConstraint.get(i);" + NL + "\t\t\t";
  protected final String TEXT_165 = " rbp = new ";
  protected final String TEXT_166 = "(getConnectionFigure());" + NL + "\t\t\trbp.setRelativeDimensions(new ";
  protected final String TEXT_167 = "(wbp.getSourceX(), wbp.getSourceY()), new ";
  protected final String TEXT_168 = "(wbp.getTargetX(), wbp.getTargetY()));" + NL + "\t\t\trbp.setWeight((i + 1) / ((float) modelConstraint.size() + 1));" + NL + "\t\t\tfigureConstraint.add(rbp);" + NL + "\t\t}" + NL + "\t\tgetConnectionFigure().setRoutingConstraint(figureConstraint);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = ((View)getModel()).isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addNotify() {" + NL + "\t\tsuper.addNotify();" + NL + "\t\tgetConnectionFigure().setConnectionRouter(new ";
  protected final String TEXT_169 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_170 = " createFigure() {";
  protected final String TEXT_171 = NL + "\t\treturn new ";
  protected final String TEXT_172 = "();";
  protected final String TEXT_173 = NL + "\t\treturn ";
  protected final String TEXT_174 = ";";
  protected final String TEXT_175 = NL + " \t\treturn new ";
  protected final String TEXT_176 = "();";
  protected final String TEXT_177 = NL + "\t}" + NL;
  protected final String TEXT_178 = NL;
  protected final String TEXT_179 = NL;
  protected final String TEXT_180 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_181 = NL + "}";
  protected final String TEXT_182 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenLink genLink = (GenLink) ((Object[]) argument)[0];
GenDiagram genDiagram = genLink.getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);
importManager.addImport("java.util.List");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractConnectionEditPart"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_7);
    {
GenCommonBase genCommonBase = genLink;
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_34);
    
{
	String _edge = "getDiagramEdge()";

    stringBuffer.append(TEXT_35);
    
	//input: _edge : String

    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_38);
    
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

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_41);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_46);
    
			} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_51);
    
			}
		} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_53);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_59);
    
			} else {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_65);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_71);
    
			} else {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_77);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_83);
    
			} else {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_89);
    
			}
		}

    stringBuffer.append(TEXT_90);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_96);
    
		} else {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_102);
    
		}

    
	}

    stringBuffer.append(TEXT_103);
    
}	//local declarations

    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.BendpointEditPolicy"));
    stringBuffer.append(TEXT_108);
    
GenLinkLabel primaryLabel = null;
for(Iterator it = genLink.getLabels().iterator(); it.hasNext(); ) {
	GenLinkLabel next = (GenLinkLabel)it.next();
	if (!next.isReadOnly()) {
		primaryLabel = next;
		break;
	}
}
if (primaryLabel != null) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_126);
    
		for (Iterator it = genLink.getLabels().iterator(); it.hasNext(); ) {
			GenLinkLabel genLabel = (GenLinkLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_128);
    
		}

    stringBuffer.append(TEXT_129);
    
}	//if (primaryLabel != null, i.e., there are editable labels)

    stringBuffer.append(TEXT_130);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_135);
    
if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
	//Otherwise, there's no element associated with the element

    stringBuffer.append(TEXT_136);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_140);
    
}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RelativeBendpoint"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RelativeBendpoint"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BendpointConnectionRouter"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_170);
    
Viewmap viewmap = genLink.getViewmap();
if (viewmap instanceof FigureViewmap) {
	String figureQualifiedClassName = null;
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.gmf.runtime.draw2d.PolylineConnection";
	}

    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_172);
    } // instanceof FigureViewmap
	else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_173);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_174);
    } // instanceof SnippetViewmap 
	else if (viewmap instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(((InnerClassViewmap) viewmap).getClassName());
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    
if (genLink.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genLink.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_178);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_179);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_180);
    
}

    
}

    stringBuffer.append(TEXT_181);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_182);
    return stringBuffer.toString();
  }
}
