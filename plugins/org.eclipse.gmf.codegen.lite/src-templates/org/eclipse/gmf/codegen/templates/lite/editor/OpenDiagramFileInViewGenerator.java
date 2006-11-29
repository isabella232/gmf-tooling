package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class OpenDiagramFileInViewGenerator
{
  protected static String nl;
  public static synchronized OpenDiagramFileInViewGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    OpenDiagramFileInViewGenerator result = new OpenDiagramFileInViewGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " myPart;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_8 = " mySelectedModelFile;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setActivePart(";
  protected final String TEXT_9 = " action, ";
  protected final String TEXT_10 = " targetPart) {" + NL + "\t\tmyPart = targetPart;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void selectionChanged(";
  protected final String TEXT_11 = " action, ";
  protected final String TEXT_12 = " selection) {" + NL + "\t\tmySelectedModelFile = null;" + NL + "\t\taction.setEnabled(false);" + NL + "\t\tif (selection instanceof ";
  protected final String TEXT_13 = " == false" + NL + "\t\t\t\t|| selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tmySelectedModelFile = (";
  protected final String TEXT_14 = ") ((";
  protected final String TEXT_15 = ") selection).getFirstElement();" + NL + "\t\taction.setEnabled(true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void run(";
  protected final String TEXT_16 = " action) {" + NL + "\t\t";
  protected final String TEXT_17 = " diagram = null;" + NL + "\t\t";
  protected final String TEXT_18 = " editingDomain = ";
  protected final String TEXT_19 = ".INSTANCE" + NL + "\t\t\t\t.createEditingDomain();" + NL + "\t\t";
  protected final String TEXT_20 = " resourceSet = editingDomain.getResourceSet();" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_21 = " resource = resourceSet.getResource(";
  protected final String TEXT_22 = ".createPlatformResourceURI(mySelectedModelFile.getFullPath().toString()), true);" + NL + "\t\t\tdiagram = (";
  protected final String TEXT_23 = ") resource.getContents().get(0);" + NL + "\t\t} catch (";
  protected final String TEXT_24 = " ex) {" + NL + "\t\t\t";
  protected final String TEXT_25 = ".getInstance().logError(" + NL + "\t\t\t\t\t\t\t\"Unable to load resource: \" + mySelectedModelFile.getFullPath().toString(), ex);" + NL + "\t\t\t";
  protected final String TEXT_26 = ".openError(myPart.getSite().getShell(), \"Error\"," + NL + "\t\t\t\t\t\"Diagram file failed to load\");" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_27 = " part = (";
  protected final String TEXT_28 = ") myPart.getSite().getPage().showView(";
  protected final String TEXT_29 = ".ID);" + NL + "\t\t\tpart.showDiagram(editingDomain, ";
  protected final String TEXT_30 = ".getURI(diagram));" + NL + "\t\t} catch (";
  protected final String TEXT_31 = " ex) {" + NL + "\t\t\t";
  protected final String TEXT_32 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFile.getFullPath().toString(), ex);" + NL + "\t\t\t";
  protected final String TEXT_33 = ".openError(myPart.getSite().getShell(), \"Error\", \"Unable to open diagram\");" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView editorView = (GenEditorView) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = editorView.getEditorGen();
final GenDiagram genDiagram = editorGen.getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IObjectActionDelegate"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ISelection"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.WorkspaceEditingDomainFactory"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.WrappedException"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(editorView.getQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_33);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
