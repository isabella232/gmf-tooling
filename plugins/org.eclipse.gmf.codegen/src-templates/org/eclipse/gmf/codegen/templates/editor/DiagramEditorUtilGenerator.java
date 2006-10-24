package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;

public class DiagramEditorUtilGenerator
{
  protected static String nl;
  public static synchronized DiagramEditorUtilGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditorUtilGenerator result = new DiagramEditorUtilGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.io.IOException;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.commands.ExecutionException;" + NL + "import org.eclipse.core.commands.operations.OperationHistoryFactory;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.SubProgressMonitor;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.ecore.resource.ResourceSet;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;" + NL + "import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IEditorPart;" + NL + "import org.eclipse.ui.IWorkbenchPage;" + NL + "import org.eclipse.ui.IWorkbenchWindow;" + NL + "import org.eclipse.ui.PartInitException;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final URI createAndOpenDiagram(IPath containerPath, String fileName, IWorkbenchWindow window, IProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {" + NL + "\t\tIFile diagramFile = createNewDiagramFile(containerPath, fileName, window.getShell(), progressMonitor);" + NL + "\t\tif (diagramFile != null && openEditor) {" + NL + "\t\t\topenDiagramEditor(window, diagramFile, saveDiagram, progressMonitor);" + NL + "\t\t}" + NL + "\t\treturn URI.createPlatformResourceURI(diagramFile.getFullPath().toString());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IEditorPart openDiagramEditor(IWorkbenchWindow window, IFile file, boolean saveDiagram, IProgressMonitor progressMonitor) {" + NL + "\t\tIEditorPart editorPart = null;" + NL + "\t\ttry {" + NL + "\t\t\tIWorkbenchPage page = window.getActivePage();" + NL + "\t\t\tif (page != null) {" + NL + "\t\t\t\teditorPart = openDiagramEditor(page, file);" + NL + "\t\t\t\tif (saveDiagram) {" + NL + "\t\t\t\t\teditorPart.doSave(progressMonitor);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tfile.refreshLocal(IResource.DEPTH_ZERO, null);" + NL + "\t\t\treturn editorPart;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_7 = ".getInstance().logError(\"Error opening diagram\", e);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IEditorPart openDiagramEditor(IWorkbenchPage page, IFile file) throws PartInitException {";
  protected final String TEXT_8 = NL + "\t\treturn ";
  protected final String TEXT_9 = ".openEditor(page, file);";
  protected final String TEXT_10 = NL + "\t\tURI fileURI = URI.createFileURI(file.getLocation().toString());" + NL + "\t\t";
  protected final String TEXT_11 = " editorDescriptor = page.getWorkbenchWindow().getWorkbench().getEditorRegistry().getDefaultEditor(fileURI.toFileString());" + NL + "\t\tif (editorDescriptor == null) {" + NL + "\t\t\t";
  protected final String TEXT_12 = ".openError(page.getWorkbenchWindow().getShell(), \"Error\"," + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = ".bind(\"There is no editor registered for the file ''{0}''.\", fileURI.toFileString()));" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn page.openEditor(new ";
  protected final String TEXT_14 = "(fileURI), editorDescriptor.getId());";
  protected final String TEXT_15 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <p>" + NL + "\t * This method should be called within a workspace modify operation since it creates resources." + NL + "\t * </p>" + NL + "\t * @generated" + NL + "\t * @return the created file resource, or <code>null</code> if the file was not created" + NL + "\t */" + NL + "\tpublic static final IFile createNewDiagramFile(IPath containerFullPath, String fileName, Shell shell, IProgressMonitor progressMonitor) {" + NL + "\t\tTransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "\t\tResourceSet resourceSet = editingDomain.getResourceSet();" + NL + "\t\tprogressMonitor.beginTask(\"Creating diagram and model files\", 3); //$NON-NLS-1$" + NL + "\t\tfinal IFile diagramFile = ";
  protected final String TEXT_16 = ".createNewFile(containerFullPath, fileName, shell);" + NL + "\t\tfinal Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));" + NL + "\t\tList affectedFiles = new ArrayList();" + NL + "\t\taffectedFiles.add(diagramFile);";
  protected final String TEXT_17 = NL + "\t\tIPath modelFileRelativePath = diagramFile.getFullPath().removeFileExtension().addFileExtension(\"";
  protected final String TEXT_18 = "\"); //$NON-NLS-1$" + NL + "\t\tIFile modelFile = diagramFile.getParent().getFile(new ";
  protected final String TEXT_19 = "(modelFileRelativePath.lastSegment()));" + NL + "\t\tfinal Resource modelResource = resourceSet.createResource(URI.createPlatformResourceURI(modelFile.getFullPath().toString()));" + NL + "\t\taffectedFiles.add(modelFile);";
  protected final String TEXT_20 = NL + "\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, \"Creating diagram and model\", affectedFiles) { //$NON-NLS-1$" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {";
  protected final String TEXT_21 = NL + "\t\t\t\t";
  protected final String TEXT_22 = " model = createInitialModel();";
  protected final String TEXT_23 = NL + "\t\t\t\tmodelResource.getContents().add(createInitialRoot(model));";
  protected final String TEXT_24 = NL + "\t\t\t\tdiagramResource.getContents().add(model);";
  protected final String TEXT_25 = NL + "\t\t\t\tDiagram diagram = ViewService.createDiagram(";
  protected final String TEXT_26 = NL + "\t\t\t\t";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ") ";
  protected final String TEXT_29 = "model, ";
  protected final String TEXT_30 = NL + "\t\t\t\t\t";
  protected final String TEXT_31 = ".MODEL_ID," + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tif (diagram != null) {" + NL + "\t\t\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\t\t\tdiagram.setName(diagramFile.getName());";
  protected final String TEXT_33 = NL + "\t\t\t\t\tdiagram.setElement(";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ") ";
  protected final String TEXT_36 = "model);";
  protected final String TEXT_37 = NL + "\t\t\t\t}" + NL + "\t\t\ttry {";
  protected final String TEXT_38 = NL + "\t\t\t\t";
  protected final String TEXT_39 = " options = new ";
  protected final String TEXT_40 = "();" + NL + "\t\t\t\toptions.put(";
  protected final String TEXT_41 = ".OPTION_ENCODING, \"UTF-8\"); //$NON-NLS-1$" + NL + "\t\t\t\tmodelResource.save(options);";
  protected final String TEXT_42 = NL + "\t\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t";
  protected final String TEXT_44 = ".getInstance().logError(\"Unable to store model and diagram resources\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_45 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\ttry {" + NL + "\t\t\tmodelFile.setCharset(\"UTF-8\", new SubProgressMonitor(progressMonitor, 1)); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_47 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_48 = ".getInstance().logError(\"Unable to set charset for model file\", e); //$NON-NLS-1$" + NL + "\t\t}";
  protected final String TEXT_49 = NL + "\t\ttry {" + NL + "\t\t\tdiagramFile.setCharset(\"UTF-8\", new SubProgressMonitor(progressMonitor, 1)); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_50 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_51 = ".getInstance().logError(\"Unable to set charset for diagram file\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn diagramFile;" + NL + "\t}";
  protected final String TEXT_52 = NL + "\t/**" + NL + "\t * Create a new instance of domain element associated with canvas." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_53 = " createInitialModel() {" + NL + "\t\treturn ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ".create";
  protected final String TEXT_56 = "();" + NL + "\t}" + NL;
  protected final String TEXT_57 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_58 = " createInitialRoot(";
  protected final String TEXT_59 = " model) {";
  protected final String TEXT_60 = NL + "\t\treturn ";
  protected final String TEXT_61 = "(";
  protected final String TEXT_62 = ") ";
  protected final String TEXT_63 = "model;";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = " docRoot =" + NL + "\t\t\t\t";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = ".create";
  protected final String TEXT_68 = "();" + NL + "\t\tdocRoot.set";
  protected final String TEXT_69 = "(model);" + NL + "\t\treturn docRoot;";
  protected final String TEXT_70 = NL + "\t}";
  protected final String TEXT_71 = NL + "}";
  protected final String TEXT_72 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ide.IDE"));
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorDescriptor"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.osgi.util.NLS"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramFileCreatorQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    
final boolean standaloneDomainModel = !editorGen.isSameFileForDiagramAndModel() && genDiagram.getDomainDiagramElement() != null;
if (standaloneDomainModel) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Path"));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_22);
    	if (standaloneDomainModel) {
    stringBuffer.append(TEXT_23);
    	} else {
    stringBuffer.append(TEXT_24);
    
	}
}

    stringBuffer.append(TEXT_25);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_26);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_32);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_33);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.xmi.XMIResource"));
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    // TODO CommandResult.newErrorCommandResult(e) would be better? 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_51);
    if (genDiagram.getDomainDiagramElement() != null) {
final String diagramElementImportedName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());
final GenPackage domainGenPackage = genDiagram.getDomainDiagramElement().getGenPackage();

    stringBuffer.append(TEXT_52);
    stringBuffer.append(diagramElementImportedName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getName());
    stringBuffer.append(TEXT_56);
    if (standaloneDomainModel /*may need docRoot only if separate file for domain model*/) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(diagramElementImportedName);
    stringBuffer.append(TEXT_59);
    if (!domainGenPackage.hasDocumentRoot()) { 
    stringBuffer.append(TEXT_60);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    } else {
// would be better to get GenClass for docRoot and directly use setter
GenClass docRoot = domainGenPackage.getDocumentRoot();
String featureAccessor = "null"; // Alternative is: genDiagram.getDomainDiagramElement().getInterfaceName(); although it's a hack. Seems better to fail right away
for (java.util.Iterator it = docRoot.getGenFeatures().iterator(); it.hasNext(); ) {
	GenFeature genFeature = (GenFeature) it.next();
	boolean unspecifiedUpperBound = ETypedElement.UNSPECIFIED_MULTIPLICITY == genFeature.getEcoreFeature().getUpperBound();
	// Perhaps, makes sense to check instanceof EReference && isContainment
	if (genFeature.isSet() && unspecifiedUpperBound && genDiagram.getDomainDiagramElement().equals(genFeature.getTypeGenClass())) {
		featureAccessor = genFeature.getAccessorName();
		break;
	}
} /*for*/

    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(docRoot.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(docRoot.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(featureAccessor);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    } /*if standaloneDomainModel*/
} /* domainDiagramElement != null */
    stringBuffer.append(TEXT_71);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}
