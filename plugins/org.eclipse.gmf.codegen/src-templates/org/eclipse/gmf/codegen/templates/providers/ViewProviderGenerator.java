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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tif (\"";
  protected final String TEXT_6 = "\".equals(diagramKind) && ";
  protected final String TEXT_7 = ".INSTANCE.getDiagramVisualID(semanticElement) != -1) { //$NON-NLS-1$" + NL + "\t\t\treturn ";
  protected final String TEXT_8 = ".class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tif (containerView == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tif (!\"";
  protected final String TEXT_9 = "\".equals(containerView.getDiagram().getType())) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_10 = ".INSTANCE.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);" + NL + "" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_11 = NL + "\t\tcase ";
  protected final String TEXT_12 = ":" + NL + "\t\t\t return ";
  protected final String TEXT_13 = ".class;";
  protected final String TEXT_14 = NL + "\t\tcase ";
  protected final String TEXT_15 = ":" + NL + "\t\t\treturn ";
  protected final String TEXT_16 = ".class;";
  protected final String TEXT_17 = NL + "\t\tcase ";
  protected final String TEXT_18 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_19 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_20 = ".class;" + NL + "\t\t\t} else { " + NL + "\t\t\t\treturn ";
  protected final String TEXT_21 = ".class;" + NL + "\t\t\t}";
  protected final String TEXT_22 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tIElementType elementType = (IElementType) semanticAdapter.getAdapter(IElementType.class);";
  protected final String TEXT_23 = NL + "\t\tif (";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ".equals(elementType)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_26 = ".class;" + NL + "\t\t}";
  protected final String TEXT_27 = NL + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "" + NL + "\t\tint linkVID = ";
  protected final String TEXT_28 = ".INSTANCE.getLinkWithClassVisualID(semanticElement, semanticType);" + NL + "\t\t" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_29 = NL + "\t\tcase ";
  protected final String TEXT_30 = ":" + NL + "\t\t\treturn ";
  protected final String TEXT_31 = ".class;";
  protected final String TEXT_32 = NL + "\t\t}" + NL + "\t\treturn getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "\t" + NL + "}";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
GenModel genModel = genDiagram.getEMFGenModel();
List genLinks = genDiagram.getLinks();
Collection allContainers = AccessUtil.getAllContainers(genDiagram);

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
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer container = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(container.getVisualID());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(container.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    
	if (container instanceof GenNode) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(label.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    
		}
	}
}

for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelViewId = semanticHintsClassName + '.' + link.getUniqueIdentifier() + "Labels." + AccessUtil.getLabelId(linkLabel);

    stringBuffer.append(TEXT_17);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(linkLabel.getNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(linkLabel.getTextNotationViewFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    
	}
}

    stringBuffer.append(TEXT_22);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof FeatureModelFacet) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_26);
    
	}
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_31);
    
	}
}

    stringBuffer.append(TEXT_32);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
