package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.common.codegen.*;

public class NewDiagramFileWizardGenerator {
 
  protected static String nl;
  public static synchronized NewDiagramFileWizardGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NewDiagramFileWizardGenerator result = new NewDiagramFileWizardGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends Wizard {" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate TransactionalEditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "\t\t" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate WizardNewFileCreationPage myFileCreationPage;" + NL + "\t\t" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate IFile mySelectedModelFile;" + NL + "\t\t" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate IWorkbenchPage myWorkbenchPage;" + NL + "\t\t" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate IStructuredSelection mySelection;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(IFile selectedModelFile, IWorkbenchPage workbenchPage, IStructuredSelection selection) {" + NL + "\t   \tmySelectedModelFile = selectedModelFile;" + NL + "\t   \tmyWorkbenchPage = workbenchPage;" + NL + "\t   \tmySelection = selection;" + NL + "\t}" + NL + "\t     \t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addPages() {" + NL + "\t\tmyFileCreationPage = new WizardNewFileCreationPage(\"Initialize new Ecore diagram file\", mySelection);" + NL + "\t\tmyFileCreationPage.setFileName(mySelectedModelFile.getProjectRelativePath().removeFileExtension().addFileExtension(\"";
  protected final String TEXT_7 = "\").lastSegment());" + NL + "\t\tmyFileCreationPage.setTitle(\"Diagram file\");" + NL + "\t\tmyFileCreationPage.setDescription(\"Create new diagram and initialize it using specified ";
  protected final String TEXT_8 = " model content\");" + NL + "\t\taddPage(myFileCreationPage);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean performFinish() {" + NL + "\t\tfinal EObject diagramModelObject = load();" + NL + "\t\tif (diagramModelObject == null) {" + NL + "\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to load user model\");" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\t\t" + NL + "\t\tIFile diagramFile = myFileCreationPage.createNewFile();" + NL + "\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();" + NL + "\t\tfinal Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));" + NL + "" + NL + "\t\tList affectedFiles = new LinkedList();" + NL + "\t\taffectedFiles.add(mySelectedModelFile);" + NL + "\t\taffectedFiles.add(diagramFile);" + NL + "\t\t\t" + NL + "\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain, \"Initializing diagram contents\", affectedFiles) { //$NON-NLS-1$" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {" + NL + "\t\t\t\tint diagramVID = ";
  protected final String TEXT_9 = ".INSTANCE.getDiagramVisualID(diagramModelObject);" + NL + "\t\t\t\tif (diagramVID != ";
  protected final String TEXT_10 = ") {" + NL + "\t\t\t\t\treturn CommandResult.newErrorCommandResult(\"Incorrect model object stored as a root resource object\"); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDiagram diagram = ViewService.createDiagram(diagramModelObject, \"";
  protected final String TEXT_11 = "\", ";
  protected final String TEXT_12 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tdiagramResource.getContents().add(diagram);";
  protected final String TEXT_13 = NL + "\t\t\t\tdiagramResource.getContents().add(diagram.getElement());";
  protected final String TEXT_14 = NL + "\t\t\t\tinitDiagramContents(diagram, diagramModelObject);";
  protected final String TEXT_15 = NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t\t" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);" + NL + "\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\tIDE.openEditor(myWorkbenchPage, diagramFile);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_16 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\t";
  protected final String TEXT_17 = ".getInstance().logError(\"Save operation failed for: \" + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t} catch (PartInitException ex) {" + NL + "\t\t\t";
  protected final String TEXT_18 = ".getInstance().logError(\"Unable to open editor\", ex); //$NON-NLS-1$" + NL + "\t\t}\t\t\t" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate EObject load() {";
  protected final String TEXT_19 = NL + "\t\tResourceSet resourceSet = new ";
  protected final String TEXT_20 = "();";
  protected final String TEXT_21 = NL + "\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();";
  protected final String TEXT_22 = NL + "\t\ttry {" + NL + "\t\t\tResource resource = resourceSet.getResource(URI.createPlatformResourceURI(mySelectedModelFile.getFullPath().toString()), true);" + NL + "\t\t\treturn (EObject) resource.getContents().get(0);" + NL + "\t\t} catch (WrappedException ex) {" + NL + "\t\t\t";
  protected final String TEXT_23 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static final Integer LINK_KEY_";
  protected final String TEXT_26 = " = new Integer(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_29 = " myLinkVID2EObjectMap = new ";
  protected final String TEXT_30 = "();" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_31 = " myEObject2NodeMap = new ";
  protected final String TEXT_32 = "();" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void initDiagramContents(Diagram diagram, EObject diagramModelObject) {";
  protected final String TEXT_33 = NL + "\tmyLinkVID2EObjectMap.put(LINK_KEY_";
  protected final String TEXT_34 = ", new LinkedList());";
  protected final String TEXT_35 = NL + "\tcreate";
  protected final String TEXT_36 = "Children(diagram, diagramModelObject);";
  protected final String TEXT_37 = NL + "\tResource resource = diagramModelObject.eResource();" + NL + "\tfor (";
  protected final String TEXT_38 = " it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t\tEObject nextResourceObject = (EObject) it.next();" + NL + "\t\tif (nextResourceObject == diagramModelObject) {" + NL + "\t\t\tcontinue;" + NL + "\t\t}" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_39 = ".INSTANCE.getNodeVisualID(diagram, nextResourceObject, \"\");" + NL + "\t\t";
  protected final String TEXT_40 = " nextNode;" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_41 = NL + "\t\tcase ";
  protected final String TEXT_42 = ":" + NL + "\t\t\tnextNode = ViewService.createNode(diagram, nextResourceObject, null, ";
  protected final String TEXT_43 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tmyEObject2NodeMap.put(nextResourceObject, nextNode);" + NL + "\t\t\tcreate";
  protected final String TEXT_44 = "Children(nextNode, nextResourceObject);" + NL + "\t\t\tbreak;";
  protected final String TEXT_45 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_46 = "\t\t" + NL + "\t\tcreateLinks();" + NL + "\t}";
  protected final String TEXT_47 = "\t" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_48 = "Children(";
  protected final String TEXT_49 = " viewObject, EObject modelObject) {";
  protected final String TEXT_50 = NL + "\tEObject nextValue;" + NL + "\t";
  protected final String TEXT_51 = " nextNode;" + NL + "\tint nodeVID;";
  protected final String TEXT_52 = NL + "\t";
  protected final String TEXT_53 = " nextNode;";
  protected final String TEXT_54 = NL + "\tfor (";
  protected final String TEXT_55 = " values = ";
  protected final String TEXT_56 = ".iterator(); values.hasNext();) {" + NL + "\t\tnextValue = (EObject) values.next();";
  protected final String TEXT_57 = NL + "\tnextValue = ";
  protected final String TEXT_58 = ";";
  protected final String TEXT_59 = NL + "\tnodeVID = ";
  protected final String TEXT_60 = ".INSTANCE.getNodeVisualID(viewObject, nextValue, \"\");" + NL + "\tif (";
  protected final String TEXT_61 = " == nodeVID) {" + NL + "\t\tnextNode = ViewService.createNode(viewObject, nextValue, null, ";
  protected final String TEXT_62 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextValue, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_63 = "Children(nextNode, nextValue);" + NL + "\t}";
  protected final String TEXT_64 = NL + "\t}";
  protected final String TEXT_65 = NL + "\tnextNode = getCompartment(viewObject, \"";
  protected final String TEXT_66 = "\");" + NL + "\tif (nextNode != null) {" + NL + "\t\tcreate";
  protected final String TEXT_67 = "Children(nextNode, modelObject);" + NL + "\t}";
  protected final String TEXT_68 = NL + "\tstoreLinks(modelObject, viewObject.getDiagram());";
  protected final String TEXT_69 = NL + "}";
  protected final String TEXT_70 = NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_71 = " getCompartment(";
  protected final String TEXT_72 = " node, String name) {" + NL + "\tfor (";
  protected final String TEXT_73 = " it = node.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_74 = " nextView = (";
  protected final String TEXT_75 = ") it.next();" + NL + "\t\tif (nextView instanceof ";
  protected final String TEXT_76 = " && name.equals(nextView.getType())) {" + NL + "\t\t\treturn (";
  protected final String TEXT_77 = ") nextView;" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn null;" + NL + "}";
  protected final String TEXT_78 = NL + NL + "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeLinks(EObject container, Diagram diagram) {" + NL + "\t";
  protected final String TEXT_79 = " containerMetaclass = container.eClass();" + NL + "\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\tstoreTypeModelFacetLinks(container, containerMetaclass, diagram);" + NL + "}" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void storeTypeModelFacetLinks(EObject container, ";
  protected final String TEXT_80 = " containerMetaclass, Diagram diagram) {\t";
  protected final String TEXT_81 = "\t\t" + NL + "\tif (";
  protected final String TEXT_82 = ".eINSTANCE.get";
  protected final String TEXT_83 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_84 = "\t\t" + NL + "\t\tfor (";
  protected final String TEXT_85 = " values = ";
  protected final String TEXT_86 = ".iterator(); values.hasNext();) {" + NL + "\t\t\tEObject nextValue = ((EObject) values.next());";
  protected final String TEXT_87 = NL + "\t\tEObject nextValue = (EObject) ";
  protected final String TEXT_88 = ";";
  protected final String TEXT_89 = NL + "\t\tObject structuralFeatureResult = ";
  protected final String TEXT_90 = ";" + NL + "\t\tif (structuralFeatureResult instanceof EObject) {" + NL + "\t\t\tEObject dst = (EObject) structuralFeatureResult;";
  protected final String TEXT_91 = NL + "\t\t\tstructuralFeatureResult = ";
  protected final String TEXT_92 = ";" + NL + "\t\t\tif (structuralFeatureResult instanceof EObject) {" + NL + "\t\t\t\tEObject src = (EObject) structuralFeatureResult;";
  protected final String TEXT_93 = NL + "\t\t\tEObject src = nextValue;";
  protected final String TEXT_94 = NL + "\t\t\tint linkVID = ";
  protected final String TEXT_95 = ".INSTANCE.getLinkWithClassVisualID(nextValue);" + NL + "\t\t\tif (";
  protected final String TEXT_96 = " == linkVID) {" + NL + "\t\t\t\t((";
  protected final String TEXT_97 = ") myLinkVID2EObjectMap.get(LINK_KEY_";
  protected final String TEXT_98 = ")).add(new LinkDescriptor(src, dst, nextValue, diagram));" + NL + "\t\t\t}";
  protected final String TEXT_99 = NL + "\t\t\t}";
  protected final String TEXT_100 = NL + "\t\t}";
  protected final String TEXT_101 = NL + "\t\t}";
  protected final String TEXT_102 = NL + "\t}";
  protected final String TEXT_103 = NL + "}" + NL + "" + NL + "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeFeatureModelFacetLinks(EObject container, ";
  protected final String TEXT_104 = " containerMetaclass, Diagram diagram) {";
  protected final String TEXT_105 = NL + "\tif (";
  protected final String TEXT_106 = ".eINSTANCE.get";
  protected final String TEXT_107 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_108 = NL + "\t\tfor (";
  protected final String TEXT_109 = " destinations = ";
  protected final String TEXT_110 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\tEObject nextDestination = (EObject) destinations.next();";
  protected final String TEXT_111 = NL + "\t\tif (";
  protected final String TEXT_112 = " instanceof EObject) {" + NL + "\t\t\tEObject nextDestination = (EObject) ";
  protected final String TEXT_113 = ";";
  protected final String TEXT_114 = NL + "\t\t\t((";
  protected final String TEXT_115 = ") myLinkVID2EObjectMap.get(LINK_KEY_";
  protected final String TEXT_116 = ")).add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = ", diagram));";
  protected final String TEXT_119 = NL + "\t\t\tint nodeVID = ";
  protected final String TEXT_120 = ".INSTANCE.getNodeVisualID(diagram, nextDestination, \"\");" + NL + "\t\t\tif (";
  protected final String TEXT_121 = " == nodeVID) {" + NL + "\t\t\t\t";
  protected final String TEXT_122 = " nextNode = ViewService.createNode(diagram, nextDestination, null, ";
  protected final String TEXT_123 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tmyEObject2NodeMap.put(nextDestination, nextNode);" + NL + "\t\t\t\tcreate";
  protected final String TEXT_124 = "Children(nextNode, nextDestination);" + NL + "\t\t\t}";
  protected final String TEXT_125 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_126 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void createLinks() {";
  protected final String TEXT_127 = NL + "\t";
  protected final String TEXT_128 = " linkElements;";
  protected final String TEXT_129 = NL + "\tlinkElements = (";
  protected final String TEXT_130 = ") myLinkVID2EObjectMap.get(LINK_KEY_";
  protected final String TEXT_131 = ");" + NL + "\tfor (";
  protected final String TEXT_132 = " it = linkElements.iterator(); it.hasNext();) {" + NL + "\t\tLinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();" + NL + "\t\t";
  protected final String TEXT_133 = " edge = (";
  protected final String TEXT_134 = ") ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), \"\", ";
  protected final String TEXT_135 = ".APPEND, ";
  protected final String TEXT_136 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tif (edge != null) {" + NL + "\t\t\tedge.setSource((";
  protected final String TEXT_137 = ") myEObject2NodeMap.get(nextLinkDescriptor.getSource()));" + NL + "\t\t\tedge.setTarget((";
  protected final String TEXT_138 = ") myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_139 = NL + "}" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private class LinkDescriptor {" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate EObject mySource;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate EObject myDestination;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate IAdaptable mySemanticAdapter;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate Diagram myDiagram;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(EObject source, EObject destination, EObject linkElement, Diagram diagram) {" + NL + "\t\tthis(source, destination, diagram);" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_140 = "(linkElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(EObject source, EObject destination, ";
  protected final String TEXT_141 = " elementType, Diagram diagram) {" + NL + "\t\tthis(source, destination, diagram);" + NL + "\t\tfinal ";
  protected final String TEXT_142 = " elementTypeCopy = elementType;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_143 = "() {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_144 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(EObject source, EObject destination, Diagram diagram) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyDiagram = diagram;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected EObject getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected EObject getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected Diagram getDiagram() {" + NL + "\t\treturn myDiagram;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected IAdaptable getSemanticAdapter() {" + NL + "\t\treturn mySemanticAdapter;" + NL + "\t}" + NL + "}";
  protected final String TEXT_145 = "\t" + NL + "" + NL + "}";

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
    
// TODO: move this attribute to the genmodel
final boolean isSynchronizedDiagram = false;

final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final String modelID = editorGen.getModelID();
final String pluginActivatorClass = importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName());

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);

importManager.addImport("java.io.IOException");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.List");
importManager.addImport("java.util.LinkedList");
importManager.addImport("org.eclipse.core.commands.ExecutionException");
importManager.addImport("org.eclipse.core.commands.operations.OperationHistoryFactory");
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.runtime.IProgressMonitor");
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.core.runtime.NullProgressMonitor");
importManager.addImport("org.eclipse.emf.common.util.WrappedException");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.resource.Resource");
importManager.addImport("org.eclipse.emf.ecore.resource.ResourceSet");
importManager.addImport("org.eclipse.gmf.runtime.common.core.command.CommandResult");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.services.ViewService");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory");
importManager.addImport("org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.jface.dialogs.MessageDialog");
importManager.addImport("org.eclipse.jface.viewers.IStructuredSelection");
importManager.addImport("org.eclipse.jface.wizard.Wizard");
importManager.addImport("org.eclipse.ui.PartInitException");
importManager.addImport("org.eclipse.ui.ide.IDE");
importManager.addImport("org.eclipse.ui.dialogs.WizardNewFileCreationPage");
importManager.addImport("org.eclipse.ui.IWorkbenchPage");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_12);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_13);
    
}
if (!isSynchronizedDiagram) {

    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_18);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_20);
    } else {
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_23);
    if (!isSynchronizedDiagram) {
    stringBuffer.append(TEXT_24);
    
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

for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_27);
    
}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_32);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_34);
    
}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_40);
    
	for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
		GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_41);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    
	}

    stringBuffer.append(TEXT_45);
    
}
// TODO: remove "createLinks()" method - this task should be done by canonicalEditPolicies

    stringBuffer.append(TEXT_46);
    
