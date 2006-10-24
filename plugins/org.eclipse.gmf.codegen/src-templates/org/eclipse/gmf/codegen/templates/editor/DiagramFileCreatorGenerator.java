package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramFileCreatorGenerator
{
  protected static String nl;
  public static synchronized DiagramFileCreatorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramFileCreatorGenerator result = new DiagramFileCreatorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.io.ByteArrayInputStream;" + NL + "import java.io.InputStream;" + NL + "" + NL + "import org.eclipse.jface.dialogs.ErrorDialog;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.resources.IResourceStatus;" + NL + "import org.eclipse.core.resources.ResourcesPlugin;" + NL + "" + NL + "import org.eclipse.core.runtime.CoreException;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.NullProgressMonitor;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_7 = " INSTANCE = new ";
  protected final String TEXT_8 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_9 = " getInstance() {" + NL + "\t\treturn INSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean exists(IPath path) {";
  protected final String TEXT_10 = NL + "\t\treturn ResourcesPlugin.getWorkspace().getRoot().exists(path);";
  protected final String TEXT_11 = NL + "\t\treturn path.toFile().exists();";
  protected final String TEXT_12 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getExtension() {" + NL + "\t\treturn \".";
  protected final String TEXT_13 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getUniqueFileName(IPath containerPath, String fileName) {" + NL + "\t\tint nFileNumber = 1;" + NL + "\t\tfileName = removeExtensionFromFileName(fileName);" + NL + "\t\tString newFileName = fileName;" + NL + "\t\tIPath diagramFilePath = containerPath.append(appendExtensionToFileName(newFileName));";
  protected final String TEXT_14 = NL + "\t\tIPath modelFilePath = containerPath.append(newFileName + \".";
  protected final String TEXT_15 = "\"); //$NON-NLS-1$";
  protected final String TEXT_16 = NL + "\t\twhile (exists(diagramFilePath)";
  protected final String TEXT_17 = NL + "\t\t\t\t|| exists(modelFilePath)";
  protected final String TEXT_18 = NL + "\t\t\t\t) {" + NL + "\t\t\tnFileNumber++;" + NL + "\t\t\tnewFileName = fileName + nFileNumber;" + NL + "\t\t\tdiagramFilePath = containerPath.append(appendExtensionToFileName(newFileName));";
  protected final String TEXT_19 = NL + "\t\t\tmodelFilePath = containerPath.append(newFileName + \".";
  protected final String TEXT_20 = "\"); //$NON-NLS-1$";
  protected final String TEXT_21 = NL + "\t\t}" + NL + "\t\treturn newFileName;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String appendExtensionToFileName(String fileName) {" + NL + "\t\tif (!fileName.endsWith(getExtension())) {" + NL + "\t\t\treturn fileName + getExtension();" + NL + "\t\t}" + NL + "\t\treturn fileName;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String removeExtensionFromFileName(String fileName) {" + NL + "\t\tif (fileName.endsWith(getExtension())) {" + NL + "\t\t\treturn fileName.substring(0, fileName.length() - getExtension().length());" + NL + "\t\t}" + NL + "\t\treturn fileName;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFile createNewFile(IPath containerPath, String fileName, InputStream initialContents, Shell shell) {" + NL + "\t\tIPath newFilePath = containerPath.append(appendExtensionToFileName(fileName));" + NL + "\t\tIFile newFileHandle = ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);" + NL + "\t\ttry {" + NL + "\t\t\tcreateFile(newFileHandle, initialContents);" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\tErrorDialog.openError(shell, \"Creation Problems\", null, e.getStatus());" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn newFileHandle;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createFile(IFile fileHandle, InputStream contents) throws CoreException {" + NL + "\t\ttry {" + NL + "\t\t\tif (contents == null) {" + NL + "\t\t\t\tcontents = new ByteArrayInputStream(new byte[0]);" + NL + "\t\t\t}" + NL + "\t\t\tfileHandle.create(contents, false, new NullProgressMonitor());" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\t// If the file already existed locally, just refresh to get contents" + NL + "\t\t\tif (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED) {" + NL + "\t\t\t\tfileHandle.refreshLocal(IResource.DEPTH_ZERO, null);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow e;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_22 = NL;

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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_9);
    if (application == null) {
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_13);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
