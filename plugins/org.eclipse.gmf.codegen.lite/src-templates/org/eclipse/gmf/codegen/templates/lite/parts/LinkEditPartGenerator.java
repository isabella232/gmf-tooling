package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;

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
  protected final String TEXT_6 = " implements IUpdatableEditPart {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = " view) {" + NL + "\t\tassert view instanceof ";
  protected final String TEXT_9 = ";" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = " getDiagramEdge() {" + NL + "\t\treturn (";
  protected final String TEXT_11 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\t//XXX: install correct edit policies!";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "\t\tinstallEditPolicy(";
  protected final String TEXT_14 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_15 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_16 = " createDeleteCommand(";
  protected final String TEXT_17 = " deleteRequest) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_18 = "() {" + NL + "\t\t\t\t\tprivate final Edge edgeToRemove = getDiagramEdge();" + NL + "\t\t\t\t\tprivate final View source = edgeToRemove.getSource();" + NL + "\t\t\t\t\tprivate final View target = edgeToRemove.getTarget();" + NL + "\t\t\t\t\tprivate final org.eclipse.emf.common.command.Command domainModelRemoveCommand = createDomainModelRemoveCommand();" + NL + "\t\t\t\t\tprivate org.eclipse.emf.common.command.Command createDomainModelRemoveCommand() {";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_20 = " result = new ";
  protected final String TEXT_21 = "();";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_23 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_24 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement().eContainer(), edgeToRemove.getElement().eContainmentFeature(), edgeToRemove.getElement()));";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_26 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_27 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement().eContainer(), edgeToRemove.getElement().eContainmentFeature(), ";
  protected final String TEXT_28 = ".UNSET_VALUE));";
  protected final String TEXT_29 = NL + "\t\t\treturn ";
  protected final String TEXT_30 = ".INSTANCE;";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_32 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_33 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement().eContainer(), ";
  protected final String TEXT_34 = ".eINSTANCE.get";
  protected final String TEXT_35 = "()," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement()));";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_37 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_38 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement().eContainer(), ";
  protected final String TEXT_39 = ".eINSTANCE.get";
  protected final String TEXT_40 = "()," + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_41 = ".UNSET_VALUE));";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_43 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_44 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement(), ";
  protected final String TEXT_45 = ".eINSTANCE.get";
  protected final String TEXT_46 = "(), source.getElement()));";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_48 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_49 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement(), ";
  protected final String TEXT_50 = ".eINSTANCE.get";
  protected final String TEXT_51 = "(), ";
  protected final String TEXT_52 = ".UNSET_VALUE));";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_54 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_55 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement(), ";
  protected final String TEXT_56 = ".eINSTANCE.get";
  protected final String TEXT_57 = "(), target.getElement()));";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_59 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_60 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tedgeToRemove.getElement(), ";
  protected final String TEXT_61 = ".eINSTANCE.get";
  protected final String TEXT_62 = "(), ";
  protected final String TEXT_63 = ".UNSET_VALUE));";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\treturn result;";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_66 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_67 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tsource.getElement(), ";
  protected final String TEXT_68 = ".eINSTANCE.get";
  protected final String TEXT_69 = "(), target.getElement());";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_71 = ".create(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_72 = ".getEditingDomainFor(edgeToRemove.getDiagram().getElement())," + NL + "\t\t\t\t\t\t\tsource.getElement(), ";
  protected final String TEXT_73 = ".eINSTANCE.get";
  protected final String TEXT_74 = "(), ";
  protected final String TEXT_75 = ".UNSET_VALUE);";
  protected final String TEXT_76 = NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\t\treturn domainModelRemoveCommand != null && domainModelRemoveCommand.canExecute();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\tdomainModelRemoveCommand.execute();" + NL + "\t\t\t\t\t\tsource.getDiagram().removeEdge(edgeToRemove);" + NL + "\t\t\t\t\t\tedgeToRemove.setSource(null);" + NL + "\t\t\t\t\t\tedgeToRemove.setTarget(null);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\treturn domainModelRemoveCommand != null && domainModelRemoveCommand.canUndo();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\tdomainModelRemoveCommand.undo();" + NL + "\t\t\t\t\t\tsource.getDiagram().insertEdge(edgeToRemove);" + NL + "\t\t\t\t\t\tedgeToRemove.setSource(source);" + NL + "\t\t\t\t\t\tedgeToRemove.setTarget(target);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_77 = ".CONNECTION_ENDPOINTS_ROLE, new ";
  protected final String TEXT_78 = "());" + NL + "\t}" + NL;
  protected final String TEXT_79 = NL;
  protected final String TEXT_80 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getVisualID(";
  protected final String TEXT_81 = " containerView) {" + NL + "\t\t";
  protected final String TEXT_82 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"visualID\"); //$NON-NLS-1$" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\t";
  protected final String TEXT_83 = ".getInstance().logError(\"Unable to parse \\\"visualID\\\" annotation: \" + visualID, e);" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the label which should be direct-edited by default." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_84 = " getPrimaryLabelEditPart() {" + NL + "\t\tfor(";
  protected final String TEXT_85 = " it = getDiagramEdge().getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_86 = " nextChild = (";
  protected final String TEXT_87 = ")it.next();" + NL + "\t\t\tif (getVisualID(nextChild) == ";
  protected final String TEXT_88 = ") {" + NL + "\t\t\t\treturn (EditPart) getViewer().getEditPartRegistry().get(nextChild);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_89 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_90 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\t";
  protected final String TEXT_91 = " primaryLabel = getPrimaryLabelEditPart();" + NL + "\t\t\tif (primaryLabel != null) {" + NL + "\t\t\t\tprimaryLabel.performRequest(req);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_92 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn ((Edge)getModel()).getChildren();" + NL + "\t}" + NL;
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_95 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_96 = " feature, ";
  protected final String TEXT_97 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramEdge().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramEdge().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_100 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_101 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_102 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = "\tpublic void addRefresher(";
  protected final String TEXT_105 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.addRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\tpublic void removeRefresher(";
  protected final String TEXT_106 = " feature, Refresher refresher) {" + NL + "\t\tCompositeRefresher compositeRefresher = getCompositeRefresher(feature);" + NL + "\t\tcompositeRefresher.removeRefresher(refresher);" + NL + "\t}" + NL + "" + NL + "\tprivate CompositeRefresher getCompositeRefresher(";
  protected final String TEXT_107 = " feature) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\tRefresher refresher = (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t\tif (refresher instanceof CompositeRefresher) {" + NL + "\t\t\treturn (CompositeRefresher) refresher;" + NL + "\t\t}" + NL + "\t\tCompositeRefresher result = new CompositeRefresher();" + NL + "\t\tif (refresher != null) {" + NL + "\t\t\tresult.addRefresher(refresher);" + NL + "\t\t}" + NL + "\t\tstructuralFeatures2Refresher.put(feature, result);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_110 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_111 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_114 = ".eINSTANCE.getView_Visible(), visibilityRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "//XXX:\t\trefreshBackgroundColor();" + NL + "//XXX:\t\trefreshForegroundColor();" + NL + "//XXX:\t\trefreshFont();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = ((View)getModel()).isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_115 = " createFigure() {";
  protected final String TEXT_116 = NL + "\t\treturn new ";
  protected final String TEXT_117 = "();";
  protected final String TEXT_118 = NL + "\t\treturn ";
  protected final String TEXT_119 = ";";
  protected final String TEXT_120 = NL + " \t\treturn new ";
  protected final String TEXT_121 = "();";
  protected final String TEXT_122 = NL + "\t}" + NL;
  protected final String TEXT_123 = NL;
  protected final String TEXT_124 = NL;
  protected final String TEXT_125 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_126 = NL + "}";
  protected final String TEXT_127 = NL;

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
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_18);
    
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

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_21);
    
			if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_24);
    
			} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_28);
    
			}
		} else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_30);
    
		}
		if (removeChild) {
			if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_35);
    
			} else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_41);
    
			}
		}
		if (removeSource) {
			if (sourceFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_46);
    
			} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(sourceFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sourceFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_52);
    
			}
		}
		if (removeTarget) {
			if (targetFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_57);
    
			} else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(targetFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(targetFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_63);
    
			}
		}

    stringBuffer.append(TEXT_64);
    
	} else if (genLink.getModelFacet() instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) genLink.getModelFacet()).getMetaFeature();
		if (metaFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_69);
    
		} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_75);
    
		}

    
	}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy"));
    stringBuffer.append(TEXT_78);
    
if (genLink.getLabels().size() > 0) {
	GenLinkLabel primaryLabel = (GenLinkLabel)genLink.getLabels().get(0);

    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(primaryLabel.getVisualID());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_91);
    
}	//if (genLink.getLabels().size() > 0)

    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_115);
    
Viewmap viewmap = genLink.getViewmap();
if (viewmap instanceof FigureViewmap) {
	String figureQualifiedClassName = null;
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.gmf.runtime.draw2d.PolylineConnection";
	}

    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_117);
    } // instanceof FigureViewmap
	else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_119);
    } // instanceof SnippetViewmap 
	else if (viewmap instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(((InnerClassViewmap) viewmap).getClassName());
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    
if (genLink.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genLink.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_123);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_124);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_125);
    
}

    
}

    stringBuffer.append(TEXT_126);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_127);
    return stringBuffer.toString();
  }
}