boolean generateGetCompartment = false;

for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_47);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_49);
    
	if (nextContainer.getContainedNodes().size() > 0) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_51);
    
	} else if (nextContainer instanceof GenNode && ((GenNode) nextContainer).getCompartments().size() > 0) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_53);
    
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

    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_56);
    
		} else {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_58);
    
		}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(nextChild.getVisualID());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(nextChild.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_64);
    
		}
	}
	
	if (nextContainer instanceof GenNode) {
		GenNode nextNode = (GenNode) nextContainer;
		for (Iterator compartments = nextNode.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment nextCompartment = (GenCompartment) compartments.next();
			generateGetCompartment = true;

    stringBuffer.append(TEXT_65);
    stringBuffer.append(nextCompartment.getTitle());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_67);
    
		}
	}
	if (false == nextContainer instanceof GenCompartment) {

    stringBuffer.append(TEXT_68);
    	}
    stringBuffer.append(TEXT_69);
    
}

if (generateGetCompartment) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_77);
    
}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_80);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(childMetaFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_83);
    		if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_86);
    		} else {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_88);
    		}
    stringBuffer.append(TEXT_89);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getTargetMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_90);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getSourceMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_92);
    		} else {
    stringBuffer.append(TEXT_93);
    		}
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_98);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_99);
    		}
    stringBuffer.append(TEXT_100);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_101);
    
		}

    stringBuffer.append(TEXT_102);
    
	}
}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_104);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof FeatureModelFacet) {
		FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
		GenFeature genFeature = linkFMF.getMetaFeature();
		GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());

    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_107);
    		if (genFeature.isListType()) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_110);
    		} else {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_113);
    		}
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_118);
    		if (genFeature.isContains() && phantomNode != null) {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_124);
    		}
    stringBuffer.append(TEXT_125);
    
	}
}

    stringBuffer.append(TEXT_126);
    
if (genLinks.size() > 0) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_128);
    
}

for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_138);
    
}

    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}