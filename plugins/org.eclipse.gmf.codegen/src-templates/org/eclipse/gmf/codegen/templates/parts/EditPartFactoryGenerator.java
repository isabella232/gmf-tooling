package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
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
  protected final String TEXT_3 = NL + "import java.util.Collection;" + NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.draw2d.ConnectionLocator;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.Node;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_4 = ".StructuralFeatureParser;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tif (model instanceof Diagram) {" + NL + "\t\t\t\treturn createDiagramEditPart((Diagram) model);" + NL + "\t\t\t} else if (view instanceof Node) {" + NL + "\t\t\t\tif (view.eContainer() instanceof Diagram || (view.getType() != null && view.getType().length() > 0)) {" + NL + "\t\t\t\t\treturn createNodeEditPart((Node) model);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\treturn createChildNodeEditPart((Node) model);" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (view instanceof Edge) {" + NL + "\t\t\t\treturn createEdgeEditPart((Edge) model);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createDiagramEditPart(Diagram diagram) {" + NL + "\t\tEObject element = diagram.getElement();" + NL + "\t\tif (";
  protected final String TEXT_8 = ".INSTANCE.getDiagramVisualID(element) != -1) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_9 = "(diagram);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createNodeEditPart(Node node) {" + NL + "\t\tEditPart linkLabelEditPart = createLinkLabelEditPart(node);" + NL + "\t\tif (linkLabelEditPart != null) {" + NL + "\t\t\treturn linkLabelEditPart;" + NL + "\t\t}" + NL + "\t\tfinal EObject element = node.getElement();" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_10 = ".INSTANCE.getNodeVisualID(element);" + NL + "\t\t" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_11 = NL + "\t\tcase ";
  protected final String TEXT_12 = ":";
  protected final String TEXT_13 = NL + "\t\t\tif (";
  protected final String TEXT_14 = ".equals(node.getType())) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_15 = "(node);" + NL + "\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\tif (";
  protected final String TEXT_17 = ".equals(node.getType())) {" + NL + "\t\t\t\treturn new ListCompartmentEditPart(node) {" + NL + "" + NL + "\t\t\t\t\tprotected boolean hasModelChildrenChanged(Notification evt) {" + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprotected void createDefaultEditPolicies() {" + NL + "\t\t\t\t\t\tsuper.createDefaultEditPolicies();" + NL + "\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());" + NL + "\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());" + NL + "\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CanonicalEditPolicy() {" + NL + "\t\t\t\t\t\t\tprotected List getSemanticChildrenList() {" + NL + "\t\t\t\t\t\t\t\tList result = new LinkedList();";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\t\tresult.";
  protected final String TEXT_19 = "(((";
  protected final String TEXT_20 = ") element).";
  protected final String TEXT_21 = "());";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t\t\tCollection featureValues = ((";
  protected final String TEXT_23 = ") element).";
  protected final String TEXT_24 = "();" + NL + "\t\t\t\t\t\t\t\tfor (Iterator it = featureValues.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\t\t\t\t\tEObject nextValue = (EObject) it.next();";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\t\t\tEObject nextValue = (EObject) ((";
  protected final String TEXT_26 = ") element).";
  protected final String TEXT_27 = "();";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\t\tEClass nextEClass = nextValue.eClass();";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t\t\tif (";
  protected final String TEXT_30 = ".eINSTANCE.get";
  protected final String TEXT_31 = "().equals(nextEClass)) {" + NL + "\t\t\t\t\t\t\t\t\tresult.add(nextValue);" + NL + "\t\t\t\t\t\t\t\t} ";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t\t//installEditPolicy(EditPolicy.NODE_ROLE, null);" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprotected String getTitleName() {" + NL + "\t\t\t\t\t\treturn \"";
  protected final String TEXT_34 = "\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}";
  protected final String TEXT_35 = NL + "\t\t\treturn new ";
  protected final String TEXT_36 = "(node);";
  protected final String TEXT_37 = NL + "\t\t}" + NL + "\t\treturn createUnrecognizedNodeEditPart(node);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createLinkLabelEditPart(Node node) {";
  protected final String TEXT_38 = NL + "\t\tEObject element = node.getElement();" + NL + "\t\tint linkVID = ";
  protected final String TEXT_39 = ".INSTANCE.getLinkWithClassVisualID(element);" + NL + "\t\t" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_40 = NL + "\t\tcase ";
  protected final String TEXT_41 = ":";
  protected final String TEXT_42 = NL + "\t\t\tif (";
  protected final String TEXT_43 = ".equals(node.getType())) {" + NL + "\t\t\t\treturn new LabelEditPart(node) {" + NL + "" + NL + "\t\t\t\t\tpublic int getKeyPoint() {" + NL + "\t\t\t\t\t\treturn ConnectionLocator.";
  protected final String TEXT_44 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\t\tif (";
  protected final String TEXT_45 = ".equals(node.getType())) {" + NL + "\t\t\t\treturn new TextCompartmentEditPart(node) {" + NL + "" + NL + "\t\t\t\t\tpublic IParser getParser() {" + NL + "\t\t\t\t\t\tif (parser == null) {" + NL + "\t\t\t\t\t\t\tparser = new StructuralFeatureParser(";
  protected final String TEXT_46 = ".eINSTANCE.get";
  protected final String TEXT_47 = "().getEStructuralFeature(\"";
  protected final String TEXT_48 = "\"));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn parser;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}";
  protected final String TEXT_49 = NL + "\t\t\treturn null;";
  protected final String TEXT_50 = NL + "\t\t}";
  protected final String TEXT_51 = "\t\t\t\t" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createUnrecognizedNodeEditPart(Node node) {" + NL + "\t\t// Handle creation of unrecognized node EditParts here" + NL + "\t \treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createChildNodeEditPart(Node node) {" + NL + "\t\tEObject element = node.getElement();" + NL + "\t\tint nodeVID = ";
  protected final String TEXT_52 = ".INSTANCE.getChildNodeVisualID(element);" + NL + "\t\t" + NL + "\t\tswitch (nodeVID) {";
  protected final String TEXT_53 = NL + "\t\tcase ";
  protected final String TEXT_54 = ":" + NL + "\t\t\treturn new ";
  protected final String TEXT_55 = "(node);";
  protected final String TEXT_56 = NL + "\t\t} " + NL + "\t\treturn createUnrecognizedChildNodeEditPart(node);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedChildNodeEditPart(Node node) {" + NL + "\t \t// Handle creation of unrecognized child node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createEdgeEditPart(Edge edge) {";
  protected final String TEXT_57 = NL + "\t\tEObject element = edge.getElement();" + NL + "\t\tif (element == null) {";
  protected final String TEXT_58 = NL + "\t\t\tif (";
  protected final String TEXT_59 = ".VIEW_TYPE.equals(edge.getType())) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_60 = "(edge);" + NL + "\t\t\t}";
  protected final String TEXT_61 = NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tint linkVID = ";
  protected final String TEXT_62 = ".INSTANCE.getLinkWithClassVisualID(element);" + NL + "\t\t" + NL + "\t\tswitch (linkVID) {";
  protected final String TEXT_63 = NL + "\t\tcase ";
  protected final String TEXT_64 = ":" + NL + "\t\t\treturn new ";
  protected final String TEXT_65 = "(edge);";
  protected final String TEXT_66 = NL + "\t\t}";
  protected final String TEXT_67 = NL + "\t\treturn createUnrecognizedEdgeEditPart(edge);\t\t\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedEdgeEditPart(Edge edge) {" + NL + "\t \t// Handle creation of unrecognized edge EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "}";
  protected final String TEXT_68 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_6);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
List genNodes = genDiagram.getNodes();
List genLinks = genDiagram.getLinks();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_10);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String modelElementInterfaceName = importManager.getImportedName(genNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_11);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_12);
    
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
	List labels = genNode.getLabels();
	for (int j = 0; j < labels.size(); j++) {
		GenNodeLabel label = (GenNodeLabel) labels.get(j);
		String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_13);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_15);
    
	}
	List genCompartments = genNode.getCompartments();
	for (int j = 0; j < genCompartments.size(); j++) {
		GenCompartment genCompartment = (GenCompartment) genCompartments.get(j);
		String compartmentId = semanticHintsClassName + ".Compartments." + AccessUtil.getCompartmentId(genCompartment);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_17);
    
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

    stringBuffer.append(TEXT_18);
    stringBuffer.append(nextFeature.isListType() ? "addAll" : "add");
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_21);
    
				continue;
			}
			
			if (nextFeature.isListType()) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_24);
    
			} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_27);
    
			}

    stringBuffer.append(TEXT_28);
    			
			for (Iterator childNodesIterator = childNodes.iterator(); childNodesIterator.hasNext();) {
				GenChildNode nextChildNode = (GenChildNode) childNodesIterator.next();
				GenClass domainMetaclass = nextChildNode.getDomainMetaClass();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(domainMetaclass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(domainMetaclass.getClassifierAccessorName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(childNodesIterator.hasNext() ? "else" : "");
    
			}
			if (nextFeature.isListType()) {

    stringBuffer.append(TEXT_32);
    
			}
		}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(genCompartment.getTitle());
    stringBuffer.append(TEXT_34);
    	}
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_36);
    
}

    stringBuffer.append(TEXT_37);
    if (!genLinks.isEmpty()) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_39);
    
	for (int i = 0; i < genLinks.size(); i++) {
		GenLink genLink = (GenLink) genLinks.get(i);
		String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genLink);
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
			String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();

    stringBuffer.append(TEXT_40);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_41);
    
			List labels = genLink.getLabels();
			for (int j = 0; j < labels.size(); j++) {
				GenLinkLabel label = (GenLinkLabel) labels.get(j);
				String labelViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelId(label);
				String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_42);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(label.getAlignment());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(label.getMetaFeature().getName());
    stringBuffer.append(TEXT_48);
    			}
    stringBuffer.append(TEXT_49);
    
		}
	}

    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_52);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = AccessUtil.getAllChildNodes(genNode);
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);

    stringBuffer.append(TEXT_53);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_55);
    
	}
}

    stringBuffer.append(TEXT_56);
    if (!genLinks.isEmpty()) {
    stringBuffer.append(TEXT_57);
    
	for (int i = 0; i < genLinks.size(); i++) {
		GenLink genLink = (GenLink) genLinks.get(i);
		if (genLink.getModelFacet() instanceof FeatureModelFacet) {
			String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genLink);
			String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);

    stringBuffer.append(TEXT_58);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_60);
    
		}
	}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_62);
    
	for (int i = 0; i < genLinks.size(); i++) {
		GenLink genLink = (GenLink) genLinks.get(i);
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_65);
    
		}
	}

    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_68);
    return stringBuffer.toString();
  }
}
