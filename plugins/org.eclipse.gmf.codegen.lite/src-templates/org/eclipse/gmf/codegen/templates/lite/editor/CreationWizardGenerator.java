package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class CreationWizardGenerator
{
  protected static String nl;
  public static synchronized CreationWizardGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreationWizardGenerator result = new CreationWizardGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " implements ";
  protected final String TEXT_4 = " {";
  protected final String TEXT_5 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_6 = " diagramFileURI;";
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_8 = " diagramFile;";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_10 = " page;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addPages() {" + NL + "\t\tsuper.addPages();" + NL + "\t\tif (page == null) {" + NL + "\t\t\tpage = new ";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = "getSelection()";
  protected final String TEXT_13 = ");" + NL + "\t\t}" + NL + "\t\taddPage(page);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(IWorkbench workbench, IStructuredSelection selection) {";
  protected final String TEXT_14 = NL + "\t\tsuper.init(workbench, selection);";
  protected final String TEXT_15 = NL + "\t\tsetWindowTitle(\"New ";
  protected final String TEXT_16 = " Diagram\"); //$NON-NLS-1$" + NL + "\t\tsetDefaultPageImageDescriptor(";
  protected final String TEXT_17 = ".getBundledImageDescriptor(" + NL + "\t\t\t\"icons/full/wizban/New";
  protected final String TEXT_18 = ".gif\")); //$NON-NLS-1$" + NL + "\t\tsetNeedsProgressMonitor(true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean performFinish() {" + NL + "\t\tboolean retVal = page.finish();";
  protected final String TEXT_19 = NL + "\t\tdiagramFileURI = page.getCreatedDiagramFileURI();";
  protected final String TEXT_20 = NL + "\t\tdiagramFile = page.getCreatedDiagramFile();";
  protected final String TEXT_21 = NL + "\t\treturn retVal;" + NL + "\t}" + NL;
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t * returns the diagram file " + NL + "\t * @return URI the diagram file" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final URI getDiagramFileURI() {" + NL + "\t\treturn diagramFileURI;" + NL + "\t}";
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * returns the diagram file " + NL + "\t * @return IFile the diagram file" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final IFile getDiagramFile() {" + NL + "\t\treturn diagramFile;" + NL + "\t}";
  protected final String TEXT_24 = NL + "}";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenModel genModel = genDiagram.getEditorGen().getDomainGenModel();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final boolean isRichClientPlatform = genDiagram.getEditorGen().getDomainGenModel().isRichClientPlatform();

importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);
importManager.addImport("org.eclipse.jface.viewers.IStructuredSelection");
importManager.addImport("org.eclipse.ui.IWorkbench");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getCreationWizardClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getImportedName(isRichClientPlatform ? "org.eclipse.jface.wizard.Wizard" : "org.eclipse.ui.wizards.newresource.BasicNewResourceWizard"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.INewWizard"));
    stringBuffer.append(TEXT_4);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_6);
    
} else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_8);
    
}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCreationWizardPageQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCreationWizardPageQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    if(!isRichClientPlatform) {
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_18);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_19);
    
} else {

    stringBuffer.append(TEXT_20);
    
}

    stringBuffer.append(TEXT_21);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_22);
    
} else {

    stringBuffer.append(TEXT_23);
    
}

    stringBuffer.append(TEXT_24);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
