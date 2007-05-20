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
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated " + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_8 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tpublic static ";
  protected final String TEXT_9 = " getExpression(String body, EClassifier context, Map environment) {\t\t" + NL + "\t\treturn new Expression(body, context, environment);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tpublic static ";
  protected final String TEXT_10 = " getExpression(String body, EClassifier context) {\t\t" + NL + "\t\treturn getExpression(body, context, Collections.EMPTY_MAP);" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tprivate static class Expression extends ";
  protected final String TEXT_11 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate WeakReference queryRef;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate final OCL oclInstance;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t\t" + NL + "\t\tpublic Expression(String body, EClassifier context, Map environment) {" + NL + "\t\t\tsuper(body, context);" + NL + "\t\t\toclInstance = OCL.newInstance();" + NL + "\t\t\tinitCustomEnv(oclInstance.getEnvironment(), environment);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprotected Query getQuery() {" + NL + "\t\t\tQuery oclQuery = null;" + NL + "\t\t\tif(this.queryRef != null) {" + NL + "\t\t\t\toclQuery = (Query)this.queryRef.get();" + NL + "\t\t\t}" + NL + "\t\t\tif(oclQuery == null) {" + NL + "\t\t\t\tOCLHelper oclHelper = oclInstance.createOCLHelper();" + NL + "\t\t\t\toclHelper.setContext(context());" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tOCLExpression oclExpression = oclHelper.createQuery(body());" + NL + "\t\t\t\t\toclQuery = oclInstance.createQuery(oclExpression);" + NL + "\t\t\t\t\tthis.queryRef = new WeakReference(oclQuery);" + NL + "\t\t\t\t\tsetStatus(IStatus.OK, null, null);" + NL + "\t\t\t\t} catch (ParserException e) {" + NL + "\t\t\t\t\tsetStatus(IStatus.ERROR, e.getMessage(), e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn oclQuery;\t\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprotected Object doEvaluate(Object context, Map env) {" + NL + "\t\t\tQuery oclQuery = getQuery();\t\t\t\t\t" + NL + "\t\t\tif (oclQuery == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\tEvaluationEnvironment evalEnv = oclQuery.getEvaluationEnvironment();" + NL + "\t\t\t// init environment" + NL + "\t\t\tfor (Iterator it = env.entrySet().iterator(); it.hasNext();) {" + NL + "\t\t\t\tMap.Entry nextEntry = (Map.Entry) it.next();" + NL + "\t\t\t\tevalEnv.replace((String)nextEntry.getKey(), nextEntry.getValue());\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tinitExtentMap(context);" + NL + "\t\t\t\tObject result = oclQuery.evaluate(context);" + NL + "\t\t\t\treturn (result != oclInstance.getEnvironment().getOCLStandardLibrary().getOclInvalid()) ? result : null;" + NL + "\t\t\t} finally {\t\t\t\t" + NL + "\t\t\t\tevalEnv.clear();" + NL + "\t\t\t\toclQuery.getExtentMap().clear();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprotected Object performCast(Object value, ETypedElement targetType) {" + NL + "\t\t\tif (targetType.getEType() instanceof EEnum) {" + NL + "\t\t\t\tif(value instanceof EEnumLiteral) {" + NL + "\t\t\t\t\tEEnumLiteral literal = (EEnumLiteral)value;" + NL + "\t\t\t\t\treturn (literal.getInstance() != null) ? literal.getInstance() : literal;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn super.performCast(value, targetType);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate void initExtentMap(Object context) {" + NL + "\t\t\tif (!getStatus().isOK() || context == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tfinal Query queryToInit = getQuery();" + NL + "\t\t\tfinal Object extentContext = context;" + NL + "\t\t\t" + NL + "\t\t\tqueryToInit.getExtentMap().clear();" + NL + "\t\t\tif (queryToInit.queryText() != null && queryToInit.queryText().indexOf(PredefinedType.ALL_INSTANCES_NAME) >= 0) {" + NL + "\t\t\t\tAbstractVisitor visitior = new AbstractVisitor() {" + NL + "\t\t\t\t\tprivate boolean usesAllInstances  = false;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic Object visitOperationCallExp(OperationCallExp oc) {" + NL + "\t\t\t\t\t\tif(!usesAllInstances) {" + NL + "\t\t\t\t\t\t\tusesAllInstances = PredefinedType.ALL_INSTANCES == oc.getOperationCode();" + NL + "\t\t\t\t\t\t\tif(usesAllInstances) {" + NL + "\t\t\t\t\t\t\t\tqueryToInit.getExtentMap().putAll(oclInstance.getEvaluationEnvironment().createExtentMap(extentContext));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn super.visitOperationCallExp(oc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tqueryToInit.getExpression().accept(visitior);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate static void initCustomEnv(Environment ecoreEnv, Map environment) {" + NL + "\t\t\tfor (Iterator it = environment.keySet().iterator(); it.hasNext();) {" + NL + "\t\t\t\t\t\tString varName = (String)it.next();" + NL + "\t\t\t\tEClassifier varType = (EClassifier) environment.get(varName);" + NL + "\t\t\t\tecoreEnv.addElement(varName, createVar(ecoreEnv, varName, varType), false);" + NL + "\t\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate static Variable createVar(Environment ecoreEnv, String name, EClassifier type) {" + NL + "\t\t\tVariable var = EcoreFactory.eINSTANCE.createVariable(); // or ecoreEnv.getOCLFactory().createVariable()?" + NL + "\t\t\tvar.setName(name);" + NL + "\t\t\tvar.setType(ecoreEnv.getUMLReflection().getOCLType(type));" + NL + "\t\t\treturn var;" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenExpressionInterpreter genInterpreter = (GenExpressionInterpreter) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = genInterpreter.getContainer().getEditorGen().getDiagram();
final String factoryClassName = genInterpreter.getClassName();
final String abstractExpressionClass = genInterpreter.getContainer().getAbstractExpressionQualifiedClassName();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.registerInnerClass("Expression");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.Map");
importManager.addImport("java.lang.ref.WeakReference");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.ecore.EClassifier");
importManager.addImport("org.eclipse.emf.ecore.EEnum");
importManager.addImport("org.eclipse.emf.ecore.EEnumLiteral");
importManager.addImport("org.eclipse.emf.ecore.ETypedElement");

importManager.addImport("org.eclipse.ocl.Environment");
importManager.addImport("org.eclipse.ocl.EvaluationEnvironment");
importManager.addImport("org.eclipse.ocl.ParserException");
importManager.addImport("org.eclipse.ocl.Query");
importManager.addImport("org.eclipse.ocl.ecore.EcoreFactory");
importManager.addImport("org.eclipse.ocl.ecore.OCL");
importManager.addImport("org.eclipse.ocl.expressions.OCLExpression");
importManager.addImport("org.eclipse.ocl.expressions.OperationCallExp");
importManager.addImport("org.eclipse.ocl.expressions.Variable");
importManager.addImport("org.eclipse.ocl.helper.OCLHelper");
importManager.addImport("org.eclipse.ocl.utilities.AbstractVisitor");
importManager.addImport("org.eclipse.ocl.utilities.PredefinedType");


    stringBuffer.append(TEXT_5);
    stringBuffer.append(factoryClassName);
    stringBuffer.append(TEXT_6);
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
