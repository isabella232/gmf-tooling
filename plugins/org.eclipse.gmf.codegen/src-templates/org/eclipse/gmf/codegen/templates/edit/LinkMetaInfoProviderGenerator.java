package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class LinkMetaInfoProviderGenerator
{
  protected static String nl;
  public static synchronized LinkMetaInfoProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkMetaInfoProviderGenerator result = new LinkMetaInfoProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.emf.ecore.EReference;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.diagramrt.DiagramLink;" + NL + "import org.eclipse.gmf.edit.provider.LinkMetaInfoProvider;" + NL + "import org.eclipse.gmf.edit.provider.MetaInfoProviderAdapter;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends MetaInfoProviderAdapter implements LinkMetaInfoProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EStructuralFeature getTargetFeature(DiagramLink diagramLink) {";
  protected final String TEXT_6 = NL + "\t\treturn ";
  protected final String TEXT_7 = ".eINSTANCE.get";
  protected final String TEXT_8 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EReference getContainmentFeature(DiagramLink diagramLink) {";
  protected final String TEXT_9 = NL + "\t\treturn null;";
  protected final String TEXT_10 = NL + "\t\treturn ";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "();";
  protected final String TEXT_13 = NL + "\t}" + NL + "}";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenLink genLink = (GenLink) argument;
    GenDiagram genDiagram = genLink.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLink.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_5);
    
GenFeature genFeature1 = genDiagram.findGenFeature(genLink.getDomainLinkTargetFeature());
String metaPackageInterfaceName1 = importManager.getImportedName(genFeature1.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(metaPackageInterfaceName1);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genFeature1.getFeatureAccessorName());
    stringBuffer.append(TEXT_8);
    
if (genLink.getContainmentMetaFeature() == null) {
    stringBuffer.append(TEXT_9);
    } else {
GenFeature genFeature2 = genDiagram.findGenFeature(genLink.getContainmentMetaFeature());
String metaPackageInterfaceName2 = importManager.getImportedName(genFeature2.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_10);
    stringBuffer.append(metaPackageInterfaceName2);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genFeature2.getFeatureAccessorName());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
