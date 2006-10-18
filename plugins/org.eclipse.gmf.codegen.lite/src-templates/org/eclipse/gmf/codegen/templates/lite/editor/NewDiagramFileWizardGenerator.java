package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.common.codegen.*;

public class NewDiagramFileWizardGenerator
{
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
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "((";
  protected final String TEXT_6 = ")";
  protected final String TEXT_7 = "((";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = ".eGet(";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "())";
  protected final String TEXT_13 = ")";
  protected final String TEXT_14 = "((";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = "()";
  protected final String TEXT_19 = NL + NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_20 = " extends ";
  protected final String TEXT_21 = " {" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_22 = " myEditingDomain;" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_24 = " mySelectedModelFileURI;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate DiagramURISelectorPage myDiagramURISelectorPage;" + NL;
  protected final String TEXT_25 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_26 = " mySelectedModelFile;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_27 = " myFileCreationPage;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_28 = " myWorkbenchPage;" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_29 = " mySelection;" + NL;
  protected final String TEXT_30 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_31 = " myDiagramRoot;" + NL;
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_33 = "(";
  protected final String TEXT_34 = " selectedModelFileURI, ";
  protected final String TEXT_35 = " diagramRoot, ";
  protected final String TEXT_36 = " editingDomain) {";
  protected final String TEXT_37 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_38 = "(";
  protected final String TEXT_39 = " selectedModelFile, ";
  protected final String TEXT_40 = " workbenchPage, ";
  protected final String TEXT_41 = " selection, ";
  protected final String TEXT_42 = " diagramRoot, ";
  protected final String TEXT_43 = " editingDomain) {" + NL + "\t\tassert selectedModelFile != null : \"Null selectedModelFile in ";
  protected final String TEXT_44 = " constructor\"; //$NON-NLS-1$" + NL + "\t\tassert workbenchPage != null : \"Null workbenchPage in ";
  protected final String TEXT_45 = " constructor\"; //$NON-NLS-1$" + NL + "\t\tassert selection != null : \"Null selection in ";
  protected final String TEXT_46 = " constructor\"; //$NON-NLS-1$" + NL + "\t    assert diagramRoot != null : \"Null diagramRoot in ";
  protected final String TEXT_47 = " constructor\"; //$NON-NLS-1$";
  protected final String TEXT_48 = NL + "\t    assert editingDomain != null : \"Null editingDomain in ";
  protected final String TEXT_49 = " constructor\"; //$NON-NLS-1$" + NL + "\t    ";
  protected final String TEXT_50 = NL + "\t   \tmySelectedModelFileURI = selectedModelFileURI;";
  protected final String TEXT_51 = NL + "\t   \tmySelectedModelFile = selectedModelFile;" + NL + "\t   \tmyWorkbenchPage = workbenchPage;" + NL + "\t   \tmySelection = selection;";
  protected final String TEXT_52 = NL + "\t   \tmyDiagramRoot = diagramRoot;" + NL + "\t   \tmyEditingDomain = editingDomain;" + NL + "\t\tsetDefaultPageImageDescriptor(";
  protected final String TEXT_53 = ".getBundledImageDescriptor(" + NL + "\t\t\t\"icons/wizban/New";
  protected final String TEXT_54 = "Wizard.gif\")); //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addPages() {";
  protected final String TEXT_55 = NL + "\t\tif (mySelectedModelFileURI == null) {" + NL + "\t\t\taddPage(new SourceURISelectorPage());" + NL + "\t\t}" + NL + "\t\tmyDiagramURISelectorPage = new DiagramURISelectorPage();" + NL + "\t\taddPage(myDiagramURISelectorPage);";
  protected final String TEXT_56 = NL + "\t\tmyFileCreationPage = new ";
  protected final String TEXT_57 = "(\"Initialize new ";
  protected final String TEXT_58 = " diagram file\", mySelection) {" + NL + "\t\t\tpublic void createControl(";
  protected final String TEXT_59 = " parent) {" + NL + "\t\t\t\tsuper.createControl(parent);" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_60 = " parentContainer = mySelectedModelFile.getParent();" + NL + "\t\t\t\tString originalFileName = mySelectedModelFile.getProjectRelativePath().removeFileExtension().lastSegment();" + NL + "\t\t\t\tString fileExtension = \".";
  protected final String TEXT_61 = "\"; //$NON-NLS-1$" + NL + "\t\t\t\tString fileName = originalFileName + fileExtension;" + NL + "\t\t\t\tfor (int i = 1; i > 0 && parentContainer.getFile(new ";
  protected final String TEXT_62 = "(fileName)).exists(); i++) {" + NL + "\t\t\t\t\tfileName = originalFileName + i + fileExtension;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (parentContainer.getFile(new ";
  protected final String TEXT_63 = "(fileName)).exists()) {" + NL + "\t\t\t\t\treturn;\t//failed to set name that does not exist, just leave empty." + NL + "\t\t\t\t}" + NL + "\t\t\t\tsetFileName(fileName);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tmyFileCreationPage.setTitle(\"Diagram file\");" + NL + "\t\tmyFileCreationPage.setDescription(\"Create new diagram based on ";
  protected final String TEXT_64 = " model content\");" + NL + "\t\taddPage(myFileCreationPage);";
  protected final String TEXT_65 = NL + "\t\taddPage(new RootElementSelectorPage());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean performFinish() {" + NL + "\t\t";
  protected final String TEXT_66 = " resourceSet = myEditingDomain.getResourceSet();";
  protected final String TEXT_67 = NL + "\t\t";
  protected final String TEXT_68 = " diagramFileURI = myDiagramURISelectorPage.getNewFileURI();" + NL + "\t\tfinal ";
  protected final String TEXT_69 = " diagramResource = resourceSet.createResource(diagramFileURI);";
  protected final String TEXT_70 = NL + "\t\t";
  protected final String TEXT_71 = " diagramFile = myFileCreationPage.createNewFile();" + NL + "\t\ttry {" + NL + "\t\t\tdiagramFile.setCharset(\"UTF-8\", new ";
  protected final String TEXT_72 = "()); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_73 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_74 = ".getInstance().logError(\"Unable to set charset for diagram file\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "" + NL + "\t\tfinal ";
  protected final String TEXT_75 = " diagramResource = resourceSet.createResource(";
  protected final String TEXT_76 = ".createPlatformResourceURI(diagramFile.getFullPath().toString()));";
  protected final String TEXT_77 = NL + "\t\t";
  protected final String TEXT_78 = " command = new ";
  protected final String TEXT_79 = "(\"Initializing diagram contents\") { //$NON-NLS-1$" + NL + "\t\t\tprivate ";
  protected final String TEXT_80 = " myCreatedDiagram;" + NL + "" + NL + "\t\t\tprotected boolean prepare() {" + NL + "\t\t\t\tint diagramVID = ";
  protected final String TEXT_81 = ".INSTANCE.getDiagramVisualID(myDiagramRoot);" + NL + "\t\t\t\tif (diagramVID != ";
  protected final String TEXT_82 = ".VISUAL_ID) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\tpublic void execute() {" + NL + "\t\t\t\tmyCreatedDiagram = ";
  protected final String TEXT_83 = ".eINSTANCE.createDiagram();" + NL + "\t\t\t\tmyCreatedDiagram.setElement(myDiagramRoot);" + NL + "\t\t\t\t";
  protected final String TEXT_84 = ".INSTANCE.decorateView(myCreatedDiagram);" + NL + "\t\t\t\tdiagramResource.getContents().add(myCreatedDiagram);";
  protected final String TEXT_85 = NL + "\t\t\t\tdiagramResource.getContents().add(myCreatedDiagram.getElement());";
  protected final String TEXT_86 = NL + "\t\t\t\tinitDiagramContents(myCreatedDiagram);" + NL + "\t\t\t}" + NL + "\t\t\tpublic void redo() {" + NL + "\t\t\t\texecute();" + NL + "\t\t\t}" + NL + "\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\ttry {" + NL + "\t\t\tnew ";
  protected final String TEXT_87 = "(myEditingDomain, command).execute();" + NL + "\t\t\tdiagramResource.save(";
  protected final String TEXT_88 = ".EMPTY_MAP);";
  protected final String TEXT_89 = NL + "\t\t\t";
  protected final String TEXT_90 = " editor = ";
  protected final String TEXT_91 = ".openEditor(diagramResource.getURI());";
  protected final String TEXT_92 = NL + "\t\t\t";
  protected final String TEXT_93 = " editor = ";
  protected final String TEXT_94 = ".openEditor(myWorkbenchPage, diagramFile);";
  protected final String TEXT_95 = NL + "\t\t\tif (editor != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_96 = " layouter = (";
  protected final String TEXT_97 = ") editor.getAdapter(";
  protected final String TEXT_98 = ".class);" + NL + "\t\t\t\tif (layouter != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_99 = " graphicalViewer = (";
  protected final String TEXT_100 = ") editor.getAdapter(";
  protected final String TEXT_101 = ".class);" + NL + "\t\t\t\t\tif (graphicalViewer != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_102 = " layoutCommand = layouter.layout((";
  protected final String TEXT_103 = ") graphicalViewer.getContents());" + NL + "\t\t\t\t\t\tif (layoutCommand != null && layoutCommand.canExecute()) {" + NL + "\t\t\t\t\t\t\tnew ";
  protected final String TEXT_104 = "(myEditingDomain, layoutCommand).execute();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} catch (";
  protected final String TEXT_105 = " ex) {";
  protected final String TEXT_106 = NL + "\t\t\t";
  protected final String TEXT_107 = ".getInstance().logError(\"Save operation failed for: \" + diagramFileURI.toString(), ex); //$NON-NLS-1$";
  protected final String TEXT_108 = NL + "\t\t\t";
  protected final String TEXT_109 = ".getInstance().logError(\"Save operation failed for: \" + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$" + NL + "\t\t} catch (";
  protected final String TEXT_110 = " ex) {" + NL + "\t\t\t";
  protected final String TEXT_111 = ".getInstance().logError(\"Unable to open editor\", ex); //$NON-NLS-1$";
  protected final String TEXT_112 = NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = "/**" + NL + " * @generated" + NL + " */" + NL + "private void initDiagramContents(";
  protected final String TEXT_115 = " diagram) {" + NL + "\tcreate";
  protected final String TEXT_116 = "Children(diagram);";
  protected final String TEXT_117 = NL + "\tmyViewService = new ";
  protected final String TEXT_118 = "(diagram);" + NL + "\tcreate";
  protected final String TEXT_119 = "ChildLinks(diagram);";
  protected final String TEXT_120 = NL + "}" + NL;
  protected final String TEXT_121 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_122 = "Children(";
  protected final String TEXT_123 = " viewObject) {";
  protected final String TEXT_124 = NL + "\tfor(";
  protected final String TEXT_125 = " it = viewObject.getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_126 = " next = (";
  protected final String TEXT_127 = ") it.next();" + NL + "\t\tint visualID = ";
  protected final String TEXT_128 = ".getVisualID(next);" + NL + "\t\tswitch (visualID) {";
  protected final String TEXT_129 = NL + "\t\tcase ";
  protected final String TEXT_130 = ".VISUAL_ID:" + NL + "\t\t\tcreate";
  protected final String TEXT_131 = "Children(next);" + NL + "\t\t\tbreak;";
  protected final String TEXT_132 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_133 = NL + "\t";
  protected final String TEXT_134 = " semanticChildren = get";
  protected final String TEXT_135 = "SemanticChildNodes(viewObject);" + NL + "\tfor(";
  protected final String TEXT_136 = " it = semanticChildren.iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_137 = " nextDescriptor = (";
  protected final String TEXT_138 = ") it.next();" + NL + "\t\t";
  protected final String TEXT_139 = " createCommand = getCreate";
  protected final String TEXT_140 = "NotationalChildNodeCommand(viewObject, nextDescriptor);" + NL + "\t\tif (createCommand != null && createCommand.canExecute()) {" + NL + "\t\t\tcreateCommand.execute();";
  protected final String TEXT_141 = NL + "\t\t\t";
  protected final String TEXT_142 = " nextChild = createCommand.getCreatedView();" + NL + "\t\t\tint childVisualID = nextDescriptor.getVisualID();" + NL + "\t\t\tswitch (childVisualID) {";
  protected final String TEXT_143 = NL + "\t\t\tcase ";
  protected final String TEXT_144 = ".VISUAL_ID:" + NL + "\t\t\t\tcreate";
  protected final String TEXT_145 = "Children(nextChild);" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_146 = NL + "\t\t\t}";
  protected final String TEXT_147 = NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_148 = " get";
  protected final String TEXT_149 = "SemanticChildNodes(";
  protected final String TEXT_150 = " parentView) {";
  protected final String TEXT_151 = NL;
  protected final String TEXT_152 = NL + "\treturn ";
  protected final String TEXT_153 = ".EMPTY_LIST;";
  protected final String TEXT_154 = NL + "\t";
  protected final String TEXT_155 = " result = new ";
  protected final String TEXT_156 = "();";
  protected final String TEXT_157 = NL + "\t";
  protected final String TEXT_158 = " viewObject = ";
  protected final String TEXT_159 = ";" + NL + "\t";
  protected final String TEXT_160 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_161 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_162 = NL + "\tfor(";
  protected final String TEXT_163 = " it = ";
  protected final String TEXT_164 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_165 = ") it.next();";
  protected final String TEXT_166 = NL + "\tnextValue = (";
  protected final String TEXT_167 = ")";
  protected final String TEXT_168 = ";";
  protected final String TEXT_169 = NL + "\tnodeVID = ";
  protected final String TEXT_170 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_171 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_172 = NL + "\tcase ";
  protected final String TEXT_173 = ".VISUAL_ID: {";
  protected final String TEXT_174 = NL + "\tif (";
  protected final String TEXT_175 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_176 = NL + "\t\tresult.add(new ";
  protected final String TEXT_177 = "(nextValue, nodeVID));";
  protected final String TEXT_178 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_179 = NL + "\t\t}";
  protected final String TEXT_180 = NL + "\t}";
  protected final String TEXT_181 = NL + "\t}";
  protected final String TEXT_182 = NL + "\treturn result;";
  protected final String TEXT_183 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_184 = " getCreate";
  protected final String TEXT_185 = "NotationalChildNodeCommand(";
  protected final String TEXT_186 = " parentView, ";
  protected final String TEXT_187 = " descriptor) {";
  protected final String TEXT_188 = NL;
  protected final String TEXT_189 = "\t\t\t";
  protected final String TEXT_190 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_191 = NL + "\t\t\tcase ";
  protected final String TEXT_192 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_193 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_194 = "(";
  protected final String TEXT_195 = ", domainElement, ";
  protected final String TEXT_196 = "new ";
  protected final String TEXT_197 = "(0, 0, ";
  protected final String TEXT_198 = ", ";
  protected final String TEXT_199 = ")";
  protected final String TEXT_200 = NL + "null";
  protected final String TEXT_201 = ", ";
  protected final String TEXT_202 = ".INSTANCE);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_203 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_204 = NL + "}";
  protected final String TEXT_205 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_206 = "ChildLinks(";
  protected final String TEXT_207 = " viewObject) {";
  protected final String TEXT_208 = NL + "\t";
  protected final String TEXT_209 = " semanticChildLinks = get";
  protected final String TEXT_210 = "SemanticChildLinks(viewObject);" + NL + "\tfor(";
  protected final String TEXT_211 = " it = semanticChildLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_212 = " nextDescriptor = (";
  protected final String TEXT_213 = ") it.next();" + NL + "\t\t";
  protected final String TEXT_214 = " createCommand = getCreate";
  protected final String TEXT_215 = "NotationalChildLinkCommand(viewObject, nextDescriptor);" + NL + "\t\tif (createCommand != null && createCommand.canExecute()) {" + NL + "\t\t\tcreateCommand.execute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_216 = NL + "\tfor(";
  protected final String TEXT_217 = " it = viewObject.getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_218 = " next = (";
  protected final String TEXT_219 = ") it.next();" + NL + "\t\tint visualID = ";
  protected final String TEXT_220 = ".getVisualID(next);" + NL + "\t\tswitch (visualID) {";
  protected final String TEXT_221 = NL + "\t\tcase ";
  protected final String TEXT_222 = ".VISUAL_ID:" + NL + "\t\t\tcreate";
  protected final String TEXT_223 = "ChildLinks(next);" + NL + "\t\t\tbreak;";
  protected final String TEXT_224 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_225 = NL + "}" + NL;
  protected final String TEXT_226 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_227 = " get";
  protected final String TEXT_228 = "SemanticChildLinks(";
  protected final String TEXT_229 = " parentView) {";
  protected final String TEXT_230 = NL;
  protected final String TEXT_231 = "\t";
  protected final String TEXT_232 = " result = new ";
  protected final String TEXT_233 = "();";
  protected final String TEXT_234 = NL + "\t";
  protected final String TEXT_235 = " modelObject = ";
  protected final String TEXT_236 = ".getElement();" + NL + "\t";
  protected final String TEXT_237 = " nextValue;";
  protected final String TEXT_238 = NL + "\tint linkVID;";
  protected final String TEXT_239 = NL + "\tfor(";
  protected final String TEXT_240 = " it = ";
  protected final String TEXT_241 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_242 = ") it.next();";
  protected final String TEXT_243 = NL + "\tnextValue = (";
  protected final String TEXT_244 = ")";
  protected final String TEXT_245 = ";";
  protected final String TEXT_246 = NL + "\tlinkVID = ";
  protected final String TEXT_247 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_248 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_249 = NL + "\tcase ";
  protected final String TEXT_250 = ".VISUAL_ID: {";
  protected final String TEXT_251 = NL + "\tif (";
  protected final String TEXT_252 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_253 = NL + "\t\t";
  protected final String TEXT_254 = " source = (";
  protected final String TEXT_255 = ")";
  protected final String TEXT_256 = ";";
  protected final String TEXT_257 = NL + "\t\t";
  protected final String TEXT_258 = " source = ";
  protected final String TEXT_259 = ".getElement();";
  protected final String TEXT_260 = NL + "\t\t";
  protected final String TEXT_261 = " target = (";
  protected final String TEXT_262 = ")";
  protected final String TEXT_263 = ";";
  protected final String TEXT_264 = NL + "\t\t";
  protected final String TEXT_265 = " target = ";
  protected final String TEXT_266 = ".getElement();";
  protected final String TEXT_267 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_268 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_269 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_270 = NL + "\t}";
  protected final String TEXT_271 = NL + "\t}";
  protected final String TEXT_272 = NL + "\t}";
  protected final String TEXT_273 = NL + "\tfor(";
  protected final String TEXT_274 = " it = ";
  protected final String TEXT_275 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_276 = ") it.next();";
  protected final String TEXT_277 = NL + "\tnextValue = (";
  protected final String TEXT_278 = ")";
  protected final String TEXT_279 = ";";
  protected final String TEXT_280 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_281 = NL + "\t\tresult.add(new ";
  protected final String TEXT_282 = "(modelObject, nextValue, null, ";
  protected final String TEXT_283 = ".VISUAL_ID));";
  protected final String TEXT_284 = NL + "\t}";
  protected final String TEXT_285 = NL + "\t}";
  protected final String TEXT_286 = NL + "\treturn result;";
  protected final String TEXT_287 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_288 = " getCreate";
  protected final String TEXT_289 = "NotationalChildLinkCommand(";
  protected final String TEXT_290 = " parentView, ";
  protected final String TEXT_291 = " linkDescriptor) {";
  protected final String TEXT_292 = NL;
  protected final String TEXT_293 = "\t\t\t";
  protected final String TEXT_294 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_295 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\t";
  protected final String TEXT_296 = " decorator = null;" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_297 = NL + "\t\t\tcase ";
  protected final String TEXT_298 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_299 = ") {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_300 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_301 = NL + "\t\t\tcase ";
  protected final String TEXT_302 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_303 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_304 = NL + "\t\t\t}" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_305 = "(";
  protected final String TEXT_306 = ", linkDescriptor.getElement(), sourceView, targetView, decorator);";
  protected final String TEXT_307 = NL + "}";
  protected final String TEXT_308 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_309 = " myViewService;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_310 = " getViewService() {" + NL + "\treturn myViewService;" + NL + "}";
  protected final String TEXT_311 = NL;
  protected final String TEXT_312 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate abstract class URISelectorPage extends ";
  protected final String TEXT_313 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_314 = " fileField;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected URISelectorPage(String name) {" + NL + "\t\t\tsuper(name);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void createControl(";
  protected final String TEXT_315 = " parent) {" + NL + "\t\t\t";
  protected final String TEXT_316 = " composite = new ";
  protected final String TEXT_317 = "(parent, ";
  protected final String TEXT_318 = ".NONE);" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_319 = " layout = new ";
  protected final String TEXT_320 = "();" + NL + "\t\t\t\tlayout.numColumns = 1;" + NL + "\t\t\t\tlayout.verticalSpacing = 12;" + NL + "\t\t\t\tcomposite.setLayout(layout);" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_321 = " data = new ";
  protected final String TEXT_322 = "();" + NL + "\t\t\t\tdata.verticalAlignment = ";
  protected final String TEXT_323 = ".FILL;" + NL + "\t\t\t\tdata.grabExcessVerticalSpace = true;" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_324 = ".FILL;" + NL + "\t\t\t\tcomposite.setLayoutData(data);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_325 = " resourceURILabel = new ";
  protected final String TEXT_326 = "(composite, ";
  protected final String TEXT_327 = ".LEFT);" + NL + "\t\t\t{" + NL + "\t\t\t\tresourceURILabel.setText(\"&File\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_328 = " data = new ";
  protected final String TEXT_329 = "();" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_330 = ".FILL;" + NL + "\t\t\t\tresourceURILabel.setLayoutData(data);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_331 = " fileComposite = new ";
  protected final String TEXT_332 = "(composite, ";
  protected final String TEXT_333 = ".NONE);" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_334 = " data = new ";
  protected final String TEXT_335 = "();" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_336 = ".FILL;" + NL + "\t\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\t\tfileComposite.setLayoutData(data);" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_337 = " layout = new ";
  protected final String TEXT_338 = "();" + NL + "\t\t\t\tlayout.marginHeight = 0;" + NL + "\t\t\t\tlayout.marginWidth = 0;" + NL + "\t\t\t\tlayout.numColumns = 2;" + NL + "\t\t\t\tfileComposite.setLayout(layout);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfileField = new ";
  protected final String TEXT_339 = "(fileComposite, ";
  protected final String TEXT_340 = ".BORDER);" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_341 = " data = new ";
  protected final String TEXT_342 = "();" + NL + "\t\t\t\tdata.horizontalAlignment = ";
  protected final String TEXT_343 = ".FILL;" + NL + "\t\t\t\tdata.grabExcessHorizontalSpace = true;" + NL + "\t\t\t\tdata.horizontalSpan = 1;" + NL + "\t\t\t\tfileField.setLayoutData(data);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfileField.addModifyListener(validator);" + NL + "\t\t\t";
  protected final String TEXT_344 = " resourceURIBrowseFileSystemButton = new ";
  protected final String TEXT_345 = "(fileComposite," + NL + "\t\t\t\t\t";
  protected final String TEXT_346 = ".PUSH);" + NL + "\t\t\tresourceURIBrowseFileSystemButton.setText(\"&Browse\");" + NL + "" + NL + "\t\t\tresourceURIBrowseFileSystemButton" + NL + "\t\t\t\t\t.addSelectionListener(new ";
  protected final String TEXT_347 = "() {" + NL + "\t\t\t\t\t\tpublic void widgetSelected(";
  protected final String TEXT_348 = " event) {" + NL + "\t\t\t\t\t\t\tString fileExtension = getFileExtension();" + NL + "\t\t\t\t\t\t\tString filePath = ";
  protected final String TEXT_349 = ".openFilePathDialog(getShell(), \"*.\" + fileExtension, ";
  protected final String TEXT_350 = ".OPEN);" + NL + "\t\t\t\t\t\t\tif (filePath != null) {" + NL + "\t\t\t\t\t\t\t\tif (!filePath.endsWith(\".\" + fileExtension)) {" + NL + "\t\t\t\t\t\t\t\t\tfilePath = filePath + \".\" + fileExtension;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tfileField.setText(filePath);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t});" + NL + "\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\tsetControl(composite);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_351 = " validator = new ";
  protected final String TEXT_352 = "() {" + NL + "\t\t\tpublic void modifyText(";
  protected final String TEXT_353 = " e) {" + NL + "\t\t\t\tsetPageComplete(validatePage());" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected final void setFile(";
  protected final String TEXT_354 = " file) {" + NL + "\t\t\tfileField.setText(file.getPath());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean validatePage() {" + NL + "\t\t\t";
  protected final String TEXT_355 = " fileURI = getFileURI();" + NL + "\t\t\tif (fileURI == null || fileURI.isEmpty()) {" + NL + "\t\t\t\tsetErrorMessage(null);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tif (fileURI.isFile()) {" + NL + "\t\t\t\t";
  protected final String TEXT_356 = " file = new ";
  protected final String TEXT_357 = "(fileURI.toFileString());" + NL + "\t\t\t\tString fileProblem = validateFile(file);" + NL + "\t\t\t\tif (fileProblem != null) {" + NL + "\t\t\t\t\tsetErrorMessage(fileProblem);" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tString requiredExt = getFileExtension();" + NL + "\t\t\tString enteredExt = fileURI.fileExtension();" + NL + "\t\t\tif (enteredExt == null || !enteredExt.equals(requiredExt)) {" + NL + "\t\t\t\tsetErrorMessage(\"The file name must end in \" + requiredExt);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tsetErrorMessage(null);" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Checks the given file and returns the error message if there are problems or <code>null</code> if the file is OK." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract String validateFile(";
  protected final String TEXT_358 = " file);" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract String getFileExtension();" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_359 = " getFileURI() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_360 = ".createFileURI(fileField.getText());" + NL + "\t\t\t} catch (Exception exception) {" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate class SourceURISelectorPage extends URISelectorPage {" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic SourceURISelectorPage() {" + NL + "\t\t\tsuper(\"Select source file\");" + NL + "\t\t\tsetTitle(\"Source file\");" + NL + "\t\t\tsetDescription(\"Select file with semantic model element to be depicted on diagram\");" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getFileExtension() {" + NL + "\t\t\treturn \"";
  protected final String TEXT_361 = "\";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean validatePage() {" + NL + "\t\t\tif (super.validatePage()) {" + NL + "\t\t\t\tmySelectedModelFileURI = getFileURI();" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String validateFile(";
  protected final String TEXT_362 = " file) {" + NL + "\t\t\tif (!file.exists()) {" + NL + "\t\t\t\treturn \"Source file does not exist\";" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate class DiagramURISelectorPage extends URISelectorPage {" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_363 = " myNewFileURI;" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic DiagramURISelectorPage() {" + NL + "\t\t\tsuper(\"Initialize new ";
  protected final String TEXT_364 = " diagram file\");" + NL + "\t\t\tsetTitle(\"Diagram file\");" + NL + "\t\t\tsetDescription(\"Create new diagram based on ";
  protected final String TEXT_365 = " model content\");" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getFileExtension() {" + NL + "\t\t\treturn \"";
  protected final String TEXT_366 = "\";" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setVisible(boolean visible) {" + NL + "\t\t\tsuper.setVisible(visible);" + NL + "\t\t\tif (visible && mySelectedModelFileURI != null && getFileURI() == null && mySelectedModelFileURI.isFile()) {" + NL + "\t\t\t\t";
  protected final String TEXT_367 = " originalFile = new ";
  protected final String TEXT_368 = "(mySelectedModelFileURI.toFileString());" + NL + "\t\t\t\tString originalFileName = mySelectedModelFileURI.trimFileExtension().lastSegment();" + NL + "\t\t\t\t";
  protected final String TEXT_369 = " parentFile = originalFile.getParentFile();" + NL + "\t\t\t\t";
  protected final String TEXT_370 = " newFile = new ";
  protected final String TEXT_371 = "(parentFile, originalFileName + getFileExtension());" + NL + "\t\t\t\tfor(int i = 1; i > 0 && newFile.exists(); i++) {" + NL + "\t\t\t\t\tnewFile = new ";
  protected final String TEXT_372 = "(parentFile, originalFileName + i + getFileExtension());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (newFile.exists()) {" + NL + "\t\t\t\t\treturn;\t//failed to set name that does not exist, just leave empty." + NL + "\t\t\t\t}" + NL + "\t\t\t\tsetFile(newFile);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean validatePage() {" + NL + "\t\t\tmyNewFileURI = null;" + NL + "\t\t\tif (super.validatePage()) {" + NL + "\t\t\t\tmyNewFileURI = getFileURI();" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_373 = " getNewFileURI() {" + NL + "\t\t\treturn myNewFileURI;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t\t */" + NL + "\t\tprotected String validateFile(";
  protected final String TEXT_374 = " file) {" + NL + "\t\t\tif (file.exists()) {" + NL + "\t\t\t\treturn \"Diagram file already exists\";" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_375 = NL + "\t/**" + NL + "     * @generated" + NL + "\t */" + NL + "\tprivate class RootElementSelectorPage extends ";
  protected final String TEXT_376 = " implements ";
  protected final String TEXT_377 = " {";
  protected final String TEXT_378 = NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_379 = " myTreeViewer;";
  protected final String TEXT_380 = NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */" + NL + "\t\tprotected RootElementSelectorPage() {" + NL + "\t\t\tsuper(\"Select diagram root element\");" + NL + "\t\t\tsetTitle(\"Diagram root element\");" + NL + "\t\t\tsetDescription(\"Select semantic model element to be depicted on diagram\");" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic void createControl(";
  protected final String TEXT_381 = " parent) {" + NL + "\t\t\tinitializeDialogUnits(parent);" + NL + "\t\t\t";
  protected final String TEXT_382 = " topLevel = new ";
  protected final String TEXT_383 = "(parent, ";
  protected final String TEXT_384 = ".NONE);" + NL + "\t\t\ttopLevel.setLayout(new ";
  protected final String TEXT_385 = "());" + NL + "\t\t\ttopLevel.setLayoutData(new ";
  protected final String TEXT_386 = "(";
  protected final String TEXT_387 = ".VERTICAL_ALIGN_FILL | ";
  protected final String TEXT_388 = ".HORIZONTAL_ALIGN_FILL));" + NL + "\t\t\ttopLevel.setFont(parent.getFont());" + NL + "\t\t\tsetControl(topLevel);" + NL + "\t\t\tcreateModelBrowser(topLevel);" + NL + "\t\t\tsetPageComplete(validatePage());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void createModelBrowser(";
  protected final String TEXT_389 = " parent) {" + NL + "\t\t\t";
  protected final String TEXT_390 = " panel = new ";
  protected final String TEXT_391 = "(parent, ";
  protected final String TEXT_392 = ".NONE);" + NL + "\t\t\tpanel.setLayoutData(new ";
  protected final String TEXT_393 = "(";
  protected final String TEXT_394 = ".FILL_BOTH));" + NL + "\t\t\t";
  protected final String TEXT_395 = " layout = new ";
  protected final String TEXT_396 = "();" + NL + "\t\t\tlayout.marginWidth = 0;" + NL + "\t\t\tpanel.setLayout(layout);" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_397 = " label = new ";
  protected final String TEXT_398 = "(panel, ";
  protected final String TEXT_399 = ".NONE);" + NL + "\t\t\tlabel.setText(\"Select diagram root element:\");" + NL + "\t\t\tlabel.setLayoutData(new ";
  protected final String TEXT_400 = "(";
  protected final String TEXT_401 = ".HORIZONTAL_ALIGN_BEGINNING));";
  protected final String TEXT_402 = NL + "\t\t\t";
  protected final String TEXT_403 = " ";
  protected final String TEXT_404 = " = new ";
  protected final String TEXT_405 = "(panel, ";
  protected final String TEXT_406 = ".SINGLE | ";
  protected final String TEXT_407 = ".H_SCROLL | ";
  protected final String TEXT_408 = ".V_SCROLL | ";
  protected final String TEXT_409 = ".BORDER);" + NL + "\t\t\t";
  protected final String TEXT_410 = " layoutData = new ";
  protected final String TEXT_411 = "(";
  protected final String TEXT_412 = ".FILL_BOTH);" + NL + "\t\t\tlayoutData.heightHint = 300;" + NL + "\t\t\tlayoutData.widthHint = 300;" + NL + "\t\t\t";
  protected final String TEXT_413 = ".getTree().setLayoutData(layoutData);" + NL + "\t\t\t";
  protected final String TEXT_414 = ".setContentProvider(new ";
  protected final String TEXT_415 = "(";
  protected final String TEXT_416 = ".getInstance().getItemProvidersAdapterFactory()));" + NL + "\t\t\t";
  protected final String TEXT_417 = ".setLabelProvider(new ";
  protected final String TEXT_418 = "(";
  protected final String TEXT_419 = ".getInstance().getItemProvidersAdapterFactory()));";
  protected final String TEXT_420 = NL + "\t\t\t";
  protected final String TEXT_421 = ".setInput(myDiagramRoot.eResource());" + NL + "\t\t\t";
  protected final String TEXT_422 = ".setSelection(new ";
  protected final String TEXT_423 = "(myDiagramRoot));";
  protected final String TEXT_424 = NL + "\t\t\t";
  protected final String TEXT_425 = ".addSelectionChangedListener(this);" + NL + "\t\t}" + NL;
  protected final String TEXT_426 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setVisible(boolean visible) {" + NL + "\t\t\tif (visible) {" + NL + "\t\t\t\t";
  protected final String TEXT_427 = ".setInput(myEditingDomain.getResourceSet().getResource(mySelectedModelFileURI, true));" + NL + "\t\t\t\tif (myDiagramRoot != null) {" + NL + "\t\t\t\t\tmyTreeViewer.setSelection(new ";
  protected final String TEXT_428 = "(myDiagramRoot));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tsuper.setVisible(visible);" + NL + "\t\t}" + NL;
  protected final String TEXT_429 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void selectionChanged(";
  protected final String TEXT_430 = " event) {" + NL + "\t\t\tmyDiagramRoot = null;" + NL + "\t\t\tif (event.getSelection() instanceof ";
  protected final String TEXT_431 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_432 = " selection = (";
  protected final String TEXT_433 = ") event.getSelection();" + NL + "\t\t\t\tif (selection.size() == 1) {" + NL + "\t\t\t\t\tObject selectedElement = selection.getFirstElement();" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_434 = ") {" + NL + "\t\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_435 = ") selectedElement).getValue();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_436 = ".Entry) {" + NL + "\t\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_437 = ".Entry) selectedElement).getValue();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_438 = ") {" + NL + "\t\t\t\t\t\tmyDiagramRoot = (";
  protected final String TEXT_439 = ") selectedElement;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tsetPageComplete(validatePage());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "    \t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate boolean validatePage() {" + NL + "\t\t\tif (myDiagramRoot == null) {" + NL + "\t\t\t\tsetErrorMessage(\"No diagram root element selected\");" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\tboolean result = ";
  protected final String TEXT_440 = ".VISUAL_ID == ";
  protected final String TEXT_441 = ".INSTANCE.getDiagramVisualID(myDiagramRoot);" + NL + "\t\t\tsetErrorMessage(result ? null : \"Invalid diagram root element was selected\");" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_442 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final GenModel genModel = editorGen.getDomainGenModel();
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
importManager.registerInnerClass("RootElementSelectorPage");
if (isRichClientPlatform) {
	importManager.registerInnerClass("URISelectorPage");
	importManager.registerInnerClass("SourceURISelectorPage");
	importManager.registerInnerClass("DiagramURISelectorPage");
}

    stringBuffer.append(TEXT_4);
    
class FeatureGetAccessorHelper {
	/**
	 * @param containerName the name of the container
	 * @param feature the feature whose value is in interest
	 * @param containerMetaClass the <code>GenClass</code> of the container, or <code>null</code>, if the container is declared as an <code>EObject</code>.
	 * @param needsCastToResultType whether the cast to the result type is required (this parameter is only used if the <code>EClass</code> this feature belongs to is an external interface). 
	 */
	public void appendFeatureValueGetter(String containerName, GenFeature feature, GenClass containerMetaClass, boolean needsCastToResultType) {
		if (feature.getGenClass().isExternalInterface()) {
			boolean needsCastToEObject = containerMetaClass != null && containerMetaClass.isExternalInterface();
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(feature.isListType() ? "java.util.Collection" : feature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_6);
    
			}
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_8);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_9);
    
			}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_12);
    
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_13);
    
			}
		} else {
			boolean needsCastToFeatureGenType = containerMetaClass == null || containerMetaClass.isExternalInterface();
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_15);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_16);
    
			}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(feature.getGetAccessor());
    stringBuffer.append(TEXT_18);
    
		}
	}
}
final FeatureGetAccessorHelper myFeatureGetAccessorHelper = new FeatureGetAccessorHelper();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.Wizard"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_22);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_24);
    
} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_29);
    
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_31);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_36);
    
} else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_47);
    
}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(genDiagram.getNewDiagramFileWizardClassName());
    stringBuffer.append(TEXT_49);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_50);
    
} else {

    stringBuffer.append(TEXT_51);
    
}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genDiagram.getDomainDiagramElement() == null ? "" : genDiagram.getDomainDiagramElement().getGenPackage().getPrefix());
    stringBuffer.append(TEXT_54);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_55);
    
} else {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.WizardNewFileCreationPage"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IContainer"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Path"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Path"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_64);
    
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_66);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_69);
    
} else {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_76);
    
}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_84);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_85);
    
}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_88);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_91);
    
} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ide.IDE"));
    stringBuffer.append(TEXT_94);
    
}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IDiagramLayouter"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IDiagramLayouter"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IDiagramLayouter"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_105);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_107);
    
} else {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_111);
    
}

    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_116);
    
