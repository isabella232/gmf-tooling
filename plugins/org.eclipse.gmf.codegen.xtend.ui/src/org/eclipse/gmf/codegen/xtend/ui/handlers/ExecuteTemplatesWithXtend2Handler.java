package org.eclipse.gmf.codegen.xtend.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.jface.viewers.TreeSelection;


public class ExecuteTemplatesWithXtend2Handler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ExecuteTemplatesOperationWithXtend2 op = createOperation(event);
		op.run();
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	private ExecuteTemplatesOperationWithXtend2 createOperation(ExecutionEvent event) throws ExecutionException {
		ExecuteTemplatesOperationWithXtend2 op = new ExecuteTemplatesOperationWithXtend2();
		try{
			op.setName(event.getCommand().getName());
		} catch(NotDefinedException e) {
			throw new RuntimeException("Undefined command",e);
		}
		org.eclipse.ui.IEditorPart diagramEditor = org.eclipse.ui.handlers.HandlerUtil.getActiveEditorChecked(event);
		org.eclipse.swt.widgets.Shell shell = diagramEditor.getEditorSite().getShell();
		op.setShell(shell);
		if (org.eclipse.ui.handlers.HandlerUtil.getCurrentSelectionChecked(event) instanceof TreeSelection) {
			TreeSelection selection = (TreeSelection)org.eclipse.ui.handlers.HandlerUtil.getCurrentSelectionChecked(event);
			if (selection.size() == 1) {
				if (selection.getFirstElement() instanceof GenEditorGenerator) {
					op.setGenModelURI(((XMIResource)selection.getPaths()[0].getFirstSegment()).getURI());
				} else {
					op.setGenModelURI(URI.createPlatformPluginURI(((IFile)selection.getFirstElement()).getFullPath().toString(), true));
				}
			} else {
				throw new ExecutionException("Size of selection more than one.");
			}
		}
		return op;
	}
}
	
