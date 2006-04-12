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
  protected final String TEXT_8 = " model content\");" + NL + "\t\taddPage(myFileCreationPage);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean performFinish() {" + NL + "\t\tfinal EObject diagramModelObject = load();" + NL + "\t\tif (diagramModelObject == null) {" + NL + "\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to load user model\");" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\t\t" + NL + "\t\tIFile diagramFile = myFileCreationPage.createNewFile();" + NL + "\t\ttry {" + NL + "\t\t\tdiagramFile.setCharset(\"UTF-8\", new NullProgressMonitor()); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_9 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_10 = ".getInstance().logError(\"Unable to set charset for diagram file\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();" + NL + "\t\tfinal Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));" + NL + "" + NL + "\t\tList affectedFiles = new LinkedList();" + NL + "\t\taffectedFiles.add(mySelectedModelFile);" + NL + "\t\taffectedFiles.add(diagramFile);" + NL + "\t\t\t" + NL + "\t\tAbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain, \"Initializing diagram contents\", affectedFiles) { //$NON-NLS-1$" + NL + "\t\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {" + NL + "\t\t\t\tint diagramVID = ";
  protected final String TEXT_11 = ".INSTANCE.getDiagramVisualID(diagramModelObject);" + NL + "\t\t\t\tif (diagramVID != ";
  protected final String TEXT_12 = ") {" + NL + "\t\t\t\t\treturn CommandResult.newErrorCommandResult(\"Incorrect model object stored as a root resource object\"); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDiagram diagram = ViewService.createDiagram(diagramModelObject, \"";
  protected final String TEXT_13 = "\", ";
  protected final String TEXT_14 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tdiagramResource.getContents().add(diagram);";
  protected final String TEXT_15 = NL + "\t\t\t\tdiagramResource.getContents().add(diagram.getElement());";
  protected final String TEXT_16 = NL + "\t\t\t\tinitDiagramContents(diagram, diagramModelObject);";
  protected final String TEXT_17 = NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t\t" + NL + "\t\ttry {" + NL + "\t\t\tOperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);" + NL + "\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\tIDE.openEditor(myWorkbenchPage, diagramFile);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_18 = ".getInstance().logError(\"Unable to create model and diagram\", e); //$NON-NLS-1$" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\t";
  protected final String TEXT_19 = ".getInstance().logError(\"Save operation failed for: \" + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t} catch (PartInitException ex) {" + NL + "\t\t\t";
  protected final String TEXT_20 = ".getInstance().logError(\"Unable to open editor\", ex); //$NON-NLS-1$" + NL + "\t\t}\t\t\t" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate EObject load() {";
  protected final String TEXT_21 = NL + "\t\tResourceSet resourceSet = new ";
  protected final String TEXT_22 = "();";
  protected final String TEXT_23 = NL + "\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();";
  protected final String TEXT_24 = NL + "\t\ttry {" + NL + "\t\t\tResource resource = resourceSet.getResource(URI.createPlatformResourceURI(mySelectedModelFile.getFullPath().toString()), true);" + NL + "\t\t\treturn (EObject) resource.getContents().get(0);" + NL + "\t\t} catch (WrappedException ex) {" + NL + "\t\t\t";
  protected final String TEXT_25 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_29 = " myLinkDescriptors = new ";
  protected final String TEXT_30 = "();" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_31 = " myEObject2NodeMap = new ";
  protected final String TEXT_32 = "();" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void initDiagramContents(";
  protected final String TEXT_33 = " diagram, ";
  protected final String TEXT_34 = " diagramModelObject) {" + NL + "\tcreate";
  protected final String TEXT_35 = "Children(diagram, diagramModelObject);";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = " resource = diagramModelObject.eResource();" + NL + "for (";
  protected final String TEXT_38 = " it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t";
  protected final String TEXT_39 = " nextResourceObject = (";
  protected final String TEXT_40 = ") it.next();" + NL + "\tif (nextResourceObject == diagramModelObject) {" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tint nodeVID = ";
  protected final String TEXT_41 = ".INSTANCE.getNodeVisualID(diagram, nextResourceObject);" + NL + "\tswitch (nodeVID) {";
  protected final String TEXT_42 = NL + "\tcase ";
  protected final String TEXT_43 = ": {" + NL + "\t\t";
  protected final String TEXT_44 = " nextNode = ViewService.createNode(diagram, nextResourceObject, ";
  protected final String TEXT_45 = ".VISUAL_ID, ";
  protected final String TEXT_46 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextResourceObject, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_47 = "Children(nextNode, nextResourceObject);";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_50 = "\t}" + NL + "}";
  protected final String TEXT_51 = "\t\t" + NL + "\tcreateLinks(diagram);" + NL + "}";
  protected final String TEXT_52 = "\t" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_53 = "Children(";
  protected final String TEXT_54 = " viewObject, ";
  protected final String TEXT_55 = " modelObject) {";
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = "\t";
  protected final String TEXT_58 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_59 = "\tfor (";
  protected final String TEXT_60 = " values = ";
  protected final String TEXT_61 = ".iterator(); values.hasNext();) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_62 = ") values.next();";
  protected final String TEXT_63 = NL + "\tnextValue = ";
  protected final String TEXT_64 = ";";
  protected final String TEXT_65 = NL + "\tnodeVID = ";
  protected final String TEXT_66 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_67 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_68 = NL + "\tcase ";
  protected final String TEXT_69 = ": {";
  protected final String TEXT_70 = NL + "\tif (";
  protected final String TEXT_71 = " == nodeVID) {";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = " nextNode = ViewService.createNode(viewObject, nextValue, ";
  protected final String TEXT_74 = ".VISUAL_ID, ";
  protected final String TEXT_75 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextValue, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_76 = "Children(nextNode, nextValue);";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = "\t\tbreak;";
  protected final String TEXT_79 = "\t}";
  protected final String TEXT_80 = NL + "\t}";
  protected final String TEXT_81 = NL + "\t}";
  protected final String TEXT_82 = NL + "\t";
  protected final String TEXT_83 = " nextCompartment = getCompartment(viewObject, ";
  protected final String TEXT_84 = ".VISUAL_ID);" + NL + "\tif (nextCompartment != null) {" + NL + "\t\tcreate";
  protected final String TEXT_85 = "Children(nextCompartment, modelObject);" + NL + "\t}";
  protected final String TEXT_86 = NL + "\tstoreLinks(modelObject, viewObject.getDiagram());";
  protected final String TEXT_87 = NL + "}";
  protected final String TEXT_88 = NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_89 = " getCompartment(";
  protected final String TEXT_90 = " node, String name) {" + NL + "\tfor (";
  protected final String TEXT_91 = " it = node.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_92 = " nextView = (";
  protected final String TEXT_93 = ") it.next();" + NL + "\t\tif (nextView instanceof ";
  protected final String TEXT_94 = " && name.equals(nextView.getType())) {" + NL + "\t\t\treturn (";
  protected final String TEXT_95 = ") nextView;" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn null;" + NL + "}";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeLinks(";
  protected final String TEXT_99 = " container, ";
  protected final String TEXT_100 = " diagram) {" + NL + "\t";
  protected final String TEXT_101 = " containerMetaclass = container.eClass();" + NL + "\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\tstoreTypeModelFacetLinks(container, containerMetaclass);" + NL + "}" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void storeTypeModelFacetLinks(";
  protected final String TEXT_102 = " container, ";
  protected final String TEXT_103 = " containerMetaclass) {\t";
  protected final String TEXT_104 = "\t\t" + NL + "\tif (";
  protected final String TEXT_105 = ".eINSTANCE.get";
  protected final String TEXT_106 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_107 = "\t\t" + NL + "\t\tfor (";
  protected final String TEXT_108 = " values = ";
  protected final String TEXT_109 = ".iterator(); values.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_110 = " nextValue = ((";
  protected final String TEXT_111 = ") values.next());";
  protected final String TEXT_112 = NL + "\t\t";
  protected final String TEXT_113 = " nextValue = (";
  protected final String TEXT_114 = ") ";
  protected final String TEXT_115 = ";";
  protected final String TEXT_116 = NL + "\t\tObject structuralFeatureResult = ";
  protected final String TEXT_117 = ";" + NL + "\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_118 = ") {" + NL + "\t\t\t";
  protected final String TEXT_119 = " dst = (";
  protected final String TEXT_120 = ") structuralFeatureResult;";
  protected final String TEXT_121 = NL + "\t\t\tstructuralFeatureResult = ";
  protected final String TEXT_122 = ";" + NL + "\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_123 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_124 = " src = (";
  protected final String TEXT_125 = ") structuralFeatureResult;";
  protected final String TEXT_126 = NL + "\t\t\t";
  protected final String TEXT_127 = " src = container;";
  protected final String TEXT_128 = NL + "\t\t\tint linkVID = ";
  protected final String TEXT_129 = ".INSTANCE.getLinkWithClassVisualID(nextValue);" + NL + "\t\t\tif (";
  protected final String TEXT_130 = " == linkVID) {" + NL + "\t\t\t\tmyLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, linkVID));" + NL + "\t\t\t}";
  protected final String TEXT_131 = NL + "\t\t\t}";
  protected final String TEXT_132 = NL + "\t\t}";
  protected final String TEXT_133 = NL + "\t\t}";
  protected final String TEXT_134 = NL + "\t}";
  protected final String TEXT_135 = NL + "}" + NL + "" + NL + "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeFeatureModelFacetLinks(";
  protected final String TEXT_136 = " container, ";
  protected final String TEXT_137 = " containerMetaclass, Diagram diagram) {";
  protected final String TEXT_138 = NL;
  protected final String TEXT_139 = "\tif (";
  protected final String TEXT_140 = ".eINSTANCE.get";
  protected final String TEXT_141 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_142 = NL + "\t\tfor (";
  protected final String TEXT_143 = " destinations = ";
  protected final String TEXT_144 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_145 = " nextDestination = (";
  protected final String TEXT_146 = ") destinations.next();";
  protected final String TEXT_147 = NL + "\t\t";
  protected final String TEXT_148 = " nextDestination = (";
  protected final String TEXT_149 = ") ";
  protected final String TEXT_150 = ";";
  protected final String TEXT_151 = NL + "\t\tif (";
  protected final String TEXT_152 = " == ";
  protected final String TEXT_153 = ".INSTANCE.getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_154 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = "));";
  protected final String TEXT_158 = NL + "\t\t";
  protected final String TEXT_159 = " nextNode = ViewService.createNode(diagram, nextDestination, ";
  protected final String TEXT_160 = ".VISUAL_ID, ";
  protected final String TEXT_161 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextDestination, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_162 = "Children(nextNode, nextDestination);";
  protected final String TEXT_163 = NL;
  protected final String TEXT_164 = NL + "\t\t}";
  protected final String TEXT_165 = NL + "\t\t}";
  protected final String TEXT_166 = NL + "\t}";
  protected final String TEXT_167 = NL;
  protected final String TEXT_168 = "\tif (";
  protected final String TEXT_169 = ".eINSTANCE.get";
  protected final String TEXT_170 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_171 = NL + "\t\tfor (";
  protected final String TEXT_172 = " destinations = ";
  protected final String TEXT_173 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_174 = " nextDestination = (";
  protected final String TEXT_175 = ") destinations.next();";
  protected final String TEXT_176 = NL + "\t\t";
  protected final String TEXT_177 = " nextDestination = (";
  protected final String TEXT_178 = ") ";
  protected final String TEXT_179 = ";";
  protected final String TEXT_180 = NL + "\t\tif (";
  protected final String TEXT_181 = " == ";
  protected final String TEXT_182 = ".INSTANCE.getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_183 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = ", ";
  protected final String TEXT_186 = "));";
  protected final String TEXT_187 = NL;
  protected final String TEXT_188 = NL + "\t\t}";
  protected final String TEXT_189 = NL + "\t\t}";
  protected final String TEXT_190 = NL + "\t}";
  protected final String TEXT_191 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void createLinks(";
  protected final String TEXT_192 = " diagram) {" + NL + "\tfor (";
  protected final String TEXT_193 = " it = myLinkDescriptors.iterator(); it.hasNext();) {" + NL + "\t\tLinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();" + NL + "\t\t";
  protected final String TEXT_194 = " edge = (";
  protected final String TEXT_195 = ") ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, \"\", ";
  protected final String TEXT_196 = ".APPEND, ";
  protected final String TEXT_197 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tif (edge != null) {" + NL + "\t\t\tedge.setSource((";
  protected final String TEXT_198 = ") myEObject2NodeMap.get(nextLinkDescriptor.getSource()));" + NL + "\t\t\tedge.setTarget((";
  protected final String TEXT_199 = ") myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_200 = NL;
  protected final String TEXT_201 = "/**" + NL + " * @generated" + NL + " */" + NL + "private class LinkDescriptor {" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_202 = " mySource;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_203 = " myDestination;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_204 = " myLinkElement;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate int myVisualID;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_205 = " mySemanticAdapter;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_206 = " source, ";
  protected final String TEXT_207 = " destination, ";
  protected final String TEXT_208 = " linkElement, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = linkElement;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_209 = "(linkElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_210 = " source, ";
  protected final String TEXT_211 = " destination, ";
  protected final String TEXT_212 = " elementType, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = null;" + NL + "\t\tfinal ";
  protected final String TEXT_213 = " elementTypeCopy = elementType;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_214 = "() {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_215 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(";
  protected final String TEXT_216 = " source, ";
  protected final String TEXT_217 = " destination, int linkVID) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyVisualID = linkVID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_218 = " getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_219 = " getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_220 = " getLinkElement() {" + NL + "\t\treturn myLinkElement;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected int getVisualID() {" + NL + "\t\treturn myVisualID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_221 = " getSemanticAdapter() {" + NL + "\t\treturn mySemanticAdapter;" + NL + "\t}" + NL + "}";
  protected final String TEXT_222 = "\t" + NL + "" + NL + "}";

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
    final StringBuffer stringBuffer = new StringBuffer();
    
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_14);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_15);
    
}
if (!isSynchronizedDiagram) {

    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_20);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_22);
    } else {
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_25);
    if (!isSynchronizedDiagram) {
    stringBuffer.append(TEXT_26);
    
List genLinks = genDiagram.getLinks();

    stringBuffer.append(TEXT_27);
    
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

    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    
}
for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
	GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_42);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    }
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_50);
    }
    
// TODO: remove "createLinks()" method - this task should be done by canonicalEditPolicies

    stringBuffer.append(TEXT_51);
    
boolean generateGetCompartment = false;

for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_52);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_55);
    	{
		List genNodes = nextContainer.getContainedNodes();
    stringBuffer.append(TEXT_56);
    
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

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_58);
    
}

for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
	Collection genNodesCollection = (Collection) nextEntry.getValue();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_62);
    	} else {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_64);
    	}
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {
    stringBuffer.append(TEXT_67);
    	}
	
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_69);
    		} else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_71);
    		}
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    		if (generateSwitch) {
    stringBuffer.append(TEXT_78);
    		}
    stringBuffer.append(TEXT_79);
    	}
	if (generateSwitch) {
    stringBuffer.append(TEXT_80);
    	}
	if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_81);
    	}
}
    	}

	if (nextContainer instanceof GenNode) {
		GenNode nextNode = (GenNode) nextContainer;
		for (int i = 0; i < nextNode.getCompartments().size(); i++) {
			generateGetCompartment = true;
			GenCompartment nextCompartment = (GenCompartment) nextNode.getCompartments().get(i);

    stringBuffer.append(TEXT_82);
    stringBuffer.append(i == 0 ? importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node") : "");
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(nextCompartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_85);
    
		}
	}
	if (false == nextContainer instanceof GenCompartment) {

    stringBuffer.append(TEXT_86);
    	}
    stringBuffer.append(TEXT_87);
    
}

if (generateGetCompartment) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_95);
    
}

    stringBuffer.append(TEXT_96);
    boolean createPhantoms = true;
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_103);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(childMetaFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_106);
    		if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_111);
    		} else {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_115);
    		}
    stringBuffer.append(TEXT_116);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getTargetMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_120);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getSourceMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_125);
    		} else {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_127);
    		}
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_130);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_131);
    		}
    stringBuffer.append(TEXT_132);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_133);
    
		}

    stringBuffer.append(TEXT_134);
    
	}
}

    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_137);
    
for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = true;

    stringBuffer.append(TEXT_138);
    
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

    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_141);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_146);
    	} else {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_150);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_153);
    	}
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_157);
    	if (createPhantoms) {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_162);
    	}
    stringBuffer.append(TEXT_163);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_164);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_165);
    	}
    stringBuffer.append(TEXT_166);
    
}

for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = false;

    stringBuffer.append(TEXT_167);
    
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

    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_170);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_175);
    	} else {
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_179);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_180);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_182);
    	}
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(TEXT_187);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_188);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_189);
    	}
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(TEXT_200);
    
// an inner class 

    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}