if(!genDiagram.getLinks().isEmpty()) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.NaiveViewService"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_119);
    
}

    stringBuffer.append(TEXT_120);
    
final Comparator<GenContainerBase> comparator = new Comparator<GenContainerBase>() {
	public int compare(GenContainerBase o1, GenContainerBase o2) {
		return o1.getVisualID() - o2.getVisualID();
	}
};
TreeSet<GenContainerBase> containers2Generate = new TreeSet<GenContainerBase>(comparator);
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();
	if (!nextContainer.getContainedNodes().isEmpty()) {
		containers2Generate.add(nextContainer);
		continue;
	}
	if (nextContainer instanceof GenDiagram) {
		containers2Generate.add(nextContainer);
		continue;
	}
	if (nextContainer instanceof GenNode) {
		//May need to generate if contains compartments with children
		for(Iterator compartments = ((GenNode) nextContainer).getCompartments().iterator(); compartments.hasNext(); ) {
			GenCompartment nextCompartment = (GenCompartment) compartments.next();
			if (!nextCompartment.getContainedNodes().isEmpty()) {
				containers2Generate.add(nextContainer);
				break;
			}
		}
	}
}
for (Iterator<GenContainerBase> containers = containers2Generate.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = containers.next();

    stringBuffer.append(TEXT_121);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_123);
    
	if (nextContainer instanceof GenNode) {
		boolean shouldIterateOverCompartments = false;
		for(Iterator compartments = ((GenNode) nextContainer).getCompartments().iterator(); compartments.hasNext(); ) {
			GenCompartment nextCompartment = (GenCompartment) compartments.next();
			if (!nextCompartment.getContainedNodes().isEmpty()) {
				shouldIterateOverCompartments = true;
				break;
			}
		}
		if (shouldIterateOverCompartments) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_128);
    
			for(Iterator compartments = ((GenNode) nextContainer).getCompartments().iterator(); compartments.hasNext(); ) {
				GenCompartment nextCompartment = (GenCompartment) compartments.next();
				if (nextCompartment.getContainedNodes().isEmpty()) {
					continue;
				}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName(nextCompartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_131);
    
			}

    stringBuffer.append(TEXT_132);
    
		}
	}

    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_140);
    
	boolean shouldIterateToGenerate = false;
	for(Iterator containedNodes = nextContainer.getContainedNodes().iterator(); containedNodes.hasNext(); ) {
		GenNode nextNode = (GenNode) containedNodes.next();
		if (containers2Generate.contains(nextNode)) {
			shouldIterateToGenerate = true;
			break;
		}
	}
	if (shouldIterateToGenerate) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_142);
    
		for(Iterator containedNodes = nextContainer.getContainedNodes().iterator(); containedNodes.hasNext(); ) {
			GenNode nextNode = (GenNode) containedNodes.next();
			if (containers2Generate.contains(nextNode)) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_145);
    
			}
		}

    stringBuffer.append(TEXT_146);
    
	}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_150);
    
	{
		String _getViewCode = "parentView";
		List childNodes = nextContainer.getContainedNodes();

    stringBuffer.append(TEXT_151);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_153);
    
} else {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_156);
    
	Map genFeature2genNodeMap = new LinkedHashMap();
	for (int nodeIndex = 0; nodeIndex < childNodes.size(); nodeIndex++) {
		GenNode nextNode = (GenNode) childNodes.get(nodeIndex);
		TypeModelFacet typeModelFacet = nextNode.getModelFacet();
		if (typeModelFacet == null) {
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

    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_161);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_163);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_165);
    
		} else {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_167);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_168);
    
	}

    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_170);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_171);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_173);
    
		} else {

    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_175);
    
		}

    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_177);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_178);
    
		} else {

    stringBuffer.append(TEXT_179);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_180);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_181);
    
	}
}

    stringBuffer.append(TEXT_182);
    
}

    
	}

    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_187);
    
	{
		String _parentNode = "parentView";
		List childNodes = nextContainer.getContainedNodes();
		boolean isListLayout;
		if (nextContainer instanceof GenNode) {
			isListLayout = !org.eclipse.gmf.codegen.gmfgen.util.ViewmapLayoutTypeHelper.getSharedInstance().isStoringChildPositions((GenNode) nextContainer);
		} else if (nextContainer instanceof GenCompartment) {
			isListLayout = ((GenCompartment) nextContainer).isListLayout(); 
		} else if (nextContainer instanceof GenDiagram) {
			isListLayout = false;
		} else {
			throw new RuntimeException("Unexpected container");
		}

    stringBuffer.append(TEXT_188);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_190);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_195);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_199);
    
	} else {

    stringBuffer.append(TEXT_200);
    
	}

    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_202);
    
}

    stringBuffer.append(TEXT_203);
    
	}

    stringBuffer.append(TEXT_204);
    
}
class LinksCollection {
	private Collection<GenLink> myTypeModelFacetLinks = new LinkedList<GenLink>();
	private Collection<GenLink> myFeatureModelFacetLinks = new LinkedList<GenLink>();
	public void add(GenLink link) {
		if (link.getModelFacet() instanceof TypeLinkModelFacet) {
			myTypeModelFacetLinks.add(link);
		} else if (link.getModelFacet() instanceof FeatureLinkModelFacet) {
			myFeatureModelFacetLinks.add(link);
		}
	}
	public Iterator<GenLink> getContainedTypeModelFacetLinks() {
		return myTypeModelFacetLinks.iterator();
	}
	public Iterator<GenLink> getContainedFeatureModelFacetLinks() {
		return myFeatureModelFacetLinks.iterator();
	}
}
class CreateChildLinkElements {
	private TreeMap<GenContainerBase, LinksCollection> myElements;
	public CreateChildLinkElements() {
		myElements = new TreeMap<GenContainerBase, LinksCollection>(comparator);
	}
	public void add(GenContainerBase o, GenLink link) {
		buildAncestors(o);
		myElements.get(o).add(link);
	}
	private void buildAncestors(GenContainerBase o) {
		if (!myElements.containsKey(o)) {
			LinksCollection elements = new LinksCollection();
			myElements.put(o, elements);
			addAncestors(o);
		}
	}
	private void addAncestors(GenContainerBase o) {
		if (o instanceof GenCompartment) {
			GenCompartment compartment = (GenCompartment) o;
			buildAncestors(compartment.getNode());
		} else if (o instanceof GenTopLevelNode) {
			GenTopLevelNode node = (GenTopLevelNode) o;
			buildAncestors(node.getDiagram());
		} else if (o instanceof GenChildNode) {
			GenChildNode node = (GenChildNode) o;
			for(Iterator it = node.getContainers().iterator(); it.hasNext(); ) {
				GenContainerBase next = (GenContainerBase) it.next();
				buildAncestors(next);
			}
		}
	}
	public boolean contains(GenContainerBase o) {
		return myElements.containsKey(o);
	}
	public Iterator<Map.Entry<GenContainerBase, LinksCollection>> iterator() {
		return myElements.entrySet().iterator();
	}
}
if (!genDiagram.getLinks().isEmpty()) {
	CreateChildLinkElements linkContainers2Generate = new CreateChildLinkElements();
	//No need to explicitly add diagram, since we build the whole hierarchy up.
	for(Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
		GenLink next = (GenLink) links.next();
		GenClass containerClass;
		LinkModelFacet nextModelFacet = next.getModelFacet();
		if (nextModelFacet instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) next.getModelFacet();
			if (modelFacet.getSourceMetaFeature() == null && modelFacet.getTargetMetaFeature() == null) {
				//if one link feature is null, the element is treated as this end of the link. If both are null, we cannot do anything about such a link.
				containerClass = null;
			} else {
				containerClass = modelFacet.getContainmentMetaFeature().getGenClass();
			}
		} else if (nextModelFacet instanceof FeatureLinkModelFacet) {
			GenFeature metaFeature = ((FeatureLinkModelFacet) next.getModelFacet()).getMetaFeature();
			containerClass = metaFeature.getGenClass();
		} else {
			continue;
		}
		for (Iterator nodes = genDiagram.getAllNodes().iterator(); nodes.hasNext(); ) {
			GenNode nextNode = (GenNode) nodes.next();
			if (containerClass.getEcoreClass().isSuperTypeOf(nextNode.getDomainMetaClass().getEcoreClass())) {
				linkContainers2Generate.add(nextNode, next);
			}
		}
	}
	for(Iterator<Map.Entry<GenContainerBase, LinksCollection>> entryIt = linkContainers2Generate.iterator(); entryIt.hasNext(); ) {
		Map.Entry<GenContainerBase, LinksCollection> next = entryIt.next();
		GenContainerBase nextContainer = next.getKey();
		LinksCollection linksCollection = next.getValue();
		Iterator<GenLink> typeModelFacetLinks = linksCollection.getContainedTypeModelFacetLinks();
		Iterator<GenLink> featureModelFacetLinks = linksCollection.getContainedFeatureModelFacetLinks();

    stringBuffer.append(TEXT_205);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_207);
    
		if (typeModelFacetLinks.hasNext() || featureModelFacetLinks.hasNext()) {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_215);
    
		}
		boolean shouldIterateToGenerate = false;
		Collection childElements = new ArrayList(nextContainer.getContainedNodes());
		if (nextContainer instanceof GenNode) {
			childElements.addAll(((GenNode) nextContainer).getCompartments());
		}
		for(Iterator childrenIterator = childElements.iterator(); childrenIterator.hasNext(); ) {
			GenContainerBase nextChild = (GenContainerBase) childrenIterator.next();
			if (linkContainers2Generate.contains(nextChild)) {
				shouldIterateToGenerate = true;
				break;
			}
		}
		if (shouldIterateToGenerate) {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_220);
    
			for(Iterator childrenIterator = childElements.iterator(); childrenIterator.hasNext(); ) {
				GenContainerBase nextChild = (GenContainerBase) childrenIterator.next();
				if (!linkContainers2Generate.contains(nextChild)) {
					continue;
				}

    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName(nextChild.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(nextChild.getUniqueIdentifier());
    stringBuffer.append(TEXT_223);
    
			}

    stringBuffer.append(TEXT_224);
    
		}

    stringBuffer.append(TEXT_225);
    
		if (typeModelFacetLinks.hasNext() || featureModelFacetLinks.hasNext()) {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_229);
    
			{
				String _getViewCode = "parentView";
				List childNodes = nextContainer.getContainedNodes();
				Iterator<GenLink> _containedTypeModelFacetLinks = linksCollection.getContainedTypeModelFacetLinks();;
				Iterator<GenLink> _containedFeatureModelFacetLinks = linksCollection.getContainedFeatureModelFacetLinks();;

    stringBuffer.append(TEXT_230);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_233);
    
