package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.Connection;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ConnectionNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();";
  protected final String TEXT_7 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_8 = ".CONNECTION_ROLE, new ";
  protected final String TEXT_9 = "());";
  protected final String TEXT_10 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_11 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_12 = "());" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_13 = "());";
  protected final String TEXT_14 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_15 = "());";
  protected final String TEXT_16 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Connection createConnectionFigure() {";
  protected final String TEXT_17 = NL + "\t\treturn new ";
  protected final String TEXT_18 = "();";
  protected final String TEXT_19 = NL + "\t\treturn ";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + " \t\treturn new ";
  protected final String TEXT_22 = "();";
  protected final String TEXT_23 = NL + "\t}" + NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "}";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenLink genLink = (GenLink) ((Object[]) argument)[0];
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
if (genLink.getModelFacet() == null) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.NonSemanticEditPolicy"));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genLink.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
Viewmap viewmap = genLink.getViewmap();
if (viewmap instanceof FigureViewmap) {
	String figureQualifiedClassName = null;
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx";
	}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_18);
    } // instanceof FigureViewmap
	else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_20);
    } // instanceof SnippetViewmap 
	else if (viewmap instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(((InnerClassViewmap) viewmap).getClassName());
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    if (genLink.getViewmap() instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(((InnerClassViewmap) genLink.getViewmap()).getClassBody());
    }
    stringBuffer.append(TEXT_25);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
