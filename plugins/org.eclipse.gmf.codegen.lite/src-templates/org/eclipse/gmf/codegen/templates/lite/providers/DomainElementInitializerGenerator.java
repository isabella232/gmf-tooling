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

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class DomainElementInitializer ";
  protected final String TEXT_4 = "{" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static interface IElementInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_5 = " instance);" + NL + "\t}" + NL;
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static IElementInitializer NULL_INITIALIZER = new IElementInitializer() {" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_7 = " instance) {" + NL + "\t\t}" + NL + "\t};" + NL;
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static IElementInitializer ";
  protected final String TEXT_9 = " = NULL_INITIALIZER;";
  protected final String TEXT_10 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final IElementInitializer ";
  protected final String TEXT_11 = " = new ObjectInitializer(";
  protected final String TEXT_12 = ") {";
  protected final String TEXT_13 = NL + "\t\tObjectInitializer ";
  protected final String TEXT_14 = "() {" + NL + "\t\t\treturn new ObjectInitializer(";
  protected final String TEXT_15 = ") {";
  protected final String TEXT_16 = NL + "\t\t \tprotected void init() {\t\t\t\t";
  protected final String TEXT_17 = "\t\t\t" + NL + "\t\t\t\tadd(createNewElementFeatureInitializer(";
  protected final String TEXT_18 = ", new ObjectInitializer[] {";
  protected final String TEXT_19 = NL + "\t\t\t\t\t";
  protected final String TEXT_20 = "(), ";
  protected final String TEXT_21 = NL + "\t\t\t\t}));";
  protected final String TEXT_22 = "\t\t\t" + NL + "\t\t\t\tadd(createExpressionFeatureInitializer(";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = "null";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ")";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_33 = ")";
  protected final String TEXT_34 = "new ";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_37 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_38 = " self = (";
  protected final String TEXT_39 = ")context;";
  protected final String TEXT_40 = "\t" + NL + "\t\t";
  protected final String TEXT_41 = " ";
  protected final String TEXT_42 = " = (";
  protected final String TEXT_43 = ")env.get(\"";
  protected final String TEXT_44 = "\"); //$NON-NLS-1$";
  protected final String TEXT_45 = NL + "\t\treturn ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = "(self";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_50 = NL + "));";
  protected final String TEXT_51 = "\t\t\t}";
  protected final String TEXT_52 = NL + "\t\t\t\t}; // ";
  protected final String TEXT_53 = " ObjectInitializer" + NL + "\t\t\t}";
  protected final String TEXT_54 = NL + "\t\t}; // ";
  protected final String TEXT_55 = " ObjectInitializer";
  protected final String TEXT_56 = NL + "\t/** " + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static abstract class ObjectInitializer implements IElementInitializer {" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal ";
  protected final String TEXT_57 = " element;\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_58 = " featureInitializers = new ";
  protected final String TEXT_59 = "();" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tObjectInitializer(";
  protected final String TEXT_60 = " element) {" + NL + "\t\t\tthis.element = element;" + NL + "\t\t\tinit();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t \tprotected abstract void init();\t\t\t\t\t\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected final FeatureInitializer add(FeatureInitializer initializer) {" + NL + "\t\t\tfeatureInitializers.add(initializer);" + NL + "\t\t\treturn initializer;" + NL + "\t\t}" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_61 = " instance) {" + NL + "\t\t\tfor (";
  protected final String TEXT_62 = " it = featureInitializers.iterator(); it.hasNext();) {" + NL + "\t\t\t\tFeatureInitializer nextExpr = (FeatureInitializer)it.next();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t} catch(RuntimeException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_63 = ".getInstance().logError(\"Feature initialization failed\", e);\t//$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} // end of ObjectInitializer" + NL + "\t" + NL + "\t/** " + NL + "\t * @generated" + NL + "\t */" + NL + "\tinterface FeatureInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tvoid init(";
  protected final String TEXT_64 = " contextInstance);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tstatic FeatureInitializer createNewElementFeatureInitializer(";
  protected final String TEXT_65 = " initFeature, ObjectInitializer[] newObjectInitializers) {" + NL + "\t\tfinal ";
  protected final String TEXT_66 = " feature = initFeature;" + NL + "\t\tfinal ObjectInitializer[] initializers = newObjectInitializers;" + NL + "\t\treturn new FeatureInitializer() {" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_67 = " contextInstance) {" + NL + "\t\t\t\tfor (int i = 0; i < initializers.length; i++) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = " newInstance = initializers[i].element.getEPackage().getEFactoryInstance().create(initializers[i].element);" + NL + "\t\t\t\t\tif(feature.isMany()) {" + NL + "\t\t\t\t\t\t((";
  protected final String TEXT_69 = ")contextInstance.eGet(feature)).add(newInstance);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tcontextInstance.eSet(feature, newInstance);" + NL + "\t\t\t\t\t}\t\t\t\t\t\t" + NL + "\t\t\t\t\tinitializers[i].initializeElement(newInstance);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tstatic FeatureInitializer createExpressionFeatureInitializer(";
  protected final String TEXT_70 = " initFeature, ";
  protected final String TEXT_71 = " valueExpression) {" + NL + "\t\tfinal ";
  protected final String TEXT_72 = " feature = initFeature;" + NL + "\t\tfinal ";
  protected final String TEXT_73 = " expression = valueExpression;" + NL + "\t\treturn new FeatureInitializer() {\t\t\t\t" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_74 = " contextInstance) {" + NL + "\t\t\t\texpression.assignTo(feature, contextInstance);" + NL + "\t\t\t}" + NL + "\t\t};\t\t\t" + NL + "\t}";
  protected final String TEXT_75 = NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class ";
  protected final String TEXT_76 = " {";
  protected final String TEXT_77 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = "(";
  protected final String TEXT_80 = " self";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = " ";
  protected final String TEXT_83 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_84 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_85 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_86 = NL + "\t\t} //";
  protected final String TEXT_87 = NL;
  protected final String TEXT_88 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_89 = " {";
  protected final String TEXT_90 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tpublic static final ";
  protected final String TEXT_91 = " ";
  protected final String TEXT_92 = " = create";
  protected final String TEXT_93 = "();";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_96 = " create";
  protected final String TEXT_97 = "() {";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = " ";
  protected final String TEXT_100 = " = new ";
  protected final String TEXT_101 = "(3);";
  protected final String TEXT_102 = ".put(\"";
  protected final String TEXT_103 = "\", ";
  protected final String TEXT_104 = "); //$NON-NLS-1$";
  protected final String TEXT_105 = NL + "\t\t\t";
  protected final String TEXT_106 = " sourceExpression = ";
  protected final String TEXT_107 = "null";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = "(";
  protected final String TEXT_110 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = ")";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = "(";
  protected final String TEXT_115 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_116 = ")";
  protected final String TEXT_117 = "new ";
  protected final String TEXT_118 = "(";
  protected final String TEXT_119 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_120 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_121 = " self = (";
  protected final String TEXT_122 = ")context;";
  protected final String TEXT_123 = "\t" + NL + "\t\t";
  protected final String TEXT_124 = " ";
  protected final String TEXT_125 = " = (";
  protected final String TEXT_126 = ")env.get(\"";
  protected final String TEXT_127 = "\"); //$NON-NLS-1$";
  protected final String TEXT_128 = NL + "\t\treturn ";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = "(self";
  protected final String TEXT_131 = ", ";
  protected final String TEXT_132 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_133 = "null";
  protected final String TEXT_134 = ";";
  protected final String TEXT_135 = NL;
  protected final String TEXT_136 = " ";
  protected final String TEXT_137 = " = new ";
  protected final String TEXT_138 = "(3);";
  protected final String TEXT_139 = ".put(\"";
  protected final String TEXT_140 = "\", ";
  protected final String TEXT_141 = "); //$NON-NLS-1$";
  protected final String TEXT_142 = NL + "\t\t\t";
  protected final String TEXT_143 = " targetExpression = ";
  protected final String TEXT_144 = "null";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = "(";
  protected final String TEXT_147 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = ")";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = "(";
  protected final String TEXT_152 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_153 = ")";
  protected final String TEXT_154 = "new ";
  protected final String TEXT_155 = "(";
  protected final String TEXT_156 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_157 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_158 = " self = (";
  protected final String TEXT_159 = ")context;";
  protected final String TEXT_160 = "\t" + NL + "\t\t";
  protected final String TEXT_161 = " ";
  protected final String TEXT_162 = " = (";
  protected final String TEXT_163 = ")env.get(\"";
  protected final String TEXT_164 = "\"); //$NON-NLS-1$";
  protected final String TEXT_165 = NL + "\t\treturn ";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = "(self";
  protected final String TEXT_168 = ", ";
  protected final String TEXT_169 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_170 = "null";
  protected final String TEXT_171 = ";" + NL + "\t\t\treturn new ";
  protected final String TEXT_172 = "(sourceExpression, targetExpression);" + NL + "\t\t}";
  protected final String TEXT_173 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate static final String OPPOSITE_END_VAR = \"oppositeEnd\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_174 = " srcEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_175 = " targetEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_176 = "(";
  protected final String TEXT_177 = " sourceEnd, ";
  protected final String TEXT_178 = " targetEnd) {" + NL + "\t\t\tthis.srcEndInv = sourceEnd;\t\t\t" + NL + "\t\t\tthis.targetEndInv = targetEnd;\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tpublic boolean canCreateLink(Object source, Object target, boolean isBackDirected) {" + NL + "\t\t\tif (source != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_179 = " sourceConstraint = isBackDirected ? targetEndInv : srcEndInv;" + NL + "\t\t\t\tif (sourceConstraint != null && !evaluate(sourceConstraint, source, target, false)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (target != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_180 = " targetConstraint = isBackDirected ? srcEndInv : targetEndInv;" + NL + "\t\t\t\tif (targetConstraint != null && !evaluate(targetConstraint, target, source, true)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static boolean evaluate(";
  protected final String TEXT_181 = " constraint, Object sourceEnd, Object oppositeEnd, boolean clearEnv) {" + NL + "\t\t\t";
  protected final String TEXT_182 = " evalEnv = ";
  protected final String TEXT_183 = ".singletonMap(OPPOSITE_END_VAR, oppositeEnd);\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tObject val = constraint.evaluate(sourceEnd, evalEnv);" + NL + "\t\t\t\treturn (val instanceof Boolean) ? ((Boolean) val).booleanValue() : false;" + NL + "\t\t\t} catch(Exception e) {\t" + NL + "\t\t\t\t";
  protected final String TEXT_184 = ".getInstance().logError(\"Link constraint evaluation error\", e); //$NON-NLS-1$" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_185 = "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ";
  protected final String TEXT_186 = " {";
  protected final String TEXT_187 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_188 = " ";
  protected final String TEXT_189 = "(";
  protected final String TEXT_190 = " self";
  protected final String TEXT_191 = ", ";
  protected final String TEXT_192 = " ";
  protected final String TEXT_193 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_194 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_195 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_196 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_197 = " ";
  protected final String TEXT_198 = "(";
  protected final String TEXT_199 = " self";
  protected final String TEXT_200 = ", ";
  protected final String TEXT_201 = " ";
  protected final String TEXT_202 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_203 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_204 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_205 = NL + "\t} // ";
  protected final String TEXT_206 = "\t\t" + NL + "\t}";
  protected final String TEXT_207 = "\t" + NL + "}";
  protected final String TEXT_208 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    
final String javaExprContainer = "JavaInitializers";
importManager.registerInnerClass(javaExprContainer);
final String javaConstraintsContainer = "JavaConstraints";
importManager.registerInnerClass(javaExprContainer);
importManager.registerInnerClass(genDiagram.getLinkCreationConstraintsClassName());

importManager.emitPackageStatement(stringBuffer);

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    /*XXX: class name should be customizable!*/
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_5);
    
{	//start local block that separates initializers and constraints
boolean needsNullInitializer = false;
boolean needsObjectInitializer = false;
final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
final LinkedHashSet<GenFeatureValueSpec> javaInitializers = new LinkedHashSet<GenFeatureValueSpec>();
final Map __exprEnvVariables = Collections.EMPTY_MAP;
final String __javaOperationContainer = javaExprContainer; // place java expression methods here
for (Map.Entry<TypeModelFacet, GenCommonBase> next : genDiagram.getTypeModelFacet2GenBaseMap().entrySet()) {
	String id = next.getValue().getUniqueIdentifier();
	TypeModelFacet modelFacet = next.getKey();

	GenElementInitializer elementInitializer = modelFacet.getModelElementInitializer();
	if (elementInitializer instanceof GenFeatureSeqInitializer == false || expressionProviders == null) {
		if (!needsNullInitializer) {
			needsNullInitializer = true;

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_7);
    
		}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_9);
    
		continue;
	}
	needsObjectInitializer = true;
	GenFeatureSeqInitializer rootFtSeqInitializer = (GenFeatureSeqInitializer)modelFacet.getModelElementInitializer();
	javaInitializers.addAll(rootFtSeqInitializer.getJavaExpressionFeatureInitializers(expressionProviders));
	for(GenFeatureSeqInitializer nextFtSeqInitializer : rootFtSeqInitializer.getAllFeatureSeqInitializers()) {
		boolean isTopLevelObjInit = nextFtSeqInitializer == rootFtSeqInitializer;
		if(isTopLevelObjInit){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(nextFtSeqInitializer.getElementClassAccessor(importManager));
    stringBuffer.append(TEXT_12);
    		} else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(nextFtSeqInitializer.getElementClassAccessor(importManager));
    stringBuffer.append(TEXT_15);
    		} 
    stringBuffer.append(TEXT_16);
    		for(GenFeatureInitializer nextFtInitializer : (List<GenFeatureInitializer>)nextFtSeqInitializer.getInitializers()) {
			String metaFeatureAccessor = nextFtSeqInitializer.getFeatureAccessor(nextFtInitializer, importManager);
			if(nextFtInitializer instanceof GenReferenceNewElementSpec) {
				GenReferenceNewElementSpec newElementSpec = (GenReferenceNewElementSpec)nextFtInitializer;

    stringBuffer.append(TEXT_17);
    stringBuffer.append(metaFeatureAccessor);
    stringBuffer.append(TEXT_18);
    				for(GenFeatureSeqInitializer newElemInit : (List<GenFeatureSeqInitializer>)newElementSpec.getNewElementInitializers()) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(newElemInit.getInitializerFieldName(id));
    stringBuffer.append(TEXT_20);
    				} // end of newElementInitializers 
    stringBuffer.append(TEXT_21);
    			} // end of GenReferenceNewElementSpec
			else if(nextFtInitializer instanceof GenFeatureValueSpec) {
				String __outEnvVarName = ""; // no env to setup;
				GenClassifier __genExprContext = nextFtSeqInitializer.getElementClass();
				GenFeatureValueSpec __genValueExpression = (GenFeatureValueSpec)nextFtInitializer;

    stringBuffer.append(TEXT_22);
    stringBuffer.append(metaFeatureAccessor);
    stringBuffer.append(TEXT_23);
    
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

    stringBuffer.append(TEXT_24);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_29);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_33);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_34);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_39);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_44);
    		} 
    stringBuffer.append(TEXT_45);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_46);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_47);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_48);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_49);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_50);
    
			} // end of GenFeatureValueSpec
		} // end of GenFeatureInitializer iteration

    stringBuffer.append(TEXT_51);
    		if(!isTopLevelObjInit) { 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_53);
    		} // GenFeatureInitializer iteration
	} // All GenFeatureSeqInitializer iteration

    stringBuffer.append(TEXT_54);
    stringBuffer.append(rootFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_55);
    
}
if (needsObjectInitializer) {

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
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_74);
    
	if(!javaInitializers.isEmpty()) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_76);
    
		for(GenFeatureValueSpec __genValueExpression : javaInitializers) {
			GenClassifier __genExprContext = __genValueExpression.getFeatureSeqInitializer().getElementClass();
			GenExpressionProviderBase provider = expressionProviders.getProvider(__genValueExpression);
			if(!(provider instanceof GenJavaExpressionProvider)) continue;
			String __genExprResultType = provider.getQualifiedTypeInstanceClassName(__genValueExpression.getFeature());

    
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

    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_80);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_83);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_85);
    
} /* end of GenJavaExpressionProvider */

    
		}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(javaExprContainer);
    	} /* end of javaInitializers */ 
    
}
}	//end local block that separates initializers and constraints

    stringBuffer.append(TEXT_87);
    
