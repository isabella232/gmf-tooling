package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class CreationWizardPageGenerator
{
  protected static String nl;
  public static synchronized CreationWizardPageGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreationWizardPageGenerator result = new CreationWizardPageGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.swt.widgets.Composite;" + NL + "import org.eclipse.ui.dialogs.WizardNewFileCreationPage;" + NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends WizardNewFileCreationPage {";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String DOMAIN_EXT = \".";
  protected final String TEXT_8 = "\"; //$NON-NLS-1$";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String DIAGRAM_EXT = \".";
  protected final String TEXT_10 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_11 = "(String pageName, IStructuredSelection selection) {" + NL + "\t\tsuper(pageName, selection);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDefaultFileName() {" + NL + "\t\treturn \"default\"; //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getFileName() {" + NL + "\t\tString fileName = super.getFileName();" + NL + "\t\tif (fileName != null && !fileName.endsWith(DIAGRAM_EXT)) {" + NL + "\t\t\tfileName += DIAGRAM_EXT;" + NL + "\t\t}" + NL + "\t\treturn fileName;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getUniqueFileName(IPath containerPath, String fileName) {" + NL + "\t\tString newFileName = fileName;" + NL + "\t\tIPath diagramFilePath = containerPath.append(newFileName + DIAGRAM_EXT);";
  protected final String TEXT_12 = NL + "\t\tIPath modelFilePath = containerPath.append(newFileName + DOMAIN_EXT);";
  protected final String TEXT_13 = NL + "\t\tint i = 1;" + NL + "\t\twhile (exists(diagramFilePath)";
  protected final String TEXT_14 = NL + "\t\t\t\t|| exists(modelFilePath)";
  protected final String TEXT_15 = NL + "\t\t\t\t) {" + NL + "\t\t\ti++;" + NL + "\t\t\tnewFileName = fileName + i;" + NL + "\t\t\tdiagramFilePath = containerPath.append(newFileName + DIAGRAM_EXT);";
  protected final String TEXT_16 = NL + "\t\t\tmodelFilePath = containerPath.append(newFileName + DOMAIN_EXT);";
  protected final String TEXT_17 = NL + "\t\t}" + NL + "\t\treturn newFileName;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent) {" + NL + "\t\tsuper.createControl(parent);" + NL + "\t\tIPath path = getContainerFullPath();" + NL + "\t\tif (path != null) {" + NL + "\t\t\tString fileName = getUniqueFileName(path, getDefaultFileName());" + NL + "\t\t\tsetFileName(fileName);" + NL + "\t\t} else {" + NL + "\t\t\tsetFileName(getDefaultFileName());" + NL + "\t\t}" + NL + "\t\tsetPageComplete(validatePage());" + NL + "\t}";
  protected final String TEXT_18 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean validatePage() {" + NL + "\t\tif (super.validatePage()) {" + NL + "\t\t\tString fileName = getFileName();" + NL + "\t\t\tif (fileName == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tfileName = fileName.substring(0, fileName.length() - DIAGRAM_EXT.length()) + DOMAIN_EXT;" + NL + "\t\t\tIPath path = getContainerFullPath().append(fileName);" + NL + "\t\t\tif (exists(path)) {" + NL + "\t\t\t\tsetErrorMessage(\"Model file already exists: \" + path.lastSegment());" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_19 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean exists(IPath path) {";
  protected final String TEXT_20 = NL + "\t\treturn ";
  protected final String TEXT_21 = ".getWorkspace().getRoot().exists(path);";
  protected final String TEXT_22 = NL + "\t\treturn path.toFile().exists();";
  protected final String TEXT_23 = NL + "\t}" + NL + "}";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenApplication application = editorGen.getApplication();

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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_11);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    if (application == null) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
