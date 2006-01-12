package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
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
  protected final String TEXT_3 = NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EXTERNAL_NODE_LABELS_LAYER = \"External Node Labels\";" + NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getModelID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_8 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t}" + NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_11 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"visualID\"); //$NON-NLS-1$" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\te.printStackTrace();\t\t" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL;
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tif (!\"";
  protected final String TEXT_13 = "\".equals(getModelID(view))) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tint viewVisualID = getVisualID(view);" + NL + "\t\t\tswitch (viewVisualID) {" + NL + "\t\t\tcase ";
  protected final String TEXT_14 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_15 = "(view);";
  protected final String TEXT_16 = NL + "\t\tcase ";
  protected final String TEXT_17 = ":" + NL + "\t\t\t return new ";
  protected final String TEXT_18 = "(view);";
  protected final String TEXT_19 = NL + "\t\tcase ";
  protected final String TEXT_20 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_21 = ".equals(view.getType())) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_22 = "(view);" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_23 = "(view);" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\tcase ";
  protected final String TEXT_25 = ":" + NL + "\t\t\treturn new ";
  protected final String TEXT_26 = "(view);";
  protected final String TEXT_27 = "\t\t" + NL + "\t\t\tcase ";
  protected final String TEXT_28 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_29 = "(view);";
  protected final String TEXT_30 = NL + "\t\t\tcase ";
  protected final String TEXT_31 = ":" + NL + "\t\t\t\tif (";
  protected final String TEXT_32 = ".equals(view.getType())) {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_33 = "(view);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_34 = "(view);" + NL + "\t\t\t\t}";
  protected final String TEXT_35 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn createUnrecognizedEditPart(context, model);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedEditPart(EditPart context, Object model) {" + NL + "\t \t// Handle creation of unrecognized child node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "}";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_11);
    
List genLinks = genDiagram.getLinks();
Collection allContainers = AccessUtil.getAllContainers(genDiagram);

    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getEMFGenModel().getModelName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_15);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer container = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(container.getVisualID());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(container.getEditPartClassName());
    stringBuffer.append(TEXT_18);
    
	if (container instanceof GenChildNode ? !((GenChildNode) container).isListContainerEntry() : container instanceof GenNode) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();
			if (label instanceof ExternalLabel) {
// [++] Just to remove unnecessary imports we are doing this import insode a loop
				String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
// [--]
				String labelViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + ((ExternalLabel) label).getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(((ExternalLabel) label).getTextEditPartClassName());
    stringBuffer.append(TEXT_23);
    
			} else {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_26);
    
			}
		}
	}
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_27);
    stringBuffer.append(link.getVisualID());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(link.getEditPartClassName());
    stringBuffer.append(TEXT_29);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
// [++] Just to remove unnecessary imports we are doing this import insode a loop
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
// [--]
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelViewId = semanticHintsClassName + '.' + link.getUniqueIdentifier() + "Labels." + linkLabel.getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_30);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(linkLabel.getEditPartClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(linkLabel.getTextEditPartClassName());
    stringBuffer.append(TEXT_34);
    
	}
}

    stringBuffer.append(TEXT_35);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
