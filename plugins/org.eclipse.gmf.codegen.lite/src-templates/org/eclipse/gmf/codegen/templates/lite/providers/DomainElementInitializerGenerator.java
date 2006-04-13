package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;

public class DomainElementInitializerGenerator
{
  protected static String nl;
  public static synchronized DomainElementInitializerGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DomainElementInitializerGenerator result = new DomainElementInitializerGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class DomainElementInitializer ";
  protected final String TEXT_5 = "{" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static interface IElementInitializer {" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_6 = " instance);" + NL + "\t}" + NL;
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static IElementInitializer NULL_INITIALIZER = new IElementInitializer() {" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_8 = " instance) {" + NL + "\t\t}" + NL + "\t};" + NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IElementInitializer ";
  protected final String TEXT_10 = " = NULL_INITIALIZER;";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IElementInitializer ";
  protected final String TEXT_12 = " = new ObjectInitializer(new FeatureInitializer[] {";
  protected final String TEXT_13 = NL + "\t\t\tnew FeatureInitializer(\"";
  protected final String TEXT_14 = "\", //$NON-NLS-1$" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_15 = ".eINSTANCE.get";
  protected final String TEXT_16 = "()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_17 = ".eINSTANCE.get";
  protected final String TEXT_18 = "())";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + "\t});";
  protected final String TEXT_22 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ObjectInitializer implements IElementInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate FeatureInitializer[] initExpressions;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tObjectInitializer(FeatureInitializer[] initExpressions) {" + NL + "\t\t\tthis.initExpressions = initExpressions;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_23 = " instance) {" + NL + "\t\t\tfor (int i = 0; i < initExpressions.length; i++) {" + NL + "\t\t\t\tFeatureInitializer nextExpr = initExpressions[i];" + NL + "\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic class FeatureInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_24 = " contextClass;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_25 = " sFeature;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_26 = " expressionBody;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_27 = " query;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tFeatureInitializer(";
  protected final String TEXT_28 = " expression, " + NL + "\t\t\t";
  protected final String TEXT_29 = " context, " + NL + "\t\t\t";
  protected final String TEXT_30 = " sFeature) {" + NL + "\t\t\tthis.sFeature = sFeature;" + NL + "\t\t\tthis.expressionBody = expression;" + NL + "\t\t\tthis.contextClass\t= context;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tvoid init(";
  protected final String TEXT_31 = " contextInstance) {" + NL + "\t\t\tif(this.query == null) {" + NL + "\t\t\t\tthis.query = ";
  protected final String TEXT_32 = ".eINSTANCE.createQuery(expressionBody, contextClass);" + NL + "\t\t\t}" + NL + "\t\t\tObject value = query.evaluate(contextInstance);" + NL + "\t\t\tif(sFeature.getEType() instanceof ";
  protected final String TEXT_33 = " && " + NL + "\t\t\t\tvalue instanceof ";
  protected final String TEXT_34 = ") {" + NL + "\t\t\t\tvalue = ((";
  protected final String TEXT_35 = ")value).getInstance();" + NL + "\t\t\t} else if(value != null && sFeature.isMany()) {" + NL + "\t\t\t\tvalue = new ";
  protected final String TEXT_36 = "((";
  protected final String TEXT_37 = ")value);" + NL + "\t\t\t}" + NL + "\t\t\tcontextInstance.eSet(sFeature, value);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_38 = NL + "}";
  protected final String TEXT_39 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    /*XXX: class name should be customizable!*/
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_6);
    
boolean needsNullInitializer = false;
boolean needsOCLInitializer = false;
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
	if (modelFacet == null) {
		continue;
	}
	GenElementInitializer elementInitializer = modelFacet.getModelElementInitializer();
	if (elementInitializer instanceof GenFeatureSeqInitializer == false) {
		if (!needsNullInitializer) {
			needsNullInitializer = true;

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_8);
    
		}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_10);
    
		continue;
	}
	needsOCLInitializer = true;
	GenFeatureSeqInitializer ftInitializer = (GenFeatureSeqInitializer) elementInitializer;

    stringBuffer.append(TEXT_11);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_12);
    
		for(Iterator featInitIt = ftInitializer.getInitializers().iterator(); featInitIt.hasNext();) { 
			GenFeatureValueSpec featureValSpec = (GenFeatureValueSpec)featInitIt.next();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(featureValSpec.getBody());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(ftInitializer.getElementQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ftInitializer.getElementClassAccessorName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(featureValSpec.getFeatureQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(featureValSpec.getFeature().getFeatureAccessorName()
						);
    stringBuffer.append(TEXT_18);
    if (featInitIt.hasNext()) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
		} // end of GenFeatureValueSpec iteration

    stringBuffer.append(TEXT_21);
    
}
if (needsOCLInitializer) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.QueryFactory"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnum"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnumLiteral"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EEnumLiteral"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_37);
    
}

    stringBuffer.append(TEXT_38);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
