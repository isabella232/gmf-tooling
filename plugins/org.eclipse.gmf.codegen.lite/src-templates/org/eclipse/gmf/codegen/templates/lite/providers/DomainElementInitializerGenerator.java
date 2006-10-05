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
  protected final String TEXT_11 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final IElementInitializer ";
  protected final String TEXT_12 = " = new ObjectInitializer(";
  protected final String TEXT_13 = ") {";
  protected final String TEXT_14 = NL + "\t\tObjectInitializer ";
  protected final String TEXT_15 = "() {" + NL + "\t\t\treturn new ObjectInitializer(";
  protected final String TEXT_16 = ") {";
  protected final String TEXT_17 = NL + "\t\t \tprotected void init() {\t\t\t\t";
  protected final String TEXT_18 = "\t\t\t" + NL + "\t\t\t\tadd(createNewElementFeatureInitializer(";
  protected final String TEXT_19 = ", new ObjectInitializer[] {";
  protected final String TEXT_20 = NL + "\t\t\t\t\t";
  protected final String TEXT_21 = "(), ";
  protected final String TEXT_22 = NL + "\t\t\t\t}));";
  protected final String TEXT_23 = "\t\t\t" + NL + "\t\t\t\tadd(createExpressionFeatureInitializer(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = "null";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ")";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_34 = ")";
  protected final String TEXT_35 = "new ";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_38 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_39 = " self = (";
  protected final String TEXT_40 = ")context;";
  protected final String TEXT_41 = "\t" + NL + "\t\t";
  protected final String TEXT_42 = " ";
  protected final String TEXT_43 = " = (";
  protected final String TEXT_44 = ")env.get(\"";
  protected final String TEXT_45 = "\"); //$NON-NLS-1$";
  protected final String TEXT_46 = NL + "\t\treturn ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "(self";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_51 = NL + "));";
  protected final String TEXT_52 = "\t\t\t}";
  protected final String TEXT_53 = NL + "\t\t\t\t}; // ";
  protected final String TEXT_54 = " ObjectInitializer" + NL + "\t\t\t}";
  protected final String TEXT_55 = NL + "\t\t}; // ";
  protected final String TEXT_56 = " ObjectInitializer";
  protected final String TEXT_57 = NL + "\t/** " + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static abstract class ObjectInitializer implements IElementInitializer {" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal ";
  protected final String TEXT_58 = " element;\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_59 = " featureInitializers = new ";
  protected final String TEXT_60 = "();" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tObjectInitializer(";
  protected final String TEXT_61 = " element) {" + NL + "\t\t\tthis.element = element;" + NL + "\t\t\tinit();" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t \t * @generated" + NL + "\t \t */" + NL + "\t \tprotected abstract void init();\t\t\t\t\t\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected final FeatureInitializer add(FeatureInitializer initializer) {" + NL + "\t\t\tfeatureInitializers.add(initializer);" + NL + "\t\t\treturn initializer;" + NL + "\t\t}" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic void initializeElement(";
  protected final String TEXT_62 = " instance) {" + NL + "\t\t\tfor (";
  protected final String TEXT_63 = " it = featureInitializers.iterator(); it.hasNext();) {" + NL + "\t\t\t\tFeatureInitializer nextExpr = (FeatureInitializer)it.next();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tnextExpr.init(instance);" + NL + "\t\t\t\t} catch(RuntimeException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_64 = ".getInstance().logError(\"Feature initialization failed\", e);\t//$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} // end of ObjectInitializer" + NL + "\t" + NL + "\t/** " + NL + "\t * @generated" + NL + "\t */" + NL + "\tinterface FeatureInitializer {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tvoid init(";
  protected final String TEXT_65 = " contextInstance);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tstatic FeatureInitializer createNewElementFeatureInitializer(";
  protected final String TEXT_66 = " initFeature, ObjectInitializer[] newObjectInitializers) {" + NL + "\t\tfinal ";
  protected final String TEXT_67 = " feature = initFeature;" + NL + "\t\tfinal ObjectInitializer[] initializers = newObjectInitializers;" + NL + "\t\treturn new FeatureInitializer() {" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_68 = " contextInstance) {" + NL + "\t\t\t\tfor (int i = 0; i < initializers.length; i++) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_69 = " newInstance = initializers[i].element.getEPackage().getEFactoryInstance().create(initializers[i].element);" + NL + "\t\t\t\t\tif(feature.isMany()) {" + NL + "\t\t\t\t\t\t((";
  protected final String TEXT_70 = ")contextInstance.eGet(feature)).add(newInstance);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tcontextInstance.eSet(feature, newInstance);" + NL + "\t\t\t\t\t}\t\t\t\t\t\t" + NL + "\t\t\t\t\tinitializers[i].initializeElement(newInstance);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t\t" + NL + "\tstatic FeatureInitializer createExpressionFeatureInitializer(";
  protected final String TEXT_71 = " initFeature, ";
  protected final String TEXT_72 = " valueExpression) {" + NL + "\t\tfinal ";
  protected final String TEXT_73 = " feature = initFeature;" + NL + "\t\tfinal ";
  protected final String TEXT_74 = " expression = valueExpression;" + NL + "\t\treturn new FeatureInitializer() {\t\t\t\t" + NL + "\t\t\tpublic void init(";
  protected final String TEXT_75 = " contextInstance) {" + NL + "\t\t\t\texpression.assignTo(feature, contextInstance);" + NL + "\t\t\t}" + NL + "\t\t};\t\t\t" + NL + "\t}";
  protected final String TEXT_76 = NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class ";
  protected final String TEXT_77 = " {";
  protected final String TEXT_78 = NL;
  protected final String TEXT_79 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_80 = " ";
  protected final String TEXT_81 = "(";
  protected final String TEXT_82 = " self";
  protected final String TEXT_83 = ", ";
  protected final String TEXT_84 = " ";
  protected final String TEXT_85 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_86 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_87 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_88 = NL + "\t\t} //";
  protected final String TEXT_89 = NL;
  protected final String TEXT_90 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_91 = " {";
  protected final String TEXT_92 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tpublic static final ";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = " = create";
  protected final String TEXT_95 = "();";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_98 = " create";
  protected final String TEXT_99 = "() {";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = " = new ";
  protected final String TEXT_103 = "(3);";
  protected final String TEXT_104 = ".put(\"";
  protected final String TEXT_105 = "\", ";
  protected final String TEXT_106 = "); //$NON-NLS-1$";
  protected final String TEXT_107 = NL + "\t\t\t";
  protected final String TEXT_108 = " sourceExpression = ";
  protected final String TEXT_109 = "null";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = "(";
  protected final String TEXT_112 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ")";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = "(";
  protected final String TEXT_117 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_118 = ")";
  protected final String TEXT_119 = "new ";
  protected final String TEXT_120 = "(";
  protected final String TEXT_121 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_122 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_123 = " self = (";
  protected final String TEXT_124 = ")context;";
  protected final String TEXT_125 = "\t" + NL + "\t\t";
  protected final String TEXT_126 = " ";
  protected final String TEXT_127 = " = (";
  protected final String TEXT_128 = ")env.get(\"";
  protected final String TEXT_129 = "\"); //$NON-NLS-1$";
  protected final String TEXT_130 = NL + "\t\treturn ";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = "(self";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_135 = "null";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = NL;
  protected final String TEXT_138 = " ";
  protected final String TEXT_139 = " = new ";
  protected final String TEXT_140 = "(3);";
  protected final String TEXT_141 = ".put(\"";
  protected final String TEXT_142 = "\", ";
  protected final String TEXT_143 = "); //$NON-NLS-1$";
  protected final String TEXT_144 = NL + "\t\t\t";
  protected final String TEXT_145 = " targetExpression = ";
  protected final String TEXT_146 = "null";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = "(";
  protected final String TEXT_149 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_150 = ", ";
  protected final String TEXT_151 = ")";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_155 = ")";
  protected final String TEXT_156 = "new ";
  protected final String TEXT_157 = "(";
  protected final String TEXT_158 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_159 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_160 = " self = (";
  protected final String TEXT_161 = ")context;";
  protected final String TEXT_162 = "\t" + NL + "\t\t";
  protected final String TEXT_163 = " ";
  protected final String TEXT_164 = " = (";
  protected final String TEXT_165 = ")env.get(\"";
  protected final String TEXT_166 = "\"); //$NON-NLS-1$";
  protected final String TEXT_167 = NL + "\t\treturn ";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = "(self";
  protected final String TEXT_170 = ", ";
  protected final String TEXT_171 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_172 = "null";
  protected final String TEXT_173 = ";" + NL + "\t\t\treturn new ";
  protected final String TEXT_174 = "(sourceExpression, targetExpression);" + NL + "\t\t}";
  protected final String TEXT_175 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate static final String OPPOSITE_END_VAR = \"oppositeEnd\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_176 = " srcEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_177 = " targetEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_178 = "(";
  protected final String TEXT_179 = " sourceEnd, ";
  protected final String TEXT_180 = " targetEnd) {" + NL + "\t\t\tthis.srcEndInv = sourceEnd;\t\t\t" + NL + "\t\t\tthis.targetEndInv = targetEnd;\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tpublic boolean canCreateLink(Object source, Object target, boolean isBackDirected) {" + NL + "\t\t\tif (source != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_181 = " sourceConstraint = isBackDirected ? targetEndInv : srcEndInv;" + NL + "\t\t\t\tif (sourceConstraint != null && !evaluate(sourceConstraint, source, target, false)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tif (target != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_182 = " targetConstraint = isBackDirected ? srcEndInv : targetEndInv;" + NL + "\t\t\t\tif (targetConstraint != null && !evaluate(targetConstraint, source, target, true)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static boolean evaluate(";
  protected final String TEXT_183 = " constraint, Object sourceEnd, Object oppositeEnd, boolean clearEnv) {" + NL + "\t\t\t";
  protected final String TEXT_184 = " evalEnv = ";
  protected final String TEXT_185 = ".singletonMap(OPPOSITE_END_VAR, oppositeEnd);\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tObject val = constraint.evaluate(sourceEnd, evalEnv);" + NL + "\t\t\t\treturn (val instanceof Boolean) ? ((Boolean) val).booleanValue() : false;" + NL + "\t\t\t} catch(Exception e) {\t" + NL + "\t\t\t\t";
  protected final String TEXT_186 = ".getInstance().logError(\"Link constraint evaluation error\", e); //$NON-NLS-1$" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_187 = "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ";
  protected final String TEXT_188 = " {";
  protected final String TEXT_189 = NL;
  protected final String TEXT_190 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_191 = " ";
  protected final String TEXT_192 = "(";
  protected final String TEXT_193 = " self";
  protected final String TEXT_194 = ", ";
  protected final String TEXT_195 = " ";
  protected final String TEXT_196 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_197 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_198 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_199 = NL;
  protected final String TEXT_200 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_201 = " ";
  protected final String TEXT_202 = "(";
  protected final String TEXT_203 = " self";
  protected final String TEXT_204 = ", ";
  protected final String TEXT_205 = " ";
  protected final String TEXT_206 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_207 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_208 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_209 = NL + "\t} // ";
  protected final String TEXT_210 = "\t\t" + NL + "\t}";
  protected final String TEXT_211 = "\t" + NL + "}";
  protected final String TEXT_212 = NL;

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
	GenFeatureSeqInitializer rootFtSeqInitializer = (GenFeatureSeqInitializer)modelFacet.getModelElementInitializer();
	javaInitializers.addAll(rootFtSeqInitializer.getJavaExpressionFeatureInitializers(expressionProviders));
	for(GenFeatureSeqInitializer nextFtSeqInitializer : rootFtSeqInitializer.getAllFeatureSeqInitializers()) {
		boolean isTopLevelObjInit = nextFtSeqInitializer == rootFtSeqInitializer;
		if(isTopLevelObjInit){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(nextFtSeqInitializer.getElementClassAccessor(importManager));
    stringBuffer.append(TEXT_13);
    		} else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(nextFtSeqInitializer.getElementClassAccessor(importManager));
    stringBuffer.append(TEXT_16);
    		} 
    stringBuffer.append(TEXT_17);
    		for(GenFeatureInitializer nextFtInitializer : (List<GenFeatureInitializer>)nextFtSeqInitializer.getInitializers()) {
			String metaFeatureAccessor = nextFtSeqInitializer.getFeatureAccessor(nextFtInitializer, importManager);
			if(nextFtInitializer instanceof GenReferenceNewElementSpec) {
				GenReferenceNewElementSpec newElementSpec = (GenReferenceNewElementSpec)nextFtInitializer;

    stringBuffer.append(TEXT_18);
    stringBuffer.append(metaFeatureAccessor);
    stringBuffer.append(TEXT_19);
    				for(GenFeatureSeqInitializer newElemInit : (List<GenFeatureSeqInitializer>)newElementSpec.getNewElementInitializers()) { 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(newElemInit.getInitializerFieldName(id));
    stringBuffer.append(TEXT_21);
    				} // end of newElementInitializers 
    stringBuffer.append(TEXT_22);
    			} // end of GenReferenceNewElementSpec
			else if(nextFtInitializer instanceof GenFeatureValueSpec) {
				String __outEnvVarName = ""; // no env to setup;
				GenClassifier __genExprContext = nextFtSeqInitializer.getElementClass();
				GenFeatureValueSpec __genValueExpression = (GenFeatureValueSpec)nextFtInitializer;

    stringBuffer.append(TEXT_23);
    stringBuffer.append(metaFeatureAccessor);
    stringBuffer.append(TEXT_24);
    
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

    stringBuffer.append(TEXT_25);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_30);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_34);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_35);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_40);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_45);
    		} 
    stringBuffer.append(TEXT_46);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_47);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_48);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_49);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_50);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_51);
    
			} // end of GenFeatureValueSpec
		} // end of GenFeatureInitializer iteration

    stringBuffer.append(TEXT_52);
    		if(!isTopLevelObjInit) { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(nextFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_54);
    		} // GenFeatureInitializer iteration
	} // All GenFeatureSeqInitializer iteration

    stringBuffer.append(TEXT_55);
    stringBuffer.append(rootFtSeqInitializer.getInitializerFieldName(id));
    stringBuffer.append(TEXT_56);
    
}
if (needsObjectInitializer) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_75);
    
	if(!javaInitializers.isEmpty()) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_77);
    
		for(GenFeatureValueSpec __genValueExpression : javaInitializers) {
			GenClassifier __genExprContext = __genValueExpression.getFeatureSeqInitializer().getElementClass();
			GenExpressionProviderBase provider = expressionProviders.getProvider(__genValueExpression);
			if(!(provider instanceof GenJavaExpressionProvider)) continue;
			String __genExprResultType = provider.getQualifiedInstanceClassName(__genValueExpression.getFeature());

    stringBuffer.append(TEXT_78);
    
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

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_82);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_85);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_87);
    
} /* end of GenJavaExpressionProvider */

    
		}

    stringBuffer.append(TEXT_88);
    stringBuffer.append(javaExprContainer);
    	} /* end of javaInitializers */ 
    
}
}	//end local block that separates initializers and constraints

    stringBuffer.append(TEXT_89);
    
