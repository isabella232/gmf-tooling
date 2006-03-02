package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.common.codegen.*;

public class InitDiagramFileActionGenerator {
 
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
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " implements IObjectActionDelegate, IInputValidator {" + NL;
  protected final String TEXT_4 = NL + "\t" + NL + "\t    /**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final Integer LINK_KEY_";
  protected final String TEXT_5 = " = new Integer(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IWorkbenchPart myPart;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFile mySelectedModelFile;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IStructuredSelection mySelection;" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map myLinkVID2EObjectMap = new HashMap();" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map myEObject2NodeMap = new HashMap();" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyPart = targetPart;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelectedModelFile = null;" + NL + "\t\tmySelection = StructuredSelection.EMPTY;" + NL + "\t\taction.setEnabled(false);" + NL + "\t\tif (selection instanceof IStructuredSelection == false || selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tmySelection = (IStructuredSelection) selection;" + NL + "\t\tmySelectedModelFile = (IFile) ((IStructuredSelection) selection).getFirstElement();" + NL + "\t\taction.setEnabled(true);" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */\t" + NL + "\tpublic String isValid(String newText) {" + NL + "\t\tIStatus status = ResourcesPlugin.getWorkspace().validateName(newText, IResource.FILE);" + NL + "\t\tif (!status.isOK()) {" + NL + "\t\t\treturn status.getMessage();" + NL + "\t\t}" + NL + "\t\tif (mySelectedModelFile.getParent().getFile(new Path(newText).addFileExtension(\"editorGen.getDiagramFileExtension()\")).exists()) {" + NL + "\t\t\treturn \"File already exists, choose another name\";" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tNewDiagramFileWizard wizard = new NewDiagramFileWizard();" + NL + "        IDialogSettings pluginDialogSettings = ";
  protected final String TEXT_8 = ".getInstance().getDialogSettings();" + NL + "        IDialogSettings initDiagramFileSettings = pluginDialogSettings.getSection(\"InisDiagramFile\"); //$NON-NLS-1$" + NL + "        if (initDiagramFileSettings == null) {" + NL + "        \tinitDiagramFileSettings = pluginDialogSettings.addNewSection(\"InisDiagramFile\"); //$NON-NLS-1$" + NL + "        }" + NL + "        wizard.setDialogSettings(initDiagramFileSettings);" + NL + "\t\twizard.setForcePreviousAndNextButtons(false);" + NL + "\t\twizard.setWindowTitle(\"Initialize new ";
  protected final String TEXT_9 = " diagram file\");" + NL + "" + NL + "        WizardDialog dialog = new WizardDialog(myPart.getSite().getShell(), wizard);" + NL + "        dialog.create();" + NL + "        dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);" + NL + "        dialog.open();" + NL + "\t}" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate class NewDiagramFileWizard extends Wizard {" + NL + "" + NL + "\t    /**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprivate TransactionalEditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "\t\t" + NL + "\t    /**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprivate WizardNewFileCreationPage myFileCreationPage;" + NL + "\t\t" + NL + "\t    /**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tpublic void addPages() {" + NL + "\t\t\tmyFileCreationPage = new WizardNewFileCreationPage(\"Initialize new Ecore diagram file\", mySelection);" + NL + "\t\t\tmyFileCreationPage.setFileName(mySelectedModelFile.getProjectRelativePath().removeFileExtension().addFileExtension(\"";
  protected final String TEXT_10 = "\").lastSegment());" + NL + "\t\t\tmyFileCreationPage.setTitle(\"Diagram file\");" + NL + "\t\t\tmyFileCreationPage.setDescription(\"Create new diagram and initialize it using specified ";
  protected final String TEXT_11 = " model content\");" + NL + "\t\t\taddPage(myFileCreationPage);" + NL + "\t\t}" + NL + "" + NL + "\t    /**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tpublic boolean performFinish() {" + NL + "\t\t\tfinal EObject diagramModelObject = load();" + NL + "\t\t\tif (diagramModelObject == null) {" + NL + "\t\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to load user model\");" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tIFile diagramFile = myFileCreationPage.createNewFile();" + NL + "\t\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();" + NL + "\t\t\tfinal Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));" + NL + "" + NL + "\t\t\tList affectedFiles = new LinkedList();" + NL + "\t\t\taffectedFiles.add(mySelectedModelFile);" + NL + "\t\t\taffectedFiles.add(diagramFile);" + NL + "\t\t\t" + NL + "\t\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain, \"Initializing diagram contents\", affectedFiles) { //$NON-NLS-1$" + NL + "\t\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {" + NL + "\t\t\t\t\tint diagramVID = ";
  protected final String TEXT_12 = ".INSTANCE.getDiagramVisualID(diagramModelObject);" + NL + "\t\t\t\t\tif (diagramVID != ";
  protected final String TEXT_13 = ") {" + NL + "\t\t\t\t\t\treturn CommandResult.newErrorCommandResult(\"Incorrect model object stored as a root resource object\"); //$NON-NLS-1$" + NL + "\t\t\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\t\t\tmyLinkVID2EObjectMap.put(LINK_KEY_";
  protected final String TEXT_15 = ", new LinkedList());";
  protected final String TEXT_16 = NL + "\t\t\t\t\tDiagram diagram = ViewService.createDiagram(diagramModelObject, \"";
  protected final String TEXT_17 = "\", ";
  protected final String TEXT_18 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\t\tdiagramResource.getContents().add(diagram);";
  protected final String TEXT_19 = NL + "\t\t\t\t\tdiagramResource.getContents().add(diagram.getElement());";
  protected final String TEXT_20 = NL + "\t\t\t\t\tcreate";
  protected final String TEXT_21 = "Children(diagram, diagramModelObject);";
  protected final String TEXT_22 = NL + "\t\t\t\t\tResource resource = diagramModelObject.eResource();" + NL + "\t\t\t\t\tint nodeVID;" + NL + "\t\t\t\t\tfor (";
  protected final String TEXT_23 = " it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t\t\t\t\t\tEObject nextResourceObject = (EObject) it.next();" + NL + "\t\t\t\t\t\tif (nextResourceObject == diagramModelObject) {" + NL + "\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tnodeVID = ";
  protected final String TEXT_25 = ".INSTANCE.getNodeVisualID(diagram, nextResourceObject, \"\");" + NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_26 = " == nodeVID) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_27 = " nextNode = ViewService.createNode(diagram, nextResourceObject, null, ";
  protected final String TEXT_28 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\t\t\t\tmyEObject2NodeMap.put(nextResourceObject, nextNode);" + NL + "\t\t\t\t\t\t\tcreate";
  protected final String TEXT_29 = "Children(nextNode, nextResourceObject);" + NL + "\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t\t\t\t}";
  protected final String TEXT_31 = "\t\t" + NL + "\t\t\t\t\tcreateLinks();" + NL + "\t\t\t\t\tmyLinkVID2EObjectMap.clear();" + NL + "\t\t\t\t\tmyEObject2NodeMap.clear();\t\t" + NL + "\t\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);" + NL + "\t\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\t\tIDE.openEditor(myPart.getSite().getPage(), diagramFile);" + NL + "\t\t\t} catch (ExecutionException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_32 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t\t} catch (IOException ex) {" + NL + "\t\t\t\t";
  protected final String TEXT_33 = ".getInstance().logError(\"Save operation failed for: \" + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t\t} catch (PartInitException ex) {" + NL + "\t\t\t\t";
  protected final String TEXT_34 = ".getInstance().logError(\"Unable to open editor\", ex); //$NON-NLS-1$" + NL + "\t\t\t}\t\t\t" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t    /**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprivate EObject load() {";
  protected final String TEXT_35 = NL + "\t\t\tResourceSet resourceSet = new ";
  protected final String TEXT_36 = "();";
  protected final String TEXT_37 = NL + "\t\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();";
  protected final String TEXT_38 = NL + "\t\t\ttry {" + NL + "\t\t\t\tResource resource = resourceSet.getResource(URI.createPlatformResourceURI(mySelectedModelFile.getFullPath().toString()), true);" + NL + "\t\t\t\treturn (EObject) resource.getContents().get(0);" + NL + "\t\t\t} catch (WrappedException ex) {" + NL + "\t\t\t\t";
  protected final String TEXT_39 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_40 = "\t" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void create";
  protected final String TEXT_41 = "Children(";
  protected final String TEXT_42 = " viewObject, EObject modelObject) {";
  protected final String TEXT_43 = NL + "\t\tEObject nextValue;" + NL + "\t\t";
  protected final String TEXT_44 = " nextNode;" + NL + "\t\tint nodeVID;";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = " nextNode;";
  protected final String TEXT_47 = NL + "\t\tfor (";
  protected final String TEXT_48 = " values = ";
  protected final String TEXT_49 = ".iterator(); values.hasNext();) {" + NL + "\t\t\tnextValue = (EObject) values.next();" + NL;
  protected final String TEXT_50 = NL + "\t\tnextValue = ";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = NL + "\t\tnodeVID = ";
  protected final String TEXT_53 = ".INSTANCE.getNodeVisualID(viewObject, nextValue, \"\");" + NL + "\t\tif (";
  protected final String TEXT_54 = " == nodeVID) {" + NL + "\t\t\tnextNode = ViewService.createNode(viewObject, nextValue, null, ";
  protected final String TEXT_55 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tmyEObject2NodeMap.put(nextValue, nextNode);" + NL + "\t\t\tcreate";
  protected final String TEXT_56 = "Children(nextNode, nextValue);" + NL + "\t\t}";
  protected final String TEXT_57 = NL + "\t\t}";
  protected final String TEXT_58 = NL + "\t\tnextNode = getCompartment(viewObject, \"";
  protected final String TEXT_59 = "\");" + NL + "\t\tif (nextNode != null) {" + NL + "\t\t\tcreate";
  protected final String TEXT_60 = "Children(nextNode, modelObject);" + NL + "\t\t}";
  protected final String TEXT_61 = NL + "\t\tstoreLinks(modelObject, viewObject.getDiagram());" + NL + "\t}";
  protected final String TEXT_62 = NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_63 = " getCompartment(";
  protected final String TEXT_64 = " node, String name) {" + NL + "\t\tfor (";
  protected final String TEXT_65 = " it = node.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_66 = " nextView = (";
  protected final String TEXT_67 = ") it.next();" + NL + "\t\t\tif (nextView instanceof ";
  protected final String TEXT_68 = " && name.equals(nextView.getType())) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_69 = ") nextView;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_70 = NL + NL + "\t/**" + NL + "\t *@generated" + NL + "\t */" + NL + "\tprivate void storeLinks(EObject container, Diagram diagram) {" + NL + "\t\tEClass containerMetaclass = container.eClass();" + NL + "\t\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\t\tstoreTypeModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {\t";
  protected final String TEXT_71 = "\t\t" + NL + "\t\tif (-1 != containerMetaclass.getFeatureID(";
  protected final String TEXT_72 = ".eINSTANCE.get";
  protected final String TEXT_73 = "())) {" + NL + "\t\t\tObject featureValue = ";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = "\t\t" + NL + "\t\t\tfor (";
  protected final String TEXT_76 = " values = ((";
  protected final String TEXT_77 = ") featureValue).iterator(); values.hasNext();) {" + NL + "\t\t\t\tEObject nextValue = ((EObject) values.next());";
  protected final String TEXT_78 = NL + "\t\t\tEObject nextValue = (EObject) featureValue;";
  protected final String TEXT_79 = NL + "\t\t\tint linkVID = ";
  protected final String TEXT_80 = ".INSTANCE.getLinkWithClassVisualID(nextValue);" + NL + "\t\t\tif (";
  protected final String TEXT_81 = " == linkVID) {" + NL + "\t\t\t\tObject structuralFeatureResult = ";
  protected final String TEXT_82 = ";" + NL + "\t\t\t\tif (structuralFeatureResult instanceof EObject) {" + NL + "\t\t\t\t\tEObject dst = (EObject) structuralFeatureResult;" + NL + "\t\t\t\t\t((";
  protected final String TEXT_83 = ") myLinkVID2EObjectMap.get(LINK_KEY_";
  protected final String TEXT_84 = ")).add(new LinkDescriptor(container, dst, nextValue, diagram));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_85 = NL + "\t\t\t}";
  protected final String TEXT_86 = NL + "\t\t}";
  protected final String TEXT_87 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t *@generated" + NL + "\t */" + NL + "\tprivate void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {";
  protected final String TEXT_88 = NL + "\t\tif (-1 != containerMetaclass.getFeatureID(";
  protected final String TEXT_89 = ".eINSTANCE.get";
  protected final String TEXT_90 = "())) {" + NL + "\t\t\tObject structuralFeatureResult = ";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = NL + "\t\t\tfor (";
  protected final String TEXT_93 = " destinations = ((";
  protected final String TEXT_94 = ") structuralFeatureResult).iterator(); destinations.hasNext();) {" + NL + "\t\t\t\tEObject nextDestination = (EObject) destinations.next();";
  protected final String TEXT_95 = NL + "\t\t\tif (structuralFeatureResult instanceof EObject) {" + NL + "\t\t\t\tEObject nextDestination = (EObject) structuralFeatureResult;";
  protected final String TEXT_96 = NL + "\t\t\t\t((";
  protected final String TEXT_97 = ") myLinkVID2EObjectMap.get(LINK_KEY_";
  protected final String TEXT_98 = ")).add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ", diagram));";
  protected final String TEXT_101 = NL + "\t\t\t\tint nodeVID = ";
  protected final String TEXT_102 = ".INSTANCE.getNodeVisualID(diagram, nextDestination, \"\");" + NL + "\t\t\t\tif (";
  protected final String TEXT_103 = " == nodeVID) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_104 = " nextNode = ViewService.createNode(diagram, nextDestination, null, ";
  protected final String TEXT_105 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\t\tmyEObject2NodeMap.put(nextDestination, nextNode);" + NL + "\t\t\t\t\tcreate";
  protected final String TEXT_106 = "Children(nextNode, nextDestination);" + NL + "\t\t\t\t}";
  protected final String TEXT_107 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void createLinks() {";
  protected final String TEXT_109 = NL + "\t\t";
  protected final String TEXT_110 = " linkElements;";
  protected final String TEXT_111 = NL + "\t\tlinkElements = (";
  protected final String TEXT_112 = ") myLinkVID2EObjectMap.get(LINK_KEY_";
  protected final String TEXT_113 = ");" + NL + "\t\tfor (";
  protected final String TEXT_114 = " it = linkElements.iterator(); it.hasNext();) {" + NL + "\t\t\tLinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();" + NL + "\t\t\t";
  protected final String TEXT_115 = " edge = (";
  protected final String TEXT_116 = ") ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), \"\", ";
  protected final String TEXT_117 = ".APPEND, ";
  protected final String TEXT_118 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tif (edge != null) {" + NL + "\t\t\t\tedge.setSource((";
  protected final String TEXT_119 = ") myEObject2NodeMap.get(nextLinkDescriptor.getSource()));" + NL + "\t\t\t\tedge.setTarget((";
  protected final String TEXT_120 = ") myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_121 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate class LinkDescriptor {" + NL + "\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprivate EObject mySource;" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprivate EObject myDestination;" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprivate IAdaptable mySemanticAdapter;" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprivate Diagram myDiagram;" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprotected LinkDescriptor(EObject source, EObject destination, EObject linkElement, Diagram diagram) {" + NL + "\t\t\tthis(source, destination, diagram);" + NL + "\t\t\tmySemanticAdapter = new ";
  protected final String TEXT_122 = "(linkElement);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprotected LinkDescriptor(EObject source, EObject destination, ";
  protected final String TEXT_123 = " elementType, Diagram diagram) {" + NL + "\t\t\tthis(source, destination, diagram);" + NL + "\t\t\tfinal ";
  protected final String TEXT_124 = " elementTypeCopy = elementType;" + NL + "\t\t\tmySemanticAdapter = new ";
  protected final String TEXT_125 = "() {" + NL + "\t\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_126 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprivate LinkDescriptor(EObject source, EObject destination, Diagram diagram) {" + NL + "\t\t\tmySource = source;" + NL + "\t\t\tmyDestination = destination;" + NL + "\t\t\tmyDiagram = diagram;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprotected EObject getSource() {" + NL + "\t\t\treturn mySource;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprotected EObject getDestination() {" + NL + "\t\t\treturn myDestination;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprotected Diagram getDiagram() {" + NL + "\t\t\treturn myDiagram;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t     */" + NL + "\t\tprotected IAdaptable getSemanticAdapter() {" + NL + "\t\t\treturn mySemanticAdapter;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_127 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final String pluginActivatorClass = importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName());
final String modelID = editorGen.getModelID();
List genLinks = genDiagram.getLinks();

// Collecting all phantom elements
Map genClass2Phantom = new LinkedHashMap();
for (Iterator topLevelNodes = genDiagram.getTopLevelNodes().iterator(); topLevelNodes.hasNext();) {
	GenTopLevelNode nextTopLevelNode = (GenTopLevelNode) topLevelNodes.next();
	TypeModelFacet nextModelFacet = nextTopLevelNode.getModelFacet();
	if (!nextModelFacet.isPhantomElement()) {
		continue;
	}
	genClass2Phantom.put(nextModelFacet.getMetaClass(), nextTopLevelNode);
}

boolean generateGetCompartment = false;

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    
importManager.addImport("java.io.IOException");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.HashMap");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.resources.IResource");
importManager.addImport("org.eclipse.core.resources.ResourcesPlugin");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.core.runtime.Path");
importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.resource.Resource");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.jface.dialogs.IInputValidator");
importManager.addImport("org.eclipse.jface.dialogs.MessageDialog");
importManager.addImport("org.eclipse.jface.viewers.ISelection");
importManager.addImport("org.eclipse.jface.viewers.IStructuredSelection");
importManager.addImport("org.eclipse.jface.viewers.StructuredSelection");
importManager.addImport("org.eclipse.ui.IObjectActionDelegate");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.ui.PartInitException");
importManager.addImport("org.eclipse.ui.ide.IDE");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.services.ViewService");
importManager.addImport("org.eclipse.jface.dialogs.IDialogSettings");
importManager.addImport("org.eclipse.jface.wizard.WizardDialog");
importManager.addImport("org.eclipse.jface.wizard.Wizard");
importManager.addImport("org.eclipse.ui.dialogs.WizardNewFileCreationPage");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory");
importManager.addImport("org.eclipse.emf.common.util.WrappedException");
importManager.addImport("org.eclipse.emf.ecore.resource.ResourceSet");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("java.util.List");
importManager.addImport("java.util.LinkedList");
importManager.addImport("org.eclipse.core.runtime.IProgressMonitor");
importManager.addImport("org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand");
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.core.commands.ExecutionException");
importManager.addImport("org.eclipse.gmf.runtime.common.core.command.CommandResult");
importManager.addImport("org.eclipse.core.commands.operations.OperationHistoryFactory");
importManager.addImport("org.eclipse.core.runtime.NullProgressMonitor");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getInitDiagramFileActionClassName());
    stringBuffer.append(TEXT_3);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_4);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_13);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_18);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_21);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_23);
    
	for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
		GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_29);
    
	}

    stringBuffer.append(TEXT_30);
    
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_34);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_36);
    } else {
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_39);
    
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_40);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_42);
    
	if (nextContainer.getContainedNodes().size() > 0) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_44);
    
	} else if (nextContainer instanceof GenNode && ((GenNode) nextContainer).getCompartments().size() > 0) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_46);
    
	}
	
	for (Iterator children = nextContainer.getContainedNodes().iterator(); children.hasNext();) {
		GenNode nextChild = (GenNode) children.next();
		TypeModelFacet typeModelFacet = nextChild.getModelFacet();
		if (typeModelFacet.isPhantomElement()) {
// Skipping top-leve phantoms
			continue;
		}
		GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_49);
    
		} else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_51);
    
		}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(nextChild.getVisualID());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(nextChild.getUniqueIdentifier());
    stringBuffer.append(TEXT_56);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_57);
    
		}
	}
	
	if (nextContainer instanceof GenNode) {
		GenNode nextNode = (GenNode) nextContainer;
		for (Iterator compartments = nextNode.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment nextCompartment = (GenCompartment) compartments.next();
			generateGetCompartment = true;

    stringBuffer.append(TEXT_58);
    stringBuffer.append(nextCompartment.getTitle());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_60);
    
		}
	}

    stringBuffer.append(TEXT_61);
    
}

if (generateGetCompartment) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_69);
    
}

    stringBuffer.append(TEXT_70);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_74);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_77);
    
		} else {

    stringBuffer.append(TEXT_78);
    		
		}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getTargetMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_84);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_85);
    
		}

    stringBuffer.append(TEXT_86);
    
	}
}

    stringBuffer.append(TEXT_87);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof FeatureModelFacet) {
		FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
		GenFeature genFeature = linkFMF.getMetaFeature();
		GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());

    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_91);
    		if (genFeature.isListType()) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_94);
    		} else {
    stringBuffer.append(TEXT_95);
    		}
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_100);
    		if (genFeature.isContains() && phantomNode != null) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_106);
    		}
    stringBuffer.append(TEXT_107);
    
	}
}

    stringBuffer.append(TEXT_108);
    
if (genLinks.size() > 0) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_110);
    
}

for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_120);
    
}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_126);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_127);
    return stringBuffer.toString();
  }
}