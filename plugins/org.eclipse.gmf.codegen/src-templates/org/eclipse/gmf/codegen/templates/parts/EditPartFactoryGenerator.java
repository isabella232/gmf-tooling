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
  protected final String TEXT_3 = NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tEObject element = view.getElement();";
  protected final String TEXT_6 = NL + "\t\t\tif (";
  protected final String TEXT_7 = ".eINSTANCE.get";
  protected final String TEXT_8 = "().isInstance(element)) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_9 = "(view);" + NL + "\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\telse if (";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "().isInstance(element)) {";
  protected final String TEXT_13 = NL + "\t\t\t\tif (";
  protected final String TEXT_14 = ".equals(view.getType())) {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_15 = "(view);" + NL + "\t\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\t\tif (\"";
  protected final String TEXT_17 = "\".equals(view.getType())) {" + NL + "\t\t\t\t\treturn new ListCompartmentEditPart(view) {" + NL + "" + NL + "\t\t\t\t\t\tprotected boolean hasModelChildrenChanged(Notification evt) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tprotected void createDefaultEditPolicies() {" + NL + "\t\t\t\t\t\t\tsuper.createDefaultEditPolicies();" + NL + "\t\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());" + NL + "\t\t\t\t\t\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());" + NL + "\t\t\t\t\t\t\t//installEditPolicy(EditPolicy.NODE_ROLE, null);" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tprotected String getTitleName() {" + NL + "\t\t\t\t\t\t\treturn \"";
  protected final String TEXT_18 = "\";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t};" + NL + "\t\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_20 = "(view);" + NL + "\t\t\t}";
  protected final String TEXT_21 = NL + "\t\t\telse if (";
  protected final String TEXT_22 = ".eINSTANCE.get";
  protected final String TEXT_23 = "().isInstance(element)) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_24 = "(view);" + NL + "\t\t\t}";
  protected final String TEXT_25 = NL + "\t\t\telse if (";
  protected final String TEXT_26 = ".eINSTANCE.get";
  protected final String TEXT_27 = "().isInstance(element)) {" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_28 = "(view);" + NL + "\t\t\t}";
  protected final String TEXT_29 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_30 = NL;

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
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_9);
    
List genNodes = genDiagram.getNodes();
for (int i = 0; i < genNodes.size(); i++) {
		GenNode genNode = (GenNode) genNodes.get(i);
		String semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_12);
    
		if (genNode.hasNameToEdit()) {
			String semanticHintsQualifiedClassName = genDiagram.getEditProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(genNode);
			String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
			String semanticHint = semanticHintsClassName + '.' + AccessUtil.getNameSemanticHint(genNode);

    stringBuffer.append(TEXT_13);
    stringBuffer.append(semanticHint);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(AccessUtil.getNodeLabelEditPartClassName(genNode));
    stringBuffer.append(TEXT_15);
    
		}
		List genChildContainers = genNode.getChildContainers();
		for (int j = 0; j < genChildContainers.size(); j++) {
			GenChildContainer genChildContainer = (GenChildContainer) genChildContainers.get(j);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(genChildContainer.getGroupID());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genChildContainer.getTitleKey());
    stringBuffer.append(TEXT_18);
    		}
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_20);
    
		List genChildNodes = genNode.getChildNodes();
		for (int j = 0; j < genChildNodes.size(); j++) {
			GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
			String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_24);
    		}
}
List genLinks = genDiagram.getLinks();
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
		String semanticLinkInterfaceName = genLinkWithClass.getDomainMetaClass().getName();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genLink.getEditPartClassName());
    stringBuffer.append(TEXT_28);
    
	}
}

    stringBuffer.append(TEXT_29);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
