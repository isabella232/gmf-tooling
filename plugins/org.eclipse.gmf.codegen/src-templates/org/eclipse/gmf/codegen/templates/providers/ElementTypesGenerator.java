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
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.ENamedElement;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.jface.resource.ImageRegistry;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ElementTypes {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageRegistry imageRegistry;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageRegistry getImageRegistry() {" + NL + "\t\tif (imageRegistry == null) {" + NL + "\t\t\timageRegistry = new ImageRegistry();" + NL + "\t\t}" + NL + "\t\treturn imageRegistry;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static String getImageRegistryKey(ENamedElement element) {" + NL + "\t\treturn element.getName();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {" + NL + "\t\tif (element instanceof EStructuralFeature) {" + NL + "\t\t\telement = ((EStructuralFeature) element).getEContainingClass();" + NL + "\t\t}" + NL + "\t\tif (element instanceof EClass) {";
  protected final String TEXT_5 = NL + "\t\t\treturn ";
  protected final String TEXT_6 = ".getInstance().getItemImageDescriptor(" + NL + "\t\t\t\t";
  protected final String TEXT_7 = ".eINSTANCE.create((EClass) element));" + NL + "\t\t}" + NL + "\t\t// TODO : support structural features" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(ENamedElement element) {" + NL + "\t\tString key = getImageRegistryKey(element);" + NL + "\t\tImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);" + NL + "\t\tif (imageDescriptor == null) {" + NL + "\t\t\timageDescriptor = getProvidedImageDescriptor(element);" + NL + "\t\t\tif (imageDescriptor == null) {" + NL + "\t\t\t\timageDescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t\t}" + NL + "\t\t\tgetImageRegistry().put(key, imageDescriptor);" + NL + "\t\t}" + NL + "\t\treturn imageDescriptor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Image getImage(ENamedElement element) {" + NL + "\t\tString key = getImageRegistryKey(element);" + NL + "\t\tImage image = getImageRegistry().get(key);" + NL + "\t\tif (image == null) {" + NL + "\t\t\tImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);" + NL + "\t\t\tif (imageDescriptor == null) {" + NL + "\t\t\t\timageDescriptor = ImageDescriptor.getMissingImageDescriptor();" + NL + "\t\t\t}" + NL + "\t\t\tgetImageRegistry().put(key, imageDescriptor);" + NL + "\t\t\timage = getImageRegistry().get(key);" + NL + "\t\t}" + NL + "\t\treturn image;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(IAdaptable hint) {" + NL + "\t\tENamedElement element = getElement(hint);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getImageDescriptor(element);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Image getImage(IAdaptable hint) {" + NL + "\t\tENamedElement element = getElement(hint);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getImage(element);" + NL + "\t}";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * Returns 'type' of the ecore object associated with the hint." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ENamedElement getElement(IAdaptable hint) {" + NL + "\t\tObject type = hint.getAdapter(IElementType.class);" + NL + "\t\tif (";
  protected final String TEXT_9 = " == type) {" + NL + "\t\t\treturn ";
  protected final String TEXT_10 = ".eINSTANCE.get";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "\t\t} else if (";
  protected final String TEXT_13 = " == type) {" + NL + "\t\t\treturn ";
  protected final String TEXT_14 = ".eINSTANCE.get";
  protected final String TEXT_15 = "();";
  protected final String TEXT_16 = NL + "\t\t} else if (";
  protected final String TEXT_17 = " == type) {" + NL + "\t\t\treturn ";
  protected final String TEXT_18 = ".eINSTANCE.get";
  protected final String TEXT_19 = "();";
  protected final String TEXT_20 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_21 = " = new MetamodelType(" + NL + "\t\t\"";
  protected final String TEXT_22 = "\", null, \"";
  protected final String TEXT_23 = "\"," + NL + "\t\t";
  protected final String TEXT_24 = ".eINSTANCE.get";
  protected final String TEXT_25 = "()," + NL + "\t\tnew NullEditHelper());";
  protected final String TEXT_26 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_27 = " = new MetamodelType(\"";
  protected final String TEXT_28 = "\", null, \"";
  protected final String TEXT_29 = "\",";
  protected final String TEXT_30 = NL + "\t\t";
  protected final String TEXT_31 = ".eINSTANCE.get";
  protected final String TEXT_32 = "(),";
  protected final String TEXT_33 = NL + "\t\tnull,";
  protected final String TEXT_34 = NL + "\t\tnew NullEditHelper());";
  protected final String TEXT_35 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void register() {";
  protected final String TEXT_36 = NL + "\t\tElementTypeRegistry.getInstance().register(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class NullEditHelper extends ";
  protected final String TEXT_39 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ICommand getEditCommand(IEditCommandRequest req) {" + NL + "\t\t\tif (!(req instanceof ConfigureRequest)) {" + NL + "\t\t\t\tSystem.err.println(\"unserved request \" + req);" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_40 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Initializers {";
  protected final String TEXT_41 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final ObjectInitializer ";
  protected final String TEXT_42 = " = new ObjectInitializer(new FeatureInitializer[] {";
  protected final String TEXT_43 = NL + "\t\t\tnew FeatureInitializer(\"";
  protected final String TEXT_44 = "\", //$NON-NLS-1$" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = ".eINSTANCE.get";
  protected final String TEXT_46 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_47 = ".eINSTANCE.get";
  protected final String TEXT_48 = "())";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t\t});";
  protected final String TEXT_51 = NL + "\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate Initializers() {" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tpublic static class ObjectInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate FeatureInitializer[] initExpressions;\t" + NL + "\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tObjectInitializer(FeatureInitializer[] initExpressions) {" + NL + "\t\t\t\tthis.initExpressions = initExpressions;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_52 = " instance) {" + NL + "\t\t\t\tfor (int i = 0; i < initExpressions.length; i++) {" + NL + "\t\t\t\t\tFeatureInitializer nextExpr = initExpressions[i];" + NL + "\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} // end of ObjectInitializer" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tstatic class FeatureInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_53 = " contextClass;\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_54 = " sFeature;" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprivate ";
  protected final String TEXT_55 = " expressionBody;\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_56 = " query;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tFeatureInitializer(";
  protected final String TEXT_57 = " expression, " + NL + "\t\t\t\t";
  protected final String TEXT_58 = " context, " + NL + "\t\t\t\t";
  protected final String TEXT_59 = " sFeature) {" + NL + "\t\t\t\tthis.sFeature = sFeature;" + NL + "\t\t\t\tthis.expressionBody = expression;" + NL + "\t\t\t\tthis.contextClass\t= context;" + NL + "\t\t\t}" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tvoid init(";
  protected final String TEXT_60 = " contextInstance) {" + NL + "\t\t\t\tif(this.query == null) {" + NL + "\t\t\t\t\tthis.query = ";
  protected final String TEXT_61 = ".eINSTANCE.createQuery(expressionBody, contextClass);\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tObject value = query.evaluate(contextInstance);" + NL + "\t\t\t\tcontextInstance.eSet(sFeature, value);\t\t" + NL + "\t\t\t}" + NL + "\t\t} // end of FeatureInitializer" + NL + "\t\t\t\t" + NL + "\t} // end of Initializers";
  protected final String TEXT_62 = NL + "}";
  protected final String TEXT_63 = NL;

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
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_11);
    
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

    stringBuffer.append(TEXT_12);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(metaClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_15);
    
	} else if (modelFacet instanceof FeatureModelFacet) {
		GenFeature metaFeature = ((FeatureModelFacet) modelFacet).getMetaFeature();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(metaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_19);
    
	}
}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_25);
    
List types = new ArrayList();
types.add(genDiagram.getUniqueIdentifier());
int elementInitializerCount = 0;
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	String id;
	TypeModelFacet typeModelFacet = null;
	String semanticEntityInterfaceName = null;
	if (next instanceof GenNode) {
		id = ((GenNode) next).getUniqueIdentifier();
		typeModelFacet = ((GenNode) next).getModelFacet();
		semanticEntityInterfaceName = typeModelFacet.getMetaClass().getClassifierAccessorName();
	} else if (next instanceof GenLink) {
		id = ((GenLink) next).getUniqueIdentifier();
		if (((GenLink) next).getModelFacet() instanceof TypeLinkModelFacet) {
			typeModelFacet = (TypeLinkModelFacet) ((GenLink) next).getModelFacet();
			semanticEntityInterfaceName = typeModelFacet.getMetaClass().getClassifierAccessorName();
		}
	} else {
		continue;
	}
	types.add(id);
	if (typeModelFacet != null && typeModelFacet.getModelElementInitializer() != null) {
		elementInitializerCount++;
	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_29);
    	if (semanticEntityInterfaceName != null) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(semanticEntityInterfaceName);
    stringBuffer.append(TEXT_32);
    	} else { 
    stringBuffer.append(TEXT_33);
    	}
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    for (int i = 0; i < types.size(); i++) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(types.get(i));
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper"));
    stringBuffer.append(TEXT_39);
    if(elementInitializerCount > 0) {
    stringBuffer.append(TEXT_40);
    
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

    stringBuffer.append(TEXT_41);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_42);
    
		for(Iterator featInitIt = ftInitializer.getInitializers().iterator(); featInitIt.hasNext();) { 
			GenFeatureValueSpec featureValSpec = (GenFeatureValueSpec)featInitIt.next();
    stringBuffer.append(TEXT_43);
    stringBuffer.append(featureValSpec.getBody());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(ftInitializer.getElementQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ftInitializer.getElementClassAccessorName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(featureValSpec.getFeatureQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(featureValSpec.getFeature().getFeatureAccessorName()
						);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(featInitIt.hasNext() ? "," : "");
    stringBuffer.append(TEXT_49);
    
		} // end of GenFeatureValueSpec iteration

    stringBuffer.append(TEXT_50);
    
	} // end of GenFeatureSeqInitializer 
} // end of getGenEntities iteration

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.QueryFactory"));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
