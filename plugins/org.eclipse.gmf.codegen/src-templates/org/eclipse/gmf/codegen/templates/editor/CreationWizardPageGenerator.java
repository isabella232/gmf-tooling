package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.emf.codegen.ecore.genmodel.*;
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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.InputStream;" + NL + "" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.ui.IWorkbench;" + NL + "import org.eclipse.ui.IWorkbenchWindow;";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends EditorWizardPage {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "(IWorkbench workbench, IStructuredSelection selection) {" + NL + "\t\tsuper(\"CreationWizardPage\", workbench, selection); //$NON-NLS-1$" + NL + "\t\tsetTitle(\"Create ";
  protected final String TEXT_6 = " Diagram\"); //$NON-NLS-1$" + NL + "\t\tsetDescription(\"Create a new ";
  protected final String TEXT_7 = " diagram.\"); //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFile createAndOpenDiagram(IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow dWindow, IProgressMonitor progressMonitor, boolean saveDiagram) {" + NL + "\t\treturn ";
  protected final String TEXT_8 = ".createAndOpenDiagram(getDiagramFileCreator(), containerPath, fileName, initialContents, kind, dWindow, progressMonitor, isOpenNewlyCreatedDiagramEditor(), saveDiagram);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDefaultFileName() {" + NL + "\t\treturn \"default\"; //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic DiagramFileCreator getDiagramFileCreator() {" + NL + "\t\treturn ";
  protected final String TEXT_9 = ".getInstance();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDiagramKind() {" + NL + "\t\treturn \"";
  protected final String TEXT_10 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean validatePage() {" + NL + "\t\tif (super.validatePage()) {" + NL + "\t\t\tString fileName = getFileName();" + NL + "\t\t\tif (fileName == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t// appending file extension to correctly process file names including \".\" symbol" + NL + "\t\t\tIPath path = getContainerFullPath().append(getDiagramFileCreator().appendExtensionToFileName(fileName));" + NL + "\t\t\tpath = path.removeFileExtension().addFileExtension(\"";
  protected final String TEXT_12 = "\"); //$NON-NLS-1$" + NL + "\t\t\tif (";
  protected final String TEXT_13 = ".getWorkspace().getRoot().exists(path)) {" + NL + "\t\t\t\tsetErrorMessage(\"Model File already exists: \" + path.lastSegment());" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_14 = NL + "}";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEMFGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getDiagramFileCreatorClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_10);
    if (!genDiagram.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getGenPackage().getPrefix().toLowerCase());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
