package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ElementInitializersGenerator
{
  protected static String nl;
  public static synchronized ElementInitializersGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ElementInitializersGenerator result = new ElementInitializersGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {";
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tprivate static final ObjectInitializer ";
  protected final String TEXT_7 = " = new ObjectInitializer(new FeatureInitializer[] {" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tnew FeatureInitializer(\"";
  protected final String TEXT_9 = "\", //$NON-NLS-1$" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = ".eINSTANCE.get";
  protected final String TEXT_11 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "())";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "\t});";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tpublic static final void ";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = " element) {" + NL + "\t\t";
  protected final String TEXT_20 = ".init(element);" + NL + "\t}";
  protected final String TEXT_21 = NL + NL + "\t/** " + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate ";
  protected final String TEXT_22 = "() {" + NL + "\t}" + NL + "\t";
  protected final String TEXT_23 = NL + "\t/** " + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static class ObjectInitializer {" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate FeatureInitializer[] initExpressions;\t" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tObjectInitializer(FeatureInitializer[] initExpressions) {" + NL + "\t\t\tthis.initExpressions = initExpressions;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tvoid init(";
  protected final String TEXT_24 = " instance) {" + NL + "\t\t\tfor (int i = 0; i < initExpressions.length; i++) {" + NL + "\t\t\t\tFeatureInitializer nextExpr = initExpressions[i];" + NL + "\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/** " + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static class FeatureInitializer {" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_25 = " contextClass;\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_26 = " sFeature;" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_27 = " expressionBody;\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_28 = " query;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tFeatureInitializer(";
  protected final String TEXT_29 = " expression, " + NL + "\t\t\t";
  protected final String TEXT_30 = " context, " + NL + "\t\t\t";
  protected final String TEXT_31 = " sFeature) {" + NL + "\t\t\tthis.sFeature = sFeature;" + NL + "\t\t\tthis.expressionBody = expression;" + NL + "\t\t\tthis.contextClass\t= context;" + NL + "\t\t}" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tvoid init(";
  protected final String TEXT_32 = " contextInstance) {" + NL + "\t\t\tif(this.query == null) {" + NL + "\t\t\t\tthis.query = ";
  protected final String TEXT_33 = ".eINSTANCE.createQuery(expressionBody, contextClass);\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tObject value = query.evaluate(contextInstance);" + NL + "\t\t\tcontextInstance.eSet(sFeature, value);\t\t" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_34 = NL + "}";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getElementInitializersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getElementInitializersClassName());
    stringBuffer.append(TEXT_5);
    
for(Iterator it = AccessUtil.getGenEntities(genDiagram); it.hasNext();) {
	EObject nextElement = (EObject)it.next();
	GenBaseElement  genElement = nextElement instanceof GenBaseElement ? (GenBaseElement) nextElement : null;
	if(genElement == null || genElement.getModelElementInitializer() == null) continue;	
		
	GenElementInitializer initializer = genElement.getModelElementInitializer();
	if(initializer instanceof GenFeatureSeqInitializer) {
		GenFeatureSeqInitializer ftInitializer = (GenFeatureSeqInitializer)initializer;
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(initializer.getElement().getUniqueIdentifier());
    stringBuffer.append(TEXT_7);
     for(Iterator featInitIt = ftInitializer.getInitializers().iterator(); featInitIt.hasNext();) { 
				GenFeatureValueSpec featureValSpec = (GenFeatureValueSpec)featInitIt.next();
    stringBuffer.append(TEXT_8);
    stringBuffer.append(featureValSpec.getBody());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(ftInitializer.getElementQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ftInitializer.getElementClassAccessorName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(featureValSpec.getFeatureQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(featureValSpec.getFeature().getFeatureAccessorName()
					);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(featInitIt.hasNext() ? "," : "");
    stringBuffer.append(TEXT_14);
    	}
		} 
    stringBuffer.append(TEXT_15);
    	} // end of FeatureSeqInitializer

    stringBuffer.append(TEXT_16);
    	int initializerCount = 0;
	for(Iterator it = AccessUtil.getGenEntities(genDiagram); it.hasNext();) {
		EObject nextElement = (EObject)it.next();
		GenBaseElement  genElement = nextElement instanceof GenBaseElement ? (GenBaseElement) nextElement : null;
		if(genElement == null || genElement.getModelElementInitializer() == null) continue;	
		
		GenElementInitializer initializer = genElement.getModelElementInitializer();
		initializerCount++;	
	
    stringBuffer.append(TEXT_17);
    stringBuffer.append(initializer.getInitializerMethodName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(initializer.getElement().getUniqueIdentifier());
    stringBuffer.append(TEXT_20);
    	}
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genDiagram.getElementInitializersClassName());
    stringBuffer.append(TEXT_22);
    if(initializerCount > 0){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.QueryFactory"));
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
