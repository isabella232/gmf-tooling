package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ValidationDecoratorProviderGenerator
{
  protected static String nl;
  public static synchronized ValidationDecoratorProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ValidationDecoratorProviderGenerator result = new ValidationDecoratorProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "/** " + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractProvider implements IDecoratorProvider {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static final String KEY = \"validationStatus\"; //$NON-NLS-1$" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String MARKER_TYPE = ";
  protected final String TEXT_6 = ".ID + \".\" + \"";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$ //$NON-NLS-2$" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static MarkerObserver fileObserver = null;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic void createDecorators(IDecoratorTarget decoratorTarget) {" + NL + "\t\tEditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);" + NL + "\t\tif (editPart instanceof ";
  protected final String TEXT_8 = " ||" + NL + "\t\t\teditPart instanceof AbstractConnectionEditPart) {" + NL + "\t\t\tObject model = editPart.getModel();" + NL + "\t\t\tif((model instanceof View)) {" + NL + "\t\t\t\tView view = (View)model;" + NL + "\t\t\t\tif(!(view instanceof Edge) && !view.isSetElement()) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_9 = " ed = editPart.getViewer().getEditDomain();" + NL + "\t\t\tif(!(ed instanceof DiagramEditDomain)) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tif(((DiagramEditDomain)ed).getEditorPart() instanceof ";
  protected final String TEXT_10 = ") {" + NL + "\t\t\t\tdecoratorTarget.installDecorator(KEY, new StatusDecorator(decoratorTarget));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tpublic boolean provides(";
  protected final String TEXT_11 = " operation) {" + NL + "\t\tif (!(operation instanceof CreateDecoratorsOperation)) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\tIDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();" + NL + "\t\treturn decoratorTarget.getAdapter(View.class) != null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static class StatusDecorator extends AbstractDecorator {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate String viewId;" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic StatusDecorator(IDecoratorTarget decoratorTarget) {" + NL + "\t\t\tsuper(decoratorTarget);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tfinal View view = (View) getDecoratorTarget().getAdapter(View.class);" + NL + "\t\t\t\t";
  protected final String TEXT_12 = ".getEditingDomain(view).runExclusive(new Runnable() {" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\tStatusDecorator.this.viewId = view != null ? ";
  protected final String TEXT_13 = ".getIdStr(view) : null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_14 = ".getInstance().logError(\"ViewID access failure\", e); //$NON-NLS-1$\t\t\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\tremoveDecoration();" + NL + "" + NL + "\t\t\tView view = (View) getDecoratorTarget().getAdapter(View.class);" + NL + "\t\t\tEditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);" + NL + "\t\t\tif (view == null || view.eResource() == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tIResource resource = getResource(view);" + NL + "\t\t\t// make sure we have a resource and that it exists in an open project" + NL + "\t\t\tif (resource == null || !resource.exists()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t// query for all the validation markers of the current resource" + NL + "\t\t\tIMarker[] markers = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tmarkers = resource.findMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);" + NL + "\t\t\t} catch (";
  protected final String TEXT_15 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_16 = ".getInstance().logError(\"Validation marker refresh failure\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\tif (markers == null || markers.length == 0) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tString elementId = ";
  protected final String TEXT_17 = ".getIdStr(view);" + NL + "\t\t\tif (elementId == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tIMarker foundMarker = null;" + NL + "\t\t\tfor (int i = 0; i < markers.length; i++) {" + NL + "\t\t\t\tIMarker marker = markers[i];" + NL + "\t\t\t\tString attribute = marker.getAttribute(";
  protected final String TEXT_18 = ".ELEMENT_ID, \"\"); //$NON-NLS-1$" + NL + "\t\t\t\tif (attribute.equals(elementId)) {" + NL + "\t\t\t\t\tfoundMarker = marker;" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (foundMarker == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t// add decoration" + NL + "\t\t\tif (editPart instanceof GraphicalEditPart) {" + NL + "\t\t\t\tImage img = getImage(foundMarker);" + NL + "\t\t\t\tif (view instanceof Edge) {" + NL + "\t\t\t\t\tsetDecoration(getDecoratorTarget().addConnectionDecoration(img, 50, true));\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tint margin = -1;" + NL + "\t\t\t\t\tif(editPart instanceof GraphicalEditPart) {" + NL + "\t\t\t\t\t\tmargin = ";
  protected final String TEXT_19 = ".getMapMode(" + NL + "\t\t\t\t\t\t\t((GraphicalEditPart)editPart).getFigure()).DPtoLP(margin);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tsetDecoration(getDecoratorTarget().addShapeDecoration(img, IDecoratorTarget.Direction.NORTH_EAST , margin, true));\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgetDecoration().setToolTip(new Label(foundMarker.getAttribute(IMarker.MESSAGE, \"\"), img));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate Image getImage(IMarker marker) {" + NL + "\t\t\tString imageName = ";
  protected final String TEXT_20 = ".IMG_OBJS_ERROR_TSK;" + NL + "\t\t\tswitch (marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO)) {" + NL + "\t\t\tcase IMarker.SEVERITY_ERROR:" + NL + "\t\t\t\timageName = ";
  protected final String TEXT_21 = ".IMG_OBJS_ERROR_TSK;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tcase IMarker.SEVERITY_WARNING:" + NL + "\t\t\t\timageName = ";
  protected final String TEXT_22 = ".IMG_OBJS_WARN_TSK;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\tdefault:" + NL + "\t\t\t\timageName = ";
  protected final String TEXT_23 = ".IMG_OBJS_INFO_TSK;" + NL + "\t\t\t}" + NL + "\t\t\treturn ";
  protected final String TEXT_24 = ".getWorkbench().getSharedImages().getImage(imageName);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static IResource getResource(View view) {" + NL + "\t\t\t";
  protected final String TEXT_25 = " model = view.eResource();" + NL + "\t\t\tif (model != null) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_26 = ".getFile(model);" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void activate() {" + NL + "\t\t\tView view = (View) getDecoratorTarget().getAdapter(View.class);" + NL + "\t\t\tif (view == null)" + NL + "\t\t\t\treturn;" + NL + "\t\t\tDiagram diagramView = view.getDiagram();" + NL + "\t\t\tif (diagramView == null)" + NL + "\t\t\t\treturn;" + NL + "\t\t\tIFile file = ";
  protected final String TEXT_27 = ".getFile(diagramView.eResource());" + NL + "\t\t\tif (file != null) {" + NL + "\t\t\t\tif (fileObserver == null) {" + NL + "\t\t\t\t\tfileObserver = new MarkerObserver(diagramView);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tfileObserver.registerDecorator(this);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void deactivate() {" + NL + "\t\t\tif (fileObserver != null) {" + NL + "\t\t\t\tfileObserver.unregisterDecorator(this);" + NL + "\t\t\t\tif (!fileObserver.isRegistered()) {" + NL + "\t\t\t\t\tfileObserver = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tsuper.deactivate();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tString getViewId() {" + NL + "\t\t\treturn viewId;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic class MarkerObserver implements ";
  protected final String TEXT_28 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tstatic ";
  protected final String TEXT_29 = " toolTipHelper;\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate HashMap mapOfIdsToDecorators = null;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate boolean isRegistered = false;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate Diagram diagramView;" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tprivate MarkerObserver(Diagram diagramView) {" + NL + "\t\t\tthis.diagramView = diagramView;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tprivate void registerDecorator(StatusDecorator decorator) {" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tif (mapOfIdsToDecorators == null) {" + NL + "\t\t\t\tmapOfIdsToDecorators = new HashMap();" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tString decoratorViewId = decorator.getViewId();" + NL + "\t\t\tif (decoratorViewId == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/* Add to the list */" + NL + "\t\t\tList list = (List) mapOfIdsToDecorators.get(decoratorViewId);" + NL + "\t\t\tif (list == null) {" + NL + "\t\t\t\tlist = new ArrayList(2);" + NL + "\t\t\t\tlist.add(decorator);" + NL + "\t\t\t\tmapOfIdsToDecorators.put(decoratorViewId, list);" + NL + "\t\t\t} else if (!list.contains(decorator)) {" + NL + "\t\t\t\tlist.add(decorator);" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/* Register with the file change manager */" + NL + "\t\t\tif (!isRegistered()) {" + NL + "\t\t\t\t";
  protected final String TEXT_30 = ".getInstance().addFileObserver(this);" + NL + "\t\t\t\tisRegistered = true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tprivate void unregisterDecorator(StatusDecorator decorator) {" + NL + "\t\t\t/* Return if invalid decorator */" + NL + "\t\t\tif (decorator == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/* Return if the decorator has invalid view id */" + NL + "\t\t\tString decoratorViewId = decorator.getViewId();" + NL + "\t\t\tif (decoratorViewId == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tif (mapOfIdsToDecorators != null) {" + NL + "\t\t\t\tList list = (List) mapOfIdsToDecorators.get(decoratorViewId);" + NL + "\t\t\t\tif (list != null) {" + NL + "\t\t\t\t\tlist.remove(decorator);" + NL + "\t\t\t\t\tif (list.isEmpty()) {" + NL + "\t\t\t\t\t\tmapOfIdsToDecorators.remove(decoratorViewId);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\tif (mapOfIdsToDecorators.isEmpty()) {" + NL + "\t\t\t\t\tmapOfIdsToDecorators = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tif (mapOfIdsToDecorators == null) {" + NL + "\t\t\t\t/* Unregister with the file change manager */" + NL + "\t\t\t\tif (isRegistered()) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = ".getInstance().removeFileObserver(this);" + NL + "\t\t\t\t\tisRegistered = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleFileRenamed(IFile oldFile, IFile file) { /* Empty Code */ }" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleFileMoved(IFile oldFile, IFile file) { /* Empty Code */ }" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleFileDeleted(IFile file) { /* Empty Code */ }" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleFileChanged(IFile file) { /* Empty Code */ }" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleMarkerAdded(IMarker marker) { /* Empty Code */ }" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleMarkerDeleted(IMarker marker, Map attributes) {" + NL + "\t\t\tif (mapOfIdsToDecorators == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t// Extract the element guid from the marker and retrieve" + NL + "\t\t\t// corresponding view" + NL + "\t\t\tString elementId = (String) attributes.get(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID);" + NL + "\t\t\tList list = elementId != null ? (List) mapOfIdsToDecorators.get(elementId) : null;" + NL + "\t\t\tif (list != null && !list.isEmpty()) {" + NL + "\t\t\t\trefreshDecorators(list);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t" + NL + "\t\tpublic void handleMarkerChanged(IMarker marker) {" + NL + "\t\t\tif (mapOfIdsToDecorators == null || !MARKER_TYPE.equals(getType(marker))) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t// Extract the element ID list from the marker and retrieve" + NL + "\t\t\t// corresponding view\t" + NL + "\t\t\tString elementId = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, \"\"); //$NON-NLS-1$" + NL + "\t\t\tList list = elementId != null ? (List) mapOfIdsToDecorators.get(elementId) : null;" + NL + "\t" + NL + "\t\t\tif (list != null && !list.isEmpty()) {" + NL + "\t\t\t\trefreshDecorators(list);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate void refreshDecorators(List decorators) {" + NL + "\t\t\tfinal List decoratorsToRefresh = decorators;\t\t" + NL + "\t\t\t";
  protected final String TEXT_32 = ".getWorkbench().getDisplay().asyncExec(new Runnable() {" + NL + "\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = ".getEditingDomain(diagramView).runExclusive(new Runnable() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\tfor(Iterator it = decoratorsToRefresh.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\t\t\t\t\tIDecorator decorator = (IDecorator) it.next();" + NL + "\t\t\t\t\t\t\t\t\tif (decorator != null) {" + NL + "\t\t\t\t\t\t\t\t\t\tdecorator.refresh();" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = ".getInstance().logError(\"Decorator refresh failure\", e); //$NON-NLS-1$" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate boolean isRegistered() {" + NL + "\t\t\treturn isRegistered;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate String getType(IMarker marker) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn marker.getType();" + NL + "\t\t\t} catch (";
  protected final String TEXT_35 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_36 = ".getInstance().logError(\"Validation marker refresh failure\", e); //$NON-NLS-1$" + NL + "\t\t\t\treturn \"\"; //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);

importManager.markImportLocation(stringBuffer);
importManager.registerInnerClass("MarkerObserver");
importManager.registerInnerClass("StatusDecorator");
importManager.registerInnerClass("StatusFigure");

importManager.addImport("java.util.ArrayList");
importManager.addImport("java.util.HashMap");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.List");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.resources.IMarker");
importManager.addImport("org.eclipse.core.resources.IResource");
importManager.addImport("org.eclipse.draw2d.Label");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.GraphicalEditPart");
importManager.addImport("org.eclipse.gef.editparts.AbstractConnectionEditPart");
importManager.addImport("org.eclipse.gmf.runtime.common.core.service.AbstractProvider");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.notation.Edge");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.swt.graphics.Image");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getValidationDecoratorProviderClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditDomain"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.service.IOperation"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.resources.IMarker"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ISharedImages"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ISharedImages"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ISharedImages"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ISharedImages"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.resources.IFileObserver"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ToolTipHelper"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.resources.FileChangeManager"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.CoreException"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_36);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
