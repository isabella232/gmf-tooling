package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.util.*;

public class DiagramEditPartGenerator
{
  protected static String nl;
  public static synchronized DiagramEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditPartGenerator result = new DiagramEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EPackage;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends DiagramEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_7 = "CanonicalEditPolicy());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ";
  protected final String TEXT_8 = "CanonicalEditPolicy extends CanonicalConnectionEditPolicy {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected List getSemanticChildrenList() {";
  protected final String TEXT_9 = NL + "\t\t\t";
  protected final String TEXT_10 = " modelElement = (";
  protected final String TEXT_11 = ") ((View) getHost().getModel()).getElement();" + NL + "\t\t\tList result = new LinkedList();";
  protected final String TEXT_12 = NL + "\t\t\tresult.";
  protected final String TEXT_13 = "(modelElement.";
  protected final String TEXT_14 = "());";
  protected final String TEXT_15 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected List getSemanticConnectionsList() {" + NL + "\t\t\tDiagram diagram = (Diagram) getHost().getModel();" + NL + "\t\t\t";
  protected final String TEXT_16 = " modelElement = (";
  protected final String TEXT_17 = ") diagram.getElement();" + NL + "\t\t\tList result = new LinkedList();" + NL + "\t\t\tfor (Iterator diagramElements = modelElement.eContents().iterator(); diagramElements.hasNext();) {" + NL + "\t\t\t\tEObject nextDiagramElement = (EObject) diagramElements.next();" + NL + "\t\t\t\tfor (Iterator childElements = nextDiagramElement.eContents().iterator(); childElements.hasNext();) {" + NL + "\t\t\t\t\tEObject nextChild = (EObject) childElements.next();" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_18 = ".INSTANCE.getLinkWithClassVisualID(nextChild) != -1) {" + NL + "\t\t\t\t\t\tresult.add(nextChild);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject getSourceElement(EObject relationship) {" + NL + "\t\t\treturn relationship.eContainer();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected EObject getTargetElement(EObject relationship) {" + NL + "\t\t\tint vID = ";
  protected final String TEXT_19 = ".INSTANCE.getLinkWithClassVisualID(relationship);" + NL + "\t\t\tswitch (vID) {";
  protected final String TEXT_20 = NL + "\t\t\t\tcase ";
  protected final String TEXT_21 = ":" + NL + "\t\t\t\t\t((";
  protected final String TEXT_22 = ") relationship).";
  protected final String TEXT_23 = "()";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * For now we are skipping links which was generated based on \"GenLinkReferenceOnly\" classes" + NL + "\t\t * since they do not handle any domain model objects inside, so we can not process them using" + NL + "\t\t * CanonicalConnectionEditPolicy class" + NL + "\t\t *" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldIncludeConnection(Edge connector, List children) {" + NL + "\t\t\treturn super.shouldIncludeConnection(connector, children) && connector.getElement() != null;" + NL + "\t\t}" + NL + "\t" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_8);
    
String modelElementInterfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_11);
    
Set containmentFeatures = new LinkedHashSet();
for (Iterator it = genDiagram.getNodes().iterator(); it.hasNext();) {
	GenNode nextGenNode = (GenNode) it.next();
	containmentFeatures.add(nextGenNode.getModelFacet().getContainmentMetaFeature());
}
for (Iterator it = containmentFeatures.iterator(); it.hasNext();) {
	GenFeature nextFeature = (GenFeature) it.next();	

    stringBuffer.append(TEXT_12);
    stringBuffer.append(nextFeature.isListType() ? "addAll" : "add");
    stringBuffer.append(TEXT_13);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_19);
    
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
	GenLink nextGenLink = (GenLink) it.next();
	if (nextGenLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkFacet = (TypeLinkModelFacet) nextGenLink.getModelFacet(); 
		GenFeature nextLinkTargetFeature = typeLinkFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_20);
    stringBuffer.append(nextGenLink.getVisualID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(typeLinkFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(nextLinkTargetFeature.getGetAccessor());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nextLinkTargetFeature.isListType() ? "get(0)" : "");
    stringBuffer.append(TEXT_24);
    
	}
}

    stringBuffer.append(TEXT_25);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
