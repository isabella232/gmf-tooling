package org.eclipse.gmf.codegen.templates.lite.providers;

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
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean constraintsActive = false;\t" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean shouldConstraintsBePrivate() {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ValidateAction extends Action {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic static final String VALIDATE_ACTION_KEY = \"validateAction\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate IWorkbenchPart myWorkbenchPart;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ValidateAction(IWorkbenchPart part) {" + NL + "\t\t\tsetId(VALIDATE_ACTION_KEY);" + NL + "\t\t\tsetText(\"Validate\");" + NL + "\t\t\tmyWorkbenchPart = part;" + NL + "\t\t\tsetEnabled(myWorkbenchPart instanceof ";
  protected final String TEXT_7 = ");" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run() {" + NL + "\t\t\tif (!isEnabled()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tfinal ";
  protected final String TEXT_8 = " part = (";
  protected final String TEXT_9 = ") myWorkbenchPart;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tnew ";
  protected final String TEXT_10 = "() {" + NL + "\t\t\t\t\tpublic void run(";
  protected final String TEXT_11 = " monitor) throws InterruptedException, ";
  protected final String TEXT_12 = " {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_13 = " viewer = (";
  protected final String TEXT_14 = ") part.getAdapter(";
  protected final String TEXT_15 = ".class);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_16 = " diagram = part.getDiagram();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_17 = " viewService;" + NL + "\t\t\t\t\t\tif (viewer == null) {" + NL + "\t\t\t\t\t\t\tviewService = new ";
  protected final String TEXT_18 = "(diagram);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tviewService = new ";
  protected final String TEXT_19 = "(viewer);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\trunValidation(diagram, viewService);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t.run(new ";
  protected final String TEXT_20 = "());" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_21 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static void runValidation(View view, ";
  protected final String TEXT_22 = " service) {" + NL + "\t\t\tfinal View target = view;" + NL + "\t\t\tfinal ";
  protected final String TEXT_23 = " viewService = service;" + NL + "\t\t\tRunnable task = new Runnable() {" + NL + "\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tconstraintsActive = true;" + NL + "\t\t\t\t\t\tvalidate(target, viewService);" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\tconstraintsActive = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tTransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(target);" + NL + "\t\t\tif(txDomain != null) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\ttxDomain.runExclusive(task);" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttask.run();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static Diagnostic runEMFValidator(View target) {" + NL + "\t\t\tif(target.isSetElement() && target.getElement() != null) {" + NL + "\t\t\t\treturn new Diagnostician().validate(target.getElement());" + NL + "\t\t\t}" + NL + "\t\t\treturn Diagnostic.OK_INSTANCE;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static void validate(View target, ";
  protected final String TEXT_25 = " viewService) {" + NL + "\t\t\t";
  protected final String TEXT_26 = " diagramUri = (target.getDiagram() != null) ? ";
  protected final String TEXT_27 = ".getURI(target.getDiagram()) : null;" + NL + "\t\t\tif (diagramUri != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_28 = " validationState = ";
  protected final String TEXT_29 = ".getInstance().getValidationStateManager().getValidationState(diagramUri);" + NL + "\t\t\t\t";
  protected final String TEXT_30 = " updater = validationState.startUpdate();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tDiagnostic diagnostic = runEMFValidator(target);" + NL + "\t\t\t\t\tupdate(updater, diagnostic, viewService);" + NL + "\t\t\t\t\tIBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);" + NL + "\t\t\t\t\tvalidator.setIncludeLiveConstraints(true);" + NL + "\t\t\t\t\tif (target.isSetElement() && target.getElement() != null) {" + NL + "\t\t\t\t\t\tIStatus status = validator.validate(target.getElement());" + NL + "\t\t\t\t\t\tupdate(updater, status, viewService);" + NL + "\t\t\t\t\t}" + NL;
  protected final String TEXT_31 = NL + "\t\t\t\t\tvalidator.setTraversalStrategy(getNotationTraversalStrategy(validator));" + NL + "\t\t\t\t\tIStatus status = validator.validate(target);" + NL + "\t\t\t\t\tupdate(updater, status, viewService);";
  protected final String TEXT_32 = NL + "\t\t\t\t\tupdater.commitChanges();" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tupdater.discardChanges();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static void update(";
  protected final String TEXT_33 = " updater, Diagnostic emfValidationStatus, ";
  protected final String TEXT_34 = " viewService) {" + NL + "\t\t\tif (emfValidationStatus.getSeverity() == Diagnostic.OK) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tfinal Diagnostic rootStatus = emfValidationStatus;" + NL + "\t\t\t";
  protected final String TEXT_35 = " allDiagnostics = new ";
  protected final String TEXT_36 = "();" + NL + "\t\t\tcollectTargetElements(rootStatus, new ";
  protected final String TEXT_37 = "(), allDiagnostics);" + NL + "\t\t\tfor (";
  protected final String TEXT_38 = " it = emfValidationStatus.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t\tDiagnostic nextDiagnostic = (Diagnostic) it.next();" + NL + "\t\t\t\t";
  protected final String TEXT_39 = " data = nextDiagnostic.getData();" + NL + "\t\t\t\tif (data != null && !data.isEmpty() && data.get(0) instanceof ";
  protected final String TEXT_40 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = " element = (";
  protected final String TEXT_42 = ") data.get(0);" + NL + "\t\t\t\t\tView view = viewService.findView(element);" + NL + "\t\t\t\t\tif (view != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = " next = ";
  protected final String TEXT_44 = ".create(view, nextDiagnostic);" + NL + "\t\t\t\t\t\tif (next != null) {" + NL + "\t\t\t\t\t\t\tupdater.addViolation(next);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t * @elsewhere see XXXMarkerNavigationProvider" + NL + "\t\t */" + NL + "\t\tprivate static void update(";
  protected final String TEXT_45 = " updater, IStatus validationStatus, ";
  protected final String TEXT_46 = " viewService) {" + NL + "\t\t\tif (validationStatus.isOK()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tfinal IStatus rootStatus = validationStatus;" + NL + "\t\t\t";
  protected final String TEXT_47 = " allStatuses = new ";
  protected final String TEXT_48 = "();" + NL + "\t\t\tcollectTargetElements(rootStatus, new ";
  protected final String TEXT_49 = "(), allStatuses);" + NL + "\t\t\tfor (";
  protected final String TEXT_50 = " it = allStatuses.iterator(); it.hasNext();) {" + NL + "\t\t\t\t";
  protected final String TEXT_51 = " nextStatus = (";
  protected final String TEXT_52 = ") it.next();" + NL + "\t\t\t\tView view = viewService.findView(nextStatus.getTarget());" + NL + "\t\t\t\tif (view != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_53 = " next = ";
  protected final String TEXT_54 = ".create(view, nextStatus);" + NL + "\t\t\t\t\tif (next != null) {" + NL + "\t\t\t\t\t\tupdater.addViolation(next);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_55 = " collectTargetElements(Diagnostic diagnostic, ";
  protected final String TEXT_56 = " targetElementCollector, ";
  protected final String TEXT_57 = " allDiagnostics) {" + NL + "\t\t\t";
  protected final String TEXT_58 = " data = diagnostic.getData();" + NL + "\t\t\tEObject target = null;" + NL + "\t\t\tif (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {" + NL + "\t\t\t\ttarget = (EObject) data.get(0);" + NL + "\t\t\t\ttargetElementCollector.add(target);" + NL + "\t\t\t\tallDiagnostics.add(diagnostic);" + NL + "\t\t\t}" + NL + "\t\t\tif (diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {" + NL + "\t\t\t\tfor (";
  protected final String TEXT_59 = " it = diagnostic.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tcollectTargetElements((Diagnostic) it.next(), targetElementCollector, allDiagnostics);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn targetElementCollector;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_60 = " collectTargetElements(IStatus status, ";
  protected final String TEXT_61 = " targetElementCollector, ";
  protected final String TEXT_62 = " allConstraintStatuses) {" + NL + "\t\t\tif (status instanceof IConstraintStatus) {" + NL + "\t\t\t\ttargetElementCollector.add(((IConstraintStatus) status).getTarget());" + NL + "\t\t\t\tallConstraintStatuses.add(status);" + NL + "\t\t\t}" + NL + "\t\t\tif (status.isMultiStatus()) {" + NL + "\t\t\t\tIStatus[] children = status.getChildren();" + NL + "\t\t\t\tfor (int i = 0; i < children.length; i++) {" + NL + "\t\t\t\t\tcollectTargetElements(children[i], targetElementCollector, allConstraintStatuses);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn targetElementCollector;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic boolean isInDefaultEditorContext(Object object) {" + NL + "\t\tif(shouldConstraintsBePrivate() && !constraintsActive) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tif (object instanceof View) {" + NL + "\t\t\treturn constraintsActive && ";
  protected final String TEXT_63 = ".MODEL_ID.equals(";
  protected final String TEXT_64 = ".getModelID((View)object));" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}\t";
  protected final String TEXT_65 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tpublic static class ";
  protected final String TEXT_66 = " implements ";
  protected final String TEXT_67 = " {";
  protected final String TEXT_68 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {\t\t" + NL + "\t\t\tif(isInDefaultEditorContext(object) && object instanceof View) {" + NL + "\t\t\t\tString id = ((View) object).getType();" + NL + "\t\t\t\treturn id != null && semanticCtxIdMap.get(id) == ";
  protected final String TEXT_69 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_70 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {" + NL + "\t\t\treturn isInDefaultEditorContext(object);\t" + NL + "\t\t}\t" + NL + "\t}\t\t";
  protected final String TEXT_71 = NL + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic final ";
  protected final String TEXT_72 = " semanticCtxIdMap = new ";
  protected final String TEXT_73 = "();" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic {";
  protected final String TEXT_74 = NL + "\t\tsemanticCtxIdMap.put(String.valueOf(";
  protected final String TEXT_75 = "), ";
  protected final String TEXT_76 = ".class); //$NON-NLS-1$";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL;
  protected final String TEXT_79 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic ";
  protected final String TEXT_80 = " getNotationTraversalStrategy(IBatchValidator validator) {";
  protected final String TEXT_81 = "\t" + NL + "\t\treturn new CtxSwitchStrategy(validator);";
  protected final String TEXT_82 = "\t\t\t" + NL + "\t\treturn validator.getDefaultTraversalStrategy();";
  protected final String TEXT_83 = NL + "\t}";
  protected final String TEXT_84 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class CtxSwitchStrategy implements ";
  protected final String TEXT_85 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_86 = " defaultStrategy;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate String currentSemanticCtxId;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean ctxChanged = true;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject currentTarget;\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject preFetchedNextTarget;\t\t" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tCtxSwitchStrategy(IBatchValidator validator) {" + NL + "\t\t\tthis.defaultStrategy = validator.getDefaultTraversalStrategy();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void elementValidated(EObject element, IStatus status) {" + NL + "\t\t\tdefaultStrategy.elementValidated(element, status);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasNext() {" + NL + "\t\t\treturn defaultStrategy.hasNext();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isClientContextChanged() {" + NL + "\t\t\tif(preFetchedNextTarget == null) {" + NL + "\t\t\t\tpreFetchedNextTarget = next();" + NL + "\t\t\t\tprepareNextClientContext(preFetchedNextTarget);\t\t\t\t" + NL + "\t\t\t}\t\t\t  \t\t\t" + NL + "\t\t\treturn ctxChanged;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EObject next() {" + NL + "\t\t\tEObject nextTarget = preFetchedNextTarget;" + NL + "\t\t\tif(nextTarget == null) {" + NL + "\t\t\t\tnextTarget = defaultStrategy.next();" + NL + "\t\t\t}" + NL + "\t\t\tthis.preFetchedNextTarget = null;" + NL + "\t\t\treturn this.currentTarget = nextTarget;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void startTraversal(";
  protected final String TEXT_87 = " traversalRoots," + NL + "\t\t\t\t";
  protected final String TEXT_88 = " monitor) {" + NL + "\t\t\tdefaultStrategy.startTraversal(traversalRoots, monitor);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void prepareNextClientContext(EObject nextTarget) { " + NL + "\t\t\tif (nextTarget != null && currentTarget != null) {" + NL + "\t\t\t\tif (nextTarget instanceof View) {" + NL + "\t\t\t\t\tString id = ((View) nextTarget).getType();" + NL + "\t\t\t\t\tString nextSemanticId = id != null" + NL + "\t\t\t\t\t\t\t&& semanticCtxIdMap.containsKey(id) ? id : null;" + NL + "\t\t\t\t\tif ((currentSemanticCtxId != null && !currentSemanticCtxId" + NL + "\t\t\t\t\t\t\t.equals(nextSemanticId))" + NL + "\t\t\t\t\t\t\t|| (nextSemanticId != null && !nextSemanticId" + NL + "\t\t\t\t\t\t\t\t\t.equals(currentSemanticCtxId))) {" + NL + "\t\t\t\t\t\tthis.ctxChanged = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcurrentSemanticCtxId = nextSemanticId;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t// context of domain model" + NL + "\t\t\t\t\tthis.ctxChanged = currentSemanticCtxId != null;" + NL + "\t\t\t\t\tcurrentSemanticCtxId = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthis.ctxChanged = false;" + NL + "\t\t\t}" + NL + "\t\t}\t\t" + NL + "\t}// CtxSwitchStrategy";
  protected final String TEXT_89 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_90 = " extends ";
  protected final String TEXT_91 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_92 = " expression;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ";
  protected final String TEXT_93 = "() {" + NL + "\t\t\texpression = ";
  protected final String TEXT_94 = "null";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = ")";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = "(";
  protected final String TEXT_102 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_103 = ")";
  protected final String TEXT_104 = "new ";
  protected final String TEXT_105 = "(";
  protected final String TEXT_106 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_107 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_108 = " self = (";
  protected final String TEXT_109 = ")context;";
  protected final String TEXT_110 = "\t" + NL + "\t\t";
  protected final String TEXT_111 = " ";
  protected final String TEXT_112 = " = (";
  protected final String TEXT_113 = ")env.get(\"";
  protected final String TEXT_114 = "\"); //$NON-NLS-1$";
  protected final String TEXT_115 = NL + "\t\treturn ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = "(self";
  protected final String TEXT_118 = ", ";
  protected final String TEXT_119 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_120 = NL + ";\t\t" + NL + "\t\t}\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IStatus validate(";
  protected final String TEXT_121 = " ctx) {" + NL + "\t\t\tObject evalCtx = ctx.getTarget();";
  protected final String TEXT_122 = NL + "\t\t\tif(evalCtx instanceof EObject) evalCtx = ((EObject)evalCtx).eGet(";
  protected final String TEXT_123 = "());" + NL + "\t\t\tif(evalCtx == null) {";
  protected final String TEXT_124 = NL + "\t\t\t\treturn ctx.createFailureStatus(new Object[] { formatElement(ctx.getTarget()) });";
  protected final String TEXT_125 = NL + "\t\t\t\treturn ";
  protected final String TEXT_126 = ".OK_STATUS;";
  protected final String TEXT_127 = NL + "\t\t\t}\t\t\t";
  protected final String TEXT_128 = "\t\t\t" + NL + "\t\t\tevalCtx = ";
  protected final String TEXT_129 = ".calculateMetric(";
  protected final String TEXT_130 = ", evalCtx);";
  protected final String TEXT_131 = "\t\t" + NL + "\t\t\tObject result = expression.evaluate(evalCtx);" + NL + "\t\t\tif(result instanceof Boolean && ((Boolean)result).booleanValue()) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_132 = ".OK_STATUS;" + NL + "\t\t\t}" + NL + "\t\t\treturn ctx.createFailureStatus(new Object[] { formatElement(ctx.getTarget()) }); " + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String formatElement(";
  protected final String TEXT_133 = " object) {" + NL + "\t\t\tif (object == null) {" + NL + "\t\t\t\treturn String.valueOf((Object)null);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_134 = " adapterFactory = ";
  protected final String TEXT_135 = ".getInstance().getItemProvidersAdapterFactory();" + NL + "\t\t\t";
  protected final String TEXT_136 = " labelProvider = (";
  protected final String TEXT_137 = ") adapterFactory.adapt(object, ";
  protected final String TEXT_138 = ".class);" + NL + "\t\t\tif (labelProvider != null) {" + NL + "\t\t\t\treturn object.eClass() + \" \" + labelProvider.getText(object);" + NL + "\t\t\t}" + NL + "\t\t\treturn object.toString();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_139 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "static class ";
  protected final String TEXT_140 = " {";
  protected final String TEXT_141 = NL;
  protected final String TEXT_142 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_143 = " ";
  protected final String TEXT_144 = "(";
  protected final String TEXT_145 = " self";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = " ";
  protected final String TEXT_148 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_149 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_150 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_151 = NL + "} //";
  protected final String TEXT_152 = NL + "} //";
  protected final String TEXT_153 = NL;

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


    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
final java.util.List<String> innerClasses = new java.util.ArrayList<String>();
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

importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.common.util.Diagnostic");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.util.Diagnostician");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.emf.transaction.util.TransactionUtil");
importManager.addImport("org.eclipse.emf.validation.model.EvaluationMode");
importManager.addImport("org.eclipse.emf.validation.model.IConstraintStatus");
importManager.addImport("org.eclipse.emf.validation.service.IBatchValidator");
importManager.addImport("org.eclipse.emf.validation.service.ModelValidationService");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.jface.action.Action");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.ui.IEditorPart");
importManager.addImport("org.eclipse.ui.PlatformUI");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.operation.IRunnableWithProgress"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.lang.reflect.InvocationTargetException"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalViewer"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.NaiveViewService"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.EditPartRegistryBasedViewService"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.NullProgressMonitor"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.ValidationState"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.IValidationStateUpdater"));
    stringBuffer.append(TEXT_30);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.IValidationStateUpdater"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("java.util.HashSet"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.ViolationDescriptor"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.ViolationDescriptor"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.IValidationStateUpdater"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.canonical.IViewService"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("java.util.HashSet"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.model.IConstraintStatus"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.model.IConstraintStatus"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.ViolationDescriptor"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.validation.ViolationDescriptor"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.util.Set"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Set"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.Set"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("java.util.Set"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_64);
    
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

    stringBuffer.append(TEXT_65);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.model.IClientSelector"));
    stringBuffer.append(TEXT_67);
    
	if(audit.getTarget() instanceof GenDiagramElementTarget) {
		usesNotationContextSwitch = true;
		GenDiagramElementTarget	diagramElement = (GenDiagramElementTarget)audit.getTarget();
		for(java.util.Iterator diagramElementIt = diagramElement.getElement().iterator(); diagramElementIt.hasNext();) {
			GenCommonBase nextElement = (GenCommonBase) diagramElementIt.next();
			view2SelectorMap.put(nextElement, selectorClassName);
		}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_69);
    	} else {
    stringBuffer.append(TEXT_70);
    
	} 
} // end of audits iteration
		
if(usesNotationContextSwitch) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_73);
    
	for(java.util.Iterator it = view2SelectorMap.keySet().iterator(); it.hasNext();) {
		GenCommonBase nextView = (GenCommonBase)it.next();

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(nextView.getEditPartQualifiedClassName()) + ".VISUAL_ID");
    stringBuffer.append(TEXT_75);
    stringBuffer.append(view2SelectorMap.get(nextView));
    stringBuffer.append(TEXT_76);
    	} // end of view ID iteration 
    stringBuffer.append(TEXT_77);
    
} // end of context map generation //usesNotationContextSwitch 

    stringBuffer.append(TEXT_78);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_80);
    	if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_81);
    } else {
    stringBuffer.append(TEXT_82);
    	} // end of usesNotationContextSwitch 
    stringBuffer.append(TEXT_83);
    } // end of hasNotationModelAudit			

if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_88);
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

    stringBuffer.append(TEXT_89);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.AbstractModelConstraint"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importedExpressionBase);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_93);
    
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

    stringBuffer.append(TEXT_94);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_99);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_103);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_104);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_109);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_114);
    		} 
    stringBuffer.append(TEXT_115);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_116);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_117);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_118);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_119);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.IValidationContext"));
    stringBuffer.append(TEXT_121);
    		if(nextAudit.getTarget() instanceof GenDomainAttributeTarget) {
			GenDomainAttributeTarget attrTarget = (GenDomainAttributeTarget) nextAudit.getTarget();
			if(attrTarget.getAttribute() != null) {
				String fGetter = (attrTarget.getAttribute() != null) ? importManager.getImportedName(attrTarget.getAttribute().getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + attrTarget.getAttribute().getFeatureAccessorName() : ""; //$NON-NLS-1$ //$NON-NLS-2$

    stringBuffer.append(TEXT_122);
    stringBuffer.append(fGetter);
    stringBuffer.append(TEXT_123);
    				if(attrTarget.isNullAsError()) { 
    stringBuffer.append(TEXT_124);
    				} else {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_126);
    				} 
    stringBuffer.append(TEXT_127);
    			}
		} else if(nextAudit.getTarget() instanceof GenAuditedMetricTarget) {
			GenAuditedMetricTarget metricTarget = (GenAuditedMetricTarget)nextAudit.getTarget();
			String metricKey = (metricTarget.getMetric() != null) ? metricTarget.getMetric().getKey() : "";
			String metricProviderClassName = importManager.getImportedName(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(metricProviderClassName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(Conversions.toStringLiteral(metricKey));
    stringBuffer.append(TEXT_130);
    
		}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.AdapterFactory"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IItemLabelProvider"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IItemLabelProvider"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IItemLabelProvider"));
    stringBuffer.append(TEXT_138);
    
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

    stringBuffer.append(TEXT_139);
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_140);
    
	for (java.util.Iterator it = javaExpressions.iterator(); it.hasNext();) {
		GenAuditRule nextJavaRule = (GenAuditRule) it.next();
		GenClassifier __genExprContext = nextJavaRule.getTarget().getContext();		
		ValueExpression __genValueExpression = nextJavaRule.getRule();
		String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_141);
    
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

    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_145);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_148);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_150);
    
} /* end of GenJavaExpressionProvider */

    
	}

    stringBuffer.append(TEXT_151);
    stringBuffer.append(__javaOperationContainer);
    
} /* end of Java expression methods */

    stringBuffer.append(TEXT_152);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_153);
    return stringBuffer.toString();
  }
}
