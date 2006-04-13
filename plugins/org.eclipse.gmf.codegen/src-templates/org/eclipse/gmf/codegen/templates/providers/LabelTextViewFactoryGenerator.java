package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LabelTextViewFactoryGenerator
{
  protected static String nl;
  public static synchronized LabelTextViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LabelTextViewFactoryGenerator result = new LabelTextViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends ";
  protected final String TEXT_8 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_9 = NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNodeLabel genLabel = (GenNodeLabel) ((Object[]) argument)[0];
GenDiagram genDiagram = genLabel.getDiagram();
ImportUtil importManager = new ImportUtil(genDiagram.getNotationViewFactoriesPackageName());

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getNotationViewFactoriesPackageName());
    stringBuffer.append(TEXT_5);
    
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(genLabel.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genLabel.getNode().isListLayout() ?
	importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory") :
	importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory"));
    stringBuffer.append(TEXT_8);
    GenCommonBase genElement = genLabel;
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
