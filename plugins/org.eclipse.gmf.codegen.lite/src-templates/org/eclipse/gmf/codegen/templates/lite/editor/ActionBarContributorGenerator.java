package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class ActionBarContributorGenerator
{
  protected static String nl;
  public static synchronized ActionBarContributorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ActionBarContributorGenerator result = new ActionBarContributorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "import org.eclipse.gef.ui.actions.ActionBarContributor;" + NL + "import org.eclipse.gef.ui.actions.DeleteRetargetAction;" + NL + "import org.eclipse.gef.ui.actions.GEFActionConstants;" + NL + "import org.eclipse.gef.ui.actions.RedoRetargetAction;" + NL + "import org.eclipse.gef.ui.actions.UndoRetargetAction;" + NL + "import org.eclipse.gef.ui.actions.ZoomComboContributionItem;" + NL + "import org.eclipse.gef.ui.actions.ZoomInRetargetAction;" + NL + "import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;" + NL + "import org.eclipse.jface.action.IMenuManager;" + NL + "import org.eclipse.jface.action.IToolBarManager;" + NL + "import org.eclipse.jface.action.MenuManager;" + NL + "import org.eclipse.jface.action.Separator;" + NL + "import org.eclipse.ui.IWorkbenchActionConstants;" + NL + "import org.eclipse.ui.actions.ActionFactory;" + NL + "" + NL + "/**" + NL + " * The action bar contributor for the ";
  protected final String TEXT_2 = " editor." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ActionBarContributor {";
  protected final String TEXT_4 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_5 = " globalActionKeys = new ";
  protected final String TEXT_6 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ZoomComboContributionItem myZoomContributionItem;";
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    protected void buildActions() {" + NL + "        addRetargetAction(new UndoRetargetAction());" + NL + "        addRetargetAction(new RedoRetargetAction());" + NL + "        addRetargetAction(new DeleteRetargetAction());" + NL + "    " + NL + "        addRetargetAction(new ZoomInRetargetAction());" + NL + "        addRetargetAction(new ZoomOutRetargetAction());" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    protected void declareGlobalActionKeys() {" + NL + "        addGlobalActionKey(ActionFactory.PRINT.getId());" + NL + "\t\taddGlobalActionKey(ActionFactory.DELETE.getId());" + NL + "    }" + NL;
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addGlobalActionKey(String key) {" + NL + "\t\tsuper.addGlobalActionKey(key);" + NL + "\t\tglobalActionKeys.add(key);" + NL + "\t}" + NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public void contributeToMenu(IMenuManager menuManager) {" + NL + "        super.contributeToMenu(menuManager);" + NL;
  protected final String TEXT_10 = NL + "        // add a \"View\" menu after \"Edit\"" + NL + "        MenuManager viewMenu = new MenuManager(\"View\");" + NL + "        viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));" + NL + "        viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));" + NL + "        " + NL + "        menuManager.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);";
  protected final String TEXT_11 = NL + "\t\tmenuManager.add(getAction(GEFActionConstants.ZOOM_IN));" + NL + "\t\tmenuManager.add(getAction(GEFActionConstants.ZOOM_OUT));";
  protected final String TEXT_12 = NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public void contributeToToolBar(IToolBarManager toolBarManager) {" + NL + "        super.contributeToToolBar(toolBarManager);" + NL + "" + NL + "        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));" + NL + "        toolBarManager.add(getAction(ActionFactory.REDO.getId()));" + NL + "    " + NL + "        toolBarManager.add(new Separator());";
  protected final String TEXT_13 = NL + "        toolBarManager.add(new ZoomComboContributionItem(getPage()));";
  protected final String TEXT_14 = NL + "\t\tmyZoomContributionItem = new ZoomComboContributionItem(getPage());" + NL + "\t\ttoolBarManager.add(myZoomContributionItem);";
  protected final String TEXT_15 = NL + "    }" + NL;
  protected final String TEXT_16 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateGlobalActions(";
  protected final String TEXT_17 = " viewPart) {" + NL + "\t\t";
  protected final String TEXT_18 = " registry = viewPart == null ? null : (";
  protected final String TEXT_19 = ") viewPart.getAdapter(";
  protected final String TEXT_20 = ".class);" + NL + "\t\t";
  protected final String TEXT_21 = " bars = getActionBars();" + NL + "\t\tif (registry == null) {" + NL + "\t\t\tbars.clearGlobalActionHandlers();" + NL + "\t\t} else {" + NL + "\t\t\tfor (int i = 0; i < globalActionKeys.size(); i++) {" + NL + "\t\t\t\tString id = (String) globalActionKeys.get(i);" + NL + "\t\t\t\tbars.setGlobalActionHandler(id, registry.getAction(id));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_22 = " zoomManager = viewPart == null ? null : (";
  protected final String TEXT_23 = ") viewPart.getAdapter(";
  protected final String TEXT_24 = ".class);" + NL + "\t\tmyZoomContributionItem.setZoomManager(zoomManager);" + NL + "\t\tbars.updateActionBars();" + NL + "\t}";
  protected final String TEXT_25 = NL + "}";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView editorView = (GenEditorView) ((Object[]) argument)[0];
final GenModel genModel = editorView.getEditorGen().getDomainGenModel();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(editorView.getActionBarContributorClassName());
    stringBuffer.append(TEXT_3);
    
if (!editorView.isEclipseEditor()) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    
if (!editorView.isEclipseEditor()) {

    stringBuffer.append(TEXT_8);
    
}

    stringBuffer.append(TEXT_9);
    
if (editorView.isEclipseEditor()) {

    stringBuffer.append(TEXT_10);
    
} else {

    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    
if (editorView.isEclipseEditor()) {

    stringBuffer.append(TEXT_13);
    
} else {

    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    
if (!editorView.isEclipseEditor()) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IViewPart"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ActionRegistry"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ActionRegistry"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ActionRegistry"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IActionBars"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