final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
if (genDiagram.hasLinkCreationConstraints() && expressionProviders != null) {
	String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
	String importedAbstractExprCls = importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName());
	boolean hasJavaConstraints = false;

    stringBuffer.append(TEXT_90);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_91);
    
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		if(linkConstraints.getSourceEndContextClass() == null || linkConstraints.getTargetEndContextClass() == null) continue;
		hasJavaConstraints |= (linkConstraints.getSourceEnd() != null && expressionProviders.getProvider(linkConstraints.getSourceEnd()) instanceof GenJavaExpressionProvider) ||
							(linkConstraints.getTargetEnd() != null && expressionProviders.getProvider(linkConstraints.getTargetEnd()) instanceof GenJavaExpressionProvider);

    stringBuffer.append(TEXT_92);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_95);
    
	} // end of link iteration

    stringBuffer.append(TEXT_96);
    
	final String oppositeEndVarName = "oppositeEnd";
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		GenClass srcContext = linkConstraints.getSourceEndContextClass();
		GenClass targetContext = linkConstraints.getTargetEndContextClass();
		if(srcContext == null || targetContext == null) continue;

    stringBuffer.append(TEXT_97);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_99);
    
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

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_103);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_106);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_107);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_108);
    
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

    stringBuffer.append(TEXT_109);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_114);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_118);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_119);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_124);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_129);
    		} 
    stringBuffer.append(TEXT_130);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_131);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_132);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_133);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_134);
    }
    } /*end of scope*/
    
		} else 
    stringBuffer.append(TEXT_135);
    ;
    stringBuffer.append(TEXT_136);
    
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

    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_140);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_143);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_144);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_145);
    
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

    stringBuffer.append(TEXT_146);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_151);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_155);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_156);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_161);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_166);
    		} 
    stringBuffer.append(TEXT_167);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_168);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_169);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_170);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_171);
    }
    } /*end of scope*/
    
		} else 
    stringBuffer.append(TEXT_172);
    ;
    stringBuffer.append(TEXT_173);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_174);
    
	} // end of link iteration

    stringBuffer.append(TEXT_175);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_186);
    
if(hasJavaConstraints) {

    stringBuffer.append(TEXT_187);
    stringBuffer.append(javaConstraintsContainer);
    stringBuffer.append(TEXT_188);
    
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

    stringBuffer.append(TEXT_189);
    
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

    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_193);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_196);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_198);
    
} /* end of GenJavaExpressionProvider */

    
		}
		__genValueExpression = linkConstraints.getTargetEnd();
		if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {		
			__genExprContext = targetContext;
			__exprEnvVariables.put(oppositeEndVarName, srcContext);

    stringBuffer.append(TEXT_199);
    
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

    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_203);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_206);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_208);
    
} /* end of GenJavaExpressionProvider */

    
		}
	} /*java constraints iteration*/

    stringBuffer.append(TEXT_209);
    stringBuffer.append(javaConstraintsContainer);
    
} /* end of hasJavaConstraints */

    stringBuffer.append(TEXT_210);
    } /*end of hasLinkCreationConstraints()*/ 
    stringBuffer.append(TEXT_211);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_212);
    return stringBuffer.toString();
  }
}
