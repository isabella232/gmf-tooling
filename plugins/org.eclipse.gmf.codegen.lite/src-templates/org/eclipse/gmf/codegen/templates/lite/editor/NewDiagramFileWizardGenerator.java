package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.common.codegen.*;

public class NewDiagramFileWizardGenerator
{
  protected static String nl;
  public static synchronized NewDiagramFileWizardGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewDiagramFileWizardGenerator result = new NewDiagramFileWizardGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " myEditingDomain;" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_9 = " mySelectedModelFileURI;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate DiagramURISelectorPage myDiagramURISelectorPage;" + NL;
  protected final String TEXT_10 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_11 = " mySelectedModelFile;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_12 = " myFileCreationPage;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_13 = " myWorkbenchPage;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_14 = " mySelection;" + NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_16 = " myDiagramRoot;" + NL;
  protected final String TEXT_17 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = " selectedModelFileURI, ";
  protected final String TEXT_20 = " diagramRoot, ";
  protected final String TEXT_21 = " editingDomain) {";
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = " selectedModelFile, ";
  protected final String TEXT_25 = " workbenchPage, ";
  protected final String TEXT_26 = " selection, ";
  protected final String TEXT_27 = " diagramRoot, ";
  protected final String TEXT_28 = " editingDomain) {" + NL + "\t\tassert selectedModelFile != null : \"Null selectedModelFile in ";
  protected final String TEXT_29 = " constructor\"; //$NON-NLS-1$" + NL + "\t\tassert workbenchPage != null : \"Null workbenchPage in ";
  protected final String TEXT_30 = " constructor\"; //$NON-NLS-1$" + NL + "\t\tassert selection != null : \"Null selection in ";
  protected final String TEXT_31 = " constructor\"; //$NON-NLS-1$" + NL + "\t    assert diagramRoot != null : \"Null diagramRoot in ";
  protected final String TEXT_32 = " constructor\"; //$NON-NLS-1$";
  protected final String TEXT_33 = NL + "\t    assert editingDomain != null : \"Null editingDomain in ";
  protected final String TEXT_34 = " constructor\"; //$NON-NLS-1$" + NL + "\t    ";
  protected final String TEXT_35 = NL + "\t   \tmySelectedModelFileURI = selectedModelFileURI;";
  protected final String TEXT_36 = NL + "\t   \tmySelectedModelFile = selectedModelFile;" + NL + "\t   \tmyWorkbenchPage = workbenchPage;" + NL + "\t   \tmySelection = selection;";
  protected final String TEXT_37 = NL + "\t   \tmyDiagramRoot = diagramRoot;" + NL + "\t   \tmyEditingDomain = editingDomain;" + NL + "\t\tsetDefaultPageImageDescriptor(";
  protected final String TEXT_38 = ".getBundledImageDescriptor(" + NL + "\t\t\t\"icons/wizban/New";
  protected final String TEXT_39 = "Wizard.gif\")); //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addPages() {";
  protected final String TEXT_40 = NL + "\t\tif (mySelectedModelFileURI == null) {" + NL + "\t\t\taddPage(new SourceURISelectorPage());" + NL + "\t\t}" + NL + "\t\tmyDiagramURISelectorPage = new DiagramURISelectorPage();" + NL + "\t\taddPage(myDiagramURISelectorPage);";
  protected final String TEXT_41 = NL + "\t\tmyFileCreationPage = new ";
  protected final String TEXT_42 = "(\"Initialize new ";
  protected final String TEXT_43 = " diagram file\", mySelection) {" + NL + "\t\t\tpublic void createControl(";
  protected final String TEXT_44 = " parent) {" + NL + "\t\t\t\tsuper.createControl(parent);" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_45 = " parentContainer = mySelectedModelFile.getParent();" + NL + "\t\t\t\tString originalFileName = mySelectedModelFile.getProjectRelativePath().removeFileExtension().lastSegment();" + NL + "\t\t\t\tString fileExtension = \".";
  protected final String TEXT_46 = "\"; //$NON-NLS-1$" + NL + "\t\t\t\tString fileName = originalFileName + fileExtension;" + NL + "\t\t\t\tfor (int i = 1; i > 0 && parentContainer.getFile(new ";
  protected final String TEXT_47 = "(fileName)).exists(); i++) {" + NL + "\t\t\t\t\tfileName = originalFileName + i + fileExtension;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (parentContainer.getFile(new ";
  protected final String TEXT_48 = "(fileName)).exists()) {" + NL + "\t\t\t\t\treturn;\t//failed to set name that does not exist, just leave empty." + NL + "\t\t\t\t}" + NL + "\t\t\t\tsetFileName(fileName);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tmyFileCreationPage.setTitle(\"Diagram file\");" + NL + "\t\tmyFileCreationPage.setDescription(\"Create new diagram based on ";
  protected final String TEXT_49 = " model content\");" + NL + "\t\taddPage(myFileCreationPage);";
  protected final String TEXT_50 = NL + "\t\taddPage(new RootElementSelectorPage());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean performFinish() {" + NL + "\t\t";
  protected final String TEXT_51 = " resourceSet = myEditingDomain.getResourceSet();";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = " diagramFileURI = myDiagramURISelectorPage.getNewFileURI();";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = " diagramFile = myFileCreationPage.createNewFile();" + NL + "\t\t";
  protected final String TEXT_56 = ".setCharset(diagramFile);" + NL + "\t\t";
  protected final String TEXT_57 = " diagramFileURI = ";
  protected final String TEXT_58 = ".createPlatformResourceURI(diagramFile.getFullPath().toString(), true);";
  protected final String TEXT_59 = NL + "\t\tfinal ";
  protected final String TEXT_60 = " diagramResource = resourceSet.createResource(diagramFileURI);" + NL + "\t\t";
  protected final String TEXT_61 = " command = new ";
  protected final String TEXT_62 = "(\"Initializing diagram contents\") { //$NON-NLS-1$" + NL + "\t\t\tprivate ";
  protected final String TEXT_63 = " myCreatedDiagram;" + NL + "" + NL + "\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\tint diagramVID = ";
  protected final String TEXT_64 = ".INSTANCE.getDiagramVisualID(myDiagramRoot);" + NL + "\t\t\t\tif (diagramVID != ";
  protected final String TEXT_65 = ".VISUAL_ID) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\tpublic void execute() {" + NL + "\t\t\t\tmyCreatedDiagram = ";
  protected final String TEXT_66 = ".createDiagramFor(myDiagramRoot);" + NL + "\t\t\t\tassert myCreatedDiagram != null;" + NL + "\t\t\t\tdiagramResource.getContents().add(myCreatedDiagram);";
  protected final String TEXT_67 = NL + "\t\t\t\tdiagramResource.getContents().add(myCreatedDiagram.getElement());";
  protected final String TEXT_68 = NL + "\t\t\t}" + NL + "\t\t\tpublic void redo() {" + NL + "\t\t\t\texecute();" + NL + "\t\t\t}" + NL + "\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\ttry {" + NL + "\t\t\tnew ";
  protected final String TEXT_69 = "(myEditingDomain, command).execute();" + NL + "\t\t\tdiagramResource.save(";
  protected final String TEXT_70 = ".getSaveOptions());";
  protected final String TEXT_71 = NL + "\t\t\t";
  protected final String TEXT_72 = " editor = ";
  protected final String TEXT_73 = ".showView(diagramFileURI);";
  protected final String TEXT_74 = NL + "\t\t\t";
  protected final String TEXT_75 = " editor = ";
  protected final String TEXT_76 = ".openEditor(diagramFileURI);";
  protected final String TEXT_77 = NL + "\t\t\t";
  protected final String TEXT_78 = " editor = ";
  protected final String TEXT_79 = ".openEditor(myWorkbenchPage, diagramFile);";
  protected final String TEXT_80 = NL + "\t\t\tif (editor != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_81 = " layouter = (";
  protected final String TEXT_82 = ") editor.getAdapter(";
  protected final String TEXT_83 = ".class);" + NL + "\t\t\t\tif (layouter != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = " graphicalViewer = (";
  protected final String TEXT_85 = ") editor.getAdapter(";
  protected final String TEXT_86 = ".class);" + NL + "\t\t\t\t\tif (graphicalViewer != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = " layoutCommand = layouter.layout((";
  protected final String TEXT_88 = ") graphicalViewer.getContents());" + NL + "\t\t\t\t\t\tif (layoutCommand != null && layoutCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tgraphicalViewer.getEditDomain().getCommandStack().execute(new ";
  protected final String TEXT_89 = "(myEditingDomain, layoutCommand));";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t\tdiagramResource.save(";
  protected final String TEXT_91 = ".getSaveOptions());";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} catch (";
  protected final String TEXT_93 = " ex) {";
  protected final String TEXT_94 = NL + "\t\t\t";
  protected final String TEXT_95 = ".getInstance().logError(\"Save operation failed for: \" + diagramFileURI.toString(), ex); //$NON-NLS-1$";
  protected final String TEXT_96 = NL + "\t\t\t";
  protected final String TEXT_97 = ".getInstance().logError(\"Save operation failed for: \" + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$";
  protected final String TEXT_98 = NL + "\t\t} catch (";
  protected final String TEXT_99 = " ex) {" + NL + "\t\t\t";
  protected final String TEXT_100 = ".getInstance().logError(\"Unable to open editor\", ex); //$NON-NLS-1$";
  protected final String TEXT_101 = NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_102 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate abstract class URISelectorPage extends ";
  protected final String TEXT_103 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_104 = " fileField;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected URISelectorPage(String name) {" + NL + "\t\t\tsuper(name);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void createControl(";
  protected final String TEXT_105 = " parent) {" + NL + "\t\t\t";
  protected final String TEXT_106 = " composite = new ";
  protected final String TEXT_107 = "(parent, ";
  protected final String TEXT_108 = ".NONE);" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_109 = " layout = new ";
  protected final String TEXT_110 = "();" + NL + "\t\t\t\tlayout.numColumns = 1;" + NL + "\t\t\t\tlayout.verticalSpacing = 12;" + NL + "\t\t\t\tcomposite.setLayout(layout);" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_111 = " data = new ";
  protected final String TEXT_112 = "();" + NL + "\t\t\t\tdata.verticalAlignment = ";
  protected final String TEXT_113 = ".FILL;" + NL + "\t\t\t\tdata.grabExcessVerticalSpace = true;" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_114 = ".FILL;" + NL + "\t\t\t\tcomposite.setLayoutData(data);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_115 = " resourceURILabel = new ";
  protected final String TEXT_116 = "(composite, ";
  protected final String TEXT_117 = ".LEFT);" + NL + "\t\t\t{" + NL + "\t\t\t\tresourceURILabel.setText(\"&File\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_118 = " data = new ";
  protected final String TEXT_119 = "();" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_120 = ".FILL;" + NL + "\t\t\t\tresourceURILabel.setLayoutData(data);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_121 = " fileComposite = new ";
  protected final String TEXT_122 = "(composite, ";
  protected final String TEXT_123 = ".NONE);" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_124 = " data = new ";
  protected final String TEXT_125 = "();" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_126 = ".FILL;" + NL + "\t\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\t\tfileComposite.setLayoutData(data);" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_127 = " layout = new ";
  protected final String TEXT_128 = "();" + NL + "\t\t\t\tlayout.marginHeight = 0;" + NL + "\t\t\t\tlayout.marginWidth = 0;" + NL + "\t\t\t\tlayout.numColumns = 2;" + NL + "\t\t\t\tfileComposite.setLayout(layout);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfileField = new ";
  protected final String TEXT_129 = "(fileComposite, ";
  protected final String TEXT_130 = ".BORDER);" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_131 = " data = new ";
  protected final String TEXT_132 = "();" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_133 = ".FILL;" + NL + "\t\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\t\tdata.horizontalSpan = 1;" + NL + "\t\t\t\tfileField.setLayoutData(data);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfileField.addModifyListener(validator);" + NL + "\t\t\t";
  protected final String TEXT_134 = " resourceURIBrowseFileSystemButton = new ";
  protected final String TEXT_135 = "(fileComposite," + NL + "\t\t\t\t\t";
  protected final String TEXT_136 = ".PUSH);" + NL + "\t\t\tresourceURIBrowseFileSystemButton.setText(\"&Browse\");" + NL + "" + NL + "\t\t\tresourceURIBrowseFileSystemButton" + NL + "\t\t\t\t\t.addSelectionListener(new ";
  protected final String TEXT_137 = "() {" + NL + "\t\t\t\t\t\tpublic void widgetSelected(";
  protected final String TEXT_138 = " event) {" + NL + "\t\t\t\t\t\t\tString fileExtension = getFileExtension();" + NL + "\t\t\t\t\t\t\tString filePath = ";
  protected final String TEXT_139 = ".openFilePathDialog(getShell(), \"*.\" + fileExtension, ";
  protected final String TEXT_140 = ".OPEN);" + NL + "\t\t\t\t\t\t\tif (filePath != null) {" + NL + "\t\t\t\t\t\t\t\tif (!filePath.endsWith(\".\" + fileExtension)) {" + NL + "\t\t\t\t\t\t\t\t\tfilePath = filePath + \".\" + fileExtension;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tfileField.setText(filePath);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t});" + NL + "\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\tsetControl(composite);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_141 = " validator = new ";
  protected final String TEXT_142 = "() {" + NL + "\t\t\tpublic void modifyText(";
  protected final String TEXT_143 = " e) {" + NL + "\t\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected final void setFile(";
  protected final String TEXT_144 = " file) {" + NL + "\t\t\tfileField.setText(file.getPath());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean validatePage() {" + NL + "\t\t\t";
  protected final String TEXT_145 = " fileURI = getFileURI();" + NL + "\t\t\tif (fileURI == null || fileURI.isEmpty()) {" + NL + "\t\t\t\tsetErrorMessage(null);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tif (fileURI.isFile()) {" + NL + "\t\t\t\t";
  protected final String TEXT_146 = " file = new ";
  protected final String TEXT_147 = "(fileURI.toFileString());" + NL + "\t\t\t\tString fileProblem = validateFile(file);" + NL + "\t\t\t\tif (fileProblem != null) {" + NL + "\t\t\t\t\tsetErrorMessage(fileProblem);" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tString requiredExt = getFileExtension();" + NL + "\t\t\tString enteredExt = fileURI.fileExtension();" + NL + "\t\t\tif (enteredExt == null || !enteredExt.equals(requiredExt)) {" + NL + "\t\t\t\tsetErrorMessage(\"The file name must end in \" + requiredExt);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tsetErrorMessage(null);" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Checks the given file and returns the error message if there are problems or <code>null</code> if the file is OK." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract String validateFile(";
  protected final String TEXT_148 = " file);" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract String getFileExtension();" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_149 = " getFileURI() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_150 = ".createFileURI(fileField.getText());" + NL + "\t\t\t} catch (Exception exception) {" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate class SourceURISelectorPage extends URISelectorPage {" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic SourceURISelectorPage() {" + NL + "\t\t\tsuper(\"Select source file\");" + NL + "\t\t\tsetTitle(\"Source file\");" + NL + "\t\t\tsetDescription(\"Select file with semantic model element to be depicted on diagram\");" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getFileExtension() {" + NL + "\t\t\treturn \"";
  protected final String TEXT_151 = "\";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean validatePage() {" + NL + "\t\t\tif (super.validatePage()) {" + NL + "\t\t\t\tmySelectedModelFileURI = getFileURI();" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String validateFile(";
  protected final String TEXT_152 = " file) {" + NL + "\t\t\tif (!file.exists()) {" + NL + "\t\t\t\treturn \"Source file does not exist\";" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate class DiagramURISelectorPage extends URISelectorPage {" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_153 = " myNewFileURI;" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic DiagramURISelectorPage() {" + NL + "\t\t\tsuper(\"Initialize new ";
  protected final String TEXT_154 = " diagram file\");" + NL + "\t\t\tsetTitle(\"Diagram file\");" + NL + "\t\t\tsetDescription(\"Create new diagram based on ";
  protected final String TEXT_155 = " model content\");" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getFileExtension() {" + NL + "\t\t\treturn \"";
  protected final String TEXT_156 = "\";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setVisible(boolean visible) {" + NL + "\t\t\tsuper.setVisible(visible);" + NL + "\t\t\tif (visible && mySelectedModelFileURI != null && getFileURI() == null && mySelectedModelFileURI.isFile()) {" + NL + "\t\t\t\t";
  protected final String TEXT_157 = " originalFile = new ";
  protected final String TEXT_158 = "(mySelectedModelFileURI.toFileString());" + NL + "\t\t\t\tString originalFileName = mySelectedModelFileURI.trimFileExtension().lastSegment();" + NL + "\t\t\t\t";
  protected final String TEXT_159 = " parentFile = originalFile.getParentFile();" + NL + "\t\t\t\t";
  protected final String TEXT_160 = " newFile = new ";
  protected final String TEXT_161 = "(parentFile, originalFileName + getFileExtension());" + NL + "\t\t\t\tfor(int i = 1; i > 0 && newFile.exists(); i++) {" + NL + "\t\t\t\t\tnewFile = new ";
  protected final String TEXT_162 = "(parentFile, originalFileName + i + getFileExtension());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (newFile.exists()) {" + NL + "\t\t\t\t\treturn;\t//failed to set name that does not exist, just leave empty." + NL + "\t\t\t\t}" + NL + "\t\t\t\tsetFile(newFile);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean validatePage() {" + NL + "\t\t\tmyNewFileURI = null;" + NL + "\t\t\tif (super.validatePage()) {" + NL + "\t\t\t\tmyNewFileURI = getFileURI();" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_163 = " getNewFileURI() {" + NL + "\t\t\treturn myNewFileURI;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String validateFile(";
  protected final String TEXT_164 = " file) {" + NL + "\t\t\tif (file.exists()) {" + NL + "\t\t\t\treturn \"Diagram file already exists\";" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_165 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate class RootElementSelectorPage extends ";
  protected final String TEXT_166 = " implements ";
  protected final String TEXT_167 = " {";
  protected final String TEXT_168 = NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_169 = " myTreeViewer;";
  protected final String TEXT_170 = NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprotected RootElementSelectorPage() {" + NL + "\t\t\tsuper(\"Select diagram root element\");" + NL + "\t\t\tsetTitle(\"Diagram root element\");" + NL + "\t\t\tsetDescription(\"Select semantic model element to be depicted on diagram\");" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic void createControl(";
  protected final String TEXT_171 = " parent) {" + NL + "\t\t\tinitializeDialogUnits(parent);" + NL + "\t\t\t";
  protected final String TEXT_172 = " topLevel = new ";
  protected final String TEXT_173 = "(parent, ";
  protected final String TEXT_174 = ".NONE);" + NL + "\t\t\ttopLevel.setLayout(new ";
  protected final String TEXT_175 = "());" + NL + "\t\t\ttopLevel.setLayoutData(new ";
  protected final String TEXT_176 = "(";
  protected final String TEXT_177 = ".VERTICAL_ALIGN_FILL | ";
  protected final String TEXT_178 = ".HORIZONTAL_ALIGN_FILL));" + NL + "\t\t\ttopLevel.setFont(parent.getFont());" + NL + "\t\t\tsetControl(topLevel);" + NL + "\t\t\tcreateModelBrowser(topLevel);" + NL + "\t\t\tsetPageComplete(validatePage());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void createModelBrowser(";
  protected final String TEXT_179 = " parent) {" + NL + "\t\t\t";
  protected final String TEXT_180 = " panel = new ";
  protected final String TEXT_181 = "(parent, ";
  protected final String TEXT_182 = ".NONE);" + NL + "\t\t\tpanel.setLayoutData(new ";
  protected final String TEXT_183 = "(";
  protected final String TEXT_184 = ".FILL_BOTH));" + NL + "\t\t\t";
  protected final String TEXT_185 = " layout = new ";
  protected final String TEXT_186 = "();" + NL + "\t\t\tlayout.marginWidth = 0;" + NL + "\t\t\tpanel.setLayout(layout);" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_187 = " label = new ";
  protected final String TEXT_188 = "(panel, ";
  protected final String TEXT_189 = ".NONE);" + NL + "\t\t\tlabel.setText(\"Select diagram root element:\");" + NL + "\t\t\tlabel.setLayoutData(new ";
  protected final String TEXT_190 = "(";
  protected final String TEXT_191 = ".HORIZONTAL_ALIGN_BEGINNING));";
  protected final String TEXT_192 = NL + "\t\t\t";
  protected final String TEXT_193 = " ";
  protected final String TEXT_194 = " = new ";
  protected final String TEXT_195 = "(panel, ";
  protected final String TEXT_196 = ".SINGLE | ";
  protected final String TEXT_197 = ".H_SCROLL | ";
  protected final String TEXT_198 = ".V_SCROLL | ";
  protected final String TEXT_199 = ".BORDER);" + NL + "\t\t\t";
  protected final String TEXT_200 = " layoutData = new ";
  protected final String TEXT_201 = "(";
  protected final String TEXT_202 = ".FILL_BOTH);" + NL + "\t\t\tlayoutData.heightHint = 300;" + NL + "\t\t\tlayoutData.widthHint = 300;" + NL + "\t\t\t";
  protected final String TEXT_203 = ".getTree().setLayoutData(layoutData);" + NL + "\t\t\t";
  protected final String TEXT_204 = ".setContentProvider(new ";
  protected final String TEXT_205 = "(";
  protected final String TEXT_206 = ".getInstance().getItemProvidersAdapterFactory()));" + NL + "\t\t\t";
  protected final String TEXT_207 = ".setLabelProvider(new ";
  protected final String TEXT_208 = "(";
  protected final String TEXT_209 = ".getInstance().getItemProvidersAdapterFactory()));";
  protected final String TEXT_210 = NL + "\t\t\t";
  protected final String TEXT_211 = ".setInput(myDiagramRoot.eResource());" + NL + "\t\t\t";
  protected final String TEXT_212 = ".setSelection(new ";
  protected final String TEXT_213 = "(myDiagramRoot));";
  protected final String TEXT_214 = NL + "\t\t\t";
  protected final String TEXT_215 = ".addSelectionChangedListener(this);" + NL + "\t\t}" + NL;
  protected final String TEXT_216 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setVisible(boolean visible) {" + NL + "\t\t\tif (visible) {" + NL + "\t\t\t\t";
  protected final String TEXT_217 = ".setInput(myEditingDomain.getResourceSet().getResource(mySelectedModelFileURI, true));" + NL + "\t\t\t\tif (myDiagramRoot != null) {" + NL + "\t\t\t\t\tmyTreeViewer.setSelection(new ";
  protected final String TEXT_218 = "(myDiagramRoot));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tsuper.setVisible(visible);" + NL + "\t\t}" + NL;
  protected final String TEXT_219 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void selectionChanged(";
  protected final String TEXT_220 = " event) {" + NL + "\t\t\tmyDiagramRoot = null;" + NL + "\t\t\tif (event.getSelection() instanceof ";
  protected final String TEXT_221 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_222 = " selection = (";
  protected final String TEXT_223 = ") event.getSelection();" + NL + "\t\t\t\tif (selection.size() == 1) {" + NL + "\t\t\t\t\tObject selectedElement = selection.getFirstElement();" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_224 = ") {" + NL + "\t\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_225 = ") selectedElement).getValue();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_226 = ".Entry) {" + NL + "\t\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_227 = ".Entry) selectedElement).getValue();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_228 = ") {" + NL + "\t\t\t\t\t\tmyDiagramRoot = (";
  protected final String TEXT_229 = ") selectedElement;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tsetPageComplete(validatePage());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate boolean validatePage() {" + NL + "\t\t\tif (myDiagramRoot == null) {" + NL + "\t\t\t\tsetErrorMessage(\"No diagram root element selected\");" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tboolean result = ";
  protected final String TEXT_230 = ".VISUAL_ID == ";
  protected final String TEXT_231 = ".INSTANCE.getDiagramVisualID(myDiagramRoot);" + NL + "\t\t\tsetErrorMessage(result ? null : \"Invalid diagram root element was selected\");" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_232 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final GenModel genModel = editorGen.getDomainGenModel();
final String pluginActivatorClass = importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName());
final boolean isRichClientPlatform = genDiagram.getEditorGen().getApplication() != null;

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);
importManager.registerInnerClass("RootElementSelectorPage");
if (isRichClientPlatform) {
	importManager.registerInnerClass("URISelectorPage");
	importManager.registerInnerClass("SourceURISelectorPage");
	importManager.registerInnerClass("DiagramURISelectorPage");
}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.Wizard"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_7);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_9);
    
} else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_16);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_21);
    
} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_32);
    
}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_34);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_35);
    
} else {

    stringBuffer.append(TEXT_36);
    
}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genDiagram.getDomainDiagramElement() == null ? "" : genDiagram.getDomainDiagramElement().getGenPackage().getPrefix());
    stringBuffer.append(TEXT_39);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_40);
    
} else {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IContainer"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Path"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Path"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_49);
    
}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_51);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_53);
    
} else {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_58);
    
}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_67);
    
}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    
if (!genDiagram.getEditorGen().getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IViewPart"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    
} else {
	if (isRichClientPlatform) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_76);
    
	} else {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ide.IDE"));
    stringBuffer.append(TEXT_79);
    
	}
}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IDiagramLayouter"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IDiagramLayouter"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IDiagramLayouter"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_89);
    
if (genDiagram.getEditorGen().getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_91);
    
}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_93);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_95);
    
} else {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_97);
    
	if (genDiagram.getEditorGen().getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_100);
    
	}
}

    stringBuffer.append(TEXT_101);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardPage"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Text"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Text"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionAdapter"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionEvent"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.ModifyListener"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.ModifyListener"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.ModifyEvent"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(editorGen.getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_164);
    
}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardPage"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ISelectionChangedListener"));
    stringBuffer.append(TEXT_167);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreeViewer"));
    stringBuffer.append(TEXT_169);
    
}

    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_191);
    
final String treeViewer = isRichClientPlatform ? "myTreeViewer" : "treeViewer";

    stringBuffer.append(TEXT_192);
    if (!isRichClientPlatform){
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreeViewer"));
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreeViewer"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_209);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_210);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
    stringBuffer.append(TEXT_213);
    
}

    stringBuffer.append(TEXT_214);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_215);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
    stringBuffer.append(TEXT_218);
    
}

    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.SelectionChangedEvent"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IWrapperItemProvider"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IWrapperItemProvider"));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_231);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_232);
    return stringBuffer.toString();
  }
}
