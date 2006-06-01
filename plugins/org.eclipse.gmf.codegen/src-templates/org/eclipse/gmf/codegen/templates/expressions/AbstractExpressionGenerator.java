package org.eclipse.gmf.codegen.templates.expressions;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class AbstractExpressionGenerator
{
  protected static String nl;
  public static synchronized AbstractExpressionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractExpressionGenerator result = new AbstractExpressionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_7 = " {\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String body;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EClassifier context;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate IStatus status = Status.OK_STATUS;\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_8 = "(EClassifier context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected ";
  protected final String TEXT_9 = "(String body, EClassifier context, Map env) {" + NL + "\t\tthis.body = body;" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected void setStatus(int severity, String message, Throwable throwable) {\t\t" + NL + "\t\tString pluginID = ";
  protected final String TEXT_10 = ".ID;" + NL + "\t\tthis.status = new Status(severity, pluginID, -1, (message != null) ? message : \"\", throwable); //$NON-NLS-1$" + NL + "\t\tif(!this.status.isOK()) {" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t.getInstance().logError(\"Expression problem:\" + message + \"body:\"+ body, throwable); //$NON-NLS-1$ //$NON-NLS-2$" + NL + "\t\t" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprotected abstract Object doEvaluate(Object context, Map env);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object evaluate(Object context) {" + NL + "\t\treturn evaluate(context, Collections.EMPTY_MAP);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic Object evaluate(Object context, Map env) {" + NL + "\t\tif(context().isInstance(context)) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\treturn doEvaluate(context, env);" + NL + "\t\t\t} catch(Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t.getInstance().logError(\"Expression evaluation failure: \" + body, e);" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic IStatus getStatus() {" + NL + "\t\treturn status;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic String body() {" + NL + "\t\treturn body;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EClassifier context() {" + NL + "\t\treturn context;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static final ";
  protected final String TEXT_13 = " createNullExpression(EClassifier context) {" + NL + "\t\treturn new ";
  protected final String TEXT_14 = "(context) {" + NL + "\t\t\tprotected Object doEvaluate(Object context, Map env) {" + NL + "\t\t\t\t// TODO - log entry about not provider available for this expression" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "}";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenExpressionProviderContainer providerContainer = genDiagram.getEditorGen().getExpressionProviders();

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
    
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.core.runtime.Status");
importManager.addImport("org.eclipse.emf.ecore.EClassifier");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(providerContainer.getAbstractExpressionClassName());
    stringBuffer.append(TEXT_14);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
