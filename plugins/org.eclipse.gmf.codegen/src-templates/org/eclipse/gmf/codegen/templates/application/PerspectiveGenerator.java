package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class PerspectiveGenerator
{
  protected static String nl;
  public static synchronized PerspectiveGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PerspectiveGenerator result = new PerspectiveGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.ui.IPageLayout;" + NL + "import org.eclipse.ui.IPerspectiveFactory;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements IPerspectiveFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createInitialLayout(IPageLayout layout) {" + NL + "\t\tString editorArea = layout.getEditorArea();" + NL + "\t\tlayout.addStandaloneView(\"org.eclipse.ui.views.ResourceNavigator\", false, IPageLayout.LEFT, 1.0f, editorArea); //$NON-NLS-1$" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

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
    stringBuffer.append(application.getPerspectiveClassName());
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
