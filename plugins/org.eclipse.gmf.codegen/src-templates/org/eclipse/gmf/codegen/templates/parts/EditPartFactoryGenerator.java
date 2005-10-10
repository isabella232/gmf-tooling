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
  protected final String TEXT_3 = NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.Node;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_4 = ".StructuralFeatureParser;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tif (model instanceof Diagram) {" + NL + "\t\t\t\treturn createDiagramEditPart((Diagram) model);" + NL + "\t\t\t} else if (view instanceof Node) {" + NL + "\t\t\t\tboolean isTopLevel = view.eContainer() instanceof Diagram || (view.getType() != null && view.getType().length() > 0);" + NL + "\t\t\t\tif (isTopLevel) {" + NL + "\t\t\t\t\treturn createNodeEditPart((Node) model);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\treturn createChildNodeEditPart((Node) model);" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (view instanceof Edge) {" + NL + "\t\t\t\treturn createEdgeEditPart((Edge) model);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createDiagramEditPart(Diagram diagram) {" + NL + "\t\tEObject element = diagram.getElement();" + NL + "\t\tEClass elementMetaclass = element.eClass();" + NL + "\t\tif (";
  protected final String TEXT_8 = ".eINSTANCE.get";
  protected final String TEXT_9 = "().equals(elementMetaclass) && isDiagram";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = "((";
  protected final String TEXT_12 = ") element)) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_13 = "(diagram);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createNodeEditPart(Node node) {" + NL + "\t\tEObject element = node.getElement();" + NL + "\t\tEClass elementMetaclass = element.eClass();";
  protected final String TEXT_14 = NL + "\t\tif (";
  protected final String TEXT_15 = ".eINSTANCE.get";
  protected final String TEXT_16 = "().equals(elementMetaclass) && isEdge";
  protected final String TEXT_17 = "_";
  protected final String TEXT_18 = "((";
  protected final String TEXT_19 = ") element)) {";
  protected final String TEXT_20 = NL + "\t\t\tif (\"";
  protected final String TEXT_21 = "\".equals(node.getType())) {" + NL + "\t\t\t\treturn new LabelEditPart(node);" + NL + "\t\t\t}" + NL + "\t\t\tif (\"";
  protected final String TEXT_22 = "\".equals(node.getType())) {" + NL + "\t\t\t\treturn new TextCompartmentEditPart(node) {" + NL + "" + NL + "\t\t\t\t\tpublic IParser getParser() {" + NL + "\t\t\t\t\t\tif (parser == null) {" + NL + "\t\t\t\t\t\t\tparser = new StructuralFeatureParser(";
  protected final String TEXT_23 = ".eINSTANCE.get";
  protected final String TEXT_24 = "().getEStructuralFeature(\"";
  protected final String TEXT_25 = "\"));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn parser;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_27 = "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\tif (";
  protected final String TEXT_29 = ".eINSTANCE.get";
  protected final String TEXT_30 = "().equals(elementMetaclass) && isNode";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = "((";
  protected final String TEXT_33 = ") element)) {";
  protected final String TEXT_34 = NL + "\t\t\tif (";
  protected final String TEXT_35 = ".equals(node.getType())) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_36 = "(node);" + NL + "\t\t\t}";
  protected final String TEXT_37 = NL + "\t\t\tif (\"";
  protected final String TEXT_38 = "\".equals(node.getType())) {" + NL + "\t\t\t\treturn new ListCompartmentEditPart(node) {" + NL + "" + NL + "\t\t\t\t\tprotected boolean hasModelChildrenChanged(Notification evt) {" + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprotected void createDefaultEditPolicies() {" + NL + "\t\t\t\t\t\tsuper.createDefaultEditPolicies();" + NL + "\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());" + NL + "\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());" + NL + "\t\t\t\t\t\t//installEditPolicy(EditPolicy.NODE_ROLE, null);" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprotected String getTitleName() {" + NL + "\t\t\t\t\t\treturn \"";
  protected final String TEXT_39 = "\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t}";
  protected final String TEXT_40 = NL + "\t\t\treturn new ";
  protected final String TEXT_41 = "(node);" + NL + "\t\t} else";
  protected final String TEXT_42 = NL + "\t\t{ " + NL + "\t\t\treturn createUnrecognizedNodeEditPart(node);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedNodeEditPart(Node node) {" + NL + "\t \t// Handle creation of unrecognized node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createChildNodeEditPart(Node node) {" + NL + "\t\tEObject element = node.getElement();" + NL + "\t\tEClass elementMetaclass = element.eClass();";
  protected final String TEXT_43 = NL + "\t\tif (";
  protected final String TEXT_44 = ".eINSTANCE.get";
  protected final String TEXT_45 = "().equals(elementMetaclass) && isChildNode";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = "((";
  protected final String TEXT_48 = ") element)) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_49 = "(node);" + NL + "\t\t} else ";
  protected final String TEXT_50 = NL + "\t\t{ " + NL + "\t\t\treturn createUnrecognizedChildNodeEditPart(node);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedChildNodeEditPart(Node node) {" + NL + "\t \t// Handle creation of unrecognized child node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPart createEdgeEditPart(Edge edge) {" + NL + "\t\tEObject element = edge.getElement();" + NL + "\t\tEClass elementMetaclass = element.eClass();";
  protected final String TEXT_51 = NL + "\t\treturn createUnrecognizedEdgeEditPart(edge);";
  protected final String TEXT_52 = NL + "\t\tif (";
  protected final String TEXT_53 = ".eINSTANCE.get";
  protected final String TEXT_54 = "().equals(elementMetaclass) && isEdge";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = "((";
  protected final String TEXT_57 = ") element)) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_58 = "(edge);" + NL + "\t\t} else ";
  protected final String TEXT_59 = NL + "\t\t{" + NL + "\t\t\treturn createUnrecognizedEdgeEditPart(edge);" + NL + "\t\t}";
  protected final String TEXT_60 = "\t\t\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedEdgeEditPart(Edge edge) {" + NL + "\t \t// Handle creation of unrecognized edge EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = "(";
  protected final String TEXT_63 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_64 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_68 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isChildNode";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "(";
  protected final String TEXT_71 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL;
  protected final String TEXT_72 = NL + "\t";
  protected final String TEXT_73 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isEdge";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = " element) {" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_77 = NL + NL + "}";
  protected final String TEXT_78 = NL;

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
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_7);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_13);
    
