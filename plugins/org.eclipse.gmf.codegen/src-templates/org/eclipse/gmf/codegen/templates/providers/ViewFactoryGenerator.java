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
  protected final String TEXT_12 = NL + "{" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_13 = NL + "\tprotected void decorateView(View view, IAdaptable semanticAdapter, String diagramKind){" + NL + "\t\tsuper.decorateView(view, semanticAdapter, diagramKind);";
  protected final String TEXT_14 = NL + "\tprotected void decorateView(View containerView, View view, IAdaptable semanticAdapter," + NL + "\t\t\tString semanticHint, int index, boolean persisted) {" + NL + "\t\tif (semanticHint == null) { ";
  protected final String TEXT_15 = NL + "\t\t\tsemanticHint = ";
  protected final String TEXT_16 = ".getType(";
  protected final String TEXT_17 = ".VISUAL_ID);" + NL + "\t\t\tview.setType(semanticHint);" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\tsuper.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);";
  protected final String TEXT_19 = NL + "\t\tsetupCompartmentTitle(view);" + NL + "\t\tsetupCompartmentCollapsed(view);";
  protected final String TEXT_20 = "\t\t" + NL + "\t\tif (!";
  protected final String TEXT_21 = ".MODEL_ID.equals(";
  protected final String TEXT_22 = ".getModelID(containerView))) {" + NL + "\t\t\t";
  protected final String TEXT_23 = " shortcutAnnotation = ";
  protected final String TEXT_24 = ".eINSTANCE.createEAnnotation();" + NL + "\t\t\tshortcutAnnotation.setSource(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tshortcutAnnotation.getDetails().put(\"modelID\", ";
  protected final String TEXT_25 = ".MODEL_ID); //$NON-NLS-1$" + NL + "\t\t\tview.getEAnnotations().add(shortcutAnnotation);" + NL + "\t\t}";
  protected final String TEXT_26 = NL + "\t\t";
  protected final String TEXT_27 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_28 = ".eINSTANCE.getLineStyle_LineColor()," + NL + "\t\t\t";
  protected final String TEXT_29 = ".colorToInteger(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = "));";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_34 = ".eINSTANCE.getFillStyle_FillColor()," + NL + "\t\t\t";
  protected final String TEXT_35 = ".colorToInteger(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = "));";
  protected final String TEXT_38 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_39 = ".getType(";
  protected final String TEXT_40 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_41 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_42 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_43 = ".getType(";
  protected final String TEXT_44 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_45 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_46 = NL + "\t\tgetViewService().createNode(semanticAdapter, view, ";
  protected final String TEXT_47 = ".getType(";
  protected final String TEXT_48 = ".VISUAL_ID)," + NL + "\t\t\t";
  protected final String TEXT_49 = ".APPEND, true, getPreferencesHint());";
  protected final String TEXT_50 = NL + "\t}";
  protected final String TEXT_51 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_52 = " createStyles(View view) {" + NL + "\t\t";
  protected final String TEXT_53 = " styles = super.createStyles(view);" + NL + "\t\tstyles.add(";
  protected final String TEXT_54 = ".eINSTANCE.createShapeStyle());" + NL + "\t\treturn styles;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_55 = " createLayoutConstraint() {" + NL + "\t\treturn ";
  protected final String TEXT_56 = ".eINSTANCE.createBounds();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void initializeFromPreferences(View view) {" + NL + "\t\tsuper.initializeFromPreferences(view);" + NL + "" + NL + "\t\t";
  protected final String TEXT_57 = " store = (";
  protected final String TEXT_58 = ") getPreferencesHint().getPreferenceStore();" + NL + "" + NL + "\t\t// fill color" + NL + "\t\t";
  protected final String TEXT_59 = " fillRGB = ";
  protected final String TEXT_60 = ".getColor(store, ";
  protected final String TEXT_61 = ".PREF_FILL_COLOR);" + NL + "\t\t";
  protected final String TEXT_62 = ".setStructuralFeatureValue(view, ";
  protected final String TEXT_63 = ".eINSTANCE.getFillStyle_FillColor(), ";
  protected final String TEXT_64 = ".RGBToInteger(fillRGB));" + NL + "\t}";
  protected final String TEXT_65 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_66 = " getMeasurementUnit() {" + NL + "\t\treturn ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = "_LITERAL;" + NL + "\t}";
  protected final String TEXT_69 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupCompartmentTitle(View view) {" + NL + "\t\t";
  protected final String TEXT_70 = " titleStyle = (";
  protected final String TEXT_71 = ")view.getStyle(";
  protected final String TEXT_72 = ".eINSTANCE.getTitleStyle());";
  protected final String TEXT_73 = "\t\t" + NL + "\t\tif (titleStyle == null){" + NL + "\t\t\ttitleStyle = (";
  protected final String TEXT_74 = ") view.createStyle(";
  protected final String TEXT_75 = ".eINSTANCE.getTitleStyle());" + NL + "\t\t}" + NL + "\t\ttitleStyle.setShowTitle(true);";
  protected final String TEXT_76 = NL + "\t\tif (titleStyle != null){" + NL + "\t\t\tview.getStyles().remove(titleStyle);" + NL + "\t\t}";
  protected final String TEXT_77 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setupCompartmentCollapsed(View view) {" + NL + "\t\t";
  protected final String TEXT_78 = " drawerStyle = (";
  protected final String TEXT_79 = ")view.getStyle(";
  protected final String TEXT_80 = ".eINSTANCE.getDrawerStyle());";
  protected final String TEXT_81 = "\t\t" + NL + "\t\tif (drawerStyle == null){" + NL + "\t\t\tdrawerStyle = (";
  protected final String TEXT_82 = ") view.createStyle(";
  protected final String TEXT_83 = ".eINSTANCE.getDrawerStyle());" + NL + "\t\t}" + NL + "\t\tdrawerStyle.setCollapsed(false);";
  protected final String TEXT_84 = NL + "\t\tif (drawerStyle != null){" + NL + "\t\t\tview.getStyles().remove(drawerStyle);" + NL + "\t\t}";
  protected final String TEXT_85 = NL + "\t}" + NL;
  protected final String TEXT_86 = NL + "}";
  protected final String TEXT_87 = NL;

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


boolean isLink = genElement instanceof GenLink;
boolean isDiagram = genElement instanceof GenDiagram;
boolean isCompartment = genElement instanceof GenCompartment;
boolean isNode = !isLink && !isDiagram && !isCompartment;
boolean isCompartmentWithOwnBounds = false;
if (isCompartment){
	GenCompartment genCompartment = (GenCompartment)genElement;
	isCompartmentWithOwnBounds = ViewmapLayoutTypeHelper.getSharedInstance().isStoringChildPositions(genCompartment.getNode());
}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genElement.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_6);
    if (isLink) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory"));
    } else if (genElement instanceof GenChildLabelNode) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory"));
    } else if (isCompartment) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory"));
    } else if (isDiagram) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory"));
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory"));
    }
    stringBuffer.append(TEXT_12);
    
