package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class NodeMetaInfoProviderGenerator
{
  protected static String nl;
  public static synchronized NodeMetaInfoProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeMetaInfoProviderGenerator result = new NodeMetaInfoProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.diagramrt.ChildNode;" + NL + "import org.eclipse.gmf.diagramrt.DiagramNode;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.MetaInfoProviderAdapter;" + NL + "import org.eclipse.gmf.edit.provider.metainfo.NodeMetaInfoProvider;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends MetaInfoProviderAdapter implements NodeMetaInfoProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EStructuralFeature getContainmentFeature(DiagramNode node) {";
  protected final String TEXT_6 = NL + "\t\treturn ";
  protected final String TEXT_7 = ".eINSTANCE.get";
  protected final String TEXT_8 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EStructuralFeature getContainmentFeature(DiagramNode node, ChildNode childNode) {";
  protected final String TEXT_9 = NL + "\t\tif (\"";
  protected final String TEXT_10 = "\".equals(childNode.getGroupID())) {" + NL + "\t\t\treturn ";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "();" + NL + "\t\t}";
  protected final String TEXT_13 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenNode genNode = (GenNode) argument;
    GenDiagram genDiagram = genNode.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genNode.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_5);
    
GenFeature genFeature2 = genDiagram.findGenFeature(genNode.getContainmentMetaFeature());
String metaPackageInterfaceName2 = importManager.getImportedName(genFeature2.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(metaPackageInterfaceName2);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genFeature2.getFeatureAccessorName());
    stringBuffer.append(TEXT_8);
    
for (Iterator it = genNode.getChildNodes().iterator(); it.hasNext();) {
GenChildNode next = (GenChildNode) it.next();
GenFeature genFeature1 = genDiagram.findGenFeature(next.getContainmentMetaFeature());
String metaPackageInterfaceName1 = importManager.getImportedName(genFeature1.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_9);
    stringBuffer.append(next.getGroupID());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(metaPackageInterfaceName1);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genFeature1.getFeatureAccessorName());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
