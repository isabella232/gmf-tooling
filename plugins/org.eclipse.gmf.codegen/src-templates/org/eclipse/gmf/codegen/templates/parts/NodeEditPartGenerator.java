package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;
import java.util.*;

public class NodeEditPartGenerator
{
  protected static String nl;
  public static synchronized NodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeEditPartGenerator result = new NodeEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.Figure;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.StackLayout;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ShapeNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_7 = "());";
  protected final String TEXT_8 = "\t\t" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new ";
  protected final String TEXT_9 = "());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ";
  protected final String TEXT_10 = "());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_11 = "CanonicalEditPolicy());";
  protected final String TEXT_12 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodeFigure() {";
  protected final String TEXT_13 = " " + NL + "\t\t";
  protected final String TEXT_14 = " node = new ";
  protected final String TEXT_15 = "() {" + NL + "" + NL + "\t\t\tprotected void paintFigure(Graphics graphics) {" + NL + "\t\t\t\tsuper.paintFigure(graphics);" + NL + "\t\t\t\tgraphics.fillRectangle(getClientArea());" + NL + "\t\t\t\tgraphics.drawRectangle(getClientArea());" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = ".setLineStyle(Graphics.";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = ".setLineWidth(attrs.getLineWidth());";
  protected final String TEXT_22 = NL + "\t\tnode.setDefaultSize(getMapMode().DPtoLP(";
  protected final String TEXT_23 = "), getMapMode().DPtoLP(";
  protected final String TEXT_24 = "));";
  protected final String TEXT_25 = NL + "\t\tnode.setLayoutManager(new StackLayout());" + NL + "\t\tnode.add(contentPane = createContentPane());" + NL + "\t\treturn node;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createContentPane() {" + NL + "\t\tIFigure plate = new Figure();" + NL + "\t\tConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();" + NL + "\t\tlayout.setSpacing(getMapMode().DPtoLP(5));" + NL + "\t\tplate.setLayoutManager(layout);" + NL + "\t\treturn plate;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_26 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = "Labels.";
  protected final String TEXT_29 = ");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ";
  protected final String TEXT_32 = "CanonicalEditPolicy extends ";
  protected final String TEXT_33 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_34 = " getSemanticChildrenList() {\t";
  protected final String TEXT_35 = "\t\t" + NL + "\t\t\t";
  protected final String TEXT_36 = " modelElement = (";
  protected final String TEXT_37 = ") ((View) getHost().getModel()).getElement();" + NL + "\t\t\tList result = new ";
  protected final String TEXT_38 = "();" + NL;
  protected final String TEXT_39 = NL + "\t\t\tresult.";
  protected final String TEXT_40 = "(((";
  protected final String TEXT_41 = ") modelElement).";
  protected final String TEXT_42 = "());";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = " featureValues = ((";
  protected final String TEXT_45 = ") modelElement).";
  protected final String TEXT_46 = "();" + NL + "\t\t\tfor (";
  protected final String TEXT_47 = " it = featureValues.iterator(); it.hasNext();) {" + NL + "\t\t\t\t";
  protected final String TEXT_48 = " nextValue = (";
  protected final String TEXT_49 = ") it.next();";
  protected final String TEXT_50 = NL + "\t\t\t";
  protected final String TEXT_51 = " nextValue = (";
  protected final String TEXT_52 = ") ((";
  protected final String TEXT_53 = ") modelElement).";
  protected final String TEXT_54 = "();";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = " nextEClass = nextValue.eClass();";
  protected final String TEXT_57 = NL + "\t\t\tif (";
  protected final String TEXT_58 = ".eINSTANCE.get";
  protected final String TEXT_59 = "().equals(nextEClass)) {" + NL + "\t\t\t\tresult.add(nextValue);" + NL + "\t\t\t} ";
  protected final String TEXT_60 = NL + "\t\t\t}";
  protected final String TEXT_61 = NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}\t";
  protected final String TEXT_62 = NL + "}";
  protected final String TEXT_63 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenNode genNode = (GenNode) argument;
GenDiagram genDiagram = genNode.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genNode.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
if (genNode.getChildNodes().size() > 0) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    
String figureClassName;
if (genNode.getViewmap() instanceof FigureViewmap) {
	figureClassName = importManager.getImportedName(((FigureViewmap) genNode.getViewmap()).getFigureQualifiedClassName());
} else {
	figureClassName = importManager.getImportedName("org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure");
}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(figureClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(figureClassName);
    stringBuffer.append(TEXT_15);
    
for (Iterator it = genNode.getViewmap().getAttributes().iterator(); it.hasNext();) {
	Attributes next = (Attributes) it.next();
	if (next instanceof ShapeAttributes) {
		String figureVarName = "node";
		ShapeAttributes attrs = (ShapeAttributes) next;

    stringBuffer.append(TEXT_16);
    
String lineStyle = attrs.getLineStyle();
if (lineStyle != null && lineStyle.trim().length() > 0) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(lineStyle);
    stringBuffer.append(TEXT_19);
    
}
if (attrs.isSetLineWidth()) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_21);
    }
    	}
	if (next instanceof DefaultSizeAttributes) {
		DefaultSizeAttributes attrs = (DefaultSizeAttributes) next;

    stringBuffer.append(TEXT_22);
    stringBuffer.append(attrs.getWidth());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(attrs.getHeight());
    stringBuffer.append(TEXT_24);
    
	}
}

    stringBuffer.append(TEXT_25);
    
if (!genNode.getLabels().isEmpty()) {
	GenNodeLabel primaryLabel = (GenNodeLabel) genNode.getLabels().get(0);
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());

    stringBuffer.append(TEXT_26);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(AccessUtil.getLabelTextId(primaryLabel));
    stringBuffer.append(TEXT_29);
    
}

if (genNode.getChildNodes().size() > 0) {
	GenChildContainer childContainer = genNode;
	GenNode containerNode = genNode;

    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(childContainer.getEditPartClassName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_34);
    
String modelElementInterfaceName = importManager.getImportedName(containerNode.getModelFacet().getMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_38);
    
Map childFeature2NodesMap = new HashMap();
for (Iterator it = childContainer.getChildNodes().iterator(); it.hasNext();) {
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

    stringBuffer.append(TEXT_39);
    stringBuffer.append(nextFeature.isListType() ? "addAll" : "add");
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_42);
    
		continue;
	}
			
	if (nextFeature.isListType()) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_49);
    
	} else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(nextFeature.getGetAccessor());
    stringBuffer.append(TEXT_54);
    
	}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_56);
    			
	for (Iterator childNodesIterator = childNodes.iterator(); childNodesIterator.hasNext();) {
		GenChildNode nextChildNode = (GenChildNode) childNodesIterator.next();
		GenClass domainMetaclass = nextChildNode.getDomainMetaClass();

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(domainMetaclass.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(domainMetaclass.getClassifierAccessorName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(childNodesIterator.hasNext() ? "else" : "");
    
	}
	if (nextFeature.isListType()) {

    stringBuffer.append(TEXT_60);
    
	}
}

    stringBuffer.append(TEXT_61);
    
}

    stringBuffer.append(TEXT_62);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
