package org.eclipse.gmf.codegen.templates.editor;

import java.util.*;
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
  protected final String TEXT_12 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected TransactionalEditingDomain createEditingDomain() {" + NL + "\t\tTransactionalEditingDomain domain = super.createEditingDomain();" + NL + "\t\tdomain.setID(getEditingDomainID());" + NL + "\t\treturn domain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "\t\tDiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer().getRootEditPart();" + NL + "\t\tLayeredPane printableLayers = (LayeredPane) root.getLayer(LayerConstants.PRINTABLE_LAYERS);" + NL + "\t\tFreeformLayer extLabelsLayer = new FreeformLayer();" + NL + "\t\textLabelsLayer.setLayoutManager(new DelegatingLayout());" + NL + "\t\tprintableLayers.addLayerAfter(extLabelsLayer, ";
  protected final String TEXT_13 = ".EXTERNAL_NODE_LABELS_LAYER, LayerConstants.PRIMARY_LAYER);" + NL + "\t\tLayeredPane scalableLayers = (LayeredPane) root.getLayer(LayerConstants.SCALABLE_LAYERS);" + NL + "\t\tFreeformLayer scaledFeedbackLayer = new FreeformLayer();" + NL + "\t\tscaledFeedbackLayer.setEnabled(false);" + NL + "\t\tscalableLayers.addLayerAfter(scaledFeedbackLayer, LayerConstants.SCALED_FEEDBACK_LAYER, DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_14 = " getPreferencesHint() {";
  protected final String TEXT_15 = NL + "\t\treturn ";
  protected final String TEXT_16 = ".DIAGRAM_PREFERENCES_HINT;" + NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getContributorId() {" + NL + "\t\treturn ";
  protected final String TEXT_18 = ".ID;" + NL + "\t}";
  protected final String TEXT_19 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class type) {" + NL + "\t\tif (type == ";
  protected final String TEXT_20 = ".class) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(type);" + NL + "\t}";
  protected final String TEXT_21 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(";
  protected final String TEXT_22 = " input) {" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_23 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_24 = "());" + NL + "\t\t} else if (input instanceof ";
  protected final String TEXT_25 = ") {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_26 = "() {" + NL + "" + NL + "\t\t\t\tpublic IEditorInput createInputWithEditingDomain(";
  protected final String TEXT_27 = " editorInput, TransactionalEditingDomain domain) {" + NL + "\t\t\t\t\tassert editorInput instanceof ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\tclass Proxy extends ";
  protected final String TEXT_29 = " implements ";
  protected final String TEXT_30 = " {" + NL + "" + NL + "\t\t\t\t\t\t// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=158740" + NL + "\t\t\t\t\t\tProxy(IEditorInput input, TransactionalEditingDomain domain) {" + NL + "\t\t\t\t\t\t\tsuper(input, domain);" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tpublic ";
  protected final String TEXT_31 = " getDiagram() {" + NL + "\t\t\t\t\t\t\treturn ((";
  protected final String TEXT_32 = ") fProxied).getDiagram();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn new Proxy(editorInput, domain);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t} else {" + NL + "\t\t\tsetDocumentProvider(new ";
  protected final String TEXT_33 = "());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void gotoMarker(";
  protected final String TEXT_34 = " marker) {";
  protected final String TEXT_35 = NL + "        ";
  protected final String TEXT_36 = ".getInstance().gotoMarker(this, marker);" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSaveAsAllowed() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSaveAs() {" + NL + "\t\tperformSaveAs(new ";
  protected final String TEXT_37 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performSaveAs(";
  protected final String TEXT_38 = " progressMonitor) {" + NL + "\t\t";
  protected final String TEXT_39 = " shell = getSite().getShell();" + NL + "\t\t";
  protected final String TEXT_40 = " input = getEditorInput();" + NL + "\t\t";
  protected final String TEXT_41 = " dialog = new ";
  protected final String TEXT_42 = "(shell);" + NL + "\t\t";
  protected final String TEXT_43 = " original = input instanceof ";
  protected final String TEXT_44 = " ? ((";
  protected final String TEXT_45 = ") input).getFile() : null;" + NL + "\t\tif (original != null) {" + NL + "\t\t\tdialog.setOriginalFile(original);" + NL + "\t\t}" + NL + "\t\tdialog.create();" + NL + "\t\t";
  protected final String TEXT_46 = " provider = getDocumentProvider();" + NL + "\t\tif (provider == null) {" + NL + "\t\t\t// editor has been programmatically closed while the dialog was open" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (provider.isDeleted(input) && original != null) {" + NL + "\t\t\tString message = ";
  protected final String TEXT_47 = ".bind(\"The original file ''{0}'' has been deleted.\", original.getName());" + NL + "\t\t\tdialog.setErrorMessage(null);" + NL + "\t\t\tdialog.setMessage(message, ";
  protected final String TEXT_48 = ".WARNING);" + NL + "\t\t}" + NL + "\t\tif (dialog.open() == ";
  protected final String TEXT_49 = ".CANCEL) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_50 = " filePath = dialog.getResult();" + NL + "\t\tif (filePath == null) {" + NL + "\t\t\tif (progressMonitor != null) {" + NL + "\t\t\t\tprogressMonitor.setCanceled(true);" + NL + "\t\t\t}" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_51 = " workspaceRoot = ";
  protected final String TEXT_52 = ".getWorkspace().getRoot();" + NL + "\t\t";
  protected final String TEXT_53 = " file = workspaceRoot.getFile(filePath);" + NL + "\t\tfinal ";
  protected final String TEXT_54 = " newInput = new ";
  protected final String TEXT_55 = "(file);" + NL + "\t\t// Check if the editor is already open" + NL + "\t\t";
  protected final String TEXT_56 = " matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();" + NL + "\t\t";
  protected final String TEXT_57 = "[] editorRefs = ";
  protected final String TEXT_58 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();" + NL + "\t\tfor (int i = 0; i < editorRefs.length; i++) {" + NL + "\t\t\tif (matchingStrategy.matches(editorRefs[i], newInput)) {" + NL + "\t\t\t\t";
  protected final String TEXT_59 = ".openWarning(shell, \"Problem During Save As...\", \"Save could not be completed. Target file is already open in another editor.\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean success = false;" + NL + "\t\ttry {" + NL + "\t\t\tprovider.aboutToChange(newInput);" + NL + "\t\t\tgetDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);" + NL + "\t\t\tsuccess = true;" + NL + "\t\t} catch (";
  protected final String TEXT_60 = " x) {" + NL + "\t\t\t";
  protected final String TEXT_61 = " status = x.getStatus();" + NL + "\t\t\tif (status == null || status.getSeverity() != ";
  protected final String TEXT_62 = ".CANCEL) {" + NL + "\t\t\t\t";
  protected final String TEXT_63 = ".openError(shell, \"Save Problems\", \"Could not save file.\", x.getStatus());" + NL + "\t\t\t}" + NL + "\t\t} finally {" + NL + "\t\t\tprovider.changed(newInput);" + NL + "\t\t\tif (success) {" + NL + "\t\t\t\tsetInput(newInput);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (progressMonitor != null) {" + NL + "\t\t\tprogressMonitor.setCanceled(!success);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_64 = NL + "}";
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView genEditor = (GenEditorView) ((Object[]) argument)[0];
final GenDiagram genDiagram = genEditor.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenPropertySheet propertySheet = genDiagram.getEditorGen().getPropertySheet();

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
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint"));
    stringBuffer.append(TEXT_14);
    /*XXX seems better we use preference store directly (in configureGraphicalViewer) instead all these indirect ids */
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_16);
    if (genDiagram.getEditorGen().getPropertySheet() != null) { /*perhaps, we should override contributor id regardless of sheet presence, there's no much sense in default id either.*/
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getEditorGen().getPlugin().getActivatorClassName());
    stringBuffer.append(TEXT_18);
    } else {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySheetPage"));
    stringBuffer.append(TEXT_20);
    }
    if (genDiagram.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramInputDocumentProvider"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.EditorInputProxy"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.StorageDiagramDocumentProvider"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IMarker"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Shell"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.dialogs.SaveAsDialog"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.osgi.util.NLS"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.IMessageProvider"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.window.Window"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IWorkspaceRoot"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorMatchingStrategy"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorReference"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.MessageDialog"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IStatus"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.dialogs.ErrorDialog"));
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
