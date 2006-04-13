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
  protected final String TEXT_3 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Text fileField;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI createdDiagramFileURI;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {" + NL + "\t\tsuper(\"CreationWizardPage\"); //$NON-NLS-1$" + NL + "\t\tsetTitle(\"Create ";
  protected final String TEXT_5 = " Diagram\"); //$NON-NLS-1$" + NL + "\t\tsetDescription(\"Create a new ";
  protected final String TEXT_6 = " diagram.\"); //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent)" + NL + "\t{" + NL + "\t\tComposite composite = new Composite(parent, SWT.NONE);" + NL + "\t\t{" + NL + "\t\t\tGridLayout layout = new GridLayout();" + NL + "\t\t\tlayout.numColumns = 1;" + NL + "\t\t\tlayout.verticalSpacing = 12;" + NL + "\t\t\tcomposite.setLayout(layout);" + NL + "" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.verticalAlignment = GridData.FILL;" + NL + "\t\t\tdata.grabExcessVerticalSpace = true;" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tcomposite.setLayoutData(data);" + NL + "\t\t}" + NL + "\t\tLabel resourceURILabel = new Label(composite, SWT.LEFT);" + NL + "\t\t{" + NL + "\t\t\tresourceURILabel.setText(\"&File\");" + NL + "" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tresourceURILabel.setLayoutData(data);" + NL + "\t\t}" + NL + "" + NL + "\t\tComposite fileComposite = new Composite(composite, SWT.NONE);" + NL + "\t\t{" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\tfileComposite.setLayoutData(data);" + NL + "" + NL + "\t\t\tGridLayout layout = new GridLayout();" + NL + "\t\t\tlayout.marginHeight = 0;" + NL + "\t\t\tlayout.marginWidth = 0;" + NL + "\t\t\tlayout.numColumns = 2;" + NL + "\t\t\tfileComposite.setLayout(layout);" + NL + "\t\t}" + NL + "" + NL + "\t\tfileField = new ";
  protected final String TEXT_7 = "(fileComposite, SWT.BORDER);" + NL + "\t\t{" + NL + "\t\t\tGridData data = new GridData();" + NL + "\t\t\tdata.horizontalAlignment = GridData.FILL;" + NL + "\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\tdata.horizontalSpan = 1;" + NL + "\t\t\tfileField.setLayoutData(data);" + NL + "\t\t}" + NL + "" + NL + "\t\tfileField.addModifyListener(validator);" + NL + "\t\t";
  protected final String TEXT_8 = " resourceURIBrowseFileSystemButton = new ";
  protected final String TEXT_9 = "(fileComposite, SWT.PUSH);" + NL + "\t\tresourceURIBrowseFileSystemButton.setText(\"&Browse\");" + NL + "  " + NL + "\t\tresourceURIBrowseFileSystemButton.addSelectionListener" + NL + "\t\t\t(new ";
  protected final String TEXT_10 = "() {" + NL + "\t\t\t\t public void widgetSelected(";
  protected final String TEXT_11 = " event) {" + NL + "\t\t\t\t\t String fileExtension = \"";
  protected final String TEXT_12 = "\";" + NL + "\t\t\t\t\t String filePath = ";
  protected final String TEXT_13 = ".openFilePathDialog(getShell(), \"*.\" + fileExtension, ";
  protected final String TEXT_14 = ".OPEN);" + NL + "\t\t\t\t\t if (filePath != null) {" + NL + "\t\t\t\t\t\t if (!filePath.endsWith(\".\" + fileExtension)) {" + NL + "\t\t\t\t\t\t\t filePath = filePath + \".\" + fileExtension;" + NL + "\t\t\t\t\t\t }" + NL + "\t\t\t\t\t\t fileField.setText(filePath);" + NL + "\t\t\t\t\t }" + NL + "\t\t\t\t }" + NL + "\t\t\t }); " + NL + "\t\tsetPageComplete(validatePage());" + NL + "\t\tsetControl(composite);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ModifyListener validator =" + NL + "\t\tnew ModifyListener() {" + NL + "\t\t\tpublic void modifyText(ModifyEvent e) {" + NL + "\t\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\t}" + NL + "\t\t};" + NL + " " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t protected boolean validatePage() {" + NL + "\t\tURI diagramFileURI = getDiagramFileURI();" + NL + "\t\tif (diagramFileURI == null || diagramFileURI.isEmpty()) {" + NL + "\t\t\tsetErrorMessage(null);" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tString requiredExt = \"";
  protected final String TEXT_15 = "\";" + NL + "\t\tString enteredExt = diagramFileURI.fileExtension();" + NL + "\t\tif (enteredExt == null || !enteredExt.equals(requiredExt)) {" + NL + "\t\t\tsetErrorMessage(\"The file name must end in \" + requiredExt); " + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\tif (diagramFileURI.isFile()) {" + NL + "\t\t\tFile diagramFile = new File(diagramFileURI.toFileString());" + NL + "\t\t\tif (diagramFile.exists()) {" + NL + "\t\t\t\tsetErrorMessage(\"Diagram File already exists: \" + diagramFile);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\tURI modelFileURI = getModelFileURI();" + NL + "\t\t\tFile modelFile = new File(modelFileURI.toFileString());" + NL + "\t\t\tif (modelFile.exists()) {" + NL + "\t\t\t\tsetErrorMessage(\"Model File already exists: \" + modelFile);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_17 = NL + "\t\t}" + NL + "\t\tsetErrorMessage(null); " + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic URI getCreatedDiagramFileURI() {" + NL + "\t\treturn createdDiagramFileURI;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI getDiagramFileURI() {" + NL + "\t\ttry {" + NL + "\t\t\treturn URI.createFileURI(fileField.getText());" + NL + "\t\t} catch (Exception exception) {" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_18 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI getModelFileURI() {" + NL + "\t\tURI diagramFileURI = getDiagramFileURI();" + NL + "\t\tif (diagramFileURI == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn diagramFileURI.trimFileExtension().appendFileExtension(\"";
  protected final String TEXT_19 = "\");" + NL + "\t}";
  protected final String TEXT_20 = NL + NL + "\t/**" + NL + "\t * Performs the operations necessary to create and open the diagram" + NL + "\t * @return boolean indicating whether the creation and opening the Diagram was successful " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean finish() {" + NL + "\t\tfinal boolean[] result = new boolean[1];" + NL + "\t\t";
  protected final String TEXT_21 = " op = new IRunnableWithProgress() {" + NL + "\t\t\tpublic void run(IProgressMonitor monitor) {" + NL + "\t\t\t\tresult[0] = doFinish(monitor);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tgetContainer().run(false, true, op);" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\treturn false;" + NL + "\t\t} catch (";
  protected final String TEXT_22 = " e) {" + NL + "\t\t\tif (e.getTargetException() instanceof CoreException) {" + NL + "\t\t\t\t";
  protected final String TEXT_23 = ".openError(" + NL + "\t\t\t\t\tgetContainer().getShell()," + NL + "\t\t\t\t\t\"Creation Problems\"," + NL + "\t\t\t\t\tnull,\t// no special message" + NL + "\t\t\t\t\t((CoreException) e.getTargetException()).getStatus());" + NL + "\t\t\t}" + NL + "\t\t\telse {" + NL + "\t\t\t\t// CoreExceptions are handled above, but unexpected runtime exceptions and errors may still occur." + NL + "\t\t\t\t";
  protected final String TEXT_24 = ".getInstance().getLog().log(new ";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ".ERROR, ";
  protected final String TEXT_27 = ".ID, 0, \"Creation failed\", e.getTargetException()));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn result[0];" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @param monitor the <code>IProgressMonitor</code> to use to indicate progress and check for cancellation" + NL + "\t * @return boolean indicating whether the diagram was created and opened successfully" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean doFinish(IProgressMonitor monitor) {" + NL + "\t\tcreatedDiagramFileURI = createDiagramFile(monitor);" + NL + "\t\treturn createdDiagramFileURI != null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI createDiagramFile(IProgressMonitor monitor) {" + NL + "\t\t//TODO: Editing domain!" + NL + "\t\t";
  protected final String TEXT_28 = " resourceSet = new ";
  protected final String TEXT_29 = "();" + NL + "\t\tfinal ";
  protected final String TEXT_30 = " diagramResource = resourceSet.createResource(getDiagramFileURI());";
  protected final String TEXT_31 = NL + "\t\tfinal Resource modelResource = resourceSet.createResource(getModelFileURI());";
  protected final String TEXT_32 = NL + NL + "\t\tif (diagramResource != null";
  protected final String TEXT_33 = " && modelResource != null";
  protected final String TEXT_34 = ") {" + NL + "\t\t\t//TODO: Editing domain!" + NL + "\t\t\t";
  protected final String TEXT_35 = " model = ";
  protected final String TEXT_36 = ".eINSTANCE.create";
  protected final String TEXT_37 = "();";
  protected final String TEXT_38 = NL + "\t\t\tmodelResource.getContents().add(model);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tmodelResource.save(";
  protected final String TEXT_39 = ".EMPTY_MAP);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\thandleSaveException(e);" + NL + "\t\t\t}";
  protected final String TEXT_40 = NL + "\t\t\tdiagramResource.getContents().add(model);";
  protected final String TEXT_41 = NL + "\t\t\t";
  protected final String TEXT_42 = " diagram = ";
  protected final String TEXT_43 = ".eINSTANCE.createDiagram();" + NL + "\t\t\tdiagram.setElement(model);" + NL + "\t\t\t";
  protected final String TEXT_44 = ".decorateView(diagram);" + NL + "\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\thandleSaveException(e);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean result = ";
  protected final String TEXT_45 = ".openEditor(getDiagramFileURI());" + NL + "\t\tif (!result) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getDiagramFileURI();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void handleSaveException(IOException e) {" + NL + "\t\tthrow new RuntimeException(e);" + NL + "\t}" + NL + "}";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final GenPlugin genPlugin = editorGen.getPlugin();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

importManager.addImport("java.io.File");
importManager.addImport("org.eclipse.core.runtime.IProgressMonitor");
importManager.addImport("org.eclipse.core.runtime.CoreException");
importManager.addImport("java.io.IOException");
importManager.addImport("org.eclipse.swt.widgets.Text");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("org.eclipse.swt.widgets.Composite");
importManager.addImport("org.eclipse.swt.widgets.Label");
importManager.addImport("org.eclipse.swt.events.ModifyListener");
importManager.addImport("org.eclipse.swt.events.ModifyEvent");
importManager.addImport("org.eclipse.swt.layout.GridLayout");
importManager.addImport("org.eclipse.swt.layout.GridData");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardPage"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getCreationWizardPageClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(editorGen.getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(editorGen.getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Text"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionAdapter"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionEvent"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_15);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    if (!editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.operation.IRunnableWithProgress"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.lang.reflect.InvocationTargetException"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_30);
    
final boolean standaloneDomainModel = !editorGen.isSameFileForDiagramAndModel() && genDiagram.getDomainDiagramElement() != null;
if (standaloneDomainModel) {

    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedFactoryClassName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_37);
    
if (standaloneDomainModel) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_39);
    
} else {

    stringBuffer.append(TEXT_40);
    
}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_45);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
