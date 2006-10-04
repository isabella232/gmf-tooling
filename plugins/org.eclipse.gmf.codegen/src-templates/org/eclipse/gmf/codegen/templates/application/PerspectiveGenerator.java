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
  protected final String TEXT_4 = NL + NL + "import org.eclipse.ui.IFolderLayout;" + NL + "import org.eclipse.ui.IPageLayout;" + NL + "import org.eclipse.ui.IPerspectiveFactory;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements IPerspectiveFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createInitialLayout(IPageLayout layout) {" + NL + "\t\tlayout.setEditorAreaVisible(true);" + NL + "\t\tlayout.addPerspectiveShortcut(TaiPanWorkbenchAdvisor.PERSPECTIVE_ID);" + NL + "\t\tIFolderLayout right = layout.createFolder(\"right\", IPageLayout.RIGHT, 0.6f, layout.getEditorArea()); //$NON-NLS-1$" + NL + "\t\tright.addView(IPageLayout.ID_OUTLINE);" + NL + "\t\tIFolderLayout bottomRight = layout.createFolder(\"bottomRight\", IPageLayout.BOTTOM, 0.6f, \"right\"); //$NON-NLS-1$ //$NON-NLS-2$" + NL + "\t\tbottomRight.addView(IPageLayout.ID_PROP_SHEET);" + NL + "\t}" + NL + "}";
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
