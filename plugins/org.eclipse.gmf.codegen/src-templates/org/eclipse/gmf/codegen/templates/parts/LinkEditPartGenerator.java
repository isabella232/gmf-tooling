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
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.Connection;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.RotatableDecoration;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ConnectionNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();";
  protected final String TEXT_7 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_8 = ".CONNECTION_ROLE, new ";
  protected final String TEXT_9 = "());";
  protected final String TEXT_10 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_11 = "());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Connection createConnectionFigure() {";
  protected final String TEXT_12 = NL + "\t\treturn null;";
  protected final String TEXT_13 = NL + "\t\t";
  protected final String TEXT_14 = " connection = new ";
  protected final String TEXT_15 = "();";
  protected final String TEXT_16 = NL + "\t\tRotatableDecoration sourceDecoration = createSourceDecoration();" + NL + "\t\tif (sourceDecoration != null) {" + NL + "\t\t\tconnection.setSourceDecoration(sourceDecoration);" + NL + "\t\t}" + NL + "\t\tRotatableDecoration targetDecoration = createTargetDecoration();" + NL + "\t\tif (targetDecoration != null) {" + NL + "\t\t\tconnection.setTargetDecoration(targetDecoration);" + NL + "\t\t}";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = ".setLineStyle(Graphics.";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = ".setLineWidth(attrs.getLineWidth());";
  protected final String TEXT_23 = NL + "\t\treturn connection;" + NL + "\t}" + NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected RotatableDecoration createSourceDecoration() {";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\t\treturn null;";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = " decoration = new ";
  protected final String TEXT_30 = "();" + NL + "\t\tdecoration.setScale(";
  protected final String TEXT_31 = ".DPtoLP(7), ";
  protected final String TEXT_32 = ".DPtoLP(3));" + NL + "\t\treturn decoration;";
  protected final String TEXT_33 = NL + "\t\treturn new ";
  protected final String TEXT_34 = "();";
  protected final String TEXT_35 = NL + "\t\treturn null;";
  protected final String TEXT_36 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected RotatableDecoration createTargetDecoration() {";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + "\t\treturn null;";
  protected final String TEXT_39 = NL + "\t\t";
  protected final String TEXT_40 = " decoration = new ";
  protected final String TEXT_41 = "();" + NL + "\t\tdecoration.setScale(";
  protected final String TEXT_42 = ".DPtoLP(7), ";
  protected final String TEXT_43 = ".DPtoLP(3));" + NL + "\t\treturn decoration;";
  protected final String TEXT_44 = NL + "\t\treturn new ";
  protected final String TEXT_45 = "();";
  protected final String TEXT_46 = NL + "\t\treturn null;";
  protected final String TEXT_47 = NL + "\t}";
  protected final String TEXT_48 = NL + "}";
  protected final String TEXT_49 = NL;

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
    
if (false == genLink.getViewmap() instanceof FigureViewmap) {

    stringBuffer.append(TEXT_12);
    
}
String connClassName = importManager.getImportedName(((FigureViewmap) genLink.getViewmap()).getFigureQualifiedClassName());

    stringBuffer.append(TEXT_13);
    stringBuffer.append(connClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connClassName);
    stringBuffer.append(TEXT_15);
    
if (genLink.getViewmap() instanceof DecoratedConnectionViewmap) {

    stringBuffer.append(TEXT_16);
    
}
for (Iterator it = genLink.getViewmap().getAttributes().iterator(); it.hasNext(); ) {
	Attributes next = (Attributes) it.next();
	if (next instanceof ShapeAttributes) {
		String figureVarName = "connection";
		ShapeAttributes attrs = (ShapeAttributes) next;

    stringBuffer.append(TEXT_17);
    
String lineStyle = attrs.getLineStyle();
if (lineStyle != null && lineStyle.trim().length() > 0) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(lineStyle);
    stringBuffer.append(TEXT_20);
    
}
if (attrs.isSetLineWidth()) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_22);
    }
    
	}
	// put additional Attributes support here 
} // for

    stringBuffer.append(TEXT_23);
    if (genLink.getViewmap() instanceof DecoratedConnectionViewmap) {
    stringBuffer.append(TEXT_24);
    
DecoratedConnectionViewmap viewmap = (DecoratedConnectionViewmap) genLink.getViewmap();

Set SCALABLE_DECORATIONS = new HashSet();
{
	SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolylineDecoration");
	SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolygonDecoration");
	SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.RhombDecoration");
	SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.FilledRhombDecoration");
}

    stringBuffer.append(TEXT_25);
    
LinkDecoration linkDecoration = viewmap.getSource();

    stringBuffer.append(TEXT_26);
    
if (linkDecoration == null) {

    stringBuffer.append(TEXT_27);
    
} else if (linkDecoration.getFigureQualifiedClassName() != null && linkDecoration.getFigureQualifiedClassName().trim().length() > 0) {
	String decorationClassName = importManager.getImportedName(linkDecoration.getFigureQualifiedClassName());
	String mapModeClassName = importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapMode");
	if (SCALABLE_DECORATIONS.contains(linkDecoration.getFigureQualifiedClassName())) {
		// XXX use smth like ScaleableAtttributes?

    stringBuffer.append(TEXT_28);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(mapModeClassName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(mapModeClassName);
    stringBuffer.append(TEXT_32);
    	} else {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_34);
    	}
} else {
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    
linkDecoration = viewmap.getTarget();

    stringBuffer.append(TEXT_37);
    
if (linkDecoration == null) {

    stringBuffer.append(TEXT_38);
    
} else if (linkDecoration.getFigureQualifiedClassName() != null && linkDecoration.getFigureQualifiedClassName().trim().length() > 0) {
	String decorationClassName = importManager.getImportedName(linkDecoration.getFigureQualifiedClassName());
	String mapModeClassName = importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapMode");
	if (SCALABLE_DECORATIONS.contains(linkDecoration.getFigureQualifiedClassName())) {
		// XXX use smth like ScaleableAtttributes?

    stringBuffer.append(TEXT_39);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(mapModeClassName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(mapModeClassName);
    stringBuffer.append(TEXT_43);
    	} else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(decorationClassName);
    stringBuffer.append(TEXT_45);
    	}
} else {
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