if (isDiagram) {

    stringBuffer.append(TEXT_13);
    
} else {

    stringBuffer.append(TEXT_14);
    /* [++] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genElement.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_17);
    /* [--] important for the create shortcut functionality*/
    stringBuffer.append(TEXT_18);
    	if (isCompartment){
    stringBuffer.append(TEXT_19);
    	}
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EcoreFactory"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    
}

ColorAttributes colorAttrs = genElement.getViewmap() != null ? (ColorAttributes) genElement.getViewmap().find(ColorAttributes.class) : null;
if (colorAttrs != null && colorAttrs.getForegroundColor() != null && colorAttrs.getForegroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(colorAttrs.getForegroundColor());
    stringBuffer.append(TEXT_31);
    
}
if (isNode) {
	GenNode genNode = (GenNode) genElement;
	if (colorAttrs != null && colorAttrs.getBackgroundColor() != null && colorAttrs.getBackgroundColor().trim().length() > 0) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(colorAttrs.getBackgroundColor());
    stringBuffer.append(TEXT_37);
    
	}	
	List labels = genNode.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenNodeLabel label = (GenNodeLabel) labels.get(j);

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_41);
    
	}
	List genChildContainers = genNode.getCompartments();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenCompartment genChildContainer = (GenCompartment) genChildContainers.get(j);

    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genChildContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_45);
    
	}
} else if (isLink) {
	GenLink genLink = (GenLink) genElement;
	List labels = genLink.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenLinkLabel label = (GenLinkLabel) labels.get(j);

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_49);
    
	}
}

    stringBuffer.append(TEXT_50);
    if (isCompartmentWithOwnBounds) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.LayoutConstraint"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.IPreferenceStore"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.RGB"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.preference.PreferenceConverter"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities"));
    stringBuffer.append(TEXT_64);
    }
    if (isDiagram && genDiagram.getUnits() != null && genDiagram.getUnits().trim().length() > 0) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.MeasurementUnit"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.MeasurementUnit"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genDiagram.getUnits().toUpperCase());
    stringBuffer.append(TEXT_68);
    }
    
if (isCompartment) {
	String titleStyleFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.TitleStyle");
	String drawerStyleFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.DrawerStyle");	
	String notationPackageFQN = importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage");
	GenCompartment genCompartment = (GenCompartment)genElement;

    stringBuffer.append(TEXT_69);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_72);
    
if(genCompartment.isNeedsTitle()){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(titleStyleFQN);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_75);
    } else {
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_80);
    
if(genCompartment.isCanCollapse()){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(drawerStyleFQN);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(notationPackageFQN);
    stringBuffer.append(TEXT_83);
    } else {
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_87);
    return stringBuffer.toString();
  }
}
