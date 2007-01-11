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
  protected final String TEXT_22 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_23 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = "\t\tinstallEditPolicy(";
  protected final String TEXT_26 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_27 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_28 = " createDeleteCommand(";
  protected final String TEXT_29 = " deleteRequest) {" + NL + "\t\t\t\tfinal Edge edgeToRemove = getDiagramEdge();" + NL + "\t\t\t\tfinal View source = edgeToRemove.getSource();" + NL + "\t\t\t\tfinal View target = edgeToRemove.getTarget();" + NL + "\t\t\t\t";
  protected final String TEXT_30 = " editingDomain = ";
  protected final String TEXT_31 = ".getEditingDomain(getDiagramEdge().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_32 = " cc = new ";
  protected final String TEXT_33 = "();" + NL + "\t\t\t\tcc.append(createDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(new ";
  protected final String TEXT_34 = "(source.getDiagram(), edgeToRemove));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_35 = "(editingDomain, cc);" + NL + "\t\t\t}";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL + "\t\t\tprivate ";
  protected final String TEXT_38 = " createDomainModelRemoveCommand(";
  protected final String TEXT_39 = " editingDomain) {";
  protected final String TEXT_40 = NL + "\t\t\t\t";
  protected final String TEXT_41 = " result = new ";
  protected final String TEXT_42 = "();";
  protected final String TEXT_43 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_44 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = ".getElement().eContainer(), ";
  protected final String TEXT_46 = ".eINSTANCE.get";
  protected final String TEXT_47 = "(), ";
  protected final String TEXT_48 = ".getElement()));";
  protected final String TEXT_49 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_50 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_51 = ".getElement().eContainer(), ";
  protected final String TEXT_52 = ".eINSTANCE.get";
  protected final String TEXT_53 = "(), ";
  protected final String TEXT_54 = ".UNSET_VALUE));";
  protected final String TEXT_55 = NL + "\t\t\t\treturn ";
  protected final String TEXT_56 = ".INSTANCE;";
  protected final String TEXT_57 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_58 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_59 = ".getElement().eContainer(), ";
  protected final String TEXT_60 = ".eINSTANCE.get";
  protected final String TEXT_61 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = ".getElement()));";
  protected final String TEXT_63 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_64 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_65 = ".getElement().eContainer(), ";
  protected final String TEXT_66 = ".eINSTANCE.get";
  protected final String TEXT_67 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = ".UNSET_VALUE));";
  protected final String TEXT_69 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_70 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_71 = ".getElement(), ";
  protected final String TEXT_72 = ".eINSTANCE.get";
  protected final String TEXT_73 = "(), ";
  protected final String TEXT_74 = ".getSource().getElement()));";
  protected final String TEXT_75 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_76 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = ".getElement(), ";
  protected final String TEXT_78 = ".eINSTANCE.get";
  protected final String TEXT_79 = "(), ";
  protected final String TEXT_80 = ".UNSET_VALUE));";
  protected final String TEXT_81 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_82 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = ".getElement(), ";
  protected final String TEXT_84 = ".eINSTANCE.get";
  protected final String TEXT_85 = "(), ";
  protected final String TEXT_86 = ".getTarget().getElement()));";
  protected final String TEXT_87 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_88 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = ".getElement(), ";
  protected final String TEXT_90 = ".eINSTANCE.get";
  protected final String TEXT_91 = "(), ";
  protected final String TEXT_92 = ".UNSET_VALUE));";
  protected final String TEXT_93 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_94 = NL + "\t\t\t\treturn ";
  protected final String TEXT_95 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = ".getSource().getElement(), ";
  protected final String TEXT_97 = ".eINSTANCE.get";
  protected final String TEXT_98 = "(), ";
  protected final String TEXT_99 = ".getTarget().getElement());";
  protected final String TEXT_100 = NL + "\t\t\t\treturn ";
  protected final String TEXT_101 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = ".getSource().getElement(), ";
  protected final String TEXT_103 = ".eINSTANCE.get";
  protected final String TEXT_104 = "(), ";
  protected final String TEXT_105 = ".UNSET_VALUE);";
  protected final String TEXT_106 = NL + "\t\t\t}";
  protected final String TEXT_107 = NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_108 = ".CONNECTION_ENDPOINTS_ROLE, new ";
  protected final String TEXT_109 = "());" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_110 = ".CONNECTION_BENDPOINTS_ROLE, new ";
  protected final String TEXT_111 = "());";
  protected final String TEXT_112 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_113 = ".DIRECT_EDIT_ROLE, new ";
  protected final String TEXT_114 = "());";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_117 = "\", new ";
  protected final String TEXT_118 = "()); //$NON-NLS-1$";
  protected final String TEXT_119 = NL;
  protected final String TEXT_120 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_121 = ".OPEN_ROLE";
  protected final String TEXT_122 = " + \"";
  protected final String TEXT_123 = "\" ";
  protected final String TEXT_124 = ", new ";
  protected final String TEXT_125 = "());";
  protected final String TEXT_126 = NL + "\t}" + NL;
  protected final String TEXT_127 = NL + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_128 = " getPrimaryLabelEditPart() {" + NL + "\t\tfor(";
  protected final String TEXT_129 = " it = getDiagramEdge().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_130 = " nextChild = (";
  protected final String TEXT_131 = ")it.next();" + NL + "\t\t\tif (";
  protected final String TEXT_132 = ".getVisualID(nextChild) == ";
  protected final String TEXT_133 = ".VISUAL_ID) {" + NL + "\t\t\t\treturn (EditPart) getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_134 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_135 = ".REQ_DIRECT_EDIT.equals(req.getType())) {" + NL + "\t\t\t";
  protected final String TEXT_136 = " labelToEdit;" + NL + "\t\t\tif (req instanceof ";
  protected final String TEXT_137 = ") {" + NL + "\t\t\t\tlabelToEdit = getLabelEditPart((";
  protected final String TEXT_138 = ")req);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tlabelToEdit = getPrimaryLabelEditPart();" + NL + "\t\t\t}" + NL + "\t\t\tif (labelToEdit != null) {" + NL + "\t\t\t\tlabelToEdit.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_139 = NL;
  protected final String TEXT_140 = "if (";
  protected final String TEXT_141 = ".REQ_OPEN.equals(req.getType())) {" + NL + "\t";
  protected final String TEXT_142 = " command = getCommand(req);" + NL + "\tif (command != null && command.canExecute()) {" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(command);" + NL + "\t}" + NL + "\treturn;" + NL + "}" + NL + "\t\tsuper.performRequest(req);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_143 = " getLabelEditPart(";
  protected final String TEXT_144 = " req) {" + NL + "\t\t";
  protected final String TEXT_145 = " result = getViewer().findObjectAt(req.getLocation());" + NL + "\t\tif (result != null) {" + NL + "\t\t\t";
  protected final String TEXT_146 = " view = (";
  protected final String TEXT_147 = ") result.getModel();" + NL + "\t\t\tif (getDiagramEdge().getChildren().contains(view)) {" + NL + "\t\t\t\tint visualId = ";
  protected final String TEXT_148 = ".getVisualID(view);" + NL + "\t\t\t\tswitch (visualId) {";
  protected final String TEXT_149 = NL + "\t\t\t\tcase ";
  protected final String TEXT_150 = ".VISUAL_ID:" + NL + "\t\t\t\t\treturn result;";
  protected final String TEXT_151 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getPrimaryLabelEditPart();" + NL + "\t}" + NL;
  protected final String TEXT_152 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn ((Edge)getModel()).getChildren();" + NL + "\t}" + NL;
  protected final String TEXT_153 = NL;
  protected final String TEXT_154 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_155 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_156 = " feature, ";
  protected final String TEXT_157 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {" + NL + "\t\tif (";
  protected final String TEXT_158 = ".class == key) {" + NL + "\t\t\treturn getTreeEditPartAdapter();" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter myTreeEditPartAdapter;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeEditPartAdapter getTreeEditPartAdapter() {" + NL + "\t\tif (myTreeEditPartAdapter == null) {" + NL + "\t\t\tmyTreeEditPartAdapter = new TreeEditPartAdapter();" + NL + "\t\t}" + NL + "\t\treturn myTreeEditPartAdapter;" + NL + "\t}" + NL;
  protected final String TEXT_159 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramEdge().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramEdge().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_160 = NL;
  protected final String TEXT_161 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_162 = " domainModelRefresher = new ";
  protected final String TEXT_163 = "(this);" + NL;
  protected final String TEXT_164 = NL;
  protected final String TEXT_165 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addRefresher(";
  protected final String TEXT_166 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_167 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_168 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_169 = NL;
  protected final String TEXT_170 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_171 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_172 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_173 = ".eINSTANCE.getView_Styles(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_174 = ".eINSTANCE.getDrawerStyle_Collapsed(), childrenRefresher);" + NL + "\t\t";
  protected final String TEXT_175 = NL;
  protected final String TEXT_176 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_177 = ".eINSTANCE.getView_Visible(), visibilityRefresher);";
  protected final String TEXT_178 = NL;
  protected final String TEXT_179 = "\t\tRefresher bendpointsRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshBendpoints();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_180 = ".eINSTANCE.getEdge_Bendpoints(), bendpointsRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_181 = ".eINSTANCE.getRelativeBendpoints_Points(), bendpointsRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "//XXX:\t\trefreshBackgroundColor();" + NL + "//XXX:\t\trefreshForegroundColor();" + NL + "//XXX:\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t\trefreshBendpoints();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBendpoints() {" + NL + "\t\t";
  protected final String TEXT_182 = " bendpoints = (";
  protected final String TEXT_183 = ") getDiagramEdge().getBendpoints();" + NL + "\t\tif (bendpoints == null) {" + NL + "\t\t\tgetConnectionFigure().setRoutingConstraint(";
  protected final String TEXT_184 = ".EMPTY_LIST);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_185 = " modelConstraint = bendpoints.getPoints();" + NL + "\t\t";
  protected final String TEXT_186 = " figureConstraint = new ";
  protected final String TEXT_187 = "();" + NL + "\t\tfor (int i = 0; i < modelConstraint.size(); i++) {" + NL + "\t\t\t";
  protected final String TEXT_188 = " wbp = (";
  protected final String TEXT_189 = ") modelConstraint.get(i);" + NL + "\t\t\t";
  protected final String TEXT_190 = " rbp = new ";
  protected final String TEXT_191 = "(getConnectionFigure());" + NL + "\t\t\trbp.setRelativeDimensions(new ";
  protected final String TEXT_192 = "(wbp.getSourceX(), wbp.getSourceY()), new ";
  protected final String TEXT_193 = "(wbp.getTargetX(), wbp.getTargetY()));" + NL + "\t\t\trbp.setWeight((i + 1) / ((float) modelConstraint.size() + 1));" + NL + "\t\t\tfigureConstraint.add(rbp);" + NL + "\t\t}" + NL + "\t\tgetConnectionFigure().setRoutingConstraint(figureConstraint);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = ((View)getModel()).isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addNotify() {" + NL + "\t\tsuper.addNotify();" + NL + "\t\tgetConnectionFigure().setConnectionRouter(new ";
  protected final String TEXT_194 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_195 = " createFigure() {";
  protected final String TEXT_196 = NL + "\t\treturn new ";
  protected final String TEXT_197 = "();";
  protected final String TEXT_198 = NL + "\t\treturn ";
  protected final String TEXT_199 = ";";
  protected final String TEXT_200 = NL + " \t\treturn new ";
  protected final String TEXT_201 = "();";
  protected final String TEXT_202 = NL + "\t}" + NL;
  protected final String TEXT_203 = NL;
  protected final String TEXT_204 = NL;
  protected final String TEXT_205 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_206 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class TreeEditPartAdapter extends ";
  protected final String TEXT_207 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic TreeEditPartAdapter() {" + NL + "\t\t\tsuper(getDiagramEdge(), ";
  protected final String TEXT_208 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createEditPolicies() {";
  protected final String TEXT_209 = NL;
  protected final String TEXT_210 = "\t\tinstallEditPolicy(";
  protected final String TEXT_211 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_212 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_213 = " createDeleteCommand(";
  protected final String TEXT_214 = " deleteRequest) {" + NL + "\t\t\t\tfinal Edge edgeToRemove = getDiagramEdge();" + NL + "\t\t\t\tfinal View source = edgeToRemove.getSource();" + NL + "\t\t\t\tfinal View target = edgeToRemove.getTarget();" + NL + "\t\t\t\t";
  protected final String TEXT_215 = " editingDomain = ";
  protected final String TEXT_216 = ".getEditingDomain(getDiagramEdge().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_217 = " cc = new ";
  protected final String TEXT_218 = "();" + NL + "\t\t\t\tcc.append(createDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(new ";
  protected final String TEXT_219 = "(source.getDiagram(), edgeToRemove));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_220 = "(editingDomain, cc);" + NL + "\t\t\t}";
  protected final String TEXT_221 = NL;
  protected final String TEXT_222 = NL + "\t\t\tprivate ";
  protected final String TEXT_223 = " createDomainModelRemoveCommand(";
  protected final String TEXT_224 = " editingDomain) {";
  protected final String TEXT_225 = NL + "\t\t\t\t";
  protected final String TEXT_226 = " result = new ";
  protected final String TEXT_227 = "();";
  protected final String TEXT_228 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_229 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_230 = ".getElement().eContainer(), ";
  protected final String TEXT_231 = ".eINSTANCE.get";
  protected final String TEXT_232 = "(), ";
  protected final String TEXT_233 = ".getElement()));";
  protected final String TEXT_234 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_235 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_236 = ".getElement().eContainer(), ";
  protected final String TEXT_237 = ".eINSTANCE.get";
  protected final String TEXT_238 = "(), ";
  protected final String TEXT_239 = ".UNSET_VALUE));";
  protected final String TEXT_240 = NL + "\t\t\t\treturn ";
  protected final String TEXT_241 = ".INSTANCE;";
  protected final String TEXT_242 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_243 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_244 = ".getElement().eContainer(), ";
  protected final String TEXT_245 = ".eINSTANCE.get";
  protected final String TEXT_246 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_247 = ".getElement()));";
  protected final String TEXT_248 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_249 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_250 = ".getElement().eContainer(), ";
  protected final String TEXT_251 = ".eINSTANCE.get";
  protected final String TEXT_252 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_253 = ".UNSET_VALUE));";
  protected final String TEXT_254 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_255 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_256 = ".getElement(), ";
  protected final String TEXT_257 = ".eINSTANCE.get";
  protected final String TEXT_258 = "(), ";
  protected final String TEXT_259 = ".getSource().getElement()));";
  protected final String TEXT_260 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_261 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_262 = ".getElement(), ";
  protected final String TEXT_263 = ".eINSTANCE.get";
  protected final String TEXT_264 = "(), ";
  protected final String TEXT_265 = ".UNSET_VALUE));";
  protected final String TEXT_266 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_267 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_268 = ".getElement(), ";
  protected final String TEXT_269 = ".eINSTANCE.get";
  protected final String TEXT_270 = "(), ";
  protected final String TEXT_271 = ".getTarget().getElement()));";
  protected final String TEXT_272 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_273 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_274 = ".getElement(), ";
  protected final String TEXT_275 = ".eINSTANCE.get";
  protected final String TEXT_276 = "(), ";
  protected final String TEXT_277 = ".UNSET_VALUE));";
  protected final String TEXT_278 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_279 = NL + "\t\t\t\treturn ";
  protected final String TEXT_280 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_281 = ".getSource().getElement(), ";
  protected final String TEXT_282 = ".eINSTANCE.get";
  protected final String TEXT_283 = "(), ";
  protected final String TEXT_284 = ".getTarget().getElement());";
  protected final String TEXT_285 = NL + "\t\t\t\treturn ";
  protected final String TEXT_286 = ".create(" + NL + "\t\t\t\t\teditingDomain," + NL + "\t\t\t\t\t";
  protected final String TEXT_287 = ".getSource().getElement(), ";
  protected final String TEXT_288 = ".eINSTANCE.get";
  protected final String TEXT_289 = "(), ";
  protected final String TEXT_290 = ".UNSET_VALUE);";
  protected final String TEXT_291 = NL + "\t\t\t}";
  protected final String TEXT_292 = NL + "\t\t});";
  protected final String TEXT_293 = NL;
  protected final String TEXT_294 = "\t\tinstallEditPolicy(";
  protected final String TEXT_295 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_296 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_297 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tsetWidgetText(value);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_298 = NL;
  protected final String TEXT_299 = "\t\t\t\t\tprotected ";
  protected final String TEXT_300 = " getDirectEditCommand(";
  protected final String TEXT_301 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_302 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_303 = "(";
  protected final String TEXT_304 = ").parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_305 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_306 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_307 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_308 = " editingDomain = ";
  protected final String TEXT_309 = ".getEditingDomain(";
  protected final String TEXT_310 = ".getDiagram().getElement());";
  protected final String TEXT_311 = NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_312 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_313 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_314 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_315 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_316 = " createDomainModelCommand(";
  protected final String TEXT_317 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_318 = " element = ";
  protected final String TEXT_319 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_320 = " result = new ";
  protected final String TEXT_321 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_322 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_323 = " ";
  protected final String TEXT_324 = "feature = (";
  protected final String TEXT_325 = ") ";
  protected final String TEXT_326 = ".eINSTANCE.get";
  protected final String TEXT_327 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_328 = ".parseValue(feature, values[";
  protected final String TEXT_329 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_330 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_331 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_332 = " ";
  protected final String TEXT_333 = "values = new ";
  protected final String TEXT_334 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_335 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_336 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_337 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_338 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_339 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_340 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_341 = NL + "\t\t\t\t});";
  protected final String TEXT_342 = NL + "\t\t}" + NL;
  protected final String TEXT_343 = NL;
  protected final String TEXT_344 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_345 = " manager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_346 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_347 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_348 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_349 = "(this, ";
  protected final String TEXT_350 = ".class, new ";
  protected final String TEXT_351 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_352 = " celleditor) {" + NL + "\t\t\t\t\tif (checkTreeItem()) {" + NL + "\t\t\t\t\t\tcelleditor.getControl().setFont(((";
  protected final String TEXT_353 = ") getWidget()).getFont());" + NL + "\t\t\t\t\t\tcelleditor.getControl().setBounds(((";
  protected final String TEXT_354 = ") getWidget()).getBounds());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL + "" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getEditText() {" + NL + "\t\t\t";
  protected final String TEXT_355 = " primaryLabelEditPart = getPrimaryLabelEditPart();" + NL + "\t" + NL + "\t\t\tif (primaryLabelEditPart != null) {" + NL + "\t\t\t\treturn primaryLabelEditPart.getLabelEditText();" + NL + "\t\t\t}" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL;
  protected final String TEXT_356 = NL;
  protected final String TEXT_357 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void activate() {" + NL + "\t\t\tsuper.activate();" + NL + "\t\t\tgetDiagramEdge().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void deactivate() {" + NL + "\t\t\tgetDiagramEdge().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\t\tsuper.deactivate();" + NL + "\t\t}" + NL;
  protected final String TEXT_358 = NL;
  protected final String TEXT_359 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_360 = " domainModelRefresher = new ";
  protected final String TEXT_361 = "(this);" + NL;
  protected final String TEXT_362 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void createRefreshers() {" + NL + "\t\t\tsuper.createRefreshers();";
  protected final String TEXT_363 = NL + "\t\t\tRefresher labelRefresher = new Refresher() {" + NL + "\t\t\t\tpublic void refresh() {" + NL + "\t\t\t\t\trefreshVisuals();" + NL + "\t\t\t\t}" + NL + "\t\t\t};";
  protected final String TEXT_364 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_365 = ".eINSTANCE.get";
  protected final String TEXT_366 = "(), labelRefresher);";
  protected final String TEXT_367 = NL + "\t\t\tregisterRefresher(";
  protected final String TEXT_368 = ".eINSTANCE.get";
  protected final String TEXT_369 = "(), labelRefresher);";
  protected final String TEXT_370 = NL + "\t\t}" + NL;
  protected final String TEXT_371 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getText() {" + NL + "\t\t\t";
  protected final String TEXT_372 = " primaryLabelEditPart = getPrimaryLabelEditPart();" + NL + "\t\t\tif (primaryLabelEditPart != null) {" + NL + "\t\t\t\treturn primaryLabelEditPart.getLabelText();" + NL + "\t\t\t}" + NL + "\t\t\treturn super.getText();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_373 = " getPrimaryLabelEditPart() {" + NL + "\t\t\tfor(";
  protected final String TEXT_374 = " it = getDiagramEdge().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t";
  protected final String TEXT_375 = " nextChild = (";
  protected final String TEXT_376 = ")it.next();" + NL + "\t\t\t\tif (";
  protected final String TEXT_377 = ".getVisualID(nextChild) == ";
  protected final String TEXT_378 = ".VISUAL_ID) {" + NL + "\t\t\t\t\treturn (";
  protected final String TEXT_379 = ") ";
  protected final String TEXT_380 = ".this.getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_381 = NL + NL + "\t\t/**" + NL + "\t\t * Since labels are not selectable edit parts, they are filtered from the overview as well." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_382 = " getModelChildren() {" + NL + "\t\t\treturn ";
  protected final String TEXT_383 = ".EMPTY_LIST;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_384 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenLink genLink = (GenLink) ((Object[]) argument)[0];
GenDiagram genDiagram = genLink.getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("TreeEditPartAdapter");

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
    
GenLinkLabel primaryLabel = null;
for(Iterator it = genLink.getLabels().iterator(); it.hasNext(); ) {
	GenLinkLabel next = (GenLinkLabel)it.next();
	if (!next.isReadOnly()) {
		primaryLabel = next;
		break;
	}
}

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_35);
    
{
	String _edge = "getDiagramEdge()";

    stringBuffer.append(TEXT_36);
    
	//input: _edge : String

    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_39);
    
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

    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_42);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_48);
    
			} else {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_54);
    
			}
		} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_56);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_62);
    
			} else {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_68);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_74);
    
			} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_80);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_86);
    
			} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_92);
    
			}
		}

    stringBuffer.append(TEXT_93);
    
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_99);
    
		} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_105);
    
		}

    
	}

    stringBuffer.append(TEXT_106);
    
}	//local declarations

    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.BendpointEditPolicy"));
    stringBuffer.append(TEXT_111);
    
if (primaryLabel != null) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.DelegatingDirectEditPolicy"));
    stringBuffer.append(TEXT_114);
    
}

    {
GenCommonBase genCommonBase = genLink;
    stringBuffer.append(TEXT_115);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    
{
	List<OpenDiagramBehaviour> behaviours = genCommonBase.getBehaviour(OpenDiagramBehaviour.class);
	for(int i = 0, iMax = behaviours.size(); i < iMax; i++) {
	/*doesn't make sense to install more than one policy for the same role*/ 
		OpenDiagramBehaviour next = behaviours.get(i);

    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.EditPolicyRoles"));
    stringBuffer.append(TEXT_121);
    if (i > 0) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName(genCommonBase.getBehaviour(OpenDiagramBehaviour.class).get(0).getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_125);
    
	}
}

    }
    stringBuffer.append(TEXT_126);
    
if (primaryLabel != null) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_148);
    
		for (Iterator it = genLink.getLabels().iterator(); it.hasNext(); ) {
			GenLinkLabel genLabel = (GenLinkLabel) it.next();
			if (genLabel.isReadOnly()) {
				continue;
			}

    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_150);
    
		}

    stringBuffer.append(TEXT_151);
    
}	//if (primaryLabel != null, i.e., there are editable labels)

    stringBuffer.append(TEXT_152);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.TreeEditPart"));
    stringBuffer.append(TEXT_158);
    
if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
	//Otherwise, there's no element associated with the element

    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_163);
    
}

    stringBuffer.append(TEXT_164);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RelativeBendpoint"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.RelativeBendpoint"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.BendpointConnectionRouter"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_195);
    
Viewmap viewmap = genLink.getViewmap();
if (viewmap instanceof FigureViewmap) {
	String figureQualifiedClassName = null;
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.gmf.runtime.draw2d.PolylineConnection";
	}

    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_197);
    } // instanceof FigureViewmap
	else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_199);
    } // instanceof SnippetViewmap 
	else if (viewmap instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(((InnerClassViewmap) viewmap).getClassName());
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    
if (genLink.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genLink.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_203);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_204);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_205);
    
}

    
}

    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.RemoveNotationalEdgeCommand"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_220);
    
