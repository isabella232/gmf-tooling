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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractLabelViewFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);" + NL + "\t}" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List createStyles(View view) {" + NL + "\t\t";
  protected final String TEXT_7 = " styles = new ";
  protected final String TEXT_8 = "();";
  protected final String TEXT_9 = NL + "\t\tstyles.add(";
  protected final String TEXT_10 = ".eINSTANCE.createDescriptionStyle());";
  protected final String TEXT_11 = NL + "\t\treturn styles;" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenLabel genLabel = (GenLabel) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genLabel.getDiagram();

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
    stringBuffer.append(genLabel.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_8);
    if (genLabel.getModelFacet() instanceof DesignLabelModelFacet) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