final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
if (genDiagram.hasLinkCreationConstraints() && expressionProviders != null) {
	String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
	String importedAbstractExprCls = importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName());
	boolean hasJavaConstraints = false;

    stringBuffer.append(TEXT_88);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_89);
    
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		if(linkConstraints.getSourceEndContextClass() == null || linkConstraints.getTargetEndContextClass() == null) continue;
		hasJavaConstraints |= (linkConstraints.getSourceEnd() != null && expressionProviders.getProvider(linkConstraints.getSourceEnd()) instanceof GenJavaExpressionProvider) ||
							(linkConstraints.getTargetEnd() != null && expressionProviders.getProvider(linkConstraints.getTargetEnd()) instanceof GenJavaExpressionProvider);

    stringBuffer.append(TEXT_90);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_93);
    
	} // end of link iteration

    stringBuffer.append(TEXT_94);
    
	final String oppositeEndVarName = "oppositeEnd";
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		GenClass srcContext = linkConstraints.getSourceEndContextClass();
		GenClass targetContext = linkConstraints.getTargetEndContextClass();
		if(srcContext == null || targetContext == null) continue;

    stringBuffer.append(TEXT_95);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_97);
    
		String __javaOperationContainer = javaConstraintsContainer;
		Map __exprEnvVariables = new java.util.HashMap();
		String __outEnvVarName = "sourceEnv";
		GenClassifier __genExprContext = srcContext;
		ValueExpression __genValueExpression = linkConstraints.getSourceEnd();
		__exprEnvVariables.put(oppositeEndVarName, targetContext); //$NON-NLS-1$


    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables;
