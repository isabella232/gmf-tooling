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
  protected final String TEXT_4 = NL + NL + "import java.io.IOException;" + NL + "import java.util.Collections;" + NL + "" + NL + "import org.eclipse.core.commands.ExecutionException;" + NL + "import org.eclipse.core.commands.operations.OperationHistoryFactory;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.SubProgressMonitor;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;" + NL + "import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.ui.PartInitException;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean openDiagram(Resource diagram) throws PartInitException {";
  protected final String TEXT_7 = NL + "\t\treturn ";
  protected final String TEXT_8 = ".openEditor((EObject) diagram.getContents().get(0));";
  protected final String TEXT_9 = NL + "\t\tURI fileURI = URI.createFileURI(file.getLocation().toString());" + NL + "\t\t";
  protected final String TEXT_10 = " editorDescriptor = page.getWorkbenchWindow().getWorkbench().getEditorRegistry().getDefaultEditor(fileURI.toFileString());" + NL + "\t\tif (editorDescriptor == null) {" + NL + "\t\t\t";
  protected final String TEXT_11 = ".openError(page.getWorkbenchWindow().getShell(), \"Error\"," + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = ".bind(\"There is no editor registered for the file ''{0}''.\", fileURI.toFileString()));" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn page.openEditor(new ";
  protected final String TEXT_13 = "(fileURI), editorDescriptor.getId());";
  protected final String TEXT_14 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void setCharset(IPath path) {" + NL + "\t\tIFile file = ";
  protected final String TEXT_15 = ".getWorkspace().getRoot().getFile(path);" + NL + "\t\ttry {" + NL + "\t\t\tfile.setCharset(\"UTF-8\", new ";
  protected final String TEXT_16 = "()); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_17 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_18 = ".getInstance().logError(\"Unable to set charset for file \" + path, e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**";
  protected final String TEXT_19 = NL + "\t * <p>" + NL + "\t * This method should be called within a workspace modify operation since it creates resources." + NL + "\t * </p>";
  protected final String TEXT_20 = NL + "\t * @generated" + NL + "\t * @return the created resource, or <code>null</code> if the resource was not created" + NL + "\t */" + NL + "\tpublic static final Resource createDiagram(IPath containerFullPath, String fileNameParameter, IProgressMonitor progressMonitor) {" + NL + "\t\tfinal String fileName = fileNameParameter;" + NL + "\t\tTransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "\t\tprogressMonitor.beginTask(\"Creating diagram and model files\", 3); //$NON-NLS-1$" + NL + "\t\tIPath diagramPath = containerFullPath.append(fileName);" + NL + "\t\tfinal Resource diagramResource = editingDomain.getResourceSet().createResource(URI.createPlatformResourceURI(diagramPath.toString()));";
  protected final String TEXT_21 = NL + "\t\tIPath modelPath = diagramPath.removeFileExtension().addFileExtension(\"";
  protected final String TEXT_22 = "\"); //$NON-NLS-1$" + NL + "\t\tfinal Resource modelResource = editingDomain.getResourceSet().createResource(URI.createPlatformResourceURI(modelPath.toString()));";
  protected final String TEXT_23 = NL + "\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, \"Creating diagram and model\", Collections.EMPTY_LIST) { //$NON-NLS-1$" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {";
  protected final String TEXT_24 = NL + "\t\t\t\t";
  protected final String TEXT_25 = " model = createInitialModel();";
  protected final String TEXT_26 = NL + "\t\t\t\tmodelResource.getContents().add(createInitialRoot(model));";
  protected final String TEXT_27 = NL + "\t\t\t\tdiagramResource.getContents().add(model);";
  protected final String TEXT_28 = NL + "\t\t\t\tDiagram diagram = ViewService.createDiagram(";
  protected final String TEXT_29 = NL + "\t\t\t\t";
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = ") ";
  protected final String TEXT_32 = "model, ";
  protected final String TEXT_33 = NL + "\t\t\t\t\t";
  protected final String TEXT_34 = ".MODEL_ID," + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tif (diagram != null) {" + NL + "\t\t\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\t\t\tdiagram.setName(fileName);";
  protected final String TEXT_36 = NL + "\t\t\t\t\tdiagram.setElement(";
  protected final String TEXT_37 = "(";
  protected final String TEXT_38 = ") ";
  protected final String TEXT_39 = "model);";
  protected final String TEXT_40 = NL + "\t\t\t\t}" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_41 = " options = new ";
  protected final String TEXT_42 = "();" + NL + "\t\t\t\toptions.put(";
  protected final String TEXT_43 = ".OPTION_ENCODING, \"UTF-8\"); //$NON-NLS-1$";
  protected final String TEXT_44 = NL + "\t\t\t\tmodelResource.save(options);";
  protected final String TEXT_45 = NL + "\t\t\t\tdiagramResource.save(options);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = ".getInstance().logError(\"Unable to store model and diagram resources\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_48 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\tsetCharset(modelPath);";
  protected final String TEXT_50 = NL + "\t\tsetCharset(diagramPath);" + NL + "\t\treturn diagramResource;" + NL + "\t}";
  protected final String TEXT_51 = NL + "\t/**" + NL + "\t * Create a new instance of domain element associated with canvas." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_52 = " createInitialModel() {" + NL + "\t\treturn ";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ".create";
  protected final String TEXT_55 = "();" + NL + "\t}" + NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_57 = " createInitialRoot(";
  protected final String TEXT_58 = " model) {";
  protected final String TEXT_59 = NL + "\t\treturn ";
  protected final String TEXT_60 = "(";
  protected final String TEXT_61 = ") ";
  protected final String TEXT_62 = "model;";
  protected final String TEXT_63 = NL + "\t\t";
  protected final String TEXT_64 = " docRoot =" + NL + "\t\t\t\t";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = ".create";
  protected final String TEXT_67 = "();" + NL + "\t\tdocRoot.set";
  protected final String TEXT_68 = "(model);" + NL + "\t\treturn docRoot;";
  protected final String TEXT_69 = NL + "\t}";
  protected final String TEXT_70 = NL + "}";
  protected final String TEXT_71 = NL;

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
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.util.EditUIUtil"));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorDescriptor"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.osgi.util.NLS"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
final boolean standaloneDomainModel = !editorGen.isSameFileForDiagramAndModel() && genDiagram.getDomainDiagramElement() != null;
if (standaloneDomainModel) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    
if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_25);
    	if (standaloneDomainModel) {
    stringBuffer.append(TEXT_26);
    	} else {
    stringBuffer.append(TEXT_27);
    
	}
}

    stringBuffer.append(TEXT_28);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_29);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_35);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_36);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.xmi.XMIResource"));
    stringBuffer.append(TEXT_43);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    // TODO CommandResult.newErrorCommandResult(e) would be better? 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    if (genDiagram.getDomainDiagramElement() != null) {
final String diagramElementImportedName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());
final GenPackage domainGenPackage = genDiagram.getDomainDiagramElement().getGenPackage();

    stringBuffer.append(TEXT_51);
    stringBuffer.append(diagramElementImportedName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getName());
    stringBuffer.append(TEXT_55);
    if (standaloneDomainModel /*may need docRoot only if separate file for domain model*/) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(diagramElementImportedName);
    stringBuffer.append(TEXT_58);
    if (!domainGenPackage.hasDocumentRoot()) { 
    stringBuffer.append(TEXT_59);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
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

    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(docRoot.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(docRoot.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(featureAccessor);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    } /*if standaloneDomainModel*/
} /* domainDiagramElement != null */
    stringBuffer.append(TEXT_70);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_71);
    return stringBuffer.toString();
  }
}
