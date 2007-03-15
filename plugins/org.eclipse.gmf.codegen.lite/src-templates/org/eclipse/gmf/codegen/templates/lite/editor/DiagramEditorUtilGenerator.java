package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;

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
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "((";
  protected final String TEXT_5 = ")";
  protected final String TEXT_6 = "((";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = ".eGet(";
  protected final String TEXT_10 = ".eINSTANCE.get";
  protected final String TEXT_11 = "())";
  protected final String TEXT_12 = ")";
  protected final String TEXT_13 = "((";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = "()";
  protected final String TEXT_18 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_19 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String openFilePathDialog(Shell shell, String fileExtensionFilter, int style) {" + NL + "\t\tFileDialog fileDialog = new FileDialog(shell, style);" + NL + "\t\tfileDialog.setFilterExtensions(new String[]{fileExtensionFilter});" + NL + "" + NL + "\t\tfileDialog.open();" + NL + "\t\tif (fileDialog.getFileName() != null && fileDialog.getFileName().length() > 0) {" + NL + "\t\t\treturn fileDialog.getFilterPath() + File.separator + fileDialog.getFileName();" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_20 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_21 = " openEditor(URI fileURI) {" + NL + "\t\tIWorkbench workbench = PlatformUI.getWorkbench();" + NL + "\t\tIWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();" + NL + "\t\tIWorkbenchPage page = workbenchWindow.getActivePage();" + NL + "" + NL + "\t\tIEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileURI.lastSegment());" + NL + "\t\tif (editorDescriptor == null) {" + NL + "\t\t\tMessageDialog.openError(" + NL + "\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\t\"Error\"," + NL + "\t\t\t\"There is no editor registered for the file \" + fileURI.toFileString());" + NL + "\t\t\treturn null;" + NL + "\t\t} else {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn page.openEditor(new URIEditorInput(fileURI), editorDescriptor.getId());" + NL + "\t\t\t} catch (PartInitException exception) {" + NL + "\t\t\t\tMessageDialog.openError(" + NL + "\t\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\t\t\"Error Opening Editor\"," + NL + "\t\t\t\texception.getMessage());" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_23 = " showView(URI fileURI) {" + NL + "\t\tIWorkbench workbench = PlatformUI.getWorkbench();" + NL + "\t\tIWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();" + NL + "\t\tIWorkbenchPage page = workbenchWindow.getActivePage();" + NL + "" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_24 = " diagramView = (";
  protected final String TEXT_25 = ") page.showView(";
  protected final String TEXT_26 = ".ID);" + NL + "\t\t\tif (!diagramView.showDiagram(null, fileURI)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn diagramView;" + NL + "\t\t} catch (PartInitException exception) {" + NL + "\t\t\tMessageDialog.openError(" + NL + "\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\t\"Error Opening View\"," + NL + "\t\t\texception.getMessage());" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_27 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_28 = " createDiagramFor(";
  protected final String TEXT_29 = " diagramRoot) {" + NL + "\t\tif (";
  protected final String TEXT_30 = ".VISUAL_ID != ";
  protected final String TEXT_31 = ".INSTANCE.getDiagramVisualID(diagramRoot)) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_32 = " result = ";
  protected final String TEXT_33 = ".eINSTANCE.createDiagram();" + NL + "\t\tresult.setElement(diagramRoot);" + NL + "\t\t";
  protected final String TEXT_34 = ".INSTANCE.decorateView(result);" + NL + "\t\tnew DiagramInitializer().initDiagramContents(result);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class DiagramInitializer {";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "/**" + NL + " * @generated" + NL + " */" + NL + "private void initDiagramContents(";
  protected final String TEXT_37 = " diagram) {" + NL + "\tcreate";
  protected final String TEXT_38 = "Children(diagram);";
  protected final String TEXT_39 = NL + "\tmyViewService = new ";
  protected final String TEXT_40 = "(diagram);" + NL + "\tcreate";
  protected final String TEXT_41 = "ChildLinks(diagram);";
  protected final String TEXT_42 = NL + "}" + NL;
  protected final String TEXT_43 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_44 = "Children(";
  protected final String TEXT_45 = " viewObject) {";
  protected final String TEXT_46 = NL + "\tfor(";
  protected final String TEXT_47 = " it = viewObject.getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_48 = " next = (";
  protected final String TEXT_49 = ") it.next();" + NL + "\t\tint visualID = ";
  protected final String TEXT_50 = ".getVisualID(next);" + NL + "\t\tswitch (visualID) {";
  protected final String TEXT_51 = NL + "\t\tcase ";
  protected final String TEXT_52 = ".VISUAL_ID:" + NL + "\t\t\tcreate";
  protected final String TEXT_53 = "Children(next);" + NL + "\t\t\tbreak;";
  protected final String TEXT_54 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_55 = NL + "\t";
  protected final String TEXT_56 = " semanticChildren = get";
  protected final String TEXT_57 = "SemanticChildNodes(viewObject);" + NL + "\tfor(";
  protected final String TEXT_58 = " it = semanticChildren.iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_59 = " nextDescriptor = (";
  protected final String TEXT_60 = ") it.next();" + NL + "\t\t";
  protected final String TEXT_61 = " createCommand = getCreate";
  protected final String TEXT_62 = "NotationalChildNodeCommand(viewObject, nextDescriptor);" + NL + "\t\tif (createCommand != null && createCommand.canExecute()) {" + NL + "\t\t\tcreateCommand.execute();";
  protected final String TEXT_63 = NL + "\t\t\t";
  protected final String TEXT_64 = " nextChild = createCommand.getCreatedView();" + NL + "\t\t\tint childVisualID = nextDescriptor.getVisualID();" + NL + "\t\t\tswitch (childVisualID) {";
  protected final String TEXT_65 = NL + "\t\t\tcase ";
  protected final String TEXT_66 = ".VISUAL_ID:" + NL + "\t\t\t\tcreate";
  protected final String TEXT_67 = "Children(nextChild);" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_68 = NL + "\t\t\t}";
  protected final String TEXT_69 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_70 = NL + "}" + NL;
  protected final String TEXT_71 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_72 = " get";
  protected final String TEXT_73 = "SemanticChildNodes(";
  protected final String TEXT_74 = " parentView) {";
  protected final String TEXT_75 = NL;
  protected final String TEXT_76 = NL + "\treturn ";
  protected final String TEXT_77 = ".EMPTY_LIST;";
  protected final String TEXT_78 = NL + "\t";
  protected final String TEXT_79 = " result = new ";
  protected final String TEXT_80 = "();";
  protected final String TEXT_81 = NL + "\t";
  protected final String TEXT_82 = " viewObject = ";
  protected final String TEXT_83 = ";" + NL + "\t";
  protected final String TEXT_84 = " modelObject = viewObject.getElement();" + NL + "\t";
  protected final String TEXT_85 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_86 = NL + "\tfor(";
  protected final String TEXT_87 = " it = ";
  protected final String TEXT_88 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_89 = ") it.next();";
  protected final String TEXT_90 = NL + "\tnextValue = (";
  protected final String TEXT_91 = ")";
  protected final String TEXT_92 = ";";
  protected final String TEXT_93 = NL + "\tnodeVID = ";
  protected final String TEXT_94 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_95 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_96 = NL + "\tcase ";
  protected final String TEXT_97 = ".VISUAL_ID: {";
  protected final String TEXT_98 = NL + "\tif (";
  protected final String TEXT_99 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_100 = NL + "\t\tresult.add(new ";
  protected final String TEXT_101 = "(nextValue, nodeVID));";
  protected final String TEXT_102 = NL + "\t\tbreak;" + NL + "\t\t}";
  protected final String TEXT_103 = NL + "\t\t}";
  protected final String TEXT_104 = NL + "\t}";
  protected final String TEXT_105 = NL + "\t}";
  protected final String TEXT_106 = NL + "\treturn result;";
  protected final String TEXT_107 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_108 = " getCreate";
  protected final String TEXT_109 = "NotationalChildNodeCommand(";
  protected final String TEXT_110 = " parentView, ";
  protected final String TEXT_111 = " descriptor) {";
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = "\t\t\t";
  protected final String TEXT_114 = " domainElement = descriptor.getElement();" + NL + "\t\t\tint nodeVisualID = descriptor.getVisualID();" + NL + "\t\t\tswitch (nodeVisualID) {";
  protected final String TEXT_115 = NL + "\t\t\tcase ";
  protected final String TEXT_116 = ".VISUAL_ID:" + NL + "\t\t\t\tif (domainElement instanceof ";
  protected final String TEXT_117 = ") {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_118 = "(";
  protected final String TEXT_119 = ", domainElement, ";
  protected final String TEXT_120 = "new ";
  protected final String TEXT_121 = "(0, 0, ";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ")";
  protected final String TEXT_124 = NL + "null";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ".INSTANCE, false);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
  protected final String TEXT_127 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_128 = NL + "}";
  protected final String TEXT_129 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void create";
  protected final String TEXT_130 = "ChildLinks(";
  protected final String TEXT_131 = " viewObject) {";
  protected final String TEXT_132 = NL + "\t";
  protected final String TEXT_133 = " semanticChildLinks = get";
  protected final String TEXT_134 = "SemanticChildLinks(viewObject);" + NL + "\tfor(";
  protected final String TEXT_135 = " it = semanticChildLinks.iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_136 = " nextDescriptor = (";
  protected final String TEXT_137 = ") it.next();" + NL + "\t\t";
  protected final String TEXT_138 = " createCommand = getCreate";
  protected final String TEXT_139 = "NotationalChildLinkCommand(viewObject, nextDescriptor);" + NL + "\t\tif (createCommand != null && createCommand.canExecute()) {" + NL + "\t\t\tcreateCommand.execute();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_140 = NL + "\tfor(";
  protected final String TEXT_141 = " it = viewObject.getChildren().iterator(); it.hasNext(); ) {" + NL + "\t\t";
  protected final String TEXT_142 = " next = (";
  protected final String TEXT_143 = ") it.next();" + NL + "\t\tint visualID = ";
  protected final String TEXT_144 = ".getVisualID(next);" + NL + "\t\tswitch (visualID) {";
  protected final String TEXT_145 = NL + "\t\tcase ";
  protected final String TEXT_146 = ".VISUAL_ID:" + NL + "\t\t\tcreate";
  protected final String TEXT_147 = "ChildLinks(next);" + NL + "\t\t\tbreak;";
  protected final String TEXT_148 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_149 = NL + "}" + NL;
  protected final String TEXT_150 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_151 = " get";
  protected final String TEXT_152 = "SemanticChildLinks(";
  protected final String TEXT_153 = " parentView) {";
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = "\t";
  protected final String TEXT_156 = " result = new ";
  protected final String TEXT_157 = "();";
  protected final String TEXT_158 = NL + "\t";
  protected final String TEXT_159 = " modelObject = ";
  protected final String TEXT_160 = ".getElement();" + NL + "\t";
  protected final String TEXT_161 = " nextValue;";
  protected final String TEXT_162 = NL + "\tint linkVID;";
  protected final String TEXT_163 = NL + "\tfor(";
  protected final String TEXT_164 = " it = ";
  protected final String TEXT_165 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_166 = ") it.next();";
  protected final String TEXT_167 = NL + "\tnextValue = (";
  protected final String TEXT_168 = ")";
  protected final String TEXT_169 = ";";
  protected final String TEXT_170 = NL + "\tlinkVID = ";
  protected final String TEXT_171 = ".INSTANCE.getLinkWithClassVisualID(nextValue);";
  protected final String TEXT_172 = NL + "\tswitch (linkVID) {";
  protected final String TEXT_173 = NL + "\tcase ";
  protected final String TEXT_174 = ".VISUAL_ID: {";
  protected final String TEXT_175 = NL + "\tif (";
  protected final String TEXT_176 = ".VISUAL_ID == linkVID) {";
  protected final String TEXT_177 = NL + "\t\t";
  protected final String TEXT_178 = " source = (";
  protected final String TEXT_179 = ")";
  protected final String TEXT_180 = ";";
  protected final String TEXT_181 = NL + "\t\t";
  protected final String TEXT_182 = " source = ";
  protected final String TEXT_183 = ".getElement();";
  protected final String TEXT_184 = NL + "\t\t";
  protected final String TEXT_185 = " target = (";
  protected final String TEXT_186 = ")";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "\t\t";
  protected final String TEXT_189 = " target = ";
  protected final String TEXT_190 = ".getElement();";
  protected final String TEXT_191 = NL + "\t\tif (source != null && target != null) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_192 = "(source, target, nextValue, linkVID));" + NL + "\t\t}";
  protected final String TEXT_193 = NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_194 = NL + "\t}";
  protected final String TEXT_195 = NL + "\t}";
  protected final String TEXT_196 = NL + "\t}";
  protected final String TEXT_197 = NL + "\tfor(";
  protected final String TEXT_198 = " it = ";
  protected final String TEXT_199 = ".iterator(); it.hasNext(); ) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_200 = ") it.next();";
  protected final String TEXT_201 = NL + "\tnextValue = (";
  protected final String TEXT_202 = ")";
  protected final String TEXT_203 = ";";
  protected final String TEXT_204 = NL + "\tif (nextValue != null) {";
  protected final String TEXT_205 = NL + "\t\tresult.add(new ";
  protected final String TEXT_206 = "(modelObject, nextValue, null, ";
  protected final String TEXT_207 = ".VISUAL_ID));";
  protected final String TEXT_208 = NL + "\t}";
  protected final String TEXT_209 = NL + "\t}";
  protected final String TEXT_210 = NL + "\treturn result;";
  protected final String TEXT_211 = NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_212 = " getCreate";
  protected final String TEXT_213 = "NotationalChildLinkCommand(";
  protected final String TEXT_214 = " parentView, ";
  protected final String TEXT_215 = " linkDescriptor) {";
  protected final String TEXT_216 = NL;
  protected final String TEXT_217 = "\t\t\t";
  protected final String TEXT_218 = " sourceView = getViewService().findView(linkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_219 = " targetView = getViewService().findView(linkDescriptor.getDestination());" + NL + "\t\t\t";
  protected final String TEXT_220 = " decorator = null;" + NL + "\t\t\tif (sourceView == null || targetView == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tswitch (linkDescriptor.getVisualID()) {";
  protected final String TEXT_221 = NL + "\t\t\tcase ";
  protected final String TEXT_222 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() instanceof ";
  protected final String TEXT_223 = ") {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_224 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_225 = NL + "\t\t\tcase ";
  protected final String TEXT_226 = ".VISUAL_ID:" + NL + "\t\t\t\tif (linkDescriptor.getElement() == null) {" + NL + "\t\t\t\t\tdecorator = ";
  protected final String TEXT_227 = ".INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_228 = NL + "\t\t\t}" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn new ";
  protected final String TEXT_229 = "(";
  protected final String TEXT_230 = ", linkDescriptor.getElement(), sourceView, targetView, decorator);";
  protected final String TEXT_231 = NL + "}";
  protected final String TEXT_232 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_233 = " myViewService;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_234 = " getViewService() {" + NL + "\treturn myViewService;" + NL + "}";
  protected final String TEXT_235 = NL + "\t}";
  protected final String TEXT_236 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static URI getDiagramFileURI(URI modelFileURI) {" + NL + "\t\tif (modelFileURI == null || !modelFileURI.isFile()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn modelFileURI.trimFileExtension().appendFileExtension(\"";
  protected final String TEXT_237 = "\");" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static URI getModelFileURI(URI diagramFileURI) {" + NL + "\t\tif (diagramFileURI == null || !diagramFileURI.isFile()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn diagramFileURI.trimFileExtension().appendFileExtension(\"";
  protected final String TEXT_238 = "\");" + NL + "\t}";
  protected final String TEXT_239 = NL + NL + "\t/**" + NL + "\t * Returns whether the given element is read only in its editing domain." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean isReadOnly(";
  protected final String TEXT_240 = " element) {" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_241 = " resource = element.eResource();" + NL + "\t\tif (resource == null) {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_242 = " editingDomain = ";
  protected final String TEXT_243 = ".getEditingDomain(resource);" + NL + "\t\tif (editingDomain == null) {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn editingDomain.isReadOnly(resource);" + NL + "\t}" + NL + "}";
  protected final String TEXT_244 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final GenPlugin genPlugin = editorGen.getPlugin();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenModel genModel = genDiagram.getEditorGen().getDomainGenModel();
final boolean isRichClientPlatform = genDiagram.getEditorGen().getApplication() != null;

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
importManager.addImport("java.io.File");
importManager.addImport("org.eclipse.ui.IWorkbench");
importManager.addImport("org.eclipse.ui.IWorkbenchPage");
importManager.addImport("org.eclipse.ui.IWorkbenchWindow");
importManager.addImport("org.eclipse.ui.PlatformUI");
importManager.addImport("org.eclipse.ui.PartInitException");
importManager.addImport("org.eclipse.ui.IEditorDescriptor");
importManager.addImport("org.eclipse.swt.widgets.Shell");
importManager.addImport("org.eclipse.swt.widgets.FileDialog"); 
importManager.addImport("org.eclipse.jface.dialogs.MessageDialog");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("org.eclipse.emf.common.ui.URIEditorInput");

importManager.registerInnerClass("DiagramInitializer");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
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

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName(feature.isListType() ? "java.util.Collection" : feature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_5);
    
			}
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_7);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_8);
    
			}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_11);
    
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_12);
    
			}
		} else {
			boolean needsCastToFeatureGenType = containerMetaClass == null || containerMetaClass.isExternalInterface();
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_14);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_15);
    
			}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(feature.getGetAccessor());
    stringBuffer.append(TEXT_17);
    
		}
	}
}
final FeatureGetAccessorHelper myFeatureGetAccessorHelper = new FeatureGetAccessorHelper();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_19);
    
