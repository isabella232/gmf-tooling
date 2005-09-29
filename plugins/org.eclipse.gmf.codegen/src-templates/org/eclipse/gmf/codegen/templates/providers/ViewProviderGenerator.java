package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.emf.common.util.EList;
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
  protected final String TEXT_6 = "\".equals(diagramKind)) { //$NON-NLS-1$" + NL + "\t\t\treturn DiagramViewFactory.class;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\tEClass semanticType = getSemanticEClass(semanticAdapter);";
  protected final String TEXT_7 = NL + "\t\tif (";
  protected final String TEXT_8 = ".eINSTANCE.get";
  protected final String TEXT_9 = "().equals(semanticType)) {";
  protected final String TEXT_10 = NL + "\t\t\tif (";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn BasicNodeViewFactory.class;" + NL + "\t\t\t}";
  protected final String TEXT_13 = NL + "\t\t\treturn ";
  protected final String TEXT_14 = ".class;" + NL + "\t\t}";
  protected final String TEXT_15 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Class getConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEmfGenModel();
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
    
GenPackage genPackage = genDiagram.getEmfGenModel().findGenPackage(genDiagram.getDomainMetaModel());
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
EList genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_9);
    
		if (genNode.hasNameToEdit()) {
			String semanticHintsQualifiedClassName = genDiagram.getEditProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
			String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genNode));
    stringBuffer.append(TEXT_12);
    		}
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genNode.getNotationViewFactoryClassName());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
