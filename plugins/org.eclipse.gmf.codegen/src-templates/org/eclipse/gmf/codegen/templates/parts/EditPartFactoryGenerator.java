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
  protected final String TEXT_3 = NL + "import java.util.Collection;" + NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.draw2d.ConnectionLocator;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.TextCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.Node;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_4 = ".StructuralFeatureParser;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements EditPartFactory {" + NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_9 = " annotation = containerView.getEAnnotation(\"VisualID\");" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"value\");" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\te.printStackTrace();\t\t" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tif (!\"";
  protected final String TEXT_11 = "\".equals(view.getDiagram().getType())) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tint viewVisualID = getVisualID(view);" + NL + "\t\t\tswitch (viewVisualID) {" + NL + "\t\t\tcase ";
  protected final String TEXT_12 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_13 = "(view);";
  protected final String TEXT_14 = NL + "\t\tcase ";
  protected final String TEXT_15 = ":" + NL + "\t\t\t return new ";
  protected final String TEXT_16 = "(view);";
  protected final String TEXT_17 = NL + "\t\tcase ";
  protected final String TEXT_18 = ":" + NL + "\t\t\treturn new ";
  protected final String TEXT_19 = "(view);";
  protected final String TEXT_20 = "\t\t" + NL + "\t\t\tcase ";
  protected final String TEXT_21 = ":" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_22 = "(view);";
  protected final String TEXT_23 = NL + "\t\t\tcase ";
  protected final String TEXT_24 = ":" + NL + "\t\t\t\tif (";
  protected final String TEXT_25 = ".equals(view.getType())) {" + NL + "\t\t\t\t\treturn new LabelEditPart(view) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic int getKeyPoint() {" + NL + "\t\t\t\t\t\t\treturn ConnectionLocator.";
  protected final String TEXT_26 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t};" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\treturn new TextCompartmentEditPart(view) {" + NL + "" + NL + "\t\t\t\t\t\tpublic IParser getParser() {" + NL + "\t\t\t\t\t\t\tif (parser == null) {" + NL + "\t\t\t\t\t\t\t\tparser = new StructuralFeatureParser(";
  protected final String TEXT_27 = ".eINSTANCE.get";
  protected final String TEXT_28 = "().getEStructuralFeature(\"";
  protected final String TEXT_29 = "\"));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treturn parser;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t};" + NL + "\t\t\t\t}";
  protected final String TEXT_30 = "\t\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn createUnrecognizedEditPart(context, model);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedEditPart(EditPart context, Object model) {" + NL + "\t \t// Handle creation of unrecognized child node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "}";
  protected final String TEXT_31 = NL;

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
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_9);
    
List genLinks = genDiagram.getLinks();
Collection allContainers = AccessUtil.getAllContainers(genDiagram);
String semanticPackageInterfaceName = importManager.getImportedName(genDiagram.getDomainMetaModel().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getEMFGenModel().getModelName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_13);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer container = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(container.getVisualID());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(container.getEditPartClassName());
    stringBuffer.append(TEXT_16);
    
	if (container instanceof GenNode) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_19);
    
		}
	}
}

for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_20);
    stringBuffer.append(link.getVisualID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(link.getEditPartClassName());
    stringBuffer.append(TEXT_22);
    
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(link);
	String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelId(linkLabel);
		String semanticLinkInterfaceName;
		if (link.getModelFacet() instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) link.getModelFacet();
			semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		} else {
			FeatureModelFacet modelFacet = (FeatureModelFacet) link.getModelFacet();
			semanticLinkInterfaceName = modelFacet.getMetaFeature().getGenClass().getClassifierAccessorName();
		}


    stringBuffer.append(TEXT_23);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(linkLabel.getAlignment());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(linkLabel.getMetaFeature().getName());
    stringBuffer.append(TEXT_29);
    
	}
}

    stringBuffer.append(TEXT_30);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
