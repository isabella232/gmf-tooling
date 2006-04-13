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
  protected final String TEXT_3 = " extends ActionBarContributor {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    protected void buildActions() {" + NL + "        addRetargetAction(new UndoRetargetAction());" + NL + "        addRetargetAction(new RedoRetargetAction());" + NL + "        addRetargetAction(new DeleteRetargetAction());" + NL + "    " + NL + "        addRetargetAction(new ZoomInRetargetAction());" + NL + "        addRetargetAction(new ZoomOutRetargetAction());" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    protected void declareGlobalActionKeys() {" + NL + "        addGlobalActionKey(ActionFactory.PRINT.getId());" + NL + "\t\taddGlobalActionKey(ActionFactory.DELETE.getId());" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public void contributeToMenu(IMenuManager menuManager) {" + NL + "        super.contributeToMenu(menuManager);" + NL + "" + NL + "        // add a \"View\" menu after \"Edit\"" + NL + "        MenuManager viewMenu = new MenuManager(\"View\");" + NL + "        viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));" + NL + "        viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));" + NL + "        " + NL + "        menuManager.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public void contributeToToolBar(IToolBarManager toolBarManager) {" + NL + "        super.contributeToToolBar(toolBarManager);" + NL + "" + NL + "        toolBarManager.add(getAction(ActionFactory.UNDO.getId()));" + NL + "        toolBarManager.add(getAction(ActionFactory.REDO.getId()));" + NL + "    " + NL + "        toolBarManager.add(new Separator());" + NL + "        toolBarManager.add(new ZoomComboContributionItem(getPage()));" + NL + "    }" + NL + "}";
  protected final String TEXT_4 = NL;

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
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
