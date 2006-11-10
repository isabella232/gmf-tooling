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
  protected final String TEXT_4 = NL + NL + "import org.eclipse.draw2d.DelegatingLayout;" + NL + "import org.eclipse.draw2d.FreeformLayer;" + NL + "import org.eclipse.draw2d.LayeredPane;" + NL + "import org.eclipse.gef.LayerConstants;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
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
  protected final String TEXT_27 = " newTarget) {" + NL + "\t\t\t\tmyTarger = newTarget;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "" + NL + "" + NL + "\t\treturn domain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "\t\tDiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer().getRootEditPart();" + NL + "\t\tLayeredPane printableLayers = (LayeredPane) root.getLayer(LayerConstants.PRINTABLE_LAYERS);" + NL + "\t\tFreeformLayer extLabelsLayer = new FreeformLayer();" + NL + "\t\textLabelsLayer.setLayoutManager(new DelegatingLayout());" + NL + "\t\tprintableLayers.addLayerAfter(extLabelsLayer, ";
  protected final String TEXT_28 = ".EXTERNAL_NODE_LABELS_LAYER, LayerConstants.PRIMARY_LAYER);" + NL + "\t\tLayeredPane scalableLayers = (LayeredPane) root.getLayer(LayerConstants.SCALABLE_LAYERS);" + NL + "\t\tFreeformLayer scaledFeedbackLayer = new FreeformLayer();" + NL + "\t\tscaledFeedbackLayer.setEnabled(false);" + NL + "\t\tscalableLayers.addLayerAfter(scaledFeedbackLayer, LayerConstants.SCALED_FEEDBACK_LAYER, DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_29 = " getPreferencesHint() {";
  protected final String TEXT_30 = NL + "\t\treturn ";
  protected final String TEXT_31 = ".DIAGRAM_PREFERENCES_HINT;" + NL + "\t}";
  protected final String TEXT_32 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getContributorId() {" + NL + "\t\treturn ";
  protected final String TEXT_33 = ".ID;" + NL + "\t}";
  protected final String TEXT_34 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class type) {" + NL + "\t\tif (type == ";
  protected final String TEXT_35 = ".class) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(type);" + NL + "\t}";
  protected final String TEXT_36 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String contentObjectURI;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_37 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_38 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_39 = "(contentObjectURI));" + NL + "\t\t} else {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_40 = "());" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_41 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSetInput(";
  protected final String TEXT_42 = " input, boolean releaseEditorContents) throws ";
  protected final String TEXT_43 = " {" + NL + "\t\tcontentObjectURI = null;" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_44 = ") {" + NL + "\t\t\tfinal ";
  protected final String TEXT_45 = " diagram = ((";
  protected final String TEXT_46 = ") input).getDiagram();" + NL + "\t\t\tfinal ";
  protected final String TEXT_47 = " diagramFile = ";
  protected final String TEXT_48 = ".getFile(diagram.eResource());" + NL + "\t\t\t";
  protected final String TEXT_49 = " newInput = new ";
  protected final String TEXT_50 = "(diagramFile);" + NL + "\t\t\tcontentObjectURI = diagram.eResource().getURIFragment(diagram);" + NL + "\t\t\tsuper.doSetInput(newInput, releaseEditorContents);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.doSetInput(input, releaseEditorContents);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_51 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void gotoMarker(";
  protected final String TEXT_52 = " marker) {";
  protected final String TEXT_53 = NL + "        ";
  protected final String TEXT_54 = ".getInstance().gotoMarker(this, marker);" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSaveAsAllowed() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSaveAs() {" + NL + "\t\tperformSaveAs(new ";
  protected final String TEXT_55 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performSaveAs(";
  protected final String TEXT_56 = " progressMonitor) {" + NL + "\t\t";
  protected final String TEXT_57 = " shell = getSite().getShell();" + NL + "\t\t";
  protected final String TEXT_58 = " input = getEditorInput();" + NL + "\t\t";
  protected final String TEXT_59 = " dialog = new ";
  protected final String TEXT_60 = "(shell);" + NL + "\t\t";
  protected final String TEXT_61 = " original = input instanceof ";
  protected final String TEXT_62 = " ? ((";
  protected final String TEXT_63 = ") input).getFile() : null;" + NL + "\t\tif (original != null) {" + NL + "\t\t\tdialog.setOriginalFile(original);" + NL + "\t\t}" + NL + "\t\tdialog.create();" + NL + "\t\t";
  protected final String TEXT_64 = " provider = getDocumentProvider();" + NL + "\t\tif (provider == null) {" + NL + "\t\t\t// editor has been programmatically closed while the dialog was open" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (provider.isDeleted(input) && original != null) {" + NL + "\t\t\tString message = ";
  protected final String TEXT_65 = ".bind(\"The original file ''{0}'' has been deleted.\", original.getName());" + NL + "\t\t\tdialog.setErrorMessage(null);" + NL + "\t\t\tdialog.setMessage(message, ";
  protected final String TEXT_66 = ".WARNING);" + NL + "\t\t}" + NL + "\t\tif (dialog.open() == ";
  protected final String TEXT_67 = ".CANCEL) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_68 = " filePath = dialog.getResult();" + NL + "\t\tif (filePath == null) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_69 = " workspaceRoot = ";
  protected final String TEXT_70 = ".getWorkspace().getRoot();" + NL + "\t\t";
  protected final String TEXT_71 = " file = workspaceRoot.getFile(filePath);" + NL + "\t\tfinal ";
  protected final String TEXT_72 = " newInput = new ";
  protected final String TEXT_73 = "(file);" + NL + "\t\t// Check if the editor is already open" + NL + "\t\t";
  protected final String TEXT_74 = " matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();" + NL + "\t\t";
  protected final String TEXT_75 = "[] editorRefs = ";
  protected final String TEXT_76 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();" + NL + "\t\tfor (int i = 0; i < editorRefs.length; i++) {" + NL + "\t\t\tif (matchingStrategy.matches(editorRefs[i], newInput)) {" + NL + "\t\t\t\t";
  protected final String TEXT_77 = ".openWarning(shell, \"Problem During Save As...\", \"Save could not be completed. Target file is already open in another editor.\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean success = false;" + NL + "\t\ttry {" + NL + "\t\t\tprovider.aboutToChange(newInput);" + NL + "\t\t\tgetDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);" + NL + "\t\t\tsuccess = true;" + NL + "\t\t} catch (";
  protected final String TEXT_78 = " x) {" + NL + "\t\t\t";
  protected final String TEXT_79 = " status = x.getStatus();" + NL + "\t\t\tif (status == null || status.getSeverity() != ";
  protected final String TEXT_80 = ".CANCEL) {" + NL + "\t\t\t\t";
  protected final String TEXT_81 = ".openError(shell, \"Save Problems\", \"Could not save file.\", x.getStatus());" + NL + "\t\t\t}" + NL + "\t\t} finally {" + NL + "\t\t\tprovider.changed(newInput);" + NL + "\t\t\tif (success) {" + NL + "\t\t\t\tsetInput(newInput);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (progressMonitor != null) {" + NL + "\t\t\tprogressMonitor.setCanceled(!success);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_82 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_83 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_84 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_85 = "());" + NL + "\t\t} else {" + NL + "\t\t\tsuper.setDocumentProvider(input);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_86 = " getDocumentProvider(";
  protected final String TEXT_87 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_88 = ") {" + NL + "\t\t\treturn new ";
  protected final String TEXT_89 = "();" + NL + "\t\t}" + NL + "\t\treturn super.getDocumentProvider(input);" + NL + "\t}";
  protected final String TEXT_90 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeGraphicalViewer() {" + NL + "\t\tsuper.initializeGraphicalViewer();" + NL + "\t\tgetDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), ";
  protected final String TEXT_91 = ".getTransfer()) {" + NL + "" + NL + "\t\t\tprotected Object getJavaObject(";
  protected final String TEXT_92 = " data) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_93 = ".getTransfer().nativeToJava(data);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "\t\tgetDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), ";
  protected final String TEXT_94 = ".getInstance()) {" + NL + "" + NL + "\t\t\tprotected Object getJavaObject(";
  protected final String TEXT_95 = " data) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_96 = ".getInstance().nativeToJava(data);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t});" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate abstract class DropTargetListener extends ";
  protected final String TEXT_97 = " {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic DropTargetListener(";
  protected final String TEXT_98 = " viewer, ";
  protected final String TEXT_99 = " xfer) {" + NL + "\t\t\tsuper(viewer, xfer);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_100 = " getObjectsBeingDropped() {" + NL + "\t\t\t";
  protected final String TEXT_101 = " data = getCurrentEvent().currentDataType;" + NL + "\t\t\t";
  protected final String TEXT_102 = " uris = new ";
  protected final String TEXT_103 = "();" + NL + "" + NL + "\t\t\tObject transferedObject = getJavaObject(data);" + NL + "\t\t\tif (transferedObject instanceof ";
  protected final String TEXT_104 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_105 = " selection = (";
  protected final String TEXT_106 = ") transferedObject;" + NL + "\t\t\t\tfor (";
  protected final String TEXT_107 = " it = selection.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tObject nextSelectedObject = it.next();";
  protected final String TEXT_108 = NL + "\t\t\t\t\tif (nextSelectedObject instanceof ";
  protected final String TEXT_109 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_110 = " view = ((";
  protected final String TEXT_111 = ") nextSelectedObject).getView();" + NL + "\t\t\t\t\t\tnextSelectedObject = view.getElement();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_112 = "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\tif (nextSelectedObject instanceof ";
  protected final String TEXT_113 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_114 = " modelElement = (";
  protected final String TEXT_115 = ") nextSelectedObject;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_116 = " modelElementResource = modelElement.eResource();" + NL + "\t\t\t\t\t\turis.add(modelElementResource.getURI().appendFragment(modelElementResource.getURIFragment(modelElement)));\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_117 = " result = new ";
  protected final String TEXT_118 = "();" + NL + "\t\t\tfor (";
  protected final String TEXT_119 = " it = uris.iterator(); it.hasNext();) {" + NL + "\t\t\t\t";
  protected final String TEXT_120 = " nextURI = (";
  protected final String TEXT_121 = ") it.next();" + NL + "\t\t\t\t";
  protected final String TEXT_122 = " modelObject = getEditingDomain().getResourceSet().getEObject(nextURI, true);" + NL + "\t\t\t\tresult.add(modelObject);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract Object getJavaObject(";
  protected final String TEXT_123 = " data);" + NL + "\t" + NL + "\t}";
  protected final String TEXT_124 = NL + "\t" + NL + "}";

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
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint"));
    stringBuffer.append(TEXT_29);
    /*XXX seems better we use preference store directly (in configureGraphicalViewer) instead all these indirect ids */
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_31);
    if (genDiagram.getEditorGen().getPropertySheet() != null) { /*perhaps, we should override contributor id regardless of sheet presence, there's no much sense in default id either.*/
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySheetPage"));
    stringBuffer.append(TEXT_35);
    }
    if (genDiagram.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.StorageDiagramDocumentProvider"));
    stringBuffer.append(TEXT_40);
    for (Iterator it = genDiagram.getAllNodes().iterator(); it.hasNext();) {
	GenCommonBase next = (GenCommonBase) it.next();
	if (!next.getBehaviour(OpenDiagramBehaviour.class).isEmpty()) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_50);
    
	break; // suffice to find at least one element with opendiagram policy to know we should override doSetInput
	}
}
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IMarker"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Shell"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.osgi.util.NLS"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.IMessageProvider"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.window.Window"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IWorkspaceRoot"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorMatchingStrategy"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorReference"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_81);
    } else { // genDiagram.getEditorGen().getApplication() != null 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getApplication().getApplicationPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getApplication().getApplicationPackageName() + ".URIDiagramDocumentProvider"));
    stringBuffer.append(TEXT_89);
    }

if (genDiagram.generateCreateShortcutAction()) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.util.LocalSelectionTransfer"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.util.LocalSelectionTransfer"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.dnd.LocalTransfer"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.dnd.LocalTransfer"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPartViewer"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.Transfer"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.HashSet"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.IStructuredSelection"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_107);
    
/*
 * TODO: movel NavigatorItem to some public place and remove 
 * "genEditor.getEditorGen().getNavigator() != null" test
 */
	if (genEditor.getEditorGen().getNavigator() != null) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(genEditor.getEditorGen().getNavigator().getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName(genEditor.getEditorGen().getNavigator().getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_111);
    	}
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.dnd.TransferData"));
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
