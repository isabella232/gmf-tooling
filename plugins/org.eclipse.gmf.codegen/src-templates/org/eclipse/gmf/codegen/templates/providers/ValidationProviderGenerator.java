package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.internal.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class ValidationProviderGenerator
{
  protected static String nl;
  public static synchronized ValidationProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ValidationProviderGenerator result = new ValidationProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractContributionItemProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean constraintsActive = false;\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean shouldConstraintsBePrivate() {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {" + NL + "\t\tif (";
  protected final String TEXT_7 = ".ValidateAction.VALIDATE_ACTION_KEY.equals(actionId)) {" + NL + "\t\t\treturn new ";
  protected final String TEXT_8 = ".ValidateAction(partDescriptor);" + NL + "\t\t}" + NL + "\t\treturn super.createAction(actionId, partDescriptor);" + NL + "\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static void runWithConstraints(View view, Runnable op) {" + NL + "\t\t\tfinal Runnable fop = op;" + NL + "\t\t\tRunnable task = new Runnable() {" + NL + "" + NL + "\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tconstraintsActive = true;" + NL + "\t\t\t\t\t\tfop.run();" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tconstraintsActive = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tTransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(view);" + NL + "\t\t\tif (txDomain != null) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\ttxDomain.runExclusive(task);" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttask.run();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic boolean isInDefaultEditorContext(Object object) {" + NL + "\t\tif(shouldConstraintsBePrivate() && !constraintsActive) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tif (object instanceof View) {" + NL + "\t\t\treturn constraintsActive && ";
  protected final String TEXT_10 = ".MODEL_ID.equals(";
  protected final String TEXT_11 = ".getModelID((View)object));" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}\t";
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tpublic static class ";
  protected final String TEXT_13 = " implements ";
  protected final String TEXT_14 = " {";
  protected final String TEXT_15 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {\t\t" + NL + "\t\t\tif(isInDefaultEditorContext(object) && object instanceof View) {" + NL + "\t\t\t\tString id = ((View) object).getType();" + NL + "\t\t\t\treturn id != null && semanticCtxIdMap.get(id) == ";
  protected final String TEXT_16 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_17 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {" + NL + "\t\t\treturn isInDefaultEditorContext(object);\t" + NL + "\t\t}\t" + NL + "\t}\t\t";
  protected final String TEXT_18 = NL + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic final ";
  protected final String TEXT_19 = " semanticCtxIdMap = new ";
  protected final String TEXT_20 = "();" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic {";
  protected final String TEXT_21 = NL + "\t\tsemanticCtxIdMap.put(String.valueOf(";
  protected final String TEXT_22 = "), ";
  protected final String TEXT_23 = ".class); //$NON-NLS-1$";
  protected final String TEXT_24 = NL + "\t}";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_27 = " getNotationTraversalStrategy(IBatchValidator validator) {";
  protected final String TEXT_28 = "\t" + NL + "\t\treturn new CtxSwitchStrategy(validator);";
  protected final String TEXT_29 = "\t\t\t" + NL + "\t\treturn validator.getDefaultTraversalStrategy();";
  protected final String TEXT_30 = NL + "\t}";
  protected final String TEXT_31 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class CtxSwitchStrategy implements ";
  protected final String TEXT_32 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_33 = " defaultStrategy;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate String currentSemanticCtxId;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean ctxChanged = true;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject currentTarget;\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject preFetchedNextTarget;\t\t" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tCtxSwitchStrategy(IBatchValidator validator) {" + NL + "\t\t\tthis.defaultStrategy = validator.getDefaultTraversalStrategy();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void elementValidated(EObject element, IStatus status) {" + NL + "\t\t\tdefaultStrategy.elementValidated(element, status);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasNext() {" + NL + "\t\t\treturn defaultStrategy.hasNext();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isClientContextChanged() {" + NL + "\t\t\tif(preFetchedNextTarget == null) {" + NL + "\t\t\t\tpreFetchedNextTarget = next();" + NL + "\t\t\t\tprepareNextClientContext(preFetchedNextTarget);\t\t\t\t" + NL + "\t\t\t}\t\t\t  \t\t\t" + NL + "\t\t\treturn ctxChanged;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EObject next() {" + NL + "\t\t\tEObject nextTarget = preFetchedNextTarget;" + NL + "\t\t\tif(nextTarget == null) {" + NL + "\t\t\t\tnextTarget = defaultStrategy.next();" + NL + "\t\t\t}" + NL + "\t\t\tthis.preFetchedNextTarget = null;" + NL + "\t\t\treturn this.currentTarget = nextTarget;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void startTraversal(";
  protected final String TEXT_34 = " traversalRoots," + NL + "\t\t\t\t";
  protected final String TEXT_35 = " monitor) {" + NL + "\t\t\tdefaultStrategy.startTraversal(traversalRoots, monitor);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void prepareNextClientContext(EObject nextTarget) { " + NL + "\t\t\tif (nextTarget != null && currentTarget != null) {" + NL + "\t\t\t\tif (nextTarget instanceof View) {" + NL + "\t\t\t\t\tString id = ((View) nextTarget).getType();" + NL + "\t\t\t\t\tString nextSemanticId = id != null" + NL + "\t\t\t\t\t\t\t&& semanticCtxIdMap.containsKey(id) ? id : null;" + NL + "\t\t\t\t\tif ((currentSemanticCtxId != null && !currentSemanticCtxId" + NL + "\t\t\t\t\t\t\t.equals(nextSemanticId))" + NL + "\t\t\t\t\t\t\t|| (nextSemanticId != null && !nextSemanticId" + NL + "\t\t\t\t\t\t\t\t\t.equals(currentSemanticCtxId))) {" + NL + "\t\t\t\t\t\tthis.ctxChanged = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcurrentSemanticCtxId = nextSemanticId;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t// context of domain model" + NL + "\t\t\t\t\tthis.ctxChanged = currentSemanticCtxId != null;" + NL + "\t\t\t\t\tcurrentSemanticCtxId = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthis.ctxChanged = false;" + NL + "\t\t\t}" + NL + "\t\t}\t\t" + NL + "\t}// CtxSwitchStrategy";
  protected final String TEXT_36 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_37 = " extends ";
  protected final String TEXT_38 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_39 = " expression;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_40 = "() {" + NL + "\t\t\texpression = ";
  protected final String TEXT_41 = "null";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = "(";
  protected final String TEXT_44 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "(";
  protected final String TEXT_49 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_50 = ")";
  protected final String TEXT_51 = "new ";
  protected final String TEXT_52 = "(";
  protected final String TEXT_53 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_54 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_55 = " self = (";
  protected final String TEXT_56 = ")context;";
  protected final String TEXT_57 = "\t" + NL + "\t\t";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = " = (";
  protected final String TEXT_60 = ")env.get(\"";
  protected final String TEXT_61 = "\"); //$NON-NLS-1$";
  protected final String TEXT_62 = NL + "\t\treturn ";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = "(self";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_67 = NL + ";\t\t" + NL + "\t\t}\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IStatus validate(";
  protected final String TEXT_68 = " ctx) {" + NL + "\t\t\tObject evalCtx = ctx.getTarget();";
  protected final String TEXT_69 = NL + "\t\t\tif(evalCtx instanceof EObject) evalCtx = ((EObject)evalCtx).eGet(";
  protected final String TEXT_70 = "());" + NL + "\t\t\tif(evalCtx == null) {";
  protected final String TEXT_71 = NL + "\t\t\t\treturn ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) });";
  protected final String TEXT_72 = NL + "\t\t\t\treturn ";
  protected final String TEXT_73 = ".OK_STATUS;";
  protected final String TEXT_74 = NL + "\t\t\t}\t\t\t";
  protected final String TEXT_75 = "\t\t\t" + NL + "\t\t\tevalCtx = ";
  protected final String TEXT_76 = ".calculateMetric(";
  protected final String TEXT_77 = ", evalCtx);";
  protected final String TEXT_78 = "\t\t" + NL + "\t\t\tObject result = expression.evaluate(evalCtx);" + NL + "\t\t\tif(result instanceof Boolean && ((Boolean)result).booleanValue()) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_79 = ".OK_STATUS;" + NL + "\t\t\t}" + NL + "\t\t\treturn ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) }); " + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_80 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "static class ";
  protected final String TEXT_81 = " {";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_84 = " ";
  protected final String TEXT_85 = "(";
  protected final String TEXT_86 = " self";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = " ";
  protected final String TEXT_89 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_90 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_91 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_92 = NL + "} //";
  protected final String TEXT_93 = NL + "} //";
  protected final String TEXT_94 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram)((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
final GenAuditRoot audits = genDiagram.getEditorGen().getAudits();
final boolean hasNotationModelAudit;
{
 boolean hasDiagramElementRule = false;
 if (audits != null) {
  for (java.util.Iterator it = audits.getRules().iterator(); it.hasNext();) {
   GenAuditRule r = (GenAuditRule) it.next();
   if (r.getTarget() instanceof GenDiagramElementTarget || r.getTarget() instanceof GenNotationElementTarget) {
    hasDiagramElementRule = true;
    break;
   }
  }
 }
 hasNotationModelAudit = audits != null && hasDiagramElementRule;
}
final boolean rcp = genDiagram.getEditorGen().getApplication() != null;

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
final java.util.HashSet<String> innerClasses = new java.util.HashSet<String>();
final String __javaOperationContainer = "JavaAudits";
if(audits != null) {
	innerClasses.add(__javaOperationContainer);
	//innerClasses.addAll(audits.getAllRequiredConstraintAdaptersLocalClassNames());
	for (java.util.Iterator it = audits.getRules().iterator(); it.hasNext();) {
		GenAuditRule nextAudit = (GenAuditRule) it.next();
		if (nextAudit.isRequiresConstraintAdapter()) {
			String nextClassName = nextAudit.getConstraintAdapterLocalClassName();
			if (nextClassName != null) {
				innerClasses.add(nextClassName);
			}
		}
	}
	//innerClasses.addAll(audits.getAllContextSelectorsLocalClassNames());
	for (java.util.Iterator it = audits.getRules().iterator(); it.hasNext();) {
		String nextClassName = ((GenAuditRule) it.next()).getContextSelectorLocalClassName();
		if(nextClassName != null) {
			innerClasses.add(nextClassName);
		}			
	}	
}
innerClasses.add("CtxSwitchStrategy");
innerClasses.add("ValidateAction");
for(java.util.Iterator it = innerClasses.iterator(); it.hasNext();) importManager.registerInnerClass((String)it.next()); 

importManager.markImportLocation(stringBuffer);

if (!rcp) {
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.emf.workspace.util.WorkspaceSynchronizer");
}
importManager.addImport("java.util.ArrayList");
importManager.addImport("java.util.Arrays");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.List");
importManager.addImport("java.util.Map");
importManager.addImport("java.util.HashSet");
importManager.addImport("java.util.Set");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.common.util.Diagnostic");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.util.Diagnostician");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.emf.transaction.util.TransactionUtil");
importManager.addImport("org.eclipse.emf.validation.model.EvaluationMode");
importManager.addImport("org.eclipse.emf.validation.service.IBatchValidator");
importManager.addImport("org.eclipse.emf.validation.service.ModelValidationService");
importManager.addImport("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor");
importManager.addImport("org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil");
importManager.addImport("org.eclipse.emf.validation.model.IConstraintStatus");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.jface.action.Action");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.ui.IEditorPart");
importManager.addImport("org.eclipse.ui.PlatformUI");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getEditorGen().getEditor().getPackageName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditorGen().getEditor().getPackageName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    
boolean usesNotationContextSwitch = false;
java.util.List allAudits = (audits != null) ? audits.getRules() : java.util.Collections.EMPTY_LIST;
// mere pairs
java.util.HashMap<String, GenAuditRule> contextId2Audit = new java.util.HashMap<String, GenAuditRule>();
java.util.Map<GenCommonBase, String> view2SelectorMap = new java.util.IdentityHashMap<GenCommonBase, String>();
for(java.util.Iterator it = allAudits.iterator(); it.hasNext();) {
	GenAuditRule audit = (GenAuditRule)it.next();
	String contextID = (audit.getTarget() != null) ? audit.getTarget().getClientContextID() : null;
	if(contextID == null || contextId2Audit.containsKey(contextID)) continue;
	contextId2Audit.put(contextID, audit);
}
for (GenAuditRule audit : contextId2Audit.values()) {
	String selectorClassName = audit.getContextSelectorLocalClassName();

    stringBuffer.append(TEXT_12);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.model.IClientSelector"));
    stringBuffer.append(TEXT_14);
    
	if(audit.getTarget() instanceof GenDiagramElementTarget) {
		usesNotationContextSwitch = true;
		GenDiagramElementTarget	diagramElement = (GenDiagramElementTarget)audit.getTarget();
		for(java.util.Iterator diagramElementIt = diagramElement.getElement().iterator(); diagramElementIt.hasNext();) {
			GenCommonBase nextElement = (GenCommonBase) diagramElementIt.next();
			view2SelectorMap.put(nextElement, selectorClassName);
		}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_16);
    	} else {
    stringBuffer.append(TEXT_17);
    
	} 
} // end of audits iteration
		
if(usesNotationContextSwitch) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_20);
    
	for(java.util.Iterator it = view2SelectorMap.keySet().iterator(); it.hasNext();) {
		GenCommonBase nextView = (GenCommonBase)it.next();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(nextView.getEditPartQualifiedClassName()) + ".VISUAL_ID");
    stringBuffer.append(TEXT_22);
    stringBuffer.append(view2SelectorMap.get(nextView));
    stringBuffer.append(TEXT_23);
    	} // end of view ID iteration 
    stringBuffer.append(TEXT_24);
    
} // end of context map generation //usesNotationContextSwitch 

    stringBuffer.append(TEXT_25);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_27);
    	if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    	} // end of usesNotationContextSwitch 
    stringBuffer.append(TEXT_30);
    } // end of hasNotationModelAudit			

