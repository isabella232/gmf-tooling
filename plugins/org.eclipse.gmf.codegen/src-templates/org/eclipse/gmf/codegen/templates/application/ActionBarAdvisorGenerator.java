package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ActionBarAdvisorGenerator
{
  protected static String nl;
  public static synchronized ActionBarAdvisorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ActionBarAdvisorGenerator result = new ActionBarAdvisorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.jface.action.GroupMarker;" + NL + "import org.eclipse.jface.action.IAction;" + NL + "import org.eclipse.jface.action.IMenuManager;" + NL + "import org.eclipse.jface.action.MenuManager;" + NL + "import org.eclipse.jface.action.Separator;" + NL + "import org.eclipse.ui.IWorkbenchActionConstants;" + NL + "import org.eclipse.ui.IWorkbenchWindow;" + NL + "import org.eclipse.ui.actions.ActionFactory;" + NL + "import org.eclipse.ui.actions.ContributionItemFactory;" + NL + "import org.eclipse.ui.application.ActionBarAdvisor;" + NL + "import org.eclipse.ui.application.IActionBarConfigurer;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ActionBarAdvisor {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(IActionBarConfigurer configurer) {" + NL + "\t\tsuper(configurer);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillMenuBar(IMenuManager menuBar) {" + NL + "\t\tIWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();" + NL + "\t\tmenuBar.add(createFileMenu(window));" + NL + "\t\tmenuBar.add(createEditMenu(window));" + NL + "\t\tmenuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\tmenuBar.add(createWindowMenu(window));" + NL + "\t\tmenuBar.add(createHelpMenu(window));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IMenuManager createFileMenu(IWorkbenchWindow window) {" + NL + "\t\tIMenuManager menu = new MenuManager(\"&File\", IWorkbenchActionConstants.M_FILE);" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));" + NL + "\t\tIMenuManager newMenu = new MenuManager(\"&New\", \"new\"); //$NON-NLS-2$" + NL + "\t\tnewMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\tmenu.add(newMenu);" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.CLOSE.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.CLOSE_ALL.create(window));" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.SAVE.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.SAVE_AS.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.SAVE_ALL.create(window));" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.QUIT.create(window));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));" + NL + "\t\treturn menu;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IMenuManager createEditMenu(IWorkbenchWindow window) {" + NL + "\t\tIMenuManager menu = new MenuManager(\"&Edit\", IWorkbenchActionConstants.M_EDIT);" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.UNDO.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.REDO.create(window));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.CUT.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.COPY.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.PASTE.create(window));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.DELETE.create(window));" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.SELECT_ALL.create(window));" + NL + "\t\tmenu.add(new Separator());" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));" + NL + "\t\tmenu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\treturn menu;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IMenuManager createWindowMenu(IWorkbenchWindow window) {" + NL + "\t\tIMenuManager menu = new MenuManager(\"&Window\", IWorkbenchActionConstants.M_WINDOW);" + NL + "\t\taddToMenuAndRegister(menu, ActionFactory.OPEN_NEW_WINDOW.create(window));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\tmenu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));" + NL + "\t\treturn menu;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IMenuManager createHelpMenu(IWorkbenchWindow window) {" + NL + "\t\tIMenuManager menu = new MenuManager(\"&Help\", IWorkbenchActionConstants.M_HELP);" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));" + NL + "\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\treturn menu;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addToMenuAndRegister(IMenuManager menuManager, IAction action) {" + NL + "\t\tmenuManager.add(action);" + NL + "\t\tregister(action);" + NL + "\t}" + NL + "}";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenApplication application = (GenApplication) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    {
	GenDiagram genDiagram = application.getEditorGen().getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(application.getActionBarAdvisorClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(application.getActionBarAdvisorClassName());
    stringBuffer.append(TEXT_7);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
