package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class WrappingCommandGenerator
{
  protected static String nl;
  public static synchronized WrappingCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    WrappingCommandGenerator result = new WrappingCommandGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * Wraps a EMF command into a GEF command. The undelying EMF command will be executed within a transaction provided by the specified editing domain." + NL + " * @generated" + NL + " */" + NL + "public class WrappingCommand extends Command {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final IUndoableOperation operation;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected WrappingCommand(IUndoableOperation operation) {" + NL + "\t\tthis.operation = operation;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic WrappingCommand(TransactionalEditingDomain editingDomain, org.eclipse.emf.common.command.Command emfCommand) {" + NL + "\t\tthis.operation = new EMFCommandOperation(editingDomain, emfCommand);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void execute() {" + NL + "\t\ttry {" + NL + "\t\t\toperation.execute(new NullProgressMonitor(), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_2 = ".getInstance().logError(\"exception occurred while executing operation\", e);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canExecute() {" + NL + "\t\treturn operation.canExecute();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void undo() {" + NL + "\t\ttry {" + NL + "\t\t\toperation.undo(new NullProgressMonitor(), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_3 = ".getInstance().logError(\"exception occurred while undoing operation\", e);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canUndo() {" + NL + "\t\treturn operation.canUndo();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void redo() {" + NL + "\t\ttry {" + NL + "\t\t\toperation.redo(new NullProgressMonitor(), null);" + NL + "\t\t} catch (ExecutionException e) {" + NL + "\t\t\t";
  protected final String TEXT_4 = ".getInstance().logError(\"exception occurred while redoing operation\", e);" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenPlugin genPlugin = genDiagram.getEditorGen().getPlugin();

    
importManager.emitPackageStatement(stringBuffer);
importManager.addImport("org.eclipse.core.commands.ExecutionException");
importManager.addImport("org.eclipse.core.commands.operations.IUndoableOperation");
importManager.addImport("org.eclipse.core.runtime.NullProgressMonitor");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.emf.workspace.EMFCommandOperation");
importManager.addImport("org.eclipse.gef.commands.Command");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(importManager.getImportedName(genPlugin.getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getImportedName(genPlugin.getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName(genPlugin.getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_4);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
