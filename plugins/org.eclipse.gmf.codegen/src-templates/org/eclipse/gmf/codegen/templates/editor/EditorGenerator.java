package org.eclipse.gmf.codegen.templates.editor;

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
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.draw2d.DelegatingLayout;" + NL + "import org.eclipse.draw2d.FreeformLayer;" + NL + "import org.eclipse.draw2d.LayeredPane;" + NL + "import org.eclipse.gef.LayerConstants;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditor;" + NL + "import org.eclipse.ui.IEditorInput;" + NL + "import org.eclipse.ui.ide.IGotoMarker;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends FileDiagramEditor implements IGotoMarker {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ID = \"";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "() {" + NL + "\t\tsuper(";
  protected final String TEXT_9 = ");" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getEditingDomainID() {" + NL + "\t\treturn \"";
  protected final String TEXT_10 = "EditingDomain\"; //$NON-NLS-1$" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected TransactionalEditingDomain createEditingDomain() {" + NL + "\t\tTransactionalEditingDomain domain = super.createEditingDomain();" + NL + "\t\tdomain.setID(getEditingDomainID());" + NL + "\t\treturn domain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setDocumentProvider(IEditorInput input) {" + NL + "\t\tsetDocumentProvider(new ";
  protected final String TEXT_11 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void configureGraphicalViewer() {" + NL + "\t\tsuper.configureGraphicalViewer();" + NL + "\t\tDiagramRootEditPart root = (DiagramRootEditPart) getDiagramGraphicalViewer().getRootEditPart();" + NL + "\t\tLayeredPane printableLayers = (LayeredPane) root.getLayer(LayerConstants.PRINTABLE_LAYERS);" + NL + "\t\tFreeformLayer extLabelsLayer = new FreeformLayer();" + NL + "\t\textLabelsLayer.setLayoutManager(new DelegatingLayout());" + NL + "\t\tprintableLayers.addLayerAfter(extLabelsLayer, ";
  protected final String TEXT_12 = ".EXTERNAL_NODE_LABELS_LAYER, LayerConstants.PRIMARY_LAYER);" + NL + "\t\tLayeredPane scalableLayers = (LayeredPane) root.getLayer(LayerConstants.SCALABLE_LAYERS);" + NL + "\t\tFreeformLayer scaledFeedbackLayer = new FreeformLayer();" + NL + "\t\tscaledFeedbackLayer.setEnabled(false);" + NL + "\t\tscalableLayers.addLayerAfter(scaledFeedbackLayer, LayerConstants.SCALED_FEEDBACK_LAYER, DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER);" + NL + "\t}" + NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenEditorView genEditor = (GenEditorView) ((Object[]) argument)[0];
final GenDiagram genDiagram = genEditor.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

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
    stringBuffer.append(genEditor.getID());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genEditor.getClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getPalette() != null && genDiagram.getPalette().isFlyout());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genEditor.getEditorGen().getModelID());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
