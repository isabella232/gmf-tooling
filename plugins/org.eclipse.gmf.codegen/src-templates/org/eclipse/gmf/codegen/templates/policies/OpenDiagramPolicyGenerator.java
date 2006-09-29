package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class OpenDiagramPolicyGenerator
{
  protected static String nl;
  public static synchronized OpenDiagramPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    OpenDiagramPolicyGenerator result = new OpenDiagramPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getOpenCommand(Request request) {" + NL + "\t\tEditPart targetEditPart = getTargetEditPart(request);" + NL + "\t\tif (false == targetEditPart.getModel() instanceof View) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tEAnnotation ann = ((View) targetEditPart.getModel()).getEAnnotation(\"uri://eclipse.org/gmf/openDiagramPolicy\");" + NL + "\t\tif (ann == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tif (!ann.getDetails().containsKey(\"editorID\") || !ann.getDetails().containsKey(\"diagramKind\")) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn new ICommandProxy(new OpenDiagramCommand(ann));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class OpenDiagramCommand extends AbstractTransactionalCommand {" + NL + "\t\tprivate final EAnnotation diagramFacet;" + NL + "" + NL + "\t\tOpenDiagramCommand(EAnnotation annotation) {" + NL + "\t\t\t// editing domain is taken for original diagram, " + NL + "\t\t\t// if we open diagram from another file, we should use another editing domain" + NL + "\t\t\tsuper(TransactionUtil.getEditingDomain(annotation), \"Open diagram\", null);" + NL + "\t\t\tdiagramFacet = annotation;" + NL + "\t\t}" + NL + "" + NL + "\t\t// FIXME canExecute if  !(readOnly && getDiagramToOpen == null), i.e. open works on ro diagrams only when there's associated diagram already" + NL + "" + NL + "\t\tprotected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tDiagram diagram = getDiagramToOpen();" + NL + "\t\t\t\tif (diagram == null) {" + NL + "\t\t\t\t\tdiagram = intializeNewDiagram();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfinal DiagramEditorInput editorInput = new DiagramEditorInput(diagram);" + NL + "\t\t\t\tIWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();" + NL + "\t\t\t\tpage.openEditor(editorInput, getEditorID());" + NL + "\t\t\t\treturn CommandResult.newOKCommandResult();" + NL + "\t\t\t} catch (Exception ex) {" + NL + "\t\t\t\tthrow new ExecutionException(\"Can't open diagram\", ex);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected Diagram getDiagramToOpen() {" + NL + "\t\t\t// take first" + NL + "\t\t\tfor (Iterator it = diagramFacet.getReferences().iterator(); it.hasNext();) {" + NL + "\t\t\t\tObject next = it.next();" + NL + "\t\t\t\tif (next instanceof Diagram) {" + NL + "\t\t\t\t\treturn (Diagram) next;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected Diagram intializeNewDiagram() throws ExecutionException {" + NL + "\t\t\tDiagram d = ViewService.createDiagram(getDiagramDomainElement(), getDiagramKind(), getPreferencesHint());" + NL + "\t\t\tif (d == null) {" + NL + "\t\t\t\tthrow new ExecutionException(\"Can't create diagram of '\" + getDiagramKind() + \"' kind\");" + NL + "\t\t\t}" + NL + "\t\t\tdiagramFacet.getEReferences().add(d);" + NL + "\t\t\tassert diagramFacet.eResource() != null;" + NL + "\t\t\tdiagramFacet.eResource().getContents().add(d);" + NL + "\t\t\treturn d;" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected EObject getDiagramDomainElement() {" + NL + "\t\t\t// use same element as associated with EP" + NL + "\t\t\treturn ((View) diagramFacet.getEModelElement()).getElement();" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected PreferencesHint getPreferencesHint() {" + NL + "\t\t\t// XXX prefhint from target diagram's editor?" + NL + "\t\t\treturn ";
  protected final String TEXT_7 = ".DIAGRAM_PREFERENCES_HINT;" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected String getDiagramKind() {" + NL + "\t\t\treturn (String) diagramFacet.getDetails().get(\"diagramKind\");" + NL + "\t\t}" + NL + "" + NL + "\t\tprotected String getEditorID() {" + NL + "\t\t\treturn (String) diagramFacet.getDetails().get(\"editorID\");" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final OpenDiagramBehaviour behaviour = (OpenDiagramBehaviour) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = behaviour.getSubject().getDiagram();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    
importManager.addImport("java.util.Iterator");
importManager.addImport("org.eclipse.core.commands.ExecutionException");
importManager.addImport("org.eclipse.core.runtime.IAdaptable");
importManager.addImport("org.eclipse.core.runtime.IProgressMonitor");
importManager.addImport("org.eclipse.emf.ecore.EAnnotation");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.Request");
importManager.addImport("org.eclipse.gef.commands.Command");
importManager.addImport("org.eclipse.emf.transaction.util.TransactionUtil");
importManager.addImport("org.eclipse.gmf.runtime.common.core.command.CommandResult");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.services.ViewService");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput");
importManager.addImport("org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.ui.IWorkbenchPage");
importManager.addImport("org.eclipse.ui.PlatformUI");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
