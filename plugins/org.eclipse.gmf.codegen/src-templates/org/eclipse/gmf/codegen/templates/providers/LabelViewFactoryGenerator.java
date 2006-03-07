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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.emf.ecore.EcoreFactory;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends AbstractLabelViewFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();" + NL + "annotation.setSource(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "view.getEAnnotations().add(annotation);" + NL + "annotation.getDetails().put(\"modelID\", \"";
  protected final String TEXT_11 = "\"); //$NON-NLS-1$" + NL + "annotation.getDetails().put(\"visualID\", \"";
  protected final String TEXT_12 = "\"); //$NON-NLS-1$";
  protected final String TEXT_13 = NL + "\t\tgetViewService().createNode(semanticAdapter, view," + NL + "\t\t\t";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "Labels.";
  protected final String TEXT_16 = "," + NL + "\t\t\tViewUtil.APPEND, persisted, getPreferencesHint());" + NL + "\t}" + NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenLabel label = (GenLabel) ((Object[]) argument)[0];
    GenDiagram genDiagram = label.getDiagram();
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
    ImportUtil importManager = new ImportUtil(genDiagram.getNotationViewFactoriesPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_8);
    GenCommonBase genElement = label;
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_12);
    String id = label instanceof GenLinkLabel ? ((GenLinkLabel) label).getLink().getUniqueIdentifier() : ((GenNodeLabel) label).getNode().getUniqueIdentifier();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_16);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
