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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.emf.ecore.EcoreFactory;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = NL + "\tConnectionViewFactory";
  protected final String TEXT_7 = NL + "\tAbstractLabelViewFactory";
  protected final String TEXT_8 = NL + "    ListCompartmentViewFactory";
  protected final String TEXT_9 = "    " + NL + "\tDiagramViewFactory";
  protected final String TEXT_10 = NL + "\tAbstractShapeViewFactory";
  protected final String TEXT_11 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_12 = NL + "\tprotected void decorateView(View view, IAdaptable semanticAdapter, String diagramKind){" + NL + "\t\tsuper.decorateView(view, semanticAdapter, diagramKind);";
  protected final String TEXT_13 = NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = "EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();" + NL + "annotation.setSource(\"VisualID\");" + NL + "view.getEAnnotations().add(annotation);" + NL + "annotation.getDetails().put(\"value\", \"";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_19 = ".eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\t";
  protected final String TEXT_20 = ".colorToInteger(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = "));";
  protected final String TEXT_23 = NL + "\t\t";
  protected final String TEXT_24 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_25 = ".eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\t";
  protected final String TEXT_26 = ".colorToInteger(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = "));";
  protected final String TEXT_29 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_30 = "," + NL + "\t\t\t";
  protected final String TEXT_31 = ".APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_32 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_33 = "," + NL + "\t\t\t";
  protected final String TEXT_34 = ".APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_35 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_36 = "," + NL + "\t\t\t";
  protected final String TEXT_37 = ".APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_38 = NL + "\t\tview.setType(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t}" + NL + "}";
  protected final String TEXT_42 = NL;

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
    } else if (genElement instanceof GenCompartment) {
    stringBuffer.append(TEXT_8);
    } else if (genElement instanceof GenDiagram) {
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
if (genElement instanceof GenDiagram) {

    stringBuffer.append(TEXT_12);
    
} else {

    stringBuffer.append(TEXT_13);
    
}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_16);
    
ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_22);
    
}
if (genElement instanceof GenNode) {
	GenNode genNode = (GenNode) genElement;
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_28);
    
	}
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
	if (!(genNode instanceof GenChildNode)) {
		List labels = genNode.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			GenNodeLabel label = (GenNodeLabel) labels.get(j);
			String labelTextViewId = semanticHintsClassName + '.' + genNode.getUniqueIdentifier() + "Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_29);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_31);
    
		}
	}
	List genChildContainers = genNode.getCompartments();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);
		String compartmentId = semanticHintsClassName + '.' + genNode.getUniqueIdentifier() + "Compartments." + AccessUtil.getCompartmentId(genChildContainer);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_34);
    
	}
} else if (genElement instanceof GenLink) {
	GenLink genLink = (GenLink) genElement;
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
	List labels = genLink.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenLinkLabel label = (GenLinkLabel) labels.get(j);
		String labelViewId = semanticHintsClassName + '.' + genLink.getUniqueIdentifier() + "Labels." + AccessUtil.getLabelId(label);

    stringBuffer.append(TEXT_35);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_37);
    	}
	if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    
	}
}

    stringBuffer.append(TEXT_41);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
