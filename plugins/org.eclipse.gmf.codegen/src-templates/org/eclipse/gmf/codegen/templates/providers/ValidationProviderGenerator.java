package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
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
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends AbstractContributionItemProvider {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {" + NL + "\t\tif (ValidateAction.VALIDATE_ACTION_KEY.equals(actionId)) {" + NL + "\t\t\treturn new ValidateAction(partDescriptor);" + NL + "\t\t}" + NL + "\t\treturn super.createAction(actionId, partDescriptor);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ValidateAction extends Action {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String MARKER_TYPE = ";
  protected final String TEXT_8 = ".ID + \".";
  protected final String TEXT_9 = "\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tpublic static final String VALIDATE_ACTION_KEY = \"validateAction\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate IWorkbenchPartDescriptor workbenchPartDescriptor;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ValidateAction(IWorkbenchPartDescriptor workbenchPartDescriptor) {" + NL + "\t\t\tsetId(VALIDATE_ACTION_KEY);" + NL + "\t\t\tsetText(\"Validate\");" + NL + "\t\t\tthis.workbenchPartDescriptor = workbenchPartDescriptor;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run() {" + NL + "\t\t\tIWorkbenchPart workbenchPart = workbenchPartDescriptor.getPartPage().getActivePart();" + NL + "\t\t\tif(workbenchPart instanceof IDiagramWorkbenchPart) {" + NL + "\t\t\t\tfinal IDiagramWorkbenchPart part = (IDiagramWorkbenchPart)workbenchPart;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tpart.getDiagramEditPart().getEditingDomain().runExclusive(" + NL + "\t\t\t\t\t\tnew Runnable() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\tvalidate(part.getDiagram());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t}catch (Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = ".getInstance().logError(\"Validation action failed\", e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void validate(Diagram diagram) {" + NL + "\t\t\tIFile diagramFile = WorkspaceSynchronizer.getFile(diagram.eResource());" + NL + "\t\t\ttry {" + NL + "\t\t\t\tdiagramFile.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);" + NL + "\t\t\t} catch (CoreException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_11 = ".getInstance().logError(null, e);" + NL + "\t\t\t}" + NL + "\t\t\tDiagnostic diagnostic = new Diagnostician() {" + NL + "\t\t\t\tpublic String getObjectLabel(EObject eObject) {" + NL + "\t\t\t\t\treturn EMFCoreUtil.getQualifiedName(eObject, true);" + NL + "\t\t\t\t}" + NL + "\t\t\t}.validate(diagram.getElement());" + NL + "\t\t\t" + NL + "\t\t\tIBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);" + NL + "\t\t\tIStatus status = validator.validate(diagram.getElement());" + NL + "\t\t\tList allStatuses = new ArrayList();\t\t\t" + NL + "\t\t\tallStatuses.addAll(Arrays.asList(status.isMultiStatus() ? status.getChildren() : new IStatus[] { status }));";
  protected final String TEXT_12 = NL + "\t\t\tvalidator.setTraversalStrategy(getNotationTraversalStrategy(validator));" + NL + "\t\t\tstatus = validator.validate(diagram);" + NL + "\t\t\tallStatuses.addAll(Arrays.asList(status.isMultiStatus() ? status.getChildren() : new IStatus[] { status }));";
  protected final String TEXT_13 = NL + NL + "\t\t\tHashSet targets = new HashSet();" + NL + "\t\t\tfor (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t\ttargets.add(getDiagnosticTarget((Diagnostic)it.next()));" + NL + "\t\t\t}\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tfor (Iterator it = allStatuses.iterator(); it.hasNext();) {\t\t\t" + NL + "\t\t\t\tObject nextStatus = it.next();" + NL + "\t\t\t\tif(nextStatus instanceof IConstraintStatus) {" + NL + "\t\t\t\t\ttargets.add(((IConstraintStatus)nextStatus).getTarget());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tMap viewMap = buildElement2ViewMap(diagram, targets);" + NL + "\t\t\tfor (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t\tDiagnostic nextDiagnostic = (Diagnostic) it.next();" + NL + "\t\t\t\tList data = nextDiagnostic.getData();" + NL + "\t\t\t\tif (!data.isEmpty() && data.get(0) instanceof EObject) {" + NL + "\t\t\t\t\tEObject element = (EObject)data.get(0);" + NL + "\t\t\t\t\tView view = findTargetView(element, viewMap);" + NL + "\t\t\t\t\taddMarker(diagramFile, view != null ? view : diagram, element, nextDiagnostic.getMessage(), diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tfor (Iterator it = allStatuses.iterator(); it.hasNext();) {" + NL + "\t\t\t\tObject nextStatusObj = it.next();" + NL + "\t\t\t\tif(nextStatusObj instanceof IConstraintStatus) {" + NL + "\t\t\t\t\tIConstraintStatus nextStatus = (IConstraintStatus)nextStatusObj;" + NL + "\t\t\t\t\tView view = findTargetView(nextStatus.getTarget(), viewMap);" + NL + "\t\t\t\t\taddMarker(diagramFile, view != null ? view : diagram, nextStatus.getTarget(), nextStatus.getMessage(), nextStatus.getSeverity());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate View findTargetView(EObject targetElement, Map viewMap) {" + NL + "\t\t\tif(targetElement instanceof View) {" + NL + "\t\t\t\treturn (View)targetElement;" + NL + "\t\t\t}\t\t" + NL + "\t\t\tfor(EObject container = targetElement; container != null; container = container.eContainer()) {" + NL + "\t\t\t\tif(viewMap.containsKey(container)) return (View)viewMap.get(container); " + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Map buildElement2ViewMap(Diagram diagram, Set targets) {" + NL + "\t\t\tHashMap map = new HashMap();" + NL + "\t\t\tgetElement2ViewMap(diagram, map, targets);" + NL + "\t\t\tif(!targets.isEmpty()) {" + NL + "\t\t\t\tSet path = new HashSet();" + NL + "\t\t\t\tfor (Iterator it = targets.iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tEObject nextNotMapped = (EObject) it.next();" + NL + "\t\t\t\t\tfor (EObject container = nextNotMapped.eContainer(); container != null; container = container.eContainer()) {" + NL + "\t\t\t\t\t\tif(!map.containsKey(container)) { " + NL + "\t\t\t\t\t\t\tpath.add(container);" + NL + "\t\t\t\t\t\t} else break;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgetElement2ViewMap(diagram, map, path);" + NL + "\t\t\t}" + NL + "\t\t\treturn map;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void getElement2ViewMap(View view, Map map, Set targets) {" + NL + "\t\t\tif (!map.containsKey(view.getElement()) && targets.remove(view.getElement())) {" + NL + "\t\t\t\tmap.put(view.getElement(), view);" + NL + "\t\t\t}" + NL + "\t\t\tfor (Iterator it = view.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t\tgetElement2ViewMap((View) it.next(), map, targets);" + NL + "\t\t\t}\t\t\t" + NL + "\t\t\tif (view instanceof Diagram) {" + NL + "\t\t\t\tfor (Iterator it = ((Diagram)view).getEdges().iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tgetElement2ViewMap((View) it.next(), map, targets);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void addMarker(IFile file, View view, EObject element, String message, int statusSeverity) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tIMarker marker = file.createMarker(MARKER_TYPE);" + NL + "\t\t\t\tmarker.setAttribute(IMarker.MESSAGE, message);" + NL + "\t\t\t\tmarker.setAttribute(IMarker.LOCATION, EMFCoreUtil.getQualifiedName(element, true));" + NL + "\t\t\t\tmarker.setAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, ViewUtil.getIdStr(view));" + NL + "\t\t\t\tint markerSeverity = IMarker.SEVERITY_INFO;" + NL + "\t\t\t\tif(statusSeverity == IStatus.WARNING) {" + NL + "\t\t\t\t\tmarkerSeverity = IMarker.SEVERITY_WARNING;    \t\t\t\t\t\t" + NL + "\t\t\t\t} else if(statusSeverity == IStatus.ERROR || statusSeverity == IStatus.CANCEL) {" + NL + "\t\t\t\t\tmarkerSeverity = IMarker.SEVERITY_ERROR;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tmarker.setAttribute(IMarker.SEVERITY, markerSeverity);\t\t\t\t" + NL + "\t\t\t} catch (CoreException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_14 = ".getInstance().logError(null, e);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate EObject getDiagnosticTarget(Diagnostic diagnostic) {" + NL + "\t\t\tif(!diagnostic.getData().isEmpty()) {" + NL + "\t\t\t\tObject target = diagnostic.getData().get(0);" + NL + "\t\t\t\treturn target instanceof EObject ? (EObject)target : null;" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate int diagnosticToStatusSeverity(int diagnosticSeverity) {" + NL + "\t\t\tif(diagnosticSeverity == Diagnostic.OK) {" + NL + "\t\t\t\treturn IStatus.OK;    \t\t\t\t\t\t" + NL + "\t\t\t} else if(diagnosticSeverity == Diagnostic.INFO) {" + NL + "\t\t\t\treturn IStatus.INFO;" + NL + "\t\t\t} else if(diagnosticSeverity == Diagnostic.WARNING) {" + NL + "\t\t\t\treturn IStatus.WARNING; " + NL + "\t\t\t} else if(diagnosticSeverity == Diagnostic.ERROR || diagnosticSeverity == Diagnostic.CANCEL) {" + NL + "\t\t\t\treturn IStatus.ERROR; " + NL + "\t\t\t}" + NL + "\t\t\treturn IStatus.INFO;" + NL + "\t\t}" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic boolean isInDefaultEditorContext(Object object) {" + NL + "\t\tEObject domainElement = null;" + NL + "\t\tif(object instanceof View) {" + NL + "\t\t\tView view = (View)object;" + NL + "\t\t\tdomainElement = view.getElement() != null ? view.getElement() : view.getDiagram().getElement();" + NL + "\t\t} else if(object instanceof EObject) {" + NL + "\t\t\tdomainElement = (EObject)object;" + NL + "\t\t} else {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tEPackage domainPackage = domainElement.eClass().getEPackage();\t\t\t\t" + NL + "\t\treturn ";
  protected final String TEXT_15 = "domainPackage == ";
  protected final String TEXT_16 = ".eINSTANCE";
  protected final String TEXT_17 = "\t\t\t\t\t\t\t\t\t ";
  protected final String TEXT_18 = "\t\t\t" + NL + "\t}\t";
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tpublic static class ";
  protected final String TEXT_20 = " implements ";
  protected final String TEXT_21 = " {";
  protected final String TEXT_22 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {\t\t" + NL + "\t\t\tif(isInDefaultEditorContext(object) && object instanceof View) {" + NL + "\t\t\t\tString id = ((View) object).getType();" + NL + "\t\t\t\treturn id != null && semanticCtxIdMap.get(id) == ";
  protected final String TEXT_23 = ".class;" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_24 = NL + "\t\t/**" + NL + "\t\t* @generated" + NL + "\t\t*/" + NL + "\t\tpublic boolean selects(Object object) {" + NL + "\t\t\treturn isInDefaultEditorContext(object);\t" + NL + "\t\t}\t" + NL + "\t}\t\t";
  protected final String TEXT_25 = NL + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic final Map semanticCtxIdMap = new HashMap();" + NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic {";
  protected final String TEXT_26 = NL + "\t\tsemanticCtxIdMap.put(\"";
  protected final String TEXT_27 = "\", ";
  protected final String TEXT_28 = ".class); //$NON-NLS-1$";
  protected final String TEXT_29 = NL + "\t}";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "\t/**" + NL + "\t* @generated" + NL + "\t*/" + NL + "\tstatic ";
  protected final String TEXT_32 = " getNotationTraversalStrategy(IBatchValidator validator) {";
  protected final String TEXT_33 = "\t" + NL + "\t\treturn new CtxSwitchStrategy(validator);";
  protected final String TEXT_34 = "\t\t\t" + NL + "\t\treturn validator.getDefaultTraversalStrategy();";
  protected final String TEXT_35 = NL + "\t}";
  protected final String TEXT_36 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class CtxSwitchStrategy implements ";
  protected final String TEXT_37 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_38 = " defaultStrategy;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate String currentSemanticCtxId;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate boolean ctxChanged = true;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject currentTarget;\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate EObject preFetchedNextTarget;\t\t" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tCtxSwitchStrategy(IBatchValidator validator) {" + NL + "\t\t\tthis.defaultStrategy = validator.getDefaultTraversalStrategy();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void elementValidated(EObject element, IStatus status) {" + NL + "\t\t\tdefaultStrategy.elementValidated(element, status);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasNext() {" + NL + "\t\t\treturn defaultStrategy.hasNext();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isClientContextChanged() {" + NL + "\t\t\tif(preFetchedNextTarget == null) {" + NL + "\t\t\t\tpreFetchedNextTarget = next();" + NL + "\t\t\t\tprepareNextClientContext(preFetchedNextTarget);\t\t\t\t" + NL + "\t\t\t}\t\t\t  \t\t\t" + NL + "\t\t\treturn ctxChanged;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic EObject next() {" + NL + "\t\t\tEObject nextTarget = preFetchedNextTarget;" + NL + "\t\t\tif(nextTarget == null) {" + NL + "\t\t\t\tnextTarget = defaultStrategy.next();" + NL + "\t\t\t}" + NL + "\t\t\tthis.preFetchedNextTarget = null;" + NL + "\t\t\treturn this.currentTarget = nextTarget;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void startTraversal(";
  protected final String TEXT_39 = " traversalRoots," + NL + "\t\t\t\t";
  protected final String TEXT_40 = " monitor) {" + NL + "\t\t\tdefaultStrategy.startTraversal(traversalRoots, monitor);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate void prepareNextClientContext(EObject nextTarget) { " + NL + "\t\t\tif (nextTarget != null && currentTarget != null) {" + NL + "\t\t\t\tif (nextTarget instanceof View) {" + NL + "\t\t\t\t\tString id = ((View) nextTarget).getType();" + NL + "\t\t\t\t\tString nextSemanticId = id != null" + NL + "\t\t\t\t\t\t\t&& semanticCtxIdMap.containsKey(id) ? id : null;" + NL + "\t\t\t\t\tif ((currentSemanticCtxId != null && !currentSemanticCtxId" + NL + "\t\t\t\t\t\t\t.equals(nextSemanticId))" + NL + "\t\t\t\t\t\t\t|| (nextSemanticId != null && !nextSemanticId" + NL + "\t\t\t\t\t\t\t\t\t.equals(currentSemanticCtxId))) {" + NL + "\t\t\t\t\t\tthis.ctxChanged = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tcurrentSemanticCtxId = nextSemanticId;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t// context of domain model" + NL + "\t\t\t\t\tthis.ctxChanged = currentSemanticCtxId != null;" + NL + "\t\t\t\t\tcurrentSemanticCtxId = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthis.ctxChanged = false;" + NL + "\t\t\t}" + NL + "\t\t}\t\t" + NL + "\t}// CtxSwitchStrategy";
  protected final String TEXT_41 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_42 = " extends ";
  protected final String TEXT_43 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_44 = " expression = ";
  protected final String TEXT_45 = "null";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = "(\"";
  protected final String TEXT_48 = "\", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ")";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "(\"";
  protected final String TEXT_53 = "\", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_54 = ")";
  protected final String TEXT_55 = "new ";
  protected final String TEXT_56 = "(";
  protected final String TEXT_57 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_58 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_59 = " self = (";
  protected final String TEXT_60 = ")context;";
  protected final String TEXT_61 = "\t" + NL + "\t\t";
  protected final String TEXT_62 = " ";
  protected final String TEXT_63 = " = (";
  protected final String TEXT_64 = ")env.get(\"";
  protected final String TEXT_65 = "\"); //$NON-NLS-1$";
  protected final String TEXT_66 = NL + "\t\treturn ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = "(self";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_71 = NL + ";" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic IStatus validate(";
  protected final String TEXT_72 = " ctx) {" + NL + "\t\t\tObject result = expression.evaluate(ctx.getTarget());" + NL + "\t\t\tif(result instanceof Boolean && ((Boolean)result).booleanValue()) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_73 = ".OK_STATUS;" + NL + "\t\t\t}" + NL + "\t\t\treturn ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) }); " + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_74 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "static class ";
  protected final String TEXT_75 = " {";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = "(";
  protected final String TEXT_80 = " self";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = " ";
  protected final String TEXT_83 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new UnsupportedOperationException(\"No user implementation provided in '";
  protected final String TEXT_84 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_85 = NL + "} //";
  protected final String TEXT_86 = NL + "} //";
  protected final String TEXT_87 = NL;

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
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_5);
    
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
importManager.addImport("java.util.HashMap");
importManager.addImport("java.util.HashSet");
importManager.addImport("java.util.Iterator");
importManager.addImport("java.util.List");
importManager.addImport("java.util.ArrayList");
importManager.addImport("java.util.Arrays");
importManager.addImport("java.util.Map");
importManager.addImport("java.util.Set");
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.resources.IMarker");
importManager.addImport("org.eclipse.core.resources.IResource");
importManager.addImport("org.eclipse.core.runtime.CoreException");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.emf.common.util.Diagnostic");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.EPackage");
importManager.addImport("org.eclipse.emf.ecore.util.Diagnostician");
importManager.addImport("org.eclipse.emf.validation.model.EvaluationMode");
importManager.addImport("org.eclipse.emf.validation.model.IConstraintStatus");
importManager.addImport("org.eclipse.emf.validation.service.IBatchValidator");
importManager.addImport("org.eclipse.emf.validation.service.ModelValidationService");
importManager.addImport("org.eclipse.emf.workspace.util.WorkspaceSynchronizer");
importManager.addImport("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor");
importManager.addImport("org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.jface.action.Action");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_11);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_12);
    } // end of diagram element validation 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_14);
    
for(java.util.Iterator packageIt = genDiagram.getEditorGen().getDomainGenModel().getGenPackages().iterator(); packageIt.hasNext();) {
	GenPackage nextGenPackage = (GenPackage)packageIt.next();			
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(nextGenPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(packageIt.hasNext() ? " || " : ";");
    stringBuffer.append(TEXT_17);
    
} // domainPackage iteration 

    stringBuffer.append(TEXT_18);
    
boolean usesNotationContextSwitch = false;
java.util.Map ctx2Rules = (audits != null) ? audits.getAllRulesToTargetContextMap() : new java.util.HashMap();
java.util.List allAudits = (audits != null) ? audits.getAllAuditRules() : java.util.Collections.EMPTY_LIST;
java.util.Map viewID2SelectorMap = new java.util.HashMap();
for(java.util.Iterator it = allAudits.iterator(); it.hasNext();) {
	GenAuditRule audit = (GenAuditRule)it.next();
	String contextID = (audit.getTarget() != null) ? audit.getTarget().getClientContextID() : null;
	if(contextID == null || null == ctx2Rules.remove(contextID)) continue;
	String selectorClassName = audit.getContextSelectorLocalClassName();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.model.IClientSelector"));
    stringBuffer.append(TEXT_21);
    
	if(audit.getTarget() instanceof GenDiagramElementTarget) {
		usesNotationContextSwitch = true;
		GenDiagramElementTarget	diagramElement = (GenDiagramElementTarget)audit.getTarget();
		String viewID = Integer.toString(diagramElement.getElement().getVisualID());
		viewID2SelectorMap.put(viewID, selectorClassName);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(selectorClassName);
    stringBuffer.append(TEXT_23);
    	} else {
    stringBuffer.append(TEXT_24);
    
	} 
} // end of audits iteration
		
if(usesNotationContextSwitch) {

    stringBuffer.append(TEXT_25);
    
	for(java.util.Iterator it = viewID2SelectorMap.keySet().iterator(); it.hasNext();) {
		String viewID = (String)it.next();

    stringBuffer.append(TEXT_26);
    stringBuffer.append(viewID);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(viewID2SelectorMap.get(viewID));
    stringBuffer.append(TEXT_28);
    	} // end of view ID iteration 
    stringBuffer.append(TEXT_29);
    
} // end of context map generation //usesNotationContextSwitch 

    stringBuffer.append(TEXT_30);
    if(hasNotationModelAudit) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_32);
    	if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    	} // end of usesNotationContextSwitch 
    stringBuffer.append(TEXT_35);
    } // end of hasNotationModelAudit			

if(usesNotationContextSwitch) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.service.ITraversalStrategy"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IProgressMonitor"));
    stringBuffer.append(TEXT_40);
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

    stringBuffer.append(TEXT_41);
    stringBuffer.append(nextAudit.getConstraintAdapterLocalClassName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.AbstractModelConstraint"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importedExpressionBase);
    stringBuffer.append(TEXT_44);
    
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

    stringBuffer.append(TEXT_45);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(__genValueExpression.getBody());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_50);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(__genValueExpression.getBody());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_54);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = (__genExprContext instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClass) ?((org.eclipse.emf.codegen.ecore.genmodel.GenClass)__genExprContext).getQualifiedInterfaceName() : __genExprContext.getEcoreClassifier().getInstanceClassName();
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_55);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_60);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = (nextVariableType instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClass) ? ((org.eclipse.emf.codegen.ecore.genmodel.GenClass)nextVariableType).getQualifiedInterfaceName() : nextVariableType.getEcoreClassifier().getInstanceClassName();

    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_65);
    		} 
    stringBuffer.append(TEXT_66);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_67);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_68);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_69);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_70);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.validation.IValidationContext"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.Status"));
    stringBuffer.append(TEXT_73);
    
	}
} /*end of Adapters iteration*/