String __outEnvVarName;
ValueExpression __genValueExpression;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_101);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_104);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_105);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_106);
    
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

    stringBuffer.append(TEXT_107);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_112);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_116);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_117);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_122);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_127);
    		} 
    stringBuffer.append(TEXT_128);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_129);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_130);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_131);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_132);
    }
    } /*end of scope*/
    
		} else 
    stringBuffer.append(TEXT_133);
    ;
    stringBuffer.append(TEXT_134);
    
		__outEnvVarName = "targetEnv";
		__genExprContext = targetContext;
		__genValueExpression = linkConstraints.getTargetEnd();			
		__exprEnvVariables.put(oppositeEndVarName, srcContext); //$NON-NLS-1$

    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables;
String __outEnvVarName;
ValueExpression __genValueExpression;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_138);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_141);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_142);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_143);
    
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

    stringBuffer.append(TEXT_144);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_149);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_153);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_154);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_159);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_164);
    		} 
    stringBuffer.append(TEXT_165);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_166);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_167);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_168);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_169);
    }
    } /*end of scope*/
    
		} else 
    stringBuffer.append(TEXT_170);
    ;
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_172);
    
	} // end of link iteration

    stringBuffer.append(TEXT_173);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_184);
    
if(hasJavaConstraints) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(javaConstraintsContainer);
    stringBuffer.append(TEXT_186);
    
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

    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_190);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_193);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_195);
    
} /* end of GenJavaExpressionProvider */

    
		}
		__genValueExpression = linkConstraints.getTargetEnd();
		if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {		
			__genExprContext = targetContext;
			__exprEnvVariables.put(oppositeEndVarName, srcContext);

    
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

    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_199);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_202);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_204);
    
} /* end of GenJavaExpressionProvider */

    
		}
	} /*java constraints iteration*/

    stringBuffer.append(TEXT_205);
    stringBuffer.append(javaConstraintsContainer);
    
} /* end of hasJavaConstraints */

    stringBuffer.append(TEXT_206);
    } /*end of hasLinkCreationConstraints()*/ 
    stringBuffer.append(TEXT_207);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_208);
    return stringBuffer.toString();
  }
}
