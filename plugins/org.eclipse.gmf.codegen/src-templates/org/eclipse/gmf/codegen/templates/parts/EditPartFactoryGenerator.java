package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EXTERNAL_NODE_LABELS_LAYER = \"External Node Labels\";" + NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getModelID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_11 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t}" + NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_14 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"visualID\"); //$NON-NLS-1$" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\t";
  protected final String TEXT_15 = ".getInstance().logError(\"Unable to parse \\\"visualID\\\" annotation: \" + visualID, e);" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tif (!\"";
  protected final String TEXT_16 = "\".equals(getModelID(view))) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tint viewVisualID = getVisualID(view);" + NL + "\t\t\tswitch (viewVisualID) {";
  protected final String TEXT_17 = NL + "\t\t\tcase ";
  protected final String TEXT_18 = ":" + NL + "\t\t\t\t return new ";
  protected final String TEXT_19 = "(view);";
  protected final String TEXT_20 = NL + "\t\t\tcase ";
  protected final String TEXT_21 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_22 = "(view);";
  protected final String TEXT_23 = "\t\t" + NL + "\t\t\tcase ";
  protected final String TEXT_24 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_25 = "(view);";
  protected final String TEXT_26 = NL + "\t\t\tcase ";
  protected final String TEXT_27 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_28 = "(view);";
  protected final String TEXT_29 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn createUnrecognizedEditPart(context, model);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedEditPart(EditPart context, Object model) {" + NL + "\t \t// Handle creation of unrecognized child node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "}";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final String modelID = genDiagram.getEditorGen().getModelID();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_16);
    
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase container = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append(container.getVisualID());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(container.getEditPartClassName());
    stringBuffer.append(TEXT_19);
    
	if (container instanceof GenNode && !((GenNode) container).isListContainerEntry()) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_20);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_22);
    
		}
	}
}
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_23);
    stringBuffer.append(link.getVisualID());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(link.getEditPartClassName());
    stringBuffer.append(TEXT_25);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();

    stringBuffer.append(TEXT_26);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(linkLabel.getEditPartClassName());
    stringBuffer.append(TEXT_28);
    
	}
}

    stringBuffer.append(TEXT_29);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
