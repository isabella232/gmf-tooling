package org.eclipse.gmf.codegen.templates.lite.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

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
  protected final String TEXT_5 = "{" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static interface IElementInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_6 = " instance);" + NL + "\t}" + NL;
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static IElementInitializer NULL_INITIALIZER = new IElementInitializer() {" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_8 = " instance) {" + NL + "\t\t}" + NL + "\t};" + NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IElementInitializer ";
  protected final String TEXT_10 = " = NULL_INITIALIZER;";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IElementInitializer ";
  protected final String TEXT_12 = " = new ObjectInitializer(new FeatureInitializer[] {";
  protected final String TEXT_13 = NL + "\t\t\tnew FeatureInitializer(" + NL + "\t\t\t\t";
  protected final String TEXT_14 = "null";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_23 = ")";
  protected final String TEXT_24 = "new ";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_27 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_28 = " self = (";
  protected final String TEXT_29 = ")context;";
  protected final String TEXT_30 = "\t" + NL + "\t\t";
  protected final String TEXT_31 = " ";
  protected final String TEXT_32 = " = (";
  protected final String TEXT_33 = ")env.get(\"";
  protected final String TEXT_34 = "\"); //$NON-NLS-1$";
  protected final String TEXT_35 = NL + "\t\treturn ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = "(self";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_40 = NL + "," + NL + "\t\t\t\t";
  protected final String TEXT_41 = ")";
  protected final String TEXT_42 = NL + "\t\t});";
  protected final String TEXT_43 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ObjectInitializer implements IElementInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate FeatureInitializer[] initExpressions;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tObjectInitializer(FeatureInitializer[] initExpressions) {" + NL + "\t\t\tthis.initExpressions = initExpressions;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_44 = " instance) {" + NL + "\t\t\tfor (int i = 0; i < initExpressions.length; i++) {" + NL + "\t\t\t\tFeatureInitializer nextExpr = initExpressions[i];" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t} catch (RuntimeException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = ".getInstance().logError(\"Feature initialization failed\", e);\t//$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic class FeatureInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_46 = " sFeature;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_47 = " expression;\t\t" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tFeatureInitializer(";
  protected final String TEXT_48 = " expression, " + NL + "\t\t\t";
  protected final String TEXT_49 = " sFeature) {" + NL + "\t\t\tthis.sFeature = sFeature;" + NL + "\t\t\tthis.expression = expression;" + NL + "\t\t}" + NL + "" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tvoid init(";
  protected final String TEXT_50 = " contextInstance) {" + NL + "\t\t\texpression.assignTo(sFeature, contextInstance);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_51 = NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class ";
  protected final String TEXT_52 = " {";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = " self";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_61 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_62 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_63 = NL + "\t\t} //";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_66 = " {";
  protected final String TEXT_67 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tpublic static final ";
  protected final String TEXT_68 = " ";
  protected final String TEXT_69 = " = create";
  protected final String TEXT_70 = "();";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_73 = " create";
  protected final String TEXT_74 = "() {";
  protected final String TEXT_75 = NL;
  protected final String TEXT_76 = " ";
  protected final String TEXT_77 = " = new ";
  protected final String TEXT_78 = "(3);";
  protected final String TEXT_79 = ".put(\"";
  protected final String TEXT_80 = "\", ";
  protected final String TEXT_81 = "); //$NON-NLS-1$";
  protected final String TEXT_82 = NL + "\t\t\t";
  protected final String TEXT_83 = " sourceExpression = ";
  protected final String TEXT_84 = "null";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ")";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = "(";
  protected final String TEXT_92 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_93 = ")";
  protected final String TEXT_94 = "new ";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_97 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_98 = " self = (";
  protected final String TEXT_99 = ")context;";
  protected final String TEXT_100 = "\t" + NL + "\t\t";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = " = (";
  protected final String TEXT_103 = ")env.get(\"";
  protected final String TEXT_104 = "\"); //$NON-NLS-1$";
  protected final String TEXT_105 = NL + "\t\treturn ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = "(self";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_110 = "null";
  protected final String TEXT_111 = ";";
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = " ";
  protected final String TEXT_114 = " = new ";
  protected final String TEXT_115 = "(3);";
  protected final String TEXT_116 = ".put(\"";
  protected final String TEXT_117 = "\", ";
  protected final String TEXT_118 = "); //$NON-NLS-1$";
  protected final String TEXT_119 = NL + "\t\t\t";
  protected final String TEXT_120 = " targetExpression = ";
  protected final String TEXT_121 = "null";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = "(";
  protected final String TEXT_124 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ")";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = "(";
  protected final String TEXT_129 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_130 = ")";
  protected final String TEXT_131 = "new ";
  protected final String TEXT_132 = "(";
  protected final String TEXT_133 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_134 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_135 = " self = (";
  protected final String TEXT_136 = ")context;";
  protected final String TEXT_137 = "\t" + NL + "\t\t";
  protected final String TEXT_138 = " ";
  protected final String TEXT_139 = " = (";
  protected final String TEXT_140 = ")env.get(\"";
  protected final String TEXT_141 = "\"); //$NON-NLS-1$";
  protected final String TEXT_142 = NL + "\t\treturn ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = "(self";
  protected final String TEXT_145 = ", ";
  protected final String TEXT_146 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_147 = "null";
  protected final String TEXT_148 = ";" + NL + "\t\t\treturn new ";
  protected final String TEXT_149 = "(sourceExpression, targetExpression);" + NL + "\t\t}";
  protected final String TEXT_150 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate static final String OPPOSITE_END_VAR = \"oppositeEnd\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_151 = " srcEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_152 = " targetEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = " sourceEnd, ";
  protected final String TEXT_155 = " targetEnd) {" + NL + "\t\t\tthis.srcEndInv = sourceEnd;\t\t\t" + NL + "\t\t\tthis.targetEndInv = targetEnd;\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tpublic boolean canCreateLink(Object source, Object target, boolean isBackDirected) {" + NL + "\t\t\tif (source != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_156 = " sourceConstraint = isBackDirected ? targetEndInv : srcEndInv;" + NL + "\t\t\t\tif (sourceConstraint != null && !evaluate(sourceConstraint, source, target, false)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (target != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_157 = " targetConstraint = isBackDirected ? srcEndInv : targetEndInv;" + NL + "\t\t\t\tif (targetConstraint != null && !evaluate(targetConstraint, source, target, true)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static boolean evaluate(";
  protected final String TEXT_158 = " constraint, Object sourceEnd, Object oppositeEnd, boolean clearEnv) {" + NL + "\t\t\t";
  protected final String TEXT_159 = " evalEnv = ";
  protected final String TEXT_160 = ".singletonMap(OPPOSITE_END_VAR, oppositeEnd);\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tObject val = constraint.evaluate(sourceEnd, evalEnv);" + NL + "\t\t\t\treturn (val instanceof Boolean) ? ((Boolean) val).booleanValue() : false;" + NL + "\t\t\t} catch(Exception e) {\t" + NL + "\t\t\t\t";
  protected final String TEXT_161 = ".getInstance().logError(\"Link constraint evaluation error\", e); //$NON-NLS-1$" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_162 = "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ";
  protected final String TEXT_163 = " {";
  protected final String TEXT_164 = NL;
  protected final String TEXT_165 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_166 = " ";
  protected final String TEXT_167 = "(";
  protected final String TEXT_168 = " self";
  protected final String TEXT_169 = ", ";
  protected final String TEXT_170 = " ";
  protected final String TEXT_171 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_172 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_173 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_174 = NL;
  protected final String TEXT_175 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_176 = " ";
  protected final String TEXT_177 = "(";
  protected final String TEXT_178 = " self";
  protected final String TEXT_179 = ", ";
  protected final String TEXT_180 = " ";
  protected final String TEXT_181 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_182 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_183 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_184 = NL + "\t} // ";
  protected final String TEXT_185 = "\t\t" + NL + "\t}";
  protected final String TEXT_186 = "\t" + NL + "}";
  protected final String TEXT_187 = NL;

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
    
final String javaExprContainer = "JavaInitializers";
importManager.registerInnerClass(javaExprContainer);
final String javaConstraintsContainer = "JavaConstraints";
importManager.registerInnerClass(javaExprContainer);
importManager.registerInnerClass(genDiagram.getLinkCreationConstraintsClassName());

importManager.emitPackageStatement(stringBuffer);

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    /*XXX: class name should be customizable!*/
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_6);
    
{	//start local block that separates initializers and constraints
boolean needsNullInitializer = false;
boolean needsObjectInitializer = false;
final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
final Map javaInitializers = new HashMap();
final Map __exprEnvVariables = Collections.EMPTY_MAP;
final String __outEnvVarName = ""; // no env to setup;
final String __javaOperationContainer = javaExprContainer; // place java expression methods here
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
	if (elementInitializer instanceof GenFeatureSeqInitializer == false || expressionProviders == null) {
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
	needsObjectInitializer = true;
	GenFeatureSeqInitializer ftInitializer = (GenFeatureSeqInitializer) elementInitializer;

    stringBuffer.append(TEXT_11);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_12);
    
		GenClassifier __genExprContext = ftInitializer.getTypeModelFacet().getMetaClass();
		for(Iterator featInitIt = ftInitializer.getInitializers().iterator(); featInitIt.hasNext();) {		 
			GenFeatureValueSpec __genValueExpression = (GenFeatureValueSpec)featInitIt.next();
			String metaFeatureAccess = importManager.getImportedName(__genValueExpression.getFeatureQualifiedPackageInterfaceName())+".eINSTANCE.get"+__genValueExpression.getFeature().getFeatureAccessorName()+"()"; 

    stringBuffer.append(TEXT_13);
    
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

    stringBuffer.append(TEXT_14);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_19);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_23);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_24);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_29);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_34);
    		} 
    stringBuffer.append(TEXT_35);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_36);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_37);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_38);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_39);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_40);
    stringBuffer.append(metaFeatureAccess);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(featInitIt.hasNext() ? "," : "");
    
			if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider && !expressionProviders.isCopy(__genValueExpression)) {
				javaInitializers.put(__genValueExpression, __genExprContext);
			}
		} // end of GenFeatureValueSpec iteration

    stringBuffer.append(TEXT_42);
    
}
if (needsObjectInitializer) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_50);
    
	if(!javaInitializers.isEmpty()) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_52);
    
		for(Iterator javaExprIt = javaInitializers.keySet().iterator(); javaExprIt.hasNext();) {
			GenFeatureValueSpec __genValueExpression = (GenFeatureValueSpec)javaExprIt.next();
			GenClassifier __genExprContext = (GenClassifier)javaInitializers.get(__genValueExpression);
			GenExpressionProviderBase provider = expressionProviders.getProvider(__genValueExpression);
			if(!(provider instanceof GenJavaExpressionProvider)) continue;
			String __genExprResultType = provider.getQualifiedInstanceClassName(__genValueExpression.getFeature());

    stringBuffer.append(TEXT_53);
    
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

    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_57);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_60);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_62);
    
} /* end of GenJavaExpressionProvider */

    
		}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(javaExprContainer);
    	} /* end of javaInitializers */ 
    
}
}	//end local block that separates initializers and constraints

    stringBuffer.append(TEXT_64);
    
