package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class WorkbenchWindowAdvisorGenerator
{
  protected static String nl;
  public static synchronized WorkbenchWindowAdvisorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    WorkbenchWindowAdvisorGenerator result = new WorkbenchWindowAdvisorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.swt.graphics.Point;" + NL + "import org.eclipse.ui.application.ActionBarAdvisor;" + NL + "import org.eclipse.ui.application.IActionBarConfigurer;" + NL + "import org.eclipse.ui.application.IWorkbenchWindowConfigurer;" + NL + "import org.eclipse.ui.application.WorkbenchWindowAdvisor;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends WorkbenchWindowAdvisor {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(IWorkbenchWindowConfigurer configurer) {" + NL + "\t\tsuper(configurer);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {" + NL + "\t\treturn new ";
  protected final String TEXT_8 = "(configurer);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void preWindowOpen() {" + NL + "\t\tIWorkbenchWindowConfigurer configurer = getWindowConfigurer();" + NL + "\t\tconfigurer.setInitialSize(new Point(400, 300));" + NL + "\t\tconfigurer.setShowCoolBar(false);" + NL + "\t\tconfigurer.setShowStatusLine(false);" + NL + "\t\tconfigurer.setTitle(\"";
  protected final String TEXT_9 = "\");" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

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
    stringBuffer.append(application.getWorkbenchWindowAdvisorClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(application.getWorkbenchWindowAdvisorClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(application.getActionBarAdvisorQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(application.getTitle());
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
