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
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_27 = " myLinkDescriptors = new ";
  protected final String TEXT_28 = "();" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_29 = " myEObject2NodeMap = new ";
  protected final String TEXT_30 = "();" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void initDiagramContents(";
  protected final String TEXT_31 = " diagram, ";
  protected final String TEXT_32 = " diagramModelObject) {" + NL + "\tcreate";
  protected final String TEXT_33 = "Children(diagram, diagramModelObject);";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = " resource = diagramModelObject.eResource();" + NL + "for (";
  protected final String TEXT_36 = " it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t";
  protected final String TEXT_37 = " nextResourceObject = (";
  protected final String TEXT_38 = ") it.next();" + NL + "\tif (nextResourceObject == diagramModelObject) {" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tint nodeVID = ";
  protected final String TEXT_39 = ".INSTANCE.getNodeVisualID(diagram, nextResourceObject, \"\");" + NL + "\tswitch (nodeVID) {";
  protected final String TEXT_40 = NL + "\t\tcase ";
  protected final String TEXT_41 = ": {" + NL + "\t\t\t";
  protected final String TEXT_42 = " nextNode = ViewService.createNode(diagram, nextResourceObject, null, ";
  protected final String TEXT_43 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tmyEObject2NodeMap.put(nextResourceObject, nextNode);" + NL + "\t\t\tcreate";
  protected final String TEXT_44 = "Children(nextNode, nextResourceObject);" + NL + "\t\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = "\t}" + NL + "}";
  protected final String TEXT_47 = "\t\t" + NL + "\tcreateLinks(diagram);" + NL + "}";
  protected final String TEXT_48 = "\t" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_49 = "Children(";
  protected final String TEXT_50 = " viewObject, ";
  protected final String TEXT_51 = " modelObject) {";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = "\t";
  protected final String TEXT_54 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_55 = "\tfor (";
  protected final String TEXT_56 = " values = ";
  protected final String TEXT_57 = ".iterator(); values.hasNext();) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_58 = ") values.next();";
  protected final String TEXT_59 = NL + "\tnextValue = ";
  protected final String TEXT_60 = ";";
  protected final String TEXT_61 = NL + "\tnodeVID = ";
  protected final String TEXT_62 = ".INSTANCE.getNodeVisualID(viewObject, nextValue, \"\");";
  protected final String TEXT_63 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_64 = NL + "\tcase ";
  protected final String TEXT_65 = ": {";
  protected final String TEXT_66 = NL + "\tif (";
  protected final String TEXT_67 = " == nodeVID) {";
  protected final String TEXT_68 = NL + "\t\t";
  protected final String TEXT_69 = " nextNode = ViewService.createNode(viewObject, nextValue, null, ";
  protected final String TEXT_70 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextValue, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_71 = "Children(nextNode, nextValue);";
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = "\t\tbreak;";
  protected final String TEXT_74 = "\t}";
  protected final String TEXT_75 = NL + "\t}";
  protected final String TEXT_76 = NL + "\t}";
  protected final String TEXT_77 = NL + "\t";
  protected final String TEXT_78 = " nextCompartment = getCompartment(viewObject, ";
  protected final String TEXT_79 = ");" + NL + "\tif (nextCompartment != null) {" + NL + "\t\tcreate";
  protected final String TEXT_80 = "Children(nextCompartment, modelObject);" + NL + "\t}";
  protected final String TEXT_81 = NL + "\tstoreLinks(modelObject, viewObject.getDiagram());";
  protected final String TEXT_82 = NL + "}";
  protected final String TEXT_83 = NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_84 = " getCompartment(";
  protected final String TEXT_85 = " node, String name) {" + NL + "\tfor (";
  protected final String TEXT_86 = " it = node.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_87 = " nextView = (";
  protected final String TEXT_88 = ") it.next();" + NL + "\t\tif (nextView instanceof ";
  protected final String TEXT_89 = " && name.equals(nextView.getType())) {" + NL + "\t\t\treturn (";
  protected final String TEXT_90 = ") nextView;" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn null;" + NL + "}";
  protected final String TEXT_91 = NL;
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeLinks(";
  protected final String TEXT_94 = " container, ";
  protected final String TEXT_95 = " diagram) {" + NL + "\t";
  protected final String TEXT_96 = " containerMetaclass = container.eClass();" + NL + "\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\tstoreTypeModelFacetLinks(container, containerMetaclass);" + NL + "}" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void storeTypeModelFacetLinks(";
  protected final String TEXT_97 = " container, ";
  protected final String TEXT_98 = " containerMetaclass) {\t";
  protected final String TEXT_99 = "\t\t" + NL + "\tif (";
  protected final String TEXT_100 = ".eINSTANCE.get";
  protected final String TEXT_101 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_102 = "\t\t" + NL + "\t\tfor (";
  protected final String TEXT_103 = " values = ";
  protected final String TEXT_104 = ".iterator(); values.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_105 = " nextValue = ((";
  protected final String TEXT_106 = ") values.next());";
  protected final String TEXT_107 = NL + "\t\t";
  protected final String TEXT_108 = " nextValue = (";
  protected final String TEXT_109 = ") ";
  protected final String TEXT_110 = ";";
  protected final String TEXT_111 = NL + "\t\tObject structuralFeatureResult = ";
  protected final String TEXT_112 = ";" + NL + "\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_113 = ") {" + NL + "\t\t\t";
  protected final String TEXT_114 = " dst = (";
  protected final String TEXT_115 = ") structuralFeatureResult;";
  protected final String TEXT_116 = NL + "\t\t\tstructuralFeatureResult = ";
  protected final String TEXT_117 = ";" + NL + "\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_118 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_119 = " src = (";
  protected final String TEXT_120 = ") structuralFeatureResult;";
  protected final String TEXT_121 = NL + "\t\t\t";
  protected final String TEXT_122 = " src = container;";
  protected final String TEXT_123 = NL + "\t\t\tint linkVID = ";
  protected final String TEXT_124 = ".INSTANCE.getLinkWithClassVisualID(nextValue);" + NL + "\t\t\tif (";
  protected final String TEXT_125 = " == linkVID) {" + NL + "\t\t\t\tmyLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, linkVID));" + NL + "\t\t\t}";
  protected final String TEXT_126 = NL + "\t\t\t}";
  protected final String TEXT_127 = NL + "\t\t}";
  protected final String TEXT_128 = NL + "\t\t}";
  protected final String TEXT_129 = NL + "\t}";
  protected final String TEXT_130 = NL + "}" + NL + "" + NL + "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeFeatureModelFacetLinks(";
  protected final String TEXT_131 = " container, ";
  protected final String TEXT_132 = " containerMetaclass, Diagram diagram) {";
  protected final String TEXT_133 = NL;
  protected final String TEXT_134 = "\tif (";
  protected final String TEXT_135 = ".eINSTANCE.get";
  protected final String TEXT_136 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_137 = NL + "\t\tfor (";
  protected final String TEXT_138 = " destinations = ";
  protected final String TEXT_139 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_140 = " nextDestination = (";
  protected final String TEXT_141 = ") destinations.next();";
  protected final String TEXT_142 = NL + "\t\t";
  protected final String TEXT_143 = " nextDestination = (";
  protected final String TEXT_144 = ") ";
  protected final String TEXT_145 = ";";
  protected final String TEXT_146 = NL + "\t\tint nodeVID = ";
  protected final String TEXT_147 = ".INSTANCE.getNodeVisualID(diagram, nextDestination, \"\");" + NL + "\t\tif (";
  protected final String TEXT_148 = " == nodeVID) {";
  protected final String TEXT_149 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = "));";
  protected final String TEXT_153 = NL + "\t\t";
  protected final String TEXT_154 = " nextNode = ViewService.createNode(diagram, nextDestination, null, ";
  protected final String TEXT_155 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextDestination, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_156 = "Children(nextNode, nextDestination);";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL + "\t\t}";
  protected final String TEXT_159 = NL + "\t\t}";
  protected final String TEXT_160 = NL + "\t}";
  protected final String TEXT_161 = NL;
  protected final String TEXT_162 = "\tif (";
  protected final String TEXT_163 = ".eINSTANCE.get";
  protected final String TEXT_164 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_165 = NL + "\t\tfor (";
  protected final String TEXT_166 = " destinations = ";
  protected final String TEXT_167 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_168 = " nextDestination = (";
  protected final String TEXT_169 = ") destinations.next();";
  protected final String TEXT_170 = NL + "\t\t";
  protected final String TEXT_171 = " nextDestination = (";
  protected final String TEXT_172 = ") ";
  protected final String TEXT_173 = ";";
  protected final String TEXT_174 = NL + "\t\tint nodeVID = ";
  protected final String TEXT_175 = ".INSTANCE.getNodeVisualID(diagram, nextDestination, \"\");" + NL + "\t\tif (";
  protected final String TEXT_176 = " == nodeVID) {";
  protected final String TEXT_177 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = ", ";
  protected final String TEXT_180 = "));";
  protected final String TEXT_181 = NL;
  protected final String TEXT_182 = NL + "\t\t}";
  protected final String TEXT_183 = NL + "\t\t}";
  protected final String TEXT_184 = NL + "\t}";
  protected final String TEXT_185 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void createLinks(";
  protected final String TEXT_186 = " diagram) {" + NL + "\tfor (";
  protected final String TEXT_187 = " it = myLinkDescriptors.iterator(); it.hasNext();) {" + NL + "\t\tLinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();" + NL + "\t\t";
  protected final String TEXT_188 = " edge = (";
  protected final String TEXT_189 = ") ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, \"\", ";
  protected final String TEXT_190 = ".APPEND, ";
  protected final String TEXT_191 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tif (edge != null) {" + NL + "\t\t\tedge.setSource((";
  protected final String TEXT_192 = ") myEObject2NodeMap.get(nextLinkDescriptor.getSource()));" + NL + "\t\t\tedge.setTarget((";
  protected final String TEXT_193 = ") myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_194 = NL;
  protected final String TEXT_195 = "/**" + NL + " * @generated" + NL + " */" + NL + "private class LinkDescriptor {" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_196 = " mySource;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_197 = " myDestination;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_198 = " myLinkElement;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate int myVisualID;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_199 = " mySemanticAdapter;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_200 = " source, ";
  protected final String TEXT_201 = " destination, ";
  protected final String TEXT_202 = " linkElement, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = linkElement;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_203 = "(linkElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_204 = " source, ";
  protected final String TEXT_205 = " destination, ";
  protected final String TEXT_206 = " elementType, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = null;" + NL + "\t\tfinal ";
  protected final String TEXT_207 = " elementTypeCopy = elementType;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_208 = "() {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_209 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(";
  protected final String TEXT_210 = " source, ";
  protected final String TEXT_211 = " destination, int linkVID) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyVisualID = linkVID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_212 = " getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_213 = " getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_214 = " getLinkElement() {" + NL + "\t\treturn myLinkElement;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected int getVisualID() {" + NL + "\t\treturn myVisualID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_215 = " getSemanticAdapter() {" + NL + "\t\treturn mySemanticAdapter;" + NL + "\t}" + NL + "}";
  protected final String TEXT_216 = "\t" + NL + "" + NL + "}";

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
final boolean isSynchronizedDiagram = true;

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

    stringBuffer.append(TEXT_25);
    
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

    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    }
    
	for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
		GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_40);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    
	}

    stringBuffer.append(TEXT_45);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_46);
    }
    
// TODO: remove "createLinks()" method - this task should be done by canonicalEditPolicies

    stringBuffer.append(TEXT_47);
    
boolean generateGetCompartment = false;

for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_48);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_51);
    	{
		List genNodes = nextContainer.getContainedNodes();
    stringBuffer.append(TEXT_52);
    
Map genFeature2genNodeMap = new LinkedHashMap();
for (int nodeIndex = 0; nodeIndex < genNodes.size(); nodeIndex++) {
	GenNode nextNode = (GenNode) genNodes.get(nodeIndex);
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet.isPhantomElement()) {
		// Skipping top-level phantoms
		continue;
	}
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (!genFeature2genNodeMap.containsKey(childMetaFeature)) {
		genFeature2genNodeMap.put(childMetaFeature, new ArrayList());
	}
	((Collection) genFeature2genNodeMap.get(childMetaFeature)).add(nextNode);
}

Set entrySet = genFeature2genNodeMap.entrySet();
if (entrySet.size() > 0) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_54);
    
}

for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
	Collection genNodesCollection = (Collection) nextEntry.getValue();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_58);
    	} else {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_60);
    	}
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_62);
    	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {
    stringBuffer.append(TEXT_63);
    	}
	
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_65);
    		} else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_67);
    		}
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    		if (generateSwitch) {
    stringBuffer.append(TEXT_73);
    		}
    stringBuffer.append(TEXT_74);
    	}
	if (generateSwitch) {
    stringBuffer.append(TEXT_75);
    	}
	if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_76);
    	}
}
    	}

	if (nextContainer instanceof GenNode) {
		GenNode nextNode = (GenNode) nextContainer;
		for (int i = 0; i < nextNode.getCompartments().size(); i++) {
			generateGetCompartment = true;
			GenCompartment nextCompartment = (GenCompartment) nextNode.getCompartments().get(i);
			String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
			String compartmentViewId = semanticHintsClassName + '.' + nextNode.getUniqueIdentifier() + "Compartments." + nextCompartment.getSemanticHintFieldName();

    stringBuffer.append(TEXT_77);
    stringBuffer.append(i == 0 ? importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node") : "");
    stringBuffer.append(TEXT_78);
    stringBuffer.append(compartmentViewId);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_80);
    
		}
	}
	if (false == nextContainer instanceof GenCompartment) {

    stringBuffer.append(TEXT_81);
    	}
    stringBuffer.append(TEXT_82);
    
}

if (generateGetCompartment) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_90);
    
}

    stringBuffer.append(TEXT_91);
    boolean createPhantoms = true;
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_98);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(childMetaFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_101);
    		if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_106);
    		} else {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_110);
    		}
    stringBuffer.append(TEXT_111);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getTargetMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_115);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getSourceMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_120);
    		} else {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_122);
    		}
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_125);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_126);
    		}
    stringBuffer.append(TEXT_127);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_128);
    
		}

    stringBuffer.append(TEXT_129);
    
	}
}

    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_132);
    
for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = true;

    stringBuffer.append(TEXT_133);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureModelFacet) {
	continue;
}
FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_136);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_141);
    	} else {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_145);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_148);
    	}
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_152);
    	if (createPhantoms) {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_156);
    	}
    stringBuffer.append(TEXT_157);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_158);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_159);
    	}
    stringBuffer.append(TEXT_160);
    
}

for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = false;

    stringBuffer.append(TEXT_161);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureModelFacet) {
	continue;
}
FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_164);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_169);
    	} else {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_173);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_176);
    	}
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(TEXT_181);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_182);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_183);
    	}
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(TEXT_194);
    
// an inner class 

    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}