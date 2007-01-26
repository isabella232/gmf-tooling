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
  protected final String TEXT_11 = ");" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getEditingDomainID() {" + NL + "\t\treturn \"";
  protected final String TEXT_12 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected TransactionalEditingDomain createEditingDomain() {" + NL + "\t\tTransactionalEditingDomain domain = super.createEditingDomain();" + NL + "\t\tdomain.setID(getEditingDomainID());";
  protected final String TEXT_13 = NL + "\t\tfinal ";
  protected final String TEXT_14 = " diagramResourceModifiedFilter = ";
  protected final String TEXT_15 = ".createNotifierFilter(domain.getResourceSet()).and(";
  protected final String TEXT_16 = ".createEventTypeFilter(";
  protected final String TEXT_17 = ".ADD)).and(";
  protected final String TEXT_18 = ".createFeatureFilter(";
  protected final String TEXT_19 = ".class, ";
  protected final String TEXT_20 = ".RESOURCE_SET__RESOURCES));" + NL + "\t\tdomain.getResourceSet().eAdapters().add(new ";
  protected final String TEXT_21 = "() {" + NL + "" + NL + "\t\t\tprivate ";
  protected final String TEXT_22 = " myTarger;" + NL + "" + NL + "\t\t\tpublic ";
  protected final String TEXT_23 = " getTarget() {" + NL + "\t\t\t\treturn myTarger;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic boolean isAdapterForType(Object type) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic void notifyChanged(";
  protected final String TEXT_24 = " notification) {" + NL + "\t\t\t\tif (diagramResourceModifiedFilter.matches(notification)) {" + NL + "\t\t\t\t\tObject value = notification.getNewValue();" + NL + "\t\t\t\t\tif (value instanceof ";
  protected final String TEXT_25 = ") {" + NL + "\t\t\t\t\t\t((";
  protected final String TEXT_26 = ") value).setTrackingModification(true);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic void setTarget(";
  protected final String TEXT_27 = " newTarget) {" + NL + "\t\t\t\tmyTarger = newTarget;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "" + NL + "" + NL + "\t\treturn domain;" + NL + "\t}" + NL;
  protected final String TEXT_28 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {" + NL + "\t\tPaletteRoot root = super.createPaletteRoot(existingPaletteRoot);" + NL + "\t\tnew ";
  protected final String TEXT_29 = "().fillPalette(root);" + NL + "\t\treturn root;" + NL + "\t}";
  protected final String TEXT_30 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_31 = " getPreferencesHint() {";
  protected final String TEXT_32 = NL + "\t\treturn ";
  protected final String TEXT_33 = ".DIAGRAM_PREFERENCES_HINT;" + NL + "\t}";
  protected final String TEXT_34 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getContributorId() {" + NL + "\t\treturn ";
  protected final String TEXT_35 = ".ID;" + NL + "\t}";
  protected final String TEXT_36 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class type) {" + NL + "\t\tif (type == ";
  protected final String TEXT_37 = ".class) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(type);" + NL + "\t}";
  protected final String TEXT_38 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String contentObjectURI;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_39 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_40 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_41 = "(contentObjectURI));" + NL + "\t\t} else {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_42 = "());" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_43 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSetInput(";
  protected final String TEXT_44 = " input, boolean releaseEditorContents) throws ";
  protected final String TEXT_45 = " {" + NL + "\t\tcontentObjectURI = null;" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_46 = ") {" + NL + "\t\t\tfinal ";
  protected final String TEXT_47 = " diagram = ((";
  protected final String TEXT_48 = ") input).getDiagram();" + NL + "\t\t\tfinal ";
  protected final String TEXT_49 = " diagramFile = ";
  protected final String TEXT_50 = ".getFile(diagram.eResource());" + NL + "\t\t\t";
  protected final String TEXT_51 = " newInput = new ";
  protected final String TEXT_52 = "(diagramFile);" + NL + "\t\t\tcontentObjectURI = diagram.eResource().getURIFragment(diagram);" + NL + "\t\t\tsuper.doSetInput(newInput, releaseEditorContents);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.doSetInput(input, releaseEditorContents);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_53 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void gotoMarker(";
  protected final String TEXT_54 = " marker) {";
  protected final String TEXT_55 = NL + "        ";
  protected final String TEXT_56 = ".getInstance().gotoMarker(this, marker);" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSaveAsAllowed() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSaveAs() {" + NL + "\t\tperformSaveAs(new ";
  protected final String TEXT_57 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performSaveAs(";
  protected final String TEXT_58 = " progressMonitor) {" + NL + "\t\t";
  protected final String TEXT_59 = " shell = getSite().getShell();" + NL + "\t\t";
  protected final String TEXT_60 = " input = getEditorInput();" + NL + "\t\t";
  protected final String TEXT_61 = " dialog = new ";
  protected final String TEXT_62 = "(shell);" + NL + "\t\t";
  protected final String TEXT_63 = " original = input instanceof ";
  protected final String TEXT_64 = " ? ((";
  protected final String TEXT_65 = ") input).getFile() : null;" + NL + "\t\tif (original != null) {" + NL + "\t\t\tdialog.setOriginalFile(original);" + NL + "\t\t}" + NL + "\t\tdialog.create();" + NL + "\t\t";
  protected final String TEXT_66 = " provider = getDocumentProvider();" + NL + "\t\tif (provider == null) {" + NL + "\t\t\t// editor has been programmatically closed while the dialog was open" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (provider.isDeleted(input) && original != null) {" + NL + "\t\t\tString message = ";
  protected final String TEXT_67 = ".bind(\"The original file ''{0}'' has been deleted.\", original.getName());" + NL + "\t\t\tdialog.setErrorMessage(null);" + NL + "\t\t\tdialog.setMessage(message, ";
  protected final String TEXT_68 = ".WARNING);" + NL + "\t\t}" + NL + "\t\tif (dialog.open() == ";
  protected final String TEXT_69 = ".CANCEL) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_70 = " filePath = dialog.getResult();" + NL + "\t\tif (filePath == null) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_71 = " workspaceRoot = ";
  protected final String TEXT_72 = ".getWorkspace().getRoot();" + NL + "\t\t";
  protected final String TEXT_73 = " file = workspaceRoot.getFile(filePath);" + NL + "\t\tfinal ";
  protected final String TEXT_74 = " newInput = new ";
  protected final String TEXT_75 = "(file);" + NL + "\t\t// Check if the editor is already open" + NL + "\t\t";
  protected final String TEXT_76 = " matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();" + NL + "\t\t";
  protected final String TEXT_77 = "[] editorRefs = ";
  protected final String TEXT_78 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();" + NL + "\t\tfor (int i = 0; i < editorRefs.length; i++) {" + NL + "\t\t\tif (matchingStrategy.matches(editorRefs[i], newInput)) {" + NL + "\t\t\t\t";
  protected final String TEXT_79 = ".openWarning(shell, \"Problem During Save As...\", \"Save could not be completed. Target file is already open in another editor.\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean success = false;" + NL + "\t\ttry {" + NL + "\t\t\tprovider.aboutToChange(newInput);" + NL + "\t\t\tgetDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);" + NL + "\t\t\tsuccess = true;" + NL + "\t\t} catch (";
  protected final String TEXT_80 = " x) {" + NL + "\t\t\t";
  protected final String TEXT_81 = " status = x.getStatus();" + NL + "\t\t\tif (status == null || status.getSeverity() != ";
  protected final String TEXT_82 = ".CANCEL) {" + NL + "\t\t\t\t";
  protected final String TEXT_83 = ".openError(shell, \"Save Problems\", \"Could not save file.\", x.getStatus());" + NL + "\t\t\t}" + NL + "\t\t} finally {" + NL + "\t\t\tprovider.changed(newInput);" + NL + "\t\t\tif (success) {" + NL + "\t\t\t\tsetInput(newInput);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (progressMonitor != null) {" + NL + "\t\t\tprogressMonitor.setCanceled(!success);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_84 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSetInput(";
  protected final String TEXT_85 = " input, boolean releaseEditorContents) throws ";
  protected final String TEXT_86 = " {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_87 = ") {" + NL + "\t\t\tfinal ";
  protected final String TEXT_88 = " diagram = ((";
  protected final String TEXT_89 = ") input).getDiagram();" + NL + "\t\t\t";
  protected final String TEXT_90 = " newInput = new ";
  protected final String TEXT_91 = "(diagram.eResource().getURI());" + NL + "\t\t\tsuper.doSetInput(newInput, releaseEditorContents);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.doSetInput(input, releaseEditorContents);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_92 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_93 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_94 = "());" + NL + "\t\t} else {" + NL + "\t\t\tsuper.setDocumentProvider(input);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_95 = " getDocumentProvider(";
  protected final String TEXT_96 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_97 = ") {" + NL + "\t\t\treturn new ";
  protected final String TEXT_98 = "();" + NL + "\t\t}" + NL + "\t\treturn super.getDocumentProvider(input);" + NL + "\t}";
  protected final String TEXT_99 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeGraphicalViewer() {" + NL + "\t\tsuper.initializeGraphicalViewer();" + NL + "\t\tgetDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), ";
  protected final String TEXT_100 = ".getTransfer()) {" + NL + "" + NL + "\t\t\tprotected Object getJavaObject(";
  protected final String TEXT_101 = " data) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_102 = ".getTransfer().nativeToJava(data);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "\t\tgetDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), ";
  protected final String TEXT_103 = ".getInstance()) {" + NL + "" + NL + "\t\t\tprotected Object getJavaObject(";
  protected final String TEXT_104 = " data) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_105 = ".getInstance().nativeToJava(data);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate abstract class DropTargetListener extends ";
  protected final String TEXT_106 = " {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic DropTargetListener(";
  protected final String TEXT_107 = " viewer, ";
  protected final String TEXT_108 = " xfer) {" + NL + "\t\t\tsuper(viewer, xfer);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_109 = " getObjectsBeingDropped() {" + NL + "\t\t\t";
  protected final String TEXT_110 = " data = getCurrentEvent().currentDataType;" + NL + "\t\t\t";
  protected final String TEXT_111 = " uris = new ";
  protected final String TEXT_112 = "();" + NL + "" + NL + "\t\t\tObject transferedObject = getJavaObject(data);" + NL + "\t\t\tif (transferedObject instanceof ";
  protected final String TEXT_113 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_114 = " selection = (";
  protected final String TEXT_115 = ") transferedObject;" + NL + "\t\t\t\tfor (";
  protected final String TEXT_116 = " it = selection.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tObject nextSelectedObject = it.next();";
  protected final String TEXT_117 = NL + "\t\t\t\t\tif (nextSelectedObject instanceof ";
  protected final String TEXT_118 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = " view = ((";
  protected final String TEXT_120 = ") nextSelectedObject).getView();" + NL + "\t\t\t\t\t\tnextSelectedObject = view.getElement();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_121 = "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\tif (nextSelectedObject instanceof ";
  protected final String TEXT_122 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = " modelElement = (";
  protected final String TEXT_124 = ") nextSelectedObject;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = " modelElementResource = modelElement.eResource();" + NL + "\t\t\t\t\t\turis.add(modelElementResource.getURI().appendFragment(modelElementResource.getURIFragment(modelElement)));\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_126 = " result = new ";
  protected final String TEXT_127 = "();" + NL + "\t\t\tfor (";
  protected final String TEXT_128 = " it = uris.iterator(); it.hasNext();) {" + NL + "\t\t\t\t";
  protected final String TEXT_129 = " nextURI = (";
  protected final String TEXT_130 = ") it.next();" + NL + "\t\t\t\t";
  protected final String TEXT_131 = " modelObject = getEditingDomain().getResourceSet().getEObject(nextURI, true);" + NL + "\t\t\t\tresult.add(modelObject);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract Object getJavaObject(";
  protected final String TEXT_132 = " data);" + NL + "\t" + NL + "\t}";
  protected final String TEXT_133 = NL + "\t" + NL + "}";

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
    stringBuffer.append(genDiagram.getEditingDomainID());
    stringBuffer.append(TEXT_12);
    String notificationGilterFQName = importManager.getImportedName("org.eclipse.emf.transaction.NotificationFilter");
    stringBuffer.append(TEXT_13);
    stringBuffer.append(notificationGilterFQName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(notificationGilterFQName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(notificationGilterFQName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(notificationGilterFQName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Adapter"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notifier"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notifier"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notifier"));
    stringBuffer.append(TEXT_27);
    if (genDiagram.getPalette() != null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint"));
    stringBuffer.append(TEXT_31);
    /*XXX seems better we use preference store directly (in configureGraphicalViewer) instead all these indirect ids */
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_33);
    if (genDiagram.getEditorGen().getPropertySheet() != null) { /*perhaps, we should override contributor id regardless of sheet presence, there's no much sense in default id either.*/
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySheetPage"));
    stringBuffer.append(TEXT_37);
    }
    if (genDiagram.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.StorageDiagramDocumentProvider"));
    stringBuffer.append(TEXT_42);
    for (Iterator it = genDiagram.getAllNodes().iterator(); it.hasNext();) {
	GenCommonBase next = (GenCommonBase) it.next();
	if (!next.getBehaviour(OpenDiagramBehaviour.class).isEmpty()) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_52);
    
	break; // suffice to find at least one element with opendiagram policy to know we should override doSetInput
	}
}
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IMarker"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Shell"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.osgi.util.NLS"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.IMessageProvider"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.window.Window"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IWorkspaceRoot"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorMatchingStrategy"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorReference"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_83);
    } else { // genDiagram.getEditorGen().getApplication() != null 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append("org.eclipse.emf.common.ui.URIEditorInput");
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getApplication().getPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getApplication().getPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_98);
    }

if (genDiagram.generateCreateShortcutAction()) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.util.LocalSelectionTransfer"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.util.LocalSelectionTransfer"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.dnd.LocalTransfer"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.dnd.LocalTransfer"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPartViewer"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.Transfer"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("java.util.HashSet"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_116);
    
/*
 * TODO: movel NavigatorItem to some public place and remove 
 * "genEditor.getEditorGen().getNavigator() != null" test
 */
	if (genEditor.getEditorGen().getNavigator() != null) {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(genEditor.getEditorGen().getNavigator().getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(genEditor.getEditorGen().getNavigator().getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_120);
    	}
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