final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
if (genDiagram.hasLinkCreationConstraints() && expressionProviders != null) {
	String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
	String importedAbstractExprCls = importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName());
	boolean hasJavaConstraints = false;

    stringBuffer.append(TEXT_65);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_66);
    
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		if(linkConstraints.getSourceEndContextClass() == null || linkConstraints.getTargetEndContextClass() == null) continue;
		hasJavaConstraints |= (linkConstraints.getSourceEnd() != null && expressionProviders.getProvider(linkConstraints.getSourceEnd()) instanceof GenJavaExpressionProvider) ||
							(linkConstraints.getTargetEnd() != null && expressionProviders.getProvider(linkConstraints.getTargetEnd()) instanceof GenJavaExpressionProvider);

    stringBuffer.append(TEXT_67);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_70);
    
	} // end of link iteration

    stringBuffer.append(TEXT_71);
    
	final String oppositeEndVarName = "oppositeEnd";
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		GenClass srcContext = linkConstraints.getSourceEndContextClass();
		GenClass targetContext = linkConstraints.getTargetEndContextClass();
		if(srcContext == null || targetContext == null) continue;

    stringBuffer.append(TEXT_72);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_74);
    
		String __javaOperationContainer = javaConstraintsContainer;
		Map __exprEnvVariables = new java.util.HashMap();
		String __outEnvVarName = "sourceEnv";
		GenClassifier __genExprContext = srcContext;
		ValueExpression __genValueExpression = linkConstraints.getSourceEnd();
		__exprEnvVariables.put(oppositeEndVarName, targetContext); //$NON-NLS-1$


    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables
