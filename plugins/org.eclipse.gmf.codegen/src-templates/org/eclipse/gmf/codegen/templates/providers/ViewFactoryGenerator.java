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
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = "    " + NL + "\t";
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprotected List createStyles(View view) {" + NL + "\t\t";
  protected final String TEXT_13 = " styles = new ";
  protected final String TEXT_14 = "();";
  protected final String TEXT_15 = NL + "\t\tstyles.add(";
  protected final String TEXT_16 = ".eINSTANCE.createRoutingStyle());";
  protected final String TEXT_17 = NL + "\t\tstyles.add(";
  protected final String TEXT_18 = ".eINSTANCE.createFontStyle());";
  protected final String TEXT_19 = NL + "\t\tstyles.add(";
  protected final String TEXT_20 = ".eINSTANCE.createLineStyle());";
  protected final String TEXT_21 = NL + "\t\tstyles.add(";
  protected final String TEXT_22 = ".eINSTANCE.createPageStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_23 = ".eINSTANCE.createGuideStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_24 = ".eINSTANCE.createDescriptionStyle());";
  protected final String TEXT_25 = NL + "\t\tstyles.add(";
  protected final String TEXT_26 = ".eINSTANCE.createDrawerStyle());";
  protected final String TEXT_27 = NL + "\t\tstyles.add(";
  protected final String TEXT_28 = ".eINSTANCE.createTitleStyle());";
  protected final String TEXT_29 = "\t" + NL + "\t\tstyles.add(";
  protected final String TEXT_30 = ".eINSTANCE.createSortingStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_31 = ".eINSTANCE.createFilteringStyle());";
  protected final String TEXT_32 = NL + "\t\tstyles.add(";
  protected final String TEXT_33 = ".eINSTANCE.createFontStyle());";
  protected final String TEXT_34 = NL + "\t\tstyles.add(";
  protected final String TEXT_35 = ".eINSTANCE.createDescriptionStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_36 = ".eINSTANCE.createFillStyle());" + NL + "\t\tstyles.add(";
  protected final String TEXT_37 = ".eINSTANCE.createLineStyle());";
  protected final String TEXT_38 = NL + "\t\treturn styles;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_39 = NL + "\tprotected void decorateView(View view, IAdaptable semanticAdapter, String diagramKind){" + NL + "\t\tsuper.decorateView(view, semanticAdapter, diagramKind);";
  protected final String TEXT_40 = NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tif (semanticHint == null) { ";
  protected final String TEXT_41 = NL + "\t\t\tsemanticHint = ";
  protected final String TEXT_42 = ".getType(";
  protected final String TEXT_43 = ".VISUAL_ID);" + NL + "\t\t\tview.setType(semanticHint);" + NL + "\t\t}";
  protected final String TEXT_44 = NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_45 = NL + "\t\tsetupCompartmentTitle(view);" + NL + "\t\tsetupCompartmentCollapsed(view);";
  protected final String TEXT_46 = "\t\t" + NL + "\t\tif (!";
  protected final String TEXT_47 = ".MODEL_ID.equals(";
  protected final String TEXT_48 = ".getModelID(containerView))) {";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = "\t\t\t";
  protected final String TEXT_51 = " shortcutAnnotation = ";
  protected final String TEXT_52 = ".eINSTANCE.createEAnnotation();" + NL + "\t\t\tshortcutAnnotation.setSource(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tshortcutAnnotation.getDetails().put(\"modelID\", ";
  protected final String TEXT_53 = ".MODEL_ID); //$NON-NLS-1$" + NL + "\t\t\tview.getEAnnotations().add(shortcutAnnotation);" + NL + "\t\t}";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_56 = ".eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\t";
  protected final String TEXT_57 = ".colorToInteger(";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = "));";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = " diagramFacet = ";
  protected final String TEXT_62 = ".eINSTANCE.createEAnnotation();" + NL + "\t\tdiagramFacet.setSource(\"";
  protected final String TEXT_63 = "\");" + NL + "\t\tview.getEAnnotations().add(diagramFacet);";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_66 = ".eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\t";
  protected final String TEXT_67 = ".colorToInteger(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = "));";
  protected final String TEXT_70 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_71 = ".getType(";
  protected final String TEXT_72 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_73 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_74 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_75 = ".getType(";
  protected final String TEXT_76 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_77 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_78 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_79 = ".getType(";
  protected final String TEXT_80 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_81 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_82 = NL + "\t}";
  protected final String TEXT_83 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_84 = " createLayoutConstraint() {" + NL + "\t\treturn ";
  protected final String TEXT_85 = ".eINSTANCE.createBounds();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeFromPreferences(View view) {" + NL + "\t\tsuper.initializeFromPreferences(view);" + NL + "" + NL + "\t\t";
  protected final String TEXT_86 = " store = (";
  protected final String TEXT_87 = ") getPreferencesHint().getPreferenceStore();" + NL + "" + NL + "\t\t// fill color" + NL + "\t\t";
  protected final String TEXT_88 = " fillRGB = ";
  protected final String TEXT_89 = ".getColor(store, ";
  protected final String TEXT_90 = ".PREF_FILL_COLOR);" + NL + "\t\t";
  protected final String TEXT_91 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_92 = ".eINSTANCE.getFillStyle_FillColor(), ";
  protected final String TEXT_93 = ".RGBToInteger(fillRGB));" + NL + "\t}";
  protected final String TEXT_94 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_95 = " getMeasurementUnit() {" + NL + "\t\treturn ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = "_LITERAL;" + NL + "\t}";
  protected final String TEXT_98 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupCompartmentTitle(View view) {" + NL + "\t\t";
  protected final String TEXT_99 = " titleStyle = (";
  protected final String TEXT_100 = ")view.getStyle(";
  protected final String TEXT_101 = ".eINSTANCE.getTitleStyle());" + NL + "\t\tif (titleStyle != null){" + NL + "\t\t\ttitleStyle.setShowTitle(true);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupCompartmentCollapsed(View view) {" + NL + "\t\t";
  protected final String TEXT_102 = " drawerStyle = (";
  protected final String TEXT_103 = ")view.getStyle(";
  protected final String TEXT_104 = ".eINSTANCE.getDrawerStyle());" + NL + "\t\tif (drawerStyle != null){" + NL + "\t\t\tdrawerStyle.setCollapsed(false);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_105 = NL + NL + "}";
  protected final String TEXT_106 = NL;

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
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
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
    } else if (isDiagram) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory"));
    } else if (isShape) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory"));
    } else {
	throw new IllegalStateException("Unknown case for " + genElement);
}
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_14);
    if (isLink) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_16);
    	if (!fixedFont) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_18);
    	}
    	if (!fixedForeground) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_20);
    	}
    
}
if (isLabel) {
	//no styles for label
	//FIXME: throw new IllegalStateExcpetion("Labels to be processed in the LabelTextViewFactory/LabelViewFactory");
}
if (isDiagram) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_24);
    
}
if (isCompartment) {
	GenCompartment genCompartment = (GenCompartment)genElement;
	if (genCompartment.isCanCollapse()) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_26);
    
	}
	if (genCompartment.isNeedsTitle()) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_28);
    	}
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_31);
    
}
if (isShape || isCompartmentWithOwnBounds) {

    	if (!fixedFont) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_33);
    	}
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    
if (isDiagram) {

    stringBuffer.append(TEXT_39);
    
} else {

    stringBuffer.append(TEXT_40);
    /* [++] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genElement.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_43);
    /* [--] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_44);
    	if (isCompartment){
    stringBuffer.append(TEXT_45);
    	}
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_53);
    
}

ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_59);
    
}
if (isNode) {
	GenNode genNode = (GenNode) genElement;
	if (genNode.getBehaviour(OpenDiagramBehaviour.class).size() == 1) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(org.eclipse.gmf.codegen.gmfgen.impl.OpenDiagramBehaviourImpl.ANNOTATION_SOURCE);
    stringBuffer.append(TEXT_63);
    	}
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_69);
    
	}	
	List labels = genNode.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenNodeLabel label = (GenNodeLabel) labels.get(j);

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_73);
    
	}
	List genChildContainers = genNode.getCompartments();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(genChildContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_77);
    
	}
} else if (isLink) {
	GenLink genLink = (GenLink) genElement;
	List labels = genLink.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenLinkLabel label = (GenLinkLabel) labels.get(j);

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_81);
    
	}
}

    stringBuffer.append(TEXT_82);
    if (isCompartmentWithOwnBounds) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LayoutConstraint"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.RGB"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.PreferenceConverter"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_93);
    }
    if (isDiagram && genDiagram.getUnits() != null && genDiagram.getUnits().trim().length() > 0) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.MeasurementUnit"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.MeasurementUnit"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genDiagram.getUnits().toUpperCase());
    stringBuffer.append(TEXT_97);
    }
    
if (isCompartment) {
	String titleStyleFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.TitleStyle");
	String drawerStyleFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle");	
	String notationPackageFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage");

    stringBuffer.append(TEXT_98);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_106);
    return stringBuffer.toString();
  }
}
