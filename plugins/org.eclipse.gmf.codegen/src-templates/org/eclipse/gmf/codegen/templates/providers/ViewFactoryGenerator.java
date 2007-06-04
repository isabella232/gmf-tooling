package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.codegen.gmfgen.util.*;

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

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprotected List createStyles(View view) {" + NL + "\t\t";
  protected final String TEXT_9 = " styles = new ";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL + "\t\tstyles.add(";
  protected final String TEXT_12 = ".eINSTANCE.createShapeStyle());";
  protected final String TEXT_13 = NL + "\t\tstyles.add(";
  protected final String TEXT_14 = ".eINSTANCE.createDescriptionStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_15 = ".eINSTANCE.createFillStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_16 = ".eINSTANCE.createLineStyle());";
  protected final String TEXT_17 = NL + "\t\treturn styles;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tif (semanticHint == null) { ";
  protected final String TEXT_18 = NL + "\t\t\tsemanticHint = ";
  protected final String TEXT_19 = ".getType(";
  protected final String TEXT_20 = ".VISUAL_ID);" + NL + "\t\t\tview.setType(semanticHint);" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);" + NL + "\t\tif (!";
  protected final String TEXT_22 = ".MODEL_ID.equals(";
  protected final String TEXT_23 = ".getModelID(containerView))) {";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = "\t\t\t";
  protected final String TEXT_26 = " shortcutAnnotation = ";
  protected final String TEXT_27 = ".eINSTANCE.createEAnnotation();" + NL + "\t\t\tshortcutAnnotation.setSource(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tshortcutAnnotation.getDetails().put(\"modelID\", ";
  protected final String TEXT_28 = ".MODEL_ID); //$NON-NLS-1$" + NL + "\t\t\tview.getEAnnotations().add(shortcutAnnotation);" + NL + "\t\t}";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_31 = ".eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\t";
  protected final String TEXT_32 = ".colorToInteger(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = "));";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = " diagramFacet = ";
  protected final String TEXT_37 = ".eINSTANCE.createHintedDiagramLinkStyle();";
  protected final String TEXT_38 = NL + "\t\tdiagramFacet.setHint(\"";
  protected final String TEXT_39 = "\"); // $NON-NLS-1$";
  protected final String TEXT_40 = NL + "\t\tview.getStyles().add(diagramFacet);";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_43 = ".eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\t";
  protected final String TEXT_44 = ".colorToInteger(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "\torg.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) semanticAdapter.getAdapter(org.eclipse.emf.ecore.EObject.class);" + NL + "\tIAdaptable eObjectAdapter = eObject != null ? new ";
  protected final String TEXT_48 = "(eObject) : null;";
  protected final String TEXT_49 = NL + "\tIAdaptable eObjectAdapter = null;";
  protected final String TEXT_50 = NL + "\t\tgetViewService().createNode(eObjectAdapter, view, ";
  protected final String TEXT_51 = ".getType(";
  protected final String TEXT_52 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_53 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_54 = NL + "\t\tgetViewService().createNode(eObjectAdapter, view, ";
  protected final String TEXT_55 = ".getType(";
  protected final String TEXT_56 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_57 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_58 = NL + "\t}" + NL + "}";
  protected final String TEXT_59 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genElement.getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");

importManager.markImportLocation(stringBuffer);

final boolean isLabel = genElement instanceof GenChildLabelNode;
final boolean isShape = !isLabel;
final boolean isNode = true;

Viewmap viewmap = genElement.getViewmap();
StyleAttributes styleAttributes = (viewmap == null) ? null : (StyleAttributes)viewmap.find(StyleAttributes.class);
boolean fixedForeground = styleAttributes != null && styleAttributes.isFixedForeground();
boolean fixedFont = styleAttributes != null && styleAttributes.isFixedFont();

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_5);
    if (isLabel) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory"));
    } else if (isShape) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory"));
    } else {
	throw new IllegalStateException("Unknown case for " + genElement);
}
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_10);
    
if (isShape) {
	if (!fixedFont) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_12);
    	} else { /*all but font style*/
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_16);
    	}
}

    stringBuffer.append(TEXT_17);
    /* [++] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genElement.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_20);
    /* [--] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    
ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_34);
    
}
if (isNode) {
	GenNode genNode = (GenNode) genElement;
	if (genNode.getBehaviour(OpenDiagramBehaviour.class).size() == 1) /*XXX perhaps, add size() linkStyles with different hints and process them with single policy?*/ {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_37);
    	if (genNode.getBehaviour(OpenDiagramBehaviour.class).get(0).getDiagramKind() != null) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genNode.getBehaviour(OpenDiagramBehaviour.class).get(0).getDiagramKind());
    stringBuffer.append(TEXT_39);
    	}
    stringBuffer.append(TEXT_40);
    	}
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_46);
    
	}
	List labels = genNode.getLabels();
	List genChildContainers = genNode.getCompartments();
	if (labels.size() > 0 || genChildContainers.size() > 0) {
		if (genNode.getModelFacet() != null) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_48);
    
		} else {

    stringBuffer.append(TEXT_49);
    
		}
	}	
	for (int j = 0; j < labels.size(); j++) {
		GenNodeLabel label = (GenNodeLabel) labels.get(j);

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_53);
    
	}
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);

    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genChildContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_57);
    
	}
}

    stringBuffer.append(TEXT_58);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_59);
    return stringBuffer.toString();
  }
}
