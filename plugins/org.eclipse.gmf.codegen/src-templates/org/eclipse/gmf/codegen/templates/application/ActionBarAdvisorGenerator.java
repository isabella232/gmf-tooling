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
  protected final String TEXT_4 = NL + NL + "import org.eclipse.jface.action.IMenuManager;" + NL + "import org.eclipse.jface.action.MenuManager;" + NL + "import org.eclipse.ui.IWorkbenchActionConstants;" + NL + "import org.eclipse.ui.IWorkbenchWindow;" + NL + "import org.eclipse.ui.actions.ActionFactory;" + NL + "import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;" + NL + "import org.eclipse.ui.application.ActionBarAdvisor;" + NL + "import org.eclipse.ui.application.IActionBarConfigurer;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ActionBarAdvisor {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IWorkbenchAction quitAction;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(IActionBarConfigurer configurer) {" + NL + "\t\tsuper(configurer);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void makeActions(final IWorkbenchWindow window) {" + NL + "\t\tquitAction = ActionFactory.QUIT.create(window);" + NL + "\t\tregister(quitAction);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillMenuBar(IMenuManager menuBar) {" + NL + "\t\tMenuManager fileMenu = new MenuManager(\"&File\", IWorkbenchActionConstants.M_FILE);" + NL + "\t\tmenuBar.add(fileMenu);" + NL + "\t\tfileMenu.add(quitAction);" + NL + "\t}" + NL + "}";
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
