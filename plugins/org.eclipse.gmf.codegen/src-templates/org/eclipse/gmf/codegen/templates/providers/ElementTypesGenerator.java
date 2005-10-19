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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.ENamedElement;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EReference;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.edithelpers.MSLEditHelper;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.NullElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.jface.resource.ImageRegistry;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ElementTypes {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageRegistry imageRegistry;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageRegistry getImageRegistry() {" + NL + "\t\tif (imageRegistry == null) {" + NL + "\t\t\timageRegistry = new ImageRegistry();" + NL + "\t\t}" + NL + "\t\treturn imageRegistry;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static String getImageRegistryKey(ENamedElement element) {" + NL + "\t\treturn element.getName();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {" + NL + "\t\tif (element instanceof EStructuralFeature) {" + NL + "\t\t\telement = ((EStructuralFeature) element).getEContainingClass();" + NL + "\t\t}" + NL + "\t\tif (element instanceof EClass) {";
  protected final String TEXT_5 = NL + "\t\t\treturn ";
  protected final String TEXT_6 = ".getInstance().getItemImageDescriptor(" + NL + "\t\t\t\t";
  protected final String TEXT_7 = ".eINSTANCE.create((EClass) element));" + NL + "\t\t}" + NL + "\t\t// TODO : support structural features" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(ENamedElement element) {" + NL + "\t\tString key = getImageRegistryKey(element);" + NL + "\t\tImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);" + NL + "\t\tif (imageDescriptor == null) {" + NL + "\t\t\timageDescriptor = getProvidedImageDescriptor(element);" + NL + "\t\t\tif (imageDescriptor == null) {" + NL + "\t\t\t\timageDescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t\t}" + NL + "\t\t\tgetImageRegistry().put(key, imageDescriptor);" + NL + "\t\t}" + NL + "\t\treturn imageDescriptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Image getImage(ENamedElement element) {" + NL + "\t\tString key = getImageRegistryKey(element);" + NL + "\t\tImage image = getImageRegistry().get(key);" + NL + "\t\tif (image == null) {" + NL + "\t\t\tImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);" + NL + "\t\t\tif (imageDescriptor == null) {" + NL + "\t\t\t\timageDescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t\t}" + NL + "\t\t\tgetImageRegistry().put(key, imageDescriptor);" + NL + "\t\t\timage = getImageRegistry().get(key);" + NL + "\t\t}" + NL + "\t\treturn image;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(IAdaptable hint) {" + NL + "\t\tENamedElement element = getElement(hint);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getImageDescriptor(element);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Image getImage(IAdaptable hint) {" + NL + "\t\tENamedElement element = getElement(hint);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getImage(element);" + NL + "\t}";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * Returns 'type' of the ecore object associated with the hint." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ENamedElement getElement(IAdaptable hint) {" + NL + "\t\tObject type = hint.getAdapter(IElementType.class);" + NL + "\t\tif (type instanceof IMetamodelType) {" + NL + "\t\t\tEClass eClass = ((IMetamodelType) type).getEClass();" + NL + "\t\t\tif (eClass != null && eClass.getEPackage() == ";
  protected final String TEXT_9 = ".eINSTANCE) {" + NL + "\t\t\t\treturn eClass;" + NL + "\t\t\t}" + NL + "\t\t\treturn null;";
  protected final String TEXT_10 = NL + "\t\t} else if (type instanceof ISpecializationType) {";
  protected final String TEXT_11 = NL + "\t\t\tif (";
  protected final String TEXT_12 = " == type) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_13 = ".getEContainerDescriptor().getContainmentFeatures()[0];" + NL + "\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_15 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_16 = "_EditHelper extends BaseEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getConfigureCommand(ConfigureRequest req) {" + NL + "\t\t\treturn new ConfigureElementCommand(req) {" + NL + "" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * @generated" + NL + "\t\t\t\t */" + NL + "\t\t\t\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "\t\t\t\t\t// Write new object initialization code here." + NL + "\t\t\t\t\t// Use getElementToEdit() to get created element." + NL + "\t\t\t\t\treturn newOKCommandResult();" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}";
  protected final String TEXT_17 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getCreateRelationshipCommand(CreateRelationshipRequest reqest) {";
  protected final String TEXT_18 = NL + "\t\t\tif (";
  protected final String TEXT_19 = ".equals(reqest.getElementType())) {" + NL + "\t\t\t\treqest.setContainmentFeature(";
  protected final String TEXT_20 = ".getEContainerDescriptor().getContainmentFeatures()[0]);" + NL + "\t\t\t\treturn new SetValueCommand(new SetRequest(reqest.getSource(), reqest.getContainmentFeature(), reqest.getTarget()));" + NL + "\t\t\t}";
  protected final String TEXT_21 = NL + "\t\t\treturn super.getCreateRelationshipCommand(reqest);" + NL + "\t\t}";
  protected final String TEXT_22 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_23 = " = new MetamodelType(" + NL + "\t\t\"";
  protected final String TEXT_24 = "\", null, \"";
  protected final String TEXT_25 = "\"," + NL + "\t\t";
  protected final String TEXT_26 = ".eINSTANCE.get";
  protected final String TEXT_27 = "()," + NL + "\t\tnew ";
  protected final String TEXT_28 = "_EditHelper());";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_30 = "_ContainerDescriptor implements IContainerDescriptor {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final EReference[] containmentFeatures = new EReference[] {" + NL + "\t\t\t";
  protected final String TEXT_31 = ".eINSTANCE.get";
  protected final String TEXT_32 = "()" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EReference[] getContainmentFeatures() {" + NL + "\t\t\treturn containmentFeatures;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IElementMatcher getMatcher() {" + NL + "\t\t\treturn new IElementMatcher() {" + NL + "" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * @generated" + NL + "\t\t\t\t */" + NL + "\t\t\t\tpublic boolean matches(EObject eObject) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_33 = ".eINSTANCE.get";
  protected final String TEXT_34 = "().isInstance(eObject);" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_35 = "_EditHelperAdvice extends BaseEditHelperAdvice {}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ISpecializationType ";
  protected final String TEXT_36 = " = new SpecializationType(" + NL + "\t\t\"";
  protected final String TEXT_37 = "\", null, \"";
  protected final String TEXT_38 = "\"," + NL + "\t\tnew IElementType[] { NullElementType.getInstance() }, null," + NL + "\t\tnew ";
  protected final String TEXT_39 = "_ContainerDescriptor()," + NL + "\t\tnew ";
  protected final String TEXT_40 = "_EditHelperAdvice());";
  protected final String TEXT_41 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void register() {";
  protected final String TEXT_42 = NL + "\t\tElementTypeRegistry.getInstance().register(";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelperAdvice extends AbstractEditHelperAdvice {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getBeforeEditContextCommand(GetEditContextRequest reqest) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = reqest.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(reqest);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tresult.setEditContext(((View) container).getElement());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelper extends MSLEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getEditContextCommand(GetEditContextRequest req) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = req.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(req);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tcontainer = ((View) container).getElement();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tresult.setEditContext(container);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_45 = NL;

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
    
String pluginClassName = importManager.getImportedName(genDiagram.getPluginQualifiedClassName());
String semanticFactoryClassName = importManager.getImportedName(genDiagram.getDomainMetaModel().getQualifiedFactoryInterfaceName());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(pluginClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(semanticFactoryClassName);
    stringBuffer.append(TEXT_7);
    
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

    stringBuffer.append(TEXT_8);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_9);
    if (!refLinks.isEmpty()) {
    stringBuffer.append(TEXT_10);
    
	for (int i = 0; i < refLinks.size(); i++) {
		GenLinkReferenceOnly refLink = (GenLinkReferenceOnly) refLinks.get(i);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_13);
    
	}
}

    stringBuffer.append(TEXT_14);
    
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

    stringBuffer.append(TEXT_15);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_16);
    
	if (entity instanceof GenNode) {
		GenNode node = (GenNode) entity;

    stringBuffer.append(TEXT_17);
    
		for (int i = 0; i < refLinks.size(); i++) {
			GenLinkReferenceOnly refLink = (GenLinkReferenceOnly) refLinks.get(i);
			GenFeature targetFeature = refLink.getDomainLinkTargetFeature();
			if (node.getDomainMetaClass().equals(targetFeature.getGenClass())) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_20);
    
			}
		}

    stringBuffer.append(TEXT_21);
    	}
    stringBuffer.append(TEXT_22);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    
}
for (int i = 0; i < refLinks.size(); i++) {
	GenLinkReferenceOnly entity = (GenLinkReferenceOnly) refLinks.get(i);
	GenFeature targetFeature = entity.getDomainLinkTargetFeature();
	String semanticFeatureCapName = targetFeature.getCapName();
	String semanticNodeInterfaceName = targetFeature.getGenClass().getName();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(semanticNodeInterfaceName + '_' + semanticFeatureCapName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    
}

    stringBuffer.append(TEXT_41);
    for (int i = 0; i < types.size(); i++) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(types.get(i));
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}
