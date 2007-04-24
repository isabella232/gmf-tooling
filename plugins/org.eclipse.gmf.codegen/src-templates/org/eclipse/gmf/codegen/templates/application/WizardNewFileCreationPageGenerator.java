package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class WizardNewFileCreationPageGenerator
{
  protected static String nl;
  public static synchronized WizardNewFileCreationPageGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    WizardNewFileCreationPageGenerator result = new WizardNewFileCreationPageGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.jface.wizard.WizardPage;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.events.ModifyEvent;" + NL + "import org.eclipse.swt.events.ModifyListener;" + NL + "import org.eclipse.swt.events.SelectionEvent;" + NL + "import org.eclipse.swt.events.SelectionListener;" + NL + "import org.eclipse.swt.layout.GridData;" + NL + "import org.eclipse.swt.layout.GridLayout;" + NL + "import org.eclipse.swt.widgets.Button;" + NL + "import org.eclipse.swt.widgets.Composite;" + NL + "import org.eclipse.swt.widgets.FileDialog;" + NL + "import org.eclipse.swt.widgets.Label;" + NL + "import org.eclipse.swt.widgets.Text;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class WizardNewFileCreationPage extends WizardPage {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final IStructuredSelection currentSelection;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String initialFileName;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IPath initialContainerFullPath;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Text fileNameEditor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic WizardNewFileCreationPage(String name, IStructuredSelection currentSelection) {" + NL + "\t\tsuper(name);" + NL + "\t\tthis.currentSelection = currentSelection;" + NL + "\t\tString home = System.getProperty(\"user.home\"); //$NON-NLS-1$" + NL + "\t\tif (home != null) {" + NL + "\t\t\tinitialContainerFullPath = new Path(home);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IStructuredSelection getSelection() {" + NL + "\t\treturn currentSelection;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getFileName() {" + NL + "\t\tif (fileNameEditor == null) {" + NL + "\t\t\treturn initialFileName;" + NL + "\t\t}" + NL + "\t\tIPath path = getFilePath();" + NL + "\t\tif (path == null || path.isEmpty() || path.hasTrailingSeparator()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn path.lastSegment();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setFileName(String fileName) {" + NL + "\t\tif (fileNameEditor == null) {" + NL + "\t\t\tinitialFileName = fileName;" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tsetFilePath(getContainerFullPath(), fileName);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IPath getContainerFullPath() {" + NL + "\t\tif (fileNameEditor == null) {" + NL + "\t\t\treturn initialContainerFullPath;" + NL + "\t\t}" + NL + "\t\tIPath path = getFilePath();" + NL + "\t\tif (path == null || path.isEmpty()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tif (path.hasTrailingSeparator()) {" + NL + "\t\t\treturn path;" + NL + "\t\t}" + NL + "\t\tpath = path.removeLastSegments(1);" + NL + "\t\tif (path.isEmpty()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn path.addTrailingSeparator();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setContainerFullPath(IPath containerPath) {" + NL + "\t\tif (fileNameEditor == null) {" + NL + "\t\t\tinitialContainerFullPath = containerPath;" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tsetFilePath(containerPath, getFileName());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IPath getFilePath() {" + NL + "\t\tString fileName = fileNameEditor.getText().trim();" + NL + "\t\tif (fileName.length() == 0) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn new Path(fileNameEditor.getText());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFilePath(IPath containerPath, String fileName) {" + NL + "\t\tif (fileName == null) {" + NL + "\t\t\tfileName = \"\"; //$NON-NLS-1$" + NL + "\t\t} else {" + NL + "\t\t\tfileName = fileName.trim();" + NL + "\t\t}" + NL + "\t\tif (containerPath == null) {" + NL + "\t\t\tfileNameEditor.setText(fileName);" + NL + "\t\t} else {" + NL + "\t\t\tif (!containerPath.hasTrailingSeparator()) {" + NL + "\t\t\t\tcontainerPath = containerPath.addTrailingSeparator();" + NL + "\t\t\t}" + NL + "\t\t\tIPath path = fileName.length() == 0 ? containerPath : containerPath.append(fileName);" + NL + "\t\t\tfileNameEditor.setText(path.toOSString());" + NL + "\t\t}" + NL + "\t\tsetPageComplete(validatePage());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createControl(Composite parent) {" + NL + "\t\tComposite plate = new Composite(parent, SWT.NONE);" + NL + "\t\tplate.setLayout(new GridLayout(2, false));" + NL + "\t\tLabel label = new Label(plate, SWT.NONE);" + NL + "\t\tlabel.setText(\"File:\");" + NL + "\t\tlabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));" + NL + "\t\tfileNameEditor = new Text(plate, SWT.SINGLE | SWT.BORDER);" + NL + "\t\tfileNameEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));" + NL + "\t\tButton button = new Button(plate, SWT.PUSH);" + NL + "\t\tbutton.setText(\"Browse\");" + NL + "\t\tbutton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));" + NL + "" + NL + "\t\t// logic" + NL + "\t\tfileNameEditor.addModifyListener(new ModifyListener() {" + NL + "" + NL + "\t\t\tpublic void modifyText(ModifyEvent e) {" + NL + "\t\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\tbutton.addSelectionListener(new SelectionListener() {" + NL + "" + NL + "\t\t\tpublic void widgetSelected(SelectionEvent e) {" + NL + "\t\t\t\tFileDialog dialog = new FileDialog(getShell(), SWT.SAVE);" + NL + "\t\t\t\tdialog.setText(\"Select new file\");" + NL + "\t\t\t\tdialog.setFileName(getFileName());" + NL + "\t\t\t\tString fileName = dialog.open();" + NL + "\t\t\t\tif (fileName != null) {" + NL + "\t\t\t\t\tfileNameEditor.setText(fileName);" + NL + "\t\t\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic void widgetDefaultSelected(SelectionEvent e) {" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "" + NL + "\t\t// init" + NL + "\t\tsetFilePath(initialContainerFullPath, initialFileName);" + NL + "\t\tsetControl(plate);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean validatePage() {" + NL + "\t\tString fileName = fileNameEditor.getText().trim();" + NL + "\t\tif (fileName.length() == 0) {" + NL + "\t\t\tsetErrorMessage(\"Specify file name\");" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tif (!new Path(\"\").isValidPath(fileName)) { //$NON-NLS-1$" + NL + "\t\t\tsetErrorMessage(\"Invalid file name\");" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tsetErrorMessage(null);" + NL + "\t\treturn true;" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenApplication application = (GenApplication) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    {
	GenDiagram genDiagram = application.getEditorGen().getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
