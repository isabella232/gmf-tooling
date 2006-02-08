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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = NL + "\textends ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();" + NL + "annotation.setSource(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "view.getEAnnotations().add(annotation);" + NL + "annotation.getDetails().put(\"modelID\", \"";
  protected final String TEXT_8 = "\"); //$NON-NLS-1$" + NL + "annotation.getDetails().put(\"visualID\", \"";
  protected final String TEXT_9 = "\"); //$NON-NLS-1$" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenLabel label = (GenLabel) argument;
GenDiagram genDiagram = label.getDiagram();
ImportUtil importManager = new ImportUtil(genDiagram.getNotationViewFactoriesPackageName());

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getNotationViewFactoriesPackageName());
    stringBuffer.append(TEXT_2);
    
importManager.markImportLocation(stringBuffer);
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.emf.ecore.EAnnotation");
importManager.addImport("org.eclipse.emf.ecore.EcoreFactory");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
boolean isFlowLayout = label instanceof GenNodeLabel && !((GenNodeLabel) label).getNode().isListLayout();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(label instanceof ExternalLabel ? ((ExternalLabel) label).getTextNotationViewFactoryClassName() : label.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(isFlowLayout ? importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory") : importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory"));
    stringBuffer.append(TEXT_5);
    GenCommonBase genElement = label;
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditorGen().getDomainGenModel().getModelName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
