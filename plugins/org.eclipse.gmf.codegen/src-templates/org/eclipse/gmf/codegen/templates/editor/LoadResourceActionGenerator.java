package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LoadResourceActionGenerator
{
  protected static String nl;
  public static synchronized LoadResourceActionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LoadResourceActionGenerator result = new LoadResourceActionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;" + NL + "import org.eclipse.jface.action.IAction;" + NL + "import org.eclipse.jface.viewers.ISelection;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IObjectActionDelegate;" + NL + "import org.eclipse.ui.IWorkbenchPart;";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " implements IObjectActionDelegate {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_4 = " mySelectedElement;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Shell myShell;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyShell = targetPart.getSite().getShell();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tLoadResourceDialog loadResourceDialog = new LoadResourceDialog(myShell, mySelectedElement.getEditingDomain());" + NL + "\t\tloadResourceDialog.open();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelectedElement = null;" + NL + "\t\tif (selection instanceof IStructuredSelection) {" + NL + "\t\t\tIStructuredSelection structuredSelection = (IStructuredSelection) selection;" + NL + "\t\t\tif (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof ";
  protected final String TEXT_5 = ") {" + NL + "\t\t\t\tmySelectedElement = (";
  protected final String TEXT_6 = ") structuredSelection.getFirstElement();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\taction.setEnabled(isEnabled());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isEnabled() {" + NL + "\t\treturn mySelectedElement != null;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getLoadResourceActionClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
