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
  protected final String TEXT_4 = NL + NL + "import java.io.ByteArrayInputStream;" + NL + "" + NL + "import org.eclipse.jface.dialogs.ErrorDialog;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.resources.IResourceStatus;" + NL + "import org.eclipse.core.resources.ResourcesPlugin;" + NL + "" + NL + "import org.eclipse.core.runtime.CoreException;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.NullProgressMonitor;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IFile createNewFile(IPath containerPath, String fileName, Shell shell) {" + NL + "\t\tIPath newFilePath = containerPath.append(fileName);" + NL + "\t\tIFile newFileHandle = ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);" + NL + "\t\ttry {" + NL + "\t\t\tcreateFile(newFileHandle);" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\tErrorDialog.openError(shell, \"Creation Problems\", null, e.getStatus());" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn newFileHandle;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static void createFile(IFile fileHandle) throws CoreException {" + NL + "\t\ttry {" + NL + "\t\t\tfileHandle.create(new ByteArrayInputStream(new byte[0]), false, new NullProgressMonitor());" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\t// If the file already existed locally, just refresh to get contents" + NL + "\t\t\tif (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED) {" + NL + "\t\t\t\tfileHandle.refreshLocal(IResource.DEPTH_ZERO, null);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthrow e;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
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
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
