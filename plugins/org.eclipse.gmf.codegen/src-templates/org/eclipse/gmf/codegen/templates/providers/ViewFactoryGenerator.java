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

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprotected List createStyles(View view) {" + NL + "\t\t";
  protected final String TEXT_12 = " styles = new ";
  protected final String TEXT_13 = "();";
  protected final String TEXT_14 = NL + "\t\tstyles.add(";
  protected final String TEXT_15 = ".eINSTANCE.createConnectorStyle());";
  protected final String TEXT_16 = NL + "\t\tstyles.add(";
  protected final String TEXT_17 = ".eINSTANCE.createRoutingStyle());";
  protected final String TEXT_18 = NL + "\t\tstyles.add(";
  protected final String TEXT_19 = ".eINSTANCE.createFontStyle());";
  protected final String TEXT_20 = NL + "\t\tstyles.add(";
  protected final String TEXT_21 = ".eINSTANCE.createDrawerStyle());";
  protected final String TEXT_22 = NL + "\t\tstyles.add(";
  protected final String TEXT_23 = ".eINSTANCE.createTitleStyle());";
  protected final String TEXT_24 = "\t" + NL + "\t\tstyles.add(";
  protected final String TEXT_25 = ".eINSTANCE.createSortingStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_26 = ".eINSTANCE.createFilteringStyle());";
  protected final String TEXT_27 = NL + "\t\tstyles.add(";
  protected final String TEXT_28 = ".eINSTANCE.createShapeStyle());";
  protected final String TEXT_29 = NL + "\t\tstyles.add(";
  protected final String TEXT_30 = ".eINSTANCE.createDescriptionStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_31 = ".eINSTANCE.createFillStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_32 = ".eINSTANCE.createLineStyle());";
  protected final String TEXT_33 = NL + "\t\treturn styles;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tif (semanticHint == null) { ";
  protected final String TEXT_34 = NL + "\t\t\tsemanticHint = ";
  protected final String TEXT_35 = ".getType(";
  protected final String TEXT_36 = ".VISUAL_ID);" + NL + "\t\t\tview.setType(semanticHint);" + NL + "\t\t}";
  protected final String TEXT_37 = NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_38 = NL + "\t\tsetupCompartmentTitle(view);" + NL + "\t\tsetupCompartmentCollapsed(view);";
  protected final String TEXT_39 = "\t\t" + NL + "\t\tif (!";
  protected final String TEXT_40 = ".MODEL_ID.equals(";
  protected final String TEXT_41 = ".getModelID(containerView))) {";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "\t\t\t";
  protected final String TEXT_44 = " shortcutAnnotation = ";
  protected final String TEXT_45 = ".eINSTANCE.createEAnnotation();" + NL + "\t\t\tshortcutAnnotation.setSource(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tshortcutAnnotation.getDetails().put(\"modelID\", ";
  protected final String TEXT_46 = ".MODEL_ID); //$NON-NLS-1$" + NL + "\t\t\tview.getEAnnotations().add(shortcutAnnotation);" + NL + "\t\t}";
  protected final String TEXT_47 = NL + "\t\t";
  protected final String TEXT_48 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_49 = ".eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\t";
  protected final String TEXT_50 = ".colorToInteger(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "));";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = " diagramFacet = ";
  protected final String TEXT_55 = ".eINSTANCE.createHintedDiagramLinkStyle();";
  protected final String TEXT_56 = NL + "\t\tdiagramFacet.setHint(\"";
  protected final String TEXT_57 = "\"); // $NON-NLS-1$";
  protected final String TEXT_58 = NL + "\t\tview.getStyles().add(diagramFacet);";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_61 = ".eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\t";
  protected final String TEXT_62 = ".colorToInteger(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = "));";
  protected final String TEXT_65 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_66 = ".getType(";
  protected final String TEXT_67 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_68 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_69 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_70 = ".getType(";
  protected final String TEXT_71 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_72 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_73 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_74 = ".getType(";
  protected final String TEXT_75 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_76 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_79 = " createLayoutConstraint() {" + NL + "\t\treturn ";
  protected final String TEXT_80 = ".eINSTANCE.createBounds();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeFromPreferences(View view) {" + NL + "\t\tsuper.initializeFromPreferences(view);" + NL + "" + NL + "\t\t";
  protected final String TEXT_81 = " store = (";
  protected final String TEXT_82 = ") getPreferencesHint().getPreferenceStore();" + NL + "" + NL + "\t\t// fill color" + NL + "\t\t";
  protected final String TEXT_83 = " fillRGB = ";
  protected final String TEXT_84 = ".getColor(store, ";
  protected final String TEXT_85 = ".PREF_FILL_COLOR);" + NL + "\t\t";
  protected final String TEXT_86 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_87 = ".eINSTANCE.getFillStyle_FillColor(), ";
  protected final String TEXT_88 = ".RGBToInteger(fillRGB));" + NL + "\t}";
  protected final String TEXT_89 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupCompartmentTitle(View view) {" + NL + "\t\t";
  protected final String TEXT_90 = " titleStyle = (";
  protected final String TEXT_91 = ")view.getStyle(";
  protected final String TEXT_92 = ".eINSTANCE.getTitleStyle());" + NL + "\t\tif (titleStyle != null){" + NL + "\t\t\ttitleStyle.setShowTitle(true);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupCompartmentCollapsed(View view) {" + NL + "\t\t";
  protected final String TEXT_93 = " drawerStyle = (";
  protected final String TEXT_94 = ")view.getStyle(";
  protected final String TEXT_95 = ".eINSTANCE.getDrawerStyle());" + NL + "\t\tif (drawerStyle != null){" + NL + "\t\t\tdrawerStyle.setCollapsed(false);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_96 = NL + "}";
  protected final String TEXT_97 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenDiagram genDiagram = genElement.getDiagram();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");