if (editorGen.getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_21);
    
} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IViewPart"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(editorGen.getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_38);
    
if(!genDiagram.getLinks().isEmpty()) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.NaiveViewService"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    
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

    stringBuffer.append(TEXT_43);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_45);
    
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

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_50);
    
			for(Iterator compartments = ((GenNode) nextContainer).getCompartments().iterator(); compartments.hasNext(); ) {
				GenCompartment nextCompartment = (GenCompartment) compartments.next();
				if (nextCompartment.getContainedNodes().isEmpty()) {
					continue;
				}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(nextCompartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_53);
    
			}

    stringBuffer.append(TEXT_54);
    
		}
	}
	if (!nextContainer.getContainedNodes().isEmpty()) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_62);
    
		boolean shouldIterateToGenerate = false;
		for(Iterator containedNodes = nextContainer.getContainedNodes().iterator(); containedNodes.hasNext(); ) {
			GenNode nextNode = (GenNode) containedNodes.next();
			if (containers2Generate.contains(nextNode)) {
				shouldIterateToGenerate = true;
				break;
			}
		}
		if (shouldIterateToGenerate) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_64);
    
			for(Iterator containedNodes = nextContainer.getContainedNodes().iterator(); containedNodes.hasNext(); ) {
				GenNode nextNode = (GenNode) containedNodes.next();
				if (containers2Generate.contains(nextNode)) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_67);
    
				}
			}	//iterate over contained nodes

    stringBuffer.append(TEXT_68);
    
		}	//if (shouldIterateToGenerate)

    stringBuffer.append(TEXT_69);
    
	}	//if (!nextContainer.getContainedNodes().isEmpty())

    stringBuffer.append(TEXT_70);
    
	if (!nextContainer.getContainedNodes().isEmpty()) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_74);
    
		{
			String _getViewCode = "parentView";
			List childNodes = nextContainer.getContainedNodes();

    stringBuffer.append(TEXT_75);
    
if (childNodes.size() == 0) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_77);
    
} else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_80);
    
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

    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_85);
    
	}
	for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
		Map.Entry nextEntry = (Map.Entry) entries.next();
		GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
		Collection genNodesCollection = (Collection) nextEntry.getValue();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_87);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, true);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_89);
    
		} else {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_91);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", childMetaFeature, null, false);
    stringBuffer.append(TEXT_92);
    
	}

    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_94);
    
	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_95);
    
	}
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_97);
    
		} else {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_99);
    
		}

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_101);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_102);
    
		} else {

    stringBuffer.append(TEXT_103);
    
		}
	}
	if (generateSwitch) {

    stringBuffer.append(TEXT_104);
    
	}
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_105);
    
	}
}

    stringBuffer.append(TEXT_106);
    
}

    
		}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.ElementDescriptor"));
    stringBuffer.append(TEXT_111);
    
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

    stringBuffer.append(TEXT_112);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_114);
    
