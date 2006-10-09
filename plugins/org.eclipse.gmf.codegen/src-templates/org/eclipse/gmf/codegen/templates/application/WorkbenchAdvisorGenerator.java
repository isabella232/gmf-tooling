package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class WorkbenchAdvisorGenerator
{
  protected static String nl;
  public static synchronized WorkbenchAdvisorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    WorkbenchAdvisorGenerator result = new WorkbenchAdvisorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.ui.application.IWorkbenchConfigurer;" + NL + "import org.eclipse.ui.application.IWorkbenchWindowConfigurer;" + NL + "import org.eclipse.ui.application.WorkbenchAdvisor;" + NL + "import org.eclipse.ui.application.WorkbenchWindowAdvisor;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends WorkbenchAdvisor {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String PERSPECTIVE_ID = \"";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getInitialWindowPerspectiveId() {" + NL + "\t\treturn PERSPECTIVE_ID;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void initialize(IWorkbenchConfigurer configurer) {" + NL + "\t\tsuper.initialize(configurer);" + NL + "\t\tconfigurer.setSaveAndRestore(true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {" + NL + "\t\treturn new ";
  protected final String TEXT_8 = "(configurer);" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(application.getPerspectiveId());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(application.getWorkbenchWindowAdvisorQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
