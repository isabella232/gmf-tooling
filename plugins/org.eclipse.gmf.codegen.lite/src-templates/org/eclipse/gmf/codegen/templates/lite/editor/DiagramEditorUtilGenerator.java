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
  protected final String TEXT_126 = ".INSTANCE);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;";
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
  protected final String TEXT_239 = NL + "\t/**" + NL + "\t * Looks up a string in the plugin's plugin.properties file." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static String getString(String key) {" + NL + "\t\treturn ";
  protected final String TEXT_240 = ".getInstance().getBundleString(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * RCP's application" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Application implements ";
  protected final String TEXT_241 = " {" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.core.runtime.IPlatformRunnable#run(java.lang.Object)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object run(Object args) {" + NL + "\t\t\t";
  protected final String TEXT_242 = " workbenchAdvisor = new Advisor();" + NL + "\t\t\t";
  protected final String TEXT_243 = " display = ";
  protected final String TEXT_244 = ".createDisplay();" + NL + "\t\t\ttry {" + NL + "\t\t\t\tint returnCode = ";
  protected final String TEXT_245 = ".createAndRunWorkbench(display, workbenchAdvisor);" + NL + "\t\t\t\tif (returnCode == ";
  protected final String TEXT_246 = ".RETURN_RESTART) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_247 = ".EXIT_RESTART;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_248 = ".EXIT_OK;" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\tdisplay.dispose();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + " " + NL + "  \t/**" + NL + "\t * RCP's perspective" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Advisor extends ";
  protected final String TEXT_249 = " {" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic String getInitialWindowPerspectiveId() {" + NL + "\t\t\treturn Perspective.ID_PERSPECTIVE;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void initialize(";
  protected final String TEXT_250 = " configurer) {" + NL + "\t\t\tsuper.initialize(configurer);" + NL + "\t\t\tconfigurer.setSaveAndRestore(true);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(";
  protected final String TEXT_251 = " configurer) {" + NL + "\t\t\treturn new WindowAdvisor(configurer);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "  \t/**" + NL + "\t * RCP's perspective" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Perspective implements ";
  protected final String TEXT_252 = " {" + NL + "\t\t/**" + NL + "\t\t * Perspective ID" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ID_PERSPECTIVE = \"";
  protected final String TEXT_253 = ".Perspective\";\t//$NON-NLS-1$" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void createInitialLayout(";
  protected final String TEXT_254 = " layout) {" + NL + "\t\t\tlayout.setEditorAreaVisible(true);" + NL + "\t\t\tlayout.addPerspectiveShortcut(ID_PERSPECTIVE);" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_255 = " right = layout.createFolder(\"right\", ";
  protected final String TEXT_256 = ".RIGHT, (float)0.66, layout.getEditorArea());\t//$NON-NLS-1$" + NL + "\t\t\tright.addView(IPageLayout.ID_OUTLINE);";
  protected final String TEXT_257 = NL + "\t\t\t";
  protected final String TEXT_258 = " top = layout.createFolder(\"top\", ";
  protected final String TEXT_259 = ".TOP, (float)0.5, layout.getEditorArea());\t//$NON-NLS-1$" + NL + "\t\t\ttop.addView(";
  protected final String TEXT_260 = ".ID);";
  protected final String TEXT_261 = NL + "\t\t\t";
  protected final String TEXT_262 = " bottomRight = layout.createFolder(\"bottomRight\", ";
  protected final String TEXT_263 = ".BOTTOM, (float)0.60, \"right\");\t//$NON-NLS-1$\t//$NON-NLS-2$" + NL + "\t\t\tbottomRight.addView(";
  protected final String TEXT_264 = ".ID_PROP_SHEET);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * RCP's window advisor" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class WindowAdvisor extends ";
  protected final String TEXT_265 = " {" + NL + "\t\t/**" + NL + "\t\t * @see WorkbenchWindowAdvisor#WorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic WindowAdvisor(";
  protected final String TEXT_266 = " configurer) {" + NL + "\t\t\tsuper(configurer);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowOpen()" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void preWindowOpen() {" + NL + "\t\t\t";
  protected final String TEXT_267 = " configurer = getWindowConfigurer();" + NL + "\t\t\tconfigurer.setInitialSize(new ";
  protected final String TEXT_268 = "(600, 450));" + NL + "\t\t\tconfigurer.setShowCoolBar(false);" + NL + "\t\t\tconfigurer.setShowStatusLine(true);" + NL + "\t\t\tconfigurer.setTitle(getString(\"_UI_Application_title\"));\t//$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#createActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_269 = " createActionBarAdvisor(";
  protected final String TEXT_270 = " configurer) {" + NL + "\t\t\treturn new WindowActionBarAdvisor(configurer);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * RCP's action bar advisor" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class WindowActionBarAdvisor extends ";
  protected final String TEXT_271 = " {" + NL + "\t\t/**" + NL + "\t\t * @see ActionBarAdvisor#ActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic WindowActionBarAdvisor(";
  protected final String TEXT_272 = " configurer) {" + NL + "\t\t\tsuper(configurer);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void fillMenuBar(";
  protected final String TEXT_273 = " menuBar) {" + NL + "\t\t\t";
  protected final String TEXT_274 = " window = getActionBarConfigurer().getWindowConfigurer().getWindow();" + NL + "\t\t\tmenuBar.add(createFileMenu(window));" + NL + "\t\t\tmenuBar.add(createEditMenu(window));" + NL + "\t\t\tmenuBar.add(new ";
  protected final String TEXT_275 = "(";
  protected final String TEXT_276 = ".MB_ADDITIONS));" + NL + "\t\t\tmenuBar.add(createWindowMenu(window));" + NL + "\t\t\tmenuBar.add(createHelpMenu(window));\t\t\t\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Creates the 'File' menu." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_277 = " createFileMenu(";
  protected final String TEXT_278 = " window) {" + NL + "\t\t\t";
  protected final String TEXT_279 = " menu = new ";
  protected final String TEXT_280 = "(getString(\"_UI_Menu_File_label\"),\t//$NON-NLS-1$" + NL + "\t\t\t\t";
  protected final String TEXT_281 = ".M_FILE);" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_282 = "(";
  protected final String TEXT_283 = ".FILE_START));" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_284 = " newMenu = new ";
  protected final String TEXT_285 = "(getString(\"_UI_Menu_New_label\"), \"new\");\t//$NON-NLS-1$\t//$NON-NLS-2$" + NL + "\t\t\tnewMenu.add(new ";
  protected final String TEXT_286 = "(";
  protected final String TEXT_287 = ".MB_ADDITIONS));" + NL + "\t" + NL + "\t\t\tmenu.add(newMenu);" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_288 = "());" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_289 = "(";
  protected final String TEXT_290 = ".MB_ADDITIONS));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_291 = "());" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_292 = ".CLOSE.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_293 = ".CLOSE_ALL.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_294 = "());" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_295 = ".SAVE.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_296 = ".SAVE_AS.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_297 = ".SAVE_ALL.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_298 = "());" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_299 = ".QUIT.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_300 = "(";
  protected final String TEXT_301 = ".FILE_END));" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Creates the 'Edit' menu." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_302 = " createEditMenu(";
  protected final String TEXT_303 = " window) {" + NL + "\t\t\t";
  protected final String TEXT_304 = " menu = new ";
  protected final String TEXT_305 = "(getString(\"_UI_Menu_Edit_label\"),\t//$NON-NLS-1$" + NL + "\t\t\t\t";
  protected final String TEXT_306 = ".M_EDIT);" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_307 = "(";
  protected final String TEXT_308 = ".EDIT_START));" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_309 = ".UNDO.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_310 = ".REDO.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_311 = "(";
  protected final String TEXT_312 = ".UNDO_EXT));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_313 = "());" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_314 = ".CUT.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_315 = ".COPY.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_316 = ".PASTE.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_317 = "(";
  protected final String TEXT_318 = ".CUT_EXT));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_319 = "());" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_320 = ".DELETE.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_321 = ".SELECT_ALL.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_322 = "());" + NL + "\t" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_323 = "(";
  protected final String TEXT_324 = ".ADD_EXT));" + NL + "\t" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_325 = "(";
  protected final String TEXT_326 = ".EDIT_END));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_327 = "(";
  protected final String TEXT_328 = ".MB_ADDITIONS));" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * Creates the 'Window' menu." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_329 = " createWindowMenu(";
  protected final String TEXT_330 = " window) {" + NL + "\t\t\t";
  protected final String TEXT_331 = " menu = new ";
  protected final String TEXT_332 = "(getString(\"_UI_Menu_Window_label\"),\t//$NON-NLS-1$" + NL + "\t\t\t\t";
  protected final String TEXT_333 = ".M_WINDOW);" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ";
  protected final String TEXT_334 = ".OPEN_NEW_WINDOW.create(window));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_335 = "(";
  protected final String TEXT_336 = ".MB_ADDITIONS));" + NL + "\t\t\tmenu.add(";
  protected final String TEXT_337 = ".OPEN_WINDOWS.create(window));" + NL + "\t" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * Creates the 'Help' menu." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_338 = " createHelpMenu(";
  protected final String TEXT_339 = " window) {" + NL + "\t\t\t";
  protected final String TEXT_340 = " menu = new ";
  protected final String TEXT_341 = "(getString(\"_UI_Menu_Help_label\"), ";
  protected final String TEXT_342 = ".M_HELP);\t//$NON-NLS-1$" + NL + "\t\t\t// Welcome or intro page would go here" + NL + "\t\t\t// Help contents would go here" + NL + "\t\t\t// Tips and tricks page would go here" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_343 = "(";
  protected final String TEXT_344 = ".HELP_START));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_345 = "(";
  protected final String TEXT_346 = ".HELP_END));" + NL + "\t\t\tmenu.add(new ";
  protected final String TEXT_347 = "(";
  protected final String TEXT_348 = ".MB_ADDITIONS));" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * Adds the specified action to the given menu and also registers the action with the" + NL + "\t\t * action bar configurer, in order to activate its key binding." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void addToMenuAndRegister(";
  protected final String TEXT_349 = " menuManager, ";
  protected final String TEXT_350 = " action) {" + NL + "\t\t\tmenuManager.add(action);" + NL + "\t\t\tgetActionBarConfigurer().registerGlobalAction(action);\t\t\t" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * About action for the RCP application." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class AboutAction extends ";
  protected final String TEXT_351 = " {" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(";
  protected final String TEXT_352 = " action) {" + NL + "\t\t\t";
  protected final String TEXT_353 = ".openInformation(getWindow().getShell(), getString(\"_UI_About_title\"),\t//$NON-NLS-1$" + NL + "\t\t\tgetString(\"_UI_About_text\"));\t//$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_354 = NL + NL + " \t/**" + NL + "\t * Open action for the ";
  protected final String TEXT_355 = " diagram." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class OpenDiagramAction extends ";
  protected final String TEXT_356 = " {" + NL + "\t\t/**" + NL + "\t\t * Opens the editors for the files selected using the file dialog." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(";
  protected final String TEXT_357 = " action) {" + NL + "\t\t\tString filePath = openFilePathDialog(getWindow().getShell(), \"*.";
  protected final String TEXT_358 = "\", ";
  protected final String TEXT_359 = ".OPEN);\t//$NON-NLS-1$" + NL + "\t\t\tif (filePath != null) {";
  protected final String TEXT_360 = NL + "\t\t\t\topenEditor(URI.createFileURI(filePath));";
  protected final String TEXT_361 = NL + "\t\t\t\tshowView(URI.createFileURI(filePath));";
  protected final String TEXT_362 = NL + "\t\t\t}" + NL + "\t\t}" + NL + " \t}" + NL + "" + NL + "\t/**" + NL + "\t * Open URI action for the ";
  protected final String TEXT_363 = " diagram." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class OpenURIAction extends ";
  protected final String TEXT_364 = " {" + NL + "\t\t/**" + NL + "\t\t * Opens the editors for the files selected using the LoadResourceDialog." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(";
  protected final String TEXT_365 = " action) {" + NL + "\t\t\t";
  protected final String TEXT_366 = ".LoadResourceDialog loadResourceDialog = new ";
  protected final String TEXT_367 = ".LoadResourceDialog(getWindow().getShell());" + NL + "\t\t\tif (";
  protected final String TEXT_368 = ".OK == loadResourceDialog.open()) {" + NL + "\t\t\t\tfor (";
  protected final String TEXT_369 = " it = loadResourceDialog.getURIs().iterator(); it.hasNext(); ) {";
  protected final String TEXT_370 = NL + "\t\t\t\t\topenEditor((URI) it.next());";
  protected final String TEXT_371 = NL + "\t\t\t\t\tshowView((URI) it.next());";
  protected final String TEXT_372 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * New diagram action for the ";
  protected final String TEXT_373 = " diagram." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class NewDiagramAction extends ";
  protected final String TEXT_374 = " {" + NL + "\t\t/**" + NL + "\t\t * Opens the wizard to create the diagram." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(";
  protected final String TEXT_375 = " action) {" + NL + "\t\t\t";
  protected final String TEXT_376 = " wizard = new ";
  protected final String TEXT_377 = "();" + NL + "\t\t\twizard.init(getWindow().getWorkbench(), ";
  protected final String TEXT_378 = ".EMPTY);" + NL + "\t\t\t";
  protected final String TEXT_379 = " wizardDialog = new ";
  protected final String TEXT_380 = "(getWindow().getShell(), wizard);" + NL + "\t\t\twizardDialog.open();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_381 = NL + "}";
  protected final String TEXT_382 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final GenPlugin genPlugin = editorGen.getPlugin();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenModel genModel = genDiagram.getEditorGen().getDomainGenModel();
final boolean isRichClientPlatform = genDiagram.getEditorGen().getDomainGenModel().isRichClientPlatform();

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

    
if (isRichClientPlatform) {
	boolean shouldGenerateApplication = true;	/*XXX: option in gmfgen*/
	if (shouldGenerateApplication) {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName(genPlugin.getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPlatformRunnable"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.WorkbenchAdvisor"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Display"));
    stringBuffer.append(TEXT_243);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPlatformRunnable"));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPlatformRunnable"));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.WorkbenchAdvisor"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.IWorkbenchConfigurer"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.IWorkbenchWindowConfigurer"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPerspectiveFactory"));
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPageLayout"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFolderLayout"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPageLayout"));
    stringBuffer.append(TEXT_256);
    
if (!genDiagram.getEditorGen().getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFolderLayout"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPageLayout"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_260);
    
}

    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFolderLayout"));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPageLayout"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPageLayout"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.WorkbenchWindowAdvisor"));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.IWorkbenchWindowConfigurer"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.IWorkbenchWindowConfigurer"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Point"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.ActionBarAdvisor"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.IActionBarConfigurer"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.ActionBarAdvisor"));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.application.IActionBarConfigurer"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchWindow"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchWindow"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_283);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_287);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_288);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_290);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_294);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_296);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_297);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_298);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_302);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchWindow"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_305);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_310);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_315);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_322);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchWindow"));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_331);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_333);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_335);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ContributionItemFactory"));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchWindow"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_346);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.GroupMarker"));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchActionConstants"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate"));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_353);
    
 	}
 
    stringBuffer.append(TEXT_354);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_355);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate"));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_358);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_359);
    
if (genDiagram.getEditorGen().getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_360);
    
} else {

    stringBuffer.append(TEXT_361);
    
}

    stringBuffer.append(TEXT_362);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_363);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.action.LoadResourceAction"));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.action.LoadResourceAction"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.Dialog"));
    stringBuffer.append(TEXT_368);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_369);
    
if (genDiagram.getEditorGen().getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_370);
    
} else {

    stringBuffer.append(TEXT_371);
    
}

    stringBuffer.append(TEXT_372);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_373);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCreationWizardQualifiedClassName()));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCreationWizardQualifiedClassName()));
    stringBuffer.append(TEXT_377);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.StructuredSelection"));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
    stringBuffer.append(TEXT_379);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.wizard.WizardDialog"));
    stringBuffer.append(TEXT_380);
    
}

    stringBuffer.append(TEXT_381);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_382);
    return stringBuffer.toString();
  }
}
