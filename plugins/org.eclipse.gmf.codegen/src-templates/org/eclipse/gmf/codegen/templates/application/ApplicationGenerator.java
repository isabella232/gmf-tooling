package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ApplicationGenerator
{
  protected static String nl;
  public static synchronized ApplicationGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ApplicationGenerator result = new ApplicationGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IPlatformRunnable;" + NL + "import org.eclipse.swt.widgets.Display;" + NL + "import org.eclipse.ui.PlatformUI;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements IPlatformRunnable {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object run(Object args) throws Exception {" + NL + "\t\tDisplay display = PlatformUI.createDisplay();" + NL + "\t\ttry {" + NL + "\t\t\tint returnCode = PlatformUI.createAndRunWorkbench(display," + NL + "\t\t\t\t\tnew ";
  protected final String TEXT_7 = "());" + NL + "\t\t\tif (returnCode == PlatformUI.RETURN_RESTART) {" + NL + "\t\t\t\treturn IPlatformRunnable.EXIT_RESTART;" + NL + "\t\t\t}" + NL + "\t\t\treturn IPlatformRunnable.EXIT_OK;" + NL + "\t\t} finally {" + NL + "\t\t\tdisplay.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "}";
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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(application.getWorkbenchAdvisorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
