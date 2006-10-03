package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ApplicationGenerator
{
  protected static String nl;
  public static synchronized ApplicationGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ApplicationGenerator result = new ApplicationGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.lang.reflect.InvocationTargetException;" + NL + "" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.resources.IWorkspaceRunnable;" + NL + "import org.eclipse.core.resources.ResourcesPlugin;" + NL + "import org.eclipse.core.runtime.CoreException;" + NL + "import org.eclipse.core.runtime.IPlatformRunnable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.OperationCanceledException;" + NL + "import org.eclipse.core.runtime.Platform;" + NL + "import org.eclipse.core.runtime.jobs.ISchedulingRule;" + NL + "import org.eclipse.core.runtime.jobs.Job;" + NL + "import org.eclipse.jface.operation.IRunnableWithProgress;" + NL + "import org.eclipse.jface.operation.IThreadListener;" + NL + "import org.eclipse.swt.widgets.Display;" + NL + "import org.eclipse.ui.PlatformUI;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements IPlatformRunnable {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object run(Object args) throws Exception {" + NL + "\t\tDisplay display = PlatformUI.createDisplay();" + NL + "\t\ttry {" + NL + "\t\t\tint returnCode = PlatformUI.createAndRunWorkbench(display," + NL + "\t\t\t\t\tnew ";
  protected final String TEXT_7 = "());" + NL + "\t\t\tif (returnCode == PlatformUI.RETURN_RESTART) {" + NL + "\t\t\t\treturn IPlatformRunnable.EXIT_RESTART;" + NL + "\t\t\t}" + NL + "\t\t\treturn IPlatformRunnable.EXIT_OK;" + NL + "\t\t} finally {" + NL + "\t\t\tdisplay.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic abstract class WorkspaceModifyOperation implements IRunnableWithProgress, IThreadListener {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ISchedulingRule rule;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected WorkspaceModifyOperation() {" + NL + "\t\t\tthis(ResourcesPlugin.getWorkspace().getRoot());" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected WorkspaceModifyOperation(ISchedulingRule rule) {" + NL + "\t\t\tthis.rule = rule;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected abstract void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic synchronized final void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {" + NL + "\t\t\tfinal InvocationTargetException[] iteHolder = new InvocationTargetException[1];" + NL + "\t\t\ttry {" + NL + "\t\t\t\tIWorkspaceRunnable workspaceRunnable = new IWorkspaceRunnable() {" + NL + "" + NL + "\t\t\t\t\tpublic void run(IProgressMonitor pm) throws CoreException {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\texecute(pm);" + NL + "\t\t\t\t\t\t} catch (InvocationTargetException e) {" + NL + "\t\t\t\t\t\t\t// Pass it outside the workspace runnable" + NL + "\t\t\t\t\t\t\titeHolder[0] = e;" + NL + "\t\t\t\t\t\t} catch (InterruptedException e) {" + NL + "\t\t\t\t\t\t\t// Re-throw as OperationCanceledException, which will be" + NL + "\t\t\t\t\t\t\t// caught and re-thrown as InterruptedException below." + NL + "\t\t\t\t\t\t\tthrow new OperationCanceledException(e.getMessage());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t// CoreException and OperationCanceledException are propagated" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tResourcesPlugin.getWorkspace().run(workspaceRunnable, rule, IResource.NONE, monitor);" + NL + "\t\t\t} catch (CoreException e) {" + NL + "\t\t\t\tthrow new InvocationTargetException(e);" + NL + "\t\t\t} catch (OperationCanceledException e) {" + NL + "\t\t\t\tthrow new InterruptedException(e.getMessage());" + NL + "\t\t\t}" + NL + "\t\t\t// Re-throw the InvocationTargetException, if any occurred" + NL + "\t\t\tif (iteHolder[0] != null) {" + NL + "\t\t\t\tthrow iteHolder[0];" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void threadChange(Thread thread) {" + NL + "\t\t\t//we must make sure we aren't transferring control away from a thread that" + NL + "\t\t\t//already owns a scheduling rule because this is deadlock prone (bug 105491)" + NL + "\t\t\tif (rule == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tJob currentJob = Platform.getJobManager().currentJob();" + NL + "\t\t\tif (currentJob == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tISchedulingRule currentRule = currentJob.getRule();" + NL + "\t\t\tif (currentRule == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tthrow new IllegalStateException(\"Cannot fork a thread from a thread owning a rule\"); //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenApplication application = (GenApplication) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    {
	GenDiagram genDiagram = application.getEditorGen().getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(application.getApplicationClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(application.getWorkbenchAdvisorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