importManager.markImportLocation(stringBuffer);

final boolean isLink = genElement instanceof GenLink;
final boolean isLabel = genElement instanceof GenChildLabelNode;
final boolean isDiagram = genElement instanceof GenDiagram;
final boolean isCompartment = genElement instanceof GenCompartment;
final boolean isShape = !isLink && !isLabel && !isDiagram && !isCompartment; // captures else
assert isLink || isLabel || isDiagram || isCompartment || isShape;

final boolean isNode = !isLink && !isDiagram && !isCompartment;
boolean isCompartmentWithOwnBounds = false;
if (isCompartment){
	GenCompartment genCompartment = (GenCompartment)genElement;
	isCompartmentWithOwnBounds = ViewmapLayoutTypeHelper.getSharedInstance().isStoringChildPositions(genCompartment.getNode());
}

Viewmap viewmap = genElement.getViewmap();
StyleAttributes styleAttributes = (viewmap == null) ? null : (StyleAttributes)viewmap.find(StyleAttributes.class);
boolean fixedForeground = styleAttributes != null && styleAttributes.isFixedForeground();
boolean fixedFont = styleAttributes != null && styleAttributes.isFixedFont();

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_6);
    if (isLink) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory"));
    } else if (isLabel) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory"));
    } else if (isCompartment) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory"));
    } else if (isShape) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory"));
    } else {
	throw new IllegalStateException("Unknown case for " + genElement);
}
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_13);
    if (isLink) {
    	if (!fixedForeground) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_15);
    	} else { /*only routing, no line style*/ 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_17);
    	} 
    	if (!fixedFont) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_19);
    	}
    
} /*isLink*/
if (isLabel) {
	//no styles for label
	//FIXME: throw new IllegalStateExcpetion("Labels to be processed in the LabelTextViewFactory/LabelViewFactory");
}
if (isCompartment) {
	GenCompartment genCompartment = (GenCompartment)genElement;
	if (genCompartment.isCanCollapse()) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_21);
    
	}
	if (genCompartment.isNeedsTitle()) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_23);
    	}
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_26);
    
}
if (isShape || isCompartmentWithOwnBounds) {

    	if (!fixedFont) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_28);
    	} else { /*all but font style*/
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_32);
    	}
} /*isShape || isCompartmentWithOwnBounds*/ 
    stringBuffer.append(TEXT_33);
    /* [++] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genElement.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_36);
    /* [--] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_37);
    	if (isCompartment){
    stringBuffer.append(TEXT_38);
    	}
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_46);
    
ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_52);
    
}
if (isNode) {
	GenNode genNode = (GenNode) genElement;
	if (genNode.getBehaviour(OpenDiagramBehaviour.class).size() == 1) /*XXX perhaps, add size() linkStyles with different hints and process them with single policy?*/ {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_55);
    	if (genNode.getBehaviour(OpenDiagramBehaviour.class).get(0).getDiagramKind() != null) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genNode.getBehaviour(OpenDiagramBehaviour.class).get(0).getDiagramKind());
    stringBuffer.append(TEXT_57);
    	}
    stringBuffer.append(TEXT_58);
    	}
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_64);
    
	}	
	List labels = genNode.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenNodeLabel label = (GenNodeLabel) labels.get(j);

    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_68);
    
	}
	List genChildContainers = genNode.getCompartments();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);

    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(genChildContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_72);
    
	}
} else if (isLink) {
	GenLink genLink = (GenLink) genElement;
	List labels = genLink.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenLinkLabel label = (GenLinkLabel) labels.get(j);

    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_76);
    
	}
}

    stringBuffer.append(TEXT_77);
    if (isCompartmentWithOwnBounds) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LayoutConstraint"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.RGB"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.PreferenceConverter"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_88);
    }
if (isCompartment) {
	String titleStyleFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.TitleStyle");
	String drawerStyleFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle");	
	String notationPackageFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage");

    stringBuffer.append(TEXT_89);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_97);
    return stringBuffer.toString();
  }
}
