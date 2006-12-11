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
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractContributionItemProvider {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean constraintsActive = false;\t" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean shouldConstraintsBePrivate() {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {" + NL + "\t\tif (ValidateAction.VALIDATE_ACTION_KEY.equals(actionId)) {" + NL + "\t\t\treturn new ValidateAction(partDescriptor);" + NL + "\t\t}" + NL + "\t\treturn super.createAction(actionId, partDescriptor);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ValidateAction extends Action {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic static final String VALIDATE_ACTION_KEY = \"validateAction\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate IWorkbenchPartDescriptor workbenchPartDescriptor;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ValidateAction(IWorkbenchPartDescriptor workbenchPartDescriptor) {" + NL + "\t\t\tsetId(VALIDATE_ACTION_KEY);" + NL + "\t\t\tsetText(\"Validate\");" + NL + "\t\t\tthis.workbenchPartDescriptor = workbenchPartDescriptor;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run() {" + NL + "\t\t\tIWorkbenchPart workbenchPart = workbenchPartDescriptor.getPartPage().getActivePart();" + NL + "\t\t\tif(workbenchPart instanceof IDiagramWorkbenchPart) {" + NL + "\t\t\t\tfinal IDiagramWorkbenchPart part = (IDiagramWorkbenchPart)workbenchPart;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tnew ";
  protected final String TEXT_7 = "(" + NL + "\t\t\t\t\t\tnew ";
  protected final String TEXT_8 = "() {" + NL + "\t\t\t\t\t\t\tpublic void run(";
  protected final String TEXT_9 = " monitor) throws InterruptedException, ";
  protected final String TEXT_10 = " {" + NL + "\t\t\t\t\t\t\t\trunValidation(part.getDiagramEditPart(), part.getDiagram());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t).run(new ";
  protected final String TEXT_11 = "());\t\t\t" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/** " + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static void runValidation(View view) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tif(";
  protected final String TEXT_13 = ".openDiagram(view.eResource())) {" + NL + "\t\t\t\t\tIEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();" + NL + "\t\t\t\t\tif(editorPart instanceof IDiagramWorkbenchPart) {" + NL + "\t\t\t\t\t\trunValidation(((IDiagramWorkbenchPart)editorPart).getDiagramEditPart(), view);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\trunNonUIValidation(view);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_14 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static void runNonUIValidation(View view) {" + NL + "\t\t\tDiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(view.getDiagram());" + NL + "\t\t\trunValidation(diagramEditPart, view);" + NL + "\t\t}\t\t" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static void runValidation(DiagramEditPart diagramEditPart, View view) {" + NL + "\t\t\tfinal View target = view;" + NL + "\t\t\tfinal DiagramEditPart diagramPart = diagramEditPart;" + NL + "\t\t\tRunnable task = new Runnable() {" + NL + "\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tconstraintsActive = true;" + NL + "\t\t\t\t\t\tvalidate(diagramPart, target);" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tconstraintsActive = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tTransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(target);" + NL + "\t\t\tif(txDomain != null) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\ttxDomain.runExclusive(task);" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttask.run();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static Diagnostic runEMFValidator(View target) {" + NL + "\t\t\tif(target.isSetElement() && target.getElement() != null) {" + NL + "\t\t\t\treturn new Diagnostician() {" + NL + "\t\t\t\t\tpublic String getObjectLabel(EObject eObject) {" + NL + "\t\t\t\t\t\treturn EMFCoreUtil.getQualifiedName(eObject, true);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}.validate(target.getElement());" + NL + "\t\t\t}" + NL + "\t\t\treturn Diagnostic.OK_INSTANCE;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static void validate(DiagramEditPart diagramEditPart, View target) {" + NL + "\t\t\tIFile diagramFile = (target.eResource() != null) ? WorkspaceSynchronizer.getFile(target.eResource()) : null;" + NL + "\t\t\tif(diagramFile != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_16 = ".deleteMarkers(diagramFile);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tDiagnostic diagnostic = runEMFValidator(target);" + NL + "\t\t\tif(diagramFile != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_17 = ".createMarkers(diagramFile, diagnostic, diagramEditPart);" + NL + "\t\t\t}\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tIBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);" + NL + "\t\t\tvalidator.setIncludeLiveConstraints(true);" + NL + "\t\t\tIStatus status = ";
  protected final String TEXT_18 = ".OK_STATUS;" + NL + "\t\t\tif(target.isSetElement() && target.getElement() != null) {" + NL + "\t\t\t\tstatus = validator.validate(target.getElement());" + NL + "\t\t\t\tif(diagramFile != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = ".createMarkers(diagramFile, status, diagramEditPart);" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\t}" + NL;
  protected final String TEXT_20 = NL + "\t\t\tvalidator.setTraversalStrategy(getNotationTraversalStrategy(validator));" + NL + "\t\t\tstatus = validator.validate(target);" + NL + "\t\t\tif(diagramFile != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_21 = ".createMarkers(diagramFile, status, diagramEditPart);" + NL + "\t\t\t}";
  protected final String TEXT_22 = NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic boolean isInDefaultEditorContext(Object object) {" + NL + "\t\tif(shouldConstraintsBePrivate() && !constraintsActive) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tif (object instanceof View) {" + NL + "\t\t\treturn constraintsActive && ";
  protected final String TEXT_23 = ".MODEL_ID.equals(";
  protected final String TEXT_24 = ".getModelID((View)object));" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}\t";
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tpublic static class ";
  protected final String TEXT_26 = " implements ";
  protected final String TEXT_27 = " {";
  protected final String TEXT_28 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {\t\t" + NL + "\t\t\tif(isInDefaultEditorContext(object) && object instanceof View) {" + NL + "\t\t\t\tString id = ((View) object).getType();" + NL + "\t\t\t\treturn id != null && semanticCtxIdMap.get(id) == ";
  protected final String TEXT_29 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_30 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {" + NL + "\t\t\treturn isInDefaultEditorContext(object);\t" + NL + "\t\t}\t" + NL + "\t}\t\t";
  protected final String TEXT_31 = NL + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic final ";
  protected final String TEXT_32 = " semanticCtxIdMap = new ";
  protected final String TEXT_33 = "();" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic {";
  protected final String TEXT_34 = NL + "\t\tsemanticCtxIdMap.put(String.valueOf(";
  protected final String TEXT_35 = "), ";
  protected final String TEXT_36 = ".class); //$NON-NLS-1$";
  protected final String TEXT_37 = NL + "\t}";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic ";
  protected final String TEXT_40 = " getNotationTraversalStrategy(IBatchValidator validator) {";
  protected final String TEXT_41 = "\t" + NL + "\t\treturn new CtxSwitchStrategy(validator);";
  protected final String TEXT_42 = "\t\t\t" + NL + "\t\treturn validator.getDefaultTraversalStrategy();";
  protected final String TEXT_43 = NL + "\t}";
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class CtxSwitchStrategy implements ";
  protected final String TEXT_45 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_46 = " defaultStrategy;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate String currentSemanticCtxId;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean ctxChanged = true;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject currentTarget;\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject preFetchedNextTarget;\t\t" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tCtxSwitchStrategy(IBatchValidator validator) {" + NL + "\t\t\tthis.defaultStrategy = validator.getDefaultTraversalStrategy();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void elementValidated(EObject element, IStatus status) {" + NL + "\t\t\tdefaultStrategy.elementValidated(element, status);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasNext() {" + NL + "\t\t\treturn defaultStrategy.hasNext();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isClientContextChanged() {" + NL + "\t\t\tif(preFetchedNextTarget == null) {" + NL + "\t\t\t\tpreFetchedNextTarget = next();" + NL + "\t\t\t\tprepareNextClientContext(preFetchedNextTarget);\t\t\t\t" + NL + "\t\t\t}\t\t\t  \t\t\t" + NL + "\t\t\treturn ctxChanged;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EObject next() {" + NL + "\t\t\tEObject nextTarget = preFetchedNextTarget;" + NL + "\t\t\tif(nextTarget == null) {" + NL + "\t\t\t\tnextTarget = defaultStrategy.next();" + NL + "\t\t\t}" + NL + "\t\t\tthis.preFetchedNextTarget = null;" + NL + "\t\t\treturn this.currentTarget = nextTarget;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void startTraversal(";
  protected final String TEXT_47 = " traversalRoots," + NL + "\t\t\t\t";
  protected final String TEXT_48 = " monitor) {" + NL + "\t\t\tdefaultStrategy.startTraversal(traversalRoots, monitor);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void prepareNextClientContext(EObject nextTarget) { " + NL + "\t\t\tif (nextTarget != null && currentTarget != null) {" + NL + "\t\t\t\tif (nextTarget instanceof View) {" + NL + "\t\t\t\t\tString id = ((View) nextTarget).getType();" + NL + "\t\t\t\t\tString nextSemanticId = id != null" + NL + "\t\t\t\t\t\t\t&& semanticCtxIdMap.containsKey(id) ? id : null;" + NL + "\t\t\t\t\tif ((currentSemanticCtxId != null && !currentSemanticCtxId" + NL + "\t\t\t\t\t\t\t.equals(nextSemanticId))" + NL + "\t\t\t\t\t\t\t|| (nextSemanticId != null && !nextSemanticId" + NL + "\t\t\t\t\t\t\t\t\t.equals(currentSemanticCtxId))) {" + NL + "\t\t\t\t\t\tthis.ctxChanged = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcurrentSemanticCtxId = nextSemanticId;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t// context of domain model" + NL + "\t\t\t\t\tthis.ctxChanged = currentSemanticCtxId != null;" + NL + "\t\t\t\t\tcurrentSemanticCtxId = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthis.ctxChanged = false;" + NL + "\t\t\t}" + NL + "\t\t}\t\t" + NL + "\t}// CtxSwitchStrategy";
  protected final String TEXT_49 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_50 = " extends ";
  protected final String TEXT_51 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_52 = " expression;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_53 = "() {" + NL + "\t\t\texpression = ";
  protected final String TEXT_54 = "null";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ")";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = "(";
  protected final String TEXT_62 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_63 = ")";
  protected final String TEXT_64 = "new ";
  protected final String TEXT_65 = "(";
  protected final String TEXT_66 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_67 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_68 = " self = (";
  protected final String TEXT_69 = ")context;";
  protected final String TEXT_70 = "\t" + NL + "\t\t";
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = " = (";
  protected final String TEXT_73 = ")env.get(\"";
  protected final String TEXT_74 = "\"); //$NON-NLS-1$";
  protected final String TEXT_75 = NL + "\t\treturn ";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = "(self";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_80 = NL + ";\t\t" + NL + "\t\t}\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IStatus validate(";
  protected final String TEXT_81 = " ctx) {" + NL + "\t\t\tObject evalCtx = ctx.getTarget();";
  protected final String TEXT_82 = NL + "\t\t\tif(evalCtx instanceof EObject) evalCtx = ((EObject)evalCtx).eGet(";
  protected final String TEXT_83 = "());" + NL + "\t\t\tif(evalCtx == null) {";
  protected final String TEXT_84 = NL + "\t\t\t\treturn ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) });";
  protected final String TEXT_85 = NL + "\t\t\t\treturn ";
  protected final String TEXT_86 = ".OK_STATUS;";
  protected final String TEXT_87 = NL + "\t\t\t}\t\t\t";
  protected final String TEXT_88 = "\t\t\t" + NL + "\t\t\tevalCtx = ";
  protected final String TEXT_89 = ".calculateMetric(";
  protected final String TEXT_90 = ", evalCtx);";
  protected final String TEXT_91 = "\t\t" + NL + "\t\t\tObject result = expression.evaluate(evalCtx);" + NL + "\t\t\tif(result instanceof Boolean && ((Boolean)result).booleanValue()) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_92 = ".OK_STATUS;" + NL + "\t\t\t}" + NL + "\t\t\treturn ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) }); " + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_93 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "static class ";
  protected final String TEXT_94 = " {";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_97 = " ";
  protected final String TEXT_98 = "(";
  protected final String TEXT_99 = " self";
  protected final String TEXT_100 = ", ";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_103 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_104 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_105 = NL + "} //";
  protected final String TEXT_106 = NL + "} //";
  protected final String TEXT_107 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram)((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
final GenAuditContainer audits = genDiagram.getEditorGen().getAudits();
final boolean hasNotationModelAudit = audits != null && audits.hasDiagramElementRule();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
final java.util.List innerClasses = new java.util.ArrayList();
final String __javaOperationContainer = "JavaAudits";
if(audits != null) {
	innerClasses.add(__javaOperationContainer);
	innerClasses.addAll(audits.getAllRequiredConstraintAdaptersLocalClassNames());
	innerClasses.addAll(audits.getAllContextSelectorsLocalClassNames());
}
innerClasses.add("CtxSwitchStrategy");
innerClasses.add("ValidateAction");
for(java.util.Iterator it = innerClasses.iterator(); it.hasNext();) importManager.registerInnerClass((String)it.next()); 

importManager.markImportLocation(stringBuffer);

importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.common.util.Diagnostic");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.util.Diagnostician");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.emf.transaction.util.TransactionUtil");

importManager.addImport("org.eclipse.emf.validation.model.EvaluationMode");
importManager.addImport("org.eclipse.emf.validation.service.IBatchValidator");
importManager.addImport("org.eclipse.emf.validation.service.ModelValidationService");
importManager.addImport("org.eclipse.emf.workspace.util.WorkspaceSynchronizer");
importManager.addImport("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor");
importManager.addImport("org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.jface.action.Action");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.ui.IEditorPart");
importManager.addImport("org.eclipse.ui.PlatformUI");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.operation.IRunnableWithProgress"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("java.lang.reflect.InvocationTargetException"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getMarkerNavigationProviderQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genDiagram.getMarkerNavigationProviderQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getMarkerNavigationProviderQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genDiagram.getMarkerNavigationProviderQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    } // end of diagram element validation 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    
boolean usesNotationContextSwitch = false;
java.util.Map ctx2Rules = (audits != null) ? audits.getAllRulesToTargetContextMap() : new java.util.HashMap();
java.util.List allAudits = (audits != null) ? audits.getAllAuditRules() : java.util.Collections.EMPTY_LIST;
java.util.Map view2SelectorMap = new java.util.IdentityHashMap();
for(java.util.Iterator it = allAudits.iterator(); it.hasNext();) {
	GenAuditRule audit = (GenAuditRule)it.next();
	String contextID = (audit.getTarget() != null) ? audit.getTarget().getClientContextID() : null;
	if(contextID == null || null == ctx2Rules.remove(contextID)) continue;
	String selectorClassName = audit.getContextSelectorLocalClassName();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.model.IClientSelector"));
    stringBuffer.append(TEXT_27);
    
	if(audit.getTarget() instanceof GenDiagramElementTarget) {
		usesNotationContextSwitch = true;
		GenDiagramElementTarget	diagramElement = (GenDiagramElementTarget)audit.getTarget();
		for(java.util.Iterator diagramElementIt = diagramElement.getElement().iterator(); diagramElementIt.hasNext();) {
			GenCommonBase nextElement = (GenCommonBase) diagramElementIt.next();
			view2SelectorMap.put(nextElement, selectorClassName);
		}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_29);
    	} else {
    stringBuffer.append(TEXT_30);
    
	} 
} // end of audits iteration
		
if(usesNotationContextSwitch) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_33);
    
	for(java.util.Iterator it = view2SelectorMap.keySet().iterator(); it.hasNext();) {
		GenCommonBase nextView = (GenCommonBase)it.next();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(nextView.getEditPartQualifiedClassName()) + ".VISUAL_ID");
    stringBuffer.append(TEXT_35);
    stringBuffer.append(view2SelectorMap.get(nextView));
    stringBuffer.append(TEXT_36);
    	} // end of view ID iteration 
    stringBuffer.append(TEXT_37);
    
} // end of context map generation //usesNotationContextSwitch 

    stringBuffer.append(TEXT_38);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_40);
    	if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    	} // end of usesNotationContextSwitch 
    stringBuffer.append(TEXT_43);
    } // end of hasNotationModelAudit			

if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_48);
    } // end of usesNotationContextSwitch

final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
final java.util.Map __exprEnvVariables = java.util.Collections.EMPTY_MAP;
final String __outEnvVarName = ""; // no env to setup //$NON-NLS-1$ 
for(java.util.Iterator it = allAudits.iterator(); it.hasNext();) {
	GenAuditRule nextAudit = (GenAuditRule)it.next();
	if(nextAudit.requiresConstraintAdapter() && nextAudit.getRule() != null && nextAudit.getTarget() != null && nextAudit.getTarget().getContext() != null) {
		GenClassifier __genExprContext = nextAudit.getTarget().getContext();		 
		ValueExpression __genValueExpression = nextAudit.getRule();
		String importedExpressionBase = (expressionProviders != null) ? importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()) : "null"; //$NON-NLS-1$

    stringBuffer.append(TEXT_49);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.AbstractModelConstraint"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importedExpressionBase);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_53);
    
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

    stringBuffer.append(TEXT_54);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_59);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_63);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_64);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_69);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_74);
    		} 
    stringBuffer.append(TEXT_75);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_76);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_77);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_78);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_79);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.IValidationContext"));
    stringBuffer.append(TEXT_81);
    		if(nextAudit.getTarget() instanceof GenDomainAttributeTarget) {
			GenDomainAttributeTarget attrTarget = (GenDomainAttributeTarget) nextAudit.getTarget();
			if(attrTarget.getAttribute() != null) {
				String fGetter = (attrTarget.getAttribute() != null) ? importManager.getImportedName(attrTarget.getAttribute().getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + attrTarget.getAttribute().getFeatureAccessorName() : ""; //$NON-NLS-1$ //$NON-NLS-2$

    stringBuffer.append(TEXT_82);
    stringBuffer.append(fGetter);
    stringBuffer.append(TEXT_83);
    				if(attrTarget.isNullAsError()) { 
    stringBuffer.append(TEXT_84);
    				} else {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_86);
    				} 
    stringBuffer.append(TEXT_87);
    			}
		} else if(nextAudit.getTarget() instanceof GenAuditedMetricTarget) {
			GenAuditedMetricTarget metricTarget = (GenAuditedMetricTarget)nextAudit.getTarget();
			String metricKey = (metricTarget.getMetric() != null) ? metricTarget.getMetric().getKey() : "";
			String metricProviderClassName = importManager.getImportedName(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(metricProviderClassName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(Conversions.toStringLiteral(metricKey));
    stringBuffer.append(TEXT_90);
    
		}

    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_92);
    
	}
} /*end of Adapters iteration*/

final java.util.List javaExpressions = (audits != null) ? audits.getAllJavaLangAudits() : java.util.Collections.EMPTY_LIST;
if(!javaExpressions.isEmpty()) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_94);
    
	for (java.util.Iterator it = javaExpressions.iterator(); it.hasNext();) {
		GenAuditRule nextJavaRule = (GenAuditRule) it.next();
		GenClassifier __genExprContext = nextJavaRule.getTarget().getContext();		
		ValueExpression __genValueExpression = nextJavaRule.getRule();
		String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_95);
    
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

    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_99);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_102);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_104);
    
} /* end of GenJavaExpressionProvider */

    
	}

    stringBuffer.append(TEXT_105);
    stringBuffer.append(__javaOperationContainer);
    
} /* end of Java expression methods */

    stringBuffer.append(TEXT_106);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_107);
    return stringBuffer.toString();
  }
}
