package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ViewProviderGenerator
{
  protected static String nl;
  public static synchronized ViewProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ViewProviderGenerator result = new ViewProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tif (\"";
  protected final String TEXT_6 = "\".equals(diagramKind) && ";
  protected final String TEXT_7 = ".INSTANCE.getDiagramVisualID(semanticElement) != -1) { //$NON-NLS-1$" + NL + "\t\t\treturn DiagramViewFactory.class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tClass linkLabelViewClass = getLinkLabelViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\tif (linkLabelViewClass != null) {" + NL + "\t\t\treturn linkLabelViewClass;" + NL + "\t\t}" + NL + "\t\tif (containerView instanceof Diagram || (semanticHint != null && semanticHint.length() > 0)) {" + NL + "\t\t\treturn getTopLevelNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\t} else {" + NL + "\t\t\treturn getChildNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getLinkLabelViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {";
  protected final String TEXT_8 = NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint linkVID = ";
  protected final String TEXT_9 = ".INSTANCE.getLinkWithClassVisualID(semanticElement, semanticType);" + NL + "\t\t" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_10 = NL + "\t\tcase ";
  protected final String TEXT_11 = ":";
  protected final String TEXT_12 = NL + "\t\t\tif (";
  protected final String TEXT_13 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_14 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\tif (";
  protected final String TEXT_15 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\treturn null;";
  protected final String TEXT_17 = NL + "\t\t\t" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getTopLevelNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_19 = ".INSTANCE.getNodeVisualID(semanticElement, semanticType);" + NL + "\t\t" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_20 = NL + "\t\tcase ";
  protected final String TEXT_21 = ":";
  protected final String TEXT_22 = NL + "\t\t\tif (";
  protected final String TEXT_23 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\tif (";
  protected final String TEXT_25 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ListCompartmentViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\treturn ";
  protected final String TEXT_27 = ".class;";
  protected final String TEXT_28 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedTopLevelNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedTopLevelNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getChildNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_29 = ".INSTANCE.getChildNodeVisualID(semanticElement, semanticType);" + NL + "\t\t" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_30 = NL + "\t\tcase ";
  protected final String TEXT_31 = ":" + NL + "\t\t\treturn ";
  protected final String TEXT_32 = ".class;";
  protected final String TEXT_33 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedChildNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedChildNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tIElementType elementType = (IElementType) semanticAdapter.getAdapter(IElementType.class);";
  protected final String TEXT_34 = NL + "\t\tif (ElementTypes.";
  protected final String TEXT_35 = ".equals(elementType)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_36 = ".class;" + NL + "\t\t}";
  protected final String TEXT_37 = NL + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "" + NL + "\t\tint linkVID = ";
  protected final String TEXT_38 = ".INSTANCE.getLinkWithClassVisualID(semanticElement, semanticType);" + NL + "\t\t" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_39 = NL + "\t\tcase ";
  protected final String TEXT_40 = ":";
  protected final String TEXT_41 = NL + "\t\t\tif (";
  protected final String TEXT_42 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tif (";
  protected final String TEXT_43 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_44 = NL + "\t\t\treturn ";
  protected final String TEXT_45 = ".class;";
  protected final String TEXT_46 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "\t" + NL + "}";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEMFGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getViewProviderClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_7);
    
List genLinks = genDiagram.getLinks();
if (genLinks.size() != 0) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_9);
    
	for (int i = 0; i < genLinks.size(); i++) {
		GenLink genLink = (GenLink) genLinks.get(i);
		String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genLink);
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
		if (genLink instanceof GenLinkWithClass) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_11);
    
			List labels = genLink.getLabels();
			for (int j = 0; j < labels.size(); j++) {
				GenLinkLabel label = (GenLinkLabel) labels.get(j);
				String labelViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelId(label);
				String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_12);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_15);
    
			}

    stringBuffer.append(TEXT_16);
    			
		}
	}

    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_19);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);

    stringBuffer.append(TEXT_20);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_21);
    
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
	List labels = genNode.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenNodeLabel label = (GenNodeLabel) labels.get(j);
		String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_23);
    
	}
	List genChildContainers = genNode.getChildContainers();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenChildContainer genChildContainer = (GenChildContainer) genChildContainers.get(j);
		String compartmentId = semanticHintsClassName + ".Compartments." + AccessUtil.getCompartmentId(genChildContainer);

    stringBuffer.append(TEXT_24);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_25);
    	}
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_29);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);

    stringBuffer.append(TEXT_30);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genChildNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_32);
    
	}
}

    stringBuffer.append(TEXT_33);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkReferenceOnly) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_36);
    
	}
}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_38);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genLink);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
	if (genLink instanceof GenLinkWithClass) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_40);
    
		// disable creation of connector views for label links
		List labels = genLink.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			GenLinkLabel label = (GenLinkLabel) labels.get(j);
			String labelViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelId(label);
			String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_43);
    		}
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_45);
    
	}
}

    stringBuffer.append(TEXT_46);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