List genLinks = genDiagram.getLinks();
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_19);
    
		List labels = genLink.getLabels();
		for (int j = 0; j < labels.size(); j++) {
			LinkLabel label = (LinkLabel) labels.get(j);

    stringBuffer.append(TEXT_20);
    stringBuffer.append(AccessUtil.getLinkLabelViewName(label));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(AccessUtil.getLinkLabelTextViewName(label));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label.getDomainMetaFeature().getName());
    stringBuffer.append(TEXT_25);
    		}
    stringBuffer.append(TEXT_26);
    
	}
}

    stringBuffer.append(TEXT_27);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_33);
    
	if (genNode.hasNameToEdit()) {
		String semanticHintsQualifiedClassName = genDiagram.getEditProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
		String semanticHint = semanticHintsClassName + '.' + AccessUtil.getNameSemanticHint(genNode);

    stringBuffer.append(TEXT_34);
    stringBuffer.append(semanticHint);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(AccessUtil.getNodeLabelEditPartClassName(genNode));
    stringBuffer.append(TEXT_36);
    
	}
	List genChildContainers = genNode.getChildContainers();
	for (int j = 0; j < genChildContainers.size(); j++) {
		GenChildContainer genChildContainer = (GenChildContainer) genChildContainers.get(j);

    stringBuffer.append(TEXT_37);
    stringBuffer.append(genChildContainer.getGroupID());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genChildContainer.getTitleKey());
    stringBuffer.append(TEXT_39);
    	}
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_43);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_49);
    	}
}

    stringBuffer.append(TEXT_50);
    
if (genLinks.size() == 0) {

    stringBuffer.append(TEXT_51);
    
} else {
	for (int i = 0; i < genLinks.size(); i++) {
		GenLink genLink = (GenLink) genLinks.get(i);
		if (genLink instanceof GenLinkWithClass) {
			GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
			String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
			String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_52);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_58);
    
		}
	}

    stringBuffer.append(TEXT_59);
    
}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_63);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedNodeInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_64);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(qualifiedNodeInterfaceName));
    stringBuffer.append(TEXT_67);
    
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedChildNodeInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_68);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(qualifiedChildNodeInterfaceName));
    stringBuffer.append(TEXT_71);
    	}
}

    stringBuffer.append(TEXT_72);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genLinkWithClass.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_73);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genLinkWithClass.getVisualID());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_76);
    
	}
}

    stringBuffer.append(TEXT_77);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}
