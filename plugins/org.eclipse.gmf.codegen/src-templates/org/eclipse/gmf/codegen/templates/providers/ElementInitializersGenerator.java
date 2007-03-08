package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ElementInitializers {";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Initializers {";
  protected final String TEXT_8 = "\t\t";
  protected final String TEXT_9 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final IObjectInitializer ";
  protected final String TEXT_10 = " = new ObjectInitializer(";
  protected final String TEXT_11 = ") {";
  protected final String TEXT_12 = NL + "\t\tObjectInitializer ";
  protected final String TEXT_13 = "() {" + NL + "\t\t\treturn new ObjectInitializer(";
  protected final String TEXT_14 = ") {";
  protected final String TEXT_15 = NL + "\t\t \tprotected void init() {\t\t\t\t";
  protected final String TEXT_16 = "\t\t\t" + NL + "\t\t\t\tadd(createNewElementFeatureInitializer(";
  protected final String TEXT_17 = ", new ObjectInitializer[] {";
  protected final String TEXT_18 = NL + "\t\t\t\t\t";
  protected final String TEXT_19 = "(), ";
  protected final String TEXT_20 = NL + "\t\t\t\t}));";
  protected final String TEXT_21 = "\t\t\t" + NL + "\t\t\t\tadd(createExpressionFeatureInitializer(";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = "null";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ")";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_32 = ")";
  protected final String TEXT_33 = "new ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_36 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_37 = " self = (";
  protected final String TEXT_38 = ")context;";
  protected final String TEXT_39 = "\t" + NL + "\t\t";
  protected final String TEXT_40 = " ";
  protected final String TEXT_41 = " = (";
  protected final String TEXT_42 = ")env.get(\"";
  protected final String TEXT_43 = "\"); //$NON-NLS-1$";
  protected final String TEXT_44 = NL + "\t\treturn ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = "(self";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_49 = NL + "));";
  protected final String TEXT_50 = "\t\t\t}";
  protected final String TEXT_51 = NL + "\t\t\t\t}; // ";
  protected final String TEXT_52 = " ObjectInitializer" + NL + "\t\t\t}";
  protected final String TEXT_53 = NL + "\t\t}; // ";
  protected final String TEXT_54 = " ObjectInitializer";
  protected final String TEXT_55 = NL + "\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate Initializers() {" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic static interface IObjectInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_56 = " instance);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tpublic static abstract class ObjectInitializer implements IObjectInitializer {" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tfinal ";
  protected final String TEXT_57 = " element;\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_58 = " featureInitializers = new ";
  protected final String TEXT_59 = "();" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tObjectInitializer(";
  protected final String TEXT_60 = " element) {" + NL + "\t\t\t\tthis.element = element;" + NL + "\t\t\t\tinit();" + NL + "\t\t\t}" + NL + "\t\t\t/**" + NL + "\t\t \t * @generated" + NL + "\t\t \t */" + NL + "\t\t \tprotected abstract void init();\t\t\t\t\t\t\t" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tprotected final IFeatureInitializer add(IFeatureInitializer initializer) {" + NL + "\t\t\t\tfeatureInitializers.add(initializer);" + NL + "\t\t\t\treturn initializer;" + NL + "\t\t\t}" + NL + "\t\t\t/** " + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_61 = " instance) {" + NL + "\t\t\t\tfor (java.util.Iterator it = featureInitializers.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tIFeatureInitializer nextExpr = (IFeatureInitializer)it.next();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t\t} catch(RuntimeException e) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_62 = ".getInstance().logError(\"Feature initialization failed\", e); //$NON-NLS-1$\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} // end of ObjectInitializer" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tinterface IFeatureInitializer {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */" + NL + "\t\t\tvoid init(EObject contextInstance);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tstatic IFeatureInitializer createNewElementFeatureInitializer(";
  protected final String TEXT_63 = " initFeature, ObjectInitializer[] newObjectInitializers) {" + NL + "\t\t\tfinal ";
  protected final String TEXT_64 = " feature = initFeature;" + NL + "\t\t\tfinal ObjectInitializer[] initializers = newObjectInitializers;" + NL + "\t\t\treturn new IFeatureInitializer() {" + NL + "\t\t\t\tpublic void init(EObject contextInstance) {" + NL + "\t\t\t\t\tfor (int i = 0; i < initializers.length; i++) {" + NL + "\t\t\t\t\t\tEObject newInstance = initializers[i].element.getEPackage().getEFactoryInstance().create(initializers[i].element);" + NL + "\t\t\t\t\t\tif(feature.isMany()) {" + NL + "\t\t\t\t\t\t\t((";
  protected final String TEXT_65 = ")contextInstance.eGet(feature)).add(newInstance);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tcontextInstance.eSet(feature, newInstance);" + NL + "\t\t\t\t\t\t}\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tinitializers[i].init(newInstance);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tstatic IFeatureInitializer createExpressionFeatureInitializer(";
  protected final String TEXT_66 = " initFeature, ";
  protected final String TEXT_67 = " valueExpression) {" + NL + "\t\t\tfinal ";
  protected final String TEXT_68 = " feature = initFeature;" + NL + "\t\t\tfinal ";
  protected final String TEXT_69 = " expression = valueExpression;" + NL + "\t\t\treturn new IFeatureInitializer() {\t\t\t\t" + NL + "\t\t\t\tpublic void init(EObject contextInstance) {" + NL + "\t\t\t\t\texpression.assignTo(feature, contextInstance);" + NL + "\t\t\t\t}" + NL + "\t\t\t};\t\t\t" + NL + "\t\t}\t\t";
  protected final String TEXT_70 = NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class ";
  protected final String TEXT_71 = " {";
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_74 = " ";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = " self";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_80 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_81 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_82 = NL + "\t\t} //";
  protected final String TEXT_83 = NL + "\t} // end of Initializers";
  protected final String TEXT_84 = NL + "}";
  protected final String TEXT_85 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.registerInnerClass("Initializers");
importManager.registerInnerClass("IObjectInitializer");
importManager.registerInnerClass("ObjectInitializer");
importManager.registerInnerClass("IFeatureInitializer");
final String javaExprContainer = "Java";
importManager.registerInnerClass(javaExprContainer);

    stringBuffer.append(TEXT_5);
    importManager.markImportLocation(stringBuffer);
    String pluginClassName = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_6);
    
int elementInitializerCount = 0;
List elements = new LinkedList();
if (genDiagram.getElementType() != null) {
	elements.add(genDiagram);
}
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	GenCommonBase genElement;
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
	if (genElement.getElementType() != null) {
		elements.add(genElement);
	}
}
if(elementInitializerCount > 0 && genDiagram.getEditorGen().getExpressionProviders() != null) {
	final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
	final LinkedHashSet<GenFeatureValueSpec> javaInitializers = new LinkedHashSet<GenFeatureValueSpec>();
	final String __javaOperationContainer = javaExprContainer; // place java expression methods here
	final Map __exprEnvVariables = Collections.EMPTY_MAP;

    stringBuffer.append(TEXT_7);
    
for (Map.Entry<TypeModelFacet, GenCommonBase> next : genDiagram.getTypeModelFacet2GenBaseMap().entrySet()) {
	TypeModelFacet modelFacet = next.getKey();
	if (modelFacet.getModelElementInitializer() instanceof GenFeatureSeqInitializer) {
		GenFeatureSeqInitializer rootFtSeqInitializer = (GenFeatureSeqInitializer)modelFacet.getModelElementInitializer();				
		javaInitializers.addAll(rootFtSeqInitializer.getJavaExpressionFeatureInitializers(expressionProviders));
		String id = next.getValue().getUniqueIdentifier();
		for(GenFeatureSeqInitializer nextFtSeqInitializer : rootFtSeqInitializer.getAllFeatureSeqInitializers()) {
			boolean isTopLevelObjInit = nextFtSeqInitializer == rootFtSeqInitializer;

    stringBuffer.append(TEXT_8);
    			if(isTopLevelObjInit){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(nextFtSeqInitializer.getElementClassAccessor(importManager));
    stringBuffer.append(TEXT_11);
    			} else {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(nextFtSeqInitializer.getElementClassAccessor(importManager));
    stringBuffer.append(TEXT_14);
    			} 
    stringBuffer.append(TEXT_15);
    			for(GenFeatureInitializer nextFtInitializer : (List<GenFeatureInitializer>)nextFtSeqInitializer.getInitializers()) {
				String metaFeatureAccessor = nextFtSeqInitializer.getFeatureAccessor(nextFtInitializer, importManager);
				if(nextFtInitializer instanceof GenReferenceNewElementSpec) {
					GenReferenceNewElementSpec newElementSpec = (GenReferenceNewElementSpec)nextFtInitializer;

    stringBuffer.append(TEXT_16);
    stringBuffer.append(metaFeatureAccessor);
    stringBuffer.append(TEXT_17);
    					for(GenFeatureSeqInitializer newElemInit : (List<GenFeatureSeqInitializer>)newElementSpec.getNewElementInitializers()) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(newElemInit.getInitializerFieldName(id));
    stringBuffer.append(TEXT_19);
    					} // end of newElementInitializers 
    stringBuffer.append(TEXT_20);
    				} // end of GenReferenceNewElementSpec
				else if(nextFtInitializer instanceof GenFeatureValueSpec) {
					String __outEnvVarName = ""; // no env to setup;
					GenClassifier __genExprContext = nextFtSeqInitializer.getElementClass();
					GenFeatureValueSpec __genValueExpression = (GenFeatureValueSpec)nextFtInitializer;

    stringBuffer.append(TEXT_21);
    stringBuffer.append(metaFeatureAccessor);
    stringBuffer.append(TEXT_22);
    
{ /*begin the scope*/
/*
ValueExpression __genValueExpression;
GenClassifier __genExprContext
java.util.Map __exprEnvVariables
String __outEnvVarName;
String __javaOperationContainer;
*/
	org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
	String __ctxEClassifierAccess = importManager.getImportedName(__genExprContext.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + __genExprContext.getClassifierAccessorName()+"()";
	String __importedAbstractClass = __genExprProvider != null ? importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName()) : null;

	if(__genExprProvider == null || __importedAbstractClass == null) {

    stringBuffer.append(TEXT_23);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_28);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_32);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_33);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_38);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_43);
    		} 
    stringBuffer.append(TEXT_44);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_45);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_46);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_47);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_48);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_49);
    
				} // end of GenFeatureValueSpec
			} // end of GenFeatureInitializer iteration

    stringBuffer.append(TEXT_50);
    			if(!isTopLevelObjInit) { 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_52);
    			} // GenFeatureInitializer iteration
		} // All GenFeatureSeqInitializer iteration

    stringBuffer.append(TEXT_53);
    stringBuffer.append(rootFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_54);
    
	} // (modelFacet.getModelElementInitializer() instanceof GenFeatureSeqInitializer)
}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(pluginClassName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_69);
    
	if(!javaInitializers.isEmpty()) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_71);
    
		for(GenFeatureValueSpec __genValueExpression : javaInitializers) {
			GenClassifier __genExprContext = __genValueExpression.getFeatureSeqInitializer().getElementClass();
			GenExpressionProviderBase provider = expressionProviders.getProvider(__genValueExpression);
			if(!(provider instanceof GenJavaExpressionProvider)) continue;
			String __genExprResultType = provider.getQualifiedTypeInstanceClassName(__genValueExpression.getFeature());

    stringBuffer.append(TEXT_72);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String __importedAbstractExpr = importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName());
	String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = __genExprProvider.getQualifiedInstanceClassName((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj);
	String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);

    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_76);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_79);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_81);
    
} /* end of GenJavaExpressionProvider */

    
		}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(javaExprContainer);
    	} /* end of javaInitializers */ 
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_85);
    return stringBuffer.toString();
  }
}
