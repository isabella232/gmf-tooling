package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class MarkerNavigationProviderGenerator
{
  protected static String nl;
  public static synchronized MarkerNavigationProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MarkerNavigationProviderGenerator result = new MarkerNavigationProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */\t" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractModelMarkerNavigationProvider {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String MARKER_TYPE = ";
  protected final String TEXT_7 = ".ID + \".";
  protected final String TEXT_8 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tprotected void doGotoMarker(IMarker marker) {" + NL + "\t\tString elementId = marker.getAttribute(org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID, null);" + NL + "\t\tif(elementId == null || !(getEditor() instanceof DiagramEditor)) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tDiagramEditor editor = (DiagramEditor) getEditor();" + NL + "\t\tMap editPartRegistry = editor.getDiagramGraphicalViewer().getEditPartRegistry();" + NL + "\t\tEObject targetView = editor.getDiagram().eResource().getEObject(elementId);" + NL + "\t\tif(targetView == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tEditPart targetEditPart = (EditPart)editPartRegistry.get(targetView);" + NL + "\t\tif (targetEditPart != null) {" + NL + "\t\t\t";
  protected final String TEXT_9 = ".selectElementsInDiagram(editor, Arrays.asList(new EditPart[] { targetEditPart }));" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void createMarkers(IFile diagramFile, IStatus validationStatus, DiagramEditPart diagramEditPart) {" + NL + "\t\tif(validationStatus.isOK()) return;" + NL + "\t\t" + NL + "\t\tfinal IStatus rootStatus = validationStatus;" + NL + "\t\tList allStatuses = new ArrayList();" + NL + "\t\t";
  protected final String TEXT_10 = ".LazyElement2ViewMap element2ViewMap = new ";
  protected final String TEXT_11 = ".LazyElement2ViewMap(" + NL + "\t\t\tdiagramEditPart.getDiagramView(), collectTargetElements(rootStatus, new HashSet(), allStatuses));" + NL + "\t\t" + NL + "\t\tfor (Iterator it = allStatuses.iterator(); it.hasNext();) {" + NL + "\t\t\tIConstraintStatus nextStatus = (IConstraintStatus)it.next();" + NL + "\t\t\tView view = ";
  protected final String TEXT_12 = ".findView(diagramEditPart, nextStatus.getTarget(), element2ViewMap);\t\t\t" + NL + "\t\t\tIMarker newMarker = addMarker(diagramFile, view.eResource().getURIFragment(view), " + NL + "\t\t\t\t\tEMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), " + NL + "\t\t\t\t\tnextStatus.getMessage(), nextStatus.getSeverity());" + NL + "\t\t\tif (newMarker != null) {" + NL + "\t\t\t\tadjustMarker(newMarker, nextStatus);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void createMarkers(IFile diagramFile, Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {" + NL + "\t\tif(emfValidationStatus.getSeverity() == Diagnostic.OK) return;" + NL + "\t\t" + NL + "\t\tfinal Diagnostic rootStatus = emfValidationStatus;" + NL + "\t\tList allDiagnostics = new ArrayList();" + NL + "\t\t";
  protected final String TEXT_13 = ".LazyElement2ViewMap element2ViewMap = new ";
  protected final String TEXT_14 = ".LazyElement2ViewMap(diagramEditPart.getDiagramView(), collectTargetElements(rootStatus, new HashSet(), allDiagnostics));" + NL + "\t\t" + NL + "\t\tfor (Iterator it = emfValidationStatus.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\tDiagnostic nextDiagnostic = (Diagnostic) it.next();" + NL + "\t\t\tList data = nextDiagnostic.getData();" + NL + "\t\t\tif (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {" + NL + "\t\t\t\tEObject element = (EObject) data.get(0);" + NL + "\t\t\t\tView view = ";
  protected final String TEXT_15 = ".findView(diagramEditPart, element, element2ViewMap);" + NL + "\t\t\t\tIMarker newMarker = addMarker(diagramFile, view.eResource().getURIFragment(view)," + NL + "\t\t\t\t\t\tEMFCoreUtil.getQualifiedName(element, true), nextDiagnostic.getMessage()," + NL + "\t\t\t\t\t\tdiagnosticToStatusSeverity(nextDiagnostic.getSeverity()));" + NL + "\t\t\t\tif (newMarker != null) {" + NL + "\t\t\t\t\tadjustMarker(newMarker, emfValidationStatus);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void deleteMarkers(IResource resource) {" + NL + "\t\ttry {" + NL + "\t\t\tresource.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\t";
  protected final String TEXT_16 = ".getInstance().logError(\"Failed to delete validation markers\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void adjustMarker(IMarker marker, Diagnostic sourceDiagnostic) {" + NL + "\t\tassert marker != null && sourceDiagnostic != null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void adjustMarker(IMarker marker, IConstraintStatus sourceStatus) {" + NL + "\t\tassert marker != null && sourceStatus != null;\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static IMarker addMarker(IFile file, String elementId, String location, String message, int statusSeverity) {" + NL + "\t\tIMarker marker = null;" + NL + "\t\ttry {" + NL + "\t\t\tmarker = file.createMarker(MARKER_TYPE);" + NL + "\t\t\tmarker.setAttribute(IMarker.MESSAGE, message);" + NL + "\t\t\tmarker.setAttribute(IMarker.LOCATION, location);" + NL + "\t\t\tmarker.setAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, elementId);" + NL + "\t\t\tint markerSeverity = IMarker.SEVERITY_INFO;" + NL + "\t\t\tif(statusSeverity == IStatus.WARNING) {" + NL + "\t\t\t\tmarkerSeverity = IMarker.SEVERITY_WARNING;    \t\t\t\t\t\t" + NL + "\t\t\t} else if(statusSeverity == IStatus.ERROR || statusSeverity == IStatus.CANCEL) {" + NL + "\t\t\t\tmarkerSeverity = IMarker.SEVERITY_ERROR;" + NL + "\t\t\t}" + NL + "\t\t\tmarker.setAttribute(IMarker.SEVERITY, markerSeverity);" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\t";
  protected final String TEXT_17 = ".getInstance().logError(\"Failed to create validation marker\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn marker;\t\t" + NL + "\t}\t" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int diagnosticToStatusSeverity(int diagnosticSeverity) {" + NL + "\t\tif (diagnosticSeverity == Diagnostic.OK) {" + NL + "\t\t\treturn IStatus.OK;" + NL + "\t\t} else if (diagnosticSeverity == Diagnostic.INFO) {" + NL + "\t\t\treturn IStatus.INFO;" + NL + "\t\t} else if (diagnosticSeverity == Diagnostic.WARNING) {" + NL + "\t\t\treturn IStatus.WARNING;" + NL + "\t\t} else if (diagnosticSeverity == Diagnostic.ERROR" + NL + "\t\t\t\t|| diagnosticSeverity == Diagnostic.CANCEL) {" + NL + "\t\t\treturn IStatus.ERROR;" + NL + "\t\t}" + NL + "\t\treturn IStatus.INFO;" + NL + "\t}\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static Set collectTargetElements(IStatus status, Set targetElementCollector, List allConstraintStatuses) {" + NL + "\t\tif(status instanceof IConstraintStatus) {" + NL + "\t\t\ttargetElementCollector.add(((IConstraintStatus)status).getTarget());" + NL + "\t\t\tallConstraintStatuses.add(status);" + NL + "\t\t}" + NL + "\t\tif(status.isMultiStatus()) {" + NL + "\t\t\tIStatus[] children = status.getChildren();" + NL + "\t\t\tfor (int i = 0; i < children.length; i++) {" + NL + "\t\t\t\tcollectTargetElements(children[i], targetElementCollector, allConstraintStatuses);\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn targetElementCollector;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static Set collectTargetElements(Diagnostic diagnostic, Set targetElementCollector, List allDiagnostics) {" + NL + "\t\tList data = diagnostic.getData();" + NL + "\t\tEObject target = null;" + NL + "\t\tif (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {" + NL + "\t\t\ttarget = (EObject)data.get(0);" + NL + "\t\t\ttargetElementCollector.add(target);\t" + NL + "\t\t\tallDiagnostics.add(diagnostic);" + NL + "\t\t}" + NL + "\t\tif(diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {" + NL + "\t\t\tfor (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t\tcollectTargetElements((Diagnostic)it.next(), targetElementCollector, allDiagnostics);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn targetElementCollector;" + NL + "\t}" + NL + "}";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram)((Object[]) argument)[0];
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
    stringBuffer.append(TEXT_4);
    
importManager.markImportLocation(stringBuffer);

importManager.addImport("java.util.ArrayList");
importManager.addImport("java.util.Arrays");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.List");
importManager.addImport("java.util.Map");
importManager.addImport("java.util.HashSet");
importManager.addImport("java.util.Set");
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.resources.IMarker");
importManager.addImport("org.eclipse.core.resources.IResource");
importManager.addImport("org.eclipse.core.runtime.CoreException");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.common.util.Diagnostic");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.validation.model.IConstraintStatus");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil");
importManager.addImport("org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getMarkerNavigationProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_17);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
