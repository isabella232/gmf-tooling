package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class LinkEditPartGenerator
{
  protected static String nl;
  public static synchronized LinkEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkEditPartGenerator result = new LinkEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.Connection;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.PolylineConnection;" + NL + "import org.eclipse.draw2d.RotatableDecoration;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ConnectionNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();";
  protected final String TEXT_7 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_8 = ".CONNECTION_ROLE, new ";
  protected final String TEXT_9 = "());";
  protected final String TEXT_10 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_11 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PolylineConnection createConnectionShape() {";
  protected final String TEXT_12 = NL + "\t\treturn new ";
  protected final String TEXT_13 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateConnectionShape(PolylineConnection shape) {";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "\tshape.setLineStyle(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tshape.setLineWidth(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\tRotatableDecoration sourceDecoration = createSourceDecoration();" + NL + "\t\tif (sourceDecoration != null) {" + NL + "\t\t\tshape.setSourceDecoration(sourceDecoration);" + NL + "\t\t}" + NL + "\t\tRotatableDecoration targetDecoration = createTargetDecoration();" + NL + "\t\tif (targetDecoration != null) {" + NL + "\t\t\tshape.setTargetDecoration(targetDecoration);" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Connection createConnectionFigure() {" + NL + "\t\tPolylineConnection shape = createConnectionShape();" + NL + "\t\tdecorateConnectionShape(shape);" + NL + "\t\treturn shape;" + NL + "\t}" + NL;
  protected final String TEXT_22 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected RotatableDecoration createSourceDecoration() {";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL + "\t";
  protected final String TEXT_25 = " decoration = new ";
  protected final String TEXT_26 = "();" + NL + "\tdecoration.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));" + NL + "\treturn decoration;";
  protected final String TEXT_27 = NL + "\treturn new ";
  protected final String TEXT_28 = "();";
  protected final String TEXT_29 = NL + "\treturn null;";
  protected final String TEXT_30 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected RotatableDecoration createTargetDecoration() {";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "\t";
  protected final String TEXT_33 = " decoration = new ";
  protected final String TEXT_34 = "();" + NL + "\tdecoration.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));" + NL + "\treturn decoration;";
  protected final String TEXT_35 = NL + "\treturn new ";
  protected final String TEXT_36 = "();";
  protected final String TEXT_37 = NL + "\treturn null;";
  protected final String TEXT_38 = NL + "\t}";
  protected final String TEXT_39 = NL + "}";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenLink genLink = (GenLink) argument;
GenDiagram genDiagram = genLink.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    if (genLink.getModelFacet() instanceof FeatureModelFacet) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getReferenceConnectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genLink.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    
Viewmap viewmap = genLink.getViewmap();
String figureQualifiedClassName = null;
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
}
if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
	figureQualifiedClassName = "org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx";
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    
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

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Graphics"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(lineStyle);
    stringBuffer.append(TEXT_17);
    
		}
		if (shapeAttrs.isSetLineWidth()) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(shapeAttrs.getLineWidth());
    stringBuffer.append(TEXT_19);
    
		}
	}
} // private namespace

    if (viewmap instanceof DecoratedConnectionViewmap) {
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    if (viewmap instanceof DecoratedConnectionViewmap) {
    stringBuffer.append(TEXT_22);
    	LinkDecoration linkDecoration = ((DecoratedConnectionViewmap) viewmap).getSource();
    stringBuffer.append(TEXT_23);
    
// Body of a method that returns link decoration figure.
//
// Parameters:
//
// importManager - ImportUtil ref in code
// linkDecoration - LinkDecoration ref in code
//
{ // private namespace
	if (linkDecoration != null && linkDecoration.getFigureQualifiedClassName() != null && linkDecoration.getFigureQualifiedClassName().trim().length() > 0) {
		String decorationClassName = importManager.getImportedName(linkDecoration.getFigureQualifiedClassName());
		Set SCALABLE_DECORATIONS = new HashSet();
		SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolylineDecoration");
		SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolygonDecoration");
		SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.RhombDecoration");
		SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.FilledRhombDecoration");
		if (SCALABLE_DECORATIONS.contains(linkDecoration.getFigureQualifiedClassName())) {
			// XXX use smth like ScaleableAtttributes?

    stringBuffer.append(TEXT_24);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_26);
    		} else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_28);
    
		}
	} else {

    stringBuffer.append(TEXT_29);
    
	}
} // private namespace

    stringBuffer.append(TEXT_30);
    	linkDecoration = ((DecoratedConnectionViewmap) viewmap).getTarget();
    stringBuffer.append(TEXT_31);
    
// Body of a method that returns link decoration figure.
//
// Parameters:
//
// importManager - ImportUtil ref in code
// linkDecoration - LinkDecoration ref in code
//
{ // private namespace
	if (linkDecoration != null && linkDecoration.getFigureQualifiedClassName() != null && linkDecoration.getFigureQualifiedClassName().trim().length() > 0) {
		String decorationClassName = importManager.getImportedName(linkDecoration.getFigureQualifiedClassName());
		Set SCALABLE_DECORATIONS = new HashSet();
		SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolylineDecoration");
		SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolygonDecoration");
		SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.RhombDecoration");
		SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.FilledRhombDecoration");
		if (SCALABLE_DECORATIONS.contains(linkDecoration.getFigureQualifiedClassName())) {
			// XXX use smth like ScaleableAtttributes?

    stringBuffer.append(TEXT_32);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_34);
    		} else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_36);
    
		}
	} else {

    stringBuffer.append(TEXT_37);
    
	}
} // private namespace

    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
