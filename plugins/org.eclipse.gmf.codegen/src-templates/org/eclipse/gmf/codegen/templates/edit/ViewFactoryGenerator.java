package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ViewFactoryGenerator
{
  protected static String nl;
  public static synchronized ViewFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ViewFactoryGenerator result = new ViewFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = "ConnectorViewFactory";
  protected final String TEXT_7 = "AbstractShapeViewFactory";
  protected final String TEXT_8 = " {";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);" + NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "," + NL + "\t\t\tViewUtil.APPEND, persisted, getPreferencesHint());" + NL + "\t}";
  protected final String TEXT_12 = NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenBaseElement genElement = (GenBaseElement) argument;
    GenDiagram genDiagram = genElement.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    if (genElement instanceof GenLink) {
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    if (genElement.hasNameToEdit()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genElement));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genElement));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
