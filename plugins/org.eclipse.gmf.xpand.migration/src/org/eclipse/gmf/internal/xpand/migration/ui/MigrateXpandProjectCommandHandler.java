package org.eclipse.gmf.internal.xpand.migration.ui;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.migration.MigrationException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MigrateXpandProjectCommandHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object applicationContext = event.getApplicationContext();
		IProject singleProject = getSingleProject(applicationContext);
		Shell shell = getShell(applicationContext);
		try {
			new ProgressMonitorDialog(shell).run(true, true, new MigrateXpandProject(singleProject));
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			if (cause instanceof XpandResourceMigrationException) {
				reportMigrationException((XpandResourceMigrationException) cause, shell);
			} else if (cause instanceof UnsupportedEncodingException) {
				showError("Unsupported encoding", "Specified encoding \"" + MigrationVisitor.CHARSET + "\" is not supported by the platform: " + cause.getMessage(), shell);
			} else if (cause != null) {
				String message = cause.getMessage();
				if (message == null || message.length() == 0) {
					final CharArrayWriter writer = new CharArrayWriter();
					final int[] lineCounter = new int[] { 0 };
					final String[] messageContainer = new String[] { null };
					cause.printStackTrace(new PrintWriter(writer) {

						public void println() {
							lineCounter[0] = lineCounter[0] + 1;
							if (lineCounter[0] == 6) {
								messageContainer[0] = new String(writer.toCharArray());
							}
							super.println();
						};
					});
					writer.close();
					message = messageContainer[0] == null ? new String(writer.toCharArray()) : messageContainer[0];
				}
				showError("Exception", message, shell);
			} else {
				showError("Invocation target exception", e.getMessage(), shell);
			}
		} catch (InterruptedException e) {
			// Cancel pressed
		}
		return null;
	}

	@Override
	public void setEnabled(Object contextObject) {
		setBaseEnabled(getSingleProject(contextObject) != null);
	}

	private IProject getSingleProject(Object contextObject) {
		if (contextObject instanceof EvaluationContext) {
			EvaluationContext evaluationContext = (EvaluationContext) contextObject;
			Object defaultVariable = evaluationContext.getDefaultVariable();
			if (defaultVariable instanceof Collection<?>) {
				Collection<?> selection = (Collection<?>) defaultVariable;
				if (selection.size() == 1) {
					Object selectedObject = selection.iterator().next();
					if (selectedObject instanceof IJavaProject) {
						return ((IJavaProject) selectedObject).getProject();
					} else if (selectedObject instanceof IProject) {
						return (IProject) selectedObject;
					}
				}
			}
		}
		return null;
	}

	private Shell getShell(Object contextObject) {
		if (contextObject instanceof EvaluationContext) {
			EvaluationContext evaluationContext = (EvaluationContext) contextObject;
			Object activeShell = evaluationContext.getVariable("activeWorkbenchWindowShell");
			if (activeShell instanceof Shell) {
				return (Shell) activeShell;
			}
		}
		return Display.getCurrent().getActiveShell();
	}

	private void reportMigrationException(XpandResourceMigrationException ex, Shell shell) {
		MigrationException migrationException = ex.getMigrationException();
		StringBuilder sb = new StringBuilder(ex.getTemplateFile().getProjectRelativePath().toString());
		sb.append(" migration error\n");
		switch (migrationException.getType()) {
		case ANALYZATION_PROBLEMS:
			sb.append("Following analyzation problems present:\n\n");
			for (AnalysationIssue issue : migrationException.getIssues()) {
				sb.append(issue.toString());
				sb.append("\n");
			}
			showError("Unable to load xtend resource", sb.toString(), shell);
			return;
		default:
			showError("Migration exception", sb.append(migrationException.getMessage()).toString(), shell);
		}
	}

	private void showError(String title, String contents, Shell shell) {
		MessageDialog.openError(shell, title, contents);
	}

}
