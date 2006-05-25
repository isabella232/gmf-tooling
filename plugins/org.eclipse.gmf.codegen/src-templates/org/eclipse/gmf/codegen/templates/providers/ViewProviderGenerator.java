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
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {";
  protected final String TEXT_7 = NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_8 = NL + "\t\tif (";
  protected final String TEXT_9 = ".MODEL_ID.equals(diagramKind)";
  protected final String TEXT_10 = NL + "\t\t\t\t&& ";
  protected final String TEXT_11 = ".getDiagramVisualID(semanticElement) != -1";
  protected final String TEXT_12 = NL + "\t\t\t\t) {" + NL + "\t\t\treturn ";
  protected final String TEXT_13 = ".class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tif (containerView == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tIElementType elementType = getSemanticElementType(semanticAdapter);" + NL + "\t\tif (semanticAdapter != null && !";
  protected final String TEXT_14 = ".isKnownElementType(elementType)) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_15 = ".getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_16 = NL + "\t\tcase ";
  protected final String TEXT_17 = ".VISUAL_ID:" + NL + "\t\t\t return ";
  protected final String TEXT_18 = ".class;";
  protected final String TEXT_19 = NL + "\t\tcase ";
  protected final String TEXT_20 = ".VISUAL_ID:" + NL + "\t\t\treturn ";
  protected final String TEXT_21 = ".class;";
  protected final String TEXT_22 = NL + "\t\tcase ";
  protected final String TEXT_23 = ".VISUAL_ID:" + NL + "\t\t\treturn ";
  protected final String TEXT_24 = ".class;";
  protected final String TEXT_25 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tIElementType elementType = getSemanticElementType(semanticAdapter);" + NL + "\t\tif (semanticAdapter != null && !";
  protected final String TEXT_26 = ".isKnownElementType(elementType)) {" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t\tif (";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ".equals(elementType)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_30 = ".class;" + NL + "\t\t}";
  protected final String TEXT_31 = NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tif (semanticType == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint linkVID = ";
  protected final String TEXT_32 = ".getLinkWithClassVisualID(semanticElement, semanticType);" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_33 = NL + "\t\tcase ";
  protected final String TEXT_34 = ".VISUAL_ID:" + NL + "\t\t\treturn ";
  protected final String TEXT_35 = ".class;";
  protected final String TEXT_36 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IElementType getSemanticElementType(IAdaptable semanticAdapter) {" + NL + "\t\tif (semanticAdapter == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (IElementType) semanticAdapter.getAdapter(IElementType.class);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
List genLinks = genDiagram.getLinks();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getNotationViewProviderClassName());
    stringBuffer.append(TEXT_6);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    
for (Iterator containers = genDiagram.getAllChildContainers().iterator(); containers.hasNext();) {
	GenContainerBase container = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(container.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(container.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    
	if (container instanceof GenNode) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    
		}
	}
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(linkLabel.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    
	}
}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof FeatureModelFacet || genLink.getModelFacet() == null) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    
	}
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genLink.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    
	}
}

    stringBuffer.append(TEXT_36);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
