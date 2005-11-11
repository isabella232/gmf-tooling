package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class DiagramItemSemanticEditPolicyGenerator
{
  protected static String nl;
  public static synchronized DiagramItemSemanticEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramItemSemanticEditPolicyGenerator result = new DiagramItemSemanticEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ".ElementTypes;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLCreateElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateCommand(CreateElementRequest req) {";
  protected final String TEXT_9 = NL + "\t\tif (ElementTypes.";
  protected final String TEXT_10 = " == req.getElementType()) {" + NL + "\t\t\tif (req.getContainmentFeature() == null) {" + NL + "\t\t\t\treq.setContainmentFeature(";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "());" + NL + "\t\t\t}" + NL + "\t\t\treturn getMSLWrapper(new Create";
  protected final String TEXT_13 = "Command(req));" + NL + "\t\t}";
  protected final String TEXT_14 = NL + "\t\treturn super.getCreateCommand(req);" + NL + "\t}";
  protected final String TEXT_15 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Create";
  protected final String TEXT_16 = "Command extends MSLCreateElementCommand {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Create";
  protected final String TEXT_17 = "Command(CreateElementRequest req) {" + NL + "\t\t\tsuper(req);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EClass getEClassToEdit() {" + NL + "\t\t\treturn ";
  protected final String TEXT_18 = ".eINSTANCE.get";
  protected final String TEXT_19 = "();" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject getElementToEdit() {" + NL + "\t\t\tEObject container = ((CreateElementRequest) getRequest()).getContainer();" + NL + "\t\t\tif (container instanceof View) {" + NL + "\t\t\t\tcontainer = ((View) container).getElement();" + NL + "\t\t\t}" + NL + "\t\t\treturn container;" + NL + "\t\t}";
  protected final String TEXT_20 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject doDefaultElementCreation() {";
  protected final String TEXT_21 = NL + "\t\t\t";
  protected final String TEXT_22 = " newElement = (";
  protected final String TEXT_23 = ") super.doDefaultElementCreation();" + NL + "\t\t\tif (newElement != null) {" + NL + "\t\t\t\tElementTypes.Initializers.";
  protected final String TEXT_24 = ".init(newElement);" + NL + "\t\t\t}" + NL + "\t\t\treturn newElement;" + NL + "\t\t}";
  protected final String TEXT_25 = NL + "\t}";
  protected final String TEXT_26 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDuplicateCommand(DuplicateElementsRequest req) {" + NL + "\t\treturn getMSLWrapper(new DuplicateAnythingCommand(req));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic DuplicateAnythingCommand(DuplicateElementsRequest req) {" + NL + "\t\t\tsuper(req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_8);
    
for (Iterator nodes = genDiagram.getNodes().iterator(); nodes.hasNext(); ) {
	GenNode genNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genNode.getModelFacet();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelFacet.getContainmentMetaFeature().getFeatureAccessorName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
for (Iterator nodes = genDiagram.getNodes().iterator(); nodes.hasNext(); ) {
	GenNode genNode = (GenNode) nodes.next();
	TypeModelFacet modelFacet = genNode.getModelFacet();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelFacet.getMetaClass().getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_19);
    	if (modelFacet.getModelElementInitializer() != null) { 
    stringBuffer.append(TEXT_20);
    		String metaClassName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(metaClassName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    	}
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
