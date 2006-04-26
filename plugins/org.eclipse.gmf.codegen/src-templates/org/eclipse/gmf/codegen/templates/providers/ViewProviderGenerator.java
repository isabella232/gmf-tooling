package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {";
  protected final String TEXT_9 = NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_10 = NL + "\t\tif (";
  protected final String TEXT_11 = ".MODEL_ID.equals(diagramKind)";
  protected final String TEXT_12 = NL + "\t\t\t\t&& ";
  protected final String TEXT_13 = ".getDiagramVisualID(semanticElement) != -1";
  protected final String TEXT_14 = NL + "\t\t\t\t) {" + NL + "\t\t\treturn ";
  protected final String TEXT_15 = ".class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tif (containerView == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_16 = ".getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);" + NL + "" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_17 = NL + "\t\tcase ";
  protected final String TEXT_18 = ".VISUAL_ID:" + NL + "\t\t\t return ";
  protected final String TEXT_19 = ".class;";
  protected final String TEXT_20 = NL + "\t\tcase ";
  protected final String TEXT_21 = ".VISUAL_ID:" + NL + "\t\t\treturn ";
  protected final String TEXT_22 = ".class;";
  protected final String TEXT_23 = NL + "\t\tcase ";
  protected final String TEXT_24 = ".VISUAL_ID:" + NL + "\t\t\treturn ";
  protected final String TEXT_25 = ".class;";
  protected final String TEXT_26 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = " elementType = getSemanticElementType(semanticAdapter);";
  protected final String TEXT_29 = NL + "\t\tif (";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".equals(elementType)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_32 = ".class;" + NL + "\t\t}";
  protected final String TEXT_33 = NL + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tif (semanticType == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "" + NL + "\t\tint linkVID = ";
  protected final String TEXT_34 = ".getLinkWithClassVisualID(semanticElement, semanticType);" + NL + "\t\t" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_35 = NL + "\t\tcase ";
  protected final String TEXT_36 = ".VISUAL_ID:" + NL + "\t\t\treturn ";
  protected final String TEXT_37 = ".class;";
  protected final String TEXT_38 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_40 = " getSemanticElementType(IAdaptable semanticAdapter) {" + NL + "\t\tif (semanticAdapter == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (";
  protected final String TEXT_41 = ") semanticAdapter.getAdapter(";
  protected final String TEXT_42 = ".class);" + NL + "\t}";
  protected final String TEXT_43 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_44 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
List genLinks = genDiagram.getLinks();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getNotationViewProviderClassName());
    stringBuffer.append(TEXT_8);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    
for (Iterator containers = genDiagram.getAllChildContainers().iterator(); containers.hasNext();) {
	GenContainerBase container = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(container.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(container.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    
	if (container instanceof GenNode && !((GenNode) container).isListContainerEntry()) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    
		}
	}
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(linkLabel.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    
	}
}

    stringBuffer.append(TEXT_26);
    
boolean elementTypeInitialized = false;
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof FeatureModelFacet || genLink.getModelFacet() == null) {
		if (!elementTypeInitialized) {
			elementTypeInitialized = true;

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_28);
    
		}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
	}
}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_37);
    
	}
}

    stringBuffer.append(TEXT_38);
    if (elementTypeInitialized) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
