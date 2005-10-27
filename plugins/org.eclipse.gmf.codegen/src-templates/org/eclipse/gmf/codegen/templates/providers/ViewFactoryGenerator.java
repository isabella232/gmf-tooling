package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.draw2d.ColorConstants;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;" + NL + "import org.eclipse.gmf.runtime.notation.NotationPackage;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = NL + "\tConnectorViewFactory";
  protected final String TEXT_7 = NL + "\tAbstractLabelViewFactory";
  protected final String TEXT_8 = NL + "\tAbstractShapeViewFactory";
  protected final String TEXT_9 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_10 = NL + "\t\tViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\tFigureUtilities.colorToInteger(ColorConstants.";
  protected final String TEXT_11 = "));";
  protected final String TEXT_12 = NL + "\t\tViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\tFigureUtilities.colorToInteger(ColorConstants.";
  protected final String TEXT_13 = "));";
  protected final String TEXT_14 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_15 = "," + NL + "\t\t\tViewUtil.APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_16 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_17 = "," + NL + "\t\t\tViewUtil.APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_18 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_19 = "," + NL + "\t\t\tViewUtil.APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_20 = NL + "\t\tview.setType(";
  protected final String TEXT_21 = ".VIEW_TYPE);";
  protected final String TEXT_22 = NL + "\t}" + NL + "}";
  protected final String TEXT_23 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenCommonBase genElement = (GenCommonBase) argument;
    GenDiagram genDiagram = genElement.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    if (genElement instanceof GenLink) {
    stringBuffer.append(TEXT_6);
    } else if (genElement instanceof GenChildNode) {
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_11);
    
}
if (genElement instanceof GenNode) {
	GenNode genNode = (GenNode) genElement;
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_13);
    
	}
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
	if (!(genNode instanceof GenChildNode)) {
		List labels = genNode.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			GenNodeLabel label = (GenNodeLabel) labels.get(j);
			String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_14);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_15);
    
		}
	}
	List genChildContainers = genNode.getCompartments();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);
		String compartmentId = semanticHintsClassName + ".Compartments." + AccessUtil.getCompartmentId(genChildContainer);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_17);
    
	}
} else if (genElement instanceof GenLink) {
	GenLink genLink = (GenLink) genElement;
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genLink);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
	List labels = genLink.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenLinkLabel label = (GenLinkLabel) labels.get(j);
		String labelViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelId(label);

    stringBuffer.append(TEXT_18);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_19);
    	}
	if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genLink));
    stringBuffer.append(TEXT_21);
    
	}
}

    stringBuffer.append(TEXT_22);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
