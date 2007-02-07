package org.eclipse.gmf.codegen.templates.editor;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
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
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends DiagramDocumentEditor";
  protected final String TEXT_7 = NL + "\t\timplements ";
  protected final String TEXT_8 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ID = \"";
  protected final String TEXT_9 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = "() {" + NL + "\t\tsuper(";
  protected final String TEXT_11 = ");" + NL + "\t}" + NL;
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {" + NL + "\t\tPaletteRoot root = super.createPaletteRoot(existingPaletteRoot);" + NL + "\t\tnew ";
  protected final String TEXT_13 = "().fillPalette(root);" + NL + "\t\treturn root;" + NL + "\t}";
  protected final String TEXT_14 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_15 = " getPreferencesHint() {";
  protected final String TEXT_16 = NL + "\t\treturn ";
  protected final String TEXT_17 = ".DIAGRAM_PREFERENCES_HINT;" + NL + "\t}";
  protected final String TEXT_18 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getContributorId() {" + NL + "\t\treturn ";
  protected final String TEXT_19 = ".ID;" + NL + "\t}";
  protected final String TEXT_20 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class type) {" + NL + "\t\tif (type == ";
  protected final String TEXT_21 = ".class) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(type);" + NL + "\t}";
  protected final String TEXT_22 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_23 = " getDocumentProvider(";
  protected final String TEXT_24 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_25 = ") {" + NL + "\t\t\treturn new ";
  protected final String TEXT_26 = "();" + NL + "\t\t}" + NL + "\t\treturn super.getDocumentProvider(input);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public ";
  protected final String TEXT_27 = " getEditingDomain() {" + NL + "    \torg.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;" + NL + "    \tif (document instanceof org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) {" + NL + "    \t\treturn ((org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document).getEditingDomain();" + NL + "    \t}" + NL + "        return super.getEditingDomain();" + NL + "    }";
  protected final String TEXT_28 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_29 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_30 = ") {" + NL + "\t\t\tsetDocumentProvider(";
  protected final String TEXT_31 = ".getInstance().getDocumentProvider());" + NL + "\t\t} else if (input instanceof ";
  protected final String TEXT_32 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_33 = "());" + NL + "\t\t} else {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_34 = "());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void gotoMarker(";
  protected final String TEXT_35 = " marker) {";
  protected final String TEXT_36 = NL + "        ";
  protected final String TEXT_37 = ".getInstance().gotoMarker(this, marker);" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSaveAsAllowed() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSaveAs() {" + NL + "\t\tperformSaveAs(new ";
  protected final String TEXT_38 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performSaveAs(";
  protected final String TEXT_39 = " progressMonitor) {" + NL + "\t\t";
  protected final String TEXT_40 = " shell = getSite().getShell();" + NL + "\t\t";
  protected final String TEXT_41 = " input = getEditorInput();" + NL + "\t\t";
  protected final String TEXT_42 = " dialog = new ";
  protected final String TEXT_43 = "(shell);" + NL + "\t\t";
  protected final String TEXT_44 = " original = input instanceof ";
  protected final String TEXT_45 = " ? ((";
  protected final String TEXT_46 = ") input).getFile() : null;" + NL + "\t\tif (original != null) {" + NL + "\t\t\tdialog.setOriginalFile(original);" + NL + "\t\t}" + NL + "\t\tdialog.create();" + NL + "\t\t";
  protected final String TEXT_47 = " provider = getDocumentProvider();" + NL + "\t\tif (provider == null) {" + NL + "\t\t\t// editor has been programmatically closed while the dialog was open" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (provider.isDeleted(input) && original != null) {" + NL + "\t\t\tString message = ";
  protected final String TEXT_48 = ".bind(\"The original file ''{0}'' has been deleted.\", original.getName());" + NL + "\t\t\tdialog.setErrorMessage(null);" + NL + "\t\t\tdialog.setMessage(message, ";
  protected final String TEXT_49 = ".WARNING);" + NL + "\t\t}" + NL + "\t\tif (dialog.open() == ";
  protected final String TEXT_50 = ".CANCEL) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_51 = " filePath = dialog.getResult();" + NL + "\t\tif (filePath == null) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_52 = " workspaceRoot = ";
  protected final String TEXT_53 = ".getWorkspace().getRoot();" + NL + "\t\t";
  protected final String TEXT_54 = " file = workspaceRoot.getFile(filePath);" + NL + "\t\tfinal ";
  protected final String TEXT_55 = " newInput = new ";
  protected final String TEXT_56 = "(file);" + NL + "\t\t// Check if the editor is already open" + NL + "\t\t";
  protected final String TEXT_57 = " matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();" + NL + "\t\t";
  protected final String TEXT_58 = "[] editorRefs = ";
  protected final String TEXT_59 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();" + NL + "\t\tfor (int i = 0; i < editorRefs.length; i++) {" + NL + "\t\t\tif (matchingStrategy.matches(editorRefs[i], newInput)) {" + NL + "\t\t\t\t";
  protected final String TEXT_60 = ".openWarning(shell, \"Problem During Save As...\", \"Save could not be completed. Target file is already open in another editor.\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean success = false;" + NL + "\t\ttry {" + NL + "\t\t\tprovider.aboutToChange(newInput);" + NL + "\t\t\tgetDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);" + NL + "\t\t\tsuccess = true;" + NL + "\t\t} catch (";
  protected final String TEXT_61 = " x) {" + NL + "\t\t\t";
  protected final String TEXT_62 = " status = x.getStatus();" + NL + "\t\t\tif (status == null || status.getSeverity() != ";
  protected final String TEXT_63 = ".CANCEL) {" + NL + "\t\t\t\t";
  protected final String TEXT_64 = ".openError(shell, \"Save Problems\", \"Could not save file.\", x.getStatus());" + NL + "\t\t\t}" + NL + "\t\t} finally {" + NL + "\t\t\tprovider.changed(newInput);" + NL + "\t\t\tif (success) {" + NL + "\t\t\t\tsetInput(newInput);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (progressMonitor != null) {" + NL + "\t\t\tprogressMonitor.setCanceled(!success);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_65 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_66 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_67 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_68 = "());" + NL + "\t\t} else {" + NL + "\t\t\tsuper.setDocumentProvider(input);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_69 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeGraphicalViewer() {" + NL + "\t\tsuper.initializeGraphicalViewer();" + NL + "\t\tgetDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), ";
  protected final String TEXT_70 = ".getTransfer()) {" + NL + "" + NL + "\t\t\tprotected Object getJavaObject(";
  protected final String TEXT_71 = " data) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_72 = ".getTransfer().nativeToJava(data);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "\t\tgetDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), ";
  protected final String TEXT_73 = ".getInstance()) {" + NL + "" + NL + "\t\t\tprotected Object getJavaObject(";
  protected final String TEXT_74 = " data) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_75 = ".getInstance().nativeToJava(data);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate abstract class DropTargetListener extends ";
  protected final String TEXT_76 = " {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic DropTargetListener(";
  protected final String TEXT_77 = " viewer, ";
  protected final String TEXT_78 = " xfer) {" + NL + "\t\t\tsuper(viewer, xfer);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_79 = " getObjectsBeingDropped() {" + NL + "\t\t\t";
  protected final String TEXT_80 = " data = getCurrentEvent().currentDataType;" + NL + "\t\t\t";
  protected final String TEXT_81 = " uris = new ";
  protected final String TEXT_82 = "();" + NL + "" + NL + "\t\t\tObject transferedObject = getJavaObject(data);" + NL + "\t\t\tif (transferedObject instanceof ";
  protected final String TEXT_83 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_84 = " selection = (";
  protected final String TEXT_85 = ") transferedObject;" + NL + "\t\t\t\tfor (";
  protected final String TEXT_86 = " it = selection.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tObject nextSelectedObject = it.next();";
  protected final String TEXT_87 = NL + "\t\t\t\t\tif (nextSelectedObject instanceof ";
  protected final String TEXT_88 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = " view = ((";
  protected final String TEXT_90 = ") nextSelectedObject).getView();" + NL + "\t\t\t\t\t\tnextSelectedObject = view.getElement();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_91 = "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\tif (nextSelectedObject instanceof ";
  protected final String TEXT_92 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_93 = " modelElement = (";
  protected final String TEXT_94 = ") nextSelectedObject;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_95 = " modelElementResource = modelElement.eResource();" + NL + "\t\t\t\t\t\turis.add(modelElementResource.getURI().appendFragment(modelElementResource.getURIFragment(modelElement)));\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_96 = " result = new ";
  protected final String TEXT_97 = "();" + NL + "\t\t\tfor (";
  protected final String TEXT_98 = " it = uris.iterator(); it.hasNext();) {" + NL + "\t\t\t\t";
  protected final String TEXT_99 = " nextURI = (";
  protected final String TEXT_100 = ") it.next();" + NL + "\t\t\t\t";
  protected final String TEXT_101 = " modelObject = getEditingDomain().getResourceSet().getEObject(nextURI, true);" + NL + "\t\t\t\tresult.add(modelObject);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract Object getJavaObject(";
  protected final String TEXT_102 = " data);" + NL + "\t" + NL + "\t}";
  protected final String TEXT_103 = NL + "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView genEditor = (GenEditorView) ((Object[]) argument)[0];
final GenDiagram genDiagram = genEditor.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenPropertySheet propertySheet = genDiagram.getEditorGen().getPropertySheet();
importManager.registerInnerClass("DropTargetListener");

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
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_6);
    
Set<String> ifaces = new LinkedHashSet<String>();
if (genEditor.getEditorGen().getApplication() == null) {
	ifaces.add(importManager.getImportedName("org.eclipse.ui.ide.IGotoMarker"));
}
if (propertySheet != null && propertySheet.isReadOnly()) {
	ifaces.add(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.properties.views.IReadOnlyDiagramPropertySheetPageContributor"));
}
if (!ifaces.isEmpty()) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(ifaces.toString().substring(1, ifaces.toString().length() - 1));
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genEditor.getID());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getPalette() != null && genDiagram.getPalette().isFlyout());
    stringBuffer.append(TEXT_11);
    if (genDiagram.getPalette() != null) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint"));
    stringBuffer.append(TEXT_15);
    /*XXX seems better we use preference store directly (in configureGraphicalViewer) instead all these indirect ids */
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_17);
    if (genDiagram.getEditorGen().getPropertySheet() != null) { /*perhaps, we should override contributor id regardless of sheet presence, there's no much sense in default id either.*/
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySheetPage"));
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("TransactionalEditingDomain"));
    stringBuffer.append(TEXT_27);
    if (genDiagram.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.StorageDiagramDocumentProvider"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IMarker"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Shell"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.osgi.util.NLS"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.IMessageProvider"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.window.Window"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IWorkspaceRoot"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorMatchingStrategy"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorReference"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_64);
    } else { // genDiagram.getEditorGen().getApplication() != null 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_68);
    }

if (genDiagram.generateCreateShortcutAction()) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.util.LocalSelectionTransfer"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.util.LocalSelectionTransfer"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.dnd.LocalTransfer"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.dnd.LocalTransfer"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPartViewer"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.Transfer"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("java.util.HashSet"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_86);
    
/*
 * TODO: movel NavigatorItem to some public place and remove 
 * "genEditor.getEditorGen().getNavigator() != null" test
 */
	if (genEditor.getEditorGen().getNavigator() != null) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(genEditor.getEditorGen().getNavigator().getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(genEditor.getEditorGen().getNavigator().getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    	}
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