String __outEnvVarName;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_78);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_81);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_82);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_83);
    
		if(linkConstraints.getSourceEnd() != null) {

    
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

    stringBuffer.append(TEXT_84);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_89);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_93);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_94);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_99);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_104);
    		} 
    stringBuffer.append(TEXT_105);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_106);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_107);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_108);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_109);
    }
    } /*end of scope*/
    
		} else 
    stringBuffer.append(TEXT_110);
    ;
    stringBuffer.append(TEXT_111);
    
		__outEnvVarName = "targetEnv";
		__genExprContext = targetContext;
		__genValueExpression = linkConstraints.getTargetEnd();			
		__exprEnvVariables.put(oppositeEndVarName, srcContext); //$NON-NLS-1$

    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables
String __outEnvVarName;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_115);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_118);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_119);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_120);
    
		if(linkConstraints.getTargetEnd() != null) {

    
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

    stringBuffer.append(TEXT_121);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_126);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_130);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_131);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_136);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_141);
    		} 
    stringBuffer.append(TEXT_142);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_143);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_144);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_145);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_146);
    }
    } /*end of scope*/
    
		} else 
    stringBuffer.append(TEXT_147);
    ;
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_149);
    
	} // end of link iteration

    stringBuffer.append(TEXT_150);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_161);
    