for (Iterator it = childNodes.iterator(); it.hasNext(); ) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalNodeCommand"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(_parentNode);
    stringBuffer.append(TEXT_119);
    
	if (!isListLayout) {
		int defaultWidth = 40;
		int defaultHeight = 40;
		DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) nextNode.getViewmap().find(DefaultSizeAttributes.class);
		if (defSizeAttrs != null) {
			defaultWidth = defSizeAttrs.getWidth();
			defaultHeight = defSizeAttrs.getHeight();
		}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(defaultWidth);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(defaultHeight);
    stringBuffer.append(TEXT_123);
    
	} else {

    stringBuffer.append(TEXT_124);
    
	}

    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName(nextNode.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_126);
    
}

    stringBuffer.append(TEXT_127);
    
		}	//local declarations

    stringBuffer.append(TEXT_128);
    
	}	//if (!nextContainer.getContainedNodes().isEmpty())
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

    stringBuffer.append(TEXT_129);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_131);
    
		if (typeModelFacetLinks.hasNext() || featureModelFacetLinks.hasNext()) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_139);
    
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

    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_144);
    
			for(Iterator childrenIterator = childElements.iterator(); childrenIterator.hasNext(); ) {
				GenContainerBase nextChild = (GenContainerBase) childrenIterator.next();
				if (!linkContainers2Generate.contains(nextChild)) {
					continue;
				}

    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(nextChild.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(nextChild.getUniqueIdentifier());
    stringBuffer.append(TEXT_147);
    
			}

    stringBuffer.append(TEXT_148);
    
		}

    stringBuffer.append(TEXT_149);
    
		if (typeModelFacetLinks.hasNext() || featureModelFacetLinks.hasNext()) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_153);
    
			{
				String _getViewCode = "parentView";
				List childNodes = nextContainer.getContainedNodes();
				Iterator<GenLink> _containedTypeModelFacetLinks = linksCollection.getContainedTypeModelFacetLinks();;
				Iterator<GenLink> _containedFeatureModelFacetLinks = linksCollection.getContainedFeatureModelFacetLinks();;

    stringBuffer.append(TEXT_154);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_157);
    
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

    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_161);
    
}
if (!genFeature2genLinkMap.isEmpty()) {

    stringBuffer.append(TEXT_162);
    
}
for (Iterator entries = genFeature2genLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_164);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_166);
    
	} else {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_168);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_169);
    
	}

    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_171);
    
	boolean generateSwitch = genLinksCollection.size() != 1;
	if (generateSwitch) {

    stringBuffer.append(TEXT_172);
    
	}
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (generateSwitch) {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_174);
    
		} else {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_176);
    
		}
		if (modelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_179);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getSourceMetaFeature(), null, false);
    stringBuffer.append(TEXT_180);
    
		} else {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_183);
    
		}
		if (modelFacet.getTargetMetaFeature() != null) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_186);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("nextValue", modelFacet.getTargetMetaFeature(), null, false);
    stringBuffer.append(TEXT_187);
    
		} else {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(_getViewCode);
    stringBuffer.append(TEXT_190);
    
		}

    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_192);
    
		if (generateSwitch) {

    stringBuffer.append(TEXT_193);
    
		} else {

    stringBuffer.append(TEXT_194);
    
		}

    
	}	//iterate over genLinksCollection
	if (generateSwitch) {

    stringBuffer.append(TEXT_195);
    
	}
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_196);
    
	}
}
for (Iterator entries = genFeature2featureGenLinkMap.entrySet().iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature metaFeature = (GenFeature) nextEntry.getKey();
	Collection genLinksCollection = (Collection) nextEntry.getValue();
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_198);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, true);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_200);
    
	} else {

    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_202);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("modelObject", metaFeature, null, false);
    stringBuffer.append(TEXT_203);
    
	}

    stringBuffer.append(TEXT_204);
    
	for (Iterator genLinksIterator = genLinksCollection.iterator(); genLinksIterator.hasNext(); ) {
		GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_207);
    
	}

    stringBuffer.append(TEXT_208);
    
	if (metaFeature.isListType()) {

    stringBuffer.append(TEXT_209);
    
	}
}

    stringBuffer.append(TEXT_210);
    
			}

    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalElementCommand"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.LinkDescriptor"));
    stringBuffer.append(TEXT_215);
    
			{
				String _diagramCode = "parentView.getDiagram()";
				Iterator<GenLink> _containedTypeModelFacetLinks = linksCollection.getContainedTypeModelFacetLinks();;
				Iterator<GenLink> _containedFeatureModelFacetLinks = linksCollection.getContainedFeatureModelFacetLinks();;

    stringBuffer.append(TEXT_216);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.IViewDecorator"));
    stringBuffer.append(TEXT_220);
    
	for(Iterator it = _containedTypeModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		if (modelFacet == null) {
			continue;
		}

    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_224);
    
	}
	for(Iterator it = _containedFeatureModelFacetLinks; it.hasNext(); ) {
		GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName(nextLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_227);
    
	}

    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.CreateNotationalEdgeCommand"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(_diagramCode);
    stringBuffer.append(TEXT_230);
    
			}

    stringBuffer.append(TEXT_231);
    
		}
	}
}
if(!genDiagram.getLinks().isEmpty()) {

    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_234);
    
}

    stringBuffer.append(TEXT_235);
    
if (!genDiagram.getEditorGen().isSameFileForDiagramAndModel()) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_238);
    
}

    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_243);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_244);
    return stringBuffer.toString();
  }
}
