package org.eclipse.gmf.codegen.templates.parts;

import java.util.List;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.util.*;

public class EditPartFactoryGenerator
{
  protected static String nl;
  public static synchronized EditPartFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditPartFactoryGenerator result = new EditPartFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_4 = ".StructuralFeatureParser;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tEObject element = view.getElement();";
  protected final String TEXT_7 = NL + "\t\t\tif (";
  protected final String TEXT_8 = ".eINSTANCE.get";
  protected final String TEXT_9 = "().isInstance(element)) {" + NL + "\t\t\t\treturn new DiagramEditPart(view);" + NL + "\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\telse if (";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "().isInstance(element)) {";
  protected final String TEXT_13 = NL + "\t\t\t\tif (";
  protected final String TEXT_14 = ".equals(view.getType())) {" + NL + "\t\t\t\t\treturn new TextCompartmentEditPart(view) {" + NL + "" + NL + "\t\t\t\t\t\tpublic IParser getParser() {" + NL + "\t\t\t\t\t\t\tif (parser == null) {" + NL + "\t\t\t\t\t\t\t\tif (";
  protected final String TEXT_15 = ".equals(((View) getModel()).getType())) {" + NL + "\t\t\t\t\t\t\t\t\tparser = new StructuralFeatureParser(";
  protected final String TEXT_16 = ".eINSTANCE.get";
  protected final String TEXT_17 = "().getEStructuralFeature(\"";
  protected final String TEXT_18 = "\"));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treturn parser;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t};" + NL + "\t\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_20 = "(view);" + NL + "\t\t\t}";
  protected final String TEXT_21 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_22 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_6);
    
GenPackage genPackage = genDiagram.getEmfGenModel().findGenPackage(genDiagram.getDomainMetaModel());
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_7);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getName());
    stringBuffer.append(TEXT_9);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
		GenNode genNode = (GenNode) genNodes.get(i);
		String semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_12);
    
		if (genNode.hasNameToEdit()) {
			String semanticHintsQualifiedClassName = genDiagram.getEditProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
			String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
			String semanticHint = semanticHintsClassName + '.' + AccessUtil.getNameSemanticHint(genNode);

    stringBuffer.append(TEXT_13);
    stringBuffer.append(semanticHint);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(semanticHint);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genNode.getDomainNameFeature().getName());
    stringBuffer.append(TEXT_18);
    		}
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
