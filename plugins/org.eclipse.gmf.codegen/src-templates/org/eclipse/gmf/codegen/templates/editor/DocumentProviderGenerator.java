package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DocumentProviderGenerator
{
  protected static String nl;
  public static synchronized DocumentProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DocumentProviderGenerator result = new DocumentProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.io.IOException;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Collection;" + NL + "import java.util.Collections;" + NL + "import java.util.Iterator;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.runtime.CoreException;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.SubProgressMonitor;" + NL + "import org.eclipse.core.runtime.jobs.ISchedulingRule;" + NL + "import org.eclipse.core.runtime.jobs.MultiRule;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.transaction.DemultiplexingListener;" + NL + "import org.eclipse.emf.transaction.NotificationFilter;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramModificationListener;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramDocumentProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramModificationListener;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.ui.IFileEditorInput;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends FileDiagramDocumentProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void saveDocumentToFile(IDocument document, IFile file, boolean overwrite, IProgressMonitor monitor) throws CoreException {" + NL + "\t\tDiagram diagram = (Diagram)document.getContent();" + NL + "\t\tResource diagramResource = diagram.eResource();" + NL + "\t\tIDiagramDocument diagramDocument = (IDiagramDocument)document;" + NL + "\t\tTransactionalEditingDomain domain = diagramDocument.getEditingDomain();" + NL + "\t\tList resources = domain.getResourceSet().getResources();" + NL + "" + NL + "\t\tmonitor.beginTask(\"Saving diagram\", resources.size() + 1); //$NON-NLS-1$" + NL + "\t\tsuper.saveDocumentToFile(document, file, overwrite, new SubProgressMonitor(monitor, 1));" + NL + "\t\tfor (Iterator it = resources.iterator(); it.hasNext();) {" + NL + "\t\t\tResource nextResource = (Resource) it.next();" + NL + "\t\t\tmonitor.setTaskName(\"Saving \" + nextResource.getURI()); //$NON-NLS-1$" + NL + "\t\t\tif (nextResource != diagramResource) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tnextResource.save(Collections.EMPTY_MAP);" + NL + "\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_7 = ".getInstance().logError(\"Unable to save resource: \" + nextResource.getURI(), e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tmonitor.worked(1);" + NL + "\t\t}" + NL + "\t\tmonitor.done();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ISchedulingRule getSaveRule(Object element) {" + NL + "\t\tIDiagramDocument diagramDocument = getDiagramDocument(element);" + NL + "\t\tif (diagramDocument != null) {" + NL + "\t\t\tDiagram diagram = diagramDocument.getDiagram();" + NL + "\t\t\tif (diagram != null) {" + NL + "\t\t\t\tCollection rules = new ArrayList();" + NL + "\t\t\t\tfor (Iterator it = diagramDocument.getEditingDomain().getResourceSet().getResources().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t\tIFile nextFile = WorkspaceSynchronizer.getFile((Resource) it.next());" + NL + "\t\t\t\t\tif (nextFile != null) {" + NL + "\t\t\t\t\t\trules.add(computeSaveSchedulingRule(nextFile));\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn new MultiRule((ISchedulingRule[]) rules.toArray(new ISchedulingRule[rules.size()]));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn super.getSaveRule(element);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected FileInfo createFileInfo(IDocument document, FileSynchronizer synchronizer, IFileEditorInput input) {" + NL + "\t\tassert document instanceof DiagramDocument;" + NL + "" + NL + "\t\tDiagramModificationListener diagramListener = new CustomModificationListener(this, (DiagramDocument) document, input);" + NL + "\t\tDiagramFileInfo info = new DiagramFileInfo(document, synchronizer, diagramListener);" + NL + "" + NL + "\t\tdiagramListener.startListening();" + NL + "\t\treturn info;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ISchedulingRule computeSaveSchedulingRule(IResource toCreateOrModify) {" + NL + "\t\tif (toCreateOrModify.exists() && toCreateOrModify.isSynchronized(IResource.DEPTH_ZERO))" + NL + "\t\t\treturn fResourceRuleFactory.modifyRule(toCreateOrModify);" + NL + "" + NL + "\t\tIResource parent= toCreateOrModify;" + NL + "\t\tdo {" + NL + "\t\t\t /*" + NL + "\t\t\t * XXX This is a workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=67601" + NL + "\t\t\t * IResourceRuleFactory.createRule should iterate the hierarchy itself." + NL + "\t\t\t */" + NL + "\t\t\ttoCreateOrModify= parent;" + NL + "\t\t\tparent= toCreateOrModify.getParent();" + NL + "\t\t} while (parent != null && !parent.exists() && !parent.isSynchronized(IResource.DEPTH_ZERO));" + NL + "" + NL + "\t\treturn fResourceRuleFactory.createRule(toCreateOrModify);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class CustomModificationListener extends FileDiagramModificationListener {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate DemultiplexingListener myListener = null;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t \tpublic CustomModificationListener(";
  protected final String TEXT_8 = " documentProviderParameter, DiagramDocument documentParameter, IFileEditorInput inputParameter) {" + NL + "\t\t\tsuper(documentProviderParameter, documentParameter, inputParameter);" + NL + "\t \t\tfinal DiagramDocument document = documentParameter;" + NL + "\t\t\tNotificationFilter diagramResourceModifiedFilter = NotificationFilter.createEventTypeFilter(Notification.SET);" + NL + "\t\t\tmyListener = new DemultiplexingListener(diagramResourceModifiedFilter) {" + NL + "\t\t\t\tprotected void handleNotification(TransactionalEditingDomain domain, Notification notification) {" + NL + "\t\t\t\t\tif (notification.getNotifier() instanceof EObject) {" + NL + "\t\t\t\t\t\tResource modifiedResource = ((EObject) notification.getNotifier()).eResource();" + NL + "\t\t\t\t\t\tif (modifiedResource != document.getDiagram().eResource()) {" + NL + "\t\t\t\t\t\t\tdocument.setContent(document.getContent());\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void startListening() {" + NL + "\t\t\tsuper.startListening();" + NL + "\t\t\tgetEditingDomain().addResourceSetListener(myListener);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void stopListening() {" + NL + "\t\t\tgetEditingDomain().removeResourceSetListener(myListener);" + NL + "\t\t\tsuper.stopListening();" + NL + "\t\t}" + NL + "" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

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
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getDocumentProviderClassName());
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
