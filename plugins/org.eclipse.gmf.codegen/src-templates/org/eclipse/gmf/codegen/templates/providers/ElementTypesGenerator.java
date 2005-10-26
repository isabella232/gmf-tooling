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
  protected final String TEXT_16 = "_EditHelper extends BaseEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getConfigureCommand(ConfigureRequest req) {" + NL + "\t\t\treturn new ConfigureElementCommand(req) {" + NL + "" + NL + "\t\t\t\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "\t\t\t\t\t// To customize newly created domain objects remove @renerated tag of " + NL + "\t\t\t\t\t// getConfigureCommand(ConfigureRequest req) method and write your custom" + NL + "\t\t\t\t\t// code here. Use getElementToEdit() to get created element.";
  protected final String TEXT_17 = NL + "\t\t\t\t\tInitializers.";
  protected final String TEXT_18 = ".init(getElementToEdit());";
  protected final String TEXT_19 = NL + "\t\t\t\t\t((";
  protected final String TEXT_20 = ") getElementToEdit()).";
  protected final String TEXT_21 = "((";
  protected final String TEXT_22 = ") getRequest().getParameter(CreateRelationshipRequest.TARGET));";
  protected final String TEXT_23 = "\t\t\t\t" + NL + "\t\t\t\t\treturn newOKCommandResult();" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}";
  protected final String TEXT_24 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getCreateRelationshipCommand(CreateRelationshipRequest reqest) {";
  protected final String TEXT_25 = NL + "\t\t\tif (";
  protected final String TEXT_26 = ".equals(reqest.getElementType())) {" + NL + "\t\t\t\treqest.setContainmentFeature(";
  protected final String TEXT_27 = ".getEContainerDescriptor().getContainmentFeatures()[0]);" + NL + "\t\t\t\treturn new SetValueCommand(new SetRequest(reqest.getSource(), reqest.getContainmentFeature(), reqest.getTarget()));" + NL + "\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\treturn super.getCreateRelationshipCommand(reqest);" + NL + "\t\t}";
  protected final String TEXT_29 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_30 = " = new MetamodelType(" + NL + "\t\t\"";
  protected final String TEXT_31 = "\", null, \"";
  protected final String TEXT_32 = "\"," + NL + "\t\t";
  protected final String TEXT_33 = ".eINSTANCE.get";
  protected final String TEXT_34 = "()," + NL + "\t\tnew ";
  protected final String TEXT_35 = "_EditHelper());";
  protected final String TEXT_36 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_37 = "_ContainerDescriptor implements IContainerDescriptor {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final EReference[] containmentFeatures = new EReference[] {" + NL + "\t\t\t";
  protected final String TEXT_38 = ".eINSTANCE.get";
  protected final String TEXT_39 = "()" + NL + "\t\t};" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EReference[] getContainmentFeatures() {" + NL + "\t\t\treturn containmentFeatures;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IElementMatcher getMatcher() {" + NL + "\t\t\treturn new IElementMatcher() {" + NL + "" + NL + "\t\t\t\t/**" + NL + "\t\t\t\t * @generated" + NL + "\t\t\t\t */" + NL + "\t\t\t\tpublic boolean matches(EObject eObject) {" + NL + "\t\t\t\t\treturn ";
  protected final String TEXT_40 = ".eINSTANCE.get";
  protected final String TEXT_41 = "().isInstance(eObject);" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_42 = "_EditHelperAdvice extends BaseEditHelperAdvice {}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ISpecializationType ";
  protected final String TEXT_43 = " = new SpecializationType(" + NL + "\t\t\"";
  protected final String TEXT_44 = "\", null, \"";
  protected final String TEXT_45 = "\"," + NL + "\t\tnew IElementType[] { NullElementType.getInstance() }, null," + NL + "\t\tnew ";
  protected final String TEXT_46 = "_ContainerDescriptor()," + NL + "\t\tnew ";
  protected final String TEXT_47 = "_EditHelperAdvice());";
  protected final String TEXT_48 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void register() {";
  protected final String TEXT_49 = NL + "\t\tElementTypeRegistry.getInstance().register(";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelperAdvice extends AbstractEditHelperAdvice {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getBeforeEditContextCommand(GetEditContextRequest reqest) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = reqest.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(reqest);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tresult.setEditContext(((View) container).getElement());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelper extends MSLEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getEditContextCommand(GetEditContextRequest req) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = req.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(req);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tcontainer = ((View) container).getElement();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tresult.setEditContext(container);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_52 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class Initializers {";
  protected final String TEXT_53 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tprivate static final ObjectInitializer ";
  protected final String TEXT_54 = " = new ObjectInitializer(new FeatureInitializer[] {";
  protected final String TEXT_55 = NL + "\t\t\tnew FeatureInitializer(\"";
  protected final String TEXT_56 = "\", //$NON-NLS-1$" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_57 = ".eINSTANCE.get";
  protected final String TEXT_58 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = ".eINSTANCE.get";
  protected final String TEXT_60 = "())";
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = NL + "\t\t});";
  protected final String TEXT_63 = NL + "\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate Initializers() {" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tstatic class ObjectInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate FeatureInitializer[] initExpressions;\t" + NL + "\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tObjectInitializer(FeatureInitializer[] initExpressions) {" + NL + "\t\t\t\tthis.initExpressions = initExpressions;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tvoid init(";
  protected final String TEXT_64 = " instance) {" + NL + "\t\t\t\tfor (int i = 0; i < initExpressions.length; i++) {" + NL + "\t\t\t\t\tFeatureInitializer nextExpr = initExpressions[i];" + NL + "\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} // end of ObjectInitializer" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tstatic class FeatureInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_65 = " contextClass;\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_66 = " sFeature;" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprivate ";
  protected final String TEXT_67 = " expressionBody;\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_68 = " query;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tFeatureInitializer(";
  protected final String TEXT_69 = " expression, " + NL + "\t\t\t\t";
  protected final String TEXT_70 = " context, " + NL + "\t\t\t\t";
  protected final String TEXT_71 = " sFeature) {" + NL + "\t\t\t\tthis.sFeature = sFeature;" + NL + "\t\t\t\tthis.expressionBody = expression;" + NL + "\t\t\t\tthis.contextClass\t= context;" + NL + "\t\t\t}" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tvoid init(";
  protected final String TEXT_72 = " contextInstance) {" + NL + "\t\t\t\tif(this.query == null) {" + NL + "\t\t\t\t\tthis.query = ";
  protected final String TEXT_73 = ".eINSTANCE.createQuery(expressionBody, contextClass);\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tObject value = query.evaluate(contextInstance);" + NL + "\t\t\t\tcontextInstance.eSet(sFeature, value);\t\t" + NL + "\t\t\t}" + NL + "\t\t} // end of FeatureInitializer" + NL + "\t\t\t\t" + NL + "\t} // end of Initializers";
  protected final String TEXT_74 = NL + "}";
  protected final String TEXT_75 = NL;

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
	if (entity instanceof GenLink && ((GenLink) entity).getModelFacet() instanceof FeatureModelFacet) {
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
		GenLink refLink = (GenLink) refLinks.get(i);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_13);
    
	}
}

    stringBuffer.append(TEXT_14);
    
entities = AccessUtil.getGenEntities(genDiagram);
int elementInitializerCount = 0;
while (entities.hasNext()) {
	GenCommonBase entity = (GenCommonBase) entities.next();
	TypeModelFacet typeModelFacet = null;
	String semanticNodeInterfaceName;
	if (entity instanceof GenDiagram) {
		semanticNodeInterfaceName = genDiagram.getDomainDiagramElement().getName();
	} else if (entity instanceof GenNode) {
		GenNode genNode = (GenNode) entity;
		typeModelFacet = genNode.getModelFacet();
		semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();
	} else if (entity instanceof GenLink && ((GenLink) entity).getModelFacet() instanceof TypeLinkModelFacet) {
		typeModelFacet = (TypeLinkModelFacet) ((GenLink) entity).getModelFacet();
		semanticNodeInterfaceName = typeModelFacet.getMetaClass().getName();
	} else {
		continue;
	}
	types.add(entity.getUniqueIdentifier());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_16);
    
	if (typeModelFacet != null && typeModelFacet.getModelElementInitializer() != null) {
		++elementInitializerCount;

    stringBuffer.append(TEXT_17);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_18);
    
	}
	if (entity instanceof GenLink) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) ((GenLink) entity).getModelFacet();
		GenFeature linkFeature = modelFacet.getTargetMetaFeature();
        String featureAccessorName = linkFeature.isListType() ? linkFeature.getGetAccessor() + "().add" : "set" + linkFeature.getAccessorName();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(featureAccessorName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(linkFeature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_22);
    	}
    stringBuffer.append(TEXT_23);
    
	if (entity instanceof GenNode) {
		GenNode node = (GenNode) entity;

    stringBuffer.append(TEXT_24);
    
		for (int i = 0; i < refLinks.size(); i++) {
			GenLink refLink = (GenLink) refLinks.get(i);
			GenFeature targetFeature = ((FeatureModelFacet) refLink.getModelFacet()).getMetaFeature();
			if (node.getDomainMetaClass().equals(targetFeature.getGenClass())) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(refLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_27);
    
			}
		}

    stringBuffer.append(TEXT_28);
    	}
    stringBuffer.append(TEXT_29);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    
}
for (int i = 0; i < refLinks.size(); i++) {
	GenLink entity = (GenLink) refLinks.get(i);
	GenFeature targetFeature = ((FeatureModelFacet) entity.getModelFacet()).getMetaFeature();
	String semanticFeatureCapName = targetFeature.getCapName();
	String semanticNodeInterfaceName = targetFeature.getGenClass().getName();

    stringBuffer.append(TEXT_36);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(semanticNodeInterfaceName + '_' + semanticFeatureCapName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    for (int i = 0; i < types.size(); i++) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(types.get(i));
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
     if(elementInitializerCount > 0) {
    stringBuffer.append(TEXT_52);
    
for(Iterator it = AccessUtil.getGenEntities(genDiagram); it.hasNext();) {
	GenCommonBase nextElement = (GenCommonBase)it.next();
	TypeModelFacet modelFacet = null;
	if(nextElement instanceof GenNode) {
		modelFacet = ((GenNode)nextElement).getModelFacet();
	} else if(nextElement instanceof GenLink && 
		((GenLink)nextElement).getModelFacet() instanceof TypeLinkModelFacet) {
		modelFacet = (TypeLinkModelFacet)((GenLink)nextElement).getModelFacet();
	} 
	
	if(modelFacet != null && modelFacet.getModelElementInitializer() instanceof GenFeatureSeqInitializer) {				
		GenFeatureSeqInitializer ftInitializer = (GenFeatureSeqInitializer)modelFacet.getModelElementInitializer();

    stringBuffer.append(TEXT_53);
    stringBuffer.append(nextElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_54);
    
		for(Iterator featInitIt = ftInitializer.getInitializers().iterator(); featInitIt.hasNext();) { 
			GenFeatureValueSpec featureValSpec = (GenFeatureValueSpec)featInitIt.next();
    stringBuffer.append(TEXT_55);
    stringBuffer.append(featureValSpec.getBody());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(ftInitializer.getElementQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ftInitializer.getElementClassAccessorName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(featureValSpec.getFeatureQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(featureValSpec.getFeature().getFeatureAccessorName()
						);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(featInitIt.hasNext() ? "," : "");
    stringBuffer.append(TEXT_61);
    
		} // end of GenFeatureValueSpec iteration

    stringBuffer.append(TEXT_62);
    
	} // end of GenFeatureSeqInitializer 
} // end of getGenEntities iteration

    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.QueryFactory"));
    stringBuffer.append(TEXT_73);
    	} 
    stringBuffer.append(TEXT_74);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_75);
    return stringBuffer.toString();
  }
}
