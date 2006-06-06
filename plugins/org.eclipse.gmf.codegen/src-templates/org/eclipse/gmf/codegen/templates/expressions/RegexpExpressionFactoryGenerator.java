package org.eclipse.gmf.codegen.templates.expressions;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class RegexpExpressionFactoryGenerator
{
  protected static String nl;
  public static synchronized RegexpExpressionFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    RegexpExpressionFactoryGenerator result = new RegexpExpressionFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated " + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_8 = " getExpression(String body," + NL + "\t\t\tEClassifier context, Map environment) {" + NL + "\t\treturn new Expression(body, context, environment);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_9 = " getExpression(String body," + NL + "\t\t\tEClassifier context) {" + NL + "\t\treturn getExpression(body, context, Collections.EMPTY_MAP);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprivate static class Expression extends ";
  protected final String TEXT_10 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate Pattern pattern;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tpublic Expression(String body, EClassifier context, Map environment) {" + NL + "\t\t\tsuper(body, context, environment);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tthis.pattern = Pattern.compile(body);" + NL + "\t\t\t} catch (PatternSyntaxException e) {" + NL + "\t\t\t\tsetStatus(IStatus.ERROR, e.getMessage(), e);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprotected Object doEvaluate(Object contextInstance, Map env) {" + NL + "\t\t\tif (pattern == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(context() instanceof EDataType) {" + NL + "\t\t\t\tcontextInstance = EcoreUtil.convertToString((EDataType)context(), contextInstance);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tMatcher matcher = this.pattern.matcher(String.valueOf(contextInstance));" + NL + "\t\t\treturn Boolean.valueOf(";
  protected final String TEXT_11 = "matcher.matches());" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenExpressionInterpreter genInterpreter = (GenExpressionInterpreter) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = genInterpreter.getContainer().getEditorGen().getDiagram();
final String factoryClassName = genInterpreter.getClassName();
final String abstractExpressionClass = genInterpreter.getContainer().getAbstractExpressionQualifiedClassName();
final boolean isNegationRegexp = !GenLanguage.REGEXP_LITERAL.equals(genInterpreter.getLanguage());

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
importManager.registerInnerClass("Expression");

importManager.addImport("java.util.Collections");
importManager.addImport("java.util.Map");
importManager.addImport("java.util.regex.Matcher");
importManager.addImport("java.util.regex.Pattern");
importManager.addImport("java.util.regex.PatternSyntaxException");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.ecore.EClassifier");
importManager.addImport("org.eclipse.emf.ecore.EDataType");
importManager.addImport("org.eclipse.emf.ecore.util.EcoreUtil");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(factoryClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(factoryClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(abstractExpressionClass));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(abstractExpressionClass));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(abstractExpressionClass));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(isNegationRegexp ? "!" : "");
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
