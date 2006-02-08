package org.eclipse.gmf.codegen.templates.editor;

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.io.InputStream;" + NL + "import java.lang.reflect.InvocationTargetException;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;" + NL + "import org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain;" + NL + "import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.operation.IRunnableContext;" + NL + "import org.eclipse.jface.operation.IRunnableWithProgress;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IWorkbenchWindow;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends IDEEditorUtil {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IFile createAndOpenDiagram(DiagramFileCreator diagramFileCreator, IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow window, IProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {" + NL + "\t\tIFile diagramFile = ";
  protected final String TEXT_6 = ".createNewDiagramFile(diagramFileCreator, containerPath, fileName, initialContents, kind, window.getShell(), progressMonitor);" + NL + "\t\tif (diagramFile != null && openEditor) {" + NL + "\t\t\tIDEEditorUtil.openDiagram(diagramFile, window, saveDiagram, progressMonitor);" + NL + "\t\t}" + NL + "\t\treturn diagramFile;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <p>" + NL + "\t * This method should be called within a workspace modify operation since it creates resources." + NL + "\t * </p>" + NL + "\t * @generated" + NL + "\t * @return the created file resource, or <code>null</code> if the file was not created" + NL + "\t */" + NL + "\tpublic static final IFile createNewDiagramFile(DiagramFileCreator diagramFileCreator, IPath containerFullPath, String fileName, InputStream initialContents, String kind, Shell shell, IProgressMonitor progressMonitor) {" + NL + "\t\tfinal MEditingDomain editingDomain = MEditingDomain.createNewDomain();" + NL + "\t\tfinal IProgressMonitor progressMonitorCopy = progressMonitor;" + NL + "\t\tfinal IFile diagramFile = diagramFileCreator.createNewFile(containerFullPath, fileName, initialContents, shell, new IRunnableContext() {" + NL + "\t\t\tpublic void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable) throws InvocationTargetException, InterruptedException {" + NL + "\t\t\t\trunnable.run(progressMonitorCopy);" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "" + NL + "\t\tIPath diagramFilePath = diagramFile.getLocation();" + NL + "\t\tfinal Resource diagramResource = editingDomain.createResource(diagramFilePath.toOSString());";
  protected final String TEXT_7 = NL + "\t\tIPath modelFilePath = diagramFilePath.removeFileExtension().addFileExtension(\"";
  protected final String TEXT_8 = "\"); //$NON-NLS-1$" + NL + "\t\tfinal Resource modelResource = editingDomain.createResource(modelFilePath.toOSString());";
  protected final String TEXT_9 = NL + NL + "\t\tif (diagramResource != null";
  protected final String TEXT_10 = " && modelResource != null";
  protected final String TEXT_11 = ") {" + NL + "\t\t\tfinal String kindParam = kind;" + NL + "\t\t\teditingDomain.runAsUnchecked(new MRunnable() {" + NL + "" + NL + "\t\t\t\tpublic Object run() {" + NL + "\t\t\t\t\tEObject model = editingDomain.create(";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "());";
  protected final String TEXT_14 = "\t\t\t\t\t" + NL + "\t\t\t\t\tmodelResource.getContents().add(model);" + NL + "\t\t\t\t\teditingDomain.saveResource(modelResource);";
  protected final String TEXT_15 = NL + "\t\t\t\t\tdiagramResource.getContents.add(model);";
  protected final String TEXT_16 = NL + "\t\t\t\t\tDiagram diagram = ViewService.createDiagram(model, kindParam, ";
  protected final String TEXT_17 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\t\tif (diagram != null) {" + NL + "\t\t\t\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\t\t\t\tdiagram.setName(diagramFile.getName());" + NL + "\t\t\t\t\t\tdiagram.setElement(model);" + NL + "\t\t\t\t\t\teditingDomain.saveResource(diagramResource);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "" + NL + "\t\treturn diagramFile;" + NL + "\t}" + NL + "}";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
GenEditorGenerator editorGen = genDiagram.getEditorGen();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_6);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getMetaPackageName(importManager));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_13);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_17);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