Map genFeature2genLinkMap = new LinkedHashMap();
for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
	GenFeature metaFeature = modelFacet.getChildMetaFeature();
	if (!genFeature2genLinkMap.containsKey(metaFeature)) {
		genFeature2genLinkMap.put(metaFeature, new ArrayList());
	}
	((Collection) genFeature2genLinkMap.get(metaFeature)).add(genLink);
}
Map genFeature2featureGenLinkMap = new LinkedHashMap();
for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
	GenLink genLink = (GenLink)it.next();
	GenFeature metaFeature = ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature();
	if (!genFeature2featureGenLinkMap.containsKey(metaFeature)) {
		genFeature2featureGenLinkMap.put(metaFeature, new ArrayList());
	}
	((Collection) genFeature2featureGenLinkMap.get(metaFeature)).add(genLink);
}
if (!genFeature2genLinkMap.isEmpty() || !genFeature2featureGenLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_237);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_238);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_240);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_242);
    
	} else {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_244);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_245);
    
	}

    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_247);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_248);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_250);
    
		} else {

    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_252);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_255);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_256);
    
		} else {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_259);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_260);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_262);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_263);
    
		} else {

    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_266);
    
		}

    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_268);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_269);
    
		} else {

    stringBuffer.append(TEXT_270);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_271);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_272);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_274);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_276);
    
	} else {

    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_278);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_279);
    
	}

    stringBuffer.append(TEXT_280);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_283);
    
	}

    stringBuffer.append(TEXT_284);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_285);
    
	}
}

    stringBuffer.append(TEXT_286);
    
			}

    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_291);
    
			{
				String _diagramCode = "parentView.getDiagram()";
				Iterator<GenLink> _containedTypeModelFacetLinks = linksCollection.getContainedTypeModelFacetLinks();;
				Iterator<GenLink> _containedFeatureModelFacetLinks = linksCollection.getContainedFeatureModelFacetLinks();;

    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IViewDecorator"));
    stringBuffer.append(TEXT_296);
    
	for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_300);
    
	}
	for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_303);
    
	}

    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(_diagramCode);
    stringBuffer.append(TEXT_306);
    
			}

    stringBuffer.append(TEXT_307);
    
		}
	}
}
if(!genDiagram.getLinks().isEmpty()) {

    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_310);
    
}

    stringBuffer.append(TEXT_311);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardPage"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Text"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Text"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Button"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionAdapter"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionEvent"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.ModifyListener"));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.ModifyListener"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.ModifyEvent"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_362);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(editorGen.getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_370);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("java.io.File"));
    stringBuffer.append(TEXT_374);
    
}

    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardPage"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ISelectionChangedListener"));
    stringBuffer.append(TEXT_377);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreeViewer"));
    stringBuffer.append(TEXT_379);
    
}

    stringBuffer.append(TEXT_380);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_385);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_386);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_387);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_388);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_390);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_393);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_394);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridLayout"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Label"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_399);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_400);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_401);
    
final String treeViewer = isRichClientPlatform ? "myTreeViewer" : "treeViewer";

    stringBuffer.append(TEXT_402);
    if (!isRichClientPlatform){
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreeViewer"));
    stringBuffer.append(TEXT_403);
    }
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreeViewer"));
    stringBuffer.append(TEXT_405);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.layout.GridData"));
    stringBuffer.append(TEXT_412);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider"));
    stringBuffer.append(TEXT_415);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider"));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_419);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_420);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
    stringBuffer.append(TEXT_423);
    
}

    stringBuffer.append(TEXT_424);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_425);
    
if (isRichClientPlatform) {

    stringBuffer.append(TEXT_426);
    stringBuffer.append(treeViewer);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
    stringBuffer.append(TEXT_428);
    
}

    stringBuffer.append(TEXT_429);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.SelectionChangedEvent"));
    stringBuffer.append(TEXT_430);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IWrapperItemProvider"));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IWrapperItemProvider"));
    stringBuffer.append(TEXT_435);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_438);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_439);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_440);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_441);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_442);
    return stringBuffer.toString();
  }
}
