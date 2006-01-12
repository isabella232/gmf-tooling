package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.DelegatingLayout;" + NL + "import org.eclipse.draw2d.FreeformLayer;" + NL + "import org.eclipse.draw2d.LayeredPane;" + NL + "import org.eclipse.gef.LayerConstants;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditorWithFlyoutPalette;" + NL + "import org.eclipse.ui.IEditorInput;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends FileDiagramEditorWithFlyoutPalette {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {" + NL + "\t\texistingPaletteRoot = super.createPaletteRoot(existingPaletteRoot);" + NL + "\t\t";
  protected final String TEXT_6 = ".fillPalette(existingPaletteRoot, getDiagram());" + NL + "\t\treturn existingPaletteRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(IEditorInput input) {" + NL + "\t\tsetDocumentProvider(new ";
  protected final String TEXT_7 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "\t\tDiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer().getRootEditPart();" + NL + "\t\tLayeredPane printableLayers = (LayeredPane) root.getLayer(LayerConstants.PRINTABLE_LAYERS);" + NL + "\t\tFreeformLayer extLabelsLayer = new FreeformLayer();" + NL + "\t\textLabelsLayer.setLayoutManager(new DelegatingLayout());" + NL + "\t\tprintableLayers.addLayerAfter(extLabelsLayer, ";
  protected final String TEXT_8 = ".EXTERNAL_NODE_LABELS_LAYER, LayerConstants.PRIMARY_LAYER);" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditorClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
