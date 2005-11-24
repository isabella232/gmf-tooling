package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class NodeEditPartGenerator {
 
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
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.Shape;" + NL + "import org.eclipse.draw2d.StackLayout;" + NL + "import org.eclipse.gef.EditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.RectangularDropShadowLineBorder;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;" + NL + "import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ShapeNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_7 = "());" + NL + "\t\tinstallEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_8 = "());";
  protected final String TEXT_9 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new ";
  protected final String TEXT_10 = "());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ";
  protected final String TEXT_11 = "());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_12 = "());";
  protected final String TEXT_13 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createNodeShape() {";
  protected final String TEXT_14 = NL + "\t\treturn new ";
  protected final String TEXT_15 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateNodeShape(Shape shape) {";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\tshape.setLineStyle(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\tshape.setLineWidth(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodePlate() {";
  protected final String TEXT_23 = NL + "\t\treturn new DefaultSizeNodeFigure(getMapMode().DPtoLP(";
  protected final String TEXT_24 = "), getMapMode().DPtoLP(";
  protected final String TEXT_25 = "));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodeFigure() {" + NL + "\t\tNodeFigure figure = createNodePlate();" + NL + "\t\tfigure.setBorder(new RectangularDropShadowLineBorder(0));" + NL + "\t\tfigure.setLayoutManager(new StackLayout());" + NL + "\t\tIFigure shape = createNodeShape();" + NL + "\t\tif (shape instanceof Shape) {" + NL + "\t\t\tdecorateNodeShape((Shape) shape);" + NL + "\t\t}" + NL + "\t\tfigure.add(shape);" + NL + "\t\taddContentPane(shape);" + NL + "\t\treturn figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addContentPane(IFigure shape) {";
  protected final String TEXT_26 = NL + "\t\tcontentPane = new ";
  protected final String TEXT_27 = "();" + NL + "\t\tshape.setLayoutManager(new StackLayout());" + NL + "\t\tshape.add(contentPane);";
  protected final String TEXT_28 = NL + "\t\tcontentPane = shape;";
  protected final String TEXT_29 = NL + "\t\tConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();" + NL + "\t\tlayout.setSpacing(getMapMode().DPtoLP(5));" + NL + "\t\tcontentPane.setLayoutManager(layout);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_30 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_31 = " getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = "Labels.";
  protected final String TEXT_34 = ");" + NL + "\t}";
  protected final String TEXT_35 = NL + "}";
  protected final String TEXT_36 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".set");
			result.append(feature.getAccessorName());
			result.append("(");
		}
		return result.toString();
	}
 
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
    stringBuffer.append(importManager.getImportedName(genNode.getGraphicalNodeEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    if (!genNode.getChildNodes().isEmpty()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genNode.getCanonicalEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
Viewmap viewmap = genNode.getViewmap();
String figureQualifiedClassName = null;
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
}
if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
	figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    
// Code fragment that sets shape line width and style.
//
// Parameters:
//
// importManager - ImportUtil ref in code
// viewmap - Viewmap ref in code
// shape - draw2d Shape ref in text
//
{ // private namespace
	ShapeAttributes shapeAttrs = viewmap == null ? null : (ShapeAttributes) viewmap.find(ShapeAttributes.class);
	if (shapeAttrs != null) {
		String lineStyle = shapeAttrs.getLineStyle();
		if (lineStyle != null && lineStyle.trim().length() > 0) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Graphics"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(lineStyle);
    stringBuffer.append(TEXT_19);
    
		}
		if (shapeAttrs.isSetLineWidth()) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(shapeAttrs.getLineWidth());
    stringBuffer.append(TEXT_21);
    
		}
	}
} // private namespace

    stringBuffer.append(TEXT_22);
    
int width = 40;
int height = 40;
DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) genNode.getViewmap().find(DefaultSizeAttributes.class);
if (defSizeAttrs != null) {
	width = defSizeAttrs.getWidth();
	height = defSizeAttrs.getHeight();
}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(height);
    stringBuffer.append(TEXT_25);
    if (genNode.isExplicitContentPane()) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Figure"));
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    
if (!genNode.getLabels().isEmpty()) {
	GenNodeLabel primaryLabel = (GenNodeLabel) genNode.getLabels().get(0);
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(semanticHintsClassName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(AccessUtil.getLabelTextId(primaryLabel));
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}