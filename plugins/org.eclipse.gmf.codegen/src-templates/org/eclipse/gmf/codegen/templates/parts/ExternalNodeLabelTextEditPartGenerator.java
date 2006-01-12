package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ExternalNodeLabelTextEditPartGenerator
{
  protected static String nl;
  public static synchronized ExternalNodeLabelTextEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ExternalNodeLabelTextEditPartGenerator result = new ExternalNodeLabelTextEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends TextCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParser getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tparser = new ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = ".eINSTANCE.get";
  protected final String TEXT_10 = "().getEStructuralFeature(\"";
  protected final String TEXT_11 = "\"));" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {" + NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_13 = NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenExternalNodeLabel genLabel = (GenExternalNodeLabel) argument;
GenDiagram genDiagram = genLabel.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_6);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
String accessorName = genLabel.getNode().getDomainMetaClass().getClassifierAccessorName();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genLabel.getMetaFeature().getName());
    stringBuffer.append(TEXT_11);
    if (genLabel.isReadOnly()) {
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
