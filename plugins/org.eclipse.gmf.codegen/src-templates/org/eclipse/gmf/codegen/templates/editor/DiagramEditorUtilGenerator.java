package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

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
  protected final String TEXT_3 = NL + "import java.io.InputStream;" + NL + "import java.lang.reflect.InvocationTargetException;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.IStatus;" + NL + "import org.eclipse.core.runtime.Status;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;" + NL + "import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.EObjectUtil;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.operation.IRunnableContext;" + NL + "import org.eclipse.jface.operation.IRunnableWithProgress;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IWorkbenchWindow;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends IDEEditorUtil {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IFile createAndOpenDiagram(DiagramFileCreator diagramFileCreator," + NL + "\t\tIPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow window," + NL + "\t\tIProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {" + NL + "" + NL + "\t\tIFile diagramFile = ";
  protected final String TEXT_6 = ".createNewDiagramFile(diagramFileCreator," + NL + "\t\t\tcontainerPath, fileName, initialContents, kind, window.getShell(), progressMonitor);" + NL + "\t\tif (diagramFile != null && openEditor) {" + NL + "\t\t\tIDEEditorUtil.openDiagram(diagramFile, window, saveDiagram, progressMonitor);" + NL + "\t\t}" + NL + "\t\treturn diagramFile;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates a new diagram file resource in the selected container and with" + NL + "\t * the selected name. Creates any missing resource containers along the" + NL + "\t * path; does nothing if the container resources already exist." + NL + "\t * <p>" + NL + "\t * In normal usage, this method is invoked after the user has pressed Finish" + NL + "\t * on the wizard; the enablement of the Finish button implies that all" + NL + "\t * controls on on this page currently contain valid values." + NL + "\t * </p>" + NL + "\t * <p>" + NL + "\t * Note that this page caches the new file once it has been successfully" + NL + "\t * created; subsequent invocations of this method will answer the same file" + NL + "\t * resource without attempting to create it again." + NL + "\t * </p>" + NL + "\t * <p>" + NL + "\t * This method should be called within a workspace modify operation since it" + NL + "\t * creates resources." + NL + "\t * </p>" + NL + "\t * " + NL + "\t * @generated" + NL + "\t * @return the created file resource, or <code>null</code> if the file was" + NL + "\t *         not created" + NL + "\t */" + NL + "\tpublic static final IFile createNewDiagramFile(DiagramFileCreator diagramFileCreator," + NL + "\t\tIPath containerFullPath, String fileName, InputStream initialContents," + NL + "\t\tString kind, Shell shell, IProgressMonitor progressMonitor) {" + NL + "" + NL + "\t\tfinal IProgressMonitor progressMonitorParam = progressMonitor;" + NL + "\t\tfinal IFile newDiagramFile = diagramFileCreator.createNewFile(containerFullPath," + NL + "\t\t\tfileName, initialContents, shell, new IRunnableContext() {" + NL + "" + NL + "\t\t\tpublic void run(boolean fork, boolean cancelable, IRunnableWithProgress runnable) throws InvocationTargetException, InterruptedException {" + NL + "\t\t\t\trunnable.run(progressMonitorParam);" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_7 = NL + "\t\tIPath modelFilePath = newDiagramFile.getLocation().removeFileExtension();" + NL + "\t\tmodelFilePath = modelFilePath.addFileExtension(\"";
  protected final String TEXT_8 = "\"); //$NON-NLS-1$" + NL + "\t\tfinal Resource modelResource = ResourceUtil.create(modelFilePath.toOSString(), null);";
  protected final String TEXT_9 = NL + "\t\tResource notationModel = null;" + NL + "\t\ttry {" + NL + "\t\t\tnewDiagramFile.refreshLocal(IResource.DEPTH_ZERO, null);" + NL + "\t\t\tString completeFileName = newDiagramFile.getLocation().toOSString();" + NL + "\t\t\tnotationModel = ResourceUtil.create(completeFileName, null);" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tIStatus status = new Status(IStatus.ERROR, ";
  protected final String TEXT_10 = ".ID, 0, e.getMessage(), e);" + NL + "\t\t\t";
  protected final String TEXT_11 = ".getInstance().getLog().log(status);" + NL + "\t\t}" + NL + "" + NL + "\t\tif (notationModel != null) {" + NL + "\t\t\tfinal Resource notationModelParam = notationModel;" + NL + "\t\t\tfinal String kindParam = kind;" + NL + "\t\t\tOperationUtil.runAsUnchecked(new MRunnable() {" + NL + "" + NL + "\t\t\t\tpublic Object run() {";
  protected final String TEXT_12 = NL + "\t\t\t\t\tEObject model = EObjectUtil.create(";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "());" + NL + "\t\t\t\t\tDiagram diagram = ViewService.createDiagram(model, kindParam, new PreferencesHint(";
  protected final String TEXT_15 = ".EDITOR_ID));" + NL + "\t\t\t\t\tif (diagram != null) {" + NL + "\t\t\t\t\t\tnotationModelParam.getContents().add(diagram);";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tnotationModelParam.getContents().add(model);";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tmodelResource.getContents().add(model);" + NL + "\t\t\t\t\t\tResourceUtil.save(modelResource);";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\tdiagram.setName(newDiagramFile.getName());" + NL + "\t\t\t\t\t\tdiagram.setElement(model);" + NL + "\t\t\t\t\t\tResourceUtil.save(notationModelParam);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "" + NL + "\t\treturn newDiagramFile;" + NL + "\t}" + NL + "}";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
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
    if (!genDiagram.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getGenPackage().getPrefix().toLowerCase());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_11);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String domainPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_12);
    stringBuffer.append(domainPackageInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_15);
    if (genDiagram.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
