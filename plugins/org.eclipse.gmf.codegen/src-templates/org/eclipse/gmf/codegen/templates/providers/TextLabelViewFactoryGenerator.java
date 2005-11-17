package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;

public class TextLabelViewFactoryGenerator
{
  protected static String nl;
  public static synchronized TextLabelViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TextLabelViewFactoryGenerator result = new TextLabelViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.emf.ecore.EcoreFactory;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends BasicNodeViewFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();" + NL + "annotation.setSource(\"VisualID\");" + NL + "view.getEAnnotations().add(annotation);" + NL + "annotation.getDetails().put(\"value\", \"";
  protected final String TEXT_6 = "\");" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenLabel label = (GenLabel) argument;
    GenDiagram diagram = label.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getNotationViewFactoriesPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label instanceof GenLinkLabel ? ((GenLinkLabel) label).getTextNotationViewFactoryClassName() : label.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_3);
    GenCommonBase genElement = label;
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