{
	String _edge = "getDiagramEdge()";

    stringBuffer.append(TEXT_221);
    
	//input: _edge : String

    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_224);
    
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

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_227);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_233);
    
			} else {

    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_239);
    
			}
		} else {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_241);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_247);
    
			} else {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_253);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_259);
    
			} else {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_265);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_271);
    
			} else {

    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_277);
    
			}
		}

    stringBuffer.append(TEXT_278);
    
	} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_284);
    
		} else {

    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(_edge);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_290);
    
		}

    
	}

    stringBuffer.append(TEXT_291);
    
}	//local declarations

    stringBuffer.append(TEXT_292);
    
if (primaryLabel != null && genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		String editPatternCode = importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()) + ".EDIT_PATTERN";
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String primaryView = "getDiagramEdge()";
		String resolvedSemanticElement = "(" + importManager.getImportedName(typeLinkModelFacet.getMetaClass().getQualifiedInterfaceName()) + ") getDiagramEdge().getElement()";
		LabelModelFacet labelModelFacet = primaryLabel.getModelFacet();
		GenClass underlyingMetaClass = typeLinkModelFacet.getMetaClass();

    stringBuffer.append(TEXT_293);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(editPatternCode);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_310);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = featureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_311);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_321);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_322);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_323);
    }
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_330);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_331);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_332);
    }
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_337);
    
		} else {

    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_339);
    
		}

    
	}

    stringBuffer.append(TEXT_340);
    
}

    stringBuffer.append(TEXT_341);
    
}

    stringBuffer.append(TEXT_342);
    
