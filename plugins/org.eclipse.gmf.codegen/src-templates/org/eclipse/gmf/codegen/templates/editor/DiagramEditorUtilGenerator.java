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
  protected final String TEXT_4 = NL + NL + "import java.io.IOException;" + NL + "import java.util.Collections;" + NL + "" + NL + "import org.eclipse.core.commands.ExecutionException;" + NL + "import org.eclipse.core.commands.operations.OperationHistoryFactory;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.SubProgressMonitor;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;" + NL + "import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.ui.PartInitException;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean openDiagram(Resource diagram) throws PartInitException {";
  protected final String TEXT_7 = NL + "\t\treturn ";
  protected final String TEXT_8 = ".openEditor((";
  protected final String TEXT_9 = ") diagram.getContents().get(0));";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = " page = ";
  protected final String TEXT_12 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage();" + NL + "\t\tpage.openEditor(new ";
  protected final String TEXT_13 = "(diagram.getURI()), ";
  protected final String TEXT_14 = ".ID);" + NL + "\t\treturn true;";
  protected final String TEXT_15 = NL + "\t}";
  protected final String TEXT_16 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void setCharset(URI uri) {" + NL + "\t\t";
  protected final String TEXT_17 = " file = getFile(uri);" + NL + "\t\tif (file == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\tfile.setCharset(\"UTF-8\", new ";
  protected final String TEXT_18 = "()); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_19 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_20 = ".getInstance().logError(\"Unable to set charset for file \" + file.getFullPath(), e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IFile getFile(URI uri) {" + NL + "\t\tif (uri.toString().startsWith(\"platform:/resource\")) { //$NON-NLS-1$" + NL + "\t\t\tString path = uri.toString().substring(\"platform:/resource\".length()); //$NON-NLS-1$" + NL + "\t\t\t";
  protected final String TEXT_21 = " workspaceResource =" + NL + "\t\t\t\t";
  protected final String TEXT_22 = ".getWorkspace().getRoot().findMember(new ";
  protected final String TEXT_23 = "(path));" + NL + "\t\t\tif (workspaceResource instanceof ";
  protected final String TEXT_24 = ") {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_25 = ") workspaceResource;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_26 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean exists(";
  protected final String TEXT_27 = " path) {";
  protected final String TEXT_28 = NL + "\t\treturn ";
  protected final String TEXT_29 = ".getWorkspace().getRoot().exists(path);";
  protected final String TEXT_30 = NL + "\t\treturn path.toFile().exists();";
  protected final String TEXT_31 = NL + "\t}" + NL + "" + NL + "\t/**";
  protected final String TEXT_32 = NL + "\t * <p>" + NL + "\t * This method should be called within a workspace modify operation since it creates resources." + NL + "\t * </p>";
  protected final String TEXT_33 = NL + "\t * @generated" + NL + "\t * @return the created resource, or <code>null</code> if the resource was not created" + NL + "\t */";
  protected final String TEXT_34 = NL + "\tpublic static final Resource createDiagram(URI diagramURI,";
  protected final String TEXT_35 = NL + "\t\t\tURI modelURI,";
  protected final String TEXT_36 = NL + "\t\t\tIProgressMonitor progressMonitor) {" + NL + "\t\tTransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "\t\tprogressMonitor.beginTask(\"Creating diagram and model files\", 3);" + NL + "\t\tfinal Resource diagramResource = editingDomain.getResourceSet().createResource(diagramURI);";
  protected final String TEXT_37 = NL + "\t\tfinal Resource modelResource = editingDomain.getResourceSet().createResource(modelURI);";
  protected final String TEXT_38 = NL + "\t\tfinal String diagramName = diagramURI.lastSegment();" + NL + "\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, \"Creating diagram and model\", Collections.EMPTY_LIST) { //$NON-NLS-1$" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = " model = createInitialModel();";
  protected final String TEXT_41 = NL + "\t\t\t\tmodelResource.getContents().add(createInitialRoot(model));";
  protected final String TEXT_42 = NL + "\t\t\t\tdiagramResource.getContents().add(model);";
  protected final String TEXT_43 = NL + "\t\t\t\tDiagram diagram = ViewService.createDiagram(";
  protected final String TEXT_44 = NL + "\t\t\t\t";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ") ";
  protected final String TEXT_47 = "model, ";
  protected final String TEXT_48 = NL + "\t\t\t\t\t";
  protected final String TEXT_49 = ".MODEL_ID," + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tif (diagram != null) {" + NL + "\t\t\t\t\tdiagramResource.getContents().add(diagram);" + NL + "\t\t\t\t\tdiagram.setName(diagramName);";
  protected final String TEXT_51 = NL + "\t\t\t\t\tdiagram.setElement(";
  protected final String TEXT_52 = "(";
  protected final String TEXT_53 = ") ";
  protected final String TEXT_54 = "model);";
  protected final String TEXT_55 = NL + "\t\t\t\t}" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_56 = " options = new ";
  protected final String TEXT_57 = "();" + NL + "\t\t\t\toptions.put(";
  protected final String TEXT_58 = ".OPTION_ENCODING, \"UTF-8\"); //$NON-NLS-1$";
  protected final String TEXT_59 = NL + "\t\t\t\tmodelResource.save(options);";
  protected final String TEXT_60 = NL + "\t\t\t\tdiagramResource.save(options);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t";
  protected final String TEXT_62 = ".getInstance().logError(\"Unable to store model and diagram resources\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_63 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t}";
  protected final String TEXT_64 = NL + "\t\tsetCharset(modelURI);";
  protected final String TEXT_65 = NL + "\t\tsetCharset(diagramURI);";
  protected final String TEXT_66 = NL + "\t\treturn diagramResource;" + NL + "\t}";
  protected final String TEXT_67 = NL + "\t/**" + NL + "\t * Create a new instance of domain element associated with canvas." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_68 = " createInitialModel() {" + NL + "\t\treturn ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ".create";
  protected final String TEXT_71 = "();" + NL + "\t}" + NL;
  protected final String TEXT_72 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_73 = " createInitialRoot(";
  protected final String TEXT_74 = " model) {";
  protected final String TEXT_75 = NL + "\t\treturn ";
  protected final String TEXT_76 = "(";
  protected final String TEXT_77 = ") ";
  protected final String TEXT_78 = "model;";
  protected final String TEXT_79 = NL + "\t\t";
  protected final String TEXT_80 = " docRoot =" + NL + "\t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ".create";
  protected final String TEXT_83 = "();" + NL + "\t\tdocRoot.set";
  protected final String TEXT_84 = "(model);" + NL + "\t\treturn docRoot;";
  protected final String TEXT_85 = NL + "\t}";
  protected final String TEXT_86 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int findElementsInDiagram(";
  protected final String TEXT_87 = " diagramPart, ";
  protected final String TEXT_88 = " elementURI, ";
  protected final String TEXT_89 = "/*EditPart*/ editPartCollector) {" + NL + "\t\tfinal int originalNumOfEditParts = editPartCollector.size();" + NL + "\t\t";
  protected final String TEXT_90 = " element = null;" + NL + "\t\ttry {" + NL + "\t\t\telement = diagramPart.getDiagram().eResource().getResourceSet().getEObject(elementURI, false);" + NL + "\t\t} catch(RuntimeException e) {" + NL + "\t\t\t";
  protected final String TEXT_91 = ".getInstance().logError(\"Failed to get EObject by uri: \" + elementURI, e); //$NON-NLS-1$" + NL + "\t\t\treturn 0;" + NL + "\t\t}" + NL + "\t\tif(element == null) {" + NL + "\t\t\treturn 0;" + NL + "\t\t} else if(element instanceof ";
  protected final String TEXT_92 = ") {" + NL + "\t\t\t";
  protected final String TEXT_93 = " editPart = (";
  protected final String TEXT_94 = ")diagramPart.getDiagramGraphicalViewer().getEditPartRegistry().get(element);" + NL + "\t\t\tif(editPart != null) {" + NL + "\t\t\t\teditPartCollector.add(editPart);" + NL + "\t\t\t\treturn 1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tString elementID = ";
  protected final String TEXT_95 = ".getProxyID(element);" + NL + "\t\t";
  protected final String TEXT_96 = " associatedParts = diagramPart.getDiagramGraphicalViewer()" + NL + "\t\t\t.findEditPartsForElement(elementID, ";
  protected final String TEXT_97 = ".class);" + NL + "\t\t// peform the possible hierarchy disjoint -> take the top-most parts" + NL + "\t\tfor (";
  protected final String TEXT_98 = " editPartIt = associatedParts.iterator(); editPartIt.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_99 = " nextPart = (org.eclipse.gef.EditPart)editPartIt.next();" + NL + "\t\t\t";
  protected final String TEXT_100 = " parentPart = nextPart.getParent();" + NL + "\t\t\twhile(parentPart != null && !associatedParts.contains(parentPart)) {" + NL + "\t\t\t\tparentPart = parentPart.getParent();" + NL + "\t\t\t}\t\t" + NL + "\t\t\tif(parentPart == null) {" + NL + "\t\t\t\teditPartCollector.add(nextPart);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(originalNumOfEditParts == editPartCollector.size()) {" + NL + "\t\t\tif(!associatedParts.isEmpty()) {" + NL + "\t\t\t\teditPartCollector.add(associatedParts.iterator().next());" + NL + "\t\t\t} else {" + NL + "\t\t\t\telement = element.eContainer();" + NL + "\t\t\t\tif(element != null) {" + NL + "\t\t\t\t\treturn findElementsInDiagram(diagramPart, ";
  protected final String TEXT_101 = ".getURI(element), editPartCollector);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn editPartCollector.size() - originalNumOfEditParts;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static void selectElementsInDiagram(";
  protected final String TEXT_102 = " diagramPart, ";
  protected final String TEXT_103 = "/*EditPart*/ editParts) {" + NL + "\t\tdiagramPart.getDiagramGraphicalViewer().deselectAll();" + NL + "" + NL + "\t\t";
  protected final String TEXT_104 = " firstPrimary = null;" + NL + "\t\tfor (java.util.Iterator it = editParts.iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_105 = " nextPart = (";
  protected final String TEXT_106 = ") it.next();" + NL + "\t\t\tdiagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);" + NL + "\t\t\tif(firstPrimary == null && nextPart instanceof ";
  protected final String TEXT_107 = ") {" + NL + "\t\t\t\tfirstPrimary = nextPart;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tif(!editParts.isEmpty()) {" + NL + "\t\t\tdiagramPart.getDiagramGraphicalViewer().reveal(firstPrimary != null ? firstPrimary : (";
  protected final String TEXT_108 = ")editParts.get(0));" + NL + "\t\t}" + NL + "\t}\t" + NL + "}";
  protected final String TEXT_109 = NL;

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(editorGen.getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResource"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Path"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_27);
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_29);
    } else {
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    final boolean standaloneDomainModel = !editorGen.isSameFileForDiagramAndModel() && genDiagram.getDomainDiagramElement() != null;
    stringBuffer.append(TEXT_34);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_40);
    	if (standaloneDomainModel) {
    stringBuffer.append(TEXT_41);
    	} else {
    stringBuffer.append(TEXT_42);
    
	}
}

    stringBuffer.append(TEXT_43);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_44);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_50);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_51);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.xmi.XMIResource"));
    stringBuffer.append(TEXT_58);
    if (standaloneDomainModel) {
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    // TODO CommandResult.newErrorCommandResult(e) would be better? 
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    if (editorGen.getApplication() == null) {
    	if (standaloneDomainModel) {
    stringBuffer.append(TEXT_64);
    	}
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    if (genDiagram.getDomainDiagramElement() != null) {
final String diagramElementImportedName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());
final GenPackage domainGenPackage = genDiagram.getDomainDiagramElement().getGenPackage();

    stringBuffer.append(TEXT_67);
    stringBuffer.append(diagramElementImportedName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getName());
    stringBuffer.append(TEXT_71);
    if (standaloneDomainModel /*may need docRoot only if separate file for domain model*/) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(diagramElementImportedName);
    stringBuffer.append(TEXT_74);
    if (!domainGenPackage.hasDocumentRoot()) { 
    stringBuffer.append(TEXT_75);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
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

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(docRoot.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(domainGenPackage.getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(domainGenPackage.getFactoryInstanceName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(docRoot.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(featureAccessor);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    } /*if standaloneDomainModel*/
} /* domainDiagramElement != null */
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_108);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}
