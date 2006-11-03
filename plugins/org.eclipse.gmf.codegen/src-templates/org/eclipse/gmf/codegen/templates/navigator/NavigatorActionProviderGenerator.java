package org.eclipse.gmf.codegen.templates.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NavigatorActionProviderGenerator
{
  protected static String nl;
  public static synchronized NavigatorActionProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NavigatorActionProviderGenerator result = new NavigatorActionProviderGenerator();
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
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean myContribute;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate OpenDiagramAction myOpenDiagramAction;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_8 = " aSite) {" + NL + "\t\tsuper.init(aSite);" + NL + "\t\tif (aSite.getViewSite() instanceof ";
  protected final String TEXT_9 = ") {" + NL + "\t\t\tmyContribute = true;" + NL + "\t\t\tmakeActions((";
  protected final String TEXT_10 = ") aSite.getViewSite());" + NL + "\t\t} else {" + NL + "\t\t\tmyContribute = false;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void makeActions(";
  protected final String TEXT_11 = " viewerSite) {" + NL + "\t\tmyOpenDiagramAction = new OpenDiagramAction(viewerSite);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void fillActionBars(";
  protected final String TEXT_12 = " actionBars) {" + NL + "\t\tif (!myContribute) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_13 = " selection = (";
  protected final String TEXT_14 = ") getContext().getSelection();" + NL + "\t\tmyOpenDiagramAction.selectionChanged(selection);" + NL + "\t\tif (myOpenDiagramAction.isEnabled()) {" + NL + "\t\t\tactionBars.setGlobalActionHandler(";
  protected final String TEXT_15 = ".OPEN, myOpenDiagramAction);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void fillContextMenu(";
  protected final String TEXT_16 = " menu) {" + NL + "/*\t\tif (!myContribute || getContext().getSelection().isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_17 = " selection = (";
  protected final String TEXT_18 = ") getContext().getSelection();" + NL + "" + NL + "\t\tmyOpenDiagramAction.selectionChanged(selection);" + NL + "\t\tif (myOpenDiagramAction.isEnabled()) {" + NL + "\t\t\tmenu.insertAfter(";
  protected final String TEXT_19 = ".GROUP_OPEN, myOpenDiagramAction);" + NL + "\t\t}*/" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class OpenDiagramAction extends ";
  protected final String TEXT_20 = " {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_21 = " myDiagram;" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_22 = " myViewerSite;" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic OpenDiagramAction(";
  protected final String TEXT_23 = " viewerSite) {" + NL + "\t\t\tsuper(\"Open Diagram\");" + NL + "\t\t\tmyViewerSite = viewerSite;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic final void selectionChanged(";
  protected final String TEXT_24 = " selection) {" + NL + "\t\t\tmyDiagram = null;" + NL + "\t\t\tif (selection.size() == 1) {" + NL + "\t\t\t\tObject selectedElement = selection.getFirstElement();" + NL + "\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_25 = ") {" + NL + "\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_26 = ") selectedElement).getView();" + NL + "\t\t\t\t} else if (selectedElement instanceof ";
  protected final String TEXT_27 = ") {" + NL + "\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_28 = ") selectedElement).getAdapter(";
  protected final String TEXT_29 = ".class);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_30 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = " diagram = (";
  protected final String TEXT_32 = ") selectedElement;" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_33 = ".MODEL_ID.equals(";
  protected final String TEXT_34 = ".getModelID(diagram))) {" + NL + "\t\t\t\t\t\tmyDiagram = diagram;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tsetEnabled(myDiagram != null);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run() {" + NL + "\t\t\tif (myDiagram == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_35 = " editorInput = new ";
  protected final String TEXT_36 = "(myDiagram);" + NL + "\t\t\t";
  protected final String TEXT_37 = " page = myViewerSite.getPage();" + NL + "\t\t \ttry {" + NL + "\t\t\t\tpage.openEditor(editorInput, ";
  protected final String TEXT_38 = ".ID);" + NL + "\t\t\t} catch (";
  protected final String TEXT_39 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_40 = ".getInstance().logError(\"Exception while openning diagram\", e);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
importManager.registerInnerClass("OpenFileAction");

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNavigator.getActionProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.CommonActionProvider"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonActionExtensionSite"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonViewerWorkbenchSite"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonViewerWorkbenchSite"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonViewerWorkbenchSite"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IActionBars"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonActionConstants"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonMenuConstants"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Action"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonViewerWorkbenchSite"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonViewerWorkbenchSite"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_40);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
