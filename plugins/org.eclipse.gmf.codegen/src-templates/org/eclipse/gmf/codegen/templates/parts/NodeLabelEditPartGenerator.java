package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class NodeLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized NodeLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeLabelEditPartGenerator result = new NodeLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import ";
  protected final String TEXT_4 = ".StructuralFeatureParser;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends TextCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t\tsetNumIcons(1);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Image getLabelIcon(int index) {" + NL + "\t\tImageDescriptor descriptor = ";
  protected final String TEXT_8 = ".getInstance().getItemImageDescriptor(resolveSemanticElement());" + NL + "\t\tif (descriptor == null) {" + NL + "\t\t\tdescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t}" + NL + "\t\treturn descriptor.createImage();" + NL + "\t}";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParser getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tparser = new StructuralFeatureParser(";
  protected final String TEXT_10 = ".eINSTANCE.get";
  protected final String TEXT_11 = "().getEStructuralFeature(\"";
  protected final String TEXT_12 = "\"));" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}" + NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNodeLabel label = (GenNodeLabel) argument;
GenDiagram genDiagram = label.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
String accessorName = label.getNode().getDomainMetaClass().getClassifierAccessorName();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(label.getMetaFeature().getName());
    stringBuffer.append(TEXT_12);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