if(hasJavaConstraints) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(javaConstraintsContainer);
    stringBuffer.append(TEXT_163);
    
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		GenClass srcContext = linkConstraints.getSourceEndContextClass();
		GenClass targetContext = linkConstraints.getTargetEndContextClass();
		if(srcContext == null || targetContext == null) continue;
		String __genExprResultType = "java.lang.Boolean";
		Map __exprEnvVariables = new java.util.HashMap();
		GenClassifier __genExprContext = srcContext;
		ValueExpression __genValueExpression = linkConstraints.getSourceEnd();
		if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {				
			__exprEnvVariables.put(oppositeEndVarName, targetContext);

    stringBuffer.append(TEXT_164);
    
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

    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_168);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_171);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_173);
    
} /* end of GenJavaExpressionProvider */

    
		}
		__genValueExpression = linkConstraints.getTargetEnd();
		if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {		
			__genExprContext = targetContext;
			__exprEnvVariables.put(oppositeEndVarName, srcContext);

    stringBuffer.append(TEXT_174);
    
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

    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_178);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_181);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_183);
    
} /* end of GenJavaExpressionProvider */

    
		}
	} /*java constraints iteration*/

    stringBuffer.append(TEXT_184);
    stringBuffer.append(javaConstraintsContainer);
    
} /* end of hasJavaConstraints */

    stringBuffer.append(TEXT_185);
    } /*end of hasLinkCreationConstraints()*/ 
    stringBuffer.append(TEXT_186);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_187);
    return stringBuffer.toString();
  }
}
