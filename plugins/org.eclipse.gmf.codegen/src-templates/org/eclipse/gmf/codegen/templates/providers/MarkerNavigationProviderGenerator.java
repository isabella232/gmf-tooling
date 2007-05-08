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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */\t" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractModelMarkerNavigationProvider {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String MARKER_TYPE = ";
  protected final String TEXT_7 = ".ID + \".";
  protected final String TEXT_8 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tprotected void doGotoMarker(IMarker marker) {" + NL + "\t\tString elementId = marker.getAttribute(org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID, null);" + NL + "\t\tif(elementId == null || !(getEditor() instanceof DiagramEditor)) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tDiagramEditor editor = (DiagramEditor) getEditor();" + NL + "\t\tMap editPartRegistry = editor.getDiagramGraphicalViewer().getEditPartRegistry();" + NL + "\t\tEObject targetView = editor.getDiagram().eResource().getEObject(elementId);" + NL + "\t\tif(targetView == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tEditPart targetEditPart = (EditPart)editPartRegistry.get(targetView);" + NL + "\t\tif (targetEditPart != null) {" + NL + "\t\t\t";
  protected final String TEXT_9 = ".selectElementsInDiagram(editor, Arrays.asList(new EditPart[] { targetEditPart }));" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void deleteMarkers(IResource resource) {" + NL + "\t\ttry {" + NL + "\t\t\tresource.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\t";
  protected final String TEXT_10 = ".getInstance().logError(\"Failed to delete validation markers\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IMarker addMarker(IFile file, String elementId, String location, String message, int statusSeverity) {" + NL + "\t\tIMarker marker = null;" + NL + "\t\ttry {" + NL + "\t\t\tmarker = file.createMarker(MARKER_TYPE);" + NL + "\t\t\tmarker.setAttribute(IMarker.MESSAGE, message);" + NL + "\t\t\tmarker.setAttribute(IMarker.LOCATION, location);" + NL + "\t\t\tmarker.setAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, elementId);" + NL + "\t\t\tint markerSeverity = IMarker.SEVERITY_INFO;" + NL + "\t\t\tif(statusSeverity == IStatus.WARNING) {" + NL + "\t\t\t\tmarkerSeverity = IMarker.SEVERITY_WARNING;    \t\t\t\t\t\t" + NL + "\t\t\t} else if(statusSeverity == IStatus.ERROR || statusSeverity == IStatus.CANCEL) {" + NL + "\t\t\t\tmarkerSeverity = IMarker.SEVERITY_ERROR;" + NL + "\t\t\t}" + NL + "\t\t\tmarker.setAttribute(IMarker.SEVERITY, markerSeverity);" + NL + "\t\t} catch (CoreException e) {" + NL + "\t\t\t";
  protected final String TEXT_11 = ".getInstance().logError(\"Failed to create validation marker\", e); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn marker;\t\t" + NL + "\t}\t" + NL + "}";
  protected final String TEXT_12 = NL;

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
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
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
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