final java.util.List javaExpressions = (audits != null) ? audits.getAllJavaLangAudits() : java.util.Collections.EMPTY_LIST;
if(!javaExpressions.isEmpty()) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_75);
    
	for (java.util.Iterator it = javaExpressions.iterator(); it.hasNext();) {
		GenAuditRule nextJavaRule = (GenAuditRule) it.next();
		GenClassifier __genExprContext = nextJavaRule.getTarget().getContext();		
		ValueExpression __genValueExpression = nextJavaRule.getRule();
		String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_76);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String evalCtxQualifiedName = (__genExprContext instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClass) ? ((org.eclipse.emf.codegen.ecore.genmodel.GenClass)__genExprContext).getQualifiedInterfaceName() : __genExprContext.getEcoreClassifier().getInstanceClassName();
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClass) 
		__exprResultTypeQualifiedName = ((org.eclipse.emf.codegen.ecore.genmodel.GenClass)__genExprResultTypeObj).getQualifiedInterfaceName();
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = ((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj).getEcoreClassifier().getInstanceClassName();
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
		String qualifiedTypeName = (nextVariableType instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClass) ? ((org.eclipse.emf.codegen.ecore.genmodel.GenClass)nextVariableType).getQualifiedInterfaceName() : nextVariableType.getEcoreClassifier().getInstanceClassName();

	
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_83);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_84);
    
}

    
	}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(__javaOperationContainer);
    
} /* end of Java expression methods */

    stringBuffer.append(TEXT_86);
    stringBuffer.append(genDiagram.getValidationProviderClassName());
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_87);
    return stringBuffer.toString();
  }
}
