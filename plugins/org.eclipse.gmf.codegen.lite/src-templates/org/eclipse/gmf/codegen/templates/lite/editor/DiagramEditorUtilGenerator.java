package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramEditorUtilGenerator
{
  protected static String nl;
  public static synchronized DiagramEditorUtilGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditorUtilGenerator result = new DiagramEditorUtilGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String openFilePathDialog(Shell shell, String fileExtensionFilter, int style) {" + NL + "\t\tFileDialog fileDialog = new FileDialog(shell, style);" + NL + "\t\tfileDialog.setFilterExtensions(new String[]{fileExtensionFilter});" + NL + "" + NL + "\t\tfileDialog.open();" + NL + "\t\tif (fileDialog.getFileName() != null && fileDialog.getFileName().length() > 0) {" + NL + "\t\t\treturn fileDialog.getFilterPath() + File.separator + fileDialog.getFileName();" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean openEditor(URI fileURI) {" + NL + "\t\tIWorkbench workbench = PlatformUI.getWorkbench();" + NL + "\t\tIWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();" + NL + "\t\tIWorkbenchPage page = workbenchWindow.getActivePage();" + NL + "" + NL + "\t\tIEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileURI.toFileString());" + NL + "\t\tif (editorDescriptor == null) {" + NL + "\t\t\tMessageDialog.openError(" + NL + "\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\t\"Error\"," + NL + "\t\t\t\"There is no editor registered for the file \" + fileURI.toFileString());" + NL + "\t\t\treturn false;" + NL + "\t\t} else {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tpage.openEditor(new URIEditorInput(fileURI), editorDescriptor.getId());" + NL + "\t\t\t} catch (PartInitException exception) {" + NL + "\t\t\t\tMessageDialog.openError(" + NL + "\t\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\t\t\"Error Opening Editor\"," + NL + "\t\t\t\texception.getMessage());" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static URI getDiagramFileURI(URI modelFileURI) {" + NL + "\t\tif (modelFileURI == null || !modelFileURI.isFile()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn modelFileURI.trimFileExtension().appendFileExtension(\"";
  protected final String TEXT_4 = "\");" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static URI getModelFileURI(URI diagramFileURI) {" + NL + "\t\tif (diagramFileURI == null || !diagramFileURI.isFile()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn diagramFileURI.trimFileExtension().appendFileExtension(\"";
  protected final String TEXT_5 = "\");" + NL + "\t}" + NL + " }";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
importManager.addImport("java.io.File");
importManager.addImport("org.eclipse.ui.IWorkbench");
importManager.addImport("org.eclipse.ui.IWorkbenchPage");
importManager.addImport("org.eclipse.ui.IWorkbenchWindow");
importManager.addImport("org.eclipse.ui.PlatformUI");
importManager.addImport("org.eclipse.ui.PartInitException");
importManager.addImport("org.eclipse.ui.IEditorDescriptor");
importManager.addImport("org.eclipse.swt.widgets.Shell");
importManager.addImport("org.eclipse.swt.widgets.FileDialog"); 
importManager.addImport("org.eclipse.jface.dialogs.MessageDialog");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("org.eclipse.emf.common.ui.URIEditorInput");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_5);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
