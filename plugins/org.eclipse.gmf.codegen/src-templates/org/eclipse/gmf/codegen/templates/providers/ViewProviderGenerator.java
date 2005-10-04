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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_4 = ".*;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ViewProvider extends AbstractViewProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {" + NL + "\t\tif (\"";
  protected final String TEXT_6 = "\".equals(diagramKind)) { //$NON-NLS-1$" + NL + "\t\t\treturn DiagramViewFactory.class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);";
  protected final String TEXT_8 = NL + "\t\tif (";
  protected final String TEXT_9 = ".eINSTANCE.get";
  protected final String TEXT_10 = "().equals(semanticType)) {";
  protected final String TEXT_11 = NL + "\t\t\tif (";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\tif (\"";
  protected final String TEXT_15 = "\".equals(semanticHint)) {" + NL + "\t\t\t\treturn ListCompartmentViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\treturn ";
  protected final String TEXT_17 = ".class;" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\tif (";
  protected final String TEXT_19 = ".eINSTANCE.get";
  protected final String TEXT_20 = "().equals(semanticType)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_21 = ".class;" + NL + "\t\t}";
  protected final String TEXT_22 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);";
  protected final String TEXT_23 = NL + "\t\tif (";
  protected final String TEXT_24 = ".eINSTANCE.get";
  protected final String TEXT_25 = "().equals(semanticType)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_26 = ".class;" + NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_28 = NL;

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
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_7);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_10);
    
	if (genNode.hasNameToEdit()) {
		String semanticHintsQualifiedClassName = genDiagram.getEditProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genNode));
    stringBuffer.append(TEXT_13);
    	}
	List genChildContainers = genNode.getChildContainers();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenChildContainer genChildContainer = (GenChildContainer) genChildContainers.get(j);

    stringBuffer.append(TEXT_14);
    stringBuffer.append(genChildContainer.getGroupID());
    stringBuffer.append(TEXT_15);
    	}
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_17);
    
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genChildNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_21);
    	}
}

    stringBuffer.append(TEXT_22);
    
List genLinks = genDiagram.getLinks();
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_23);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genLink.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_26);
    
	}
}

    stringBuffer.append(TEXT_27);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
