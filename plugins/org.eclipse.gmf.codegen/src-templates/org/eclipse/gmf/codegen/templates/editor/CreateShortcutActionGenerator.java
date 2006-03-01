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
  protected final String TEXT_1 = NL + "import org.eclipse.core.commands.ExecutionException;" + NL + "import org.eclipse.core.commands.operations.OperationHistoryFactory;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.NullProgressMonitor;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.common.util.WrappedException;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EcoreFactory;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.action.IAction;" + NL + "import org.eclipse.jface.viewers.ISelection;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.jface.window.Window;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IObjectActionDelegate;" + NL + "import org.eclipse.ui.IWorkbenchPart;";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " implements IObjectActionDelegate {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_4 = " mySelectedElement;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Shell myShell;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyShell = targetPart.getSite().getShell();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tfinal View view = (View) mySelectedElement.getModel();" + NL + "\t\t";
  protected final String TEXT_5 = " elementChooser = new ";
  protected final String TEXT_6 = "(myShell, view);" + NL + "\t\tint result = elementChooser.open();" + NL + "\t\tif (result != Window.OK) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tURI selectedModelElementURI = elementChooser.getSelectedModelElementURI();" + NL + "\t\tfinal EObject selectedElement;" + NL + "\t\ttry {" + NL + "\t\t\tselectedElement = mySelectedElement.getEditingDomain().getResourceSet().getEObject(selectedModelElementURI, true);" + NL + "\t\t} catch (WrappedException e) {" + NL + "\t\t\t";
  protected final String TEXT_7 = ".getInstance().logError(\"Exception while loading object: \" + selectedModelElementURI.toString(), e); //$NON-NLS-1$" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "" + NL + "\t\tif (selectedElement == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tCreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(selectedElement), ";
  protected final String TEXT_8 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tCreateCommand command = new CreateCommand(mySelectedElement.getEditingDomain(), viewDescriptor, view) {" + NL + "" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {" + NL + "\t\t\t\tCommandResult result = super.doExecuteWithResult(monitor, info);" + NL + "\t\t\t\tView view = (View) ((IAdaptable) result.getReturnValue()).getAdapter(View.class);" + NL + "\t\t\t\tif (view != null) {" + NL + "\t\t\t\t\tEAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();" + NL + "\t\t\t\t\tannotation.setSource(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\t\t\tview.getEAnnotations().add(annotation);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t};" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_9 = ".getInstance().logError(\"Unable to create shortcut\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelectedElement = null;" + NL + "\t\tif (selection instanceof IStructuredSelection) {" + NL + "\t\t\tIStructuredSelection structuredSelection = (IStructuredSelection) selection;" + NL + "\t\t\tif (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof ";
  protected final String TEXT_10 = ") {" + NL + "\t\t\t\tmySelectedElement = (";
  protected final String TEXT_11 = ") structuredSelection.getFirstElement();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\taction.setEnabled(isEnabled());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isEnabled() {" + NL + "\t\treturn mySelectedElement != null;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getCreateShortcutActionClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementChooserQualifiedClassName()));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementChooserQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
