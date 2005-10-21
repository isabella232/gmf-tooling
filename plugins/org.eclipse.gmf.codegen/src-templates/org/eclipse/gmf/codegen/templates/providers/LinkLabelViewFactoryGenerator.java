package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class LinkLabelViewFactoryGenerator
{
  protected static String nl;
  public static synchronized LinkLabelViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkLabelViewFactoryGenerator result = new LinkLabelViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends AbstractLabelViewFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);" + NL + "\t\tgetViewService().createNode(semanticAdapter, view," + NL + "\t\t\t";
  protected final String TEXT_4 = ".Labels.";
  protected final String TEXT_5 = "," + NL + "\t\t\tViewUtil.APPEND, persisted, getPreferencesHint());" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenLinkLabel label = (GenLinkLabel) argument;
    GenDiagram diagram = label.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(label.getLink()));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(AccessUtil.getLabelTextId(label));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
