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
  protected final String TEXT_4 = NL + NL + "import java.io.ByteArrayInputStream;" + NL + "import java.io.InputStream;" + NL + "" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.swt.widgets.Composite;" + NL + "import org.eclipse.ui.dialogs.WizardNewFileCreationPage;" + NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends WizardNewFileCreationPage {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(String pageName, IStructuredSelection selection) {" + NL + "\t\tsuper(pageName, selection);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDefaultFileName() {" + NL + "\t\treturn \"default\"; //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getFileName() {" + NL + "\t\tString fileName = super.getFileName();" + NL + "\t\tif (fileName != null) {" + NL + "\t\t\tfileName = getDiagramFileCreator().appendExtensionToFileName(fileName);" + NL + "\t\t}" + NL + "\t\treturn fileName;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic InputStream getInitialContents() {" + NL + "\t\treturn new ByteArrayInputStream(new byte[0]);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = " getDiagramFileCreator() {" + NL + "\t\treturn ";
  protected final String TEXT_9 = ".getInstance();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent) {" + NL + "\t\tsuper.createControl(parent);" + NL + "\t\tIPath path = getContainerFullPath();" + NL + "\t\tif (path != null) {" + NL + "\t\t\tString fileName = getDiagramFileCreator().getUniqueFileName(path, getDefaultFileName());" + NL + "\t\t\tsetFileName(fileName);" + NL + "\t\t}" + NL + "\t\tsetPageComplete(validatePage());" + NL + "\t}";
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean validatePage() {" + NL + "\t\tif (super.validatePage()) {" + NL + "\t\t\tString fileName = getFileName();" + NL + "\t\t\tif (fileName == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t// appending file extension to correctly process file names including \".\" symbol" + NL + "\t\t\tIPath path = getContainerFullPath().append(getDiagramFileCreator().appendExtensionToFileName(fileName));" + NL + "\t\t\tpath = path.removeFileExtension().addFileExtension(\"";
  protected final String TEXT_11 = "\"); //$NON-NLS-1$" + NL + "\t\t\tif (";
  protected final String TEXT_12 = ".exists(path)) {" + NL + "\t\t\t\tsetErrorMessage(\"Model file already exists: \" + path.lastSegment());" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_13 = NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramFileCreatorQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramFileCreatorQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramFileCreatorQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
