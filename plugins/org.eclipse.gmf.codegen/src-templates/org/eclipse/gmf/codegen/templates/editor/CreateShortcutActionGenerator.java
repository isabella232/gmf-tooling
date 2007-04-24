package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class CreateShortcutActionGenerator
{
  protected static String nl;
  public static synchronized CreateShortcutActionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateShortcutActionGenerator result = new CreateShortcutActionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements IObjectActionDelegate {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_6 = " mySelectedElement;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Shell myShell;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyShell = targetPart.getSite().getShell();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelectedElement = null;" + NL + "\t\tif (selection instanceof IStructuredSelection) {" + NL + "\t\t\tIStructuredSelection structuredSelection = (IStructuredSelection) selection;" + NL + "\t\t\tif (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof ";
  protected final String TEXT_7 = ") {" + NL + "\t\t\t\tmySelectedElement = (";
  protected final String TEXT_8 = ") structuredSelection.getFirstElement();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\taction.setEnabled(isEnabled());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isEnabled() {" + NL + "\t\treturn mySelectedElement != null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tfinal View view = (View) mySelectedElement.getModel();";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = " elementChooser = new ";
  protected final String TEXT_11 = "(myShell, view);" + NL + "\t\tint result = elementChooser.open();" + NL + "\t\tif (result != Window.OK) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tURI selectedModelElementURI = elementChooser.getSelectedModelElementURI();" + NL + "\t\tfinal EObject selectedElement;" + NL + "\t\ttry {" + NL + "\t\t\tselectedElement = mySelectedElement.getEditingDomain().getResourceSet().getEObject(selectedModelElementURI, true);" + NL + "\t\t} catch (WrappedException e) {" + NL + "\t\t\t";
  protected final String TEXT_12 = ".getInstance().logError(\"Exception while loading object: \" + selectedModelElementURI.toString(), e); //$NON-NLS-1$" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "" + NL + "\t\tif (selectedElement == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tCreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(selectedElement), Node.class, null, ";
  protected final String TEXT_13 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t";
  protected final String TEXT_14 = " command = new CreateCommand(mySelectedElement.getEditingDomain(), viewDescriptor, view);" + NL + "\t\tcommand = command.compose(new ";
  protected final String TEXT_15 = "(mySelectedElement.getEditingDomain(), view, viewDescriptor));" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_16 = ".getInstance().logError(\"Unable to create shortcut\", e); //$NON-NLS-1$" + NL + "\t\t}";
  protected final String TEXT_17 = NL + "\t\torg.eclipse.emf.ecore.resource.Resource resource =" + NL + "\t\t\t\t";
  protected final String TEXT_18 = ".openModel(" + NL + "\t\t\t\t\t\tmyShell, \"Select model to reference\", mySelectedElement.getEditingDomain());" + NL + "\t\tif (resource == null || resource.getContents().isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tShortcutCreationWizard wizard = new ShortcutCreationWizard((EObject) resource.getContents().get(0), view, mySelectedElement.getEditingDomain());" + NL + "\t\twizard.setWindowTitle(\"Create shortcut\");" + NL + "\t\t";
  protected final String TEXT_19 = ".runWizard(myShell, wizard, \"CreateShortcut\"); //$NON-NLS-1$";
  protected final String TEXT_20 = NL + "\t}" + NL + "}";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);

importManager.getImportedName("org.eclipse.core.commands.ExecutionException");
importManager.getImportedName("org.eclipse.core.commands.operations.OperationHistoryFactory");
importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor");
importManager.getImportedName("org.eclipse.emf.common.util.URI");
importManager.getImportedName("org.eclipse.emf.common.util.WrappedException");
importManager.getImportedName("org.eclipse.emf.ecore.EObject");
importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand");
importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest");
importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter");
importManager.getImportedName("org.eclipse.gmf.runtime.notation.View");
importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node");
importManager.getImportedName("org.eclipse.jface.action.IAction");
importManager.getImportedName("org.eclipse.jface.viewers.ISelection");
importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection");
importManager.getImportedName("org.eclipse.jface.window.Window");
importManager.getImportedName("org.eclipse.swt.widgets.Shell");
importManager.getImportedName("org.eclipse.ui.IObjectActionDelegate");
importManager.getImportedName("org.eclipse.ui.IWorkbenchPart");

importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getCreateShortcutActionClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    if(genDiagram.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementChooserQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementChooserQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.ICommand"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCreateShortcutDecorationsCommandQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
