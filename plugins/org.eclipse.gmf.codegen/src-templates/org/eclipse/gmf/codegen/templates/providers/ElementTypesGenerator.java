package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ElementTypesGenerator
{
  protected static String nl;
  public static synchronized ElementTypesGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ElementTypesGenerator result = new ElementTypesGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EReference;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.edithelpers.MSLEditHelper;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.NullElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ElementTypes {" + NL;
  protected final String TEXT_5 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_6 = "_EditHelper extends BaseEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getConfigureCommand(ConfigureRequest req) {" + NL + "\t\t\treturn new ConfigureElementCommand(req) {" + NL + "" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * @generated" + NL + "\t\t\t\t */" + NL + "\t\t\t\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "\t\t\t\t\t// Write new object initialization code here." + NL + "\t\t\t\t\t// Use getElementToEdit() to get created element." + NL + "\t\t\t\t\treturn newOKCommandResult();" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}";
  protected final String TEXT_7 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getCreateRelationshipCommand(CreateRelationshipRequest reqest) {";
  protected final String TEXT_8 = NL + "\t\t\tif (";
  protected final String TEXT_9 = ".equals(reqest.getElementType())) {" + NL + "\t\t\t\treqest.setContainmentFeature(";
  protected final String TEXT_10 = ".getEContainerDescriptor().getContainmentFeatures()[0]);" + NL + "\t\t\t\treturn new SetValueCommand(new SetRequest(reqest.getSource(), reqest.getContainmentFeature(), reqest.getTarget()));" + NL + "\t\t\t}";
  protected final String TEXT_11 = NL + "\t\t\treturn super.getCreateRelationshipCommand(reqest);" + NL + "\t\t}";
  protected final String TEXT_12 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_13 = " = new MetamodelType(" + NL + "\t\t\"";
  protected final String TEXT_14 = "\", null, null," + NL + "\t\t";
  protected final String TEXT_15 = ".eINSTANCE.get";
  protected final String TEXT_16 = "()," + NL + "\t\tnew ";
  protected final String TEXT_17 = "_EditHelper());";
  protected final String TEXT_18 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_19 = "_ContainerDescriptor implements IContainerDescriptor {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final EReference[] containmentFeatures = new EReference[] {" + NL + "\t\t\t";
  protected final String TEXT_20 = ".eINSTANCE.get";
  protected final String TEXT_21 = "()" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EReference[] getContainmentFeatures() {" + NL + "\t\t\treturn containmentFeatures;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IElementMatcher getMatcher() {" + NL + "\t\t\treturn new IElementMatcher() {" + NL + "" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * @generated" + NL + "\t\t\t\t */" + NL + "\t\t\t\tpublic boolean matches(EObject eObject) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_22 = ".eINSTANCE.get";
  protected final String TEXT_23 = "().isInstance(eObject);" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_24 = "_EditHelperAdvice extends BaseEditHelperAdvice {}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ISpecializationType ";
  protected final String TEXT_25 = " = new SpecializationType(" + NL + "\t\t\"";
  protected final String TEXT_26 = "\", null, null," + NL + "\t\tnew IElementType[] { NullElementType.getInstance() }, null," + NL + "\t\tnew ";
  protected final String TEXT_27 = "_ContainerDescriptor()," + NL + "\t\tnew ";
  protected final String TEXT_28 = "_EditHelperAdvice());";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void register() {";
  protected final String TEXT_30 = NL + "\t\tElementTypeRegistry.getInstance().register(";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelperAdvice extends AbstractEditHelperAdvice {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getBeforeEditContextCommand(GetEditContextRequest reqest) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = reqest.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(reqest);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tresult.setEditContext(((View) container).getElement());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelper extends MSLEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getEditContextCommand(GetEditContextRequest req) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = req.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(req);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tcontainer = ((View) container).getElement();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tresult.setEditContext(container);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    
List types = new ArrayList();
List refLinks = new ArrayList();
Iterator entities = AccessUtil.getGenEntities(genDiagram);
while (entities.hasNext()) {
	GenCommonBase entity = (GenCommonBase) entities.next();
	if (entity instanceof GenLinkReferenceOnly) {
		refLinks.add(entity);
		types.add(entity.getUniqueIdentifier());
	}
}
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
entities = AccessUtil.getGenEntities(genDiagram);
while (entities.hasNext()) {
	GenCommonBase entity = (GenCommonBase) entities.next();
	String semanticNodeInterfaceName;
	if (entity instanceof GenDiagram) {
		semanticNodeInterfaceName = genDiagram.getDomainDiagramElement().getName();
	} else if (entity instanceof GenNode) {
		GenNode genNode = (GenNode) entity;
		semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();
	} else if (entity instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) entity;
		semanticNodeInterfaceName = genLinkWithClass.getDomainMetaClass().getName();
	} else {
		continue;
	}
	types.add(entity.getUniqueIdentifier());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_6);
    
	if (entity instanceof GenNode) {
		GenNode node = (GenNode) entity;

    stringBuffer.append(TEXT_7);
    
		for (int i = 0; i < refLinks.size(); i++) {
			GenLinkReferenceOnly refLink = (GenLinkReferenceOnly) refLinks.get(i);
			GenFeature targetFeature = refLink.getDomainLinkTargetFeature();
			if (node.getDomainMetaClass().equals(targetFeature.getGenClass())) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    
			}
		}

    stringBuffer.append(TEXT_11);
    	}
    stringBuffer.append(TEXT_12);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_17);
    
}
for (int i = 0; i < refLinks.size(); i++) {
	GenLinkReferenceOnly entity = (GenLinkReferenceOnly) refLinks.get(i);
	GenFeature targetFeature = entity.getDomainLinkTargetFeature();
	String semanticFeatureCapName = targetFeature.getCapName();
	String semanticNodeInterfaceName = targetFeature.getGenClass().getName();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(semanticNodeInterfaceName + '_' + semanticFeatureCapName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    
}

    stringBuffer.append(TEXT_29);
    for (int i = 0; i < types.size(); i++) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(types.get(i));
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
