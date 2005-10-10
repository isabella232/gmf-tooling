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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_4 = ".*;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ViewProvider extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tif (\"";
  protected final String TEXT_6 = "\".equals(diagramKind) && isDiagram";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "((";
  protected final String TEXT_9 = ") semanticElement)) { //$NON-NLS-1$" + NL + "\t\t\treturn DiagramViewFactory.class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_11 = NL + "\t\tif (";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "().equals(semanticType) && isConnector";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = "((";
  protected final String TEXT_16 = ") semanticElement)) {";
  protected final String TEXT_17 = NL + "\t\t\tif (\"";
  protected final String TEXT_18 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_19 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\tif (\"";
  protected final String TEXT_20 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_21 = NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_22 = NL + "\t\tboolean isTopLevel = containerView instanceof Diagram || (semanticHint != null && semanticHint.length() > 0);" + NL + "\t\tif (isTopLevel) {" + NL + "\t\t\treturn getTopLevelNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\t} else {" + NL + "\t\t\treturn getChildNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getTopLevelNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_23 = NL + "\t\tif (";
  protected final String TEXT_24 = ".eINSTANCE.get";
  protected final String TEXT_25 = "().equals(semanticType) && isNode";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "((";
  protected final String TEXT_28 = ") semanticElement)) {";
  protected final String TEXT_29 = NL + "\t\t\tif (";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_32 = NL + "\t\t\tif (\"";
  protected final String TEXT_33 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn ListCompartmentViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_34 = NL + "\t\t\treturn ";
  protected final String TEXT_35 = ".class;" + NL + "\t\t}";
  protected final String TEXT_36 = NL + "\t\treturn getUnrecognizedTopLevelNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedTopLevelNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getChildNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_37 = NL + "\t\tif (";
  protected final String TEXT_38 = ".eINSTANCE.get";
  protected final String TEXT_39 = "().equals(semanticType) && isChildNode";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = "((";
  protected final String TEXT_42 = ") semanticElement)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_43 = ".class;" + NL + "\t\t}";
  protected final String TEXT_44 = NL + "\t\treturn getUnrecognizedChildNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedChildNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_45 = NL + "\t\tif (";
  protected final String TEXT_46 = ".eINSTANCE.get";
  protected final String TEXT_47 = "().equals(semanticType) && isConnector";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = "((";
  protected final String TEXT_50 = ") semanticElement)) {";
  protected final String TEXT_51 = NL + "\t\t\tif (\"";
  protected final String TEXT_52 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tif (\"";
  protected final String TEXT_53 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_54 = NL + "\t\t\treturn ";
  protected final String TEXT_55 = ".class;" + NL + "\t\t}";
  protected final String TEXT_56 = NL + "\t\treturn getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = "(";
  protected final String TEXT_59 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_60 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = "(";
  protected final String TEXT_63 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_64 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isChildNode";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_68 = NL + "\t";
  protected final String TEXT_69 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isConnector";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = "(";
  protected final String TEXT_72 = " element) {" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_73 = NL + "\t" + NL + "}";
  protected final String TEXT_74 = NL;

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
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_9);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_10);
    
List genLinks = genDiagram.getLinks();
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_16);
    
		List labels = genLink.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			LinkLabel label = (LinkLabel) labels.get(j);

    stringBuffer.append(TEXT_17);
    stringBuffer.append(AccessUtil.getLinkLabelViewName(label));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(AccessUtil.getLinkLabelViewFactoryClassName(label));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(AccessUtil.getLinkLabelTextViewName(label));
    stringBuffer.append(TEXT_20);
    		}
    stringBuffer.append(TEXT_21);
    
	}
}

    stringBuffer.append(TEXT_22);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_23);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_28);
    
	if (genNode.hasNameToEdit()) {
		String semanticHintsQualifiedClassName = genDiagram.getEditProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);

    stringBuffer.append(TEXT_29);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genNode));
    stringBuffer.append(TEXT_31);
    	}
	List genChildContainers = genNode.getChildContainers();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenChildContainer genChildContainer = (GenChildContainer) genChildContainers.get(j);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(genChildContainer.getGroupID());
    stringBuffer.append(TEXT_33);
    	}
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_35);
    
}

    stringBuffer.append(TEXT_36);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_37);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genChildNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_43);
    	}
}

    stringBuffer.append(TEXT_44);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_45);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_50);
    
		// disable creation of connector views for label links
		List labels = genLink.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			LinkLabel label = (LinkLabel) labels.get(j);

    stringBuffer.append(TEXT_51);
    stringBuffer.append(AccessUtil.getLinkLabelViewName(label));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(AccessUtil.getLinkLabelTextViewName(label));
    stringBuffer.append(TEXT_53);
    		}
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_55);
    
	}
}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_59);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedNodeInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_60);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(qualifiedNodeInterfaceName));
    stringBuffer.append(TEXT_63);
    
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedChildNodeInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_64);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(qualifiedChildNodeInterfaceName));
    stringBuffer.append(TEXT_67);
    	}
}

    stringBuffer.append(TEXT_68);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_69);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_72);
    
	}
}

    stringBuffer.append(TEXT_73);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_74);
    return stringBuffer.toString();
  }
}
