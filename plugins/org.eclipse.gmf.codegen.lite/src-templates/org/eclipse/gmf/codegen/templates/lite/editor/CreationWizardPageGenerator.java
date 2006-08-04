package org.eclipse.gmf.codegen.templates.lite.editor;

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
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Text fileField;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI createdDiagramFileURI;";
  protected final String TEXT_5 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_6 = " createdDiagramFile;";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_8 = NL + "\tpublic ";
  protected final String TEXT_9 = "() {" + NL + "\t\tsuper(\"CreationWizardPage\"); //$NON-NLS-1$";
  protected final String TEXT_10 = NL + "\tpublic ";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = " selection) {" + NL + "\t\tsuper(\"CreationWizardPage\", selection);\t//$NON-NLS-1$";
  protected final String TEXT_13 = NL + "\t\tsetTitle(\"Create ";
  protected final String TEXT_14 = " Diagram\"); //$NON-NLS-1$" + NL + "\t\tsetDescription(\"Create a new ";
  protected final String TEXT_15 = " diagram.\"); //$NON-NLS-1$" + NL + "\t}" + NL;
  protected final String TEXT_16 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent)" + NL + "\t{" + NL + "\t\tComposite composite = new Composite(parent, SWT.NONE);" + NL + "\t\t{" + NL + "\t\t\tGridLayout layout = new GridLayout();" + NL + "\t\t\tlayout.numColumns = 1;" + NL + "\t\t\tlayout.verticalSpacing = 12;" + NL + "\t\t\tcomposite.setLayout(layout);" + NL + "" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.verticalAlignment = GridData.FILL;" + NL + "\t\t\tdata.grabExcessVerticalSpace = true;" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tcomposite.setLayoutData(data);" + NL + "\t\t}" + NL + "\t\tLabel resourceURILabel = new Label(composite, SWT.LEFT);" + NL + "\t\t{" + NL + "\t\t\tresourceURILabel.setText(\"&File\");" + NL + "" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tresourceURILabel.setLayoutData(data);" + NL + "\t\t}" + NL + "" + NL + "\t\tComposite fileComposite = new Composite(composite, SWT.NONE);" + NL + "\t\t{" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\tfileComposite.setLayoutData(data);" + NL + "" + NL + "\t\t\tGridLayout layout = new GridLayout();" + NL + "\t\t\tlayout.marginHeight = 0;" + NL + "\t\t\tlayout.marginWidth = 0;" + NL + "\t\t\tlayout.numColumns = 2;" + NL + "\t\t\tfileComposite.setLayout(layout);" + NL + "\t\t}" + NL + "" + NL + "\t\tfileField = new ";
  protected final String TEXT_17 = "(fileComposite, SWT.BORDER);" + NL + "\t\t{" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\tdata.horizontalSpan = 1;" + NL + "\t\t\tfileField.setLayoutData(data);" + NL + "\t\t}" + NL + "" + NL + "\t\tfileField.addModifyListener(validator);" + NL + "\t\t";
  protected final String TEXT_18 = " resourceURIBrowseFileSystemButton = new ";
  protected final String TEXT_19 = "(fileComposite, SWT.PUSH);" + NL + "\t\tresourceURIBrowseFileSystemButton.setText(\"&Browse\");" + NL + "  " + NL + "\t\tresourceURIBrowseFileSystemButton.addSelectionListener" + NL + "\t\t\t(new ";
  protected final String TEXT_20 = "() {" + NL + "\t\t\t\t public void widgetSelected(";
  protected final String TEXT_21 = " event) {" + NL + "\t\t\t\t\t String fileExtension = \"";
  protected final String TEXT_22 = "\";" + NL + "\t\t\t\t\t String filePath = ";
  protected final String TEXT_23 = ".openFilePathDialog(getShell(), \"*.\" + fileExtension, ";
  protected final String TEXT_24 = ".OPEN);" + NL + "\t\t\t\t\t if (filePath != null) {" + NL + "\t\t\t\t\t\t if (!filePath.endsWith(\".\" + fileExtension)) {" + NL + "\t\t\t\t\t\t\t filePath = filePath + \".\" + fileExtension;" + NL + "\t\t\t\t\t\t }" + NL + "\t\t\t\t\t\t fileField.setText(filePath);" + NL + "\t\t\t\t\t }" + NL + "\t\t\t\t }" + NL + "\t\t\t }); " + NL + "\t\tsetPageComplete(validatePage());" + NL + "\t\tsetControl(composite);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ModifyListener validator =" + NL + "\t\tnew ModifyListener() {" + NL + "\t\t\tpublic void modifyText(ModifyEvent e) {" + NL + "\t\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\t}" + NL + "\t\t};" + NL;
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t protected boolean validatePage() {";
  protected final String TEXT_26 = NL + "\t\tURI diagramFileURI = getDiagramFileURI();" + NL + "\t\tif (diagramFileURI == null || diagramFileURI.isEmpty()) {" + NL + "\t\t\tsetErrorMessage(null);" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\tif (diagramFileURI.isFile()) {" + NL + "\t\t\tFile diagramFile = new File(diagramFileURI.toFileString());" + NL + "\t\t\tif (diagramFile.exists()) {" + NL + "\t\t\t\tsetErrorMessage(\"Diagram File already exists: \" + diagramFile);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t\tif (!super.validatePage()) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tString fileName = getFileName();" + NL + "" + NL + "\t\tif (fileName == null) {" + NL + "\t\t\tsetErrorMessage(null);" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_28 = " path = getContainerFullPath().append(fileName);" + NL + "\t\tif (path.getFileExtension() == null) {" + NL + "\t\t\tpath = path.addFileExtension(\"";
  protected final String TEXT_29 = "\");\t//$NON-NLS-1$" + NL + "\t\t}" + NL + "" + NL + "\t\tif (";
  protected final String TEXT_30 = ".getWorkspace().getRoot().exists(path)) {" + NL + "\t\t\tsetErrorMessage(\"Diagram File already exists: \" + path.toOSString());" + NL + "\t\t\treturn false;" + NL + "\t\t}";
  protected final String TEXT_31 = NL + "\t\tString requiredExt = \"";
  protected final String TEXT_32 = "\";";
  protected final String TEXT_33 = NL + "\t\tString enteredExt = diagramFileURI.fileExtension();";
  protected final String TEXT_34 = NL + "\t\tString enteredExt = path.getFileExtension();";
  protected final String TEXT_35 = NL + "\t\tif (enteredExt == null || !enteredExt.equals(requiredExt)) {" + NL + "\t\t\tsetErrorMessage(\"The file name must end in \" + requiredExt); " + NL + "\t\t\treturn false;" + NL + "\t\t}";
  protected final String TEXT_36 = NL + "\t\t\tURI modelFileURI = getModelFileURI();" + NL + "\t\t\tFile modelFile = new File(modelFileURI.toFileString());" + NL + "\t\t\tif (modelFile.exists()) {" + NL + "\t\t\t\tsetErrorMessage(\"Model File already exists: \" + modelFile);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_37 = NL + "\t\t\tpath = path.removeFileExtension().addFileExtension(\"";
  protected final String TEXT_38 = "\"); //$NON-NLS-1$" + NL + "\t\t\tif (";
  protected final String TEXT_39 = ".getWorkspace().getRoot().exists(path)) {" + NL + "\t\t\t\tsetErrorMessage(\"Model File already exists: \" + path.lastSegment());" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_40 = NL + "\t\tsetErrorMessage(null);" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_41 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic URI getCreatedDiagramFileURI() {" + NL + "\t\treturn createdDiagramFileURI;" + NL + "\t}";
  protected final String TEXT_42 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFile getCreatedDiagramFile() {" + NL + "\t\treturn createdDiagramFile;" + NL + "\t}";
  protected final String TEXT_43 = NL;
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI getDiagramFileURI() {" + NL + "\t\ttry {" + NL + "\t\t\treturn URI.createFileURI(fileField.getText());" + NL + "\t\t} catch (Exception exception) {" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_45 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI getModelFileURI() {" + NL + "\t\tURI diagramFileURI = getDiagramFileURI();" + NL + "\t\tif (diagramFileURI == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn diagramFileURI.trimFileExtension().appendFileExtension(\"";
  protected final String TEXT_46 = "\");" + NL + "\t}";
  protected final String TEXT_47 = NL + NL + "\t/**" + NL + "\t * Performs the operations necessary to create and open the diagram" + NL + "\t * @return boolean indicating whether the creation and opening the Diagram was successful " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean finish() {" + NL + "\t\tfinal boolean[] result = new boolean[1];";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = " op = new IRunnableWithProgress() {" + NL + "\t\t\tpublic void run(IProgressMonitor monitor) {";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = " op = new WorkspaceModifyOperation(null) {" + NL + "\t\t\tprotected void execute(IProgressMonitor monitor) {";
  protected final String TEXT_52 = NL + "\t\t\t\tresult[0] = doFinish(monitor);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tgetContainer().run(false, true, op);" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\treturn false;" + NL + "\t\t} catch (";
  protected final String TEXT_53 = " e) {" + NL + "\t\t\tif (e.getTargetException() instanceof CoreException) {" + NL + "\t\t\t\t";
  protected final String TEXT_54 = ".openError(" + NL + "\t\t\t\t\tgetContainer().getShell()," + NL + "\t\t\t\t\t\"Creation Problems\"," + NL + "\t\t\t\t\tnull,\t// no special message" + NL + "\t\t\t\t\t((CoreException) e.getTargetException()).getStatus());" + NL + "\t\t\t}" + NL + "\t\t\telse {" + NL + "\t\t\t\t// CoreExceptions are handled above, but unexpected runtime exceptions and errors may still occur." + NL + "\t\t\t\t";
  protected final String TEXT_55 = ".getInstance().getLog().log(new ";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = ".ERROR, ";
  protected final String TEXT_58 = ".ID, 0, \"Creation failed\", e.getTargetException()));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn result[0];" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @param monitor the <code>IProgressMonitor</code> to use to indicate progress and check for cancellation" + NL + "\t * @return boolean indicating whether the diagram was created and opened successfully" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean doFinish(IProgressMonitor monitor) {";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = " = createDiagramFile(monitor);" + NL + "\t\treturn ";
  protected final String TEXT_61 = " != null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_62 = NL + "\tprivate URI createDiagramFile(IProgressMonitor monitor) {";
  protected final String TEXT_63 = NL + "\tprivate IFile createDiagramFile(IProgressMonitor monitor) {";
  protected final String TEXT_64 = NL + "\t\t//TODO: Editing domain!" + NL + "\t\t";
  protected final String TEXT_65 = " resourceSet = new ";
  protected final String TEXT_66 = "();";
  protected final String TEXT_67 = NL + "\t\tfinal ";
  protected final String TEXT_68 = " diagramResource = resourceSet.createResource(getDiagramFileURI());";
  protected final String TEXT_69 = NL + "\t\tIPath diagramFilePath = getContainerFullPath().append(getFileName());" + NL + "\t\tif (diagramFilePath.getFileExtension() == null) {" + NL + "\t\t\tdiagramFilePath = diagramFilePath.addFileExtension(\"";
  protected final String TEXT_70 = "\");\t\t//$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\tfinal IFile diagramFile = ResourcesPlugin.getWorkspace().getRoot().getFile(diagramFilePath);" + NL + "\t\tfinal ";
  protected final String TEXT_71 = " diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFilePath.toString()));";
  protected final String TEXT_72 = NL + "\t\tfinal Resource modelResource = resourceSet.createResource(getModelFileURI());";
  protected final String TEXT_73 = NL + "\t\tIPath modelFilePath = diagramFilePath.removeFileExtension().addFileExtension(\"";
  protected final String TEXT_74 = "\"); //$NON-NLS-1$" + NL + "\t\tfinal Resource modelResource = resourceSet.createResource(URI.createPlatformResourceURI(modelFilePath.toString()));";
  protected final String TEXT_75 = NL + NL + "\t\tif (diagramResource != null";
  protected final String TEXT_76 = " && modelResource != null";
  protected final String TEXT_77 = ") {" + NL + "\t\t\t//TODO: Editing domain!" + NL + "\t\t\t";
  protected final String TEXT_78 = " model = ";
  protected final String TEXT_79 = ".eINSTANCE.create";
  protected final String TEXT_80 = "();";
  protected final String TEXT_81 = NL + "\t\t\tmodelResource.getContents().add(model);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tmodelResource.save(";
  protected final String TEXT_82 = ".EMPTY_MAP);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\thandleSaveException(e);" + NL + "\t\t\t}";
  protected final String TEXT_83 = NL + "\t\t\tdiagramResource.getContents().add(model);";
  protected final String TEXT_84 = NL + "\t\t\t";
  protected final String TEXT_85 = " diagram = ";
  protected final String TEXT_86 = ".eINSTANCE.createDiagram();" + NL + "\t\t\tdiagram.setElement(";
  protected final String TEXT_87 = "(";
  protected final String TEXT_88 = ") ";
  protected final String TEXT_89 = "model);" + NL + "\t\t\t";
  protected final String TEXT_90 = ".decorateView(diagram);" + NL + "\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\thandleSaveException(e);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_91 = NL + "\t\tboolean result = ";
  protected final String TEXT_92 = ".openEditor(getDiagramFileURI());" + NL + "\t\tif (!result) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getDiagramFileURI();";
  protected final String TEXT_93 = NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_94 = ".openEditor(";
  protected final String TEXT_95 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage(), diagramFile);" + NL + "\t\t} catch (";
  protected final String TEXT_96 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_97 = ".getInstance().getLog().log(e.getStatus());" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn diagramFile;";
  protected final String TEXT_98 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void handleSaveException(IOException e) {" + NL + "\t\tthrow new RuntimeException(e);" + NL + "\t}" + NL + "}";
  protected final String TEXT_99 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final GenPlugin genPlugin = editorGen.getPlugin();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final boolean isRichClientPlatform = genDiagram.getEditorGen().getDomainGenModel().isRichClientPlatform();

importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

importManager.addImport("org.eclipse.core.runtime.IProgressMonitor");
importManager.addImport("org.eclipse.core.runtime.CoreException");
importManager.addImport("java.io.IOException");
importManager.addImport("org.eclipse.emf.common.util.URI");
if (isRichClientPlatform) {
importManager.addImport("java.io.File");
importManager.addImport("org.eclipse.swt.widgets.Composite");
importManager.addImport("org.eclipse.swt.widgets.Label");
importManager.addImport("org.eclipse.swt.widgets.Text");
importManager.addImport("org.eclipse.swt.events.ModifyListener");
importManager.addImport("org.eclipse.swt.events.ModifyEvent");
importManager.addImport("org.eclipse.swt.layout.GridLayout");
importManager.addImport("org.eclipse.swt.layout.GridData");
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getImportedName(isRichClientPlatform ? "org.eclipse.jface.wizard.WizardPage" : "org.eclipse.ui.dialogs.WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_3);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_4);
    
} else {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_9);
    
} else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(editorGen.getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(editorGen.getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_15);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Text"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionAdapter"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionEvent"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_26);
    
} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_30);
    
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_32);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_33);
    
} else {

    stringBuffer.append(TEXT_34);
    
}

    stringBuffer.append(TEXT_35);
    
if (!editorGen.isSameFileForDiagramAndModel()) {
	if (isRichClientPlatform) {

    stringBuffer.append(TEXT_36);
    
	} else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_39);
    
	}
}

    stringBuffer.append(TEXT_40);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_41);
    
} else {

    stringBuffer.append(TEXT_42);
    
}

    stringBuffer.append(TEXT_43);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_44);
    
	if (!editorGen.isSameFileForDiagramAndModel()) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_46);
    
	}
}

    stringBuffer.append(TEXT_47);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.operation.IRunnableWithProgress"));
    stringBuffer.append(TEXT_49);
    
} else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.WorkspaceModifyOperation"));
    stringBuffer.append(TEXT_51);
    
}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("java.lang.reflect.InvocationTargetException"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_58);
    
String createdVar = isRichClientPlatform ? "createdDiagramFileURI" : "createdDiagramFile";

    stringBuffer.append(TEXT_59);
    stringBuffer.append(createdVar);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(createdVar);
    stringBuffer.append(TEXT_61);
    if (isRichClientPlatform) {
    stringBuffer.append(TEXT_62);
    } else {
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_66);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_68);
    
} else {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_71);
    
}

    
final boolean standaloneDomainModel = !editorGen.isSameFileForDiagramAndModel() && genDiagram.getDomainDiagramElement() != null;
if (standaloneDomainModel) {
	if (isRichClientPlatform) {

    stringBuffer.append(TEXT_72);
    
	} else {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_74);
    
	}
}

    stringBuffer.append(TEXT_75);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedFactoryClassName()));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_80);
    
if (standaloneDomainModel) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_82);
    
} else {

    stringBuffer.append(TEXT_83);
    
}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_86);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_92);
    
} else {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ide.IDE"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_97);
    
}

    stringBuffer.append(TEXT_98);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_99);
    return stringBuffer.toString();
  }
}
