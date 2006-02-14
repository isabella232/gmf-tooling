package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.emf.ecore.EcoreFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = "    " + NL + "\t";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_12 = NL + "\tprotected void decorateView(View view, IAdaptable semanticAdapter, String diagramKind){" + NL + "\t\tsuper.decorateView(view, semanticAdapter, diagramKind);";
  protected final String TEXT_13 = NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = "EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();" + NL + "annotation.setSource(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "view.getEAnnotations().add(annotation);" + NL + "annotation.getDetails().put(\"modelID\", \"";
  protected final String TEXT_16 = "\"); //$NON-NLS-1$" + NL + "annotation.getDetails().put(\"visualID\", \"";
  protected final String TEXT_17 = "\"); //$NON-NLS-1$";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_20 = ".eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\t";
  protected final String TEXT_21 = ".colorToInteger(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = "));";
  protected final String TEXT_24 = NL + "\t\t";
  protected final String TEXT_25 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_26 = ".eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\t";
  protected final String TEXT_27 = ".colorToInteger(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "));";
  protected final String TEXT_30 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_31 = "," + NL + "\t\t\t";
  protected final String TEXT_32 = ".APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_33 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_34 = "," + NL + "\t\t\t";
  protected final String TEXT_35 = ".APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_36 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_37 = "," + NL + "\t\t\t";
  protected final String TEXT_38 = ".APPEND, persisted, getPreferencesHint());";
  protected final String TEXT_39 = NL + "\t\tview.setType(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t}";
  protected final String TEXT_43 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_44 = " createStyles(View view) {" + NL + "\t\t";
  protected final String TEXT_45 = " styles = super.createStyles(view);" + NL + "\t\tstyles.add(";
  protected final String TEXT_46 = ".eINSTANCE.createShapeStyle());" + NL + "\t\treturn styles;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_47 = " createLayoutConstraint() {" + NL + "\t\treturn ";
  protected final String TEXT_48 = ".eINSTANCE.createBounds();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeFromPreferences(View view) {" + NL + "\t\tsuper.initializeFromPreferences(view);" + NL + "" + NL + "\t\t";
  protected final String TEXT_49 = " store = (";
  protected final String TEXT_50 = ") getPreferencesHint().getPreferenceStore();" + NL + "" + NL + "\t\t// fill color" + NL + "\t\t";
  protected final String TEXT_51 = " fillRGB = ";
  protected final String TEXT_52 = ".getColor(store, ";
  protected final String TEXT_53 = ".PREF_FILL_COLOR);" + NL + "\t\t";
  protected final String TEXT_54 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_55 = ".eINSTANCE.getFillStyle_FillColor(), ";
  protected final String TEXT_56 = ".RGBToInteger(fillRGB));" + NL + "\t}";
  protected final String TEXT_57 = NL + "}";
  protected final String TEXT_58 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
    GenDiagram genDiagram = genElement.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getNotationViewFactoriesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getNotationViewFactoriesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    
boolean isLink = genElement instanceof GenLink;
boolean isDiagram = genElement instanceof GenDiagram;
boolean isCompartment = genElement instanceof GenCompartment;
boolean isNode = !isLink && !isDiagram && !isCompartment;
boolean isLeaf = genElement instanceof GenNode &&  ((GenNode) genElement).isListContainerEntry();

boolean isFlowLayout = isCompartment && !((GenCompartment) genElement).getNode().isListLayout();

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    if (isLink) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory"));
    } else if (isLeaf) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory"));
    } else if (isCompartment) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory"));
    } else if (isDiagram) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory"));
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory"));
    }
    stringBuffer.append(TEXT_11);
    
if (isDiagram) {

    stringBuffer.append(TEXT_12);
    
} else {

    stringBuffer.append(TEXT_13);
    
}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_17);
    
ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_23);
    
}
if (isNode) {
	GenNode genNode = (GenNode) genElement;
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_29);
    
	}	
	if (!isLeaf) {
		List labels = genNode.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
			GenNodeLabel label = (GenNodeLabel) labels.get(j);
			String labelViewId;
			if (label instanceof ExternalLabel) {
				labelViewId = semanticHintsClassName + '.' + genNode.getUniqueIdentifier() + "Labels." + ((ExternalLabel) label).getSemanticHintLabelFieldName();
			} else {
				labelViewId = semanticHintsClassName + '.' + genNode.getUniqueIdentifier() + "Labels." + label.getSemanticHintFieldName();
			}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_32);
    
		}
	}
	List genChildContainers = genNode.getCompartments();
	for (int j = 0; j < genChildContainers.size(); j++) {
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);
		String compartmentId = semanticHintsClassName + '.' + genNode.getUniqueIdentifier() + "Compartments." + genChildContainer.getSemanticHintFieldName();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_35);
    
	}
} else if (isLink) {
	GenLink genLink = (GenLink) genElement;
	List labels = genLink.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
		GenLinkLabel label = (GenLinkLabel) labels.get(j);
		String labelViewId = semanticHintsClassName + '.' + genLink.getUniqueIdentifier() + "Labels." + label.getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_36);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_38);
    	}
	if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_41);
    
	}
}

    stringBuffer.append(TEXT_42);
    	
if (isFlowLayout) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LayoutConstraint"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.RGB"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.PreferenceConverter"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_56);
    
}

    stringBuffer.append(TEXT_57);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_58);
    return stringBuffer.toString();
  }
}
