package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.emf.common.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.common.codegen.*;

public class EditorGenerator
{
  protected static String nl;
  public static synchronized EditorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditorGenerator result = new EditorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {";
  protected final String TEXT_5 = NL + "\t/**" + NL + "\t * This class listens to changes to the file system in the workspace, and" + NL + "\t * makes the following changes: " + NL + "\t * <ul><li>If an open, saved file gets deleted, the editor is closed.</li>" + NL + "\t * <li>If an open file gets renamed or moved, the editor's" + NL + "\t * input is changed accordingly.</li></ul>" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ResourceTracker implements ";
  protected final String TEXT_6 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void resourceChanged(";
  protected final String TEXT_7 = " event) {" + NL + "\t\t\t";
  protected final String TEXT_8 = " delta = event.getDelta();" + NL + "\t\t\tif (delta != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_9 = " fileDelta = delta.findMember(((";
  protected final String TEXT_10 = ") getEditorInput()).getFile().getFullPath());" + NL + "\t\t\t\tif (fileDelta != null) {" + NL + "\t\t\t\t\tprocessFileDelta(fileDelta);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void processFileDelta(";
  protected final String TEXT_11 = " delta) {" + NL + "\t\t\tassert (delta != null && delta.getResource().equals(((";
  protected final String TEXT_12 = ") getEditorInput()).getFile()));" + NL + "\t\t\tif (delta.getKind() == ";
  protected final String TEXT_13 = ".REMOVED) {" + NL + "\t\t\t\tif ((";
  protected final String TEXT_14 = ".MOVED_TO & delta.getFlags()) == 0) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\tif (!isDirty()) {" + NL + "\t\t\t\t\t\tcloseEditor();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t// else if it was moved or renamed" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_16 = " newFile = ";
  protected final String TEXT_17 = ".getWorkspace().getRoot().getFile(delta.getMovedToPath());" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = " display = getSite().getShell().getDisplay();" + NL + "\t\t\t\t\tdisplay.asyncExec(new Runnable() {" + NL + "\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\tsetInput(new ";
  protected final String TEXT_19 = "(newFile));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t});" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ResourceTracker resourceTracker;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ResourceTracker getResourceTracker() {" + NL + "\t\tif (resourceTracker == null) {" + NL + "\t\t\tresourceTracker = new ResourceTracker();" + NL + "\t\t}" + NL + "\t\treturn resourceTracker;" + NL + "\t}" + NL;
  protected final String TEXT_20 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_21 = " diagramRoot;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_22 = " diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_23 = " domainAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createActions() {" + NL + "\t\taddStackAction(new ";
  protected final String TEXT_24 = "(this));" + NL + "\t\taddStackAction(new ";
  protected final String TEXT_25 = "(this));" + NL + "" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_26 = "((";
  protected final String TEXT_27 = ") this));" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_28 = "((";
  protected final String TEXT_29 = ") this));" + NL + "" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_30 = "((";
  protected final String TEXT_31 = ") this, ";
  protected final String TEXT_32 = ".LEFT));" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_33 = "((";
  protected final String TEXT_34 = ") this, ";
  protected final String TEXT_35 = ".RIGHT));" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_36 = "((";
  protected final String TEXT_37 = ") this, ";
  protected final String TEXT_38 = ".TOP));" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_39 = "((";
  protected final String TEXT_40 = ") this, ";
  protected final String TEXT_41 = ".BOTTOM));" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_42 = "((";
  protected final String TEXT_43 = ") this, ";
  protected final String TEXT_44 = ".CENTER));" + NL + "\t\taddEditPartAction(new ";
  protected final String TEXT_45 = "((";
  protected final String TEXT_46 = ") this, ";
  protected final String TEXT_47 = ".MIDDLE));" + NL + "" + NL + "\t\taddEditorAction(new ";
  protected final String TEXT_48 = "(this));" + NL + "\t\taddEditorAction(new ";
  protected final String TEXT_49 = "(this));" + NL + "\t\taddEditorAction(new ";
  protected final String TEXT_50 = "(this));" + NL + "" + NL + "\t\t";
  protected final String TEXT_51 = " zoomIn = new ";
  protected final String TEXT_52 = "(getZoomManager());" + NL + "\t\t";
  protected final String TEXT_53 = " zoomOut = new ";
  protected final String TEXT_54 = "(getZoomManager());" + NL + "\t\taddAction(zoomIn);" + NL + "\t\taddAction(zoomOut);" + NL + "\t\tgetSite().getKeyBindingService().registerAction(zoomIn);" + NL + "\t\tgetSite().getKeyBindingService().registerAction(zoomOut);" + NL + "\t\t";
  protected final String TEXT_55 = " keyHandler = getGraphicalViewer().getKeyHandler();" + NL + "\t\tkeyHandler.put(";
  protected final String TEXT_56 = ".getPressed(";
  protected final String TEXT_57 = ".DEL, 127, 0), getActionRegistry().getAction(";
  protected final String TEXT_58 = ".DELETE.getId()));" + NL + "\t\tkeyHandler.put(";
  protected final String TEXT_59 = ".getPressed(";
  protected final String TEXT_60 = ".F2, 0), getActionRegistry().getAction(";
  protected final String TEXT_61 = ".DIRECT_EDIT));" + NL + "\t}" + NL;
  protected final String TEXT_62 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tvoid closeEditor() {" + NL + "\t\tgetSite().getShell().getDisplay().syncExec(new Runnable() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\tgetSite().getPage().closeEditor(";
  protected final String TEXT_63 = ".this, false);" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_64 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void dispose() {" + NL + "\t\t// important: always call super implementation of dispose" + NL + "\t\tsuper.dispose();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSave(";
  protected final String TEXT_65 = " monitor) {" + NL + "\t\ttry {" + NL + "\t\t\tsave(monitor);" + NL + "\t\t\tgetCommandStack().markSaveLocation();" + NL + "\t\t} catch (";
  protected final String TEXT_66 = " e) {" + NL + "\t\t\t";
  protected final String TEXT_67 = ".openError(getSite().getShell(), \"Error During Save\", \"The current ";
  protected final String TEXT_68 = " model could not be saved.\", e.getStatus());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configurePalette(";
  protected final String TEXT_69 = " paletteRoot) {";
  protected final String TEXT_70 = NL + "\t\tnew ";
  protected final String TEXT_71 = "(getDomainAdapterFactory()).contributeToPalette(paletteRoot);";
  protected final String TEXT_72 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_73 = " getDiagramRoot() {" + NL + "\t\treturn diagramRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_74 = " getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_75 = " site, ";
  protected final String TEXT_76 = " input) throws ";
  protected final String TEXT_77 = " {" + NL + "\t\t";
  protected final String TEXT_78 = " file = getURIFromInput(input);" + NL + "\t\tif (file == null) {" + NL + "\t\t\tthrow new ";
  protected final String TEXT_79 = "(\"The specified input is not valid.\");" + NL + "\t\t}" + NL + "\t\tsuper.init(site, input);" + NL + "\t\t// validate" + NL + "\t\tif (getDiagramRoot() == null) {" + NL + "\t\t\tthrow new ";
  protected final String TEXT_80 = "(\"The specified input is not valid.\");" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setInput(";
  protected final String TEXT_81 = " input)  {";
  protected final String TEXT_82 = NL + "\t\tif (getEditorInput() instanceof ";
  protected final String TEXT_83 = ") {" + NL + "\t\t\t";
  protected final String TEXT_84 = " resource = ((";
  protected final String TEXT_85 = ") getEditorInput()).getFile();" + NL + "\t\t\tresource.getWorkspace().removeResourceChangeListener(getResourceTracker());" + NL + "\t\t}";
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = " file = getURIFromInput(input);" + NL + "\t\tload(file);" + NL + "\t\tsetPartName(file.lastSegment());" + NL + "\t\tsuper.setInput(input);";
  protected final String TEXT_88 = NL + "\t\tif (getEditorInput() instanceof ";
  protected final String TEXT_89 = ") {" + NL + "\t\t\t";
  protected final String TEXT_90 = " resource = ((";
  protected final String TEXT_91 = ") getEditorInput()).getFile();" + NL + "\t\t\tresource.getWorkspace().addResourceChangeListener(getResourceTracker());" + NL + "\t\t}";
  protected final String TEXT_92 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_93 = " getURIFromInput(";
  protected final String TEXT_94 = " input) {";
  protected final String TEXT_95 = NL + "\t\tif (input instanceof ";
  protected final String TEXT_96 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_97 = ") input).getURI();" + NL + "\t\t}" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_98 = ") {" + NL + "\t\t\treturn ";
  protected final String TEXT_99 = ".createFileURI(((IPathEditorInput)input).getPath().toOSString());" + NL + "\t\t}";
  protected final String TEXT_100 = NL + "\t\tif (input instanceof ";
  protected final String TEXT_101 = ") {" + NL + "\t\t\treturn ";
  protected final String TEXT_102 = ".createPlatformResourceURI(((IFileEditorInput)input).getFile().getFullPath().toString());" + NL + "\t\t}";
  protected final String TEXT_103 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_104 = " getDomainAdapterFactory() {" + NL + "\t\tif (domainAdapterFactory == null) {" + NL + "\t\t\t";
  protected final String TEXT_105 = " factories = new ";
  protected final String TEXT_106 = "();" + NL + "\t\t\tfactories.add(new ";
  protected final String TEXT_107 = "());";
  protected final String TEXT_108 = NL + "\t\t\tfactories.add(new ";
  protected final String TEXT_109 = "());";
  protected final String TEXT_110 = NL + "\t\t\tfactories.add(new ";
  protected final String TEXT_111 = "());" + NL + "\t\t\tfactories.add(new ";
  protected final String TEXT_112 = "());" + NL + "\t\t\tdomainAdapterFactory = new ";
  protected final String TEXT_113 = "(factories);" + NL + "\t\t}" + NL + "\t\treturn domainAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void load(";
  protected final String TEXT_114 = " diagramFile) {" + NL + "\t\tdiagramRoot = null;" + NL + "\t\tdiagram = null;" + NL + "\t\tif (diagramFile == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_115 = " editingDomain = getEditingDomain();" + NL + "\t\t";
  protected final String TEXT_116 = " resourceSet = editingDomain.getResourceSet();" + NL + "\t\t";
  protected final String TEXT_117 = " diagramResource = resourceSet.getResource(diagramFile, true);" + NL + "\t\tif (diagramResource == null) {" + NL + "\t\t\tdiagramResource = resourceSet.createResource(diagramFile);" + NL + "\t\t}" + NL + "\t\tdiagram = (";
  protected final String TEXT_118 = ") findInResource(diagramResource, ";
  protected final String TEXT_119 = ".class);" + NL + "\t\tif (diagram == null) {" + NL + "\t\t\tdiagram = ";
  protected final String TEXT_120 = ".eINSTANCE.createDiagram();" + NL + "\t\t\tdiagramResource.getContents().add(0, diagram);" + NL + "\t\t\t//Auxiliary creation should not be undoable." + NL + "\t\t\ttry {" + NL + "\t\t\t\tdiagramResource.save(";
  protected final String TEXT_121 = ".EMPTY_MAP);" + NL + "\t\t\t} catch (";
  protected final String TEXT_122 = " e) {" + NL + "\t\t\t\tdiagram = null;" + NL + "\t\t\t\tdiagramRoot = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tdiagramRoot = (";
  protected final String TEXT_123 = ") diagram.getElement();" + NL + "\t\tif (diagramRoot == null) {";
  protected final String TEXT_124 = NL + "\t\t\t";
  protected final String TEXT_125 = " modelFile = ";
  protected final String TEXT_126 = ".getModelFileURI(diagramFile);" + NL + "\t\t\t";
  protected final String TEXT_127 = " modelResource = resourceSet.getResource(modelFile, true);" + NL + "\t\t\tif (modelResource == null) {" + NL + "\t\t\t\tmodelResource = resourceSet.createResource(modelFile);" + NL + "\t\t\t}";
  protected final String TEXT_128 = NL + "\t\t\tdiagramRoot = (";
  protected final String TEXT_129 = ") findInResource(";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ".class);" + NL + "\t\t\tif (diagramRoot == null) {" + NL + "\t\t\t\tdiagramRoot = ";
  protected final String TEXT_132 = ".eINSTANCE.create";
  protected final String TEXT_133 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_134 = ".getContents().add(0, diagramRoot);" + NL + "\t\t\t\t//We don't want this auxiliary creation to be undoable." + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\t";
  protected final String TEXT_135 = ".save(";
  protected final String TEXT_136 = ".EMPTY_MAP);" + NL + "\t\t\t\t} catch (";
  protected final String TEXT_137 = " e) {" + NL + "\t\t\t\t\tdiagram = null;" + NL + "\t\t\t\t\tdiagramRoot = null;" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (!diagram.isSetElement()) {" + NL + "\t\t\t\tdiagram.setElement(";
  protected final String TEXT_138 = "(";
  protected final String TEXT_139 = ") ";
  protected final String TEXT_140 = "diagramRoot);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_141 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Object findInResource(";
  protected final String TEXT_142 = " resource, Class expectedClass) {" + NL + "\t\tfor(";
  protected final String TEXT_143 = " it = resource.getContents().iterator(); it.hasNext(); ) {" + NL + "\t\t\tObject next = it.next();" + NL + "\t\t\tif (expectedClass.isInstance(next)) {" + NL + "\t\t\t\treturn next;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createGraphicalViewer(";
  protected final String TEXT_144 = " parent) {" + NL + "\t\tsuper.createGraphicalViewer(parent);" + NL + "\t\t// initialize the viewer with input" + NL + "\t\t";
  protected final String TEXT_145 = " root = new ";
  protected final String TEXT_146 = "();" + NL + "\t\tgetGraphicalViewer().setRootEditPart(root);" + NL + "\t\tgetGraphicalViewer().setEditPartFactory(new ";
  protected final String TEXT_147 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_148 = " printableLayers = (";
  protected final String TEXT_149 = ") root.getLayer(";
  protected final String TEXT_150 = ".PRINTABLE_LAYERS);" + NL + "\t\t";
  protected final String TEXT_151 = " extLabelsLayer = new ";
  protected final String TEXT_152 = "();" + NL + "\t\textLabelsLayer.setLayoutManager(new ";
  protected final String TEXT_153 = "());" + NL + "\t\tprintableLayers.addLayerAfter(extLabelsLayer, ";
  protected final String TEXT_154 = ".EXTERNAL_NODE_LABELS_LAYER, ";
  protected final String TEXT_155 = ".PRIMARY_LAYER);" + NL + "\t\tgetGraphicalViewer().setContents(getDiagram());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "\t\t";
  protected final String TEXT_156 = " viewer = getGraphicalViewer();" + NL + "\t\t// configure the context menu" + NL + "\t\t";
  protected final String TEXT_157 = " provider = new ";
  protected final String TEXT_158 = "ContextMenuProvider(viewer);" + NL + "\t\tviewer.setContextMenu(provider);" + NL + "\t\tgetSite().registerContextMenu(";
  protected final String TEXT_159 = ".ID + \".editor.contextmenu\", provider, getSite().getSelectionProvider()); //$NON-NLS-1$" + NL + "" + NL + "\t\t";
  protected final String TEXT_160 = " keyHandler = new ";
  protected final String TEXT_161 = "(viewer);" + NL + "\t\tviewer.setKeyHandler(keyHandler);" + NL + "" + NL + "\t\tviewer.setProperty(";
  protected final String TEXT_162 = ".KeyGenerator.getKey(";
  protected final String TEXT_163 = ".CTRL), ";
  protected final String TEXT_164 = ".SINGLETON);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ";
  protected final String TEXT_165 = "ContextMenuProvider extends ";
  protected final String TEXT_166 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_167 = "ContextMenuProvider(";
  protected final String TEXT_168 = " viewer) {" + NL + "\t\t\tsuper(viewer);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t    public void buildContextMenu(";
  protected final String TEXT_169 = " menuManager) {" + NL + "\t        ";
  protected final String TEXT_170 = ".addStandardActionGroups(menuManager);" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_171 = ".UNDO.getId(), ";
  protected final String TEXT_172 = ".GROUP_UNDO);" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_173 = ".REDO.getId(), ";
  protected final String TEXT_174 = ".GROUP_UNDO);" + NL + "\t" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_175 = ".COPY.getId(), ";
  protected final String TEXT_176 = ".GROUP_EDIT);" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_177 = ".PASTE.getId(), ";
  protected final String TEXT_178 = ".GROUP_EDIT);" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_179 = ".DELETE.getId(), ";
  protected final String TEXT_180 = ".GROUP_EDIT);" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_181 = ".DIRECT_EDIT, ";
  protected final String TEXT_182 = ".GROUP_EDIT);" + NL + "" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_183 = ".LAYOUT_ALL_ACTION, ";
  protected final String TEXT_184 = ".GROUP_REST);" + NL + "" + NL + "\t\t\tappendActionToMenu(menuManager, ";
  protected final String TEXT_185 = ".SAVE.getId(), ";
  protected final String TEXT_186 = ".GROUP_SAVE);" + NL + "" + NL + "\t\t\tappendAlignmentSubmenu(menuManager);" + NL + "\t    }" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void appendAlignmentSubmenu(";
  protected final String TEXT_187 = " menuManager) {" + NL + "\t\t\t// Alignment Actions" + NL + "\t\t\t";
  protected final String TEXT_188 = " submenu = new ";
  protected final String TEXT_189 = "(\"Align\");" + NL + "\t\t\tsubmenu.add(new ";
  protected final String TEXT_190 = "(";
  protected final String TEXT_191 = ".MB_ADDITIONS));" + NL + "\t" + NL + "\t\t\tappendActionToMenu(submenu, ";
  protected final String TEXT_192 = ".ALIGN_LEFT, ";
  protected final String TEXT_193 = ".MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, ";
  protected final String TEXT_194 = ".ALIGN_CENTER, ";
  protected final String TEXT_195 = ".MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, ";
  protected final String TEXT_196 = ".ALIGN_RIGHT, ";
  protected final String TEXT_197 = ".MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, ";
  protected final String TEXT_198 = ".ALIGN_TOP, ";
  protected final String TEXT_199 = ".MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, ";
  protected final String TEXT_200 = ".ALIGN_MIDDLE, ";
  protected final String TEXT_201 = ".MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, ";
  protected final String TEXT_202 = ".ALIGN_BOTTOM, ";
  protected final String TEXT_203 = ".MB_ADDITIONS);" + NL + "\t" + NL + "\t\t\tif (!submenu.isEmpty()) {" + NL + "\t\t\t\tmenuManager.appendToGroup(";
  protected final String TEXT_204 = ".GROUP_REST, submenu);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void appendActionToMenu(";
  protected final String TEXT_205 = " menu, String actionId, String menuGroup) {" + NL + "\t\t\t";
  protected final String TEXT_206 = " action = getActionRegistry().getAction(actionId);" + NL + "\t\t\tif (action != null && action.isEnabled()) {" + NL + "\t\t\t\tmenu.appendToGroup(menuGroup, action);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_207 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView genEditor = (GenEditorView) ((Object[]) argument)[0];
final GenDiagram genDiagram = genEditor.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final boolean isRichClientPlatform = genDiagram.getEditorGen().getDomainGenModel().isRichClientPlatform();

importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_1);
    
importManager.registerInnerClass(genEditor.getClassName() + "ContextMenuProvider");
if (!isRichClientPlatform) {
	importManager.registerInnerClass("ResourceTracker");
}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramEditor"));
    stringBuffer.append(TEXT_4);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceChangeListener"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceChangeEvent"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_14);
    /*XXX: make sure unsaved deleted file is handled correctly*/
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Display"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_19);
    
}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.ComposedAdapterFactory"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.UndoAction"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.RedoAction"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.DeleteAction"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.DirectEditAction"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.AlignmentAction"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.AlignmentAction"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.AlignmentAction"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.AlignmentAction"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.AlignmentAction"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.AlignmentAction"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.PositionConstants"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.SaveAction"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.PrintAction"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.ui.actions.LayoutDiagramAction"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ZoomInAction"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ZoomOutAction"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.KeyHandler"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.KeyStroke"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.KeyStroke"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_61);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_63);
    
}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genDiagram.getEditorGen().getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteRoot"));
    stringBuffer.append(TEXT_69);
    
{
	final Palette palette = genDiagram.getPalette();
	if (palette != null) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    
	}
}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorSite"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_81);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_85);
    
}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_87);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_91);
    
}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_94);
    if (isRichClientPlatform) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPathEditorInput"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_99);
    } else {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.AdapterFactory"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory"));
    stringBuffer.append(TEXT_107);
    
final EList genPackages = genDiagram.getEditorGen().getAllDomainGenPackages(true);
for (int i = 0; i < genPackages.size(); i++) {
	GenPackage genPackage = (GenPackage) genPackages.get(i);

    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.ComposedAdapterFactory"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_123);
    
{

    
	boolean sameFile = genDiagram.getEditorGen().isSameFileForDiagramAndModel();
	String resourceToUse;
	if (!sameFile) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_127);
    
		resourceToUse = "modelResource";
	} else {
		resourceToUse = "diagramResource";
	}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(resourceToUse);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(resourceToUse);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(resourceToUse);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_137);
    if (genDiagram.getDomainDiagramElement().isExternalInterface()) {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    
}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Composite"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ScalableFreeformRootEditPart"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ScalableFreeformRootEditPart"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LayeredPane"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LayeredPane"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.LayerConstants"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.DelegatingLayout"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.LayerConstants"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ContextMenuProvider"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.KeyHandler"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.MouseWheelHandler"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.MouseWheelZoomHandler"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ContextMenuProvider"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPartViewer"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.ui.actions.ActionIds"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.ActionFactory"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.MenuManager"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Separator"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.GEFActionConstants"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IMenuManager"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_206);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_207);
    return stringBuffer.toString();
  }
}
