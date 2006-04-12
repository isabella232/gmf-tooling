package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_8 = "() {}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static Map elements;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageRegistry imageRegistry;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageRegistry getImageRegistry() {" + NL + "\t\tif (imageRegistry == null) {" + NL + "\t\t\timageRegistry = new ImageRegistry();" + NL + "\t\t}" + NL + "\t\treturn imageRegistry;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static String getImageRegistryKey(ENamedElement element) {" + NL + "\t\treturn element.getName();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {" + NL + "\t\tif (element instanceof EStructuralFeature) {" + NL + "\t\t\telement = ((EStructuralFeature) element).getEContainingClass();" + NL + "\t\t}" + NL + "\t\tif (element instanceof EClass) {";
  protected final String TEXT_9 = NL + "\t\t\tEClass eClass = (EClass) element;" + NL + "\t\t\tif (!eClass.isAbstract()) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_10 = ".getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t// TODO : support structural features" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(ENamedElement element) {" + NL + "\t\tString key = getImageRegistryKey(element);" + NL + "\t\tImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);" + NL + "\t\tif (imageDescriptor == null) {" + NL + "\t\t\timageDescriptor = getProvidedImageDescriptor(element);" + NL + "\t\t\tif (imageDescriptor == null) {" + NL + "\t\t\t\timageDescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t\t}" + NL + "\t\t\tgetImageRegistry().put(key, imageDescriptor);" + NL + "\t\t}" + NL + "\t\treturn imageDescriptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Image getImage(ENamedElement element) {" + NL + "\t\tString key = getImageRegistryKey(element);" + NL + "\t\tImage image = getImageRegistry().get(key);" + NL + "\t\tif (image == null) {" + NL + "\t\t\tImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);" + NL + "\t\t\tif (imageDescriptor == null) {" + NL + "\t\t\t\timageDescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t\t}" + NL + "\t\t\tgetImageRegistry().put(key, imageDescriptor);" + NL + "\t\t\timage = getImageRegistry().get(key);" + NL + "\t\t}" + NL + "\t\treturn image;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(IAdaptable hint) {" + NL + "\t\tENamedElement element = getElement(hint);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getImageDescriptor(element);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Image getImage(IAdaptable hint) {" + NL + "\t\tENamedElement element = getElement(hint);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getImage(element);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns 'type' of the ecore object associated with the hint." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ENamedElement getElement(IAdaptable hint) {" + NL + "\t\tObject type = hint.getAdapter(IElementType.class);" + NL + "\t\tif (elements == null) {" + NL + "\t\t\telements = new IdentityHashMap();";
  protected final String TEXT_11 = NL + "\t\t\telements.put(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "());";
  protected final String TEXT_15 = NL + "\t\t\telements.put(";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ".eINSTANCE.get";
  protected final String TEXT_18 = "());";
  protected final String TEXT_19 = NL + "\t\t\telements.put(";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ".eINSTANCE.get";
  protected final String TEXT_22 = "());";
  protected final String TEXT_23 = NL + "\t\t}" + NL + "\t\treturn (ENamedElement) elements.get(type);" + NL + "\t}";
  protected final String TEXT_24 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_25 = " = new MetamodelType(" + NL + "\t\t\"";
  protected final String TEXT_26 = "\", null, \"";
  protected final String TEXT_27 = "\",";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".eINSTANCE.get";
  protected final String TEXT_30 = "(),";
  protected final String TEXT_31 = NL + "\t\tnull,";
  protected final String TEXT_32 = NL + "\t\tnew NullEditHelper());";
  protected final String TEXT_33 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IElementType ";
  protected final String TEXT_34 = " = getElementType(\"";
  protected final String TEXT_35 = "\");";
  protected final String TEXT_36 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_37 = " = new HintedMetamodelType(\"";
  protected final String TEXT_38 = "\", \"";
  protected final String TEXT_39 = "\",";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = ".eINSTANCE.get";
  protected final String TEXT_42 = "(),";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = ".VISUAL_ID);";
  protected final String TEXT_45 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static IElementType getElementType(String id) {" + NL + "\t\treturn ElementTypeRegistry.getInstance().getType(id);" + NL + "\t}";
  protected final String TEXT_46 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void register() {";
  protected final String TEXT_47 = NL + "\t\tElementTypeRegistry.getInstance().register(";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t}";
  protected final String TEXT_50 = NL + "\t" + NL + "\t/** " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class HintedMetamodelType extends MetamodelType implements IHintedType {" + NL + "" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate String mySemanticHint;" + NL + "" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic HintedMetamodelType(String id, String displayName, EClass eClass, String semanticHint) {" + NL + "\t\t\tsuper(id, null, displayName, eClass, new NullEditHelper());" + NL + "\t\t\tmySemanticHint = semanticHint;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic HintedMetamodelType(String id, String displayName, String semanticHint) {" + NL + "\t\t\tthis(id, displayName, null, semanticHint);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + " \t\tpublic String getSemanticHint() {" + NL + " \t\t\treturn mySemanticHint;" + NL + " \t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class NullEditHelper extends ";
  protected final String TEXT_51 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ICommand getEditCommand(IEditCommandRequest req) {" + NL + "\t\t\tif (!(req instanceof ConfigureRequest)) {" + NL + "\t\t\t\t";
  protected final String TEXT_52 = ".getInstance().logError(\"unserved request \" + req);" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IElementType ";
  protected final String TEXT_55 = " = getElementType(\"";
  protected final String TEXT_56 = "\");";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IElementType ";
  protected final String TEXT_59 = " = getElementType(\"";
  protected final String TEXT_60 = "\");";
  protected final String TEXT_61 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static IElementType getElementType(String id) {" + NL + "\t\treturn ElementTypeRegistry.getInstance().getType(id);" + NL + "\t}";
  protected final String TEXT_62 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Initializers {";
  protected final String TEXT_63 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final ObjectInitializer ";
  protected final String TEXT_64 = " = new ObjectInitializer(new FeatureInitializer[] {";
  protected final String TEXT_65 = NL + "\t\t\tnew FeatureInitializer(\"";
  protected final String TEXT_66 = "\", //$NON-NLS-1$" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = ".eINSTANCE.get";
  protected final String TEXT_68 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = ".eINSTANCE.get";
  protected final String TEXT_70 = "())";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL + "\t\t});";
  protected final String TEXT_73 = NL + "\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate Initializers() {" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tpublic static class ObjectInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate FeatureInitializer[] initExpressions;\t" + NL + "\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tObjectInitializer(FeatureInitializer[] initExpressions) {" + NL + "\t\t\t\tthis.initExpressions = initExpressions;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_74 = " instance) {" + NL + "\t\t\t\tfor (int i = 0; i < initExpressions.length; i++) {" + NL + "\t\t\t\t\tFeatureInitializer nextExpr = initExpressions[i];" + NL + "\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} // end of ObjectInitializer" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tstatic class FeatureInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_75 = " contextClass;\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_76 = " sFeature;" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprivate ";
  protected final String TEXT_77 = " expressionBody;\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_78 = " query;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tFeatureInitializer(";
  protected final String TEXT_79 = " expression, " + NL + "\t\t\t\t";
  protected final String TEXT_80 = " context, " + NL + "\t\t\t\t";
  protected final String TEXT_81 = " sFeature) {" + NL + "\t\t\t\tthis.sFeature = sFeature;" + NL + "\t\t\t\tthis.expressionBody = expression;" + NL + "\t\t\t\tthis.contextClass\t= context;" + NL + "\t\t\t}" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tvoid init(";
  protected final String TEXT_82 = " contextInstance) {" + NL + "\t\t\t\tif(this.query == null) {" + NL + "\t\t\t\t\tthis.query = ";
  protected final String TEXT_83 = ".eINSTANCE.createQuery(expressionBody, contextClass);\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tObject value = query.evaluate(contextInstance);" + NL + "\t\t\t\tif(sFeature.getEType() instanceof ";
  protected final String TEXT_84 = " && " + NL + "\t\t\t\t\tvalue instanceof ";
  protected final String TEXT_85 = ") {" + NL + "\t\t\t\t\tvalue = ((";
  protected final String TEXT_86 = ")value).getInstance();" + NL + "\t\t\t\t} else if(value != null && sFeature.isMany()) {" + NL + "\t\t\t\t\tvalue = new ";
  protected final String TEXT_87 = "((";
  protected final String TEXT_88 = ")value);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tcontextInstance.eSet(sFeature, value);" + NL + "\t\t\t}" + NL + "\t\t} // end of FeatureInitializer" + NL + "\t\t\t\t" + NL + "\t} // end of Initializers";
  protected final String TEXT_89 = NL + "}";
  protected final String TEXT_90 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
importManager.addImport("java.util.IdentityHashMap");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.ENamedElement");
importManager.addImport("org.eclipse.emf.ecore.EStructuralFeature");
importManager.addImport("org.eclipse.gmf.runtime.common.core.command.ICommand");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.IElementType");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.IMetamodelType");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.IHintedType");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.MetamodelType");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest");
importManager.addImport("org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest");
importManager.addImport("org.eclipse.jface.resource.ImageDescriptor");
importManager.addImport("org.eclipse.jface.resource.ImageRegistry");
importManager.addImport("org.eclipse.swt.graphics.Image");
importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getElementTypesClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getElementTypesClassName());
    stringBuffer.append(TEXT_8);
    
String pluginClassName = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());

    stringBuffer.append(TEXT_9);
    stringBuffer.append(pluginClassName);
    stringBuffer.append(TEXT_10);
    
GenClass diagramElement = genDiagram.getDomainDiagramElement();
if (diagramElement != null) {
	String semanticPackageInterfaceName = importManager.getImportedName(diagramElement.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(diagramElement.getClassifierAccessorName());
    stringBuffer.append(TEXT_14);
    
}
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	String id = null;
	ModelFacet modelFacet = null;
	if (next instanceof GenNode) {
		id = ((GenNode) next).getUniqueIdentifier();
		modelFacet = ((GenNode) next).getModelFacet();
	} else if (next instanceof GenLink) {
		id = ((GenLink) next).getUniqueIdentifier();
		modelFacet = ((GenLink) next).getModelFacet();
	}
	if (modelFacet instanceof TypeModelFacet) {
		GenClass metaClass = ((TypeModelFacet) modelFacet).getMetaClass();
		String semanticPackageInterfaceName = importManager.getImportedName(metaClass.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(metaClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_18);
    
	} else if (modelFacet instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) modelFacet).getMetaFeature();
		String semanticPackageInterfaceName = importManager.getImportedName(metaFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_19);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_22);
    
	}
}

    stringBuffer.append(TEXT_23);
    
int elementInitializerCount = 0;
if(false) { // register element types in code

    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genDiagram.getClassNamePrefix());
    stringBuffer.append(TEXT_27);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_30);
    } else {
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
List types = new ArrayList(); // element types that should be registered in code
List registeredTypes = new ArrayList(); // element types registered via plugin.xml
// TODO : create diagram specialization type otherwise and register it
if (genDiagram.getDomainDiagramElement() != null) {
	types.add(genDiagram.getUniqueIdentifier());
}
elementInitializerCount = 0;
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	String id;
	TypeModelFacet typeModelFacet = null;
	String semanticEntityInterfaceName = null;
	String semanticPackageInterfaceName = null;
	if (next instanceof GenNode) {
		id = ((GenNode) next).getUniqueIdentifier();
		types.add(id);
		typeModelFacet = ((GenNode) next).getModelFacet();
		semanticEntityInterfaceName = typeModelFacet.getMetaClass().getClassifierAccessorName();
		semanticPackageInterfaceName = importManager.getImportedName(typeModelFacet.getMetaClass().getGenPackage().getQualifiedPackageInterfaceName());
	} else if (next instanceof GenLink) {
		id = ((GenLink) next).getUniqueIdentifier();
		ModelFacet modelFacet = ((GenLink) next).getModelFacet();
		if (modelFacet == null) {
			registeredTypes.add(id);
		} else {
			types.add(id);
			if (modelFacet instanceof TypeLinkModelFacet) {
				typeModelFacet = (TypeLinkModelFacet) ((GenLink) next).getModelFacet();
				semanticEntityInterfaceName = typeModelFacet.getMetaClass().getClassifierAccessorName();
				semanticPackageInterfaceName = importManager.getImportedName(typeModelFacet.getMetaClass().getGenPackage().getQualifiedPackageInterfaceName());
			}
		}
	} else {
		continue;
	}
	GenCommonBase nextCommonBase = (GenCommonBase) next;
	
	if (typeModelFacet != null && typeModelFacet.getModelElementInitializer() != null) {
		elementInitializerCount++;
	}
	if (registeredTypes.contains(id)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_35);
    	} else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(nextCommonBase.getClassNamePrefix());
    stringBuffer.append(TEXT_39);
    		if (semanticEntityInterfaceName != null) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(semanticEntityInterfaceName);
    stringBuffer.append(TEXT_42);
    		}
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    
	}
}
if (!registeredTypes.isEmpty()) {

    stringBuffer.append(TEXT_45);
    
}
if (!types.isEmpty()) {

    stringBuffer.append(TEXT_46);
    	for (int i = 0; i < types.size(); i++) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(types.get(i));
    stringBuffer.append(TEXT_48);
    	}
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_52);
    } else { // register element types in xml

GenCommonBase genElement = genDiagram;
    stringBuffer.append(TEXT_53);
    if (genElement.getElementType() != null) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genElement.getElementType().getUniqueIdentifier());
    stringBuffer.append(TEXT_56);
    }
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	TypeModelFacet typeModelFacet = null;
	if (next instanceof GenNode) {
		genElement = (GenCommonBase) next;
		typeModelFacet = ((GenNode) next).getModelFacet();
	} else if (next instanceof GenLink) {
		genElement = (GenCommonBase) next;
		ModelFacet modelFacet = ((GenLink) next).getModelFacet();
		if (modelFacet instanceof TypeLinkModelFacet) {
			typeModelFacet = (TypeLinkModelFacet) ((GenLink) next).getModelFacet();
		}
	} else {
		continue;
	}
	if (typeModelFacet != null && typeModelFacet.getModelElementInitializer() != null) {
		elementInitializerCount++;
	}

    stringBuffer.append(TEXT_57);
    if (genElement.getElementType() != null) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genElement.getElementType().getUniqueIdentifier());
    stringBuffer.append(TEXT_60);
    }
    }
    stringBuffer.append(TEXT_61);
    }
    if(elementInitializerCount > 0) {
    stringBuffer.append(TEXT_62);
    
for (Iterator it = genDiagram.eAllContents(); it.hasNext(); ) {
	Object next = it.next();
	String id = null;
	TypeModelFacet modelFacet = null;
	if (next instanceof GenNode) {
		id = ((GenNode) next).getUniqueIdentifier();
		modelFacet = ((GenNode) next).getModelFacet();
	} else if (next instanceof GenLink && ((GenLink) next).getModelFacet() instanceof TypeLinkModelFacet) {
		id = ((GenLink) next).getUniqueIdentifier();
		modelFacet = (TypeLinkModelFacet) ((GenLink) next).getModelFacet();
	}
	if (modelFacet != null && modelFacet.getModelElementInitializer() instanceof GenFeatureSeqInitializer) {				
		GenFeatureSeqInitializer ftInitializer = (GenFeatureSeqInitializer)modelFacet.getModelElementInitializer();

    stringBuffer.append(TEXT_63);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_64);
    
		for(Iterator featInitIt = ftInitializer.getInitializers().iterator(); featInitIt.hasNext();) { 
			GenFeatureValueSpec featureValSpec = (GenFeatureValueSpec)featInitIt.next();
    stringBuffer.append(TEXT_65);
    stringBuffer.append(featureValSpec.getBody());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(ftInitializer.getElementQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ftInitializer.getElementClassAccessorName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(featureValSpec.getFeatureQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(featureValSpec.getFeature().getFeatureAccessorName()
						);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(featInitIt.hasNext() ? "," : "");
    stringBuffer.append(TEXT_71);
    
		} // end of GenFeatureValueSpec iteration

    stringBuffer.append(TEXT_72);
    
	} // end of GenFeatureSeqInitializer 
} // end of getGenEntities iteration

    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.QueryFactory"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnum"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnumLiteral"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnumLiteral"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_90);
    return stringBuffer.toString();
  }
}
