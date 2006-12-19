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
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.osgi.util.NLS;" + NL + "import org.eclipse.swt.widgets.Composite;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "\t";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "\t";
  protected final String TEXT_11 = NL + "\t{" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final String fileExtension;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = "(String pageName, IStructuredSelection selection, String fileExtension) {" + NL + "\t\tsuper(pageName, selection);" + NL + "\t\tthis.fileExtension = fileExtension;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Override to create files with this extension." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getExtension() {" + NL + "\t\treturn fileExtension;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic URI getURI() {";
  protected final String TEXT_13 = NL + "\t\treturn URI.createPlatformResourceURI(getFilePath().toString());";
  protected final String TEXT_14 = NL + "\t\treturn URI.createFileURI(getFilePath().toString());";
  protected final String TEXT_15 = NL + "\t}";
  protected final String TEXT_16 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IPath getFilePath() {" + NL + "\t\tIPath path = getContainerFullPath();" + NL + "\t\tif (path == null) {" + NL + "\t\t\tpath = new Path(\"\"); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\tString fileName = getFileName();" + NL + "\t\tif (fileName != null) {" + NL + "\t\t\tpath = path.append(fileName);" + NL + "\t\t}" + NL + "\t\treturn path;" + NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t";
  protected final String TEXT_18 = NL + "\t";
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getUniqueFileName(IPath containerFullPath, String fileName) {" + NL + "\t\tif (containerFullPath == null) {" + NL + "\t\t\tcontainerFullPath = new Path(\"\"); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\tif (fileName == null || fileName.trim().length() == 0) {" + NL + "\t\t\tfileName = \"default\"; //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\tIPath filePath = containerFullPath.append(fileName);" + NL + "\t\tString extension = getExtension();" + NL + "\t\tif (extension != null && !extension.equals(filePath.getFileExtension())) {" + NL + "\t\t\tfilePath = filePath.addFileExtension(extension);" + NL + "\t\t}" + NL + "" + NL + "\t\textension = filePath.getFileExtension();" + NL + "\t\tfileName = filePath.removeFileExtension().lastSegment();" + NL + "\t\tint i = 1;" + NL + "\t\twhile (";
  protected final String TEXT_20 = ".exists(filePath)) {" + NL + "\t\t\ti++;" + NL + "\t\t\tfilePath = containerFullPath.append(fileName + i);" + NL + "\t\t\tif (extension != null) {" + NL + "\t\t\t\tfilePath = filePath.addFileExtension(extension);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn filePath.lastSegment();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_21 = "\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent) {" + NL + "\t\tsuper.createControl(parent);" + NL + "\t\tsetFileName(getUniqueFileName(getContainerFullPath(), getFileName()));" + NL + "\t\tsetPageComplete(validatePage());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean validatePage() {" + NL + "\t\tif (!super.validatePage()) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tString extension = getExtension();" + NL + "\t\tif (extension != null && !getFilePath().toString().endsWith(\".\" + extension)) {" + NL + "\t\t\tsetErrorMessage(NLS.bind(\"File name should have ''{0}'' extension.\", extension));" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL + "}";

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
    if (application == null) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(application.getPackageName() + ".WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_12);
    if (application == null) {
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if (application == null) {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
