package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class InitDiagramFileActionGenerator
{
  protected static String nl;
  public static synchronized InitDiagramFileActionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitDiagramFileActionGenerator result = new InitDiagramFileActionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = "implements ";
  protected final String TEXT_8 = " {";
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_10 = " mySelectedModelFileURI;" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void selectionChanged(";
  protected final String TEXT_11 = " action, ";
  protected final String TEXT_12 = " selection) {" + NL + "\t\tsuper.selectionChanged(action, selection);" + NL + "\t\tmySelectedModelFileURI = null;" + NL + "\t\tif (selection instanceof ";
  protected final String TEXT_13 = " == false || selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tObject firstElement = ((";
  protected final String TEXT_14 = ") selection).getFirstElement();" + NL + "\t\tif (firstElement instanceof ";
  protected final String TEXT_15 = ") {" + NL + "\t\t\tmySelectedModelFileURI = (";
  protected final String TEXT_16 = ") firstElement;" + NL + "\t\t} else if (firstElement instanceof ";
  protected final String TEXT_17 = ") {" + NL + "\t\t\tmySelectedModelFileURI = (";
  protected final String TEXT_18 = ") ((";
  protected final String TEXT_19 = ") firstElement).getAdapter(";
  protected final String TEXT_20 = ".class);" + NL + "\t\t}" + NL + "\t\tif (mySelectedModelFileURI != null) {" + NL + "\t\t\tmySelectedModelFileURI = mySelectedModelFileURI.trimFragment();" + NL + "\t\t}" + NL + "\t\taction.setEnabled(true);" + NL + "\t}";
  protected final String TEXT_21 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_22 = " myPart;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_23 = " mySelectedModelFile;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_24 = " mySelection;" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void setActivePart(";
  protected final String TEXT_25 = " action, ";
  protected final String TEXT_26 = " targetPart) {" + NL + "\t\tmyPart = targetPart;" + NL + "\t}" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void selectionChanged(";
  protected final String TEXT_27 = " action, ";
  protected final String TEXT_28 = " selection) {" + NL + "\t\tmySelectedModelFile = null;" + NL + "\t\tmySelection = ";
  protected final String TEXT_29 = ".EMPTY;" + NL + "\t\taction.setEnabled(false);" + NL + "\t\tif (selection instanceof ";
  protected final String TEXT_30 = " == false || selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tmySelection = (";
  protected final String TEXT_31 = ") selection;" + NL + "\t\tmySelectedModelFile = (";
  protected final String TEXT_32 = ") ((";
  protected final String TEXT_33 = ") selection).getFirstElement();" + NL + "\t\taction.setEnabled(true);" + NL + "\t}";
  protected final String TEXT_34 = NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void run(";
  protected final String TEXT_35 = " action) {" + NL + "\t\t";
  protected final String TEXT_36 = " diagramRoot = null;" + NL + "\t\t";
  protected final String TEXT_37 = " editingDomain = ";
  protected final String TEXT_38 = ".INSTANCE.createEditingDomain();";
  protected final String TEXT_39 = NL + "\t\tif (mySelectedModelFileURI != null) {";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = " resourceSet = new ";
  protected final String TEXT_42 = "();";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = " resourceSet = editingDomain.getResourceSet();";
  protected final String TEXT_45 = NL + "\t\ttry {";
  protected final String TEXT_46 = NL + "\t\t\t";
  protected final String TEXT_47 = " resource = resourceSet.getResource(mySelectedModelFileURI, true);";
  protected final String TEXT_48 = NL + "\t\t\t";
  protected final String TEXT_49 = " resource = resourceSet.getResource(";
  protected final String TEXT_50 = ".createPlatformResourceURI(mySelectedModelFile.getFullPath().toString()), true);";
  protected final String TEXT_51 = NL + "\t\t\tdiagramRoot = (";
  protected final String TEXT_52 = ") resource.getContents().get(0);" + NL + "\t\t} catch (";
  protected final String TEXT_53 = " ex) {";
  protected final String TEXT_54 = NL + "\t\t\t";
  protected final String TEXT_55 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFileURI.toString(), ex); //$NON-NLS-1$" + NL + "\t\t\t";
  protected final String TEXT_56 = ".openError(getWindow().getShell(), \"Error\", \"Model file loading failed\");";
  protected final String TEXT_57 = NL + "\t\t\t";
  protected final String TEXT_58 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t\t";
  protected final String TEXT_59 = ".openError(myPart.getSite().getShell(), \"Error\", \"Model file loading failed\");";
  protected final String TEXT_60 = NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_61 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_62 = " wizard = new ";
  protected final String TEXT_63 = "(mySelectedModelFileURI, diagramRoot, editingDomain);";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = " wizard = new ";
  protected final String TEXT_66 = "(mySelectedModelFile, myPart.getSite().getPage(), mySelection, diagramRoot, editingDomain);";
  protected final String TEXT_67 = NL + "        ";
  protected final String TEXT_68 = " pluginDialogSettings = ";
  protected final String TEXT_69 = ".getInstance().getDialogSettings();";
  protected final String TEXT_70 = NL + "        ";
  protected final String TEXT_71 = " initDiagramFileSettings = pluginDialogSettings.getSection(\"InisDiagramFile\"); //$NON-NLS-1$" + NL + "        if (initDiagramFileSettings == null) {" + NL + "        \tinitDiagramFileSettings = pluginDialogSettings.addNewSection(\"InisDiagramFile\"); //$NON-NLS-1$" + NL + "        }" + NL + "        wizard.setDialogSettings(initDiagramFileSettings);";
  protected final String TEXT_72 = NL + "\t\twizard.setForcePreviousAndNextButtons(mySelectedModelFileURI != null);";
  protected final String TEXT_73 = NL + "\t\twizard.setForcePreviousAndNextButtons(false);";
  protected final String TEXT_74 = NL + "\t\twizard.setWindowTitle(\"Initialize new \" + ";
  protected final String TEXT_75 = ".MODEL_ID + \" diagram file\");" + NL;
  protected final String TEXT_76 = NL + "        ";
  protected final String TEXT_77 = " dialog = new ";
  protected final String TEXT_78 = "(getWindow().getShell(), wizard);";
  protected final String TEXT_79 = NL + "        ";
  protected final String TEXT_80 = " dialog = new ";
  protected final String TEXT_81 = "(myPart.getSite().getShell(), wizard);";
  protected final String TEXT_82 = NL + "        dialog.create();" + NL + "        dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);" + NL + "        dialog.open();" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_83 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final String pluginActivatorClass = importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName());
final boolean isRichClientPlatform = genDiagram.getEditorGen().getDomainGenModel().isRichClientPlatform();

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
    stringBuffer.append(genDiagram.getInitDiagramFileActionClassName());
    stringBuffer.append(TEXT_5);
    if (isRichClientPlatform) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate"));
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IObjectActionDelegate"));
    }
    stringBuffer.append(TEXT_8);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ISelection"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_20);
    
} else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ISelection"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_33);
    	
}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.WorkspaceEditingDomainFactory"));
    stringBuffer.append(TEXT_38);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_39);
    
}

    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_47);
    
} else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_50);
    
}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.WrappedException"));
    stringBuffer.append(TEXT_53);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_56);
    
} else {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_59);
    
}

    stringBuffer.append(TEXT_60);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.Wizard"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNewDiagramFileWizardQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    
} else {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.Wizard"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNewDiagramFileWizardQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    
}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.IDialogSettings"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.IDialogSettings"));
    stringBuffer.append(TEXT_71);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_72);
    
} else {

    stringBuffer.append(TEXT_73);
    
}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
    stringBuffer.append(TEXT_78);
    
} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
    stringBuffer.append(TEXT_81);
    
}

    stringBuffer.append(TEXT_82);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_83);
    return stringBuffer.toString();
  }
}