if (primaryLabel != null && genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.TreeItem"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.TreeItem"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_355);
    
}

    stringBuffer.append(TEXT_356);
    
if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
	//Otherwise, there's no element associated with the element

    stringBuffer.append(TEXT_357);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_361);
    
}

    stringBuffer.append(TEXT_362);
    
if (genLink.getModelFacet() instanceof TypeLinkModelFacet || primaryLabel != null) {
	//Otherwise, an empty string will be returned, and it will not change no matter what.

    stringBuffer.append(TEXT_363);
    
	if (primaryLabel != null) {
		LabelModelFacet labelModelFacet = primaryLabel.getModelFacet();
		if (labelModelFacet instanceof FeatureLabelModelFacet) {
			FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
			for(Iterator it = featureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
				GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_364);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_366);
    
			}
		}
	} else {
		GenClass metaClass = ((TypeLinkModelFacet) genLink.getModelFacet()).getMetaClass();
		List labelNotifyFeatures = metaClass.getLabelNotifyFeatures();
		for(Iterator it = labelNotifyFeatures.iterator(); it.hasNext(); ) {
			GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_369);
    
		}
	}
}

    stringBuffer.append(TEXT_370);
    
if (primaryLabel != null) {

    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_380);
    
}

    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_383);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_384);
    return stringBuffer.toString();
  }
}