if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_35);
    } // end of usesNotationContextSwitch

final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
final java.util.Map __exprEnvVariables = java.util.Collections.EMPTY_MAP;
final String __outEnvVarName = ""; // no env to setup //$NON-NLS-1$ 
for(java.util.Iterator it = allAudits.iterator(); it.hasNext();) {
	GenAuditRule nextAudit = (GenAuditRule)it.next();
	if(nextAudit.isRequiresConstraintAdapter() && nextAudit.getRule() != null && nextAudit.getTarget() != null && nextAudit.getTarget().getContext() != null) {
		GenClassifier __genExprContext = nextAudit.getTarget().getContext();		 
		ValueExpression __genValueExpression = nextAudit.getRule();
		String importedExpressionBase = (expressionProviders != null) ? importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()) : "null"; //$NON-NLS-1$

    stringBuffer.append(TEXT_36);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.AbstractModelConstraint"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importedExpressionBase);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_40);
    
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

    stringBuffer.append(TEXT_41);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_46);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_50);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_51);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_56);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_61);
    		} 
    stringBuffer.append(TEXT_62);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_63);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_64);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_65);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_66);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.IValidationContext"));
    stringBuffer.append(TEXT_68);
    		if(nextAudit.getTarget() instanceof GenDomainAttributeTarget) {
			GenDomainAttributeTarget attrTarget = (GenDomainAttributeTarget) nextAudit.getTarget();
			if(attrTarget.getAttribute() != null) {
				String fGetter = (attrTarget.getAttribute() != null) ? importManager.getImportedName(attrTarget.getAttribute().getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + attrTarget.getAttribute().getFeatureAccessorName() : ""; //$NON-NLS-1$ //$NON-NLS-2$

    stringBuffer.append(TEXT_69);
    stringBuffer.append(fGetter);
    stringBuffer.append(TEXT_70);
    				if(attrTarget.isNullAsError()) { 
    stringBuffer.append(TEXT_71);
    				} else {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_73);
    				} 
    stringBuffer.append(TEXT_74);
    			}
		} else if(nextAudit.getTarget() instanceof GenAuditedMetricTarget) {
			GenAuditedMetricTarget metricTarget = (GenAuditedMetricTarget)nextAudit.getTarget();
			String metricKey = (metricTarget.getMetric() != null) ? metricTarget.getMetric().getKey() : "";
			String metricProviderClassName = importManager.getImportedName(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(metricProviderClassName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(Conversions.toStringLiteral(metricKey));
    stringBuffer.append(TEXT_77);
    
		}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_79);
    
	}
} /*end of Adapters iteration*/

final java.util.List<GenAuditRule> javaExpressions = new java.util.ArrayList<GenAuditRule>();
if (audits != null && audits.getEditorGen().getExpressionProviders() != null) {
  GenExpressionProviderContainer exprProviders = audits.getEditorGen().getExpressionProviders();
  for (java.util.Iterator it = audits.getRules().iterator(); it.hasNext();) {
    GenAuditRule nextAudit = (GenAuditRule) it.next();
    if(nextAudit.getRule() != null && exprProviders.getProvider(nextAudit.getRule()) instanceof GenJavaExpressionProvider) {
      javaExpressions.add(nextAudit);
    }
  }
}

if(!javaExpressions.isEmpty()) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_81);
    
	for (GenAuditRule nextJavaRule : javaExpressions) {
		GenClassifier __genExprContext = nextJavaRule.getTarget().getContext();		
		ValueExpression __genValueExpression = nextJavaRule.getRule();
		String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_82);
    
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

    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_86);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_89);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_91);
    
} /* end of GenJavaExpressionProvider */

    
	}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(__javaOperationContainer);
    
} /* end of Java expression methods */

    stringBuffer.append(TEXT_93);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_94);
    return stringBuffer.toString();
  }
}
