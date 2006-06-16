package org.eclipse.gmf.codegen.templates.expressions;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class OCLExpressionFactoryGenerator
{
  protected static String nl;
  public static synchronized OCLExpressionFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    OCLExpressionFactoryGenerator result = new OCLExpressionFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated " + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " {" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_8 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tpublic static ";
  protected final String TEXT_9 = " getExpression(String body, EClassifier context, Map environment) {\t\t" + NL + "\t\treturn new Expression(body, context, environment);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tpublic static ";
  protected final String TEXT_10 = " getExpression(String body, EClassifier context) {\t\t" + NL + "\t\treturn getExpression(body, context, Collections.EMPTY_MAP);" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tprivate static class Expression extends ";
  protected final String TEXT_11 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate Query query;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t\t" + NL + "\t\tpublic Expression(String body, EClassifier context, Map environment) {" + NL + "\t\t\tsuper(body, context, environment);" + NL + "\t\t\t" + NL + "\t\t\tIOCLHelper oclHelper = (environment.isEmpty()) ? " + NL + "\t\t\t\t\tHelperUtil.createOCLHelper() :" + NL + "\t\t\t\t\tHelperUtil.createOCLHelper(createCustomEnv(environment));" + NL + "\t\t\toclHelper.setContext(context());" + NL + "\t\t\ttry {" + NL + "\t\t\t\tOCLExpression oclExpression = oclHelper.createQuery(body);" + NL + "\t\t\t\tthis.query = QueryFactory.eINSTANCE.createQuery(oclExpression);" + NL + "\t\t\t} catch (OCLParsingException e) {" + NL + "\t\t\t\tsetStatus(IStatus.ERROR, e.getMessage(), e);" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprotected Object doEvaluate(Object context, Map env) {" + NL + "\t\t\tif (query == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tEvaluationEnvironment evalEnv = query.getEvaluationEnvironment();" + NL + "\t\t\t// init environment" + NL + "\t\t\tfor (Iterator it = env.entrySet().iterator(); it.hasNext();) {" + NL + "\t\t\t\tMap.Entry nextEntry = (Map.Entry) it.next();" + NL + "\t\t\t\tevalEnv.replace((String)nextEntry.getKey(), nextEntry.getValue());\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tinitExtentMap(context);" + NL + "\t\t\t\tObject result = query.evaluate(context);" + NL + "\t\t\t\treturn (result != Types.OCL_INVALID) ? result : null;" + NL + "\t\t\t} finally {\t\t\t\t" + NL + "\t\t\t\tevalEnv.clear();" + NL + "\t\t\t\tquery.setExtentMap(Collections.EMPTY_MAP);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprotected Object performCast(Object value, ETypedElement targetType) {" + NL + "\t\t\tif (targetType.getEType() instanceof EEnum) {" + NL + "\t\t\t\tif(value instanceof EEnumLiteral) {" + NL + "\t\t\t\t\tEEnumLiteral literal = (EEnumLiteral)value;" + NL + "\t\t\t\t\treturn (literal.getInstance() != null) ? literal.getInstance() : literal;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn super.performCast(value, targetType);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate void initExtentMap(Object context) {" + NL + "\t\t\tif(query == null || context == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tfinal Query queryToInit = query;" + NL + "\t\t\tfinal Object extentContext = context;" + NL + "\t\t\t" + NL + "\t\t\tqueryToInit.setExtentMap(Collections.EMPTY_MAP);" + NL + "\t\t\tif(queryToInit.queryText() != null && queryToInit.queryText().indexOf(\"allInstances\") >= 0) {\t\t\t" + NL + "\t\t\t\tAbstractVisitor visitior = new AbstractVisitor() {" + NL + "\t\t\t\t\tprivate boolean usesAllInstances  = false;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic Object visitOperationCallExp(OperationCallExp oc) {" + NL + "\t\t\t\t\t\tif(!usesAllInstances) {" + NL + "\t\t\t\t\t\t\tusesAllInstances = PredefinedType.ALL_INSTANCES == oc.getOperationCode();" + NL + "\t\t\t\t\t\t\tif(usesAllInstances) {" + NL + "\t\t\t\t\t\t\t\tqueryToInit.setExtentMap(EcoreEnvironmentFactory.ECORE_INSTANCE.createExtentMap(extentContext));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.visitOperationCallExp(oc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tqueryToInit.getExpression().accept(visitior);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate static EcoreEnvironmentFactory createCustomEnv(Map environment) {" + NL + "\t\t\tfinal Map env = environment;" + NL + "\t\t\treturn new EcoreEnvironmentFactory() {\t\t\t\t\t" + NL + "\t\t\t\tpublic Environment createClassifierContext(Object context) {" + NL + "\t\t\t\t\tEnvironment ecoreEnv = super.createClassifierContext(context);" + NL + "\t\t\t\t\tfor (Iterator it = env.keySet().iterator(); it.hasNext();) {" + NL + "\t\t\t\t\t\tString varName = (String)it.next();" + NL + "\t\t\t\t\t\tEClassifier varType = (EClassifier)env.get(varName);" + NL + "\t\t\t\t\t\tecoreEnv.addElement(varName, createVar(varName, varType), true);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn ecoreEnv;" + NL + "\t\t\t\t}" + NL + "\t\t\t};\t\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate static Variable createVar(String name, EClassifier type) {" + NL + "\t\t\tVariable var = ExpressionsFactory.eINSTANCE.createVariable();" + NL + "\t\t\tvar.setName(name);" + NL + "\t\t\tvar.setType(EcoreEnvironment.getOCLType(type));" + NL + "\t\t\treturn var;" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenExpressionInterpreter genInterpreter = (GenExpressionInterpreter) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = genInterpreter.getContainer().getEditorGen().getDiagram();
final String factoryClassName = genInterpreter.getClassName();
final String abstractExpressionClass = genInterpreter.getContainer().getAbstractExpressionQualifiedClassName();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    
importManager.registerInnerClass("Expression");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.ecore.EClassifier");
importManager.addImport("org.eclipse.emf.ecore.EEnum");
importManager.addImport("org.eclipse.emf.ecore.EEnumLiteral");
importManager.addImport("org.eclipse.emf.ecore.ETypedElement");
importManager.addImport("org.eclipse.emf.ocl.expressions.ExpressionsFactory");
importManager.addImport("org.eclipse.emf.ocl.expressions.OCLExpression");
importManager.addImport("org.eclipse.emf.ocl.expressions.Variable");
importManager.addImport("org.eclipse.emf.ocl.expressions.OperationCallExp");
importManager.addImport("org.eclipse.emf.ocl.expressions.util.AbstractVisitor");
importManager.addImport("org.eclipse.emf.ocl.utilities.PredefinedType");

importManager.addImport("org.eclipse.emf.ocl.helper.HelperUtil");
importManager.addImport("org.eclipse.emf.ocl.helper.IOCLHelper");
importManager.addImport("org.eclipse.emf.ocl.helper.OCLParsingException");
importManager.addImport("org.eclipse.emf.ocl.parser.EcoreEnvironment");
importManager.addImport("org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory");
importManager.addImport("org.eclipse.emf.ocl.parser.EvaluationEnvironment");
importManager.addImport("org.eclipse.emf.ocl.parser.Environment");
importManager.addImport("org.eclipse.emf.ocl.query.Query");
importManager.addImport("org.eclipse.emf.ocl.query.QueryFactory");
importManager.addImport("org.eclipse.emf.ocl.types.util.Types");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(factoryClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(factoryClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(abstractExpressionClass));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(abstractExpressionClass));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(abstractExpressionClass));
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
