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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ViewProvider extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);" + NL + "\t\tif (\"";
  protected final String TEXT_5 = "\".equals(diagramKind) && isDiagram";
  protected final String TEXT_6 = "_";
  protected final String TEXT_7 = "((";
  protected final String TEXT_8 = ") semanticElement)) { //$NON-NLS-1$" + NL + "\t\t\treturn DiagramViewFactory.class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_10 = NL + "\t\tif (";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "().equals(semanticType) && isConnector";
  protected final String TEXT_13 = "_";
  protected final String TEXT_14 = "((";
  protected final String TEXT_15 = ") semanticElement)) {";
  protected final String TEXT_16 = NL + "\t\t\tif (\"";
  protected final String TEXT_17 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_18 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\tif (\"";
  protected final String TEXT_19 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_20 = NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t\tboolean isTopLevel = containerView instanceof Diagram || (semanticHint != null && semanticHint.length() > 0);" + NL + "\t\tif (isTopLevel) {" + NL + "\t\t\treturn getTopLevelNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\t} else {" + NL + "\t\t\treturn getChildNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getTopLevelNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_22 = NL + "\t\tif (";
  protected final String TEXT_23 = ".eINSTANCE.get";
  protected final String TEXT_24 = "().equals(semanticType) && isNode";
  protected final String TEXT_25 = "_";
  protected final String TEXT_26 = "((";
  protected final String TEXT_27 = ") semanticElement)) {";
  protected final String TEXT_28 = NL + "\t\t\tif (";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_31 = NL + "\t\t\tif (\"";
  protected final String TEXT_32 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn ListCompartmentViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_33 = NL + "\t\t\treturn ";
  protected final String TEXT_34 = ".class;" + NL + "\t\t}";
  protected final String TEXT_35 = NL + "\t\treturn getUnrecognizedTopLevelNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedTopLevelNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Class getChildNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_36 = NL + "\t\tif (";
  protected final String TEXT_37 = ".eINSTANCE.get";
  protected final String TEXT_38 = "().equals(semanticType) && isChildNode";
  protected final String TEXT_39 = "_";
  protected final String TEXT_40 = "((";
  protected final String TEXT_41 = ") semanticElement)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_42 = ".class;" + NL + "\t\t}";
  protected final String TEXT_43 = NL + "\t\treturn getUnrecognizedChildNodeViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedChildNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);" + NL + "\t\tEObject semanticElement = getSemanticElement(semanticAdapter);";
  protected final String TEXT_44 = NL + "\t\tif (";
  protected final String TEXT_45 = ".eINSTANCE.get";
  protected final String TEXT_46 = "().equals(semanticType) && isConnector";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = "((";
  protected final String TEXT_49 = ") semanticElement)) {";
  protected final String TEXT_50 = NL + "\t\t\tif (\"";
  protected final String TEXT_51 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tif (\"";
  protected final String TEXT_52 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}";
  protected final String TEXT_53 = NL + "\t\t\treturn ";
  protected final String TEXT_54 = ".class;" + NL + "\t\t}";
  protected final String TEXT_55 = NL + "\t\treturn getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t \t// Handle unrecognized child node classes here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_59 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = "(";
  protected final String TEXT_62 = " element) {" + NL + "\t\treturn element == null || ";
  protected final String TEXT_63 = "(element);" + NL + "\t}" + NL;
  protected final String TEXT_64 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isChildNode";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = " element) {" + NL + "\t\treturn element == null || ";
  protected final String TEXT_68 = "(element);" + NL + "\t}" + NL;
  protected final String TEXT_69 = NL + "\t";
  protected final String TEXT_70 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isConnector";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = "(";
  protected final String TEXT_73 = " element) {" + NL + "\t\treturn element == null || ";
  protected final String TEXT_74 = "(element);" + NL + "\t}";
  protected final String TEXT_75 = NL + "\t" + NL + "}";
  protected final String TEXT_76 = NL;

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
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_8);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_9);
    
List genLinks = genDiagram.getLinks();
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_15);
    
		List labels = genLink.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			LinkLabel label = (LinkLabel) labels.get(j);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(AccessUtil.getLinkLabelViewName(label));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(AccessUtil.getLinkLabelViewFactoryClassName(label));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(AccessUtil.getLinkLabelTextViewName(label));
    stringBuffer.append(TEXT_19);
    		}
    stringBuffer.append(TEXT_20);
    
	}
}

    stringBuffer.append(TEXT_21);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_22);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_27);
    
	if (genNode.hasNameToEdit()) {
		String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);

    stringBuffer.append(TEXT_28);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genNode));
    stringBuffer.append(TEXT_30);
    	}
	List genChildContainers = genNode.getChildContainers();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenChildContainer genChildContainer = (GenChildContainer) genChildContainers.get(j);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(genChildContainer.getGroupID());
    stringBuffer.append(TEXT_32);
    	}
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_34);
    
}

    stringBuffer.append(TEXT_35);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_36);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genChildNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_42);
    	}
}

    stringBuffer.append(TEXT_43);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_44);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_49);
    
		// disable creation of connector views for label links
		List labels = genLink.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			LinkLabel label = (LinkLabel) labels.get(j);

    stringBuffer.append(TEXT_50);
    stringBuffer.append(AccessUtil.getLinkLabelViewName(label));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(AccessUtil.getLinkLabelTextViewName(label));
    stringBuffer.append(TEXT_52);
    		}
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_54);
    
	}
}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_58);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedNodeInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_59);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(qualifiedNodeInterfaceName));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(PartSelectorUtil.getPartSelectorsFullClassName(genDiagram)) + "." + PartSelectorUtil.getPartSelectorMethodName(genNode));
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
    stringBuffer.append(importManager.getImportedName(PartSelectorUtil.getPartSelectorsFullClassName(genDiagram)) + "." + PartSelectorUtil.getPartSelectorMethodName(genChildNode));
    stringBuffer.append(TEXT_68);
    	}
}

    stringBuffer.append(TEXT_69);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_70);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(PartSelectorUtil.getPartSelectorsFullClassName(genDiagram)) + "." + PartSelectorUtil.getPartSelectorMethodName(genLinkWithClass));
    stringBuffer.append(TEXT_74);
    
	}
}

    stringBuffer.append(TEXT_75);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_76);
    return stringBuffer.toString();
  }
}
