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
  protected final String TEXT_3 = " extends GraphicalEditorWithFlyoutPalette {";
  protected final String TEXT_4 = NL + "\t/**" + NL + "\t * This class listens to changes to the file system in the workspace, and" + NL + "\t * makes the following changes: " + NL + "\t * <ul><li>If an open, saved file gets deleted, the editor is closed.</li>" + NL + "\t * <li>If an open file gets renamed or moved, the editor's" + NL + "\t * input is changed accordingly.</li></ul>" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ResourceTracker implements ";
  protected final String TEXT_5 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void resourceChanged(";
  protected final String TEXT_6 = " event) {" + NL + "\t\t\t";
  protected final String TEXT_7 = " delta = event.getDelta();" + NL + "\t\t\tif (delta != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_8 = " fileDelta = delta.findMember(((";
  protected final String TEXT_9 = ") getEditorInput()).getFile().getFullPath());" + NL + "\t\t\t\tif (fileDelta != null) {" + NL + "\t\t\t\t\tprocessFileDelta(fileDelta);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void processFileDelta(";
  protected final String TEXT_10 = " delta) {" + NL + "\t\t\tassert (delta != null && delta.getResource().equals(((";
  protected final String TEXT_11 = ") getEditorInput()).getFile()));" + NL + "\t\t\tif (delta.getKind() == ";
  protected final String TEXT_12 = ".REMOVED) {" + NL + "\t\t\t\tif ((";
  protected final String TEXT_13 = ".MOVED_TO & delta.getFlags()) == 0) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tif (!isDirty()) {" + NL + "\t\t\t\t\t\tcloseEditor();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t// else if it was moved or renamed" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_15 = " newFile = ";
  protected final String TEXT_16 = ".getWorkspace().getRoot().getFile(delta.getMovedToPath());" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = " display = getSite().getShell().getDisplay();" + NL + "\t\t\t\t\tdisplay.asyncExec(new Runnable() {" + NL + "\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\tsetInput(new ";
  protected final String TEXT_18 = "(newFile));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t});" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ResourceTracker resourceTracker;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ResourceTracker getResourceTracker() {" + NL + "\t\tif (resourceTracker == null) {" + NL + "\t\t\tresourceTracker = new ResourceTracker();" + NL + "\t\t}" + NL + "\t\treturn resourceTracker;" + NL + "\t}" + NL;
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class UpdatableActionGroup {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void addAction(UpdateAction action) {" + NL + "\t\t\tassert action != null;" + NL + "\t\t\tmyActions.add(action);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void removeAction(UpdateAction action) {" + NL + "\t\t\tmyActions.remove(action);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void update() {" + NL + "\t\t\tfor (Iterator it = myActions.iterator(); it.hasNext();) {" + NL + "\t\t\t\tUpdateAction next = (UpdateAction) it.next();" + NL + "\t\t\t\tnext.update();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ArrayList myActions = new ArrayList();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditingDomain editingDomain;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_22 = " diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDirty = false;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteRoot paletteRoot;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PropertySheetPage undoablePropertySheetPage;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate UpdatableActionGroup stackActions = new UpdatableActionGroup();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CommandStackListener commandStackListener = new CommandStackListener() {" + NL + "" + NL + "\t\tpublic void commandStackChanged(EventObject event) {" + NL + "\t\t\tstackActions.update();" + NL + "\t\t\tsetDirty(((CommandStack) event.getSource()).isDirty());" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate UpdatableActionGroup editPartActions = new UpdatableActionGroup();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ISelectionListener selectionListener = new ISelectionListener() {" + NL + "" + NL + "\t\tpublic void selectionChanged(IWorkbenchPart part, ISelection selection) {" + NL + "\t\t\teditPartActions.update();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate UpdatableActionGroup editorActions = new UpdatableActionGroup();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ComposedAdapterFactory domainAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void firePropertyChange(int propertyId) {" + NL + "\t\tsuper.firePropertyChange(propertyId);" + NL + "\t\teditorActions.update();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Adds an action to this editor's <code>ActionRegistry</code>. (This is" + NL + "\t * a helper method.)" + NL + "\t * " + NL + "\t * @generated" + NL + "\t * @param action" + NL + "\t *            the action to add." + NL + "\t */" + NL + "\tprotected void addAction(IAction action) {" + NL + "\t\tgetActionRegistry().registerAction(action);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Adds an editor action to this editor." + NL + "\t * " + NL + "\t * <p>" + NL + "\t * Editor actions are actions that depend and work on the editor." + NL + "\t * " + NL + "\t * @generated" + NL + "\t * @param action" + NL + "\t *            the editor action" + NL + "\t */" + NL + "\tprotected void addEditorAction(WorkbenchPartAction action) {" + NL + "\t\tgetActionRegistry().registerAction(action);" + NL + "\t\teditorActions.addAction(action);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Adds an <code>EditPart</code> action to this editor." + NL + "\t * " + NL + "\t * <p>" + NL + "\t * <code>EditPart</code> actions are actions that depend and work on the" + NL + "\t * selected <code>EditPart</code>s." + NL + "\t * " + NL + "\t * @generated" + NL + "\t * @param action" + NL + "\t *            the <code>EditPart</code> action" + NL + "\t */" + NL + "\tprotected void addEditPartAction(SelectionAction action) {" + NL + "\t\tgetActionRegistry().registerAction(action);" + NL + "\t\teditPartActions.addAction(action);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Adds an <code>CommandStack</code> action to this editor." + NL + "\t * " + NL + "\t * <p>" + NL + "\t * <code>CommandStack</code> actions are actions that depend and work on" + NL + "\t * the <code>CommandStack</code>." + NL + "\t * " + NL + "\t * @generated" + NL + "\t * @param action" + NL + "\t *            the <code>CommandStack</code> action" + NL + "\t */" + NL + "\tprotected void addStackAction(StackAction action) {" + NL + "\t\tgetActionRegistry().registerAction(action);" + NL + "\t\tstackActions.addAction(action);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createActions() {" + NL + "\t\taddStackAction(new UndoAction(this));" + NL + "\t\taddStackAction(new RedoAction(this));" + NL + "" + NL + "\t\taddEditPartAction(new DeleteAction((IWorkbenchPart) this));" + NL + "\t\taddEditPartAction(new DirectEditAction((IWorkbenchPart) this));" + NL + "" + NL + "\t\taddEditPartAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.LEFT));" + NL + "\t\taddEditPartAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.RIGHT));" + NL + "\t\taddEditPartAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.TOP));" + NL + "\t\taddEditPartAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.BOTTOM));" + NL + "\t\taddEditPartAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.CENTER));" + NL + "\t\taddEditPartAction(new AlignmentAction((IWorkbenchPart) this, PositionConstants.MIDDLE));" + NL + "" + NL + "\t\taddEditorAction(new SaveAction(this));" + NL + "\t\taddEditorAction(new PrintAction(this));" + NL + "" + NL + "\t\tIAction zoomIn = new ZoomInAction(getZoomManager());" + NL + "\t\tIAction zoomOut = new ZoomOutAction(getZoomManager());" + NL + "\t\taddAction(zoomIn);" + NL + "\t\taddAction(zoomOut);" + NL + "\t\tgetSite().getKeyBindingService().registerAction(zoomIn);" + NL + "\t\tgetSite().getKeyBindingService().registerAction(zoomOut);" + NL + "\t}" + NL;
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tvoid closeEditor() {" + NL + "\t\tgetSite().getShell().getDisplay().syncExec(new Runnable() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\tgetSite().getPage().closeEditor(";
  protected final String TEXT_24 = ".this, false);" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void dispose() {" + NL + "\t\t// remove CommandStackListener" + NL + "\t\tgetCommandStack().removeCommandStackListener(getStackActionsListener());" + NL + "" + NL + "\t\t// remove selection listener" + NL + "\t\tgetSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(getSelectionListener());" + NL + "" + NL + "\t\t// dispose the ActionRegistry (will dispose all actions)" + NL + "\t\tgetActionRegistry().dispose();" + NL + "" + NL + "\t\t// important: always call super implementation of dispose" + NL + "\t\tsuper.dispose();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSave(IProgressMonitor monitor) {" + NL + "\t\ttry {" + NL + "\t\t\tsave(monitor);" + NL + "\t\t\tgetCommandStack().markSaveLocation();" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\tErrorDialog.openError(getSite().getShell(), \"Error During Save\", \"The current ";
  protected final String TEXT_26 = " model could not be saved.\", e.getStatus());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void save(IProgressMonitor progressMonitor) throws CoreException {" + NL + "\t\tif (progressMonitor == null) {" + NL + "\t\t\tprogressMonitor = new NullProgressMonitor();" + NL + "\t\t}" + NL + "\t\tprogressMonitor.beginTask(\"Saving\", getEditingDomain().getResourceSet().getResources().size());" + NL + "\t\ttry {" + NL + "\t\t\tfor(Iterator it = getEditingDomain().getResourceSet().getResources().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\tResource next = (Resource)it.next();" + NL + "\t\t\t\tnext.save(Collections.EMPTY_MAP);" + NL + "\t\t\t\tprogressMonitor.worked(1);" + NL + "\t\t\t}" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tIStatus status = new Status(IStatus.ERROR, ";
  protected final String TEXT_27 = ".ID, 0, \"Error writing file.\", e);" + NL + "\t\t\tthrow new CoreException(status);" + NL + "\t\t} finally {" + NL + "\t\t\tprogressMonitor.done();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSaveAsAllowed() {" + NL + "\t\t// TODO: should be allowed." + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void doSaveAs() {" + NL + "\t\t// TODO: Implement." + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class type) {" + NL + "\t\tif (type == IPropertySheetPage.class) {" + NL + "\t\t\treturn getPropertySheetPage();" + NL + "\t\t} else if (type == IContentOutlinePage.class) {" + NL + "\t\t\treturn getOutlinePage();" + NL + "\t\t} else if (type == ZoomManager.class) {" + NL + "\t\t\treturn getZoomManager();" + NL + "\t\t}" + NL + "\t\treturn super.getAdapter(type);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ZoomManager getZoomManager() {" + NL + "\t\treturn getZoomManager(getGraphicalViewer());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ZoomManager getZoomManager(GraphicalViewer viewer) {" + NL + "\t\t// get zoom manager from root edit part" + NL + "\t\tRootEditPart rootEditPart = viewer.getRootEditPart();" + NL + "\t\tZoomManager zoomManager = null;" + NL + "\t\tif (rootEditPart instanceof ScalableFreeformRootEditPart) {" + NL + "\t\t\tzoomManager = ((ScalableFreeformRootEditPart) rootEditPart).getZoomManager();" + NL + "\t\t} else if (rootEditPart instanceof ScalableRootEditPart) {" + NL + "\t\t\tzoomManager = ((ScalableRootEditPart) rootEditPart).getZoomManager();" + NL + "\t\t}" + NL + "\t\treturn zoomManager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate CommandStackListener getStackActionsListener() {" + NL + "\t\treturn commandStackListener;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IContentOutlinePage getOutlinePage() {" + NL + "\t\t//TODO: outline page missing" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PaletteRoot getPaletteRoot() {" + NL + "\t\tif (paletteRoot == null) {" + NL + "\t\t\tpaletteRoot = new PaletteRoot();";
  protected final String TEXT_28 = NL + "\t\t\tnew ";
  protected final String TEXT_29 = "(getDomainAdapterFactory()).contributeToPalette(paletteRoot);";
  protected final String TEXT_30 = NL + "\t\t}" + NL + "\t\treturn paletteRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PropertySheetPage getPropertySheetPage() {" + NL + "\t\tif (undoablePropertySheetPage == null) {" + NL + "\t\t\tundoablePropertySheetPage = new PropertySheetPage();" + NL + "\t\t\t";
  protected final String TEXT_31 = " rootEntry = new ";
  protected final String TEXT_32 = "(getCommandStack());" + NL + "\t\t\trootEntry.setPropertySourceProvider(new ";
  protected final String TEXT_33 = "(getDomainAdapterFactory()));" + NL + "\t\t\tundoablePropertySheetPage.setRootEntry(rootEntry);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn undoablePropertySheetPage;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ISelectionListener getSelectionListener() {" + NL + "\t\treturn selectionListener;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_34 = " get";
  protected final String TEXT_35 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_36 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Diagram getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(IEditorSite site, IEditorInput input) throws PartInitException {" + NL + "\t\tURI file = getURIFromInput(input);" + NL + "\t\tif (file == null) {" + NL + "\t\t\tthrow new PartInitException(\"The specified input is not valid.\");" + NL + "\t\t}" + NL + "\t\tsetSite(site);" + NL + "\t\tsetInput(input);" + NL + "\t\tsetEditDomain(new DefaultEditDomain(this));" + NL + "" + NL + "\t\t// validate" + NL + "\t\tif (get";
  protected final String TEXT_37 = "() == null) {" + NL + "\t\t\tthrow new PartInitException(\"The specified input is not valid.\");" + NL + "\t\t}" + NL + "" + NL + "\t\t// add CommandStackListener" + NL + "\t\tgetCommandStack().addCommandStackListener(getStackActionsListener());" + NL + "" + NL + "\t\t// add selection change listener" + NL + "\t\tgetSite().getWorkbenchWindow().getSelectionService().addSelectionListener(getSelectionListener());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setInput(IEditorInput input)  {";
  protected final String TEXT_38 = NL + "\t\tif (getEditorInput() instanceof ";
  protected final String TEXT_39 = ") {" + NL + "\t\t\t";
  protected final String TEXT_40 = " resource = ((";
  protected final String TEXT_41 = ") getEditorInput()).getFile();" + NL + "\t\t\tresource.getWorkspace().removeResourceChangeListener(getResourceTracker());" + NL + "\t\t}";
  protected final String TEXT_42 = NL + "\t\tURI file = getURIFromInput(input);" + NL + "\t\tload(file);" + NL + "\t\tsetPartName(file.lastSegment());" + NL + "\t\tsuper.setInput(input);";
  protected final String TEXT_43 = NL + "\t\tif (getEditorInput() instanceof ";
  protected final String TEXT_44 = ") {" + NL + "\t\t\t";
  protected final String TEXT_45 = " resource = ((";
  protected final String TEXT_46 = ") getEditorInput()).getFile();" + NL + "\t\t\tresource.getWorkspace().addResourceChangeListener(getResourceTracker());" + NL + "\t\t}";
  protected final String TEXT_47 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate URI getURIFromInput(IEditorInput input) {";
  protected final String TEXT_48 = NL + "\t\tif (input instanceof ";
  protected final String TEXT_49 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_50 = ") input).getURI();" + NL + "\t\t}" + NL + "\t\tif (input instanceof ";
  protected final String TEXT_51 = ") {" + NL + "\t\t\treturn URI.createFileURI(((IPathEditorInput)input).getPath().toOSString());" + NL + "\t\t}";
  protected final String TEXT_52 = NL + "\t\tif (input instanceof ";
  protected final String TEXT_53 = ") {" + NL + "\t\t\treturn URI.createPlatformResourceURI(((IFileEditorInput)input).getFile().getFullPath().toString());" + NL + "\t\t}";
  protected final String TEXT_54 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isDirty() {" + NL + "\t\treturn isDirty;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setDirty(boolean dirty) {" + NL + "\t\tif (isDirty != dirty) {" + NL + "\t\t\tisDirty = dirty;" + NL + "\t\t\tfirePropertyChange(IEditorPart.PROP_DIRTY);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EditingDomain getEditingDomain() {" + NL + "\t\tif (editingDomain == null) {" + NL + "\t\t\tBasicCommandStack commandStack = new BasicCommandStack();" + NL + "\t\t\teditingDomain = new AdapterFactoryEditingDomain(getDomainAdapterFactory(), commandStack, new HashMap());" + NL + "\t\t\teditingDomain.getResourceSet().eAdapters().add(new AdapterFactoryEditingDomain.EditingDomainProvider(editingDomain));" + NL + "\t\t}" + NL + "\t\treturn editingDomain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate AdapterFactory getDomainAdapterFactory() {" + NL + "\t\tif (domainAdapterFactory == null) {" + NL + "\t\t\tList factories = new ArrayList();" + NL + "\t\t\tfactories.add(new ResourceItemProviderAdapterFactory());";
  protected final String TEXT_55 = NL + "\t\t\tfactories.add(new ";
  protected final String TEXT_56 = "());";
  protected final String TEXT_57 = NL + "\t\t\tfactories.add(new ReflectiveItemProviderAdapterFactory());" + NL + "\t\t\tfactories.add(new NotationItemProviderAdapterFactory());" + NL + "\t\t\tdomainAdapterFactory = new ComposedAdapterFactory(factories);" + NL + "\t\t}" + NL + "\t\treturn domainAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void load(URI diagramFile) {" + NL + "\t\t";
  protected final String TEXT_58 = " = null;" + NL + "\t\tdiagram = null;" + NL + "\t\tif (diagramFile == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tEditingDomain editingDomain = getEditingDomain();" + NL + "\t\tResourceSet resourceSet = editingDomain.getResourceSet();" + NL + "\t\tResource diagramResource = resourceSet.getResource(diagramFile, true);" + NL + "\t\tif (diagramResource == null) {" + NL + "\t\t\tdiagramResource = resourceSet.createResource(diagramFile);" + NL + "\t\t}" + NL + "\t\tdiagram = (Diagram) findInResource(diagramResource, Diagram.class);" + NL + "\t\tif (diagram == null) {" + NL + "\t\t\tdiagram = NotationFactory.eINSTANCE.createDiagram();" + NL + "\t\t\tdiagramResource.getContents().add(0, diagram);" + NL + "\t\t\t//Auxiliary creation should not be undoable." + NL + "\t\t\ttry {" + NL + "\t\t\t\tdiagramResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\tdiagram = null;" + NL + "\t\t\t\t";
  protected final String TEXT_59 = " = null;" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_60 = " = (";
  protected final String TEXT_61 = ") diagram.getElement();" + NL + "\t\tif (";
  protected final String TEXT_62 = " == null) {";
  protected final String TEXT_63 = NL + "\t\t\tURI modelFile = ";
  protected final String TEXT_64 = ".getModelFileURI(diagramFile);" + NL + "\t\t\tResource modelResource = resourceSet.getResource(modelFile, true);" + NL + "\t\t\tif (modelResource == null) {" + NL + "\t\t\t\tmodelResource = resourceSet.createResource(modelFile);" + NL + "\t\t\t}";
  protected final String TEXT_65 = NL + "\t\t\t";
  protected final String TEXT_66 = " = (";
  protected final String TEXT_67 = ") findInResource(";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ".class);" + NL + "\t\t\tif (";
  protected final String TEXT_70 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ".eINSTANCE.create";
  protected final String TEXT_73 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_74 = ".getContents().add(0, ";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t//We don't want this auxiliary creation to be undoable." + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\t";
  protected final String TEXT_76 = ".save(Collections.EMPTY_MAP);" + NL + "\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t\tdiagram = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = " = null;" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (!diagram.isSetElement()) {" + NL + "\t\t\t\tdiagram.setElement(";
  protected final String TEXT_78 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_79 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Object findInResource(Resource resource, Class expectedClass) {" + NL + "\t\tfor(Iterator it = resource.getContents().iterator(); it.hasNext(); ) {" + NL + "\t\t\tObject next = it.next();" + NL + "\t\t\tif (expectedClass.isInstance(next)) {" + NL + "\t\t\t\treturn next;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setFocus() {" + NL + "\t\tgetGraphicalViewer().getControl().setFocus();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final void createPartControl(Composite parent) {" + NL + "\t\tsuper.createPartControl(parent);" + NL + "\t\t// initialize actions" + NL + "\t\tcreateActions();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createGraphicalViewer(Composite parent) {" + NL + "\t\tsuper.createGraphicalViewer(parent);" + NL + "\t\t// initialize the viewer with input" + NL + "\t\tScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();" + NL + "\t\tgetGraphicalViewer().setRootEditPart(root);" + NL + "\t\tgetGraphicalViewer().setEditPartFactory(new ";
  protected final String TEXT_80 = "());" + NL + "" + NL + "\t\t";
  protected final String TEXT_81 = " printableLayers = (";
  protected final String TEXT_82 = ") root.getLayer(";
  protected final String TEXT_83 = ".PRINTABLE_LAYERS);" + NL + "\t\t";
  protected final String TEXT_84 = " extLabelsLayer = new ";
  protected final String TEXT_85 = "();" + NL + "\t\textLabelsLayer.setLayoutManager(new ";
  protected final String TEXT_86 = "());" + NL + "\t\tprintableLayers.addLayerAfter(extLabelsLayer, ";
  protected final String TEXT_87 = ".EXTERNAL_NODE_LABELS_LAYER, ";
  protected final String TEXT_88 = ".PRIMARY_LAYER);" + NL + "\t\tgetGraphicalViewer().setContents(getDiagram());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "\t\tGraphicalViewer viewer = getGraphicalViewer();" + NL + "\t\t// configure the context menu" + NL + "\t\tContextMenuProvider provider = new ";
  protected final String TEXT_89 = "ContextMenuProvider(viewer);" + NL + "\t\tviewer.setContextMenu(provider);" + NL + "\t\tgetSite().registerContextMenu(";
  protected final String TEXT_90 = ".ID + \".editor.contextmenu\", provider, getSite().getSelectionProvider()); //$NON-NLS-1$" + NL + "" + NL + "\t\tKeyHandler keyHandler = new GraphicalViewerKeyHandler(viewer);" + NL + "\t\tkeyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0), getActionRegistry().getAction(ActionFactory.DELETE.getId()));" + NL + "\t\tkeyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));" + NL + "\t\tviewer.setKeyHandler(keyHandler);" + NL + "" + NL + "\t\tviewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL), MouseWheelZoomHandler.SINGLETON);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ";
  protected final String TEXT_91 = "ContextMenuProvider extends ContextMenuProvider {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_92 = "ContextMenuProvider(EditPartViewer viewer) {" + NL + "\t\t\tsuper(viewer);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t    public void buildContextMenu(IMenuManager menuManager) {" + NL + "\t        GEFActionConstants.addStandardActionGroups(menuManager);" + NL + "\t\t\tappendActionToMenu(menuManager, ActionFactory.UNDO.getId(), GEFActionConstants.GROUP_UNDO);" + NL + "\t\t\tappendActionToMenu(menuManager, ActionFactory.REDO.getId(), GEFActionConstants.GROUP_UNDO);" + NL + "\t" + NL + "\t\t\tappendActionToMenu(menuManager, ActionFactory.COPY.getId(), GEFActionConstants.GROUP_EDIT);" + NL + "\t\t\tappendActionToMenu(menuManager, ActionFactory.PASTE.getId(), GEFActionConstants.GROUP_EDIT);" + NL + "\t\t\tappendActionToMenu(menuManager, ActionFactory.DELETE.getId(), GEFActionConstants.GROUP_EDIT);" + NL + "\t\t\tappendActionToMenu(menuManager, GEFActionConstants.DIRECT_EDIT, GEFActionConstants.GROUP_EDIT);" + NL + "" + NL + "\t\t\tappendActionToMenu(menuManager, ActionFactory.SAVE.getId(), GEFActionConstants.GROUP_SAVE);" + NL + "" + NL + "\t\t\tappendAlignmentSubmenu(menuManager);" + NL + "\t    }" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void appendAlignmentSubmenu(IMenuManager menuManager) {" + NL + "\t\t\t// Alignment Actions" + NL + "\t\t\tMenuManager submenu = new MenuManager(\"Align\");" + NL + "\t\t\tsubmenu.add(new Separator(GEFActionConstants.MB_ADDITIONS));" + NL + "\t" + NL + "\t\t\tappendActionToMenu(submenu, GEFActionConstants.ALIGN_LEFT, GEFActionConstants.MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, GEFActionConstants.ALIGN_CENTER, GEFActionConstants.MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, GEFActionConstants.ALIGN_RIGHT, GEFActionConstants.MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, GEFActionConstants.ALIGN_TOP, GEFActionConstants.MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, GEFActionConstants.ALIGN_MIDDLE, GEFActionConstants.MB_ADDITIONS);" + NL + "\t\t\tappendActionToMenu(submenu, GEFActionConstants.ALIGN_BOTTOM, GEFActionConstants.MB_ADDITIONS);" + NL + "\t" + NL + "\t\t\tif (!submenu.isEmpty()) {" + NL + "\t\t\t\tmenuManager.appendToGroup(GEFActionConstants.GROUP_REST, submenu);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void appendActionToMenu(IMenuManager menu, String actionId, String menuGroup) {" + NL + "\t\t\tIAction action = getActionRegistry().getAction(actionId);" + NL + "\t\t\tif (action != null && action.isEnabled()) {" + NL + "\t\t\t\tmenu.appendToGroup(menuGroup, action);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_93 = NL;

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
    
importManager.addImport("java.io.IOException");
importManager.addImport("java.util.ArrayList");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.EventObject");
importManager.addImport("java.util.HashMap");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.List");

importManager.addImport("org.eclipse.core.runtime.CoreException");
importManager.addImport("org.eclipse.core.runtime.IProgressMonitor");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.core.runtime.NullProgressMonitor");
importManager.addImport("org.eclipse.core.runtime.Status");
importManager.addImport("org.eclipse.draw2d.PositionConstants");
importManager.addImport("org.eclipse.emf.common.command.BasicCommandStack");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("org.eclipse.emf.ecore.resource.Resource");
importManager.addImport("org.eclipse.emf.ecore.resource.ResourceSet");
importManager.addImport("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain");
importManager.addImport("org.eclipse.emf.edit.domain.EditingDomain");
importManager.addImport("org.eclipse.emf.edit.provider.ComposedAdapterFactory");
importManager.addImport("org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory");
importManager.addImport("org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory");
importManager.addImport("org.eclipse.gef.ContextMenuProvider");
importManager.addImport("org.eclipse.gef.EditPartViewer");
importManager.addImport("org.eclipse.gef.GraphicalViewer");
importManager.addImport("org.eclipse.gef.KeyHandler");
importManager.addImport("org.eclipse.gef.KeyStroke");
importManager.addImport("org.eclipse.gef.RootEditPart");
importManager.addImport("org.eclipse.gef.MouseWheelHandler");
importManager.addImport("org.eclipse.gef.MouseWheelZoomHandler");
importManager.addImport("org.eclipse.gef.commands.CommandStack");
importManager.addImport("org.eclipse.gef.commands.CommandStackListener");
importManager.addImport("org.eclipse.gef.editparts.ScalableFreeformRootEditPart");
importManager.addImport("org.eclipse.gef.editparts.ScalableRootEditPart");
importManager.addImport("org.eclipse.gef.editparts.ZoomManager");
importManager.addImport("org.eclipse.gef.palette.PaletteRoot");
importManager.addImport("org.eclipse.gef.ui.actions.AlignmentAction");
importManager.addImport("org.eclipse.gef.ui.actions.DeleteAction");
importManager.addImport("org.eclipse.gef.ui.actions.DirectEditAction");
importManager.addImport("org.eclipse.gef.ui.actions.GEFActionConstants");
importManager.addImport("org.eclipse.gef.ui.actions.PrintAction");
importManager.addImport("org.eclipse.gef.ui.actions.RedoAction");
importManager.addImport("org.eclipse.gef.ui.actions.SaveAction");
importManager.addImport("org.eclipse.gef.ui.actions.SelectionAction");
importManager.addImport("org.eclipse.gef.ui.actions.StackAction");
importManager.addImport("org.eclipse.gef.ui.actions.UndoAction");
importManager.addImport("org.eclipse.gef.ui.actions.UpdateAction");
importManager.addImport("org.eclipse.gef.ui.actions.WorkbenchPartAction");
importManager.addImport("org.eclipse.gef.ui.actions.ZoomInAction");
importManager.addImport("org.eclipse.gef.ui.actions.ZoomOutAction");
importManager.addImport("org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.notation.NotationFactory");
importManager.addImport("org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.jface.action.IMenuManager");
importManager.addImport("org.eclipse.jface.action.MenuManager");
importManager.addImport("org.eclipse.jface.action.Separator");
importManager.addImport("org.eclipse.jface.dialogs.ErrorDialog");
importManager.addImport("org.eclipse.jface.viewers.ISelection");
importManager.addImport("org.eclipse.swt.SWT");
importManager.addImport("org.eclipse.swt.widgets.Composite");
importManager.addImport("org.eclipse.ui.IEditorPart");
importManager.addImport("org.eclipse.ui.IEditorInput");
importManager.addImport("org.eclipse.ui.IEditorSite");
importManager.addImport("org.eclipse.ui.ISelectionListener");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.ui.PartInitException");
importManager.addImport("org.eclipse.ui.actions.ActionFactory");
importManager.addImport("org.eclipse.ui.views.contentoutline.IContentOutlinePage");
importManager.addImport("org.eclipse.ui.views.properties.IPropertySheetPage");
importManager.addImport("org.eclipse.ui.views.properties.PropertySheetPage");
importManager.addImport("org.eclipse.emf.common.notify.AdapterFactory");
importManager.addImport("org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette");
importManager.addImport("org.eclipse.gef.DefaultEditDomain");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_3);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceChangeListener"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceChangeEvent"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IResourceDelta"));
    stringBuffer.append(TEXT_13);
    /*XXX: make sure unsaved deleted file is handled correctly*/
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.widgets.Display"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.FileEditorInput"));
    stringBuffer.append(TEXT_18);
    
}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_22);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getEditorGen().getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    
{
	final Palette palette = genDiagram.getPalette();
	if (palette != null) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(palette.getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    
	}
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.properties.UndoablePropertySheetEntry"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.properties.UndoablePropertySheetEntry"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPropertyProviderQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_37);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    
if (!isRichClientPlatform) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_46);
    
}

    stringBuffer.append(TEXT_47);
    if (isRichClientPlatform) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IPathEditorInput"));
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IFileEditorInput"));
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    
final EList genPackages = genDiagram.getEditorGen().getAllDomainGenPackages(true);
for (int i = 0; i < genPackages.size(); i++) {
	GenPackage genPackage = (GenPackage) genPackages.get(i);

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_62);
    
{

    
	boolean sameFile = genDiagram.getEditorGen().isSameFileForDiagramAndModel();
	String resourceToUse;
	if (!sameFile) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(genDiagram.getDiagramEditorUtilClassName());
    stringBuffer.append(TEXT_64);
    
		resourceToUse = "modelResource";
	} else {
		resourceToUse = "diagramResource";
	}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(resourceToUse);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedFactoryClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(resourceToUse);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(resourceToUse);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getSafeUncapName());
    stringBuffer.append(TEXT_78);
    
}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LayeredPane"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.LayeredPane"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.LayerConstants"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayer"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.DelegatingLayout"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.LayerConstants"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_92);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_93);
    return stringBuffer.toString();
  }
}
