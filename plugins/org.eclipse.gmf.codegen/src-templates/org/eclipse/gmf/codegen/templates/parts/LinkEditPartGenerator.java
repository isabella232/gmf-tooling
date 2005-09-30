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
  protected final String TEXT_3 = NL + "import org.eclipse.draw2d.Connection;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.RotatableDecoration;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapMode;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ConnectionNodeEditPart {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_6 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Connection createConnectionFigure() {" + NL + "\t\tPolylineConnectionEx connection = new PolylineConnectionEx();" + NL + "\t\tRotatableDecoration sourceDecoration = createSourceDecoration();" + NL + "\t\tif (sourceDecoration != null) {" + NL + "\t\t\tconnection.setSourceDecoration(sourceDecoration);" + NL + "\t\t}" + NL + "\t\tRotatableDecoration targetDecoration = createTargetDecoration();" + NL + "\t\tif (targetDecoration != null) {" + NL + "\t\t\tconnection.setTargetDecoration(targetDecoration);" + NL + "\t\t}";
  protected final String TEXT_7 = NL + "\t\tconnection.setLineStyle(Graphics.";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\treturn connection;" + NL + "\t}";
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected RotatableDecoration createSourceDecoration() {";
  protected final String TEXT_11 = NL + "\t\t";
  protected final String TEXT_12 = " decoration = new ";
  protected final String TEXT_13 = "();" + NL + "\t\tdecoration.setScale(MapMode.DPtoLP(7), MapMode.DPtoLP(3));" + NL + "\t\treturn decoration;";
  protected final String TEXT_14 = NL + "\t\treturn new ";
  protected final String TEXT_15 = "();";
  protected final String TEXT_16 = NL + "\t\treturn null;";
  protected final String TEXT_17 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected RotatableDecoration createTargetDecoration() {";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = " decoration = new ";
  protected final String TEXT_20 = "();" + NL + "\t\tdecoration.setScale(MapMode.DPtoLP(7), MapMode.DPtoLP(3));" + NL + "\t\treturn decoration;";
  protected final String TEXT_21 = NL + "\t\treturn new ";
  protected final String TEXT_22 = "();";
  protected final String TEXT_23 = NL + "\t\treturn null;";
  protected final String TEXT_24 = NL + "\t}" + NL + "}";
  protected final String TEXT_25 = NL;

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
    
String lineStyle = genLink.getLineStyle();
if (lineStyle != null && lineStyle.trim().length() > 0) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(lineStyle);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
Set SCALABLE_DECORATIONS = new HashSet();
{
	SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolylineDecoration");
	SCALABLE_DECORATIONS.add("org.eclipse.draw2d.PolygonDecoration");
	SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.RhombDecoration");
	SCALABLE_DECORATIONS.add("org.eclipse.gmf.draw2d.FilledRhombDecoration");
}

    stringBuffer.append(TEXT_10);
    
String sourceDecorationClassQualifiedName = genLink.getSourceDecorationFigureQualifiedClassName();
if (sourceDecorationClassQualifiedName != null && sourceDecorationClassQualifiedName.trim().length() > 0) {
	String sourceDecorationClassName = importManager.getImportedName(sourceDecorationClassQualifiedName);
	if (SCALABLE_DECORATIONS.contains(sourceDecorationClassQualifiedName)) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(sourceDecorationClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sourceDecorationClassName);
    stringBuffer.append(TEXT_13);
    	} else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sourceDecorationClassName);
    stringBuffer.append(TEXT_15);
    	}
} else {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    
String targetDecorationClassQualifiedName = genLink.getTargetDecorationFigureQualifiedClassName();
if (targetDecorationClassQualifiedName != null && targetDecorationClassQualifiedName.trim().length() > 0) {
	String targetDecorationClassName = importManager.getImportedName(targetDecorationClassQualifiedName);
	if (SCALABLE_DECORATIONS.contains(targetDecorationClassQualifiedName)) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(targetDecorationClassName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(targetDecorationClassName);
    stringBuffer.append(TEXT_20);
    	} else {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(targetDecorationClassName);
    stringBuffer.append(TEXT_22);
    	}
} else {
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
