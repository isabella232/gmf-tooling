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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */\t" + NL + "public class ";
  protected final String TEXT_4 = " extends AbstractModelMarkerNavigationProvider {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tprotected void doGotoMarker(IMarker marker) {" + NL + "\t\tString elementId = marker.getAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, null);" + NL + "\t\tif(elementId == null || !(getEditor() instanceof DiagramEditor)) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tEditPart targetEditPart = null;" + NL + "\t\tDiagramEditor editor = (DiagramEditor)getEditor();" + NL + "\t\tMap epartRegistry = editor.getDiagramGraphicalViewer().getEditPartRegistry();" + NL + "\t\tfor (Iterator it = epartRegistry.entrySet().iterator(); it.hasNext();) {" + NL + "\t\t\tMap.Entry entry = (Map.Entry) it.next();" + NL + "\t\t\tif(entry.getKey() instanceof View) {" + NL + "\t\t\t\tView view = (View)entry.getKey();" + NL + "\t\t\t\tString viewId = ViewUtil.getIdStr(view);" + NL + "\t\t\t\tif(viewId.equals(elementId)) {" + NL + "\t\t\t\t\ttargetEditPart = (EditPart)entry.getValue();" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t} " + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(targetEditPart != null) {" + NL + "\t\t\teditor.getDiagramGraphicalViewer().select(targetEditPart);\t\t\t" + NL + "\t\t\teditor.getDiagramGraphicalViewer().reveal(targetEditPart);" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram)((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    
importManager.markImportLocation(stringBuffer);
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.resources.IMarker");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor");
importManager.addImport("org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getMarkerNavigationProviderClassName());
    stringBuffer.append(TEXT_4);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
