package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LabelViewFactoryGenerator
{
  protected static String nl;
  public static synchronized LabelViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LabelViewFactoryGenerator result = new LabelViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;" + NL + "import org.eclipse.gmf.runtime.notation.Node;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractLabelViewFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {" + NL + "\t\tNode view = (Node) super.createView(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = " location = (";
  protected final String TEXT_8 = ") view.getLayoutConstraint();" + NL + "\t\t";
  protected final String TEXT_9 = " mapMode = ";
  protected final String TEXT_10 = ".getMapMode(containerView.getDiagram().getMeasurementUnit());" + NL + "\t\tlocation.setX(mapMode.DPtoLP(";
  protected final String TEXT_11 = "));" + NL + "\t\tlocation.setY(mapMode.DPtoLP(";
  protected final String TEXT_12 = "));";
  protected final String TEXT_13 = NL + "\t\treturn view;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List createStyles(View view) {" + NL + "\t\tList styles = new ArrayList();";
  protected final String TEXT_14 = NL + "\t\tstyles.add(";
  protected final String TEXT_15 = ".eINSTANCE.createDescriptionStyle());";
  protected final String TEXT_16 = NL + "\t\treturn styles;" + NL + "\t}" + NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenLabel genLabel = (GenLabel) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genLabel.getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLabel.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    
int x = 0;
int y = 0;
LabelOffsetAttributes labelOffset = (LabelOffsetAttributes) genLabel.getViewmap().find(LabelOffsetAttributes.class);
if (labelOffset != null) {
	x = labelOffset.getX();
	y = labelOffset.getY();
} else if (genLabel instanceof GenExternalNodeLabel) {
	y = 5;
}
if ((x != 0 || y != 0) && (genLabel instanceof GenLinkLabel || genLabel instanceof GenExternalNodeLabel)) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Location"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Location"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.util.MeasurementUnitHelper"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(x);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(y);
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if (genLabel.getModelFacet() instanceof DesignLabelModelFacet) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
