package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class CompartmentEditPartGenerator
{
  protected static String nl;
  public static synchronized CompartmentEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CompartmentEditPartGenerator result = new CompartmentEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.Collection;" + NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ListCompartmentEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean hasModelChildrenChanged(Notification evt) {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getTitleName() {" + NL + "\t\treturn \"";
  protected final String TEXT_7 = "\";" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_8 = "CanonicalEditPolicy());" + NL + "\t\t//installEditPolicy(EditPolicy.NODE_ROLE, null);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ";
  protected final String TEXT_9 = "CanonicalEditPolicy extends CanonicalEditPolicy {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected List getSemanticChildrenList() {\t";
  protected final String TEXT_10 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_11 = " modelElement = (";
  protected final String TEXT_12 = ") ((View) getHost().getModel()).getElement();" + NL + "\t\t\tList result = new LinkedList();" + NL;
  protected final String TEXT_13 = NL + "\t\t\tresult.";
  protected final String TEXT_14 = "(((";
  protected final String TEXT_15 = ") modelElement).";
  protected final String TEXT_16 = "());";
  protected final String TEXT_17 = NL + "\t\t\tCollection featureValues = ((";
  protected final String TEXT_18 = ") modelElement).";
  protected final String TEXT_19 = "();" + NL + "\t\t\tfor (Iterator it = featureValues.iterator(); it.hasNext();) {" + NL + "\t\t\t\tEObject nextValue = (EObject) it.next();";
  protected final String TEXT_20 = NL + "\t\t\tEObject nextValue = (EObject) ((";
  protected final String TEXT_21 = ") modelElement).";
  protected final String TEXT_22 = "();";
  protected final String TEXT_23 = NL + "\t\t\tEClass nextEClass = nextValue.eClass();";
  protected final String TEXT_24 = NL + "\t\t\tif (";
  protected final String TEXT_25 = ".eINSTANCE.get";
  protected final String TEXT_26 = "().equals(nextEClass)) {" + NL + "\t\t\t\tresult.add(nextValue);" + NL + "\t\t\t} ";
  protected final String TEXT_27 = NL + "\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenCompartment genCompartment = (GenCompartment) argument;
GenDiagram genDiagram = genCompartment.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genCompartment.getTitle());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genCompartment.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    
GenNode containerNode = genCompartment.getNode();
String modelElementInterfaceName = importManager.getImportedName(containerNode.getModelFacet().getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_12);
    
Map childFeature2NodesMap = new HashMap();
for (Iterator it = genCompartment.getChildNodes().iterator(); it.hasNext();) {
	GenChildNode nextChildNode = (GenChildNode) it.next();
	GenFeature genFeature = nextChildNode.getModelFacet().getChildMetaFeature();
	List genChildNodes; 
	if (!childFeature2NodesMap.containsKey(genFeature)) {
		genChildNodes = new ArrayList();
		childFeature2NodesMap.put(genFeature, genChildNodes);
	} else {
		genChildNodes = (List) childFeature2NodesMap.get(genFeature);
	}

	if (nextChildNode.getDomainMetaClass() == null) {
		genChildNodes.clear();
		genChildNodes.add(nextChildNode);
		continue;
	}
	if (genChildNodes.size() == 1 && ((GenChildNode) genChildNodes.get(0)).getDomainMetaClass() == null) {
		continue;
	}
	genChildNodes.add(nextChildNode);
}
		
for (Iterator it = childFeature2NodesMap.entrySet().iterator(); it.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) it.next();
	GenFeature nextFeature = (GenFeature) nextEntry.getKey();
	List childNodes = (List) nextEntry.getValue();
	if (childNodes.size() == 1 && ((GenChildNode) childNodes.get(0)).getDomainMetaClass() == null) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(nextFeature.isListType() ? "addAll" : "add");
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_16);
    
		continue;
	}
			
	if (nextFeature.isListType()) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_19);
    
	} else {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_22);
    
	}

    stringBuffer.append(TEXT_23);
    			
	for (Iterator childNodesIterator = childNodes.iterator(); childNodesIterator.hasNext();) {
		GenChildNode nextChildNode = (GenChildNode) childNodesIterator.next();
		GenClass domainMetaclass = nextChildNode.getDomainMetaClass();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(domainMetaclass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(domainMetaclass.getClassifierAccessorName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(childNodesIterator.hasNext() ? "else" : "");
    
	}
	if (nextFeature.isListType()) {

    stringBuffer.append(TEXT_27);
    
	}
}

    stringBuffer.append(TEXT_28);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
